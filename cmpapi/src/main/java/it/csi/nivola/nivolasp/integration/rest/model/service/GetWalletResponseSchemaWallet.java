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

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * GetWalletResponseSchemaWallet
 */

public class GetWalletResponseSchemaWallet {
  @JsonProperty("__meta__")
  private GetAccountCapabilityResponseSchemaCapabilitiesMeta_ meta_ = null;

  @JsonProperty("active")
  private Boolean active = null;

  @JsonProperty("capital_total")
  private BigDecimal capitalTotal = null;

  @JsonProperty("capital_used")
  private BigDecimal capitalUsed = null;

  @JsonProperty("date")
  private GetAccountCapabilityResponseSchemaCapabilitiesDate date = null;

  @JsonProperty("desc")
  private String desc = null;

  @JsonProperty("division_id")
  private String divisionId = null;

  @JsonProperty("evaluation_date")
  private LocalDateTime evaluationDate = null;

  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("service_status_id")
  private Integer serviceStatusId = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("uuid")
  private String uuid = null;

  @JsonProperty("version")
  private String version = null;

  @JsonProperty("year")
  private String year = null;

  public GetWalletResponseSchemaWallet meta_(GetAccountCapabilityResponseSchemaCapabilitiesMeta_ meta_) {
    this.meta_ = meta_;
    return this;
  }

   /**
   * Get meta_
   * @return meta_
  **/
  @ApiModelProperty(required = true, value = "")
  public GetAccountCapabilityResponseSchemaCapabilitiesMeta_ getMeta_() {
    return meta_;
  }

  public void setMeta_(GetAccountCapabilityResponseSchemaCapabilitiesMeta_ meta_) {
    this.meta_ = meta_;
  }

  public GetWalletResponseSchemaWallet active(Boolean active) {
    this.active = active;
    return this;
  }

   /**
   * Get active
   * @return active
  **/
  @ApiModelProperty(example = "true", required = true, value = "")
  public Boolean isActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public GetWalletResponseSchemaWallet capitalTotal(BigDecimal capitalTotal) {
    this.capitalTotal = capitalTotal;
    return this;
  }

   /**
   * Get capitalTotal
   * @return capitalTotal
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getCapitalTotal() {
    return capitalTotal;
  }

  public void setCapitalTotal(BigDecimal capitalTotal) {
    this.capitalTotal = capitalTotal;
  }

  public GetWalletResponseSchemaWallet capitalUsed(BigDecimal capitalUsed) {
    this.capitalUsed = capitalUsed;
    return this;
  }

   /**
   * Get capitalUsed
   * @return capitalUsed
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getCapitalUsed() {
    return capitalUsed;
  }

  public void setCapitalUsed(BigDecimal capitalUsed) {
    this.capitalUsed = capitalUsed;
  }

  public GetWalletResponseSchemaWallet date(GetAccountCapabilityResponseSchemaCapabilitiesDate date) {
    this.date = date;
    return this;
  }

   /**
   * Get date
   * @return date
  **/
  @ApiModelProperty(required = true, value = "")
  public GetAccountCapabilityResponseSchemaCapabilitiesDate getDate() {
    return date;
  }

  public void setDate(GetAccountCapabilityResponseSchemaCapabilitiesDate date) {
    this.date = date;
  }

  public GetWalletResponseSchemaWallet desc(String desc) {
    this.desc = desc;
    return this;
  }

   /**
   * Get desc
   * @return desc
  **/
  @ApiModelProperty(example = "test", required = true, value = "")
  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public GetWalletResponseSchemaWallet divisionId(String divisionId) {
    this.divisionId = divisionId;
    return this;
  }

   /**
   * Get divisionId
   * @return divisionId
  **/
  @ApiModelProperty(value = "")
  public String getDivisionId() {
    return divisionId;
  }

  public void setDivisionId(String divisionId) {
    this.divisionId = divisionId;
  }

