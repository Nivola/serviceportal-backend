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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.csi.nivola.nivolasp.domain.SpDTipoServizio;

public class RaggruppamentoCostiServizioDTO {
	@JsonIgnore
	private SpDTipoServizio servizio;
	private Double quantita;
	private Double costo;

	public RaggruppamentoCostiServizioDTO(SpDTipoServizio servizio, Double quantita, Double costo) {
		super();
		this.servizio = servizio;
		this.quantita = quantita;
		this.costo = costo;
	}
	@JsonIgnore
	public SpDTipoServizio getServizio() {
		return servizio;
	}
	@JsonIgnore
	public void setServizio(SpDTipoServizio servizio) {
		this.servizio = servizio;
	}

	public Double getQuantita() {
		return quantita;
	}

	public void setQuantita(Double quantita) {
		this.quantita = quantita;
	}
	public Double getCosto() {
		return costo;
	}
	
	public void setCosto(Double costo) {
		this.costo = costo;
	}

	@JsonProperty
	public String getColore() {
		return servizio.getColore();
	}
	@JsonProperty
	public String getDescrizione() {
		return servizio.getDescrizione();
	}
	@JsonProperty
	public String getEtichetta() {
		return servizio.getEtichetta();
	}
	@JsonProperty
	public String getNome() {
		return servizio.getNome();
	}

}
