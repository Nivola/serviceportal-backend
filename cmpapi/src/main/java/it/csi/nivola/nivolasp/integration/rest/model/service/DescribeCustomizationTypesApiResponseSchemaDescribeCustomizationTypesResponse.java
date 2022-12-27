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
 * DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponse
 */

public class DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponse {
  @JsonProperty("customizationTypesSet")
  private List<DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseCustomizationTypesSet> customizationTypesSet = new ArrayList<>();

  @JsonProperty("customizationTypesTotal")
  private Integer customizationTypesTotal = null;

  @JsonProperty("requestId")
  private String requestId = null;

  public DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponse customizationTypesSet(List<DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseCustomizationTypesSet> customizationTypesSet) {
    this.customizationTypesSet = customizationTypesSet;
    return this;
  }

  public DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponse addCustomizationTypesSetItem(DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseCustomizationTypesSet customizationTypesSetItem) {
    this.customizationTypesSet.add(customizationTypesSetItem);
    return this;
  }

   /**
   * list of customization type info
   * @return customizationTypesSet
  **/
  @ApiModelProperty(required = true, value = "list of customization type info")
  public List<DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseCustomizationTypesSet> getCustomizationTypesSet() {
    return customizationTypesSet;
  }

  public void setCustomizationTypesSet(List<DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseCustomizationTypesSet> customizationTypesSet) {
    this.customizationTypesSet = customizationTypesSet;
  }

  public DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponse customizationTypesTotal(Integer customizationTypesTotal) {
    this.customizationTypesTotal = customizationTypesTotal;
    return this;
  }

   /**
   * total number of customization type
   * @return customizationTypesTotal
  **/
  @ApiModelProperty(required = true, value = "total number of customization type")
  public Integer getCustomizationTypesTotal() {
    return customizationTypesTotal;
  }

  public void setCustomizationTypesTotal(Integer customizationTypesTotal) {
    this.customizationTypesTotal = customizationTypesTotal;
  }

  public DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponse requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

   /**
   * api request id
   * @return requestId
  **/
  @ApiModelProperty(example = "123", required = true, value = "api request id")
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
    DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponse describeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponse = (DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponse) o;
    return Objects.equals(this.customizationTypesSet, describeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponse.customizationTypesSet) &&
        Objects.equals(this.customizationTypesTotal, describeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponse.customizationTypesTotal) &&
        Objects.equals(this.requestId, describeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponse.requestId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customizationTypesSet, customizationTypesTotal, requestId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponse {\n");
    
    sb.append("    customizationTypesSet: ").append(toIndentedString(customizationTypesSet)).append("\n");
    sb.append("    customizationTypesTotal: ").append(toIndentedString(customizationTypesTotal)).append("\n");
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
