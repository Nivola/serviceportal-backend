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
 * ApiObjectPermsResponseSchemaPerms
 */

public class ApiObjectPermsResponseSchemaPerms {
  @JsonProperty("action")
  private String action = null;

  @JsonProperty("aid")
  private Integer aid = null;

  @JsonProperty("desc")
  private String desc = null;

  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("objid")
  private String objid = null;

  @JsonProperty("oid")
  private Integer oid = null;

  @JsonProperty("subsystem")
  private String subsystem = null;

  @JsonProperty("type")
  private String type = null;

  public ApiObjectPermsResponseSchemaPerms action(String action) {
    this.action = action;
    return this;
  }

   /**
   * Get action
   * @return action
  **/
  @ApiModelProperty(example = "view", required = true, value = "")
  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public ApiObjectPermsResponseSchemaPerms aid(Integer aid) {
    this.aid = aid;
    return this;
  }

   /**
   * Get aid
   * @return aid
  **/
  @ApiModelProperty(example = "1", required = true, value = "")
  public Integer getAid() {
    return aid;
  }

  public void setAid(Integer aid) {
    this.aid = aid;
  }

  public ApiObjectPermsResponseSchemaPerms desc(String desc) {
    this.desc = desc;
    return this;
  }

   /**
   * Get desc
   * @return desc
  **/
  @ApiModelProperty(example = "beehive", required = true, value = "")
  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public ApiObjectPermsResponseSchemaPerms id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "1", required = true, value = "")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ApiObjectPermsResponseSchemaPerms objid(String objid) {
    this.objid = objid;
    return this;
  }

   /**
   * Get objid
   * @return objid
  **/
  @ApiModelProperty(example = "396587362//3328462822", required = true, value = "")
  public String getObjid() {
    return objid;
  }

  public void setObjid(String objid) {
    this.objid = objid;
  }

  public ApiObjectPermsResponseSchemaPerms oid(Integer oid) {
    this.oid = oid;
    return this;
  }

   /**
   * Get oid
   * @return oid
  **/
  @ApiModelProperty(example = "1", required = true, value = "")
  public Integer getOid() {
    return oid;
  }

  public void setOid(Integer oid) {
    this.oid = oid;
  }

  public ApiObjectPermsResponseSchemaPerms subsystem(String subsystem) {
    this.subsystem = subsystem;
    return this;
  }

   /**
   * Get subsystem
   * @return subsystem
  **/
  @ApiModelProperty(example = "auth", required = true, value = "")
  public String getSubsystem() {
    return subsystem;
  }

  public void setSubsystem(String subsystem) {
    this.subsystem = subsystem;
  }

  public ApiObjectPermsResponseSchemaPerms type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(example = "Objects", required = true, value = "")
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
    ApiObjectPermsResponseSchemaPerms apiObjectPermsResponseSchemaPerms = (ApiObjectPermsResponseSchemaPerms) o;
    return Objects.equals(this.action, apiObjectPermsResponseSchemaPerms.action) &&
        Objects.equals(this.aid, apiObjectPermsResponseSchemaPerms.aid) &&
        Objects.equals(this.desc, apiObjectPermsResponseSchemaPerms.desc) &&
        Objects.equals(this.id, apiObjectPermsResponseSchemaPerms.id) &&
        Objects.equals(this.objid, apiObjectPermsResponseSchemaPerms.objid) &&
        Objects.equals(this.oid, apiObjectPermsResponseSchemaPerms.oid) &&
        Objects.equals(this.subsystem, apiObjectPermsResponseSchemaPerms.subsystem) &&
        Objects.equals(this.type, apiObjectPermsResponseSchemaPerms.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(action, aid, desc, id, objid, oid, subsystem, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiObjectPermsResponseSchemaPerms {\n");
    
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    aid: ").append(toIndentedString(aid)).append("\n");
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    objid: ").append(toIndentedString(objid)).append("\n");
    sb.append("    oid: ").append(toIndentedString(oid)).append("\n");
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
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

