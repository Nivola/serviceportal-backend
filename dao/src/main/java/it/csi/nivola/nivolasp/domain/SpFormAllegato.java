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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the sp_form_allegato database table.
 * 
 */
@Entity
@Table(name="sp_form_allegato")
@NamedQuery(name="SpFormAllegato.findAll", query="SELECT s FROM SpFormAllegato s")
public class SpFormAllegato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private byte[] file;

	@Column(name="log_id")
	private String logId;
	
	private String nome;
	
	private Boolean inviato = false;
	
	private String note;
	
	private String riepilogo;
	
	private String tipologia;
	
	@Column(name="data_inserimento")
	private Timestamp dataInserimento;

	//bi-directional many-to-one association to SpFormRichieste
	@ManyToOne
	@JoinColumn(name="id_form")
	private SpFormRichieste spFormRichieste;
	
	@ManyToOne
	@JoinColumn(name="id_utente_inserimento")
	private SpUser utenteInserimento;

	public SpFormAllegato() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getFile() {
		return this.file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getLogId() {
		return this.logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public SpFormRichieste getSpFormRichieste() {
		return this.spFormRichieste;
	}

	public void setSpFormRichieste(SpFormRichieste spFormRichieste) {
		this.spFormRichieste = spFormRichieste;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getInviato() {
		return inviato;
	}

	public void setInviato(Boolean inviato) {
		this.inviato = inviato;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getRiepilogo() {
		return riepilogo;
	}

	public void setRiepilogo(String riepilogo) {
		this.riepilogo = riepilogo;
	}

	public Timestamp getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Timestamp dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public SpUser getUtenteInserimento() {
		return utenteInserimento;
	}

	public void setUtenteInserimento(SpUser utenteInserimento) {
		this.utenteInserimento = utenteInserimento;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	
	
}
