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
 * GetServiceMetricResponseSchemaMetric
 */

public class GetServiceMetricResponseSchemaMetric {
  @JsonProperty("date")
  private CheckServiceInstanceResponseSchemaServiceinstDate date = null;

  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("job_id")
  private Integer jobId = null;

  @JsonProperty("metric_num")
  private Integer metricNum = null;

  @JsonProperty("metric_type")
  private String metricType = null;

  @JsonProperty("service_instance_id")
  private Integer serviceInstanceId = null;

  @JsonProperty("value")
  private BigDecimal value = null;

  public GetServiceMetricResponseSchemaMetric date(CheckServiceInstanceResponseSchemaServiceinstDate date) {
    this.date = date;
    return this;
  }

   /**
   * Get date
   * @return date
  **/
  @ApiModelProperty(required = true, value = "")
  public CheckServiceInstanceResponseSchemaServiceinstDate getDate() {
    return date;
  }

  public void setDate(CheckServiceInstanceResponseSchemaServiceinstDate date) {
    this.date = date;
  }

  public GetServiceMetricResponseSchemaMetric id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "10", required = true, value = "")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public GetServiceMetricResponseSchemaMetric jobId(Integer jobId) {
    this.jobId = jobId;
    return this;
  }

   /**
   * Get jobId
   * @return jobId
  **/
  @ApiModelProperty(value = "")
  public Integer getJobId() {
    return jobId;
  }

  public void setJobId(Integer jobId) {
    this.jobId = jobId;
  }

  public GetServiceMetricResponseSchemaMetric metricNum(Integer metricNum) {
    this.metricNum = metricNum;
    return this;
  }

   /**
   * Get metricNum
   * @return metricNum
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getMetricNum() {
    return metricNum;
  }

  public void setMetricNum(Integer metricNum) {
    this.metricNum = metricNum;
  }

  public GetServiceMetricResponseSchemaMetric metricType(String metricType) {
    this.metricType = metricType;
    return this;
  }

   /**
   * Get metricType
   * @return metricType
  **/
  @ApiModelProperty(required = true, value = "")
  public String getMetricType() {
    return metricType;
  }

  public void setMetricType(String metricType) {
    this.metricType = metricType;
  }

  public GetServiceMetricResponseSchemaMetric serviceInstanceId(Integer serviceInstanceId) {
    this.serviceInstanceId = serviceInstanceId;
    return this;
  }

   /**
   * Get serviceInstanceId
   * @return serviceInstanceId
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getServiceInstanceId() {
    return serviceInstanceId;
  }

  public void setServiceInstanceId(Integer serviceInstanceId) {
    this.serviceInstanceId = serviceInstanceId;
  }

  public GetServiceMetricResponseSchemaMetric value(BigDecimal value) {
    this.value = value;
    return this;
  }

   /**
   * Get value
   * @return value
  **/
  @ApiModelProperty(required = true, value = "")
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
    GetServiceMetricResponseSchemaMetric getServiceMetricResponseSchemaMetric = (GetServiceMetricResponseSchemaMetric) o;
    return Objects.equals(this.date, getServiceMetricResponseSchemaMetric.date) &&
        Objects.equals(this.id, getServiceMetricResponseSchemaMetric.id) &&
        Objects.equals(this.jobId, getServiceMetricResponseSchemaMetric.jobId) &&
        Objects.equals(this.metricNum, getServiceMetricResponseSchemaMetric.metricNum) &&
        Objects.equals(this.metricType, getServiceMetricResponseSchemaMetric.metricType) &&
        Objects.equals(this.serviceInstanceId, getServiceMetricResponseSchemaMetric.serviceInstanceId) &&
        Objects.equals(this.value, getServiceMetricResponseSchemaMetric.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, id, jobId, metricNum, metricType, serviceInstanceId, value);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetServiceMetricResponseSchemaMetric {\n");
    
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    jobId: ").append(toIndentedString(jobId)).append("\n");
    sb.append("    metricNum: ").append(toIndentedString(metricNum)).append("\n");
    sb.append("    metricType: ").append(toIndentedString(metricType)).append("\n");
    sb.append("    serviceInstanceId: ").append(toIndentedString(serviceInstanceId)).append("\n");
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

