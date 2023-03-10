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
 * DetachInternetGatewayResponseSchema
 */

public class DetachInternetGatewayResponseSchema {
  @JsonProperty("DetachInternetGatewayResponse")
  private AttachInternetGatewayResponseSchemaAttachInternetGatewayResponse detachInternetGatewayResponse = null;

  public DetachInternetGatewayResponseSchema detachInternetGatewayResponse(AttachInternetGatewayResponseSchemaAttachInternetGatewayResponse detachInternetGatewayResponse) {
    this.detachInternetGatewayResponse = detachInternetGatewayResponse;
    return this;
  }

   /**
   * Get detachInternetGatewayResponse
   * @return detachInternetGatewayResponse
  **/
  @ApiModelProperty(required = true, value = "")
  public AttachInternetGatewayResponseSchemaAttachInternetGatewayResponse getDetachInternetGatewayResponse() {
    return detachInternetGatewayResponse;
  }

  public void setDetachInternetGatewayResponse(AttachInternetGatewayResponseSchemaAttachInternetGatewayResponse detachInternetGatewayResponse) {
    this.detachInternetGatewayResponse = detachInternetGatewayResponse;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DetachInternetGatewayResponseSchema detachInternetGatewayResponseSchema = (DetachInternetGatewayResponseSchema) o;
    return Objects.equals(this.detachInternetGatewayResponse, detachInternetGatewayResponseSchema.detachInternetGatewayResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(detachInternetGatewayResponse);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DetachInternetGatewayResponseSchema {\n");
    
    sb.append("    detachInternetGatewayResponse: ").append(toIndentedString(detachInternetGatewayResponse)).append("\n");
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

