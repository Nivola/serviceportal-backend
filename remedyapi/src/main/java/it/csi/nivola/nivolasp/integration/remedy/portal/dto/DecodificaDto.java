/*-
 * ========================LICENSE_START=================================
 * Api Remedy
 * %%
 * Copyright (C) 2022 Regione Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | Regione Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.integration.remedy.portal.dto;

import java.io.Serializable;

public class DecodificaDto implements Serializable {
	
	private static final long serialVersionUID = -7668352934797990564L;
	
	public String codice;
	public String valore;
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getValore() {
		return valore;
	}
	public void setValore(String valore) {
		this.valore = valore;
	}
	
	public DecodificaDto(String codice, String valore) {
		super();
		this.codice = codice;
		this.valore = valore;
	}
	
	public DecodificaDto () {
		
	}
	@Override
	public String toString() {
		return "DecodificaDto [codice=" + codice + ", valore=" + valore + "]";
	}
}
