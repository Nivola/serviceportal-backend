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
 * ReportCostConsumeResponseSchemaReportsCreditSummary
 */

public class ReportCostConsumeResponseSchemaReportsCreditSummary {
  @JsonProperty("accounted")
  private Float accounted = null;

  @JsonProperty("consume_period")
  private Float consumePeriod = null;

  @JsonProperty("initial")
  private Float initial = null;

  @JsonProperty("remaining_post")
  private Float remainingPost = null;

  @JsonProperty("remaining_pre")
  private Float remainingPre = null;

  public ReportCostConsumeResponseSchemaReportsCreditSummary accounted(Float accounted) {
    this.accounted = accounted;
    return this;
  }

   /**
   * Get accounted
   * @return accounted
  **/
  @ApiModelProperty(required = true, value = "")
  public Float getAccounted() {
    return accounted;
  }

  public void setAccounted(Float accounted) {
    this.accounted = accounted;
  }

  public ReportCostConsumeResponseSchemaReportsCreditSummary consumePeriod(Float consumePeriod) {
    this.consumePeriod = consumePeriod;
    return this;
  }

   /**
   * Get consumePeriod
   * @return consumePeriod
  **/
  @ApiModelProperty(required = true, value = "")
  public Float getConsumePeriod() {
    return consumePeriod;
  }

  public void setConsumePeriod(Float consumePeriod) {
    this.consumePeriod = consumePeriod;
  }

  public ReportCostConsumeResponseSchemaReportsCreditSummary initial(Float initial) {
    this.initial = initial;
    return this;
  }

   /**
   * Get initial
   * @return initial
  **/
  @ApiModelProperty(required = true, value = "")
  public Float getInitial() {
    return initial;
  }

  public void setInitial(Float initial) {
    this.initial = initial;
  }

  public ReportCostConsumeResponseSchemaReportsCreditSummary remainingPost(Float remainingPost) {
    this.remainingPost = remainingPost;
    return this;
  }

   /**
   * Get remainingPost
   * @return remainingPost
  **/
  @ApiModelProperty(required = true, value = "")
  public Float getRemainingPost() {
    return remainingPost;
  }

  public void setRemainingPost(Float remainingPost) {
    this.remainingPost = remainingPost;
  }

  public ReportCostConsumeResponseSchemaReportsCreditSummary remainingPre(Float remainingPre) {
    this.remainingPre = remainingPre;
    return this;
  }

   /**
   * Get remainingPre
   * @return remainingPre
  **/
  @ApiModelProperty(required = true, value = "")
  public Float getRemainingPre() {
    return remainingPre;
  }

  public void setRemainingPre(Float remainingPre) {
    this.remainingPre = remainingPre;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReportCostConsumeResponseSchemaReportsCreditSummary reportCostConsumeResponseSchemaReportsCreditSummary = (ReportCostConsumeResponseSchemaReportsCreditSummary) o;
    return Objects.equals(this.accounted, reportCostConsumeResponseSchemaReportsCreditSummary.accounted) &&
        Objects.equals(this.consumePeriod, reportCostConsumeResponseSchemaReportsCreditSummary.consumePeriod) &&
        Objects.equals(this.initial, reportCostConsumeResponseSchemaReportsCreditSummary.initial) &&
        Objects.equals(this.remainingPost, reportCostConsumeResponseSchemaReportsCreditSummary.remainingPost) &&
        Objects.equals(this.remainingPre, reportCostConsumeResponseSchemaReportsCreditSummary.remainingPre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accounted, consumePeriod, initial, remainingPost, remainingPre);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReportCostConsumeResponseSchemaReportsCreditSummary {\n");
    
    sb.append("    accounted: ").append(toIndentedString(accounted)).append("\n");
    sb.append("    consumePeriod: ").append(toIndentedString(consumePeriod)).append("\n");
    sb.append("    initial: ").append(toIndentedString(initial)).append("\n");
    sb.append("    remainingPost: ").append(toIndentedString(remainingPost)).append("\n");
    sb.append("    remainingPre: ").append(toIndentedString(remainingPre)).append("\n");
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

