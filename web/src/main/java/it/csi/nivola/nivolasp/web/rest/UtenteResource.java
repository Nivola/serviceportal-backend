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
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import it.csi.nivola.nivolasp.config.DecodificaRuoliCMP;
import it.csi.nivola.nivolasp.domain.SpUser;
import it.csi.nivola.nivolasp.domain.SpUserRuolo;
import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.integration.rest.api.auth.AuthorizationApi;
import it.csi.nivola.nivolasp.integration.rest.api.service.AuthorityApi;
import it.csi.nivola.nivolasp.integration.rest.api.service.PortalApi;
import it.csi.nivola.nivolasp.integration.rest.model.auth.ListUsersResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetUserRolesAndServicesResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetUserRolesAndServicesResponseSchemaServices;
import it.csi.nivola.nivolasp.security.AuthoritiesConstants;
import it.csi.nivola.nivolasp.security.AuthoritiesEnum;
import it.csi.nivola.nivolasp.security.SecurityUtils;
import it.csi.nivola.nivolasp.service.ServiceException;
import it.csi.nivola.nivolasp.service.UserService;
import it.csi.nivola.nivolasp.service.dto.AbilitazioneDTO;
import it.csi.nivola.nivolasp.service.dto.DatiSinteticiUtenteDto;
import it.csi.nivola.nivolasp.service.dto.DatiUtenteDTO;
import it.csi.nivola.nivolasp.service.dto.UserDTO;
import it.csi.nivola.nivolasp.service.mapper.UtenteMapper;
import it.csi.nivola.nivolasp.service.mapper.cmp.AbilitazioneMapper;
import it.csi.nivola.nivolasp.util.StreamingObjectUtil;

/**
 * REST controller for managing the current user's account.
 */
@RestController
@RequestMapping("/api")
public class UtenteResource {
	
	private UserService userService;
	
	private UtenteMapper utenteMapper;
	
	private AbilitazioneMapper abilitazioneMapper;
	
	private DecodificaRuoliCMP decodificaRuoliCMP;
	
	private AuthorizationApi authorizationApi;
	
	private AuthorityApi authorityApi;

    private Logger log = LoggerFactory.getLogger(UtenteResource.class);
    
    
    public UtenteResource(UserService userService, AuthorizationApi authorizationApi, UtenteMapper utenteMapper, PortalApi portalApi, AbilitazioneMapper abilitazioneMapper, DecodificaRuoliCMP decodificaRuoliCMP, AuthorityApi authorityApi) {
		this.userService = userService;
		this.utenteMapper = utenteMapper;
		this.abilitazioneMapper = abilitazioneMapper;
		this.decodificaRuoliCMP = decodificaRuoliCMP;
		this.authorizationApi = authorizationApi;
		this.authorityApi = authorityApi;
	}
    
    /**
     * GET  /authenticate : check if the user is authenticated, and return its login.
     *
     * @param request the HTTP request
     * @return the login if the user is authenticated
     */
    @GetMapping("/authenticate")
    public String isAuthenticated(HttpServletRequest request) {
        return request.getRemoteUser();
    }

    /**
     * GET  /account : get the current user.
     *
     * @return the ResponseEntity with status 200 (OK) and the current user in body, or status 500 (Internal Server Error) if the user couldn't be returned
     */
    @GetMapping("/account")
    public ResponseEntity<UserDTO> getAccount(HttpSession session) {
    	UserDTO daRestituire = SecurityUtils.getCurrentUser();
    	if (daRestituire == null || !daRestituire.isAttivo()) {
    		new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    	}
    	return ResponseEntity.ok(daRestituire);
    }
    
    /**
     * GET  /account : get the current user.
     *
     * @return the ResponseEntity with status 200 (OK) and the current user in body, or status 500 (Internal Server Error) if the user couldn't be returned
     */
    @GetMapping("/account/changeAbil")
    public ResponseEntity<Integer> getChangeAbil(Integer id) {
    	UserDTO daRestituire = SecurityUtils.getCurrentUser();
    	if (daRestituire == null) {
    		new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    	}
    	AbilitazioneDTO abil = daRestituire.getElencoAbilitazioni().stream().filter(p -> p.getId() ==id).findFirst()
    			.orElse(daRestituire.getElencoAbilitazioni().stream().findFirst().get());
    	log.debug("Cambio di abilitazione a : " + StreamingObjectUtil.streamObjectToJSON(abil));
    	daRestituire.setAbilitazioneSelezionata(abil);
    	return ResponseEntity.ok(abil.getId());
    }
    
    
    @PostMapping("/utente")
    @Secured(AuthoritiesConstants.BOADMIN)
    public ResponseEntity<Long> registraUtente(@RequestBody DatiUtenteDTO utenteDaInserire) throws BusinessException {
    	SpUser utenteRegistrato = userService.createUser(utenteDaInserire.getCognome(), utenteDaInserire.getCodiceFiscale(), utenteDaInserire.getEmail(),
    			BigInteger.valueOf(SecurityUtils.getCurrentUser().getId()), utenteDaInserire.getMatricolaCsi(), utenteDaInserire.getNome(), "", utenteDaInserire.getUsername(), utenteDaInserire.getRuoloBO(), utenteDaInserire.getAttivo(), "andrea.fontana@csi.it", utenteDaInserire.getUsaCredenziali(), utenteDaInserire.getUsaRemedy());
    	return ResponseEntity.ok(utenteRegistrato.getId());
    }
    
