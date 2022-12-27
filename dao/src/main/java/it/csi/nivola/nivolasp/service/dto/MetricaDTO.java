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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MetricaDTO implements Serializable {

	private static final long serialVersionUID = 3965291252133711883L;
	
	@JsonProperty("metrica")
	private String metric = null;

	@JsonProperty("quota")
	private Float quota = null;

	@JsonProperty("affidabilita")
	private Float reliability = null;

	@JsonProperty("unita")
	private String unit = null;

	@JsonProperty("valore")
	private Double value = null;
	
	@JsonIgnore
	private String regola;
	
	@JsonIgnore
	private String servizio;
	
	private String descrizione;
	
	private String note;
 	
	private BigInteger id;
	
	private String isTenantCost;

	public String getMetric() {
		return metric;
	}

	public void setMetric(String metric) {
		this.metric = metric;
	}

	public Float getQuota() {
		return quota;
	}

	public void setQuota(Float quota) {
		this.quota = quota;
	}

	public Float getReliability() {
		return reliability;
	}

	public void setReliability(Float reliability) {
		this.reliability = reliability;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getRegola() {
		return regola;
	}

	public void setRegola(String regola) {
		this.regola = regola;
	}

	public String getServizio() {
		return servizio;
	}

	public void setServizio(String servizio) {
		this.servizio = servizio;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getIsTenantCost() {
		return isTenantCost;
	}

	public void setIsTenantCost(String isTenantCost) {
		this.isTenantCost = isTenantCost;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
}
