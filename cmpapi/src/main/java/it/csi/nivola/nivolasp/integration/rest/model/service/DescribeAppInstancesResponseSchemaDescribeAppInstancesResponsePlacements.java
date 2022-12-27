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
 * DescribeAppInstancesResponseSchemaDescribeAppInstancesResponsePlacements
 */

public class DescribeAppInstancesResponseSchemaDescribeAppInstancesResponsePlacements {
  @JsonProperty("availabilityZone")
  private String availabilityZone = null;

  public DescribeAppInstancesResponseSchemaDescribeAppInstancesResponsePlacements availabilityZone(String availabilityZone) {
    this.availabilityZone = availabilityZone;
    return this;
  }

   /**
   * availability zone of the instance id
   * @return availabilityZone
  **/
  @ApiModelProperty(example = "", value = "availability zone of the instance id")
  public String getAvailabilityZone() {
    return availabilityZone;
  }

  public void setAvailabilityZone(String availabilityZone) {
    this.availabilityZone = availabilityZone;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeAppInstancesResponseSchemaDescribeAppInstancesResponsePlacements describeAppInstancesResponseSchemaDescribeAppInstancesResponsePlacements = (DescribeAppInstancesResponseSchemaDescribeAppInstancesResponsePlacements) o;
    return Objects.equals(this.availabilityZone, describeAppInstancesResponseSchemaDescribeAppInstancesResponsePlacements.availabilityZone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(availabilityZone);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeAppInstancesResponseSchemaDescribeAppInstancesResponsePlacements {\n");
    
    sb.append("    availabilityZone: ").append(toIndentedString(availabilityZone)).append("\n");
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

