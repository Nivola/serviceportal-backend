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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServizioDTO implements Serializable {

	private static final long serialVersionUID = -1870232184123437672L;
	
	@JsonProperty
	private Date dataRichiesta = new Date();

	@JsonProperty("descrizione")
	private String desc = null;

	@JsonProperty("dataEstrazione")
	private LocalDateTime extractionDate = null;

	@JsonProperty("numeroIstanze")
	private Integer instances = null;
	
	@JsonProperty("numeroIstanzeStopped")
	private Integer instancesStopped = null;
	
	@JsonProperty("numeroIstanzeError")
	private Integer instancesError = null;
	
	@JsonProperty("numeroIstanzeRunning")
	private Integer instancesRunning = null;

	@JsonProperty("nome")
	private String name = null;

	@JsonProperty("tipoServizio")
	private String pluginType = null;

	@JsonProperty("stato")
	private String status = null;

	@JsonProperty("elencoMetriche")
	private List<MetricaDTO> totMetrics = new ArrayList<>();

	@JsonProperty("uuid")
	private String uuid = null;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public LocalDateTime getExtractionDate() {
		return extractionDate;
	}

	public void setExtractionDate(LocalDateTime extractionDate) {
		this.extractionDate = extractionDate;
	}

	public Integer getInstances() {
		return instances;
	}

	public void setInstances(Integer instances) {
		this.instances = instances;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPluginType() {
		return pluginType;
	}

	public void setPluginType(String pluginType) {
		this.pluginType = pluginType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<MetricaDTO> getTotMetrics() {
		return totMetrics;
	}

	public void setTotMetrics(List<MetricaDTO> totMetrics) {
		this.totMetrics = totMetrics;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getDataRichiesta() {
		return dataRichiesta;
	}

	public void setDataRichiesta(Date dataRichiesta) {
		this.dataRichiesta = dataRichiesta;
	}

	public Integer getInstancesStopped() {
		return instancesStopped;
	}

	public void setInstancesStopped(Integer instancesStopped) {
		this.instancesStopped = instancesStopped;
	}

	public Integer getInstancesError() {
		return instancesError;
	}

	public void setInstancesError(Integer instancesError) {
		this.instancesError = instancesError;
	}

	public Integer getInstancesRunning() {
		return instancesRunning;
	}

	public void setInstancesRunning(Integer instancesRunning) {
		this.instancesRunning = instancesRunning;
	}
	
}
