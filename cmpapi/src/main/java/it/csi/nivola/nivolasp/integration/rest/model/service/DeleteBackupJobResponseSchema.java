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
 * DeleteBackupJobResponseSchema
 */

public class DeleteBackupJobResponseSchema {
  @JsonProperty("DeleteBackupJob")
  private AddBackupJobInstanceResponseSchemaAddBackupJobInstance deleteBackupJob = null;

  public DeleteBackupJobResponseSchema deleteBackupJob(AddBackupJobInstanceResponseSchemaAddBackupJobInstance deleteBackupJob) {
    this.deleteBackupJob = deleteBackupJob;
    return this;
  }

   /**
   * Get deleteBackupJob
   * @return deleteBackupJob
  **/
  @ApiModelProperty(required = true, value = "")
  public AddBackupJobInstanceResponseSchemaAddBackupJobInstance getDeleteBackupJob() {
    return deleteBackupJob;
  }

  public void setDeleteBackupJob(AddBackupJobInstanceResponseSchemaAddBackupJobInstance deleteBackupJob) {
    this.deleteBackupJob = deleteBackupJob;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeleteBackupJobResponseSchema deleteBackupJobResponseSchema = (DeleteBackupJobResponseSchema) o;
    return Objects.equals(this.deleteBackupJob, deleteBackupJobResponseSchema.deleteBackupJob);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deleteBackupJob);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteBackupJobResponseSchema {\n");
    
    sb.append("    deleteBackupJob: ").append(toIndentedString(deleteBackupJob)).append("\n");
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

