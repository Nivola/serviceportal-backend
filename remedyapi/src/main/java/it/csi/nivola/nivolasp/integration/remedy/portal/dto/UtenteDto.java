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

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class UtenteDto {
	@JsonProperty("personId")
	private String personId = null;

	@JsonProperty("nome")
	private String nome = null;

	@JsonProperty("cognome")
	private String cognome = null;

	@JsonProperty("email")
	private String email = null;

	@JsonProperty("telefono")
	private String telefono = null;

	@JsonProperty("telefonoMobile")
	private String telefonoMobile = null;

	@JsonProperty("fax")
	private String fax = null;

	private EnteDto company = null;

	public UtenteDto personId(String personId) {
		this.personId = personId;
		return this;
	}

	/**
	 * identificativo del richiedente anagrafato in formato
	 * &#x60;PPLxxxxxxxxxxxx&#x60;
	 * 
	 * @return personId
	 **/
	@ApiModelProperty(value = "identificativo del richiedente anagrafato in formato `PPLxxxxxxxxxxxx`")
	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public UtenteDto nome(String nome) {
		this.nome = nome;
		return this;
	}

	/**
	 * Get nome
	 * 
	 * @return nome
	 **/
	@ApiModelProperty(value = "")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UtenteDto cognome(String cognome) {
		this.cognome = cognome;
		return this;
	}

	/**
	 * Get cognome
	 * 
	 * @return cognome
	 **/
	@ApiModelProperty(value = "")
	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public UtenteDto email(String email) {
		this.email = email;
		return this;
	}

	/**
	 * Get email
	 * 
	 * @return email
	 **/
	@ApiModelProperty(value = "")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UtenteDto telefono(String telefono) {
		this.telefono = telefono;
		return this;
	}

	/**
	 * Get telefono
	 * 
	 * @return telefono
	 **/
	@ApiModelProperty(value = "")
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public UtenteDto telefonoMobile(String telefonoMobile) {
		this.telefonoMobile = telefonoMobile;
		return this;
	}

	/**
	 * Get telefonoMobile
	 * 
	 * @return telefonoMobile
	 **/
	@ApiModelProperty(value = "")
	public String getTelefonoMobile() {
		return telefonoMobile;
	}

	public void setTelefonoMobile(String telefonoMobile) {
		this.telefonoMobile = telefonoMobile;
	}

	public UtenteDto fax(String fax) {
		this.fax = fax;
		return this;
	}

	/**
	 * Get fax
	 * 
	 * @return fax
	 **/
	@ApiModelProperty(value = "")
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	
	

	public EnteDto getCompany() {
		return company;
	}

	public void setCompany(EnteDto company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "UtenteDto [personId=" + personId + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", telefono=" + telefono + ", telefonoMobile=" + telefonoMobile + ", fax=" + fax + "]" + company;
	}

}
