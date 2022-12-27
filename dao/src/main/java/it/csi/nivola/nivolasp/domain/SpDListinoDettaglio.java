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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the sp_d_listino_dettaglio database table.
 * 
 */
@Entity
@Table(name="sp_d_listino_dettaglio")
@NamedQuery(name="SpDListinoDettaglio.findAll", query="SELECT s FROM SpDListinoDettaglio s")
public class SpDListinoDettaglio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="data_cancellazione")
	private Timestamp dataCancellazione;

	@Column(name="data_creazione")
	private Timestamp dataCreazione;

	@Column(name="data_modifica")
	private Timestamp dataModifica;

	private String descrizione;

	@Column(name="id_agente")
	private BigInteger idAgente;

	private Double qta;

	@Column(name="RANGE_MAX")
	private Double rangeMax;

	@Column(name="RANGE_MIN")
	private Double rangeMin;
	private String udm;

	private String voce;

	//bi-directional many-to-one association to SpDListino
	@ManyToOne
	@JoinColumn(name="id_listino")
	private SpDListino spDListino;

	//bi-directional many-to-one association to SpDMetriche
	@ManyToOne
	@JoinColumn(name="id_metrica")
	private SpDMetriche spDMetriche;

	//bi-directional many-to-one association to SpDListinoImporto
	@OneToMany(mappedBy="spDListinoDettaglio", fetch=FetchType.LAZY)
	private List<SpDListinoImporto> spDListinoImportos;

	public SpDListinoDettaglio() {
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

	public Double getQta() {
		return this.qta;
	}

	public void setQta(Double qta) {
		this.qta = qta;
	}

	public Double getRangeMax() {
		return this.rangeMax;
	}

	public void setRangeMax(Double rangeMax) {
		this.rangeMax = rangeMax;
	}

	public Double getRangeMin() {
		return this.rangeMin;
	}

	public void setRangeMin(Double rangeMin) {
		this.rangeMin = rangeMin;
	}

	public String getUdm() {
		return this.udm;
	}

	public void setUdm(String udm) {
		this.udm = udm;
	}

	public String getVoce() {
		return this.voce;
	}

	public void setVoce(String voce) {
		this.voce = voce;
	}

	public SpDListino getSpDListino() {
		return this.spDListino;
	}

	public void setSpDListino(SpDListino spDListino) {
		this.spDListino = spDListino;
	}

	public SpDMetriche getSpDMetriche() {
		return this.spDMetriche;
	}

	public void setSpDMetriche(SpDMetriche spDMetriche) {
		this.spDMetriche = spDMetriche;
	}

	public List<SpDListinoImporto> getSpDListinoImportos() {
		return this.spDListinoImportos;
	}

	public void setSpDListinoImportos(List<SpDListinoImporto> spDListinoImportos) {
		this.spDListinoImportos = spDListinoImportos;
	}

	public SpDListinoImporto addSpDListinoImporto(SpDListinoImporto spDListinoImporto) {
		getSpDListinoImportos().add(spDListinoImporto);
		spDListinoImporto.setSpDListinoDettaglio(this);

		return spDListinoImporto;
	}

	public SpDListinoImporto removeSpDListinoImporto(SpDListinoImporto spDListinoImporto) {
		getSpDListinoImportos().remove(spDListinoImporto);
		spDListinoImporto.setSpDListinoDettaglio(null);

		return spDListinoImporto;
	}

}
