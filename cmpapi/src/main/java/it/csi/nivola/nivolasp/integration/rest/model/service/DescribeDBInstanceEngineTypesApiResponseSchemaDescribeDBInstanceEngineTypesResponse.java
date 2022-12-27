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
 * DescribeDBInstanceEngineTypesApiResponseSchemaDescribeDBInstanceEngineTypesResponse
 */

public class DescribeDBInstanceEngineTypesApiResponseSchemaDescribeDBInstanceEngineTypesResponse {
  @JsonProperty("engineTypesSet")
  private List<DescribeDBInstanceEngineTypesApiResponseSchemaDescribeDBInstanceEngineTypesResponseEngineTypesSet> engineTypesSet = null;

  @JsonProperty("engineTypesTotal")
  private Integer engineTypesTotal = null;

  public DescribeDBInstanceEngineTypesApiResponseSchemaDescribeDBInstanceEngineTypesResponse engineTypesSet(List<DescribeDBInstanceEngineTypesApiResponseSchemaDescribeDBInstanceEngineTypesResponseEngineTypesSet> engineTypesSet) {
    this.engineTypesSet = engineTypesSet;
    return this;
  }

  public DescribeDBInstanceEngineTypesApiResponseSchemaDescribeDBInstanceEngineTypesResponse addEngineTypesSetItem(DescribeDBInstanceEngineTypesApiResponseSchemaDescribeDBInstanceEngineTypesResponseEngineTypesSet engineTypesSetItem) {
    if (this.engineTypesSet == null) {
      this.engineTypesSet = new ArrayList<>();
    }
    this.engineTypesSet.add(engineTypesSetItem);
    return this;
  }

   /**
   * 
   * @return engineTypesSet
  **/
  @ApiModelProperty(example = "\"\"", value = "")
  public List<DescribeDBInstanceEngineTypesApiResponseSchemaDescribeDBInstanceEngineTypesResponseEngineTypesSet> getEngineTypesSet() {
    return engineTypesSet;
  }

  public void setEngineTypesSet(List<DescribeDBInstanceEngineTypesApiResponseSchemaDescribeDBInstanceEngineTypesResponseEngineTypesSet> engineTypesSet) {
    this.engineTypesSet = engineTypesSet;
  }

  public DescribeDBInstanceEngineTypesApiResponseSchemaDescribeDBInstanceEngineTypesResponse engineTypesTotal(Integer engineTypesTotal) {
    this.engineTypesTotal = engineTypesTotal;
    return this;
  }

   /**
   * 
   * @return engineTypesTotal
  **/
  @ApiModelProperty(example = "", required = true, value = "")
  public Integer getEngineTypesTotal() {
    return engineTypesTotal;
  }

  public void setEngineTypesTotal(Integer engineTypesTotal) {
    this.engineTypesTotal = engineTypesTotal;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeDBInstanceEngineTypesApiResponseSchemaDescribeDBInstanceEngineTypesResponse describeDBInstanceEngineTypesApiResponseSchemaDescribeDBInstanceEngineTypesResponse = (DescribeDBInstanceEngineTypesApiResponseSchemaDescribeDBInstanceEngineTypesResponse) o;
    return Objects.equals(this.engineTypesSet, describeDBInstanceEngineTypesApiResponseSchemaDescribeDBInstanceEngineTypesResponse.engineTypesSet) &&
        Objects.equals(this.engineTypesTotal, describeDBInstanceEngineTypesApiResponseSchemaDescribeDBInstanceEngineTypesResponse.engineTypesTotal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(engineTypesSet, engineTypesTotal);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeDBInstanceEngineTypesApiResponseSchemaDescribeDBInstanceEngineTypesResponse {\n");
    
    sb.append("    engineTypesSet: ").append(toIndentedString(engineTypesSet)).append("\n");
    sb.append("    engineTypesTotal: ").append(toIndentedString(engineTypesTotal)).append("\n");
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

