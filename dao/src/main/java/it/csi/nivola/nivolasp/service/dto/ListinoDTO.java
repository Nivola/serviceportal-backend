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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ListinoDTO extends AbstractDTO {

	private static final long serialVersionUID = -2194178633747396693L;

	private String id;

	private LocalDateTime dataCancellazione;

	private LocalDateTime dataCreazione;

	private LocalDate dataFineValidita;

	private LocalDate dataInizioValidita;

	private LocalDateTime dataModifica;

	private String descrizione;

	private String nome;
	
	private String voce;
	
	private String tipoListino;
	
	private List<ListinoDettaglioDTO> elencoDettagli;
	
	private List<CodiceEtichettaDescrizioneDTO> tipiPrezzoAmmessi;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getDataCancellazione() {
		return dataCancellazione;
	}

	public void setDataCancellazione(LocalDateTime dataCancellazione) {
		this.dataCancellazione = dataCancellazione;
	}

	public LocalDateTime getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(LocalDateTime dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public LocalDate getDataFineValidita() {
		return dataFineValidita;
	}

	public void setDataFineValidita(LocalDate dataFineValidita) {
		this.dataFineValidita = dataFineValidita;
	}

	public LocalDate getDataInizioValidita() {
		return dataInizioValidita;
	}

	public void setDataInizioValidita(LocalDate dataInizioValidita) {
		this.dataInizioValidita = dataInizioValidita;
	}

	public LocalDateTime getDataModifica() {
		return dataModifica;
	}

	public void setDataModifica(LocalDateTime dataModifica) {
		this.dataModifica = dataModifica;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ListinoDettaglioDTO> getElencoDettagli() {
		return elencoDettagli;
	}

	public void setElencoDettagli(List<ListinoDettaglioDTO> elencoDettagli) {
		this.elencoDettagli = elencoDettagli;
	}

	public String getTipoListino() {
		return tipoListino;
	}

	public void setTipoListino(String tipoListino) {
		this.tipoListino = tipoListino;
	}

	public List<CodiceEtichettaDescrizioneDTO> getTipiPrezzoAmmessi() {
		return tipiPrezzoAmmessi;
	}

	public void setTipiPrezzoAmmessi(List<CodiceEtichettaDescrizioneDTO> tipiPrezzoAmmessi) {
		this.tipiPrezzoAmmessi = tipiPrezzoAmmessi;
	}

	public String getVoce() {
		return voce;
	}

	public void setVoce(String voce) {
		this.voce = voce;
	}
	
	
}
