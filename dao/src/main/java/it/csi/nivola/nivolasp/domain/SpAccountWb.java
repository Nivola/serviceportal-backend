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
 * The persistent class for the sp_account_wbs database table.
 * 
 */
@Entity
@Table(name="sp_account_wbs")
@NamedQuery(name="SpAccountWb.findAll", query="SELECT s FROM SpAccountWb s")
public class SpAccountWb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="data_creazione")
	private Timestamp dataCreazione;

	@Column(name="data_fine_associazione")
	private Timestamp dataFineAssociazione;

	@Column(name="data_inizio_associazione")
	private Timestamp dataInizioAssociazione;

	@Column(name="ewbs_perc")
	private double ewbsPerc;

	@Column(name="id_agente")
	private BigInteger idAgente;

	@Column(name="ref_account")
	private String refAccount;

	//bi-directional many-to-one association to SpDWb
	@ManyToOne
	@JoinColumn(name="ewbs")
	private SpDWb spDWb;

	public SpAccountWb() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getDataCreazione() {
		return this.dataCreazione;
	}

	public void setDataCreazione(Timestamp dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Timestamp getDataFineAssociazione() {
		return this.dataFineAssociazione;
	}

	public void setDataFineAssociazione(Timestamp dataFineAssociazione) {
		this.dataFineAssociazione = dataFineAssociazione;
	}

	public Timestamp getDataInizioAssociazione() {
		return this.dataInizioAssociazione;
	}

	public void setDataInizioAssociazione(Timestamp dataInizioAssociazione) {
		this.dataInizioAssociazione = dataInizioAssociazione;
	}

	public double getEwbsPerc() {
		return this.ewbsPerc;
	}

	public void setEwbsPerc(double ewbsPerc) {
		this.ewbsPerc = ewbsPerc;
	}

	public BigInteger getIdAgente() {
		return this.idAgente;
	}

	public void setIdAgente(BigInteger idAgente) {
		this.idAgente = idAgente;
	}

	public String getRefAccount() {
		return this.refAccount;
	}

	public void setRefAccount(String refAccount) {
		this.refAccount = refAccount;
	}

	public SpDWb getSpDWb() {
		return this.spDWb;
	}

	public void setSpDWb(SpDWb spDWb) {
		this.spDWb = spDWb;
	}

}
