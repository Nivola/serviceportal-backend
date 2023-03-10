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
 * GetEventEntityDefinitionResponseSchema
 */

public class GetEventEntityDefinitionResponseSchema {
  @JsonProperty("count")
  private Integer count = null;

  @JsonProperty("event_entities")
  private List<String> eventEntities = null;

  public GetEventEntityDefinitionResponseSchema count(Integer count) {
    this.count = count;
    return this;
  }

   /**
   * Get count
   * @return count
  **/
  @ApiModelProperty(value = "")
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public GetEventEntityDefinitionResponseSchema eventEntities(List<String> eventEntities) {
    this.eventEntities = eventEntities;
    return this;
  }

  public GetEventEntityDefinitionResponseSchema addEventEntitiesItem(String eventEntitiesItem) {
    if (this.eventEntities == null) {
      this.eventEntities = new ArrayList<>();
    }
    this.eventEntities.add(eventEntitiesItem);
    return this;
  }

   /**
   * Get eventEntities
   * @return eventEntities
  **/
  @ApiModelProperty(value = "")
  public List<String> getEventEntities() {
    return eventEntities;
  }

  public void setEventEntities(List<String> eventEntities) {
    this.eventEntities = eventEntities;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetEventEntityDefinitionResponseSchema getEventEntityDefinitionResponseSchema = (GetEventEntityDefinitionResponseSchema) o;
    return Objects.equals(this.count, getEventEntityDefinitionResponseSchema.count) &&
        Objects.equals(this.eventEntities, getEventEntityDefinitionResponseSchema.eventEntities);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, eventEntities);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetEventEntityDefinitionResponseSchema {\n");
    
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    eventEntities: ").append(toIndentedString(eventEntities)).append("\n");
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

