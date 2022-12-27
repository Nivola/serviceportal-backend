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
 * UpdateServiceScheduleRequestSchemaJobScheduleRetryPolicy
 */

public class UpdateServiceScheduleRequestSchemaJobScheduleRetryPolicy {
  @JsonProperty("interval_max")
  private BigDecimal intervalMax = null;

  @JsonProperty("interval_start")
  private BigDecimal intervalStart = null;

  @JsonProperty("interval_step")
  private BigDecimal intervalStep = null;

  @JsonProperty("max_retries")
  private Integer maxRetries = null;

  public UpdateServiceScheduleRequestSchemaJobScheduleRetryPolicy intervalMax(BigDecimal intervalMax) {
    this.intervalMax = intervalMax;
    return this;
  }

   /**
   * Get intervalMax
   * @return intervalMax
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getIntervalMax() {
    return intervalMax;
  }

  public void setIntervalMax(BigDecimal intervalMax) {
    this.intervalMax = intervalMax;
  }

  public UpdateServiceScheduleRequestSchemaJobScheduleRetryPolicy intervalStart(BigDecimal intervalStart) {
    this.intervalStart = intervalStart;
    return this;
  }

   /**
   * Get intervalStart
   * @return intervalStart
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getIntervalStart() {
    return intervalStart;
  }

  public void setIntervalStart(BigDecimal intervalStart) {
    this.intervalStart = intervalStart;
  }

  public UpdateServiceScheduleRequestSchemaJobScheduleRetryPolicy intervalStep(BigDecimal intervalStep) {
    this.intervalStep = intervalStep;
    return this;
  }

   /**
   * Get intervalStep
   * @return intervalStep
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getIntervalStep() {
    return intervalStep;
  }

  public void setIntervalStep(BigDecimal intervalStep) {
    this.intervalStep = intervalStep;
  }

  public UpdateServiceScheduleRequestSchemaJobScheduleRetryPolicy maxRetries(Integer maxRetries) {
    this.maxRetries = maxRetries;
    return this;
  }

   /**
   * Get maxRetries
   * @return maxRetries
  **/
  @ApiModelProperty(value = "")
  public Integer getMaxRetries() {
    return maxRetries;
  }

  public void setMaxRetries(Integer maxRetries) {
    this.maxRetries = maxRetries;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateServiceScheduleRequestSchemaJobScheduleRetryPolicy updateServiceScheduleRequestSchemaJobScheduleRetryPolicy = (UpdateServiceScheduleRequestSchemaJobScheduleRetryPolicy) o;
    return Objects.equals(this.intervalMax, updateServiceScheduleRequestSchemaJobScheduleRetryPolicy.intervalMax) &&
        Objects.equals(this.intervalStart, updateServiceScheduleRequestSchemaJobScheduleRetryPolicy.intervalStart) &&
        Objects.equals(this.intervalStep, updateServiceScheduleRequestSchemaJobScheduleRetryPolicy.intervalStep) &&
        Objects.equals(this.maxRetries, updateServiceScheduleRequestSchemaJobScheduleRetryPolicy.maxRetries);
  }

  @Override
  public int hashCode() {
    return Objects.hash(intervalMax, intervalStart, intervalStep, maxRetries);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateServiceScheduleRequestSchemaJobScheduleRetryPolicy {\n");
    
    sb.append("    intervalMax: ").append(toIndentedString(intervalMax)).append("\n");
    sb.append("    intervalStart: ").append(toIndentedString(intervalStart)).append("\n");
    sb.append("    intervalStep: ").append(toIndentedString(intervalStep)).append("\n");
    sb.append("    maxRetries: ").append(toIndentedString(maxRetries)).append("\n");
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
