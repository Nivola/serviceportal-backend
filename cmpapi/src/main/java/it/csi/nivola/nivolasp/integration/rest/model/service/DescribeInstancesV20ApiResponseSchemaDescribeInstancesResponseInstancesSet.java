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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet
 */

public class DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet {
  @JsonProperty("architecture")
  private String architecture = null;

  @JsonProperty("blockDeviceMapping")
  private List<DescribeInstancesApiResponseSchemaDescribeInstancesResponseBlockDeviceMapping> blockDeviceMapping = null;

  @JsonProperty("dnsName")
  private String dnsName = null;

  @JsonProperty("ebsOptimized")
  private Boolean ebsOptimized = null;

  @JsonProperty("groupSet")
  private List<DescribeInstancesApiResponseSchemaDescribeInstancesResponseGroupSet> groupSet = null;

  @JsonProperty("hypervisor")
  private String hypervisor = null;

  @JsonProperty("imageId")
  private String imageId = null;

  @JsonProperty("instanceId")
  private String instanceId = null;

  @JsonProperty("instanceState")
  private DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstanceState instanceState = null;

  @JsonProperty("instanceType")
  private String instanceType = null;

  @JsonProperty("ipAddress")
  private String ipAddress = null;

  @JsonProperty("keyName")
  private String keyName = null;

  @JsonProperty("launchTime")
  private LocalDateTime launchTime = null;

  @JsonProperty("monitoring")
  private DescribeInstancesApiResponseSchemaDescribeInstancesResponseMonitoring monitoring = null;

  @JsonProperty("networkInterfaceSet")
  private List<DescribeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet> networkInterfaceSet = null;

  @JsonProperty("nvl-BackupEnabled")
  private Boolean nvlBackupEnabled = null;

  @JsonProperty("nvl-HostGroup")
  private String nvlHostGroup = null;

  @JsonProperty("nvl-InstanceTypeExt")
  private DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseNvlInstanceTypeExt nvlInstanceTypeExt = null;

  @JsonProperty("nvl-LoggingEnabled")
  private Boolean nvlLoggingEnabled = null;

  @JsonProperty("nvl-MonitoringEnabled")
  private Boolean nvlMonitoringEnabled = null;

  @JsonProperty("nvl-imageName")
  private String nvlImageName = null;

  @JsonProperty("nvl-name")
  private String nvlName = null;

  @JsonProperty("nvl-ownerAlias")
  private String nvlOwnerAlias = null;

  @JsonProperty("nvl-ownerId")
  private String nvlOwnerId = null;

  @JsonProperty("nvl-resourceId")
  private String nvlResourceId = null;

  @JsonProperty("nvl-subnetName")
  private String nvlSubnetName = null;

  @JsonProperty("nvl-vpcName")
  private String nvlVpcName = null;

  @JsonProperty("placement")
  private DescribeInstancesApiResponseSchemaDescribeInstancesResponsePlacement placement = null;

  @JsonProperty("privateDnsName")
  private String privateDnsName = null;

  @JsonProperty("privateIpAddress")
  private String privateIpAddress = null;

  @JsonProperty("productCodes")
  private DescribeInstancesApiResponseSchemaDescribeInstancesResponseProductCodes productCodes = null;

  @JsonProperty("reason")
  private String reason = null;

  @JsonProperty("rootDeviceType")
  private String rootDeviceType = null;

  @JsonProperty("stateReason")
  private DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseStateReason stateReason = null;

  @JsonProperty("subnetId")
  private String subnetId = null;

  @JsonProperty("tagSet")
  private List<CreateDBInstancesApiRequestSchemaDbinstanceTag> tagSet = null;

  @JsonProperty("virtualizationType")
  private String virtualizationType = null;

  @JsonProperty("vpcId")
  private String vpcId = null;

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet architecture(String architecture) {
    this.architecture = architecture;
    return this;
  }

   /**
   * 
   * @return architecture
  **/
  @ApiModelProperty(example = "i386 | x86_64", value = "")
  public String getArchitecture() {
    return architecture;
  }

