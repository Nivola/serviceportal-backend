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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * CreateClientRequestSchemaClient
 */

public class CreateClientRequestSchemaClient {
  @JsonProperty("active")
  private Boolean active = true;

  @JsonProperty("desc")
  private String desc = null;

  @JsonProperty("expirydate")
  private String expirydate = null;

  /**
   * grant type. Select from: authorization_code, implicit, resource_owner_password_credentials, client_credentials, urn:ietf:params:oauth:grant-type:jwt-bearer
   */
  public enum GrantTypeEnum {
    AUTHORIZATION_CODE("authorization_code"),
    
    IMPLICIT("implicit"),
    
    PASSWORD("password"),
    
    CLIENT_CREDENTIALS("client_credentials"),
    
    URN_IETF_PARAMS_OAUTH_GRANT_TYPE_JWT_BEARER("urn:ietf:params:oauth:grant-type:jwt-bearer");

    private String value;

    GrantTypeEnum(String value) {
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
    public static GrantTypeEnum fromValue(String text) {
      for (GrantTypeEnum b : GrantTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("grant_type")
  private GrantTypeEnum grantType = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("redirect_uri")
  private String redirectUri = null;

  @JsonProperty("response_type")
  private String responseType = null;

  @JsonProperty("scopes")
  private String scopes = null;

  @JsonProperty("user")
  private String user = null;

  public CreateClientRequestSchemaClient active(Boolean active) {
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

  public CreateClientRequestSchemaClient desc(String desc) {
    this.desc = desc;
    return this;
  }

   /**
   * Get desc
   * @return desc
  **/
  @ApiModelProperty(required = true, value = "")
  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public CreateClientRequestSchemaClient expirydate(String expirydate) {
    this.expirydate = expirydate;
    return this;
  }

   /**
   * expiration date. [default&#x3D;365days]
   * @return expirydate
  **/
  @ApiModelProperty(example = "", value = "expiration date. [default=365days]")
  public String getExpirydate() {
    return expirydate;
  }

  public void setExpirydate(String expirydate) {
    this.expirydate = expirydate;
  }

  public CreateClientRequestSchemaClient grantType(GrantTypeEnum grantType) {
    this.grantType = grantType;
    return this;
  }

   /**
   * grant type. Select from: authorization_code, implicit, resource_owner_password_credentials, client_credentials, urn:ietf:params:oauth:grant-type:jwt-bearer
   * @return grantType
  **/
  @ApiModelProperty(example = "authorization_code", required = true, value = "grant type. Select from: authorization_code, implicit, resource_owner_password_credentials, client_credentials, urn:ietf:params:oauth:grant-type:jwt-bearer")
  public GrantTypeEnum getGrantType() {
    return grantType;
  }

  public void setGrantType(GrantTypeEnum grantType) {
    this.grantType = grantType;
  }

  public CreateClientRequestSchemaClient name(String name) {
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

  public CreateClientRequestSchemaClient redirectUri(String redirectUri) {
    this.redirectUri = redirectUri;
    return this;
  }

   /**
   * redirect uri
   * @return redirectUri
  **/
  @ApiModelProperty(example = "beehive,auth", required = true, value = "redirect uri")
  public String getRedirectUri() {
    return redirectUri;
  }

  public void setRedirectUri(String redirectUri) {
    this.redirectUri = redirectUri;
  }

  public CreateClientRequestSchemaClient responseType(String responseType) {
    this.responseType = responseType;
    return this;
  }

   /**
   * response type. Use code for grant-type&#x3D;authorization_code
   * @return responseType
  **/
  @ApiModelProperty(example = "code", required = true, value = "response type. Use code for grant-type=authorization_code")
  public String getResponseType() {
    return responseType;
  }

  public void setResponseType(String responseType) {
    this.responseType = responseType;
  }

  public CreateClientRequestSchemaClient scopes(String scopes) {
    this.scopes = scopes;
    return this;
  }

   /**
   * comma separated list of scopes
   * @return scopes
  **/
  @ApiModelProperty(example = "beehive,auth", required = true, value = "comma separated list of scopes")
  public String getScopes() {
    return scopes;
  }

  public void setScopes(String scopes) {
    this.scopes = scopes;
  }

  public CreateClientRequestSchemaClient user(String user) {
    this.user = user;
    return this;
  }

   /**
   * id, uuid or name of the user to link to client. Use with Resource Owner Password Credentials Grant
   * @return user
  **/
  @ApiModelProperty(example = "admin@local", value = "id, uuid or name of the user to link to client. Use with Resource Owner Password Credentials Grant")
  public String getUser() {
    return user;
  }

  public void setUser(String user) {
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
    CreateClientRequestSchemaClient createClientRequestSchemaClient = (CreateClientRequestSchemaClient) o;
    return Objects.equals(this.active, createClientRequestSchemaClient.active) &&
        Objects.equals(this.desc, createClientRequestSchemaClient.desc) &&
        Objects.equals(this.expirydate, createClientRequestSchemaClient.expirydate) &&
        Objects.equals(this.grantType, createClientRequestSchemaClient.grantType) &&
        Objects.equals(this.name, createClientRequestSchemaClient.name) &&
        Objects.equals(this.redirectUri, createClientRequestSchemaClient.redirectUri) &&
        Objects.equals(this.responseType, createClientRequestSchemaClient.responseType) &&
        Objects.equals(this.scopes, createClientRequestSchemaClient.scopes) &&
        Objects.equals(this.user, createClientRequestSchemaClient.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, desc, expirydate, grantType, name, redirectUri, responseType, scopes, user);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateClientRequestSchemaClient {\n");
    
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    expirydate: ").append(toIndentedString(expirydate)).append("\n");
    sb.append("    grantType: ").append(toIndentedString(grantType)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    redirectUri: ").append(toIndentedString(redirectUri)).append("\n");
    sb.append("    responseType: ").append(toIndentedString(responseType)).append("\n");
    sb.append("    scopes: ").append(toIndentedString(scopes)).append("\n");
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

