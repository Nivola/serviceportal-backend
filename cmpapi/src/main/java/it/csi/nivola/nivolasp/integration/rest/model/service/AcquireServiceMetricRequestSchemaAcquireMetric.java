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
 * AcquireServiceMetricRequestSchemaAcquireMetric
 */

public class AcquireServiceMetricRequestSchemaAcquireMetric {
  @JsonProperty("account_id")
  private String accountId = null;

  @JsonProperty("metric_type_id")
  private Integer metricTypeId = null;

  @JsonProperty("service_instance_id")
  private String serviceInstanceId = null;

  public AcquireServiceMetricRequestSchemaAcquireMetric accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

   /**
   * Get accountId
   * @return accountId
  **/
  @ApiModelProperty(value = "")
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public AcquireServiceMetricRequestSchemaAcquireMetric metricTypeId(Integer metricTypeId) {
    this.metricTypeId = metricTypeId;
    return this;
  }

   /**
   * Get metricTypeId
   * @return metricTypeId
  **/
  @ApiModelProperty(value = "")
  public Integer getMetricTypeId() {
    return metricTypeId;
  }

  public void setMetricTypeId(Integer metricTypeId) {
    this.metricTypeId = metricTypeId;
  }

  public AcquireServiceMetricRequestSchemaAcquireMetric serviceInstanceId(String serviceInstanceId) {
    this.serviceInstanceId = serviceInstanceId;
    return this;
  }

   /**
   * Get serviceInstanceId
   * @return serviceInstanceId
  **/
  @ApiModelProperty(value = "")
  public String getServiceInstanceId() {
    return serviceInstanceId;
  }

  public void setServiceInstanceId(String serviceInstanceId) {
    this.serviceInstanceId = serviceInstanceId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AcquireServiceMetricRequestSchemaAcquireMetric acquireServiceMetricRequestSchemaAcquireMetric = (AcquireServiceMetricRequestSchemaAcquireMetric) o;
    return Objects.equals(this.accountId, acquireServiceMetricRequestSchemaAcquireMetric.accountId) &&
        Objects.equals(this.metricTypeId, acquireServiceMetricRequestSchemaAcquireMetric.metricTypeId) &&
        Objects.equals(this.serviceInstanceId, acquireServiceMetricRequestSchemaAcquireMetric.serviceInstanceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, metricTypeId, serviceInstanceId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AcquireServiceMetricRequestSchemaAcquireMetric {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    metricTypeId: ").append(toIndentedString(metricTypeId)).append("\n");
    sb.append("    serviceInstanceId: ").append(toIndentedString(serviceInstanceId)).append("\n");
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
