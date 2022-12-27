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
 * The persistent class for the sp_log_accesso_user database table.
 * 
 */
@Entity
@Table(name="sp_log_accesso_user")
@NamedQuery(name="SpLogAccessoUser.findAll", query="SELECT s FROM SpLogAccessoUser s")
public class SpLogAccessoUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="data_accesso")
	private Timestamp dataAccesso;

	//bi-directional many-to-one association to SpUser
	@ManyToOne
	@JoinColumn(name="user_id")
	private SpUser spUser;

	public SpLogAccessoUser() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getDataAccesso() {
		return this.dataAccesso;
	}

	public void setDataAccesso(Timestamp dataAccesso) {
		this.dataAccesso = dataAccesso;
	}

	public SpUser getSpUser() {
		return this.spUser;
	}

	public void setSpUser(SpUser spUser) {
		this.spUser = spUser;
	}

}
