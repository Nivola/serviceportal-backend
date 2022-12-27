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
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * DeleteMountTargetApiResponseSchema
 */

public class DeleteMountTargetApiResponseSchema {
  @JsonProperty("nvl_JobId")
  private UUID nvlJobId = null;

  @JsonProperty("nvl_TaskId")
  private UUID nvlTaskId = null;

  public DeleteMountTargetApiResponseSchema nvlJobId(UUID nvlJobId) {
    this.nvlJobId = nvlJobId;
    return this;
  }

   /**
   * ID of the running job
   * @return nvlJobId
  **/
  @ApiModelProperty(example = "db078b20-19c6-4f0e-909c-94745de667d4", required = true, value = "ID of the running job")
  public UUID getNvlJobId() {
    return nvlJobId;
  }

  public void setNvlJobId(UUID nvlJobId) {
    this.nvlJobId = nvlJobId;
  }

  public DeleteMountTargetApiResponseSchema nvlTaskId(UUID nvlTaskId) {
    this.nvlTaskId = nvlTaskId;
    return this;
  }

   /**
   * ID of the running task
   * @return nvlTaskId
  **/
  @ApiModelProperty(example = "db078b20-19c6-4f0e-909c-94745de667d4", required = true, value = "ID of the running task")
  public UUID getNvlTaskId() {
    return nvlTaskId;
  }

  public void setNvlTaskId(UUID nvlTaskId) {
    this.nvlTaskId = nvlTaskId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeleteMountTargetApiResponseSchema deleteMountTargetApiResponseSchema = (DeleteMountTargetApiResponseSchema) o;
    return Objects.equals(this.nvlJobId, deleteMountTargetApiResponseSchema.nvlJobId) &&
        Objects.equals(this.nvlTaskId, deleteMountTargetApiResponseSchema.nvlTaskId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nvlJobId, nvlTaskId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteMountTargetApiResponseSchema {\n");
    
    sb.append("    nvlJobId: ").append(toIndentedString(nvlJobId)).append("\n");
    sb.append("    nvlTaskId: ").append(toIndentedString(nvlTaskId)).append("\n");
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

