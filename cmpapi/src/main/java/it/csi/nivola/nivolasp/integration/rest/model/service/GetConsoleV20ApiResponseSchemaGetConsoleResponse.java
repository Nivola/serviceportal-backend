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
 * GetConsoleV20ApiResponseSchemaGetConsoleResponse
 */

public class GetConsoleV20ApiResponseSchemaGetConsoleResponse {
  @JsonProperty("__xmlns")
  private String xmlns = null;

  @JsonProperty("console")
  private GetConsoleV20ApiResponseSchemaGetConsoleResponseConsole console = null;

  @JsonProperty("instanceId")
  private String instanceId = null;

  @JsonProperty("instancesId")
  private String instancesId = null;

  @JsonProperty("requestId")
  private String requestId = null;

  public GetConsoleV20ApiResponseSchemaGetConsoleResponse xmlns(String xmlns) {
    this.xmlns = xmlns;
    return this;
  }

   /**
   * Get xmlns
   * @return xmlns
  **/
  @ApiModelProperty(value = "")
  public String getXmlns() {
    return xmlns;
  }

  public void setXmlns(String xmlns) {
    this.xmlns = xmlns;
  }

  public GetConsoleV20ApiResponseSchemaGetConsoleResponse console(GetConsoleV20ApiResponseSchemaGetConsoleResponseConsole console) {
    this.console = console;
    return this;
  }

   /**
   * Get console
   * @return console
  **/
  @ApiModelProperty(required = true, value = "")
  public GetConsoleV20ApiResponseSchemaGetConsoleResponseConsole getConsole() {
    return console;
  }

  public void setConsole(GetConsoleV20ApiResponseSchemaGetConsoleResponseConsole console) {
    this.console = console;
  }

  public GetConsoleV20ApiResponseSchemaGetConsoleResponse instanceId(String instanceId) {
    this.instanceId = instanceId;
    return this;
  }

   /**
   * elk-04-ubuntu
   * @return instanceId
  **/
  @ApiModelProperty(value = "elk-04-ubuntu")
  public String getInstanceId() {
    return instanceId;
  }

  public void setInstanceId(String instanceId) {
    this.instanceId = instanceId;
  }

  public GetConsoleV20ApiResponseSchemaGetConsoleResponse instancesId(String instancesId) {
    this.instancesId = instancesId;
    return this;
  }

   /**
   * instance id
   * @return instancesId
  **/
  @ApiModelProperty(value = "instance id")
  public String getInstancesId() {
    return instancesId;
  }

  public void setInstancesId(String instancesId) {
    this.instancesId = instancesId;
  }

  public GetConsoleV20ApiResponseSchemaGetConsoleResponse requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

   /**
   * request id
   * @return requestId
  **/
  @ApiModelProperty(required = true, value = "request id")
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
    GetConsoleV20ApiResponseSchemaGetConsoleResponse getConsoleV20ApiResponseSchemaGetConsoleResponse = (GetConsoleV20ApiResponseSchemaGetConsoleResponse) o;
    return Objects.equals(this.xmlns, getConsoleV20ApiResponseSchemaGetConsoleResponse.xmlns) &&
        Objects.equals(this.console, getConsoleV20ApiResponseSchemaGetConsoleResponse.console) &&
        Objects.equals(this.instanceId, getConsoleV20ApiResponseSchemaGetConsoleResponse.instanceId) &&
        Objects.equals(this.instancesId, getConsoleV20ApiResponseSchemaGetConsoleResponse.instancesId) &&
        Objects.equals(this.requestId, getConsoleV20ApiResponseSchemaGetConsoleResponse.requestId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(xmlns, console, instanceId, instancesId, requestId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetConsoleV20ApiResponseSchemaGetConsoleResponse {\n");
    
    sb.append("    xmlns: ").append(toIndentedString(xmlns)).append("\n");
    sb.append("    console: ").append(toIndentedString(console)).append("\n");
    sb.append("    instanceId: ").append(toIndentedString(instanceId)).append("\n");
    sb.append("    instancesId: ").append(toIndentedString(instancesId)).append("\n");
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

