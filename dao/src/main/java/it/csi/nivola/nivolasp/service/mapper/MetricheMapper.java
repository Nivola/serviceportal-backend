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
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import it.csi.nivola.nivolasp.domain.SpDMetriche;
import it.csi.nivola.nivolasp.domain.SpMetricheDichiarate;
import it.csi.nivola.nivolasp.service.dto.MetricaDTO;
import it.csi.nivola.nivolasp.service.dto.MetricaListinoDefinizioneDTO;
import it.csi.nivola.nivolasp.service.dto.ValoreCostoListinoDTO;

/**
 * Mapper for the entity SpRendiconto and its DTO MetricheDto.
 */
@Mapper(componentModel = "spring")
public abstract class MetricheMapper {

    @Mappings({
        @Mapping(source = "nome", target = "metric"),
        @Mapping(source = "udm", target = "unit"),
        @Mapping(source = "calcRegex", target = "regola"),
        @Mapping(source = "spDTipoServizio.nome", target = "servizio"),
    })
    public abstract MetricaDTO toDTO(SpDMetriche metrica);
    
    public abstract List<MetricaDTO> toDTOList(List<SpDMetriche> metrica);

    public abstract SpDMetriche toEntity(MetricaDTO metrica);

    public abstract void mapToEntity(MetricaDTO metricaDto, @MappingTarget SpDMetriche metrica);
    
   
    
    public abstract MetricaListinoDefinizioneDTO toMetricaDefinizioneNumerico (MetricaDTO metrica);
    
    @Mappings({
        @Mapping(source = "id", target = "idValore"),
        @Mapping(source = "spDMetriche.nome", target = "nomeMetricaDefinizione"),
        @Mapping(source = "spDMetriche.descrizione", target = "descrizioneMetrica"),
        @Mapping(source = "refAccount", target = "accountUuid"),
        @Mapping(source = "qta", target = "quantita"),
        @Mapping(source = "dataInizioValidita", target = "dataDa"),
        @Mapping(source = "dataFineValidita", target = "dataA"),
        @Mapping(source = "dataModifica", target = "dataModifica"),
        @Mapping(source = "dataCancellazione", target = "dataCancellazione"),
        @Mapping(target = "etichettaValore", expression="java(decodificaTenant(from))")
    })
    public abstract ValoreCostoListinoDTO convertiMetricaDichiarataInValoreCosto (SpMetricheDichiarate from);
    
    
    public abstract List<ValoreCostoListinoDTO> convertiElencoMetricaDichiarataInValoreCosto (List<SpMetricheDichiarate> from);
    
    public java.time.LocalDateTime map(java.sql.Timestamp timestamp) {
    	if (timestamp == null) return null;
    	return timestamp.toLocalDateTime();
    }
    
    public String decodificaTenant (SpMetricheDichiarate from) {
    	if (from.getSpDMetriche().getNome().contains("tenant") && from.getQta() != null) {
	    	switch (from.getQta().intValue()) {
			case 1:
				return "Developer";
			case 2:
				return "Standard";
			case 3:
				return "Standard orario esteso";
			case 4:
				return "Premium";
			case 5:
				return "Premium orario esteso";
			case 6:
				return "Premium H24";
			default:
				return null;
			}
    	}
    	return null;
    }
}
