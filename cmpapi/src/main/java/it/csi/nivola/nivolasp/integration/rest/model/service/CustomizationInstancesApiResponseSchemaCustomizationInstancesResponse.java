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
 * API description in Markdown.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: me@csi.it
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
 * CustomizationInstancesApiResponseSchemaCustomizationInstancesResponse
 */

public class CustomizationInstancesApiResponseSchemaCustomizationInstancesResponse {
  @JsonProperty("customizationId")
  private String customizationId = null;

  @JsonProperty("instanceId")
  private String instanceId = null;

  @JsonProperty("requestId")
  private String requestId = null;

  public CustomizationInstancesApiResponseSchemaCustomizationInstancesResponse customizationId(String customizationId) {
    this.customizationId = customizationId;
    return this;
  }

   /**
   * customization instance id
   * @return customizationId
  **/
  @ApiModelProperty(required = true, value = "customization instance id")
  public String getCustomizationId() {
    return customizationId;
  }

  public void setCustomizationId(String customizationId) {
    this.customizationId = customizationId;
  }

  public CustomizationInstancesApiResponseSchemaCustomizationInstancesResponse instanceId(String instanceId) {
    this.instanceId = instanceId;
    return this;
  }

   /**
   * vm instance id
   * @return instanceId
  **/
  @ApiModelProperty(required = true, value = "vm instance id")
  public String getInstanceId() {
    return instanceId;
  }

  public void setInstanceId(String instanceId) {
    this.instanceId = instanceId;
  }

  public CustomizationInstancesApiResponseSchemaCustomizationInstancesResponse requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

   /**
   * Get requestId
   * @return requestId
  **/
  @ApiModelProperty(required = true, value = "")
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
    CustomizationInstancesApiResponseSchemaCustomizationInstancesResponse customizationInstancesApiResponseSchemaCustomizationInstancesResponse = (CustomizationInstancesApiResponseSchemaCustomizationInstancesResponse) o;
    return Objects.equals(this.customizationId, customizationInstancesApiResponseSchemaCustomizationInstancesResponse.customizationId) &&
        Objects.equals(this.instanceId, customizationInstancesApiResponseSchemaCustomizationInstancesResponse.instanceId) &&
        Objects.equals(this.requestId, customizationInstancesApiResponseSchemaCustomizationInstancesResponse.requestId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customizationId, instanceId, requestId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomizationInstancesApiResponseSchemaCustomizationInstancesResponse {\n");
    
    sb.append("    customizationId: ").append(toIndentedString(customizationId)).append("\n");
    sb.append("    instanceId: ").append(toIndentedString(instanceId)).append("\n");
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
      return "";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

