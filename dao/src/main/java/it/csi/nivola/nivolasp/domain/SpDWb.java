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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the sp_d_wbs database table.
 * 
 */
@Entity
@Table(name="sp_d_wbs")
@NamedQuery(name="SpDWb.findAll", query="SELECT s FROM SpDWb s")
public class SpDWb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String ewbs;

	private String committente;

	@Column(name="descr_cat_sottotipologia")
	private String descrCatSottotipologia;

	@Column(name="descr_cat_tipologia")
	private String descrCatTipologia;

	@Column(name="id_cat_sottotipologia")
	private String idCatSottotipologia;

	@Column(name="id_cat_tipologia")
	private String idCatTipologia;

	@Column(name="id_committente")
	private BigInteger idCommittente;

	//bi-directional many-to-one association to SpCostoGiornoWb
	@OneToMany(mappedBy="spDWb", fetch=FetchType.LAZY)
	private List<SpCostoGiornoWb> spCostoGiornoWbs;

	public SpDWb() {
	}

	public String getEwbs() {
		return this.ewbs;
	}

	public void setEwbs(String ewbs) {
		this.ewbs = ewbs;
	}

	public String getCommittente() {
		return this.committente;
	}

	public void setCommittente(String committente) {
		this.committente = committente;
	}

	public String getDescrCatSottotipologia() {
		return this.descrCatSottotipologia;
	}

	public void setDescrCatSottotipologia(String descrCatSottotipologia) {
		this.descrCatSottotipologia = descrCatSottotipologia;
	}

	public String getDescrCatTipologia() {
		return this.descrCatTipologia;
	}

	public void setDescrCatTipologia(String descrCatTipologia) {
		this.descrCatTipologia = descrCatTipologia;
	}

	public String getIdCatSottotipologia() {
		return this.idCatSottotipologia;
	}

	public void setIdCatSottotipologia(String idCatSottotipologia) {
		this.idCatSottotipologia = idCatSottotipologia;
	}

	public String getIdCatTipologia() {
		return this.idCatTipologia;
	}

	public void setIdCatTipologia(String idCatTipologia) {
		this.idCatTipologia = idCatTipologia;
	}

	public BigInteger getIdCommittente() {
		return this.idCommittente;
	}

	public void setIdCommittente(BigInteger idCommittente) {
		this.idCommittente = idCommittente;
	}

	public List<SpCostoGiornoWb> getSpCostoGiornoWbs() {
		return this.spCostoGiornoWbs;
	}

	public void setSpCostoGiornoWbs(List<SpCostoGiornoWb> spCostoGiornoWbs) {
		this.spCostoGiornoWbs = spCostoGiornoWbs;
	}

	public SpCostoGiornoWb addSpCostoGiornoWb(SpCostoGiornoWb spCostoGiornoWb) {
		getSpCostoGiornoWbs().add(spCostoGiornoWb);
		spCostoGiornoWb.setSpDWb(this);

		return spCostoGiornoWb;
	}

	public SpCostoGiornoWb removeSpCostoGiornoWb(SpCostoGiornoWb spCostoGiornoWb) {
		getSpCostoGiornoWbs().remove(spCostoGiornoWb);
		spCostoGiornoWb.setSpDWb(null);

		return spCostoGiornoWb;
	}

}
