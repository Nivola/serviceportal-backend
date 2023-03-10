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
 * ForwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseInstancesSet
 */

public class ForwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseInstancesSet {
  @JsonProperty("currentState")
  private ForwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseCurrentState currentState = null;

  @JsonProperty("instanceId")
  private String instanceId = null;

  @JsonProperty("previousState")
  private ForwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseCurrentState previousState = null;

  public ForwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseInstancesSet currentState(ForwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseCurrentState currentState) {
    this.currentState = currentState;
    return this;
  }

   /**
   * Get currentState
   * @return currentState
  **/
  @ApiModelProperty(value = "")
  public ForwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseCurrentState getCurrentState() {
    return currentState;
  }

  public void setCurrentState(ForwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseCurrentState currentState) {
    this.currentState = currentState;
  }

  public ForwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseInstancesSet instanceId(String instanceId) {
    this.instanceId = instanceId;
    return this;
  }

   /**
   * DB instance ID
   * @return instanceId
  **/
  @ApiModelProperty(example = "", value = "DB instance ID")
  public String getInstanceId() {
    return instanceId;
  }

  public void setInstanceId(String instanceId) {
    this.instanceId = instanceId;
  }

  public ForwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseInstancesSet previousState(ForwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseCurrentState previousState) {
    this.previousState = previousState;
    return this;
  }

   /**
   * Get previousState
   * @return previousState
  **/
  @ApiModelProperty(value = "")
  public ForwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseCurrentState getPreviousState() {
    return previousState;
  }

  public void setPreviousState(ForwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseCurrentState previousState) {
    this.previousState = previousState;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ForwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseInstancesSet forwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseInstancesSet = (ForwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseInstancesSet) o;
    return Objects.equals(this.currentState, forwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseInstancesSet.currentState) &&
        Objects.equals(this.instanceId, forwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseInstancesSet.instanceId) &&
        Objects.equals(this.previousState, forwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseInstancesSet.previousState);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentState, instanceId, previousState);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ForwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseInstancesSet {\n");
    
    sb.append("    currentState: ").append(toIndentedString(currentState)).append("\n");
    sb.append("    instanceId: ").append(toIndentedString(instanceId)).append("\n");
    sb.append("    previousState: ").append(toIndentedString(previousState)).append("\n");
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

