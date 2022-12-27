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
 * AuthorizeSGroupEgressApiRequestSchemaRuleIpRanges
 */

public class AuthorizeSGroupEgressApiRequestSchemaRuleIpRanges {
  @JsonProperty("CidrIp")
  private String cidrIp = null;

  @JsonProperty("Description")
  private String description = null;

  public AuthorizeSGroupEgressApiRequestSchemaRuleIpRanges cidrIp(String cidrIp) {
    this.cidrIp = cidrIp;
    return this;
  }

   /**
   * IPv4 CIDR (supported format:xxx.xxx.xxx.xxx/xx)
   * @return cidrIp
  **/
  @ApiModelProperty(example = "", value = "IPv4 CIDR (supported format:xxx.xxx.xxx.xxx/xx)")
  public String getCidrIp() {
    return cidrIp;
  }

  public void setCidrIp(String cidrIp) {
    this.cidrIp = cidrIp;
  }

  public AuthorizeSGroupEgressApiRequestSchemaRuleIpRanges description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Description of IPv4 CIDR
   * @return description
  **/
  @ApiModelProperty(example = "", value = "Description of IPv4 CIDR")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthorizeSGroupEgressApiRequestSchemaRuleIpRanges authorizeSGroupEgressApiRequestSchemaRuleIpRanges = (AuthorizeSGroupEgressApiRequestSchemaRuleIpRanges) o;
    return Objects.equals(this.cidrIp, authorizeSGroupEgressApiRequestSchemaRuleIpRanges.cidrIp) &&
        Objects.equals(this.description, authorizeSGroupEgressApiRequestSchemaRuleIpRanges.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cidrIp, description);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthorizeSGroupEgressApiRequestSchemaRuleIpRanges {\n");
    
    sb.append("    cidrIp: ").append(toIndentedString(cidrIp)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

