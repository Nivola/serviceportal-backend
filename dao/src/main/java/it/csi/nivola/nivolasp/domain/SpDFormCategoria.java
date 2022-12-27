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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the sp_d_form_categoria database table.
 * 
 */
@Entity
@Table(name="sp_d_form_categoria")
@NamedQuery(name="SpDFormCategoria.findAll", query="SELECT s FROM SpDFormCategoria s")
public class SpDFormCategoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="livello_1")
	private String livello1;

	@Column(name="livello_2")
	private String livello2;

	@Column(name="livello_3")
	private String livello3;

	private String tecnologia;

	public SpDFormCategoria() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getTecnologia() {
		return this.tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

}
