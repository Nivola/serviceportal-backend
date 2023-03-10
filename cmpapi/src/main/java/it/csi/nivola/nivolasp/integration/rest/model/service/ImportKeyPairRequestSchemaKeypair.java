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
 * ImportKeyPairRequestSchemaKeypair
 */

public class ImportKeyPairRequestSchemaKeypair {
  @JsonProperty("KeyName")
  private String keyName = null;

  /**
   * Key pair type definition
   */
  public enum NvlKeyPairTypeEnum {
    DEFAULTKEYPAIR("DefaultKeyPair"),
    
    KEYPAIR_PRIVATE("KeyPair.Private");

    private String value;

    NvlKeyPairTypeEnum(String value) {
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
    public static NvlKeyPairTypeEnum fromValue(String value) {
      for (NvlKeyPairTypeEnum b : NvlKeyPairTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("Nvl-KeyPairType")
  private NvlKeyPairTypeEnum nvlKeyPairType = null;

  @JsonProperty("PublicKeyMaterial")
  private String publicKeyMaterial = null;

  @JsonProperty("owner-id")
  private String ownerId = null;

  public ImportKeyPairRequestSchemaKeypair keyName(String keyName) {
    this.keyName = keyName;
    return this;
  }

   /**
   * keypair name
   * @return keyName
  **/
  @ApiModelProperty(example = "", required = true, value = "keypair name")
  public String getKeyName() {
    return keyName;
  }

  public void setKeyName(String keyName) {
    this.keyName = keyName;
  }

  public ImportKeyPairRequestSchemaKeypair nvlKeyPairType(NvlKeyPairTypeEnum nvlKeyPairType) {
    this.nvlKeyPairType = nvlKeyPairType;
    return this;
  }

   /**
   * Key pair type definition
   * @return nvlKeyPairType
  **/
  @ApiModelProperty(value = "Key pair type definition")
  public NvlKeyPairTypeEnum getNvlKeyPairType() {
    return nvlKeyPairType;
  }

  public void setNvlKeyPairType(NvlKeyPairTypeEnum nvlKeyPairType) {
    this.nvlKeyPairType = nvlKeyPairType;
  }

  public ImportKeyPairRequestSchemaKeypair publicKeyMaterial(String publicKeyMaterial) {
    this.publicKeyMaterial = publicKeyMaterial;
    return this;
  }

   /**
   * public key base64-encoded
   * @return publicKeyMaterial
  **/
  @ApiModelProperty(example = "", required = true, value = "public key base64-encoded")
  public String getPublicKeyMaterial() {
    return publicKeyMaterial;
  }

  public void setPublicKeyMaterial(String publicKeyMaterial) {
    this.publicKeyMaterial = publicKeyMaterial;
  }

  public ImportKeyPairRequestSchemaKeypair ownerId(String ownerId) {
    this.ownerId = ownerId;
    return this;
  }

   /**
   * account id or uuid associated to compute zone
   * @return ownerId
  **/
  @ApiModelProperty(example = "1", required = true, value = "account id or uuid associated to compute zone")
  public String getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(String ownerId) {
    this.ownerId = ownerId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImportKeyPairRequestSchemaKeypair importKeyPairRequestSchemaKeypair = (ImportKeyPairRequestSchemaKeypair) o;
    return Objects.equals(this.keyName, importKeyPairRequestSchemaKeypair.keyName) &&
        Objects.equals(this.nvlKeyPairType, importKeyPairRequestSchemaKeypair.nvlKeyPairType) &&
        Objects.equals(this.publicKeyMaterial, importKeyPairRequestSchemaKeypair.publicKeyMaterial) &&
        Objects.equals(this.ownerId, importKeyPairRequestSchemaKeypair.ownerId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(keyName, nvlKeyPairType, publicKeyMaterial, ownerId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImportKeyPairRequestSchemaKeypair {\n");
    
    sb.append("    keyName: ").append(toIndentedString(keyName)).append("\n");
    sb.append("    nvlKeyPairType: ").append(toIndentedString(nvlKeyPairType)).append("\n");
    sb.append("    publicKeyMaterial: ").append(toIndentedString(publicKeyMaterial)).append("\n");
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
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

