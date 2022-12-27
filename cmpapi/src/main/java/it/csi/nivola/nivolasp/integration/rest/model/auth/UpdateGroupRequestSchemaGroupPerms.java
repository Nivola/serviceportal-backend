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
 * UpdateGroupRequestSchemaGroupPerms
 */

public class UpdateGroupRequestSchemaGroupPerms {
  @JsonProperty("append")
  private List<UpdateGroupRequestSchemaGroupPermsAppend> append = null;

  @JsonProperty("remove")
  private List<UpdateGroupRequestSchemaGroupPermsAppend> remove = null;

  public UpdateGroupRequestSchemaGroupPerms append(List<UpdateGroupRequestSchemaGroupPermsAppend> append) {
    this.append = append;
    return this;
  }

  public UpdateGroupRequestSchemaGroupPerms addAppendItem(UpdateGroupRequestSchemaGroupPermsAppend appendItem) {
    if (this.append == null) {
      this.append = new ArrayList<>();
    }
    this.append.add(appendItem);
    return this;
  }

   /**
   * Get append
   * @return append
  **/
  @ApiModelProperty(value = "")
  public List<UpdateGroupRequestSchemaGroupPermsAppend> getAppend() {
    return append;
  }

  public void setAppend(List<UpdateGroupRequestSchemaGroupPermsAppend> append) {
    this.append = append;
  }

  public UpdateGroupRequestSchemaGroupPerms remove(List<UpdateGroupRequestSchemaGroupPermsAppend> remove) {
    this.remove = remove;
    return this;
  }

  public UpdateGroupRequestSchemaGroupPerms addRemoveItem(UpdateGroupRequestSchemaGroupPermsAppend removeItem) {
    if (this.remove == null) {
      this.remove = new ArrayList<>();
    }
    this.remove.add(removeItem);
    return this;
  }

   /**
   * Get remove
   * @return remove
  **/
  @ApiModelProperty(value = "")
  public List<UpdateGroupRequestSchemaGroupPermsAppend> getRemove() {
    return remove;
  }

  public void setRemove(List<UpdateGroupRequestSchemaGroupPermsAppend> remove) {
    this.remove = remove;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateGroupRequestSchemaGroupPerms updateGroupRequestSchemaGroupPerms = (UpdateGroupRequestSchemaGroupPerms) o;
    return Objects.equals(this.append, updateGroupRequestSchemaGroupPerms.append) &&
        Objects.equals(this.remove, updateGroupRequestSchemaGroupPerms.remove);
  }

  @Override
  public int hashCode() {
    return Objects.hash(append, remove);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateGroupRequestSchemaGroupPerms {\n");
    
    sb.append("    append: ").append(toIndentedString(append)).append("\n");
    sb.append("    remove: ").append(toIndentedString(remove)).append("\n");
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
