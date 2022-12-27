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
 * SyncUsersFolderApiResponseSchemaSyncFolderUsersResponse
 */

public class SyncUsersFolderApiResponseSchemaSyncFolderUsersResponse {
  @JsonProperty("__xmlns")
  private String xmlns = null;

  @JsonProperty("nvl-activeTask")
  private String nvlActiveTask = null;

  @JsonProperty("requestId")
  private String requestId = null;

  @JsonProperty("return")
  private Boolean _return = null;

  public SyncUsersFolderApiResponseSchemaSyncFolderUsersResponse xmlns(String xmlns) {
    this.xmlns = xmlns;
    return this;
  }

   /**
   * Get xmlns
   * @return xmlns
  **/
  @ApiModelProperty(example = "http://nivolapiemonte.it/XMLdoc/2022-05-16/folder/", value = "")
  public String getXmlns() {
    return xmlns;
  }

  public void setXmlns(String xmlns) {
    this.xmlns = xmlns;
  }

  public SyncUsersFolderApiResponseSchemaSyncFolderUsersResponse nvlActiveTask(String nvlActiveTask) {
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

  public SyncUsersFolderApiResponseSchemaSyncFolderUsersResponse requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

   /**
   * Get requestId
   * @return requestId
  **/
  @ApiModelProperty(example = "folderXX-3525-4f95-880d-479acdb463a4", required = true, value = "")
  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public SyncUsersFolderApiResponseSchemaSyncFolderUsersResponse _return(Boolean _return) {
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
    SyncUsersFolderApiResponseSchemaSyncFolderUsersResponse syncUsersFolderApiResponseSchemaSyncFolderUsersResponse = (SyncUsersFolderApiResponseSchemaSyncFolderUsersResponse) o;
    return Objects.equals(this.xmlns, syncUsersFolderApiResponseSchemaSyncFolderUsersResponse.xmlns) &&
        Objects.equals(this.nvlActiveTask, syncUsersFolderApiResponseSchemaSyncFolderUsersResponse.nvlActiveTask) &&
        Objects.equals(this.requestId, syncUsersFolderApiResponseSchemaSyncFolderUsersResponse.requestId) &&
        Objects.equals(this._return, syncUsersFolderApiResponseSchemaSyncFolderUsersResponse._return);
  }

  @Override
  public int hashCode() {
    return Objects.hash(xmlns, nvlActiveTask, requestId, _return);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SyncUsersFolderApiResponseSchemaSyncFolderUsersResponse {\n");
    
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
