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

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * UpdateRoleRequestSchemaRole
 */

public class UpdateRoleRequestSchemaRole {
  @JsonProperty("active")
  private Boolean active = null;

  @JsonProperty("desc")
  private String desc = null;

  @JsonProperty("expiry_date")
  private String expiryDate = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("perms")
  private UpdateRoleRequestSchemaRolePerms perms = null;

  public UpdateRoleRequestSchemaRole active(Boolean active) {
    this.active = active;
    return this;
  }

   /**
   * Get active
   * @return active
  **/
  @ApiModelProperty(value = "")
  public Boolean isActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public UpdateRoleRequestSchemaRole desc(String desc) {
    this.desc = desc;
    return this;
  }

   /**
   * Get desc
   * @return desc
  **/
  @ApiModelProperty(value = "")
  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public UpdateRoleRequestSchemaRole expiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
    return this;
  }

   /**
   * Get expiryDate
   * @return expiryDate
  **/
  @ApiModelProperty(value = "")
  public String getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
  }

  public UpdateRoleRequestSchemaRole name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UpdateRoleRequestSchemaRole perms(UpdateRoleRequestSchemaRolePerms perms) {
    this.perms = perms;
    return this;
  }

   /**
   * Get perms
   * @return perms
  **/
  @ApiModelProperty(value = "")
  public UpdateRoleRequestSchemaRolePerms getPerms() {
    return perms;
  }

  public void setPerms(UpdateRoleRequestSchemaRolePerms perms) {
    this.perms = perms;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateRoleRequestSchemaRole updateRoleRequestSchemaRole = (UpdateRoleRequestSchemaRole) o;
    return Objects.equals(this.active, updateRoleRequestSchemaRole.active) &&
        Objects.equals(this.desc, updateRoleRequestSchemaRole.desc) &&
        Objects.equals(this.expiryDate, updateRoleRequestSchemaRole.expiryDate) &&
        Objects.equals(this.name, updateRoleRequestSchemaRole.name) &&
        Objects.equals(this.perms, updateRoleRequestSchemaRole.perms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, desc, expiryDate, name, perms);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateRoleRequestSchemaRole {\n");
    
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    expiryDate: ").append(toIndentedString(expiryDate)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    perms: ").append(toIndentedString(perms)).append("\n");
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
