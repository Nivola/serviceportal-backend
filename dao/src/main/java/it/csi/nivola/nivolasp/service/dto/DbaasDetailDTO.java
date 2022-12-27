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
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DbaasDetailDTO extends DbaasDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7407645597011456206L;

	@JsonProperty("Address")
	private String address = null;

	@JsonProperty("Port")
	private Integer port = null;

	@JsonProperty("AllocatedStorage")
	private Integer allocatedStorage = 0;

	@JsonProperty("AutoMinorVersionUpgrade")
	private Boolean autoMinorVersionUpgrade = null;

	@JsonProperty("AvailabilityZone")
	private String availabilityZone = null;

	@JsonProperty("BackupRetentionPeriod")
	private Integer backupRetentionPeriod = null;

	@JsonProperty("CACertificateIdentifier")
	private String caCertificateIdentifier = null;

	@JsonProperty("CharacterSetName")
	private String characterSetName = null;

	@JsonProperty("CopyTagsToSnapshot")
	private Boolean copyTagsToSnapshot = null;

	@JsonProperty("DBClusterIdentifier")
	private String dbClusterIdentifier = null;

	@JsonProperty("DBInstanceArn")
	private String dbInstanceArn = null;

	@JsonProperty("DBInstanceClass")
	private String dbInstanceClass = null;

	@JsonProperty("DBInstanceIdentifier")
	private String dbInstanceIdentifier = null;

	@JsonProperty("DBInstanceStatus")
	private String dbInstanceStatus = null;

	@JsonProperty("DBName")
	private String dbName = null;

	@JsonProperty("DbInstancePort")
	private Integer dbInstancePort = null;

	@JsonProperty("DbiResourceId")
	private String dbiResourceId = null;

	@JsonProperty("Engine")
	private String engine = null;

	@JsonProperty("EngineVersion")
	private String engineVersion = null;

	@JsonProperty("EnhancedMonitoringResourceArn")
	private String enhancedMonitoringResourceArn = null;

	@JsonProperty("IAMDatabaseAuthenticationEnabled")
	private Boolean iaMDatabaseAuthenticationEnabled = null;

	@JsonProperty("InstanceCreateTime")
	private LocalDateTime instanceCreateTime = null;

	@JsonProperty("Iops")
	private Integer iops = null;

	@JsonProperty("KmsKeyId")
	private String kmsKeyId = null;

	@JsonProperty("LatestRestorableTime")
	private LocalDateTime latestRestorableTime = null;

	@JsonProperty("LicenseModel")
	private String licenseModel = null;

	@JsonProperty("MasterUsername")
	private String masterUsername = null;
	
	@JsonProperty("MasterUserpassword")
	private String masterUserpassword = null;

	@JsonProperty("MonitoringInterval")
	private Integer monitoringInterval = null;

	@JsonProperty("MonitoringRoleArn")
	private String monitoringRoleArn = null;

	@JsonProperty("MultiAZ")
	private Boolean multiAZ = null;

	@JsonProperty("PendingModifiedValues")
	private Object pendingModifiedValues = null;

	@JsonProperty("PerformanceInsightsEnabled")
	private Boolean performanceInsightsEnabled = null;

	@JsonProperty("PerformanceInsightsKMSKeyId")
	private String performanceInsightsKMSKeyId = null;

	@JsonProperty("PreferredBackupWindow")
	private String preferredBackupWindow = null;

	@JsonProperty("PreferredMaintenanceWindow")
	private String preferredMaintenanceWindow = null;

	@JsonProperty("PromotionTier")
	private Integer promotionTier = null;

	@JsonProperty("PubliclyAccessible")
	private Boolean publiclyAccessible = null;

	@JsonProperty("ReadReplicaDBClusterIdentifiers.ReadReplicaDBClusterIdentifier.N")
	private List<String> readReplicaDBClusterIdentifiersReadReplicaDBClusterIdentifierN = null;

	@JsonProperty("ReadReplicaDBInstanceIdentifiers.ReadReplicaDBInstanceIdentifier.N")
	private List<String> readReplicaDBInstanceIdentifiersReadReplicaDBInstanceIdentifierN = null;

	@JsonProperty("ReadReplicaSourceDBInstanceIdentifier")
	private String readReplicaSourceDBInstanceIdentifier = null;

	@JsonProperty("SecondaryAvailabilityZone")
	private String secondaryAvailabilityZone = null;

	@JsonProperty("StorageEncrypted")
	private Boolean storageEncrypted = null;

	@JsonProperty("StorageType")
	private String storageType = null;

	@JsonProperty("TdeCredentialArn")
	private String tdeCredentialArn = null;

	@JsonProperty("TdeCredentialPassword")
	private String tdeCredentialPassword = null;

	@JsonProperty("Timezone")
	private String timezone = null;

	@JsonProperty("nvl-name")
	private String nvlName = null;

	@JsonProperty("nvl-ownerAlias")
	private String nvlOwnerAlias = null;

	@JsonProperty("nvl-ownerId")
	private String nvlOwnerId = null;

	@JsonProperty("nvl-resourceId")
	private String nvlResourceId = null;
	
	private String subnet;
	
	private String securityGroup;

	@JsonProperty("EnabledCloudwatchLogsExports.member.N")
	private List<String> enabledCloudwatchLogsExportsMemberN = null;

	public Integer getAllocatedStorage() {
		return allocatedStorage;
	}

	public void setAllocatedStorage(Integer allocatedStorage) {
		this.allocatedStorage = allocatedStorage;
	}

	public Boolean getAutoMinorVersionUpgrade() {
		return autoMinorVersionUpgrade;
	}

	public void setAutoMinorVersionUpgrade(Boolean autoMinorVersionUpgrade) {
		this.autoMinorVersionUpgrade = autoMinorVersionUpgrade;
	}

	public String getAvailabilityZone() {
		return availabilityZone;
	}

	public void setAvailabilityZone(String availabilityZone) {
		this.availabilityZone = availabilityZone;
	}

	public Integer getBackupRetentionPeriod() {
		return backupRetentionPeriod;
	}

	public void setBackupRetentionPeriod(Integer backupRetentionPeriod) {
		this.backupRetentionPeriod = backupRetentionPeriod;
	}

	public String getCaCertificateIdentifier() {
		return caCertificateIdentifier;
	}

	public void setCaCertificateIdentifier(String caCertificateIdentifier) {
		this.caCertificateIdentifier = caCertificateIdentifier;
	}

	public String getCharacterSetName() {
		return characterSetName;
	}

	public void setCharacterSetName(String characterSetName) {
		this.characterSetName = characterSetName;
	}

	public Boolean getCopyTagsToSnapshot() {
		return copyTagsToSnapshot;
	}

	public void setCopyTagsToSnapshot(Boolean copyTagsToSnapshot) {
		this.copyTagsToSnapshot = copyTagsToSnapshot;
	}

	public String getDbClusterIdentifier() {
		return dbClusterIdentifier;
	}

	public void setDbClusterIdentifier(String dbClusterIdentifier) {
		this.dbClusterIdentifier = dbClusterIdentifier;
	}

	public String getDbInstanceArn() {
		return dbInstanceArn;
	}

	public void setDbInstanceArn(String dbInstanceArn) {
		this.dbInstanceArn = dbInstanceArn;
	}

	public String getDbInstanceClass() {
		return dbInstanceClass;
	}

	public void setDbInstanceClass(String dbInstanceClass) {
		this.dbInstanceClass = dbInstanceClass;
	}

	public String getDbInstanceIdentifier() {
		return dbInstanceIdentifier;
	}

	public void setDbInstanceIdentifier(String dbInstanceIdentifier) {
		this.dbInstanceIdentifier = dbInstanceIdentifier;
	}

	public String getDbInstanceStatus() {
		return dbInstanceStatus;
	}

	public void setDbInstanceStatus(String dbInstanceStatus) {
		this.dbInstanceStatus = dbInstanceStatus;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public Integer getDbInstancePort() {
		return dbInstancePort;
	}

	public void setDbInstancePort(Integer dbInstancePort) {
		this.dbInstancePort = dbInstancePort;
	}

	public String getDbiResourceId() {
		return dbiResourceId;
	}

	public void setDbiResourceId(String dbiResourceId) {
		this.dbiResourceId = dbiResourceId;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getEngineVersion() {
		return engineVersion;
	}

	public void setEngineVersion(String engineVersion) {
		this.engineVersion = engineVersion;
	}

	public String getEnhancedMonitoringResourceArn() {
		return enhancedMonitoringResourceArn;
	}

	public void setEnhancedMonitoringResourceArn(String enhancedMonitoringResourceArn) {
		this.enhancedMonitoringResourceArn = enhancedMonitoringResourceArn;
	}

	public Boolean getIaMDatabaseAuthenticationEnabled() {
		return iaMDatabaseAuthenticationEnabled;
	}

	public void setIaMDatabaseAuthenticationEnabled(Boolean iaMDatabaseAuthenticationEnabled) {
		this.iaMDatabaseAuthenticationEnabled = iaMDatabaseAuthenticationEnabled;
	}

	public LocalDateTime getInstanceCreateTime() {
		return instanceCreateTime;
	}

	public void setInstanceCreateTime(LocalDateTime instanceCreateTime) {
		this.instanceCreateTime = instanceCreateTime;
	}

	public Integer getIops() {
		return iops;
	}

	public void setIops(Integer iops) {
		this.iops = iops;
	}

	public String getKmsKeyId() {
		return kmsKeyId;
	}

	public void setKmsKeyId(String kmsKeyId) {
		this.kmsKeyId = kmsKeyId;
	}

	public LocalDateTime getLatestRestorableTime() {
		return latestRestorableTime;
	}

	public void setLatestRestorableTime(LocalDateTime latestRestorableTime) {
		this.latestRestorableTime = latestRestorableTime;
	}

	public String getLicenseModel() {
		return licenseModel;
	}

	public void setLicenseModel(String licenseModel) {
		this.licenseModel = licenseModel;
	}

	public String getMasterUsername() {
		return masterUsername;
	}

	public void setMasterUsername(String masterUsername) {
		this.masterUsername = masterUsername;
	}

	public Integer getMonitoringInterval() {
		return monitoringInterval;
	}

	public void setMonitoringInterval(Integer monitoringInterval) {
		this.monitoringInterval = monitoringInterval;
	}

	public String getMonitoringRoleArn() {
		return monitoringRoleArn;
	}

	public void setMonitoringRoleArn(String monitoringRoleArn) {
		this.monitoringRoleArn = monitoringRoleArn;
	}

	public Boolean getMultiAZ() {
		return multiAZ;
	}

	public void setMultiAZ(Boolean multiAZ) {
		this.multiAZ = multiAZ;
	}

	public Object getPendingModifiedValues() {
		return pendingModifiedValues;
	}

	public void setPendingModifiedValues(Object pendingModifiedValues) {
		this.pendingModifiedValues = pendingModifiedValues;
	}

	public Boolean getPerformanceInsightsEnabled() {
		return performanceInsightsEnabled;
	}

	public void setPerformanceInsightsEnabled(Boolean performanceInsightsEnabled) {
		this.performanceInsightsEnabled = performanceInsightsEnabled;
	}

	public String getPerformanceInsightsKMSKeyId() {
		return performanceInsightsKMSKeyId;
	}

	public void setPerformanceInsightsKMSKeyId(String performanceInsightsKMSKeyId) {
		this.performanceInsightsKMSKeyId = performanceInsightsKMSKeyId;
	}

	public String getPreferredBackupWindow() {
		return preferredBackupWindow;
	}

	public void setPreferredBackupWindow(String preferredBackupWindow) {
		this.preferredBackupWindow = preferredBackupWindow;
	}

	public String getPreferredMaintenanceWindow() {
		return preferredMaintenanceWindow;
	}

	public void setPreferredMaintenanceWindow(String preferredMaintenanceWindow) {
		this.preferredMaintenanceWindow = preferredMaintenanceWindow;
	}

	public Integer getPromotionTier() {
		return promotionTier;
	}

	public void setPromotionTier(Integer promotionTier) {
		this.promotionTier = promotionTier;
	}

	public Boolean getPubliclyAccessible() {
		return publiclyAccessible;
	}

	public void setPubliclyAccessible(Boolean publiclyAccessible) {
		this.publiclyAccessible = publiclyAccessible;
	}

	public List<String> getReadReplicaDBClusterIdentifiersReadReplicaDBClusterIdentifierN() {
		return readReplicaDBClusterIdentifiersReadReplicaDBClusterIdentifierN;
	}

	public void setReadReplicaDBClusterIdentifiersReadReplicaDBClusterIdentifierN(List<String> readReplicaDBClusterIdentifiersReadReplicaDBClusterIdentifierN) {
		this.readReplicaDBClusterIdentifiersReadReplicaDBClusterIdentifierN = readReplicaDBClusterIdentifiersReadReplicaDBClusterIdentifierN;
	}

	public List<String> getReadReplicaDBInstanceIdentifiersReadReplicaDBInstanceIdentifierN() {
		return readReplicaDBInstanceIdentifiersReadReplicaDBInstanceIdentifierN;
	}

	public void setReadReplicaDBInstanceIdentifiersReadReplicaDBInstanceIdentifierN(List<String> readReplicaDBInstanceIdentifiersReadReplicaDBInstanceIdentifierN) {
		this.readReplicaDBInstanceIdentifiersReadReplicaDBInstanceIdentifierN = readReplicaDBInstanceIdentifiersReadReplicaDBInstanceIdentifierN;
	}

	public String getReadReplicaSourceDBInstanceIdentifier() {
		return readReplicaSourceDBInstanceIdentifier;
	}

	public void setReadReplicaSourceDBInstanceIdentifier(String readReplicaSourceDBInstanceIdentifier) {
		this.readReplicaSourceDBInstanceIdentifier = readReplicaSourceDBInstanceIdentifier;
	}

	public String getSecondaryAvailabilityZone() {
		return secondaryAvailabilityZone;
	}

	public void setSecondaryAvailabilityZone(String secondaryAvailabilityZone) {
		this.secondaryAvailabilityZone = secondaryAvailabilityZone;
	}

	public Boolean getStorageEncrypted() {
		return storageEncrypted;
	}

	public void setStorageEncrypted(Boolean storageEncrypted) {
		this.storageEncrypted = storageEncrypted;
	}

	public String getStorageType() {
		return storageType;
	}

	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}

	public String getTdeCredentialArn() {
		return tdeCredentialArn;
	}

	public void setTdeCredentialArn(String tdeCredentialArn) {
		this.tdeCredentialArn = tdeCredentialArn;
	}

	public String getTdeCredentialPassword() {
		return tdeCredentialPassword;
	}

	public void setTdeCredentialPassword(String tdeCredentialPassword) {
		this.tdeCredentialPassword = tdeCredentialPassword;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getNvlName() {
		return nvlName;
	}

	public void setNvlName(String nvlName) {
		this.nvlName = nvlName;
	}

	public String getNvlOwnerAlias() {
		return nvlOwnerAlias;
	}

	public void setNvlOwnerAlias(String nvlOwnerAlias) {
		this.nvlOwnerAlias = nvlOwnerAlias;
	}

	public String getNvlOwnerId() {
		return nvlOwnerId;
	}

	public void setNvlOwnerId(String nvlOwnerId) {
		this.nvlOwnerId = nvlOwnerId;
	}

	public String getNvlResourceId() {
		return nvlResourceId;
	}

	public void setNvlResourceId(String nvlResourceId) {
		this.nvlResourceId = nvlResourceId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public List<String> getEnabledCloudwatchLogsExportsMemberN() {
		return enabledCloudwatchLogsExportsMemberN;
	}

	public void setEnabledCloudwatchLogsExportsMemberN(List<String> enabledCloudwatchLogsExportsMemberN) {
		this.enabledCloudwatchLogsExportsMemberN = enabledCloudwatchLogsExportsMemberN;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSubnet() {
		return subnet;
	}

	public void setSubnet(String subnet) {
		this.subnet = subnet;
	}

	public String getSecurityGroup() {
		return securityGroup;
	}

	public void setSecurityGroup(String securityGroup) {
		this.securityGroup = securityGroup;
	}

	public String getMasterUserpassword() {
		return masterUserpassword;
	}

	public void setMasterUserpassword(String masterUserpassword) {
		this.masterUserpassword = masterUserpassword;
	}
	
	

}
