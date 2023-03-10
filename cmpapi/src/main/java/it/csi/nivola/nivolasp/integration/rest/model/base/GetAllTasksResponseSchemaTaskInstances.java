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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * GetAllTasksResponseSchemaTaskInstances
 */

public class GetAllTasksResponseSchemaTaskInstances {
  @JsonProperty("children")
  private List<Object> children = null;

  @JsonProperty("elapsed")
  private Float elapsed = null;

  @JsonProperty("jobs")
  private List<String> jobs = null;

  @JsonProperty("kwargs")
  private Object kwargs = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("start_time")
  private String startTime = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("stop_time")
  private String stopTime = null;

  @JsonProperty("task_id")
  private String taskId = null;

  @JsonProperty("traceback")
  private List<String> traceback = null;

  @JsonProperty("ttl")
  private Integer ttl = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("worker")
  private String worker = null;

  public GetAllTasksResponseSchemaTaskInstances children(List<Object> children) {
    this.children = children;
    return this;
  }

  public GetAllTasksResponseSchemaTaskInstances addChildrenItem(Object childrenItem) {
    if (this.children == null) {
      this.children = new ArrayList<>();
    }
    this.children.add(childrenItem);
    return this;
  }

   /**
   * Get children
   * @return children
  **/
  @ApiModelProperty(value = "")
  public List<Object> getChildren() {
    return children;
  }

  public void setChildren(List<Object> children) {
    this.children = children;
  }

  public GetAllTasksResponseSchemaTaskInstances elapsed(Float elapsed) {
    this.elapsed = elapsed;
    return this;
  }

   /**
   * Get elapsed
   * @return elapsed
  **/
  @ApiModelProperty(required = true, value = "")
  public Float getElapsed() {
    return elapsed;
  }

  public void setElapsed(Float elapsed) {
    this.elapsed = elapsed;
  }

  public GetAllTasksResponseSchemaTaskInstances jobs(List<String> jobs) {
    this.jobs = jobs;
    return this;
  }

  public GetAllTasksResponseSchemaTaskInstances addJobsItem(String jobsItem) {
    if (this.jobs == null) {
      this.jobs = new ArrayList<>();
    }
    this.jobs.add(jobsItem);
    return this;
  }

   /**
   * Get jobs
   * @return jobs
  **/
  @ApiModelProperty(value = "")
  public List<String> getJobs() {
    return jobs;
  }

  public void setJobs(List<String> jobs) {
    this.jobs = jobs;
  }

  public GetAllTasksResponseSchemaTaskInstances kwargs(Object kwargs) {
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

  public GetAllTasksResponseSchemaTaskInstances name(String name) {
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

  public GetAllTasksResponseSchemaTaskInstances startTime(String startTime) {
    this.startTime = startTime;
    return this;
  }

   /**
   * Get startTime
   * @return startTime
  **/
  @ApiModelProperty(required = true, value = "")
  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public GetAllTasksResponseSchemaTaskInstances status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(required = true, value = "")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public GetAllTasksResponseSchemaTaskInstances stopTime(String stopTime) {
    this.stopTime = stopTime;
    return this;
  }

   /**
   * Get stopTime
   * @return stopTime
  **/
  @ApiModelProperty(required = true, value = "")
  public String getStopTime() {
    return stopTime;
  }

  public void setStopTime(String stopTime) {
    this.stopTime = stopTime;
  }

  public GetAllTasksResponseSchemaTaskInstances taskId(String taskId) {
    this.taskId = taskId;
    return this;
  }

   /**
   * Get taskId
   * @return taskId
  **/
  @ApiModelProperty(required = true, value = "")
  public String getTaskId() {
    return taskId;
  }

  public void setTaskId(String taskId) {
    this.taskId = taskId;
  }

  public GetAllTasksResponseSchemaTaskInstances traceback(List<String> traceback) {
    this.traceback = traceback;
    return this;
  }

  public GetAllTasksResponseSchemaTaskInstances addTracebackItem(String tracebackItem) {
    if (this.traceback == null) {
      this.traceback = new ArrayList<>();
    }
    this.traceback.add(tracebackItem);
    return this;
  }

   /**
   * Get traceback
   * @return traceback
  **/
  @ApiModelProperty(value = "")
  public List<String> getTraceback() {
    return traceback;
  }

  public void setTraceback(List<String> traceback) {
    this.traceback = traceback;
  }

  public GetAllTasksResponseSchemaTaskInstances ttl(Integer ttl) {
    this.ttl = ttl;
    return this;
  }

   /**
   * Get ttl
   * @return ttl
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getTtl() {
    return ttl;
  }

  public void setTtl(Integer ttl) {
    this.ttl = ttl;
  }

  public GetAllTasksResponseSchemaTaskInstances type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(required = true, value = "")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public GetAllTasksResponseSchemaTaskInstances worker(String worker) {
    this.worker = worker;
    return this;
  }

   /**
   * Get worker
   * @return worker
  **/
  @ApiModelProperty(required = true, value = "")
  public String getWorker() {
    return worker;
  }

  public void setWorker(String worker) {
    this.worker = worker;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetAllTasksResponseSchemaTaskInstances getAllTasksResponseSchemaTaskInstances = (GetAllTasksResponseSchemaTaskInstances) o;
    return Objects.equals(this.children, getAllTasksResponseSchemaTaskInstances.children) &&
        Objects.equals(this.elapsed, getAllTasksResponseSchemaTaskInstances.elapsed) &&
        Objects.equals(this.jobs, getAllTasksResponseSchemaTaskInstances.jobs) &&
        Objects.equals(this.kwargs, getAllTasksResponseSchemaTaskInstances.kwargs) &&
        Objects.equals(this.name, getAllTasksResponseSchemaTaskInstances.name) &&
        Objects.equals(this.startTime, getAllTasksResponseSchemaTaskInstances.startTime) &&
        Objects.equals(this.status, getAllTasksResponseSchemaTaskInstances.status) &&
        Objects.equals(this.stopTime, getAllTasksResponseSchemaTaskInstances.stopTime) &&
        Objects.equals(this.taskId, getAllTasksResponseSchemaTaskInstances.taskId) &&
        Objects.equals(this.traceback, getAllTasksResponseSchemaTaskInstances.traceback) &&
        Objects.equals(this.ttl, getAllTasksResponseSchemaTaskInstances.ttl) &&
        Objects.equals(this.type, getAllTasksResponseSchemaTaskInstances.type) &&
        Objects.equals(this.worker, getAllTasksResponseSchemaTaskInstances.worker);
  }

  @Override
  public int hashCode() {
    return Objects.hash(children, elapsed, jobs, kwargs, name, startTime, status, stopTime, taskId, traceback, ttl, type, worker);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetAllTasksResponseSchemaTaskInstances {\n");
    
    sb.append("    children: ").append(toIndentedString(children)).append("\n");
    sb.append("    elapsed: ").append(toIndentedString(elapsed)).append("\n");
    sb.append("    jobs: ").append(toIndentedString(jobs)).append("\n");
    sb.append("    kwargs: ").append(toIndentedString(kwargs)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    stopTime: ").append(toIndentedString(stopTime)).append("\n");
    sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
    sb.append("    traceback: ").append(toIndentedString(traceback)).append("\n");
    sb.append("    ttl: ").append(toIndentedString(ttl)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    worker: ").append(toIndentedString(worker)).append("\n");
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

