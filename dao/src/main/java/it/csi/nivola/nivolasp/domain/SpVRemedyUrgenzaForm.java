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
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the sp_v_remedy_urgenza_form database table.
 * 
 */
@Entity
@Table(name="sp_v_remedy_urgenza_form")
@NamedQuery(name="SpVRemedyUrgenzaForm.findAll", query="SELECT s FROM SpVRemedyUrgenzaForm s")
public class SpVRemedyUrgenzaForm implements Serializable {

	private static final long serialVersionUID = 929958082119113137L;
	
	@Id
	private String id;

	@Column(name="id_impatto")
	private Long idImpatto;

	@Column(name="impatto")
	private String impatto;

	@Column(name="id_tipologia")
	private Long idTipologia;
	
	@Column(name="tipologia")
	private String tipologia;
	
	@Column(name="liv_gest_tenant_da")
	private Long livelloTenantDa;
	
	@Column(name="liv_gest_tenant_a")
	private Long livelloTentantA;
	
	@Column(name="id_urgenza")
	private Long idUrgenza;
	
	@Column(name="urgenza")
	private String urgenza;

	public Long getIdImpatto() {
		return idImpatto;
	}

	public void setIdImpatto(Long idImpatto) {
		this.idImpatto = idImpatto;
	}

	public String getImpatto() {
		return impatto;
	}

	public void setImpatto(String impatto) {
		this.impatto = impatto;
	}

	public Long getIdTipologia() {
		return idTipologia;
	}

	public void setIdTipologia(Long idTipologia) {
		this.idTipologia = idTipologia;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public Long getLivelloTenantDa() {
		return livelloTenantDa;
	}

	public void setLivelloTenantDa(Long livelloTenantDa) {
		this.livelloTenantDa = livelloTenantDa;
	}

	public Long getLivelloTentantA() {
		return livelloTentantA;
	}

	public void setLivelloTentantA(Long livelloTentantA) {
		this.livelloTentantA = livelloTentantA;
	}

	public Long getIdUrgenza() {
		return idUrgenza;
	}

	public void setIdUrgenza(Long idUrgenza) {
		this.idUrgenza = idUrgenza;
	}

	public String getUrgenza() {
		return urgenza;
	}

	public void setUrgenza(String urgenza) {
		this.urgenza = urgenza;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	

}
