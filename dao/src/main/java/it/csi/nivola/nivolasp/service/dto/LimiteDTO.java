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

public class LimiteDTO implements Serializable {

	private static final long serialVersionUID = -5846254056886132175L;
	
	private String limiteMin;
	private String limiteMax;
	public String getLimiteMin() {
		return limiteMin;
	}
	public void setLimiteMin(String limiteMin) {
		this.limiteMin = limiteMin;
	}
	public String getLimiteMax() {
		return limiteMax;
	}
	public void setLimiteMax(String limiteMax) {
		this.limiteMax = limiteMax;
	}
	
	

}
