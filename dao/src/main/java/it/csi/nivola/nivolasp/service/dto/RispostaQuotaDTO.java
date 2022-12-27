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

public class RispostaQuotaDTO implements Serializable {
	
	private static final long serialVersionUID = -2437751042551211070L;
	
	private List<DescrizioneQuotaDTO> quoteCompute;
	private List<DescrizioneQuotaDTO> quoteDb;
	private List<DescrizioneQuotaDTO> quoteStorage;
	
	public List<DescrizioneQuotaDTO> getQuoteCompute() {
		return quoteCompute;
	}
	public void setQuoteCompute(List<DescrizioneQuotaDTO> quuoteCompute) {
		this.quoteCompute = quuoteCompute;
	}
	public List<DescrizioneQuotaDTO> getQuoteDb() {
		return quoteDb;
	}
	public void setQuoteDb(List<DescrizioneQuotaDTO> quoteDb) {
		this.quoteDb = quoteDb;
	}
	public List<DescrizioneQuotaDTO> getQuoteStorage() {
		return quoteStorage;
	}
	public void setQuoteStorage(List<DescrizioneQuotaDTO> quoteStorage) {
		this.quoteStorage = quoteStorage;
	}
	
	
	
	
}