    @PostMapping("/utenteself")
    public ResponseEntity<Long> registrazioneUtenteGuest(@RequestBody DatiUtenteDTO utenteDaInserire) throws BusinessException {
    	SpUser utenteRegistrato = userService.createUser(
    			utenteDaInserire.getCognome(), 
    			utenteDaInserire.getCodiceFiscale(), 
    			utenteDaInserire.getEmail(),
    			SecurityUtils.getCurrentUser().getId() == null ? null : BigInteger.valueOf(SecurityUtils.getCurrentUser().getId()), 
    					utenteDaInserire.getMatricolaCsi(), utenteDaInserire.getNome(), "", utenteDaInserire.getUsername(), utenteDaInserire.getRuoloBO(), utenteDaInserire.getAttivo(), "andrea.fontana@csi.it", utenteDaInserire.getUsaCredenziali(), utenteDaInserire.getUsaRemedy());
    	return ResponseEntity.ok(utenteRegistrato.getId());
    }
    
    @PutMapping("/utente")
    @Secured(AuthoritiesConstants.BOADMIN)
    public ResponseEntity<Long> aggiornaUtente(@RequestBody DatiUtenteDTO utente) throws ServiceException {
    	SpUser utenteAggiornato = userService.updateUser(utente, SecurityUtils.getCurrentUser().getId());
    	return ResponseEntity.ok(utenteAggiornato.getId());
    }
    
    
    @DeleteMapping("/utente/{id}")
    @Secured(AuthoritiesConstants.BOADMIN)
    public ResponseEntity<Long> deleteUtente(@PathVariable(name="id" ) Long id) throws ServiceException {
    	SpUser utenteAggiornato = userService.deleteUser(id, SecurityUtils.getCurrentUser().getId());
    	return ResponseEntity.ok(utenteAggiornato.getId());
    }
    
    @GetMapping("/utente")
    @Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ACCOUNT_ADMIN})
    public ResponseEntity<Object> listAllUtenti(String cf) {
    	if (StringUtils.isEmpty(cf))
    		return new ResponseEntity<>(utenteMapper.spUsersToUserDtos(userService.getAll()), HttpStatus.OK);
    	else 
    		return new ResponseEntity<>(utenteMapper.spUserToUserDTO(userService.getUserBycf(cf)), HttpStatus.OK);
    }
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/utente/{id}")
    @Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ACCOUNT_ADMIN})
    public ResponseEntity<UserDTO> getUtentePerId(@PathVariable(name="id" ) Long id){
    	SpUser utenteDB = userService.getUserById(id);
    	UserDTO utenteRichiesto = utenteMapper.spUserToUserDTO(utenteDB);
    	if (utenteRichiesto == null) {
    		return new ResponseEntity("Utente con id " + id + " non trovato", HttpStatus.NOT_FOUND);
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
    	Timestamp current = new Timestamp(System.currentTimeMillis());
    	for (SpUserRuolo ruolo : utenteDB.getSpUserRuolos()) {
    		if (ruolo.getDataCancellazione() == null && (ruolo.getDataFineValidita() == null || ruolo.getDataFineValidita().compareTo(current) > 0)) {
	    		AbilitazioneDTO attuale = new AbilitazioneDTO();
	    		attuale.setUserRole(ruolo.getSpRuolo().getRuolo());
	    		attuale.setUserRoleDescription(AuthoritiesEnum.valueOf(ruolo.getSpRuolo().getRuolo()).getDescrizione());
	    		attuale.setProvenienteDaCmp(false);
	    		elencoAbilitazioni.add(attuale);
    		}
    	}
    	
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
			log.error("IMPOSSSIBILE OTTENERE LE ABILITAZIONI PER L'UTENTE " + utenteDB.getCmpUsername() + "- MOTIVO:", e);
		}
		if (response != null && response.getServices() != null)
		for (GetUserRolesAndServicesResponseSchemaServices singolo : response.getServices()) {
			if (singolo.getUserRole() != null) {
				AbilitazioneDTO account = abilitazioneMapper.serviceToAbilitazione(singolo);
				account.setUserRoleDescription(decodificaRuoliCMP.getDecodifica(singolo.getUserRole()));
				account.setId(abilitazione++);
				elencoAbilitazioni.add(account);
			}
		}
		return elencoAbilitazioni;
	}

	@GetMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
    	UserDTO daRestituire = SecurityUtils.getCurrentUser();
    	String urlLogout = daRestituire.getUrlLogout();
    	SecurityUtils.logout();
    	session.invalidate();
    	return ResponseEntity.ok(urlLogout);
    }
	
	@GetMapping("/user/suggest")
	public ResponseEntity<List<DatiSinteticiUtenteDto>> suggestUtenti (String startBy) {
		return new ResponseEntity<List<DatiSinteticiUtenteDto>>(userService.ricercaUtenteCognome(startBy), HttpStatus.OK);
	}
}
