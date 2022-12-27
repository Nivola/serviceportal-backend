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
 * Wrapping presso la cmp delle Capabilities
 * 
 * @author plaf
 *
 */
public class CapabilitiesDTO extends BaseCMPDto implements Serializable {

	private static final long serialVersionUID = -6172679555336393573L;

	@JsonProperty("active")
	private Boolean active = null;

	@JsonProperty("desc")
	private String desc = null;


	@JsonProperty("name")
	private String name = null;

	@JsonProperty("plugin_name")
	private String pluginName = null;

	@JsonProperty("status_id")
	private Integer statusId = null;

	@JsonProperty("uuid")
	private String uuid = null;

	@JsonProperty("version")
	private String version = null;
	
	private String status = null;
	
	@JsonProperty("abilitataAccount")
	private Boolean abilitataAccount;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPluginName() {
		return pluginName;
	}

	public void setPluginName(String pluginName) {
		this.pluginName = pluginName;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
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

	public Boolean getAbilitataAccount() {
		return abilitataAccount;
	}

	public void setAbilitataAccount(Boolean abilitataAccount) {
		this.abilitataAccount = abilitataAccount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
