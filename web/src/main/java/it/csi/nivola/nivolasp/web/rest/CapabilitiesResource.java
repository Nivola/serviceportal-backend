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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.csi.nivola.nivolasp.integration.rest.api.service.AuthorityApi;
import it.csi.nivola.nivolasp.integration.rest.model.service.AddAccountCapabilitiesRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.AddAccountCapabilitiesResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetAccountCapabilitiesResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetAccountCapabilitiesResponseSchemaCapabilities;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListAccountCapabilitiesResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListAccountCapabilitiesResponseSchemaCapabilities;
import it.csi.nivola.nivolasp.service.dto.CapabilitiesDTO;
import it.csi.nivola.nivolasp.service.dto.FiltroCapabilitiesDto;
import it.csi.nivola.nivolasp.service.dto.RichiestaCapabilityDTO;
import it.csi.nivola.nivolasp.service.mapper.CapabilitiesMapper;

/**
 * REST controller per la gestione delle capabilities da associare ad un account.
 * Restituisce l'elenco completo delle capabilities e permette di associare / disassociarle sull'account
 */
@RestController
@RequestMapping("/api")
public class CapabilitiesResource {
	
	private AuthorityApi authorityApi;

	private CapabilitiesMapper capabilitiesMapper;

    private final Logger log = LoggerFactory.getLogger(CapabilitiesResource.class);
    
    public CapabilitiesResource(AuthorityApi authorityApi, CapabilitiesMapper capabilitiesMapper) {
    	this.authorityApi = authorityApi;
    	this.capabilitiesMapper = capabilitiesMapper;
	}

    /**
     * Restituisce l'elenco delle capabilities eventualemtne filtrato.
     * @param filtro
     * @return
     */
    @GetMapping("/capabilities")
    
    public ResponseEntity<List<CapabilitiesDTO>> getElencoCapabilities(FiltroCapabilitiesDto filtro) {
    	log.debug(""+filtro);
    	if (filtro == null)
    		filtro = new FiltroCapabilitiesDto();
    	ListAccountCapabilitiesResponseSchema response = authorityApi.v10NwsCapabilitiesGet(-1, 0, null, null, null, filtro.getDataScadenzaDa(), filtro.getDataScadenzaA(), filtro.getDataModificaDa(), filtro.getDataModificaA(), filtro.getDataScadenzaDa(), filtro.getDataScadenzaA(), filtro.getName(), null, filtro.getVersion(), filtro.getActive(), filtro.getStatusId());
    	return new ResponseEntity<List<CapabilitiesDTO>>(capabilitiesMapper.toListCapabilitiesDTOs(response.getCapabilities()), HttpStatus.OK);
    	
    }
    

    /**
     * Associa una o piu' capabilities ad un account
     * @param uuidAccount
     * @param elencoUuidCapabilities
     * @return
    **/
	@PostMapping("/account/{uuidAccount}/capabilities")
    
    public ResponseEntity<HttpStatus> associaCapabilities(@PathVariable String uuidAccount, @RequestBody RichiestaCapabilityDTO uuidCapability) {
		log.debug("RICEVUTA CAPABILITY:" + uuidCapability);
		AddAccountCapabilitiesRequestSchema body = new AddAccountCapabilitiesRequestSchema();
		List<String> elencoUuidCapabilities = new ArrayList<>(1);
		elencoUuidCapabilities.add(uuidCapability.getUuidCapability());
		body.setCapabilities(elencoUuidCapabilities);
		AddAccountCapabilitiesResponseSchema risposta = authorityApi.v10NwsAccountsOidCapabilitiesPost(uuidAccount, body);
		log.debug(""+risposta.getTaskid());
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

	
	/**
	 * Restituisce l'elenco delle capabilities associato ad un account con relativo stato
	 * @param uuidAccount
	 * @param nomeCap
	 * @return
	 */
	@GetMapping("/account/{uuidAccount}/capabilities")
	public ResponseEntity<List<CapabilitiesDTO>> elencoCapabilitiesAccount(@PathVariable String uuidAccount, String nome) {
		
		
		ListAccountCapabilitiesResponseSchema elencoTutteCapabilities = authorityApi.v10NwsCapabilitiesGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		List<CapabilitiesDTO> capabilitiesConStatoAccount = new ArrayList<CapabilitiesDTO>(elencoTutteCapabilities.getCapabilities().size());
		
		GetAccountCapabilitiesResponseSchema capabilitiesAccount = authorityApi.v10NwsAccountsOidCapabilitiesGet(uuidAccount, nome);
		for (ListAccountCapabilitiesResponseSchemaCapabilities singolaCap : elencoTutteCapabilities.getCapabilities()) {
			CapabilitiesDTO singolaVoce = capabilitiesMapper.toCapabilitiesDTO(singolaCap);
			singolaVoce.setStatus(capabilitiesAccount.getCapabilities().stream().filter(e -> e.getName().equalsIgnoreCase(singolaCap.getName())).findFirst().orElse(new GetAccountCapabilitiesResponseSchemaCapabilities()).getStatus()); 
			singolaVoce.setAbilitataAccount(capabilitiesAccount.getCapabilities().stream().anyMatch(e -> e.getStatus().equalsIgnoreCase("ACTIVE") && e.getName().equalsIgnoreCase(singolaCap.getName())));
			capabilitiesConStatoAccount.add(singolaVoce);
		}
		
		return new ResponseEntity<List<CapabilitiesDTO>>(capabilitiesConStatoAccount, HttpStatus.OK);
    }
}
