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
 * CreateConsumeRequestSchema
 */

public class CreateConsumeRequestSchema {
  @JsonProperty("consume")
  private CreateConsumeRequestSchemaConsume consume = null;

  public CreateConsumeRequestSchema consume(CreateConsumeRequestSchemaConsume consume) {
    this.consume = consume;
    return this;
  }

   /**
   * Get consume
   * @return consume
  **/
  @ApiModelProperty(value = "")
  public CreateConsumeRequestSchemaConsume getConsume() {
    return consume;
  }

  public void setConsume(CreateConsumeRequestSchemaConsume consume) {
    this.consume = consume;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateConsumeRequestSchema createConsumeRequestSchema = (CreateConsumeRequestSchema) o;
    return Objects.equals(this.consume, createConsumeRequestSchema.consume);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consume);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateConsumeRequestSchema {\n");
    
    sb.append("    consume: ").append(toIndentedString(consume)).append("\n");
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

