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


package it.csi.nivola.nivolasp.integration.rest.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ListServiceInstanceLinksResponseSchema
 */

public class ListServiceInstanceLinksResponseSchema {
  @JsonProperty("service_links")
  private List<ListServiceDefinitionLinksResponseSchemaServiceLinks> serviceLinks = new ArrayList<>();

  public ListServiceInstanceLinksResponseSchema serviceLinks(List<ListServiceDefinitionLinksResponseSchemaServiceLinks> serviceLinks) {
    this.serviceLinks = serviceLinks;
    return this;
  }

  public ListServiceInstanceLinksResponseSchema addServiceLinksItem(ListServiceDefinitionLinksResponseSchemaServiceLinks serviceLinksItem) {
    this.serviceLinks.add(serviceLinksItem);
    return this;
  }

   /**
   * Get serviceLinks
   * @return serviceLinks
  **/
  @ApiModelProperty(required = true, value = "")
  public List<ListServiceDefinitionLinksResponseSchemaServiceLinks> getServiceLinks() {
    return serviceLinks;
  }

  public void setServiceLinks(List<ListServiceDefinitionLinksResponseSchemaServiceLinks> serviceLinks) {
    this.serviceLinks = serviceLinks;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListServiceInstanceLinksResponseSchema listServiceInstanceLinksResponseSchema = (ListServiceInstanceLinksResponseSchema) o;
    return Objects.equals(this.serviceLinks, listServiceInstanceLinksResponseSchema.serviceLinks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceLinks);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListServiceInstanceLinksResponseSchema {\n");
    
    sb.append("    serviceLinks: ").append(toIndentedString(serviceLinks)).append("\n");
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
