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
import java.util.Map;

public class InfoGraficoDTO {
	
	private Long responseDate = System.currentTimeMillis();
	
	private ValutaDTO valuta = new ValutaDTO();
	
	Map<InfoGraficoServizioDTO, List<RigaCostoDTO>> mappaCosti;
	
//	private List<RigaCostoDTO> costiCPAAS;
	
//	private List<RigaCostoDTO> costiDBAAS;
	
//	private List<RigaCostoDTO> costiSTAAS;

	private List<CostoAccountDTO> elencoAccounts = null;

	public List<CostoAccountDTO> getElencoAccounts() {
		return elencoAccounts;
	}

	public void setElencoAccounts(List<CostoAccountDTO> elencoAccounts) {
		this.elencoAccounts = elencoAccounts;
	}
	

	public ValutaDTO getValuta() {
		return valuta;
	}

	public void setValuta(ValutaDTO valuta) {
		this.valuta = valuta;
	}

	public Long getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(Long responseDate) {
		this.responseDate = responseDate;
	}
	
	
}
