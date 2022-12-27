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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * GetAccountUserRolesResponseSchema
 */

public class GetAccountUserRolesResponseSchema {
  @JsonProperty("usernames")
  private List<GetAccountUserRolesResponseSchemaUsernames> usernames = new ArrayList<>();

  public GetAccountUserRolesResponseSchema usernames(List<GetAccountUserRolesResponseSchemaUsernames> usernames) {
    this.usernames = usernames;
    return this;
  }

  public GetAccountUserRolesResponseSchema addUsernamesItem(GetAccountUserRolesResponseSchemaUsernames usernamesItem) {
    this.usernames.add(usernamesItem);
    return this;
  }

   /**
   * Get usernames
   * @return usernames
  **/
  @ApiModelProperty(required = true, value = "")
  public List<GetAccountUserRolesResponseSchemaUsernames> getUsernames() {
    return usernames;
  }

  public void setUsernames(List<GetAccountUserRolesResponseSchemaUsernames> usernames) {
    this.usernames = usernames;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetAccountUserRolesResponseSchema getAccountUserRolesResponseSchema = (GetAccountUserRolesResponseSchema) o;
    return Objects.equals(this.usernames, getAccountUserRolesResponseSchema.usernames);
  }

  @Override
  public int hashCode() {
    return Objects.hash(usernames);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetAccountUserRolesResponseSchema {\n");
    
    sb.append("    usernames: ").append(toIndentedString(usernames)).append("\n");
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

