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
package it.csi.nivola.nivolasp.service.dto;

import java.io.Serializable;
import java.util.List;

public class ParametriCreazioneDbaas implements Serializable {

	private static final long serialVersionUID = 5345422387243566632L;

	private String nome;
	
	private String descrizione;
	
	private String flavourName;
	
	private Integer spazioAllocazione;
	
	private String engine;
	
	private String versione;
	
	private String chiaveSSH;
	
	private String identificativoIstanza;
	
	private String region;
	
	private String az;
	
	private String subnet;
	
	private String securityGroup;
	
	private String schemaName;
	
	private List<String> tags;
	
	private String adminPassword;
	
	private Integer porta;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getFlavourName() {
		return flavourName;
	}

	public void setFlavourName(String flavourName) {
		this.flavourName = flavourName;
	}

	public Integer getSpazioAllocazione() {
		return spazioAllocazione;
	}

	public void setSpazioAllocazione(Integer spazioAllocazione) {
		this.spazioAllocazione = spazioAllocazione;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getVersione() {
		return versione;
	}

	public void setVersione(String versione) {
		this.versione = versione;
	}

	public String getChiaveSSH() {
		return chiaveSSH;
	}

	public void setChiaveSSH(String chiaveSSH) {
		this.chiaveSSH = chiaveSSH;
	}

	public String getIdentificativoIstanza() {
		return identificativoIstanza;
	}

	public void setIdentificativoIstanza(String identificativoIstanza) {
		this.identificativoIstanza = identificativoIstanza;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAz() {
		return az;
	}

	public void setAz(String az) {
		this.az = az;
	}

	public String getSubnet() {
		return subnet;
	}

	public void setSubnet(String subnet) {
		this.subnet = subnet;
	}

	public String getSecurityGroup() {
		return securityGroup;
	}

	public void setSecurityGroup(String securityGroup) {
		this.securityGroup = securityGroup;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public Integer getPorta() {
		return porta;
	}

	public void setPorta(Integer porta) {
		this.porta = porta;
	}
	
}
