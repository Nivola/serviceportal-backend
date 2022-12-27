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
 * DescribeAccountAttributesResponseSchemaDescribeAccountAttributesResponse
 */

public class DescribeAccountAttributesResponseSchemaDescribeAccountAttributesResponse {
  @JsonProperty("accountAttributeSet")
  private List<DescribeAccountAttributesResponseSchemaDescribeAccountAttributesResponseAccountAttributeSet> accountAttributeSet = new ArrayList<>();

  @JsonProperty("requestId")
  private String requestId = null;

  public DescribeAccountAttributesResponseSchemaDescribeAccountAttributesResponse accountAttributeSet(List<DescribeAccountAttributesResponseSchemaDescribeAccountAttributesResponseAccountAttributeSet> accountAttributeSet) {
    this.accountAttributeSet = accountAttributeSet;
    return this;
  }

  public DescribeAccountAttributesResponseSchemaDescribeAccountAttributesResponse addAccountAttributeSetItem(DescribeAccountAttributesResponseSchemaDescribeAccountAttributesResponseAccountAttributeSet accountAttributeSetItem) {
    this.accountAttributeSet.add(accountAttributeSetItem);
    return this;
  }

   /**
   * Get accountAttributeSet
   * @return accountAttributeSet
  **/
  @ApiModelProperty(required = true, value = "")
  public List<DescribeAccountAttributesResponseSchemaDescribeAccountAttributesResponseAccountAttributeSet> getAccountAttributeSet() {
    return accountAttributeSet;
  }

  public void setAccountAttributeSet(List<DescribeAccountAttributesResponseSchemaDescribeAccountAttributesResponseAccountAttributeSet> accountAttributeSet) {
    this.accountAttributeSet = accountAttributeSet;
  }

  public DescribeAccountAttributesResponseSchemaDescribeAccountAttributesResponse requestId(String requestId) {
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
    DescribeAccountAttributesResponseSchemaDescribeAccountAttributesResponse describeAccountAttributesResponseSchemaDescribeAccountAttributesResponse = (DescribeAccountAttributesResponseSchemaDescribeAccountAttributesResponse) o;
    return Objects.equals(this.accountAttributeSet, describeAccountAttributesResponseSchemaDescribeAccountAttributesResponse.accountAttributeSet) &&
        Objects.equals(this.requestId, describeAccountAttributesResponseSchemaDescribeAccountAttributesResponse.requestId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountAttributeSet, requestId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeAccountAttributesResponseSchemaDescribeAccountAttributesResponse {\n");
    
    sb.append("    accountAttributeSet: ").append(toIndentedString(accountAttributeSet)).append("\n");
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
