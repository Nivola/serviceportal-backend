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

public class DatiUtenteDTO extends AbstractDTO {

	private static final long serialVersionUID = -564123471917252910L;
	
	private Long id;

	private String username;

	private String nome;
	
	private String cognome;

	private String codiceFiscale;

	private String email;

	private String matricolaCsi;
	
	private String cmpUsername;
	
	private String ruoloBO;
	
	private Boolean attivo;
	
	private Boolean attivoCMP;
	
	private String note;
	
	private Boolean usaCredenziali = false;

	private Boolean usaRemedy = false;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatricolaCsi() {
		return matricolaCsi;
	}

	public void setMatricolaCsi(String matricolaCsi) {
		this.matricolaCsi = matricolaCsi;
	}

	public String getCmpUsername() {
		return cmpUsername;
	}

	public void setCmpUsername(String cmpUsername) {
		this.cmpUsername = cmpUsername;
	}

	public String getRuoloBO() {
		return ruoloBO;
	}

	public void setRuoloBO(String ruoloBO) {
		this.ruoloBO = ruoloBO;
	}

	public Boolean getAttivo() {
		return attivo;
	}

	public void setAttivo(Boolean attivo) {
		this.attivo = attivo;
	}

	public Boolean getAttivoCMP() {
		return attivoCMP;
	}

	public void setAttivoCMP(Boolean attivoCMP) {
		this.attivoCMP = attivoCMP;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Boolean getUsaCredenziali() {
		return usaCredenziali;
	}

	public void setUsaCredenziali(Boolean usaCredenziali) {
		this.usaCredenziali = usaCredenziali;
	}

	public Boolean getUsaRemedy() {
		return usaRemedy;
	}

	public void setUsaRemedy(Boolean usaRemedy) {
		this.usaRemedy = usaRemedy;
	}
	
	
}
