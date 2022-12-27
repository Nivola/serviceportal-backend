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
 * DeleteMountTargetApiRequestSchema
 */

public class DeleteMountTargetApiRequestSchema {
  @JsonProperty("MountTargetId")
  private String mountTargetId = null;

  @JsonProperty("Nvl_FileSystemId")
  private String nvlFileSystemId = null;

  public DeleteMountTargetApiRequestSchema mountTargetId(String mountTargetId) {
    this.mountTargetId = mountTargetId;
    return this;
  }

   /**
   * resource file system ID
   * @return mountTargetId
  **/
  @ApiModelProperty(example = "", value = "resource file system ID")
  public String getMountTargetId() {
    return mountTargetId;
  }

  public void setMountTargetId(String mountTargetId) {
    this.mountTargetId = mountTargetId;
  }

  public DeleteMountTargetApiRequestSchema nvlFileSystemId(String nvlFileSystemId) {
    this.nvlFileSystemId = nvlFileSystemId;
    return this;
  }

   /**
   * File system ID
   * @return nvlFileSystemId
  **/
  @ApiModelProperty(example = "", required = true, value = "File system ID")
  public String getNvlFileSystemId() {
    return nvlFileSystemId;
  }

  public void setNvlFileSystemId(String nvlFileSystemId) {
    this.nvlFileSystemId = nvlFileSystemId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeleteMountTargetApiRequestSchema deleteMountTargetApiRequestSchema = (DeleteMountTargetApiRequestSchema) o;
    return Objects.equals(this.mountTargetId, deleteMountTargetApiRequestSchema.mountTargetId) &&
        Objects.equals(this.nvlFileSystemId, deleteMountTargetApiRequestSchema.nvlFileSystemId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mountTargetId, nvlFileSystemId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteMountTargetApiRequestSchema {\n");
    
    sb.append("    mountTargetId: ").append(toIndentedString(mountTargetId)).append("\n");
    sb.append("    nvlFileSystemId: ").append(toIndentedString(nvlFileSystemId)).append("\n");
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