  public void setArchitecture(String architecture) {
    this.architecture = architecture;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet blockDeviceMapping(List<DescribeInstancesApiResponseSchemaDescribeInstancesResponseBlockDeviceMapping> blockDeviceMapping) {
    this.blockDeviceMapping = blockDeviceMapping;
    return this;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet addBlockDeviceMappingItem(DescribeInstancesApiResponseSchemaDescribeInstancesResponseBlockDeviceMapping blockDeviceMappingItem) {
    if (this.blockDeviceMapping == null) {
      this.blockDeviceMapping = new ArrayList<>();
    }
    this.blockDeviceMapping.add(blockDeviceMappingItem);
    return this;
  }

   /**
   * Get blockDeviceMapping
   * @return blockDeviceMapping
  **/
  @ApiModelProperty(value = "")
  public List<DescribeInstancesApiResponseSchemaDescribeInstancesResponseBlockDeviceMapping> getBlockDeviceMapping() {
    return blockDeviceMapping;
  }

  public void setBlockDeviceMapping(List<DescribeInstancesApiResponseSchemaDescribeInstancesResponseBlockDeviceMapping> blockDeviceMapping) {
    this.blockDeviceMapping = blockDeviceMapping;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet dnsName(String dnsName) {
    this.dnsName = dnsName;
    return this;
  }

   /**
   * public dns name assigned to the instance
   * @return dnsName
  **/
  @ApiModelProperty(example = "", value = "public dns name assigned to the instance")
  public String getDnsName() {
    return dnsName;
  }

  public void setDnsName(String dnsName) {
    this.dnsName = dnsName;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet ebsOptimized(Boolean ebsOptimized) {
    this.ebsOptimized = ebsOptimized;
    return this;
  }

   /**
   * indicates whether the instance is optimized for Amazon EBS I/O
   * @return ebsOptimized
  **/
  @ApiModelProperty(value = "indicates whether the instance is optimized for Amazon EBS I/O")
  public Boolean isEbsOptimized() {
    return ebsOptimized;
  }

  public void setEbsOptimized(Boolean ebsOptimized) {
    this.ebsOptimized = ebsOptimized;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet groupSet(List<DescribeInstancesApiResponseSchemaDescribeInstancesResponseGroupSet> groupSet) {
    this.groupSet = groupSet;
    return this;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet addGroupSetItem(DescribeInstancesApiResponseSchemaDescribeInstancesResponseGroupSet groupSetItem) {
    if (this.groupSet == null) {
      this.groupSet = new ArrayList<>();
    }
    this.groupSet.add(groupSetItem);
    return this;
  }

   /**
   * Get groupSet
   * @return groupSet
  **/
  @ApiModelProperty(value = "")
  public List<DescribeInstancesApiResponseSchemaDescribeInstancesResponseGroupSet> getGroupSet() {
    return groupSet;
  }

  public void setGroupSet(List<DescribeInstancesApiResponseSchemaDescribeInstancesResponseGroupSet> groupSet) {
    this.groupSet = groupSet;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet hypervisor(String hypervisor) {
    this.hypervisor = hypervisor;
    return this;
  }

   /**
   * type of the hypervisor
   * @return hypervisor
  **/
  @ApiModelProperty(example = "vmware | openstack", value = "type of the hypervisor")
  public String getHypervisor() {
    return hypervisor;
  }

  public void setHypervisor(String hypervisor) {
    this.hypervisor = hypervisor;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet imageId(String imageId) {
    this.imageId = imageId;
    return this;
  }

   /**
   * image instance id
   * @return imageId
  **/
  @ApiModelProperty(example = "", value = "image instance id")
  public String getImageId() {
    return imageId;
  }

  public void setImageId(String imageId) {
    this.imageId = imageId;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet instanceId(String instanceId) {
    this.instanceId = instanceId;
    return this;
  }

   /**
   * instance id
   * @return instanceId
  **/
  @ApiModelProperty(example = "", value = "instance id")
  public String getInstanceId() {
    return instanceId;
  }

  public void setInstanceId(String instanceId) {
    this.instanceId = instanceId;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet instanceState(DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstanceState instanceState) {
    this.instanceState = instanceState;
    return this;
  }

   /**
   * Get instanceState
   * @return instanceState
  **/
  @ApiModelProperty(value = "")
  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstanceState getInstanceState() {
    return instanceState;
  }

  public void setInstanceState(DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstanceState instanceState) {
    this.instanceState = instanceState;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet instanceType(String instanceType) {
    this.instanceType = instanceType;
    return this;
  }

   /**
   * instance definition for the instance
   * @return instanceType
  **/
  @ApiModelProperty(example = "", value = "instance definition for the instance")
  public String getInstanceType() {
    return instanceType;
  }

  public void setInstanceType(String instanceType) {
    this.instanceType = instanceType;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet ipAddress(String ipAddress) {
    this.ipAddress = ipAddress;
    return this;
  }

   /**
   * 
   * @return ipAddress
  **/
  @ApiModelProperty(example = "192.168.1.98", value = "")
  public String getIpAddress() {
    return ipAddress;
  }

  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet keyName(String keyName) {
    this.keyName = keyName;
    return this;
  }

   /**
   * name of the key pair used to create the instance
   * @return keyName
  **/
  @ApiModelProperty(example = "", value = "name of the key pair used to create the instance")
  public String getKeyName() {
    return keyName;
  }

  public void setKeyName(String keyName) {
    this.keyName = keyName;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet launchTime(LocalDateTime launchTime) {
    this.launchTime = launchTime;
    return this;
  }

   /**
   * the timestamp the instance was launched
   * @return launchTime
  **/
  @ApiModelProperty(example = "", value = "the timestamp the instance was launched")
  public LocalDateTime getLaunchTime() {
    return launchTime;
  }

  public void setLaunchTime(LocalDateTime launchTime) {
    this.launchTime = launchTime;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet monitoring(DescribeInstancesApiResponseSchemaDescribeInstancesResponseMonitoring monitoring) {
    this.monitoring = monitoring;
    return this;
  }

   /**
   * Get monitoring
   * @return monitoring
  **/
  @ApiModelProperty(value = "")
  public DescribeInstancesApiResponseSchemaDescribeInstancesResponseMonitoring getMonitoring() {
    return monitoring;
  }

  public void setMonitoring(DescribeInstancesApiResponseSchemaDescribeInstancesResponseMonitoring monitoring) {
    this.monitoring = monitoring;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet networkInterfaceSet(List<DescribeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet> networkInterfaceSet) {
    this.networkInterfaceSet = networkInterfaceSet;
    return this;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet addNetworkInterfaceSetItem(DescribeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet networkInterfaceSetItem) {
    if (this.networkInterfaceSet == null) {
      this.networkInterfaceSet = new ArrayList<>();
    }
    this.networkInterfaceSet.add(networkInterfaceSetItem);
    return this;
  }

   /**
   * Get networkInterfaceSet
   * @return networkInterfaceSet
  **/
  @ApiModelProperty(value = "")
  public List<DescribeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet> getNetworkInterfaceSet() {
    return networkInterfaceSet;
  }

  public void setNetworkInterfaceSet(List<DescribeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet> networkInterfaceSet) {
    this.networkInterfaceSet = networkInterfaceSet;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet nvlBackupEnabled(Boolean nvlBackupEnabled) {
    this.nvlBackupEnabled = nvlBackupEnabled;
    return this;
  }

   /**
   * if True backup is enabled
   * @return nvlBackupEnabled
  **/
  @ApiModelProperty(required = true, value = "if True backup is enabled")
  public Boolean isNvlBackupEnabled() {
    return nvlBackupEnabled;
  }

  public void setNvlBackupEnabled(Boolean nvlBackupEnabled) {
    this.nvlBackupEnabled = nvlBackupEnabled;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet nvlHostGroup(String nvlHostGroup) {
    this.nvlHostGroup = nvlHostGroup;
    return this;
  }

   /**
   * hypervisor host group
   * @return nvlHostGroup
  **/
  @ApiModelProperty(example = "oracle", value = "hypervisor host group")
  public String getNvlHostGroup() {
    return nvlHostGroup;
  }

  public void setNvlHostGroup(String nvlHostGroup) {
    this.nvlHostGroup = nvlHostGroup;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet nvlInstanceTypeExt(DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseNvlInstanceTypeExt nvlInstanceTypeExt) {
    this.nvlInstanceTypeExt = nvlInstanceTypeExt;
    return this;
  }

   /**
   * Get nvlInstanceTypeExt
   * @return nvlInstanceTypeExt
  **/
  @ApiModelProperty(required = true, value = "")
  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseNvlInstanceTypeExt getNvlInstanceTypeExt() {
    return nvlInstanceTypeExt;
  }

  public void setNvlInstanceTypeExt(DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseNvlInstanceTypeExt nvlInstanceTypeExt) {
    this.nvlInstanceTypeExt = nvlInstanceTypeExt;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet nvlLoggingEnabled(Boolean nvlLoggingEnabled) {
    this.nvlLoggingEnabled = nvlLoggingEnabled;
    return this;
  }

   /**
   * if True log forward is enabled
   * @return nvlLoggingEnabled
  **/
  @ApiModelProperty(required = true, value = "if True log forward is enabled")
  public Boolean isNvlLoggingEnabled() {
    return nvlLoggingEnabled;
  }

  public void setNvlLoggingEnabled(Boolean nvlLoggingEnabled) {
    this.nvlLoggingEnabled = nvlLoggingEnabled;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet nvlMonitoringEnabled(Boolean nvlMonitoringEnabled) {
    this.nvlMonitoringEnabled = nvlMonitoringEnabled;
    return this;
  }

   /**
   * if True monitoring is enabled
   * @return nvlMonitoringEnabled
  **/
  @ApiModelProperty(required = true, value = "if True monitoring is enabled")
  public Boolean isNvlMonitoringEnabled() {
    return nvlMonitoringEnabled;
  }

  public void setNvlMonitoringEnabled(Boolean nvlMonitoringEnabled) {
    this.nvlMonitoringEnabled = nvlMonitoringEnabled;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet nvlImageName(String nvlImageName) {
    this.nvlImageName = nvlImageName;
    return this;
  }

   /**
   * image name of the instance
   * @return nvlImageName
  **/
  @ApiModelProperty(example = "", value = "image name of the instance")
  public String getNvlImageName() {
    return nvlImageName;
  }

  public void setNvlImageName(String nvlImageName) {
    this.nvlImageName = nvlImageName;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet nvlName(String nvlName) {
    this.nvlName = nvlName;
    return this;
  }

   /**
   * name of the instance
   * @return nvlName
  **/
  @ApiModelProperty(example = "", value = "name of the instance")
  public String getNvlName() {
    return nvlName;
  }

  public void setNvlName(String nvlName) {
    this.nvlName = nvlName;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet nvlOwnerAlias(String nvlOwnerAlias) {
    this.nvlOwnerAlias = nvlOwnerAlias;
    return this;
  }

   /**
   * name of the account that owns the instance
   * @return nvlOwnerAlias
  **/
  @ApiModelProperty(example = "", value = "name of the account that owns the instance")
  public String getNvlOwnerAlias() {
    return nvlOwnerAlias;
  }

  public void setNvlOwnerAlias(String nvlOwnerAlias) {
    this.nvlOwnerAlias = nvlOwnerAlias;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet nvlOwnerId(String nvlOwnerId) {
    this.nvlOwnerId = nvlOwnerId;
    return this;
  }

   /**
   * ID of the account that owns the instance
   * @return nvlOwnerId
  **/
  @ApiModelProperty(example = "", value = "ID of the account that owns the instance")
  public String getNvlOwnerId() {
    return nvlOwnerId;
  }

  public void setNvlOwnerId(String nvlOwnerId) {
    this.nvlOwnerId = nvlOwnerId;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet nvlResourceId(String nvlResourceId) {
    this.nvlResourceId = nvlResourceId;
    return this;
  }

   /**
   * ID of the instance resource
   * @return nvlResourceId
  **/
  @ApiModelProperty(example = "", value = "ID of the instance resource")
  public String getNvlResourceId() {
    return nvlResourceId;
  }

  public void setNvlResourceId(String nvlResourceId) {
    this.nvlResourceId = nvlResourceId;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet nvlSubnetName(String nvlSubnetName) {
    this.nvlSubnetName = nvlSubnetName;
    return this;
  }

   /**
   * subnet name of the instance
   * @return nvlSubnetName
  **/
  @ApiModelProperty(example = "", value = "subnet name of the instance")
  public String getNvlSubnetName() {
    return nvlSubnetName;
  }

  public void setNvlSubnetName(String nvlSubnetName) {
    this.nvlSubnetName = nvlSubnetName;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet nvlVpcName(String nvlVpcName) {
    this.nvlVpcName = nvlVpcName;
    return this;
  }

   /**
   * vpc name of the instance
   * @return nvlVpcName
  **/
  @ApiModelProperty(example = "", value = "vpc name of the instance")
  public String getNvlVpcName() {
    return nvlVpcName;
  }

  public void setNvlVpcName(String nvlVpcName) {
    this.nvlVpcName = nvlVpcName;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet placement(DescribeInstancesApiResponseSchemaDescribeInstancesResponsePlacement placement) {
    this.placement = placement;
    return this;
  }

   /**
   * Get placement
   * @return placement
  **/
  @ApiModelProperty(value = "")
  public DescribeInstancesApiResponseSchemaDescribeInstancesResponsePlacement getPlacement() {
    return placement;
  }

  public void setPlacement(DescribeInstancesApiResponseSchemaDescribeInstancesResponsePlacement placement) {
    this.placement = placement;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet privateDnsName(String privateDnsName) {
    this.privateDnsName = privateDnsName;
    return this;
  }

   /**
   * private dns name assigned to the instance
   * @return privateDnsName
  **/
  @ApiModelProperty(example = "", value = "private dns name assigned to the instance")
  public String getPrivateDnsName() {
    return privateDnsName;
  }

  public void setPrivateDnsName(String privateDnsName) {
    this.privateDnsName = privateDnsName;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet privateIpAddress(String privateIpAddress) {
    this.privateIpAddress = privateIpAddress;
    return this;
  }

   /**
   * 
   * @return privateIpAddress
  **/
  @ApiModelProperty(example = "192.168.1.78", value = "")
  public String getPrivateIpAddress() {
    return privateIpAddress;
  }

  public void setPrivateIpAddress(String privateIpAddress) {
    this.privateIpAddress = privateIpAddress;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet productCodes(DescribeInstancesApiResponseSchemaDescribeInstancesResponseProductCodes productCodes) {
    this.productCodes = productCodes;
    return this;
  }

   /**
   * Get productCodes
   * @return productCodes
  **/
  @ApiModelProperty(value = "")
  public DescribeInstancesApiResponseSchemaDescribeInstancesResponseProductCodes getProductCodes() {
    return productCodes;
  }

  public void setProductCodes(DescribeInstancesApiResponseSchemaDescribeInstancesResponseProductCodes productCodes) {
    this.productCodes = productCodes;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet reason(String reason) {
    this.reason = reason;
    return this;
  }

   /**
   * reason for the current state of the instance
   * @return reason
  **/
  @ApiModelProperty(example = "", value = "reason for the current state of the instance")
  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet rootDeviceType(String rootDeviceType) {
    this.rootDeviceType = rootDeviceType;
    return this;
  }

   /**
   * root device type used by the AMI.
   * @return rootDeviceType
  **/
  @ApiModelProperty(example = "ebs", value = "root device type used by the AMI.")
  public String getRootDeviceType() {
    return rootDeviceType;
  }

  public void setRootDeviceType(String rootDeviceType) {
    this.rootDeviceType = rootDeviceType;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet stateReason(DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseStateReason stateReason) {
    this.stateReason = stateReason;
    return this;
  }

   /**
   * Get stateReason
   * @return stateReason
  **/
  @ApiModelProperty(value = "")
  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseStateReason getStateReason() {
    return stateReason;
  }

  public void setStateReason(DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseStateReason stateReason) {
    this.stateReason = stateReason;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet subnetId(String subnetId) {
    this.subnetId = subnetId;
    return this;
  }

   /**
   * subnet id 
   * @return subnetId
  **/
  @ApiModelProperty(example = "", value = "subnet id ")
  public String getSubnetId() {
    return subnetId;
  }

  public void setSubnetId(String subnetId) {
    this.subnetId = subnetId;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet tagSet(List<CreateDBInstancesApiRequestSchemaDbinstanceTag> tagSet) {
    this.tagSet = tagSet;
    return this;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet addTagSetItem(CreateDBInstancesApiRequestSchemaDbinstanceTag tagSetItem) {
    if (this.tagSet == null) {
      this.tagSet = new ArrayList<>();
    }
    this.tagSet.add(tagSetItem);
    return this;
  }

   /**
   * Get tagSet
   * @return tagSet
  **/
  @ApiModelProperty(value = "")
  public List<CreateDBInstancesApiRequestSchemaDbinstanceTag> getTagSet() {
    return tagSet;
  }

  public void setTagSet(List<CreateDBInstancesApiRequestSchemaDbinstanceTag> tagSet) {
    this.tagSet = tagSet;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet virtualizationType(String virtualizationType) {
    this.virtualizationType = virtualizationType;
    return this;
  }

   /**
   * virtualization type of the instance
   * @return virtualizationType
  **/
  @ApiModelProperty(example = "hvm | paravirtual", value = "virtualization type of the instance")
  public String getVirtualizationType() {
    return virtualizationType;
  }

  public void setVirtualizationType(String virtualizationType) {
    this.virtualizationType = virtualizationType;
  }

  public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet vpcId(String vpcId) {
    this.vpcId = vpcId;
    return this;
  }

   /**
   * vpc id 
   * @return vpcId
  **/
  @ApiModelProperty(example = "", value = "vpc id ")
  public String getVpcId() {
    return vpcId;
  }

  public void setVpcId(String vpcId) {
    this.vpcId = vpcId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet = (DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet) o;
    return Objects.equals(this.architecture, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.architecture) &&
        Objects.equals(this.blockDeviceMapping, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.blockDeviceMapping) &&
        Objects.equals(this.dnsName, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.dnsName) &&
        Objects.equals(this.ebsOptimized, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.ebsOptimized) &&
        Objects.equals(this.groupSet, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.groupSet) &&
        Objects.equals(this.hypervisor, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.hypervisor) &&
        Objects.equals(this.imageId, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.imageId) &&
        Objects.equals(this.instanceId, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.instanceId) &&
        Objects.equals(this.instanceState, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.instanceState) &&
        Objects.equals(this.instanceType, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.instanceType) &&
        Objects.equals(this.ipAddress, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.ipAddress) &&
        Objects.equals(this.keyName, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.keyName) &&
        Objects.equals(this.launchTime, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.launchTime) &&
        Objects.equals(this.monitoring, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.monitoring) &&
        Objects.equals(this.networkInterfaceSet, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.networkInterfaceSet) &&
        Objects.equals(this.nvlBackupEnabled, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.nvlBackupEnabled) &&
        Objects.equals(this.nvlHostGroup, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.nvlHostGroup) &&
        Objects.equals(this.nvlInstanceTypeExt, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.nvlInstanceTypeExt) &&
        Objects.equals(this.nvlLoggingEnabled, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.nvlLoggingEnabled) &&
        Objects.equals(this.nvlMonitoringEnabled, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.nvlMonitoringEnabled) &&
        Objects.equals(this.nvlImageName, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.nvlImageName) &&
        Objects.equals(this.nvlName, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.nvlName) &&
        Objects.equals(this.nvlOwnerAlias, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.nvlOwnerAlias) &&
        Objects.equals(this.nvlOwnerId, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.nvlOwnerId) &&
        Objects.equals(this.nvlResourceId, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.nvlResourceId) &&
        Objects.equals(this.nvlSubnetName, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.nvlSubnetName) &&
        Objects.equals(this.nvlVpcName, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.nvlVpcName) &&
        Objects.equals(this.placement, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.placement) &&
        Objects.equals(this.privateDnsName, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.privateDnsName) &&
        Objects.equals(this.privateIpAddress, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.privateIpAddress) &&
        Objects.equals(this.productCodes, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.productCodes) &&
        Objects.equals(this.reason, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.reason) &&
        Objects.equals(this.rootDeviceType, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.rootDeviceType) &&
        Objects.equals(this.stateReason, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.stateReason) &&
        Objects.equals(this.subnetId, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.subnetId) &&
        Objects.equals(this.tagSet, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.tagSet) &&
        Objects.equals(this.virtualizationType, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.virtualizationType) &&
        Objects.equals(this.vpcId, describeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet.vpcId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(architecture, blockDeviceMapping, dnsName, ebsOptimized, groupSet, hypervisor, imageId, instanceId, instanceState, instanceType, ipAddress, keyName, launchTime, monitoring, networkInterfaceSet, nvlBackupEnabled, nvlHostGroup, nvlInstanceTypeExt, nvlLoggingEnabled, nvlMonitoringEnabled, nvlImageName, nvlName, nvlOwnerAlias, nvlOwnerId, nvlResourceId, nvlSubnetName, nvlVpcName, placement, privateDnsName, privateIpAddress, productCodes, reason, rootDeviceType, stateReason, subnetId, tagSet, virtualizationType, vpcId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet {\n");
    
    sb.append("    architecture: ").append(toIndentedString(architecture)).append("\n");
    sb.append("    blockDeviceMapping: ").append(toIndentedString(blockDeviceMapping)).append("\n");
    sb.append("    dnsName: ").append(toIndentedString(dnsName)).append("\n");
    sb.append("    ebsOptimized: ").append(toIndentedString(ebsOptimized)).append("\n");
    sb.append("    groupSet: ").append(toIndentedString(groupSet)).append("\n");
    sb.append("    hypervisor: ").append(toIndentedString(hypervisor)).append("\n");
    sb.append("    imageId: ").append(toIndentedString(imageId)).append("\n");
    sb.append("    instanceId: ").append(toIndentedString(instanceId)).append("\n");
    sb.append("    instanceState: ").append(toIndentedString(instanceState)).append("\n");
    sb.append("    instanceType: ").append(toIndentedString(instanceType)).append("\n");
    sb.append("    ipAddress: ").append(toIndentedString(ipAddress)).append("\n");
    sb.append("    keyName: ").append(toIndentedString(keyName)).append("\n");
    sb.append("    launchTime: ").append(toIndentedString(launchTime)).append("\n");
    sb.append("    monitoring: ").append(toIndentedString(monitoring)).append("\n");
    sb.append("    networkInterfaceSet: ").append(toIndentedString(networkInterfaceSet)).append("\n");
    sb.append("    nvlBackupEnabled: ").append(toIndentedString(nvlBackupEnabled)).append("\n");
    sb.append("    nvlHostGroup: ").append(toIndentedString(nvlHostGroup)).append("\n");
    sb.append("    nvlInstanceTypeExt: ").append(toIndentedString(nvlInstanceTypeExt)).append("\n");
    sb.append("    nvlLoggingEnabled: ").append(toIndentedString(nvlLoggingEnabled)).append("\n");
    sb.append("    nvlMonitoringEnabled: ").append(toIndentedString(nvlMonitoringEnabled)).append("\n");
    sb.append("    nvlImageName: ").append(toIndentedString(nvlImageName)).append("\n");
    sb.append("    nvlName: ").append(toIndentedString(nvlName)).append("\n");
    sb.append("    nvlOwnerAlias: ").append(toIndentedString(nvlOwnerAlias)).append("\n");
    sb.append("    nvlOwnerId: ").append(toIndentedString(nvlOwnerId)).append("\n");
    sb.append("    nvlResourceId: ").append(toIndentedString(nvlResourceId)).append("\n");
    sb.append("    nvlSubnetName: ").append(toIndentedString(nvlSubnetName)).append("\n");
    sb.append("    nvlVpcName: ").append(toIndentedString(nvlVpcName)).append("\n");
    sb.append("    placement: ").append(toIndentedString(placement)).append("\n");
    sb.append("    privateDnsName: ").append(toIndentedString(privateDnsName)).append("\n");
    sb.append("    privateIpAddress: ").append(toIndentedString(privateIpAddress)).append("\n");
    sb.append("    productCodes: ").append(toIndentedString(productCodes)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    rootDeviceType: ").append(toIndentedString(rootDeviceType)).append("\n");
    sb.append("    stateReason: ").append(toIndentedString(stateReason)).append("\n");
    sb.append("    subnetId: ").append(toIndentedString(subnetId)).append("\n");
    sb.append("    tagSet: ").append(toIndentedString(tagSet)).append("\n");
    sb.append("    virtualizationType: ").append(toIndentedString(virtualizationType)).append("\n");
    sb.append("    vpcId: ").append(toIndentedString(vpcId)).append("\n");
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

