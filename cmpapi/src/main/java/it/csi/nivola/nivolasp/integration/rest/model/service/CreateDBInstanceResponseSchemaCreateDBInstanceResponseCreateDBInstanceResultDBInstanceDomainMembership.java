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
 * CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDomainMembership
 */

public class CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDomainMembership {
  @JsonProperty("Domain")
  private String domain = null;

  @JsonProperty("FQDN")
  private String FQDN = null;

  @JsonProperty("IAMRoleName")
  private String iaMRoleName = null;

  @JsonProperty("Status")
  private String status = null;

  public CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDomainMembership domain(String domain) {
    this.domain = domain;
    return this;
  }

   /**
   * identifier of the Active Directory Domain.
   * @return domain
  **/
  @ApiModelProperty(example = "", value = "identifier of the Active Directory Domain.")
  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDomainMembership FQDN(String FQDN) {
    this.FQDN = FQDN;
    return this;
  }

   /**
   * 
   * @return FQDN
  **/
  @ApiModelProperty(example = "", value = "")
  public String getFQDN() {
    return FQDN;
  }

  public void setFQDN(String FQDN) {
    this.FQDN = FQDN;
  }

  public CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDomainMembership iaMRoleName(String iaMRoleName) {
    this.iaMRoleName = iaMRoleName;
    return this;
  }

   /**
   * 
   * @return iaMRoleName
  **/
  @ApiModelProperty(example = "", value = "")
  public String getIaMRoleName() {
    return iaMRoleName;
  }

  public void setIaMRoleName(String iaMRoleName) {
    this.iaMRoleName = iaMRoleName;
  }

  public CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDomainMembership status(String status) {
    this.status = status;
    return this;
  }

   /**
   * status of the DB instance Active Directory Domain membership
   * @return status
  **/
  @ApiModelProperty(example = "", value = "status of the DB instance Active Directory Domain membership")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDomainMembership createDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDomainMembership = (CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDomainMembership) o;
    return Objects.equals(this.domain, createDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDomainMembership.domain) &&
        Objects.equals(this.FQDN, createDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDomainMembership.FQDN) &&
        Objects.equals(this.iaMRoleName, createDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDomainMembership.iaMRoleName) &&
        Objects.equals(this.status, createDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDomainMembership.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(domain, FQDN, iaMRoleName, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDomainMembership {\n");
    
    sb.append("    domain: ").append(toIndentedString(domain)).append("\n");
    sb.append("    FQDN: ").append(toIndentedString(FQDN)).append("\n");
    sb.append("    iaMRoleName: ").append(toIndentedString(iaMRoleName)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

