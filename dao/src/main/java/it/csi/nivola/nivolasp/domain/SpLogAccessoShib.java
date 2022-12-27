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
import javax.persistence.Table;


/**
 * The persistent class for the sp_log_accesso_shib database table.
 * 
 */
@Entity
@Table(name="sp_log_accesso_shib")
//@NamedQuery(name="SpLogAccessoShib.findAll", query="SELECT s FROM SpLogAccessoShib s")
public class SpLogAccessoShib implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="codice_fiscale")
	private String codiceFiscale;

	private String cognome;

	@Column(name="comunita_shib")
	private String comunitaShib;

	@Column(name="data_accesso")
	private Timestamp dataAccesso;

	private String nome;

	public SpLogAccessoShib() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodiceFiscale() {
		return this.codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getComunitaShib() {
		return this.comunitaShib;
	}

	public void setComunitaShib(String comunitaShib) {
		this.comunitaShib = comunitaShib;
	}

	public Timestamp getDataAccesso() {
		return this.dataAccesso;
	}

	public void setDataAccesso(Timestamp dataAccesso) {
		this.dataAccesso = dataAccesso;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
