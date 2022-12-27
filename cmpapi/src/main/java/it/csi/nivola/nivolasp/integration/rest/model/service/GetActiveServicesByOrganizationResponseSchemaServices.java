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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * GetActiveServicesByOrganizationResponseSchemaServices
 */

public class GetActiveServicesByOrganizationResponseSchemaServices {
  @JsonProperty("accounts")
  private Integer accounts = null;

  @JsonProperty("divisions")
  private Integer divisions = null;

  @JsonProperty("extraction_date")
  private LocalDateTime extractionDate = null;

  @JsonProperty("service_container")
  private List<GetActiveServicesByAccountResponseSchemaServicesServiceContainer> serviceContainer = new ArrayList<>();

  public GetActiveServicesByOrganizationResponseSchemaServices accounts(Integer accounts) {
    this.accounts = accounts;
    return this;
  }

   /**
   * Get accounts
   * @return accounts
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getAccounts() {
    return accounts;
  }

  public void setAccounts(Integer accounts) {
    this.accounts = accounts;
  }

  public GetActiveServicesByOrganizationResponseSchemaServices divisions(Integer divisions) {
    this.divisions = divisions;
    return this;
  }

   /**
   * Get divisions
   * @return divisions
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getDivisions() {
    return divisions;
  }

  public void setDivisions(Integer divisions) {
    this.divisions = divisions;
  }

  public GetActiveServicesByOrganizationResponseSchemaServices extractionDate(LocalDateTime extractionDate) {
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

  public GetActiveServicesByOrganizationResponseSchemaServices serviceContainer(List<GetActiveServicesByAccountResponseSchemaServicesServiceContainer> serviceContainer) {
    this.serviceContainer = serviceContainer;
    return this;
  }

  public GetActiveServicesByOrganizationResponseSchemaServices addServiceContainerItem(GetActiveServicesByAccountResponseSchemaServicesServiceContainer serviceContainerItem) {
    this.serviceContainer.add(serviceContainerItem);
    return this;
  }

   /**
   * Get serviceContainer
   * @return serviceContainer
  **/
  @ApiModelProperty(required = true, value = "")
  public List<GetActiveServicesByAccountResponseSchemaServicesServiceContainer> getServiceContainer() {
    return serviceContainer;
  }

  public void setServiceContainer(List<GetActiveServicesByAccountResponseSchemaServicesServiceContainer> serviceContainer) {
    this.serviceContainer = serviceContainer;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetActiveServicesByOrganizationResponseSchemaServices getActiveServicesByOrganizationResponseSchemaServices = (GetActiveServicesByOrganizationResponseSchemaServices) o;
    return Objects.equals(this.accounts, getActiveServicesByOrganizationResponseSchemaServices.accounts) &&
        Objects.equals(this.divisions, getActiveServicesByOrganizationResponseSchemaServices.divisions) &&
        Objects.equals(this.extractionDate, getActiveServicesByOrganizationResponseSchemaServices.extractionDate) &&
        Objects.equals(this.serviceContainer, getActiveServicesByOrganizationResponseSchemaServices.serviceContainer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accounts, divisions, extractionDate, serviceContainer);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetActiveServicesByOrganizationResponseSchemaServices {\n");
    
    sb.append("    accounts: ").append(toIndentedString(accounts)).append("\n");
    sb.append("    divisions: ").append(toIndentedString(divisions)).append("\n");
    sb.append("    extractionDate: ").append(toIndentedString(extractionDate)).append("\n");
    sb.append("    serviceContainer: ").append(toIndentedString(serviceContainer)).append("\n");
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

