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

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import it.csi.nivola.nivolasp.aop.logging.AzioneDispositiva;
import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.integration.rest.api.service.ComputeserviceApi;
import it.csi.nivola.nivolasp.integration.rest.api.service.ServiceApi;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeAvailabilityZonesResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeAvailabilityZonesResponseSchemaDescribeAvailabilityZonesResponseAvailabilityZoneInfo;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeImagesResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeImagesResponseSchemaDescribeImagesResponseImagesSet;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeInstanceTypesV20ApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeInstancesApiResponseSchemaDescribeInstancesResponseBlockDeviceMapping;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeInstancesV20ApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeSecurityGroupsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeSubnetsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeVolumesApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ModifyInstanceAttributeRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ModifyInstanceAttributeRequestSchemaInstance;
import it.csi.nivola.nivolasp.integration.rest.model.service.ModifyInstanceAttributeResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.RebootInstancesApiRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.RunInstancesApiRequestSchemaInstanceBlockDeviceMappingN;
import it.csi.nivola.nivolasp.integration.rest.model.service.RunInstancesApiRequestSchemaInstanceEbs;
import it.csi.nivola.nivolasp.integration.rest.model.service.RunInstancesV20ApiRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.RunInstancesV20ApiRequestSchemaInstance;
import it.csi.nivola.nivolasp.integration.rest.model.service.RunInstancesV20ApiRequestSchemaInstance.NvlHypervisorEnum;
import it.csi.nivola.nivolasp.integration.rest.model.service.RunInstancesV20ApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.StartInstancesApiRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.StopInstancesApiRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.TerminateInstancesRequestSchema;
import it.csi.nivola.nivolasp.security.AuthoritiesConstants;
import it.csi.nivola.nivolasp.security.SecurityUtils;
import it.csi.nivola.nivolasp.service.dto.DiscoAggiuntivoDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoEnum;
import it.csi.nivola.nivolasp.service.dto.FlavourDTO;
import it.csi.nivola.nivolasp.service.dto.ParametriCreazioneVmDTO;
import it.csi.nivola.nivolasp.service.dto.ParametriGestioneVmDTO;
import it.csi.nivola.nivolasp.service.dto.ParametriModificaVmDTO;
import it.csi.nivola.nivolasp.service.dto.ProspettoCostiVmDTO;
import it.csi.nivola.nivolasp.service.dto.RegionAvailabilityZoneDTO;
import it.csi.nivola.nivolasp.service.dto.RichiestaCostiVmDTO;
import it.csi.nivola.nivolasp.service.dto.SecurityGroupDTO;
import it.csi.nivola.nivolasp.service.dto.SubnetDTO;
import it.csi.nivola.nivolasp.service.dto.TemplateDTO;
import it.csi.nivola.nivolasp.service.dto.VmDTO;
import it.csi.nivola.nivolasp.service.dto.VmDetailDTO;
import it.csi.nivola.nivolasp.service.impl.CostiListinoService;
import it.csi.nivola.nivolasp.service.mapper.VmMapper;
import it.csi.nivola.nivolasp.service.mapper.VolumeMapper;
import it.csi.nivola.nivolasp.util.StreamingObjectUtil;

/**
 * Rest controller per la gestione dell Vm
 */
@RestController
@RequestMapping("/api")
public class VmResource {
	/**
	 * Servizio presso CMP computeservice
	 */
	@Autowired
	ComputeserviceApi computeserviceApi;

	@Autowired
	VmMapper vmMapper;

	@Autowired
	ServiceApi serviceApi;
	
	@Autowired
	CostiListinoService costiListinoService;
	
	@Autowired
	VolumeMapper volumeMapper;

	private Logger log = LoggerFactory.getLogger(VmResource.class);
	

