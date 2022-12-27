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

public class RigaCostoDTO implements Serializable {

	private static final long serialVersionUID = 7243713365315475346L;

	private Long data;
	
	private Double valore;
	
	private String dataAsString;

	public Long getData() {
		return data;
	}

	public void setData(Long data) {
		this.data = data;
	}

	public Double getValore() {
		return valore;
	}

	public void setValore(Double valore) {
		this.valore = valore;
	}

	public String getDataAsString() {
		return dataAsString;
	}

	public void setDataAsString(String dataAsString) {
		this.dataAsString = dataAsString;
	}
	
	
	
}
