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

import it.csi.nivola.nivolasp.domain.SpLogAzione;
import it.csi.nivola.nivolasp.service.dto.LogAzioneDTO;

@Mapper(componentModel = "spring")
public abstract class LogsMapper {
	
	@Mapping(target = "nome", expression = "java(from.getSpUser().getNome() + \" \" + from.getSpUser().getCognome())")
	@Mapping(source="from.spUser.cmpUsername", target="username")
	public abstract LogAzioneDTO toLogAzioneDto (SpLogAzione from);
	
	public abstract List<LogAzioneDTO> toLogAzioneDtoList (List<SpLogAzione> from);
	
	public java.time.LocalDateTime map(java.sql.Timestamp timestamp) {
    	if (timestamp == null) return null;
    	return timestamp.toLocalDateTime();
    }

}
