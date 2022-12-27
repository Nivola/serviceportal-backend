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
 * DescribeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseInstanceBackupSet
 */

public class DescribeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseInstanceBackupSet {
  @JsonProperty("instanceId")
  private String instanceId = null;

  @JsonProperty("job")
  private Object job = null;

  @JsonProperty("rsstorePoints")
  private List<Object> rsstorePoints = new ArrayList<>();

  public DescribeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseInstanceBackupSet instanceId(String instanceId) {
    this.instanceId = instanceId;
    return this;
  }

   /**
   * instance id
   * @return instanceId
  **/
  @ApiModelProperty(example = "", required = true, value = "instance id")
  public String getInstanceId() {
    return instanceId;
  }

  public void setInstanceId(String instanceId) {
    this.instanceId = instanceId;
  }

  public DescribeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseInstanceBackupSet job(Object job) {
    this.job = job;
    return this;
  }

   /**
   * job info
   * @return job
  **/
  @ApiModelProperty(example = "\"{}\"", required = true, value = "job info")
  public Object getJob() {
    return job;
  }

  public void setJob(Object job) {
    this.job = job;
  }

  public DescribeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseInstanceBackupSet rsstorePoints(List<Object> rsstorePoints) {
    this.rsstorePoints = rsstorePoints;
    return this;
  }

  public DescribeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseInstanceBackupSet addRsstorePointsItem(Object rsstorePointsItem) {
    this.rsstorePoints.add(rsstorePointsItem);
    return this;
  }

   /**
   * list of restore points
   * @return rsstorePoints
  **/
  @ApiModelProperty(example = "\"[{}]\"", required = true, value = "list of restore points")
  public List<Object> getRsstorePoints() {
    return rsstorePoints;
  }

  public void setRsstorePoints(List<Object> rsstorePoints) {
    this.rsstorePoints = rsstorePoints;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseInstanceBackupSet describeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseInstanceBackupSet = (DescribeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseInstanceBackupSet) o;
    return Objects.equals(this.instanceId, describeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseInstanceBackupSet.instanceId) &&
        Objects.equals(this.job, describeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseInstanceBackupSet.job) &&
        Objects.equals(this.rsstorePoints, describeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseInstanceBackupSet.rsstorePoints);
  }

  @Override
  public int hashCode() {
    return Objects.hash(instanceId, job, rsstorePoints);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseInstanceBackupSet {\n");
    
    sb.append("    instanceId: ").append(toIndentedString(instanceId)).append("\n");
    sb.append("    job: ").append(toIndentedString(job)).append("\n");
    sb.append("    rsstorePoints: ").append(toIndentedString(rsstorePoints)).append("\n");
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
