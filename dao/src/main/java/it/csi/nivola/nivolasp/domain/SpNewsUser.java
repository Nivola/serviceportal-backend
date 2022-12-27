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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the sp_news_user database table.
 * 
 */
@Entity
@Table(name="sp_news_user")
//@NamedQuery(name="SpNewsUser.findAll", query="SELECT s FROM SpNewsUser s")
public class SpNewsUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SpNewsUserPK id;

	@Column(name="data_lettura")
	private Timestamp dataLettura;

	//bi-directional many-to-one association to SpNew
	@ManyToOne
	@JoinColumn(updatable=false, insertable= false, name="news_id")
	private SpNews spNew;

	//bi-directional many-to-one association to SpUser
	@ManyToOne
	@JoinColumn(name="user_id", insertable=false, updatable=false)
	private SpUser spUser;

	public SpNewsUser() {
	}

	public SpNewsUserPK getId() {
		return this.id;
	}

	public void setId(SpNewsUserPK id) {
		this.id = id;
	}

	public Timestamp getDataLettura() {
		return this.dataLettura;
	}

	public void setDataLettura(Timestamp dataLettura) {
		this.dataLettura = dataLettura;
	}

	public SpNews getSpNew() {
		return this.spNew;
	}

	public void setSpNew(SpNews spNew) {
		this.spNew = spNew;
	}

	public SpUser getSpUser() {
		return this.spUser;
	}

	public void setSpUser(SpUser spUser) {
		this.spUser = spUser;
	}

}
