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
 * DeleteVolumeResponseSchemaDeleteVolumeResponse
 */

public class DeleteVolumeResponseSchemaDeleteVolumeResponse {
  @JsonProperty("requestId")
  private String requestId = null;

  @JsonProperty("return")
  private Boolean _return = null;

  public DeleteVolumeResponseSchemaDeleteVolumeResponse requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

   /**
   * api request id
   * @return requestId
  **/
  @ApiModelProperty(example = "", required = true, value = "api request id")
  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public DeleteVolumeResponseSchemaDeleteVolumeResponse _return(Boolean _return) {
    this._return = _return;
    return this;
  }

   /**
   * return status
   * @return _return
  **/
  @ApiModelProperty(required = true, value = "return status")
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
    DeleteVolumeResponseSchemaDeleteVolumeResponse deleteVolumeResponseSchemaDeleteVolumeResponse = (DeleteVolumeResponseSchemaDeleteVolumeResponse) o;
    return Objects.equals(this.requestId, deleteVolumeResponseSchemaDeleteVolumeResponse.requestId) &&
        Objects.equals(this._return, deleteVolumeResponseSchemaDeleteVolumeResponse._return);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestId, _return);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteVolumeResponseSchemaDeleteVolumeResponse {\n");
    
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

