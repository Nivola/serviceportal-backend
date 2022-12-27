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
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * AddAccountCapabilitiesResponseSchema
 */

public class AddAccountCapabilitiesResponseSchema {
  @JsonProperty("taskid")
  private UUID taskid = null;

  public AddAccountCapabilitiesResponseSchema taskid(UUID taskid) {
    this.taskid = taskid;
    return this;
  }

   /**
   * Get taskid
   * @return taskid
  **/
  @ApiModelProperty(example = "6d960236-d280-46d2-817d-f3ce8f0aeff7", required = true, value = "")
  public UUID getTaskid() {
    return taskid;
  }

  public void setTaskid(UUID taskid) {
    this.taskid = taskid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddAccountCapabilitiesResponseSchema addAccountCapabilitiesResponseSchema = (AddAccountCapabilitiesResponseSchema) o;
    return Objects.equals(this.taskid, addAccountCapabilitiesResponseSchema.taskid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taskid);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddAccountCapabilitiesResponseSchema {\n");
    
    sb.append("    taskid: ").append(toIndentedString(taskid)).append("\n");
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

