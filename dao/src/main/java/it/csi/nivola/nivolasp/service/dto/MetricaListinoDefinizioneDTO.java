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
 * Classe che definisce una voce di listino - si appoggia alla definizione di metrica
 *
 */
public class MetricaListinoDefinizioneDTO extends MetricaDTO {

	private static final long serialVersionUID = -493200750585952026L;

	public enum TipoDefinizioneEnum {
		NUMERICO, ALFANUMERICO, LISTA;
	}

	private String idDefinizione;
	
	private TipoDefinizioneEnum tipo = TipoDefinizioneEnum.NUMERICO;
	
	private List<CodiceEtichettaDescrizioneDTO> elencoValoriAmmessi;

	public TipoDefinizioneEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoDefinizioneEnum tipo) {
		this.tipo = tipo;
	}

	public List<CodiceEtichettaDescrizioneDTO> getElencoValoriAmmessi() {
		return elencoValoriAmmessi;
	}

	public void setElencoValoriAmmessi(List<CodiceEtichettaDescrizioneDTO> elencoValoriAmmessi) {
		this.elencoValoriAmmessi = elencoValoriAmmessi;
	}

	public String getIdDefinizione() {
		return idDefinizione;
	}

	public void setIdDefinizione(String idDefinizione) {
		this.idDefinizione = idDefinizione;
	}
	
	
	

}
