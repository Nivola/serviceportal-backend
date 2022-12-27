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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ReportCostConsumeResponseSchemaReports
 */

public class ReportCostConsumeResponseSchemaReports {
  @JsonProperty("account")
  private String account = null;

  @JsonProperty("account_id")
  private String accountId = null;

  @JsonProperty("amount")
  private Float amount = null;

  @JsonProperty("credit_composition")
  private ReportCostConsumeResponseSchemaReportsCreditComposition creditComposition = null;

  @JsonProperty("credit_summary")
  private ReportCostConsumeResponseSchemaReportsCreditSummary creditSummary = null;

  @JsonProperty("date_report")
  private LocalDate dateReport = null;

  @JsonProperty("division")
  private String division = null;

  @JsonProperty("division_id")
  private String divisionId = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("hasvat")
  private Boolean hasvat = null;

  @JsonProperty("organization")
  private String organization = null;

  @JsonProperty("organization_id")
  private String organizationId = null;

  @JsonProperty("period")
  private ReportCostConsumeResponseSchemaReportsPeriod period = null;

  @JsonProperty("postal_address")
  private String postalAddress = null;

  @JsonProperty("referent")
  private String referent = null;

  @JsonProperty("services")
  private List<ReportCostConsumeResponseSchemaReportsServices> services = null;

  public ReportCostConsumeResponseSchemaReports account(String account) {
    this.account = account;
    return this;
  }

   /**
   * Get account
   * @return account
  **/
  @ApiModelProperty(required = true, value = "")
  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public ReportCostConsumeResponseSchemaReports accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

   /**
   * Get accountId
   * @return accountId
  **/
  @ApiModelProperty(required = true, value = "")
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public ReportCostConsumeResponseSchemaReports amount(Float amount) {
    this.amount = amount;
    return this;
  }

