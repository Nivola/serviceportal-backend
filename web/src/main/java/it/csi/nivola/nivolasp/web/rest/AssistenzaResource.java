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

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.csi.nivola.nivolasp.config.ApplicationProperties;
import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.security.SecurityUtils;
import it.csi.nivola.nivolasp.service.MailService;
import it.csi.nivola.nivolasp.service.dto.InvioEmail;
import it.csi.nivola.nivolasp.service.dto.UserDTO;

/**
 * REST controller for managing the current user's account.
 */
@RestController
@RequestMapping("/api")
public class AssistenzaResource extends AbstractResource {

//    private final Logger log = LoggerFactory.getLogger(AssistenzaResource.class);

    private MailService mailService;
    
    public AssistenzaResource(MailService mailService, ApplicationProperties applicationProperties) {
		this.mailService = mailService;
		this.applicationProperties = applicationProperties;
	}
    
    @SuppressWarnings("rawtypes")
	@PostMapping(path="/emailAssistenza")
    public ResponseEntity inviaEmail(@RequestBody InvioEmail parametri) throws BusinessException {
    	UserDTO utente = SecurityUtils.getCurrentUser();
    	if (StringUtils.isEmpty(parametri.getOggetto()))
    		throw new BusinessException("OGGETTO non puo' essere null");
    	
    	if (StringUtils.isEmpty(parametri.getMessaggio()))
    		throw new BusinessException("MESSAGGIO non puo' essere null");
    	
    			
    	mailService.sendEmail(utente.getEmail(), applicationProperties.getDeploy().getIndirizzoServizio(), parametri.getOggetto(), parametri.getMessaggio(), false, false);
    	return new ResponseEntity<>(HttpStatus.CREATED);
    	
    }
}
