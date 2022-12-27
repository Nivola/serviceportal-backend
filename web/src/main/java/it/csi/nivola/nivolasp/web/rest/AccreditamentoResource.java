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

import java.math.BigInteger;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.csi.nivola.nivolasp.aop.logging.AzioneDispositiva;
import it.csi.nivola.nivolasp.domain.SpRuolo;
import it.csi.nivola.nivolasp.domain.SpUser;
import it.csi.nivola.nivolasp.domain.SpUserRuolo;
import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.integration.rest.api.service.AuthorityApi;
import it.csi.nivola.nivolasp.integration.rest.model.service.SetAccountUsersRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.SetAccountUsersRequestSchemaUser;
import it.csi.nivola.nivolasp.integration.rest.model.service.SetAccountUsersRequestSchemaUser.RoleEnum;
import it.csi.nivola.nivolasp.integration.rest.model.service.SetDivisionUsersRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.SetOrganizationUsersRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.UnsetAccountUsersRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.UnsetDivisionUsersRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.UnsetOrganizationUsersRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.UnsetOrganizationUsersRequestSchemaUser;
import it.csi.nivola.nivolasp.security.AuthoritiesConstants;
import it.csi.nivola.nivolasp.security.SecurityUtils;
import it.csi.nivola.nivolasp.service.UserService;
import it.csi.nivola.nivolasp.service.dto.RichiestaAccreditamento;
import it.csi.nivola.nivolasp.service.dto.RuoloDTO;

/**
 * REST controller per la gestione degli accreditamenti, associazione ruolo per organizzazione, divisione e account
 */
@RestController
@RequestMapping("/api")
public class AccreditamentoResource {
	
	AuthorityApi authorityApi;
	
	UserService userService;

    private final Logger log = LoggerFactory.getLogger(AccreditamentoResource.class);
    
    public AccreditamentoResource(AuthorityApi authorityApi, UserService userService) {
    	this.authorityApi = authorityApi;
    	this.userService = userService;
	}
    /**
     * Esegue l'accreditamento sull'organizzazione
     * @param parametri
     * @return
     */
    @PostMapping("/accreditamento/organizzazione")
    
