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
 * GetTagResponseSchema
 */

public class GetTagResponseSchema {
  @JsonProperty("tag")
  private GetTagResponseSchemaTag tag = null;

  public GetTagResponseSchema tag(GetTagResponseSchemaTag tag) {
    this.tag = tag;
    return this;
  }

   /**
   * Get tag
   * @return tag
  **/
  @ApiModelProperty(required = true, value = "")
  public GetTagResponseSchemaTag getTag() {
    return tag;
  }

  public void setTag(GetTagResponseSchemaTag tag) {
    this.tag = tag;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetTagResponseSchema getTagResponseSchema = (GetTagResponseSchema) o;
    return Objects.equals(this.tag, getTagResponseSchema.tag);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tag);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetTagResponseSchema {\n");
    
    sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
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

