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

public class CalcoloCostiVmDTO implements Serializable {

	private static final long serialVersionUID = -282050242900654782L;

	private double costoUnitario;
	
	private double costoTotale;
	
	

	public CalcoloCostiVmDTO(double costoUnitario, double costoTotale) {
		super();
		this.costoUnitario = costoUnitario;
		this.costoTotale = costoTotale;
	}

	public double getCostoUnitario() {
		return costoUnitario;
	}

	public void setCostoUnitario(double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

	public double getCostoTotale() {
		return costoTotale;
	}

	public void setCostoTotale(double costoTotale) {
		this.costoTotale = costoTotale;
	}
	
	
}
