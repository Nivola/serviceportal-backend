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
 * The persistent class for the sp_d_remedy_tipologia database table.
 * 
 */
@Entity
@Table(name="sp_d_remedy_tipologia")
@NamedQuery(name="SpDRemedyTipologia.findAll", query="SELECT s FROM SpDRemedyTipologia s")
public class SpDRemedyTipologia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String descrizione;

	private String valore;

	@Column(name="valore_remedy")
	private String valoreRemedy;

	//bi-directional many-to-one association to SpDRemedyCatOperativa
	@OneToMany(mappedBy="spDRemedyTipologia")
	private List<SpDRemedyCatOperativa> spDRemedyCatOperativas;

	public SpDRemedyTipologia() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getValore() {
		return this.valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

	public String getValoreRemedy() {
		return this.valoreRemedy;
	}

	public void setValoreRemedy(String valoreRemedy) {
		this.valoreRemedy = valoreRemedy;
	}

	public List<SpDRemedyCatOperativa> getSpDRemedyCatOperativas() {
		return this.spDRemedyCatOperativas;
	}

	public void setSpDRemedyCatOperativas(List<SpDRemedyCatOperativa> spDRemedyCatOperativas) {
		this.spDRemedyCatOperativas = spDRemedyCatOperativas;
	}

	public SpDRemedyCatOperativa addSpDRemedyCatOperativa(SpDRemedyCatOperativa spDRemedyCatOperativa) {
		getSpDRemedyCatOperativas().add(spDRemedyCatOperativa);
		spDRemedyCatOperativa.setSpDRemedyTipologia(this);

		return spDRemedyCatOperativa;
	}

	public SpDRemedyCatOperativa removeSpDRemedyCatOperativa(SpDRemedyCatOperativa spDRemedyCatOperativa) {
		getSpDRemedyCatOperativas().remove(spDRemedyCatOperativa);
		spDRemedyCatOperativa.setSpDRemedyTipologia(null);

		return spDRemedyCatOperativa;
	}

}
