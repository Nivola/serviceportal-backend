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
 * UpdateServiceDefinitionRequestSchemaServicedef
 */

public class UpdateServiceDefinitionRequestSchemaServicedef {
  @JsonProperty("config")
  private String config = null;

  @JsonProperty("desc")
  private String desc = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("status")
  private String status = null;

  public UpdateServiceDefinitionRequestSchemaServicedef config(String config) {
    this.config = config;
    return this;
  }

   /**
   * Service definition config key:value
   * @return config
  **/
  @ApiModelProperty(value = "Service definition config key:value")
  public String getConfig() {
    return config;
  }

  public void setConfig(String config) {
    this.config = config;
  }

  public UpdateServiceDefinitionRequestSchemaServicedef desc(String desc) {
    this.desc = desc;
    return this;
  }

   /**
   * Service definition description
   * @return desc
  **/
  @ApiModelProperty(value = "Service definition description")
  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public UpdateServiceDefinitionRequestSchemaServicedef name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Service definition name
   * @return name
  **/
  @ApiModelProperty(value = "Service definition name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UpdateServiceDefinitionRequestSchemaServicedef status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Service definition statue
   * @return status
  **/
  @ApiModelProperty(value = "Service definition statue")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateServiceDefinitionRequestSchemaServicedef updateServiceDefinitionRequestSchemaServicedef = (UpdateServiceDefinitionRequestSchemaServicedef) o;
    return Objects.equals(this.config, updateServiceDefinitionRequestSchemaServicedef.config) &&
        Objects.equals(this.desc, updateServiceDefinitionRequestSchemaServicedef.desc) &&
        Objects.equals(this.name, updateServiceDefinitionRequestSchemaServicedef.name) &&
        Objects.equals(this.status, updateServiceDefinitionRequestSchemaServicedef.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(config, desc, name, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateServiceDefinitionRequestSchemaServicedef {\n");
    
    sb.append("    config: ").append(toIndentedString(config)).append("\n");
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

