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
 * DescribeInstanceTypesApiRequestSchema
 */

public class DescribeInstanceTypesApiRequestSchema {
  @JsonProperty("MaxResults")
  private Integer maxResults = null;

  @JsonProperty("NextToken")
  private String nextToken = null;

  @JsonProperty("instance-type.N")
  private List<String> instanceTypeN = null;

  public DescribeInstanceTypesApiRequestSchema maxResults(Integer maxResults) {
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

  public DescribeInstanceTypesApiRequestSchema nextToken(String nextToken) {
    this.nextToken = nextToken;
    return this;
  }

   /**
   * entities list page selected
   * @return nextToken
  **/
  @ApiModelProperty(value = "entities list page selected")
  public String getNextToken() {
    return nextToken;
  }

  public void setNextToken(String nextToken) {
    this.nextToken = nextToken;
  }

  public DescribeInstanceTypesApiRequestSchema instanceTypeN(List<String> instanceTypeN) {
    this.instanceTypeN = instanceTypeN;
    return this;
  }

  public DescribeInstanceTypesApiRequestSchema addInstanceTypeNItem(String instanceTypeNItem) {
    if (this.instanceTypeN == null) {
      this.instanceTypeN = new ArrayList<>();
    }
    this.instanceTypeN.add(instanceTypeNItem);
    return this;
  }

   /**
   * list of instance type uuid
   * @return instanceTypeN
  **/
  @ApiModelProperty(value = "list of instance type uuid")
  public List<String> getInstanceTypeN() {
    return instanceTypeN;
  }

  public void setInstanceTypeN(List<String> instanceTypeN) {
    this.instanceTypeN = instanceTypeN;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeInstanceTypesApiRequestSchema describeInstanceTypesApiRequestSchema = (DescribeInstanceTypesApiRequestSchema) o;
    return Objects.equals(this.maxResults, describeInstanceTypesApiRequestSchema.maxResults) &&
        Objects.equals(this.nextToken, describeInstanceTypesApiRequestSchema.nextToken) &&
        Objects.equals(this.instanceTypeN, describeInstanceTypesApiRequestSchema.instanceTypeN);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxResults, nextToken, instanceTypeN);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeInstanceTypesApiRequestSchema {\n");
    
    sb.append("    maxResults: ").append(toIndentedString(maxResults)).append("\n");
    sb.append("    nextToken: ").append(toIndentedString(nextToken)).append("\n");
    sb.append("    instanceTypeN: ").append(toIndentedString(instanceTypeN)).append("\n");
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

