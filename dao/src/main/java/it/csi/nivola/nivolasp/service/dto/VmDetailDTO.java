/*-
 * ========================LICENSE_START=================================
 * Servizi di accesso dati
 * %%
 * Copyright (C) 2022 CSI Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | CSI Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.service.dto;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.csi.nivola.nivolasp.integration.rest.model.service.CreateDBInstancesApiRequestSchemaDbinstanceTag;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeInstancesApiResponseSchemaDescribeInstancesResponseBlockDeviceMapping;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeInstancesApiResponseSchemaDescribeInstancesResponseMonitoring;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeInstancesApiResponseSchemaDescribeInstancesResponsePlacement;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeInstancesApiResponseSchemaDescribeInstancesResponseProductCodes;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstanceState;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseNvlInstanceTypeExt;

public class VmDetailDTO extends VmDTO {

	private static final long serialVersionUID = -3120234764257156590L;

	@JsonProperty("blockDeviceMapping")
	private List<DescribeInstancesApiResponseSchemaDescribeInstancesResponseBlockDeviceMapping> blockDeviceMapping = null;

	@JsonProperty("monitoraggio")
	private DescribeInstancesApiResponseSchemaDescribeInstancesResponseMonitoring monitoring = null;

	@JsonProperty("elencoInterfacceRete")
	private List<DescribeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet> networkInterfaceSet = null;

	@JsonProperty("risorseIstanza")
	private DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseNvlInstanceTypeExt nvlInstanceTypeExt = null;

	@JsonProperty("dispiegamento")
	private DescribeInstancesApiResponseSchemaDescribeInstancesResponsePlacement placement = null;

	@JsonProperty("architettura")
	private String architecture = null;

	@JsonProperty("dnsName")
	private String dnsName = null;

	@JsonProperty("ebsOptimized")
	private Boolean ebsOptimized = null;

	@JsonProperty("hypervisor")
	private String hypervisor = null;

	@JsonProperty("imageId")
	private String imageId = null;

	@JsonProperty("instanceType")
	private String instanceType = null;

	@JsonProperty("ipAddress")
	private String ipAddress = null;

	@JsonProperty("keyName")
	private String keyName = null;

	@JsonProperty("launchTime")
	private LocalDateTime launchTime = null;

	@JsonProperty("privateDnsName")
	private String privateDnsName = null;

	@JsonProperty("privateIpAddress")
	private String privateIpAddress = null;

	@JsonProperty("reason")
	private String reason = null;

	@JsonProperty("rootDeviceType")
	private String rootDeviceType = null;

	@JsonProperty("subnetId")
	private String subnetId = null;

	@JsonProperty("virtualizationType")
	private String virtualizationType = null;

	@JsonProperty("vpcId")
	private String vpcId = null;

	@JsonProperty("deviceName")
	private String deviceName = null;

	@JsonProperty("attachTime")
	private LocalDateTime attachTime = null;

	@JsonProperty("deleteOnTermination")
	private Boolean deleteOnTermination = null;

	@JsonProperty("status")
	private String status = null;

	@JsonProperty("volumeId")
	private String volumeId = null;

	@JsonProperty("productCodes")
	private DescribeInstancesApiResponseSchemaDescribeInstancesResponseProductCodes productCodes = null;

	@JsonProperty("elencoTag")
	private List<CreateDBInstancesApiRequestSchemaDbinstanceTag> tagSet = null;

	@JsonProperty("instanceState")
	private DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstanceState instanceState = null;

	@JsonProperty("monitoringState")
	private String state = null;
	
	private SubnetDTO subnet = null;
	
	private List<VolumeDTO> elencoVolumi = new LinkedList<>();

	public List<DescribeInstancesApiResponseSchemaDescribeInstancesResponseBlockDeviceMapping> getBlockDeviceMapping() {
		return blockDeviceMapping;
	}

	public void setBlockDeviceMapping(List<DescribeInstancesApiResponseSchemaDescribeInstancesResponseBlockDeviceMapping> blockDeviceMapping) {
		this.blockDeviceMapping = blockDeviceMapping;
	}

	public DescribeInstancesApiResponseSchemaDescribeInstancesResponseMonitoring getMonitoring() {
		return monitoring;
	}

	public void setMonitoring(DescribeInstancesApiResponseSchemaDescribeInstancesResponseMonitoring monitoring) {
		this.monitoring = monitoring;
	}

	public List<DescribeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet> getNetworkInterfaceSet() {
		return networkInterfaceSet;
	}

	public void setNetworkInterfaceSet(List<DescribeInstancesApiResponseSchemaDescribeInstancesResponseNetworkInterfaceSet> networkInterfaceSet) {
		this.networkInterfaceSet = networkInterfaceSet;
	}

	public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseNvlInstanceTypeExt getNvlInstanceTypeExt() {
		return nvlInstanceTypeExt;
	}

	public void setNvlInstanceTypeExt(DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseNvlInstanceTypeExt nvlInstanceTypeExt) {
		this.nvlInstanceTypeExt = nvlInstanceTypeExt;
	}

	public DescribeInstancesApiResponseSchemaDescribeInstancesResponsePlacement getPlacement() {
		return placement;
	}

	public void setPlacement(DescribeInstancesApiResponseSchemaDescribeInstancesResponsePlacement placement) {
		this.placement = placement;
	}

	public String getArchitecture() {
		return architecture;
	}

	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}

	public String getDnsName() {
		return dnsName;
	}

	public void setDnsName(String dnsName) {
		this.dnsName = dnsName;
	}

	public Boolean getEbsOptimized() {
		return ebsOptimized;
	}

	public void setEbsOptimized(Boolean ebsOptimized) {
		this.ebsOptimized = ebsOptimized;
	}

	public String getHypervisor() {
		return hypervisor;
	}

	public void setHypervisor(String hypervisor) {
		this.hypervisor = hypervisor;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getInstanceType() {
		return instanceType;
	}

	public void setInstanceType(String instanceType) {
		this.instanceType = instanceType;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public LocalDateTime getLaunchTime() {
		return launchTime;
	}

	public void setLaunchTime(LocalDateTime launchTime) {
		this.launchTime = launchTime;
	}

	public String getPrivateDnsName() {
		return privateDnsName;
	}

	public void setPrivateDnsName(String privateDnsName) {
		this.privateDnsName = privateDnsName;
	}

	public String getPrivateIpAddress() {
		return privateIpAddress;
	}

	public void setPrivateIpAddress(String privateIpAddress) {
		this.privateIpAddress = privateIpAddress;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getRootDeviceType() {
		return rootDeviceType;
	}

	public void setRootDeviceType(String rootDeviceType) {
		this.rootDeviceType = rootDeviceType;
	}

	public String getSubnetId() {
		return subnetId;
	}

	public void setSubnetId(String subnetId) {
		this.subnetId = subnetId;
	}

	public String getVirtualizationType() {
		return virtualizationType;
	}

	public void setVirtualizationType(String virtualizationType) {
		this.virtualizationType = virtualizationType;
	}

	public String getVpcId() {
		return vpcId;
	}

	public void setVpcId(String vpcId) {
		this.vpcId = vpcId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public LocalDateTime getAttachTime() {
		return attachTime;
	}

	public void setAttachTime(LocalDateTime attachTime) {
		this.attachTime = attachTime;
	}

	public Boolean getDeleteOnTermination() {
		return deleteOnTermination;
	}

	public void setDeleteOnTermination(Boolean deleteOnTermination) {
		this.deleteOnTermination = deleteOnTermination;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVolumeId() {
		return volumeId;
	}

	public void setVolumeId(String volumeId) {
		this.volumeId = volumeId;
	}

	public DescribeInstancesApiResponseSchemaDescribeInstancesResponseProductCodes getProductCodes() {
		return productCodes;
	}

	public void setProductCodes(DescribeInstancesApiResponseSchemaDescribeInstancesResponseProductCodes productCodes) {
		this.productCodes = productCodes;
	}

	public List<CreateDBInstancesApiRequestSchemaDbinstanceTag> getTagSet() {
		return tagSet;
	}

	public void setTagSet(List<CreateDBInstancesApiRequestSchemaDbinstanceTag> tagSet) {
		this.tagSet = tagSet;
	}

	public DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstanceState getInstanceState() {
		return instanceState;
	}

	public void setInstanceState(DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstanceState instanceState) {
		this.instanceState = instanceState;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public SubnetDTO getSubnet() {
		return subnet;
	}

	public void setSubnet(SubnetDTO subnet) {
		this.subnet = subnet;
	}

	public List<VolumeDTO> getElencoVolumi() {
		return elencoVolumi;
	}

	public void setElencoVolumi(List<VolumeDTO> elencoVolumi) {
		this.elencoVolumi = elencoVolumi;
	}

}
