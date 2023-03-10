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
 * DescribeKeyPairsRequestSchema
 */

public class DescribeKeyPairsRequestSchema {
  @JsonProperty("KeyName.N")
  private List<String> keyNameDotN = null;

  @JsonProperty("Nvl-MaxResults")
  private Integer nvlMaxResults = null;

  @JsonProperty("Nvl-NextToken")
  private String nvlNextToken = null;

  @JsonProperty("key-name.N")
  private List<String> keyNameN = null;

  @JsonProperty("owner-id.N")
  private List<String> ownerIdN = null;

  public DescribeKeyPairsRequestSchema keyNameDotN(List<String> keyNameDotN) {
    this.keyNameDotN = keyNameDotN;
    return this;
  }

  public DescribeKeyPairsRequestSchema addKeyNameDotNItem(String keyNameDotNItem) {
    if (this.keyNameDotN == null) {
      this.keyNameDotN = new ArrayList<>();
    }
    this.keyNameDotN.add(keyNameDotNItem);
    return this;
  }

   /**
   * keypair name
   * @return keyNameDotN
  **/
  @ApiModelProperty(value = "keypair name")
  public List<String> getKeyNameDotN() {
    return keyNameDotN;
  }

  public void setKeyNameDotN(List<String> keyNameDotN) {
    this.keyNameDotN = keyNameDotN;
  }

  public DescribeKeyPairsRequestSchema nvlMaxResults(Integer nvlMaxResults) {
    this.nvlMaxResults = nvlMaxResults;
    return this;
  }

   /**
   * 
   * @return nvlMaxResults
  **/
  @ApiModelProperty(value = "")
  public Integer getNvlMaxResults() {
    return nvlMaxResults;
  }

  public void setNvlMaxResults(Integer nvlMaxResults) {
    this.nvlMaxResults = nvlMaxResults;
  }

  public DescribeKeyPairsRequestSchema nvlNextToken(String nvlNextToken) {
    this.nvlNextToken = nvlNextToken;
    return this;
  }

   /**
   * 
   * @return nvlNextToken
  **/
  @ApiModelProperty(value = "")
  public String getNvlNextToken() {
    return nvlNextToken;
  }

  public void setNvlNextToken(String nvlNextToken) {
    this.nvlNextToken = nvlNextToken;
  }

  public DescribeKeyPairsRequestSchema keyNameN(List<String> keyNameN) {
    this.keyNameN = keyNameN;
    return this;
  }

  public DescribeKeyPairsRequestSchema addKeyNameNItem(String keyNameNItem) {
    if (this.keyNameN == null) {
      this.keyNameN = new ArrayList<>();
    }
    this.keyNameN.add(keyNameNItem);
    return this;
  }

   /**
   * keypair name
   * @return keyNameN
  **/
  @ApiModelProperty(value = "keypair name")
  public List<String> getKeyNameN() {
    return keyNameN;
  }

  public void setKeyNameN(List<String> keyNameN) {
    this.keyNameN = keyNameN;
  }

  public DescribeKeyPairsRequestSchema ownerIdN(List<String> ownerIdN) {
    this.ownerIdN = ownerIdN;
    return this;
  }

  public DescribeKeyPairsRequestSchema addOwnerIdNItem(String ownerIdNItem) {
    if (this.ownerIdN == null) {
      this.ownerIdN = new ArrayList<>();
    }
    this.ownerIdN.add(ownerIdNItem);
    return this;
  }

   /**
   * account ID of the keypair owner
   * @return ownerIdN
  **/
  @ApiModelProperty(value = "account ID of the keypair owner")
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
    DescribeKeyPairsRequestSchema describeKeyPairsRequestSchema = (DescribeKeyPairsRequestSchema) o;
    return Objects.equals(this.keyNameDotN, describeKeyPairsRequestSchema.keyNameDotN) &&
        Objects.equals(this.nvlMaxResults, describeKeyPairsRequestSchema.nvlMaxResults) &&
        Objects.equals(this.nvlNextToken, describeKeyPairsRequestSchema.nvlNextToken) &&
        Objects.equals(this.keyNameN, describeKeyPairsRequestSchema.keyNameN) &&
        Objects.equals(this.ownerIdN, describeKeyPairsRequestSchema.ownerIdN);
  }

  @Override
  public int hashCode() {
    return Objects.hash(keyNameDotN, nvlMaxResults, nvlNextToken, keyNameN, ownerIdN);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeKeyPairsRequestSchema {\n");
    
    sb.append("    keyNameDotN: ").append(toIndentedString(keyNameDotN)).append("\n");
    sb.append("    nvlMaxResults: ").append(toIndentedString(nvlMaxResults)).append("\n");
    sb.append("    nvlNextToken: ").append(toIndentedString(nvlNextToken)).append("\n");
    sb.append("    keyNameN: ").append(toIndentedString(keyNameN)).append("\n");
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

