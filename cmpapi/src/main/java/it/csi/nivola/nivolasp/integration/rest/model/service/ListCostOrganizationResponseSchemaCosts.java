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
 * ListCostOrganizationResponseSchemaCosts
 */

public class ListCostOrganizationResponseSchemaCosts {
  @JsonProperty("cost_reported")
  private Float costReported = null;

  @JsonProperty("cost_tot")
  private Float costTot = null;

  @JsonProperty("cost_unreported")
  private Float costUnreported = null;

  @JsonProperty("credit_res")
  private Float creditRes = null;

  @JsonProperty("credit_tot")
  private Float creditTot = null;

  @JsonProperty("extraction_date")
  private LocalDateTime extractionDate = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("uuid")
  private String uuid = null;

  public ListCostOrganizationResponseSchemaCosts costReported(Float costReported) {
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

  public ListCostOrganizationResponseSchemaCosts costTot(Float costTot) {
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

  public ListCostOrganizationResponseSchemaCosts costUnreported(Float costUnreported) {
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

  public ListCostOrganizationResponseSchemaCosts creditRes(Float creditRes) {
    this.creditRes = creditRes;
    return this;
  }

   /**
   * Get creditRes
   * @return creditRes
  **/
  @ApiModelProperty(required = true, value = "")
  public Float getCreditRes() {
    return creditRes;
  }

  public void setCreditRes(Float creditRes) {
    this.creditRes = creditRes;
  }

  public ListCostOrganizationResponseSchemaCosts creditTot(Float creditTot) {
    this.creditTot = creditTot;
    return this;
  }

   /**
   * Get creditTot
   * @return creditTot
  **/
  @ApiModelProperty(required = true, value = "")
  public Float getCreditTot() {
    return creditTot;
  }

  public void setCreditTot(Float creditTot) {
    this.creditTot = creditTot;
  }

  public ListCostOrganizationResponseSchemaCosts extractionDate(LocalDateTime extractionDate) {
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

  public ListCostOrganizationResponseSchemaCosts name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Organization name
   * @return name
  **/
  @ApiModelProperty(value = "Organization name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ListCostOrganizationResponseSchemaCosts uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * Organization uuid
   * @return uuid
  **/
  @ApiModelProperty(value = "Organization uuid")
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
    ListCostOrganizationResponseSchemaCosts listCostOrganizationResponseSchemaCosts = (ListCostOrganizationResponseSchemaCosts) o;
    return Objects.equals(this.costReported, listCostOrganizationResponseSchemaCosts.costReported) &&
        Objects.equals(this.costTot, listCostOrganizationResponseSchemaCosts.costTot) &&
        Objects.equals(this.costUnreported, listCostOrganizationResponseSchemaCosts.costUnreported) &&
        Objects.equals(this.creditRes, listCostOrganizationResponseSchemaCosts.creditRes) &&
        Objects.equals(this.creditTot, listCostOrganizationResponseSchemaCosts.creditTot) &&
        Objects.equals(this.extractionDate, listCostOrganizationResponseSchemaCosts.extractionDate) &&
        Objects.equals(this.name, listCostOrganizationResponseSchemaCosts.name) &&
        Objects.equals(this.uuid, listCostOrganizationResponseSchemaCosts.uuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(costReported, costTot, costUnreported, creditRes, creditTot, extractionDate, name, uuid);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListCostOrganizationResponseSchemaCosts {\n");
    
    sb.append("    costReported: ").append(toIndentedString(costReported)).append("\n");
    sb.append("    costTot: ").append(toIndentedString(costTot)).append("\n");
    sb.append("    costUnreported: ").append(toIndentedString(costUnreported)).append("\n");
    sb.append("    creditRes: ").append(toIndentedString(creditRes)).append("\n");
    sb.append("    creditTot: ").append(toIndentedString(creditTot)).append("\n");
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

