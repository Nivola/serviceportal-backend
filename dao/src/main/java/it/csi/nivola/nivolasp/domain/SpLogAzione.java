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
package it.csi.nivola.nivolasp.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



/**
 * The persistent class for the sp_log_accesso_user database table.
 * 
 */
@Entity
@Table(name="sp_log_azione")
public class SpLogAzione implements Serializable {
	
	private static final long serialVersionUID = -2462620274810654314L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	
	private String oggetto;

	private String account;

	private String azione;

	@Column(name="data_azione")
	private Timestamp dataAzione;

	private String descrizione;

	private String divisione;

	@Column(name="indirizzo_ip")
	private String indirizzoIp;

	private String organizzazione;

	private String parametri;

	private String ruolo;

	//bi-directional many-to-one association to SpUser
	@ManyToOne
	@JoinColumn(name="user_id")
	private SpUser spUser;

	public SpLogAzione() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

	public String getOggetto() {
		return oggetto;
	}

	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAzione() {
		return azione;
	}

	public void setAzione(String azione) {
		this.azione = azione;
	}

	public Timestamp getDataAzione() {
		return dataAzione;
	}

	public void setDataAzione(Timestamp dataAzione) {
		this.dataAzione = dataAzione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDivisione() {
		return divisione;
	}

	public void setDivisione(String divisione) {
		this.divisione = divisione;
	}

	public String getIndirizzoIp() {
		return indirizzoIp;
	}

	public void setIndirizzoIp(String indirizzoIp) {
		this.indirizzoIp = indirizzoIp;
	}

	public String getOrganizzazione() {
		return organizzazione;
	}

	public void setOrganizzazione(String organizzazione) {
		this.organizzazione = organizzazione;
	}

	public String getParametri() {
		return parametri;
	}

	public void setParametri(String parametri) {
		this.parametri = parametri;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public SpUser getSpUser() {
		return spUser;
	}

	public void setSpUser(SpUser spUser) {
		this.spUser = spUser;
	}
	
	
	
}
