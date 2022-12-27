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
package it.csi.nivola.nivolasp.repository.query;

import java.io.Serializable;
import java.util.Date;

public class DistinctShares implements Serializable {

	private static final long serialVersionUID = 5939838842524638740L;

	private String evs;

	private String filesystem;

	private String share;

	private String tipologia;
	
	private String refaccount;
	
	private Date dataFineAssociazione;

	private Date dataInizioAssociazione;
	
	
	public DistinctShares () {
		
	}

	public DistinctShares(String evs, String filesystem, String share) {
		super();
		this.evs = evs;
		this.filesystem = filesystem;
		this.share = share;
	}

	public String getEvs() {
		return evs;
	}

	public String getFilesystem() {
		return filesystem;
	}

	public String getShare() {
		return share;
	}

	public String getRefaccount() {
		return refaccount;
	}

	public void setRefaccount(String refaccount) {
		this.refaccount = refaccount;
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

	public void setEvs(String evs) {
		this.evs = evs;
	}

	public void setFilesystem(String filesystem) {
		this.filesystem = filesystem;
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
