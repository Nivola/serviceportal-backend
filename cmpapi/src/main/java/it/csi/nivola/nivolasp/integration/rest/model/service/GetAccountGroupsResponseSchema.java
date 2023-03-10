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
 * GetAccountGroupsResponseSchema
 */

public class GetAccountGroupsResponseSchema {
  @JsonProperty("count")
  private Integer count = null;

  @JsonProperty("groups")
  private List<GetAccountGroupsResponseSchemaGroups> groups = new ArrayList<>();

  public GetAccountGroupsResponseSchema count(Integer count) {
    this.count = count;
    return this;
  }

   /**
   * Get count
   * @return count
  **/
  @ApiModelProperty(example = "0", required = true, value = "")
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public GetAccountGroupsResponseSchema groups(List<GetAccountGroupsResponseSchemaGroups> groups) {
    this.groups = groups;
    return this;
  }

  public GetAccountGroupsResponseSchema addGroupsItem(GetAccountGroupsResponseSchemaGroups groupsItem) {
    this.groups.add(groupsItem);
    return this;
  }

   /**
   * Get groups
   * @return groups
  **/
  @ApiModelProperty(required = true, value = "")
  public List<GetAccountGroupsResponseSchemaGroups> getGroups() {
    return groups;
  }

  public void setGroups(List<GetAccountGroupsResponseSchemaGroups> groups) {
    this.groups = groups;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetAccountGroupsResponseSchema getAccountGroupsResponseSchema = (GetAccountGroupsResponseSchema) o;
    return Objects.equals(this.count, getAccountGroupsResponseSchema.count) &&
        Objects.equals(this.groups, getAccountGroupsResponseSchema.groups);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, groups);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetAccountGroupsResponseSchema {\n");
    
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
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

