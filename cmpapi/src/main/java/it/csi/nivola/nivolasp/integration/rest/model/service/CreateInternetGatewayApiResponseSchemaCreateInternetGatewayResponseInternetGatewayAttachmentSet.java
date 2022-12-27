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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Any VPCs attached to the internet gateway
 */
@ApiModel(description = "Any VPCs attached to the internet gateway")

public class CreateInternetGatewayApiResponseSchemaCreateInternetGatewayResponseInternetGatewayAttachmentSet {
  @JsonProperty("nvl-vpcName")
  private String nvlVpcName = null;

  @JsonProperty("state")
  private String state = null;

  @JsonProperty("vpcId")
  private String vpcId = null;

  public CreateInternetGatewayApiResponseSchemaCreateInternetGatewayResponseInternetGatewayAttachmentSet nvlVpcName(String nvlVpcName) {
    this.nvlVpcName = nvlVpcName;
    return this;
  }

   /**
   * name of the vpc
   * @return nvlVpcName
  **/
  @ApiModelProperty(example = "vpc1", value = "name of the vpc")
  public String getNvlVpcName() {
    return nvlVpcName;
  }

  public void setNvlVpcName(String nvlVpcName) {
    this.nvlVpcName = nvlVpcName;
  }

  public CreateInternetGatewayApiResponseSchemaCreateInternetGatewayResponseInternetGatewayAttachmentSet state(String state) {
    this.state = state;
    return this;
  }

   /**
   * the current state of the attachment. For an internet gateway, the state is available when attached to a VPC; otherwise, this value is not returned.
   * @return state
  **/
  @ApiModelProperty(example = "account1", required = true, value = "the current state of the attachment. For an internet gateway, the state is available when attached to a VPC; otherwise, this value is not returned.")
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public CreateInternetGatewayApiResponseSchemaCreateInternetGatewayResponseInternetGatewayAttachmentSet vpcId(String vpcId) {
    this.vpcId = vpcId;
    return this;
  }

   /**
   * id of the vpc
   * @return vpcId
  **/
  @ApiModelProperty(example = "eur89", required = true, value = "id of the vpc")
  public String getVpcId() {
    return vpcId;
  }

  public void setVpcId(String vpcId) {
    this.vpcId = vpcId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateInternetGatewayApiResponseSchemaCreateInternetGatewayResponseInternetGatewayAttachmentSet createInternetGatewayApiResponseSchemaCreateInternetGatewayResponseInternetGatewayAttachmentSet = (CreateInternetGatewayApiResponseSchemaCreateInternetGatewayResponseInternetGatewayAttachmentSet) o;
    return Objects.equals(this.nvlVpcName, createInternetGatewayApiResponseSchemaCreateInternetGatewayResponseInternetGatewayAttachmentSet.nvlVpcName) &&
        Objects.equals(this.state, createInternetGatewayApiResponseSchemaCreateInternetGatewayResponseInternetGatewayAttachmentSet.state) &&
        Objects.equals(this.vpcId, createInternetGatewayApiResponseSchemaCreateInternetGatewayResponseInternetGatewayAttachmentSet.vpcId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nvlVpcName, state, vpcId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateInternetGatewayApiResponseSchemaCreateInternetGatewayResponseInternetGatewayAttachmentSet {\n");
    
    sb.append("    nvlVpcName: ").append(toIndentedString(nvlVpcName)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    vpcId: ").append(toIndentedString(vpcId)).append("\n");
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

