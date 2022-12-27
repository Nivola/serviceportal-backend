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

public class ValoreStoricoCostoListinoDTO extends ValoreCostoListinoDTO {

	private List<ValoreCostoListinoDTO> elencoStorici;

	public List<ValoreCostoListinoDTO> getElencoStorici() {
		return elencoStorici;
	}

	public void setElencoStorici(List<ValoreCostoListinoDTO> elencoStorici) {
		this.elencoStorici = elencoStorici;
	}
	
	
}
