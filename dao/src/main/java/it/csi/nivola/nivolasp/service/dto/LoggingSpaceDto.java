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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LoggingSpaceDto {

	private LocalDateTime creationDate = null;

	private List<LoggingSpaceDashboardDto> dashboards = new ArrayList<>();

	private String description = null;

	private LoggingSpaceEndpointDto endpoints = null;

	private String id = null;

	private String name = null;

	private String ownerAlias = null;

	private String ownerId = null;

	private String state = null;

	private String templateId = null;

	private String templateName = null;
	
	private String stateReason;

	private Integer stateCode;

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public List<LoggingSpaceDashboardDto> getDashboards() {
		return dashboards;
	}

	public void setDashboards(List<LoggingSpaceDashboardDto> dashboards) {
		this.dashboards = dashboards;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LoggingSpaceEndpointDto getEndpoints() {
		return endpoints;
	}

	public void setEndpoints(LoggingSpaceEndpointDto endpoints) {
		this.endpoints = endpoints;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnerAlias() {
		return ownerAlias;
	}

	public void setOwnerAlias(String ownerAlias) {
		this.ownerAlias = ownerAlias;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getStateReason() {
		return stateReason;
	}

	public void setStateReason(String stateReason) {
		this.stateReason = stateReason;
	}

	public Integer getStateCode() {
		return stateCode;
	}

	public void setStateCode(Integer stateCode) {
		this.stateCode = stateCode;
	}
	
	
	

}
