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
 * CreateDBInstanceSchemaApiV2ResponseSchema
 */

public class CreateDBInstanceSchemaApiV2ResponseSchema {
  @JsonProperty("CreateDBInstanceSchemaResponse")
  private CreateDBInstanceSchemaApiV2ResponseSchemaCreateDBInstanceSchemaResponse createDBInstanceSchemaResponse = null;

  public CreateDBInstanceSchemaApiV2ResponseSchema createDBInstanceSchemaResponse(CreateDBInstanceSchemaApiV2ResponseSchemaCreateDBInstanceSchemaResponse createDBInstanceSchemaResponse) {
    this.createDBInstanceSchemaResponse = createDBInstanceSchemaResponse;
    return this;
  }

   /**
   * Get createDBInstanceSchemaResponse
   * @return createDBInstanceSchemaResponse
  **/
  @ApiModelProperty(required = true, value = "")
  public CreateDBInstanceSchemaApiV2ResponseSchemaCreateDBInstanceSchemaResponse getCreateDBInstanceSchemaResponse() {
    return createDBInstanceSchemaResponse;
  }

  public void setCreateDBInstanceSchemaResponse(CreateDBInstanceSchemaApiV2ResponseSchemaCreateDBInstanceSchemaResponse createDBInstanceSchemaResponse) {
    this.createDBInstanceSchemaResponse = createDBInstanceSchemaResponse;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateDBInstanceSchemaApiV2ResponseSchema createDBInstanceSchemaApiV2ResponseSchema = (CreateDBInstanceSchemaApiV2ResponseSchema) o;
    return Objects.equals(this.createDBInstanceSchemaResponse, createDBInstanceSchemaApiV2ResponseSchema.createDBInstanceSchemaResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createDBInstanceSchemaResponse);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateDBInstanceSchemaApiV2ResponseSchema {\n");
    
    sb.append("    createDBInstanceSchemaResponse: ").append(toIndentedString(createDBInstanceSchemaResponse)).append("\n");
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

