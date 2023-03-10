/*-
 * ========================LICENSE_START=================================
 * Api CMP
 * %%
 * Copyright (C) 2022 CSI Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | CSI Piemonte
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
 * ModifyInstanceAttributeRequestSchemaInstance
 */

public class ModifyInstanceAttributeRequestSchemaInstance {
  @JsonProperty("GroupId.N")
  private List<String> groupIdN = null;

  @JsonProperty("InstanceId")
  private String instanceId = null;

  @JsonProperty("InstanceType")
  private String instanceType = null;

  @JsonProperty("Nvl_User")
  private ModifyInstanceAttributeRequestSchemaInstanceNvlUser nvlUser = null;

  public ModifyInstanceAttributeRequestSchemaInstance groupIdN(List<String> groupIdN) {
    this.groupIdN = groupIdN;
    return this;
  }

  public ModifyInstanceAttributeRequestSchemaInstance addGroupIdNItem(String groupIdNItem) {
    if (this.groupIdN == null) {
      this.groupIdN = new ArrayList<>();
    }
    this.groupIdN.add(groupIdNItem);
    return this;
  }

   /**
   * Changes the security groups of the instance. You must specify only one security group id followed by :ADD to add and :DEL to remove
   * @return groupIdN
  **/
  @ApiModelProperty(value = "Changes the security groups of the instance. You must specify only one security group id followed by :ADD to add and :DEL to remove")
  public List<String> getGroupIdN() {
    return groupIdN;
  }

  public void setGroupIdN(List<String> groupIdN) {
    this.groupIdN = groupIdN;
  }

  public ModifyInstanceAttributeRequestSchemaInstance instanceId(String instanceId) {
    this.instanceId = instanceId;
    return this;
  }

   /**
   * The ID of the instance.
   * @return instanceId
  **/
  @ApiModelProperty(example = "ce72f656-4c97-4ce7-8bb4-5da60daedc81", required = true, value = "The ID of the instance.")
  public String getInstanceId() {
    return instanceId;
  }

  public void setInstanceId(String instanceId) {
    this.instanceId = instanceId;
  }

  public ModifyInstanceAttributeRequestSchemaInstance instanceType(String instanceType) {
    this.instanceType = instanceType;
    return this;
  }

   /**
   * Changes the instance type to the specified value. For more information, see Instance Types. If the instance type is not valid, the error returned is InvalidInstanceAttributeValue.
   * @return instanceType
  **/
  @ApiModelProperty(example = "ce72f656-4c97-4ce7-8bb4-5da60daedc81", value = "Changes the instance type to the specified value. For more information, see Instance Types. If the instance type is not valid, the error returned is InvalidInstanceAttributeValue.")
  public String getInstanceType() {
    return instanceType;
  }

  public void setInstanceType(String instanceType) {
    this.instanceType = instanceType;
  }

  public ModifyInstanceAttributeRequestSchemaInstance nvlUser(ModifyInstanceAttributeRequestSchemaInstanceNvlUser nvlUser) {
    this.nvlUser = nvlUser;
    return this;
  }

   /**
   * Get nvlUser
   * @return nvlUser
  **/
  @ApiModelProperty(value = "")
  public ModifyInstanceAttributeRequestSchemaInstanceNvlUser getNvlUser() {
    return nvlUser;
  }

  public void setNvlUser(ModifyInstanceAttributeRequestSchemaInstanceNvlUser nvlUser) {
    this.nvlUser = nvlUser;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModifyInstanceAttributeRequestSchemaInstance modifyInstanceAttributeRequestSchemaInstance = (ModifyInstanceAttributeRequestSchemaInstance) o;
    return Objects.equals(this.groupIdN, modifyInstanceAttributeRequestSchemaInstance.groupIdN) &&
        Objects.equals(this.instanceId, modifyInstanceAttributeRequestSchemaInstance.instanceId) &&
        Objects.equals(this.instanceType, modifyInstanceAttributeRequestSchemaInstance.instanceType) &&
        Objects.equals(this.nvlUser, modifyInstanceAttributeRequestSchemaInstance.nvlUser);
  }

  @Override
  public int hashCode() {
    return Objects.hash(groupIdN, instanceId, instanceType, nvlUser);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModifyInstanceAttributeRequestSchemaInstance {\n");
    
    sb.append("    groupIdN: ").append(toIndentedString(groupIdN)).append("\n");
    sb.append("    instanceId: ").append(toIndentedString(instanceId)).append("\n");
    sb.append("    instanceType: ").append(toIndentedString(instanceType)).append("\n");
    sb.append("    nvlUser: ").append(toIndentedString(nvlUser)).append("\n");
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

