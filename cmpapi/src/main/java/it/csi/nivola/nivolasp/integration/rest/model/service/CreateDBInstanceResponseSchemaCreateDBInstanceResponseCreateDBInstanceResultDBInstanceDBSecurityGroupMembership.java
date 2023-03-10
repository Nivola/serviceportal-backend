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

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSecurityGroupMembership
 */

public class CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSecurityGroupMembership {
  @JsonProperty("DBSecurityGroupName")
  private String dbSecurityGroupName = null;

  @JsonProperty("Status")
  private String status = null;

  public CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSecurityGroupMembership dbSecurityGroupName(String dbSecurityGroupName) {
    this.dbSecurityGroupName = dbSecurityGroupName;
    return this;
  }

   /**
   * name of the DB security group
   * @return dbSecurityGroupName
  **/
  @ApiModelProperty(example = "", value = "name of the DB security group")
  public String getDbSecurityGroupName() {
    return dbSecurityGroupName;
  }

  public void setDbSecurityGroupName(String dbSecurityGroupName) {
    this.dbSecurityGroupName = dbSecurityGroupName;
  }

  public CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSecurityGroupMembership status(String status) {
    this.status = status;
    return this;
  }

   /**
   * status of the DB security group
   * @return status
  **/
  @ApiModelProperty(example = "", value = "status of the DB security group")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSecurityGroupMembership createDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSecurityGroupMembership = (CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSecurityGroupMembership) o;
    return Objects.equals(this.dbSecurityGroupName, createDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSecurityGroupMembership.dbSecurityGroupName) &&
        Objects.equals(this.status, createDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSecurityGroupMembership.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dbSecurityGroupName, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSecurityGroupMembership {\n");
    
    sb.append("    dbSecurityGroupName: ").append(toIndentedString(dbSecurityGroupName)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

