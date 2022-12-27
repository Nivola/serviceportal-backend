/*-
 * ========================LICENSE_START=================================
 * Api CMP
 * %%
 * Copyright (C) 2022 Regione Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | Regione Piemonte
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
 * DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponse
 */

public class DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponse {
  @JsonProperty("internetGatewaySet")
  private List<DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseInternetGatewaySet> internetGatewaySet = new ArrayList<>();

  @JsonProperty("nextToken")
  private String nextToken = null;

  @JsonProperty("nvl-internetGatewayTotal")
  private Integer nvlInternetGatewayTotal = null;

  @JsonProperty("requestId")
  private String requestId = null;

  public DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponse internetGatewaySet(List<DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseInternetGatewaySet> internetGatewaySet) {
    this.internetGatewaySet = internetGatewaySet;
    return this;
  }

  public DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponse addInternetGatewaySetItem(DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseInternetGatewaySet internetGatewaySetItem) {
    this.internetGatewaySet.add(internetGatewaySetItem);
    return this;
  }

   /**
   * list of gateway definition
   * @return internetGatewaySet
  **/
  @ApiModelProperty(required = true, value = "list of gateway definition")
  public List<DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseInternetGatewaySet> getInternetGatewaySet() {
    return internetGatewaySet;
  }

  public void setInternetGatewaySet(List<DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseInternetGatewaySet> internetGatewaySet) {
    this.internetGatewaySet = internetGatewaySet;
  }

  public DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponse nextToken(String nextToken) {
    this.nextToken = nextToken;
    return this;
  }

   /**
   * The token to use to retrieve the next page of results. This value is null
   * @return nextToken
  **/
  @ApiModelProperty(example = "ednundw83ldw", required = true, value = "The token to use to retrieve the next page of results. This value is null")
  public String getNextToken() {
    return nextToken;
  }

  public void setNextToken(String nextToken) {
    this.nextToken = nextToken;
  }

  public DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponse nvlInternetGatewayTotal(Integer nvlInternetGatewayTotal) {
    this.nvlInternetGatewayTotal = nvlInternetGatewayTotal;
    return this;
  }

   /**
   * total number of subnet
   * @return nvlInternetGatewayTotal
  **/
  @ApiModelProperty(example = "", required = true, value = "total number of subnet")
  public Integer getNvlInternetGatewayTotal() {
    return nvlInternetGatewayTotal;
  }

  public void setNvlInternetGatewayTotal(Integer nvlInternetGatewayTotal) {
    this.nvlInternetGatewayTotal = nvlInternetGatewayTotal;
  }

  public DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponse requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

   /**
   * request id
   * @return requestId
  **/
  @ApiModelProperty(example = "ednundw83ldw", required = true, value = "request id")
  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponse describeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponse = (DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponse) o;
    return Objects.equals(this.internetGatewaySet, describeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponse.internetGatewaySet) &&
        Objects.equals(this.nextToken, describeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponse.nextToken) &&
        Objects.equals(this.nvlInternetGatewayTotal, describeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponse.nvlInternetGatewayTotal) &&
        Objects.equals(this.requestId, describeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponse.requestId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(internetGatewaySet, nextToken, nvlInternetGatewayTotal, requestId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponse {\n");
    
    sb.append("    internetGatewaySet: ").append(toIndentedString(internetGatewaySet)).append("\n");
    sb.append("    nextToken: ").append(toIndentedString(nextToken)).append("\n");
    sb.append("    nvlInternetGatewayTotal: ").append(toIndentedString(nvlInternetGatewayTotal)).append("\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
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