   /**
   * Get amount
   * @return amount
  **/
  @ApiModelProperty(required = true, value = "")
  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }

  public ReportCostConsumeResponseSchemaReports creditComposition(ReportCostConsumeResponseSchemaReportsCreditComposition creditComposition) {
    this.creditComposition = creditComposition;
    return this;
  }

   /**
   * Get creditComposition
   * @return creditComposition
  **/
  @ApiModelProperty(value = "")
  public ReportCostConsumeResponseSchemaReportsCreditComposition getCreditComposition() {
    return creditComposition;
  }

  public void setCreditComposition(ReportCostConsumeResponseSchemaReportsCreditComposition creditComposition) {
    this.creditComposition = creditComposition;
  }

  public ReportCostConsumeResponseSchemaReports creditSummary(ReportCostConsumeResponseSchemaReportsCreditSummary creditSummary) {
    this.creditSummary = creditSummary;
    return this;
  }

   /**
   * Get creditSummary
   * @return creditSummary
  **/
  @ApiModelProperty(required = true, value = "")
  public ReportCostConsumeResponseSchemaReportsCreditSummary getCreditSummary() {
    return creditSummary;
  }

  public void setCreditSummary(ReportCostConsumeResponseSchemaReportsCreditSummary creditSummary) {
    this.creditSummary = creditSummary;
  }

  public ReportCostConsumeResponseSchemaReports dateReport(LocalDate dateReport) {
    this.dateReport = dateReport;
    return this;
  }

   /**
   * Get dateReport
   * @return dateReport
  **/
  @ApiModelProperty(required = true, value = "")
  public LocalDate getDateReport() {
    return dateReport;
  }

  public void setDateReport(LocalDate dateReport) {
    this.dateReport = dateReport;
  }

  public ReportCostConsumeResponseSchemaReports division(String division) {
    this.division = division;
    return this;
  }

   /**
   * Get division
   * @return division
  **/
  @ApiModelProperty(required = true, value = "")
  public String getDivision() {
    return division;
  }

  public void setDivision(String division) {
    this.division = division;
  }

  public ReportCostConsumeResponseSchemaReports divisionId(String divisionId) {
    this.divisionId = divisionId;
    return this;
  }

   /**
   * Get divisionId
   * @return divisionId
  **/
  @ApiModelProperty(required = true, value = "")
  public String getDivisionId() {
    return divisionId;
  }

  public void setDivisionId(String divisionId) {
    this.divisionId = divisionId;
  }

  public ReportCostConsumeResponseSchemaReports email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(value = "")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public ReportCostConsumeResponseSchemaReports hasvat(Boolean hasvat) {
    this.hasvat = hasvat;
    return this;
  }

   /**
   * Get hasvat
   * @return hasvat
  **/
  @ApiModelProperty(required = true, value = "")
  public Boolean isHasvat() {
    return hasvat;
  }

  public void setHasvat(Boolean hasvat) {
    this.hasvat = hasvat;
  }

  public ReportCostConsumeResponseSchemaReports organization(String organization) {
    this.organization = organization;
    return this;
  }

   /**
   * Get organization
   * @return organization
  **/
  @ApiModelProperty(required = true, value = "")
  public String getOrganization() {
    return organization;
  }

  public void setOrganization(String organization) {
    this.organization = organization;
  }

  public ReportCostConsumeResponseSchemaReports organizationId(String organizationId) {
    this.organizationId = organizationId;
    return this;
  }

   /**
   * Get organizationId
   * @return organizationId
  **/
  @ApiModelProperty(required = true, value = "")
  public String getOrganizationId() {
    return organizationId;
  }

  public void setOrganizationId(String organizationId) {
    this.organizationId = organizationId;
  }

  public ReportCostConsumeResponseSchemaReports period(ReportCostConsumeResponseSchemaReportsPeriod period) {
    this.period = period;
    return this;
  }

   /**
   * Get period
   * @return period
  **/
  @ApiModelProperty(required = true, value = "")
  public ReportCostConsumeResponseSchemaReportsPeriod getPeriod() {
    return period;
  }

  public void setPeriod(ReportCostConsumeResponseSchemaReportsPeriod period) {
    this.period = period;
  }

  public ReportCostConsumeResponseSchemaReports postalAddress(String postalAddress) {
    this.postalAddress = postalAddress;
    return this;
  }

   /**
   * Get postalAddress
   * @return postalAddress
  **/
  @ApiModelProperty(value = "")
  public String getPostalAddress() {
    return postalAddress;
  }

  public void setPostalAddress(String postalAddress) {
    this.postalAddress = postalAddress;
  }

  public ReportCostConsumeResponseSchemaReports referent(String referent) {
    this.referent = referent;
    return this;
  }

   /**
   * Get referent
   * @return referent
  **/
  @ApiModelProperty(value = "")
  public String getReferent() {
    return referent;
  }

  public void setReferent(String referent) {
    this.referent = referent;
  }

  public ReportCostConsumeResponseSchemaReports services(List<ReportCostConsumeResponseSchemaReportsServices> services) {
    this.services = services;
    return this;
  }

  public ReportCostConsumeResponseSchemaReports addServicesItem(ReportCostConsumeResponseSchemaReportsServices servicesItem) {
    if (this.services == null) {
      this.services = new ArrayList<>();
    }
    this.services.add(servicesItem);
    return this;
  }

   /**
   * Get services
   * @return services
  **/
  @ApiModelProperty(value = "")
  public List<ReportCostConsumeResponseSchemaReportsServices> getServices() {
    return services;
  }

  public void setServices(List<ReportCostConsumeResponseSchemaReportsServices> services) {
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
    ReportCostConsumeResponseSchemaReports reportCostConsumeResponseSchemaReports = (ReportCostConsumeResponseSchemaReports) o;
    return Objects.equals(this.account, reportCostConsumeResponseSchemaReports.account) &&
        Objects.equals(this.accountId, reportCostConsumeResponseSchemaReports.accountId) &&
        Objects.equals(this.amount, reportCostConsumeResponseSchemaReports.amount) &&
        Objects.equals(this.creditComposition, reportCostConsumeResponseSchemaReports.creditComposition) &&
        Objects.equals(this.creditSummary, reportCostConsumeResponseSchemaReports.creditSummary) &&
        Objects.equals(this.dateReport, reportCostConsumeResponseSchemaReports.dateReport) &&
        Objects.equals(this.division, reportCostConsumeResponseSchemaReports.division) &&
        Objects.equals(this.divisionId, reportCostConsumeResponseSchemaReports.divisionId) &&
        Objects.equals(this.email, reportCostConsumeResponseSchemaReports.email) &&
        Objects.equals(this.hasvat, reportCostConsumeResponseSchemaReports.hasvat) &&
        Objects.equals(this.organization, reportCostConsumeResponseSchemaReports.organization) &&
        Objects.equals(this.organizationId, reportCostConsumeResponseSchemaReports.organizationId) &&
        Objects.equals(this.period, reportCostConsumeResponseSchemaReports.period) &&
        Objects.equals(this.postalAddress, reportCostConsumeResponseSchemaReports.postalAddress) &&
        Objects.equals(this.referent, reportCostConsumeResponseSchemaReports.referent) &&
        Objects.equals(this.services, reportCostConsumeResponseSchemaReports.services);
  }

  @Override
  public int hashCode() {
    return Objects.hash(account, accountId, amount, creditComposition, creditSummary, dateReport, division, divisionId, email, hasvat, organization, organizationId, period, postalAddress, referent, services);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReportCostConsumeResponseSchemaReports {\n");
    
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    creditComposition: ").append(toIndentedString(creditComposition)).append("\n");
    sb.append("    creditSummary: ").append(toIndentedString(creditSummary)).append("\n");
    sb.append("    dateReport: ").append(toIndentedString(dateReport)).append("\n");
    sb.append("    division: ").append(toIndentedString(division)).append("\n");
    sb.append("    divisionId: ").append(toIndentedString(divisionId)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    hasvat: ").append(toIndentedString(hasvat)).append("\n");
    sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
    sb.append("    organizationId: ").append(toIndentedString(organizationId)).append("\n");
    sb.append("    period: ").append(toIndentedString(period)).append("\n");
    sb.append("    postalAddress: ").append(toIndentedString(postalAddress)).append("\n");
    sb.append("    referent: ").append(toIndentedString(referent)).append("\n");
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
      return "";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

