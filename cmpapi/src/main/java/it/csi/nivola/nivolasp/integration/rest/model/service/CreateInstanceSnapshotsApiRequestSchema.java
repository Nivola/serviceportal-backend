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
 * CreateInstanceSnapshotsApiRequestSchema
 */

public class CreateInstanceSnapshotsApiRequestSchema {
  @JsonProperty("InstanceId.N")
  private List<String> instanceIdDotN = new ArrayList<>();

  @JsonProperty("SnapshotName")
  private String snapshotName = null;

  @JsonProperty("owner-id.N")
  private List<String> ownerIdN = null;

  public CreateInstanceSnapshotsApiRequestSchema instanceIdDotN(List<String> instanceIdDotN) {
    this.instanceIdDotN = instanceIdDotN;
    return this;
  }

  public CreateInstanceSnapshotsApiRequestSchema addInstanceIdDotNItem(String instanceIdDotNItem) {
    this.instanceIdDotN.add(instanceIdDotNItem);
    return this;
  }

   /**
   * instance id
   * @return instanceIdDotN
  **/
  @ApiModelProperty(required = true, value = "instance id")
  public List<String> getInstanceIdDotN() {
    return instanceIdDotN;
  }

  public void setInstanceIdDotN(List<String> instanceIdDotN) {
    this.instanceIdDotN = instanceIdDotN;
  }

  public CreateInstanceSnapshotsApiRequestSchema snapshotName(String snapshotName) {
    this.snapshotName = snapshotName;
    return this;
  }

   /**
   * snapshot name
   * @return snapshotName
  **/
  @ApiModelProperty(value = "snapshot name")
  public String getSnapshotName() {
    return snapshotName;
  }

  public void setSnapshotName(String snapshotName) {
    this.snapshotName = snapshotName;
  }

  public CreateInstanceSnapshotsApiRequestSchema ownerIdN(List<String> ownerIdN) {
    this.ownerIdN = ownerIdN;
    return this;
  }

  public CreateInstanceSnapshotsApiRequestSchema addOwnerIdNItem(String ownerIdNItem) {
    if (this.ownerIdN == null) {
      this.ownerIdN = new ArrayList<>();
    }
    this.ownerIdN.add(ownerIdNItem);
    return this;
  }

   /**
   * account ID of the instance owner
   * @return ownerIdN
  **/
  @ApiModelProperty(value = "account ID of the instance owner")
  public List<String> getOwnerIdN() {
    return ownerIdN;
  }

  public void setOwnerIdN(List<String> ownerIdN) {
    this.ownerIdN = ownerIdN;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateInstanceSnapshotsApiRequestSchema createInstanceSnapshotsApiRequestSchema = (CreateInstanceSnapshotsApiRequestSchema) o;
    return Objects.equals(this.instanceIdDotN, createInstanceSnapshotsApiRequestSchema.instanceIdDotN) &&
        Objects.equals(this.snapshotName, createInstanceSnapshotsApiRequestSchema.snapshotName) &&
        Objects.equals(this.ownerIdN, createInstanceSnapshotsApiRequestSchema.ownerIdN);
  }

  @Override
  public int hashCode() {
    return Objects.hash(instanceIdDotN, snapshotName, ownerIdN);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateInstanceSnapshotsApiRequestSchema {\n");
    
    sb.append("    instanceIdDotN: ").append(toIndentedString(instanceIdDotN)).append("\n");
    sb.append("    snapshotName: ").append(toIndentedString(snapshotName)).append("\n");
    sb.append("    ownerIdN: ").append(toIndentedString(ownerIdN)).append("\n");
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
