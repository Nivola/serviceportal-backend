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
 * CreateDBInstanceV2ResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceTagList
 */

public class CreateDBInstanceV2ResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceTagList {
  @JsonProperty("Tag")
  private CreateDBInstanceV2ResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceTag tag = null;

  public CreateDBInstanceV2ResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceTagList tag(CreateDBInstanceV2ResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceTag tag) {
    this.tag = tag;
    return this;
  }

   /**
   * Get tag
   * @return tag
  **/
  @ApiModelProperty(value = "")
  public CreateDBInstanceV2ResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceTag getTag() {
    return tag;
  }

  public void setTag(CreateDBInstanceV2ResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceTag tag) {
    this.tag = tag;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateDBInstanceV2ResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceTagList createDBInstanceV2ResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceTagList = (CreateDBInstanceV2ResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceTagList) o;
    return Objects.equals(this.tag, createDBInstanceV2ResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceTagList.tag);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tag);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateDBInstanceV2ResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceTagList {\n");
    
    sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
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

