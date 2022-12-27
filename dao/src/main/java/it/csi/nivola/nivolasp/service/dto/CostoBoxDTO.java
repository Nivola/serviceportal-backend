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
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CostoBoxDTO implements Serializable {

	private static final long serialVersionUID = 3564132719988718802L;

	private BigDecimal costoDellaGiornata;

	private BigDecimal costoMeseInCorso;

	private String giornoRiferimento;

	private String meseRiferimento;

	private String annoRiferimento;

	public BigDecimal getCostoDellaGiornata() {
		return costoDellaGiornata;
	}

	public void setCostoDellaGiornata(BigDecimal costoDellaGiornata) {
		this.costoDellaGiornata = costoDellaGiornata;
	}

	public BigDecimal getCostoMeseInCorso() {
		return costoMeseInCorso;
	}

	public void setCostoMeseInCorso(BigDecimal costoMeseInCorso) {
		this.costoMeseInCorso = costoMeseInCorso;
	}

	public String getGiornoRiferimento() {
		return giornoRiferimento;
	}

	public void setGiornoRiferimento(String giornoRiferimento) {
		this.giornoRiferimento = giornoRiferimento;
	}

	public String getMeseRiferimento() {
		return meseRiferimento;
	}

	public void setMeseRiferimento(String meseRiferimento) {
		this.meseRiferimento = meseRiferimento;
	}

	public String getAnnoRiferimento() {
		return annoRiferimento;
	}

	public void setAnnoRiferimento(String annoRiferimento) {
		this.annoRiferimento = annoRiferimento;
	}


}
