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
 * CreateDBInstanceSchemaApiV2ResponseSchemaCreateDBInstanceSchemaResponse
 */

public class CreateDBInstanceSchemaApiV2ResponseSchemaCreateDBInstanceSchemaResponse {
  @JsonProperty("CreateDBInstanceSchemaResult")
  private CreateDBInstanceSchemaApiV2ResponseSchemaCreateDBInstanceSchemaResponseCreateDBInstanceSchemaResult createDBInstanceSchemaResult = null;

  @JsonProperty("ResponseMetadata")
  private ChangeDBInstanceUserPasswordApiV2ResponseSchemaChangeDBInstanceUserPasswordResponseResponseMetadata responseMetadata = null;

  @JsonProperty("__xmlns")
  private String xmlns = null;

  public CreateDBInstanceSchemaApiV2ResponseSchemaCreateDBInstanceSchemaResponse createDBInstanceSchemaResult(CreateDBInstanceSchemaApiV2ResponseSchemaCreateDBInstanceSchemaResponseCreateDBInstanceSchemaResult createDBInstanceSchemaResult) {
    this.createDBInstanceSchemaResult = createDBInstanceSchemaResult;
    return this;
  }

   /**
   * Get createDBInstanceSchemaResult
   * @return createDBInstanceSchemaResult
  **/
  @ApiModelProperty(value = "")
  public CreateDBInstanceSchemaApiV2ResponseSchemaCreateDBInstanceSchemaResponseCreateDBInstanceSchemaResult getCreateDBInstanceSchemaResult() {
    return createDBInstanceSchemaResult;
  }

  public void setCreateDBInstanceSchemaResult(CreateDBInstanceSchemaApiV2ResponseSchemaCreateDBInstanceSchemaResponseCreateDBInstanceSchemaResult createDBInstanceSchemaResult) {
    this.createDBInstanceSchemaResult = createDBInstanceSchemaResult;
  }

  public CreateDBInstanceSchemaApiV2ResponseSchemaCreateDBInstanceSchemaResponse responseMetadata(ChangeDBInstanceUserPasswordApiV2ResponseSchemaChangeDBInstanceUserPasswordResponseResponseMetadata responseMetadata) {
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

  public CreateDBInstanceSchemaApiV2ResponseSchemaCreateDBInstanceSchemaResponse xmlns(String xmlns) {
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
    CreateDBInstanceSchemaApiV2ResponseSchemaCreateDBInstanceSchemaResponse createDBInstanceSchemaApiV2ResponseSchemaCreateDBInstanceSchemaResponse = (CreateDBInstanceSchemaApiV2ResponseSchemaCreateDBInstanceSchemaResponse) o;
    return Objects.equals(this.createDBInstanceSchemaResult, createDBInstanceSchemaApiV2ResponseSchemaCreateDBInstanceSchemaResponse.createDBInstanceSchemaResult) &&
        Objects.equals(this.responseMetadata, createDBInstanceSchemaApiV2ResponseSchemaCreateDBInstanceSchemaResponse.responseMetadata) &&
        Objects.equals(this.xmlns, createDBInstanceSchemaApiV2ResponseSchemaCreateDBInstanceSchemaResponse.xmlns);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createDBInstanceSchemaResult, responseMetadata, xmlns);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateDBInstanceSchemaApiV2ResponseSchemaCreateDBInstanceSchemaResponse {\n");
    
    sb.append("    createDBInstanceSchemaResult: ").append(toIndentedString(createDBInstanceSchemaResult)).append("\n");
    sb.append("    responseMetadata: ").append(toIndentedString(responseMetadata)).append("\n");
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

