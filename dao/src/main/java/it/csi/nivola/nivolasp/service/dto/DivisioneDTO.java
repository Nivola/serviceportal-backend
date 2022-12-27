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

public class DivisioneDTO extends BaseCMPDto implements Serializable {

	private static final long serialVersionUID = 2548923855556802071L;

	@JsonProperty("active")
	private Boolean active = null;

	@JsonProperty("contact")
	private String contact = null;

	@JsonProperty("desc")
	private String desc = null;

	@JsonProperty("email")
	private String email = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("organization_id")
	private String organizationId = null;

	@JsonProperty("postaladdress")
	private String postaladdress = null;

	@JsonProperty("service_status_id")
	private Integer serviceStatusId = null;

	@JsonProperty("uuid")
	private String uuid = null;

	@JsonProperty("version")
	private String version = null;

	@JsonProperty("accounts")
	private Integer accounts = null;
	
	private OrganizzazioneDTO organizzazione = null;
	
	private List<AttributoStrutturaDTO> elencoAttributi;
	
	

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getPostaladdress() {
		return postaladdress;
	}

	public void setPostaladdress(String postaladdress) {
		this.postaladdress = postaladdress;
	}

	public Integer getServiceStatusId() {
		return serviceStatusId;
	}

	public void setServiceStatusId(Integer serviceStatusId) {
		this.serviceStatusId = serviceStatusId;
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

	public OrganizzazioneDTO getOrganizzazione() {
		return organizzazione;
	}

	public void setOrganizzazione(OrganizzazioneDTO organizzazione) {
		this.organizzazione = organizzazione;
	}

	public Integer getAccounts() {
		return accounts;
	}

	public void setAccounts(Integer accounts) {
		this.accounts = accounts;
	}

	public List<AttributoStrutturaDTO> getElencoAttributi() {
		return elencoAttributi;
	}

	public void setElencoAttributi(List<AttributoStrutturaDTO> elencoAttributi) {
		this.elencoAttributi = elencoAttributi;
	}
}
