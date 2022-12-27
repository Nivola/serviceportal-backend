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

import java.util.Date;

import it.csi.nivola.nivolasp.domain.SpDTipoEvento;

public class EmailRichiestaDettaglio {

	private Integer id;

	private Date dataRichiesta;

	private String oggetto;

	private String refAccount;

	private String testo;

	private SpDTipoEvento spDTipoEvento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataRichiesta() {
		return dataRichiesta;
	}

	public void setDataRichiesta(Date dataRichiesta) {
		this.dataRichiesta = dataRichiesta;
	}

	public String getOggetto() {
		return oggetto;
	}

	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}

	public String getRefAccount() {
		return refAccount;
	}

	public void setRefAccount(String refAccount) {
		this.refAccount = refAccount;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public SpDTipoEvento getSpDTipoEvento() {
		return spDTipoEvento;
	}

	public void setSpDTipoEvento(SpDTipoEvento spDTipoEvento) {
		this.spDTipoEvento = spDTipoEvento;
	}
	
	

}
