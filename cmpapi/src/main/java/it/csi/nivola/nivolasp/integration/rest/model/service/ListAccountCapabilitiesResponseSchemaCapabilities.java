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
 * ListAccountCapabilitiesResponseSchemaCapabilities
 */

public class ListAccountCapabilitiesResponseSchemaCapabilities {
  @JsonProperty("__meta__")
  private CheckServiceInstanceResponseSchemaServiceinstMeta_ meta_ = null;

  @JsonProperty("active")
  private Boolean active = null;

  @JsonProperty("date")
  private CheckServiceInstanceResponseSchemaServiceinstDate date = null;

  @JsonProperty("desc")
  private String desc = null;

  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("params")
  private ListAccountCapabilitiesResponseSchemaParams params = null;

  @JsonProperty("plugin_name")
  private String pluginName = null;

  @JsonProperty("status_id")
  private Integer statusId = null;

  @JsonProperty("uuid")
  private String uuid = null;

  @JsonProperty("version")
  private String version = null;

  public ListAccountCapabilitiesResponseSchemaCapabilities meta_(CheckServiceInstanceResponseSchemaServiceinstMeta_ meta_) {
    this.meta_ = meta_;
    return this;
  }

   /**
   * Get meta_
   * @return meta_
  **/
  @ApiModelProperty(required = true, value = "")
  public CheckServiceInstanceResponseSchemaServiceinstMeta_ getMeta_() {
    return meta_;
  }

  public void setMeta_(CheckServiceInstanceResponseSchemaServiceinstMeta_ meta_) {
    this.meta_ = meta_;
  }

  public ListAccountCapabilitiesResponseSchemaCapabilities active(Boolean active) {
    this.active = active;
    return this;
  }

   /**
   * entity acitve status
   * @return active
  **/
  @ApiModelProperty(example = "true", required = true, value = "entity acitve status")
  public Boolean isActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public ListAccountCapabilitiesResponseSchemaCapabilities date(CheckServiceInstanceResponseSchemaServiceinstDate date) {
    this.date = date;
    return this;
  }

   /**
   * Get date
   * @return date
  **/
  @ApiModelProperty(required = true, value = "")
  public CheckServiceInstanceResponseSchemaServiceinstDate getDate() {
    return date;
  }

  public void setDate(CheckServiceInstanceResponseSchemaServiceinstDate date) {
    this.date = date;
  }

  public ListAccountCapabilitiesResponseSchemaCapabilities desc(String desc) {
    this.desc = desc;
    return this;
  }

   /**
   * Get desc
   * @return desc
  **/
  @ApiModelProperty(example = "test", required = true, value = "")
  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public ListAccountCapabilitiesResponseSchemaCapabilities id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * entity database id
   * @return id
  **/
  @ApiModelProperty(example = "10", required = true, value = "entity database id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ListAccountCapabilitiesResponseSchemaCapabilities name(String name) {
    this.name = name;
    return this;
  }

   /**
   * entity name
   * @return name
  **/
  @ApiModelProperty(example = "test", required = true, value = "entity name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ListAccountCapabilitiesResponseSchemaCapabilities params(ListAccountCapabilitiesResponseSchemaParams params) {
    this.params = params;
    return this;
  }

   /**
   * Get params
   * @return params
  **/
  @ApiModelProperty(value = "")
  public ListAccountCapabilitiesResponseSchemaParams getParams() {
    return params;
  }

  public void setParams(ListAccountCapabilitiesResponseSchemaParams params) {
    this.params = params;
  }

  public ListAccountCapabilitiesResponseSchemaCapabilities pluginName(String pluginName) {
    this.pluginName = pluginName;
    return this;
  }

   /**
   * Get pluginName
   * @return pluginName
  **/
  @ApiModelProperty(value = "")
  public String getPluginName() {
    return pluginName;
  }

  public void setPluginName(String pluginName) {
    this.pluginName = pluginName;
  }

  public ListAccountCapabilitiesResponseSchemaCapabilities statusId(Integer statusId) {
    this.statusId = statusId;
    return this;
  }

   /**
   * Get statusId
   * @return statusId
  **/
  @ApiModelProperty(value = "")
  public Integer getStatusId() {
    return statusId;
  }

  public void setStatusId(Integer statusId) {
    this.statusId = statusId;
  }

  public ListAccountCapabilitiesResponseSchemaCapabilities uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * entity uuid
   * @return uuid
  **/
  @ApiModelProperty(example = "4cdf0ea4-159a-45aa-96f2-708e461130e1", required = true, value = "entity uuid")
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public ListAccountCapabilitiesResponseSchemaCapabilities version(String version) {
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @ApiModelProperty(value = "")
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListAccountCapabilitiesResponseSchemaCapabilities listAccountCapabilitiesResponseSchemaCapabilities = (ListAccountCapabilitiesResponseSchemaCapabilities) o;
    return Objects.equals(this.meta_, listAccountCapabilitiesResponseSchemaCapabilities.meta_) &&
        Objects.equals(this.active, listAccountCapabilitiesResponseSchemaCapabilities.active) &&
        Objects.equals(this.date, listAccountCapabilitiesResponseSchemaCapabilities.date) &&
        Objects.equals(this.desc, listAccountCapabilitiesResponseSchemaCapabilities.desc) &&
        Objects.equals(this.id, listAccountCapabilitiesResponseSchemaCapabilities.id) &&
        Objects.equals(this.name, listAccountCapabilitiesResponseSchemaCapabilities.name) &&
        Objects.equals(this.params, listAccountCapabilitiesResponseSchemaCapabilities.params) &&
        Objects.equals(this.pluginName, listAccountCapabilitiesResponseSchemaCapabilities.pluginName) &&
        Objects.equals(this.statusId, listAccountCapabilitiesResponseSchemaCapabilities.statusId) &&
        Objects.equals(this.uuid, listAccountCapabilitiesResponseSchemaCapabilities.uuid) &&
        Objects.equals(this.version, listAccountCapabilitiesResponseSchemaCapabilities.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(meta_, active, date, desc, id, name, params, pluginName, statusId, uuid, version);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListAccountCapabilitiesResponseSchemaCapabilities {\n");
    
    sb.append("    meta_: ").append(toIndentedString(meta_)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    params: ").append(toIndentedString(params)).append("\n");
    sb.append("    pluginName: ").append(toIndentedString(pluginName)).append("\n");
    sb.append("    statusId: ").append(toIndentedString(statusId)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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