  public GetWalletResponseSchemaWallet evaluationDate(LocalDateTime evaluationDate) {
    this.evaluationDate = evaluationDate;
    return this;
  }

   /**
   * Get evaluationDate
   * @return evaluationDate
  **/
  @ApiModelProperty(value = "")
  public LocalDateTime getEvaluationDate() {
    return evaluationDate;
  }

  public void setEvaluationDate(LocalDateTime evaluationDate) {
    this.evaluationDate = evaluationDate;
  }

  public GetWalletResponseSchemaWallet id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "10", required = true, value = "")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public GetWalletResponseSchemaWallet name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "test", required = true, value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GetWalletResponseSchemaWallet serviceStatusId(Integer serviceStatusId) {
    this.serviceStatusId = serviceStatusId;
    return this;
  }

   /**
   * Get serviceStatusId
   * @return serviceStatusId
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getServiceStatusId() {
    return serviceStatusId;
  }

  public void setServiceStatusId(Integer serviceStatusId) {
    this.serviceStatusId = serviceStatusId;
  }

  public GetWalletResponseSchemaWallet status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(required = true, value = "")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public GetWalletResponseSchemaWallet uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * Get uuid
   * @return uuid
  **/
  @ApiModelProperty(example = "4cdf0ea4-159a-45aa-96f2-708e461130e1", required = true, value = "")
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public GetWalletResponseSchemaWallet version(String version) {
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @ApiModelProperty(value = "")
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public GetWalletResponseSchemaWallet year(String year) {
    this.year = year;
    return this;
  }

   /**
   * Get year
   * @return year
  **/
  @ApiModelProperty(required = true, value = "")
  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetWalletResponseSchemaWallet getWalletResponseSchemaWallet = (GetWalletResponseSchemaWallet) o;
    return Objects.equals(this.meta_, getWalletResponseSchemaWallet.meta_) &&
        Objects.equals(this.active, getWalletResponseSchemaWallet.active) &&
        Objects.equals(this.capitalTotal, getWalletResponseSchemaWallet.capitalTotal) &&
        Objects.equals(this.capitalUsed, getWalletResponseSchemaWallet.capitalUsed) &&
        Objects.equals(this.date, getWalletResponseSchemaWallet.date) &&
        Objects.equals(this.desc, getWalletResponseSchemaWallet.desc) &&
        Objects.equals(this.divisionId, getWalletResponseSchemaWallet.divisionId) &&
        Objects.equals(this.evaluationDate, getWalletResponseSchemaWallet.evaluationDate) &&
        Objects.equals(this.id, getWalletResponseSchemaWallet.id) &&
        Objects.equals(this.name, getWalletResponseSchemaWallet.name) &&
        Objects.equals(this.serviceStatusId, getWalletResponseSchemaWallet.serviceStatusId) &&
        Objects.equals(this.status, getWalletResponseSchemaWallet.status) &&
        Objects.equals(this.uuid, getWalletResponseSchemaWallet.uuid) &&
        Objects.equals(this.version, getWalletResponseSchemaWallet.version) &&
        Objects.equals(this.year, getWalletResponseSchemaWallet.year);
  }

  @Override
  public int hashCode() {
    return Objects.hash(meta_, active, capitalTotal, capitalUsed, date, desc, divisionId, evaluationDate, id, name, serviceStatusId, status, uuid, version, year);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetWalletResponseSchemaWallet {\n");
    
    sb.append("    meta_: ").append(toIndentedString(meta_)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    capitalTotal: ").append(toIndentedString(capitalTotal)).append("\n");
    sb.append("    capitalUsed: ").append(toIndentedString(capitalUsed)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    divisionId: ").append(toIndentedString(divisionId)).append("\n");
    sb.append("    evaluationDate: ").append(toIndentedString(evaluationDate)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    serviceStatusId: ").append(toIndentedString(serviceStatusId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
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
