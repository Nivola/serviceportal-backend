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
 * DeleteFileSystemGrantRequestSchemaGrant
 */

public class DeleteFileSystemGrantRequestSchemaGrant {
  @JsonProperty("access_id")
  private String accessId = null;

  public DeleteFileSystemGrantRequestSchemaGrant accessId(String accessId) {
    this.accessId = accessId;
    return this;
  }

   /**
   * The UUID of the access granted to a file system instance to be deletd
   * @return accessId
  **/
  @ApiModelProperty(example = "52bea969-78a2-4f7e-ae84-fb4599dc06ca", required = true, value = "The UUID of the access granted to a file system instance to be deletd")
  public String getAccessId() {
    return accessId;
  }

  public void setAccessId(String accessId) {
    this.accessId = accessId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeleteFileSystemGrantRequestSchemaGrant deleteFileSystemGrantRequestSchemaGrant = (DeleteFileSystemGrantRequestSchemaGrant) o;
    return Objects.equals(this.accessId, deleteFileSystemGrantRequestSchemaGrant.accessId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteFileSystemGrantRequestSchemaGrant {\n");
    
    sb.append("    accessId: ").append(toIndentedString(accessId)).append("\n");
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

