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
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.csi.nivola.nivolasp.aop.logging.AzioneDispositiva;
import it.csi.nivola.nivolasp.config.DecodificaRuoliCMP;
import it.csi.nivola.nivolasp.domain.SpUser;
import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.integration.rest.api.auth.AuthorizationApi;
import it.csi.nivola.nivolasp.integration.rest.api.service.AuthorityApi;
import it.csi.nivola.nivolasp.integration.rest.model.auth.ListUsersResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetUserRolesAndServicesResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetUserRolesAndServicesResponseSchemaServices;
import it.csi.nivola.nivolasp.integration.rest.model.service.SetAccountUsersRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.SetAccountUsersRequestSchemaUser;
import it.csi.nivola.nivolasp.integration.rest.model.service.SetAccountUsersRequestSchemaUser.RoleEnum;
import it.csi.nivola.nivolasp.integration.rest.model.service.SetDivisionUsersRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.SetOrganizationUsersRequestSchema;
import it.csi.nivola.nivolasp.security.AuthoritiesConstants;
import it.csi.nivola.nivolasp.security.SecurityUtils;
import it.csi.nivola.nivolasp.service.UserService;
import it.csi.nivola.nivolasp.service.dto.AbilitazioneDTO;
import it.csi.nivola.nivolasp.service.dto.DatiUtenteStrutturaOrganizzativaDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoEnum;
import it.csi.nivola.nivolasp.service.dto.UserDTO;
import it.csi.nivola.nivolasp.service.mapper.UtenteMapper;
import it.csi.nivola.nivolasp.service.mapper.cmp.AbilitazioneMapper;

/**
 * REST controller per la gestione degli accreditamenti, associazione ruolo per organizzazione, divisione e account
 */
@RestController
@RequestMapping("/api")
public class AdminStrutturaOrganizzativaResource {
	
	@Autowired
	AuthorityApi authorityApi;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UtenteMapper utenteMapper;
	
	@Autowired
	AuthorizationApi authorizationApi;
	
	@Autowired
	AbilitazioneMapper abilitazioneMapper;
	
	@Autowired
	DecodificaRuoliCMP decodificaRuoliCMP;

	@SuppressWarnings("unused")
	private final Logger log = LoggerFactory.getLogger(AdminStrutturaOrganizzativaResource.class);
    /**
     * Gestisce la creazione dell'utente, se non presente, e l'accreditamento da parte dei master di struttura organizzativa
     * @param utenteConAccreditamento
     * @return
     * @throws BusinessException
     */
    @PostMapping("/utentestruttura")
    
