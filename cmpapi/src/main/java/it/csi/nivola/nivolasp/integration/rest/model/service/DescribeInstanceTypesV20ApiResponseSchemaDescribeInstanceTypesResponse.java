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
 * DescribeInstanceTypesV20ApiResponseSchemaDescribeInstanceTypesResponse
 */

public class DescribeInstanceTypesV20ApiResponseSchemaDescribeInstanceTypesResponse {
  @JsonProperty("$xmlns")
  private String xmlns = null;

  @JsonProperty("instanceTypesSet")
  private List<DescribeDBInstanceTypesApiResponseSchemaDescribeDBInstanceTypesResponseInstanceTypesSet> instanceTypesSet = new ArrayList<>();

  @JsonProperty("instanceTypesTotal")
  private Integer instanceTypesTotal = null;

  @JsonProperty("requestId")
  private String requestId = null;

  public DescribeInstanceTypesV20ApiResponseSchemaDescribeInstanceTypesResponse xmlns(String xmlns) {
    this.xmlns = xmlns;
    return this;
  }

   /**
   * Get xmlns
   * @return xmlns
  **/
  @ApiModelProperty(value = "")
  public String getXmlns() {
    return xmlns;
  }

  public void setXmlns(String xmlns) {
    this.xmlns = xmlns;
  }

  public DescribeInstanceTypesV20ApiResponseSchemaDescribeInstanceTypesResponse instanceTypesSet(List<DescribeDBInstanceTypesApiResponseSchemaDescribeDBInstanceTypesResponseInstanceTypesSet> instanceTypesSet) {
    this.instanceTypesSet = instanceTypesSet;
    return this;
  }

  public DescribeInstanceTypesV20ApiResponseSchemaDescribeInstanceTypesResponse addInstanceTypesSetItem(DescribeDBInstanceTypesApiResponseSchemaDescribeDBInstanceTypesResponseInstanceTypesSet instanceTypesSetItem) {
    this.instanceTypesSet.add(instanceTypesSetItem);
    return this;
  }

   /**
   * Get instanceTypesSet
   * @return instanceTypesSet
  **/
  @ApiModelProperty(required = true, value = "")
  public List<DescribeDBInstanceTypesApiResponseSchemaDescribeDBInstanceTypesResponseInstanceTypesSet> getInstanceTypesSet() {
    return instanceTypesSet;
  }

  public void setInstanceTypesSet(List<DescribeDBInstanceTypesApiResponseSchemaDescribeDBInstanceTypesResponseInstanceTypesSet> instanceTypesSet) {
    this.instanceTypesSet = instanceTypesSet;
  }

  public DescribeInstanceTypesV20ApiResponseSchemaDescribeInstanceTypesResponse instanceTypesTotal(Integer instanceTypesTotal) {
    this.instanceTypesTotal = instanceTypesTotal;
    return this;
  }

   /**
   * Get instanceTypesTotal
   * @return instanceTypesTotal
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getInstanceTypesTotal() {
    return instanceTypesTotal;
  }

  public void setInstanceTypesTotal(Integer instanceTypesTotal) {
    this.instanceTypesTotal = instanceTypesTotal;
  }

  public DescribeInstanceTypesV20ApiResponseSchemaDescribeInstanceTypesResponse requestId(String requestId) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeInstanceTypesV20ApiResponseSchemaDescribeInstanceTypesResponse describeInstanceTypesV20ApiResponseSchemaDescribeInstanceTypesResponse = (DescribeInstanceTypesV20ApiResponseSchemaDescribeInstanceTypesResponse) o;
    return Objects.equals(this.xmlns, describeInstanceTypesV20ApiResponseSchemaDescribeInstanceTypesResponse.xmlns) &&
        Objects.equals(this.instanceTypesSet, describeInstanceTypesV20ApiResponseSchemaDescribeInstanceTypesResponse.instanceTypesSet) &&
        Objects.equals(this.instanceTypesTotal, describeInstanceTypesV20ApiResponseSchemaDescribeInstanceTypesResponse.instanceTypesTotal) &&
        Objects.equals(this.requestId, describeInstanceTypesV20ApiResponseSchemaDescribeInstanceTypesResponse.requestId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(xmlns, instanceTypesSet, instanceTypesTotal, requestId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeInstanceTypesV20ApiResponseSchemaDescribeInstanceTypesResponse {\n");
    
    sb.append("    xmlns: ").append(toIndentedString(xmlns)).append("\n");
    sb.append("    instanceTypesSet: ").append(toIndentedString(instanceTypesSet)).append("\n");
    sb.append("    instanceTypesTotal: ").append(toIndentedString(instanceTypesTotal)).append("\n");
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
