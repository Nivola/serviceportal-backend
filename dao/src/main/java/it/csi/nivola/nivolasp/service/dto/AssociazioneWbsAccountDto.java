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
import java.math.BigInteger;
import java.sql.Timestamp;

public class AssociazioneWbsAccountDto implements Serializable{

	private static final long serialVersionUID = 1624105579613178007L;
	
	private String id;
	
	private Timestamp dataCreazione;

	private Timestamp dataFineAssociazione;

	private Timestamp dataInizioAssociazione;

	private double ewbsPerc;
	
	private BigInteger idAgente;

	private String refAccount;
	
	private String ewbs;

	private String committente;

	private String descrCatSottotipologia;

	private String descrCatTipologia;

	private String idCatSottotipologia;

	private String idCatTipologia;

	private BigInteger idCommittente;

	public Timestamp getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Timestamp dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Timestamp getDataFineAssociazione() {
		return dataFineAssociazione;
	}

	public void setDataFineAssociazione(Timestamp dataFineAssociazione) {
		this.dataFineAssociazione = dataFineAssociazione;
	}

	public Timestamp getDataInizioAssociazione() {
		return dataInizioAssociazione;
	}

	public void setDataInizioAssociazione(Timestamp dataInizioAssociazione) {
		this.dataInizioAssociazione = dataInizioAssociazione;
	}

	public double getEwbsPerc() {
		return ewbsPerc;
	}

	public void setEwbsPerc(double ewbsPerc) {
		this.ewbsPerc = ewbsPerc;
	}

	public BigInteger getIdAgente() {
		return idAgente;
	}

	public void setIdAgente(BigInteger idAgente) {
		this.idAgente = idAgente;
	}

	public String getRefAccount() {
		return refAccount;
	}

	public void setRefAccount(String refAccount) {
		this.refAccount = refAccount;
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

	public String getEwbs() {
		return ewbs;
	}

	public void setEwbs(String ewbs) {
		this.ewbs = ewbs;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
