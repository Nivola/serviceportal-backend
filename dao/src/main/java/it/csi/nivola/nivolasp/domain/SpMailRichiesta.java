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
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the sp_mail_richiesta database table.
 * 
 */
@Entity
@Table(name="sp_mail_richiesta")
@NamedQuery(name="SpMailRichiesta.findAll", query="SELECT s FROM SpMailRichiesta s")
public class SpMailRichiesta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="data_richiesta")
	private Date dataRichiesta;

	private String oggetto;

	@Column(name="ref_account")
	private String refAccount;

	private String testo;

	//bi-directional many-to-one association to SpDTipoEvento
	@ManyToOne
	@JoinColumn(name="id_tipo_richiesta")
	private SpDTipoEvento spDTipoEvento;

	//bi-directional many-to-one association to SpUser
	@ManyToOne
	@JoinColumn(name="id_utente")
	private SpUser spUser;

	public SpMailRichiesta() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataRichiesta() {
		return this.dataRichiesta;
	}

	public void setDataRichiesta(Date dataRichiesta) {
		this.dataRichiesta = dataRichiesta;
	}

	public String getOggetto() {
		return this.oggetto;
	}

	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}

	public String getRefAccount() {
		return this.refAccount;
	}

	public void setRefAccount(String refAccount) {
		this.refAccount = refAccount;
	}

	public String getTesto() {
		return this.testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public SpDTipoEvento getSpDTipoEvento() {
		return this.spDTipoEvento;
	}

	public void setSpDTipoEvento(SpDTipoEvento spDTipoEvento) {
		this.spDTipoEvento = spDTipoEvento;
	}

	public SpUser getSpUser() {
		return this.spUser;
	}

	public void setSpUser(SpUser spUser) {
		this.spUser = spUser;
	}

}
