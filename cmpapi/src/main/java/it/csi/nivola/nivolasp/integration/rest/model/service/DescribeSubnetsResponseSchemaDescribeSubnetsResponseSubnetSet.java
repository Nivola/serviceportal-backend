/*-
 * ========================LICENSE_START=================================
 * Api CMP
 * %%
 * Copyright (C) 2022 Regione Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | Regione Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
/*
 * Beehive API
 * Beehive API
 *
 * OpenAPI spec version: 1.0.0
 * Contact: nivola.engineering@csi.it
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package it.csi.nivola.nivolasp.integration.rest.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet
 */

public class DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet {
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

  @JsonProperty("ipv6CidrBlockAssociationSet")
  private List<DescribeSubnetsResponseSchemaDescribeSubnetsResponseIpv6CidrBlockAssociationSet> ipv6CidrBlockAssociationSet = null;

  @JsonProperty("mapPublicIpOnLaunch")
  private Boolean mapPublicIpOnLaunch = null;

  @JsonProperty("nvl-name")
  private String nvlName = null;

  @JsonProperty("nvl-subnetOwnerAlias")
  private String nvlSubnetOwnerAlias = null;

  @JsonProperty("nvl-subnetOwnerId")
  private String nvlSubnetOwnerId = null;

  @JsonProperty("nvl-vpcName")
  private String nvlVpcName = null;

  @JsonProperty("ownerId")
  private String ownerId = null;

  /**
   * state of the VPC (pending | available | transient | error)
   */
  public enum StateEnum {
    AVAILABLE("available"),
    
    DEREGISTERED("deregistered"),
    
    ERROR("error"),
    
    PENDING("pending"),
    
    TRANSIENT("transient"),
    
    UNKNOWN("unknown");

    private String value;

    StateEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StateEnum fromValue(String value) {
      for (StateEnum b : StateEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("state")
  private StateEnum state = null;

  @JsonProperty("subnetId")
  private String subnetId = null;

  @JsonProperty("tagSet")
  private List<CreateDBInstancesApiRequestSchemaDbinstanceTag> tagSet = null;

  @JsonProperty("vpcId")
  private String vpcId = null;

  public DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet assignIpv6AddressOnCreation(Boolean assignIpv6AddressOnCreation) {
    this.assignIpv6AddressOnCreation = assignIpv6AddressOnCreation;
    return this;
  }

   /**
   * Get assignIpv6AddressOnCreation
   * @return assignIpv6AddressOnCreation
  **/
  @ApiModelProperty(value = "")
  public Boolean isAssignIpv6AddressOnCreation() {
    return assignIpv6AddressOnCreation;
  }

  public void setAssignIpv6AddressOnCreation(Boolean assignIpv6AddressOnCreation) {
    this.assignIpv6AddressOnCreation = assignIpv6AddressOnCreation;
  }

  public DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet availabilityZone(String availabilityZone) {
    this.availabilityZone = availabilityZone;
    return this;
  }

   /**
   * Availability Zone of the subnet.
   * @return availabilityZone
  **/
  @ApiModelProperty(example = "", value = "Availability Zone of the subnet.")
  public String getAvailabilityZone() {
    return availabilityZone;
  }

  public void setAvailabilityZone(String availabilityZone) {
    this.availabilityZone = availabilityZone;
  }

  public DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet availableIpAddressCount(Integer availableIpAddressCount) {
    this.availableIpAddressCount = availableIpAddressCount;
    return this;
  }

   /**
   * Get availableIpAddressCount
   * @return availableIpAddressCount
  **/
  @ApiModelProperty(value = "")
  public Integer getAvailableIpAddressCount() {
    return availableIpAddressCount;
  }

  public void setAvailableIpAddressCount(Integer availableIpAddressCount) {
    this.availableIpAddressCount = availableIpAddressCount;
  }

  public DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet cidrBlock(String cidrBlock) {
    this.cidrBlock = cidrBlock;
    return this;
  }

   /**
   * primary IPv4 CIDR block for the subnet
   * @return cidrBlock
  **/
  @ApiModelProperty(example = "", value = "primary IPv4 CIDR block for the subnet")
  public String getCidrBlock() {
    return cidrBlock;
  }

  public void setCidrBlock(String cidrBlock) {
    this.cidrBlock = cidrBlock;
  }

  public DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet defaultForAz(Boolean defaultForAz) {
    this.defaultForAz = defaultForAz;
    return this;
  }

   /**
   * Get defaultForAz
   * @return defaultForAz
  **/
  @ApiModelProperty(value = "")
  public Boolean isDefaultForAz() {
    return defaultForAz;
  }

  public void setDefaultForAz(Boolean defaultForAz) {
    this.defaultForAz = defaultForAz;
  }

  public DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet ipv6CidrBlockAssociationSet(List<DescribeSubnetsResponseSchemaDescribeSubnetsResponseIpv6CidrBlockAssociationSet> ipv6CidrBlockAssociationSet) {
    this.ipv6CidrBlockAssociationSet = ipv6CidrBlockAssociationSet;
    return this;
  }

  public DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet addIpv6CidrBlockAssociationSetItem(DescribeSubnetsResponseSchemaDescribeSubnetsResponseIpv6CidrBlockAssociationSet ipv6CidrBlockAssociationSetItem) {
    if (this.ipv6CidrBlockAssociationSet == null) {
      this.ipv6CidrBlockAssociationSet = new ArrayList<>();
    }
    this.ipv6CidrBlockAssociationSet.add(ipv6CidrBlockAssociationSetItem);
    return this;
  }

   /**
   * IPv6 CIDR blocks associated with the subnet
   * @return ipv6CidrBlockAssociationSet
  **/
  @ApiModelProperty(value = "IPv6 CIDR blocks associated with the subnet")
  public List<DescribeSubnetsResponseSchemaDescribeSubnetsResponseIpv6CidrBlockAssociationSet> getIpv6CidrBlockAssociationSet() {
    return ipv6CidrBlockAssociationSet;
  }

  public void setIpv6CidrBlockAssociationSet(List<DescribeSubnetsResponseSchemaDescribeSubnetsResponseIpv6CidrBlockAssociationSet> ipv6CidrBlockAssociationSet) {
    this.ipv6CidrBlockAssociationSet = ipv6CidrBlockAssociationSet;
  }

  public DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet mapPublicIpOnLaunch(Boolean mapPublicIpOnLaunch) {
    this.mapPublicIpOnLaunch = mapPublicIpOnLaunch;
    return this;
  }

   /**
   * Get mapPublicIpOnLaunch
   * @return mapPublicIpOnLaunch
  **/
  @ApiModelProperty(value = "")
  public Boolean isMapPublicIpOnLaunch() {
    return mapPublicIpOnLaunch;
  }

  public void setMapPublicIpOnLaunch(Boolean mapPublicIpOnLaunch) {
    this.mapPublicIpOnLaunch = mapPublicIpOnLaunch;
  }

  public DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet nvlName(String nvlName) {
    this.nvlName = nvlName;
    return this;
  }

   /**
   * Get nvlName
   * @return nvlName
  **/
  @ApiModelProperty(example = "", value = "")
  public String getNvlName() {
    return nvlName;
  }

  public void setNvlName(String nvlName) {
    this.nvlName = nvlName;
  }

  public DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet nvlSubnetOwnerAlias(String nvlSubnetOwnerAlias) {
    this.nvlSubnetOwnerAlias = nvlSubnetOwnerAlias;
    return this;
  }

   /**
   * alias of the account that owns the subnet
   * @return nvlSubnetOwnerAlias
  **/
  @ApiModelProperty(example = "", value = "alias of the account that owns the subnet")
  public String getNvlSubnetOwnerAlias() {
    return nvlSubnetOwnerAlias;
  }

  public void setNvlSubnetOwnerAlias(String nvlSubnetOwnerAlias) {
    this.nvlSubnetOwnerAlias = nvlSubnetOwnerAlias;
  }

  public DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet nvlSubnetOwnerId(String nvlSubnetOwnerId) {
    this.nvlSubnetOwnerId = nvlSubnetOwnerId;
    return this;
  }

   /**
   * ID of the account that owns the subnet
   * @return nvlSubnetOwnerId
  **/
  @ApiModelProperty(example = "", value = "ID of the account that owns the subnet")
  public String getNvlSubnetOwnerId() {
    return nvlSubnetOwnerId;
  }

  public void setNvlSubnetOwnerId(String nvlSubnetOwnerId) {
    this.nvlSubnetOwnerId = nvlSubnetOwnerId;
  }

  public DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet nvlVpcName(String nvlVpcName) {
    this.nvlVpcName = nvlVpcName;
    return this;
  }

   /**
   * Get nvlVpcName
   * @return nvlVpcName
  **/
  @ApiModelProperty(example = "", value = "")
  public String getNvlVpcName() {
    return nvlVpcName;
  }

  public void setNvlVpcName(String nvlVpcName) {
    this.nvlVpcName = nvlVpcName;
  }

  public DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet ownerId(String ownerId) {
    this.ownerId = ownerId;
    return this;
  }

   /**
   * Get ownerId
   * @return ownerId
  **/
  @ApiModelProperty(example = "", value = "")
  public String getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(String ownerId) {
    this.ownerId = ownerId;
  }

  public DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet state(StateEnum state) {
    this.state = state;
    return this;
  }

   /**
   * state of the VPC (pending | available | transient | error)
   * @return state
  **/
  @ApiModelProperty(example = "pending", value = "state of the VPC (pending | available | transient | error)")
  public StateEnum getState() {
    return state;
  }

  public void setState(StateEnum state) {
    this.state = state;
  }

  public DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet subnetId(String subnetId) {
    this.subnetId = subnetId;
    return this;
  }

   /**
   * Get subnetId
   * @return subnetId
  **/
  @ApiModelProperty(example = "12", value = "")
  public String getSubnetId() {
    return subnetId;
  }

  public void setSubnetId(String subnetId) {
    this.subnetId = subnetId;
  }

  public DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet tagSet(List<CreateDBInstancesApiRequestSchemaDbinstanceTag> tagSet) {
    this.tagSet = tagSet;
    return this;
  }

  public DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet addTagSetItem(CreateDBInstancesApiRequestSchemaDbinstanceTag tagSetItem) {
    if (this.tagSet == null) {
      this.tagSet = new ArrayList<>();
    }
    this.tagSet.add(tagSetItem);
    return this;
  }

   /**
   * Get tagSet
   * @return tagSet
  **/
  @ApiModelProperty(value = "")
  public List<CreateDBInstancesApiRequestSchemaDbinstanceTag> getTagSet() {
    return tagSet;
  }

  public void setTagSet(List<CreateDBInstancesApiRequestSchemaDbinstanceTag> tagSet) {
    this.tagSet = tagSet;
  }

  public DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet vpcId(String vpcId) {
    this.vpcId = vpcId;
    return this;
  }

   /**
   * Get vpcId
   * @return vpcId
  **/
  @ApiModelProperty(example = "12", value = "")
  public String getVpcId() {
    return vpcId;
  }

  public void setVpcId(String vpcId) {
    this.vpcId = vpcId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet describeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet = (DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet) o;
    return Objects.equals(this.assignIpv6AddressOnCreation, describeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet.assignIpv6AddressOnCreation) &&
        Objects.equals(this.availabilityZone, describeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet.availabilityZone) &&
        Objects.equals(this.availableIpAddressCount, describeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet.availableIpAddressCount) &&
        Objects.equals(this.cidrBlock, describeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet.cidrBlock) &&
        Objects.equals(this.defaultForAz, describeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet.defaultForAz) &&
        Objects.equals(this.ipv6CidrBlockAssociationSet, describeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet.ipv6CidrBlockAssociationSet) &&
        Objects.equals(this.mapPublicIpOnLaunch, describeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet.mapPublicIpOnLaunch) &&
        Objects.equals(this.nvlName, describeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet.nvlName) &&
        Objects.equals(this.nvlSubnetOwnerAlias, describeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet.nvlSubnetOwnerAlias) &&
        Objects.equals(this.nvlSubnetOwnerId, describeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet.nvlSubnetOwnerId) &&
        Objects.equals(this.nvlVpcName, describeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet.nvlVpcName) &&
        Objects.equals(this.ownerId, describeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet.ownerId) &&
        Objects.equals(this.state, describeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet.state) &&
        Objects.equals(this.subnetId, describeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet.subnetId) &&
        Objects.equals(this.tagSet, describeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet.tagSet) &&
        Objects.equals(this.vpcId, describeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet.vpcId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(assignIpv6AddressOnCreation, availabilityZone, availableIpAddressCount, cidrBlock, defaultForAz, ipv6CidrBlockAssociationSet, mapPublicIpOnLaunch, nvlName, nvlSubnetOwnerAlias, nvlSubnetOwnerId, nvlVpcName, ownerId, state, subnetId, tagSet, vpcId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet {\n");
    
    sb.append("    assignIpv6AddressOnCreation: ").append(toIndentedString(assignIpv6AddressOnCreation)).append("\n");
    sb.append("    availabilityZone: ").append(toIndentedString(availabilityZone)).append("\n");
    sb.append("    availableIpAddressCount: ").append(toIndentedString(availableIpAddressCount)).append("\n");
    sb.append("    cidrBlock: ").append(toIndentedString(cidrBlock)).append("\n");
    sb.append("    defaultForAz: ").append(toIndentedString(defaultForAz)).append("\n");
    sb.append("    ipv6CidrBlockAssociationSet: ").append(toIndentedString(ipv6CidrBlockAssociationSet)).append("\n");
    sb.append("    mapPublicIpOnLaunch: ").append(toIndentedString(mapPublicIpOnLaunch)).append("\n");
    sb.append("    nvlName: ").append(toIndentedString(nvlName)).append("\n");
    sb.append("    nvlSubnetOwnerAlias: ").append(toIndentedString(nvlSubnetOwnerAlias)).append("\n");
    sb.append("    nvlSubnetOwnerId: ").append(toIndentedString(nvlSubnetOwnerId)).append("\n");
    sb.append("    nvlVpcName: ").append(toIndentedString(nvlVpcName)).append("\n");
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    subnetId: ").append(toIndentedString(subnetId)).append("\n");
    sb.append("    tagSet: ").append(toIndentedString(tagSet)).append("\n");
    sb.append("    vpcId: ").append(toIndentedString(vpcId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
