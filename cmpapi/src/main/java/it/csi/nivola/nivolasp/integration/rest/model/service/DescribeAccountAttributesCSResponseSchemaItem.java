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
 * DescribeAccountAttributesCSResponseSchemaItem
 */

public class DescribeAccountAttributesCSResponseSchemaItem {
  @JsonProperty("attributeValue")
  private Integer attributeValue = null;

  @JsonProperty("nvl-attributeUsed")
  private Integer nvlAttributeUsed = null;

  public DescribeAccountAttributesCSResponseSchemaItem attributeValue(Integer attributeValue) {
    this.attributeValue = attributeValue;
    return this;
  }

   /**
   * Get attributeValue
   * @return attributeValue
  **/
  @ApiModelProperty(value = "")
  public Integer getAttributeValue() {
    return attributeValue;
  }

  public void setAttributeValue(Integer attributeValue) {
    this.attributeValue = attributeValue;
  }

  public DescribeAccountAttributesCSResponseSchemaItem nvlAttributeUsed(Integer nvlAttributeUsed) {
    this.nvlAttributeUsed = nvlAttributeUsed;
    return this;
  }

   /**
   * Get nvlAttributeUsed
   * @return nvlAttributeUsed
  **/
  @ApiModelProperty(value = "")
  public Integer getNvlAttributeUsed() {
    return nvlAttributeUsed;
  }

  public void setNvlAttributeUsed(Integer nvlAttributeUsed) {
    this.nvlAttributeUsed = nvlAttributeUsed;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeAccountAttributesCSResponseSchemaItem describeAccountAttributesCSResponseSchemaItem = (DescribeAccountAttributesCSResponseSchemaItem) o;
    return Objects.equals(this.attributeValue, describeAccountAttributesCSResponseSchemaItem.attributeValue) &&
        Objects.equals(this.nvlAttributeUsed, describeAccountAttributesCSResponseSchemaItem.nvlAttributeUsed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributeValue, nvlAttributeUsed);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeAccountAttributesCSResponseSchemaItem {\n");
    
    sb.append("    attributeValue: ").append(toIndentedString(attributeValue)).append("\n");
    sb.append("    nvlAttributeUsed: ").append(toIndentedString(nvlAttributeUsed)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

