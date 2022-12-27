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
 * GetPortalDescRoleResponseSchema
 */

public class GetPortalDescRoleResponseSchema {
  @JsonProperty("desc_sp")
  private String descSp = null;

  @JsonProperty("generic_name")
  private String genericName = null;

  public GetPortalDescRoleResponseSchema descSp(String descSp) {
    this.descSp = descSp;
    return this;
  }

   /**
   * generic descripion of entity role
   * @return descSp
  **/
  @ApiModelProperty(example = "Master di Account", required = true, value = "generic descripion of entity role")
  public String getDescSp() {
    return descSp;
  }

  public void setDescSp(String descSp) {
    this.descSp = descSp;
  }

  public GetPortalDescRoleResponseSchema genericName(String genericName) {
    this.genericName = genericName;
    return this;
  }

   /**
   * generic name entity role
   * @return genericName
  **/
  @ApiModelProperty(example = "AdminAccountRole", required = true, value = "generic name entity role")
  public String getGenericName() {
    return genericName;
  }

  public void setGenericName(String genericName) {
    this.genericName = genericName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetPortalDescRoleResponseSchema getPortalDescRoleResponseSchema = (GetPortalDescRoleResponseSchema) o;
    return Objects.equals(this.descSp, getPortalDescRoleResponseSchema.descSp) &&
        Objects.equals(this.genericName, getPortalDescRoleResponseSchema.genericName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(descSp, genericName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetPortalDescRoleResponseSchema {\n");
    
    sb.append("    descSp: ").append(toIndentedString(descSp)).append("\n");
    sb.append("    genericName: ").append(toIndentedString(genericName)).append("\n");
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

