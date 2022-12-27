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
 * ModifyDBInstanceApiV2RequestSchemaExtensions
 */

public class ModifyDBInstanceApiV2RequestSchemaExtensions {
  @JsonProperty("Name")
  private String name = null;

  /**
   * Extension type
   */
  public enum TypeEnum {
    PLUGIN("plugin"),
    
    COMPONENT("component");

    private String value;

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("Type")
  private TypeEnum type = null;

  public ModifyDBInstanceApiV2RequestSchemaExtensions name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Extension name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Extension name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ModifyDBInstanceApiV2RequestSchemaExtensions type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * Extension type
   * @return type
  **/
  @ApiModelProperty(required = true, value = "Extension type")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModifyDBInstanceApiV2RequestSchemaExtensions modifyDBInstanceApiV2RequestSchemaExtensions = (ModifyDBInstanceApiV2RequestSchemaExtensions) o;
    return Objects.equals(this.name, modifyDBInstanceApiV2RequestSchemaExtensions.name) &&
        Objects.equals(this.type, modifyDBInstanceApiV2RequestSchemaExtensions.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModifyDBInstanceApiV2RequestSchemaExtensions {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
