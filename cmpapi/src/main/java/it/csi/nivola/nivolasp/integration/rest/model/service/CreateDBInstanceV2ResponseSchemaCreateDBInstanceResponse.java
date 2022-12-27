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
 * CreateDBInstanceV2ResponseSchemaCreateDBInstanceResponse
 */

public class CreateDBInstanceV2ResponseSchemaCreateDBInstanceResponse {
  @JsonProperty("CreateDBInstanceResult")
  private CreateDBInstanceV2ResponseSchemaCreateDBInstanceResponseCreateDBInstanceResult createDBInstanceResult = null;

  @JsonProperty("__xmlns")
  private String xmlns = null;

  public CreateDBInstanceV2ResponseSchemaCreateDBInstanceResponse createDBInstanceResult(CreateDBInstanceV2ResponseSchemaCreateDBInstanceResponseCreateDBInstanceResult createDBInstanceResult) {
    this.createDBInstanceResult = createDBInstanceResult;
    return this;
  }

   /**
   * Get createDBInstanceResult
   * @return createDBInstanceResult
  **/
  @ApiModelProperty(required = true, value = "")
  public CreateDBInstanceV2ResponseSchemaCreateDBInstanceResponseCreateDBInstanceResult getCreateDBInstanceResult() {
    return createDBInstanceResult;
  }

  public void setCreateDBInstanceResult(CreateDBInstanceV2ResponseSchemaCreateDBInstanceResponseCreateDBInstanceResult createDBInstanceResult) {
    this.createDBInstanceResult = createDBInstanceResult;
  }

  public CreateDBInstanceV2ResponseSchemaCreateDBInstanceResponse xmlns(String xmlns) {
    this.xmlns = xmlns;
    return this;
  }

   /**
   * Get xmlns
   * @return xmlns
  **/
  @ApiModelProperty(value = "")
  public String getXmlns() {
    return xmlns;
  }

  public void setXmlns(String xmlns) {
    this.xmlns = xmlns;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateDBInstanceV2ResponseSchemaCreateDBInstanceResponse createDBInstanceV2ResponseSchemaCreateDBInstanceResponse = (CreateDBInstanceV2ResponseSchemaCreateDBInstanceResponse) o;
    return Objects.equals(this.createDBInstanceResult, createDBInstanceV2ResponseSchemaCreateDBInstanceResponse.createDBInstanceResult) &&
        Objects.equals(this.xmlns, createDBInstanceV2ResponseSchemaCreateDBInstanceResponse.xmlns);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createDBInstanceResult, xmlns);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateDBInstanceV2ResponseSchemaCreateDBInstanceResponse {\n");
    
    sb.append("    createDBInstanceResult: ").append(toIndentedString(createDBInstanceResult)).append("\n");
    sb.append("    xmlns: ").append(toIndentedString(xmlns)).append("\n");
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

