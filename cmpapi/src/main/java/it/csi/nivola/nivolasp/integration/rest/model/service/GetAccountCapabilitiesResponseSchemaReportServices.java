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
 * GetAccountCapabilitiesResponseSchemaReportServices
 */

public class GetAccountCapabilitiesResponseSchemaReportServices {
  @JsonProperty("created")
  private Integer created = null;

  @JsonProperty("error")
  private Integer error = null;

  @JsonProperty("required")
  private Integer required = null;

  public GetAccountCapabilitiesResponseSchemaReportServices created(Integer created) {
    this.created = created;
    return this;
  }

   /**
   * Get created
   * @return created
  **/
  @ApiModelProperty(value = "")
  public Integer getCreated() {
    return created;
  }

  public void setCreated(Integer created) {
    this.created = created;
  }

  public GetAccountCapabilitiesResponseSchemaReportServices error(Integer error) {
    this.error = error;
    return this;
  }

   /**
   * Get error
   * @return error
  **/
  @ApiModelProperty(value = "")
  public Integer getError() {
    return error;
  }

  public void setError(Integer error) {
    this.error = error;
  }

  public GetAccountCapabilitiesResponseSchemaReportServices required(Integer required) {
    this.required = required;
    return this;
  }

   /**
   * Get required
   * @return required
  **/
  @ApiModelProperty(value = "")
  public Integer getRequired() {
    return required;
  }

  public void setRequired(Integer required) {
    this.required = required;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetAccountCapabilitiesResponseSchemaReportServices getAccountCapabilitiesResponseSchemaReportServices = (GetAccountCapabilitiesResponseSchemaReportServices) o;
    return Objects.equals(this.created, getAccountCapabilitiesResponseSchemaReportServices.created) &&
        Objects.equals(this.error, getAccountCapabilitiesResponseSchemaReportServices.error) &&
        Objects.equals(this.required, getAccountCapabilitiesResponseSchemaReportServices.required);
  }

  @Override
  public int hashCode() {
    return Objects.hash(created, error, required);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetAccountCapabilitiesResponseSchemaReportServices {\n");
    
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    required: ").append(toIndentedString(required)).append("\n");
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

