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

public class RaggruppamentoCostiWbsDTO {
	private String wbs;
	private String committente;
	private Double costo;

	public RaggruppamentoCostiWbsDTO(String wbs, String committente, Double costo) {
		super();
		this.wbs = wbs;
		this.committente = committente;
		this.costo = costo;
	}

	public String getWbs() {
		return wbs;
	}

	public void setWbs(String wbs) {
		this.wbs = wbs;
	}

	public String getCommittente() {
		return committente;
	}

	public void setCommittente(String committente) {
		this.committente = committente;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}
	
}
