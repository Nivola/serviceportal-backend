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
 * UpdateServiceDefinitionRequestSchema
 */

public class UpdateServiceDefinitionRequestSchema {
  @JsonProperty("servicedef")
  private UpdateServiceDefinitionRequestSchemaServicedef servicedef = null;

  public UpdateServiceDefinitionRequestSchema servicedef(UpdateServiceDefinitionRequestSchemaServicedef servicedef) {
    this.servicedef = servicedef;
    return this;
  }

   /**
   * Get servicedef
   * @return servicedef
  **/
  @ApiModelProperty(value = "")
  public UpdateServiceDefinitionRequestSchemaServicedef getServicedef() {
    return servicedef;
  }

  public void setServicedef(UpdateServiceDefinitionRequestSchemaServicedef servicedef) {
    this.servicedef = servicedef;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateServiceDefinitionRequestSchema updateServiceDefinitionRequestSchema = (UpdateServiceDefinitionRequestSchema) o;
    return Objects.equals(this.servicedef, updateServiceDefinitionRequestSchema.servicedef);
  }

  @Override
  public int hashCode() {
    return Objects.hash(servicedef);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateServiceDefinitionRequestSchema {\n");
    
    sb.append("    servicedef: ").append(toIndentedString(servicedef)).append("\n");
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

