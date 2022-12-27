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
 * GetTaskGraphResponseSchema
 */

public class GetTaskGraphResponseSchema {
  @JsonProperty("task_instance_graph")
  private Object taskInstanceGraph = null;

  public GetTaskGraphResponseSchema taskInstanceGraph(Object taskInstanceGraph) {
    this.taskInstanceGraph = taskInstanceGraph;
    return this;
  }

   /**
   * Get taskInstanceGraph
   * @return taskInstanceGraph
  **/
  @ApiModelProperty(required = true, value = "")
  public Object getTaskInstanceGraph() {
    return taskInstanceGraph;
  }

  public void setTaskInstanceGraph(Object taskInstanceGraph) {
    this.taskInstanceGraph = taskInstanceGraph;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetTaskGraphResponseSchema getTaskGraphResponseSchema = (GetTaskGraphResponseSchema) o;
    return Objects.equals(this.taskInstanceGraph, getTaskGraphResponseSchema.taskInstanceGraph);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taskInstanceGraph);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetTaskGraphResponseSchema {\n");
    
    sb.append("    taskInstanceGraph: ").append(toIndentedString(taskInstanceGraph)).append("\n");
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

