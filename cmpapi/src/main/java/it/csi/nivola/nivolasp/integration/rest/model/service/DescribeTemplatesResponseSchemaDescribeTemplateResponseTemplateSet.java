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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * DescribeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet
 */

public class DescribeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet {
  @JsonProperty("creationDate")
  private LocalDateTime creationDate = null;

  @JsonProperty("desc")
  private String desc = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("resource_id")
  private String resourceId = null;

  /**
   * state of template
   */
  public enum StateEnum {
    PENDING("pending"),
    
    AVAILABLE("available"),
    
    INVALID("invalid"),
    
    DEREGISTERED("deregistered"),
    
    TRANSIENT("transient"),
    
    FAILED("failed"),
    
    ERROR("error");

    private String value;

    StateEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StateEnum fromValue(String text) {
      for (StateEnum b : StateEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("state")
  private StateEnum state = null;

  @JsonProperty("stateReason")
  private DescribeImagesResponseSchemaDescribeImagesResponseStateReason stateReason = null;

  @JsonProperty("tagSet")
  private List<DescribeImagesResponseSchemaDescribeImagesResponseTagSet> tagSet = null;

  @JsonProperty("template_id")
  private String templateId = null;

  @JsonProperty("template_owner_id")
  private String templateOwnerId = null;

  @JsonProperty("template_owner_name")
  private String templateOwnerName = null;

  public DescribeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet creationDate(LocalDateTime creationDate) {
    this.creationDate = creationDate;
    return this;
  }

   /**
   * template date creation
   * @return creationDate
  **/
  @ApiModelProperty(example = "", value = "template date creation")
  public LocalDateTime getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDateTime creationDate) {
    this.creationDate = creationDate;
  }

  public DescribeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet desc(String desc) {
    this.desc = desc;
    return this;
  }

   /**
   * template description
   * @return desc
  **/
  @ApiModelProperty(example = "", value = "template description")
  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public DescribeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet name(String name) {
    this.name = name;
    return this;
  }

   /**
   * template name
   * @return name
  **/
  @ApiModelProperty(example = "", value = "template name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DescribeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet resourceId(String resourceId) {
    this.resourceId = resourceId;
    return this;
  }

   /**
   * resource id
   * @return resourceId
  **/
  @ApiModelProperty(example = "", value = "resource id")
  public String getResourceId() {
    return resourceId;
  }

  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }

  public DescribeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet state(StateEnum state) {
    this.state = state;
    return this;
  }

   /**
   * state of template
   * @return state
  **/
  @ApiModelProperty(example = "", value = "state of template")
  public StateEnum getState() {
    return state;
  }

  public void setState(StateEnum state) {
    this.state = state;
  }

  public DescribeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet stateReason(DescribeImagesResponseSchemaDescribeImagesResponseStateReason stateReason) {
    this.stateReason = stateReason;
    return this;
  }

   /**
   * Get stateReason
   * @return stateReason
  **/
  @ApiModelProperty(value = "")
  public DescribeImagesResponseSchemaDescribeImagesResponseStateReason getStateReason() {
    return stateReason;
  }

  public void setStateReason(DescribeImagesResponseSchemaDescribeImagesResponseStateReason stateReason) {
    this.stateReason = stateReason;
  }

  public DescribeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet tagSet(List<DescribeImagesResponseSchemaDescribeImagesResponseTagSet> tagSet) {
    this.tagSet = tagSet;
    return this;
  }

  public DescribeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet addTagSetItem(DescribeImagesResponseSchemaDescribeImagesResponseTagSet tagSetItem) {
    if (this.tagSet == null) {
      this.tagSet = new ArrayList<>();
    }
    this.tagSet.add(tagSetItem);
    return this;
  }

   /**
   * Get tagSet
   * @return tagSet
  **/
  @ApiModelProperty(value = "")
  public List<DescribeImagesResponseSchemaDescribeImagesResponseTagSet> getTagSet() {
    return tagSet;
  }

  public void setTagSet(List<DescribeImagesResponseSchemaDescribeImagesResponseTagSet> tagSet) {
    this.tagSet = tagSet;
  }

  public DescribeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet templateId(String templateId) {
    this.templateId = templateId;
    return this;
  }

   /**
   * template instance id
   * @return templateId
  **/
  @ApiModelProperty(example = "", value = "template instance id")
  public String getTemplateId() {
    return templateId;
  }

  public void setTemplateId(String templateId) {
    this.templateId = templateId;
  }

  public DescribeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet templateOwnerId(String templateOwnerId) {
    this.templateOwnerId = templateOwnerId;
    return this;
  }

   /**
   * template instance id
   * @return templateOwnerId
  **/
  @ApiModelProperty(example = "", value = "template instance id")
  public String getTemplateOwnerId() {
    return templateOwnerId;
  }

  public void setTemplateOwnerId(String templateOwnerId) {
    this.templateOwnerId = templateOwnerId;
  }

  public DescribeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet templateOwnerName(String templateOwnerName) {
    this.templateOwnerName = templateOwnerName;
    return this;
  }

   /**
   * template instance id
   * @return templateOwnerName
  **/
  @ApiModelProperty(example = "", value = "template instance id")
  public String getTemplateOwnerName() {
    return templateOwnerName;
  }

  public void setTemplateOwnerName(String templateOwnerName) {
    this.templateOwnerName = templateOwnerName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet describeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet = (DescribeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet) o;
    return Objects.equals(this.creationDate, describeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet.creationDate) &&
        Objects.equals(this.desc, describeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet.desc) &&
        Objects.equals(this.name, describeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet.name) &&
        Objects.equals(this.resourceId, describeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet.resourceId) &&
        Objects.equals(this.state, describeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet.state) &&
        Objects.equals(this.stateReason, describeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet.stateReason) &&
        Objects.equals(this.tagSet, describeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet.tagSet) &&
        Objects.equals(this.templateId, describeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet.templateId) &&
        Objects.equals(this.templateOwnerId, describeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet.templateOwnerId) &&
        Objects.equals(this.templateOwnerName, describeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet.templateOwnerName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creationDate, desc, name, resourceId, state, stateReason, tagSet, templateId, templateOwnerId, templateOwnerName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeTemplatesResponseSchemaDescribeTemplateResponseTemplateSet {\n");
    
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    resourceId: ").append(toIndentedString(resourceId)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    stateReason: ").append(toIndentedString(stateReason)).append("\n");
    sb.append("    tagSet: ").append(toIndentedString(tagSet)).append("\n");
    sb.append("    templateId: ").append(toIndentedString(templateId)).append("\n");
    sb.append("    templateOwnerId: ").append(toIndentedString(templateOwnerId)).append("\n");
    sb.append("    templateOwnerName: ").append(toIndentedString(templateOwnerName)).append("\n");
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
