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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ListAccountCapabilitiesResponseSchema
 */

public class ListAccountCapabilitiesResponseSchema {
  @JsonProperty("capabilities")
  private List<ListAccountCapabilitiesResponseSchemaCapabilities> capabilities = new ArrayList<>();

  @JsonProperty("count")
  private Integer count = null;

  @JsonProperty("page")
  private Integer page = null;

  @JsonProperty("sort")
  private AddAccountDefinitionsResponseSchemaSort sort = null;

  @JsonProperty("total")
  private Integer total = null;

  public ListAccountCapabilitiesResponseSchema capabilities(List<ListAccountCapabilitiesResponseSchemaCapabilities> capabilities) {
    this.capabilities = capabilities;
    return this;
  }

  public ListAccountCapabilitiesResponseSchema addCapabilitiesItem(ListAccountCapabilitiesResponseSchemaCapabilities capabilitiesItem) {
    this.capabilities.add(capabilitiesItem);
    return this;
  }

   /**
   * Get capabilities
   * @return capabilities
  **/
  @ApiModelProperty(required = true, value = "")
  public List<ListAccountCapabilitiesResponseSchemaCapabilities> getCapabilities() {
    return capabilities;
  }

  public void setCapabilities(List<ListAccountCapabilitiesResponseSchemaCapabilities> capabilities) {
    this.capabilities = capabilities;
  }

  public ListAccountCapabilitiesResponseSchema count(Integer count) {
    this.count = count;
    return this;
  }

   /**
   * number of query items returned
   * @return count
  **/
  @ApiModelProperty(example = "10", required = true, value = "number of query items returned")
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public ListAccountCapabilitiesResponseSchema page(Integer page) {
    this.page = page;
    return this;
  }

   /**
   * query page number
   * @return page
  **/
  @ApiModelProperty(example = "0", required = true, value = "query page number")
  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public ListAccountCapabilitiesResponseSchema sort(AddAccountDefinitionsResponseSchemaSort sort) {
    this.sort = sort;
    return this;
  }

   /**
   * Get sort
   * @return sort
  **/
  @ApiModelProperty(required = true, value = "")
  public AddAccountDefinitionsResponseSchemaSort getSort() {
    return sort;
  }

  public void setSort(AddAccountDefinitionsResponseSchemaSort sort) {
    this.sort = sort;
  }

  public ListAccountCapabilitiesResponseSchema total(Integer total) {
    this.total = total;
    return this;
  }

   /**
   * total number of available query items
   * @return total
  **/
  @ApiModelProperty(example = "20", required = true, value = "total number of available query items")
  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListAccountCapabilitiesResponseSchema listAccountCapabilitiesResponseSchema = (ListAccountCapabilitiesResponseSchema) o;
    return Objects.equals(this.capabilities, listAccountCapabilitiesResponseSchema.capabilities) &&
        Objects.equals(this.count, listAccountCapabilitiesResponseSchema.count) &&
        Objects.equals(this.page, listAccountCapabilitiesResponseSchema.page) &&
        Objects.equals(this.sort, listAccountCapabilitiesResponseSchema.sort) &&
        Objects.equals(this.total, listAccountCapabilitiesResponseSchema.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(capabilities, count, page, sort, total);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListAccountCapabilitiesResponseSchema {\n");
    
    sb.append("    capabilities: ").append(toIndentedString(capabilities)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    sort: ").append(toIndentedString(sort)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
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

