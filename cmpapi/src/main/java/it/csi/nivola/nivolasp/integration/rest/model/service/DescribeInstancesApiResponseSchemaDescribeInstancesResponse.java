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
 * DescribeInstancesApiResponseSchemaDescribeInstancesResponse
 */

public class DescribeInstancesApiResponseSchemaDescribeInstancesResponse {
  @JsonProperty("nextToken")
  private String nextToken = null;

  @JsonProperty("requestId")
  private String requestId = null;

  @JsonProperty("reservationSet")
  private List<DescribeInstancesApiResponseSchemaDescribeInstancesResponseReservationSet> reservationSet = new ArrayList<>();

  public DescribeInstancesApiResponseSchemaDescribeInstancesResponse nextToken(String nextToken) {
    this.nextToken = nextToken;
    return this;
  }

   /**
   * Get nextToken
   * @return nextToken
  **/
  @ApiModelProperty(required = true, value = "")
  public String getNextToken() {
    return nextToken;
  }

  public void setNextToken(String nextToken) {
    this.nextToken = nextToken;
  }

  public DescribeInstancesApiResponseSchemaDescribeInstancesResponse requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

   /**
   * Get requestId
   * @return requestId
  **/
  @ApiModelProperty(required = true, value = "")
  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public DescribeInstancesApiResponseSchemaDescribeInstancesResponse reservationSet(List<DescribeInstancesApiResponseSchemaDescribeInstancesResponseReservationSet> reservationSet) {
    this.reservationSet = reservationSet;
    return this;
  }

  public DescribeInstancesApiResponseSchemaDescribeInstancesResponse addReservationSetItem(DescribeInstancesApiResponseSchemaDescribeInstancesResponseReservationSet reservationSetItem) {
    this.reservationSet.add(reservationSetItem);
    return this;
  }

   /**
   * Get reservationSet
   * @return reservationSet
  **/
  @ApiModelProperty(required = true, value = "")
  public List<DescribeInstancesApiResponseSchemaDescribeInstancesResponseReservationSet> getReservationSet() {
    return reservationSet;
  }

  public void setReservationSet(List<DescribeInstancesApiResponseSchemaDescribeInstancesResponseReservationSet> reservationSet) {
    this.reservationSet = reservationSet;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeInstancesApiResponseSchemaDescribeInstancesResponse describeInstancesApiResponseSchemaDescribeInstancesResponse = (DescribeInstancesApiResponseSchemaDescribeInstancesResponse) o;
    return Objects.equals(this.nextToken, describeInstancesApiResponseSchemaDescribeInstancesResponse.nextToken) &&
        Objects.equals(this.requestId, describeInstancesApiResponseSchemaDescribeInstancesResponse.requestId) &&
        Objects.equals(this.reservationSet, describeInstancesApiResponseSchemaDescribeInstancesResponse.reservationSet);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nextToken, requestId, reservationSet);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeInstancesApiResponseSchemaDescribeInstancesResponse {\n");
    
    sb.append("    nextToken: ").append(toIndentedString(nextToken)).append("\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
    sb.append("    reservationSet: ").append(toIndentedString(reservationSet)).append("\n");
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

