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
 * CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSubnetGroupSubnets
 */

public class CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSubnetGroupSubnets {
  @JsonProperty("SubnetAvailabilityZone")
  private CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSubnetGroupSubnetAvailabilityZone subnetAvailabilityZone = null;

  @JsonProperty("SubnetIdentifier")
  private String subnetIdentifier = null;

  @JsonProperty("SubnetStatus")
  private String subnetStatus = null;

  public CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSubnetGroupSubnets subnetAvailabilityZone(CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSubnetGroupSubnetAvailabilityZone subnetAvailabilityZone) {
    this.subnetAvailabilityZone = subnetAvailabilityZone;
    return this;
  }

   /**
   * Get subnetAvailabilityZone
   * @return subnetAvailabilityZone
  **/
  @ApiModelProperty(value = "")
  public CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSubnetGroupSubnetAvailabilityZone getSubnetAvailabilityZone() {
    return subnetAvailabilityZone;
  }

  public void setSubnetAvailabilityZone(CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSubnetGroupSubnetAvailabilityZone subnetAvailabilityZone) {
    this.subnetAvailabilityZone = subnetAvailabilityZone;
  }

  public CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSubnetGroupSubnets subnetIdentifier(String subnetIdentifier) {
    this.subnetIdentifier = subnetIdentifier;
    return this;
  }

   /**
   * ID of the subnet
   * @return subnetIdentifier
  **/
  @ApiModelProperty(example = "", value = "ID of the subnet")
  public String getSubnetIdentifier() {
    return subnetIdentifier;
  }

  public void setSubnetIdentifier(String subnetIdentifier) {
    this.subnetIdentifier = subnetIdentifier;
  }

  public CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSubnetGroupSubnets subnetStatus(String subnetStatus) {
    this.subnetStatus = subnetStatus;
    return this;
  }

   /**
   * status of the subnet
   * @return subnetStatus
  **/
  @ApiModelProperty(example = "", value = "status of the subnet")
  public String getSubnetStatus() {
    return subnetStatus;
  }

  public void setSubnetStatus(String subnetStatus) {
    this.subnetStatus = subnetStatus;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSubnetGroupSubnets createDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSubnetGroupSubnets = (CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSubnetGroupSubnets) o;
    return Objects.equals(this.subnetAvailabilityZone, createDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSubnetGroupSubnets.subnetAvailabilityZone) &&
        Objects.equals(this.subnetIdentifier, createDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSubnetGroupSubnets.subnetIdentifier) &&
        Objects.equals(this.subnetStatus, createDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSubnetGroupSubnets.subnetStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subnetAvailabilityZone, subnetIdentifier, subnetStatus);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSubnetGroupSubnets {\n");
    
    sb.append("    subnetAvailabilityZone: ").append(toIndentedString(subnetAvailabilityZone)).append("\n");
    sb.append("    subnetIdentifier: ").append(toIndentedString(subnetIdentifier)).append("\n");
    sb.append("    subnetStatus: ").append(toIndentedString(subnetStatus)).append("\n");
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

