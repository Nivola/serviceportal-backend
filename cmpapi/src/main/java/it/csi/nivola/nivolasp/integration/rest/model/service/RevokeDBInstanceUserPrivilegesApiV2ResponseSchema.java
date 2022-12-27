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
 * RevokeDBInstanceUserPrivilegesApiV2ResponseSchema
 */

public class RevokeDBInstanceUserPrivilegesApiV2ResponseSchema {
  @JsonProperty("RevokeDBInstanceUserPrivilegesResponse")
  private RevokeDBInstanceUserPrivilegesApiV2ResponseSchemaRevokeDBInstanceUserPrivilegesResponse revokeDBInstanceUserPrivilegesResponse = null;

  public RevokeDBInstanceUserPrivilegesApiV2ResponseSchema revokeDBInstanceUserPrivilegesResponse(RevokeDBInstanceUserPrivilegesApiV2ResponseSchemaRevokeDBInstanceUserPrivilegesResponse revokeDBInstanceUserPrivilegesResponse) {
    this.revokeDBInstanceUserPrivilegesResponse = revokeDBInstanceUserPrivilegesResponse;
    return this;
  }

   /**
   * Get revokeDBInstanceUserPrivilegesResponse
   * @return revokeDBInstanceUserPrivilegesResponse
  **/
  @ApiModelProperty(required = true, value = "")
  public RevokeDBInstanceUserPrivilegesApiV2ResponseSchemaRevokeDBInstanceUserPrivilegesResponse getRevokeDBInstanceUserPrivilegesResponse() {
    return revokeDBInstanceUserPrivilegesResponse;
  }

  public void setRevokeDBInstanceUserPrivilegesResponse(RevokeDBInstanceUserPrivilegesApiV2ResponseSchemaRevokeDBInstanceUserPrivilegesResponse revokeDBInstanceUserPrivilegesResponse) {
    this.revokeDBInstanceUserPrivilegesResponse = revokeDBInstanceUserPrivilegesResponse;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RevokeDBInstanceUserPrivilegesApiV2ResponseSchema revokeDBInstanceUserPrivilegesApiV2ResponseSchema = (RevokeDBInstanceUserPrivilegesApiV2ResponseSchema) o;
    return Objects.equals(this.revokeDBInstanceUserPrivilegesResponse, revokeDBInstanceUserPrivilegesApiV2ResponseSchema.revokeDBInstanceUserPrivilegesResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(revokeDBInstanceUserPrivilegesResponse);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RevokeDBInstanceUserPrivilegesApiV2ResponseSchema {\n");
    
    sb.append("    revokeDBInstanceUserPrivilegesResponse: ").append(toIndentedString(revokeDBInstanceUserPrivilegesResponse)).append("\n");
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

