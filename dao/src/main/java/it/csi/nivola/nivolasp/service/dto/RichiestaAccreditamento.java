/*-
 * ========================LICENSE_START=================================
 * Servizi di accesso dati
 * %%
 * Copyright (C) 2022 CSI Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | CSI Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.service.dto;

import java.io.Serializable;

/**
 * Body della richiesta si accreditamento.
 * Parametri:
 * - uuidUtente: uuid dell'utente che si desidera abilitare / revocare
 * - uuidAssegnazione: uuid dell'organizzazione/divisione/account al quale assegnare o revocare il ruolo
 * - ruolo: valori possibili: viewer, operator, master.
 * @author plaf
 *
 */
public class RichiestaAccreditamento implements Serializable {

	private static final long serialVersionUID = -9136579249049318403L;
	
	private String uuidUtente;
	private String uuidAssegnazione;
	private RuoloEnum ruolo;
	
	
	public String getUuidUtente() {
		return uuidUtente;
	}
	public void setUuidUtente(String uuidUtente) {
		this.uuidUtente = uuidUtente;
	}
	public String getUuidAssegnazione() {
		return uuidAssegnazione;
	}
	public void setUuidAssegnazione(String uuidAssegnazione) {
		this.uuidAssegnazione = uuidAssegnazione;
	}
	public RuoloEnum getRuolo() {
		return ruolo;
	}
	public void setRuolo(RuoloEnum ruolo) {
		this.ruolo = ruolo;
	}
	
	
}
