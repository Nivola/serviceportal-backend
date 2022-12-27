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


package it.csi.nivola.nivolasp.integration.rest.model.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ListClientsResponseSchema
 */

public class ListClientsResponseSchema {
  @JsonProperty("clients")
  private List<ListClientsResponseSchemaClients> clients = new ArrayList<>();

  @JsonProperty("count")
  private Integer count = null;

  @JsonProperty("page")
  private Integer page = null;

  @JsonProperty("sort")
  private ListAuthorizationCodesResponseSchemaSort sort = null;

  @JsonProperty("total")
  private Integer total = null;

  public ListClientsResponseSchema clients(List<ListClientsResponseSchemaClients> clients) {
    this.clients = clients;
    return this;
  }

  public ListClientsResponseSchema addClientsItem(ListClientsResponseSchemaClients clientsItem) {
    this.clients.add(clientsItem);
    return this;
  }

   /**
   * Get clients
   * @return clients
  **/
  @ApiModelProperty(required = true, value = "")
  public List<ListClientsResponseSchemaClients> getClients() {
    return clients;
  }

  public void setClients(List<ListClientsResponseSchemaClients> clients) {
    this.clients = clients;
  }

  public ListClientsResponseSchema count(Integer count) {
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

  public ListClientsResponseSchema page(Integer page) {
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

  public ListClientsResponseSchema sort(ListAuthorizationCodesResponseSchemaSort sort) {
    this.sort = sort;
    return this;
  }

   /**
   * Get sort
   * @return sort
  **/
  @ApiModelProperty(required = true, value = "")
  public ListAuthorizationCodesResponseSchemaSort getSort() {
    return sort;
  }

  public void setSort(ListAuthorizationCodesResponseSchemaSort sort) {
    this.sort = sort;
  }

  public ListClientsResponseSchema total(Integer total) {
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
    ListClientsResponseSchema listClientsResponseSchema = (ListClientsResponseSchema) o;
    return Objects.equals(this.clients, listClientsResponseSchema.clients) &&
        Objects.equals(this.count, listClientsResponseSchema.count) &&
        Objects.equals(this.page, listClientsResponseSchema.page) &&
        Objects.equals(this.sort, listClientsResponseSchema.sort) &&
        Objects.equals(this.total, listClientsResponseSchema.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clients, count, page, sort, total);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListClientsResponseSchema {\n");
    
    sb.append("    clients: ").append(toIndentedString(clients)).append("\n");
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
      return "";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

