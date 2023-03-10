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
 * CreateVolumeApiResponseSchemaCreateVolumeResponse
 */

public class CreateVolumeApiResponseSchemaCreateVolumeResponse {
  @JsonProperty("availabilityZone")
  private String availabilityZone = null;

  @JsonProperty("createTime")
  private String createTime = null;

  @JsonProperty("encrypted")
  private String encrypted = null;

  @JsonProperty("iops")
  private String iops = null;

  @JsonProperty("multiAttachEnabled")
  private String multiAttachEnabled = null;

  @JsonProperty("requestId")
  private String requestId = null;

  @JsonProperty("size")
  private String size = null;

  @JsonProperty("snapshotId")
  private String snapshotId = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("volumeId")
  private String volumeId = null;

  @JsonProperty("volumeType")
  private String volumeType = null;

  public CreateVolumeApiResponseSchemaCreateVolumeResponse availabilityZone(String availabilityZone) {
    this.availabilityZone = availabilityZone;
    return this;
  }

   /**
   * volume availability zone
   * @return availabilityZone
  **/
  @ApiModelProperty(required = true, value = "volume availability zone")
  public String getAvailabilityZone() {
    return availabilityZone;
  }

  public void setAvailabilityZone(String availabilityZone) {
    this.availabilityZone = availabilityZone;
  }

  public CreateVolumeApiResponseSchemaCreateVolumeResponse createTime(String createTime) {
    this.createTime = createTime;
    return this;
  }

   /**
   * volume creation time
   * @return createTime
  **/
  @ApiModelProperty(required = true, value = "volume creation time")
  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public CreateVolumeApiResponseSchemaCreateVolumeResponse encrypted(String encrypted) {
    this.encrypted = encrypted;
    return this;
  }

   /**
   * volume is encrypted
   * @return encrypted
  **/
  @ApiModelProperty(required = true, value = "volume is encrypted")
  public String getEncrypted() {
    return encrypted;
  }

  public void setEncrypted(String encrypted) {
    this.encrypted = encrypted;
  }

  public CreateVolumeApiResponseSchemaCreateVolumeResponse iops(String iops) {
    this.iops = iops;
    return this;
  }

   /**
   * volume iops
   * @return iops
  **/
  @ApiModelProperty(required = true, value = "volume iops")
  public String getIops() {
    return iops;
  }

  public void setIops(String iops) {
    this.iops = iops;
  }

  public CreateVolumeApiResponseSchemaCreateVolumeResponse multiAttachEnabled(String multiAttachEnabled) {
    this.multiAttachEnabled = multiAttachEnabled;
    return this;
  }

   /**
   * volume is multi attach
   * @return multiAttachEnabled
  **/
  @ApiModelProperty(required = true, value = "volume is multi attach")
  public String getMultiAttachEnabled() {
    return multiAttachEnabled;
  }

  public void setMultiAttachEnabled(String multiAttachEnabled) {
    this.multiAttachEnabled = multiAttachEnabled;
  }

  public CreateVolumeApiResponseSchemaCreateVolumeResponse requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

   /**
   * api request id
   * @return requestId
  **/
  @ApiModelProperty(required = true, value = "api request id")
  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public CreateVolumeApiResponseSchemaCreateVolumeResponse size(String size) {
    this.size = size;
    return this;
  }

   /**
   * volume size
   * @return size
  **/
  @ApiModelProperty(required = true, value = "volume size")
  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public CreateVolumeApiResponseSchemaCreateVolumeResponse snapshotId(String snapshotId) {
    this.snapshotId = snapshotId;
    return this;
  }

   /**
   * volume snapshot id
   * @return snapshotId
  **/
  @ApiModelProperty(value = "volume snapshot id")
  public String getSnapshotId() {
    return snapshotId;
  }

  public void setSnapshotId(String snapshotId) {
    this.snapshotId = snapshotId;
  }

  public CreateVolumeApiResponseSchemaCreateVolumeResponse status(String status) {
    this.status = status;
    return this;
  }

   /**
   * volume status
   * @return status
  **/
  @ApiModelProperty(required = true, value = "volume status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public CreateVolumeApiResponseSchemaCreateVolumeResponse volumeId(String volumeId) {
    this.volumeId = volumeId;
    return this;
  }

   /**
   * volume id
   * @return volumeId
  **/
  @ApiModelProperty(required = true, value = "volume id")
  public String getVolumeId() {
    return volumeId;
  }

  public void setVolumeId(String volumeId) {
    this.volumeId = volumeId;
  }

  public CreateVolumeApiResponseSchemaCreateVolumeResponse volumeType(String volumeType) {
    this.volumeType = volumeType;
    return this;
  }

   /**
   * volume type
   * @return volumeType
  **/
  @ApiModelProperty(required = true, value = "volume type")
  public String getVolumeType() {
    return volumeType;
  }

  public void setVolumeType(String volumeType) {
    this.volumeType = volumeType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateVolumeApiResponseSchemaCreateVolumeResponse createVolumeApiResponseSchemaCreateVolumeResponse = (CreateVolumeApiResponseSchemaCreateVolumeResponse) o;
    return Objects.equals(this.availabilityZone, createVolumeApiResponseSchemaCreateVolumeResponse.availabilityZone) &&
        Objects.equals(this.createTime, createVolumeApiResponseSchemaCreateVolumeResponse.createTime) &&
        Objects.equals(this.encrypted, createVolumeApiResponseSchemaCreateVolumeResponse.encrypted) &&
        Objects.equals(this.iops, createVolumeApiResponseSchemaCreateVolumeResponse.iops) &&
        Objects.equals(this.multiAttachEnabled, createVolumeApiResponseSchemaCreateVolumeResponse.multiAttachEnabled) &&
        Objects.equals(this.requestId, createVolumeApiResponseSchemaCreateVolumeResponse.requestId) &&
        Objects.equals(this.size, createVolumeApiResponseSchemaCreateVolumeResponse.size) &&
        Objects.equals(this.snapshotId, createVolumeApiResponseSchemaCreateVolumeResponse.snapshotId) &&
        Objects.equals(this.status, createVolumeApiResponseSchemaCreateVolumeResponse.status) &&
        Objects.equals(this.volumeId, createVolumeApiResponseSchemaCreateVolumeResponse.volumeId) &&
        Objects.equals(this.volumeType, createVolumeApiResponseSchemaCreateVolumeResponse.volumeType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(availabilityZone, createTime, encrypted, iops, multiAttachEnabled, requestId, size, snapshotId, status, volumeId, volumeType);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateVolumeApiResponseSchemaCreateVolumeResponse {\n");
    
    sb.append("    availabilityZone: ").append(toIndentedString(availabilityZone)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    encrypted: ").append(toIndentedString(encrypted)).append("\n");
    sb.append("    iops: ").append(toIndentedString(iops)).append("\n");
    sb.append("    multiAttachEnabled: ").append(toIndentedString(multiAttachEnabled)).append("\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    snapshotId: ").append(toIndentedString(snapshotId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    volumeId: ").append(toIndentedString(volumeId)).append("\n");
    sb.append("    volumeType: ").append(toIndentedString(volumeType)).append("\n");
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

