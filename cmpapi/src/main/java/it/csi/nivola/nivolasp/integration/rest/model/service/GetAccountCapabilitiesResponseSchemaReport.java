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
 * GetAccountCapabilitiesResponseSchemaReport
 */

public class GetAccountCapabilitiesResponseSchemaReport {
  @JsonProperty("definitions")
  private GetAccountCapabilitiesResponseSchemaReportDefinitions definitions = null;

  @JsonProperty("services")
  private GetAccountCapabilitiesResponseSchemaReportServices services = null;

  public GetAccountCapabilitiesResponseSchemaReport definitions(GetAccountCapabilitiesResponseSchemaReportDefinitions definitions) {
    this.definitions = definitions;
    return this;
  }

   /**
   * Get definitions
   * @return definitions
  **/
  @ApiModelProperty(value = "")
  public GetAccountCapabilitiesResponseSchemaReportDefinitions getDefinitions() {
    return definitions;
  }

  public void setDefinitions(GetAccountCapabilitiesResponseSchemaReportDefinitions definitions) {
    this.definitions = definitions;
  }

  public GetAccountCapabilitiesResponseSchemaReport services(GetAccountCapabilitiesResponseSchemaReportServices services) {
    this.services = services;
    return this;
  }

   /**
   * Get services
   * @return services
  **/
  @ApiModelProperty(value = "")
  public GetAccountCapabilitiesResponseSchemaReportServices getServices() {
    return services;
  }

  public void setServices(GetAccountCapabilitiesResponseSchemaReportServices services) {
    this.services = services;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetAccountCapabilitiesResponseSchemaReport getAccountCapabilitiesResponseSchemaReport = (GetAccountCapabilitiesResponseSchemaReport) o;
    return Objects.equals(this.definitions, getAccountCapabilitiesResponseSchemaReport.definitions) &&
        Objects.equals(this.services, getAccountCapabilitiesResponseSchemaReport.services);
  }

  @Override
  public int hashCode() {
    return Objects.hash(definitions, services);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetAccountCapabilitiesResponseSchemaReport {\n");
    
    sb.append("    definitions: ").append(toIndentedString(definitions)).append("\n");
    sb.append("    services: ").append(toIndentedString(services)).append("\n");
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
