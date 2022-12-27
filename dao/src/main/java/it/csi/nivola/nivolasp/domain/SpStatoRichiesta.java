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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the sp_stato_richiesta database table.
 * 
 */
@Entity
@Table(name="sp_stato_richiesta")
@NamedQuery(name="SpStatoRichiesta.findAll", query="SELECT s FROM SpStatoRichiesta s")
public class SpStatoRichiesta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="data_richiesta")
	private Timestamp dataRichiesta;

	@Column(name="data_ultimo_stato")
	private Timestamp dataUltimoStato;

	@Column(name="stato_richiesta")
	private String statoRichiesta;

	@Column(name="tipo_richiesta")
	private String tipoRichiesta;

	@Column(name="uuid_richiesta")
	private String uuidRichiesta;
	
	@Column(name="uuid_organizzazione")
	private String uuidOrganizzazione;
	
	@Column(name="uuid_divisione")
	private String uuidDivisione;
	
	@Column(name="uuid_account")
	private String uuidAccount;

	//bi-directional many-to-one association to SpUser
	@ManyToOne
	@JoinColumn(name="sp_user_id")
	private SpUser spUser;

	public SpStatoRichiesta() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getDataRichiesta() {
		return this.dataRichiesta;
	}

	public void setDataRichiesta(Timestamp dataRichiesta) {
		this.dataRichiesta = dataRichiesta;
	}

	public Timestamp getDataUltimoStato() {
		return this.dataUltimoStato;
	}

	public void setDataUltimoStato(Timestamp dataUltimoStato) {
		this.dataUltimoStato = dataUltimoStato;
	}

	public String getStatoRichiesta() {
		return this.statoRichiesta;
	}

	public void setStatoRichiesta(String statoRichiesta) {
		this.statoRichiesta = statoRichiesta;
	}

	public String getTipoRichiesta() {
		return this.tipoRichiesta;
	}

	public void setTipoRichiesta(String tipoRichiesta) {
		this.tipoRichiesta = tipoRichiesta;
	}

	public String getUuidRichiesta() {
		return this.uuidRichiesta;
	}

	public void setUuidRichiesta(String uuidRichiesta) {
		this.uuidRichiesta = uuidRichiesta;
	}

	public SpUser getSpUser() {
		return this.spUser;
	}

	public void setSpUser(SpUser spUser) {
		this.spUser = spUser;
	}

	public String getUuidOrganizzazione() {
		return uuidOrganizzazione;
	}

	public void setUuidOrganizzazione(String uuidOrganizzazione) {
		this.uuidOrganizzazione = uuidOrganizzazione;
	}

	public String getUuidDivisione() {
		return uuidDivisione;
	}

	public void setUuidDivisione(String uuidDivisione) {
		this.uuidDivisione = uuidDivisione;
	}

	public String getUuidAccount() {
		return uuidAccount;
	}

	public void setUuidAccount(String uuidAccount) {
		this.uuidAccount = uuidAccount;
	}
	
	

}
