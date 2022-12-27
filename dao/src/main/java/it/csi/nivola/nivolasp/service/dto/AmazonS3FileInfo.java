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

import java.util.Date;

public class AmazonS3FileInfo {

	private String id;
	
	private String nomeFile;
	
	private long dimensione;
	
	private Date dataModifica;
	
	private String tipoDocumento;
	
	private String idAccount;
	
	public AmazonS3FileInfo() {
		
	}

	public AmazonS3FileInfo(String id, String nomeFile, long dimensione, Date dataModifica, String tipoDocumento) {
		super();
		this.id = id;
		this.nomeFile = nomeFile;
		this.dimensione = dimensione;
		this.dataModifica = dataModifica;
		this.tipoDocumento = tipoDocumento;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	public long getDimensione() {
		return dimensione;
	}

	public void setDimensione(long dimensione) {
		this.dimensione = dimensione;
	}

	public Date getDataModifica() {
		return dataModifica;
	}

	public void setDataModifica(Date dataModifica) {
		this.dataModifica = dataModifica;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(String idAccount) {
		this.idAccount = idAccount;
	}
	
	
}
