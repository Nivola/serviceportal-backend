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

/**
 * Classe che modella i dati tipici per il frontend di tipo codice - etichetta - descrizione estesa
 *
 */
public class CodiceEtichettaDescrizioneDTO {
	
	private String codice;
	
	private String etichetta;
	
	private String descrizione;

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}


	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getEtichetta() {
		return etichetta;
	}

	public void setEtichetta(String etichetta) {
		this.etichetta = etichetta;
	}

	public CodiceEtichettaDescrizioneDTO(String codice, String etichetta, String descrizione) {
		super();
		this.codice = codice;
		this.etichetta = etichetta;
		this.descrizione = descrizione;
	}
	
	public CodiceEtichettaDescrizioneDTO() {
		
	}
	
}
