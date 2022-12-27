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

public class AvailabilityZoneDTO extends AbstractDTO {

	private static final long serialVersionUID = -8297121986172127405L;

	private String zoneName = null;
	
	private String zoneUuid;
	
	public AvailabilityZoneDTO (String zoneName, String zoneUuid) {
		this.zoneName = zoneName;
		this.zoneUuid = zoneUuid;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public String getZoneUuid() {
		return zoneUuid;
	}

	public void setZoneUuid(String zoneUuid) {
		this.zoneUuid = zoneUuid;
	}
	
	

}
