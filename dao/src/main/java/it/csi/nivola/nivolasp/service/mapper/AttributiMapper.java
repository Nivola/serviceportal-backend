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

import it.csi.nivola.nivolasp.domain.SpDivisioneAttributo;
import it.csi.nivola.nivolasp.domain.SpOrganizzazioneAttributo;
import it.csi.nivola.nivolasp.service.dto.AttributoStrutturaDTO;

/**
 * Mapper for the entity Message and its DTO NewsDto.
 */
@Mapper(componentModel = "spring")
public interface AttributiMapper {

	@Mapping(source="from.spDTipoAttributo.descrizioneEstesa", target="descrizioneTipo")
	@Mapping(source="from.spUser.cognome", target="utenteInserimento")
	@Mapping(source="from.divId", target="uuidStruttura")
	AttributoStrutturaDTO spDivisioneAttributoToAttributoStrutturaDto(SpDivisioneAttributo from);
	
	List<AttributoStrutturaDTO> elencoAttributiDivisione(List<SpDivisioneAttributo> from);
	
	
	@Mapping(source="from.spDTipoAttributo.descrizioneEstesa", target="descrizioneTipo")
	@Mapping(source="from.spUser.cognome", target="utenteInserimento")
	@Mapping(source="from.orgId", target="uuidStruttura")
	AttributoStrutturaDTO spOrganizzazioneAttributoToAttributoStrutturaDto(SpOrganizzazioneAttributo from);
	
	List<AttributoStrutturaDTO> elencoAttributiOrganizzazione(List<SpOrganizzazioneAttributo> from);

   
}
