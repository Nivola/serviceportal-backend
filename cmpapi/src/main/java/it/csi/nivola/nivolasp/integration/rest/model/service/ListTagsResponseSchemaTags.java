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
 * ListTagsResponseSchemaTags
 */

public class ListTagsResponseSchemaTags {
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

  @JsonProperty("links")
  private Integer links = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("services")
  private Integer services = null;

  @JsonProperty("uuid")
  private String uuid = null;

  public ListTagsResponseSchemaTags meta_(CheckServiceInstanceResponseSchemaServiceinstMeta_ meta_) {
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

  public ListTagsResponseSchemaTags active(Boolean active) {
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

  public ListTagsResponseSchemaTags date(CheckServiceInstanceResponseSchemaServiceinstDate date) {
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

  public ListTagsResponseSchemaTags desc(String desc) {
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

  public ListTagsResponseSchemaTags id(Integer id) {
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

  public ListTagsResponseSchemaTags links(Integer links) {
    this.links = links;
    return this;
  }

   /**
   * Get links
   * @return links
  **/
  @ApiModelProperty(value = "")
  public Integer getLinks() {
    return links;
  }

  public void setLinks(Integer links) {
    this.links = links;
  }

  public ListTagsResponseSchemaTags name(String name) {
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

  public ListTagsResponseSchemaTags services(Integer services) {
    this.services = services;
    return this;
  }

   /**
   * Get services
   * @return services
  **/
  @ApiModelProperty(value = "")
  public Integer getServices() {
    return services;
  }

  public void setServices(Integer services) {
    this.services = services;
  }

  public ListTagsResponseSchemaTags uuid(String uuid) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListTagsResponseSchemaTags listTagsResponseSchemaTags = (ListTagsResponseSchemaTags) o;
    return Objects.equals(this.meta_, listTagsResponseSchemaTags.meta_) &&
        Objects.equals(this.active, listTagsResponseSchemaTags.active) &&
        Objects.equals(this.date, listTagsResponseSchemaTags.date) &&
        Objects.equals(this.desc, listTagsResponseSchemaTags.desc) &&
        Objects.equals(this.id, listTagsResponseSchemaTags.id) &&
        Objects.equals(this.links, listTagsResponseSchemaTags.links) &&
        Objects.equals(this.name, listTagsResponseSchemaTags.name) &&
        Objects.equals(this.services, listTagsResponseSchemaTags.services) &&
        Objects.equals(this.uuid, listTagsResponseSchemaTags.uuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(meta_, active, date, desc, id, links, name, services, uuid);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListTagsResponseSchemaTags {\n");
    
    sb.append("    meta_: ").append(toIndentedString(meta_)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    services: ").append(toIndentedString(services)).append("\n");
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

