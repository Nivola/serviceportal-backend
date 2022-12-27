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

public class ListinoTipoPrezzoDTO extends AbstractDTO {

	private static final long serialVersionUID = 6311579250191576639L;
	
	private String codice;

	private String descrizione;
	
	private Double importoAnnuo;

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

	public Double getImportoAnnuo() {
		return importoAnnuo;
	}

	public void setImportoAnnuo(Double importoAnnuo) {
		this.importoAnnuo = importoAnnuo;
	}

	
	
	
}
