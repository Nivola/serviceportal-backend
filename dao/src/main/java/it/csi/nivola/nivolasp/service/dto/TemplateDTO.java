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

import com.fasterxml.jackson.annotation.JsonProperty;

public class TemplateDTO extends AbstractDTO {

	private static final long serialVersionUID = -4393929730811829939L;

	@JsonProperty("architecture")
	private String architecture = null;

	@JsonProperty("creationDate")
	private LocalDateTime creationDate = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("enaSupport")
	private Boolean enaSupport = null;

	@JsonProperty("hypervisor")
	private String hypervisor = null;

	@JsonProperty("imageId")
	private String imageId = null;

	@JsonProperty("imageLocation")
	private String imageLocation = null;

	@JsonProperty("imageOwnerAlias")
	private String imageOwnerAlias = null;

	@JsonProperty("imageOwnerId")
	private String imageOwnerId = null;

	@JsonProperty("imageState")
	private String imageState = null;

	@JsonProperty("imageType")
	private String imageType = null;

	@JsonProperty("isPublic")
	private Boolean isPublic = null;

	@JsonProperty("kernelId")
	private String kernelId = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("platform")
	private String platform = null;

	@JsonProperty("ramdiskId")
	private String ramdiskId = null;

	@JsonProperty("rootDeviceName")
	private String rootDeviceName = null;

	@JsonProperty("rootDeviceType")
	private String rootDeviceType = null;

	@JsonProperty("sriovNetSupport")
	private String sriovNetSupport = null;

	@JsonProperty("virtualizationType")
	private String virtualizationType = null;

	public String getArchitecture() {
		return architecture;
	}

	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getEnaSupport() {
		return enaSupport;
	}

	public void setEnaSupport(Boolean enaSupport) {
		this.enaSupport = enaSupport;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getImageLocation() {
		return imageLocation;
	}

	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

	public String getImageOwnerAlias() {
		return imageOwnerAlias;
	}

	public void setImageOwnerAlias(String imageOwnerAlias) {
		this.imageOwnerAlias = imageOwnerAlias;
	}

	public String getImageOwnerId() {
		return imageOwnerId;
	}

	public void setImageOwnerId(String imageOwnerId) {
		this.imageOwnerId = imageOwnerId;
	}

	public String getImageState() {
		return imageState;
	}

	public void setImageState(String imageState) {
		this.imageState = imageState;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public Boolean getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	public String getKernelId() {
		return kernelId;
	}

	public void setKernelId(String kernelId) {
		this.kernelId = kernelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getRamdiskId() {
		return ramdiskId;
	}

	public void setRamdiskId(String ramdiskId) {
		this.ramdiskId = ramdiskId;
	}

	public String getRootDeviceName() {
		return rootDeviceName;
	}

	public void setRootDeviceName(String rootDeviceName) {
		this.rootDeviceName = rootDeviceName;
	}

	public String getRootDeviceType() {
		return rootDeviceType;
	}

	public void setRootDeviceType(String rootDeviceType) {
		this.rootDeviceType = rootDeviceType;
	}

	public String getSriovNetSupport() {
		return sriovNetSupport;
	}

	public void setSriovNetSupport(String sriovNetSupport) {
		this.sriovNetSupport = sriovNetSupport;
	}

	public String getVirtualizationType() {
		return virtualizationType;
	}

	public void setVirtualizationType(String virtualizationType) {
		this.virtualizationType = virtualizationType;
	}

	public String getHypervisor() {
		return hypervisor;
	}

	public void setHypervisor(String hypervisor) {
		this.hypervisor = hypervisor;
	}
	
	
	
}
