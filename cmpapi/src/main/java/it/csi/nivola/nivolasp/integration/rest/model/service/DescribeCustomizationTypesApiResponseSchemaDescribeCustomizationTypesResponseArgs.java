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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * customization type args
 */
@ApiModel(description = "customization type args")

public class DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseArgs {
  @JsonProperty("allowed")
  private String allowed = null;

  @JsonProperty("default")
  private String _default = null;

  @JsonProperty("desc")
  private String desc = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("required")
  private String required = null;

  @JsonProperty("type")
  private String type = null;

  public DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseArgs allowed(String allowed) {
    this.allowed = allowed;
    return this;
  }

   /**
   * parameter allowed value
   * @return allowed
  **/
  @ApiModelProperty(example = "", value = "parameter allowed value")
  public String getAllowed() {
    return allowed;
  }

  public void setAllowed(String allowed) {
    this.allowed = allowed;
  }

  public DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseArgs _default(String _default) {
    this._default = _default;
    return this;
  }

   /**
   * parameter default value
   * @return _default
  **/
  @ApiModelProperty(example = "test", value = "parameter default value")
  public String getDefault() {
    return _default;
  }

  public void setDefault(String _default) {
    this._default = _default;
  }

  public DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseArgs desc(String desc) {
    this.desc = desc;
    return this;
  }

   /**
   * parameter description
   * @return desc
  **/
  @ApiModelProperty(example = "test", required = true, value = "parameter description")
  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseArgs name(String name) {
    this.name = name;
    return this;
  }

   /**
   * parameter name
   * @return name
  **/
  @ApiModelProperty(example = "test", required = true, value = "parameter name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseArgs required(String required) {
    this.required = required;
    return this;
  }

   /**
   * set if parameter is required
   * @return required
  **/
  @ApiModelProperty(example = "", value = "set if parameter is required")
  public String getRequired() {
    return required;
  }

  public void setRequired(String required) {
    this.required = required;
  }

  public DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseArgs type(String type) {
    this.type = type;
    return this;
  }

   /**
   * parameter type like int, str
   * @return type
  **/
  @ApiModelProperty(example = "str", required = true, value = "parameter type like int, str")
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
    DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseArgs describeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseArgs = (DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseArgs) o;
    return Objects.equals(this.allowed, describeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseArgs.allowed) &&
        Objects.equals(this._default, describeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseArgs._default) &&
        Objects.equals(this.desc, describeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseArgs.desc) &&
        Objects.equals(this.name, describeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseArgs.name) &&
        Objects.equals(this.required, describeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseArgs.required) &&
        Objects.equals(this.type, describeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseArgs.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(allowed, _default, desc, name, required, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseArgs {\n");
    
    sb.append("    allowed: ").append(toIndentedString(allowed)).append("\n");
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    required: ").append(toIndentedString(required)).append("\n");
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

