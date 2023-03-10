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

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet
 */

public class DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet {
  @JsonProperty("availabilityZone")
  private String availabilityZone = null;

  @JsonProperty("created")
  private LocalDateTime created = null;

  @JsonProperty("enabled")
  private Boolean enabled = null;

  @JsonProperty("hypervisor")
  private String hypervisor = "openstack";

  @JsonProperty("instanceNum")
  private Integer instanceNum = null;

  @JsonProperty("instanceSet")
  private List<DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseInstanceSet> instanceSet = null;

  @JsonProperty("jobId")
  private String jobId = null;

  @JsonProperty("jobState")
  private String jobState = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("owner_id")
  private String ownerId = null;

  @JsonProperty("policy")
  private Object policy = null;

  @JsonProperty("reason")
  private String reason = null;

  @JsonProperty("updated")
  private LocalDateTime updated = null;

  public DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet availabilityZone(String availabilityZone) {
    this.availabilityZone = availabilityZone;
    return this;
  }

   /**
   * availability zone of the job
   * @return availabilityZone
  **/
  @ApiModelProperty(example = "SiteTorino01", required = true, value = "availability zone of the job")
  public String getAvailabilityZone() {
    return availabilityZone;
  }

  public void setAvailabilityZone(String availabilityZone) {
    this.availabilityZone = availabilityZone;
  }

  public DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet created(LocalDateTime created) {
    this.created = created;
    return this;
  }

   /**
   * job creation time
   * @return created
  **/
  @ApiModelProperty(example = "2021-06-28T12:12:02.000000", required = true, value = "job creation time")
  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet enabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

   /**
   * tell if job schedule is enabled
   * @return enabled
  **/
  @ApiModelProperty(example = "true", required = true, value = "tell if job schedule is enabled")
  public Boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet hypervisor(String hypervisor) {
    this.hypervisor = hypervisor;
    return this;
  }

   /**
   * hypervisor type
   * @return hypervisor
  **/
  @ApiModelProperty(example = "openstack", value = "hypervisor type")
  public String getHypervisor() {
    return hypervisor;
  }

  public void setHypervisor(String hypervisor) {
    this.hypervisor = hypervisor;
  }

  public DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet instanceNum(Integer instanceNum) {
    this.instanceNum = instanceNum;
    return this;
  }

   /**
   * number of compute instances
   * @return instanceNum
  **/
  @ApiModelProperty(value = "number of compute instances")
  public Integer getInstanceNum() {
    return instanceNum;
  }

  public void setInstanceNum(Integer instanceNum) {
    this.instanceNum = instanceNum;
  }

  public DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet instanceSet(List<DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseInstanceSet> instanceSet) {
    this.instanceSet = instanceSet;
    return this;
  }

  public DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet addInstanceSetItem(DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseInstanceSet instanceSetItem) {
    if (this.instanceSet == null) {
      this.instanceSet = new ArrayList<>();
    }
    this.instanceSet.add(instanceSetItem);
    return this;
  }

   /**
   * Get instanceSet
   * @return instanceSet
  **/
  @ApiModelProperty(value = "")
  public List<DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseInstanceSet> getInstanceSet() {
    return instanceSet;
  }

  public void setInstanceSet(List<DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseInstanceSet> instanceSet) {
    this.instanceSet = instanceSet;
  }

  public DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet jobId(String jobId) {
    this.jobId = jobId;
    return this;
  }

   /**
   * instance id
   * @return jobId
  **/
  @ApiModelProperty(example = "", value = "instance id")
  public String getJobId() {
    return jobId;
  }

  public void setJobId(String jobId) {
    this.jobId = jobId;
  }

  public DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet jobState(String jobState) {
    this.jobState = jobState;
    return this;
  }

   /**
   * current job status
   * @return jobState
  **/
  @ApiModelProperty(example = "available", required = true, value = "current job status")
  public String getJobState() {
    return jobState;
  }

  public void setJobState(String jobState) {
    this.jobState = jobState;
  }

  public DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet name(String name) {
    this.name = name;
    return this;
  }

   /**
   * job name
   * @return name
  **/
  @ApiModelProperty(example = "job123", required = true, value = "job name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet ownerId(String ownerId) {
    this.ownerId = ownerId;
    return this;
  }

   /**
   * account ID of the job owner
   * @return ownerId
  **/
  @ApiModelProperty(example = "test123", required = true, value = "account ID of the job owner")
  public String getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(String ownerId) {
    this.ownerId = ownerId;
  }

  public DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet policy(Object policy) {
    this.policy = policy;
    return this;
  }

   /**
   * job policy
   * @return policy
  **/
  @ApiModelProperty(example = "\"bk-job-policy-14-retention\"", required = true, value = "job policy")
  public Object getPolicy() {
    return policy;
  }

  public void setPolicy(Object policy) {
    this.policy = policy;
  }

  public DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet reason(String reason) {
    this.reason = reason;
    return this;
  }

   /**
   * reason for the current state of the job
   * @return reason
  **/
  @ApiModelProperty(example = "", required = true, value = "reason for the current state of the job")
  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet updated(LocalDateTime updated) {
    this.updated = updated;
    return this;
  }

   /**
   * job update time
   * @return updated
  **/
  @ApiModelProperty(example = "2021-07-12T15:11:49.000000", required = true, value = "job update time")
  public LocalDateTime getUpdated() {
    return updated;
  }

  public void setUpdated(LocalDateTime updated) {
    this.updated = updated;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet describeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet = (DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet) o;
    return Objects.equals(this.availabilityZone, describeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet.availabilityZone) &&
        Objects.equals(this.created, describeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet.created) &&
        Objects.equals(this.enabled, describeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet.enabled) &&
        Objects.equals(this.hypervisor, describeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet.hypervisor) &&
        Objects.equals(this.instanceNum, describeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet.instanceNum) &&
        Objects.equals(this.instanceSet, describeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet.instanceSet) &&
        Objects.equals(this.jobId, describeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet.jobId) &&
        Objects.equals(this.jobState, describeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet.jobState) &&
        Objects.equals(this.name, describeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet.name) &&
        Objects.equals(this.ownerId, describeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet.ownerId) &&
        Objects.equals(this.policy, describeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet.policy) &&
        Objects.equals(this.reason, describeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet.reason) &&
        Objects.equals(this.updated, describeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet.updated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(availabilityZone, created, enabled, hypervisor, instanceNum, instanceSet, jobId, jobState, name, ownerId, policy, reason, updated);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet {\n");
    
    sb.append("    availabilityZone: ").append(toIndentedString(availabilityZone)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    hypervisor: ").append(toIndentedString(hypervisor)).append("\n");
    sb.append("    instanceNum: ").append(toIndentedString(instanceNum)).append("\n");
    sb.append("    instanceSet: ").append(toIndentedString(instanceSet)).append("\n");
    sb.append("    jobId: ").append(toIndentedString(jobId)).append("\n");
    sb.append("    jobState: ").append(toIndentedString(jobState)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
    sb.append("    policy: ").append(toIndentedString(policy)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
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

