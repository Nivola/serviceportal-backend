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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the sp_metriche_dichiarate database table.
 * 
 */
@Entity
@Table(name="sp_metriche_dichiarate")
@NamedQuery(name="SpMetricheDichiarate.findAll", query="SELECT s FROM SpMetricheDichiarate s")
public class SpMetricheDichiarate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private String id;

	@Column(name="data_cancellazione")
	private Timestamp dataCancellazione;

	@Column(name="data_creazione")
	private Timestamp dataCreazione;

	@Column(name="data_fine_validita")
	private Timestamp dataFineValidita;

	@Column(name="data_inizio_validita")
	private Timestamp dataInizioValidita;

	@Column(name="data_modifica")
	private Timestamp dataModifica;

	@Column(name="id_agente")
	private BigInteger idAgente;

	private Double qta;

	@Column(name="ref_account")
	private String refAccount;

	//bi-directional many-to-one association to SpDMetriche
	@ManyToOne
	@JoinColumn(name="id_metrica")
	private SpDMetriche spDMetriche;

	public SpMetricheDichiarate() {
	}

	public String getId() {
		return id;
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

	public Timestamp getDataFineValidita() {
		return this.dataFineValidita;
	}

	public void setDataFineValidita(Timestamp dataFineValidita) {
		this.dataFineValidita = dataFineValidita;
	}

	public Timestamp getDataInizioValidita() {
		return this.dataInizioValidita;
	}

	public void setDataInizioValidita(Timestamp dataInizioValidita) {
		this.dataInizioValidita = dataInizioValidita;
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

	public Double getQta() {
		return this.qta;
	}

	public void setQta(Double qta) {
		this.qta = qta;
	}

	public String getRefAccount() {
		return this.refAccount;
	}

	public void setRefAccount(String refAccount) {
		this.refAccount = refAccount;
	}

	public SpDMetriche getSpDMetriche() {
		return this.spDMetriche;
	}

	public void setSpDMetriche(SpDMetriche spDMetriche) {
		this.spDMetriche = spDMetriche;
	}

}
