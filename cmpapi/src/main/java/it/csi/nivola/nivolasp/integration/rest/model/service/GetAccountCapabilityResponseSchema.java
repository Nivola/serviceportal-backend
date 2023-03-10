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
 * GetAccountCapabilityResponseSchema
 */

public class GetAccountCapabilityResponseSchema {
  @JsonProperty("capabilities")
  private GetAccountCapabilityResponseSchemaCapabilities capabilities = null;

  public GetAccountCapabilityResponseSchema capabilities(GetAccountCapabilityResponseSchemaCapabilities capabilities) {
    this.capabilities = capabilities;
    return this;
  }

   /**
   * Get capabilities
   * @return capabilities
  **/
  @ApiModelProperty(required = true, value = "")
  public GetAccountCapabilityResponseSchemaCapabilities getCapabilities() {
    return capabilities;
  }

  public void setCapabilities(GetAccountCapabilityResponseSchemaCapabilities capabilities) {
    this.capabilities = capabilities;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetAccountCapabilityResponseSchema getAccountCapabilityResponseSchema = (GetAccountCapabilityResponseSchema) o;
    return Objects.equals(this.capabilities, getAccountCapabilityResponseSchema.capabilities);
  }

  @Override
  public int hashCode() {
    return Objects.hash(capabilities);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetAccountCapabilityResponseSchema {\n");
    
    sb.append("    capabilities: ").append(toIndentedString(capabilities)).append("\n");
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

