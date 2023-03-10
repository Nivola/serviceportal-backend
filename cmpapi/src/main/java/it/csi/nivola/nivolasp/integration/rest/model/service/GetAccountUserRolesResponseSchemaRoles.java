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
 * GetAccountUserRolesResponseSchemaRoles
 */

public class GetAccountUserRolesResponseSchemaRoles {
  @JsonProperty("active")
  private Boolean active = null;

  @JsonProperty("alias")
  private String alias = null;

  @JsonProperty("desc")
  private String desc = null;

  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("uuid")
  private String uuid = null;

  public GetAccountUserRolesResponseSchemaRoles active(Boolean active) {
    this.active = active;
    return this;
  }

   /**
   * Describes if a user is active
   * @return active
  **/
  @ApiModelProperty(value = "Describes if a user is active")
  public Boolean isActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public GetAccountUserRolesResponseSchemaRoles alias(String alias) {
    this.alias = alias;
    return this;
  }

   /**
   * role alias
   * @return alias
  **/
  @ApiModelProperty(value = "role alias")
  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public GetAccountUserRolesResponseSchemaRoles desc(String desc) {
    this.desc = desc;
    return this;
  }

   /**
   * Generic description
   * @return desc
  **/
  @ApiModelProperty(value = "Generic description")
  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public GetAccountUserRolesResponseSchemaRoles id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * role id
   * @return id
  **/
  @ApiModelProperty(value = "role id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public GetAccountUserRolesResponseSchemaRoles name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Role name
   * @return name
  **/
  @ApiModelProperty(example = "master", required = true, value = "Role name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GetAccountUserRolesResponseSchemaRoles uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * role uuid or objid
   * @return uuid
  **/
  @ApiModelProperty(value = "role uuid or objid")
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetAccountUserRolesResponseSchemaRoles getAccountUserRolesResponseSchemaRoles = (GetAccountUserRolesResponseSchemaRoles) o;
    return Objects.equals(this.active, getAccountUserRolesResponseSchemaRoles.active) &&
        Objects.equals(this.alias, getAccountUserRolesResponseSchemaRoles.alias) &&
        Objects.equals(this.desc, getAccountUserRolesResponseSchemaRoles.desc) &&
        Objects.equals(this.id, getAccountUserRolesResponseSchemaRoles.id) &&
        Objects.equals(this.name, getAccountUserRolesResponseSchemaRoles.name) &&
        Objects.equals(this.uuid, getAccountUserRolesResponseSchemaRoles.uuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, alias, desc, id, name, uuid);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetAccountUserRolesResponseSchemaRoles {\n");
    
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    alias: ").append(toIndentedString(alias)).append("\n");
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
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

