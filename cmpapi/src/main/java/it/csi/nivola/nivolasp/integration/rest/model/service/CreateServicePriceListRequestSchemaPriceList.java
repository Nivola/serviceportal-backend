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
 * CreateServicePriceListRequestSchemaPriceList
 */

public class CreateServicePriceListRequestSchemaPriceList {
  @JsonProperty("active")
  private Boolean active = null;

  @JsonProperty("desc")
  private String desc = null;

  @JsonProperty("flag_default")
  private Boolean flagDefault = null;

  @JsonProperty("name")
  private String name = null;

  public CreateServicePriceListRequestSchemaPriceList active(Boolean active) {
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

  public CreateServicePriceListRequestSchemaPriceList desc(String desc) {
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

  public CreateServicePriceListRequestSchemaPriceList flagDefault(Boolean flagDefault) {
    this.flagDefault = flagDefault;
    return this;
  }

   /**
   * Get flagDefault
   * @return flagDefault
  **/
  @ApiModelProperty(value = "")
  public Boolean isFlagDefault() {
    return flagDefault;
  }

  public void setFlagDefault(Boolean flagDefault) {
    this.flagDefault = flagDefault;
  }

  public CreateServicePriceListRequestSchemaPriceList name(String name) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateServicePriceListRequestSchemaPriceList createServicePriceListRequestSchemaPriceList = (CreateServicePriceListRequestSchemaPriceList) o;
    return Objects.equals(this.active, createServicePriceListRequestSchemaPriceList.active) &&
        Objects.equals(this.desc, createServicePriceListRequestSchemaPriceList.desc) &&
        Objects.equals(this.flagDefault, createServicePriceListRequestSchemaPriceList.flagDefault) &&
        Objects.equals(this.name, createServicePriceListRequestSchemaPriceList.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, desc, flagDefault, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateServicePriceListRequestSchemaPriceList {\n");
    
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    flagDefault: ").append(toIndentedString(flagDefault)).append("\n");
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
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

