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

public class CostoDelMeseDTO implements Serializable {

	private static final long serialVersionUID = 3520496407489213665L;

	private String periodoDA;

	private String periodoA;

	private ValutaDTO valuta;

	private Double totaleConsumiNonRendicontati;

	private Integer totale;

	private List<CostoDelMeseRigaDTO> elencoServizi;

	private String periodo;
	
	private String nomeStruttura;

	public String getPeriodoDA() {
		return periodoDA;
	}

	public void setPeriodoDA(String periodoDA) {
		this.periodoDA = periodoDA;
	}

	public String getPeriodoA() {
		return periodoA;
	}

	public void setPeriodoA(String periodoA) {
		this.periodoA = periodoA;
	}

	public ValutaDTO getValuta() {
		return valuta;
	}

	public void setValuta(ValutaDTO valuta) {
		this.valuta = valuta;
	}

	public Double getTotaleConsumiNonRendicontati() {
		return totaleConsumiNonRendicontati;
	}

	public void setTotaleConsumiNonRendicontati(Double totaleConsumiNonRendicontati) {
		this.totaleConsumiNonRendicontati = totaleConsumiNonRendicontati;
	}

	public List<CostoDelMeseRigaDTO> getElencoServizi() {
		return elencoServizi;
	}

	public void setElencoServizi(List<CostoDelMeseRigaDTO> elencoServizi) {
		this.elencoServizi = elencoServizi;
	}

	public Integer getTotale() {
		return totale;
	}

	public void setTotale(Integer totale) {
		this.totale = totale;
	}

	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getNomeStruttura() {
		return nomeStruttura;
	}

	public void setNomeStruttura(String nomeStruttura) {
		this.nomeStruttura = nomeStruttura;
	}


}
