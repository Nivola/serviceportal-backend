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

public class OrganizzazioneDTO extends BaseCMPDto implements Serializable {


	private static final long serialVersionUID = 397533004759315092L;

	@JsonProperty("active")
	private Boolean active = null;

	@JsonProperty("attributes")
	private String attributes = null;

	@JsonProperty("desc")
	private String desc = null;

	@JsonProperty("email")
	private String email = null;

	@JsonProperty("ext_anag_id")
	private String extAnagId = null;

	@JsonProperty("hasvat")
	private Boolean hasvat = null;

	@JsonProperty("legalemail")
	private String legalemail = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("org_type")
	private String orgType = null;

	@JsonProperty("partner")
	private Boolean partner = null;

	@JsonProperty("postaladdress")
	private String postaladdress = null;

	@JsonProperty("referent")
	private String referent = null;

	@JsonProperty("service_status_id")
	private Integer serviceStatusId = null;

	@JsonProperty("uuid")
	private String uuid = null;

	@JsonProperty("version")
	private String version = null;
	
	private List<AttributoStrutturaDTO> elencoAttributi;
	

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
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

	public String getExtAnagId() {
		return extAnagId;
	}

	public void setExtAnagId(String extAnagId) {
		this.extAnagId = extAnagId;
	}

	public Boolean getHasvat() {
		return hasvat;
	}

	public void setHasvat(Boolean hasvat) {
		this.hasvat = hasvat;
	}

	public String getLegalemail() {
		return legalemail;
	}

	public void setLegalemail(String legalemail) {
		this.legalemail = legalemail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public Boolean getPartner() {
		return partner;
	}

	public void setPartner(Boolean partner) {
		this.partner = partner;
	}

	public String getPostaladdress() {
		return postaladdress;
	}

	public void setPostaladdress(String postaladdress) {
		this.postaladdress = postaladdress;
	}

	public String getReferent() {
		return referent;
	}

	public void setReferent(String referent) {
		this.referent = referent;
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

	public List<AttributoStrutturaDTO> getElencoAttributi() {
		return elencoAttributi;
	}

	public void setElencoAttributi(List<AttributoStrutturaDTO> elencoAttributi) {
		this.elencoAttributi = elencoAttributi;
	}
}
