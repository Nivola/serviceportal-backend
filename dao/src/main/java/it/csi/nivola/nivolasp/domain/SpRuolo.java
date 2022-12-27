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
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the sp_ruolo database table.
 * 
 */
@Entity
@Table(name="sp_ruolo")
@NamedQuery(name="SpRuolo.findAll", query="SELECT s FROM SpRuolo s")
public class SpRuolo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String ruolo;

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

	private String descrizione;

	@Column(name="id_agente")
	private BigInteger idAgente;

	//bi-directional many-to-one association to SpUserRuolo
	@OneToMany(mappedBy="spRuolo")
	private List<SpUserRuolo> spUserRuolos;

	public SpRuolo() {
	}

	public String getRuolo() {
		return this.ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
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

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public BigInteger getIdAgente() {
		return this.idAgente;
	}

	public void setIdAgente(BigInteger idAgente) {
		this.idAgente = idAgente;
	}

	public List<SpUserRuolo> getSpUserRuolos() {
		return this.spUserRuolos;
	}

	public void setSpUserRuolos(List<SpUserRuolo> spUserRuolos) {
		this.spUserRuolos = spUserRuolos;
	}

	public SpUserRuolo addSpUserRuolo(SpUserRuolo spUserRuolo) {
		getSpUserRuolos().add(spUserRuolo);
		spUserRuolo.setSpRuolo(this);

		return spUserRuolo;
	}

	public SpUserRuolo removeSpUserRuolo(SpUserRuolo spUserRuolo) {
		getSpUserRuolos().remove(spUserRuolo);
		spUserRuolo.setSpRuolo(null);

		return spUserRuolo;
	}

}
