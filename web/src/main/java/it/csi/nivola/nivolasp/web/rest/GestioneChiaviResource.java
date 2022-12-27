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
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
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
import it.csi.nivola.nivolasp.config.ApplicationProperties;
import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.integration.rest.api.service.ComputeserviceApi;
import it.csi.nivola.nivolasp.integration.rest.api.service.ServiceApi;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateKeyPairApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateKeyPairRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateKeyPairRequestSchemaKeypair;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateKeyPairRequestSchemaKeypair.NvlKeyPairTypeEnum;
import it.csi.nivola.nivolasp.integration.rest.model.service.DeleteKeyPairRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DeleteKeyPairResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ImportKeyPairRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ImportKeyPairRequestSchemaKeypair;
import it.csi.nivola.nivolasp.integration.rest.model.service.ImportKeyPairResponseSchema;
import it.csi.nivola.nivolasp.security.AuthoritiesConstants;
import it.csi.nivola.nivolasp.security.SecurityUtils;
import it.csi.nivola.nivolasp.service.dto.ChiaveDTO;
import it.csi.nivola.nivolasp.service.dto.CreaChiaveRequestDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoEnum;
import it.csi.nivola.nivolasp.service.mapper.cmp.ServiziMapper;
import it.csi.nivola.nivolasp.util.RSAUtils;

/**
 * Rest controller per la gestione delle chiavi (key pairs)
 */
@RestController
@RequestMapping("/api")
public class GestioneChiaviResource {
	
	ApplicationProperties applicationProperties;
	
	ServiceApi serviceApi;
	
	ServiziMapper serviziMapper;
	
	ComputeserviceApi computeserviceApi;

	
	/**
	 * Costruttore
	 * @param storageserviceApi
	 * @param staasMapper
	 * @param applicationProperties
	 */
	public GestioneChiaviResource(ComputeserviceApi computeserviceApi, ServiziMapper serviziMapper, ServiceApi serviceApi, ApplicationProperties applicationProperties) {
		this.applicationProperties = applicationProperties;
		this.serviceApi = serviceApi;
		this.serviziMapper = serviziMapper;
		this.computeserviceApi = computeserviceApi;
	}
	
	
	/**
	 * Elenco delle chiavi esistenti per account
	 * @return
	 * @throws BusinessException 
	 */
	@GetMapping("/keypairs")
	@Secured({AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR, AuthoritiesConstants.ACCOUNT_VIEWER, AuthoritiesConstants.BOADMIN})
	public ResponseEntity<List<ChiaveDTO>> elencoChiavi (String accountId, String name) throws BusinessException {
		List<String> elencoAccountId = new ArrayList<String>(1);
		elencoAccountId.add(SecurityUtils.getAccountIdCorrente(accountId));
		List<String> elencoNomiChiavi = null;
		if (StringUtils.isNotEmpty(name)) {
			elencoNomiChiavi = new ArrayList<String>(1);
			elencoNomiChiavi.add(name);
		}
			
		
		elencoAccountId.add(SecurityUtils.getAccountIdCorrente());
		List<ChiaveDTO> elenco = computeserviceApi.v10NwsComputeservicesKeypairDescribekeypairsGet(
				elencoNomiChiavi, //keyNameN, 
				null, //keyNameN2, 
				elencoAccountId, //ownerIdN, 
				-1, //nvlMaxResults, 
				null //nvlNextToken
				).getDescribeKeyPairsResponse().getKeySet().stream().map(kp -> {
					ChiaveDTO chiave = new ChiaveDTO();
					chiave.setId(kp.getNvlKeyId());
					chiave.setImpronta(kp.getKeyFingerprint());
					chiave.setNome(kp.getKeyName());
					return chiave;
				}).collect(Collectors.toList());
		
		return new ResponseEntity<List<ChiaveDTO>>(elenco, HttpStatus.OK);
	}
	
