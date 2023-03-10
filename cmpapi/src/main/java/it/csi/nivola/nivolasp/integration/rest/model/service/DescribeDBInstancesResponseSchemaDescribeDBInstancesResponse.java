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
 * DescribeDBInstancesResponseSchemaDescribeDBInstancesResponse
 */

public class DescribeDBInstancesResponseSchemaDescribeDBInstancesResponse {
  @JsonProperty("DescribeDBInstancesResult")
  private DescribeDBInstancesResponseSchemaDescribeDBInstancesResponseDescribeDBInstancesResult describeDBInstancesResult = null;

  @JsonProperty("ResponseMetadata")
  private ChangeDBInstanceUserPasswordApiV2ResponseSchemaChangeDBInstanceUserPasswordResponseResponseMetadata responseMetadata = null;

  public DescribeDBInstancesResponseSchemaDescribeDBInstancesResponse describeDBInstancesResult(DescribeDBInstancesResponseSchemaDescribeDBInstancesResponseDescribeDBInstancesResult describeDBInstancesResult) {
    this.describeDBInstancesResult = describeDBInstancesResult;
    return this;
  }

   /**
   * Get describeDBInstancesResult
   * @return describeDBInstancesResult
  **/
  @ApiModelProperty(required = true, value = "")
  public DescribeDBInstancesResponseSchemaDescribeDBInstancesResponseDescribeDBInstancesResult getDescribeDBInstancesResult() {
    return describeDBInstancesResult;
  }

  public void setDescribeDBInstancesResult(DescribeDBInstancesResponseSchemaDescribeDBInstancesResponseDescribeDBInstancesResult describeDBInstancesResult) {
    this.describeDBInstancesResult = describeDBInstancesResult;
  }

  public DescribeDBInstancesResponseSchemaDescribeDBInstancesResponse responseMetadata(ChangeDBInstanceUserPasswordApiV2ResponseSchemaChangeDBInstanceUserPasswordResponseResponseMetadata responseMetadata) {
    this.responseMetadata = responseMetadata;
    return this;
  }

   /**
   * Get responseMetadata
   * @return responseMetadata
  **/
  @ApiModelProperty(value = "")
  public ChangeDBInstanceUserPasswordApiV2ResponseSchemaChangeDBInstanceUserPasswordResponseResponseMetadata getResponseMetadata() {
    return responseMetadata;
  }

  public void setResponseMetadata(ChangeDBInstanceUserPasswordApiV2ResponseSchemaChangeDBInstanceUserPasswordResponseResponseMetadata responseMetadata) {
    this.responseMetadata = responseMetadata;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeDBInstancesResponseSchemaDescribeDBInstancesResponse describeDBInstancesResponseSchemaDescribeDBInstancesResponse = (DescribeDBInstancesResponseSchemaDescribeDBInstancesResponse) o;
    return Objects.equals(this.describeDBInstancesResult, describeDBInstancesResponseSchemaDescribeDBInstancesResponse.describeDBInstancesResult) &&
        Objects.equals(this.responseMetadata, describeDBInstancesResponseSchemaDescribeDBInstancesResponse.responseMetadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(describeDBInstancesResult, responseMetadata);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeDBInstancesResponseSchemaDescribeDBInstancesResponse {\n");
    
    sb.append("    describeDBInstancesResult: ").append(toIndentedString(describeDBInstancesResult)).append("\n");
    sb.append("    responseMetadata: ").append(toIndentedString(responseMetadata)).append("\n");
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

