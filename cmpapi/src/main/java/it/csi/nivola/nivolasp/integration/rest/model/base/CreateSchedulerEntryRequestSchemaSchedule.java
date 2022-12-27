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
 * CreateSchedulerEntryRequestSchemaSchedule
 */

public class CreateSchedulerEntryRequestSchemaSchedule {
  @JsonProperty("args")
  private String args = null;

  @JsonProperty("kwargs")
  private Object kwargs = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("options")
  private Object options = null;

  @JsonProperty("relative")
  private Boolean relative = null;

  @JsonProperty("schedule")
  private Object schedule = null;

  @JsonProperty("task")
  private String task = null;

  public CreateSchedulerEntryRequestSchemaSchedule args(String args) {
    this.args = args;
    return this;
  }

   /**
   * Get args
   * @return args
  **/
  @ApiModelProperty(value = "")
  public String getArgs() {
    return args;
  }

  public void setArgs(String args) {
    this.args = args;
  }

  public CreateSchedulerEntryRequestSchemaSchedule kwargs(Object kwargs) {
    this.kwargs = kwargs;
    return this;
  }

   /**
   * Get kwargs
   * @return kwargs
  **/
  @ApiModelProperty(value = "")
  public Object getKwargs() {
    return kwargs;
  }

  public void setKwargs(Object kwargs) {
    this.kwargs = kwargs;
  }

  public CreateSchedulerEntryRequestSchemaSchedule name(String name) {
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

  public CreateSchedulerEntryRequestSchemaSchedule options(Object options) {
    this.options = options;
    return this;
  }

   /**
   * Get options
   * @return options
  **/
  @ApiModelProperty(value = "")
  public Object getOptions() {
    return options;
  }

  public void setOptions(Object options) {
    this.options = options;
  }

  public CreateSchedulerEntryRequestSchemaSchedule relative(Boolean relative) {
    this.relative = relative;
    return this;
  }

   /**
   * Get relative
   * @return relative
  **/
  @ApiModelProperty(value = "")
  public Boolean isRelative() {
    return relative;
  }

  public void setRelative(Boolean relative) {
    this.relative = relative;
  }

  public CreateSchedulerEntryRequestSchemaSchedule schedule(Object schedule) {
    this.schedule = schedule;
    return this;
  }

   /**
   * Get schedule
   * @return schedule
  **/
  @ApiModelProperty(required = true, value = "")
  public Object getSchedule() {
    return schedule;
  }

  public void setSchedule(Object schedule) {
    this.schedule = schedule;
  }

  public CreateSchedulerEntryRequestSchemaSchedule task(String task) {
    this.task = task;
    return this;
  }

   /**
   * Get task
   * @return task
  **/
  @ApiModelProperty(required = true, value = "")
  public String getTask() {
    return task;
  }

  public void setTask(String task) {
    this.task = task;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateSchedulerEntryRequestSchemaSchedule createSchedulerEntryRequestSchemaSchedule = (CreateSchedulerEntryRequestSchemaSchedule) o;
    return Objects.equals(this.args, createSchedulerEntryRequestSchemaSchedule.args) &&
        Objects.equals(this.kwargs, createSchedulerEntryRequestSchemaSchedule.kwargs) &&
        Objects.equals(this.name, createSchedulerEntryRequestSchemaSchedule.name) &&
        Objects.equals(this.options, createSchedulerEntryRequestSchemaSchedule.options) &&
        Objects.equals(this.relative, createSchedulerEntryRequestSchemaSchedule.relative) &&
        Objects.equals(this.schedule, createSchedulerEntryRequestSchemaSchedule.schedule) &&
        Objects.equals(this.task, createSchedulerEntryRequestSchemaSchedule.task);
  }

  @Override
  public int hashCode() {
    return Objects.hash(args, kwargs, name, options, relative, schedule, task);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateSchedulerEntryRequestSchemaSchedule {\n");
    
    sb.append("    args: ").append(toIndentedString(args)).append("\n");
    sb.append("    kwargs: ").append(toIndentedString(kwargs)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    options: ").append(toIndentedString(options)).append("\n");
    sb.append("    relative: ").append(toIndentedString(relative)).append("\n");
    sb.append("    schedule: ").append(toIndentedString(schedule)).append("\n");
    sb.append("    task: ").append(toIndentedString(task)).append("\n");
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

