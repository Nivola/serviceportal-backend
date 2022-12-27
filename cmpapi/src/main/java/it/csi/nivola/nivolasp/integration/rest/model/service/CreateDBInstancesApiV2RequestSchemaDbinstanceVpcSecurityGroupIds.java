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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * a DB security groups to associate with DB instance
 */
@ApiModel(description = "a DB security groups to associate with DB instance")

public class CreateDBInstancesApiV2RequestSchemaDbinstanceVpcSecurityGroupIds {
  @JsonProperty("VpcSecurityGroupId")
  private List<String> vpcSecurityGroupId = new ArrayList<>();

  public CreateDBInstancesApiV2RequestSchemaDbinstanceVpcSecurityGroupIds vpcSecurityGroupId(List<String> vpcSecurityGroupId) {
    this.vpcSecurityGroupId = vpcSecurityGroupId;
    return this;
  }

  public CreateDBInstancesApiV2RequestSchemaDbinstanceVpcSecurityGroupIds addVpcSecurityGroupIdItem(String vpcSecurityGroupIdItem) {
    this.vpcSecurityGroupId.add(vpcSecurityGroupIdItem);
    return this;
  }

   /**
   * security group id
   * @return vpcSecurityGroupId
  **/
  @ApiModelProperty(required = true, value = "security group id")
  public List<String> getVpcSecurityGroupId() {
    return vpcSecurityGroupId;
  }

  public void setVpcSecurityGroupId(List<String> vpcSecurityGroupId) {
    this.vpcSecurityGroupId = vpcSecurityGroupId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateDBInstancesApiV2RequestSchemaDbinstanceVpcSecurityGroupIds createDBInstancesApiV2RequestSchemaDbinstanceVpcSecurityGroupIds = (CreateDBInstancesApiV2RequestSchemaDbinstanceVpcSecurityGroupIds) o;
    return Objects.equals(this.vpcSecurityGroupId, createDBInstancesApiV2RequestSchemaDbinstanceVpcSecurityGroupIds.vpcSecurityGroupId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vpcSecurityGroupId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateDBInstancesApiV2RequestSchemaDbinstanceVpcSecurityGroupIds {\n");
    
    sb.append("    vpcSecurityGroupId: ").append(toIndentedString(vpcSecurityGroupId)).append("\n");
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

