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
import java.sql.Date;
import java.sql.Timestamp;

public class AssociaStaasAccount implements Serializable {
	
	private static final long serialVersionUID = -1806528848293294621L;

	private String id;

	private Timestamp dataCancellazione;

	private Timestamp dataCreazione;

	private Date dataFineAssociazione;

	private Date dataInizioAssociazione;

	private String evs;

	private String filesystem;

	private String refAccount;

	private String share;

	private String tipologia;

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

	public Timestamp getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Timestamp dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Date getDataFineAssociazione() {
		return dataFineAssociazione;
	}

	public void setDataFineAssociazione(Date dataFineAssociazione) {
		this.dataFineAssociazione = dataFineAssociazione;
	}

	public Date getDataInizioAssociazione() {
		return dataInizioAssociazione;
	}

	public void setDataInizioAssociazione(Date dataInizioAssociazione) {
		this.dataInizioAssociazione = dataInizioAssociazione;
	}

	public String getEvs() {
		return evs;
	}

	public void setEvs(String evs) {
		this.evs = evs;
	}

	public String getFilesystem() {
		return filesystem;
	}

	public void setFilesystem(String filesystem) {
		this.filesystem = filesystem;
	}

	public String getRefAccount() {
		return refAccount;
	}

	public void setRefAccount(String refAccount) {
		this.refAccount = refAccount;
	}

	public String getShare() {
		return share;
	}

	public void setShare(String share) {
		this.share = share;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
}
