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
 * CreateFolderApiRequestSchemaFolder
 */

public class CreateFolderApiRequestSchemaFolder {
  @JsonProperty("AdditionalInfo")
  private String additionalInfo = null;

  @JsonProperty("Name")
  private String name = null;

  @JsonProperty("definition")
  private String definition = null;

  @JsonProperty("owner-id")
  private String ownerId = null;

  public CreateFolderApiRequestSchemaFolder additionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

   /**
   * folder description
   * @return additionalInfo
  **/
  @ApiModelProperty(example = "test", value = "folder description")
  public String getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public CreateFolderApiRequestSchemaFolder name(String name) {
    this.name = name;
    return this;
  }

   /**
   * folder name
   * @return name
  **/
  @ApiModelProperty(example = "test", value = "folder name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreateFolderApiRequestSchemaFolder definition(String definition) {
    this.definition = definition;
    return this;
  }

   /**
   * service definition of the folder
   * @return definition
  **/
  @ApiModelProperty(example = "monitoring.folder.xxx", value = "service definition of the folder")
  public String getDefinition() {
    return definition;
  }

  public void setDefinition(String definition) {
    this.definition = definition;
  }

  public CreateFolderApiRequestSchemaFolder ownerId(String ownerId) {
    this.ownerId = ownerId;
    return this;
  }

   /**
   * account id or uuid associated to compute zone
   * @return ownerId
  **/
  @ApiModelProperty(example = "1", required = true, value = "account id or uuid associated to compute zone")
  public String getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(String ownerId) {
    this.ownerId = ownerId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateFolderApiRequestSchemaFolder createFolderApiRequestSchemaFolder = (CreateFolderApiRequestSchemaFolder) o;
    return Objects.equals(this.additionalInfo, createFolderApiRequestSchemaFolder.additionalInfo) &&
        Objects.equals(this.name, createFolderApiRequestSchemaFolder.name) &&
        Objects.equals(this.definition, createFolderApiRequestSchemaFolder.definition) &&
        Objects.equals(this.ownerId, createFolderApiRequestSchemaFolder.ownerId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInfo, name, definition, ownerId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateFolderApiRequestSchemaFolder {\n");
    
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    definition: ").append(toIndentedString(definition)).append("\n");
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
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

