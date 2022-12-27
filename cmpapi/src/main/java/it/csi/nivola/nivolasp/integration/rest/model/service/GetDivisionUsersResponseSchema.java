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
 * GetDivisionUsersResponseSchema
 */

public class GetDivisionUsersResponseSchema {
  @JsonProperty("count")
  private Integer count = null;

  @JsonProperty("users")
  private List<GetDivisionUsersResponseSchemaUsers> users = new ArrayList<>();

  public GetDivisionUsersResponseSchema count(Integer count) {
    this.count = count;
    return this;
  }

   /**
   * Get count
   * @return count
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public GetDivisionUsersResponseSchema users(List<GetDivisionUsersResponseSchemaUsers> users) {
    this.users = users;
    return this;
  }

  public GetDivisionUsersResponseSchema addUsersItem(GetDivisionUsersResponseSchemaUsers usersItem) {
    this.users.add(usersItem);
    return this;
  }

   /**
   * Get users
   * @return users
  **/
  @ApiModelProperty(required = true, value = "")
  public List<GetDivisionUsersResponseSchemaUsers> getUsers() {
    return users;
  }

  public void setUsers(List<GetDivisionUsersResponseSchemaUsers> users) {
    this.users = users;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetDivisionUsersResponseSchema getDivisionUsersResponseSchema = (GetDivisionUsersResponseSchema) o;
    return Objects.equals(this.count, getDivisionUsersResponseSchema.count) &&
        Objects.equals(this.users, getDivisionUsersResponseSchema.users);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, users);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetDivisionUsersResponseSchema {\n");
    
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    users: ").append(toIndentedString(users)).append("\n");
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

