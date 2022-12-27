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

public class RichiestaCostiVmDTO implements Serializable {

	private static final long serialVersionUID = -8761333600591942573L;

	private int numCpu;
	
	private int gbRam;
	
	private int gbDiscoBase;
	
	private int gbDiscoPrestazionale;
	
	private boolean licenzaCommerciale;
	
	private String accountId;

	public int getNumCpu() {
		return numCpu;
	}

	public void setNumCpu(int numCpu) {
		this.numCpu = numCpu;
	}

	public int getGbRam() {
		return gbRam;
	}

	public void setGbRam(int gbRam) {
		this.gbRam = gbRam;
	}


	public int getGbDiscoBase() {
		return gbDiscoBase;
	}

	public void setGbDiscoBase(int gbDiscoBase) {
		this.gbDiscoBase = gbDiscoBase;
	}

	public int getGbDiscoPrestazionale() {
		return gbDiscoPrestazionale;
	}

	public void setGbDiscoPrestazionale(int gbDiscoPrestazionale) {
		this.gbDiscoPrestazionale = gbDiscoPrestazionale;
	}

	public boolean isLicenzaCommerciale() {
		return licenzaCommerciale;
	}

	public void setLicenzaCommerciale(boolean licenzaCommerciale) {
		this.licenzaCommerciale = licenzaCommerciale;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	
}
