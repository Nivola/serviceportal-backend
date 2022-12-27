/*-
 * ========================LICENSE_START=================================
 * Nivola Batch
 * %%
 * Copyright (C) 2022 CSI Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | CSI Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.remote.service;

public class RemoteControlException extends Exception {

	private static final long serialVersionUID = -1540910834919604005L;

	
	public RemoteControlException(String message) {
		super(message);
	}
}
