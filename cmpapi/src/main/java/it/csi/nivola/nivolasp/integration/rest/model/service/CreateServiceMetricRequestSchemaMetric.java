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
import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CreateServiceMetricRequestSchemaMetric
 */

public class CreateServiceMetricRequestSchemaMetric {
  @JsonProperty("creation_date")
  private LocalDateTime creationDate = null;

  @JsonProperty("job_id")
  private Integer jobId = null;

  @JsonProperty("metric_num")
  private Integer metricNum = null;

  @JsonProperty("metric_type_id")
  private Integer metricTypeId = null;

  @JsonProperty("service_instance_oid")
  private String serviceInstanceOid = null;

  @JsonProperty("value")
  private BigDecimal value = null;

  public CreateServiceMetricRequestSchemaMetric creationDate(LocalDateTime creationDate) {
    this.creationDate = creationDate;
    return this;
  }

   /**
   * Get creationDate
   * @return creationDate
  **/
  @ApiModelProperty(required = true, value = "")
  public LocalDateTime getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDateTime creationDate) {
    this.creationDate = creationDate;
  }

  public CreateServiceMetricRequestSchemaMetric jobId(Integer jobId) {
    this.jobId = jobId;
    return this;
  }

   /**
   * Get jobId
   * @return jobId
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getJobId() {
    return jobId;
  }

  public void setJobId(Integer jobId) {
    this.jobId = jobId;
  }

  public CreateServiceMetricRequestSchemaMetric metricNum(Integer metricNum) {
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

  public CreateServiceMetricRequestSchemaMetric metricTypeId(Integer metricTypeId) {
    this.metricTypeId = metricTypeId;
    return this;
  }

   /**
   * Get metricTypeId
   * @return metricTypeId
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getMetricTypeId() {
    return metricTypeId;
  }

  public void setMetricTypeId(Integer metricTypeId) {
    this.metricTypeId = metricTypeId;
  }

  public CreateServiceMetricRequestSchemaMetric serviceInstanceOid(String serviceInstanceOid) {
    this.serviceInstanceOid = serviceInstanceOid;
    return this;
  }

   /**
   * Get serviceInstanceOid
   * @return serviceInstanceOid
  **/
  @ApiModelProperty(required = true, value = "")
  public String getServiceInstanceOid() {
    return serviceInstanceOid;
  }

  public void setServiceInstanceOid(String serviceInstanceOid) {
    this.serviceInstanceOid = serviceInstanceOid;
  }

  public CreateServiceMetricRequestSchemaMetric value(BigDecimal value) {
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
    CreateServiceMetricRequestSchemaMetric createServiceMetricRequestSchemaMetric = (CreateServiceMetricRequestSchemaMetric) o;
    return Objects.equals(this.creationDate, createServiceMetricRequestSchemaMetric.creationDate) &&
        Objects.equals(this.jobId, createServiceMetricRequestSchemaMetric.jobId) &&
        Objects.equals(this.metricNum, createServiceMetricRequestSchemaMetric.metricNum) &&
        Objects.equals(this.metricTypeId, createServiceMetricRequestSchemaMetric.metricTypeId) &&
        Objects.equals(this.serviceInstanceOid, createServiceMetricRequestSchemaMetric.serviceInstanceOid) &&
        Objects.equals(this.value, createServiceMetricRequestSchemaMetric.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creationDate, jobId, metricNum, metricTypeId, serviceInstanceOid, value);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateServiceMetricRequestSchemaMetric {\n");
    
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    jobId: ").append(toIndentedString(jobId)).append("\n");
    sb.append("    metricNum: ").append(toIndentedString(metricNum)).append("\n");
    sb.append("    metricTypeId: ").append(toIndentedString(metricTypeId)).append("\n");
    sb.append("    serviceInstanceOid: ").append(toIndentedString(serviceInstanceOid)).append("\n");
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

