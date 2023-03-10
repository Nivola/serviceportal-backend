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
 * DescribeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResultSchemas
 */

public class DescribeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResultSchemas {
  @JsonProperty("access_privileges")
  private String accessPrivileges = null;

  @JsonProperty("charset")
  private String charset = null;

  @JsonProperty("collation")
  private String collation = null;

  @JsonProperty("db_name")
  private String dbName = null;

  public DescribeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResultSchemas accessPrivileges(String accessPrivileges) {
    this.accessPrivileges = accessPrivileges;
    return this;
  }

   /**
   * The database or schema access privileges
   * @return accessPrivileges
  **/
  @ApiModelProperty(value = "The database or schema access privileges")
  public String getAccessPrivileges() {
    return accessPrivileges;
  }

  public void setAccessPrivileges(String accessPrivileges) {
    this.accessPrivileges = accessPrivileges;
  }

  public DescribeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResultSchemas charset(String charset) {
    this.charset = charset;
    return this;
  }

   /**
   * The database or schema charset
   * @return charset
  **/
  @ApiModelProperty(required = true, value = "The database or schema charset")
  public String getCharset() {
    return charset;
  }

  public void setCharset(String charset) {
    this.charset = charset;
  }

  public DescribeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResultSchemas collation(String collation) {
    this.collation = collation;
    return this;
  }

   /**
   * The database or schema collation
   * @return collation
  **/
  @ApiModelProperty(required = true, value = "The database or schema collation")
  public String getCollation() {
    return collation;
  }

  public void setCollation(String collation) {
    this.collation = collation;
  }

  public DescribeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResultSchemas dbName(String dbName) {
    this.dbName = dbName;
    return this;
  }

   /**
   * The database or schema name
   * @return dbName
  **/
  @ApiModelProperty(required = true, value = "The database or schema name")
  public String getDbName() {
    return dbName;
  }

  public void setDbName(String dbName) {
    this.dbName = dbName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResultSchemas describeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResultSchemas = (DescribeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResultSchemas) o;
    return Objects.equals(this.accessPrivileges, describeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResultSchemas.accessPrivileges) &&
        Objects.equals(this.charset, describeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResultSchemas.charset) &&
        Objects.equals(this.collation, describeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResultSchemas.collation) &&
        Objects.equals(this.dbName, describeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResultSchemas.dbName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessPrivileges, charset, collation, dbName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResultSchemas {\n");
    
    sb.append("    accessPrivileges: ").append(toIndentedString(accessPrivileges)).append("\n");
    sb.append("    charset: ").append(toIndentedString(charset)).append("\n");
    sb.append("    collation: ").append(toIndentedString(collation)).append("\n");
    sb.append("    dbName: ").append(toIndentedString(dbName)).append("\n");
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

