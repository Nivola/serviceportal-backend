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

public class SecurityGroupDTO extends AbstractDTO {

	private static final long serialVersionUID = 166777522710874752L;

	@JsonProperty("groupDescription")
	private String groupDescription = null;

	@JsonProperty("groupId")
	private String groupId = null;

	@JsonProperty("groupName")
	private String groupName = null;

	@JsonProperty("nvlSgOwnerAlias")
	private String nvlSgOwnerAlias = null;

	@JsonProperty("nvlSgOwnerId")
	private String nvlSgOwnerId = null;

	@JsonProperty("nvlVpcName")
	private String nvlVpcName = null;

	@JsonProperty("nvlState")
	private String nvlState = null;

	@JsonProperty("ownerId")
	private String ownerId = null;

	@JsonProperty("vpcId")
	private String vpcId = null;

	public String getGroupDescription() {
		return groupDescription;
	}

	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getNvlSgOwnerAlias() {
		return nvlSgOwnerAlias;
	}

	public void setNvlSgOwnerAlias(String nvlSgOwnerAlias) {
		this.nvlSgOwnerAlias = nvlSgOwnerAlias;
	}

	public String getNvlSgOwnerId() {
		return nvlSgOwnerId;
	}

	public void setNvlSgOwnerId(String nvlSgOwnerId) {
		this.nvlSgOwnerId = nvlSgOwnerId;
	}

	public String getNvlVpcName() {
		return nvlVpcName;
	}

	public void setNvlVpcName(String nvlVpcName) {
		this.nvlVpcName = nvlVpcName;
	}

	public String getNvlState() {
		return nvlState;
	}

	public void setNvlState(String nvlState) {
		this.nvlState = nvlState;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getVpcId() {
		return vpcId;
	}

	public void setVpcId(String vpcId) {
		this.vpcId = vpcId;
	}
	
	

}
