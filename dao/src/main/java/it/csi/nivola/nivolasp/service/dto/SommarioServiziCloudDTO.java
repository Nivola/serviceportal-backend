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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SommarioServiziCloudDTO implements Serializable {

	private static final long serialVersionUID = 8147734305731151693L;

	@JsonProperty("numeroAccounts")
	private Integer accounts = null;
	
	@JsonProperty("numeroDivisioni")
	private Integer divisions = null;
	
	@JsonProperty("numeroOrganizzazioni")
	private Integer organizations = null;
	
	@JsonProperty("elencoServizi")
	List<ServizioDTO> serviceContainer = null;

	public Integer getAccounts() {
		return accounts;
	}

	public void setAccounts(Integer accounts) {
		this.accounts = accounts;
	}

	public Integer getDivisions() {
		return divisions;
	}

	public void setDivisions(Integer divisions) {
		this.divisions = divisions;
	}

	public Integer getOrganizations() {
		return organizations;
	}

	public void setOrganizations(Integer organizations) {
		this.organizations = organizations;
	}

	public List<ServizioDTO> getServiceContainer() {
		return serviceContainer;
	}

	public void setServiceContainer(List<ServizioDTO> serviceContainer) {
		this.serviceContainer = serviceContainer;
	}



}
