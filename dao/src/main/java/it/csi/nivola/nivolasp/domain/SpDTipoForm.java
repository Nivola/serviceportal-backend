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
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the sp_d_tipo_form database table.
 * 
 */
@Entity
@Table(name="sp_d_tipo_form")
@NamedQuery(name="SpDTipoForm.findAll", query="SELECT s FROM SpDTipoForm s")
public class SpDTipoForm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="classe_json")
	private String classeJson;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_inserimento")
	private Date dataInserimento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_modifica")
	private Date dataModifica;

	private String livello1;

	private String livello2;

	private String livello3;

	private String nome;

	private String tipologia;

	//bi-directional many-to-one association to SpUser
	@ManyToOne
	@JoinColumn(name="id_agente")
	private SpUser spUser;

	//bi-directional many-to-one association to SpFormRichieste
	@OneToMany(mappedBy="spDTipoForm", fetch=FetchType.LAZY)
	private List<SpFormRichieste> spFormRichiestes;

	public SpDTipoForm() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClasseJson() {
		return this.classeJson;
	}

	public void setClasseJson(String classeJson) {
		this.classeJson = classeJson;
	}

	public Date getDataInserimento() {
		return this.dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public Date getDataModifica() {
		return this.dataModifica;
	}

	public void setDataModifica(Date dataModifica) {
		this.dataModifica = dataModifica;
	}

	public String getLivello1() {
		return this.livello1;
	}

	public void setLivello1(String livello1) {
		this.livello1 = livello1;
	}

	public String getLivello2() {
		return this.livello2;
	}

	public void setLivello2(String livello2) {
		this.livello2 = livello2;
	}

	public String getLivello3() {
		return this.livello3;
	}

	public void setLivello3(String livello3) {
		this.livello3 = livello3;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipologia() {
		return this.tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public SpUser getSpUser() {
		return this.spUser;
	}

	public void setSpUser(SpUser spUser) {
		this.spUser = spUser;
	}

	public List<SpFormRichieste> getSpFormRichiestes() {
		return this.spFormRichiestes;
	}

	public void setSpFormRichiestes(List<SpFormRichieste> spFormRichiestes) {
		this.spFormRichiestes = spFormRichiestes;
	}

	public SpFormRichieste addSpFormRichieste(SpFormRichieste spFormRichieste) {
		getSpFormRichiestes().add(spFormRichieste);
		spFormRichieste.setSpDTipoForm(this);

		return spFormRichieste;
	}

	public SpFormRichieste removeSpFormRichieste(SpFormRichieste spFormRichieste) {
		getSpFormRichiestes().remove(spFormRichieste);
		spFormRichieste.setSpDTipoForm(null);

		return spFormRichieste;
	}

}
