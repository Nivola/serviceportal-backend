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
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


/**
 * The persistent class for the sp_d_listino database table.
 * 
 */
@Entity
@Table(name="sp_d_listino")
@NamedQuery(name="SpDListino.findAll", query="SELECT s FROM SpDListino s")
public class SpDListino implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="data_cancellazione")
	private Timestamp dataCancellazione;

	@Column(name="data_creazione")
	private Timestamp dataCreazione;

	@Column(name="data_fine_validita")
	private Date dataFineValidita;

	@Column(name="data_inizio_validita")
	private Date dataInizioValidita;

	@Column(name="data_modifica")
	private Timestamp dataModifica;

	private String descrizione;

	@Column(name="id_agente")
	private BigInteger idAgente;

	private String nome;

	//bi-directional many-to-one association to SpAccountInfocosto
	@OneToMany(mappedBy="spDListino")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<SpAccountInfocosto> spAccountInfocostos;

	//bi-directional many-to-one association to SpDTipoListino
	@ManyToOne
	@JoinColumn(name="tipo_listino")
	private SpDTipoListino spDTipoListino;

	//bi-directional many-to-one association to SpDListinoDettaglio
	@OneToMany(mappedBy="spDListino", fetch=FetchType.LAZY)
	private List<SpDListinoDettaglio> spDListinoDettaglios;

	@ManyToMany
	@JoinTable(
			  name = "sp_r_listino_tipo_prezzo", 
			  joinColumns = @JoinColumn(name = "id_listino"), 
			  inverseJoinColumns = @JoinColumn(name = "codice_tipo_prezzo"))
	private List<SpDTipoPrezzo> spDTipoPrezzos;

	public SpDListino() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Date getDataFineValidita() {
		return this.dataFineValidita;
	}

	public void setDataFineValidita(Date dataFineValidita) {
		this.dataFineValidita = dataFineValidita;
	}

	public Date getDataInizioValidita() {
		return this.dataInizioValidita;
	}

	public void setDataInizioValidita(Date dataInizioValidita) {
		this.dataInizioValidita = dataInizioValidita;
	}

	public Timestamp getDataModifica() {
		return this.dataModifica;
	}

	public void setDataModifica(Timestamp dataModifica) {
		this.dataModifica = dataModifica;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public BigInteger getIdAgente() {
		return this.idAgente;
	}

	public void setIdAgente(BigInteger idAgente) {
		this.idAgente = idAgente;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<SpAccountInfocosto> getSpAccountInfocostos() {
		return this.spAccountInfocostos;
	}

	public void setSpAccountInfocostos(List<SpAccountInfocosto> spAccountInfocostos) {
		this.spAccountInfocostos = spAccountInfocostos;
	}

	public SpAccountInfocosto addSpAccountInfocosto(SpAccountInfocosto spAccountInfocosto) {
		getSpAccountInfocostos().add(spAccountInfocosto);
		spAccountInfocosto.setSpDListino(this);

		return spAccountInfocosto;
	}

	public SpAccountInfocosto removeSpAccountInfocosto(SpAccountInfocosto spAccountInfocosto) {
		getSpAccountInfocostos().remove(spAccountInfocosto);
		spAccountInfocosto.setSpDListino(null);

		return spAccountInfocosto;
	}

	public SpDTipoListino getSpDTipoListino() {
		return this.spDTipoListino;
	}

	public void setSpDTipoListino(SpDTipoListino spDTipoListino) {
		this.spDTipoListino = spDTipoListino;
	}

	public List<SpDListinoDettaglio> getSpDListinoDettaglios() {
		return this.spDListinoDettaglios;
	}

	public void setSpDListinoDettaglios(List<SpDListinoDettaglio> spDListinoDettaglios) {
		this.spDListinoDettaglios = spDListinoDettaglios;
	}

	public SpDListinoDettaglio addSpDListinoDettaglio(SpDListinoDettaglio spDListinoDettaglio) {
		getSpDListinoDettaglios().add(spDListinoDettaglio);
		spDListinoDettaglio.setSpDListino(this);

		return spDListinoDettaglio;
	}

	public SpDListinoDettaglio removeSpDListinoDettaglio(SpDListinoDettaglio spDListinoDettaglio) {
		getSpDListinoDettaglios().remove(spDListinoDettaglio);
		spDListinoDettaglio.setSpDListino(null);

		return spDListinoDettaglio;
	}

	public List<SpDTipoPrezzo> getSpDTipoPrezzos() {
		return spDTipoPrezzos;
	}

	public void setSpDTipoPrezzos(List<SpDTipoPrezzo> spDTipoPrezzos) {
		this.spDTipoPrezzos = spDTipoPrezzos;
	}
	
	

}
