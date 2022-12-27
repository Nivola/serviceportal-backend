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
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the sp_news database table.
 * 
 */
@Entity
@Table(name="sp_news")
//@NamedQuery(name="SpNew.findAll", query="SELECT s FROM SpNews s")
public class SpNews implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="autore_id")
	private BigInteger autoreId;

	private String contenuto;

	@Column(name="data_cancellazione")
	private Timestamp dataCancellazione;

	@Column(name="data_creazione")
	private Timestamp dataCreazione;

	@Column(name="data_modifica")
	private Timestamp dataModifica;

	@Column(name="data_pubblicazione_fine")
	private Timestamp dataPubblicazioneFine;

	@Column(name="data_pubblicazione_inizio")
	private Timestamp dataPubblicazioneInizio;

	@Column(name="id_agente")
	private BigInteger idAgente;
	
	@Column(name="priorita")
	private Integer priorita;

	private String titolo;
	

	//bi-directional many-to-one association to SpCategoriaNews
	@ManyToOne
	@JoinColumn(name="codice_categoria")
	private SpCategoriaNews spCategoriaNew;

	//bi-directional many-to-one association to SpStatoNew
	@ManyToOne
	@JoinColumn(name="stato")
	private SpStatoNew spStatoNew;

	//bi-directional many-to-one association to SpNewsUser
	@OneToMany(mappedBy="spNew")
	private List<SpNewsUser> spNewsUsers;

	public SpNews() {
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public BigInteger getAutoreId() {
		return this.autoreId;
	}

	public void setAutoreId(BigInteger autoreId) {
		this.autoreId = autoreId;
	}

	public String getContenuto() {
		return this.contenuto;
	}

	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
	}

	public Timestamp getDataCancellazione() {
		return this.dataCancellazione;
	}

	public void setDataCancellazione(Timestamp dataCancellazione) {
		this.dataCancellazione = dataCancellazione;
	}

	public Timestamp getDataCreazione() {
		return this.dataCreazione;
	}

	public void setDataCreazione(Timestamp dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Timestamp getDataModifica() {
		return this.dataModifica;
	}

	public void setDataModifica(Timestamp dataModifica) {
		this.dataModifica = dataModifica;
	}

	public Timestamp getDataPubblicazioneFine() {
		return this.dataPubblicazioneFine;
	}

	public void setDataPubblicazioneFine(Timestamp dataPubblicazioneFine) {
		this.dataPubblicazioneFine = dataPubblicazioneFine;
	}

	public Timestamp getDataPubblicazioneInizio() {
		return this.dataPubblicazioneInizio;
	}

	public void setDataPubblicazioneInizio(Timestamp dataPubblicazioneInizio) {
		this.dataPubblicazioneInizio = dataPubblicazioneInizio;
	}

	public BigInteger getIdAgente() {
		return this.idAgente;
	}

	public void setIdAgente(BigInteger idAgente) {
		this.idAgente = idAgente;
	}

	public String getTitolo() {
		return this.titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public SpCategoriaNews getSpCategoriaNew() {
		return this.spCategoriaNew;
	}

	public void setSpCategoriaNew(SpCategoriaNews spCategoriaNew) {
		this.spCategoriaNew = spCategoriaNew;
	}

	public SpStatoNew getSpStatoNew() {
		return this.spStatoNew;
	}

	public void setSpStatoNew(SpStatoNew spStatoNew) {
		this.spStatoNew = spStatoNew;
	}

	public List<SpNewsUser> getSpNewsUsers() {
		return this.spNewsUsers;
	}

	public void setSpNewsUsers(List<SpNewsUser> spNewsUsers) {
		this.spNewsUsers = spNewsUsers;
	}


	public Integer getPriorita() {
		return priorita;
	}


	public void setPriorita(Integer priorita) {
		this.priorita = priorita;
	}

	

//	public SpNewsUser addSpNewsUser(SpNewsUser spNewsUser) {
//		getSpNewsUsers().add(spNewsUser);
//		spNewsUser.setSpNew(this);
//
//		return spNewsUser;
//	}
//
//	public SpNewsUser removeSpNewsUser(SpNewsUser spNewsUser) {
//		getSpNewsUsers().remove(spNewsUser);
//		spNewsUser.setSpNew(null);
//
//		return spNewsUser;
//	}

}
