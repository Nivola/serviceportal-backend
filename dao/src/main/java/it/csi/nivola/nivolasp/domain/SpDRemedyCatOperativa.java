/*-
 * ========================LICENSE_START=================================
 * Servizi di accesso dati
 * %%
 * Copyright (C) 2022 Regione Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | Regione Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the sp_d_remedy_cat_operativa database table.
 * 
 */
@Entity
@Table(name="sp_d_remedy_cat_operativa")
@NamedQuery(name="SpDRemedyCatOperativa.findAll", query="SELECT s FROM SpDRemedyCatOperativa s")
public class SpDRemedyCatOperativa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="cod_tecnologia")
	private String codTecnologia;

	private String livello1;

	private String livello2;

	private String livello3;
	
	@Column(name="tipologia_tripletta")
	private String tipologiaTripletta;

	//bi-directional many-to-one association to SpDRemedyTipologia
	@ManyToOne
	@JoinColumn(name="id_tipologia")
	private SpDRemedyTipologia spDRemedyTipologia;

	public SpDRemedyCatOperativa() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodTecnologia() {
		return this.codTecnologia;
	}

	public void setCodTecnologia(String codTecnologia) {
		this.codTecnologia = codTecnologia;
	}

	public String getLivello1() {
		return this.livello1;
	}

	public void setLivello1(String livello1) {
		this.livello1 = livello1;
	}

	public String getLivello2() {
		return this.livello2;
	}

	public void setLivello2(String livello2) {
		this.livello2 = livello2;
	}

	public String getLivello3() {
		return this.livello3;
	}

	public void setLivello3(String livello3) {
		this.livello3 = livello3;
	}

	public SpDRemedyTipologia getSpDRemedyTipologia() {
		return this.spDRemedyTipologia;
	}

	public void setSpDRemedyTipologia(SpDRemedyTipologia spDRemedyTipologia) {
		this.spDRemedyTipologia = spDRemedyTipologia;
	}

	public String getTipologiaTripletta() {
		return tipologiaTripletta;
	}

	public void setTipologiaTripletta(String tipologiaTripletta) {
		this.tipologiaTripletta = tipologiaTripletta;
	}

	
	@Override
	public String toString() {
		return "Categoria Operativa: " +codTecnologia + " "+ livello1 + " " + livello2 + " " + livello3 + " " + tipologiaTripletta;
	}
}
