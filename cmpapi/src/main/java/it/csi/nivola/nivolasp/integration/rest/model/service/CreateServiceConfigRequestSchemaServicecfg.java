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
 * CreateServiceConfigRequestSchemaServicecfg
 */

public class CreateServiceConfigRequestSchemaServicecfg {
  @JsonProperty("active")
  private Boolean active = null;

  @JsonProperty("desc")
  private String desc = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("params")
  private Object params = null;

  @JsonProperty("params_type")
  private String paramsType = null;

  @JsonProperty("service_definition_id")
  private String serviceDefinitionId = null;

  @JsonProperty("version")
  private String version = null;

  public CreateServiceConfigRequestSchemaServicecfg active(Boolean active) {
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

  public CreateServiceConfigRequestSchemaServicecfg desc(String desc) {
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

  public CreateServiceConfigRequestSchemaServicecfg name(String name) {
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

  public CreateServiceConfigRequestSchemaServicecfg params(Object params) {
    this.params = params;
    return this;
  }

   /**
   * Get params
   * @return params
  **/
  @ApiModelProperty(example = "{}", required = true, value = "")
  public Object getParams() {
    return params;
  }

  public void setParams(Object params) {
    this.params = params;
  }

  public CreateServiceConfigRequestSchemaServicecfg paramsType(String paramsType) {
    this.paramsType = paramsType;
    return this;
  }

   /**
   * Get paramsType
   * @return paramsType
  **/
  @ApiModelProperty(required = true, value = "")
  public String getParamsType() {
    return paramsType;
  }

  public void setParamsType(String paramsType) {
    this.paramsType = paramsType;
  }

  public CreateServiceConfigRequestSchemaServicecfg serviceDefinitionId(String serviceDefinitionId) {
    this.serviceDefinitionId = serviceDefinitionId;
    return this;
  }

   /**
   * Get serviceDefinitionId
   * @return serviceDefinitionId
  **/
  @ApiModelProperty(required = true, value = "")
  public String getServiceDefinitionId() {
    return serviceDefinitionId;
  }

  public void setServiceDefinitionId(String serviceDefinitionId) {
    this.serviceDefinitionId = serviceDefinitionId;
  }

  public CreateServiceConfigRequestSchemaServicecfg version(String version) {
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @ApiModelProperty(required = true, value = "")
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
    CreateServiceConfigRequestSchemaServicecfg createServiceConfigRequestSchemaServicecfg = (CreateServiceConfigRequestSchemaServicecfg) o;
    return Objects.equals(this.active, createServiceConfigRequestSchemaServicecfg.active) &&
        Objects.equals(this.desc, createServiceConfigRequestSchemaServicecfg.desc) &&
        Objects.equals(this.name, createServiceConfigRequestSchemaServicecfg.name) &&
        Objects.equals(this.params, createServiceConfigRequestSchemaServicecfg.params) &&
        Objects.equals(this.paramsType, createServiceConfigRequestSchemaServicecfg.paramsType) &&
        Objects.equals(this.serviceDefinitionId, createServiceConfigRequestSchemaServicecfg.serviceDefinitionId) &&
        Objects.equals(this.version, createServiceConfigRequestSchemaServicecfg.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, desc, name, params, paramsType, serviceDefinitionId, version);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateServiceConfigRequestSchemaServicecfg {\n");
    
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    params: ").append(toIndentedString(params)).append("\n");
    sb.append("    paramsType: ").append(toIndentedString(paramsType)).append("\n");
    sb.append("    serviceDefinitionId: ").append(toIndentedString(serviceDefinitionId)).append("\n");
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

