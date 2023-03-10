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
 * UpdateGroupRequestSchemaGroupPermsAppend
 */

public class UpdateGroupRequestSchemaGroupPermsAppend {
  @JsonProperty("action")
  private String action = null;

  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("objid")
  private String objid = null;

  @JsonProperty("subsystem")
  private String subsystem = null;

  @JsonProperty("type")
  private String type = null;

  public UpdateGroupRequestSchemaGroupPermsAppend action(String action) {
    this.action = action;
    return this;
  }

   /**
   * Get action
   * @return action
  **/
  @ApiModelProperty(value = "")
  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public UpdateGroupRequestSchemaGroupPermsAppend id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public UpdateGroupRequestSchemaGroupPermsAppend objid(String objid) {
    this.objid = objid;
    return this;
  }

   /**
   * Get objid
   * @return objid
  **/
  @ApiModelProperty(value = "")
  public String getObjid() {
    return objid;
  }

  public void setObjid(String objid) {
    this.objid = objid;
  }

  public UpdateGroupRequestSchemaGroupPermsAppend subsystem(String subsystem) {
    this.subsystem = subsystem;
    return this;
  }

   /**
   * Get subsystem
   * @return subsystem
  **/
  @ApiModelProperty(value = "")
  public String getSubsystem() {
    return subsystem;
  }

  public void setSubsystem(String subsystem) {
    this.subsystem = subsystem;
  }

  public UpdateGroupRequestSchemaGroupPermsAppend type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateGroupRequestSchemaGroupPermsAppend updateGroupRequestSchemaGroupPermsAppend = (UpdateGroupRequestSchemaGroupPermsAppend) o;
    return Objects.equals(this.action, updateGroupRequestSchemaGroupPermsAppend.action) &&
        Objects.equals(this.id, updateGroupRequestSchemaGroupPermsAppend.id) &&
        Objects.equals(this.objid, updateGroupRequestSchemaGroupPermsAppend.objid) &&
        Objects.equals(this.subsystem, updateGroupRequestSchemaGroupPermsAppend.subsystem) &&
        Objects.equals(this.type, updateGroupRequestSchemaGroupPermsAppend.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(action, id, objid, subsystem, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateGroupRequestSchemaGroupPermsAppend {\n");
    
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    objid: ").append(toIndentedString(objid)).append("\n");
    sb.append("    subsystem: ").append(toIndentedString(subsystem)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

