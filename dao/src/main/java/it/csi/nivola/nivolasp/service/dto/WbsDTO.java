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

import java.math.BigInteger;

public class WbsDTO {
	
	private String ewbs;

	private String committente;

	private String descrCatSottotipologia;

	private String descrCatTipologia;

	private String idCatSottotipologia;

	private String idCatTipologia;

	private BigInteger idCommittente;

	public String getEwbs() {
		return ewbs;
	}

	public void setEwbs(String ewbs) {
		this.ewbs = ewbs;
	}

	public String getCommittente() {
		return committente;
	}

	public void setCommittente(String committente) {
		this.committente = committente;
	}

	public String getDescrCatSottotipologia() {
		return descrCatSottotipologia;
	}

	public void setDescrCatSottotipologia(String descrCatSottotipologia) {
		this.descrCatSottotipologia = descrCatSottotipologia;
	}

	public String getDescrCatTipologia() {
		return descrCatTipologia;
	}

	public void setDescrCatTipologia(String descrCatTipologia) {
		this.descrCatTipologia = descrCatTipologia;
	}

	public String getIdCatSottotipologia() {
		return idCatSottotipologia;
	}

	public void setIdCatSottotipologia(String idCatSottotipologia) {
		this.idCatSottotipologia = idCatSottotipologia;
	}

	public String getIdCatTipologia() {
		return idCatTipologia;
	}

	public void setIdCatTipologia(String idCatTipologia) {
		this.idCatTipologia = idCatTipologia;
	}

	public BigInteger getIdCommittente() {
		return idCommittente;
	}

	public void setIdCommittente(BigInteger idCommittente) {
		this.idCommittente = idCommittente;
	}
	
	
}
