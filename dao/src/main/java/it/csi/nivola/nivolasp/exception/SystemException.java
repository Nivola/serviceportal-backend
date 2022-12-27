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

public class SystemException extends RuntimeException {

	private static final long serialVersionUID = -4463314854148780884L;

	public SystemException (Throwable e) {
		super(e);
	}
}
