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

public class ProspettoCostiStorageDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private double costoUnitarioStorage;
	
	private double costoTotaleStorage;

	public double getCostoUnitarioStorage() {
		return costoUnitarioStorage;
	}

	public void setCostoUnitarioStorage(double costoUnitarioStorage) {
		this.costoUnitarioStorage = costoUnitarioStorage;
	}

	public double getCostoTotaleStorage() {
		return costoTotaleStorage;
	}

	public void setCostoTotaleStorage(double costoTotaleStorage) {
		this.costoTotaleStorage = costoTotaleStorage;
	}
	
	
	
}
