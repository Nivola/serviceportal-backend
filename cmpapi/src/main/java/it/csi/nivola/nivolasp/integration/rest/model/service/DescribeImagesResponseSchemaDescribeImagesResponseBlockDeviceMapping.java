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
 * DescribeImagesResponseSchemaDescribeImagesResponseBlockDeviceMapping
 */

public class DescribeImagesResponseSchemaDescribeImagesResponseBlockDeviceMapping {
  @JsonProperty("deviceName")
  private String deviceName = null;

  @JsonProperty("ebs")
  private DescribeImagesResponseSchemaDescribeImagesResponseEbs ebs = null;

  @JsonProperty("noDevice")
  private List<String> noDevice = null;

  @JsonProperty("virtualName")
  private List<String> virtualName = null;

  public DescribeImagesResponseSchemaDescribeImagesResponseBlockDeviceMapping deviceName(String deviceName) {
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

  public DescribeImagesResponseSchemaDescribeImagesResponseBlockDeviceMapping ebs(DescribeImagesResponseSchemaDescribeImagesResponseEbs ebs) {
    this.ebs = ebs;
    return this;
  }

   /**
   * Get ebs
   * @return ebs
  **/
  @ApiModelProperty(value = "")
  public DescribeImagesResponseSchemaDescribeImagesResponseEbs getEbs() {
    return ebs;
  }

  public void setEbs(DescribeImagesResponseSchemaDescribeImagesResponseEbs ebs) {
    this.ebs = ebs;
  }

  public DescribeImagesResponseSchemaDescribeImagesResponseBlockDeviceMapping noDevice(List<String> noDevice) {
    this.noDevice = noDevice;
    return this;
  }

  public DescribeImagesResponseSchemaDescribeImagesResponseBlockDeviceMapping addNoDeviceItem(String noDeviceItem) {
    if (this.noDevice == null) {
      this.noDevice = new ArrayList<>();
    }
    this.noDevice.add(noDeviceItem);
    return this;
  }

   /**
   * suppresses the specified device included in the block device mapping of the AMI
   * @return noDevice
  **/
  @ApiModelProperty(value = "suppresses the specified device included in the block device mapping of the AMI")
  public List<String> getNoDevice() {
    return noDevice;
  }

  public void setNoDevice(List<String> noDevice) {
    this.noDevice = noDevice;
  }

  public DescribeImagesResponseSchemaDescribeImagesResponseBlockDeviceMapping virtualName(List<String> virtualName) {
    this.virtualName = virtualName;
    return this;
  }

  public DescribeImagesResponseSchemaDescribeImagesResponseBlockDeviceMapping addVirtualNameItem(String virtualNameItem) {
    if (this.virtualName == null) {
      this.virtualName = new ArrayList<>();
    }
    this.virtualName.add(virtualNameItem);
    return this;
  }

   /**
   * virtual device names
   * @return virtualName
  **/
  @ApiModelProperty(value = "virtual device names")
  public List<String> getVirtualName() {
    return virtualName;
  }

  public void setVirtualName(List<String> virtualName) {
    this.virtualName = virtualName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeImagesResponseSchemaDescribeImagesResponseBlockDeviceMapping describeImagesResponseSchemaDescribeImagesResponseBlockDeviceMapping = (DescribeImagesResponseSchemaDescribeImagesResponseBlockDeviceMapping) o;
    return Objects.equals(this.deviceName, describeImagesResponseSchemaDescribeImagesResponseBlockDeviceMapping.deviceName) &&
        Objects.equals(this.ebs, describeImagesResponseSchemaDescribeImagesResponseBlockDeviceMapping.ebs) &&
        Objects.equals(this.noDevice, describeImagesResponseSchemaDescribeImagesResponseBlockDeviceMapping.noDevice) &&
        Objects.equals(this.virtualName, describeImagesResponseSchemaDescribeImagesResponseBlockDeviceMapping.virtualName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deviceName, ebs, noDevice, virtualName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeImagesResponseSchemaDescribeImagesResponseBlockDeviceMapping {\n");
    
    sb.append("    deviceName: ").append(toIndentedString(deviceName)).append("\n");
    sb.append("    ebs: ").append(toIndentedString(ebs)).append("\n");
    sb.append("    noDevice: ").append(toIndentedString(noDevice)).append("\n");
    sb.append("    virtualName: ").append(toIndentedString(virtualName)).append("\n");
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

