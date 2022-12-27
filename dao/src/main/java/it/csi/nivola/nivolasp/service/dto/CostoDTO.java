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
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CostoDTO implements Serializable {
	
	private static final long serialVersionUID = -5504539431731555166L;

	@JsonProperty("costiRendicontatiAnno")
	private Float costReported = null;

	@JsonProperty("costiTotali")
	private Float costTot = null;

	@JsonProperty("costiNonRendicontati")
	private Float costUnreported = null;

	@JsonProperty("dataEstrazione")
	private LocalDateTime extractionDate = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("uuid")
	private String uuid = null;

	public Float getCostReported() {
		return costReported;
	}

	public void setCostReported(Float costReported) {
		this.costReported = costReported;
	}

	public Float getCostTot() {
		return costTot;
	}

	public void setCostTot(Float costTot) {
		this.costTot = costTot;
	}

	public Float getCostUnreported() {
		return costUnreported;
	}

	public void setCostUnreported(Float costUnreported) {
		this.costUnreported = costUnreported;
	}

	public LocalDateTime getExtractionDate() {
		return extractionDate;
	}

	public void setExtractionDate(LocalDateTime extractionDate) {
		this.extractionDate = extractionDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	
}
