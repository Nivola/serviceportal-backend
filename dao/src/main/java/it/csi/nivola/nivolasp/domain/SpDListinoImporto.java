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
 * The persistent class for the sp_d_listino_importo database table.
 * 
 */
@Entity
@Table(name="sp_d_listino_importo")
@NamedQuery(name="SpDListinoImporto.findAll", query="SELECT s FROM SpDListinoImporto s")
public class SpDListinoImporto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="add_perc")
	private Double addPerc;

	@Column(name="data_cancellazione")
	private Timestamp dataCancellazione;

	@Column(name="data_creazione")
	private Timestamp dataCreazione;

	@Column(name="data_modifica")
	private Timestamp dataModifica;

	@Column(name="importo_annuo")
	private Double importoAnnuo;

	//bi-directional many-to-one association to SpDListinoDettaglio
	@ManyToOne
	@JoinColumn(name="id_listino_dettaglio")
	private SpDListinoDettaglio spDListinoDettaglio;

	//bi-directional many-to-one association to SpDTipoPrezzo
	@ManyToOne
	@JoinColumn(name="tipo")
	private SpDTipoPrezzo spDTipoPrezzo;

	//bi-directional many-to-one association to SpUser
	@ManyToOne
	@JoinColumn(name="id_agente")
	private SpUser spUser;
	

	public SpDListinoImporto() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getAddPerc() {
		return this.addPerc;
	}

	public void setAddPerc(Double addPerc) {
		this.addPerc = addPerc;
	}

	public Timestamp getDataCancellazione() {
		return this.dataCancellazione;
	}

	public void setDataCancellazione(Timestamp dataCancellazione) {
		this.dataCancellazione = dataCancellazione;
	}

	public Timestamp getDataCreazione() {
		return this.dataCreazione;
	}

	public void setDataCreazione(Timestamp dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Timestamp getDataModifica() {
		return this.dataModifica;
	}

	public void setDataModifica(Timestamp dataModifica) {
		this.dataModifica = dataModifica;
	}

	public Double getImportoAnnuo() {
		return this.importoAnnuo;
	}

	public void setImportoAnnuo(Double importoAnnuo) {
		this.importoAnnuo = importoAnnuo;
	}

	public SpDListinoDettaglio getSpDListinoDettaglio() {
		return this.spDListinoDettaglio;
	}

	public void setSpDListinoDettaglio(SpDListinoDettaglio spDListinoDettaglio) {
		this.spDListinoDettaglio = spDListinoDettaglio;
	}

	public SpDTipoPrezzo getSpDTipoPrezzo() {
		return this.spDTipoPrezzo;
	}

	public void setSpDTipoPrezzo(SpDTipoPrezzo spDTipoPrezzo) {
		this.spDTipoPrezzo = spDTipoPrezzo;
	}

	public SpUser getSpUser() {
		return this.spUser;
	}

	public void setSpUser(SpUser spUser) {
		this.spUser = spUser;
	}

}
