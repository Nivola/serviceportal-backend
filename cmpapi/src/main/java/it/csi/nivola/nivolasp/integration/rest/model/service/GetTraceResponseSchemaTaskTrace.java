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
 * GetTraceResponseSchemaTaskTrace
 */

public class GetTraceResponseSchemaTaskTrace {
  @JsonProperty("date")
  private String date = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("level")
  private String level = null;

  @JsonProperty("message")
  private String message = null;

  @JsonProperty("step")
  private String step = null;

  public GetTraceResponseSchemaTaskTrace date(String date) {
    this.date = date;
    return this;
  }

   /**
   * trace date
   * @return date
  **/
  @ApiModelProperty(required = true, value = "trace date")
  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public GetTraceResponseSchemaTaskTrace id(String id) {
    this.id = id;
    return this;
  }

   /**
   * trace line id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "trace line id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GetTraceResponseSchemaTaskTrace level(String level) {
    this.level = level;
    return this;
  }

   /**
   * trace level
   * @return level
  **/
  @ApiModelProperty(required = true, value = "trace level")
  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public GetTraceResponseSchemaTaskTrace message(String message) {
    this.message = message;
    return this;
  }

   /**
   * trace message
   * @return message
  **/
  @ApiModelProperty(required = true, value = "trace message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public GetTraceResponseSchemaTaskTrace step(String step) {
    this.step = step;
    return this;
  }

   /**
   * step id
   * @return step
  **/
  @ApiModelProperty(required = true, value = "step id")
  public String getStep() {
    return step;
  }

  public void setStep(String step) {
    this.step = step;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetTraceResponseSchemaTaskTrace getTraceResponseSchemaTaskTrace = (GetTraceResponseSchemaTaskTrace) o;
    return Objects.equals(this.date, getTraceResponseSchemaTaskTrace.date) &&
        Objects.equals(this.id, getTraceResponseSchemaTaskTrace.id) &&
        Objects.equals(this.level, getTraceResponseSchemaTaskTrace.level) &&
        Objects.equals(this.message, getTraceResponseSchemaTaskTrace.message) &&
        Objects.equals(this.step, getTraceResponseSchemaTaskTrace.step);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, id, level, message, step);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetTraceResponseSchemaTaskTrace {\n");
    
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    step: ").append(toIndentedString(step)).append("\n");
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

