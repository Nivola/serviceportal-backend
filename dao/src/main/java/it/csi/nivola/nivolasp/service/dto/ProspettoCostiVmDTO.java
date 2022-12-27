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
import java.util.Map;

public class ProspettoCostiVmDTO extends RichiestaCostiVmDTO implements Serializable {

	private static final long serialVersionUID = 6894500840279312300L;

	private double costoUnitarioCpu;
	
	private double costoTotaleCpu;
	
	private double costoUnitarioRam;
	
	private double costoTotaleRam;
	
	private double costoUnitarioDiscoBase;
	
	private double costoTotaleDiscoBase;
	
	private double costoUnitarioDiscoPrestazionale;
	
	private double costoTotaleDiscoPrestazionale;
	
	private Map<String, CalcoloCostiVmDTO> costiDichiarati;

	public double getCostoUnitarioCpu() {
		return costoUnitarioCpu;
	}

	public void setCostoUnitarioCpu(double costoUnitarioCpu) {
		this.costoUnitarioCpu = costoUnitarioCpu;
	}

	public double getCostoTotaleCpu() {
		return costoTotaleCpu;
	}

	public void setCostoTotaleCpu(double costoTotaleCpu) {
		this.costoTotaleCpu = costoTotaleCpu;
	}

	public double getCostoUnitarioRam() {
		return costoUnitarioRam;
	}

	public void setCostoUnitarioRam(double costoUnitarioRam) {
		this.costoUnitarioRam = costoUnitarioRam;
	}

	public double getCostoTotaleRam() {
		return costoTotaleRam;
	}

	public void setCostoTotaleRam(double costoTotaleRam) {
		this.costoTotaleRam = costoTotaleRam;
	}

	public double getCostoUnitarioDiscoBase() {
		return costoUnitarioDiscoBase;
	}

	public void setCostoUnitarioDiscoBase(double costoUnitarioDiscoBase) {
		this.costoUnitarioDiscoBase = costoUnitarioDiscoBase;
	}

	public double getCostoTotaleDiscoBase() {
		return costoTotaleDiscoBase;
	}

	public void setCostoTotaleDiscoBase(double costoTotaleDiscoBase) {
		this.costoTotaleDiscoBase = costoTotaleDiscoBase;
	}

	public double getCostoUnitarioDiscoPrestazionale() {
		return costoUnitarioDiscoPrestazionale;
	}

	public void setCostoUnitarioDiscoPrestazionale(double costoUnitarioDiscoPrestazionale) {
		this.costoUnitarioDiscoPrestazionale = costoUnitarioDiscoPrestazionale;
	}

	public double getCostoTotaleDiscoPrestazionale() {
		return costoTotaleDiscoPrestazionale;
	}

	public void setCostoTotaleDiscoPrestazionale(double costoTotaleDiscoPrestazionale) {
		this.costoTotaleDiscoPrestazionale = costoTotaleDiscoPrestazionale;
	}

	public Map<String, CalcoloCostiVmDTO> getCostiDichiarati() {
		return costiDichiarati;
	}

	public void setCostiDichiarati(Map<String, CalcoloCostiVmDTO> costiDichiarati) {
		this.costiDichiarati = costiDichiarati;
	}
	
	
}
