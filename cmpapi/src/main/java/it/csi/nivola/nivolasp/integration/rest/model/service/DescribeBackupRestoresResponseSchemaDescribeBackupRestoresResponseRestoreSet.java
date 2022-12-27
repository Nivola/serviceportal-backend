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
 * DescribeBackupRestoresResponseSchemaDescribeBackupRestoresResponseRestoreSet
 */

public class DescribeBackupRestoresResponseSchemaDescribeBackupRestoresResponseRestoreSet {
  @JsonProperty("instanceId")
  private String instanceId = null;

  @JsonProperty("restores")
  private List<Object> restores = new ArrayList<>();

  public DescribeBackupRestoresResponseSchemaDescribeBackupRestoresResponseRestoreSet instanceId(String instanceId) {
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

  public DescribeBackupRestoresResponseSchemaDescribeBackupRestoresResponseRestoreSet restores(List<Object> restores) {
    this.restores = restores;
    return this;
  }

  public DescribeBackupRestoresResponseSchemaDescribeBackupRestoresResponseRestoreSet addRestoresItem(Object restoresItem) {
    this.restores.add(restoresItem);
    return this;
  }

   /**
   * list of restores
   * @return restores
  **/
  @ApiModelProperty(example = "\"[{}]\"", required = true, value = "list of restores")
  public List<Object> getRestores() {
    return restores;
  }

  public void setRestores(List<Object> restores) {
    this.restores = restores;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeBackupRestoresResponseSchemaDescribeBackupRestoresResponseRestoreSet describeBackupRestoresResponseSchemaDescribeBackupRestoresResponseRestoreSet = (DescribeBackupRestoresResponseSchemaDescribeBackupRestoresResponseRestoreSet) o;
    return Objects.equals(this.instanceId, describeBackupRestoresResponseSchemaDescribeBackupRestoresResponseRestoreSet.instanceId) &&
        Objects.equals(this.restores, describeBackupRestoresResponseSchemaDescribeBackupRestoresResponseRestoreSet.restores);
  }

  @Override
  public int hashCode() {
    return Objects.hash(instanceId, restores);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeBackupRestoresResponseSchemaDescribeBackupRestoresResponseRestoreSet {\n");
    
    sb.append("    instanceId: ").append(toIndentedString(instanceId)).append("\n");
    sb.append("    restores: ").append(toIndentedString(restores)).append("\n");
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
