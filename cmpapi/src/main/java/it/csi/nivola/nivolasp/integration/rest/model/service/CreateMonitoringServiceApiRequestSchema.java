/*-
 * ========================LICENSE_START=================================
 * Api CMP
 * %%
 * Copyright (C) 2022 Regione Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | Regione Piemonte
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
 * CreateMonitoringServiceApiRequestSchema
 */

public class CreateMonitoringServiceApiRequestSchema {
  @JsonProperty("desc")
  private String desc = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("owner_id")
  private String ownerId = null;

  @JsonProperty("resource_desc")
  private String resourceDesc = null;

  @JsonProperty("service_def_id")
  private String serviceDefId = null;

  public CreateMonitoringServiceApiRequestSchema desc(String desc) {
    this.desc = desc;
    return this;
  }

   /**
   * Get desc
   * @return desc
  **/
  @ApiModelProperty(value = "")
  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public CreateMonitoringServiceApiRequestSchema name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreateMonitoringServiceApiRequestSchema ownerId(String ownerId) {
    this.ownerId = ownerId;
    return this;
  }

   /**
   * Get ownerId
   * @return ownerId
  **/
  @ApiModelProperty(required = true, value = "")
  public String getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(String ownerId) {
    this.ownerId = ownerId;
  }

  public CreateMonitoringServiceApiRequestSchema resourceDesc(String resourceDesc) {
    this.resourceDesc = resourceDesc;
    return this;
  }

   /**
   * Get resourceDesc
   * @return resourceDesc
  **/
  @ApiModelProperty(value = "")
  public String getResourceDesc() {
    return resourceDesc;
  }

  public void setResourceDesc(String resourceDesc) {
    this.resourceDesc = resourceDesc;
  }

  public CreateMonitoringServiceApiRequestSchema serviceDefId(String serviceDefId) {
    this.serviceDefId = serviceDefId;
    return this;
  }

   /**
   * Get serviceDefId
   * @return serviceDefId
  **/
  @ApiModelProperty(example = "", required = true, value = "")
  public String getServiceDefId() {
    return serviceDefId;
  }

  public void setServiceDefId(String serviceDefId) {
    this.serviceDefId = serviceDefId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateMonitoringServiceApiRequestSchema createMonitoringServiceApiRequestSchema = (CreateMonitoringServiceApiRequestSchema) o;
    return Objects.equals(this.desc, createMonitoringServiceApiRequestSchema.desc) &&
        Objects.equals(this.name, createMonitoringServiceApiRequestSchema.name) &&
        Objects.equals(this.ownerId, createMonitoringServiceApiRequestSchema.ownerId) &&
        Objects.equals(this.resourceDesc, createMonitoringServiceApiRequestSchema.resourceDesc) &&
        Objects.equals(this.serviceDefId, createMonitoringServiceApiRequestSchema.serviceDefId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(desc, name, ownerId, resourceDesc, serviceDefId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateMonitoringServiceApiRequestSchema {\n");
    
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
    sb.append("    resourceDesc: ").append(toIndentedString(resourceDesc)).append("\n");
    sb.append("    serviceDefId: ").append(toIndentedString(serviceDefId)).append("\n");
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

