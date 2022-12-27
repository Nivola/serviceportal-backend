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
package it.csi.nivola.nivolasp.config;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import it.csi.nivola.nivolasp.integration.rest.api.service.PortalApi;

@Component
@Scope(value = "singleton")
public class DecodificaRuoliCMP {
	
	private final Logger log = LoggerFactory.getLogger(DecodificaRuoliCMP.class);
	
//	private PortalApi portalApi;
	
	private Map<String,String> mappaRuoli = null;
	
	public DecodificaRuoliCMP(PortalApi api) {
		try {
			prepareDefault();
			/*this.portalApi = api;/*
			ListPortalRolesResponseSchema response = portalApi.v10NwsRolesListportaldescriptionGet();
			mappaRuoli = response.getRoles().stream().collect(Collectors.toMap(ListPortalRolesResponseSchemaRoles::getName,
				ListPortalRolesResponseSchemaRoles::getDescSp));*/
		} catch (Exception e) {
			log.error("IMPOSSIBILE DECODIFICARE I RUOLI DALLA CMP: ", e);
		}
	}
	
	
	
	private void prepareDefault() {
		mappaRuoli = new HashMap<String,String>();
		mappaRuoli.put("AccountViewerRole", "Viewer di Account");
		mappaRuoli.put("AccountOperatorRole", "Operatore di Account");
		mappaRuoli.put("AccountAdminRole", "Master di Account");
		mappaRuoli.put("DivViewerRole", "Viewer di Division");
		mappaRuoli.put("DivOperatorRole", "Operatore di Division");
		mappaRuoli.put("DivAdminRole", "Master di Division");
		mappaRuoli.put("OrgViewerRole", "Viewer di Organization");
		mappaRuoli.put("OrgOperatorRole", "Operatore di Organization");
		mappaRuoli.put("OrgAdminRole", "Master di Organization");
	}



	public String getDecodifica(String ruolo) {
		return mappaRuoli.get(ruolo);
	}

}
