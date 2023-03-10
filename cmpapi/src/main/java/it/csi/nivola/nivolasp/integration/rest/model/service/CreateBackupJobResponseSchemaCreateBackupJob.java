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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CreateBackupJobResponseSchemaCreateBackupJob
 */

public class CreateBackupJobResponseSchemaCreateBackupJob {
  @JsonProperty("jobsSet")
  private List<CreateBackupJobResponseSchemaCreateBackupJobJobsSet> jobsSet = new ArrayList<>();

  @JsonProperty("requestId")
  private String requestId = null;

  public CreateBackupJobResponseSchemaCreateBackupJob jobsSet(List<CreateBackupJobResponseSchemaCreateBackupJobJobsSet> jobsSet) {
    this.jobsSet = jobsSet;
    return this;
  }

  public CreateBackupJobResponseSchemaCreateBackupJob addJobsSetItem(CreateBackupJobResponseSchemaCreateBackupJobJobsSet jobsSetItem) {
    this.jobsSet.add(jobsSetItem);
    return this;
  }

   /**
   * Get jobsSet
   * @return jobsSet
  **/
  @ApiModelProperty(required = true, value = "")
  public List<CreateBackupJobResponseSchemaCreateBackupJobJobsSet> getJobsSet() {
    return jobsSet;
  }

  public void setJobsSet(List<CreateBackupJobResponseSchemaCreateBackupJobJobsSet> jobsSet) {
    this.jobsSet = jobsSet;
  }

  public CreateBackupJobResponseSchemaCreateBackupJob requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

   /**
   * Get requestId
   * @return requestId
  **/
  @ApiModelProperty(example = "", required = true, value = "")
  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateBackupJobResponseSchemaCreateBackupJob createBackupJobResponseSchemaCreateBackupJob = (CreateBackupJobResponseSchemaCreateBackupJob) o;
    return Objects.equals(this.jobsSet, createBackupJobResponseSchemaCreateBackupJob.jobsSet) &&
        Objects.equals(this.requestId, createBackupJobResponseSchemaCreateBackupJob.requestId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jobsSet, requestId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateBackupJobResponseSchemaCreateBackupJob {\n");
    
    sb.append("    jobsSet: ").append(toIndentedString(jobsSet)).append("\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
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

