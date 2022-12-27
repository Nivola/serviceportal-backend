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
import java.sql.Timestamp;

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
 * The persistent class for the sp_d_read_the_docs_mapping database table.
 * 
 */
@Entity
@Table(name="sp_d_read_the_docs_mapping")
@NamedQuery(name="SpDReadTheDocsMapping.findAll", query="SELECT s FROM SpDReadTheDocsMapping s")
public class SpDReadTheDocsMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="data_inserimento")
	private Timestamp dataInserimento;

	@Column(name="doc_url")
	private String docUrl;

	//bi-directional many-to-one association to SpUser
	@ManyToOne
	@JoinColumn(name="id_utente")
	private SpUser spUser;

	@Column(name="route_label")
	private String routeLabel;
	
	@Column(name="lingua")
	private String lingua;
	
	

	public SpDReadTheDocsMapping() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDataInserimento() {
		return this.dataInserimento;
	}

	public void setDataInserimento(Timestamp dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public String getDocUrl() {
		return this.docUrl;
	}

	public void setDocUrl(String docUrl) {
		this.docUrl = docUrl;
	}


	public SpUser getSpUser() {
		return spUser;
	}

	public void setSpUser(SpUser spUser) {
		this.spUser = spUser;
	}

	public String getRouteLabel() {
		return this.routeLabel;
	}

	public void setRouteLabel(String routeLabel) {
		this.routeLabel = routeLabel;
	}

	public String getLingua() {
		return lingua;
	}

	public void setLingua(String lingua) {
		this.lingua = lingua;
	}

}
