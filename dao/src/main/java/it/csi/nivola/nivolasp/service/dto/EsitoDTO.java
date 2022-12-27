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
import java.util.Map;

public class EsitoDTO implements Serializable{

	private static final long serialVersionUID = 7091274977403810628L;

	private EsitoEnum esito;
	
	private String codice;
	
	private String message;
	
	private Map<String, String> valoriAggiuntivi;

	public EsitoDTO(EsitoEnum esito, String codice, String messaggio) {
		super();
		this.esito = esito;
		this.codice = codice;
		this.message = messaggio;
	}
	public EsitoDTO(EsitoEnum esito, String codice, String messaggio, Map<String, String> valoriAggiuntivi) {
		super();
		this.esito = esito;
		this.codice = codice;
		this.message = messaggio;
		this.valoriAggiuntivi = valoriAggiuntivi;
	}

	public EsitoEnum getEsito() {
		return esito;
	}

	public void setEsito(EsitoEnum esito) {
		this.esito = esito;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String messaggio) {
		this.message = messaggio;
	}
	public Map<String, String> getValoriAggiuntivi() {
		return valoriAggiuntivi;
	}
	public void setValoriAggiuntivi(Map<String, String> valoriAggiuntivi) {
		this.valoriAggiuntivi = valoriAggiuntivi;
	}
	
	
}
