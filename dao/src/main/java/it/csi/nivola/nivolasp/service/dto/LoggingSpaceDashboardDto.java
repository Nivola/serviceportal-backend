/*-
 * ========================LICENSE_START=================================
 * Servizi di accesso dati
 * %%
 * Copyright (C) 2022 Regione Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | Regione Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.service.dto;

public class LoggingSpaceDashboardDto {

	private String dashboardId = null;

	private String dashboardName = null;

	private Integer dashboardScore = null;

	private String dashboardVersion = null;

	private String endpoint = null;

	private String modificationDate = null;

	public String getDashboardId() {
		return dashboardId;
	}

	public void setDashboardId(String dashboardId) {
		this.dashboardId = dashboardId;
	}

	public String getDashboardName() {
		return dashboardName;
	}

	public void setDashboardName(String dashboardName) {
		this.dashboardName = dashboardName;
	}

	public Integer getDashboardScore() {
		return dashboardScore;
	}

	public void setDashboardScore(Integer dashboardScore) {
		this.dashboardScore = dashboardScore;
	}

	public String getDashboardVersion() {
		return dashboardVersion;
	}

	public void setDashboardVersion(String dashboardVersion) {
		this.dashboardVersion = dashboardVersion;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(String modificationDate) {
		this.modificationDate = modificationDate;
	}

}
