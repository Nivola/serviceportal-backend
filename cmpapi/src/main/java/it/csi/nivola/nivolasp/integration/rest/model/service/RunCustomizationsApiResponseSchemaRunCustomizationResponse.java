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
 * RunCustomizationsApiResponseSchemaRunCustomizationResponse
 */

public class RunCustomizationsApiResponseSchemaRunCustomizationResponse {
  @JsonProperty("customizationId")
  private String customizationId = null;

  @JsonProperty("requestId")
  private String requestId = null;

  public RunCustomizationsApiResponseSchemaRunCustomizationResponse customizationId(String customizationId) {
    this.customizationId = customizationId;
    return this;
  }

   /**
   * customization id created
   * @return customizationId
  **/
  @ApiModelProperty(example = "6ee1916d-28b9-4d54-9676-63bb20784669", required = true, value = "customization id created")
  public String getCustomizationId() {
    return customizationId;
  }

  public void setCustomizationId(String customizationId) {
    this.customizationId = customizationId;
  }

  public RunCustomizationsApiResponseSchemaRunCustomizationResponse requestId(String requestId) {
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
    RunCustomizationsApiResponseSchemaRunCustomizationResponse runCustomizationsApiResponseSchemaRunCustomizationResponse = (RunCustomizationsApiResponseSchemaRunCustomizationResponse) o;
    return Objects.equals(this.customizationId, runCustomizationsApiResponseSchemaRunCustomizationResponse.customizationId) &&
        Objects.equals(this.requestId, runCustomizationsApiResponseSchemaRunCustomizationResponse.requestId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customizationId, requestId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RunCustomizationsApiResponseSchemaRunCustomizationResponse {\n");
    
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

