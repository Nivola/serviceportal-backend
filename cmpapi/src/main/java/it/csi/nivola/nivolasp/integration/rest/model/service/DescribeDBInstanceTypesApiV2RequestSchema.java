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
 * DescribeDBInstanceTypesApiV2RequestSchema
 */

public class DescribeDBInstanceTypesApiV2RequestSchema {
  @JsonProperty("InstanceType")
  private String instanceType = null;

  @JsonProperty("MaxResults")
  private Integer maxResults = null;

  @JsonProperty("NextToken")
  private Integer nextToken = null;

  @JsonProperty("owner-id")
  private String ownerId = null;

  public DescribeDBInstanceTypesApiV2RequestSchema instanceType(String instanceType) {
    this.instanceType = instanceType;
    return this;
  }

   /**
   * instance type id
   * @return instanceType
  **/
  @ApiModelProperty(example = "d35d19b3-d6b8-4208-b690-a51da2525497", value = "instance type id")
  public String getInstanceType() {
    return instanceType;
  }

  public void setInstanceType(String instanceType) {
    this.instanceType = instanceType;
  }

  public DescribeDBInstanceTypesApiV2RequestSchema maxResults(Integer maxResults) {
    this.maxResults = maxResults;
    return this;
  }

   /**
   * entities list page size
   * @return maxResults
  **/
  @ApiModelProperty(value = "entities list page size")
  public Integer getMaxResults() {
    return maxResults;
  }

  public void setMaxResults(Integer maxResults) {
    this.maxResults = maxResults;
  }

  public DescribeDBInstanceTypesApiV2RequestSchema nextToken(Integer nextToken) {
    this.nextToken = nextToken;
    return this;
  }

   /**
   * entities list page selected
   * @return nextToken
  **/
  @ApiModelProperty(value = "entities list page selected")
  public Integer getNextToken() {
    return nextToken;
  }

  public void setNextToken(Integer nextToken) {
    this.nextToken = nextToken;
  }

  public DescribeDBInstanceTypesApiV2RequestSchema ownerId(String ownerId) {
    this.ownerId = ownerId;
    return this;
  }

   /**
   * account id of the instance type owner
   * @return ownerId
  **/
  @ApiModelProperty(example = "d35d19b3-d6b8-4208-b690-a51da2525497", required = true, value = "account id of the instance type owner")
  public String getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(String ownerId) {
    this.ownerId = ownerId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeDBInstanceTypesApiV2RequestSchema describeDBInstanceTypesApiV2RequestSchema = (DescribeDBInstanceTypesApiV2RequestSchema) o;
    return Objects.equals(this.instanceType, describeDBInstanceTypesApiV2RequestSchema.instanceType) &&
        Objects.equals(this.maxResults, describeDBInstanceTypesApiV2RequestSchema.maxResults) &&
        Objects.equals(this.nextToken, describeDBInstanceTypesApiV2RequestSchema.nextToken) &&
        Objects.equals(this.ownerId, describeDBInstanceTypesApiV2RequestSchema.ownerId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(instanceType, maxResults, nextToken, ownerId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeDBInstanceTypesApiV2RequestSchema {\n");
    
    sb.append("    instanceType: ").append(toIndentedString(instanceType)).append("\n");
    sb.append("    maxResults: ").append(toIndentedString(maxResults)).append("\n");
    sb.append("    nextToken: ").append(toIndentedString(nextToken)).append("\n");
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
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

