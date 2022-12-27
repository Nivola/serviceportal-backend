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

public class RichiestaSnapshotVmDTO implements Serializable {

	private static final long serialVersionUID = -4892126225937311866L;

	private String accountId;
	
	private String instanceId;
	
	private String nomeSnapshot;
	
	private String idSnapshot;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public String getNomeSnapshot() {
		return nomeSnapshot;
	}

	public void setNomeSnapshot(String nomeSnapshot) {
		this.nomeSnapshot = nomeSnapshot;
	}

	public String getIdSnapshot() {
		return idSnapshot;
	}

	public void setIdSnapshot(String idSnapshot) {
		this.idSnapshot = idSnapshot;
	}
	
}
