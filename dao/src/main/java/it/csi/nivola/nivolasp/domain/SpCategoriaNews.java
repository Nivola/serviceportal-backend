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
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the sp_categoria_news database table.
 * 
 */
@Entity
@Table(name="sp_categoria_news")
//@NamedQuery(name="SpCategoriaNews.findAll", query="SELECT s FROM SpCategoriaNews s")
public class SpCategoriaNews implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String codice;

	private String descrizione;

	//bi-directional many-to-one association to SpNew
	@OneToMany(mappedBy="spCategoriaNew")
	private List<SpNews> spNews;

	public SpCategoriaNews() {
	}

	public String getCodice() {
		return this.codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<SpNews> getSpNews() {
		return this.spNews;
	}

	public void setSpNews(List<SpNews> spNews) {
		this.spNews = spNews;
	}

	public SpNews addSpNew(SpNews spNew) {
		getSpNews().add(spNew);
		spNew.setSpCategoriaNew(this);

		return spNew;
	}

	public SpNews removeSpNew(SpNews spNew) {
		getSpNews().remove(spNew);
		spNew.setSpCategoriaNew(null);

		return spNew;
	}

}
