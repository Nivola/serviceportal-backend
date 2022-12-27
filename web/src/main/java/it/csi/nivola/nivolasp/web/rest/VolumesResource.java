/*-
 * ========================LICENSE_START=================================
 * Nivola Web
 * %%
 * Copyright (C) 2022 CSI Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | CSI Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.web.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.csi.nivola.nivolasp.aop.logging.AzioneDispositiva;
import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.integration.rest.api.service.ComputeserviceApi;
import it.csi.nivola.nivolasp.integration.rest.model.service.AttachVolumeApiRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.AttachVolumeApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateVolumeApiRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateVolumeApiRequestSchemaVolume;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateVolumeApiRequestSchemaVolume.NvlHypervisorEnum;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateVolumeApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DeleteVolumeRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeDBInstanceTypesApiResponseSchemaDescribeDBInstanceTypesResponseInstanceTypesSet;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeInstancesApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeInstancesApiResponseSchemaDescribeInstancesResponseInstancesSet;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeVolumeTypesV20ApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeVolumesApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DetachVolumeApiRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DetachVolumeApiResponseSchema;
import it.csi.nivola.nivolasp.security.AuthoritiesConstants;
import it.csi.nivola.nivolasp.security.SecurityUtils;
import it.csi.nivola.nivolasp.service.dto.AttachDetachVolumeRisposta;
import it.csi.nivola.nivolasp.service.dto.ElencoTipiVolumeRisposta;
import it.csi.nivola.nivolasp.service.dto.EsitoDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoEnum;
import it.csi.nivola.nivolasp.service.dto.RichiestaAttachDetachVolume;
import it.csi.nivola.nivolasp.service.dto.RichiestaCreazioneVolume;
import it.csi.nivola.nivolasp.service.dto.RispostaElencoVolumiDTO;
import it.csi.nivola.nivolasp.service.dto.VolumeAttachmentDTO;
import it.csi.nivola.nivolasp.service.dto.VolumeDTO;
import it.csi.nivola.nivolasp.service.mapper.VolumeMapper;

/**
 * Rest controller per la gestione dei Volumi
 */
@RestController
@RequestMapping("/api")
public class VolumesResource {
	@Autowired
	ComputeserviceApi computeserviceApi;

	@Autowired
	VolumeMapper volumeMapper;

	private final Logger log = LoggerFactory.getLogger(VolumesResource.class);

	@GetMapping("/volume")
	@Secured({ AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR, AuthoritiesConstants.ACCOUNT_VIEWER })
	public ResponseEntity<RispostaElencoVolumiDTO> elencoVolumi(String accountId) throws BusinessException {
		log.debug(accountId);
		RispostaElencoVolumiDTO risultatoServizio = null;
		List<String> elencoAccountId = new ArrayList<String>(1);
		elencoAccountId.add(SecurityUtils.getAccountIdCorrente(accountId));

		DescribeVolumesApiResponseSchema rispostaElencoVolumi = computeserviceApi.v20NwsComputeservicesVolumeDescribevolumesGet(-1, // maxResults,
				null, // nextToken,
				elencoAccountId, // ownerIdN,
				null, // nvlNameN,
				null, // volumeIdN,
				null, // volumeIdN2,
				null, // volumeTypeN,
				null, // statusN,
				null, // tagKeyN,
				null, // createTimeN,
				null // attachmentN
		);
		
		if (rispostaElencoVolumi.getDescribeVolumesResponse().getNvlVolumeTotal() > 0 ) {
			risultatoServizio = volumeMapper.toRispostaElencoVolumi(rispostaElencoVolumi.getDescribeVolumesResponse());
			DescribeInstancesApiResponseSchema decodificaIstanze = computeserviceApi.v10NwsComputeservicesInstanceDescribeinstancesGet
					(-1, null, elencoAccountId, null, null, null, null, null, null, null, null, null, null, null);
			DescribeVolumeTypesV20ApiResponseSchema decodificaVolumeTypes = computeserviceApi.v20NwsComputeservicesVolumeDescribevolumetypesGet(SecurityUtils.getAccountIdCorrente(accountId), -1, null, null);
			
			risultatoServizio.getElencoVolumi().forEach(
					v -> 
					{v.getAttachmentSet().forEach(
							att -> {
								String nomeVmAtt = nomeVmAttachmentVolume(decodificaIstanze, att);
								att.setNomeIstanza(nomeVmAtt);
							}
					);
					v.setVolumeTypeDesc(recuperaVolumeTypeDesc(decodificaVolumeTypes, v));
					});
		}

		return new ResponseEntity<RispostaElencoVolumiDTO>(risultatoServizio, HttpStatus.OK);
	}

	private String recuperaVolumeTypeDesc(DescribeVolumeTypesV20ApiResponseSchema decodificaVolumeTypes, VolumeDTO v) {
		String volumeTypeDesc =  decodificaVolumeTypes.getDescribeVolumeTypesV20Response().getVolumeTypesSet().stream().filter(typ -> typ.getName().equals(v.getVolumeType())).findFirst().orElse(new DescribeDBInstanceTypesApiResponseSchemaDescribeDBInstanceTypesResponseInstanceTypesSet()).getDescription();
		if (volumeTypeDesc != null)
			return volumeTypeDesc.toLowerCase().replace("volume", "").replace("type", "");
		return "";
	}

