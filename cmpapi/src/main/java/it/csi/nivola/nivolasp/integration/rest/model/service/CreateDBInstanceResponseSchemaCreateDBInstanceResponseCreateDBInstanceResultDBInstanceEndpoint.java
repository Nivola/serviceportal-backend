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
 * CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceEndpoint
 */

public class CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceEndpoint {
  @JsonProperty("Address")
  private String address = null;

  @JsonProperty("Port")
  private Integer port = null;

  public CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceEndpoint address(String address) {
    this.address = address;
    return this;
  }

   /**
   * the DNS address of the DB instance
   * @return address
  **/
  @ApiModelProperty(example = "", value = "the DNS address of the DB instance")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceEndpoint port(Integer port) {
    this.port = port;
    return this;
  }

   /**
   * the port that the database engine is listening on
   * @return port
  **/
  @ApiModelProperty(example = "", value = "the port that the database engine is listening on")
  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceEndpoint createDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceEndpoint = (CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceEndpoint) o;
    return Objects.equals(this.address, createDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceEndpoint.address) &&
        Objects.equals(this.port, createDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceEndpoint.port);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, port);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceEndpoint {\n");
    
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
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
