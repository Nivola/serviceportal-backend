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

public class DiscoAggiuntivoDTO implements Serializable {
	
	private static final long serialVersionUID = 1592725718156975487L;

	private Integer dimensioneDisco;
	
	private String tipoDisco;

	public Integer getDimensioneDisco() {
		return dimensioneDisco;
	}

	public void setDimensioneDisco(Integer dimensioneDisco) {
		this.dimensioneDisco = dimensioneDisco;
	}

	public String getTipoDisco() {
		return tipoDisco;
	}

	public void setTipoDisco(String tipoDisco) {
		this.tipoDisco = tipoDisco;
	}
	
	

}
