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
 * GetConsoleV20ApiResponseSchema
 */

public class GetConsoleV20ApiResponseSchema {
  @JsonProperty("GetConsoleResponse")
  private GetConsoleV20ApiResponseSchemaGetConsoleResponse getConsoleResponse = null;

  public GetConsoleV20ApiResponseSchema getConsoleResponse(GetConsoleV20ApiResponseSchemaGetConsoleResponse getConsoleResponse) {
    this.getConsoleResponse = getConsoleResponse;
    return this;
  }

   /**
   * Get getConsoleResponse
   * @return getConsoleResponse
  **/
  @ApiModelProperty(required = true, value = "")
  public GetConsoleV20ApiResponseSchemaGetConsoleResponse getGetConsoleResponse() {
    return getConsoleResponse;
  }

  public void setGetConsoleResponse(GetConsoleV20ApiResponseSchemaGetConsoleResponse getConsoleResponse) {
    this.getConsoleResponse = getConsoleResponse;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetConsoleV20ApiResponseSchema getConsoleV20ApiResponseSchema = (GetConsoleV20ApiResponseSchema) o;
    return Objects.equals(this.getConsoleResponse, getConsoleV20ApiResponseSchema.getConsoleResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getConsoleResponse);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetConsoleV20ApiResponseSchema {\n");
    
    sb.append("    getConsoleResponse: ").append(toIndentedString(getConsoleResponse)).append("\n");
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

