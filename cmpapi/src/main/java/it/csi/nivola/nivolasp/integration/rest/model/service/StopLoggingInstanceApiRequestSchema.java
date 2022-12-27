/*-
 * ========================LICENSE_START=================================
 * Api CMP
 * %%
 * Copyright (C) 2022 Regione Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | Regione Piemonte
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
 * StopLoggingInstanceApiRequestSchema
 */

public class StopLoggingInstanceApiRequestSchema {
  @JsonProperty("conf")
  private String conf = null;

  public StopLoggingInstanceApiRequestSchema conf(String conf) {
    this.conf = conf;
    return this;
  }

   /**
   * name of log conf
   * @return conf
  **/
  @ApiModelProperty(example = "tomcat", value = "name of log conf")
  public String getConf() {
    return conf;
  }

  public void setConf(String conf) {
    this.conf = conf;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StopLoggingInstanceApiRequestSchema stopLoggingInstanceApiRequestSchema = (StopLoggingInstanceApiRequestSchema) o;
    return Objects.equals(this.conf, stopLoggingInstanceApiRequestSchema.conf);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conf);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StopLoggingInstanceApiRequestSchema {\n");
    
    sb.append("    conf: ").append(toIndentedString(conf)).append("\n");
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

