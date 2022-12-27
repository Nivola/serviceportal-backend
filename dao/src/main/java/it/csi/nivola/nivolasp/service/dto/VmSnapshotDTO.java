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

import com.fasterxml.jackson.annotation.JsonProperty;

public class VmSnapshotDTO implements Serializable {
	
	private static final long serialVersionUID = -6397236185089432875L;

	@JsonProperty("dataCreazione")
	private String createTime = null;

	@JsonProperty("snapshotId")
	private String snapshotId = null;

	@JsonProperty("snapshotName")
	private String snapshotName = null;

	@JsonProperty("snapshotStatus")
	private String snapshotStatus = null;

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getSnapshotId() {
		return snapshotId;
	}

	public void setSnapshotId(String snapshotId) {
		this.snapshotId = snapshotId;
	}

	public String getSnapshotName() {
		return snapshotName;
	}

	public void setSnapshotName(String snapshotName) {
		this.snapshotName = snapshotName;
	}

	public String getSnapshotStatus() {
		return snapshotStatus;
	}

	public void setSnapshotStatus(String snapshotStatus) {
		this.snapshotStatus = snapshotStatus;
	}
	
}
