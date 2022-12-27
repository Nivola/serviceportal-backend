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

public class MountTargetDTO implements Serializable {

	private static final long serialVersionUID = 4241074520422027444L;

	@JsonProperty("IpAddress")
	private String ipAddress = null;

	@JsonProperty("MountTargetId")
	private String mountTargetId = null;

	@JsonProperty("NetworkInterfaceId")
	private String networkInterfaceId = null;

	@JsonProperty("SubnetId")
	private String subnetId = null;

	@JsonProperty("protocol")
	private String nvlShareProto = null;

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getMountTargetId() {
		return mountTargetId;
	}

	public void setMountTargetId(String mountTargetId) {
		this.mountTargetId = mountTargetId;
	}

	public String getNetworkInterfaceId() {
		return networkInterfaceId;
	}

	public void setNetworkInterfaceId(String networkInterfaceId) {
		this.networkInterfaceId = networkInterfaceId;
	}

	public String getSubnetId() {
		return subnetId;
	}

	public void setSubnetId(String subnetId) {
		this.subnetId = subnetId;
	}

	public String getNvlShareProto() {
		return nvlShareProto;
	}

	public void setNvlShareProto(String nvlShareProto) {
		this.nvlShareProto = nvlShareProto;
	}
	
	
	

}
