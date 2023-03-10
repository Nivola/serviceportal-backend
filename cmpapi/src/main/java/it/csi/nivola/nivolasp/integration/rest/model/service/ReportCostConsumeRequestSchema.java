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

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * ReportCostConsumeRequestSchema
 */

public class ReportCostConsumeRequestSchema {
  @JsonProperty("end_date")
  private LocalDateTime endDate = null;

  @JsonProperty("oid")
  private String oid = null;

  /**
   * extraction report mode:[u&#39;SUMMARY&#39;, u&#39;COMPLETE&#39;]
   */
  public enum ReportModeEnum {
    SUMMARY("SUMMARY"),
    
    COMPLETE("COMPLETE");

    private String value;

    ReportModeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ReportModeEnum fromValue(String text) {
      for (ReportModeEnum b : ReportModeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("report_mode")
  private ReportModeEnum reportMode = ReportModeEnum.COMPLETE;

  @JsonProperty("start_date")
  private LocalDateTime startDate = null;

  @JsonProperty("year_month")
  private String yearMonth = null;

  public ReportCostConsumeRequestSchema endDate(LocalDateTime endDate) {
    this.endDate = endDate;
    return this;
  }

   /**
   * report extraction start date
   * @return endDate
  **/
  @ApiModelProperty(example = "", value = "report extraction start date")
  public LocalDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDateTime endDate) {
    this.endDate = endDate;
  }

  public ReportCostConsumeRequestSchema oid(String oid) {
    this.oid = oid;
    return this;
  }

   /**
   * id, uuid or name
   * @return oid
  **/
  @ApiModelProperty(required = true, value = "id, uuid or name")
  public String getOid() {
    return oid;
  }

  public void setOid(String oid) {
    this.oid = oid;
  }

  public ReportCostConsumeRequestSchema reportMode(ReportModeEnum reportMode) {
    this.reportMode = reportMode;
    return this;
  }

   /**
   * extraction report mode:[u&#39;SUMMARY&#39;, u&#39;COMPLETE&#39;]
   * @return reportMode
  **/
  @ApiModelProperty(example = "SUMMARY", value = "extraction report mode:[u'SUMMARY', u'COMPLETE']")
  public ReportModeEnum getReportMode() {
    return reportMode;
  }

  public void setReportMode(ReportModeEnum reportMode) {
    this.reportMode = reportMode;
  }

  public ReportCostConsumeRequestSchema startDate(LocalDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

   /**
   * report extraction start date
   * @return startDate
  **/
  @ApiModelProperty(example = "", value = "report extraction start date")
  public LocalDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDateTime startDate) {
    this.startDate = startDate;
  }

  public ReportCostConsumeRequestSchema yearMonth(String yearMonth) {
    this.yearMonth = yearMonth;
    return this;
  }

   /**
   * report period
   * @return yearMonth
  **/
  @ApiModelProperty(example = "2018-12", value = "report period")
  public String getYearMonth() {
    return yearMonth;
  }

  public void setYearMonth(String yearMonth) {
    this.yearMonth = yearMonth;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReportCostConsumeRequestSchema reportCostConsumeRequestSchema = (ReportCostConsumeRequestSchema) o;
    return Objects.equals(this.endDate, reportCostConsumeRequestSchema.endDate) &&
        Objects.equals(this.oid, reportCostConsumeRequestSchema.oid) &&
        Objects.equals(this.reportMode, reportCostConsumeRequestSchema.reportMode) &&
        Objects.equals(this.startDate, reportCostConsumeRequestSchema.startDate) &&
        Objects.equals(this.yearMonth, reportCostConsumeRequestSchema.yearMonth);
  }

  @Override
  public int hashCode() {
    return Objects.hash(endDate, oid, reportMode, startDate, yearMonth);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReportCostConsumeRequestSchema {\n");
    
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    oid: ").append(toIndentedString(oid)).append("\n");
    sb.append("    reportMode: ").append(toIndentedString(reportMode)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    yearMonth: ").append(toIndentedString(yearMonth)).append("\n");
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

