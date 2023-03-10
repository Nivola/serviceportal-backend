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


package it.csi.nivola.nivolasp.integration.rest.model.service;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * UpdateServiceInstCfgRequestSchemaInstancecfg
 */

public class UpdateServiceInstCfgRequestSchemaInstancecfg {
  @JsonProperty("active")
  private String active = null;

  @JsonProperty("desc")
  private String desc = null;

  @JsonProperty("json_cfg")
  private Object jsonCfg = null;

  @JsonProperty("name")
  private String name = null;

  public UpdateServiceInstCfgRequestSchemaInstancecfg active(String active) {
    this.active = active;
    return this;
  }

   /**
   * Get active
   * @return active
  **/
  @ApiModelProperty(value = "")
  public String getActive() {
    return active;
  }

  public void setActive(String active) {
    this.active = active;
  }

  public UpdateServiceInstCfgRequestSchemaInstancecfg desc(String desc) {
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

  public UpdateServiceInstCfgRequestSchemaInstancecfg jsonCfg(Object jsonCfg) {
    this.jsonCfg = jsonCfg;
    return this;
  }

   /**
   * Get jsonCfg
   * @return jsonCfg
  **/
  @ApiModelProperty(value = "")
  public Object getJsonCfg() {
    return jsonCfg;
  }

  public void setJsonCfg(Object jsonCfg) {
    this.jsonCfg = jsonCfg;
  }

  public UpdateServiceInstCfgRequestSchemaInstancecfg name(String name) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateServiceInstCfgRequestSchemaInstancecfg updateServiceInstCfgRequestSchemaInstancecfg = (UpdateServiceInstCfgRequestSchemaInstancecfg) o;
    return Objects.equals(this.active, updateServiceInstCfgRequestSchemaInstancecfg.active) &&
        Objects.equals(this.desc, updateServiceInstCfgRequestSchemaInstancecfg.desc) &&
        Objects.equals(this.jsonCfg, updateServiceInstCfgRequestSchemaInstancecfg.jsonCfg) &&
        Objects.equals(this.name, updateServiceInstCfgRequestSchemaInstancecfg.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, desc, jsonCfg, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateServiceInstCfgRequestSchemaInstancecfg {\n");
    
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    jsonCfg: ").append(toIndentedString(jsonCfg)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

