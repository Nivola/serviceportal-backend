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
/**
 * Singolo elemento della tendina dei Flavours di una vm
 */
public class FlavourDTO implements Serializable {
	
	private static final long serialVersionUID = 349498702446988792L;

	@JsonProperty("descrizione")
	private String description = null;

	@JsonProperty("disco")
	private String disk = null;

	@JsonProperty("ram")
	private String ram = null;

	@JsonProperty("vcpus")
	private Integer vcpus = null;

	@JsonProperty("id")
	private Integer id = null;

	@JsonProperty("nome")
	private String name = null;

	@JsonProperty("resource_id")
	private String resourceId = null;

	@JsonProperty("uuid")
	private String uuid = null;

	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDisk() {
		return disk;
	}

	public void setDisk(String disk) {
		this.disk = disk;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Integer getVcpus() {
		return vcpus;
	}

	public void setVcpus(Integer vcpus) {
		this.vcpus = vcpus;
	}
	
}
