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
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


/**
 * The persistent class for the sp_costo_giorno database table.
 * 
 */
@Entity
@Table(name="sp_costo_giorno")
@NamedQuery(name="SpCostoGiorno.findAll", query="SELECT s FROM SpCostoGiorno s")
public class SpCostoGiorno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Temporal(TemporalType.DATE)
	private Date data;

	@Column(name="data_cancellazione")
	private Timestamp dataCancellazione;

	@Column(name="data_creazione")
	private Timestamp dataCreazione;

	@Column(name="data_modifica")
	private Timestamp dataModifica;

	@Column(name="id_agente")
	private BigInteger idAgente;

	@Column(name="ref_account")
	private String refAccount;

	@Column(name="ref_divisione")
	private String refDivisione;

	@Column(name="ref_organizzazione")
	private String refOrganizzazione;

	//bi-directional many-to-one association to SpCostoGiornoDettaglio
	@OneToMany(mappedBy="spCostoGiorno", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<SpCostoGiornoDettaglio> spCostoGiornoDettaglios;
	
	//bi-directional many-to-one association to SpCostoGiornoWb
	@LazyCollection(LazyCollectionOption.TRUE)
	@OneToMany(mappedBy="spCostoGiorno")
	private List<SpCostoGiornoWb> spCostoGiornoWbs;


	public SpCostoGiorno() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
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

	public BigInteger getIdAgente() {
		return this.idAgente;
	}

	public void setIdAgente(BigInteger idAgente) {
		this.idAgente = idAgente;
	}

	public String getRefAccount() {
		return this.refAccount;
	}

	public void setRefAccount(String refAccount) {
		this.refAccount = refAccount;
	}

	public String getRefDivisione() {
		return this.refDivisione;
	}

	public void setRefDivisione(String refDivisione) {
		this.refDivisione = refDivisione;
	}

	public String getRefOrganizzazione() {
		return this.refOrganizzazione;
	}

	public void setRefOrganizzazione(String refOrganizzazione) {
		this.refOrganizzazione = refOrganizzazione;
	}

	public List<SpCostoGiornoDettaglio> getSpCostoGiornoDettaglios() {
		return this.spCostoGiornoDettaglios;
	}

	public void setSpCostoGiornoDettaglios(List<SpCostoGiornoDettaglio> spCostoGiornoDettaglios) {
		this.spCostoGiornoDettaglios = spCostoGiornoDettaglios;
	}

	public SpCostoGiornoDettaglio addSpCostoGiornoDettaglio(SpCostoGiornoDettaglio spCostoGiornoDettaglio) {
		getSpCostoGiornoDettaglios().add(spCostoGiornoDettaglio);
		spCostoGiornoDettaglio.setSpCostoGiorno(this);

		return spCostoGiornoDettaglio;
	}

	public SpCostoGiornoDettaglio removeSpCostoGiornoDettaglio(SpCostoGiornoDettaglio spCostoGiornoDettaglio) {
		getSpCostoGiornoDettaglios().remove(spCostoGiornoDettaglio);
		spCostoGiornoDettaglio.setSpCostoGiorno(null);

		return spCostoGiornoDettaglio;
	}

	public List<SpCostoGiornoWb> getSpCostoGiornoWbs() {
		return this.spCostoGiornoWbs;
	}

	public void setSpCostoGiornoWbs(List<SpCostoGiornoWb> spCostoGiornoWbs) {
		this.spCostoGiornoWbs = spCostoGiornoWbs;
	}

	public SpCostoGiornoWb addSpCostoGiornoWb(SpCostoGiornoWb spCostoGiornoWb) {
		getSpCostoGiornoWbs().add(spCostoGiornoWb);
		spCostoGiornoWb.setSpCostoGiorno(this);

		return spCostoGiornoWb;
	}

	public SpCostoGiornoWb removeSpCostoGiornoWb(SpCostoGiornoWb spCostoGiornoWb) {
		getSpCostoGiornoWbs().remove(spCostoGiornoWb);
		spCostoGiornoWb.setSpCostoGiorno(null);

		return spCostoGiornoWb;
	}

}
