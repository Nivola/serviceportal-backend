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
 * DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo
 */

public class DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo {
  @JsonProperty("groupDescription")
  private String groupDescription = null;

  @JsonProperty("groupId")
  private String groupId = null;

  @JsonProperty("groupName")
  private String groupName = null;

  @JsonProperty("ipPermissions")
  private List<DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseIpPermissions> ipPermissions = null;

  @JsonProperty("ipPermissionsEgress")
  private List<DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseIpPermissions> ipPermissionsEgress = null;

  @JsonProperty("nvl-sgOwnerAlias")
  private String nvlSgOwnerAlias = null;

  @JsonProperty("nvl-sgOwnerId")
  private String nvlSgOwnerId = null;

  /**
   * state of the SecurityGroup
   */
  public enum NvlStateEnum {
    AVAILABLE("available"),
    
    DEREGISTERED("deregistered"),
    
    DEREGISTERING("deregistering"),
    
    ERROR("error"),
    
    PENDING("pending"),
    
    TRANSIENT("transient"),
    
    UNKNOWN("unknown"),
    
    UPDATING("updating");

    private String value;

    NvlStateEnum(String value) {
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
    public static NvlStateEnum fromValue(String value) {
      for (NvlStateEnum b : NvlStateEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("nvl-state")
  private NvlStateEnum nvlState = null;

  @JsonProperty("nvl-stateReason")
  private DeleteDBInstancesApiResponseSchemaDeleteDBInstanceResponseDeleteDBInstanceResultDBInstanceNvlstateReason nvlStateReason = null;

  @JsonProperty("nvl-vpcName")
  private String nvlVpcName = null;

  @JsonProperty("ownerId")
  private String ownerId = null;

  @JsonProperty("tagSet")
  private List<DescribeImagesResponseSchemaDescribeImagesResponseTagSet> tagSet = null;

  @JsonProperty("vpcId")
  private String vpcId = null;

  public DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo groupDescription(String groupDescription) {
    this.groupDescription = groupDescription;
    return this;
  }

   /**
   * instance security group description
   * @return groupDescription
  **/
  @ApiModelProperty(example = "", value = "instance security group description")
  public String getGroupDescription() {
    return groupDescription;
  }

  public void setGroupDescription(String groupDescription) {
    this.groupDescription = groupDescription;
  }

  public DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo groupId(String groupId) {
    this.groupId = groupId;
    return this;
  }

   /**
   * instance security group identifier
   * @return groupId
  **/
  @ApiModelProperty(example = "", value = "instance security group identifier")
  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo groupName(String groupName) {
    this.groupName = groupName;
    return this;
  }

   /**
   * instance security group name
   * @return groupName
  **/
  @ApiModelProperty(example = "", value = "instance security group name")
  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo ipPermissions(List<DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseIpPermissions> ipPermissions) {
    this.ipPermissions = ipPermissions;
    return this;
  }

  public DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo addIpPermissionsItem(DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseIpPermissions ipPermissionsItem) {
    if (this.ipPermissions == null) {
      this.ipPermissions = new ArrayList<>();
    }
    this.ipPermissions.add(ipPermissionsItem);
    return this;
  }

   /**
   * One or more inbound rules associated with the security group
   * @return ipPermissions
  **/
  @ApiModelProperty(value = "One or more inbound rules associated with the security group")
  public List<DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseIpPermissions> getIpPermissions() {
    return ipPermissions;
  }

  public void setIpPermissions(List<DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseIpPermissions> ipPermissions) {
    this.ipPermissions = ipPermissions;
  }

  public DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo ipPermissionsEgress(List<DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseIpPermissions> ipPermissionsEgress) {
    this.ipPermissionsEgress = ipPermissionsEgress;
    return this;
  }

  public DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo addIpPermissionsEgressItem(DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseIpPermissions ipPermissionsEgressItem) {
    if (this.ipPermissionsEgress == null) {
      this.ipPermissionsEgress = new ArrayList<>();
    }
    this.ipPermissionsEgress.add(ipPermissionsEgressItem);
    return this;
  }

   /**
   * One or more outbound rules associated with the security group
   * @return ipPermissionsEgress
  **/
  @ApiModelProperty(value = "One or more outbound rules associated with the security group")
  public List<DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseIpPermissions> getIpPermissionsEgress() {
    return ipPermissionsEgress;
  }

  public void setIpPermissionsEgress(List<DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseIpPermissions> ipPermissionsEgress) {
    this.ipPermissionsEgress = ipPermissionsEgress;
  }

  public DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo nvlSgOwnerAlias(String nvlSgOwnerAlias) {
    this.nvlSgOwnerAlias = nvlSgOwnerAlias;
    return this;
  }

   /**
   * Get nvlSgOwnerAlias
   * @return nvlSgOwnerAlias
  **/
  @ApiModelProperty(example = "", value = "")
  public String getNvlSgOwnerAlias() {
    return nvlSgOwnerAlias;
  }

  public void setNvlSgOwnerAlias(String nvlSgOwnerAlias) {
    this.nvlSgOwnerAlias = nvlSgOwnerAlias;
  }

  public DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo nvlSgOwnerId(String nvlSgOwnerId) {
    this.nvlSgOwnerId = nvlSgOwnerId;
    return this;
  }

   /**
   * Get nvlSgOwnerId
   * @return nvlSgOwnerId
  **/
  @ApiModelProperty(example = "", value = "")
  public String getNvlSgOwnerId() {
    return nvlSgOwnerId;
  }

  public void setNvlSgOwnerId(String nvlSgOwnerId) {
    this.nvlSgOwnerId = nvlSgOwnerId;
  }

  public DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo nvlState(NvlStateEnum nvlState) {
    this.nvlState = nvlState;
    return this;
  }

   /**
   * state of the SecurityGroup
   * @return nvlState
  **/
  @ApiModelProperty(example = "", value = "state of the SecurityGroup")
  public NvlStateEnum getNvlState() {
    return nvlState;
  }

  public void setNvlState(NvlStateEnum nvlState) {
    this.nvlState = nvlState;
  }

  public DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo nvlStateReason(DeleteDBInstancesApiResponseSchemaDeleteDBInstanceResponseDeleteDBInstanceResultDBInstanceNvlstateReason nvlStateReason) {
    this.nvlStateReason = nvlStateReason;
    return this;
  }

   /**
   * Get nvlStateReason
   * @return nvlStateReason
  **/
  @ApiModelProperty(value = "")
  public DeleteDBInstancesApiResponseSchemaDeleteDBInstanceResponseDeleteDBInstanceResultDBInstanceNvlstateReason getNvlStateReason() {
    return nvlStateReason;
  }

  public void setNvlStateReason(DeleteDBInstancesApiResponseSchemaDeleteDBInstanceResponseDeleteDBInstanceResultDBInstanceNvlstateReason nvlStateReason) {
    this.nvlStateReason = nvlStateReason;
  }

  public DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo nvlVpcName(String nvlVpcName) {
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

  public DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo ownerId(String ownerId) {
    this.ownerId = ownerId;
    return this;
  }

   /**
   * account ID of the owner of the instance security group
   * @return ownerId
  **/
  @ApiModelProperty(example = "", value = "account ID of the owner of the instance security group")
  public String getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(String ownerId) {
    this.ownerId = ownerId;
  }

  public DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo tagSet(List<DescribeImagesResponseSchemaDescribeImagesResponseTagSet> tagSet) {
    this.tagSet = tagSet;
    return this;
  }

  public DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo addTagSetItem(DescribeImagesResponseSchemaDescribeImagesResponseTagSet tagSetItem) {
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
  public List<DescribeImagesResponseSchemaDescribeImagesResponseTagSet> getTagSet() {
    return tagSet;
  }

  public void setTagSet(List<DescribeImagesResponseSchemaDescribeImagesResponseTagSet> tagSet) {
    this.tagSet = tagSet;
  }

  public DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo vpcId(String vpcId) {
    this.vpcId = vpcId;
    return this;
  }

   /**
   * Get vpcId
   * @return vpcId
  **/
  @ApiModelProperty(example = "", value = "")
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
    DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo describeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo = (DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo) o;
    return Objects.equals(this.groupDescription, describeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo.groupDescription) &&
        Objects.equals(this.groupId, describeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo.groupId) &&
        Objects.equals(this.groupName, describeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo.groupName) &&
        Objects.equals(this.ipPermissions, describeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo.ipPermissions) &&
        Objects.equals(this.ipPermissionsEgress, describeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo.ipPermissionsEgress) &&
        Objects.equals(this.nvlSgOwnerAlias, describeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo.nvlSgOwnerAlias) &&
        Objects.equals(this.nvlSgOwnerId, describeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo.nvlSgOwnerId) &&
        Objects.equals(this.nvlState, describeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo.nvlState) &&
        Objects.equals(this.nvlStateReason, describeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo.nvlStateReason) &&
        Objects.equals(this.nvlVpcName, describeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo.nvlVpcName) &&
        Objects.equals(this.ownerId, describeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo.ownerId) &&
        Objects.equals(this.tagSet, describeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo.tagSet) &&
        Objects.equals(this.vpcId, describeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo.vpcId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(groupDescription, groupId, groupName, ipPermissions, ipPermissionsEgress, nvlSgOwnerAlias, nvlSgOwnerId, nvlState, nvlStateReason, nvlVpcName, ownerId, tagSet, vpcId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo {\n");
    
    sb.append("    groupDescription: ").append(toIndentedString(groupDescription)).append("\n");
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
    sb.append("    groupName: ").append(toIndentedString(groupName)).append("\n");
    sb.append("    ipPermissions: ").append(toIndentedString(ipPermissions)).append("\n");
    sb.append("    ipPermissionsEgress: ").append(toIndentedString(ipPermissionsEgress)).append("\n");
    sb.append("    nvlSgOwnerAlias: ").append(toIndentedString(nvlSgOwnerAlias)).append("\n");
    sb.append("    nvlSgOwnerId: ").append(toIndentedString(nvlSgOwnerId)).append("\n");
    sb.append("    nvlState: ").append(toIndentedString(nvlState)).append("\n");
    sb.append("    nvlStateReason: ").append(toIndentedString(nvlStateReason)).append("\n");
    sb.append("    nvlVpcName: ").append(toIndentedString(nvlVpcName)).append("\n");
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
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

