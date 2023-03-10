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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * CreateFileSystemApiRequestSchema
 */

public class CreateFileSystemApiRequestSchema {
  @JsonProperty("CreationToken")
  private String creationToken = null;

  @JsonProperty("Nvl_FileSystem_Size")
  private Integer nvlFileSystemSize = null;

  @JsonProperty("Nvl_FileSystem_Type")
  private String nvlFileSystemType = null;

  /**
   * The performance mode of the file system. Can be shared or private
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
  private PerformanceModeEnum performanceMode = null;

  @JsonProperty("owner_id")
  private String ownerId = null;

  public CreateFileSystemApiRequestSchema creationToken(String creationToken) {
    this.creationToken = creationToken;
    return this;
  }

   /**
   * a string used to identify the file system
   * @return creationToken
  **/
  @ApiModelProperty(example = "myFileSystem1", required = true, value = "a string used to identify the file system")
  public String getCreationToken() {
    return creationToken;
  }

  public void setCreationToken(String creationToken) {
    this.creationToken = creationToken;
  }

  public CreateFileSystemApiRequestSchema nvlFileSystemSize(Integer nvlFileSystemSize) {
    this.nvlFileSystemSize = nvlFileSystemSize;
    return this;
  }

   /**
   * size in Giga byte of storage file system to create
   * @return nvlFileSystemSize
  **/
  @ApiModelProperty(example = "10", required = true, value = "size in Giga byte of storage file system to create")
  public Integer getNvlFileSystemSize() {
    return nvlFileSystemSize;
  }

  public void setNvlFileSystemSize(Integer nvlFileSystemSize) {
    this.nvlFileSystemSize = nvlFileSystemSize;
  }

  public CreateFileSystemApiRequestSchema nvlFileSystemType(String nvlFileSystemType) {
    this.nvlFileSystemType = nvlFileSystemType;
    return this;
  }

   /**
   * service definition for storage file system
   * @return nvlFileSystemType
  **/
  @ApiModelProperty(example = "", value = "service definition for storage file system")
  public String getNvlFileSystemType() {
    return nvlFileSystemType;
  }

  public void setNvlFileSystemType(String nvlFileSystemType) {
    this.nvlFileSystemType = nvlFileSystemType;
  }

  public CreateFileSystemApiRequestSchema performanceMode(PerformanceModeEnum performanceMode) {
    this.performanceMode = performanceMode;
    return this;
  }

   /**
   * The performance mode of the file system. Can be shared or private
   * @return performanceMode
  **/
  @ApiModelProperty(example = "shared", value = "The performance mode of the file system. Can be shared or private")
  public PerformanceModeEnum getPerformanceMode() {
    return performanceMode;
  }

  public void setPerformanceMode(PerformanceModeEnum performanceMode) {
    this.performanceMode = performanceMode;
  }

  public CreateFileSystemApiRequestSchema ownerId(String ownerId) {
    this.ownerId = ownerId;
    return this;
  }

   /**
   * account id
   * @return ownerId
  **/
  @ApiModelProperty(example = "", required = true, value = "account id")
  public String getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(String ownerId) {
    this.ownerId = ownerId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateFileSystemApiRequestSchema createFileSystemApiRequestSchema = (CreateFileSystemApiRequestSchema) o;
    return Objects.equals(this.creationToken, createFileSystemApiRequestSchema.creationToken) &&
        Objects.equals(this.nvlFileSystemSize, createFileSystemApiRequestSchema.nvlFileSystemSize) &&
        Objects.equals(this.nvlFileSystemType, createFileSystemApiRequestSchema.nvlFileSystemType) &&
        Objects.equals(this.performanceMode, createFileSystemApiRequestSchema.performanceMode) &&
        Objects.equals(this.ownerId, createFileSystemApiRequestSchema.ownerId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creationToken, nvlFileSystemSize, nvlFileSystemType, performanceMode, ownerId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateFileSystemApiRequestSchema {\n");
    
    sb.append("    creationToken: ").append(toIndentedString(creationToken)).append("\n");
    sb.append("    nvlFileSystemSize: ").append(toIndentedString(nvlFileSystemSize)).append("\n");
    sb.append("    nvlFileSystemType: ").append(toIndentedString(nvlFileSystemType)).append("\n");
    sb.append("    performanceMode: ").append(toIndentedString(performanceMode)).append("\n");
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
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

