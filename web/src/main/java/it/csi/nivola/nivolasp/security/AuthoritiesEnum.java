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
package it.csi.nivola.nivolasp.security;

/**
 * Constants for Spring Security authorities.
 */
public enum AuthoritiesEnum {
	SUPERADMIN("Amministratore", "SUPERADMIN"), //superamm
	BOADMIN("Amministratore di backoffice", "BOADMIN"), //amm di bo
	MANUTENZIONE("Manutenzione", "MANUTENZIONE"), //amm di bo
	BOMONITORING("Monitoraggio", "BOMONITORING"),//da eliminare 
	ROLE_USER("Utente", "Utente"), //utente non di bo ma con cmp username
	ROLE_GUEST("Utente ospite", "Ospite"), //utente censito senza permessi sul portale ma non ha cmp username oppure il servizio di CMP non restituisce dati
	ANONYMOUS("Utente non censito", "Anonimo"), //non trovato del tutto
	ACTUATOR("Spring boot","Sprting boot"), //non trovato del tutto
	
	ACCOUNT_VIEWER("Viewer di Account", "AccountViewerRole"),
	ACCOUNT_OPERATOR("Operatore di Account", "AccountOperatorRole"),
	ACCOUNT_ADMIN("Master di Account", "AccountAdminRole"),
	DIVISION_VIEWER("Viewer di Division", "DivViewerRole"),
	DIVISION_OPERATOR("Operatore di Division", "DivOperatorRole"),
	DIVISION_ADMIN("Master di Division", "DivAdminRole"),
	ORGANIZATION_VIEWER("Viewer di Organization", "OrgViewerRole"),
	ORGANIZATION_OPERATOR("Operatore di Organization", "OrgOperatorRole"),
	ORGANIZATION_ADMIN("Master di Organization", "OrgAdminRole"),
	TICKETOPERATOR("Operatore segnalazioni", "operatore");
	
	private String descrizione;
	
	private String nomeVisualizzato;
    
    private AuthoritiesEnum(String descrizione, String etichetta) {
    	this.descrizione = descrizione;
    	this.nomeVisualizzato = etichetta;
    }

	public String getDescrizione() {
		return descrizione;
	}

	public String getNomeVisualizzato() {
		return nomeVisualizzato;
	}
    
    
}
