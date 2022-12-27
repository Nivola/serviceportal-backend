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
 * ServerVersionResponseSchema
 */

public class ServerVersionResponseSchema {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("version")
  private String version = null;

  public ServerVersionResponseSchema name(String name) {
    this.name = name;
    return this;
  }

   /**
   * package name
   * @return name
  **/
  @ApiModelProperty(example = "beehive", required = true, value = "package name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ServerVersionResponseSchema version(String version) {
    this.version = version;
    return this;
  }

   /**
   * package version
   * @return version
  **/
  @ApiModelProperty(example = "auth", required = true, value = "package version")
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
    ServerVersionResponseSchema serverVersionResponseSchema = (ServerVersionResponseSchema) o;
    return Objects.equals(this.name, serverVersionResponseSchema.name) &&
        Objects.equals(this.version, serverVersionResponseSchema.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, version);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServerVersionResponseSchema {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
