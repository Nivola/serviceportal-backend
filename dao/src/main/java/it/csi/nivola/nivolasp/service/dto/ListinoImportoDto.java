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

import java.time.LocalDateTime;

public class ListinoImportoDto {
	
	private String id;

	private Double addPerc;

	private LocalDateTime dataCancellazione;

	private LocalDateTime dataCreazione;

	private LocalDateTime dataModifica;

	private Double importoAnnuo;

	private String idListinoDettaglio;

	private String tipoPrezzo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getAddPerc() {
		return addPerc;
	}

	public void setAddPerc(Double addPerc) {
		this.addPerc = addPerc;
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

	public LocalDateTime getDataModifica() {
		return dataModifica;
	}

	public void setDataModifica(LocalDateTime dataModifica) {
		this.dataModifica = dataModifica;
	}

	public Double getImportoAnnuo() {
		return importoAnnuo;
	}

	public void setImportoAnnuo(Double importoAnnuo) {
		this.importoAnnuo = importoAnnuo;
	}

	public String getIdListinoDettaglio() {
		return idListinoDettaglio;
	}

	public void setIdListinoDettaglio(String idListinoDettaglio) {
		this.idListinoDettaglio = idListinoDettaglio;
	}

	public String getTipoPrezzo() {
		return tipoPrezzo;
	}

	public void setTipoPrezzo(String tipoPrezzo) {
		this.tipoPrezzo = tipoPrezzo;
	}
	
	
	
}
