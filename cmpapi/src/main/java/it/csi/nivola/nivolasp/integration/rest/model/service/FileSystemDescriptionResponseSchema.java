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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * FileSystemDescriptionResponseSchema
 */

public class FileSystemDescriptionResponseSchema {
  @JsonProperty("CreationTime")
  private LocalDateTime creationTime = null;

  @JsonProperty("CreationToken")
  private String creationToken = null;

  @JsonProperty("Encrypted")
  private Boolean encrypted = false;

  @JsonProperty("FileSystemId")
  private String fileSystemId = null;

  @JsonProperty("KmsKeyId")
  private String kmsKeyId = null;

  /**
   * LifeCycle state of FileSystem
   */
  public enum LifeCycleStateEnum {
    CREATING("creating"),
    
    AVAILABLE("available"),
    
    DELETING("deleting"),
    
    DELETED("deleted"),
    
    UNKNOWN("unknown"),
    
    ERROR("error");

    private String value;

    LifeCycleStateEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static LifeCycleStateEnum fromValue(String value) {
      for (LifeCycleStateEnum b : LifeCycleStateEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("LifeCycleState")
  private LifeCycleStateEnum lifeCycleState = null;

  @JsonProperty("Name")
  private String name = null;

  @JsonProperty("NumberOfMountTargets")
  private Integer numberOfMountTargets = null;

  @JsonProperty("OwnerId")
  private String ownerId = null;

  /**
   * 
   */
  public enum PerformanceModeEnum {
    GENERALPURPOSE("generalPurpose"),
    
    LOCALPURPOSE("localPurpose");

    private String value;

    PerformanceModeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PerformanceModeEnum fromValue(String value) {
      for (PerformanceModeEnum b : PerformanceModeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("PerformanceMode")
  private PerformanceModeEnum performanceMode = PerformanceModeEnum.GENERALPURPOSE;

  @JsonProperty("ProvisionedThroughputInMibps")
  private Integer provisionedThroughputInMibps = null;

  @JsonProperty("SizeInBytes")
  private DescribeFileSystemsResponseSchemaSizeInBytes sizeInBytes = null;

  /**
   * The throughput mode for a file system. There are two throughput modes to choose from for your file system: bursting and provisioned.
   */
  public enum ThroughputModeEnum {
    BURSTING("bursting"),
    
    PROVISIONED("provisioned");

    private String value;

    ThroughputModeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ThroughputModeEnum fromValue(String value) {
      for (ThroughputModeEnum b : ThroughputModeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("ThroughputMode")
  private ThroughputModeEnum throughputMode = null;

  @JsonProperty("nvl-Capabilities")
  private List<String> nvlCapabilities = null;

  @JsonProperty("nvl-OwnerAlias")
  private String nvlOwnerAlias = null;

  public FileSystemDescriptionResponseSchema creationTime(LocalDateTime creationTime) {
    this.creationTime = creationTime;
    return this;
  }

   /**
   * creation time file system storage
   * @return creationTime
  **/
  @ApiModelProperty(example = "1970-01-01T00:00:00Z", required = true, value = "creation time file system storage")
  public LocalDateTime getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(LocalDateTime creationTime) {
    this.creationTime = creationTime;
  }

  public FileSystemDescriptionResponseSchema creationToken(String creationToken) {
    this.creationToken = creationToken;
    return this;
  }

   /**
   * file system storage name
   * @return creationToken
  **/
  @ApiModelProperty(example = "", required = true, value = "file system storage name")
  public String getCreationToken() {
    return creationToken;
  }

  public void setCreationToken(String creationToken) {
    this.creationToken = creationToken;
  }

  public FileSystemDescriptionResponseSchema encrypted(Boolean encrypted) {
    this.encrypted = encrypted;
    return this;
  }

   /**
   * boolean value that indicate if the storage file system is encrypted
   * @return encrypted
  **/
  @ApiModelProperty(value = "boolean value that indicate if the storage file system is encrypted")
  public Boolean isEncrypted() {
    return encrypted;
  }

  public void setEncrypted(Boolean encrypted) {
    this.encrypted = encrypted;
  }

  public FileSystemDescriptionResponseSchema fileSystemId(String fileSystemId) {
    this.fileSystemId = fileSystemId;
    return this;
  }

   /**
   * ID of the storage file system
   * @return fileSystemId
  **/
  @ApiModelProperty(example = "", required = true, value = "ID of the storage file system")
  public String getFileSystemId() {
    return fileSystemId;
  }

  public void setFileSystemId(String fileSystemId) {
    this.fileSystemId = fileSystemId;
  }

  public FileSystemDescriptionResponseSchema kmsKeyId(String kmsKeyId) {
    this.kmsKeyId = kmsKeyId;
    return this;
  }

   /**
   * ID of a Key Management Service
   * @return kmsKeyId
  **/
  @ApiModelProperty(example = "", value = "ID of a Key Management Service")
  public String getKmsKeyId() {
    return kmsKeyId;
  }

  public void setKmsKeyId(String kmsKeyId) {
    this.kmsKeyId = kmsKeyId;
  }

  public FileSystemDescriptionResponseSchema lifeCycleState(LifeCycleStateEnum lifeCycleState) {
    this.lifeCycleState = lifeCycleState;
    return this;
  }

   /**
   * LifeCycle state of FileSystem
   * @return lifeCycleState
  **/
  @ApiModelProperty(example = "creating | available | deleting | deleted | unknown | error", required = true, value = "LifeCycle state of FileSystem")
  public LifeCycleStateEnum getLifeCycleState() {
    return lifeCycleState;
  }

  public void setLifeCycleState(LifeCycleStateEnum lifeCycleState) {
    this.lifeCycleState = lifeCycleState;
  }

  public FileSystemDescriptionResponseSchema name(String name) {
    this.name = name;
    return this;
  }

   /**
   * resource tag name
   * @return name
  **/
  @ApiModelProperty(example = "", value = "resource tag name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FileSystemDescriptionResponseSchema numberOfMountTargets(Integer numberOfMountTargets) {
    this.numberOfMountTargets = numberOfMountTargets;
    return this;
  }

   /**
   * current number of mount targets that the file system has
   * minimum: 0
   * @return numberOfMountTargets
  **/
  @ApiModelProperty(example = "", value = "current number of mount targets that the file system has")
  public Integer getNumberOfMountTargets() {
    return numberOfMountTargets;
  }

  public void setNumberOfMountTargets(Integer numberOfMountTargets) {
    this.numberOfMountTargets = numberOfMountTargets;
  }

  public FileSystemDescriptionResponseSchema ownerId(String ownerId) {
    this.ownerId = ownerId;
    return this;
  }

   /**
   * account id that created the file system
   * @return ownerId
  **/
  @ApiModelProperty(example = "", required = true, value = "account id that created the file system")
  public String getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(String ownerId) {
    this.ownerId = ownerId;
  }

  public FileSystemDescriptionResponseSchema performanceMode(PerformanceModeEnum performanceMode) {
    this.performanceMode = performanceMode;
    return this;
  }

   /**
   * 
   * @return performanceMode
  **/
  @ApiModelProperty(example = "", value = "")
  public PerformanceModeEnum getPerformanceMode() {
    return performanceMode;
  }

  public void setPerformanceMode(PerformanceModeEnum performanceMode) {
    this.performanceMode = performanceMode;
  }

  public FileSystemDescriptionResponseSchema provisionedThroughputInMibps(Integer provisionedThroughputInMibps) {
    this.provisionedThroughputInMibps = provisionedThroughputInMibps;
    return this;
  }

   /**
   * The throughput, measured in MiB/s, that you want to provision for a file system.
   * @return provisionedThroughputInMibps
  **/
  @ApiModelProperty(example = "", value = "The throughput, measured in MiB/s, that you want to provision for a file system.")
  public Integer getProvisionedThroughputInMibps() {
    return provisionedThroughputInMibps;
  }

  public void setProvisionedThroughputInMibps(Integer provisionedThroughputInMibps) {
    this.provisionedThroughputInMibps = provisionedThroughputInMibps;
  }

  public FileSystemDescriptionResponseSchema sizeInBytes(DescribeFileSystemsResponseSchemaSizeInBytes sizeInBytes) {
    this.sizeInBytes = sizeInBytes;
    return this;
  }

   /**
   * Get sizeInBytes
   * @return sizeInBytes
  **/
  @ApiModelProperty(required = true, value = "")
  public DescribeFileSystemsResponseSchemaSizeInBytes getSizeInBytes() {
    return sizeInBytes;
  }

  public void setSizeInBytes(DescribeFileSystemsResponseSchemaSizeInBytes sizeInBytes) {
    this.sizeInBytes = sizeInBytes;
  }

  public FileSystemDescriptionResponseSchema throughputMode(ThroughputModeEnum throughputMode) {
    this.throughputMode = throughputMode;
    return this;
  }

   /**
   * The throughput mode for a file system. There are two throughput modes to choose from for your file system: bursting and provisioned.
   * @return throughputMode
  **/
  @ApiModelProperty(example = "", value = "The throughput mode for a file system. There are two throughput modes to choose from for your file system: bursting and provisioned.")
  public ThroughputModeEnum getThroughputMode() {
    return throughputMode;
  }

  public void setThroughputMode(ThroughputModeEnum throughputMode) {
    this.throughputMode = throughputMode;
  }

  public FileSystemDescriptionResponseSchema nvlCapabilities(List<String> nvlCapabilities) {
    this.nvlCapabilities = nvlCapabilities;
    return this;
  }

  public FileSystemDescriptionResponseSchema addNvlCapabilitiesItem(String nvlCapabilitiesItem) {
    if (this.nvlCapabilities == null) {
      this.nvlCapabilities = new ArrayList<>();
    }
    this.nvlCapabilities.add(nvlCapabilitiesItem);
    return this;
  }

   /**
   * list of file system available capabilities
   * @return nvlCapabilities
  **/
  @ApiModelProperty(example = "[\"grant\"]", value = "list of file system available capabilities")
  public List<String> getNvlCapabilities() {
    return nvlCapabilities;
  }

  public void setNvlCapabilities(List<String> nvlCapabilities) {
    this.nvlCapabilities = nvlCapabilities;
  }

  public FileSystemDescriptionResponseSchema nvlOwnerAlias(String nvlOwnerAlias) {
    this.nvlOwnerAlias = nvlOwnerAlias;
    return this;
  }

   /**
   * account name that created the file system
   * @return nvlOwnerAlias
  **/
  @ApiModelProperty(example = "", required = true, value = "account name that created the file system")
  public String getNvlOwnerAlias() {
    return nvlOwnerAlias;
  }

  public void setNvlOwnerAlias(String nvlOwnerAlias) {
    this.nvlOwnerAlias = nvlOwnerAlias;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FileSystemDescriptionResponseSchema fileSystemDescriptionResponseSchema = (FileSystemDescriptionResponseSchema) o;
    return Objects.equals(this.creationTime, fileSystemDescriptionResponseSchema.creationTime) &&
        Objects.equals(this.creationToken, fileSystemDescriptionResponseSchema.creationToken) &&
        Objects.equals(this.encrypted, fileSystemDescriptionResponseSchema.encrypted) &&
        Objects.equals(this.fileSystemId, fileSystemDescriptionResponseSchema.fileSystemId) &&
        Objects.equals(this.kmsKeyId, fileSystemDescriptionResponseSchema.kmsKeyId) &&
        Objects.equals(this.lifeCycleState, fileSystemDescriptionResponseSchema.lifeCycleState) &&
        Objects.equals(this.name, fileSystemDescriptionResponseSchema.name) &&
        Objects.equals(this.numberOfMountTargets, fileSystemDescriptionResponseSchema.numberOfMountTargets) &&
        Objects.equals(this.ownerId, fileSystemDescriptionResponseSchema.ownerId) &&
        Objects.equals(this.performanceMode, fileSystemDescriptionResponseSchema.performanceMode) &&
        Objects.equals(this.provisionedThroughputInMibps, fileSystemDescriptionResponseSchema.provisionedThroughputInMibps) &&
        Objects.equals(this.sizeInBytes, fileSystemDescriptionResponseSchema.sizeInBytes) &&
        Objects.equals(this.throughputMode, fileSystemDescriptionResponseSchema.throughputMode) &&
        Objects.equals(this.nvlCapabilities, fileSystemDescriptionResponseSchema.nvlCapabilities) &&
        Objects.equals(this.nvlOwnerAlias, fileSystemDescriptionResponseSchema.nvlOwnerAlias);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creationTime, creationToken, encrypted, fileSystemId, kmsKeyId, lifeCycleState, name, numberOfMountTargets, ownerId, performanceMode, provisionedThroughputInMibps, sizeInBytes, throughputMode, nvlCapabilities, nvlOwnerAlias);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FileSystemDescriptionResponseSchema {\n");
    
    sb.append("    creationTime: ").append(toIndentedString(creationTime)).append("\n");
    sb.append("    creationToken: ").append(toIndentedString(creationToken)).append("\n");
    sb.append("    encrypted: ").append(toIndentedString(encrypted)).append("\n");
    sb.append("    fileSystemId: ").append(toIndentedString(fileSystemId)).append("\n");
    sb.append("    kmsKeyId: ").append(toIndentedString(kmsKeyId)).append("\n");
    sb.append("    lifeCycleState: ").append(toIndentedString(lifeCycleState)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    numberOfMountTargets: ").append(toIndentedString(numberOfMountTargets)).append("\n");
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
    sb.append("    performanceMode: ").append(toIndentedString(performanceMode)).append("\n");
    sb.append("    provisionedThroughputInMibps: ").append(toIndentedString(provisionedThroughputInMibps)).append("\n");
    sb.append("    sizeInBytes: ").append(toIndentedString(sizeInBytes)).append("\n");
    sb.append("    throughputMode: ").append(toIndentedString(throughputMode)).append("\n");
    sb.append("    nvlCapabilities: ").append(toIndentedString(nvlCapabilities)).append("\n");
    sb.append("    nvlOwnerAlias: ").append(toIndentedString(nvlOwnerAlias)).append("\n");
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

