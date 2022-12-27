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
 * CreateTagRequestSchemaTag
 */

public class CreateTagRequestSchemaTag {
  @JsonProperty("account")
  private String account = null;

  @JsonProperty("value")
  private String value = null;

  public CreateTagRequestSchemaTag account(String account) {
    this.account = account;
    return this;
  }

   /**
   * Account id or uuid related to tag
   * @return account
  **/
  @ApiModelProperty(required = true, value = "Account id or uuid related to tag")
  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public CreateTagRequestSchemaTag value(String value) {
    this.value = value;
    return this;
  }

   /**
   * Get value
   * @return value
  **/
  @ApiModelProperty(required = true, value = "")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateTagRequestSchemaTag createTagRequestSchemaTag = (CreateTagRequestSchemaTag) o;
    return Objects.equals(this.account, createTagRequestSchemaTag.account) &&
        Objects.equals(this.value, createTagRequestSchemaTag.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(account, value);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateTagRequestSchemaTag {\n");
    
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

