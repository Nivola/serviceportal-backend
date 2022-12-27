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


package it.csi.nivola.nivolasp.integration.rest.model.base;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * GetCatalogResponseSchemaCatalogMeta_
 */

public class GetCatalogResponseSchemaCatalogMeta_ {
  @JsonProperty("definition")
  private String definition = null;

  @JsonProperty("objid")
  private String objid = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("uri")
  private String uri = null;

  public GetCatalogResponseSchemaCatalogMeta_ definition(String definition) {
    this.definition = definition;
    return this;
  }

   /**
   * Get definition
   * @return definition
  **/
  @ApiModelProperty(example = "Role", required = true, value = "")
  public String getDefinition() {
    return definition;
  }

  public void setDefinition(String definition) {
    this.definition = definition;
  }

  public GetCatalogResponseSchemaCatalogMeta_ objid(String objid) {
    this.objid = objid;
    return this;
  }

   /**
   * Get objid
   * @return objid
  **/
  @ApiModelProperty(example = "396587362//3328462822", required = true, value = "")
  public String getObjid() {
    return objid;
  }

  public void setObjid(String objid) {
    this.objid = objid;
  }

  public GetCatalogResponseSchemaCatalogMeta_ type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(example = "auth", required = true, value = "")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public GetCatalogResponseSchemaCatalogMeta_ uri(String uri) {
    this.uri = uri;
    return this;
  }

   /**
   * Get uri
   * @return uri
  **/
  @ApiModelProperty(example = "/v1.0/auht/roles", required = true, value = "")
  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCatalogResponseSchemaCatalogMeta_ getCatalogResponseSchemaCatalogMeta_ = (GetCatalogResponseSchemaCatalogMeta_) o;
    return Objects.equals(this.definition, getCatalogResponseSchemaCatalogMeta_.definition) &&
        Objects.equals(this.objid, getCatalogResponseSchemaCatalogMeta_.objid) &&
        Objects.equals(this.type, getCatalogResponseSchemaCatalogMeta_.type) &&
        Objects.equals(this.uri, getCatalogResponseSchemaCatalogMeta_.uri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(definition, objid, type, uri);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCatalogResponseSchemaCatalogMeta_ {\n");
    
    sb.append("    definition: ").append(toIndentedString(definition)).append("\n");
    sb.append("    objid: ").append(toIndentedString(objid)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
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

