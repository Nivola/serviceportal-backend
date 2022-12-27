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
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the sp_d_remedy_urgenza database table.
 * 
 */
@Entity
@Table(name="sp_d_remedy_urgenza")
@NamedQuery(name="SpDRemedyUrgenza.findAll", query="SELECT s FROM SpDRemedyUrgenza s")
public class SpDRemedyUrgenza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String descrizione;

	private Long valore;

	@Column(name="valore_remedy")
	private String valoreRemedy;

	public SpDRemedyUrgenza() {
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

	public Long getValore() {
		return this.valore;
	}

	public void setValore(Long valore) {
		this.valore = valore;
	}

	public String getValoreRemedy() {
		return this.valoreRemedy;
	}

	public void setValoreRemedy(String valoreRemedy) {
		this.valoreRemedy = valoreRemedy;
	}

}
