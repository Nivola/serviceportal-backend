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
package it.csi.nivola.nivolasp.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.csi.nivola.nivolasp.integration.rest.model.service.GetAccountCapabilitiesResponseSchemaCapabilities;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListAccountCapabilitiesResponseSchemaCapabilities;
import it.csi.nivola.nivolasp.service.dto.CapabilitiesDTO;
import it.csi.nivola.nivolasp.service.dto.StatoCapabilityDTO;

/**
 * Mapper per Capabilities e stato capabilities
 */
@Mapper(componentModel = "spring")
public interface CapabilitiesMapper extends CommonTypesMapper {

	@Mapping(source = "from.date.creation", target = "creation")
	@Mapping(source = "from.date.expiry", target = "expiry")
	@Mapping(source = "from.date.modified", target = "modified")
	CapabilitiesDTO toCapabilitiesDTO(ListAccountCapabilitiesResponseSchemaCapabilities from);

	List<CapabilitiesDTO> toListCapabilitiesDTOs( List<ListAccountCapabilitiesResponseSchemaCapabilities> from);
	
	StatoCapabilityDTO toStatoCapabilityDTO (GetAccountCapabilitiesResponseSchemaCapabilities from);
	
	List<StatoCapabilityDTO> toListStatoCapabilityDTO (List<GetAccountCapabilitiesResponseSchemaCapabilities> from);
}
