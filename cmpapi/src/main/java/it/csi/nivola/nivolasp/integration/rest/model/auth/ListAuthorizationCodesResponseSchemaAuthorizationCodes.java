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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ListAuthorizationCodesResponseSchemaAuthorizationCodes
 */

public class ListAuthorizationCodesResponseSchemaAuthorizationCodes {
  @JsonProperty("client")
  private UUID client = null;

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("expired")
  private Boolean expired = null;

  @JsonProperty("expires_at")
  private String expiresAt = null;

  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("redirect_uri")
  private String redirectUri = null;

  @JsonProperty("scope")
  private List<String> scope = new ArrayList<>();

  @JsonProperty("state")
  private String state = null;

  @JsonProperty("user")
  private UUID user = null;

  public ListAuthorizationCodesResponseSchemaAuthorizationCodes client(UUID client) {
    this.client = client;
    return this;
  }

   /**
   * client uuid
   * @return client
  **/
  @ApiModelProperty(example = "2", required = true, value = "client uuid")
  public UUID getClient() {
    return client;
  }

  public void setClient(UUID client) {
    this.client = client;
  }

  public ListAuthorizationCodesResponseSchemaAuthorizationCodes code(String code) {
    this.code = code;
    return this;
  }

   /**
   * code
   * @return code
  **/
  @ApiModelProperty(example = "2", required = true, value = "code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public ListAuthorizationCodesResponseSchemaAuthorizationCodes expired(Boolean expired) {
    this.expired = expired;
    return this;
  }

   /**
   * tell if code is expired
   * @return expired
  **/
  @ApiModelProperty(example = "true", required = true, value = "tell if code is expired")
  public Boolean isExpired() {
    return expired;
  }

  public void setExpired(Boolean expired) {
    this.expired = expired;
  }

  public ListAuthorizationCodesResponseSchemaAuthorizationCodes expiresAt(String expiresAt) {
    this.expiresAt = expiresAt;
    return this;
  }

   /**
   * expiration date
   * @return expiresAt
  **/
  @ApiModelProperty(example = "2099-12-31", required = true, value = "expiration date")
  public String getExpiresAt() {
    return expiresAt;
  }

  public void setExpiresAt(String expiresAt) {
    this.expiresAt = expiresAt;
  }

  public ListAuthorizationCodesResponseSchemaAuthorizationCodes id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * code id
   * @return id
  **/
  @ApiModelProperty(example = "2", required = true, value = "code id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ListAuthorizationCodesResponseSchemaAuthorizationCodes redirectUri(String redirectUri) {
    this.redirectUri = redirectUri;
    return this;
  }

   /**
   * redirect uri
   * @return redirectUri
  **/
  @ApiModelProperty(example = "2", required = true, value = "redirect uri")
  public String getRedirectUri() {
    return redirectUri;
  }

  public void setRedirectUri(String redirectUri) {
    this.redirectUri = redirectUri;
  }

  public ListAuthorizationCodesResponseSchemaAuthorizationCodes scope(List<String> scope) {
    this.scope = scope;
    return this;
  }

  public ListAuthorizationCodesResponseSchemaAuthorizationCodes addScopeItem(String scopeItem) {
    this.scope.add(scopeItem);
    return this;
  }

   /**
   * scopes
   * @return scope
  **/
  @ApiModelProperty(required = true, value = "scopes")
  public List<String> getScope() {
    return scope;
  }

  public void setScope(List<String> scope) {
    this.scope = scope;
  }

  public ListAuthorizationCodesResponseSchemaAuthorizationCodes state(String state) {
    this.state = state;
    return this;
  }

   /**
   * generation state
   * @return state
  **/
  @ApiModelProperty(example = "dje3d8whjdis", required = true, value = "generation state")
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public ListAuthorizationCodesResponseSchemaAuthorizationCodes user(UUID user) {
    this.user = user;
    return this;
  }

   /**
   * user uuid
   * @return user
  **/
  @ApiModelProperty(example = "2", required = true, value = "user uuid")
  public UUID getUser() {
    return user;
  }

  public void setUser(UUID user) {
    this.user = user;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListAuthorizationCodesResponseSchemaAuthorizationCodes listAuthorizationCodesResponseSchemaAuthorizationCodes = (ListAuthorizationCodesResponseSchemaAuthorizationCodes) o;
    return Objects.equals(this.client, listAuthorizationCodesResponseSchemaAuthorizationCodes.client) &&
        Objects.equals(this.code, listAuthorizationCodesResponseSchemaAuthorizationCodes.code) &&
        Objects.equals(this.expired, listAuthorizationCodesResponseSchemaAuthorizationCodes.expired) &&
        Objects.equals(this.expiresAt, listAuthorizationCodesResponseSchemaAuthorizationCodes.expiresAt) &&
        Objects.equals(this.id, listAuthorizationCodesResponseSchemaAuthorizationCodes.id) &&
        Objects.equals(this.redirectUri, listAuthorizationCodesResponseSchemaAuthorizationCodes.redirectUri) &&
        Objects.equals(this.scope, listAuthorizationCodesResponseSchemaAuthorizationCodes.scope) &&
        Objects.equals(this.state, listAuthorizationCodesResponseSchemaAuthorizationCodes.state) &&
        Objects.equals(this.user, listAuthorizationCodesResponseSchemaAuthorizationCodes.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(client, code, expired, expiresAt, id, redirectUri, scope, state, user);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListAuthorizationCodesResponseSchemaAuthorizationCodes {\n");
    
    sb.append("    client: ").append(toIndentedString(client)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    expired: ").append(toIndentedString(expired)).append("\n");
    sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    redirectUri: ").append(toIndentedString(redirectUri)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
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
