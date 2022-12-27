/*-
 * ========================LICENSE_START=================================
 * Api Remedy
 * %%
 * Copyright (C) 2022 Regione Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | Regione Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.integration.remedy.portal.service;

public class RemedyServiceException extends Exception {
	
	private TipoErroreEnum errore;

	private static final long serialVersionUID = -3640061298802486917L;
	
	public RemedyServiceException(String message) {
		super(message);
	}
	
	public RemedyServiceException(String message, TipoErroreEnum errore) {
		super(message);
		this.errore = errore;
	}

	public TipoErroreEnum getErrore() {
		return errore;
	}

	public void setErrore(TipoErroreEnum errore) {
		this.errore = errore;
	}

	
}
