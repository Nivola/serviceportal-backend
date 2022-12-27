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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Body2
 */

public class Body2 {
  @JsonProperty("object_types")
  private List<V10nasobjectstypesObjectTypes> objectTypes = null;

  public Body2 objectTypes(List<V10nasobjectstypesObjectTypes> objectTypes) {
    this.objectTypes = objectTypes;
    return this;
  }

  public Body2 addObjectTypesItem(V10nasobjectstypesObjectTypes objectTypesItem) {
    if (this.objectTypes == null) {
      this.objectTypes = new ArrayList<>();
    }
    this.objectTypes.add(objectTypesItem);
    return this;
  }

   /**
   * Get objectTypes
   * @return objectTypes
  **/
  @ApiModelProperty(value = "")
  public List<V10nasobjectstypesObjectTypes> getObjectTypes() {
    return objectTypes;
  }

  public void setObjectTypes(List<V10nasobjectstypesObjectTypes> objectTypes) {
    this.objectTypes = objectTypes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Body2 body2 = (Body2) o;
    return Objects.equals(this.objectTypes, body2.objectTypes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objectTypes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Body2 {\n");
    
    sb.append("    objectTypes: ").append(toIndentedString(objectTypes)).append("\n");
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
