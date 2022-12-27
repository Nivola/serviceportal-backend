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
package it.csi.nivola.nivolasp.service.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

public class NewsDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private BigInteger autoreId;

	private String contenuto;

	private Timestamp dataCancellazione;

	private Timestamp dataCreazione;

	private Timestamp dataModifica;

	private Timestamp dataPubblicazioneFine;

	private Timestamp dataPubblicazioneInizio;

	private BigInteger idAgente;

	private String titolo;
	
	private String stato;
	
	private Integer priorita;

	
	public NewsDto() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigInteger getAutoreId() {
		return this.autoreId;
	}

	public void setAutoreId(BigInteger autoreId) {
		this.autoreId = autoreId;
	}

	public String getContenuto() {
		return this.contenuto;
	}

	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
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

	public Timestamp getDataPubblicazioneFine() {
		return this.dataPubblicazioneFine;
	}

	public void setDataPubblicazioneFine(Timestamp dataPubblicazioneFine) {
		this.dataPubblicazioneFine = dataPubblicazioneFine;
	}

	public Timestamp getDataPubblicazioneInizio() {
		return this.dataPubblicazioneInizio;
	}

	public void setDataPubblicazioneInizio(Timestamp dataPubblicazioneInizio) {
		this.dataPubblicazioneInizio = dataPubblicazioneInizio;
	}

	public BigInteger getIdAgente() {
		return this.idAgente;
	}

	public void setIdAgente(BigInteger idAgente) {
		this.idAgente = idAgente;
	}

	public String getTitolo() {
		return this.titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Integer getPriorita() {
		return priorita;
	}

	public void setPriorita(Integer priorita) {
		this.priorita = priorita;
	}
	
	
}
