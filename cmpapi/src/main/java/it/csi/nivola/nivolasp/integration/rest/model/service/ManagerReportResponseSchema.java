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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ManagerReportResponseSchema
 */

public class ManagerReportResponseSchema {
  @JsonProperty("workers_report")
  private List<Object> workersReport = new ArrayList<>();

  public ManagerReportResponseSchema workersReport(List<Object> workersReport) {
    this.workersReport = workersReport;
    return this;
  }

  public ManagerReportResponseSchema addWorkersReportItem(Object workersReportItem) {
    this.workersReport.add(workersReportItem);
    return this;
  }

   /**
   * Get workersReport
   * @return workersReport
  **/
  @ApiModelProperty(required = true, value = "")
  public List<Object> getWorkersReport() {
    return workersReport;
  }

  public void setWorkersReport(List<Object> workersReport) {
    this.workersReport = workersReport;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ManagerReportResponseSchema managerReportResponseSchema = (ManagerReportResponseSchema) o;
    return Objects.equals(this.workersReport, managerReportResponseSchema.workersReport);
  }

  @Override
  public int hashCode() {
    return Objects.hash(workersReport);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ManagerReportResponseSchema {\n");
    
    sb.append("    workersReport: ").append(toIndentedString(workersReport)).append("\n");
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
