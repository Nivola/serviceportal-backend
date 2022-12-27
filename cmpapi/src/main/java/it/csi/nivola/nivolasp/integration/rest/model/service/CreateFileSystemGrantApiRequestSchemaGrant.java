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
 * CreateFileSystemGrantApiRequestSchemaGrant
 */

public class CreateFileSystemGrantApiRequestSchemaGrant {
  /**
   * The access level to the share should be rw or ro
   */
  public enum AccessLevelEnum {
    RW("RW"),
    
    RW_2("rw"),
    
    RO("RO"),
    
    RO_2("ro");

    private String value;

    AccessLevelEnum(String value) {
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
    public static AccessLevelEnum fromValue(String value) {
      for (AccessLevelEnum b : AccessLevelEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("access_level")
  private AccessLevelEnum accessLevel = null;

  @JsonProperty("access_to")
  private String accessTo = null;

  /**
   * The access rule type
   */
  public enum AccessTypeEnum {
    IP("IP"),
    
    IP_2("ip"),
    
    CERT("CERT"),
    
    CERT_2("cert"),
    
    USER("USER"),
    
    USER_2("user");

    private String value;

    AccessTypeEnum(String value) {
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
    public static AccessTypeEnum fromValue(String value) {
      for (AccessTypeEnum b : AccessTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("access_type")
  private AccessTypeEnum accessType = null;

  public CreateFileSystemGrantApiRequestSchemaGrant accessLevel(AccessLevelEnum accessLevel) {
    this.accessLevel = accessLevel;
    return this;
  }

   /**
   * The access level to the share should be rw or ro
   * @return accessLevel
  **/
  @ApiModelProperty(example = "rw", required = true, value = "The access level to the share should be rw or ro")
  public AccessLevelEnum getAccessLevel() {
    return accessLevel;
  }

  public void setAccessLevel(AccessLevelEnum accessLevel) {
    this.accessLevel = accessLevel;
  }

  public CreateFileSystemGrantApiRequestSchemaGrant accessTo(String accessTo) {
    this.accessTo = accessTo;
    return this;
  }

   /**
   * The value that defines the access. - ip. A valid format is XX.XX.XX.XX or XX.XX.XX.XX/XX. For example 0.0.0.0/0. - cert. A valid value is any string up to 64 characters long in the common name(CN) of the certificate. - user. A valid value is an alphanumeric string that can contain some special characters and is from 4 to 32 characters long.
   * @return accessTo
  **/
  @ApiModelProperty(example = "10.102.186.0/24", required = true, value = "The value that defines the access. - ip. A valid format is XX.XX.XX.XX or XX.XX.XX.XX/XX. For example 0.0.0.0/0. - cert. A valid value is any string up to 64 characters long in the common name(CN) of the certificate. - user. A valid value is an alphanumeric string that can contain some special characters and is from 4 to 32 characters long.")
  public String getAccessTo() {
    return accessTo;
  }

  public void setAccessTo(String accessTo) {
    this.accessTo = accessTo;
  }

  public CreateFileSystemGrantApiRequestSchemaGrant accessType(AccessTypeEnum accessType) {
    this.accessType = accessType;
    return this;
  }

   /**
   * The access rule type
   * @return accessType
  **/
  @ApiModelProperty(example = "ip", required = true, value = "The access rule type")
  public AccessTypeEnum getAccessType() {
    return accessType;
  }

  public void setAccessType(AccessTypeEnum accessType) {
    this.accessType = accessType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateFileSystemGrantApiRequestSchemaGrant createFileSystemGrantApiRequestSchemaGrant = (CreateFileSystemGrantApiRequestSchemaGrant) o;
    return Objects.equals(this.accessLevel, createFileSystemGrantApiRequestSchemaGrant.accessLevel) &&
        Objects.equals(this.accessTo, createFileSystemGrantApiRequestSchemaGrant.accessTo) &&
        Objects.equals(this.accessType, createFileSystemGrantApiRequestSchemaGrant.accessType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessLevel, accessTo, accessType);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateFileSystemGrantApiRequestSchemaGrant {\n");
    
    sb.append("    accessLevel: ").append(toIndentedString(accessLevel)).append("\n");
    sb.append("    accessTo: ").append(toIndentedString(accessTo)).append("\n");
    sb.append("    accessType: ").append(toIndentedString(accessType)).append("\n");
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

