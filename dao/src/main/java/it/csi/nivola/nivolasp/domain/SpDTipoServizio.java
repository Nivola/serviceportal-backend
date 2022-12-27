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
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;


/**
 * The persistent class for the sp_d_tipo_servizio database table.
 * 
 */
@Entity
@Table(name="sp_d_tipo_servizio")
@NamedQuery(name="SpDTipoServizio.findAll", query="SELECT s FROM SpDTipoServizio s")
public class SpDTipoServizio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String colore;

	private String descrizione;

	private String etichetta;

	private String nome;
	
	private Integer ordine;

	//bi-directional many-to-one association to SpDMetriche
	@OneToMany(mappedBy="spDTipoServizio")
	private List<SpDMetriche> spDMetriches;

	//bi-directional many-to-one association to SpDSottoservizio
	@OneToMany(fetch = FetchType.EAGER, mappedBy="spDTipoServizio")
	@OrderBy("ordine")
	private List<SpDSottoservizio> spDSottoservizios;

	public SpDTipoServizio() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getColore() {
		return this.colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getEtichetta() {
		return this.etichetta;
	}

	public void setEtichetta(String etichetta) {
		this.etichetta = etichetta;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<SpDMetriche> getSpDMetriches() {
		return this.spDMetriches;
	}

	public void setSpDMetriches(List<SpDMetriche> spDMetriches) {
		this.spDMetriches = spDMetriches;
	}

	public SpDMetriche addSpDMetrich(SpDMetriche spDMetrich) {
		getSpDMetriches().add(spDMetrich);
		spDMetrich.setSpDTipoServizio(this);

		return spDMetrich;
	}

	public SpDMetriche removeSpDMetrich(SpDMetriche spDMetrich) {
		getSpDMetriches().remove(spDMetrich);
		spDMetrich.setSpDTipoServizio(null);

		return spDMetrich;
	}

	public List<SpDSottoservizio> getSpDSottoservizios() {
		return this.spDSottoservizios;
	}

	public void setSpDSottoservizios(List<SpDSottoservizio> spDSottoservizios) {
		this.spDSottoservizios = spDSottoservizios;
	}

	public SpDSottoservizio addSpDSottoservizio(SpDSottoservizio spDSottoservizio) {
		getSpDSottoservizios().add(spDSottoservizio);
		spDSottoservizio.setSpDTipoServizio(this);

		return spDSottoservizio;
	}

	public SpDSottoservizio removeSpDSottoservizio(SpDSottoservizio spDSottoservizio) {
		getSpDSottoservizios().remove(spDSottoservizio);
		spDSottoservizio.setSpDTipoServizio(null);

		return spDSottoservizio;
	}

	public Integer getOrdine() {
		return ordine;
	}

	public void setOrdine(Integer ordine) {
		this.ordine = ordine;
	}

}
