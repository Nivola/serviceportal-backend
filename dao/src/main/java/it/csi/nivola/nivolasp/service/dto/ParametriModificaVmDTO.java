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

public class ParametriModificaVmDTO implements Serializable {

	private static final long serialVersionUID = 5830029605370867578L;
	
	private String instanceUuid;
	private String flavourUuid;
	private List<String> elencoGruppiAggiungere;
	private List<String> elencoGruppiEliminare;
	
	
	
	public String getInstanceUuid() {
		return instanceUuid;
	}
	public void setInstanceUuid(String instanceUuid) {
		this.instanceUuid = instanceUuid;
	}
	public String getFlavourUuid() {
		return flavourUuid;
	}
	public void setFlavourUuid(String flavourUuid) {
		this.flavourUuid = flavourUuid;
	}
	public List<String> getElencoGruppiAggiungere() {
		return elencoGruppiAggiungere;
	}
	public void setElencoGruppiAggiungere(List<String> elencoGruppiAggiungere) {
		this.elencoGruppiAggiungere = elencoGruppiAggiungere;
	}
	public List<String> getElencoGruppiEliminare() {
		return elencoGruppiEliminare;
	}
	public void setElencoGruppiEliminare(List<String> elencoGruppiEliminare) {
		this.elencoGruppiEliminare = elencoGruppiEliminare;
	}	
	
	
}
