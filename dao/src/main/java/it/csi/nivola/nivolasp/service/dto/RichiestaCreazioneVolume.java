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

public class RichiestaCreazioneVolume implements Serializable {

	private static final long serialVersionUID = 2555895567082957324L;

	@JsonProperty("availabilityZone")
	private String availabilityZone = null;

	@JsonProperty("encrypted")
	private Boolean encrypted = null;

	@JsonProperty("multiAttachEnabled")
	private Boolean multiAttachEnabled = null;

	@JsonProperty
	private String name = null;

	@JsonProperty("volumeOwnerAlias")
	private String volumeOwnerAlias = null;

	@JsonProperty
	private String accountId = null;

	@JsonProperty("size")
	private Integer size = null;

	@JsonProperty("snapshotId")
	private String snapshotId = null;

	@JsonProperty("status")
	private String status = null;

	@JsonProperty("volumeType")
	private String volumeType = null;
	
	@JsonProperty
	private String hypervisor;

	public String getAvailabilityZone() {
		return availabilityZone;
	}

	public void setAvailabilityZone(String availabilityZone) {
		this.availabilityZone = availabilityZone;
	}

	public Boolean getEncrypted() {
		return encrypted;
	}

	public void setEncrypted(Boolean encrypted) {
		this.encrypted = encrypted;
	}

	public Boolean getMultiAttachEnabled() {
		return multiAttachEnabled;
	}

	public void setMultiAttachEnabled(Boolean multiAttachEnabled) {
		this.multiAttachEnabled = multiAttachEnabled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVolumeOwnerAlias() {
		return volumeOwnerAlias;
	}

	public void setVolumeOwnerAlias(String volumeOwnerAlias) {
		this.volumeOwnerAlias = volumeOwnerAlias;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
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

	public String getVolumeType() {
		return volumeType;
	}

	public void setVolumeType(String volumeType) {
		this.volumeType = volumeType;
	}

	public String getHypervisor() {
		return hypervisor;
	}

	public void setHypervisor(String hypervisor) {
		this.hypervisor = hypervisor;
	}
	
	
}
