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
 * DescribeDBInstanceUserApiV2ResponseSchemaDescribeDBInstanceUserResponse
 */

public class DescribeDBInstanceUserApiV2ResponseSchemaDescribeDBInstanceUserResponse {
  @JsonProperty("DescribeDBInstanceUserResult")
  private DescribeDBInstanceUserApiV2ResponseSchemaDescribeDBInstanceUserResponseDescribeDBInstanceUserResult describeDBInstanceUserResult = null;

  @JsonProperty("ResponseMetadata")
  private ChangeDBInstanceUserPasswordApiV2ResponseSchemaChangeDBInstanceUserPasswordResponseResponseMetadata responseMetadata = null;

  @JsonProperty("__xmlns")
  private String xmlns = null;

  public DescribeDBInstanceUserApiV2ResponseSchemaDescribeDBInstanceUserResponse describeDBInstanceUserResult(DescribeDBInstanceUserApiV2ResponseSchemaDescribeDBInstanceUserResponseDescribeDBInstanceUserResult describeDBInstanceUserResult) {
    this.describeDBInstanceUserResult = describeDBInstanceUserResult;
    return this;
  }

   /**
   * Get describeDBInstanceUserResult
   * @return describeDBInstanceUserResult
  **/
  @ApiModelProperty(value = "")
  public DescribeDBInstanceUserApiV2ResponseSchemaDescribeDBInstanceUserResponseDescribeDBInstanceUserResult getDescribeDBInstanceUserResult() {
    return describeDBInstanceUserResult;
  }

  public void setDescribeDBInstanceUserResult(DescribeDBInstanceUserApiV2ResponseSchemaDescribeDBInstanceUserResponseDescribeDBInstanceUserResult describeDBInstanceUserResult) {
    this.describeDBInstanceUserResult = describeDBInstanceUserResult;
  }

  public DescribeDBInstanceUserApiV2ResponseSchemaDescribeDBInstanceUserResponse responseMetadata(ChangeDBInstanceUserPasswordApiV2ResponseSchemaChangeDBInstanceUserPasswordResponseResponseMetadata responseMetadata) {
    this.responseMetadata = responseMetadata;
    return this;
  }

   /**
   * Get responseMetadata
   * @return responseMetadata
  **/
  @ApiModelProperty(value = "")
  public ChangeDBInstanceUserPasswordApiV2ResponseSchemaChangeDBInstanceUserPasswordResponseResponseMetadata getResponseMetadata() {
    return responseMetadata;
  }

  public void setResponseMetadata(ChangeDBInstanceUserPasswordApiV2ResponseSchemaChangeDBInstanceUserPasswordResponseResponseMetadata responseMetadata) {
    this.responseMetadata = responseMetadata;
  }

  public DescribeDBInstanceUserApiV2ResponseSchemaDescribeDBInstanceUserResponse xmlns(String xmlns) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeDBInstanceUserApiV2ResponseSchemaDescribeDBInstanceUserResponse describeDBInstanceUserApiV2ResponseSchemaDescribeDBInstanceUserResponse = (DescribeDBInstanceUserApiV2ResponseSchemaDescribeDBInstanceUserResponse) o;
    return Objects.equals(this.describeDBInstanceUserResult, describeDBInstanceUserApiV2ResponseSchemaDescribeDBInstanceUserResponse.describeDBInstanceUserResult) &&
        Objects.equals(this.responseMetadata, describeDBInstanceUserApiV2ResponseSchemaDescribeDBInstanceUserResponse.responseMetadata) &&
        Objects.equals(this.xmlns, describeDBInstanceUserApiV2ResponseSchemaDescribeDBInstanceUserResponse.xmlns);
  }

  @Override
  public int hashCode() {
    return Objects.hash(describeDBInstanceUserResult, responseMetadata, xmlns);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeDBInstanceUserApiV2ResponseSchemaDescribeDBInstanceUserResponse {\n");
    
    sb.append("    describeDBInstanceUserResult: ").append(toIndentedString(describeDBInstanceUserResult)).append("\n");
    sb.append("    responseMetadata: ").append(toIndentedString(responseMetadata)).append("\n");
    sb.append("    xmlns: ").append(toIndentedString(xmlns)).append("\n");
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

