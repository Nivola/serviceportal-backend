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

import com.fasterxml.jackson.annotation.JsonProperty;

public class VolumeAttachmentDTO implements Serializable{
	
	private static final long serialVersionUID = -2502746451342634458L;

	@JsonProperty("attachTime")
	private String attachTime = null;

	@JsonProperty("deleteOnTermination")
	private Boolean deleteOnTermination = null;

	@JsonProperty("device")
	private String device = null;

	@JsonProperty("instanceId")
	private String instanceId = null;

	@JsonProperty("requestId")
	private String requestId = null;

	@JsonProperty("status")
	private String status = null;

	@JsonProperty("volumeId")
	private String volumeId = null;
	
	private String nomeIstanza;

	public String getAttachTime() {
		return attachTime;
	}

	public void setAttachTime(String attachTime) {
		this.attachTime = attachTime;
	}

	public Boolean getDeleteOnTermination() {
		return deleteOnTermination;
	}

	public void setDeleteOnTermination(Boolean deleteOnTermination) {
		this.deleteOnTermination = deleteOnTermination;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVolumeId() {
		return volumeId;
	}

	public void setVolumeId(String volumeId) {
		this.volumeId = volumeId;
	}

	public String getNomeIstanza() {
		return nomeIstanza;
	}

	public void setNomeIstanza(String nomeIstanza) {
		this.nomeIstanza = nomeIstanza;
	}
	
	
}
