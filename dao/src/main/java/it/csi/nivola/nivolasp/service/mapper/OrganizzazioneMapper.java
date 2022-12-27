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

import it.csi.nivola.nivolasp.integration.rest.model.service.GetOrganizationResponseSchemaOrganization;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListOrganizationsResponseSchemaOrganizations;
import it.csi.nivola.nivolasp.service.dto.OrganizzazioneDTO;

/**
 * Mapper per Organizzazione
 */
@Mapper(componentModel = "spring")
public interface OrganizzazioneMapper extends CommonTypesMapper {

	@Mapping(source="from.date.creation", target="creation")
	@Mapping(source="from.date.expiry", target="expiry")
	@Mapping(source="from.date.modified", target="modified")
	OrganizzazioneDTO toOrganizzazioneDTO(GetOrganizationResponseSchemaOrganization from);
	
    OrganizzazioneDTO toOrganizzazioneDTOs(ListOrganizationsResponseSchemaOrganizations elencoFrom);
    
    List<OrganizzazioneDTO> toListOrganizzazioneDTOs(List<ListOrganizationsResponseSchemaOrganizations> elencoFrom);
}
