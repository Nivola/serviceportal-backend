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

import com.fasterxml.jackson.annotation.JsonProperty;

public class FiltroCapabilitiesDto extends CapabilitiesDTO {

	
	private static final long serialVersionUID = -4294482662526914951L;

	@JsonProperty
	private String dataCreazioneDa;
	
	@JsonProperty
	private String dataCreazioneA;
	
	@JsonProperty
	private String dataModificaDa;
	
	@JsonProperty
	private String dataModificaA;
	
	@JsonProperty
	private String dataScadenzaDa;
	
	@JsonProperty
	private String dataScadenzaA;

	public String getDataCreazioneDa() {
		return dataCreazioneDa;
	}

	public void setDataCreazioneDa(String dataCreazioneDa) {
		this.dataCreazioneDa = dataCreazioneDa;
	}

	public String getDataCreazioneA() {
		return dataCreazioneA;
	}

	public void setDataCreazioneA(String dataCreazioneA) {
		this.dataCreazioneA = dataCreazioneA;
	}

	public String getDataModificaDa() {
		return dataModificaDa;
	}

	public void setDataModificaDa(String dataModificaDa) {
		this.dataModificaDa = dataModificaDa;
	}

	public String getDataModificaA() {
		return dataModificaA;
	}

	public void setDataModificaA(String dataModificaA) {
		this.dataModificaA = dataModificaA;
	}

	public String getDataScadenzaDa() {
		return dataScadenzaDa;
	}

	public void setDataScadenzaDa(String dataScadenzaDa) {
		this.dataScadenzaDa = dataScadenzaDa;
	}

	public String getDataScadenzaA() {
		return dataScadenzaA;
	}

	public void setDataScadenzaA(String dataScadenzaA) {
		this.dataScadenzaA = dataScadenzaA;
	}
	
	
}
