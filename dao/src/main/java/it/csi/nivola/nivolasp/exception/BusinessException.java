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
package it.csi.nivola.nivolasp.exception;

public class BusinessException extends Exception {
	
	private Integer statusCode;
	
	private String codiceErrore;

	private static final long serialVersionUID = -4046331460359358526L;

	public BusinessException(String messaggio) {
		super(messaggio);
	}
	
	public BusinessException(String messaggio, String codiceErrore) {
		super(messaggio);
		this.codiceErrore = codiceErrore;
	}
	
	public BusinessException(String messaggio, String codiceErrore, Integer statusCode) {
		super(messaggio);
		this.codiceErrore = codiceErrore;
		this.statusCode = statusCode;
	}

	public BusinessException(Exception e1) {
		super (e1);
	}

	public String getCodiceErrore() {
		return codiceErrore;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	
	
	
	

}
