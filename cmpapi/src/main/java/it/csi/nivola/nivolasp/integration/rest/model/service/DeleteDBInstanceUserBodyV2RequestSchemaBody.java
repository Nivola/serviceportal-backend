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
 * DeleteDBInstanceUserBodyV2RequestSchemaBody
 */

public class DeleteDBInstanceUserBodyV2RequestSchemaBody {
  @JsonProperty("DBInstanceIdentifier")
  private String dbInstanceIdentifier = null;

  @JsonProperty("Name")
  private String name = null;

  public DeleteDBInstanceUserBodyV2RequestSchemaBody dbInstanceIdentifier(String dbInstanceIdentifier) {
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

  public DeleteDBInstanceUserBodyV2RequestSchemaBody name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The user name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The user name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeleteDBInstanceUserBodyV2RequestSchemaBody deleteDBInstanceUserBodyV2RequestSchemaBody = (DeleteDBInstanceUserBodyV2RequestSchemaBody) o;
    return Objects.equals(this.dbInstanceIdentifier, deleteDBInstanceUserBodyV2RequestSchemaBody.dbInstanceIdentifier) &&
        Objects.equals(this.name, deleteDBInstanceUserBodyV2RequestSchemaBody.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dbInstanceIdentifier, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteDBInstanceUserBodyV2RequestSchemaBody {\n");
    
    sb.append("    dbInstanceIdentifier: ").append(toIndentedString(dbInstanceIdentifier)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
