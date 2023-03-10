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
 * StartDBInstanceApiV2ResponseSchemaStartDBInstanceResponse
 */

public class StartDBInstanceApiV2ResponseSchemaStartDBInstanceResponse {
  @JsonProperty("ResponseMetadata")
  private ChangeDBInstanceUserPasswordApiV2ResponseSchemaChangeDBInstanceUserPasswordResponseResponseMetadata responseMetadata = null;

  @JsonProperty("StartDBInstanceResult")
  private DeleteDBInstancesApiV2ResponseSchemaDeleteDBInstanceResponseDeleteDBInstanceResult startDBInstanceResult = null;

  @JsonProperty("__xmlns")
  private String xmlns = null;

  public StartDBInstanceApiV2ResponseSchemaStartDBInstanceResponse responseMetadata(ChangeDBInstanceUserPasswordApiV2ResponseSchemaChangeDBInstanceUserPasswordResponseResponseMetadata responseMetadata) {
    this.responseMetadata = responseMetadata;
    return this;
  }

   /**
   * Get responseMetadata
   * @return responseMetadata
  **/
  @ApiModelProperty(value = "")
  public ChangeDBInstanceUserPasswordApiV2ResponseSchemaChangeDBInstanceUserPasswordResponseResponseMetadata getResponseMetadata() {
    return responseMetadata;
  }

  public void setResponseMetadata(ChangeDBInstanceUserPasswordApiV2ResponseSchemaChangeDBInstanceUserPasswordResponseResponseMetadata responseMetadata) {
    this.responseMetadata = responseMetadata;
  }

  public StartDBInstanceApiV2ResponseSchemaStartDBInstanceResponse startDBInstanceResult(DeleteDBInstancesApiV2ResponseSchemaDeleteDBInstanceResponseDeleteDBInstanceResult startDBInstanceResult) {
    this.startDBInstanceResult = startDBInstanceResult;
    return this;
  }

   /**
   * Get startDBInstanceResult
   * @return startDBInstanceResult
  **/
  @ApiModelProperty(value = "")
  public DeleteDBInstancesApiV2ResponseSchemaDeleteDBInstanceResponseDeleteDBInstanceResult getStartDBInstanceResult() {
    return startDBInstanceResult;
  }

  public void setStartDBInstanceResult(DeleteDBInstancesApiV2ResponseSchemaDeleteDBInstanceResponseDeleteDBInstanceResult startDBInstanceResult) {
    this.startDBInstanceResult = startDBInstanceResult;
  }

  public StartDBInstanceApiV2ResponseSchemaStartDBInstanceResponse xmlns(String xmlns) {
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
    StartDBInstanceApiV2ResponseSchemaStartDBInstanceResponse startDBInstanceApiV2ResponseSchemaStartDBInstanceResponse = (StartDBInstanceApiV2ResponseSchemaStartDBInstanceResponse) o;
    return Objects.equals(this.responseMetadata, startDBInstanceApiV2ResponseSchemaStartDBInstanceResponse.responseMetadata) &&
        Objects.equals(this.startDBInstanceResult, startDBInstanceApiV2ResponseSchemaStartDBInstanceResponse.startDBInstanceResult) &&
        Objects.equals(this.xmlns, startDBInstanceApiV2ResponseSchemaStartDBInstanceResponse.xmlns);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseMetadata, startDBInstanceResult, xmlns);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartDBInstanceApiV2ResponseSchemaStartDBInstanceResponse {\n");
    
    sb.append("    responseMetadata: ").append(toIndentedString(responseMetadata)).append("\n");
    sb.append("    startDBInstanceResult: ").append(toIndentedString(startDBInstanceResult)).append("\n");
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

