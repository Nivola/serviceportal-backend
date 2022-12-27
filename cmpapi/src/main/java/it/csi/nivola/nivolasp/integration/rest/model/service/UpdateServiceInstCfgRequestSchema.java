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
 * UpdateServiceInstCfgRequestSchema
 */

public class UpdateServiceInstCfgRequestSchema {
  @JsonProperty("instancecfg")
  private UpdateServiceInstCfgRequestSchemaInstancecfg instancecfg = null;

  public UpdateServiceInstCfgRequestSchema instancecfg(UpdateServiceInstCfgRequestSchemaInstancecfg instancecfg) {
    this.instancecfg = instancecfg;
    return this;
  }

   /**
   * Get instancecfg
   * @return instancecfg
  **/
  @ApiModelProperty(value = "")
  public UpdateServiceInstCfgRequestSchemaInstancecfg getInstancecfg() {
    return instancecfg;
  }

  public void setInstancecfg(UpdateServiceInstCfgRequestSchemaInstancecfg instancecfg) {
    this.instancecfg = instancecfg;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateServiceInstCfgRequestSchema updateServiceInstCfgRequestSchema = (UpdateServiceInstCfgRequestSchema) o;
    return Objects.equals(this.instancecfg, updateServiceInstCfgRequestSchema.instancecfg);
  }

  @Override
  public int hashCode() {
    return Objects.hash(instancecfg);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateServiceInstCfgRequestSchema {\n");
    
    sb.append("    instancecfg: ").append(toIndentedString(instancecfg)).append("\n");
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
