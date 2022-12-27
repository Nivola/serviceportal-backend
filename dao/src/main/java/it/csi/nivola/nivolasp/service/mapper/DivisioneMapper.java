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

import it.csi.nivola.nivolasp.integration.rest.model.service.GetDivisionResponseSchemaDivision;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListDivisionsResponseSchemaDivisions;
import it.csi.nivola.nivolasp.service.dto.DivisioneDTO;

/**
 * Mapper per Divisione
 */
@Mapper(componentModel = "spring")
public interface DivisioneMapper extends CommonTypesMapper {

	@Mapping(source="from.date.creation", target="creation")
	@Mapping(source="from.date.expiry", target="expiry")
	@Mapping(source="from.date.modified", target="modified")
	DivisioneDTO toDivisioneDTO(GetDivisionResponseSchemaDivision from);
	
	DivisioneDTO toDivisioneDTO(ListDivisionsResponseSchemaDivisions elem);

    
    List<DivisioneDTO> toListDivisioneDTOs(List<ListDivisionsResponseSchemaDivisions> elencoFrom);
}
