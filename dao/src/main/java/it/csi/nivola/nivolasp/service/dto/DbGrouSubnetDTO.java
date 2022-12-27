/*-
 * ========================LICENSE_START=================================
 * Servizi di accesso dati
 * %%
 * Copyright (C) 2022 Regione Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | Regione Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DbGrouSubnetDTO {
	@JsonProperty("SubnetAvailabilityZone")
	private String name = null;

	@JsonProperty("SubnetIdentifier")
	private String subnetIdentifier = null;

	@JsonProperty("SubnetStatus")
	private String subnetStatus = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubnetIdentifier() {
		return subnetIdentifier;
	}

	public void setSubnetIdentifier(String subnetIdentifier) {
		this.subnetIdentifier = subnetIdentifier;
	}

	public String getSubnetStatus() {
		return subnetStatus;
	}

	public void setSubnetStatus(String subnetStatus) {
		this.subnetStatus = subnetStatus;
	}
}
