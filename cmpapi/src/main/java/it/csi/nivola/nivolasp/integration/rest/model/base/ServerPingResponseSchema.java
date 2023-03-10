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
 * ServerPingResponseSchema
 */

public class ServerPingResponseSchema {
  @JsonProperty("hostname")
  private String hostname = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("uri")
  private String uri = null;

  public ServerPingResponseSchema hostname(String hostname) {
    this.hostname = hostname;
    return this;
  }

   /**
   * server instance host name
   * @return hostname
  **/
  @ApiModelProperty(example = "tst-beehive", required = true, value = "server instance host name")
  public String getHostname() {
    return hostname;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public ServerPingResponseSchema id(String id) {
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

  public ServerPingResponseSchema name(String name) {
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

  public ServerPingResponseSchema uri(String uri) {
    this.uri = uri;
    return this;
  }

   /**
   * server instance uri
   * @return uri
  **/
  @ApiModelProperty(example = "http://localhost:6060", required = true, value = "server instance uri")
  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServerPingResponseSchema serverPingResponseSchema = (ServerPingResponseSchema) o;
    return Objects.equals(this.hostname, serverPingResponseSchema.hostname) &&
        Objects.equals(this.id, serverPingResponseSchema.id) &&
        Objects.equals(this.name, serverPingResponseSchema.name) &&
        Objects.equals(this.uri, serverPingResponseSchema.uri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hostname, id, name, uri);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServerPingResponseSchema {\n");
    
    sb.append("    hostname: ").append(toIndentedString(hostname)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
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

