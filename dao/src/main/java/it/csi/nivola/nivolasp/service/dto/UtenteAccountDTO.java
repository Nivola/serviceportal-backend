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

/**
 * Un utente di un account, come merge tra le informazioni CMP e quelle portale
 */
public class UtenteAccountDTO extends AbstractDTO {

	private static final long serialVersionUID = -7618223444354375949L;

	private String ruolo;
	
	private String username;
	
	private String nome;
	
	private String email;
	
	private boolean utentePortale;
	
	private Long id;
	
	private String strutturaOrganizzativaRuolo;
	
	private String nomeStrutturaOrganizzativa;

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isUtentePortale() {
		return utentePortale;
	}

	public void setUtentePortale(boolean utentePortale) {
		this.utentePortale = utentePortale;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStrutturaOrganizzativaRuolo() {
		return strutturaOrganizzativaRuolo;
	}

	public void setStrutturaOrganizzativaRuolo(String strutturaOrganizzativaRuolo) {
		this.strutturaOrganizzativaRuolo = strutturaOrganizzativaRuolo;
	}

	public String getNomeStrutturaOrganizzativa() {
		return nomeStrutturaOrganizzativa;
	}

	public void setNomeStrutturaOrganizzativa(String nomeStrutturaOrganizzativa) {
		this.nomeStrutturaOrganizzativa = nomeStrutturaOrganizzativa;
	}
	
	
	
}
