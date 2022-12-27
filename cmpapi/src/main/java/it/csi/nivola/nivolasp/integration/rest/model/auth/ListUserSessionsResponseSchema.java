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
 * API description in Markdown.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: me@csi.it
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package it.csi.nivola.nivolasp.integration.rest.model.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ListUserSessionsResponseSchema
 */

public class ListUserSessionsResponseSchema {
  @JsonProperty("count")
  private Integer count = null;

  @JsonProperty("user_sessions")
  private List<Object> userSessions = new ArrayList<>();

  public ListUserSessionsResponseSchema count(Integer count) {
    this.count = count;
    return this;
  }

   /**
   * User sessions count
   * @return count
  **/
  @ApiModelProperty(example = "1", required = true, value = "User sessions count")
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public ListUserSessionsResponseSchema userSessions(List<Object> userSessions) {
    this.userSessions = userSessions;
    return this;
  }

  public ListUserSessionsResponseSchema addUserSessionsItem(Object userSessionsItem) {
    this.userSessions.add(userSessionsItem);
    return this;
  }

   /**
   * List of user sessions
   * @return userSessions
  **/
  @ApiModelProperty(required = true, value = "List of user sessions")
  public List<Object> getUserSessions() {
    return userSessions;
  }

  public void setUserSessions(List<Object> userSessions) {
    this.userSessions = userSessions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListUserSessionsResponseSchema listUserSessionsResponseSchema = (ListUserSessionsResponseSchema) o;
    return Objects.equals(this.count, listUserSessionsResponseSchema.count) &&
        Objects.equals(this.userSessions, listUserSessionsResponseSchema.userSessions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, userSessions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListUserSessionsResponseSchema {\n");
    
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    userSessions: ").append(toIndentedString(userSessions)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

