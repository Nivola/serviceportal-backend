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


package it.csi.nivola.nivolasp.integration.rest.model.service;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * DeletePluginTypeInstanceRequestSchema
 */

public class DeletePluginTypeInstanceRequestSchema {
  @JsonProperty("force")
  private Boolean force = null;

  @JsonProperty("propagate")
  private Boolean propagate = null;

  public DeletePluginTypeInstanceRequestSchema force(Boolean force) {
    this.force = force;
    return this;
  }

   /**
   * If True force delete
   * @return force
  **/
  @ApiModelProperty(value = "If True force delete")
  public Boolean isForce() {
    return force;
  }

  public void setForce(Boolean force) {
    this.force = force;
  }

  public DeletePluginTypeInstanceRequestSchema propagate(Boolean propagate) {
    this.propagate = propagate;
    return this;
  }

   /**
   * If True propagate delete to all cmp modules
   * @return propagate
  **/
  @ApiModelProperty(value = "If True propagate delete to all cmp modules")
  public Boolean isPropagate() {
    return propagate;
  }

  public void setPropagate(Boolean propagate) {
    this.propagate = propagate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeletePluginTypeInstanceRequestSchema deletePluginTypeInstanceRequestSchema = (DeletePluginTypeInstanceRequestSchema) o;
    return Objects.equals(this.force, deletePluginTypeInstanceRequestSchema.force) &&
        Objects.equals(this.propagate, deletePluginTypeInstanceRequestSchema.propagate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(force, propagate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeletePluginTypeInstanceRequestSchema {\n");
    
    sb.append("    force: ").append(toIndentedString(force)).append("\n");
    sb.append("    propagate: ").append(toIndentedString(propagate)).append("\n");
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
