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
 * ListServiceDefinitionLinksResponseSchemaServiceLinks
 */

public class ListServiceDefinitionLinksResponseSchemaServiceLinks {
  @JsonProperty("__meta__")
  private GetAccountCapabilityResponseSchemaCapabilitiesMeta_ meta_ = null;

  @JsonProperty("active")
  private Boolean active = null;

  @JsonProperty("attributes")
  private String attributes = null;

  @JsonProperty("date")
  private GetAccountCapabilityResponseSchemaCapabilitiesDate date = null;

  @JsonProperty("desc")
  private String desc = null;

  @JsonProperty("end_service_id")
  private String endServiceId = null;

  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("priority")
  private Integer priority = null;

  @JsonProperty("start_service_id")
  private String startServiceId = null;

  @JsonProperty("uuid")
  private String uuid = null;

  public ListServiceDefinitionLinksResponseSchemaServiceLinks meta_(GetAccountCapabilityResponseSchemaCapabilitiesMeta_ meta_) {
    this.meta_ = meta_;
    return this;
  }

   /**
   * Get meta_
   * @return meta_
  **/
  @ApiModelProperty(required = true, value = "")
  public GetAccountCapabilityResponseSchemaCapabilitiesMeta_ getMeta_() {
    return meta_;
  }

  public void setMeta_(GetAccountCapabilityResponseSchemaCapabilitiesMeta_ meta_) {
    this.meta_ = meta_;
  }

  public ListServiceDefinitionLinksResponseSchemaServiceLinks active(Boolean active) {
    this.active = active;
    return this;
  }

   /**
   * Get active
   * @return active
  **/
  @ApiModelProperty(example = "true", required = true, value = "")
  public Boolean isActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public ListServiceDefinitionLinksResponseSchemaServiceLinks attributes(String attributes) {
    this.attributes = attributes;
    return this;
  }

   /**
   * Get attributes
   * @return attributes
  **/
  @ApiModelProperty(required = true, value = "")
  public String getAttributes() {
    return attributes;
  }

  public void setAttributes(String attributes) {
    this.attributes = attributes;
  }

  public ListServiceDefinitionLinksResponseSchemaServiceLinks date(GetAccountCapabilityResponseSchemaCapabilitiesDate date) {
    this.date = date;
    return this;
  }

   /**
   * Get date
   * @return date
  **/
  @ApiModelProperty(required = true, value = "")
  public GetAccountCapabilityResponseSchemaCapabilitiesDate getDate() {
    return date;
  }

  public void setDate(GetAccountCapabilityResponseSchemaCapabilitiesDate date) {
    this.date = date;
  }

  public ListServiceDefinitionLinksResponseSchemaServiceLinks desc(String desc) {
    this.desc = desc;
    return this;
  }

   /**
   * Get desc
   * @return desc
  **/
  @ApiModelProperty(required = true, value = "")
  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public ListServiceDefinitionLinksResponseSchemaServiceLinks endServiceId(String endServiceId) {
    this.endServiceId = endServiceId;
    return this;
  }

   /**
   * Get endServiceId
   * @return endServiceId
  **/
  @ApiModelProperty(required = true, value = "")
  public String getEndServiceId() {
    return endServiceId;
  }

  public void setEndServiceId(String endServiceId) {
    this.endServiceId = endServiceId;
  }

  public ListServiceDefinitionLinksResponseSchemaServiceLinks id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "10", required = true, value = "")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ListServiceDefinitionLinksResponseSchemaServiceLinks name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ListServiceDefinitionLinksResponseSchemaServiceLinks priority(Integer priority) {
    this.priority = priority;
    return this;
  }

   /**
   * Get priority
   * @return priority
  **/
  @ApiModelProperty(value = "")
  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public ListServiceDefinitionLinksResponseSchemaServiceLinks startServiceId(String startServiceId) {
    this.startServiceId = startServiceId;
    return this;
  }

   /**
   * Get startServiceId
   * @return startServiceId
  **/
  @ApiModelProperty(required = true, value = "")
  public String getStartServiceId() {
    return startServiceId;
  }

  public void setStartServiceId(String startServiceId) {
    this.startServiceId = startServiceId;
  }

  public ListServiceDefinitionLinksResponseSchemaServiceLinks uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * Get uuid
   * @return uuid
  **/
  @ApiModelProperty(example = "4cdf0ea4-159a-45aa-96f2-708e461130e1", required = true, value = "")
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
    ListServiceDefinitionLinksResponseSchemaServiceLinks listServiceDefinitionLinksResponseSchemaServiceLinks = (ListServiceDefinitionLinksResponseSchemaServiceLinks) o;
    return Objects.equals(this.meta_, listServiceDefinitionLinksResponseSchemaServiceLinks.meta_) &&
        Objects.equals(this.active, listServiceDefinitionLinksResponseSchemaServiceLinks.active) &&
        Objects.equals(this.attributes, listServiceDefinitionLinksResponseSchemaServiceLinks.attributes) &&
        Objects.equals(this.date, listServiceDefinitionLinksResponseSchemaServiceLinks.date) &&
        Objects.equals(this.desc, listServiceDefinitionLinksResponseSchemaServiceLinks.desc) &&
        Objects.equals(this.endServiceId, listServiceDefinitionLinksResponseSchemaServiceLinks.endServiceId) &&
        Objects.equals(this.id, listServiceDefinitionLinksResponseSchemaServiceLinks.id) &&
        Objects.equals(this.name, listServiceDefinitionLinksResponseSchemaServiceLinks.name) &&
        Objects.equals(this.priority, listServiceDefinitionLinksResponseSchemaServiceLinks.priority) &&
        Objects.equals(this.startServiceId, listServiceDefinitionLinksResponseSchemaServiceLinks.startServiceId) &&
        Objects.equals(this.uuid, listServiceDefinitionLinksResponseSchemaServiceLinks.uuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(meta_, active, attributes, date, desc, endServiceId, id, name, priority, startServiceId, uuid);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListServiceDefinitionLinksResponseSchemaServiceLinks {\n");
    
    sb.append("    meta_: ").append(toIndentedString(meta_)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    endServiceId: ").append(toIndentedString(endServiceId)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    startServiceId: ").append(toIndentedString(startServiceId)).append("\n");
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
      return "";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

