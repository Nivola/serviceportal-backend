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
 * ServerInfoResponseSchema
 */

public class ServerInfoResponseSchema {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("modules")
  private Object modules = null;

  @JsonProperty("name")
  private String name = null;

  public ServerInfoResponseSchema id(String id) {
    this.id = id;
    return this;
  }

   /**
   * server instance id
   * @return id
  **/
  @ApiModelProperty(example = "auth", required = true, value = "server instance id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ServerInfoResponseSchema modules(Object modules) {
    this.modules = modules;
    return this;
  }

   /**
   * server modules
   * @return modules
  **/
  @ApiModelProperty(example = "{}", required = true, value = "server modules")
  public Object getModules() {
    return modules;
  }

  public void setModules(Object modules) {
    this.modules = modules;
  }

  public ServerInfoResponseSchema name(String name) {
    this.name = name;
    return this;
  }

   /**
   * server instance name
   * @return name
  **/
  @ApiModelProperty(example = "beehive", required = true, value = "server instance name")
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
    ServerInfoResponseSchema serverInfoResponseSchema = (ServerInfoResponseSchema) o;
    return Objects.equals(this.id, serverInfoResponseSchema.id) &&
        Objects.equals(this.modules, serverInfoResponseSchema.modules) &&
        Objects.equals(this.name, serverInfoResponseSchema.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, modules, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServerInfoResponseSchema {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    modules: ").append(toIndentedString(modules)).append("\n");
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
