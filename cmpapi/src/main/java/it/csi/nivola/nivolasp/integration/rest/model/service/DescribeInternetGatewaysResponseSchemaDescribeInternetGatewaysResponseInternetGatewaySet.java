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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseInternetGatewaySet
 */

public class DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseInternetGatewaySet {
  @JsonProperty("attachmentSet")
  private CreateInternetGatewayApiResponseSchemaCreateInternetGatewayResponseInternetGatewayAttachmentSet attachmentSet = null;

  @JsonProperty("internetGatewayId")
  private String internetGatewayId = null;

  @JsonProperty("nvl-name")
  private String nvlName = null;

  @JsonProperty("nvl-ownerAlias")
  private String nvlOwnerAlias = null;

  @JsonProperty("nvl-state")
  private String nvlState = null;

  @JsonProperty("ownerId")
  private String ownerId = null;

  @JsonProperty("tagSet")
  private List<DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseTagSet> tagSet = null;

  public DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseInternetGatewaySet attachmentSet(CreateInternetGatewayApiResponseSchemaCreateInternetGatewayResponseInternetGatewayAttachmentSet attachmentSet) {
    this.attachmentSet = attachmentSet;
    return this;
  }

   /**
   * Get attachmentSet
   * @return attachmentSet
  **/
  @ApiModelProperty(value = "")
  public CreateInternetGatewayApiResponseSchemaCreateInternetGatewayResponseInternetGatewayAttachmentSet getAttachmentSet() {
    return attachmentSet;
  }

  public void setAttachmentSet(CreateInternetGatewayApiResponseSchemaCreateInternetGatewayResponseInternetGatewayAttachmentSet attachmentSet) {
    this.attachmentSet = attachmentSet;
  }

  public DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseInternetGatewaySet internetGatewayId(String internetGatewayId) {
    this.internetGatewayId = internetGatewayId;
    return this;
  }

   /**
   * id of the gateway
   * @return internetGatewayId
  **/
  @ApiModelProperty(example = "12", required = true, value = "id of the gateway")
  public String getInternetGatewayId() {
    return internetGatewayId;
  }

  public void setInternetGatewayId(String internetGatewayId) {
    this.internetGatewayId = internetGatewayId;
  }

  public DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseInternetGatewaySet nvlName(String nvlName) {
    this.nvlName = nvlName;
    return this;
  }

   /**
   * Get nvlName
   * @return nvlName
  **/
  @ApiModelProperty(example = "test", value = "")
  public String getNvlName() {
    return nvlName;
  }

  public void setNvlName(String nvlName) {
    this.nvlName = nvlName;
  }

  public DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseInternetGatewaySet nvlOwnerAlias(String nvlOwnerAlias) {
    this.nvlOwnerAlias = nvlOwnerAlias;
    return this;
  }

   /**
   * Get nvlOwnerAlias
   * @return nvlOwnerAlias
  **/
  @ApiModelProperty(example = "test", value = "")
  public String getNvlOwnerAlias() {
    return nvlOwnerAlias;
  }

  public void setNvlOwnerAlias(String nvlOwnerAlias) {
    this.nvlOwnerAlias = nvlOwnerAlias;
  }

  public DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseInternetGatewaySet nvlState(String nvlState) {
    this.nvlState = nvlState;
    return this;
  }

   /**
   * state of the VPC (pending | available | transient | error)
   * @return nvlState
  **/
  @ApiModelProperty(example = "pending", value = "state of the VPC (pending | available | transient | error)")
  public String getNvlState() {
    return nvlState;
  }

  public void setNvlState(String nvlState) {
    this.nvlState = nvlState;
  }

  public DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseInternetGatewaySet ownerId(String ownerId) {
    this.ownerId = ownerId;
    return this;
  }

   /**
   * Get ownerId
   * @return ownerId
  **/
  @ApiModelProperty(example = "", required = true, value = "")
  public String getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(String ownerId) {
    this.ownerId = ownerId;
  }

  public DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseInternetGatewaySet tagSet(List<DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseTagSet> tagSet) {
    this.tagSet = tagSet;
    return this;
  }

  public DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseInternetGatewaySet addTagSetItem(DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseTagSet tagSetItem) {
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
  public List<DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseTagSet> getTagSet() {
    return tagSet;
  }

  public void setTagSet(List<DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseTagSet> tagSet) {
    this.tagSet = tagSet;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseInternetGatewaySet describeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseInternetGatewaySet = (DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseInternetGatewaySet) o;
    return Objects.equals(this.attachmentSet, describeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseInternetGatewaySet.attachmentSet) &&
        Objects.equals(this.internetGatewayId, describeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseInternetGatewaySet.internetGatewayId) &&
        Objects.equals(this.nvlName, describeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseInternetGatewaySet.nvlName) &&
        Objects.equals(this.nvlOwnerAlias, describeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseInternetGatewaySet.nvlOwnerAlias) &&
        Objects.equals(this.nvlState, describeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseInternetGatewaySet.nvlState) &&
        Objects.equals(this.ownerId, describeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseInternetGatewaySet.ownerId) &&
        Objects.equals(this.tagSet, describeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseInternetGatewaySet.tagSet);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attachmentSet, internetGatewayId, nvlName, nvlOwnerAlias, nvlState, ownerId, tagSet);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeInternetGatewaysResponseSchemaDescribeInternetGatewaysResponseInternetGatewaySet {\n");
    
    sb.append("    attachmentSet: ").append(toIndentedString(attachmentSet)).append("\n");
    sb.append("    internetGatewayId: ").append(toIndentedString(internetGatewayId)).append("\n");
    sb.append("    nvlName: ").append(toIndentedString(nvlName)).append("\n");
    sb.append("    nvlOwnerAlias: ").append(toIndentedString(nvlOwnerAlias)).append("\n");
    sb.append("    nvlState: ").append(toIndentedString(nvlState)).append("\n");
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
    sb.append("    tagSet: ").append(toIndentedString(tagSet)).append("\n");
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