	@PostMapping("/keypairs")
	@Secured({AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.BOADMIN})
	@AzioneDispositiva
	public ResponseEntity<EsitoDTO> creaChiave (@RequestBody CreaChiaveRequestDTO  richiesta) throws BusinessException {
		CreateKeyPairRequestSchema body = new CreateKeyPairRequestSchema();
		CreateKeyPairRequestSchemaKeypair keypair = new CreateKeyPairRequestSchemaKeypair();
		keypair.setKeyName(richiesta.getNome());
		keypair.setNvlKeyPairType(NvlKeyPairTypeEnum.DEFAULTKEYPAIR);
		keypair.setOwnerId(SecurityUtils.getAccountIdCorrente());
		body.setKeypair(keypair);
		CreateKeyPairApiResponseSchema risposta = computeserviceApi.v10NwsComputeservicesKeypairCreatekeypairPost(body);
		HashMap<String, String> valoriAggiuntivi = new HashMap<>();
		valoriAggiuntivi.put("fingerprint", risposta.getCreateKeyPairResponse().getKeyFingerprint());
		valoriAggiuntivi.put("material", risposta.getCreateKeyPairResponse().getKeyMaterial());
		valoriAggiuntivi.put("nome", risposta.getCreateKeyPairResponse().getKeyName());
		valoriAggiuntivi.put("idRichiesta", risposta.getCreateKeyPairResponse().getRequestId());
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "Chiave creata correttamente", valoriAggiuntivi), HttpStatus.OK);
	}
	
	@PutMapping("/keypairs")
	@Secured({AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.BOADMIN})
	@AzioneDispositiva
	public ResponseEntity<EsitoDTO> importaChiave (@RequestBody CreaChiaveRequestDTO  richiesta) throws BusinessException {
		// 10.02.2020
		// Revisione servizio flusso di gestione chiave ricevuta.
		// 1. Si riceve una stringa con la parte pubblica della chiave SSH.
		
		// 2. Si richiama una funzione che "filtra" la stringa.
		String filtered = RSAUtils.filtraChiavePubblica(richiesta.getChiaveDaImportare());

		// 3. Si passa la chiave al servizio di creazione dopo avere effettuato la conversione Base64 
		ImportKeyPairRequestSchema body = new ImportKeyPairRequestSchema();
		ImportKeyPairRequestSchemaKeypair keypair = new ImportKeyPairRequestSchemaKeypair();
		keypair.setKeyName(richiesta.getNome());
		keypair.setNvlKeyPairType(it.csi.nivola.nivolasp.integration.rest.model.service.ImportKeyPairRequestSchemaKeypair.NvlKeyPairTypeEnum.DEFAULTKEYPAIR);
		keypair.setOwnerId(SecurityUtils.getAccountIdCorrente());
		
		// Encoding Base64 della chiave
		filtered = "ssh-rsa " + filtered;
		String encodeFiltered = Base64.getEncoder().encodeToString(filtered.getBytes());
		keypair.setPublicKeyMaterial(encodeFiltered);

		body.setKeypair(keypair);
		ImportKeyPairResponseSchema risposta = computeserviceApi.v10NwsComputeservicesKeypairImportkeypairPost(body);
		HashMap<String, String> valoriAggiuntivi = new HashMap<>();
		valoriAggiuntivi.put("fingerprint", risposta.getImportKeyPairResponse().getKeyFingerprint());
		valoriAggiuntivi.put("material", risposta.getImportKeyPairResponse().getRequestId());
		valoriAggiuntivi.put("nome", risposta.getImportKeyPairResponse().getKeyName());
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "Chiave importata correttamente"), HttpStatus.OK);
	}
		
	@DeleteMapping("/keypairs/{nomeChiave}")
	@Secured({AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.BOADMIN})
	@AzioneDispositiva
	public ResponseEntity<EsitoDTO> eliminaChiave (@PathVariable String nomeChiave) {
		DeleteKeyPairRequestSchema body = new DeleteKeyPairRequestSchema();
		body.setKeyName(nomeChiave);
		DeleteKeyPairResponseSchema risposta = computeserviceApi.v10NwsComputeservicesKeypairDeletekeypairDelete(body);
		Map<String, String> patametriAggiuntivi = new HashMap<>();
		patametriAggiuntivi.put("idRichiesta", risposta.getDeleteKeyPairResponse().getRequestId());
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "Chiave eliminata correttamente", patametriAggiuntivi), HttpStatus.OK );
	}
	
}
