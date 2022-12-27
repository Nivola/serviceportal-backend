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

import java.sql.Timestamp;

public class AttributoStrutturaDTO extends AbstractDTO {

	private static final long serialVersionUID = -4820089175356257217L;

	private String id;

	private Timestamp dataCancellazione;

	private Timestamp dataInserimento;

	private Timestamp dataModifica;

	private String valore;
	
	private String descrizioneTipo;
	
	private String utenteInserimento;
	
	private String uuidStruttura;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getDataCancellazione() {
		return dataCancellazione;
	}

	public void setDataCancellazione(Timestamp dataCancellazione) {
		this.dataCancellazione = dataCancellazione;
	}

	public Timestamp getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Timestamp dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public Timestamp getDataModifica() {
		return dataModifica;
	}

	public void setDataModifica(Timestamp dataModifica) {
		this.dataModifica = dataModifica;
	}

	public String getValore() {
		return valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

	public String getDescrizioneTipo() {
		return descrizioneTipo;
	}

	public void setDescrizioneTipo(String descrizioneTipo) {
		this.descrizioneTipo = descrizioneTipo;
	}

	public String getUtenteInserimento() {
		return utenteInserimento;
	}

	public void setUtenteInserimento(String utenteInserimento) {
		this.utenteInserimento = utenteInserimento;
	}

	public String getUuidStruttura() {
		return uuidStruttura;
	}

	public void setUuidStruttura(String uuidStruttura) {
		this.uuidStruttura = uuidStruttura;
	}
	
	
}
