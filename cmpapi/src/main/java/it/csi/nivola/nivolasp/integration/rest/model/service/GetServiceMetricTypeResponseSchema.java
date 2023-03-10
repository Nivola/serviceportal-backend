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
 * GetServiceMetricTypeResponseSchema
 */

public class GetServiceMetricTypeResponseSchema {
  @JsonProperty("metric_type")
  private GetServiceMetricTypeResponseSchemaMetricType metricType = null;

  public GetServiceMetricTypeResponseSchema metricType(GetServiceMetricTypeResponseSchemaMetricType metricType) {
    this.metricType = metricType;
    return this;
  }

   /**
   * Get metricType
   * @return metricType
  **/
  @ApiModelProperty(required = true, value = "")
  public GetServiceMetricTypeResponseSchemaMetricType getMetricType() {
    return metricType;
  }

  public void setMetricType(GetServiceMetricTypeResponseSchemaMetricType metricType) {
    this.metricType = metricType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetServiceMetricTypeResponseSchema getServiceMetricTypeResponseSchema = (GetServiceMetricTypeResponseSchema) o;
    return Objects.equals(this.metricType, getServiceMetricTypeResponseSchema.metricType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metricType);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetServiceMetricTypeResponseSchema {\n");
    
    sb.append("    metricType: ").append(toIndentedString(metricType)).append("\n");
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

