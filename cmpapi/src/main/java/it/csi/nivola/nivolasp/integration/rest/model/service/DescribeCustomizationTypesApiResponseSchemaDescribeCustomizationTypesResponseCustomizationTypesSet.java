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
 * DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseCustomizationTypesSet
 */

public class DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseCustomizationTypesSet {
  @JsonProperty("args")
  private DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseArgs args = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("uuid")
  private String uuid = null;

  public DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseCustomizationTypesSet args(DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseArgs args) {
    this.args = args;
    return this;
  }

   /**
   * Get args
   * @return args
  **/
  @ApiModelProperty(value = "")
  public DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseArgs getArgs() {
    return args;
  }

  public void setArgs(DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseArgs args) {
    this.args = args;
  }

  public DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseCustomizationTypesSet description(String description) {
    this.description = description;
    return this;
  }

   /**
   * customization type description
   * @return description
  **/
  @ApiModelProperty(example = "", required = true, value = "customization type description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseCustomizationTypesSet id(String id) {
    this.id = id;
    return this;
  }

   /**
   * customization type id
   * @return id
  **/
  @ApiModelProperty(example = "", required = true, value = "customization type id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseCustomizationTypesSet name(String name) {
    this.name = name;
    return this;
  }

   /**
   * customization type name
   * @return name
  **/
  @ApiModelProperty(example = "", required = true, value = "customization type name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseCustomizationTypesSet uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * customization type uuid
   * @return uuid
  **/
  @ApiModelProperty(example = "", required = true, value = "customization type uuid")
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseCustomizationTypesSet describeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseCustomizationTypesSet = (DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseCustomizationTypesSet) o;
    return Objects.equals(this.args, describeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseCustomizationTypesSet.args) &&
        Objects.equals(this.description, describeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseCustomizationTypesSet.description) &&
        Objects.equals(this.id, describeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseCustomizationTypesSet.id) &&
        Objects.equals(this.name, describeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseCustomizationTypesSet.name) &&
        Objects.equals(this.uuid, describeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseCustomizationTypesSet.uuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(args, description, id, name, uuid);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeCustomizationTypesApiResponseSchemaDescribeCustomizationTypesResponseCustomizationTypesSet {\n");
    
    sb.append("    args: ").append(toIndentedString(args)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
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

