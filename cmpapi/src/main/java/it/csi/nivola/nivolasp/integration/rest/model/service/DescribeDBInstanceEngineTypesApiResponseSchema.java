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
 * DescribeDBInstanceEngineTypesApiResponseSchema
 */

public class DescribeDBInstanceEngineTypesApiResponseSchema {
  @JsonProperty("DescribeDBInstanceEngineTypesResponse")
  private DescribeDBInstanceEngineTypesApiResponseSchemaDescribeDBInstanceEngineTypesResponse describeDBInstanceEngineTypesResponse = null;

  public DescribeDBInstanceEngineTypesApiResponseSchema describeDBInstanceEngineTypesResponse(DescribeDBInstanceEngineTypesApiResponseSchemaDescribeDBInstanceEngineTypesResponse describeDBInstanceEngineTypesResponse) {
    this.describeDBInstanceEngineTypesResponse = describeDBInstanceEngineTypesResponse;
    return this;
  }

   /**
   * Get describeDBInstanceEngineTypesResponse
   * @return describeDBInstanceEngineTypesResponse
  **/
  @ApiModelProperty(required = true, value = "")
  public DescribeDBInstanceEngineTypesApiResponseSchemaDescribeDBInstanceEngineTypesResponse getDescribeDBInstanceEngineTypesResponse() {
    return describeDBInstanceEngineTypesResponse;
  }

  public void setDescribeDBInstanceEngineTypesResponse(DescribeDBInstanceEngineTypesApiResponseSchemaDescribeDBInstanceEngineTypesResponse describeDBInstanceEngineTypesResponse) {
    this.describeDBInstanceEngineTypesResponse = describeDBInstanceEngineTypesResponse;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeDBInstanceEngineTypesApiResponseSchema describeDBInstanceEngineTypesApiResponseSchema = (DescribeDBInstanceEngineTypesApiResponseSchema) o;
    return Objects.equals(this.describeDBInstanceEngineTypesResponse, describeDBInstanceEngineTypesApiResponseSchema.describeDBInstanceEngineTypesResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(describeDBInstanceEngineTypesResponse);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeDBInstanceEngineTypesApiResponseSchema {\n");
    
    sb.append("    describeDBInstanceEngineTypesResponse: ").append(toIndentedString(describeDBInstanceEngineTypesResponse)).append("\n");
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
