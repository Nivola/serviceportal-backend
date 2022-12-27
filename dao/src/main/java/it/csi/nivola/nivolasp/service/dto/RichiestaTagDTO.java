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

/**
 * Classe che modella i dati tipici per il frontend di tipo codice - etichetta - descrizione estesa
 *
 */
public class RichiestaTagDTO {
	
	private String accountId;
	
	private String risorsaId;
	
	private List<TagDTO> tags;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getRisorsaId() {
		return risorsaId;
	}

	public void setRisorsaId(String risorsaId) {
		this.risorsaId = risorsaId;
	}

	public List<TagDTO> getTags() {
		return tags;
	}

	public void setTags(List<TagDTO> tags) {
		this.tags = tags;
	}
	
	
}
