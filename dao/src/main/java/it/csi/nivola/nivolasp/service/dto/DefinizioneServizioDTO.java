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

public class DefinizioneServizioDTO extends AbstractDTO implements Serializable {

	private static final long serialVersionUID = -6174263097157204024L;

	@JsonProperty("attivo")
	private Boolean active = null;

	@JsonProperty("descrizione")
	private String desc = null;

	@JsonProperty("id")
	private Integer id = null;

	@JsonProperty("nome")
	private String name = null;

	@JsonProperty("stato")
	private String status = null;

	@JsonProperty("uuid")
	private String uuid = null;

	@JsonProperty("versione")
	private String version = null;

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
