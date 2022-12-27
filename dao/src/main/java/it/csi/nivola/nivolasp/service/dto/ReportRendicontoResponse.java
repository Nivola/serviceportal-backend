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

public class ReportRendicontoResponse extends ServiceBaseResponse {

	private byte[] report;
	
	private String nomeFile;

	public byte[] getReport() {
		return report;
	}
	
	

	public String getNomeFile() {
		return nomeFile;
	}



	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}



	public void setReport(byte[] report) {
		this.report = report;
	}
}
