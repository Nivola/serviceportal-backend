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
 * App engine specific params
 */
@ApiModel(description = "App engine specific params")

public class DescribeAppInstancesResponseSchemaDescribeAppInstancesResponseEngineConfigs {
  @JsonProperty("appPort")
  private Integer appPort = null;

  @JsonProperty("documentRoot")
  private String documentRoot = null;

  @JsonProperty("farmName")
  private String farmName = null;

  @JsonProperty("ftpServer")
  private Boolean ftpServer = null;

  @JsonProperty("shareCfgDimension")
  private Boolean shareCfgDimension = null;

  @JsonProperty("shareDimension")
  private Integer shareDimension = null;

  @JsonProperty("smbServer")
  private Boolean smbServer = null;

  public DescribeAppInstancesResponseSchemaDescribeAppInstancesResponseEngineConfigs appPort(Integer appPort) {
    this.appPort = appPort;
    return this;
  }

   /**
   * [apache-php] internal application prot
   * @return appPort
  **/
  @ApiModelProperty(example = "80", value = "[apache-php] internal application prot")
  public Integer getAppPort() {
    return appPort;
  }

  public void setAppPort(Integer appPort) {
    this.appPort = appPort;
  }

  public DescribeAppInstancesResponseSchemaDescribeAppInstancesResponseEngineConfigs documentRoot(String documentRoot) {
    this.documentRoot = documentRoot;
    return this;
  }

   /**
   * [apache-php] document root
   * @return documentRoot
  **/
  @ApiModelProperty(example = "/var/www", value = "[apache-php] document root")
  public String getDocumentRoot() {
    return documentRoot;
  }

  public void setDocumentRoot(String documentRoot) {
    this.documentRoot = documentRoot;
  }

  public DescribeAppInstancesResponseSchemaDescribeAppInstancesResponseEngineConfigs farmName(String farmName) {
    this.farmName = farmName;
    return this;
  }

   /**
   * [apache-php] parent compute zone id or uuid
   * @return farmName
  **/
  @ApiModelProperty(example = "tst-portali", required = true, value = "[apache-php] parent compute zone id or uuid")
  public String getFarmName() {
    return farmName;
  }

  public void setFarmName(String farmName) {
    this.farmName = farmName;
  }

  public DescribeAppInstancesResponseSchemaDescribeAppInstancesResponseEngineConfigs ftpServer(Boolean ftpServer) {
    this.ftpServer = ftpServer;
    return this;
  }

   /**
   * [apache-php] if true install ftp server
   * @return ftpServer
  **/
  @ApiModelProperty(example = "true", value = "[apache-php] if true install ftp server")
  public Boolean isFtpServer() {
    return ftpServer;
  }

  public void setFtpServer(Boolean ftpServer) {
    this.ftpServer = ftpServer;
  }

  public DescribeAppInstancesResponseSchemaDescribeAppInstancesResponseEngineConfigs shareCfgDimension(Boolean shareCfgDimension) {
    this.shareCfgDimension = shareCfgDimension;
    return this;
  }

   /**
   * [apache-php] share config dimension in GB
   * @return shareCfgDimension
  **/
  @ApiModelProperty(example = "false", value = "[apache-php] share config dimension in GB")
  public Boolean isShareCfgDimension() {
    return shareCfgDimension;
  }

  public void setShareCfgDimension(Boolean shareCfgDimension) {
    this.shareCfgDimension = shareCfgDimension;
  }

  public DescribeAppInstancesResponseSchemaDescribeAppInstancesResponseEngineConfigs shareDimension(Integer shareDimension) {
    this.shareDimension = shareDimension;
    return this;
  }

   /**
   * [apache-php] share dimension in GB
   * @return shareDimension
  **/
  @ApiModelProperty(example = "10", value = "[apache-php] share dimension in GB")
  public Integer getShareDimension() {
    return shareDimension;
  }

  public void setShareDimension(Integer shareDimension) {
    this.shareDimension = shareDimension;
  }

  public DescribeAppInstancesResponseSchemaDescribeAppInstancesResponseEngineConfigs smbServer(Boolean smbServer) {
    this.smbServer = smbServer;
    return this;
  }

   /**
   * [apache-php] if true install samba server
   * @return smbServer
  **/
  @ApiModelProperty(example = "false", value = "[apache-php] if true install samba server")
  public Boolean isSmbServer() {
    return smbServer;
  }

  public void setSmbServer(Boolean smbServer) {
    this.smbServer = smbServer;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeAppInstancesResponseSchemaDescribeAppInstancesResponseEngineConfigs describeAppInstancesResponseSchemaDescribeAppInstancesResponseEngineConfigs = (DescribeAppInstancesResponseSchemaDescribeAppInstancesResponseEngineConfigs) o;
    return Objects.equals(this.appPort, describeAppInstancesResponseSchemaDescribeAppInstancesResponseEngineConfigs.appPort) &&
        Objects.equals(this.documentRoot, describeAppInstancesResponseSchemaDescribeAppInstancesResponseEngineConfigs.documentRoot) &&
        Objects.equals(this.farmName, describeAppInstancesResponseSchemaDescribeAppInstancesResponseEngineConfigs.farmName) &&
        Objects.equals(this.ftpServer, describeAppInstancesResponseSchemaDescribeAppInstancesResponseEngineConfigs.ftpServer) &&
        Objects.equals(this.shareCfgDimension, describeAppInstancesResponseSchemaDescribeAppInstancesResponseEngineConfigs.shareCfgDimension) &&
        Objects.equals(this.shareDimension, describeAppInstancesResponseSchemaDescribeAppInstancesResponseEngineConfigs.shareDimension) &&
        Objects.equals(this.smbServer, describeAppInstancesResponseSchemaDescribeAppInstancesResponseEngineConfigs.smbServer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appPort, documentRoot, farmName, ftpServer, shareCfgDimension, shareDimension, smbServer);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeAppInstancesResponseSchemaDescribeAppInstancesResponseEngineConfigs {\n");
    
    sb.append("    appPort: ").append(toIndentedString(appPort)).append("\n");
    sb.append("    documentRoot: ").append(toIndentedString(documentRoot)).append("\n");
    sb.append("    farmName: ").append(toIndentedString(farmName)).append("\n");
    sb.append("    ftpServer: ").append(toIndentedString(ftpServer)).append("\n");
    sb.append("    shareCfgDimension: ").append(toIndentedString(shareCfgDimension)).append("\n");
    sb.append("    shareDimension: ").append(toIndentedString(shareDimension)).append("\n");
    sb.append("    smbServer: ").append(toIndentedString(smbServer)).append("\n");
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

