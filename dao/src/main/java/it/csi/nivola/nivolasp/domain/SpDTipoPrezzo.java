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
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the sp_d_tipo_prezzo database table.
 * 
 */
@Entity
@Table(name="sp_d_tipo_prezzo")
@NamedQuery(name="SpDTipoPrezzo.findAll", query="SELECT s FROM SpDTipoPrezzo s")
public class SpDTipoPrezzo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String codice;

	@Column(name="data_cancellazione")
	private Timestamp dataCancellazione;

	@Column(name="data_creazione")
	private Timestamp dataCreazione;

	@Column(name="data_modifica")
	private Timestamp dataModifica;

	private String descrizione;

	@Column(name="id_agente")
	private BigInteger idAgente;

	//bi-directional many-to-one association to SpAccountAttributo
	@OneToMany(mappedBy="spDTipoPrezzo")
	private List<SpAccountAttributo> spAccountAttributos;
	
	 @ManyToMany(mappedBy = "spDTipoPrezzos", fetch = FetchType.LAZY)
	 private List<SpDListino> spDListinos;

	public SpDTipoPrezzo() {
	}

	public String getCodice() {
		return this.codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public Timestamp getDataCancellazione() {
		return this.dataCancellazione;
	}

	public void setDataCancellazione(Timestamp dataCancellazione) {
		this.dataCancellazione = dataCancellazione;
	}

	public Timestamp getDataCreazione() {
		return this.dataCreazione;
	}

	public void setDataCreazione(Timestamp dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Timestamp getDataModifica() {
		return this.dataModifica;
	}

	public void setDataModifica(Timestamp dataModifica) {
		this.dataModifica = dataModifica;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public BigInteger getIdAgente() {
		return this.idAgente;
	}

	public void setIdAgente(BigInteger idAgente) {
		this.idAgente = idAgente;
	}

	public List<SpAccountAttributo> getSpAccountAttributos() {
		return this.spAccountAttributos;
	}

	public void setSpAccountAttributos(List<SpAccountAttributo> spAccountAttributos) {
		this.spAccountAttributos = spAccountAttributos;
	}

	public SpAccountAttributo addSpAccountAttributo(SpAccountAttributo spAccountAttributo) {
		getSpAccountAttributos().add(spAccountAttributo);
		spAccountAttributo.setSpDTipoPrezzo(this);

		return spAccountAttributo;
	}

	public SpAccountAttributo removeSpAccountAttributo(SpAccountAttributo spAccountAttributo) {
		getSpAccountAttributos().remove(spAccountAttributo);
		spAccountAttributo.setSpDTipoPrezzo(null);

		return spAccountAttributo;
	}

	public List<SpDListino> getSpDListinos() {
		return spDListinos;
	}

	public void setSpDListinos(List<SpDListino> spDListinos) {
		this.spDListinos = spDListinos;
	}

}
