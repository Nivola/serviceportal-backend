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
import java.sql.Date;

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
 * The persistent class for the sp_assegnatario_richiesta database table.
 * 
 */
@Entity
@Table(name="sp_assegnatario_richiesta")
@NamedQuery(name="SpAssegnatarioRichiesta.findAll", query="SELECT s FROM SpAssegnatarioRichiesta s")
public class SpAssegnatarioRichiesta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private Boolean attivo;

	@Column(name="data_cancellazione")
	private Date dataCancellazione;

	@Column(name="data_creazione")
	private Date dataCreazione;

	@Column(name="data_fine_validita")
	private Date dataFineValidita;

	@Column(name="data_inizio_validita")
	private Date dataInizioValidita;

	@Column(name="data_modifica")
	private Date dataModifica;


	//bi-directional many-to-one association to SpFormRichieste
	@ManyToOne
	@JoinColumn(name="id_richiesta")
	private SpFormRichieste richiesta;

	//bi-directional many-to-one association to SpUser
	@ManyToOne
	@JoinColumn(name="id_agente")
	private SpUser agente;
	
	//bi-directional many-to-one association to SpUser
	@ManyToOne
	@JoinColumn(name="user_id")
	private SpUser assegnatario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public Date getDataCancellazione() {
		return dataCancellazione;
	}

	public void setDataCancellazione(Date dataCancellazione) {
		this.dataCancellazione = dataCancellazione;
	}

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Date getDataFineValidita() {
		return dataFineValidita;
	}

	public void setDataFineValidita(Date dataFineValidita) {
		this.dataFineValidita = dataFineValidita;
	}

	public Date getDataInizioValidita() {
		return dataInizioValidita;
	}

	public void setDataInizioValidita(Date dataInizioValidita) {
		this.dataInizioValidita = dataInizioValidita;
	}

	public Date getDataModifica() {
		return dataModifica;
	}

	public void setDataModifica(Date dataModifica) {
		this.dataModifica = dataModifica;
	}

	public SpFormRichieste getRichiesta() {
		return richiesta;
	}

	public void setRichiesta(SpFormRichieste spFormRichieste) {
		this.richiesta = spFormRichieste;
	}

	public SpUser getAgente() {
		return agente;
	}

	public void setAgente(SpUser agente) {
		this.agente = agente;
	}

	public SpUser getAssegnatario() {
		return assegnatario;
	}

	public void setAssegnatario(SpUser assegnatario) {
		this.assegnatario = assegnatario;
	}

	public Boolean getAttivo() {
		return attivo;
	}

	public void setAttivo(Boolean attivo) {
		this.attivo = attivo;
	}

	
}
