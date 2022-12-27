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
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the sp_account_attributo database table.
 * 
 */
@Entity
@Table(name="sp_account_attributo")
@NamedQuery(name="SpAccountAttributo.findAll", query="SELECT s FROM SpAccountAttributo s")
public class SpAccountAttributo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ref_account")
	private String refAccount;

	private String acronimo;

	@Column(name="aggiorna_costi_giorno")
	private Boolean aggiornaCostiGiorno;

	@Column(name="person_id")
	private String personId;

	@Column(name="data_cancellazione")
	private Timestamp dataCancellazione;

	@Column(name="data_creazione")
	private Timestamp dataCreazione;

	@Column(name="data_inizio_consumi")
	private Date dataInizioConsumi;

	@Column(name="data_modifica")
	private Timestamp dataModifica;

	private String division;

	@Column(name="id_agente")
	private BigInteger idAgente;

	private String managed;

	private String nome;
	
	@Column(name="budget_min")
	private Integer budgetMin = 0;
	
	@Column(name="budget_max")
	private Integer budgetMax = 0;
	
	@Column(name="data_fine_consumi")
	private Date dataFineConsumi = null;

	//bi-directional many-to-one association to SpDTipoPrezzo
	@ManyToOne
	@JoinColumn(name="tipo_prezzo")
	private SpDTipoPrezzo spDTipoPrezzo;

	public SpAccountAttributo() {
	}

	public String getRefAccount() {
		return this.refAccount;
	}

	public void setRefAccount(String refAccount) {
		this.refAccount = refAccount;
	}

	public String getAcronimo() {
		return this.acronimo;
	}

	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}

	public Boolean getAggiornaCostiGiorno() {
		return this.aggiornaCostiGiorno;
	}

	public void setAggiornaCostiGiorno(Boolean aggiornaCostiGiorno) {
		this.aggiornaCostiGiorno = aggiornaCostiGiorno;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
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

	public Date getDataInizioConsumi() {
		return this.dataInizioConsumi;
	}

	public void setDataInizioConsumi(Date dataInizioConsumi) {
		this.dataInizioConsumi = dataInizioConsumi;
	}

	public Timestamp getDataModifica() {
		return this.dataModifica;
	}

	public void setDataModifica(Timestamp dataModifica) {
		this.dataModifica = dataModifica;
	}

	public String getDivision() {
		return this.division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public BigInteger getIdAgente() {
		return this.idAgente;
	}

	public void setIdAgente(BigInteger idAgente) {
		this.idAgente = idAgente;
	}

	public String getManaged() {
		return this.managed;
	}

	public void setManaged(String managed) {
		this.managed = managed;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public SpDTipoPrezzo getSpDTipoPrezzo() {
		return this.spDTipoPrezzo;
	}

	public void setSpDTipoPrezzo(SpDTipoPrezzo spDTipoPrezzo) {
		this.spDTipoPrezzo = spDTipoPrezzo;
	}

	public Integer getBudgetMin() {
		return budgetMin;
	}

	public void setBudgetMin(Integer budgetMin) {
		this.budgetMin = budgetMin;
	}

	public Integer getBudgetMax() {
		return budgetMax;
	}

	public void setBudgetMax(Integer budgetMax) {
		this.budgetMax = budgetMax;
	}

	public Date getDataFineConsumi() {
		return dataFineConsumi;
	}

	public void setDataFineConsumi(Date dataFineConsumi) {
		this.dataFineConsumi = dataFineConsumi;
	}
	
	
}
