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

import java.sql.Timestamp;

/**
 * Classe che rappresenta una voce di costo di listino all'interno di un account
 */
public class ValoreCostoListinoDTO {
	
	private String idValore;
	
	private String nomeMetricaDefinizione;
	
	private String descrizioneMetrica;
	
	private String accountUuid;
	
	private Double quantita;
	
	private String etichettaValore;
	
	private Timestamp dataDa;
	
	private Timestamp dataA;
	
	private Timestamp dataModifica;
	
	private Timestamp dataCancellazione;

	public String getIdValore() {
		return idValore;
	}

	public void setIdValore(String idValore) {
		this.idValore = idValore;
	}

	public String getNomeMetricaDefinizione() {
		return nomeMetricaDefinizione;
	}

	public void setNomeMetricaDefinizione(String nomeMetricaDefinizione) {
		this.nomeMetricaDefinizione = nomeMetricaDefinizione;
	}

	public String getAccountUuid() {
		return accountUuid;
	}

	public void setAccountUuid(String accountUuid) {
		this.accountUuid = accountUuid;
	}

	public Double getQuantita() {
		return quantita;
	}

	public void setQuantita(Double quantita) {
		this.quantita = quantita;
	}

	public String getDescrizioneMetrica() {
		return descrizioneMetrica;
	}

	public void setDescrizioneMetrica(String descrizioneMetrica) {
		this.descrizioneMetrica = descrizioneMetrica;
	}

	public String getEtichettaValore() {
		return etichettaValore;
	}

	public void setEtichettaValore(String etichettaValore) {
		this.etichettaValore = etichettaValore;
	}

	public Timestamp getDataDa() {
		return dataDa;
	}

	public void setDataDa(Timestamp dataDa) {
		this.dataDa = dataDa;
	}

	public Timestamp getDataA() {
		return dataA;
	}

	public void setDataA(Timestamp dataA) {
		this.dataA = dataA;
	}

	public Timestamp getDataModifica() {
		return dataModifica;
	}

	public void setDataModifica(Timestamp dataModifica) {
		this.dataModifica = dataModifica;
	}

	public Timestamp getDataCancellazione() {
		return dataCancellazione;
	}

	public void setDataCancellazione(Timestamp dataCancellazione) {
		this.dataCancellazione = dataCancellazione;
	}


}
