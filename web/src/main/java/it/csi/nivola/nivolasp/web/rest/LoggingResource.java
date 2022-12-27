/*-
 * ========================LICENSE_START=================================
 * Nivola Web
 * %%
 * Copyright (C) 2022 Regione Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | Regione Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.web.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.integration.rest.api.service.LoggingserviceApi;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateLoggingInstanceApiRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateLoggingInstanceApiRequestSchemaInstance;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateLoggingInstanceApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateSpaceApiRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateSpaceApiRequestSchemaSpace;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateSpaceApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DeleteLoggingInstanceApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeLoggingInstanceLogConfigApiV2ResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeLoggingInstancesResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeSpacesResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DisableLogConfigApiRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DisableLogConfigApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.EnableLogConfigApiRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.EnableLogConfigApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.SyncUsersSpaceApiRequestSchema;
import it.csi.nivola.nivolasp.security.SecurityUtils;
import it.csi.nivola.nivolasp.service.dto.ConfiguraModuloDto;
import it.csi.nivola.nivolasp.service.dto.CreazioneLoggingSpaceDto;
import it.csi.nivola.nivolasp.service.dto.DescrizioneLoggingDto;
import it.csi.nivola.nivolasp.service.dto.EsitoDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoEnum;
import it.csi.nivola.nivolasp.service.dto.LoggingSpaceDto;
import it.csi.nivola.nivolasp.service.mapper.cmp.LoggingMapper;
import it.csi.nivola.nivolasp.web.rest.dto.RichiestaCreazioneIstanzaLoggingDto;
import it.csi.nivola.nivolasp.web.rest.dto.RispostaElenco;

@RestController
@RequestMapping("/api")
public class LoggingResource extends AbstractResource {
	
	@Autowired
	LoggingserviceApi loggingserviceApi;
	
	@Autowired
	LoggingMapper loggerMapper;
	
	/**
	 * Elenco Logs
	 * @param accountId
	 * @return
	 * @throws BusinessException
	 */
	@GetMapping("/logging")
	public ResponseEntity<RispostaElenco<DescrizioneLoggingDto>> elencoLogAccount (String accountId) throws BusinessException {
		List<String> ownerId = new ArrayList<String>();
		ownerId.add(SecurityUtils.getAccountIdCorrente(accountId));
		ResponseEntity<DescribeLoggingInstancesResponseSchema> risposta = loggingserviceApi.v10NwsLoggingservicesInstanceDescribeinstancesGetWithHttpInfo(
				ownerId // list string ownerId
				, null // String instanceName
				, null // list String instanceIdN
				, -1 // maxItems
				, null // String marker
		);
		
		RispostaElenco<DescrizioneLoggingDto> rispostaRest = new RispostaElenco<DescrizioneLoggingDto>();
		rispostaRest.setNextToken(risposta.getBody().getDescribeLoggingInstancesResponse().getNextToken());
		rispostaRest.setRequestId(risposta.getBody().getDescribeLoggingInstancesResponse().getRequestId());
		rispostaRest.setXmlns(risposta.getBody().getDescribeLoggingInstancesResponse().getXmlns());
		rispostaRest.setTotale(risposta.getBody().getDescribeLoggingInstancesResponse().getNvlInstanceTotal());
		
		rispostaRest.setElenco(loggerMapper.toListDescrizioneLogging(risposta.getBody().getDescribeLoggingInstancesResponse().getInstanceInfo()));
		
		return new ResponseEntity<RispostaElenco<DescrizioneLoggingDto>>(rispostaRest, HttpStatus.OK);
	}
	
	/**
	 * Creazione
	 * @param richiestaFe
	 * @return
	 * @throws BusinessException
	 */
	@PostMapping("/logging")
	public ResponseEntity<EsitoDTO> creazioneIstanzaLog (@RequestBody RichiestaCreazioneIstanzaLoggingDto richiestaFe) throws BusinessException {
		
		CreateLoggingInstanceApiRequestSchema richiestaCreazioneLog = new CreateLoggingInstanceApiRequestSchema();
		CreateLoggingInstanceApiRequestSchemaInstance istanza = new CreateLoggingInstanceApiRequestSchemaInstance();
		istanza.setComputeInstanceId(richiestaFe.getInstanceId());
		istanza.setInstanceType(richiestaFe.getInstanceType());
		istanza.setOwnerId(SecurityUtils.getAccountIdCorrente(richiestaFe.getAccountId()));
		richiestaCreazioneLog.setInstance(istanza);
		ResponseEntity<CreateLoggingInstanceApiResponseSchema> rispostaCreazioneIstanza = loggingserviceApi.v10NwsLoggingservicesInstanceCreateinstancePostWithHttpInfo(richiestaCreazioneLog);
		return new ResponseEntity<EsitoDTO> (new EsitoDTO(EsitoEnum.OK, "0000" , "Log creato correttamente: " + rispostaCreazioneIstanza.getBody().getCreateLoggingInstanceResponse().getNvlActiveTask()), HttpStatus.OK);
		
	}
	
	/**
	 * Cancellazione
	 * @param idIstanza
	 * @return
	 * @throws BusinessException
	 */
	@DeleteMapping("/logging/{id}")
	public ResponseEntity<EsitoDTO> eliminazioneIstanzaLog (String idIstanza) throws BusinessException {
		ResponseEntity<DeleteLoggingInstanceApiResponseSchema> rispostaEliminazione = loggingserviceApi.v10NwsLoggingservicesInstanceDeleteteinstanceDeleteWithHttpInfo(idIstanza);
		return new ResponseEntity<EsitoDTO> (new EsitoDTO(EsitoEnum.OK, "0000" , "Log eliminatoCorrettamente correttamente con id richiesta " + rispostaEliminazione.getBody().getDeleteInstanceResponse().getRequestId()), HttpStatus.OK);
		
	}
	
	
	/**
	 * Elenco configurazione moduli
	 * @throws BusinessException 
	 * @throws RestClientException 
	 */
	@GetMapping("/logging/config")
	public ResponseEntity<RispostaElenco<String>> elencoConfigurazioneModuli (String accountId) throws RestClientException, BusinessException {
		ResponseEntity<DescribeLoggingInstanceLogConfigApiV2ResponseSchema> rispostaCmp = loggingserviceApi.v10NwsLoggingservicesInstanceDescribelogconfigGetWithHttpInfo(SecurityUtils.getAccountIdCorrente(accountId));
		
		RispostaElenco<String> elencoConfigurazioneModuli = new RispostaElenco<>();
		elencoConfigurazioneModuli.setRequestId(rispostaCmp.getBody().getDescribeLoggingInstanceLogConfigResponse().getRequestId());
		elencoConfigurazioneModuli.setTotale(rispostaCmp.getBody().getDescribeLoggingInstanceLogConfigResponse().getLogConfigTotal());
		elencoConfigurazioneModuli.setXmlns(rispostaCmp.getBody().getDescribeLoggingInstanceLogConfigResponse().getXmlns());
		elencoConfigurazioneModuli.setElenco(rispostaCmp.getBody().getDescribeLoggingInstanceLogConfigResponse().getLogConfigSet().stream().map(config -> config.getName()).collect(Collectors.toList()));
		
		return new ResponseEntity<RispostaElenco<String>>(elencoConfigurazioneModuli, HttpStatus.OK);
	}
	
	
	/**
	 * Configurazione - Attivazione di un modulo sull'istanza
	 */
	@PostMapping("/logging/config")
	public ResponseEntity<EsitoDTO> configuraModuloIstanza (@RequestBody ConfiguraModuloDto parametri) throws BusinessException {
		
		EnableLogConfigApiRequestSchema richiestaConfigurazioneModulo = new EnableLogConfigApiRequestSchema();
		richiestaConfigurazioneModulo.setConfig(parametri.getConfig());
		richiestaConfigurazioneModulo.setInstanceId(parametri.getInstanceId());
		ResponseEntity<EnableLogConfigApiResponseSchema> rispostaConfigurazioneModulo = loggingserviceApi.v10NwsLoggingservicesInstanceEnablelogconfigPutWithHttpInfo(richiestaConfigurazioneModulo);
		
		return new ResponseEntity<EsitoDTO> (new EsitoDTO(EsitoEnum.OK, "0000" , "Configurazione modulo eseguita correttamente: " + rispostaConfigurazioneModulo.getBody().getEnableLogConfigResponse().getNvlActiveTask()), HttpStatus.OK);
	}
	
	
	/**
	 * Disattivazione di un modulo sull'istanza
	 */
	@DeleteMapping("/logging/config/{config}/instance/{instanceId}")
	public ResponseEntity<EsitoDTO> disattivaModuloIstanza (String config, String instanceId) throws BusinessException {
		
		DisableLogConfigApiRequestSchema richiestaDisattivazioneModulo = new DisableLogConfigApiRequestSchema();
		richiestaDisattivazioneModulo.setConfig(config);
		richiestaDisattivazioneModulo.setInstanceId(instanceId);
		ResponseEntity<DisableLogConfigApiResponseSchema> rispostaConfigurazioneModulo = loggingserviceApi.v10NwsLoggingservicesInstanceDisablelogconfigPutWithHttpInfo(richiestaDisattivazioneModulo);
		
		return new ResponseEntity<EsitoDTO> (new EsitoDTO(EsitoEnum.OK, "0000" , "Configurazione modulo eseguita correttamente: " + rispostaConfigurazioneModulo.getBody().getDisableLogConfigResponse().getNvlActiveTask()), HttpStatus.OK);
	}
	
	
	/**
	 * Elenco spazi
	 * @throws BusinessException 
	 * @throws RestClientException 
	 */
	@GetMapping("/logging/space")
	public ResponseEntity<RispostaElenco<LoggingSpaceDto>> elencoSpazi (String accountId) throws RestClientException, BusinessException {
		
		ArrayList<String> ownerId = new ArrayList<>();
		ownerId.add(SecurityUtils.getAccountIdCorrente(accountId));
		
		ResponseEntity<DescribeSpacesResponseSchema> rispostaCmp = loggingserviceApi.v10NwsLoggingservicesSpacesDescribespacesGetWithHttpInfo(
				ownerId, // list string ownerId
				null, // space name
				null, // list string space id n
				-1, // max results
				null // marker
		);
		
		RispostaElenco<LoggingSpaceDto> risposta = new RispostaElenco<>();
		risposta.setRequestId(rispostaCmp.getBody().getDescribeSpacesResponse().getRequestId());
		risposta.setNextToken(rispostaCmp.getBody().getDescribeSpacesResponse().getNextToken());
		risposta.setTotale(rispostaCmp.getBody().getDescribeSpacesResponse().getSpaceTotal());
		risposta.setXmlns(rispostaCmp.getBody().getDescribeSpacesResponse().getXmlns());
		
		risposta.setElenco(loggerMapper.toLoggingSpaceDto(rispostaCmp.getBody().getDescribeSpacesResponse().getSpaceInfo()));
		
		return new ResponseEntity<RispostaElenco<LoggingSpaceDto>>(risposta, HttpStatus.OK);
	}
	
	/**
	 * Crea spazio di Log
	 * @param parametri
	 * @return
	 * @throws BusinessException
	 */
	@PostMapping("/logging/space")
	public ResponseEntity<EsitoDTO> creaSpazioLogging (@RequestBody CreazioneLoggingSpaceDto parametri) throws BusinessException {
		CreateSpaceApiRequestSchema richiestaCreazioneSpace = new CreateSpaceApiRequestSchema();
		CreateSpaceApiRequestSchemaSpace space = new CreateSpaceApiRequestSchemaSpace();
		space.setAdditionalInfo(parametri.getAdditionalInfo());
		space.setDefinition(parametri.getDefinition()); //definition
		space.setName(parametri.getName());
		space.setOwnerId(SecurityUtils.getAccountIdCorrente(parametri.getOwnerId()));
		richiestaCreazioneSpace.setSpace(space);
		@SuppressWarnings("unused")
		ResponseEntity<CreateSpaceApiResponseSchema> rispostaCreazioneSpace = loggingserviceApi.v10NwsLoggingservicesSpacesCreatespacePostWithHttpInfo(richiestaCreazioneSpace);
		
		return ResponseEntity.ok(new EsitoDTO(EsitoEnum.OK, "0001", "Spazio creato correttamente"));
		
	}
	
	/**
	 * Sincronizza space
	 * @param spaceId
	 * @return
	 */
	@PutMapping("/logging/space/{spaceId}")
	public ResponseEntity<EsitoDTO> sincronizzaSpace(@PathVariable String spaceId) {
		SyncUsersSpaceApiRequestSchema richiestaSyncSpace = new SyncUsersSpaceApiRequestSchema();
		richiestaSyncSpace.setSpaceId(spaceId);
		loggingserviceApi.v10NwsLoggingservicesSpacesSyncspaceusersPutWithHttpInfo(richiestaSyncSpace);
		
		return ResponseEntity.ok(new EsitoDTO(EsitoEnum.OK, "0001", "Space sincronizzato correttamente"));
	}
	
	/**
	 * Delete space
	 * @param spaceId
	 * @return
	 */
	@DeleteMapping("/logging/space/{spaceId}")
	public ResponseEntity<EsitoDTO> eliminaSpace(@PathVariable String spaceId) {
		loggingserviceApi.v10NwsLoggingservicesSpacesDeletespaceDeleteWithHttpInfo(spaceId);
		
		return ResponseEntity.ok(new EsitoDTO(EsitoEnum.OK, "0001", "Space eliminato correttamente"));
	}
	

}
