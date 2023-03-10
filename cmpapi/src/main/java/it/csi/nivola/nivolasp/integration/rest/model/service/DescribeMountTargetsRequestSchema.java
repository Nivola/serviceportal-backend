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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * DescribeMountTargetsRequestSchema
 */

public class DescribeMountTargetsRequestSchema {
  @JsonProperty("FileSystemId")
  private String fileSystemId = null;

  @JsonProperty("Marker")
  private String marker = "0";

  @JsonProperty("MaxItems")
  private Integer maxItems = null;

  @JsonProperty("owner-id.N")
  private List<String> ownerIdN = null;

  public DescribeMountTargetsRequestSchema fileSystemId(String fileSystemId) {
    this.fileSystemId = fileSystemId;
    return this;
  }

   /**
   * file system ID
   * @return fileSystemId
  **/
  @ApiModelProperty(example = "", value = "file system ID")
  public String getFileSystemId() {
    return fileSystemId;
  }

  public void setFileSystemId(String fileSystemId) {
    this.fileSystemId = fileSystemId;
  }

  public DescribeMountTargetsRequestSchema marker(String marker) {
    this.marker = marker;
    return this;
  }

   /**
   * pagination token
   * @return marker
  **/
  @ApiModelProperty(example = "", value = "pagination token")
  public String getMarker() {
    return marker;
  }

  public void setMarker(String marker) {
    this.marker = marker;
  }

  public DescribeMountTargetsRequestSchema maxItems(Integer maxItems) {
    this.maxItems = maxItems;
    return this;
  }

   /**
   * max number elements to return in the response
   * @return maxItems
  **/
  @ApiModelProperty(value = "max number elements to return in the response")
  public Integer getMaxItems() {
    return maxItems;
  }

  public void setMaxItems(Integer maxItems) {
    this.maxItems = maxItems;
  }

  public DescribeMountTargetsRequestSchema ownerIdN(List<String> ownerIdN) {
    this.ownerIdN = ownerIdN;
    return this;
  }

  public DescribeMountTargetsRequestSchema addOwnerIdNItem(String ownerIdNItem) {
    if (this.ownerIdN == null) {
      this.ownerIdN = new ArrayList<>();
    }
    this.ownerIdN.add(ownerIdNItem);
    return this;
  }

   /**
   * Get ownerIdN
   * @return ownerIdN
  **/
  @ApiModelProperty(value = "")
  public List<String> getOwnerIdN() {
    return ownerIdN;
  }

  public void setOwnerIdN(List<String> ownerIdN) {
    this.ownerIdN = ownerIdN;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeMountTargetsRequestSchema describeMountTargetsRequestSchema = (DescribeMountTargetsRequestSchema) o;
    return Objects.equals(this.fileSystemId, describeMountTargetsRequestSchema.fileSystemId) &&
        Objects.equals(this.marker, describeMountTargetsRequestSchema.marker) &&
        Objects.equals(this.maxItems, describeMountTargetsRequestSchema.maxItems) &&
        Objects.equals(this.ownerIdN, describeMountTargetsRequestSchema.ownerIdN);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fileSystemId, marker, maxItems, ownerIdN);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeMountTargetsRequestSchema {\n");
    
    sb.append("    fileSystemId: ").append(toIndentedString(fileSystemId)).append("\n");
    sb.append("    marker: ").append(toIndentedString(marker)).append("\n");
    sb.append("    maxItems: ").append(toIndentedString(maxItems)).append("\n");
    sb.append("    ownerIdN: ").append(toIndentedString(ownerIdN)).append("\n");
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

