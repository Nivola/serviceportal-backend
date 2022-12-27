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
import java.util.stream.Collectors;

import javax.transaction.SystemException;

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
import org.springframework.web.client.RestClientException;

import it.csi.nivola.nivolasp.aop.logging.AzioneDispositiva;
import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.integration.rest.api.service.AuthorityApi;
import it.csi.nivola.nivolasp.integration.rest.api.service.ComputeserviceApi;
import it.csi.nivola.nivolasp.integration.rest.api.service.ServiceApi;
import it.csi.nivola.nivolasp.integration.rest.api.service.StorageserviceApi;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateFileSystemApiRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateFileSystemGrantApiRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateFileSystemGrantApiRequestSchemaGrant;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateFileSystemGrantApiRequestSchemaGrant.AccessLevelEnum;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateFileSystemGrantApiRequestSchemaGrant.AccessTypeEnum;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateMountTargetApiRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateMountTargetApiRequestSchema.NvlShareProtoEnum;
import it.csi.nivola.nivolasp.integration.rest.model.service.DeleteFileSystemGrantRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DeleteFileSystemGrantRequestSchemaGrant;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeFileSystemsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeMountTargetsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeMountTargetsResponseSchemaMountTargets;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeTagsApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.FileSystemDescriptionResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetAccountDefinitionsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListFileSystemGrantResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.UpdateFileSystemRequestSchema;
import it.csi.nivola.nivolasp.security.AuthoritiesConstants;
import it.csi.nivola.nivolasp.security.SecurityUtils;
import it.csi.nivola.nivolasp.service.dto.AutorizzazioneStorageDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoEnum;
import it.csi.nivola.nivolasp.service.dto.ParametriCreazioneVolume;
import it.csi.nivola.nivolasp.service.dto.ProspettoCostiStorageDTO;
import it.csi.nivola.nivolasp.service.dto.RichiestaCostiStorage;
import it.csi.nivola.nivolasp.service.dto.StaasDTO;
import it.csi.nivola.nivolasp.service.dto.Tag;
import it.csi.nivola.nivolasp.service.impl.CostiListinoService;
import it.csi.nivola.nivolasp.service.mapper.StaasMapper;
import it.csi.nivola.nivolasp.service.mapper.cmp.ServiziMapper;

/**
 * Rest controller per la gestione dell Vm
 */
@RestController
@RequestMapping("/api")
public class StaasResource {

	@Autowired
	StorageserviceApi storageserviceApi;
	
	@Autowired
	StaasMapper staasMapper;
	
	@Autowired
	ServiceApi serviceApi;
	
	@Autowired
	ServiziMapper serviziMapper;
	
	@Autowired
	CostiListinoService costiListinoService;
	
	@Autowired
	AuthorityApi authorityApi;
	
