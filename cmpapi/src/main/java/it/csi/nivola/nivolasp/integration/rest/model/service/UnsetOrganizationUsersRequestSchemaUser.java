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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * UnsetOrganizationUsersRequestSchemaUser
 */

public class UnsetOrganizationUsersRequestSchemaUser {
  /**
   * Role name, id or uuid
   */
  public enum RoleEnum {
    MASTER("master"),
    
    VIEWER("viewer"),
    
    OPERATOR("operator");

    private String value;

    RoleEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static RoleEnum fromValue(String value) {
      for (RoleEnum b : RoleEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("role")
  private RoleEnum role = null;

  @JsonProperty("user_id")
  private String userId = null;

  public UnsetOrganizationUsersRequestSchemaUser role(RoleEnum role) {
    this.role = role;
    return this;
  }

   /**
   * Role name, id or uuid
   * @return role
  **/
  @ApiModelProperty(value = "Role name, id or uuid")
  public RoleEnum getRole() {
    return role;
  }

  public void setRole(RoleEnum role) {
    this.role = role;
  }

  public UnsetOrganizationUsersRequestSchemaUser userId(String userId) {
    this.userId = userId;
    return this;
  }

   /**
   * User name, id or uuid
   * @return userId
  **/
  @ApiModelProperty(required = true, value = "User name, id or uuid")
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UnsetOrganizationUsersRequestSchemaUser unsetOrganizationUsersRequestSchemaUser = (UnsetOrganizationUsersRequestSchemaUser) o;
    return Objects.equals(this.role, unsetOrganizationUsersRequestSchemaUser.role) &&
        Objects.equals(this.userId, unsetOrganizationUsersRequestSchemaUser.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(role, userId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UnsetOrganizationUsersRequestSchemaUser {\n");
    
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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