	/**
	 * Recupera l'elenco delle VM di un account
	 * @param accountUuid
	 * @return
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 * @throws BusinessException 
	 */
	@GetMapping("/vm")
	@Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN,
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER,
		AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR,  AuthoritiesConstants.DIVISION_VIEWER,
		AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR,  AuthoritiesConstants.ACCOUNT_VIEWER})
	public ResponseEntity<List<VmDTO>> getElencoVm(String accountId, Optional<String> name) throws InterruptedException, ExecutionException, BusinessException {
		log.debug("Elenco VM");
		List<VmDTO> elencoVM = null;
		List<String> elencoAccountId = new ArrayList<String>(1);
    
    	elencoAccountId.add(SecurityUtils.getAccountIdCorrente(accountId));
		LocalDateTime lDtimeIniziale = LocalDateTime.now();
		
		
		//chiamata CMP
		DescribeInstancesV20ApiResponseSchema risposta = computeserviceApi.v20NwsComputeservicesInstanceDescribeinstancesGet(-1, null, elencoAccountId, null, null, null, null, null, null, null, null, null, null, null);
				
		// il numero di VM stabilit dal primo servizio, si cicla per estrarre i dettagli dell'immagine per  OS, e stato.
		elencoVM = new ArrayList<>(risposta.getDescribeInstancesResponse().getReservationSet().get(0).getInstancesSet().size());
		
		DescribeImagesResponseSchema tutteImmagini = computeserviceApi
				.v10NwsComputeservicesImageDescribeimagesGet(null, null, null, elencoAccountId, null, null, -1, null);

		elencoVM.addAll(risposta
				.getDescribeInstancesResponse()
				.getReservationSet()
				.parallelStream()
				.map(el -> {
						return el
								.getInstancesSet()
								.parallelStream()
								.map(e -> {
									VmDTO singolaVM = vmMapper.toVm2Dto(e);
									if (e.getBlockDeviceMapping() != null && e.getBlockDeviceMapping().size() > 0)
										singolaVM.setDisco(e.getBlockDeviceMapping().stream().mapToDouble(disco -> disco.getEbs().getVolumeSize()).sum());
									singolaVM.setOs(tutteImmagini.getDescribeImagesResponse().getImagesSet().stream().filter(img -> img.getImageId().equals(e.getImageId())).findFirst().orElse(new DescribeImagesResponseSchemaDescribeImagesResponseImagesSet()).getDescription());
									singolaVM.setTagSet(e.getTagSet());
									return singolaVM;
								})
							.collect(Collectors.toList());
				}).flatMap(e -> {
					return e.stream().filter(e1 -> e1 != null);
				}).collect(Collectors.toList()));

		LocalDateTime lDtimeFinale = LocalDateTime.now();
		long seconds = ChronoUnit.SECONDS.between(lDtimeIniziale,lDtimeFinale);
		log.debug("TEMPO DI ESECUZIONE secondi :"+seconds+" s");
		return new ResponseEntity<List<VmDTO>>(elencoVM, HttpStatus.OK);
	}


	/**
	 * Richiesta del dettaglio completo di una singola istanza: decodifica tutte le proprietà di un'istanza con
	 * immagine e subnet
	 * @param instanceId
	 * @return
	 * @throws BusinessException 
	 */
	@GetMapping("/vm/{instanceId}")
	@Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN,
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER,
		AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR,  AuthoritiesConstants.DIVISION_VIEWER,
		AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR,  AuthoritiesConstants.ACCOUNT_VIEWER})
	public ResponseEntity<VmDetailDTO> getDettaglioVm(@PathVariable String instanceId) throws BusinessException {
		
		List<String> elencoAccountId = new ArrayList<String>(1);
		elencoAccountId.add(SecurityUtils.getAccountIdCorrente());
		
		//imposta l'id dell'istanza richiesta ed effettua al servizio di descrzione dell'istanza
		List<String> elencoIstanze = new ArrayList<>(1);
		elencoIstanze.add(instanceId);
		
		DescribeInstancesV20ApiResponseSchema ricercaIstanza = computeserviceApi.v20NwsComputeservicesInstanceDescribeinstancesGet(-1, null, elencoAccountId, null, null, elencoIstanze, null, null, null, null, null, null, null, null);
		
		DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet istanza = ricercaIstanza.getDescribeInstancesResponse().getReservationSet().get(0).getInstancesSet().get(0);

		// crea l'oggetto completo
		VmDetailDTO singolaVM = vmMapper.toVmV2DetailDto(istanza);

		//recupera i dettagli os sull'immagine dell'istanza
		impostaOsEStato(istanza, singolaVM);

		//decodifica della subnet
		impostaSubnet(istanza, singolaVM);
		
		
		//Gestione dei volumi
		if (istanza.getBlockDeviceMapping() != null) {
			istanza.getBlockDeviceMapping().parallelStream().forEach(volume -> gestioneDettaglioVoume(singolaVM, volume));
		}
		
		
		return new ResponseEntity<VmDetailDTO>(singolaVM, HttpStatus.OK);
	}


	private void gestioneDettaglioVoume(VmDetailDTO singolaVM, DescribeInstancesApiResponseSchemaDescribeInstancesResponseBlockDeviceMapping volume) {
		List<String> volumeId = new ArrayList<>();
		if (volume.getEbs() == null) return;
		volumeId.add(volume.getEbs().getVolumeId());
		DescribeVolumesApiResponseSchema rispostaVolume = computeserviceApi.v10NwsComputeservicesVolumeDescribevolumesGet(-1, // maxResults,
				null, // nextToken,
				null, // ownerIdN,
				null, // nvlNameN,
				volumeId, // volumeIdN,
				null, // volumeIdN2,
				null, // volumeTypeN,
				null, // statusN,
				null, // tagKeyN,
				null, // createTimeN,
				null // attachmentN
		);
		
		if (rispostaVolume.getDescribeVolumesResponse().getNvlVolumeTotal() > 0 ) {
			singolaVM.getElencoVolumi().add(volumeMapper.toVolumeDto(rispostaVolume.getDescribeVolumesResponse().getVolumesSet().get(0)));
		}
	}


	private void impostaSubnet(DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet istanza, VmDetailDTO singolaVM) {
		List<String> idSubnetFiltro = new ArrayList<>(1);
		idSubnetFiltro.add(istanza.getSubnetId());
		DescribeSubnetsResponseSchema rispostaSubnet = computeserviceApi.v10NwsComputeservicesSubnetDescribesubnetsGet(
				null, // vpcIdN,
				null, // vpcIdN2,
				null, // tagKeyN,
				null, // stateN,
				idSubnetFiltro, // subnetIdN,
				null, // ownerIdN,
				null, // subnetIdN2,
				null // subnetIdN3
		);
		singolaVM.setSubnet(vmMapper.toSubnetDTO(rispostaSubnet.getDescribeSubnetsResponse().getSubnetSet().get(0)));
	}


	private void impostaOsEStato(DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet istanza, VmDetailDTO singolaVM) {
		ArrayList<String> immagini = new ArrayList<String>(1);
		immagini.add(istanza.getImageId());
		DescribeImagesResponseSchema rispostaImg = computeserviceApi.v10NwsComputeservicesImageDescribeimagesGet(immagini, null, null, null, null, null, -1, null);
		singolaVM.setOs(rispostaImg.getDescribeImagesResponse().getImagesSet().get(0).getDescription());
		singolaVM.setStatus((istanza.getInstanceState()!= null && istanza.getInstanceState().getName() != null) ? istanza.getInstanceState().getName().getValue() : "");
	}


	/**
	 * Accensione della VM
	 * @param instanceId
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("rawtypes")
	@PutMapping("/vm/{instanceId}/accensione")
	@Secured({AuthoritiesConstants.BOADMIN,
		AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR})
	@AzioneDispositiva
	public ResponseEntity avvioIstanza (@PathVariable String instanceId) throws BusinessException {
		List<String> ownerIdN = new ArrayList<String>(1);
		ownerIdN.add(SecurityUtils.getAccountIdCorrente());
		List<String> instanceIdN = new ArrayList<>(1);
		instanceIdN.add(instanceId);
		StartInstancesApiRequestSchema body = new StartInstancesApiRequestSchema();
		body.setInstanceIdDotN(instanceIdN);
		body.setOwnerIdN(ownerIdN);
		computeserviceApi.v20NwsComputeservicesInstanceStartinstancesPut(body);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	/**
	 * Riavvio della VM
	 * @param parametri
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("rawtypes")
	@PostMapping("/vm/reboot")
	@Secured({AuthoritiesConstants.BOADMIN,
		AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR})
	@AzioneDispositiva
	public ResponseEntity rebootIstanzaVm (@RequestBody ParametriGestioneVmDTO parametri) throws BusinessException {
		List<String> ownerIdN = new ArrayList<String>(1);
		ownerIdN.add(SecurityUtils.getAccountIdCorrente(parametri.getAccountId()));
		List<String> instanceIdN = new ArrayList<>(1);
		instanceIdN.add(parametri.getInstanceId());
		RebootInstancesApiRequestSchema body = new RebootInstancesApiRequestSchema();
		body.setInstanceIdDotN(instanceIdN);
		body.setOwnerIdN(ownerIdN);
		computeserviceApi.v20NwsComputeservicesInstanceRebootinstancesPut(body);
		return new ResponseEntity(HttpStatus.OK);
	}

	/**
	 * Spegnimento della VM
	 * @param instanceId
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/vm/{instanceId}/accensione")
	@Secured({AuthoritiesConstants.BOADMIN,
		AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR})
	@AzioneDispositiva
	public ResponseEntity arrestoIstanza (@PathVariable String instanceId) throws BusinessException {
		List<String> ownerIdN = new ArrayList<String>(1);
		ownerIdN.add(SecurityUtils.getAccountIdCorrente());
		List<String> instanceIdN = new ArrayList<>(1);
		instanceIdN.add(instanceId);
		StopInstancesApiRequestSchema body = new StopInstancesApiRequestSchema();
		body.setForce(true);
		body.setHibernate(false);
		body.setInstanceIdDotN(instanceIdN);
		body.setOwnerIdN(ownerIdN);
		computeserviceApi.v20NwsComputeservicesInstanceStopinstancesPut(body);
		return new ResponseEntity(HttpStatus.OK);
	}

	/**
	 * Eliminazione della VM
	 * @param instanceId
	 * @return
	 */
	@DeleteMapping("/vm/{instanceId}")
	@Secured({AuthoritiesConstants.BOADMIN,
		AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR})
	@AzioneDispositiva
	public ResponseEntity<EsitoDTO> eliminaIstanza (@PathVariable String instanceId) {
		TerminateInstancesRequestSchema richiesta = new TerminateInstancesRequestSchema();
		List<String> instanceIdN = new ArrayList<>(1);
		instanceIdN.add(instanceId);
		richiesta.setInstanceIdDotN(instanceIdN);
		computeserviceApi.v20NwsComputeservicesInstanceTerminateinstancesDelete(richiesta);
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0000", "VM eliminata correttamente"), HttpStatus.OK);
	}

	/**
	 * Recupera i Templates
	 * @throws BusinessException 
	 */
	@GetMapping("/vm/templates")
	@Secured({AuthoritiesConstants.BOADMIN,
		AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR})
	public ResponseEntity<List<TemplateDTO>> getElencoTemplates(String accountUuid) throws BusinessException {
		List<String> elencoAccountId = new ArrayList<String>(1);
		elencoAccountId.add(SecurityUtils.getAccountIdCorrente());
		DescribeImagesResponseSchema risposta = computeserviceApi.v10NwsComputeservicesImageDescribeimagesGet(null, null, null, elencoAccountId, null, null, -1, null);
		return new ResponseEntity<List<TemplateDTO>>(vmMapper.toListTemplateDTOs(risposta.getDescribeImagesResponse().getImagesSet()), HttpStatus.OK);
	}

	/**
	 * Recupera i Flavours
	 * @throws BusinessException 
	 * @throws RestClientException 
	 */
	@GetMapping("/vm/flavour")
	@Secured({AuthoritiesConstants.BOADMIN,
		AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR})
	public ResponseEntity<List<FlavourDTO>> getElencoFlavours() throws RestClientException, BusinessException {
		DescribeInstanceTypesV20ApiResponseSchema risposta = computeserviceApi.v20NwsComputeservicesInstanceDescribeinstancetypesGet(SecurityUtils.getAccountIdCorrente(), -1, null, null);
		return new ResponseEntity<List<FlavourDTO>>(vmMapper.toListFlavourDTOs(risposta.getDescribeInstanceTypesResponse().getInstanceTypesSet()), HttpStatus.OK);
	}


	/**
	 * Elenco delle subnet
	 * @return
	 * @throws BusinessException
	 */
	@GetMapping("/vm/subnet")
	@Secured({AuthoritiesConstants.BOADMIN,
		AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR, AuthoritiesConstants.ACCOUNT_VIEWER})
	public ResponseEntity<List<SubnetDTO>> getElencoSubnet() throws BusinessException {
		List<String> elencoAccountId = new ArrayList<String>(1);
		elencoAccountId.add(SecurityUtils.getAccountIdCorrente());
		DescribeSubnetsResponseSchema risposta = computeserviceApi.v10NwsComputeservicesSubnetDescribesubnetsGet(
				elencoAccountId, //ownerIdN, 
				null, //stateN, 
				null, // tagKeyN, 
				null, //subnetIdN, 
				null, //subnetIdN2, 
				null, //vpcIdN, 
				null, //nvlMaxResults, 
				null //nvlNextToken
		);
		return new ResponseEntity<List<SubnetDTO>>(vmMapper.toListSubnetDTOs(risposta.getDescribeSubnetsResponse().getSubnetSet()), HttpStatus.OK);
	}


	/**
	 * Elenco dei security Groups
	 * @param accountUuid
	 * @param usaTuttiAccount
	 * @return
	 * @throws BusinessException
	 */
	@GetMapping({"/vm/securitygroups", "/securitygroups"})
	@Secured({AuthoritiesConstants.BOADMIN,
		AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR, AuthoritiesConstants.ACCOUNT_VIEWER})
	public ResponseEntity<List<SecurityGroupDTO>> getElencoSecurityGroups(String accountUuid, boolean usaTuttiAccount) throws BusinessException {
		List<String> elencoAccount = new ArrayList<String>(1);
		if (usaTuttiAccount) {
			elencoAccount = SecurityUtils.getTuttiAccountIdsUtente();
		} else {
			if (StringUtils.isEmpty(accountUuid))
				elencoAccount.add(SecurityUtils.getAccountIdCorrente());
			else
				elencoAccount.add(accountUuid);
		}
		DescribeSecurityGroupsResponseSchema risposta = computeserviceApi.v10NwsComputeservicesSecuritygroupDescribesecuritygroupsGet(elencoAccount, null, null, null, null, null, null, -1, null);
		return new ResponseEntity<List<SecurityGroupDTO>>(vmMapper.toListSecurityGroupDTO(risposta.getDescribeSecurityGroupsResponse().getSecurityGroupInfo()), HttpStatus.OK);
	}

	/**
	 * Availability Zones
	 * @return
	 * @throws RestClientException
	 * @throws BusinessException
	 */
	@GetMapping("/vm/availabilityzones")
	@Secured({AuthoritiesConstants.BOADMIN,
		AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR, AuthoritiesConstants.ACCOUNT_VIEWER})
	public ResponseEntity<List<RegionAvailabilityZoneDTO>> getRegionAvabilityZones() throws RestClientException, BusinessException {
		List<RegionAvailabilityZoneDTO> risultati = new ArrayList<>();
 		DescribeAvailabilityZonesResponseSchema risposta = computeserviceApi.v10NwsComputeservicesDescribeavailabilityzonesGet(SecurityUtils.getAccountIdCorrente());
		for (DescribeAvailabilityZonesResponseSchemaDescribeAvailabilityZonesResponseAvailabilityZoneInfo elem : risposta.getDescribeAvailabilityZonesResponse().getAvailabilityZoneInfo()) {
			RegionAvailabilityZoneDTO regione = new RegionAvailabilityZoneDTO(elem.getRegionName(), null, elem.getZoneName(), null);
			if (risultati.contains(regione)) {
				regione = risultati.get(risultati.indexOf(regione));
				regione.addAvailabilityZone(elem.getZoneName(), null);
			} else {
				risultati.add(regione);
			}

		}
		return new ResponseEntity<List<RegionAvailabilityZoneDTO>> (risultati, HttpStatus.OK);
	}

	/**
	 * Creazione della VM
	 * @param vm
	 * @return
	 * @throws BusinessException 
	 */
	@PostMapping("/vm")
	@Secured({AuthoritiesConstants.BOADMIN,
		AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR})
	@AzioneDispositiva
	public ResponseEntity<RunInstancesV20ApiResponseSchema> creaVm(@RequestBody ParametriCreazioneVmDTO vm) throws BusinessException {

		log.debug(StreamingObjectUtil.streamObjectToJSON(vm));
		RunInstancesV20ApiRequestSchema richiesta = new RunInstancesV20ApiRequestSchema();
		RunInstancesV20ApiRequestSchemaInstance instance = new RunInstancesV20ApiRequestSchemaInstance();
		instance.setAdditionalInfo(vm.getDescrizione());

		List<RunInstancesApiRequestSchemaInstanceBlockDeviceMappingN> blockDeviceMappingN = new ArrayList<>();
		RunInstancesApiRequestSchemaInstanceBlockDeviceMappingN block = new RunInstancesApiRequestSchemaInstanceBlockDeviceMappingN();
		RunInstancesApiRequestSchemaInstanceEbs ebs = new RunInstancesApiRequestSchemaInstanceEbs();
		ebs.setVolumeSize(vm.getDiscobase().getDimensioneDisco());
//		ebs.setVolumeType(vm.getDiscobase().getTipoDisco());
		block.setEbs(ebs);
		blockDeviceMappingN.add(block);

		if (vm.getDischiAggiuntivi() != null)
		for (DiscoAggiuntivoDTO discoAggiuntivo : vm.getDischiAggiuntivi()) {
			block = new RunInstancesApiRequestSchemaInstanceBlockDeviceMappingN();
			ebs = new RunInstancesApiRequestSchemaInstanceEbs();
			ebs.setVolumeSize(discoAggiuntivo.getDimensioneDisco());
//			ebs.setVolumeType(discoAggiuntivo.getTipoDisco());
			block.setEbs(ebs);
			blockDeviceMappingN.add(block);
			instance.setBlockDeviceMappingN(blockDeviceMappingN);
		}
		instance.setBlockDeviceMappingN(blockDeviceMappingN);
		instance.setImageId(vm.getTemplateUuid());
		instance.setInstanceType(vm.getFlavurUuid());
		instance.setName(vm.getNome());
		instance.setKeyName(vm.getNomeChiave());
		
		instance.setNvlMultiAvz(true);
		instance.setNvlHypervisor(NvlHypervisorEnum.fromValue(vm.getHypervisor()));
		if (StringUtils.isNotEmpty(vm.getHypervisor()))
			instance.setNvlHypervisor(NvlHypervisorEnum.fromValue(vm.getHypervisor().toLowerCase()));
		
		instance.setOwnerId(SecurityUtils.getAccountIdCorrente());

		List<String> securityGroup = new ArrayList<>(1);
		securityGroup.add(vm.getSecurityGroup());
		instance.setSecurityGroupIdN(securityGroup);

		instance.setSubnetId(vm.getSubnet());
		richiesta.setInstance(instance);
		RunInstancesV20ApiResponseSchema risposta = computeserviceApi.v20NwsComputeservicesInstanceRuninstancesPost(richiesta);
		return new ResponseEntity<RunInstancesV20ApiResponseSchema>(risposta, HttpStatus.OK);
	}

	/**
	 * Resize della VM - modifica il flavour
	 * @param vm
	 * @return
	 */
	@PutMapping("/vm")
	@Secured({AuthoritiesConstants.BOADMIN,
		AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR})
	@AzioneDispositiva
	public ResponseEntity<EsitoDTO> modifcaFlavourInstanceTypeVm(@RequestBody ParametriModificaVmDTO vm) {
		
		ModifyInstanceAttributeRequestSchema richiesta = new ModifyInstanceAttributeRequestSchema();
		ModifyInstanceAttributeRequestSchemaInstance modifica = new ModifyInstanceAttributeRequestSchemaInstance();
		modifica.setInstanceId(vm.getInstanceUuid());
		modifica.setInstanceType(StringUtils.trimToNull(vm.getFlavourUuid()));
		richiesta.setInstance(modifica);
		
		List<String> gruppiModifica = new LinkedList<String>();
		if (!CollectionUtils.isEmpty(vm.getElencoGruppiAggiungere()))
			gruppiModifica.addAll(vm.getElencoGruppiAggiungere().stream().map(add -> add+":ADD").collect(Collectors.toList()));
		if (!CollectionUtils.isEmpty(vm.getElencoGruppiEliminare()))
			gruppiModifica.addAll(vm.getElencoGruppiEliminare().stream().map(del -> del+":DEL").collect(Collectors.toList()));
		modifica.setGroupIdN(gruppiModifica.size() != 0 ? gruppiModifica : null);
		richiesta.setInstance(modifica);
		ModifyInstanceAttributeResponseSchema risposta = computeserviceApi.v20NwsComputeservicesInstanceModifyinstanceattributePut(richiesta);
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0000", risposta.getModifyInstanceAttributeResponse().getReturn()), HttpStatus.OK);
	}
	
	/**
	 * Calcolo dei costi MENSILI stimati per la configurazione scelta di una VM .
	 * @param richiestaCosti
	 * @return
	 * @throws BusinessException 
	 */
	@GetMapping("/vm/stimacosto")
	@Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN,
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER,
		AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR,  AuthoritiesConstants.DIVISION_VIEWER,
		AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR,  AuthoritiesConstants.ACCOUNT_VIEWER})
	public ResponseEntity<ProspettoCostiVmDTO> getCostiStimatiVm(RichiestaCostiVmDTO richiestaCosti) throws BusinessException {
		
		return new ResponseEntity<ProspettoCostiVmDTO>(costiListinoService.calcolaProspettoVm(richiestaCosti), HttpStatus.OK);
	}
}
