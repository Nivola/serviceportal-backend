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

public class EstrazioneTotaliMetricaAccountDTO implements Serializable {

	private static final long serialVersionUID = 3553053517343507218L;
	
	private String refAccount = null;
	private String refDivisione = null;
	private String refOrganizzazione = null;
	private String metrica = null;
	private String metricaDescrizione = null;
	private String servizio = null;
	private Double totaleConsumo = null;
	private Double totaleCosto = null;
	
	
	public EstrazioneTotaliMetricaAccountDTO(String refAccount, String refDivisione, String refOrganizzazione, String metrica, String metricaDescrizione, String servizio, Double totaleConsumo, Double totaleCosto) {
		super();
		this.refAccount = refAccount;
		this.refDivisione = refDivisione;
		this.refOrganizzazione = refOrganizzazione;
		this.metrica = metrica;
		this.metricaDescrizione = metricaDescrizione;
		this.servizio = servizio;
		this.totaleConsumo = totaleConsumo;
		this.totaleCosto = totaleCosto;
	}

	public String getRefAccount() {
		return refAccount;
	}

	public void setRefAccount(String refAccount) {
		this.refAccount = refAccount;
	}

	public String getMetrica() {
		return metrica;
	}

	public void setMetrica(String metrica) {
		this.metrica = metrica;
	}

	public String getMetricaDescrizione() {
		return metricaDescrizione;
	}

	public void setMetricaDescrizione(String metricaDescrizione) {
		this.metricaDescrizione = metricaDescrizione;
	}

	public String getServizio() {
		return servizio;
	}

	public void setServizio(String servizio) {
		this.servizio = servizio;
	}

	public Double getTotaleConsumo() {
		return totaleConsumo;
	}

	public void setTotaleConsumo(Double totaleConsumo) {
		this.totaleConsumo = totaleConsumo;
	}

	public Double getTotaleCosto() {
		return totaleCosto;
	}

	public void setTotaleCosto(Double totaleCosto) {
		this.totaleCosto = totaleCosto;
	}

	public String getRefDivisione() {
		return refDivisione;
	}

	public void setRefDivisione(String refDivisione) {
		this.refDivisione = refDivisione;
	}

	public String getRefOrganizzazione() {
		return refOrganizzazione;
	}

	public void setRefOrganizzazione(String refOrganizzazione) {
		this.refOrganizzazione = refOrganizzazione;
	}
	
	
}
