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
 * DisableLogConfigApiResponseSchemaDisableLogConfigResponse
 */

public class DisableLogConfigApiResponseSchemaDisableLogConfigResponse {
  @JsonProperty("__xmlns")
  private String xmlns = null;

  @JsonProperty("nvl-activeTask")
  private String nvlActiveTask = null;

  @JsonProperty("requestId")
  private String requestId = null;

  @JsonProperty("return")
  private Boolean _return = null;

  public DisableLogConfigApiResponseSchemaDisableLogConfigResponse xmlns(String xmlns) {
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

  public DisableLogConfigApiResponseSchemaDisableLogConfigResponse nvlActiveTask(String nvlActiveTask) {
    this.nvlActiveTask = nvlActiveTask;
    return this;
  }

   /**
   * active task id
   * @return nvlActiveTask
  **/
  @ApiModelProperty(required = true, value = "active task id")
  public String getNvlActiveTask() {
    return nvlActiveTask;
  }

  public void setNvlActiveTask(String nvlActiveTask) {
    this.nvlActiveTask = nvlActiveTask;
  }

  public DisableLogConfigApiResponseSchemaDisableLogConfigResponse requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

   /**
   * api request id
   * @return requestId
  **/
  @ApiModelProperty(example = "29647df5-5228-46d0-a2a9-09ac9d84c099", required = true, value = "api request id")
  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public DisableLogConfigApiResponseSchemaDisableLogConfigResponse _return(Boolean _return) {
    this._return = _return;
    return this;
  }

   /**
   * Get _return
   * @return _return
  **/
  @ApiModelProperty(example = "true", required = true, value = "")
  public Boolean isReturn() {
    return _return;
  }

  public void setReturn(Boolean _return) {
    this._return = _return;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DisableLogConfigApiResponseSchemaDisableLogConfigResponse disableLogConfigApiResponseSchemaDisableLogConfigResponse = (DisableLogConfigApiResponseSchemaDisableLogConfigResponse) o;
    return Objects.equals(this.xmlns, disableLogConfigApiResponseSchemaDisableLogConfigResponse.xmlns) &&
        Objects.equals(this.nvlActiveTask, disableLogConfigApiResponseSchemaDisableLogConfigResponse.nvlActiveTask) &&
        Objects.equals(this.requestId, disableLogConfigApiResponseSchemaDisableLogConfigResponse.requestId) &&
        Objects.equals(this._return, disableLogConfigApiResponseSchemaDisableLogConfigResponse._return);
  }

  @Override
  public int hashCode() {
    return Objects.hash(xmlns, nvlActiveTask, requestId, _return);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DisableLogConfigApiResponseSchemaDisableLogConfigResponse {\n");
    
    sb.append("    xmlns: ").append(toIndentedString(xmlns)).append("\n");
    sb.append("    nvlActiveTask: ").append(toIndentedString(nvlActiveTask)).append("\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
    sb.append("    _return: ").append(toIndentedString(_return)).append("\n");
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
