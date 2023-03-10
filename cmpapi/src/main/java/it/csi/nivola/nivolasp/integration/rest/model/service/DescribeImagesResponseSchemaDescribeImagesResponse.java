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
 * DescribeImagesResponseSchemaDescribeImagesResponse
 */

public class DescribeImagesResponseSchemaDescribeImagesResponse {
  @JsonProperty("$xmlns")
  private String xmlns = null;

  @JsonProperty("imagesSet")
  private List<DescribeImagesResponseSchemaDescribeImagesResponseImagesSet> imagesSet = null;

  @JsonProperty("nvl-imageTotal")
  private Integer nvlImageTotal = null;

  @JsonProperty("requestId")
  private String requestId = null;

  public DescribeImagesResponseSchemaDescribeImagesResponse xmlns(String xmlns) {
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

  public DescribeImagesResponseSchemaDescribeImagesResponse imagesSet(List<DescribeImagesResponseSchemaDescribeImagesResponseImagesSet> imagesSet) {
    this.imagesSet = imagesSet;
    return this;
  }

  public DescribeImagesResponseSchemaDescribeImagesResponse addImagesSetItem(DescribeImagesResponseSchemaDescribeImagesResponseImagesSet imagesSetItem) {
    if (this.imagesSet == null) {
      this.imagesSet = new ArrayList<>();
    }
    this.imagesSet.add(imagesSetItem);
    return this;
  }

   /**
   * Get imagesSet
   * @return imagesSet
  **/
  @ApiModelProperty(value = "")
  public List<DescribeImagesResponseSchemaDescribeImagesResponseImagesSet> getImagesSet() {
    return imagesSet;
  }

  public void setImagesSet(List<DescribeImagesResponseSchemaDescribeImagesResponseImagesSet> imagesSet) {
    this.imagesSet = imagesSet;
  }

  public DescribeImagesResponseSchemaDescribeImagesResponse nvlImageTotal(Integer nvlImageTotal) {
    this.nvlImageTotal = nvlImageTotal;
    return this;
  }

   /**
   * total number of items
   * @return nvlImageTotal
  **/
  @ApiModelProperty(example = "", value = "total number of items")
  public Integer getNvlImageTotal() {
    return nvlImageTotal;
  }

  public void setNvlImageTotal(Integer nvlImageTotal) {
    this.nvlImageTotal = nvlImageTotal;
  }

  public DescribeImagesResponseSchemaDescribeImagesResponse requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

   /**
   * 
   * @return requestId
  **/
  @ApiModelProperty(example = "", required = true, value = "")
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
    DescribeImagesResponseSchemaDescribeImagesResponse describeImagesResponseSchemaDescribeImagesResponse = (DescribeImagesResponseSchemaDescribeImagesResponse) o;
    return Objects.equals(this.xmlns, describeImagesResponseSchemaDescribeImagesResponse.xmlns) &&
        Objects.equals(this.imagesSet, describeImagesResponseSchemaDescribeImagesResponse.imagesSet) &&
        Objects.equals(this.nvlImageTotal, describeImagesResponseSchemaDescribeImagesResponse.nvlImageTotal) &&
        Objects.equals(this.requestId, describeImagesResponseSchemaDescribeImagesResponse.requestId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(xmlns, imagesSet, nvlImageTotal, requestId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeImagesResponseSchemaDescribeImagesResponse {\n");
    
    sb.append("    xmlns: ").append(toIndentedString(xmlns)).append("\n");
    sb.append("    imagesSet: ").append(toIndentedString(imagesSet)).append("\n");
    sb.append("    nvlImageTotal: ").append(toIndentedString(nvlImageTotal)).append("\n");
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

