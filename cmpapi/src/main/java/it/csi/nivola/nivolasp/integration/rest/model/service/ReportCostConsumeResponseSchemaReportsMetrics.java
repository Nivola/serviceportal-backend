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
 * API description in Markdown.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: me@csi.it
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
 * ReportCostConsumeResponseSchemaReportsMetrics
 */

public class ReportCostConsumeResponseSchemaReportsMetrics {
  @JsonProperty("amount")
  private Float amount = null;

  @JsonProperty("metric_type_id")
  private Integer metricTypeId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("qta")
  private Float qta = null;

  @JsonProperty("unit")
  private String unit = null;

  public ReportCostConsumeResponseSchemaReportsMetrics amount(Float amount) {
    this.amount = amount;
    return this;
  }

   /**
   * Get amount
   * @return amount
  **/
  @ApiModelProperty(required = true, value = "")
  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }

  public ReportCostConsumeResponseSchemaReportsMetrics metricTypeId(Integer metricTypeId) {
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

  public ReportCostConsumeResponseSchemaReportsMetrics name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ReportCostConsumeResponseSchemaReportsMetrics qta(Float qta) {
    this.qta = qta;
    return this;
  }

   /**
   * Get qta
   * @return qta
  **/
  @ApiModelProperty(required = true, value = "")
  public Float getQta() {
    return qta;
  }

  public void setQta(Float qta) {
    this.qta = qta;
  }

  public ReportCostConsumeResponseSchemaReportsMetrics unit(String unit) {
    this.unit = unit;
    return this;
  }

   /**
   * Get unit
   * @return unit
  **/
  @ApiModelProperty(required = true, value = "")
  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReportCostConsumeResponseSchemaReportsMetrics reportCostConsumeResponseSchemaReportsMetrics = (ReportCostConsumeResponseSchemaReportsMetrics) o;
    return Objects.equals(this.amount, reportCostConsumeResponseSchemaReportsMetrics.amount) &&
        Objects.equals(this.metricTypeId, reportCostConsumeResponseSchemaReportsMetrics.metricTypeId) &&
        Objects.equals(this.name, reportCostConsumeResponseSchemaReportsMetrics.name) &&
        Objects.equals(this.qta, reportCostConsumeResponseSchemaReportsMetrics.qta) &&
        Objects.equals(this.unit, reportCostConsumeResponseSchemaReportsMetrics.unit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, metricTypeId, name, qta, unit);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReportCostConsumeResponseSchemaReportsMetrics {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    metricTypeId: ").append(toIndentedString(metricTypeId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    qta: ").append(toIndentedString(qta)).append("\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
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
