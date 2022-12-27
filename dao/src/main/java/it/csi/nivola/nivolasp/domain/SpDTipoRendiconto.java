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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the sp_d_tipo_rendiconto database table.
 *
 */
@Entity
@Table(name="sp_d_tipo_rendiconto")
@NamedQuery(name="SpDTipoRendiconto.findAll", query="SELECT s FROM SpDTipoRendiconto s")
public class SpDTipoRendiconto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codice;

	private String descrizione;
	@Id
	@Column(name="id_tipo")
	private Integer idTipo;

	public SpDTipoRendiconto() {
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

	public Integer getIdTipo() {
		return this.idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

}
