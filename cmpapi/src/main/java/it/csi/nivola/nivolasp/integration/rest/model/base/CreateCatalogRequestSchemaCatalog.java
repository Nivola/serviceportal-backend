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

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CreateCatalogRequestSchemaCatalog
 */

public class CreateCatalogRequestSchemaCatalog {
  @JsonProperty("desc")
  private String desc = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("zone")
  private String zone = null;

  public CreateCatalogRequestSchemaCatalog desc(String desc) {
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

  public CreateCatalogRequestSchemaCatalog name(String name) {
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

  public CreateCatalogRequestSchemaCatalog zone(String zone) {
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
    CreateCatalogRequestSchemaCatalog createCatalogRequestSchemaCatalog = (CreateCatalogRequestSchemaCatalog) o;
    return Objects.equals(this.desc, createCatalogRequestSchemaCatalog.desc) &&
        Objects.equals(this.name, createCatalogRequestSchemaCatalog.name) &&
        Objects.equals(this.zone, createCatalogRequestSchemaCatalog.zone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(desc, name, zone);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCatalogRequestSchemaCatalog {\n");
    
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

