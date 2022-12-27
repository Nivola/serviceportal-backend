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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the sp_organizzazione_attributo database table.
 * 
 */
@Entity
@Table(name="sp_organizzazione_attributo")
@NamedQuery(name="SpOrganizzazioneAttributo.findAll", query="SELECT s FROM SpOrganizzazioneAttributo s")
public class SpOrganizzazioneAttributo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private String id;

	@Column(name="data_cancellazione")
	private Timestamp dataCancellazione;

	@Column(name="data_inserimento")
	private Timestamp dataInserimento;

	@Column(name="data_modifica")
	private Timestamp dataModifica;
	
	@Column(name="org_id")
	private String orgId;

	private String valore;

	//bi-directional many-to-one association to SpDTipoAttributo
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_tipo")
	private SpDTipoAttributo spDTipoAttributo;

	//bi-directional many-to-one association to SpUser
	@ManyToOne
	@JoinColumn(name="id_agente")
	private SpUser spUser;

	public SpOrganizzazioneAttributo() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getDataCancellazione() {
		return this.dataCancellazione;
	}

	public void setDataCancellazione(Timestamp dataCancellazione) {
		this.dataCancellazione = dataCancellazione;
	}

	public Timestamp getDataInserimento() {
		return this.dataInserimento;
	}

	public void setDataInserimento(Timestamp dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public Timestamp getDataModifica() {
		return this.dataModifica;
	}

	public void setDataModifica(Timestamp dataModifica) {
		this.dataModifica = dataModifica;
	}

	public String getValore() {
		return this.valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

	public SpDTipoAttributo getSpDTipoAttributo() {
		return this.spDTipoAttributo;
	}

	public void setSpDTipoAttributo(SpDTipoAttributo spDTipoAttributo) {
		this.spDTipoAttributo = spDTipoAttributo;
	}

	public SpUser getSpUser() {
		return this.spUser;
	}

	public void setSpUser(SpUser spUser) {
		this.spUser = spUser;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

}
