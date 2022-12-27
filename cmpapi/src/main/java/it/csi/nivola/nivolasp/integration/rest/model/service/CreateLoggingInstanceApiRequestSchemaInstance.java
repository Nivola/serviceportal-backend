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
 * CreateLoggingInstanceApiRequestSchemaInstance
 */

public class CreateLoggingInstanceApiRequestSchemaInstance {
  @JsonProperty("ComputeInstanceId")
  private String computeInstanceId = null;

  @JsonProperty("InstanceType")
  private String instanceType = null;

  @JsonProperty("owner-id")
  private String ownerId = null;

  public CreateLoggingInstanceApiRequestSchemaInstance computeInstanceId(String computeInstanceId) {
    this.computeInstanceId = computeInstanceId;
    return this;
  }

   /**
   * compute instance id
   * @return computeInstanceId
  **/
  @ApiModelProperty(required = true, value = "compute instance id")
  public String getComputeInstanceId() {
    return computeInstanceId;
  }

  public void setComputeInstanceId(String computeInstanceId) {
    this.computeInstanceId = computeInstanceId;
  }

  public CreateLoggingInstanceApiRequestSchemaInstance instanceType(String instanceType) {
    this.instanceType = instanceType;
    return this;
  }

   /**
   * service definition of the instance
   * @return instanceType
  **/
  @ApiModelProperty(value = "service definition of the instance")
  public String getInstanceType() {
    return instanceType;
  }

  public void setInstanceType(String instanceType) {
    this.instanceType = instanceType;
  }

  public CreateLoggingInstanceApiRequestSchemaInstance ownerId(String ownerId) {
    this.ownerId = ownerId;
    return this;
  }

   /**
   * account id or uuid associated to compute zone
   * @return ownerId
  **/
  @ApiModelProperty(example = "1", required = true, value = "account id or uuid associated to compute zone")
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
    CreateLoggingInstanceApiRequestSchemaInstance createLoggingInstanceApiRequestSchemaInstance = (CreateLoggingInstanceApiRequestSchemaInstance) o;
    return Objects.equals(this.computeInstanceId, createLoggingInstanceApiRequestSchemaInstance.computeInstanceId) &&
        Objects.equals(this.instanceType, createLoggingInstanceApiRequestSchemaInstance.instanceType) &&
        Objects.equals(this.ownerId, createLoggingInstanceApiRequestSchemaInstance.ownerId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(computeInstanceId, instanceType, ownerId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateLoggingInstanceApiRequestSchemaInstance {\n");
    
    sb.append("    computeInstanceId: ").append(toIndentedString(computeInstanceId)).append("\n");
    sb.append("    instanceType: ").append(toIndentedString(instanceType)).append("\n");
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
