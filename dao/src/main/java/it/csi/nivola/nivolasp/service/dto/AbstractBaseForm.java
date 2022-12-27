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

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.csi.nivola.nivolasp.exception.BusinessException;

/**
 * Form base per tutte le richieste di assistenza.
 * Nato come supertipo per creare form diverse lavorandosolo sulle differenze e configurato sulla tabella sp_d_tipo_form,
 * è stato momentaneamente accantonato a favore di un sistema che effettua delle domande all'utente che vuole fare una
 * segnalazione.
 * La risposta ale domande determina i parametri della segnalazione e sono rappresentati dai campi con prefisso "q".
 *
 */
public class AbstractBaseForm {

	private String accountId = "";
	
	private String oggetto = "";
	
	private String descrizione = "";
	
	private String impatto;
	
	private String urgenza;
	
	private Long formId;

	private Boolean invia;
	
	@JsonProperty("q_tipo")
	private String qTipo;// tipologia di segnalazione
	
	@JsonProperty("q_category")
	private String qCategory; 
	
	@JsonProperty("q_scope")
	private Scope qScope;//sostituisce impatto
	
	@JsonProperty("q_sev")
	private Long qSev;//severita' da decodificare sulla base del livello tenant: mappaggio su sp_d_urgenza_form
	
	@JsonProperty("q_serv")
	private String qServ;
	
	private String qTecnologia; //tecnologia da decodificare su sp_d_form_categoria per tecnologia
	
	private String riepilogoScelte;
	
	
	public Long getFormId() {
		return formId;
	}

	public void setFormId(Long formId) {
		this.formId = formId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
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

	public Boolean getInvia() {
		return invia;
	}

	public void setInvia(Boolean invia) {
		this.invia = invia;
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
	
	
/*
	public Tipo getqTipo() {
		return qTipo;
	}

	public void setqTipo(Tipo qTipo) {
		this.qTipo = qTipo;
	}*/
	
	

	public String getqCategory() {
		return qCategory;
	}

	public Long getqSev() {
		return qSev;
	}

	public void setqSev(Long qSev) {
		this.qSev = qSev;
	}

	public String getqTipo() {
		return qTipo;
	}

	public void setqTipo(String qTipo) {
		this.qTipo = qTipo;
	}

	public void setqCategory(String qCategory) {
		this.qCategory = qCategory;
	}

	public Scope getqScope() {
		return qScope;
	}

	public void setqScope(Scope qScope) {
		this.qScope = qScope;
	}


	public String getqServ() {
		return qServ;
	}

	public void setqServ(String qServ) {
		this.qServ = qServ;
	}

	/**
	 * esegue la validazione della form
	 * @throws BusinessException
	 */
	public void valida () throws BusinessException {
		if (StringUtils.isEmpty(accountId )) {
			throw new BusinessException("Campo obbligatorio: accountId");
		}
		
		if (StringUtils.isEmpty(oggetto)) {
			throw new BusinessException("Campo obbligatorio: oggetto");
		}
		/*
		if (StringUtils.isEmpty(urgenza)) {
			throw new BusinessException("Campo obbligatorio: urgenza");
		}		
		
		if (StringUtils.isEmpty(impatto)) {
			throw new BusinessException("Campo obbligatorio: impatto");
		}		*/
 	}

	/*
	public Integer getqSev() {
		return qSev;
	}

	public void setqSev(Integer qSev) {
		this.qSev = qSev;
	}
*/
	public String componiTestoDaParametri() {
		return "Descrizione: " + descrizione +"\n";
	}
	
	/**
	 * Tipologia del ticket e categoria operativa
	 */
	public enum Tipo {
		PROBLEM("Ripristino di servizio utente"), CHANGE("Richiesta utente"), OTHER("Richiesta utente");
		
		private String category;
		
		Tipo (String cat) {
			category = cat;
		}

		public String getCategory() {
			return category;
		}
	}

	/**
	 * Corrispondente dell'urgenza del ticket Remedy
	 */
	public enum Severita {
		HIGH, AVERAGE, LOW;
	}
	
	/**
	 * Sostituisce l'impatto remedy
	 */
	public enum Scope {
		LARGE("Vasto/Diffuso"), MEDIUM("Significativo/Grande"), SMALL("Minimo/Localizzato");
		private String valore;
		
		Scope (String val) {
			valore = val;
		}

		public String getValore() {
			return valore;
		}
	}

	public String getqTecnologia() {
		return qTecnologia;
	}

	public void setqTecnologia(String qTecnologia) {
		this.qTecnologia = qTecnologia;
	}

	public String getRiepilogoScelte() {
		return riepilogoScelte;
	}

	public void setRiepilogoScelte(String riepilogoScelte) {
		this.riepilogoScelte = riepilogoScelte;
	}
	
	
}
