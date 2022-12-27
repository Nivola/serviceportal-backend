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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubnetDbDTO {
	@JsonProperty("DBSubnetGroupArn")
	private String dbSubnetGroupArn = null;

	@JsonProperty("DBSubnetGroupDescription")
	private String dbSubnetGroupDescription = null;

	@JsonProperty("DBSubnetGroupName")
	private String dbSubnetGroupName = null;

	@JsonProperty("SubnetGroupStatus")
	private String subnetGroupStatus = null;

	@JsonProperty("Subnets")
	private List<DbGrouSubnetDTO> subnets = null;

	@JsonProperty("VpcId")
	private String vpcId = null;

	public String getDbSubnetGroupArn() {
		return dbSubnetGroupArn;
	}

	public void setDbSubnetGroupArn(String dbSubnetGroupArn) {
		this.dbSubnetGroupArn = dbSubnetGroupArn;
	}

	public String getDbSubnetGroupDescription() {
		return dbSubnetGroupDescription;
	}

	public void setDbSubnetGroupDescription(String dbSubnetGroupDescription) {
		this.dbSubnetGroupDescription = dbSubnetGroupDescription;
	}

	public String getDbSubnetGroupName() {
		return dbSubnetGroupName;
	}

	public void setDbSubnetGroupName(String dbSubnetGroupName) {
		this.dbSubnetGroupName = dbSubnetGroupName;
	}

	public String getSubnetGroupStatus() {
		return subnetGroupStatus;
	}

	public void setSubnetGroupStatus(String subnetGroupStatus) {
		this.subnetGroupStatus = subnetGroupStatus;
	}

	public List<DbGrouSubnetDTO> getSubnets() {
		return subnets;
	}

	public void setSubnets(List<DbGrouSubnetDTO> subnets) {
		this.subnets = subnets;
	}

	public String getVpcId() {
		return vpcId;
	}

	public void setVpcId(String vpcId) {
		this.vpcId = vpcId;
	}

}