    @Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, AuthoritiesConstants.ORGANIZATION_OPERATOR})
    @AzioneDispositiva
    public ResponseEntity<String> accreditaSuOrganizzazione(@RequestBody RichiestaAccreditamento parametri) {
    	if (parametri.getRuolo() == null) {
    		return new ResponseEntity<String>("Ruolo non specificato o non valido",HttpStatus.BAD_REQUEST);
    	}
    	if (StringUtils.isEmpty(parametri.getUuidAssegnazione())) {
    		return new ResponseEntity<String>("Uuid di assegnazione mancante",HttpStatus.BAD_REQUEST);
    	}
    	if (StringUtils.isEmpty(parametri.getUuidUtente())) {
    		return new ResponseEntity<String>("Uuid utente mancante",HttpStatus.BAD_REQUEST);
    	}
    	
    	SetOrganizationUsersRequestSchema impostaRuoloUtente = new SetOrganizationUsersRequestSchema();
		SetAccountUsersRequestSchemaUser user = new SetAccountUsersRequestSchemaUser();
		user.setRole(RoleEnum.fromValue(parametri.getRuolo().getValue()));
		user.setUserId(parametri.getUuidUtente());
		impostaRuoloUtente.setUser(user);
		authorityApi.v10NwsOrganizationsOidUsersPost(parametri.getUuidAssegnazione(), impostaRuoloUtente);
		
		return new ResponseEntity<String>("",HttpStatus.OK);
    }
    
    
    /**
     * Effettua l'accreditamento sulla divisione
     * @param parametri
     * @return
     */
    @PostMapping("/accreditamento/divisione")
    
    @Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, AuthoritiesConstants.ORGANIZATION_OPERATOR, AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR})
    @AzioneDispositiva
    public ResponseEntity<String> accreditaSuDivisione(@RequestBody RichiestaAccreditamento parametri) {
    	if (parametri.getRuolo() == null) {
    		return new ResponseEntity<String>("Ruolo non specificato o non valido",HttpStatus.BAD_REQUEST);
    	}
    	if (StringUtils.isEmpty(parametri.getUuidAssegnazione())) {
    		return new ResponseEntity<String>("Uuid di assegnazione mancante",HttpStatus.BAD_REQUEST);
    	}
    	if (StringUtils.isEmpty(parametri.getUuidUtente())) {
    		return new ResponseEntity<String>("Uuid utente mancante",HttpStatus.BAD_REQUEST);
    	}
    	
    	SetDivisionUsersRequestSchema impostaRuoloUtente = new SetDivisionUsersRequestSchema();
		SetAccountUsersRequestSchemaUser user = new SetAccountUsersRequestSchemaUser();
		user.setRole(RoleEnum.fromValue(parametri.getRuolo().getValue()));
		user.setUserId(parametri.getUuidUtente());
		impostaRuoloUtente.setUser(user);
		authorityApi.v10NwsDivisionsOidUsersPost(parametri.getUuidAssegnazione(), impostaRuoloUtente);
    	
    	return new ResponseEntity<String>("",HttpStatus.OK);
    }
    
    
    /**
     * Effettua l'accreditamento sull'account
     * @param parametri
     * @return
     */
    @PostMapping("/accreditamento/account")
    
    @Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, AuthoritiesConstants.ORGANIZATION_OPERATOR, AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR})
    @AzioneDispositiva
    public ResponseEntity<String> accreditaSuAccount(@RequestBody RichiestaAccreditamento parametri) {
    	if (parametri.getRuolo() == null) {
    		return new ResponseEntity<String>("Ruolo non specificato o non valido",HttpStatus.BAD_REQUEST);
    	}
    	if (StringUtils.isEmpty(parametri.getUuidAssegnazione())) {
    		return new ResponseEntity<String>("Uuid di assegnazione mancante",HttpStatus.BAD_REQUEST);
    	}
    	if (StringUtils.isEmpty(parametri.getUuidUtente())) {
    		return new ResponseEntity<String>("Uuid utente mancante",HttpStatus.BAD_REQUEST);
    	}
    	
    	SetAccountUsersRequestSchema impostaRuoloUtente = new SetAccountUsersRequestSchema();
		SetAccountUsersRequestSchemaUser user = new SetAccountUsersRequestSchemaUser();
		user.setRole(RoleEnum.fromValue(parametri.getRuolo().getValue()));
		user.setUserId(parametri.getUuidUtente());
		impostaRuoloUtente.setUser(user);
		authorityApi.v10NwsAccountsOidUsersPost(parametri.getUuidAssegnazione(), impostaRuoloUtente);
		
    	return new ResponseEntity<String>("",HttpStatus.OK);
    }
    
    @PostMapping("/utente/{id}/ruolo")
    
    @Secured(AuthoritiesConstants.BOADMIN)
    @AzioneDispositiva
    public ResponseEntity<String> assegnaRuoloPortale(@PathVariable String id, @RequestBody RuoloDTO parametri) throws BusinessException {
    	
    	SpUser utente = userService.getUserByUuid(id);
    	if (utente == null)
    		utente = userService.getUserById(Long.parseLong(id));
    	if (utente == null)
    		throw new BusinessException("Utente con id " + id + " non trovato in anagrafica");
    	
    	SpRuolo ruolo = userService.getRuoloById(parametri.getRuolo());
    	if (ruolo == null)
    		throw new BusinessException("Ruolo " + parametri.getRuolo() + " inesistente");
    	
    	SpUserRuolo associazione = new SpUserRuolo();
    	associazione.setIdAgente(BigInteger.valueOf(SecurityUtils.getCurrentUser().getId()));
    	associazione.setSpRuolo(ruolo);
    	associazione.setSpUser(utente);
    	
    	associazione = userService.associaRuolo(associazione);
    	
    	return new ResponseEntity<String>(associazione.getId(), HttpStatus.OK);
    }
    
    
    @DeleteMapping("/utente/{id}/ruolo/{ruolo}")
    
    @Secured(AuthoritiesConstants.BOADMIN)
    @AzioneDispositiva
    public ResponseEntity<String> eliminaRuoloPortale(@PathVariable String id, @PathVariable String ruolo) {
    	
    	if (ruolo == null)
    		return new ResponseEntity<String>("Ruolo " + ruolo + " inesistente", HttpStatus.BAD_REQUEST);
    	
    	SpUser utente = userService.getUserByUuid(id);
    	if (utente == null)
    		return new ResponseEntity<String>("Utente con id " + id + " non trovato in anagrafica", HttpStatus.BAD_REQUEST);
    	
    	
    	userService.eliminaRuolo(utente.getId(), ruolo);
    	
    	
    	return new ResponseEntity<String>("", HttpStatus.OK);
    }
    
    
    /**
     * Revoca l'accreditamento sull'organizzazione
     * @param parametri
     * @return
     */
    @DeleteMapping("/organizzazione/{uuidUnit}/utente/{uuidUtente}/ruolo/{ruolo}")
    
    @Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, AuthoritiesConstants.ORGANIZATION_OPERATOR})
    @AzioneDispositiva
    public ResponseEntity<String> revocaSuOrganizzazione(@PathVariable String uuidUnit, @PathVariable String uuidUtente, @PathVariable String ruolo) {
    	log.debug("entrato in delete");
    	if (ruolo == null) {
    		return new ResponseEntity<String>("Ruolo non specificato o non valido",HttpStatus.BAD_REQUEST);
    	}
    	if (StringUtils.isEmpty(uuidUnit)) {
    		return new ResponseEntity<String>("Uuid di assegnazione mancante",HttpStatus.BAD_REQUEST);
    	}
    	if (StringUtils.isEmpty(uuidUtente)) {
    		return new ResponseEntity<String>("Uuid utente mancante",HttpStatus.BAD_REQUEST);
    	}
    	
    	UnsetOrganizationUsersRequestSchema impostaRuoloUtente = new UnsetOrganizationUsersRequestSchema();
    	UnsetOrganizationUsersRequestSchemaUser user = new UnsetOrganizationUsersRequestSchemaUser();
		user.setUserId(uuidUtente);
		user.setRole(it.csi.nivola.nivolasp.integration.rest.model.service.UnsetOrganizationUsersRequestSchemaUser.RoleEnum.fromValue(ruolo));
		impostaRuoloUtente.setUser(user);
		authorityApi.v10NwsOrganizationsOidUsersDelete(uuidUnit, impostaRuoloUtente);
		
    	return new ResponseEntity<String>("",HttpStatus.OK);
    }
    
    
    /**
     * Revoca l'accreditamento sulla divisione
     * @param parametri
     * @return
     */
    @DeleteMapping("/divisione/{uuidUnit}/utente/{uuidUtente}/ruolo/{ruolo}")
    
    @Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, AuthoritiesConstants.ORGANIZATION_OPERATOR, AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR})
    @AzioneDispositiva
    public ResponseEntity<String> revocaSuDivisione(@PathVariable String uuidUnit, @PathVariable String uuidUtente, @PathVariable String ruolo) {
    	if (StringUtils.isEmpty(ruolo)) {
    		return new ResponseEntity<String>("Ruolo non specificato o non valido",HttpStatus.BAD_REQUEST);
    	}
    	if (StringUtils.isEmpty(uuidUnit)) {
    		return new ResponseEntity<String>("Uuid di assegnazione mancante",HttpStatus.BAD_REQUEST);
    	}
    	if (StringUtils.isEmpty(uuidUtente)) {
    		return new ResponseEntity<String>("Uuid utente mancante",HttpStatus.BAD_REQUEST);
    	}
    	UnsetDivisionUsersRequestSchema impostaRuoloUtente = new UnsetDivisionUsersRequestSchema();
		SetAccountUsersRequestSchemaUser user = new SetAccountUsersRequestSchemaUser();
		user.setUserId(uuidUtente);
		user.setRole(RoleEnum.fromValue(ruolo));
		impostaRuoloUtente.setUser(user);
		authorityApi.v10NwsDivisionsOidUsersDelete(uuidUnit, impostaRuoloUtente);
    	
    	return new ResponseEntity<String>("",HttpStatus.OK);
    }
    
    
    /**
     * Revoca l'accreditamento sull'account
     * @param parametri
     * @return
     */
    @DeleteMapping("/accountcmp/{uuidUnit}/utente/{uuidUtente}/ruolo/{ruolo}")
    
    @Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, AuthoritiesConstants.ORGANIZATION_OPERATOR, AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR})
    @AzioneDispositiva
    public ResponseEntity<String> revocaSuAccount(@PathVariable String uuidUnit, @PathVariable String uuidUtente, @PathVariable String ruolo) {
    	if (StringUtils.isEmpty(ruolo)) {
    		return new ResponseEntity<String>("Ruolo non specificato o non valido",HttpStatus.BAD_REQUEST);
    	}
    	if (StringUtils.isEmpty(uuidUnit)) {
    		return new ResponseEntity<String>("Uuid di assegnazione mancante",HttpStatus.BAD_REQUEST);
    	}
    	if (StringUtils.isEmpty(uuidUtente)) {
    		return new ResponseEntity<String>("Uuid utente mancante",HttpStatus.BAD_REQUEST);
    	}
    	
    	UnsetAccountUsersRequestSchema impostaRuoloUtente = new UnsetAccountUsersRequestSchema();
		SetAccountUsersRequestSchemaUser utente = new SetAccountUsersRequestSchemaUser();
		utente.setUserId(uuidUtente);
		utente.setRole(RoleEnum.fromValue(ruolo));
		impostaRuoloUtente.setUser(utente);
		authorityApi.v10NwsAccountsOidUsersDelete(uuidUnit, impostaRuoloUtente);
		
    	return new ResponseEntity<String>("",HttpStatus.OK);
    }
}
