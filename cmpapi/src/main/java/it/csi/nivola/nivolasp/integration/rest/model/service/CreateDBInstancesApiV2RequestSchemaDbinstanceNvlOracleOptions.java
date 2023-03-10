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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Configure Oracle database options
 */
@ApiModel(description = "Configure Oracle database options")

public class CreateDBInstancesApiV2RequestSchemaDbinstanceNvlOracleOptions {
  @JsonProperty("Oracle.ArchMode")
  private String oracleArchMode = null;

  @JsonProperty("Oracle.CharSet")
  private String oracleCharSet = null;

  @JsonProperty("Oracle.DBName")
  private String oracleDBName = null;

  @JsonProperty("Oracle.DbfDiskSize")
  private Integer oracleDbfDiskSize = null;

  @JsonProperty("Oracle.LsnPort")
  private Integer oracleLsnPort = null;

  @JsonProperty("Oracle.NatCharSet")
  private String oracleNatCharSet = null;

  @JsonProperty("Oracle.PartOption")
  private String oraclePartOption = null;

  @JsonProperty("Oracle.RecoDiskSize")
  private Integer oracleRecoDiskSize = null;

  public CreateDBInstancesApiV2RequestSchemaDbinstanceNvlOracleOptions oracleArchMode(String oracleArchMode) {
    this.oracleArchMode = oracleArchMode;
    return this;
  }

   /**
   * Oracle archive mode
   * @return oracleArchMode
  **/
  @ApiModelProperty(value = "Oracle archive mode")
  public String getOracleArchMode() {
    return oracleArchMode;
  }

  public void setOracleArchMode(String oracleArchMode) {
    this.oracleArchMode = oracleArchMode;
  }

  public CreateDBInstancesApiV2RequestSchemaDbinstanceNvlOracleOptions oracleCharSet(String oracleCharSet) {
    this.oracleCharSet = oracleCharSet;
    return this;
  }

   /**
   * Oracle database character set
   * @return oracleCharSet
  **/
  @ApiModelProperty(value = "Oracle database character set")
  public String getOracleCharSet() {
    return oracleCharSet;
  }

  public void setOracleCharSet(String oracleCharSet) {
    this.oracleCharSet = oracleCharSet;
  }

  public CreateDBInstancesApiV2RequestSchemaDbinstanceNvlOracleOptions oracleDBName(String oracleDBName) {
    this.oracleDBName = oracleDBName;
    return this;
  }

   /**
   * Oracle database name
   * @return oracleDBName
  **/
  @ApiModelProperty(value = "Oracle database name")
  public String getOracleDBName() {
    return oracleDBName;
  }

  public void setOracleDBName(String oracleDBName) {
    this.oracleDBName = oracleDBName;
  }

  public CreateDBInstancesApiV2RequestSchemaDbinstanceNvlOracleOptions oracleDbfDiskSize(Integer oracleDbfDiskSize) {
    this.oracleDbfDiskSize = oracleDbfDiskSize;
    return this;
  }

   /**
   * Oracle database datafiles disk size
   * @return oracleDbfDiskSize
  **/
  @ApiModelProperty(value = "Oracle database datafiles disk size")
  public Integer getOracleDbfDiskSize() {
    return oracleDbfDiskSize;
  }

  public void setOracleDbfDiskSize(Integer oracleDbfDiskSize) {
    this.oracleDbfDiskSize = oracleDbfDiskSize;
  }

  public CreateDBInstancesApiV2RequestSchemaDbinstanceNvlOracleOptions oracleLsnPort(Integer oracleLsnPort) {
    this.oracleLsnPort = oracleLsnPort;
    return this;
  }

   /**
   * Oracle listener port
   * @return oracleLsnPort
  **/
  @ApiModelProperty(value = "Oracle listener port")
  public Integer getOracleLsnPort() {
    return oracleLsnPort;
  }

  public void setOracleLsnPort(Integer oracleLsnPort) {
    this.oracleLsnPort = oracleLsnPort;
  }

  public CreateDBInstancesApiV2RequestSchemaDbinstanceNvlOracleOptions oracleNatCharSet(String oracleNatCharSet) {
    this.oracleNatCharSet = oracleNatCharSet;
    return this;
  }

