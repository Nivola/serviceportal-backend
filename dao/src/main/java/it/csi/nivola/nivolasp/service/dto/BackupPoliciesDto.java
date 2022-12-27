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

public class BackupPoliciesDto {

	  private Integer fullbackupInterval = null;

	  private Integer id = null;

	  private String interval = null;

	  private String name = null;

	  private Integer restorePoints = null;

	  private String startTimeWindow = null;

	  private String timezone = null;

	  private String uuid = null;

	public Integer getFullbackupInterval() {
		return fullbackupInterval;
	}

	public void setFullbackupInterval(Integer fullbackupInterval) {
		this.fullbackupInterval = fullbackupInterval;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInterval() {
		return interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRestorePoints() {
		return restorePoints;
	}

	public void setRestorePoints(Integer restorePoints) {
		this.restorePoints = restorePoints;
	}

	public String getStartTimeWindow() {
		return startTimeWindow;
	}

	public void setStartTimeWindow(String startTimeWindow) {
		this.startTimeWindow = startTimeWindow;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	  
	  

}
