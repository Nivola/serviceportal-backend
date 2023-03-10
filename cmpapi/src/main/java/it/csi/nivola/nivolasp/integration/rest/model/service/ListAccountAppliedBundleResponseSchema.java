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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ListAccountAppliedBundleResponseSchema
 */

public class ListAccountAppliedBundleResponseSchema {
  @JsonProperty("bundles")
  private List<GetAccountAppliedBundleResponseSchemaBundle> bundles = new ArrayList<>();

  public ListAccountAppliedBundleResponseSchema bundles(List<GetAccountAppliedBundleResponseSchemaBundle> bundles) {
    this.bundles = bundles;
    return this;
  }

  public ListAccountAppliedBundleResponseSchema addBundlesItem(GetAccountAppliedBundleResponseSchemaBundle bundlesItem) {
    this.bundles.add(bundlesItem);
    return this;
  }

   /**
   * Get bundles
   * @return bundles
  **/
  @ApiModelProperty(required = true, value = "")
  public List<GetAccountAppliedBundleResponseSchemaBundle> getBundles() {
    return bundles;
  }

  public void setBundles(List<GetAccountAppliedBundleResponseSchemaBundle> bundles) {
    this.bundles = bundles;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListAccountAppliedBundleResponseSchema listAccountAppliedBundleResponseSchema = (ListAccountAppliedBundleResponseSchema) o;
    return Objects.equals(this.bundles, listAccountAppliedBundleResponseSchema.bundles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bundles);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListAccountAppliedBundleResponseSchema {\n");
    
    sb.append("    bundles: ").append(toIndentedString(bundles)).append("\n");
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

