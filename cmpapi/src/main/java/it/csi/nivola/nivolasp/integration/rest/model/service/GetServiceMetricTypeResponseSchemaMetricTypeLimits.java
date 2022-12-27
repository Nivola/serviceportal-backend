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

import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * GetServiceMetricTypeResponseSchemaMetricTypeLimits
 */

public class GetServiceMetricTypeResponseSchemaMetricTypeLimits {
  @JsonProperty("desc")
  private String desc = "";

  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("metric_type_id")
  private String metricTypeId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("value")
  private BigDecimal value = null;

  public GetServiceMetricTypeResponseSchemaMetricTypeLimits desc(String desc) {
    this.desc = desc;
    return this;
  }

   /**
   * service metrics type limit description
   * @return desc
  **/
  @ApiModelProperty(example = "vpc bundle bronze", value = "service metrics type limit description")
  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public GetServiceMetricTypeResponseSchemaMetricTypeLimits id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * service metrics type limit id
   * @return id
  **/
  @ApiModelProperty(example = "1", required = true, value = "service metrics type limit id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public GetServiceMetricTypeResponseSchemaMetricTypeLimits metricTypeId(String metricTypeId) {
    this.metricTypeId = metricTypeId;
    return this;
  }

   /**
   * service metrics type id
   * @return metricTypeId
  **/
  @ApiModelProperty(example = "10", required = true, value = "service metrics type id")
  public String getMetricTypeId() {
    return metricTypeId;
  }

  public void setMetricTypeId(String metricTypeId) {
    this.metricTypeId = metricTypeId;
  }

  public GetServiceMetricTypeResponseSchemaMetricTypeLimits name(String name) {
    this.name = name;
    return this;
  }

   /**
   * service metrics type limit name
   * @return name
  **/
  @ApiModelProperty(example = "vpc-bundle-bronze", required = true, value = "service metrics type limit name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GetServiceMetricTypeResponseSchemaMetricTypeLimits value(BigDecimal value) {
    this.value = value;
    return this;
  }

   /**
   * service metrics type limit value
   * @return value
  **/
  @ApiModelProperty(example = "0.0", required = true, value = "service metrics type limit value")
  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetServiceMetricTypeResponseSchemaMetricTypeLimits getServiceMetricTypeResponseSchemaMetricTypeLimits = (GetServiceMetricTypeResponseSchemaMetricTypeLimits) o;
    return Objects.equals(this.desc, getServiceMetricTypeResponseSchemaMetricTypeLimits.desc) &&
        Objects.equals(this.id, getServiceMetricTypeResponseSchemaMetricTypeLimits.id) &&
        Objects.equals(this.metricTypeId, getServiceMetricTypeResponseSchemaMetricTypeLimits.metricTypeId) &&
        Objects.equals(this.name, getServiceMetricTypeResponseSchemaMetricTypeLimits.name) &&
        Objects.equals(this.value, getServiceMetricTypeResponseSchemaMetricTypeLimits.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(desc, id, metricTypeId, name, value);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetServiceMetricTypeResponseSchemaMetricTypeLimits {\n");
    
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    metricTypeId: ").append(toIndentedString(metricTypeId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

