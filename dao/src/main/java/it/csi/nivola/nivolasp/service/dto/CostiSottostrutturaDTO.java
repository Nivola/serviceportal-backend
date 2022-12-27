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

public class CostiSottostrutturaDTO {
	
	private String uuid;
	
	private Double costo;
	
	private Double quantita;
	
	private String nomeServizio;
	
	private String coloreServizio;
	
	

	public CostiSottostrutturaDTO(String accountUuid, Double costo, Double quantita, String nomeServizio, String coloreServizio) {
		super();
		this.uuid = accountUuid;
		this.costo = costo;
		this.quantita = quantita;
		this.nomeServizio = nomeServizio;
		this.coloreServizio = coloreServizio;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String accountUuid) {
		this.uuid = accountUuid;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public Double getQuantita() {
		return quantita;
	}

	public void setQuantita(Double quantita) {
		this.quantita = quantita;
	}

	public String getNomeServizio() {
		return nomeServizio;
	}

	public void setNomeServizio(String nomeServizio) {
		this.nomeServizio = nomeServizio;
	}

	public String getColoreServizio() {
		return coloreServizio;
	}

	public void setColoreServizio(String coloreServizio) {
		this.coloreServizio = coloreServizio;
	}
}
