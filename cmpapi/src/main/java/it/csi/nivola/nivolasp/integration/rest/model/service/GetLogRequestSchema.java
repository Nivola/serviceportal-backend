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
 * GetLogRequestSchema
 */

public class GetLogRequestSchema {
  @JsonProperty("oid")
  private String oid = null;

  @JsonProperty("page")
  private Integer page = null;

  @JsonProperty("size")
  private Integer size = null;

  public GetLogRequestSchema oid(String oid) {
    this.oid = oid;
    return this;
  }

   /**
   * task id
   * @return oid
  **/
  @ApiModelProperty(example = "4d5e87cd-0139-400d-a787-5a15eba786e9", value = "task id")
  public String getOid() {
    return oid;
  }

  public void setOid(String oid) {
    this.oid = oid;
  }

  public GetLogRequestSchema page(Integer page) {
    this.page = page;
    return this;
  }

   /**
   * log list page selected
   * minimum: 0
   * maximum: 10000
   * @return page
  **/
  @ApiModelProperty(example = "0", value = "log list page selected")
  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public GetLogRequestSchema size(Integer size) {
    this.size = size;
    return this;
  }

   /**
   * log list page size. -1 to get all the logs
   * minimum: -1
   * maximum: 1000
   * @return size
  **/
  @ApiModelProperty(example = "20", value = "log list page size. -1 to get all the logs")
  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetLogRequestSchema getLogRequestSchema = (GetLogRequestSchema) o;
    return Objects.equals(this.oid, getLogRequestSchema.oid) &&
        Objects.equals(this.page, getLogRequestSchema.page) &&
        Objects.equals(this.size, getLogRequestSchema.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(oid, page, size);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetLogRequestSchema {\n");
    
    sb.append("    oid: ").append(toIndentedString(oid)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
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

