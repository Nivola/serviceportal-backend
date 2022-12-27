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
import java.util.List;

public class RispostaElencoVolumiDTO implements Serializable {
	
	private static final long serialVersionUID = 5559318253494198233L;

	private Integer numeroVolumiTotali;
	
	private String requestId;
	
	List<VolumeDTO> elencoVolumi;

	public Integer getNumeroVolumiTotali() {
		return numeroVolumiTotali;
	}

	public void setNumeroVolumiTotali(Integer numeroVolumiTotali) {
		this.numeroVolumiTotali = numeroVolumiTotali;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public List<VolumeDTO> getElencoVolumi() {
		return elencoVolumi;
	}

	public void setElencoVolumi(List<VolumeDTO> elencoVolumi) {
		this.elencoVolumi = elencoVolumi;
	}
	
	
	
}