	@Autowired
	ComputeserviceApi computeserviceApi;
	
	
	/**
	 * Elenco volumi per l'account corrente
	 * @return
	 * @throws BusinessException 
	 */
	@GetMapping("/staas")
	@Secured({AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR, AuthoritiesConstants.ACCOUNT_VIEWER})
	public ResponseEntity<List<StaasDTO>> elencoStaas (String accountId) throws BusinessException {
		List<String> elencoAccountId = new ArrayList<>(1);
		elencoAccountId.add(SecurityUtils.getAccountIdCorrente(accountId));
		DescribeFileSystemsResponseSchema risposta = storageserviceApi.v10NwsStorageservicesEfsFileSystemsGet(elencoAccountId, null, null, -1, null);
		
		List<StaasDTO> elenco = staasMapper.toListStaasDTOs(risposta.getFileSystems());
		DescribeMountTargetsResponseSchema rispostamount = storageserviceApi.v10NwsStorageservicesEfsMountTargetsGet(elencoAccountId, null, -1, null);
		List<DescribeMountTargetsResponseSchemaMountTargets> elencoMountAccount = rispostamount.getMountTargets();
		
		elenco = elenco.parallelStream().map(volume -> {

			volume.setMountTargets(staasMapper.mapElencoMountTarget(
					elencoMountAccount.parallelStream().filter(
							mount -> mount.getFileSystemId().equals(volume.getFileSystemId())).collect(Collectors.toList())));
			
			List<String> resourceIdN = new ArrayList<>();
			resourceIdN.add(volume.getFileSystemId());
			DescribeTagsApiResponseSchema rispostaTags = computeserviceApi.v10NwsComputeservicesTagDescribetagsGet(elencoAccountId, null, resourceIdN, null, 50, null);
					
			if (rispostaTags.getDescribeTagsResponse().getTagSet() != null) {
				rispostaTags.getDescribeTagsResponse().getTagSet().forEach(t -> {
					Tag tag = new Tag();
					tag.setKey(t.getKey());
					volume.getElencoTag().add(tag);
				});
			}
			
			return volume;
		}
		).collect(Collectors.toList());
		
		
		
		return new ResponseEntity<>(elenco, HttpStatus.OK);
	}
	
	
	/**
	 * Interroga la definjizione dei servizi per ottenere i templates del security
	 * group
	 * 
	 * @return
	 * @throws BusinessException 
	 * @throws RestClientException 
	 */
	@GetMapping("/staas/types")
	@Secured({ AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR, AuthoritiesConstants.ACCOUNT_VIEWER })
	public ResponseEntity<Object> getElencoTipoVolume(String accountId) throws RestClientException, BusinessException {
//		ListServiceDefinitionResponseSchema risposta = serviceApi.v10NwsServicedefsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "StorageEFS", null);	
//		return new ResponseEntity<>(serviziMapper.elencoServizi(risposta.getServicedefs()), HttpStatus.OK);
		GetAccountDefinitionsResponseSchema risposta = authorityApi.v20NwsAccountsOidDefinitionsGet(SecurityUtils.getAccountIdCorrente(accountId), -1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null,"StorageEFS" /*plugin type*/, null, null);
		
		return new ResponseEntity<>(serviziMapper.elencoServiziV2(risposta.getDefinitions()), HttpStatus.OK);
	}
	
	
	/**
	 * §Crea un nuovo volume per l'account corrente
	 * @param volume
	 * @return
	 * @throws BusinessException
	 */
	@PostMapping("/staas")
	@Secured({AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR})
	@AzioneDispositiva
	public ResponseEntity<EsitoDTO> creazioneIstanzaShare (@RequestBody ParametriCreazioneVolume volume) throws BusinessException{
		CreateFileSystemApiRequestSchema richiesta = new CreateFileSystemApiRequestSchema();
		richiesta.setCreationToken(volume.getName());
		richiesta.setNvlFileSystemSize(volume.getDimensione());
		richiesta.setNvlFileSystemType(volume.getTipo());//String type????^
		richiesta.setOwnerId(SecurityUtils.getAccountIdCorrente());
		
		FileSystemDescriptionResponseSchema risposta = storageserviceApi.v10NwsStorageservicesEfsFileSystemsPost(richiesta);
		CreateMountTargetApiRequestSchema richiestaMount = new CreateMountTargetApiRequestSchema();
		richiestaMount.setNvlFileSystemId(risposta.getFileSystemId());
		richiestaMount.setNvlShareProto(NvlShareProtoEnum.fromValue(volume.getProtocolloShare()));
		richiestaMount.setSubnetId(volume.getSubnetId());
		storageserviceApi.v10NwsStorageservicesEfsMountTargetsPost(richiestaMount);
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "Creazione  avvenuta correttamente"), HttpStatus.OK);
	}
	
	/**
	 * Elimina un Volume
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	@DeleteMapping("/staas/{id}")
	@Secured({AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR})
	@AzioneDispositiva
	public ResponseEntity<EsitoDTO> eliminazioneIstanzaShare (@PathVariable String id) throws BusinessException{
		storageserviceApi.v10NwsStorageservicesEfsFileSystemsOidDelete(id);
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "Elimninazione  avvenuta correttamente"), HttpStatus.OK);
	}
	
	
	/**
	 * Elenco Grants di un Volume
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	@GetMapping("/staas/{id}/grants")
	@Secured({AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR})
	public ResponseEntity<List<AutorizzazioneStorageDTO>> elencoAutorizzazioniIstanza (@PathVariable String id) throws BusinessException{
		
		ListFileSystemGrantResponseSchema risposta = storageserviceApi.v10NwsStorageservicesEfsMountTargetsOidGrantsGet(id, -1, 0, null, null);
		return new ResponseEntity<List<AutorizzazioneStorageDTO>>(staasMapper.elencoGtrants(risposta.getGrants()), HttpStatus.OK);
	}
	
	
	/**
	 * Aggiunge un grant al volume
	 * @param id
	 * @param richiesta
	 * @return
	 * @throws BusinessException
	 */
	@PostMapping("/staas/{id}/grants")
	@Secured({AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR})
	@AzioneDispositiva
	public ResponseEntity<EsitoDTO> autorizzaIstanzaShare (@PathVariable String id, @RequestBody AutorizzazioneStorageDTO richiesta) throws BusinessException{
		
		CreateFileSystemGrantApiRequestSchema body = new CreateFileSystemGrantApiRequestSchema();
		CreateFileSystemGrantApiRequestSchemaGrant grant = new CreateFileSystemGrantApiRequestSchemaGrant();
		grant.setAccessLevel(AccessLevelEnum.fromValue(richiesta.getAccessLevel()));
		grant.setAccessTo(richiesta.getAccessTo());
		grant.setAccessType(AccessTypeEnum.fromValue(richiesta.getAccessType()));
		body.setGrant(grant);

		storageserviceApi.v10NwsStorageservicesEfsMountTargetsOidGrantsPost(id, body);
				
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "Abilitazione avvenuta correttamente"), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/staas/{id}/grants/{idAutorizzazione}")
	@Secured({AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR})
	@AzioneDispositiva
	public ResponseEntity<EsitoDTO> revocaautorizzazioneIstanza (@PathVariable String id, @PathVariable String idAutorizzazione) throws BusinessException{
		
		DeleteFileSystemGrantRequestSchema body = new DeleteFileSystemGrantRequestSchema();
		DeleteFileSystemGrantRequestSchemaGrant grant = new DeleteFileSystemGrantRequestSchemaGrant();
		grant.setAccessId(idAutorizzazione);
		body.setGrant(grant);
		storageserviceApi.v10NwsStorageservicesEfsMountTargetsOidGrantsDelete(id, body);
		
		
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "Revoca dell'abilitazione avvenuta correttamente"), HttpStatus.OK);
	}
	
	@PutMapping("/staas")
	@Secured({AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR})
	@AzioneDispositiva
	public ResponseEntity<EsitoDTO> modificaDimensioneVolume (@RequestBody StaasDTO daModificare) throws BusinessException{
		UpdateFileSystemRequestSchema update = new UpdateFileSystemRequestSchema();
		update.setNvlFileSystemSize(daModificare.getNuovaDimensione());
		update.setOid(daModificare.getFileSystemId());
		
		storageserviceApi.v10NwsStorageservicesEfsFileSystemsOidPut(daModificare.getFileSystemId(),update);
		
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "Modifica del volume avvenuta correttamente"), HttpStatus.OK);
	}
	
	/**
	 * Calcolo dei costi MENSILI stimati per la configurazione scelta di una VM .
	 * @param richiestaCosti
	 * @returns
     * @throws SystemException 
	 */
	@GetMapping("/staas/stimacosto")
	@Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN,
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER,
		AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR,  AuthoritiesConstants.DIVISION_VIEWER,
		AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR,  AuthoritiesConstants.ACCOUNT_VIEWER})
	public ResponseEntity<ProspettoCostiStorageDTO> getCostiStimati(RichiestaCostiStorage richiestaCosti) throws SystemException {
		
		return new ResponseEntity<ProspettoCostiStorageDTO>(costiListinoService.calcolaProspettoStorage(richiestaCosti), HttpStatus.OK);
	}
}
