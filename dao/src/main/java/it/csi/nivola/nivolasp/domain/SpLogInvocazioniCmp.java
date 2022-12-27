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
package it.csi.nivola.nivolasp.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the sp_log_invocazioni_cmp database table.
 * 
 */
@Entity
@Table(name="sp_log_invocazioni_cmp")
@NamedQuery(name="SpLogInvocazioniCmp.findAll", query="SELECT s FROM SpLogInvocazioniCmp s")
public class SpLogInvocazioniCmp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Lob
	@Column(name="body_richiesta")
	private String bodyRichiesta;

	@Lob
	@Column(name="body_risposta")
	private String bodyRisposta;

	@Column(name="data_invocazione")
	private Timestamp dataInvocazione;

	private String esito;

	@Lob
	@Column(name="headers_richiesta")
	private String headersRichiesta;

	@Lob
	@Column(name="headers_risposta")
	private String headersRisposta;

	@Column(name="http_code")
	private String httpCode;

	@Column(name="http_code_description")
	private String httpCodeDescription;

	private String metodo;

	@Column(name="servizio_invocato")
	private String servizioInvocato;

	//bi-directional many-to-one association to SpUser
	@ManyToOne
	@JoinColumn(name="sp_user_id")
	private SpUser spUser;

	public SpLogInvocazioniCmp() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBodyRichiesta() {
		return this.bodyRichiesta;
	}

	public void setBodyRichiesta(String bodyRichiesta) {
		this.bodyRichiesta = bodyRichiesta;
	}

	public String getBodyRisposta() {
		return this.bodyRisposta;
	}

	public void setBodyRisposta(String bodyRisposta) {
		this.bodyRisposta = bodyRisposta;
	}

	public Timestamp getDataInvocazione() {
		return this.dataInvocazione;
	}

	public void setDataInvocazione(Timestamp dataInvocazione) {
		this.dataInvocazione = dataInvocazione;
	}

	public String getEsito() {
		return this.esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public String getHeadersRichiesta() {
		return this.headersRichiesta;
	}

	public void setHeadersRichiesta(String headersRichiesta) {
		this.headersRichiesta = headersRichiesta;
	}

	public String getHeadersRisposta() {
		return this.headersRisposta;
	}

	public void setHeadersRisposta(String headersRisposta) {
		this.headersRisposta = headersRisposta;
	}

	public String getHttpCode() {
		return this.httpCode;
	}

	public void setHttpCode(String httpCode) {
		this.httpCode = httpCode;
	}

	public String getHttpCodeDescription() {
		return this.httpCodeDescription;
	}

	public void setHttpCodeDescription(String httpCodeDescription) {
		this.httpCodeDescription = httpCodeDescription;
	}

	public String getMetodo() {
		return this.metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public String getServizioInvocato() {
		return this.servizioInvocato;
	}

	public void setServizioInvocato(String servizioInvocato) {
		this.servizioInvocato = servizioInvocato;
	}

	public SpUser getSpUser() {
		return this.spUser;
	}

	public void setSpUser(SpUser spUser) {
		this.spUser = spUser;
	}

}
