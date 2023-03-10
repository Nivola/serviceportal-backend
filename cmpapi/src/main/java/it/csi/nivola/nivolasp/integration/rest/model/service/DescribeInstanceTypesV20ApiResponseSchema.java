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
 * DescribeInstanceTypesV20ApiResponseSchema
 */

public class DescribeInstanceTypesV20ApiResponseSchema {
  @JsonProperty("DescribeInstanceTypesResponse")
  private DescribeDBInstanceTypesApiV2ResponseSchemaDescribeDBInstanceTypesResponse describeInstanceTypesResponse = null;

  public DescribeInstanceTypesV20ApiResponseSchema describeInstanceTypesResponse(DescribeDBInstanceTypesApiV2ResponseSchemaDescribeDBInstanceTypesResponse describeInstanceTypesResponse) {
    this.describeInstanceTypesResponse = describeInstanceTypesResponse;
    return this;
  }

   /**
   * Get describeInstanceTypesResponse
   * @return describeInstanceTypesResponse
  **/
  @ApiModelProperty(required = true, value = "")
  public DescribeDBInstanceTypesApiV2ResponseSchemaDescribeDBInstanceTypesResponse getDescribeInstanceTypesResponse() {
    return describeInstanceTypesResponse;
  }

  public void setDescribeInstanceTypesResponse(DescribeDBInstanceTypesApiV2ResponseSchemaDescribeDBInstanceTypesResponse describeInstanceTypesResponse) {
    this.describeInstanceTypesResponse = describeInstanceTypesResponse;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeInstanceTypesV20ApiResponseSchema describeInstanceTypesV20ApiResponseSchema = (DescribeInstanceTypesV20ApiResponseSchema) o;
    return Objects.equals(this.describeInstanceTypesResponse, describeInstanceTypesV20ApiResponseSchema.describeInstanceTypesResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(describeInstanceTypesResponse);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeInstanceTypesV20ApiResponseSchema {\n");
    
    sb.append("    describeInstanceTypesResponse: ").append(toIndentedString(describeInstanceTypesResponse)).append("\n");
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

