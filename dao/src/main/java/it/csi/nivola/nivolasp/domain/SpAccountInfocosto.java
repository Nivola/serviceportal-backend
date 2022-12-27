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
import java.sql.Date;
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
 * The persistent class for the sp_account_infocosto database table.
 * 
 */
@Entity
@Table(name="sp_account_infocosto")
@NamedQuery(name="SpAccountInfocosto.findAll", query="SELECT s FROM SpAccountInfocosto s")
public class SpAccountInfocosto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="ref_account")
	private String refAccount;

	@Column(name="data_creazione")
	private Timestamp dataCreazione;

	@Column(name="data_fine_associazione")
	private Date dataFineAssociazione;

	@Column(name="data_inizio_associazione")
	private Date dataInizioAssociazione;

	@Column(name="id_agente")
	private BigInteger idAgente;

	@Column(name="usa_listino_specifico")
	private String usaListinoSpecifico;

	//bi-directional many-to-one association to SpDListino
	@ManyToOne
	@JoinColumn(name="id_listino_specifico")
	private SpDListino spDListino;

	//bi-directional many-to-one association to SpDTipoListino
	@ManyToOne
	@JoinColumn(name="tipo_listino")
	private SpDTipoListino spDTipoListino;

	//bi-directional many-to-one association to SpDTipoPrezzo
	@ManyToOne
	@JoinColumn(name="tipo_prezzo")
	private SpDTipoPrezzo spDTipoPrezzo;

	public SpAccountInfocosto() {
	}

	public String getRefAccount() {
		return this.refAccount;
	}

	public void setRefAccount(String refAccount) {
		this.refAccount = refAccount;
	}

	public Timestamp getDataCreazione() {
		return this.dataCreazione;
	}

	public void setDataCreazione(Timestamp dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Date getDataFineAssociazione() {
		return this.dataFineAssociazione;
	}

	public void setDataFineAssociazione(Date dataFineAssociazione) {
		this.dataFineAssociazione = dataFineAssociazione;
	}

	public Date getDataInizioAssociazione() {
		return this.dataInizioAssociazione;
	}

	public void setDataInizioAssociazione(Date dataInizioAssociazione) {
		this.dataInizioAssociazione = dataInizioAssociazione;
	}

	public BigInteger getIdAgente() {
		return this.idAgente;
	}

	public void setIdAgente(BigInteger idAgente) {
		this.idAgente = idAgente;
	}

	public String getUsaListinoSpecifico() {
		return this.usaListinoSpecifico;
	}

	public void setUsaListinoSpecifico(String usaListinoSpecifico) {
		this.usaListinoSpecifico = usaListinoSpecifico;
	}

	public SpDListino getSpDListino() {
		return this.spDListino;
	}

	public void setSpDListino(SpDListino spDListino) {
		this.spDListino = spDListino;
	}

	public SpDTipoListino getSpDTipoListino() {
		return this.spDTipoListino;
	}

	public void setSpDTipoListino(SpDTipoListino spDTipoListino) {
		this.spDTipoListino = spDTipoListino;
	}

	public SpDTipoPrezzo getSpDTipoPrezzo() {
		return this.spDTipoPrezzo;
	}

	public void setSpDTipoPrezzo(SpDTipoPrezzo spDTipoPrezzo) {
		this.spDTipoPrezzo = spDTipoPrezzo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}
