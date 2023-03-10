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
 * GetServiceJobResponseSchema
 */

public class GetServiceJobResponseSchema {
  @JsonProperty("count")
  private Integer count = null;

  @JsonProperty("page")
  private Integer page = null;

  @JsonProperty("servicejobs")
  private List<GetServiceJobResponseSchemaServicejobs> servicejobs = new ArrayList<>();

  @JsonProperty("sort")
  private ApiObjectPermsResponseSchemaSort sort = null;

  @JsonProperty("total")
  private Integer total = null;

  public GetServiceJobResponseSchema count(Integer count) {
    this.count = count;
    return this;
  }

   /**
   * Get count
   * @return count
  **/
  @ApiModelProperty(example = "10", required = true, value = "")
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public GetServiceJobResponseSchema page(Integer page) {
    this.page = page;
    return this;
  }

   /**
   * Get page
   * @return page
  **/
  @ApiModelProperty(example = "0", required = true, value = "")
  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public GetServiceJobResponseSchema servicejobs(List<GetServiceJobResponseSchemaServicejobs> servicejobs) {
    this.servicejobs = servicejobs;
    return this;
  }

  public GetServiceJobResponseSchema addServicejobsItem(GetServiceJobResponseSchemaServicejobs servicejobsItem) {
    this.servicejobs.add(servicejobsItem);
    return this;
  }

   /**
   * Get servicejobs
   * @return servicejobs
  **/
  @ApiModelProperty(required = true, value = "")
  public List<GetServiceJobResponseSchemaServicejobs> getServicejobs() {
    return servicejobs;
  }

  public void setServicejobs(List<GetServiceJobResponseSchemaServicejobs> servicejobs) {
    this.servicejobs = servicejobs;
  }

  public GetServiceJobResponseSchema sort(ApiObjectPermsResponseSchemaSort sort) {
    this.sort = sort;
    return this;
  }

   /**
   * Get sort
   * @return sort
  **/
  @ApiModelProperty(required = true, value = "")
  public ApiObjectPermsResponseSchemaSort getSort() {
    return sort;
  }

  public void setSort(ApiObjectPermsResponseSchemaSort sort) {
    this.sort = sort;
  }

  public GetServiceJobResponseSchema total(Integer total) {
    this.total = total;
    return this;
  }

   /**
   * Get total
   * @return total
  **/
  @ApiModelProperty(example = "20", required = true, value = "")
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
    GetServiceJobResponseSchema getServiceJobResponseSchema = (GetServiceJobResponseSchema) o;
    return Objects.equals(this.count, getServiceJobResponseSchema.count) &&
        Objects.equals(this.page, getServiceJobResponseSchema.page) &&
        Objects.equals(this.servicejobs, getServiceJobResponseSchema.servicejobs) &&
        Objects.equals(this.sort, getServiceJobResponseSchema.sort) &&
        Objects.equals(this.total, getServiceJobResponseSchema.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, page, servicejobs, sort, total);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetServiceJobResponseSchema {\n");
    
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    servicejobs: ").append(toIndentedString(servicejobs)).append("\n");
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
      return "";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

