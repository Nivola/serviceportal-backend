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

import it.csi.nivola.nivolasp.domain.SpAccountWb;
import it.csi.nivola.nivolasp.domain.SpDWb;
import it.csi.nivola.nivolasp.service.dto.AssociazioneWbsAccountDto;
import it.csi.nivola.nivolasp.service.dto.WbsDTO;

/**
 * Mapper per la WBS
 */
@Mapper(componentModel = "spring")
public interface WbsMapper extends CommonTypesMapper {
	
	/**
	 * Mappa l'entita' che identifica una WBS per il frontend
	 * @param from
	 * @return
	 */
	WbsDTO toWbsDto(SpDWb from);
	
	/**
	 * Lista di WBS per il frontend
	 * @param from
	 * @return
	 */
	List<WbsDTO> toWbsDto(List<SpDWb> from);
	
	
	/**
	 * Descrizione di un'associazione wbs con l'account
	 * @param from
	 * @return
	 */
	@Mapping(source="from.spDWb.ewbs", target="ewbs")
	@Mapping(source="from.spDWb.committente", target="committente")
	@Mapping(source="from.spDWb.idCommittente", target="idCommittente")
	@Mapping(source="from.spDWb.idCatTipologia", target="idCatTipologia")
	@Mapping(source="from.spDWb.descrCatTipologia", target="descrCatTipologia")
	@Mapping(source="from.spDWb.descrCatSottotipologia", target="descrCatSottotipologia")
	AssociazioneWbsAccountDto toAssociazioneDto(SpAccountWb from);
	
	/**
	 * Elenco di associazioni WBS - account
	 * @param from
	 * @return
	 */
	List<AssociazioneWbsAccountDto> toAssociazioneDto(List<SpAccountWb> from);
}
