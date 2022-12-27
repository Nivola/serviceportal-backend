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

import it.csi.nivola.nivolasp.integration.rest.model.service.CreateDBInstancesApiRequestSchemaDbinstanceTag;

public class VmDTO implements Serializable {
	
	private static final long serialVersionUID = -2820065110326923576L;

	private String name;

	private String region;

	private String az;

	private Integer cpu;

	private String ram;

	private String os;

	private String ip;

	private String status;

	private String instanceId = null;
	
	private String privateDnsName;
	
	private Double disco;
	
	@JsonProperty("elencoTag")
	private List<CreateDBInstancesApiRequestSchemaDbinstanceTag> tagSet = null;
	
	@JsonProperty("securityGroup")
	private List<DescrizioneGruppo> groupSet = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAz() {
		return az;
	}

	public void setAz(String az) {
		this.az = az;
	}

	public Integer getCpu() {
		return cpu;
	}

	public void setCpu(Integer cpu) {
		this.cpu = cpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public String getPrivateDnsName() {
		return privateDnsName;
	}

	public void setPrivateDnsName(String privateDnsName) {
		this.privateDnsName = privateDnsName;
	}

	public Double getDisco() {
		return disco;
	}

	public void setDisco(Double disco) {
		this.disco = disco;
	}

	public List<CreateDBInstancesApiRequestSchemaDbinstanceTag> getTagSet() {
		return tagSet;
	}

	public void setTagSet(List<CreateDBInstancesApiRequestSchemaDbinstanceTag> tagSet) {
		this.tagSet = tagSet;
	}

	public List<DescrizioneGruppo> getGroupSet() {
		return groupSet;
	}

	public void setGroupSet(List<DescrizioneGruppo> groupSet) {
		this.groupSet = groupSet;
	}
}
