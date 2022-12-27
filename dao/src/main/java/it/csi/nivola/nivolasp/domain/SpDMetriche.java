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
 * The persistent class for the sp_d_metriche database table.
 * 
 */
@Entity
@Table(name="sp_d_metriche")
@NamedQuery(name="SpDMetriche.findAll", query="SELECT s FROM SpDMetriche s")
public class SpDMetriche implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private BigInteger id;

	@Column(name="calc_regex")
	private String calcRegex;

	private String descrizione;

	@Column(name="is_tenant_cost")
	private String isTenantCost;

	private String nome;

	private String note;

	@Column(name="ordine_servizio")
	private Integer ordineServizio;

	private String tipo;

	private String udm;

	@Column(name="visualizza_report")
	private Boolean visualizzaReport = false;

	//bi-directional many-to-one association to SpCostoGiornoDettaglio
	@OneToMany(mappedBy="spDMetriche", fetch=FetchType.LAZY)
	private List<SpCostoGiornoDettaglio> spCostoGiornoDettaglios;

	//bi-directional many-to-one association to SpDListinoDettaglio
	@OneToMany(mappedBy="spDMetriche", fetch=FetchType.EAGER)
	private List<SpDListinoDettaglio> spDListinoDettaglios;

	//bi-directional many-to-one association to SpDSottoservizio
	@ManyToOne
	@JoinColumn(name="id_sottoservizio")
	private SpDSottoservizio spDSottoservizio;

	//bi-directional many-to-one association to SpDTipoServizio
	@ManyToOne
	@JoinColumn(name="servizio")
	private SpDTipoServizio spDTipoServizio;

	//bi-directional many-to-one association to SpMetricheDichiarate
	@OneToMany(mappedBy="spDMetriche", fetch=FetchType.LAZY)
	private List<SpMetricheDichiarate> spMetricheDichiarates;

	public SpDMetriche() {
	}

	public BigInteger getId() {
		return this.id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getCalcRegex() {
		return this.calcRegex;
	}

	public void setCalcRegex(String calcRegex) {
		this.calcRegex = calcRegex;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getIsTenantCost() {
		return this.isTenantCost;
	}

	public void setIsTenantCost(String isTenantCost) {
		this.isTenantCost = isTenantCost;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getOrdineServizio() {
		return this.ordineServizio;
	}

	public void setOrdineServizio(Integer ordineServizio) {
		this.ordineServizio = ordineServizio;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUdm() {
		return this.udm;
	}

	public void setUdm(String udm) {
		this.udm = udm;
	}

	public Boolean getVisualizzaReport() {
		return this.visualizzaReport;
	}

	public void setVisualizzaReport(Boolean visualizzaReport) {
		this.visualizzaReport = visualizzaReport;
	}

	public List<SpCostoGiornoDettaglio> getSpCostoGiornoDettaglios() {
		return this.spCostoGiornoDettaglios;
	}

	public void setSpCostoGiornoDettaglios(List<SpCostoGiornoDettaglio> spCostoGiornoDettaglios) {
		this.spCostoGiornoDettaglios = spCostoGiornoDettaglios;
	}

	public SpCostoGiornoDettaglio addSpCostoGiornoDettaglio(SpCostoGiornoDettaglio spCostoGiornoDettaglio) {
		getSpCostoGiornoDettaglios().add(spCostoGiornoDettaglio);
		spCostoGiornoDettaglio.setSpDMetriche(this);

		return spCostoGiornoDettaglio;
	}

	public SpCostoGiornoDettaglio removeSpCostoGiornoDettaglio(SpCostoGiornoDettaglio spCostoGiornoDettaglio) {
		getSpCostoGiornoDettaglios().remove(spCostoGiornoDettaglio);
		spCostoGiornoDettaglio.setSpDMetriche(null);

		return spCostoGiornoDettaglio;
	}

	public List<SpDListinoDettaglio> getSpDListinoDettaglios() {
		return this.spDListinoDettaglios;
	}

	public void setSpDListinoDettaglios(List<SpDListinoDettaglio> spDListinoDettaglios) {
		this.spDListinoDettaglios = spDListinoDettaglios;
	}

	public SpDListinoDettaglio addSpDListinoDettaglio(SpDListinoDettaglio spDListinoDettaglio) {
		getSpDListinoDettaglios().add(spDListinoDettaglio);
		spDListinoDettaglio.setSpDMetriche(this);

		return spDListinoDettaglio;
	}

	public SpDListinoDettaglio removeSpDListinoDettaglio(SpDListinoDettaglio spDListinoDettaglio) {
		getSpDListinoDettaglios().remove(spDListinoDettaglio);
		spDListinoDettaglio.setSpDMetriche(null);

		return spDListinoDettaglio;
	}

	public SpDSottoservizio getSpDSottoservizio() {
		return this.spDSottoservizio;
	}

	public void setSpDSottoservizio(SpDSottoservizio spDSottoservizio) {
		this.spDSottoservizio = spDSottoservizio;
	}

	public SpDTipoServizio getSpDTipoServizio() {
		return this.spDTipoServizio;
	}

	public void setSpDTipoServizio(SpDTipoServizio spDTipoServizio) {
		this.spDTipoServizio = spDTipoServizio;
	}

	public List<SpMetricheDichiarate> getSpMetricheDichiarates() {
		return this.spMetricheDichiarates;
	}

	public void setSpMetricheDichiarates(List<SpMetricheDichiarate> spMetricheDichiarates) {
		this.spMetricheDichiarates = spMetricheDichiarates;
	}

	public SpMetricheDichiarate addSpMetricheDichiarate(SpMetricheDichiarate spMetricheDichiarate) {
		getSpMetricheDichiarates().add(spMetricheDichiarate);
		spMetricheDichiarate.setSpDMetriche(this);

		return spMetricheDichiarate;
	}

	public SpMetricheDichiarate removeSpMetricheDichiarate(SpMetricheDichiarate spMetricheDichiarate) {
		getSpMetricheDichiarates().remove(spMetricheDichiarate);
		spMetricheDichiarate.setSpDMetriche(null);

		return spMetricheDichiarate;
	}

}
