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
 * console data
 */
@ApiModel(description = "console data")

public class GetConsoleV20ApiResponseSchemaGetConsoleResponseConsole {
  @JsonProperty("protocol")
  private String protocol = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("url")
  private String url = null;

  public GetConsoleV20ApiResponseSchemaGetConsoleResponseConsole protocol(String protocol) {
    this.protocol = protocol;
    return this;
  }

   /**
   * console protocol
   * @return protocol
  **/
  @ApiModelProperty(example = "vnc", required = true, value = "console protocol")
  public String getProtocol() {
    return protocol;
  }

  public void setProtocol(String protocol) {
    this.protocol = protocol;
  }

  public GetConsoleV20ApiResponseSchemaGetConsoleResponseConsole type(String type) {
    this.type = type;
    return this;
  }

   /**
   * console type
   * @return type
  **/
  @ApiModelProperty(example = "novnc", required = true, value = "console type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public GetConsoleV20ApiResponseSchemaGetConsoleResponseConsole url(String url) {
    this.url = url;
    return this;
  }

   /**
   * console url
   * @return url
  **/
  @ApiModelProperty(example = "https://localhost:443/vnc_auto.html?path=%3Ftoken%3D2317d94c-b82a-4262-8193-f7fc01a03874", required = true, value = "console url")
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetConsoleV20ApiResponseSchemaGetConsoleResponseConsole getConsoleV20ApiResponseSchemaGetConsoleResponseConsole = (GetConsoleV20ApiResponseSchemaGetConsoleResponseConsole) o;
    return Objects.equals(this.protocol, getConsoleV20ApiResponseSchemaGetConsoleResponseConsole.protocol) &&
        Objects.equals(this.type, getConsoleV20ApiResponseSchemaGetConsoleResponseConsole.type) &&
        Objects.equals(this.url, getConsoleV20ApiResponseSchemaGetConsoleResponseConsole.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(protocol, type, url);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetConsoleV20ApiResponseSchemaGetConsoleResponseConsole {\n");
    
    sb.append("    protocol: ").append(toIndentedString(protocol)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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

