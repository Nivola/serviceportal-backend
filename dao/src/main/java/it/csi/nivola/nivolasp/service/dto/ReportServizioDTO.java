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

public class ReportServizioDTO {
	private String color;
	private String servizio;
	private String servizioNome;
	private String metrica;
	private Double quantita;
	private Double costo;
	
	
	
	public ReportServizioDTO(String servizio, Double quantita, Double costo) {
		super();
		this.servizio = servizio;
		this.quantita = quantita;
		this.costo = costo;
	}
	
	
	public ReportServizioDTO(String color, String servizio, Double quantita, Double costo) {
		super();
		this.servizio = servizio;
		this.quantita = quantita;
		this.costo = costo;
		this.color = color;
	}
	
	public ReportServizioDTO(String color, String servizio, Double quantita, Double costo, String metrica) {
		super();
		this.servizio = servizio;
		this.quantita = quantita;
		this.costo = costo;
		this.color = color;
		this.metrica = metrica;
	}
	
	
	
	public ReportServizioDTO(String color, String servizio, String servizioNome, String metrica, Double quantita, Double costo) {
		super();
		this.color = color;
		this.servizio = servizio;
		this.servizioNome = servizioNome;
		this.metrica = metrica;
		this.quantita = quantita;
		this.costo = costo;
	}


	public String getServizio() {
		return servizio;
	}
	public void setServizio(String servizio) {
		this.servizio = servizio;
	}
	public Double getQuantita() {
		return quantita;
	}
	public void setQuantita(Double quantita) {
		this.quantita = quantita;
	}
	public Double getCosto() {
		return costo;
	}
	public void setCosto(Double costo) {
		this.costo = costo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}


	public String getMetrica() {
		return metrica;
	}


	public void setMetrica(String metrica) {
		this.metrica = metrica;
	}


	public String getServizioNome() {
		return servizioNome;
	}


	public void setServizioNome(String servizioNome) {
		this.servizioNome = servizioNome;
	}
	
}
