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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the sp_d_tipo_attributo database table.
 * 
 */
@Entity
@Table(name="sp_d_tipo_attributo")
@NamedQuery(name="SpDTipoAttributo.findAll", query="SELECT s FROM SpDTipoAttributo s")
public class SpDTipoAttributo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="descrizione_estesa")
	private String descrizioneEstesa;

	private Boolean divisione;

	private String nome;

	private Boolean organizzazione;

	//bi-directional many-to-one association to SpDivisioneAttributo
	@OneToMany(mappedBy="spDTipoAttributo")
	private List<SpDivisioneAttributo> spDivisioneAttributos;

	//bi-directional many-to-one association to SpOrganizzazioneAttributo
	@OneToMany(mappedBy="spDTipoAttributo")
	private List<SpOrganizzazioneAttributo> spOrganizzazioneAttributos;

	public SpDTipoAttributo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescrizioneEstesa() {
		return this.descrizioneEstesa;
	}

	public void setDescrizioneEstesa(String descrizioneEstesa) {
		this.descrizioneEstesa = descrizioneEstesa;
	}

	
	
	public Boolean getDivisione() {
		return divisione;
	}

	public void setDivisione(Boolean divisione) {
		this.divisione = divisione;
	}

	public Boolean getOrganizzazione() {
		return organizzazione;
	}

	public void setOrganizzazione(Boolean organizzazione) {
		this.organizzazione = organizzazione;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<SpDivisioneAttributo> getSpDivisioneAttributos() {
		return this.spDivisioneAttributos;
	}

	public void setSpDivisioneAttributos(List<SpDivisioneAttributo> spDivisioneAttributos) {
		this.spDivisioneAttributos = spDivisioneAttributos;
	}

	public SpDivisioneAttributo addSpDivisioneAttributo(SpDivisioneAttributo spDivisioneAttributo) {
		getSpDivisioneAttributos().add(spDivisioneAttributo);
		spDivisioneAttributo.setSpDTipoAttributo(this);

		return spDivisioneAttributo;
	}

	public SpDivisioneAttributo removeSpDivisioneAttributo(SpDivisioneAttributo spDivisioneAttributo) {
		getSpDivisioneAttributos().remove(spDivisioneAttributo);
		spDivisioneAttributo.setSpDTipoAttributo(null);

		return spDivisioneAttributo;
	}

	public List<SpOrganizzazioneAttributo> getSpOrganizzazioneAttributos() {
		return this.spOrganizzazioneAttributos;
	}

	public void setSpOrganizzazioneAttributos(List<SpOrganizzazioneAttributo> spOrganizzazioneAttributos) {
		this.spOrganizzazioneAttributos = spOrganizzazioneAttributos;
	}

	public SpOrganizzazioneAttributo addSpOrganizzazioneAttributo(SpOrganizzazioneAttributo spOrganizzazioneAttributo) {
		getSpOrganizzazioneAttributos().add(spOrganizzazioneAttributo);
		spOrganizzazioneAttributo.setSpDTipoAttributo(this);

		return spOrganizzazioneAttributo;
	}

	public SpOrganizzazioneAttributo removeSpOrganizzazioneAttributo(SpOrganizzazioneAttributo spOrganizzazioneAttributo) {
		getSpOrganizzazioneAttributos().remove(spOrganizzazioneAttributo);
		spOrganizzazioneAttributo.setSpDTipoAttributo(null);

		return spOrganizzazioneAttributo;
	}

}
