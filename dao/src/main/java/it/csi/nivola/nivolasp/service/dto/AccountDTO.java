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
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountDTO extends BaseCMPDto implements Serializable {

	private static final long serialVersionUID = -455666153451617283L;
	

	@JsonProperty("active")
	private Boolean active = null;

	@JsonProperty("contact")
	private String contact = null;

	@JsonProperty("desc")
	private String desc = null;

	@JsonProperty("division_id")
	private String divisionId = null;

	@JsonProperty("email")
	private String email = null;

	@JsonProperty("email_support")
	private String emailSupport = null;

	@JsonProperty("email_support_link")
	private String emailSupportLink = null;

	@JsonProperty("managed")
	private Boolean managed = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("note")
	private String note = null;

	@JsonProperty("service_status_id")
	private Integer serviceStatusId = null;

	@JsonProperty("uuid")
	private String uuid = null;

	@JsonProperty("version")
	private String version = null;
	@JsonProperty("acronimo")
	private String acronym;
	
	@JsonProperty("postaladdress")
	private String postaladdress = null;
	
	private String codicePrezzo;
	
	private String descrizionePrezzo;
	
	private DivisioneDTO divisione =  null;
	
	private OrganizzazioneDTO organizzazione = null;
	
	private Boolean aggiornaCostiGiorno;
	
	private String divisioneNome;
	
	private String organizzazioneNome;
	
	private LocalDate dataInizioConsumi;
	
	private String personId;
	
	private Integer budgetMin;
	
	private Integer budgetMax;
	
	private ListinoDTO listino;
	
	private String idListinoSpecifico;
	
	private LocalDate dataFineConsumi;

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailSupport() {
		return emailSupport;
	}

	public void setEmailSupport(String emailSupport) {
		this.emailSupport = emailSupport;
	}

	public String getEmailSupportLink() {
		return emailSupportLink;
	}

	public void setEmailSupportLink(String emailSupportLink) {
		this.emailSupportLink = emailSupportLink;
	}

	public Boolean getManaged() {
		return managed;
	}

	public void setManaged(Boolean managed) {
		this.managed = managed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getServiceStatusId() {
		return serviceStatusId;
	}

	public void setServiceStatusId(Integer serviceStatusId) {
		this.serviceStatusId = serviceStatusId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public DivisioneDTO getDivisione() {
		return divisione;
	}

	public void setDivisione(DivisioneDTO divisione) {
		this.divisione = divisione;
	}

	public OrganizzazioneDTO getOrganizzazione() {
		return organizzazione;
	}

	public void setOrganizzazione(OrganizzazioneDTO organizzazione) {
		this.organizzazione = organizzazione;
	}

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public String getPostaladdress() {
		return postaladdress;
	}

	public void setPostaladdress(String postaladdress) {
		this.postaladdress = postaladdress;
	}

	public String getCodicePrezzo() {
		return codicePrezzo;
	}

	public void setCodicePrezzo(String codicePrezzo) {
		this.codicePrezzo = codicePrezzo;
	}

	public String getDescrizionePrezzo() {
		return descrizionePrezzo;
	}

	public void setDescrizionePrezzo(String descrizionePrezzo) {
		this.descrizionePrezzo = descrizionePrezzo;
	}

	public Boolean getAggiornaCostiGiorno() {
		return aggiornaCostiGiorno;
	}

	public void setAggiornaCostiGiorno(Boolean aggiornaCostiGiorno) {
		this.aggiornaCostiGiorno = aggiornaCostiGiorno;
	}

	public String getDivisioneNome() {
		return divisioneNome;
	}

	public void setDivisioneNome(String divisioneNome) {
		this.divisioneNome = divisioneNome;
	}

	public String getOrganizzazioneNome() {
		return organizzazioneNome;
	}

	public void setOrganizzazioneNome(String organizzazioneNome) {
		this.organizzazioneNome = organizzazioneNome;
	}

	public LocalDate getDataInizioConsumi() {
		return dataInizioConsumi;
	}

	public void setDataInizioConsumi(LocalDate dataInizioConsumi) {
		this.dataInizioConsumi = dataInizioConsumi;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public Integer getBudgetMin() {
		return budgetMin;
	}

	public void setBudgetMin(Integer budgetMin) {
		this.budgetMin = budgetMin;
	}

	public Integer getBudgetMax() {
		return budgetMax;
	}

	public void setBudgetMax(Integer budgetMax) {
		this.budgetMax = budgetMax;
	}

	public ListinoDTO getListino() {
		return listino;
	}

	public void setListino(ListinoDTO listino) {
		this.listino = listino;
	}

	public String getIdListinoSpecifico() {
		return idListinoSpecifico;
	}

	public void setIdListinoSpecifico(String idListinoSpecifico) {
		this.idListinoSpecifico = idListinoSpecifico;
	}

	public LocalDate getDataFineConsumi() {
		return dataFineConsumi;
	}

	public void setDataFineConsumi(LocalDate dataFineConsumi) {
		this.dataFineConsumi = dataFineConsumi;
	}

	
	

}
