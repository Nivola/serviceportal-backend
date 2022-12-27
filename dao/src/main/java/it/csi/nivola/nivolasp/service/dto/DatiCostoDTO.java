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

public class DatiCostoDTO {
	
	private Long responseDate = System.currentTimeMillis();
	
	private ValutaDTO valuta = new ValutaDTO();
	
	private List<RigaCostoDTO> costiCPAAS;
	
	private List<RigaCostoDTO> costiDBAAS;
	
	private List<RigaCostoDTO> costiSTAAS;

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

	public List<RigaCostoDTO> getCostiCPAAS() {
		return costiCPAAS;
	}

	public void setCostiCPAAS(List<RigaCostoDTO> costiCPAAS) {
		this.costiCPAAS = costiCPAAS;
	}

	public List<RigaCostoDTO> getCostiDBAAS() {
		return costiDBAAS;
	}

	public void setCostiDBAAS(List<RigaCostoDTO> costiDBAAS) {
		this.costiDBAAS = costiDBAAS;
	}

	public List<RigaCostoDTO> getCostiSTAAS() {
		return costiSTAAS;
	}

	public void setCostiSTAAS(List<RigaCostoDTO> costiSTAAS) {
		this.costiSTAAS = costiSTAAS;
	}

	public Long getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(Long responseDate) {
		this.responseDate = responseDate;
	}
	
	
}