    @Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.ACCOUNT_ADMIN})
    @AzioneDispositiva
    public ResponseEntity<EsitoDTO> accreditaSuOrganizzazione(@RequestBody DatiUtenteStrutturaOrganizzativaDTO utenteConAccreditamento) throws BusinessException {
    	
    	if (utenteConAccreditamento.getRuolo() == null) {
    		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.KO, "9999", "nessun ruolo specificato per l'accreditamento"),HttpStatus.BAD_REQUEST);
    	}
    	if (StringUtils.isEmpty(utenteConAccreditamento.getCodiceFiscale())) {
    		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.KO, "9999", "codice fiscale utente mancante"),HttpStatus.BAD_REQUEST);
    	}
    	
    	SpUser utente = userService.getUserBycf(utenteConAccreditamento.getCodiceFiscale());
    	
    	if (utente == null) {
    		utente = userService.createUser(utenteConAccreditamento.getCognome(), utenteConAccreditamento.getCodiceFiscale(), utenteConAccreditamento.getEmail(),
        			BigInteger.valueOf(SecurityUtils.getCurrentUser().getId()), utenteConAccreditamento.getMatricolaCsi(), utenteConAccreditamento.getNome(), "", utenteConAccreditamento.getUsername(), utenteConAccreditamento.getRuoloBO(), utenteConAccreditamento.getAttivo(), "andrea.fontana@csi.it", utenteConAccreditamento.getUsaCredenziali(), utenteConAccreditamento.getUsaRemedy());
    	
    	} else if (StringUtils.isEmpty(utente.getCmpUsername())) {
    		
    		utente.setCmpUsername(
    				StringUtils.isNotEmpty(utenteConAccreditamento.getMatricolaCsi()) 
    						? utenteConAccreditamento.getMatricolaCsi()+"@domnt.csi.it" 
    						: utenteConAccreditamento.getCodiceFiscale()+"@portal");
    		utente = userService.creazioneUtentePressoCMP(utente);
    	}
    	
		SetAccountUsersRequestSchemaUser user = componiRichiestaAccreditamento(utenteConAccreditamento, utente.getUuidUtente());
		switch (utenteConAccreditamento.getStrutturaOrganizzativa()) {
			case ACCOUNT:
				SetAccountUsersRequestSchema impostaRuoloUtenteAccount = new SetAccountUsersRequestSchema();
				impostaRuoloUtenteAccount.setUser(user);
				authorityApi.v10NwsAccountsOidUsersPost(utenteConAccreditamento.getUuidAssegnazione(), impostaRuoloUtenteAccount);
				break;
			case DIVISION:
				SetDivisionUsersRequestSchema impostaRuoloUtenteDivisione = new SetDivisionUsersRequestSchema();
				impostaRuoloUtenteDivisione.setUser(user);
				authorityApi.v10NwsDivisionsOidUsersPost(utenteConAccreditamento.getUuidAssegnazione(), impostaRuoloUtenteDivisione);
				break;
			case ORGANIZATION:
				SetOrganizationUsersRequestSchema impostaRuoloUtente = new SetOrganizationUsersRequestSchema();
				impostaRuoloUtente.setUser(user);
				authorityApi.v10NwsOrganizationsOidUsersPost(utenteConAccreditamento.getUuidAssegnazione(), impostaRuoloUtente);
				break;
			case BACKOFFICE:
	    		throw new BusinessException("Operazione non supportata");
				
		}
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "Utente creato correttamente"), HttpStatus.OK);

    }
    
    @PostMapping("/utentestruttura/{id}")
    
    @Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.ACCOUNT_ADMIN})
    public ResponseEntity<UserDTO> getUtentePerId(@PathVariable(name="id" ) Long id) throws BusinessException{
    	SpUser utenteDB = userService.getUserById(id);
    	UserDTO utenteRichiesto = utenteMapper.spUserToUserDTO(utenteDB);
    	if (utenteRichiesto == null) {
    		throw new BusinessException("Utente con id " + id + " non trovato");
    	}
    	if (StringUtils.isNoneEmpty( utenteRichiesto.getCmpUsername())) {
    		try {
    			ListUsersResponseSchema response = authorizationApi.v10NasUsersGet(null, null, utenteRichiesto.getCmpUsername(), null , null, null, null, null ,null ,null,null, 0, 10);
    			if (response != null && !CollectionUtils.isEmpty(response.getUsers())) {
    				utenteRichiesto.setUuidUtente(response.getUsers().get(0).getUuid());
    			}
    		} catch (Exception e) {
    			//utente non trovato, non imposto l'uuid
    		}
    		
    	}
		
    	Set<AbilitazioneDTO> elencoAbilitazioni = new HashSet<AbilitazioneDTO>();
    	    	
    	if (utenteDB.getCmpUsername() != null) {
	    	elencoAbilitazioni = decodificaRuoliCMP(utenteDB, elencoAbilitazioni);
    	}
    	
		utenteRichiesto.setElencoAbilitazioni(elencoAbilitazioni);
		return new ResponseEntity<UserDTO>(utenteRichiesto, HttpStatus.OK);
    }
    
    private Set<AbilitazioneDTO> decodificaRuoliCMP(SpUser utenteDB, Set<AbilitazioneDTO> elencoAbilitazioni) {
		GetUserRolesAndServicesResponseSchema response = null;
		int abilitazione = 1;
		try {
			response = authorityApi.v10NwsServicesObjectsFilterByusernameGet(utenteDB.getCmpUsername());
		} catch (Exception e) {
			
		}
		if (response != null && response.getServices() != null)
		for (GetUserRolesAndServicesResponseSchemaServices singolo : response.getServices()) {
			if (singolo.getUserRole() != null && singolo.getUserRole().contains("Admin")) {
				AbilitazioneDTO account = abilitazioneMapper.serviceToAbilitazione(singolo);
				account.setUserRoleDescription(decodificaRuoliCMP.getDecodifica(singolo.getUserRole()));
				account.setId(abilitazione++);
				elencoAbilitazioni.add(account);
			}
		}
		return elencoAbilitazioni;
	}

	private SetAccountUsersRequestSchemaUser componiRichiestaAccreditamento(DatiUtenteStrutturaOrganizzativaDTO utenteConAccreditamento, String uuid) {
		SetAccountUsersRequestSchemaUser user = new SetAccountUsersRequestSchemaUser();
		user.setRole(RoleEnum.fromValue(utenteConAccreditamento.getRuolo().getValue()));
		user.setUserId(uuid);
		return user;
	}
}
