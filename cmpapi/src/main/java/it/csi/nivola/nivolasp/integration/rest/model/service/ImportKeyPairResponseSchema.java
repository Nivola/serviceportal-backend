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
 * ImportKeyPairResponseSchema
 */

public class ImportKeyPairResponseSchema {
  @JsonProperty("ImportKeyPairResponse")
  private ImportKeyPairResponseSchemaImportKeyPairResponse importKeyPairResponse = null;

  public ImportKeyPairResponseSchema importKeyPairResponse(ImportKeyPairResponseSchemaImportKeyPairResponse importKeyPairResponse) {
    this.importKeyPairResponse = importKeyPairResponse;
    return this;
  }

   /**
   * Get importKeyPairResponse
   * @return importKeyPairResponse
  **/
  @ApiModelProperty(required = true, value = "")
  public ImportKeyPairResponseSchemaImportKeyPairResponse getImportKeyPairResponse() {
    return importKeyPairResponse;
  }

  public void setImportKeyPairResponse(ImportKeyPairResponseSchemaImportKeyPairResponse importKeyPairResponse) {
    this.importKeyPairResponse = importKeyPairResponse;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImportKeyPairResponseSchema importKeyPairResponseSchema = (ImportKeyPairResponseSchema) o;
    return Objects.equals(this.importKeyPairResponse, importKeyPairResponseSchema.importKeyPairResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(importKeyPairResponse);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImportKeyPairResponseSchema {\n");
    
    sb.append("    importKeyPairResponse: ").append(toIndentedString(importKeyPairResponse)).append("\n");
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

