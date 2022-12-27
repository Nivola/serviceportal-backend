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

public class RichiestaCapabilityDTO {
	
	private String id;
	
	private String uuidCapability;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUuidCapability() {
		return uuidCapability;
	}

	public void setUuidCapability(String uuidCapability) {
		this.uuidCapability = uuidCapability;
	}
	
	

}
