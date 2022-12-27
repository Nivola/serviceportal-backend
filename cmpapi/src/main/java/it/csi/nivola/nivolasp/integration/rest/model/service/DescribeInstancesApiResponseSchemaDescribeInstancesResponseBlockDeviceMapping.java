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
 * DescribeInstancesApiResponseSchemaDescribeInstancesResponseBlockDeviceMapping
 */

public class DescribeInstancesApiResponseSchemaDescribeInstancesResponseBlockDeviceMapping {
  @JsonProperty("deviceName")
  private String deviceName = null;

  @JsonProperty("ebs")
  private DescribeInstancesApiResponseSchemaDescribeInstancesResponseEbs ebs = null;

  public DescribeInstancesApiResponseSchemaDescribeInstancesResponseBlockDeviceMapping deviceName(String deviceName) {
    this.deviceName = deviceName;
    return this;
  }

   /**
   * device name
   * @return deviceName
  **/
  @ApiModelProperty(example = "", value = "device name")
  public String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public DescribeInstancesApiResponseSchemaDescribeInstancesResponseBlockDeviceMapping ebs(DescribeInstancesApiResponseSchemaDescribeInstancesResponseEbs ebs) {
    this.ebs = ebs;
    return this;
  }

   /**
   * Get ebs
   * @return ebs
  **/
  @ApiModelProperty(value = "")
  public DescribeInstancesApiResponseSchemaDescribeInstancesResponseEbs getEbs() {
    return ebs;
  }

  public void setEbs(DescribeInstancesApiResponseSchemaDescribeInstancesResponseEbs ebs) {
    this.ebs = ebs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeInstancesApiResponseSchemaDescribeInstancesResponseBlockDeviceMapping describeInstancesApiResponseSchemaDescribeInstancesResponseBlockDeviceMapping = (DescribeInstancesApiResponseSchemaDescribeInstancesResponseBlockDeviceMapping) o;
    return Objects.equals(this.deviceName, describeInstancesApiResponseSchemaDescribeInstancesResponseBlockDeviceMapping.deviceName) &&
        Objects.equals(this.ebs, describeInstancesApiResponseSchemaDescribeInstancesResponseBlockDeviceMapping.ebs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deviceName, ebs);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeInstancesApiResponseSchemaDescribeInstancesResponseBlockDeviceMapping {\n");
    
    sb.append("    deviceName: ").append(toIndentedString(deviceName)).append("\n");
    sb.append("    ebs: ").append(toIndentedString(ebs)).append("\n");
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

