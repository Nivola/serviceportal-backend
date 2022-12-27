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
 * DescribeVpcsResponseSchemaDescribeVpcsResponseCidrBlockAssociationSet
 */

public class DescribeVpcsResponseSchemaDescribeVpcsResponseCidrBlockAssociationSet {
  @JsonProperty("associationId")
  private String associationId = null;

  @JsonProperty("cidrBlock")
  private String cidrBlock = null;

  @JsonProperty("cidrBlockState")
  private DescribeVpcsResponseSchemaDescribeVpcsResponseCidrBlockState cidrBlockState = null;

  public DescribeVpcsResponseSchemaDescribeVpcsResponseCidrBlockAssociationSet associationId(String associationId) {
    this.associationId = associationId;
    return this;
  }

   /**
   * association ID for the IPv4 CIDR block
   * @return associationId
  **/
  @ApiModelProperty(example = "", value = "association ID for the IPv4 CIDR block")
  public String getAssociationId() {
    return associationId;
  }

  public void setAssociationId(String associationId) {
    this.associationId = associationId;
  }

  public DescribeVpcsResponseSchemaDescribeVpcsResponseCidrBlockAssociationSet cidrBlock(String cidrBlock) {
    this.cidrBlock = cidrBlock;
    return this;
  }

   /**
   * IPv4 CIDR block
   * @return cidrBlock
  **/
  @ApiModelProperty(example = "", value = "IPv4 CIDR block")
  public String getCidrBlock() {
    return cidrBlock;
  }

  public void setCidrBlock(String cidrBlock) {
    this.cidrBlock = cidrBlock;
  }

  public DescribeVpcsResponseSchemaDescribeVpcsResponseCidrBlockAssociationSet cidrBlockState(DescribeVpcsResponseSchemaDescribeVpcsResponseCidrBlockState cidrBlockState) {
    this.cidrBlockState = cidrBlockState;
    return this;
  }

   /**
   * Get cidrBlockState
   * @return cidrBlockState
  **/
  @ApiModelProperty(value = "")
  public DescribeVpcsResponseSchemaDescribeVpcsResponseCidrBlockState getCidrBlockState() {
    return cidrBlockState;
  }

  public void setCidrBlockState(DescribeVpcsResponseSchemaDescribeVpcsResponseCidrBlockState cidrBlockState) {
    this.cidrBlockState = cidrBlockState;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeVpcsResponseSchemaDescribeVpcsResponseCidrBlockAssociationSet describeVpcsResponseSchemaDescribeVpcsResponseCidrBlockAssociationSet = (DescribeVpcsResponseSchemaDescribeVpcsResponseCidrBlockAssociationSet) o;
    return Objects.equals(this.associationId, describeVpcsResponseSchemaDescribeVpcsResponseCidrBlockAssociationSet.associationId) &&
        Objects.equals(this.cidrBlock, describeVpcsResponseSchemaDescribeVpcsResponseCidrBlockAssociationSet.cidrBlock) &&
        Objects.equals(this.cidrBlockState, describeVpcsResponseSchemaDescribeVpcsResponseCidrBlockAssociationSet.cidrBlockState);
  }

  @Override
  public int hashCode() {
    return Objects.hash(associationId, cidrBlock, cidrBlockState);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeVpcsResponseSchemaDescribeVpcsResponseCidrBlockAssociationSet {\n");
    
    sb.append("    associationId: ").append(toIndentedString(associationId)).append("\n");
    sb.append("    cidrBlock: ").append(toIndentedString(cidrBlock)).append("\n");
    sb.append("    cidrBlockState: ").append(toIndentedString(cidrBlockState)).append("\n");
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

