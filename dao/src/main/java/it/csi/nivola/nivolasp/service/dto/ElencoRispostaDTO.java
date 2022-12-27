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

import java.util.List;

public class ElencoRispostaDTO<T> {
	
	private String requestId;
	
	private long totali;
	
	private List<T> risultati;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public long getTotali() {
		return totali;
	}

	public void setTotali(long totali) {
		this.totali = totali;
	}

	public List<T> getRisultati() {
		return risultati;
	}

	public void setRisultati(List<T> risultati) {
		this.risultati = risultati;
	}
	
	

}
