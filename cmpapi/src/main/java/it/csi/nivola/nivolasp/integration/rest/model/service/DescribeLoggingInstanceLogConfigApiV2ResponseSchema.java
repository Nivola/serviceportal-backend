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
 * DescribeLoggingInstanceLogConfigApiV2ResponseSchema
 */

public class DescribeLoggingInstanceLogConfigApiV2ResponseSchema {
  @JsonProperty("DescribeLoggingInstanceLogConfigResponse")
  private DescribeLoggingInstanceLogConfigApiV2ResponseSchemaDescribeLoggingInstanceLogConfigResponse describeLoggingInstanceLogConfigResponse = null;

  public DescribeLoggingInstanceLogConfigApiV2ResponseSchema describeLoggingInstanceLogConfigResponse(DescribeLoggingInstanceLogConfigApiV2ResponseSchemaDescribeLoggingInstanceLogConfigResponse describeLoggingInstanceLogConfigResponse) {
    this.describeLoggingInstanceLogConfigResponse = describeLoggingInstanceLogConfigResponse;
    return this;
  }

   /**
   * Get describeLoggingInstanceLogConfigResponse
   * @return describeLoggingInstanceLogConfigResponse
  **/
  @ApiModelProperty(required = true, value = "")
  public DescribeLoggingInstanceLogConfigApiV2ResponseSchemaDescribeLoggingInstanceLogConfigResponse getDescribeLoggingInstanceLogConfigResponse() {
    return describeLoggingInstanceLogConfigResponse;
  }

  public void setDescribeLoggingInstanceLogConfigResponse(DescribeLoggingInstanceLogConfigApiV2ResponseSchemaDescribeLoggingInstanceLogConfigResponse describeLoggingInstanceLogConfigResponse) {
    this.describeLoggingInstanceLogConfigResponse = describeLoggingInstanceLogConfigResponse;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeLoggingInstanceLogConfigApiV2ResponseSchema describeLoggingInstanceLogConfigApiV2ResponseSchema = (DescribeLoggingInstanceLogConfigApiV2ResponseSchema) o;
    return Objects.equals(this.describeLoggingInstanceLogConfigResponse, describeLoggingInstanceLogConfigApiV2ResponseSchema.describeLoggingInstanceLogConfigResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(describeLoggingInstanceLogConfigResponse);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeLoggingInstanceLogConfigApiV2ResponseSchema {\n");
    
    sb.append("    describeLoggingInstanceLogConfigResponse: ").append(toIndentedString(describeLoggingInstanceLogConfigResponse)).append("\n");
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

