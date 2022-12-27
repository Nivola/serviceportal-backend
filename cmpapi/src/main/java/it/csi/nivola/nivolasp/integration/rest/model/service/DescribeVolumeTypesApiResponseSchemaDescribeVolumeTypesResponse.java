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
 * DescribeVolumeTypesApiResponseSchemaDescribeVolumeTypesResponse
 */

public class DescribeVolumeTypesApiResponseSchemaDescribeVolumeTypesResponse {
  @JsonProperty("requestId")
  private String requestId = null;

  @JsonProperty("volumeTypesSet")
  private List<DescribeDBInstanceTypesApiResponseSchemaDescribeDBInstanceTypesResponseInstanceTypesSet> volumeTypesSet = new ArrayList<>();

  @JsonProperty("volumeTypesTotal")
  private Integer volumeTypesTotal = null;

  public DescribeVolumeTypesApiResponseSchemaDescribeVolumeTypesResponse requestId(String requestId) {
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

  public DescribeVolumeTypesApiResponseSchemaDescribeVolumeTypesResponse volumeTypesSet(List<DescribeDBInstanceTypesApiResponseSchemaDescribeDBInstanceTypesResponseInstanceTypesSet> volumeTypesSet) {
    this.volumeTypesSet = volumeTypesSet;
    return this;
  }

  public DescribeVolumeTypesApiResponseSchemaDescribeVolumeTypesResponse addVolumeTypesSetItem(DescribeDBInstanceTypesApiResponseSchemaDescribeDBInstanceTypesResponseInstanceTypesSet volumeTypesSetItem) {
    this.volumeTypesSet.add(volumeTypesSetItem);
    return this;
  }

   /**
   * Get volumeTypesSet
   * @return volumeTypesSet
  **/
  @ApiModelProperty(required = true, value = "")
  public List<DescribeDBInstanceTypesApiResponseSchemaDescribeDBInstanceTypesResponseInstanceTypesSet> getVolumeTypesSet() {
    return volumeTypesSet;
  }

  public void setVolumeTypesSet(List<DescribeDBInstanceTypesApiResponseSchemaDescribeDBInstanceTypesResponseInstanceTypesSet> volumeTypesSet) {
    this.volumeTypesSet = volumeTypesSet;
  }

  public DescribeVolumeTypesApiResponseSchemaDescribeVolumeTypesResponse volumeTypesTotal(Integer volumeTypesTotal) {
    this.volumeTypesTotal = volumeTypesTotal;
    return this;
  }

   /**
   * Get volumeTypesTotal
   * @return volumeTypesTotal
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getVolumeTypesTotal() {
    return volumeTypesTotal;
  }

  public void setVolumeTypesTotal(Integer volumeTypesTotal) {
    this.volumeTypesTotal = volumeTypesTotal;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeVolumeTypesApiResponseSchemaDescribeVolumeTypesResponse describeVolumeTypesApiResponseSchemaDescribeVolumeTypesResponse = (DescribeVolumeTypesApiResponseSchemaDescribeVolumeTypesResponse) o;
    return Objects.equals(this.requestId, describeVolumeTypesApiResponseSchemaDescribeVolumeTypesResponse.requestId) &&
        Objects.equals(this.volumeTypesSet, describeVolumeTypesApiResponseSchemaDescribeVolumeTypesResponse.volumeTypesSet) &&
        Objects.equals(this.volumeTypesTotal, describeVolumeTypesApiResponseSchemaDescribeVolumeTypesResponse.volumeTypesTotal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestId, volumeTypesSet, volumeTypesTotal);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeVolumeTypesApiResponseSchemaDescribeVolumeTypesResponse {\n");
    
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
    sb.append("    volumeTypesSet: ").append(toIndentedString(volumeTypesSet)).append("\n");
    sb.append("    volumeTypesTotal: ").append(toIndentedString(volumeTypesTotal)).append("\n");
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

