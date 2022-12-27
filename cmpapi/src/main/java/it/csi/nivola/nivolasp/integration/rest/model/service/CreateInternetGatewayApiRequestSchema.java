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
 * CreateInternetGatewayApiRequestSchema
 */

public class CreateInternetGatewayApiRequestSchema {
  @JsonProperty("gateway")
  private CreateInternetGatewayApiRequestSchemaGateway gateway = null;

  public CreateInternetGatewayApiRequestSchema gateway(CreateInternetGatewayApiRequestSchemaGateway gateway) {
    this.gateway = gateway;
    return this;
  }

   /**
   * Get gateway
   * @return gateway
  **/
  @ApiModelProperty(value = "")
  public CreateInternetGatewayApiRequestSchemaGateway getGateway() {
    return gateway;
  }

  public void setGateway(CreateInternetGatewayApiRequestSchemaGateway gateway) {
    this.gateway = gateway;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateInternetGatewayApiRequestSchema createInternetGatewayApiRequestSchema = (CreateInternetGatewayApiRequestSchema) o;
    return Objects.equals(this.gateway, createInternetGatewayApiRequestSchema.gateway);
  }

  @Override
  public int hashCode() {
    return Objects.hash(gateway);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateInternetGatewayApiRequestSchema {\n");
    
    sb.append("    gateway: ").append(toIndentedString(gateway)).append("\n");
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

