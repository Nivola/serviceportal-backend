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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * ForwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseCurrentState
 */

public class ForwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseCurrentState {
  @JsonProperty("code")
  private Integer code = null;

  /**
   * name of DB instance state
   */
  public enum NameEnum {
    PENDING("pending"),
    
    RUNNING("running"),
    
    SHUTTING_DOWN("shutting-down"),
    
    TERMINATED("terminated"),
    
    STOPPING("stopping"),
    
    STOPPED("stopped"),
    
    ERROR("error"),
    
    UNKNOWN("unknown");

    private String value;

    NameEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static NameEnum fromValue(String value) {
      for (NameEnum b : NameEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("name")
  private NameEnum name = null;

  public ForwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseCurrentState code(Integer code) {
    this.code = code;
    return this;
  }

   /**
   * code of DB instance state
   * @return code
  **/
  @ApiModelProperty(example = "0", value = "code of DB instance state")
  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public ForwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseCurrentState name(NameEnum name) {
    this.name = name;
    return this;
  }

   /**
   * name of DB instance state
   * @return name
  **/
  @ApiModelProperty(example = "pending | running | ....", value = "name of DB instance state")
  public NameEnum getName() {
    return name;
  }

  public void setName(NameEnum name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ForwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseCurrentState forwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseCurrentState = (ForwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseCurrentState) o;
    return Objects.equals(this.code, forwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseCurrentState.code) &&
        Objects.equals(this.name, forwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseCurrentState.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ForwardLogDBInstancesApiResponseSchemaForwardLogDBInstancesResponseCurrentState {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

