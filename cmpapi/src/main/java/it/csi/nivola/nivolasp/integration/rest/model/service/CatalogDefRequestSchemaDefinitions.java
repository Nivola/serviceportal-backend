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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CatalogDefRequestSchemaDefinitions
 */

public class CatalogDefRequestSchemaDefinitions {
  @JsonProperty("oids")
  private List<String> oids = new ArrayList<>();

  public CatalogDefRequestSchemaDefinitions oids(List<String> oids) {
    this.oids = oids;
    return this;
  }

  public CatalogDefRequestSchemaDefinitions addOidsItem(String oidsItem) {
    this.oids.add(oidsItem);
    return this;
  }

   /**
   * Get oids
   * @return oids
  **/
  @ApiModelProperty(required = true, value = "")
  public List<String> getOids() {
    return oids;
  }

  public void setOids(List<String> oids) {
    this.oids = oids;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CatalogDefRequestSchemaDefinitions catalogDefRequestSchemaDefinitions = (CatalogDefRequestSchemaDefinitions) o;
    return Objects.equals(this.oids, catalogDefRequestSchemaDefinitions.oids);
  }

  @Override
  public int hashCode() {
    return Objects.hash(oids);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CatalogDefRequestSchemaDefinitions {\n");
    
    sb.append("    oids: ").append(toIndentedString(oids)).append("\n");
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
