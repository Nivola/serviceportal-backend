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
 * DescribeTemplatesResponseSchemaDescribeTemplateResponse
 */

public class DescribeTemplatesResponseSchemaDescribeTemplateResponse {
  @JsonProperty("requestId")
  private String requestId = null;

  @JsonProperty("template_set")
  private List<DescribeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet> templateSet = null;

  @JsonProperty("template_total")
  private Integer templateTotal = null;

  public DescribeTemplatesResponseSchemaDescribeTemplateResponse requestId(String requestId) {
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

  public DescribeTemplatesResponseSchemaDescribeTemplateResponse templateSet(List<DescribeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet> templateSet) {
    this.templateSet = templateSet;
    return this;
  }

  public DescribeTemplatesResponseSchemaDescribeTemplateResponse addTemplateSetItem(DescribeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet templateSetItem) {
    if (this.templateSet == null) {
      this.templateSet = new ArrayList<>();
    }
    this.templateSet.add(templateSetItem);
    return this;
  }

   /**
   * Get templateSet
   * @return templateSet
  **/
  @ApiModelProperty(value = "")
  public List<DescribeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet> getTemplateSet() {
    return templateSet;
  }

  public void setTemplateSet(List<DescribeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet> templateSet) {
    this.templateSet = templateSet;
  }

  public DescribeTemplatesResponseSchemaDescribeTemplateResponse templateTotal(Integer templateTotal) {
    this.templateTotal = templateTotal;
    return this;
  }

   /**
   * 
   * @return templateTotal
  **/
  @ApiModelProperty(example = "", required = true, value = "")
  public Integer getTemplateTotal() {
    return templateTotal;
  }

  public void setTemplateTotal(Integer templateTotal) {
    this.templateTotal = templateTotal;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeTemplatesResponseSchemaDescribeTemplateResponse describeTemplatesResponseSchemaDescribeTemplateResponse = (DescribeTemplatesResponseSchemaDescribeTemplateResponse) o;
    return Objects.equals(this.requestId, describeTemplatesResponseSchemaDescribeTemplateResponse.requestId) &&
        Objects.equals(this.templateSet, describeTemplatesResponseSchemaDescribeTemplateResponse.templateSet) &&
        Objects.equals(this.templateTotal, describeTemplatesResponseSchemaDescribeTemplateResponse.templateTotal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestId, templateSet, templateTotal);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeTemplatesResponseSchemaDescribeTemplateResponse {\n");
    
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
    sb.append("    templateSet: ").append(toIndentedString(templateSet)).append("\n");
    sb.append("    templateTotal: ").append(toIndentedString(templateTotal)).append("\n");
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
