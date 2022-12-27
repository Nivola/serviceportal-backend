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

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * DescribeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet
 */

public class DescribeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet {
  @JsonProperty("association")
  private DescribeInstancesApiResponseSchemaDescribeInstancesResponseAssociation association = null;

  @JsonProperty("groupSet")
  private List<DescribeInstancesApiResponseSchemaDescribeInstancesResponseGroupSet> groupSet = null;

  @JsonProperty("networkInterfaceId")
  private String networkInterfaceId = null;

  @JsonProperty("privateDnsName")
  private String privateDnsName = null;

  @JsonProperty("privateIpAddressesSet")
  private DescribeInstancesApiResponseSchemaDescribeInstancesResponsePrivateIpAddressesSet privateIpAddressesSet = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("subnetId")
  private String subnetId = null;

  @JsonProperty("vpcId")
  private String vpcId = null;

  public DescribeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet association(DescribeInstancesApiResponseSchemaDescribeInstancesResponseAssociation association) {
    this.association = association;
    return this;
  }

   /**
   * Get association
   * @return association
  **/
  @ApiModelProperty(value = "")
  public DescribeInstancesApiResponseSchemaDescribeInstancesResponseAssociation getAssociation() {
    return association;
  }

  public void setAssociation(DescribeInstancesApiResponseSchemaDescribeInstancesResponseAssociation association) {
    this.association = association;
  }

  public DescribeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet groupSet(List<DescribeInstancesApiResponseSchemaDescribeInstancesResponseGroupSet> groupSet) {
    this.groupSet = groupSet;
    return this;
  }

  public DescribeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet addGroupSetItem(DescribeInstancesApiResponseSchemaDescribeInstancesResponseGroupSet groupSetItem) {
    if (this.groupSet == null) {
      this.groupSet = new ArrayList<>();
    }
    this.groupSet.add(groupSetItem);
    return this;
  }

   /**
   * Get groupSet
   * @return groupSet
  **/
  @ApiModelProperty(value = "")
  public List<DescribeInstancesApiResponseSchemaDescribeInstancesResponseGroupSet> getGroupSet() {
    return groupSet;
  }

  public void setGroupSet(List<DescribeInstancesApiResponseSchemaDescribeInstancesResponseGroupSet> groupSet) {
    this.groupSet = groupSet;
  }

  public DescribeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet networkInterfaceId(String networkInterfaceId) {
    this.networkInterfaceId = networkInterfaceId;
    return this;
  }

   /**
   * network interface id
   * @return networkInterfaceId
  **/
  @ApiModelProperty(example = "", value = "network interface id")
  public String getNetworkInterfaceId() {
    return networkInterfaceId;
  }

  public void setNetworkInterfaceId(String networkInterfaceId) {
    this.networkInterfaceId = networkInterfaceId;
  }

  public DescribeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet privateDnsName(String privateDnsName) {
    this.privateDnsName = privateDnsName;
    return this;
  }

   /**
   * private DNS name of the network interface
   * @return privateDnsName
  **/
  @ApiModelProperty(example = "", value = "private DNS name of the network interface")
  public String getPrivateDnsName() {
    return privateDnsName;
  }

  public void setPrivateDnsName(String privateDnsName) {
    this.privateDnsName = privateDnsName;
  }

  public DescribeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet privateIpAddressesSet(DescribeInstancesApiResponseSchemaDescribeInstancesResponsePrivateIpAddressesSet privateIpAddressesSet) {
    this.privateIpAddressesSet = privateIpAddressesSet;
    return this;
  }

   /**
   * Get privateIpAddressesSet
   * @return privateIpAddressesSet
  **/
  @ApiModelProperty(value = "")
  public DescribeInstancesApiResponseSchemaDescribeInstancesResponsePrivateIpAddressesSet getPrivateIpAddressesSet() {
    return privateIpAddressesSet;
  }

  public void setPrivateIpAddressesSet(DescribeInstancesApiResponseSchemaDescribeInstancesResponsePrivateIpAddressesSet privateIpAddressesSet) {
    this.privateIpAddressesSet = privateIpAddressesSet;
  }

  public DescribeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet status(String status) {
    this.status = status;
    return this;
  }

   /**
   * status of the network interface
   * @return status
  **/
  @ApiModelProperty(example = "", value = "status of the network interface")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public DescribeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet subnetId(String subnetId) {
    this.subnetId = subnetId;
    return this;
  }

   /**
   * subnet id
   * @return subnetId
  **/
  @ApiModelProperty(example = "", value = "subnet id")
  public String getSubnetId() {
    return subnetId;
  }

  public void setSubnetId(String subnetId) {
    this.subnetId = subnetId;
  }

  public DescribeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet vpcId(String vpcId) {
    this.vpcId = vpcId;
    return this;
  }

   /**
   * vpc id
   * @return vpcId
  **/
  @ApiModelProperty(example = "", value = "vpc id")
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
    DescribeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet describeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet = (DescribeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet) o;
    return Objects.equals(this.association, describeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet.association) &&
        Objects.equals(this.groupSet, describeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet.groupSet) &&
        Objects.equals(this.networkInterfaceId, describeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet.networkInterfaceId) &&
        Objects.equals(this.privateDnsName, describeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet.privateDnsName) &&
        Objects.equals(this.privateIpAddressesSet, describeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet.privateIpAddressesSet) &&
        Objects.equals(this.status, describeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet.status) &&
        Objects.equals(this.subnetId, describeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet.subnetId) &&
        Objects.equals(this.vpcId, describeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet.vpcId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(association, groupSet, networkInterfaceId, privateDnsName, privateIpAddressesSet, status, subnetId, vpcId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet {\n");
    
    sb.append("    association: ").append(toIndentedString(association)).append("\n");
    sb.append("    groupSet: ").append(toIndentedString(groupSet)).append("\n");
    sb.append("    networkInterfaceId: ").append(toIndentedString(networkInterfaceId)).append("\n");
    sb.append("    privateDnsName: ").append(toIndentedString(privateDnsName)).append("\n");
    sb.append("    privateIpAddressesSet: ").append(toIndentedString(privateIpAddressesSet)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    subnetId: ").append(toIndentedString(subnetId)).append("\n");
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

