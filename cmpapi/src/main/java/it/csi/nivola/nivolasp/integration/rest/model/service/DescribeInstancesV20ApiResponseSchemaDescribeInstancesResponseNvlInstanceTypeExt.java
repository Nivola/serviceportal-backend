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
 * flavor attributes
 */
@ApiModel(description = "flavor attributes")

public class DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseNvlInstanceTypeExt {
  @JsonProperty("bandwidth")
  private Integer bandwidth = null;

  @JsonProperty("disk")
  private Integer disk = null;

  @JsonProperty("disk_iops")
  private Integer diskIops = null;

  @JsonProperty("memory")
  private Integer memory = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("vcpus")
  private Integer vcpus = null;

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseNvlInstanceTypeExt bandwidth(Integer bandwidth) {
    this.bandwidth = bandwidth;
    return this;
  }

   /**
   * bandwidth
   * @return bandwidth
  **/
  @ApiModelProperty(example = "0", value = "bandwidth")
  public Integer getBandwidth() {
    return bandwidth;
  }

  public void setBandwidth(Integer bandwidth) {
    this.bandwidth = bandwidth;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseNvlInstanceTypeExt disk(Integer disk) {
    this.disk = disk;
    return this;
  }

   /**
   * number of virtual disk
   * @return disk
  **/
  @ApiModelProperty(example = "0", value = "number of virtual disk")
  public Integer getDisk() {
    return disk;
  }

  public void setDisk(Integer disk) {
    this.disk = disk;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseNvlInstanceTypeExt diskIops(Integer diskIops) {
    this.diskIops = diskIops;
    return this;
  }

   /**
   * available disk IOPS
   * @return diskIops
  **/
  @ApiModelProperty(example = "0", value = "available disk IOPS")
  public Integer getDiskIops() {
    return diskIops;
  }

  public void setDiskIops(Integer diskIops) {
    this.diskIops = diskIops;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseNvlInstanceTypeExt memory(Integer memory) {
    this.memory = memory;
    return this;
  }

   /**
   * RAM
   * @return memory
  **/
  @ApiModelProperty(example = "0", value = "RAM")
  public Integer getMemory() {
    return memory;
  }

  public void setMemory(Integer memory) {
    this.memory = memory;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseNvlInstanceTypeExt name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "vm.m4.large", value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseNvlInstanceTypeExt vcpus(Integer vcpus) {
    this.vcpus = vcpus;
    return this;
  }

   /**
   * number of virtual cpu
   * @return vcpus
  **/
  @ApiModelProperty(example = "1", value = "number of virtual cpu")
  public Integer getVcpus() {
    return vcpus;
  }

  public void setVcpus(Integer vcpus) {
    this.vcpus = vcpus;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseNvlInstanceTypeExt describeInstancesV20ApiResponseSchemaDescribeInstancesResponseNvlInstanceTypeExt = (DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseNvlInstanceTypeExt) o;
    return Objects.equals(this.bandwidth, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseNvlInstanceTypeExt.bandwidth) &&
        Objects.equals(this.disk, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseNvlInstanceTypeExt.disk) &&
        Objects.equals(this.diskIops, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseNvlInstanceTypeExt.diskIops) &&
        Objects.equals(this.memory, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseNvlInstanceTypeExt.memory) &&
        Objects.equals(this.name, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseNvlInstanceTypeExt.name) &&
        Objects.equals(this.vcpus, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseNvlInstanceTypeExt.vcpus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bandwidth, disk, diskIops, memory, name, vcpus);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseNvlInstanceTypeExt {\n");
    
    sb.append("    bandwidth: ").append(toIndentedString(bandwidth)).append("\n");
    sb.append("    disk: ").append(toIndentedString(disk)).append("\n");
    sb.append("    diskIops: ").append(toIndentedString(diskIops)).append("\n");
    sb.append("    memory: ").append(toIndentedString(memory)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    vcpus: ").append(toIndentedString(vcpus)).append("\n");
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

