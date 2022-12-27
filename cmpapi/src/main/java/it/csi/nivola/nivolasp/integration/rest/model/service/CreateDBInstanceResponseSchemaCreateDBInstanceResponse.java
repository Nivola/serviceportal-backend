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
 * CreateDBInstanceResponseSchemaCreateDBInstanceResponse
 */

public class CreateDBInstanceResponseSchemaCreateDBInstanceResponse {
  @JsonProperty("CreateDBInstanceResult")
  private CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResult createDBInstanceResult = null;

  public CreateDBInstanceResponseSchemaCreateDBInstanceResponse createDBInstanceResult(CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResult createDBInstanceResult) {
    this.createDBInstanceResult = createDBInstanceResult;
    return this;
  }

   /**
   * Get createDBInstanceResult
   * @return createDBInstanceResult
  **/
  @ApiModelProperty(required = true, value = "")
  public CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResult getCreateDBInstanceResult() {
    return createDBInstanceResult;
  }

  public void setCreateDBInstanceResult(CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResult createDBInstanceResult) {
    this.createDBInstanceResult = createDBInstanceResult;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateDBInstanceResponseSchemaCreateDBInstanceResponse createDBInstanceResponseSchemaCreateDBInstanceResponse = (CreateDBInstanceResponseSchemaCreateDBInstanceResponse) o;
    return Objects.equals(this.createDBInstanceResult, createDBInstanceResponseSchemaCreateDBInstanceResponse.createDBInstanceResult);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createDBInstanceResult);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateDBInstanceResponseSchemaCreateDBInstanceResponse {\n");
    
    sb.append("    createDBInstanceResult: ").append(toIndentedString(createDBInstanceResult)).append("\n");
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
