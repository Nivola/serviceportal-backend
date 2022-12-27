/*-
 * ========================LICENSE_START=================================
 * Api CMP
 * %%
 * Copyright (C) 2022 Regione Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | Regione Piemonte
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
 * DescribeLoggingServiceResponseSchema
 */

public class DescribeLoggingServiceResponseSchema {
  @JsonProperty("DescribeLoggingResponse")
  private DescribeLoggingServiceResponseSchemaDescribeLoggingResponse describeLoggingResponse = null;

  public DescribeLoggingServiceResponseSchema describeLoggingResponse(DescribeLoggingServiceResponseSchemaDescribeLoggingResponse describeLoggingResponse) {
    this.describeLoggingResponse = describeLoggingResponse;
    return this;
  }

   /**
   * Get describeLoggingResponse
   * @return describeLoggingResponse
  **/
  @ApiModelProperty(required = true, value = "")
  public DescribeLoggingServiceResponseSchemaDescribeLoggingResponse getDescribeLoggingResponse() {
    return describeLoggingResponse;
  }

  public void setDescribeLoggingResponse(DescribeLoggingServiceResponseSchemaDescribeLoggingResponse describeLoggingResponse) {
    this.describeLoggingResponse = describeLoggingResponse;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeLoggingServiceResponseSchema describeLoggingServiceResponseSchema = (DescribeLoggingServiceResponseSchema) o;
    return Objects.equals(this.describeLoggingResponse, describeLoggingServiceResponseSchema.describeLoggingResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(describeLoggingResponse);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeLoggingServiceResponseSchema {\n");
    
    sb.append("    describeLoggingResponse: ").append(toIndentedString(describeLoggingResponse)).append("\n");
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