	private String nomeVmAttachmentVolume(DescribeInstancesApiResponseSchema decodificaIstanze, VolumeAttachmentDTO att) {
		return decodificaIstanze.getDescribeInstancesResponse().getReservationSet().get(0).getInstancesSet().stream().filter(vm -> vm.getInstanceId().equals(att.getInstanceId())).findFirst().orElse(new DescribeInstancesApiResponseSchemaDescribeInstancesResponseInstancesSet()).getNvlName();
	}

	@GetMapping("/volume/types")
	@Secured({ AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR, AuthoritiesConstants.ACCOUNT_VIEWER })
	public ResponseEntity<ElencoTipiVolumeRisposta> elencoTipiVolumi(String accountId) throws BusinessException {
		accountId = SecurityUtils.getAccountIdCorrente(accountId);
		DescribeVolumeTypesV20ApiResponseSchema risposta = computeserviceApi.v20NwsComputeservicesVolumeDescribevolumetypesGet(accountId, -1, null, null);
		return new ResponseEntity<ElencoTipiVolumeRisposta>(volumeMapper.toRispostaTipiVolume(risposta.getDescribeVolumeTypesV20Response()), HttpStatus.OK);
	}

	/**
	 * Creazione del volume
	 * 
	 * @param richiesta
	 * @return
	 * @throws BusinessException
	 */
	@PostMapping("/volume")
	@Secured({ AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR })
	@AzioneDispositiva
	public ResponseEntity<VolumeDTO> creaVolume(@RequestBody RichiestaCreazioneVolume richiesta) throws BusinessException {
		String accountId = SecurityUtils.getAccountIdCorrente(richiesta.getAccountId());
		CreateVolumeApiRequestSchema richiestaCreazioneVolume = new CreateVolumeApiRequestSchema();

		CreateVolumeApiRequestSchemaVolume datiVolume = new CreateVolumeApiRequestSchemaVolume();
		datiVolume.setAvailabilityZone(richiesta.getAvailabilityZone());
		datiVolume.setEncrypted(richiesta.getEncrypted());
		datiVolume.setMultiAttachEnabled(richiesta.getMultiAttachEnabled());
		datiVolume.setNvlHypervisor(NvlHypervisorEnum.fromValue(richiesta.getHypervisor()));
		datiVolume.setNvlName(richiesta.getName());
		datiVolume.setOwnerId(accountId);
		datiVolume.setSize(richiesta.getSize());
		datiVolume.setVolumeType(richiesta.getVolumeType());

		richiestaCreazioneVolume.setVolume(datiVolume);

		CreateVolumeApiResponseSchema risposta = computeserviceApi.v20NwsComputeservicesVolumeCreatevolumePost(richiestaCreazioneVolume);

		return new ResponseEntity<VolumeDTO>(volumeMapper.toVolumeDto(risposta.getCreateVolumeResponse()), HttpStatus.OK);
	}
	
	/**
	 * Attach del volume
	 * @param richiesta
	 * @return
	 * @throws BusinessException
	 */
	@PutMapping("/volume/attach")
	@Secured({ AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR })
	@AzioneDispositiva
	public ResponseEntity<AttachDetachVolumeRisposta> attachVolume(@RequestBody RichiestaAttachDetachVolume richiesta) throws BusinessException {
		
		AttachVolumeApiRequestSchema richiestaAttach = new AttachVolumeApiRequestSchema();
		richiestaAttach.setDevice("/dev/sdh");//la CMP lo richiede ma lo ignora
		richiestaAttach.setInstanceId(richiesta.getInstanceId());
		richiestaAttach.setVolumeId(richiesta.getVolumeId());
		AttachVolumeApiResponseSchema rispostaAttach = computeserviceApi.v20NwsComputeservicesVolumeAttachvolumePut(richiestaAttach);
		
		return new ResponseEntity<AttachDetachVolumeRisposta>(volumeMapper.toAttachDetach(rispostaAttach.getAttachVolumeResponse()), HttpStatus.OK);
	}
	
	/**
	 * Detach del volume
	 * @param richiesta
	 * @return
	 * @throws BusinessException
	 */
	@PutMapping("/volume/detach")
	@Secured({ AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR })
	@AzioneDispositiva
	public ResponseEntity<AttachDetachVolumeRisposta> detachVolume(@RequestBody RichiestaAttachDetachVolume richiesta) throws BusinessException {
		
		DetachVolumeApiRequestSchema reqCmp = new DetachVolumeApiRequestSchema();
		reqCmp.setDevice("/dev/sdh");
		reqCmp.setInstanceId(richiesta.getInstanceId());
		reqCmp.setVolumeId(richiesta.getVolumeId());
		DetachVolumeApiResponseSchema risposta = computeserviceApi.v20NwsComputeservicesVolumeDetachvolumePut(reqCmp);
		
		return new ResponseEntity<AttachDetachVolumeRisposta>(volumeMapper.toAttachDetach(risposta.getDetachVolumeResponse()), HttpStatus.OK);
	}
	
	/**
	 * Cancellazione del volume
	 * @param volumeId
	 * @return
	 */
	@DeleteMapping("/volume/{volumeId}")
	@Secured({ AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR })
	@AzioneDispositiva
	public ResponseEntity<EsitoDTO> deleteVolume (@PathVariable String volumeId) {
		DeleteVolumeRequestSchema richiestaDelete = new DeleteVolumeRequestSchema();
		richiestaDelete.setVolumeId(volumeId);
		computeserviceApi.v20NwsComputeservicesVolumeDeletevolumeDelete(richiestaDelete);
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "Cancellazione avvenuta correttamente"), HttpStatus.OK);

	}

}
