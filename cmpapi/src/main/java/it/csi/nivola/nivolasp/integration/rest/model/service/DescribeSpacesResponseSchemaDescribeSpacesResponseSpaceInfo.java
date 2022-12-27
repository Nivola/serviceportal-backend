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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * DescribeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo
 */

public class DescribeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo {
  @JsonProperty("creationDate")
  private LocalDateTime creationDate = null;

  @JsonProperty("dashboards")
  private List<DescribeSpacesResponseSchemaDescribeSpacesResponseDashboards> dashboards = new ArrayList<>();

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("endpoints")
  private DescribeSpacesResponseSchemaDescribeSpacesResponseEndpoints endpoints = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("ownerAlias")
  private String ownerAlias = null;

  @JsonProperty("ownerId")
  private String ownerId = null;

  @JsonProperty("state")
  private String state = null;

  @JsonProperty("stateReason")
  private DescribeSpacesResponseSchemaDescribeSpacesResponseStateReason stateReason = null;

  @JsonProperty("templateId")
  private String templateId = null;

  @JsonProperty("templateName")
  private String templateName = null;

  public DescribeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo creationDate(LocalDateTime creationDate) {
    this.creationDate = creationDate;
    return this;
  }

   /**
   * creation date
   * @return creationDate
  **/
  @ApiModelProperty(example = "2022-01-25T11:20:18Z", required = true, value = "creation date")
  public LocalDateTime getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDateTime creationDate) {
    this.creationDate = creationDate;
  }

  public DescribeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo dashboards(List<DescribeSpacesResponseSchemaDescribeSpacesResponseDashboards> dashboards) {
    this.dashboards = dashboards;
    return this;
  }

  public DescribeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo addDashboardsItem(DescribeSpacesResponseSchemaDescribeSpacesResponseDashboards dashboardsItem) {
    this.dashboards.add(dashboardsItem);
    return this;
  }

   /**
   * Get dashboards
   * @return dashboards
  **/
  @ApiModelProperty(required = true, value = "")
  public List<DescribeSpacesResponseSchemaDescribeSpacesResponseDashboards> getDashboards() {
    return dashboards;
  }

  public void setDashboards(List<DescribeSpacesResponseSchemaDescribeSpacesResponseDashboards> dashboards) {
    this.dashboards = dashboards;
  }

  public DescribeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo description(String description) {
    this.description = description;
    return this;
  }

   /**
   * description of the space
   * @return description
  **/
  @ApiModelProperty(example = "test", required = true, value = "description of the space")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public DescribeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo endpoints(DescribeSpacesResponseSchemaDescribeSpacesResponseEndpoints endpoints) {
    this.endpoints = endpoints;
    return this;
  }

   /**
   * Get endpoints
   * @return endpoints
  **/
  @ApiModelProperty(required = true, value = "")
  public DescribeSpacesResponseSchemaDescribeSpacesResponseEndpoints getEndpoints() {
    return endpoints;
  }

  public void setEndpoints(DescribeSpacesResponseSchemaDescribeSpacesResponseEndpoints endpoints) {
    this.endpoints = endpoints;
  }

  public DescribeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo id(String id) {
    this.id = id;
    return this;
  }

   /**
   * id of the space
   * @return id
  **/
  @ApiModelProperty(example = "075df680-2560-421c-aeaa-8258a6b733f0", required = true, value = "id of the space")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public DescribeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo name(String name) {
    this.name = name;
    return this;
  }

   /**
   * name of the space
   * @return name
  **/
  @ApiModelProperty(example = "test", required = true, value = "name of the space")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DescribeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo ownerAlias(String ownerAlias) {
    this.ownerAlias = ownerAlias;
    return this;
  }

   /**
   * account name of the owner of the space
   * @return ownerAlias
  **/
  @ApiModelProperty(example = "test", required = true, value = "account name of the owner of the space")
  public String getOwnerAlias() {
    return ownerAlias;
  }

  public void setOwnerAlias(String ownerAlias) {
    this.ownerAlias = ownerAlias;
  }

  public DescribeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo ownerId(String ownerId) {
    this.ownerId = ownerId;
    return this;
  }

   /**
   * account id of the owner of the space
   * @return ownerId
  **/
  @ApiModelProperty(example = "075df680-2560-421c-aeaa-8258a6b733f0", required = true, value = "account id of the owner of the space")
  public String getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(String ownerId) {
    this.ownerId = ownerId;
  }

  public DescribeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo state(String state) {
    this.state = state;
    return this;
  }

   /**
   * state of the space
   * @return state
  **/
  @ApiModelProperty(example = "available", required = true, value = "state of the space")
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public DescribeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo stateReason(DescribeSpacesResponseSchemaDescribeSpacesResponseStateReason stateReason) {
    this.stateReason = stateReason;
    return this;
  }

   /**
   * Get stateReason
   * @return stateReason
  **/
  @ApiModelProperty(required = true, value = "")
  public DescribeSpacesResponseSchemaDescribeSpacesResponseStateReason getStateReason() {
    return stateReason;
  }

  public void setStateReason(DescribeSpacesResponseSchemaDescribeSpacesResponseStateReason stateReason) {
    this.stateReason = stateReason;
  }

  public DescribeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo templateId(String templateId) {
    this.templateId = templateId;
    return this;
  }

   /**
   * id of the space template
   * @return templateId
  **/
  @ApiModelProperty(example = "075df680-2560-421c-aeaa-8258a6b733f0", required = true, value = "id of the space template")
  public String getTemplateId() {
    return templateId;
  }

  public void setTemplateId(String templateId) {
    this.templateId = templateId;
  }

  public DescribeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo templateName(String templateName) {
    this.templateName = templateName;
    return this;
  }

   /**
   * name of the space template
   * @return templateName
  **/
  @ApiModelProperty(example = "test", required = true, value = "name of the space template")
  public String getTemplateName() {
    return templateName;
  }

  public void setTemplateName(String templateName) {
    this.templateName = templateName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo describeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo = (DescribeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo) o;
    return Objects.equals(this.creationDate, describeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo.creationDate) &&
        Objects.equals(this.dashboards, describeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo.dashboards) &&
        Objects.equals(this.description, describeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo.description) &&
        Objects.equals(this.endpoints, describeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo.endpoints) &&
        Objects.equals(this.id, describeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo.id) &&
        Objects.equals(this.name, describeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo.name) &&
        Objects.equals(this.ownerAlias, describeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo.ownerAlias) &&
        Objects.equals(this.ownerId, describeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo.ownerId) &&
        Objects.equals(this.state, describeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo.state) &&
        Objects.equals(this.stateReason, describeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo.stateReason) &&
        Objects.equals(this.templateId, describeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo.templateId) &&
        Objects.equals(this.templateName, describeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo.templateName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creationDate, dashboards, description, endpoints, id, name, ownerAlias, ownerId, state, stateReason, templateId, templateName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo {\n");
    
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    dashboards: ").append(toIndentedString(dashboards)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    endpoints: ").append(toIndentedString(endpoints)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ownerAlias: ").append(toIndentedString(ownerAlias)).append("\n");
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    stateReason: ").append(toIndentedString(stateReason)).append("\n");
    sb.append("    templateId: ").append(toIndentedString(templateId)).append("\n");
    sb.append("    templateName: ").append(toIndentedString(templateName)).append("\n");
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
