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
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JobBackupDTO {
	private String availabilityZone = null;

	@JsonProperty("created")
	private LocalDateTime created = null;

	@JsonProperty("enabled")
	private Boolean enabled = null;

	@JsonProperty("hypervisor")
	private String hypervisor = "openstack";

	@JsonProperty("instanceNum")
	private Integer instanceNum = null;

	private List<CodiceEtichettaDescrizioneDTO> elencoIstanze;

	@JsonProperty("jobId")
	private String jobId = null;

	@JsonProperty("jobState")
	private String jobState = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("owner_id")
	private String ownerId = null;

	@JsonProperty("policy")
	private Object policy = null;

	@JsonProperty("reason")
	private String reason = null;

	@JsonProperty("updated")
	private LocalDateTime updated = null;

	public String getAvailabilityZone() {
		return availabilityZone;
	}

	public void setAvailabilityZone(String availabilityZone) {
		this.availabilityZone = availabilityZone;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getHypervisor() {
		return hypervisor;
	}

	public void setHypervisor(String hypervisor) {
		this.hypervisor = hypervisor;
	}

	public Integer getInstanceNum() {
		return instanceNum;
	}

	public void setInstanceNum(Integer instanceNum) {
		this.instanceNum = instanceNum;
	}

	public List<CodiceEtichettaDescrizioneDTO> getElencoIstanze() {
		return elencoIstanze;
	}

	public void setElencoIstanze(List<CodiceEtichettaDescrizioneDTO> elencoIstanze) {
		this.elencoIstanze = elencoIstanze;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobState() {
		return jobState;
	}

	public void setJobState(String jobState) {
		this.jobState = jobState;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public Object getPolicy() {
		return policy;
	}

	public void setPolicy(Object policy) {
		this.policy = policy;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		JobBackupDTO describeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet = (JobBackupDTO) o;
		return Objects.equals(this.availabilityZone,
				describeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet.availabilityZone)
				&& Objects.equals(this.created,
						describeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet.created)
				&& Objects.equals(this.enabled,
						describeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet.enabled)
				&& Objects.equals(this.hypervisor,
						describeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet.hypervisor)
				&& Objects.equals(this.instanceNum,
						describeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet.instanceNum)
				&& Objects.equals(this.jobId, describeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet.jobId)
				&& Objects.equals(this.jobState,
						describeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet.jobState)
				&& Objects.equals(this.name, describeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet.name)
				&& Objects.equals(this.ownerId,
						describeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet.ownerId)
				&& Objects.equals(this.policy, describeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet.policy)
				&& Objects.equals(this.reason, describeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet.reason)
				&& Objects.equals(this.updated,
						describeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet.updated);
	}

	@Override
	public int hashCode() {
		return Objects.hash(availabilityZone, created, enabled, hypervisor, instanceNum, jobId, jobState, name, ownerId,
				policy, reason, updated);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet {\n");

		sb.append("    availabilityZone: ").append(toIndentedString(availabilityZone)).append("\n");
		sb.append("    created: ").append(toIndentedString(created)).append("\n");
		sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
		sb.append("    hypervisor: ").append(toIndentedString(hypervisor)).append("\n");
		sb.append("    instanceNum: ").append(toIndentedString(instanceNum)).append("\n");
		sb.append("    jobId: ").append(toIndentedString(jobId)).append("\n");
		sb.append("    jobState: ").append(toIndentedString(jobState)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
		sb.append("    policy: ").append(toIndentedString(policy)).append("\n");
		sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
		sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
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
