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

public class ElencoTipiVolumeRisposta implements Serializable {

	private static final long serialVersionUID = 9108283014284564424L;
	
	private Integer totali;
	
	private String requestId;
	
	private List<TipoVolumeDTO> elencoTipiVolume = null;

	public List<TipoVolumeDTO> getElencoTipiVolume() {
		return elencoTipiVolume;
	}

	public void setElencoTipiVolume(List<TipoVolumeDTO> elencoTipiVolume) {
		this.elencoTipiVolume = elencoTipiVolume;
	}

	public Integer getTotali() {
		return totali;
	}

	public void setTotali(Integer totali) {
		this.totali = totali;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	
	
}
