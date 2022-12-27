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


package it.csi.nivola.nivolasp.integration.rest.model.auth;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * InlineResponse2002Date
 */

public class InlineResponse2002Date {
  @JsonProperty("creation")
  private LocalDateTime creation = null;

  public InlineResponse2002Date creation(LocalDateTime creation) {
    this.creation = creation;
    return this;
  }

   /**
   * Get creation
   * @return creation
  **/
  @ApiModelProperty(example = "Mon, 31 Dec 1990 23:59:59 GMT", required = true, value = "")
  public LocalDateTime getCreation() {
    return creation;
  }

  public void setCreation(LocalDateTime creation) {
    this.creation = creation;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse2002Date inlineResponse2002Date = (InlineResponse2002Date) o;
    return Objects.equals(this.creation, inlineResponse2002Date.creation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creation);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2002Date {\n");
    
    sb.append("    creation: ").append(toIndentedString(creation)).append("\n");
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

