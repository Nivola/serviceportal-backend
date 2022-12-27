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
 * CreateEndpointRequestSchemaEndpoint
 */

public class CreateEndpointRequestSchemaEndpoint {
  @JsonProperty("active")
  private Boolean active = null;

  @JsonProperty("catalog")
  private String catalog = null;

  @JsonProperty("desc")
  private String desc = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("service")
  private String service = null;

  @JsonProperty("uri")
  private String uri = null;

  public CreateEndpointRequestSchemaEndpoint active(Boolean active) {
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

  public CreateEndpointRequestSchemaEndpoint catalog(String catalog) {
    this.catalog = catalog;
    return this;
  }

   /**
   * Get catalog
   * @return catalog
  **/
  @ApiModelProperty(value = "")
  public String getCatalog() {
    return catalog;
  }

  public void setCatalog(String catalog) {
    this.catalog = catalog;
  }

  public CreateEndpointRequestSchemaEndpoint desc(String desc) {
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

  public CreateEndpointRequestSchemaEndpoint name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreateEndpointRequestSchemaEndpoint service(String service) {
    this.service = service;
    return this;
  }

   /**
   * Get service
   * @return service
  **/
  @ApiModelProperty(value = "")
  public String getService() {
    return service;
  }

  public void setService(String service) {
    this.service = service;
  }

  public CreateEndpointRequestSchemaEndpoint uri(String uri) {
    this.uri = uri;
    return this;
  }

   /**
   * Get uri
   * @return uri
  **/
  @ApiModelProperty(value = "")
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
    CreateEndpointRequestSchemaEndpoint createEndpointRequestSchemaEndpoint = (CreateEndpointRequestSchemaEndpoint) o;
    return Objects.equals(this.active, createEndpointRequestSchemaEndpoint.active) &&
        Objects.equals(this.catalog, createEndpointRequestSchemaEndpoint.catalog) &&
        Objects.equals(this.desc, createEndpointRequestSchemaEndpoint.desc) &&
        Objects.equals(this.name, createEndpointRequestSchemaEndpoint.name) &&
        Objects.equals(this.service, createEndpointRequestSchemaEndpoint.service) &&
        Objects.equals(this.uri, createEndpointRequestSchemaEndpoint.uri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, catalog, desc, name, service, uri);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateEndpointRequestSchemaEndpoint {\n");
    
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    catalog: ").append(toIndentedString(catalog)).append("\n");
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    service: ").append(toIndentedString(service)).append("\n");
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
