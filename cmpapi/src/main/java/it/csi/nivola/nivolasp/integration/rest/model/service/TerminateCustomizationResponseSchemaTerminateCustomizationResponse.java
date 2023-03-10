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
 * TerminateCustomizationResponseSchemaTerminateCustomizationResponse
 */

public class TerminateCustomizationResponseSchemaTerminateCustomizationResponse {
  @JsonProperty("customizationId")
  private String customizationId = null;

  @JsonProperty("requestId")
  private String requestId = null;

  public TerminateCustomizationResponseSchemaTerminateCustomizationResponse customizationId(String customizationId) {
    this.customizationId = customizationId;
    return this;
  }

   /**
   * customization id
   * @return customizationId
  **/
  @ApiModelProperty(example = "3dd726eb-a303-4e97-9f99-d3b79e255b46", required = true, value = "customization id")
  public String getCustomizationId() {
    return customizationId;
  }

  public void setCustomizationId(String customizationId) {
    this.customizationId = customizationId;
  }

  public TerminateCustomizationResponseSchemaTerminateCustomizationResponse requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

   /**
   * api request id
   * @return requestId
  **/
  @ApiModelProperty(example = "123", required = true, value = "api request id")
  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TerminateCustomizationResponseSchemaTerminateCustomizationResponse terminateCustomizationResponseSchemaTerminateCustomizationResponse = (TerminateCustomizationResponseSchemaTerminateCustomizationResponse) o;
    return Objects.equals(this.customizationId, terminateCustomizationResponseSchemaTerminateCustomizationResponse.customizationId) &&
        Objects.equals(this.requestId, terminateCustomizationResponseSchemaTerminateCustomizationResponse.requestId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customizationId, requestId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TerminateCustomizationResponseSchemaTerminateCustomizationResponse {\n");
    
    sb.append("    customizationId: ").append(toIndentedString(customizationId)).append("\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
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

