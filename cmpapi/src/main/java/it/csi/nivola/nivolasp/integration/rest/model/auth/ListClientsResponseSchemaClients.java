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
 * API description in Markdown.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: me@csi.it
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package it.csi.nivola.nivolasp.integration.rest.model.auth;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ListClientsResponseSchemaClients
 */

public class ListClientsResponseSchemaClients {
  @JsonProperty("__meta__")
  private GetClientResponseSchemaClientMeta_ meta_ = null;

  @JsonProperty("active")
  private Boolean active = null;

  @JsonProperty("date")
  private GetClientResponseSchemaClientDate date = null;

  @JsonProperty("desc")
  private String desc = null;

  @JsonProperty("grant_type")
  private String grantType = null;

  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("response_type")
  private String responseType = null;

  @JsonProperty("scopes")
  private String scopes = null;

  @JsonProperty("uuid")
  private String uuid = null;

  public ListClientsResponseSchemaClients meta_(GetClientResponseSchemaClientMeta_ meta_) {
    this.meta_ = meta_;
    return this;
  }

   /**
   * Get meta_
   * @return meta_
  **/
  @ApiModelProperty(required = true, value = "")
  public GetClientResponseSchemaClientMeta_ getMeta_() {
    return meta_;
  }

  public void setMeta_(GetClientResponseSchemaClientMeta_ meta_) {
    this.meta_ = meta_;
  }

  public ListClientsResponseSchemaClients active(Boolean active) {
    this.active = active;
    return this;
  }

   /**
   * Get active
   * @return active
  **/
  @ApiModelProperty(example = "true", required = true, value = "")
  public Boolean isActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public ListClientsResponseSchemaClients date(GetClientResponseSchemaClientDate date) {
    this.date = date;
    return this;
  }

   /**
   * Get date
   * @return date
  **/
  @ApiModelProperty(required = true, value = "")
  public GetClientResponseSchemaClientDate getDate() {
    return date;
  }

  public void setDate(GetClientResponseSchemaClientDate date) {
    this.date = date;
  }

  public ListClientsResponseSchemaClients desc(String desc) {
    this.desc = desc;
    return this;
  }

   /**
   * Get desc
   * @return desc
  **/
  @ApiModelProperty(example = "test", required = true, value = "")
  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public ListClientsResponseSchemaClients grantType(String grantType) {
    this.grantType = grantType;
    return this;
  }

   /**
   * grant type
   * @return grantType
  **/
  @ApiModelProperty(example = "authorization_code", required = true, value = "grant type")
  public String getGrantType() {
    return grantType;
  }

  public void setGrantType(String grantType) {
    this.grantType = grantType;
  }

  public ListClientsResponseSchemaClients id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "10", required = true, value = "")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ListClientsResponseSchemaClients name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "test", required = true, value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ListClientsResponseSchemaClients responseType(String responseType) {
    this.responseType = responseType;
    return this;
  }

   /**
   * response type
   * @return responseType
  **/
  @ApiModelProperty(example = "code", required = true, value = "response type")
  public String getResponseType() {
    return responseType;
  }

  public void setResponseType(String responseType) {
    this.responseType = responseType;
  }

  public ListClientsResponseSchemaClients scopes(String scopes) {
    this.scopes = scopes;
    return this;
  }

   /**
   * comma separated list of scopes
   * @return scopes
  **/
  @ApiModelProperty(example = "beehive", required = true, value = "comma separated list of scopes")
  public String getScopes() {
    return scopes;
  }

  public void setScopes(String scopes) {
    this.scopes = scopes;
  }

  public ListClientsResponseSchemaClients uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * Get uuid
   * @return uuid
  **/
  @ApiModelProperty(example = "4cdf0ea4-159a-45aa-96f2-708e461130e1", required = true, value = "")
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
    ListClientsResponseSchemaClients listClientsResponseSchemaClients = (ListClientsResponseSchemaClients) o;
    return Objects.equals(this.meta_, listClientsResponseSchemaClients.meta_) &&
        Objects.equals(this.active, listClientsResponseSchemaClients.active) &&
        Objects.equals(this.date, listClientsResponseSchemaClients.date) &&
        Objects.equals(this.desc, listClientsResponseSchemaClients.desc) &&
        Objects.equals(this.grantType, listClientsResponseSchemaClients.grantType) &&
        Objects.equals(this.id, listClientsResponseSchemaClients.id) &&
        Objects.equals(this.name, listClientsResponseSchemaClients.name) &&
        Objects.equals(this.responseType, listClientsResponseSchemaClients.responseType) &&
        Objects.equals(this.scopes, listClientsResponseSchemaClients.scopes) &&
        Objects.equals(this.uuid, listClientsResponseSchemaClients.uuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(meta_, active, date, desc, grantType, id, name, responseType, scopes, uuid);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListClientsResponseSchemaClients {\n");
    
    sb.append("    meta_: ").append(toIndentedString(meta_)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    grantType: ").append(toIndentedString(grantType)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    responseType: ").append(toIndentedString(responseType)).append("\n");
    sb.append("    scopes: ").append(toIndentedString(scopes)).append("\n");
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
      return "";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

