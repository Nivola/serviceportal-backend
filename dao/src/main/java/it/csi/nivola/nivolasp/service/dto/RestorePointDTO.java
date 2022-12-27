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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RestorePointDTO {
	@JsonProperty("created")
	private String created = null;

	@JsonProperty("desc")
	private String desc = null;

	@JsonProperty("finished")
	private String finished = null;

	@JsonProperty("hypervisor")
	private String hypervisor = null;

	@JsonProperty("id")
	private String id = null;

	@JsonProperty("instanceSet")
	private List<CodiceEtichettaDescrizioneDTO> instanceSet = null;

	private String messageError = null;

	private String messageProgress = null;

	private String messageWarning = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("progress")
	private Integer progress = null;

	@JsonProperty("resource_type")
	private String resourceType = null;

	@JsonProperty("site")
	private String site = null;

	@JsonProperty("restore")
	private Integer sizeRestore = null;

	@JsonProperty("tot")
	private Integer sizeTot = null;

	private Integer sizeUploaded = null;

	@JsonProperty("status")
	private String status = null;

	@JsonProperty("time_taken")
	private Integer timeTaken = null;

	@JsonProperty("type")
	private String type = null;

	@JsonProperty("updated")
	private String updated = null;

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getFinished() {
		return finished;
	}

	public void setFinished(String finished) {
		this.finished = finished;
	}

	public String getHypervisor() {
		return hypervisor;
	}

	public void setHypervisor(String hypervisor) {
		this.hypervisor = hypervisor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<CodiceEtichettaDescrizioneDTO> getInstanceSet() {
		return instanceSet;
	}

	public void setInstanceSet(List<CodiceEtichettaDescrizioneDTO> instanceSet) {
		this.instanceSet = instanceSet;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

	public String getMessageProgress() {
		return messageProgress;
	}

	public void setMessageProgress(String messageProgress) {
		this.messageProgress = messageProgress;
	}

	public String getMessageWarning() {
		return messageWarning;
	}

	public void setMessageWarning(String messageWarning) {
		this.messageWarning = messageWarning;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getProgress() {
		return progress;
	}

	public void setProgress(Integer progress) {
		this.progress = progress;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Integer getSizeRestore() {
		return sizeRestore;
	}

	public void setSizeRestore(Integer sizeRestore) {
		this.sizeRestore = sizeRestore;
	}

	public Integer getSizeTot() {
		return sizeTot;
	}

	public void setSizeTot(Integer sizeTot) {
		this.sizeTot = sizeTot;
	}

	public Integer getSizeUploaded() {
		return sizeUploaded;
	}

	public void setSizeUploaded(Integer sizeUploaded) {
		this.sizeUploaded = sizeUploaded;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(Integer timeTaken) {
		this.timeTaken = timeTaken;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

}
