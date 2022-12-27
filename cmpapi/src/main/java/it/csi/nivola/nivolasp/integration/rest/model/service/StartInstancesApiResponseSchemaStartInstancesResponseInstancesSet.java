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
 * API description in Markdown.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: me@csi.it
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
 * StartInstancesApiResponseSchemaStartInstancesResponseInstancesSet
 */

public class StartInstancesApiResponseSchemaStartInstancesResponseInstancesSet {
  @JsonProperty("currentState")
  private DescribeInstancesApiResponseSchemaDescribeInstancesResponseInstanceState currentState = null;

  @JsonProperty("instanceId")
  private String instanceId = null;

  @JsonProperty("previousState")
  private DescribeInstancesApiResponseSchemaDescribeInstancesResponseInstanceState previousState = null;

  public StartInstancesApiResponseSchemaStartInstancesResponseInstancesSet currentState(DescribeInstancesApiResponseSchemaDescribeInstancesResponseInstanceState currentState) {
    this.currentState = currentState;
    return this;
  }

   /**
   * Get currentState
   * @return currentState
  **/
  @ApiModelProperty(value = "")
  public DescribeInstancesApiResponseSchemaDescribeInstancesResponseInstanceState getCurrentState() {
    return currentState;
  }

  public void setCurrentState(DescribeInstancesApiResponseSchemaDescribeInstancesResponseInstanceState currentState) {
    this.currentState = currentState;
  }

  public StartInstancesApiResponseSchemaStartInstancesResponseInstancesSet instanceId(String instanceId) {
    this.instanceId = instanceId;
    return this;
  }

   /**
   * instance ID
   * @return instanceId
  **/
  @ApiModelProperty(example = "", value = "instance ID")
  public String getInstanceId() {
    return instanceId;
  }

  public void setInstanceId(String instanceId) {
    this.instanceId = instanceId;
  }

  public StartInstancesApiResponseSchemaStartInstancesResponseInstancesSet previousState(DescribeInstancesApiResponseSchemaDescribeInstancesResponseInstanceState previousState) {
    this.previousState = previousState;
    return this;
  }

   /**
   * Get previousState
   * @return previousState
  **/
  @ApiModelProperty(value = "")
  public DescribeInstancesApiResponseSchemaDescribeInstancesResponseInstanceState getPreviousState() {
    return previousState;
  }

  public void setPreviousState(DescribeInstancesApiResponseSchemaDescribeInstancesResponseInstanceState previousState) {
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
    StartInstancesApiResponseSchemaStartInstancesResponseInstancesSet startInstancesApiResponseSchemaStartInstancesResponseInstancesSet = (StartInstancesApiResponseSchemaStartInstancesResponseInstancesSet) o;
    return Objects.equals(this.currentState, startInstancesApiResponseSchemaStartInstancesResponseInstancesSet.currentState) &&
        Objects.equals(this.instanceId, startInstancesApiResponseSchemaStartInstancesResponseInstancesSet.instanceId) &&
        Objects.equals(this.previousState, startInstancesApiResponseSchemaStartInstancesResponseInstancesSet.previousState);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentState, instanceId, previousState);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartInstancesApiResponseSchemaStartInstancesResponseInstancesSet {\n");
    
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
      return "";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
