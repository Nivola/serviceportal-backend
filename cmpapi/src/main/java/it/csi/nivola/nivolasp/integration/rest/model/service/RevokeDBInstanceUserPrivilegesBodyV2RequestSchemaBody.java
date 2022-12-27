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
 * RevokeDBInstanceUserPrivilegesBodyV2RequestSchemaBody
 */

public class RevokeDBInstanceUserPrivilegesBodyV2RequestSchemaBody {
  @JsonProperty("DBInstanceIdentifier")
  private String dbInstanceIdentifier = null;

  @JsonProperty("DbName")
  private String dbName = null;

  @JsonProperty("Privileges")
  private String privileges = "ALL";

  @JsonProperty("UserName")
  private String userName = null;

  public RevokeDBInstanceUserPrivilegesBodyV2RequestSchemaBody dbInstanceIdentifier(String dbInstanceIdentifier) {
    this.dbInstanceIdentifier = dbInstanceIdentifier;
    return this;
  }

   /**
   * The DB instance identifier
   * @return dbInstanceIdentifier
  **/
  @ApiModelProperty(required = true, value = "The DB instance identifier")
  public String getDbInstanceIdentifier() {
    return dbInstanceIdentifier;
  }

  public void setDbInstanceIdentifier(String dbInstanceIdentifier) {
    this.dbInstanceIdentifier = dbInstanceIdentifier;
  }

  public RevokeDBInstanceUserPrivilegesBodyV2RequestSchemaBody dbName(String dbName) {
    this.dbName = dbName;
    return this;
  }

   /**
   * The db name
   * @return dbName
  **/
  @ApiModelProperty(required = true, value = "The db name")
  public String getDbName() {
    return dbName;
  }

  public void setDbName(String dbName) {
    this.dbName = dbName;
  }

  public RevokeDBInstanceUserPrivilegesBodyV2RequestSchemaBody privileges(String privileges) {
    this.privileges = privileges;
    return this;
  }

   /**
   * The privileges string like SELECT,INSERT,DELETE,UPDATE or ALL
   * @return privileges
  **/
  @ApiModelProperty(example = "ALL", value = "The privileges string like SELECT,INSERT,DELETE,UPDATE or ALL")
  public String getPrivileges() {
    return privileges;
  }

  public void setPrivileges(String privileges) {
    this.privileges = privileges;
  }

  public RevokeDBInstanceUserPrivilegesBodyV2RequestSchemaBody userName(String userName) {
    this.userName = userName;
    return this;
  }

   /**
   * The user name
   * @return userName
  **/
  @ApiModelProperty(example = "testuser", required = true, value = "The user name")
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RevokeDBInstanceUserPrivilegesBodyV2RequestSchemaBody revokeDBInstanceUserPrivilegesBodyV2RequestSchemaBody = (RevokeDBInstanceUserPrivilegesBodyV2RequestSchemaBody) o;
    return Objects.equals(this.dbInstanceIdentifier, revokeDBInstanceUserPrivilegesBodyV2RequestSchemaBody.dbInstanceIdentifier) &&
        Objects.equals(this.dbName, revokeDBInstanceUserPrivilegesBodyV2RequestSchemaBody.dbName) &&
        Objects.equals(this.privileges, revokeDBInstanceUserPrivilegesBodyV2RequestSchemaBody.privileges) &&
        Objects.equals(this.userName, revokeDBInstanceUserPrivilegesBodyV2RequestSchemaBody.userName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dbInstanceIdentifier, dbName, privileges, userName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RevokeDBInstanceUserPrivilegesBodyV2RequestSchemaBody {\n");
    
    sb.append("    dbInstanceIdentifier: ").append(toIndentedString(dbInstanceIdentifier)).append("\n");
    sb.append("    dbName: ").append(toIndentedString(dbName)).append("\n");
    sb.append("    privileges: ").append(toIndentedString(privileges)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
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

