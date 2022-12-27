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
 * CreateBackupRestorePointsResponseSchemaCreateBackupRestorePoints
 */

public class CreateBackupRestorePointsResponseSchemaCreateBackupRestorePoints {
  @JsonProperty("requestId")
  private String requestId = null;

  @JsonProperty("return")
  private String _return = null;

  public CreateBackupRestorePointsResponseSchemaCreateBackupRestorePoints requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

   /**
   * Get requestId
   * @return requestId
  **/
  @ApiModelProperty(example = "", required = true, value = "")
  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public CreateBackupRestorePointsResponseSchemaCreateBackupRestorePoints _return(String _return) {
    this._return = _return;
    return this;
  }

   /**
   * simple return value
   * @return _return
  **/
  @ApiModelProperty(example = "true", required = true, value = "simple return value")
  public String getReturn() {
    return _return;
  }

  public void setReturn(String _return) {
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
    CreateBackupRestorePointsResponseSchemaCreateBackupRestorePoints createBackupRestorePointsResponseSchemaCreateBackupRestorePoints = (CreateBackupRestorePointsResponseSchemaCreateBackupRestorePoints) o;
    return Objects.equals(this.requestId, createBackupRestorePointsResponseSchemaCreateBackupRestorePoints.requestId) &&
        Objects.equals(this._return, createBackupRestorePointsResponseSchemaCreateBackupRestorePoints._return);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestId, _return);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateBackupRestorePointsResponseSchemaCreateBackupRestorePoints {\n");
    
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
