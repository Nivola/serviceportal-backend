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

import java.util.ArrayList;
import java.util.List;

public class RegionAvailabilityZoneDTO extends AbstractDTO {
	
	
	private static final long serialVersionUID = 2433238395423602832L;

	private String regionName;
	
	private String regionUuid;
	
	private List<AvailabilityZoneDTO> elencoAz = new ArrayList<>();
	
	public RegionAvailabilityZoneDTO (String regionName, String regionUuid, String azName, String azUuid) {
		this.regionName = regionName;
		this.regionUuid = regionUuid;
		addAvailabilityZone(azName, azUuid);
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getRegionUuid() {
		return regionUuid;
	}

	public void setRegionUuid(String regionUuid) {
		this.regionUuid = regionUuid;
	}

	public List<AvailabilityZoneDTO> getElencoAz() {
		return elencoAz;
	}
	
	public void addAvailabilityZone (String azName, String azUuid) {
		elencoAz.add(new AvailabilityZoneDTO(azName, azUuid));
	}

	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		return regionName.equals(((RegionAvailabilityZoneDTO)obj).getRegionName());
	}
	
	@Override
	public int hashCode() {
		return regionName.hashCode();
	}
	

}
