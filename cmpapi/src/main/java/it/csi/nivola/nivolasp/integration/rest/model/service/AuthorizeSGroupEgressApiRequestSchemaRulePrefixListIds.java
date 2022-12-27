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
 * AuthorizeSGroupEgressApiRequestSchemaRulePrefixListIds
 */

public class AuthorizeSGroupEgressApiRequestSchemaRulePrefixListIds {
  @JsonProperty("description")
  private String description = null;

  @JsonProperty("prefixListId")
  private String prefixListId = null;

  public AuthorizeSGroupEgressApiRequestSchemaRulePrefixListIds description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Description of security group for  the prefix id
   * @return description
  **/
  @ApiModelProperty(example = "", value = "Description of security group for  the prefix id")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public AuthorizeSGroupEgressApiRequestSchemaRulePrefixListIds prefixListId(String prefixListId) {
    this.prefixListId = prefixListId;
    return this;
  }

   /**
   * ID of the prefix
   * @return prefixListId
  **/
  @ApiModelProperty(example = "", value = "ID of the prefix")
  public String getPrefixListId() {
    return prefixListId;
  }

  public void setPrefixListId(String prefixListId) {
    this.prefixListId = prefixListId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthorizeSGroupEgressApiRequestSchemaRulePrefixListIds authorizeSGroupEgressApiRequestSchemaRulePrefixListIds = (AuthorizeSGroupEgressApiRequestSchemaRulePrefixListIds) o;
    return Objects.equals(this.description, authorizeSGroupEgressApiRequestSchemaRulePrefixListIds.description) &&
        Objects.equals(this.prefixListId, authorizeSGroupEgressApiRequestSchemaRulePrefixListIds.prefixListId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, prefixListId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthorizeSGroupEgressApiRequestSchemaRulePrefixListIds {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    prefixListId: ").append(toIndentedString(prefixListId)).append("\n");
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
