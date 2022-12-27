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
 * API description in Markdown.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: me@csi.it
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package it.csi.nivola.nivolasp.integration.rest.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * CreateFileSystemWithMountTargetRequestSchema
 */

public class CreateFileSystemWithMountTargetRequestSchema {
  @JsonProperty("CreationToken")
  private String creationToken = null;

  @JsonProperty("Nvl_FileSystem_Size")
  private Integer nvlFileSystemSize = null;

  @JsonProperty("Nvl_FileSystem_Type")
  private String nvlFileSystemType = null;

  /**
   * File system share protocol
   */
  public enum NvlShareProtoEnum {
    NFS("nfs"),
    
    CIFS("cifs");

    private String value;

    NvlShareProtoEnum(String value) {
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
    public static NvlShareProtoEnum fromValue(String text) {
      for (NvlShareProtoEnum b : NvlShareProtoEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("Nvl_shareProto")
  private NvlShareProtoEnum nvlShareProto = NvlShareProtoEnum.NFS;

  @JsonProperty("Nvl_tags")
  private List<CreateDBInstancesApiRequestSchemaDbinstanceTag> nvlTags = null;

  @JsonProperty("SubnetId")
  private String subnetId = null;

  @JsonProperty("owner_id")
  private String ownerId = null;

  public CreateFileSystemWithMountTargetRequestSchema creationToken(String creationToken) {
    this.creationToken = creationToken;
    return this;
  }

   /**
   * 
   * @return creationToken
  **/
  @ApiModelProperty(example = "myFileSystem1", required = true, value = "")
  public String getCreationToken() {
    return creationToken;
  }

  public void setCreationToken(String creationToken) {
    this.creationToken = creationToken;
  }

  public CreateFileSystemWithMountTargetRequestSchema nvlFileSystemSize(Integer nvlFileSystemSize) {
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

  public CreateFileSystemWithMountTargetRequestSchema nvlFileSystemType(String nvlFileSystemType) {
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

  public CreateFileSystemWithMountTargetRequestSchema nvlShareProto(NvlShareProtoEnum nvlShareProto) {
    this.nvlShareProto = nvlShareProto;
    return this;
  }

   /**
   * File system share protocol
   * @return nvlShareProto
  **/
  @ApiModelProperty(example = "nfs", value = "File system share protocol")
  public NvlShareProtoEnum getNvlShareProto() {
    return nvlShareProto;
  }

  public void setNvlShareProto(NvlShareProtoEnum nvlShareProto) {
    this.nvlShareProto = nvlShareProto;
  }

  public CreateFileSystemWithMountTargetRequestSchema nvlTags(List<CreateDBInstancesApiRequestSchemaDbinstanceTag> nvlTags) {
    this.nvlTags = nvlTags;
    return this;
  }

  public CreateFileSystemWithMountTargetRequestSchema addNvlTagsItem(CreateDBInstancesApiRequestSchemaDbinstanceTag nvlTagsItem) {
    if (this.nvlTags == null) {
      this.nvlTags = new ArrayList<>();
    }
    this.nvlTags.add(nvlTagsItem);
    return this;
  }

   /**
   * Get nvlTags
   * @return nvlTags
  **/
  @ApiModelProperty(value = "")
  public List<CreateDBInstancesApiRequestSchemaDbinstanceTag> getNvlTags() {
    return nvlTags;
  }

  public void setNvlTags(List<CreateDBInstancesApiRequestSchemaDbinstanceTag> nvlTags) {
    this.nvlTags = nvlTags;
  }

  public CreateFileSystemWithMountTargetRequestSchema subnetId(String subnetId) {
    this.subnetId = subnetId;
    return this;
  }

   /**
   * ID of the subnet to add the mount target in
   * @return subnetId
  **/
  @ApiModelProperty(example = "subnet-748c5d03", required = true, value = "ID of the subnet to add the mount target in")
  public String getSubnetId() {
    return subnetId;
  }

  public void setSubnetId(String subnetId) {
    this.subnetId = subnetId;
  }

  public CreateFileSystemWithMountTargetRequestSchema ownerId(String ownerId) {
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
    CreateFileSystemWithMountTargetRequestSchema createFileSystemWithMountTargetRequestSchema = (CreateFileSystemWithMountTargetRequestSchema) o;
    return Objects.equals(this.creationToken, createFileSystemWithMountTargetRequestSchema.creationToken) &&
        Objects.equals(this.nvlFileSystemSize, createFileSystemWithMountTargetRequestSchema.nvlFileSystemSize) &&
        Objects.equals(this.nvlFileSystemType, createFileSystemWithMountTargetRequestSchema.nvlFileSystemType) &&
        Objects.equals(this.nvlShareProto, createFileSystemWithMountTargetRequestSchema.nvlShareProto) &&
        Objects.equals(this.nvlTags, createFileSystemWithMountTargetRequestSchema.nvlTags) &&
        Objects.equals(this.subnetId, createFileSystemWithMountTargetRequestSchema.subnetId) &&
        Objects.equals(this.ownerId, createFileSystemWithMountTargetRequestSchema.ownerId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creationToken, nvlFileSystemSize, nvlFileSystemType, nvlShareProto, nvlTags, subnetId, ownerId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateFileSystemWithMountTargetRequestSchema {\n");
    
    sb.append("    creationToken: ").append(toIndentedString(creationToken)).append("\n");
    sb.append("    nvlFileSystemSize: ").append(toIndentedString(nvlFileSystemSize)).append("\n");
    sb.append("    nvlFileSystemType: ").append(toIndentedString(nvlFileSystemType)).append("\n");
    sb.append("    nvlShareProto: ").append(toIndentedString(nvlShareProto)).append("\n");
    sb.append("    nvlTags: ").append(toIndentedString(nvlTags)).append("\n");
    sb.append("    subnetId: ").append(toIndentedString(subnetId)).append("\n");
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
      return "";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
