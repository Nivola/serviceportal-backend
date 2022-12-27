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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * GetSchedulerEntriesResponseSchema
 */

public class GetSchedulerEntriesResponseSchema {
  @JsonProperty("count")
  private Integer count = null;

  @JsonProperty("schedules")
  private List<GetSchedulerEntriesResponseSchemaSchedules> schedules = new ArrayList<>();

  public GetSchedulerEntriesResponseSchema count(Integer count) {
    this.count = count;
    return this;
  }

   /**
   * Get count
   * @return count
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public GetSchedulerEntriesResponseSchema schedules(List<GetSchedulerEntriesResponseSchemaSchedules> schedules) {
    this.schedules = schedules;
    return this;
  }

  public GetSchedulerEntriesResponseSchema addSchedulesItem(GetSchedulerEntriesResponseSchemaSchedules schedulesItem) {
    this.schedules.add(schedulesItem);
    return this;
  }

   /**
   * Get schedules
   * @return schedules
  **/
  @ApiModelProperty(required = true, value = "")
  public List<GetSchedulerEntriesResponseSchemaSchedules> getSchedules() {
    return schedules;
  }

  public void setSchedules(List<GetSchedulerEntriesResponseSchemaSchedules> schedules) {
    this.schedules = schedules;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetSchedulerEntriesResponseSchema getSchedulerEntriesResponseSchema = (GetSchedulerEntriesResponseSchema) o;
    return Objects.equals(this.count, getSchedulerEntriesResponseSchema.count) &&
        Objects.equals(this.schedules, getSchedulerEntriesResponseSchema.schedules);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, schedules);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetSchedulerEntriesResponseSchema {\n");
    
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    schedules: ").append(toIndentedString(schedules)).append("\n");
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
