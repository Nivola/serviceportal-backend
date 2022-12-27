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


package it.csi.nivola.nivolasp.integration.rest.model.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * GetCatalogResponseSchemaCatalog
 */

public class GetCatalogResponseSchemaCatalog {
  @JsonProperty("__meta__")
  private GetCatalogResponseSchemaCatalogMeta_ meta_ = null;

  @JsonProperty("active")
  private Boolean active = null;

  @JsonProperty("date")
  private GetCatalogResponseSchemaCatalogDate date = null;

  @JsonProperty("desc")
  private String desc = null;

  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("services")
  private List<GetCatalogResponseSchemaCatalogServices> services = new ArrayList<>();

  @JsonProperty("uuid")
  private String uuid = null;

  @JsonProperty("zone")
  private String zone = null;

  public GetCatalogResponseSchemaCatalog meta_(GetCatalogResponseSchemaCatalogMeta_ meta_) {
    this.meta_ = meta_;
    return this;
  }

   /**
   * Get meta_
   * @return meta_
  **/
  @ApiModelProperty(required = true, value = "")
  public GetCatalogResponseSchemaCatalogMeta_ getMeta_() {
    return meta_;
  }

  public void setMeta_(GetCatalogResponseSchemaCatalogMeta_ meta_) {
    this.meta_ = meta_;
  }

  public GetCatalogResponseSchemaCatalog active(Boolean active) {
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

  public GetCatalogResponseSchemaCatalog date(GetCatalogResponseSchemaCatalogDate date) {
    this.date = date;
    return this;
  }

   /**
   * Get date
   * @return date
  **/
  @ApiModelProperty(required = true, value = "")
  public GetCatalogResponseSchemaCatalogDate getDate() {
    return date;
  }

  public void setDate(GetCatalogResponseSchemaCatalogDate date) {
    this.date = date;
  }

  public GetCatalogResponseSchemaCatalog desc(String desc) {
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

  public GetCatalogResponseSchemaCatalog id(Integer id) {
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

  public GetCatalogResponseSchemaCatalog name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "test", required = true, value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GetCatalogResponseSchemaCatalog services(List<GetCatalogResponseSchemaCatalogServices> services) {
    this.services = services;
    return this;
  }

  public GetCatalogResponseSchemaCatalog addServicesItem(GetCatalogResponseSchemaCatalogServices servicesItem) {
    this.services.add(servicesItem);
    return this;
  }

   /**
   * Get services
   * @return services
  **/
  @ApiModelProperty(required = true, value = "")
  public List<GetCatalogResponseSchemaCatalogServices> getServices() {
    return services;
  }

  public void setServices(List<GetCatalogResponseSchemaCatalogServices> services) {
    this.services = services;
  }

  public GetCatalogResponseSchemaCatalog uuid(String uuid) {
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

  public GetCatalogResponseSchemaCatalog zone(String zone) {
    this.zone = zone;
    return this;
  }

   /**
   * Get zone
   * @return zone
  **/
  @ApiModelProperty(required = true, value = "")
  public String getZone() {
    return zone;
  }

  public void setZone(String zone) {
    this.zone = zone;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCatalogResponseSchemaCatalog getCatalogResponseSchemaCatalog = (GetCatalogResponseSchemaCatalog) o;
    return Objects.equals(this.meta_, getCatalogResponseSchemaCatalog.meta_) &&
        Objects.equals(this.active, getCatalogResponseSchemaCatalog.active) &&
        Objects.equals(this.date, getCatalogResponseSchemaCatalog.date) &&
        Objects.equals(this.desc, getCatalogResponseSchemaCatalog.desc) &&
        Objects.equals(this.id, getCatalogResponseSchemaCatalog.id) &&
        Objects.equals(this.name, getCatalogResponseSchemaCatalog.name) &&
        Objects.equals(this.services, getCatalogResponseSchemaCatalog.services) &&
        Objects.equals(this.uuid, getCatalogResponseSchemaCatalog.uuid) &&
        Objects.equals(this.zone, getCatalogResponseSchemaCatalog.zone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(meta_, active, date, desc, id, name, services, uuid, zone);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCatalogResponseSchemaCatalog {\n");
    
    sb.append("    meta_: ").append(toIndentedString(meta_)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    services: ").append(toIndentedString(services)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    zone: ").append(toIndentedString(zone)).append("\n");
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

