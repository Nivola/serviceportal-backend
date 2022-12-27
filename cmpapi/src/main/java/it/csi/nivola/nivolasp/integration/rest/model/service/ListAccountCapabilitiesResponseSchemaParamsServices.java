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
 * ListAccountCapabilitiesResponseSchemaParamsServices
 */

public class ListAccountCapabilitiesResponseSchemaParamsServices {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("params")
  private ListAccountCapabilitiesResponseSchemaParamsParams params = null;

  @JsonProperty("require")
  private ListAccountCapabilitiesResponseSchemaParamsRequire require = null;

  @JsonProperty("template")
  private String template = null;

  @JsonProperty("type")
  private String type = null;

  public ListAccountCapabilitiesResponseSchemaParamsServices name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "Windows2016", value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ListAccountCapabilitiesResponseSchemaParamsServices params(ListAccountCapabilitiesResponseSchemaParamsParams params) {
    this.params = params;
    return this;
  }

   /**
   * Get params
   * @return params
  **/
  @ApiModelProperty(required = true, value = "")
  public ListAccountCapabilitiesResponseSchemaParamsParams getParams() {
    return params;
  }

  public void setParams(ListAccountCapabilitiesResponseSchemaParamsParams params) {
    this.params = params;
  }

  public ListAccountCapabilitiesResponseSchemaParamsServices require(ListAccountCapabilitiesResponseSchemaParamsRequire require) {
    this.require = require;
    return this;
  }

   /**
   * Get require
   * @return require
  **/
  @ApiModelProperty(value = "")
  public ListAccountCapabilitiesResponseSchemaParamsRequire getRequire() {
    return require;
  }

  public void setRequire(ListAccountCapabilitiesResponseSchemaParamsRequire require) {
    this.require = require;
  }

  public ListAccountCapabilitiesResponseSchemaParamsServices template(String template) {
    this.template = template;
    return this;
  }

   /**
   * Get template
   * @return template
  **/
  @ApiModelProperty(value = "")
  public String getTemplate() {
    return template;
  }

  public void setTemplate(String template) {
    this.template = template;
  }

  public ListAccountCapabilitiesResponseSchemaParamsServices type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(example = "ComputeImage", value = "")
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
    ListAccountCapabilitiesResponseSchemaParamsServices listAccountCapabilitiesResponseSchemaParamsServices = (ListAccountCapabilitiesResponseSchemaParamsServices) o;
    return Objects.equals(this.name, listAccountCapabilitiesResponseSchemaParamsServices.name) &&
        Objects.equals(this.params, listAccountCapabilitiesResponseSchemaParamsServices.params) &&
        Objects.equals(this.require, listAccountCapabilitiesResponseSchemaParamsServices.require) &&
        Objects.equals(this.template, listAccountCapabilitiesResponseSchemaParamsServices.template) &&
        Objects.equals(this.type, listAccountCapabilitiesResponseSchemaParamsServices.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, params, require, template, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListAccountCapabilitiesResponseSchemaParamsServices {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    params: ").append(toIndentedString(params)).append("\n");
    sb.append("    require: ").append(toIndentedString(require)).append("\n");
    sb.append("    template: ").append(toIndentedString(template)).append("\n");
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

