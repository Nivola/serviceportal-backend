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

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;


public class StaasDTO implements Serializable {

	private static final long serialVersionUID = 8167924446350506181L;

	@JsonProperty("dataCreazione")
	private LocalDateTime creationTime = null;

	@JsonProperty("creationToken")
	private String creationToken = null;

	@JsonProperty("criptata")
	private Boolean encrypted = false;

	@JsonProperty("fileSystemId")
	private String fileSystemId = null;

	@JsonProperty("kmsKeyId")
	private String kmsKeyId = null;
	
	private Integer nuovaDimensione;
	
	private List<String> nvlCapabilities = null;
	
	private List<MountTargetDTO> mountTargets;
	

	private List<Tag> elencoTag = new ArrayList<Tag>();

	/**
	 * Stato del File System
	 */
	public enum StatoFileSystemEnum {
		CREATING("creating"),

		AVAILABLE("available"),

		DELETING("deleting"),

		DELETED("deleted"),
		
	    UNKNOWN("unknown"),
		  
		ERROR("error");

		private String value;

		StatoFileSystemEnum(String value) {
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
		public static StatoFileSystemEnum fromValue(String text) {
			for (StatoFileSystemEnum b : StatoFileSystemEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("statoFileSystem")
	private StatoFileSystemEnum lifeCycleState = null;

	@JsonProperty("nome")
	private String name = null;

	@JsonProperty("numberOfMountTargets")
	private Integer numberOfMountTargets = 0;

	@JsonProperty("accountId")
	private String ownerId = null;

	/**
	 * 
	 */
	public enum PerformanceModeEnum {
		GENERALPURPOSE("generalPurpose"),
		

	    LOCALPURPOSE("localPurpose"),

		MAXIO("maxIO");

		private String value;

		PerformanceModeEnum(String value) {
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
		public static PerformanceModeEnum fromValue(String text) {
			for (PerformanceModeEnum b : PerformanceModeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("performanceMode")
	private PerformanceModeEnum performanceMode = PerformanceModeEnum.GENERALPURPOSE;

	@JsonProperty("provisionedThroughputInMibps")
	private Integer provisionedThroughputInMibps = null;

	@JsonProperty("dimensioneInByte")
	private Float dimensioneInByte = null;

	/**
	 * The throughput mode for a file system. There are two throughput modes to
	 * choose from for your file system: bursting and provisioned.
	 */
	public enum ThroughputModeEnum {
		BURSTING("bursting"),

		PROVISIONED("provisioned");

		private String value;

		ThroughputModeEnum(String value) {
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
		public static ThroughputModeEnum fromValue(String text) {
			for (ThroughputModeEnum b : ThroughputModeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("throughputMode")
	private ThroughputModeEnum throughputMode = null;

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	public String getCreationToken() {
		return creationToken;
	}

	public void setCreationToken(String creationToken) {
		this.creationToken = creationToken;
	}

	public Boolean getEncrypted() {
		return encrypted;
	}

	public void setEncrypted(Boolean encrypted) {
		this.encrypted = encrypted;
	}

	public String getFileSystemId() {
		return fileSystemId;
	}

	public void setFileSystemId(String fileSystemId) {
		this.fileSystemId = fileSystemId;
	}

	public String getKmsKeyId() {
		return kmsKeyId;
	}

	public void setKmsKeyId(String kmsKeyId) {
		this.kmsKeyId = kmsKeyId;
	}

	public StatoFileSystemEnum getLifeCycleState() {
		return lifeCycleState;
	}

	public void setLifeCycleState(StatoFileSystemEnum lifeCycleState) {
		this.lifeCycleState = lifeCycleState;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumberOfMountTargets() {
		return numberOfMountTargets;
	}

	public void setNumberOfMountTargets(Integer numberOfMountTargets) {
		this.numberOfMountTargets = numberOfMountTargets;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public PerformanceModeEnum getPerformanceMode() {
		return performanceMode;
	}

	public void setPerformanceMode(PerformanceModeEnum performanceMode) {
		this.performanceMode = performanceMode;
	}

	public Integer getProvisionedThroughputInMibps() {
		return provisionedThroughputInMibps;
	}

	public void setProvisionedThroughputInMibps(Integer provisionedThroughputInMibps) {
		this.provisionedThroughputInMibps = provisionedThroughputInMibps;
	}

	public Float getDimensioneInByte() {
		return dimensioneInByte;
	}

	public void setDimensioneInByte(Float value) {
		this.dimensioneInByte = value;
	}

	public ThroughputModeEnum getThroughputMode() {
		return throughputMode;
	}

	public void setThroughputMode(ThroughputModeEnum throughputMode) {
		this.throughputMode = throughputMode;
	}

	public List<MountTargetDTO> getMountTargets() {
		return mountTargets;
	}

	public void setMountTargets(List<MountTargetDTO> mountTargets) {
		this.mountTargets = mountTargets;
	}

	public Integer getNuovaDimensione() {
		return nuovaDimensione;
	}

	public void setNuovaDimensione(Integer nuovaDimensione) {
		this.nuovaDimensione = nuovaDimensione;
	}

	public List<Tag> getElencoTag() {
		return elencoTag;
	}

	public void setElencoTag(List<Tag> elencoTag) {
		this.elencoTag = elencoTag;
	}

	public List<String> getNvlCapabilities() {
		return nvlCapabilities;
	}

	public void setNvlCapabilities(List<String> nvlCapabilities) {
		this.nvlCapabilities = nvlCapabilities;
	}
	
	
}
