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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the sp_d_sottoservizio database table.
 * 
 */
@Entity
@Table(name="sp_d_sottoservizio")
@NamedQuery(name="SpDSottoservizio.findAll", query="SELECT s FROM SpDSottoservizio s")
public class SpDSottoservizio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String descrizione;

	private String nome;
	
	private Integer ordine;

	//bi-directional many-to-one association to SpDMetriche
	@OneToMany(mappedBy="spDSottoservizio")
	private List<SpDMetriche> spDMetriches;

	//bi-directional many-to-one association to SpDTipoServizio
	@ManyToOne
	@JoinColumn(name="id_servizio_padre")
	private SpDTipoServizio spDTipoServizio;

	public SpDSottoservizio() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
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
		spDMetrich.setSpDSottoservizio(this);

		return spDMetrich;
	}

	public SpDMetriche removeSpDMetrich(SpDMetriche spDMetrich) {
		getSpDMetriches().remove(spDMetrich);
		spDMetrich.setSpDSottoservizio(null);

		return spDMetrich;
	}

	public SpDTipoServizio getSpDTipoServizio() {
		return this.spDTipoServizio;
	}

	public void setSpDTipoServizio(SpDTipoServizio spDTipoServizio) {
		this.spDTipoServizio = spDTipoServizio;
	}

	public Integer getOrdine() {
		return ordine;
	}

	public void setOrdine(Integer ordine) {
		this.ordine = ordine;
	}

}
