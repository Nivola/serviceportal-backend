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

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.csi.nivola.nivolasp.security.AuthoritiesConstants;
import it.csi.nivola.nivolasp.service.LoggingAccessiService;
import it.csi.nivola.nivolasp.service.dto.LogAzioneDTO;

/**
 * Controller for view and managing Log Level at runtime.
 */
@RestController
@RequestMapping("/api")
public class ServerLogsResource extends AbstractResource {
	
	@Autowired
	LoggingAccessiService loggingAccessiService;

    @GetMapping("/logazione")
    
    @Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.DIVISION_ADMIN,  AuthoritiesConstants.ORGANIZATION_ADMIN})
    public List<LogAzioneDTO> elencoLogAzioneAccount(LogAzioneDTO filtro) {
		if(filtro == null || StringUtils.isEmpty(filtro.getAccount()))
			return loggingAccessiService.elencoLogAzioneCompleto();
		else
			return loggingAccessiService.elencoPerAccount(filtro.getAccount());
    }
    
       
}
