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
package it.csi.nivola.nivolasp.service.dto;

import java.io.Serializable;

public class CreazioneSecurityGroupDTO implements Serializable {

	private static final long serialVersionUID = -3673261590328823135L;

	private String descrizione = null;

	private String nome = null;

	private String uuidTemplate = null;

	private String vpcId = null;

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUuidTemplate() {
		return uuidTemplate;
	}

	public void setUuidTemplate(String uuidTemplate) {
		this.uuidTemplate = uuidTemplate;
	}

	public String getVpcId() {
		return vpcId;
	}

	public void setVpcId(String vpcId) {
		this.vpcId = vpcId;
	}

}
