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
 * GetCatalogDefsResponseSchema
 */

public class GetCatalogDefsResponseSchema {
  @JsonProperty("count")
  private Integer count = null;

  @JsonProperty("page")
  private Integer page = null;

  @JsonProperty("servicedefs")
  private List<GetCatalogDefsResponseSchemaServicedefs> servicedefs = new ArrayList<>();

  @JsonProperty("sort")
  private AddAccountDefinitionsResponseSchemaSort sort = null;

  @JsonProperty("total")
  private Integer total = null;

  public GetCatalogDefsResponseSchema count(Integer count) {
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

  public GetCatalogDefsResponseSchema page(Integer page) {
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

  public GetCatalogDefsResponseSchema servicedefs(List<GetCatalogDefsResponseSchemaServicedefs> servicedefs) {
    this.servicedefs = servicedefs;
    return this;
  }

  public GetCatalogDefsResponseSchema addServicedefsItem(GetCatalogDefsResponseSchemaServicedefs servicedefsItem) {
    this.servicedefs.add(servicedefsItem);
    return this;
  }

   /**
   * Get servicedefs
   * @return servicedefs
  **/
  @ApiModelProperty(required = true, value = "")
  public List<GetCatalogDefsResponseSchemaServicedefs> getServicedefs() {
    return servicedefs;
  }

  public void setServicedefs(List<GetCatalogDefsResponseSchemaServicedefs> servicedefs) {
    this.servicedefs = servicedefs;
  }

  public GetCatalogDefsResponseSchema sort(AddAccountDefinitionsResponseSchemaSort sort) {
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

  public GetCatalogDefsResponseSchema total(Integer total) {
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
    GetCatalogDefsResponseSchema getCatalogDefsResponseSchema = (GetCatalogDefsResponseSchema) o;
    return Objects.equals(this.count, getCatalogDefsResponseSchema.count) &&
        Objects.equals(this.page, getCatalogDefsResponseSchema.page) &&
        Objects.equals(this.servicedefs, getCatalogDefsResponseSchema.servicedefs) &&
        Objects.equals(this.sort, getCatalogDefsResponseSchema.sort) &&
        Objects.equals(this.total, getCatalogDefsResponseSchema.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, page, servicedefs, sort, total);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCatalogDefsResponseSchema {\n");
    
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    servicedefs: ").append(toIndentedString(servicedefs)).append("\n");
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
