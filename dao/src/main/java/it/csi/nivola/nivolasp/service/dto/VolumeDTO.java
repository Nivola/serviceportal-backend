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
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VolumeDTO implements Serializable {

	private static final long serialVersionUID = -4615871710991841395L;

	@JsonProperty("attachmentSet")
	private List<VolumeAttachmentDTO> attachmentSet = null;

	@JsonProperty("availabilityZone")
	private String availabilityZone = null;

	@JsonProperty("createTime")
	private String createTime = null;

	@JsonProperty("encrypted")
	private String encrypted = null;

	@JsonProperty("multiAttachEnabled")
	private String multiAttachEnabled = null;

	@JsonProperty("nvl-hypervisor")
	private String nvlHypervisor = null;

	@JsonProperty("nvl-name")
	private String nvlName = null;

	@JsonProperty("nvl-resourceId")
	private String nvlResourceId = null;

	@JsonProperty("nvl-volumeOwnerAlias")
	private String nvlVolumeOwnerAlias = null;

	@JsonProperty("nvl-volumeOwnerId")
	private String nvlVolumeOwnerId = null;

	@JsonProperty("size")
	private Integer size = null;

	@JsonProperty("snapshotId")
	private String snapshotId = null;

	@JsonProperty("status")
	private String status = null;

	@JsonProperty("volumeId")
	private String volumeId = null;

	@JsonProperty("volumeType")
	private String volumeType = null;
	
	@JsonProperty("volumeTypeDesc")
	private String volumeTypeDesc = null;

	public List<VolumeAttachmentDTO> getAttachmentSet() {
		return attachmentSet;
	}

	public void setAttachmentSet(List<VolumeAttachmentDTO> attachmentSet) {
		this.attachmentSet = attachmentSet;
	}

	public String getAvailabilityZone() {
		return availabilityZone;
	}

	public void setAvailabilityZone(String availabilityZone) {
		this.availabilityZone = availabilityZone;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getEncrypted() {
		return encrypted;
	}

	public void setEncrypted(String encrypted) {
		this.encrypted = encrypted;
	}

	public String getMultiAttachEnabled() {
		return multiAttachEnabled;
	}

	public void setMultiAttachEnabled(String multiAttachEnabled) {
		this.multiAttachEnabled = multiAttachEnabled;
	}

	public String getNvlHypervisor() {
		return nvlHypervisor;
	}

	public void setNvlHypervisor(String nvlHypervisor) {
		this.nvlHypervisor = nvlHypervisor;
	}

	public String getNvlName() {
		return nvlName;
	}

	public void setNvlName(String nvlName) {
		this.nvlName = nvlName;
	}

	public String getNvlResourceId() {
		return nvlResourceId;
	}

	public void setNvlResourceId(String nvlResourceId) {
		this.nvlResourceId = nvlResourceId;
	}

	public String getNvlVolumeOwnerAlias() {
		return nvlVolumeOwnerAlias;
	}

	public void setNvlVolumeOwnerAlias(String nvlVolumeOwnerAlias) {
		this.nvlVolumeOwnerAlias = nvlVolumeOwnerAlias;
	}

	public String getNvlVolumeOwnerId() {
		return nvlVolumeOwnerId;
	}

	public void setNvlVolumeOwnerId(String nvlVolumeOwnerId) {
		this.nvlVolumeOwnerId = nvlVolumeOwnerId;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getSnapshotId() {
		return snapshotId;
	}

	public void setSnapshotId(String snapshotId) {
		this.snapshotId = snapshotId;
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

	public String getVolumeType() {
		return volumeType;
	}

	public void setVolumeType(String volumeType) {
		this.volumeType = volumeType;
	}

	public String getVolumeTypeDesc() {
		return volumeTypeDesc;
	}

	public void setVolumeTypeDesc(String volumeTypeDesc) {
		this.volumeTypeDesc = volumeTypeDesc;
	}
	
}
