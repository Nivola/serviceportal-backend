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
import java.math.BigInteger;
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
 * The persistent class for the sp_costo_giorno_wbs database table.
 * 
 */
@Entity
@Table(name="sp_costo_giorno_wbs")
@NamedQuery(name="SpCostoGiornoWb.findAll", query="SELECT s FROM SpCostoGiornoWb s")
public class SpCostoGiornoWb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="data_cancellazione")
	private Timestamp dataCancellazione;

	@Column(name="data_creazione")
	private Timestamp dataCreazione;

	@Column(name="data_modifica")
	private Timestamp dataModifica;

	@Column(name="id_agente")
	private BigInteger idAgente;

	//bi-directional many-to-one association to SpCostoGiorno
	@ManyToOne
	@JoinColumn(name="id_costo_giorno")
	private SpCostoGiorno spCostoGiorno;

	//bi-directional many-to-one association to SpDWb
	@ManyToOne
	@JoinColumn(name="ewbs")
	private SpDWb spDWb;

	public SpCostoGiornoWb() {
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

	public BigInteger getIdAgente() {
		return this.idAgente;
	}

	public void setIdAgente(BigInteger idAgente) {
		this.idAgente = idAgente;
	}

	public SpCostoGiorno getSpCostoGiorno() {
		return this.spCostoGiorno;
	}

	public void setSpCostoGiorno(SpCostoGiorno spCostoGiorno) {
		this.spCostoGiorno = spCostoGiorno;
	}

	public SpDWb getSpDWb() {
		return this.spDWb;
	}

	public void setSpDWb(SpDWb spDWb) {
		this.spDWb = spDWb;
	}

}
