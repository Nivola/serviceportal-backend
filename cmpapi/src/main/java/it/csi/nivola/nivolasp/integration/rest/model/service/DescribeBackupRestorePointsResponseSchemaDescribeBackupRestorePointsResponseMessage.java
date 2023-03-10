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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * restore point execution messages
 */
@ApiModel(description = "restore point execution messages")

public class DescribeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseMessage {
  @JsonProperty("error")
  private String error = null;

  @JsonProperty("progress")
  private String progress = null;

  @JsonProperty("warning")
  private String warning = null;

  public DescribeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseMessage error(String error) {
    this.error = error;
    return this;
  }

   /**
   * restore point error message
   * @return error
  **/
  @ApiModelProperty(value = "restore point error message")
  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public DescribeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseMessage progress(String progress) {
    this.progress = progress;
    return this;
  }

   /**
   * restore point progress message
   * @return progress
  **/
  @ApiModelProperty(value = "restore point progress message")
  public String getProgress() {
    return progress;
  }

  public void setProgress(String progress) {
    this.progress = progress;
  }

  public DescribeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseMessage warning(String warning) {
    this.warning = warning;
    return this;
  }

   /**
   * restore point warning message
   * @return warning
  **/
  @ApiModelProperty(value = "restore point warning message")
  public String getWarning() {
    return warning;
  }

  public void setWarning(String warning) {
    this.warning = warning;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseMessage describeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseMessage = (DescribeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseMessage) o;
    return Objects.equals(this.error, describeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseMessage.error) &&
        Objects.equals(this.progress, describeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseMessage.progress) &&
        Objects.equals(this.warning, describeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseMessage.warning);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error, progress, warning);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseMessage {\n");
    
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    progress: ").append(toIndentedString(progress)).append("\n");
    sb.append("    warning: ").append(toIndentedString(warning)).append("\n");
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

