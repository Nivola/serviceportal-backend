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
 * AttachVolumeApiRequestSchema
 */

public class AttachVolumeApiRequestSchema {
  @JsonProperty("Device")
  private String device = null;

  @JsonProperty("InstanceId")
  private String instanceId = null;

  @JsonProperty("VolumeId")
  private String volumeId = null;

  public AttachVolumeApiRequestSchema device(String device) {
    this.device = device;
    return this;
  }

   /**
   * The device name
   * @return device
  **/
  @ApiModelProperty(example = "/dev/sdh", required = true, value = "The device name")
  public String getDevice() {
    return device;
  }

  public void setDevice(String device) {
    this.device = device;
  }

  public AttachVolumeApiRequestSchema instanceId(String instanceId) {
    this.instanceId = instanceId;
    return this;
  }

   /**
   * The ID of the instance
   * @return instanceId
  **/
  @ApiModelProperty(example = "123", required = true, value = "The ID of the instance")
  public String getInstanceId() {
    return instanceId;
  }

  public void setInstanceId(String instanceId) {
    this.instanceId = instanceId;
  }

  public AttachVolumeApiRequestSchema volumeId(String volumeId) {
    this.volumeId = volumeId;
    return this;
  }

   /**
   * The ID of the volume. The volume and instance must be within the same Availability Zone.
   * @return volumeId
  **/
  @ApiModelProperty(example = "123", required = true, value = "The ID of the volume. The volume and instance must be within the same Availability Zone.")
  public String getVolumeId() {
    return volumeId;
  }

  public void setVolumeId(String volumeId) {
    this.volumeId = volumeId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AttachVolumeApiRequestSchema attachVolumeApiRequestSchema = (AttachVolumeApiRequestSchema) o;
    return Objects.equals(this.device, attachVolumeApiRequestSchema.device) &&
        Objects.equals(this.instanceId, attachVolumeApiRequestSchema.instanceId) &&
        Objects.equals(this.volumeId, attachVolumeApiRequestSchema.volumeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(device, instanceId, volumeId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttachVolumeApiRequestSchema {\n");
    
    sb.append("    device: ").append(toIndentedString(device)).append("\n");
    sb.append("    instanceId: ").append(toIndentedString(instanceId)).append("\n");
    sb.append("    volumeId: ").append(toIndentedString(volumeId)).append("\n");
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

