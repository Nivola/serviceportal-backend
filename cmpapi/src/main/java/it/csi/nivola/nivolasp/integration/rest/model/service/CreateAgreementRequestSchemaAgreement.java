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
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CreateAgreementRequestSchemaAgreement
 */

public class CreateAgreementRequestSchemaAgreement {
  @JsonProperty("agreement_date_end")
  private LocalDate agreementDateEnd = null;

  @JsonProperty("agreement_date_start")
  private LocalDate agreementDateStart = null;

  @JsonProperty("amount")
  private BigDecimal amount = null;

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("desc")
  private String desc = null;

  @JsonProperty("year")
  private Integer year = null;

  public CreateAgreementRequestSchemaAgreement agreementDateEnd(LocalDate agreementDateEnd) {
    this.agreementDateEnd = agreementDateEnd;
    return this;
  }

   /**
   * Get agreementDateEnd
   * @return agreementDateEnd
  **/
  @ApiModelProperty(value = "")
  public LocalDate getAgreementDateEnd() {
    return agreementDateEnd;
  }

  public void setAgreementDateEnd(LocalDate agreementDateEnd) {
    this.agreementDateEnd = agreementDateEnd;
  }

  public CreateAgreementRequestSchemaAgreement agreementDateStart(LocalDate agreementDateStart) {
    this.agreementDateStart = agreementDateStart;
    return this;
  }

   /**
   * Get agreementDateStart
   * @return agreementDateStart
  **/
  @ApiModelProperty(value = "")
  public LocalDate getAgreementDateStart() {
    return agreementDateStart;
  }

  public void setAgreementDateStart(LocalDate agreementDateStart) {
    this.agreementDateStart = agreementDateStart;
  }

  public CreateAgreementRequestSchemaAgreement amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

   /**
   * Get amount
   * @return amount
  **/
  @ApiModelProperty(required = true, value = "")
  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public CreateAgreementRequestSchemaAgreement code(String code) {
    this.code = code;
    return this;
  }

   /**
   * Get code
   * @return code
  **/
  @ApiModelProperty(value = "")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public CreateAgreementRequestSchemaAgreement desc(String desc) {
    this.desc = desc;
    return this;
  }

   /**
   * Get desc
   * @return desc
  **/
  @ApiModelProperty(value = "")
  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public CreateAgreementRequestSchemaAgreement year(Integer year) {
    this.year = year;
    return this;
  }

   /**
   * Get year
   * @return year
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
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
    CreateAgreementRequestSchemaAgreement createAgreementRequestSchemaAgreement = (CreateAgreementRequestSchemaAgreement) o;
    return Objects.equals(this.agreementDateEnd, createAgreementRequestSchemaAgreement.agreementDateEnd) &&
        Objects.equals(this.agreementDateStart, createAgreementRequestSchemaAgreement.agreementDateStart) &&
        Objects.equals(this.amount, createAgreementRequestSchemaAgreement.amount) &&
        Objects.equals(this.code, createAgreementRequestSchemaAgreement.code) &&
        Objects.equals(this.desc, createAgreementRequestSchemaAgreement.desc) &&
        Objects.equals(this.year, createAgreementRequestSchemaAgreement.year);
  }

  @Override
  public int hashCode() {
    return Objects.hash(agreementDateEnd, agreementDateStart, amount, code, desc, year);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateAgreementRequestSchemaAgreement {\n");
    
    sb.append("    agreementDateEnd: ").append(toIndentedString(agreementDateEnd)).append("\n");
    sb.append("    agreementDateStart: ").append(toIndentedString(agreementDateStart)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
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

