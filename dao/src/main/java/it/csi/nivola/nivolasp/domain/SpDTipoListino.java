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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the sp_d_tipo_listino database table.
 * 
 */
@Entity
@Table(name="sp_d_tipo_listino")
@NamedQuery(name="SpDTipoListino.findAll", query="SELECT s FROM SpDTipoListino s")
public class SpDTipoListino implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String codice;

	@Column(name="data_cancellazione")
	private Timestamp dataCancellazione;

	@Column(name="data_creazione")
	private Timestamp dataCreazione;

	@Column(name="data_modifica")
	private Timestamp dataModifica;

	private String descrizione;

	@Column(name="id_agente")
	private BigInteger idAgente;

	//bi-directional many-to-one association to SpAccountInfocosto
	@OneToMany(mappedBy="spDTipoListino", fetch=FetchType.LAZY)
	private List<SpAccountInfocosto> spAccountInfocostos;

	//bi-directional many-to-one association to SpDListino
	@OneToMany(mappedBy="spDTipoListino", fetch=FetchType.LAZY)
	private List<SpDListino> spDListinos;

	public SpDTipoListino() {
	}

	public String getCodice() {
		return this.codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
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

	public List<SpAccountInfocosto> getSpAccountInfocostos() {
		return this.spAccountInfocostos;
	}

	public void setSpAccountInfocostos(List<SpAccountInfocosto> spAccountInfocostos) {
		this.spAccountInfocostos = spAccountInfocostos;
	}

	public SpAccountInfocosto addSpAccountInfocosto(SpAccountInfocosto spAccountInfocosto) {
		getSpAccountInfocostos().add(spAccountInfocosto);
		spAccountInfocosto.setSpDTipoListino(this);

		return spAccountInfocosto;
	}

	public SpAccountInfocosto removeSpAccountInfocosto(SpAccountInfocosto spAccountInfocosto) {
		getSpAccountInfocostos().remove(spAccountInfocosto);
		spAccountInfocosto.setSpDTipoListino(null);

		return spAccountInfocosto;
	}

	public List<SpDListino> getSpDListinos() {
		return this.spDListinos;
	}

	public void setSpDListinos(List<SpDListino> spDListinos) {
		this.spDListinos = spDListinos;
	}

	public SpDListino addSpDListino(SpDListino spDListino) {
		getSpDListinos().add(spDListino);
		spDListino.setSpDTipoListino(this);

		return spDListino;
	}

	public SpDListino removeSpDListino(SpDListino spDListino) {
		getSpDListinos().remove(spDListino);
		spDListino.setSpDTipoListino(null);

		return spDListino;
	}

}
