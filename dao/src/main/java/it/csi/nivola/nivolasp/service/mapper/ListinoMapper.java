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

import it.csi.nivola.nivolasp.domain.SpAccountInfocosto;
import it.csi.nivola.nivolasp.domain.SpAccountStaas;
import it.csi.nivola.nivolasp.domain.SpDListino;
import it.csi.nivola.nivolasp.domain.SpDListinoDettaglio;
import it.csi.nivola.nivolasp.domain.SpDListinoImporto;
import it.csi.nivola.nivolasp.domain.SpDTipoPrezzo;
import it.csi.nivola.nivolasp.repository.query.DistinctShares;
import it.csi.nivola.nivolasp.service.dto.CodiceEtichettaDescrizioneDTO;
import it.csi.nivola.nivolasp.service.dto.InfocostoDTO;
import it.csi.nivola.nivolasp.service.dto.ListinoDTO;
import it.csi.nivola.nivolasp.service.dto.ListinoDettaglioDTO;
import it.csi.nivola.nivolasp.service.dto.ListinoTipoPrezzoDTO;

/**
 * Mapper per le tabelle descrizione listino
 */
@Mapper(componentModel = "spring")
public abstract class ListinoMapper {
	
	/**
	 * Mappa un singolo listino
	 * @param from
	 * @return
	 */
	@Mapping(source="spDTipoPrezzos", target="tipiPrezzoAmmessi")
	public abstract ListinoDTO spDListinoToListinoDto (SpDListino from);
	
	/**
	 * Mappa un elenco di listini
	 * @param fromList
	 * @return
	 */
	public abstract List<ListinoDTO> spDListinoToListinoDtoElenco (List<SpDListino> fromList);
	
	
	/**
	 * Mappa un singolo elemento di dettaglio del listino
	 * @param from
	 * @return
	 */

	@Mapping(source="spDListinoImportos", target="elencoPrezzo")
	@Mapping(source="spDMetriche.spDTipoServizio.nome", target="servizio")
	public abstract ListinoDettaglioDTO spDListinoDettaglioToListinoDettaglioDto (SpDListinoDettaglio from);
	

	public abstract CodiceEtichettaDescrizioneDTO decodificaTipoPrezzo (SpDTipoPrezzo from);
	public abstract List<CodiceEtichettaDescrizioneDTO> decodificaTipoPrezzoElenco (List<SpDTipoPrezzo> from);
	
	/**
	 * Mappa un elenco di dettagli del listino
	 * @param fromList
	 * @return
	 */
	public abstract List<ListinoDettaglioDTO> spDListinoDettaglioToListinoDettaglioDtoElenco (List<SpDListinoDettaglio> fromList);
	
	@Mapping(source="spDTipoPrezzo.codice", target="codice")
	@Mapping(source="spDTipoPrezzo.descrizione", target="descrizione")
	public abstract ListinoTipoPrezzoDTO mappaTipoPrezzoImporto (SpDListinoImporto from);

	
	public abstract DistinctShares toDistinct(SpAccountStaas from);
	
	public abstract List<DistinctShares> toDistincts(List<SpAccountStaas> from);
	
	
	/**
	 * Mappa l'entità account infocosto
	 * @param from
	 * @return
	 */
	@Mapping(source="spDTipoPrezzo.codice", target="tipoPrezzoCodice")
	@Mapping(source="spDTipoPrezzo.descrizione", target="tipoPrezzoDescrizione")
	@Mapping(source="spDTipoListino.codice", target="tipoListinoCodice")
	@Mapping(source="spDTipoListino.descrizione", target="tipoListinoDescrizione")
	public abstract InfocostoDTO toInfocosto (SpAccountInfocosto from);
	/**
	 * Mappa elenco di entità infocosto
	 * @param from
	 * @return
	 */
	public abstract List<InfocostoDTO> toInfocostoList (List<SpAccountInfocosto> from);
	
	
	public java.time.LocalDateTime map(java.sql.Timestamp timestamp) {
    	if (timestamp == null) return null;
    	return timestamp.toLocalDateTime();
    }
	
	public java.time.LocalDate map(java.sql.Date date) {
		if (date == null) return null;
		return date.toLocalDate();
	}
}
