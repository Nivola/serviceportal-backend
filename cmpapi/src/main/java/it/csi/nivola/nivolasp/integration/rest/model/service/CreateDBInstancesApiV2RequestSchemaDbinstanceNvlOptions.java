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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Configure database options like postgres postgis
 */
@ApiModel(description = "Configure database options like postgres postgis")

public class CreateDBInstancesApiV2RequestSchemaDbinstanceNvlOptions {
  @JsonProperty("Postgresql.GeoExtension")
  private String postgresqlGeoExtension = "True";

  public CreateDBInstancesApiV2RequestSchemaDbinstanceNvlOptions postgresqlGeoExtension(String postgresqlGeoExtension) {
    this.postgresqlGeoExtension = postgresqlGeoExtension;
    return this;
  }

   /**
   * if True enable installation of postgres extension postgis
   * @return postgresqlGeoExtension
  **/
  @ApiModelProperty(value = "if True enable installation of postgres extension postgis")
  public String getPostgresqlGeoExtension() {
    return postgresqlGeoExtension;
  }

  public void setPostgresqlGeoExtension(String postgresqlGeoExtension) {
    this.postgresqlGeoExtension = postgresqlGeoExtension;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateDBInstancesApiV2RequestSchemaDbinstanceNvlOptions createDBInstancesApiV2RequestSchemaDbinstanceNvlOptions = (CreateDBInstancesApiV2RequestSchemaDbinstanceNvlOptions) o;
    return Objects.equals(this.postgresqlGeoExtension, createDBInstancesApiV2RequestSchemaDbinstanceNvlOptions.postgresqlGeoExtension);
  }

  @Override
  public int hashCode() {
    return Objects.hash(postgresqlGeoExtension);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateDBInstancesApiV2RequestSchemaDbinstanceNvlOptions {\n");
    
    sb.append("    postgresqlGeoExtension: ").append(toIndentedString(postgresqlGeoExtension)).append("\n");
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

