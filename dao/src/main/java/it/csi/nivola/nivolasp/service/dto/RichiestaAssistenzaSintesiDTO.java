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

public class RichiestaAssistenzaSintesiDTO extends AbstractDTO {

	private static final long serialVersionUID = 6319916380341804857L;

	private String id;
	
	private String tipoSegnalazione;
	
	private String oggetto;
	
	private String descrizione;
	
	private boolean inviato;
	
	private Date dataUltimaModifica;
	
	private Date dataInserimento;
	
	private Date dataInvio;
	
	private String utenteInserimento;
	
	private String utenteUltimaModifica;
	
	private String utenteInvio;
	
	private String ticketId;
	
	private String accountName;
	
	private String accountId;

	private String divisioneName;
	
	private String divisioneId;
	
	private String organizzazioneName;
	
	private String organizzazioneId;
	
	private String impatto;
	
	private String urgenza;
	
	private String stato;
	
	private String scope;
	
	private String service;
	
	private String tecnologia;
	
	private String tipologiaProblema;
	
	private String assegnatario;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTipoSegnalazione() {
		return tipoSegnalazione;
	}

	public void setTipoSegnalazione(String tipoSegnalazione) {
		this.tipoSegnalazione = tipoSegnalazione;
	}

	public String getOggetto() {
		return oggetto;
	}

	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public boolean isInviato() {
		return inviato;
	}

	public void setInviato(boolean inviato) {
		this.inviato = inviato;
	}

	public Date getDataUltimaModifica() {
		return dataUltimaModifica;
	}

	public void setDataUltimaModifica(Date dataUltimaModifica) {
		this.dataUltimaModifica = dataUltimaModifica;
	}

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public Date getDataInvio() {
		return dataInvio;
	}

	public void setDataInvio(Date dataInvio) {
		this.dataInvio = dataInvio;
	}

	public String getUtenteInserimento() {
		return utenteInserimento;
	}

	public void setUtenteInserimento(String utenteInserimento) {
		this.utenteInserimento = utenteInserimento;
	}

	public String getUtenteUltimaModifica() {
		return utenteUltimaModifica;
	}

	public void setUtenteUltimaModifica(String utenteUltimaModifica) {
		this.utenteUltimaModifica = utenteUltimaModifica;
	}

	public String getUtenteInvio() {
		return utenteInvio;
	}

	public void setUtenteInvio(String utenteInvio) {
		this.utenteInvio = utenteInvio;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getImpatto() {
		return impatto;
	}

	public void setImpatto(String impatto) {
		this.impatto = impatto;
	}

	public String getUrgenza() {
		return urgenza;
	}

	public void setUrgenza(String urgenza) {
		this.urgenza = urgenza;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	public String getTipologiaProblema() {
		return tipologiaProblema;
	}

	public void setTipologiaProblema(String tipologiaProblema) {
		this.tipologiaProblema = tipologiaProblema;
	}

	public String getDivisioneName() {
		return divisioneName;
	}

	public void setDivisioneName(String divisioneName) {
		this.divisioneName = divisioneName;
	}

	public String getDivisioneId() {
		return divisioneId;
	}

	public void setDivisioneId(String divisioneId) {
		this.divisioneId = divisioneId;
	}

	public String getOrganizzazioneName() {
		return organizzazioneName;
	}

	public void setOrganizzazioneName(String organizzazioneName) {
		this.organizzazioneName = organizzazioneName;
	}

	public String getOrganizzazioneId() {
		return organizzazioneId;
	}

	public void setOrganizzazioneId(String organizzazioneId) {
		this.organizzazioneId = organizzazioneId;
	}

	public String getAssegnatario() {
		return assegnatario;
	}

	public void setAssegnatario(String assegnatario) {
		this.assegnatario = assegnatario;
	}
}
