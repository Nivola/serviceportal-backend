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
 * GrantDBInstanceUserPrivilegesApiV2ResponseSchema
 */

public class GrantDBInstanceUserPrivilegesApiV2ResponseSchema {
  @JsonProperty("GrantDBInstanceUserPrivilegesResponse")
  private GrantDBInstanceUserPrivilegesApiV2ResponseSchemaGrantDBInstanceUserPrivilegesResponse grantDBInstanceUserPrivilegesResponse = null;

  public GrantDBInstanceUserPrivilegesApiV2ResponseSchema grantDBInstanceUserPrivilegesResponse(GrantDBInstanceUserPrivilegesApiV2ResponseSchemaGrantDBInstanceUserPrivilegesResponse grantDBInstanceUserPrivilegesResponse) {
    this.grantDBInstanceUserPrivilegesResponse = grantDBInstanceUserPrivilegesResponse;
    return this;
  }

   /**
   * Get grantDBInstanceUserPrivilegesResponse
   * @return grantDBInstanceUserPrivilegesResponse
  **/
  @ApiModelProperty(required = true, value = "")
  public GrantDBInstanceUserPrivilegesApiV2ResponseSchemaGrantDBInstanceUserPrivilegesResponse getGrantDBInstanceUserPrivilegesResponse() {
    return grantDBInstanceUserPrivilegesResponse;
  }

  public void setGrantDBInstanceUserPrivilegesResponse(GrantDBInstanceUserPrivilegesApiV2ResponseSchemaGrantDBInstanceUserPrivilegesResponse grantDBInstanceUserPrivilegesResponse) {
    this.grantDBInstanceUserPrivilegesResponse = grantDBInstanceUserPrivilegesResponse;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GrantDBInstanceUserPrivilegesApiV2ResponseSchema grantDBInstanceUserPrivilegesApiV2ResponseSchema = (GrantDBInstanceUserPrivilegesApiV2ResponseSchema) o;
    return Objects.equals(this.grantDBInstanceUserPrivilegesResponse, grantDBInstanceUserPrivilegesApiV2ResponseSchema.grantDBInstanceUserPrivilegesResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(grantDBInstanceUserPrivilegesResponse);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GrantDBInstanceUserPrivilegesApiV2ResponseSchema {\n");
    
    sb.append("    grantDBInstanceUserPrivilegesResponse: ").append(toIndentedString(grantDBInstanceUserPrivilegesResponse)).append("\n");
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

