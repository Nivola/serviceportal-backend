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

public class ServiceStatusDTO extends AbstractDTO {

	private static final long serialVersionUID = 8674148152888919258L;
	
	private Integer priority;
	private String code;
	private String displayName;
	private Boolean status;
	private String message;

	public ServiceStatusDTO(String code, String displayName, Integer priority) {
		super();
		this.code = code;
		this.displayName = displayName;
		this.status = true;
		this.message = null;
		this.priority = priority;
	}
	
	@Override
	public String toString() {
		return "ServiceStatusDTO [code=" + code + ", status=" + status + ", message=" + message + "]";
	}

	public ServiceStatusDTO(String code, String displayName, Integer priority, Boolean status, String message) {
		super();
		this.code = code;
		this.displayName = displayName;
		this.status = status;
		this.message = message;
		this.priority = priority;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