   /**
   * Oracle database national character set
   * @return oracleNatCharSet
  **/
  @ApiModelProperty(value = "Oracle database national character set")
  public String getOracleNatCharSet() {
    return oracleNatCharSet;
  }

  public void setOracleNatCharSet(String oracleNatCharSet) {
    this.oracleNatCharSet = oracleNatCharSet;
  }

  public CreateDBInstancesApiV2RequestSchemaDbinstanceNvlOracleOptions oraclePartOption(String oraclePartOption) {
    this.oraclePartOption = oraclePartOption;
    return this;
  }

   /**
   * Oracle partitioning option
   * @return oraclePartOption
  **/
  @ApiModelProperty(value = "Oracle partitioning option")
  public String getOraclePartOption() {
    return oraclePartOption;
  }

  public void setOraclePartOption(String oraclePartOption) {
    this.oraclePartOption = oraclePartOption;
  }

  public CreateDBInstancesApiV2RequestSchemaDbinstanceNvlOracleOptions oracleRecoDiskSize(Integer oracleRecoDiskSize) {
    this.oracleRecoDiskSize = oracleRecoDiskSize;
    return this;
  }

   /**
   * Oracle database recovery disk size
   * @return oracleRecoDiskSize
  **/
  @ApiModelProperty(value = "Oracle database recovery disk size")
  public Integer getOracleRecoDiskSize() {
    return oracleRecoDiskSize;
  }

  public void setOracleRecoDiskSize(Integer oracleRecoDiskSize) {
    this.oracleRecoDiskSize = oracleRecoDiskSize;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateDBInstancesApiV2RequestSchemaDbinstanceNvlOracleOptions createDBInstancesApiV2RequestSchemaDbinstanceNvlOracleOptions = (CreateDBInstancesApiV2RequestSchemaDbinstanceNvlOracleOptions) o;
    return Objects.equals(this.oracleArchMode, createDBInstancesApiV2RequestSchemaDbinstanceNvlOracleOptions.oracleArchMode) &&
        Objects.equals(this.oracleCharSet, createDBInstancesApiV2RequestSchemaDbinstanceNvlOracleOptions.oracleCharSet) &&
        Objects.equals(this.oracleDBName, createDBInstancesApiV2RequestSchemaDbinstanceNvlOracleOptions.oracleDBName) &&
        Objects.equals(this.oracleDbfDiskSize, createDBInstancesApiV2RequestSchemaDbinstanceNvlOracleOptions.oracleDbfDiskSize) &&
        Objects.equals(this.oracleLsnPort, createDBInstancesApiV2RequestSchemaDbinstanceNvlOracleOptions.oracleLsnPort) &&
        Objects.equals(this.oracleNatCharSet, createDBInstancesApiV2RequestSchemaDbinstanceNvlOracleOptions.oracleNatCharSet) &&
        Objects.equals(this.oraclePartOption, createDBInstancesApiV2RequestSchemaDbinstanceNvlOracleOptions.oraclePartOption) &&
        Objects.equals(this.oracleRecoDiskSize, createDBInstancesApiV2RequestSchemaDbinstanceNvlOracleOptions.oracleRecoDiskSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(oracleArchMode, oracleCharSet, oracleDBName, oracleDbfDiskSize, oracleLsnPort, oracleNatCharSet, oraclePartOption, oracleRecoDiskSize);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateDBInstancesApiV2RequestSchemaDbinstanceNvlOracleOptions {\n");
    
    sb.append("    oracleArchMode: ").append(toIndentedString(oracleArchMode)).append("\n");
    sb.append("    oracleCharSet: ").append(toIndentedString(oracleCharSet)).append("\n");
    sb.append("    oracleDBName: ").append(toIndentedString(oracleDBName)).append("\n");
    sb.append("    oracleDbfDiskSize: ").append(toIndentedString(oracleDbfDiskSize)).append("\n");
    sb.append("    oracleLsnPort: ").append(toIndentedString(oracleLsnPort)).append("\n");
    sb.append("    oracleNatCharSet: ").append(toIndentedString(oracleNatCharSet)).append("\n");
    sb.append("    oraclePartOption: ").append(toIndentedString(oraclePartOption)).append("\n");
    sb.append("    oracleRecoDiskSize: ").append(toIndentedString(oracleRecoDiskSize)).append("\n");
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

