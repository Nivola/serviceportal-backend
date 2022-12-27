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
 * DescribeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResult
 */

public class DescribeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResult {
  @JsonProperty("Schemas")
  private List<DescribeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResultSchemas> schemas = null;

  @JsonProperty("SchemasTotal")
  private Integer schemasTotal = null;

  public DescribeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResult schemas(List<DescribeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResultSchemas> schemas) {
    this.schemas = schemas;
    return this;
  }

  public DescribeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResult addSchemasItem(DescribeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResultSchemas schemasItem) {
    if (this.schemas == null) {
      this.schemas = new ArrayList<>();
    }
    this.schemas.add(schemasItem);
    return this;
  }

   /**
   * Get schemas
   * @return schemas
  **/
  @ApiModelProperty(value = "")
  public List<DescribeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResultSchemas> getSchemas() {
    return schemas;
  }

  public void setSchemas(List<DescribeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResultSchemas> schemas) {
    this.schemas = schemas;
  }

  public DescribeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResult schemasTotal(Integer schemasTotal) {
    this.schemasTotal = schemasTotal;
    return this;
  }

   /**
   * The database or schema number
   * @return schemasTotal
  **/
  @ApiModelProperty(required = true, value = "The database or schema number")
  public Integer getSchemasTotal() {
    return schemasTotal;
  }

  public void setSchemasTotal(Integer schemasTotal) {
    this.schemasTotal = schemasTotal;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResult describeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResult = (DescribeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResult) o;
    return Objects.equals(this.schemas, describeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResult.schemas) &&
        Objects.equals(this.schemasTotal, describeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResult.schemasTotal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(schemas, schemasTotal);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeDBInstanceSchemaApiV2ResponseSchemaDescribeDBInstanceSchemaResponseDescribeDBInstanceSchemaResult {\n");
    
    sb.append("    schemas: ").append(toIndentedString(schemas)).append("\n");
    sb.append("    schemasTotal: ").append(toIndentedString(schemasTotal)).append("\n");
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

