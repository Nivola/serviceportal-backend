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


import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import it.csi.nivola.nivolasp.domain.SpDTipoRendiconto;
import it.csi.nivola.nivolasp.service.dto.TipoRendicontoDto;

/**
 * Mapper for the entity SpRendiconto and its DTO RendicontoDTO.
 */
@Mapper(componentModel = "spring")
public interface TipoRendicontoMapper {

	public static final TipoRendicontoMapper INSTANCE = Mappers.getMapper(TipoRendicontoMapper.class);

    public TipoRendicontoDto toDTO(SpDTipoRendiconto tipoRendiconto);

    public SpDTipoRendiconto toEntity(TipoRendicontoDto rendiconto);

    public void mapToEntity(TipoRendicontoDto rendicontoDTO, @MappingTarget SpDTipoRendiconto rendiconto);

}
