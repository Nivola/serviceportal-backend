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
package it.csi.nivola.nivolasp.service;

public class ServiceException extends Exception {

	
	private static final long serialVersionUID = 6403993918001299567L;
	
	public ServiceException(String messaggio) {
		super(messaggio);
	}

}
