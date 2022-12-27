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
 * CreateMountTargetApiRequestSchema
 */

public class CreateMountTargetApiRequestSchema {
  @JsonProperty("Nvl_FileSystemId")
  private String nvlFileSystemId = null;

  @JsonProperty("Nvl_shareLabel")
  private String nvlShareLabel = null;

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
    public static NvlShareProtoEnum fromValue(String value) {
      for (NvlShareProtoEnum b : NvlShareProtoEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("Nvl_shareProto")
  private NvlShareProtoEnum nvlShareProto = NvlShareProtoEnum.NFS;

  @JsonProperty("Nvl_shareVolume")
  private String nvlShareVolume = null;

  @JsonProperty("SubnetId")
  private String subnetId = null;

  public CreateMountTargetApiRequestSchema nvlFileSystemId(String nvlFileSystemId) {
    this.nvlFileSystemId = nvlFileSystemId;
    return this;
  }

   /**
   * storage file system ID
   * @return nvlFileSystemId
  **/
  @ApiModelProperty(example = "fs-47a2c22e", required = true, value = "storage file system ID")
  public String getNvlFileSystemId() {
    return nvlFileSystemId;
  }

  public void setNvlFileSystemId(String nvlFileSystemId) {
    this.nvlFileSystemId = nvlFileSystemId;
  }

  public CreateMountTargetApiRequestSchema nvlShareLabel(String nvlShareLabel) {
    this.nvlShareLabel = nvlShareLabel;
    return this;
  }

   /**
   * Label to be used when you want to use a labelled share type
   * @return nvlShareLabel
  **/
  @ApiModelProperty(example = "project", value = "Label to be used when you want to use a labelled share type")
  public String getNvlShareLabel() {
    return nvlShareLabel;
  }

  public void setNvlShareLabel(String nvlShareLabel) {
    this.nvlShareLabel = nvlShareLabel;
  }

  public CreateMountTargetApiRequestSchema nvlShareProto(NvlShareProtoEnum nvlShareProto) {
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

  public CreateMountTargetApiRequestSchema nvlShareVolume(String nvlShareVolume) {
    this.nvlShareVolume = nvlShareVolume;
    return this;
  }

   /**
   * id of a physical existing volume to set for mount target
   * @return nvlShareVolume
  **/
  @ApiModelProperty(example = "uenx79dsns", value = "id of a physical existing volume to set for mount target")
  public String getNvlShareVolume() {
    return nvlShareVolume;
  }

  public void setNvlShareVolume(String nvlShareVolume) {
    this.nvlShareVolume = nvlShareVolume;
  }

  public CreateMountTargetApiRequestSchema subnetId(String subnetId) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateMountTargetApiRequestSchema createMountTargetApiRequestSchema = (CreateMountTargetApiRequestSchema) o;
    return Objects.equals(this.nvlFileSystemId, createMountTargetApiRequestSchema.nvlFileSystemId) &&
        Objects.equals(this.nvlShareLabel, createMountTargetApiRequestSchema.nvlShareLabel) &&
        Objects.equals(this.nvlShareProto, createMountTargetApiRequestSchema.nvlShareProto) &&
        Objects.equals(this.nvlShareVolume, createMountTargetApiRequestSchema.nvlShareVolume) &&
        Objects.equals(this.subnetId, createMountTargetApiRequestSchema.subnetId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nvlFileSystemId, nvlShareLabel, nvlShareProto, nvlShareVolume, subnetId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateMountTargetApiRequestSchema {\n");
    
    sb.append("    nvlFileSystemId: ").append(toIndentedString(nvlFileSystemId)).append("\n");
    sb.append("    nvlShareLabel: ").append(toIndentedString(nvlShareLabel)).append("\n");
    sb.append("    nvlShareProto: ").append(toIndentedString(nvlShareProto)).append("\n");
    sb.append("    nvlShareVolume: ").append(toIndentedString(nvlShareVolume)).append("\n");
    sb.append("    subnetId: ").append(toIndentedString(subnetId)).append("\n");
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
