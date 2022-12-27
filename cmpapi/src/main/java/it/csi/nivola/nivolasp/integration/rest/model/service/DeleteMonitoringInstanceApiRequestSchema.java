/*-
 * ========================LICENSE_START=================================
 * Api CMP
 * %%
 * Copyright (C) 2022 Regione Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | Regione Piemonte
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
 * DeleteMonitoringInstanceApiRequestSchema
 */

public class DeleteMonitoringInstanceApiRequestSchema {
  @JsonProperty("InstanceId")
  private String instanceId = null;

  public DeleteMonitoringInstanceApiRequestSchema instanceId(String instanceId) {
    this.instanceId = instanceId;
    return this;
  }

   /**
   * instance id
   * @return instanceId
  **/
  @ApiModelProperty(example = "29647df5-5228-46d0-a2a9-09ac9d84c099", required = true, value = "instance id")
  public String getInstanceId() {
    return instanceId;
  }

  public void setInstanceId(String instanceId) {
    this.instanceId = instanceId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeleteMonitoringInstanceApiRequestSchema deleteMonitoringInstanceApiRequestSchema = (DeleteMonitoringInstanceApiRequestSchema) o;
    return Objects.equals(this.instanceId, deleteMonitoringInstanceApiRequestSchema.instanceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(instanceId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteMonitoringInstanceApiRequestSchema {\n");
    
    sb.append("    instanceId: ").append(toIndentedString(instanceId)).append("\n");
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
