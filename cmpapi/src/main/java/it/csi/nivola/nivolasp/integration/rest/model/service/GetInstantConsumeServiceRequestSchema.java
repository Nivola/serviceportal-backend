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

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * GetInstantConsumeServiceRequestSchema
 */

public class GetInstantConsumeServiceRequestSchema {
  @JsonProperty("extraction_date")
  private LocalDateTime extractionDate = null;

  @JsonProperty("oid")
  private String oid = null;

  public GetInstantConsumeServiceRequestSchema extractionDate(LocalDateTime extractionDate) {
    this.extractionDate = extractionDate;
    return this;
  }

   /**
   * Get extractionDate
   * @return extractionDate
  **/
  @ApiModelProperty(value = "")
  public LocalDateTime getExtractionDate() {
    return extractionDate;
  }

  public void setExtractionDate(LocalDateTime extractionDate) {
    this.extractionDate = extractionDate;
  }

  public GetInstantConsumeServiceRequestSchema oid(String oid) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetInstantConsumeServiceRequestSchema getInstantConsumeServiceRequestSchema = (GetInstantConsumeServiceRequestSchema) o;
    return Objects.equals(this.extractionDate, getInstantConsumeServiceRequestSchema.extractionDate) &&
        Objects.equals(this.oid, getInstantConsumeServiceRequestSchema.oid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(extractionDate, oid);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetInstantConsumeServiceRequestSchema {\n");
    
    sb.append("    extractionDate: ").append(toIndentedString(extractionDate)).append("\n");
    sb.append("    oid: ").append(toIndentedString(oid)).append("\n");
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
