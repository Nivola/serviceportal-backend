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
 * The persistent class for the sp_d_urgenza_form database table.
 * 
 */
@Entity
@Table(name="sp_d_urgenza_form")
@NamedQuery(name="SpDUrgenzaForm.findAll", query="SELECT s FROM SpDUrgenzaForm s")
public class SpDUrgenzaForm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="tenant_a")
	private int tenantA;

	@Column(name="tenant_da")
	private int tenantDa;

	@Column(name="valore_portale")
	private String valorePortale;

	@Column(name="valore_remedy")
	private String valoreRemedy;

	public SpDUrgenzaForm() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTenantA() {
		return this.tenantA;
	}

	public void setTenantA(int tenantA) {
		this.tenantA = tenantA;
	}

	public int getTenantDa() {
		return this.tenantDa;
	}

	public void setTenantDa(int tenantDa) {
		this.tenantDa = tenantDa;
	}

	public String getValorePortale() {
		return this.valorePortale;
	}

	public void setValorePortale(String valorePortale) {
		this.valorePortale = valorePortale;
	}

	public String getValoreRemedy() {
		return this.valoreRemedy;
	}

	public void setValoreRemedy(String valoreRemedy) {
		this.valoreRemedy = valoreRemedy;
	}

}
