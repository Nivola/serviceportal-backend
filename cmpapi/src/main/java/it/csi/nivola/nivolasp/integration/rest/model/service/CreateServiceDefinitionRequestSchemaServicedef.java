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
 * CreateServiceDefinitionRequestSchemaServicedef
 */

public class CreateServiceDefinitionRequestSchemaServicedef {
  @JsonProperty("active")
  private Boolean active = null;

  @JsonProperty("desc")
  private String desc = null;

  @JsonProperty("is_default")
  private Boolean isDefault = false;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("parent_id")
  private String parentId = null;

  @JsonProperty("priority")
  private Integer priority = null;

  @JsonProperty("service_type_id")
  private String serviceTypeId = null;

  @JsonProperty("status")
  private String status = "ACTIVE";

  @JsonProperty("version")
  private String version = null;

  public CreateServiceDefinitionRequestSchemaServicedef active(Boolean active) {
    this.active = active;
    return this;
  }

   /**
   * Get active
   * @return active
  **/
  @ApiModelProperty(value = "")
  public Boolean isActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public CreateServiceDefinitionRequestSchemaServicedef desc(String desc) {
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

  public CreateServiceDefinitionRequestSchemaServicedef isDefault(Boolean isDefault) {
    this.isDefault = isDefault;
    return this;
  }

   /**
   * Get isDefault
   * @return isDefault
  **/
  @ApiModelProperty(value = "")
  public Boolean isIsDefault() {
    return isDefault;
  }

  public void setIsDefault(Boolean isDefault) {
    this.isDefault = isDefault;
  }

  public CreateServiceDefinitionRequestSchemaServicedef name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreateServiceDefinitionRequestSchemaServicedef parentId(String parentId) {
    this.parentId = parentId;
    return this;
  }

   /**
   * Get parentId
   * @return parentId
  **/
  @ApiModelProperty(value = "")
  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public CreateServiceDefinitionRequestSchemaServicedef priority(Integer priority) {
    this.priority = priority;
    return this;
  }

   /**
   * Get priority
   * @return priority
  **/
  @ApiModelProperty(value = "")
  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public CreateServiceDefinitionRequestSchemaServicedef serviceTypeId(String serviceTypeId) {
    this.serviceTypeId = serviceTypeId;
    return this;
  }

   /**
   * Get serviceTypeId
   * @return serviceTypeId
  **/
  @ApiModelProperty(required = true, value = "")
  public String getServiceTypeId() {
    return serviceTypeId;
  }

  public void setServiceTypeId(String serviceTypeId) {
    this.serviceTypeId = serviceTypeId;
  }

  public CreateServiceDefinitionRequestSchemaServicedef status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public CreateServiceDefinitionRequestSchemaServicedef version(String version) {
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @ApiModelProperty(required = true, value = "")
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateServiceDefinitionRequestSchemaServicedef createServiceDefinitionRequestSchemaServicedef = (CreateServiceDefinitionRequestSchemaServicedef) o;
    return Objects.equals(this.active, createServiceDefinitionRequestSchemaServicedef.active) &&
        Objects.equals(this.desc, createServiceDefinitionRequestSchemaServicedef.desc) &&
        Objects.equals(this.isDefault, createServiceDefinitionRequestSchemaServicedef.isDefault) &&
        Objects.equals(this.name, createServiceDefinitionRequestSchemaServicedef.name) &&
        Objects.equals(this.parentId, createServiceDefinitionRequestSchemaServicedef.parentId) &&
        Objects.equals(this.priority, createServiceDefinitionRequestSchemaServicedef.priority) &&
        Objects.equals(this.serviceTypeId, createServiceDefinitionRequestSchemaServicedef.serviceTypeId) &&
        Objects.equals(this.status, createServiceDefinitionRequestSchemaServicedef.status) &&
        Objects.equals(this.version, createServiceDefinitionRequestSchemaServicedef.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, desc, isDefault, name, parentId, priority, serviceTypeId, status, version);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateServiceDefinitionRequestSchemaServicedef {\n");
    
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    isDefault: ").append(toIndentedString(isDefault)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    serviceTypeId: ").append(toIndentedString(serviceTypeId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

