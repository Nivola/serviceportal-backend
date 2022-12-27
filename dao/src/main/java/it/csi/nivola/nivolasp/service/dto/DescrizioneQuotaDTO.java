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

public class DescrizioneQuotaDTO implements Serializable {

	private static final long serialVersionUID = 8625923201464806334L;

	private String nomeQuota;

	private List<QuotaDTO> valori;

	private String unitaMisura;

	public String getNomeQuota() {
		return nomeQuota;
	}

	public void setNomeQuota(String nomeQuota) {
		this.nomeQuota = nomeQuota;
	}

	public List<QuotaDTO> getValori() {
		return valori;
	}

	public void setValori(List<QuotaDTO> valori) {
		this.valori = valori;
	}

	public String getUnitaMisura() {
		return unitaMisura;
	}

	public void setUnitaMisura(String unitaMisura) {
		this.unitaMisura = unitaMisura;
	}
}
