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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * CreateBackupJobRequestSchema
 */

public class CreateBackupJobRequestSchema {
  @JsonProperty("AvailabilityZone")
  private String availabilityZone = null;

  /**
   * hypervisor type
   */
  public enum HypervisorEnum {
    OPENSTACK("openstack");

    private String value;

    HypervisorEnum(String value) {
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
    public static HypervisorEnum fromValue(String value) {
      for (HypervisorEnum b : HypervisorEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("Hypervisor")
  private HypervisorEnum hypervisor = HypervisorEnum.OPENSTACK;

  @JsonProperty("InstanceId.N")
  private List<String> instanceIdDotN = new ArrayList<>();

  @JsonProperty("Name")
  private String name = null;

  @JsonProperty("Policy")
  private String policy = "bk-job-policy-7-retention";

  @JsonProperty("owner-id")
  private String ownerId = null;

  public CreateBackupJobRequestSchema availabilityZone(String availabilityZone) {
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

  public CreateBackupJobRequestSchema hypervisor(HypervisorEnum hypervisor) {
    this.hypervisor = hypervisor;
    return this;
  }

   /**
   * hypervisor type
   * @return hypervisor
  **/
  @ApiModelProperty(example = "openstack", value = "hypervisor type")
  public HypervisorEnum getHypervisor() {
    return hypervisor;
  }

  public void setHypervisor(HypervisorEnum hypervisor) {
    this.hypervisor = hypervisor;
  }

  public CreateBackupJobRequestSchema instanceIdDotN(List<String> instanceIdDotN) {
    this.instanceIdDotN = instanceIdDotN;
    return this;
  }

  public CreateBackupJobRequestSchema addInstanceIdDotNItem(String instanceIdDotNItem) {
    this.instanceIdDotN.add(instanceIdDotNItem);
    return this;
  }

   /**
   * job id
   * @return instanceIdDotN
  **/
  @ApiModelProperty(required = true, value = "job id")
  public List<String> getInstanceIdDotN() {
    return instanceIdDotN;
  }

  public void setInstanceIdDotN(List<String> instanceIdDotN) {
    this.instanceIdDotN = instanceIdDotN;
  }

  public CreateBackupJobRequestSchema name(String name) {
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

  public CreateBackupJobRequestSchema policy(String policy) {
    this.policy = policy;
    return this;
  }

   /**
   * job policy
   * @return policy
  **/
  @ApiModelProperty(example = "bk-job-policy-14-retention", value = "job policy")
  public String getPolicy() {
    return policy;
  }

  public void setPolicy(String policy) {
    this.policy = policy;
  }

  public CreateBackupJobRequestSchema ownerId(String ownerId) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateBackupJobRequestSchema createBackupJobRequestSchema = (CreateBackupJobRequestSchema) o;
    return Objects.equals(this.availabilityZone, createBackupJobRequestSchema.availabilityZone) &&
        Objects.equals(this.hypervisor, createBackupJobRequestSchema.hypervisor) &&
        Objects.equals(this.instanceIdDotN, createBackupJobRequestSchema.instanceIdDotN) &&
        Objects.equals(this.name, createBackupJobRequestSchema.name) &&
        Objects.equals(this.policy, createBackupJobRequestSchema.policy) &&
        Objects.equals(this.ownerId, createBackupJobRequestSchema.ownerId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(availabilityZone, hypervisor, instanceIdDotN, name, policy, ownerId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateBackupJobRequestSchema {\n");
    
    sb.append("    availabilityZone: ").append(toIndentedString(availabilityZone)).append("\n");
    sb.append("    hypervisor: ").append(toIndentedString(hypervisor)).append("\n");
    sb.append("    instanceIdDotN: ").append(toIndentedString(instanceIdDotN)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    policy: ").append(toIndentedString(policy)).append("\n");
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

