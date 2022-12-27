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

import it.csi.nivola.nivolasp.integration.rest.model.service.CreateDBInstancesApiRequestSchemaDbinstanceTag;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet.StateEnum;

public class SubnetDTO extends AbstractDTO {
	
	private static final long serialVersionUID = 4999790476633028392L;

	@JsonProperty("assignIpv6AddressOnCreation")
	private Boolean assignIpv6AddressOnCreation = null;

	@JsonProperty("availabilityZone")
	private String availabilityZone = null;

	@JsonProperty("availableIpAddressCount")
	private Integer availableIpAddressCount = null;

	@JsonProperty("cidrBlock")
	private String cidrBlock = null;

	@JsonProperty("defaultForAz")
	private Boolean defaultForAz = null;

	@JsonProperty("mapPublicIpOnLaunch")
	private Boolean mapPublicIpOnLaunch = null;

	@JsonProperty("nvlName")
	private String nvlName = null;

	@JsonProperty("nvlSubnetOwnerAlias")
	private String nvlSubnetOwnerAlias = null;

	@JsonProperty("nvlSubnetOwnerId")
	private String nvlSubnetOwnerId = null;

	@JsonProperty("nvlVpcName")
	private String nvlVpcName = null;

	@JsonProperty("ownerId")
	private String ownerId = null;
	

  @JsonProperty("state")
  private StateEnum state = null;

  @JsonProperty("subnetId")
	  private String subnetId = null;

  @JsonProperty("tagSet")
  private List<CreateDBInstancesApiRequestSchemaDbinstanceTag> tagSet = null;

	  @JsonProperty("vpcId")
  private String vpcId = null;


	public Boolean getAssignIpv6AddressOnCreation() {
		return assignIpv6AddressOnCreation;
	}

	public void setAssignIpv6AddressOnCreation(Boolean assignIpv6AddressOnCreation) {
		this.assignIpv6AddressOnCreation = assignIpv6AddressOnCreation;
	}

	public String getAvailabilityZone() {
		return availabilityZone;
	}

	public void setAvailabilityZone(String availabilityZone) {
		this.availabilityZone = availabilityZone;
	}

	public Integer getAvailableIpAddressCount() {
		return availableIpAddressCount;
	}

	public void setAvailableIpAddressCount(Integer availableIpAddressCount) {
		this.availableIpAddressCount = availableIpAddressCount;
	}

	public String getCidrBlock() {
		return cidrBlock;
	}

	public void setCidrBlock(String cidrBlock) {
		this.cidrBlock = cidrBlock;
	}

	public Boolean getDefaultForAz() {
		return defaultForAz;
	}

	public void setDefaultForAz(Boolean defaultForAz) {
		this.defaultForAz = defaultForAz;
	}

	public Boolean getMapPublicIpOnLaunch() {
		return mapPublicIpOnLaunch;
	}

	public void setMapPublicIpOnLaunch(Boolean mapPublicIpOnLaunch) {
		this.mapPublicIpOnLaunch = mapPublicIpOnLaunch;
	}

	public String getNvlName() {
		return nvlName;
	}

	public void setNvlName(String nvlName) {
		this.nvlName = nvlName;
	}

	public String getNvlSubnetOwnerAlias() {
		return nvlSubnetOwnerAlias;
	}

	public void setNvlSubnetOwnerAlias(String nvlSubnetOwnerAlias) {
		this.nvlSubnetOwnerAlias = nvlSubnetOwnerAlias;
	}

	public String getNvlSubnetOwnerId() {
		return nvlSubnetOwnerId;
	}

	public void setNvlSubnetOwnerId(String nvlSubnetOwnerId) {
		this.nvlSubnetOwnerId = nvlSubnetOwnerId;
	}

	public String getNvlVpcName() {
		return nvlVpcName;
	}

	public void setNvlVpcName(String nvlVpcName) {
		this.nvlVpcName = nvlVpcName;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public StateEnum getState() {
		return state;
	}

	public void setState(StateEnum state) {
		this.state = state;
	}

	public String getSubnetId() {
		return subnetId;
	}

	public void setSubnetId(String subnetId) {
		this.subnetId = subnetId;
	}

	public List<CreateDBInstancesApiRequestSchemaDbinstanceTag> getTagSet() {
		return tagSet;
	}

	public void setTagSet(List<CreateDBInstancesApiRequestSchemaDbinstanceTag> tagSet) {
		this.tagSet = tagSet;
	}

	public String getVpcId() {
		return vpcId;
	}

	public void setVpcId(String vpcId) {
		this.vpcId = vpcId;
	}
	
	
}
