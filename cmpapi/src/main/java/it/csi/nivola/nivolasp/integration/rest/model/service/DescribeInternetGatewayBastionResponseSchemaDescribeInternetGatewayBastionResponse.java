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
 * DescribeInternetGatewayBastionResponseSchemaDescribeInternetGatewayBastionResponse
 */

public class DescribeInternetGatewayBastionResponseSchemaDescribeInternetGatewayBastionResponse {
  @JsonProperty("internetGatewayBastion")
  private List<DescribeInternetGatewayBastionResponseSchemaDescribeInternetGatewayBastionResponseInternetGatewayBastion> internetGatewayBastion = new ArrayList<>();

  @JsonProperty("requestId")
  private String requestId = null;

  public DescribeInternetGatewayBastionResponseSchemaDescribeInternetGatewayBastionResponse internetGatewayBastion(List<DescribeInternetGatewayBastionResponseSchemaDescribeInternetGatewayBastionResponseInternetGatewayBastion> internetGatewayBastion) {
    this.internetGatewayBastion = internetGatewayBastion;
    return this;
  }

  public DescribeInternetGatewayBastionResponseSchemaDescribeInternetGatewayBastionResponse addInternetGatewayBastionItem(DescribeInternetGatewayBastionResponseSchemaDescribeInternetGatewayBastionResponseInternetGatewayBastion internetGatewayBastionItem) {
    this.internetGatewayBastion.add(internetGatewayBastionItem);
    return this;
  }

   /**
   * internet gateway bastion
   * @return internetGatewayBastion
  **/
  @ApiModelProperty(required = true, value = "internet gateway bastion")
  public List<DescribeInternetGatewayBastionResponseSchemaDescribeInternetGatewayBastionResponseInternetGatewayBastion> getInternetGatewayBastion() {
    return internetGatewayBastion;
  }

  public void setInternetGatewayBastion(List<DescribeInternetGatewayBastionResponseSchemaDescribeInternetGatewayBastionResponseInternetGatewayBastion> internetGatewayBastion) {
    this.internetGatewayBastion = internetGatewayBastion;
  }

  public DescribeInternetGatewayBastionResponseSchemaDescribeInternetGatewayBastionResponse requestId(String requestId) {
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
    DescribeInternetGatewayBastionResponseSchemaDescribeInternetGatewayBastionResponse describeInternetGatewayBastionResponseSchemaDescribeInternetGatewayBastionResponse = (DescribeInternetGatewayBastionResponseSchemaDescribeInternetGatewayBastionResponse) o;
    return Objects.equals(this.internetGatewayBastion, describeInternetGatewayBastionResponseSchemaDescribeInternetGatewayBastionResponse.internetGatewayBastion) &&
        Objects.equals(this.requestId, describeInternetGatewayBastionResponseSchemaDescribeInternetGatewayBastionResponse.requestId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(internetGatewayBastion, requestId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeInternetGatewayBastionResponseSchemaDescribeInternetGatewayBastionResponse {\n");
    
    sb.append("    internetGatewayBastion: ").append(toIndentedString(internetGatewayBastion)).append("\n");
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

