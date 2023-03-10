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

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ListCostsAccountResponseSchemaCosts
 */

public class ListCostsAccountResponseSchemaCosts {
  @JsonProperty("cost_reported")
  private Float costReported = null;

  @JsonProperty("cost_tot")
  private Float costTot = null;

  @JsonProperty("cost_unreported")
  private Float costUnreported = null;

  @JsonProperty("extraction_date")
  private LocalDateTime extractionDate = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("uuid")
  private String uuid = null;

  public ListCostsAccountResponseSchemaCosts costReported(Float costReported) {
    this.costReported = costReported;
    return this;
  }

   /**
   * Get costReported
   * @return costReported
  **/
  @ApiModelProperty(required = true, value = "")
  public Float getCostReported() {
    return costReported;
  }

  public void setCostReported(Float costReported) {
    this.costReported = costReported;
  }

  public ListCostsAccountResponseSchemaCosts costTot(Float costTot) {
    this.costTot = costTot;
    return this;
  }

   /**
   * Get costTot
   * @return costTot
  **/
  @ApiModelProperty(required = true, value = "")
  public Float getCostTot() {
    return costTot;
  }

  public void setCostTot(Float costTot) {
    this.costTot = costTot;
  }

  public ListCostsAccountResponseSchemaCosts costUnreported(Float costUnreported) {
    this.costUnreported = costUnreported;
    return this;
  }

   /**
   * Get costUnreported
   * @return costUnreported
  **/
  @ApiModelProperty(required = true, value = "")
  public Float getCostUnreported() {
    return costUnreported;
  }

  public void setCostUnreported(Float costUnreported) {
    this.costUnreported = costUnreported;
  }

  public ListCostsAccountResponseSchemaCosts extractionDate(LocalDateTime extractionDate) {
    this.extractionDate = extractionDate;
    return this;
  }

   /**
   * Get extractionDate
   * @return extractionDate
  **/
  @ApiModelProperty(required = true, value = "")
  public LocalDateTime getExtractionDate() {
    return extractionDate;
  }

  public void setExtractionDate(LocalDateTime extractionDate) {
    this.extractionDate = extractionDate;
  }

  public ListCostsAccountResponseSchemaCosts name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Account name
   * @return name
  **/
  @ApiModelProperty(value = "Account name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ListCostsAccountResponseSchemaCosts uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * Account uuid
   * @return uuid
  **/
  @ApiModelProperty(example = "4cdf0ea4-159a-45aa-96f2-708e461130e1", value = "Account uuid")
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListCostsAccountResponseSchemaCosts listCostsAccountResponseSchemaCosts = (ListCostsAccountResponseSchemaCosts) o;
    return Objects.equals(this.costReported, listCostsAccountResponseSchemaCosts.costReported) &&
        Objects.equals(this.costTot, listCostsAccountResponseSchemaCosts.costTot) &&
        Objects.equals(this.costUnreported, listCostsAccountResponseSchemaCosts.costUnreported) &&
        Objects.equals(this.extractionDate, listCostsAccountResponseSchemaCosts.extractionDate) &&
        Objects.equals(this.name, listCostsAccountResponseSchemaCosts.name) &&
        Objects.equals(this.uuid, listCostsAccountResponseSchemaCosts.uuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(costReported, costTot, costUnreported, extractionDate, name, uuid);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListCostsAccountResponseSchemaCosts {\n");
    
    sb.append("    costReported: ").append(toIndentedString(costReported)).append("\n");
    sb.append("    costTot: ").append(toIndentedString(costTot)).append("\n");
    sb.append("    costUnreported: ").append(toIndentedString(costUnreported)).append("\n");
    sb.append("    extractionDate: ").append(toIndentedString(extractionDate)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
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

