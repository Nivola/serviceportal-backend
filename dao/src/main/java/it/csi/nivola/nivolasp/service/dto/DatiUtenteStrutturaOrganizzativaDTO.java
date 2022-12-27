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


public class DatiUtenteStrutturaOrganizzativaDTO extends DatiUtenteDTO {

	private static final long serialVersionUID = -6656532251235483125L;

	private StrutturaOrganizzativaEnum strutturaOrganizzativa;
	
	public StrutturaOrganizzativaEnum getStrutturaOrganizzativa() {
		return strutturaOrganizzativa;
	}

	public void setStrutturaOrganizzativa(StrutturaOrganizzativaEnum strutturaOrganizzativa) {
		this.strutturaOrganizzativa = strutturaOrganizzativa;
	}
	

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
