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

import java.util.ArrayList;
import java.util.List;

public class CostiStrutturaRaggruppatiServizioDTO {
	
	private String nomeStruttura;
	
	private String uuid;
	
	private List<DettaglioServizioDTO> servizi = new ArrayList<DettaglioServizioDTO>();;

	public String getNomeStruttura() {
		return nomeStruttura;
	}

	public void setNomeStruttura(String nomeStruttura) {
		this.nomeStruttura = nomeStruttura;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public List<DettaglioServizioDTO> getServizi() {
		return servizi;
	}

	public void setServizi(List<DettaglioServizioDTO> servizi) {
		this.servizi = servizi;
	} 
	
	
	
}
