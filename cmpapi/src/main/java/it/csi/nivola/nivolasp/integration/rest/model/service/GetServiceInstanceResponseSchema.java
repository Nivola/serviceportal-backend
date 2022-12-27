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
 * GetServiceInstanceResponseSchema
 */

public class GetServiceInstanceResponseSchema {
  @JsonProperty("serviceinst")
  private CheckServiceInstanceResponseSchemaServiceinst serviceinst = null;

  public GetServiceInstanceResponseSchema serviceinst(CheckServiceInstanceResponseSchemaServiceinst serviceinst) {
    this.serviceinst = serviceinst;
    return this;
  }

   /**
   * Get serviceinst
   * @return serviceinst
  **/
  @ApiModelProperty(required = true, value = "")
  public CheckServiceInstanceResponseSchemaServiceinst getServiceinst() {
    return serviceinst;
  }

  public void setServiceinst(CheckServiceInstanceResponseSchemaServiceinst serviceinst) {
    this.serviceinst = serviceinst;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetServiceInstanceResponseSchema getServiceInstanceResponseSchema = (GetServiceInstanceResponseSchema) o;
    return Objects.equals(this.serviceinst, getServiceInstanceResponseSchema.serviceinst);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceinst);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetServiceInstanceResponseSchema {\n");
    
    sb.append("    serviceinst: ").append(toIndentedString(serviceinst)).append("\n");
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

