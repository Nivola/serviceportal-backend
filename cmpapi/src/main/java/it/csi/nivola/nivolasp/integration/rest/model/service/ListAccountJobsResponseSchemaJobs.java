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
 * ListAccountJobsResponseSchemaJobs
 */

public class ListAccountJobsResponseSchemaJobs {
  @JsonProperty("account")
  private Integer account = null;

  @JsonProperty("elapsed")
  private Float elapsed = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("params")
  private String params = null;

  @JsonProperty("start_time")
  private String startTime = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("stop_time")
  private String stopTime = null;

  @JsonProperty("worker")
  private String worker = null;

  public ListAccountJobsResponseSchemaJobs account(Integer account) {
    this.account = account;
    return this;
  }

   /**
   * Get account
   * @return account
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getAccount() {
    return account;
  }

  public void setAccount(Integer account) {
    this.account = account;
  }

  public ListAccountJobsResponseSchemaJobs elapsed(Float elapsed) {
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

  public ListAccountJobsResponseSchemaJobs id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ListAccountJobsResponseSchemaJobs name(String name) {
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

  public ListAccountJobsResponseSchemaJobs params(String params) {
    this.params = params;
    return this;
  }

   /**
   * Get params
   * @return params
  **/
  @ApiModelProperty(required = true, value = "")
  public String getParams() {
    return params;
  }

  public void setParams(String params) {
    this.params = params;
  }

  public ListAccountJobsResponseSchemaJobs startTime(String startTime) {
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

  public ListAccountJobsResponseSchemaJobs status(String status) {
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

  public ListAccountJobsResponseSchemaJobs stopTime(String stopTime) {
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

  public ListAccountJobsResponseSchemaJobs worker(String worker) {
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
    ListAccountJobsResponseSchemaJobs listAccountJobsResponseSchemaJobs = (ListAccountJobsResponseSchemaJobs) o;
    return Objects.equals(this.account, listAccountJobsResponseSchemaJobs.account) &&
        Objects.equals(this.elapsed, listAccountJobsResponseSchemaJobs.elapsed) &&
        Objects.equals(this.id, listAccountJobsResponseSchemaJobs.id) &&
        Objects.equals(this.name, listAccountJobsResponseSchemaJobs.name) &&
        Objects.equals(this.params, listAccountJobsResponseSchemaJobs.params) &&
        Objects.equals(this.startTime, listAccountJobsResponseSchemaJobs.startTime) &&
        Objects.equals(this.status, listAccountJobsResponseSchemaJobs.status) &&
        Objects.equals(this.stopTime, listAccountJobsResponseSchemaJobs.stopTime) &&
        Objects.equals(this.worker, listAccountJobsResponseSchemaJobs.worker);
  }

  @Override
  public int hashCode() {
    return Objects.hash(account, elapsed, id, name, params, startTime, status, stopTime, worker);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListAccountJobsResponseSchemaJobs {\n");
    
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    elapsed: ").append(toIndentedString(elapsed)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    params: ").append(toIndentedString(params)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    stopTime: ").append(toIndentedString(stopTime)).append("\n");
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

