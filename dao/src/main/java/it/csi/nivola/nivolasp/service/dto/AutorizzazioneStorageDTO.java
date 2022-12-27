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

public class AutorizzazioneStorageDTO implements Serializable {

	private static final long serialVersionUID = 3968748153159700426L;

	@JsonProperty("access_level")
	private String accessLevel = null;

	@JsonProperty("access_to")
	private String accessTo = null;

	@JsonProperty("access_type")
	private String accessType = null;

	@JsonProperty("id")
	private String id = null;

	@JsonProperty("state")
	private String state = null;

	public String getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}

	public String getAccessTo() {
		return accessTo;
	}

	public void setAccessTo(String accessTo) {
		this.accessTo = accessTo;
	}

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
