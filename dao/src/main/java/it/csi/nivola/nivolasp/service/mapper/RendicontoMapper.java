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
import org.mapstruct.MappingTarget;

import it.csi.nivola.nivolasp.domain.SpRendiconto;
import it.csi.nivola.nivolasp.service.dto.RendicontoDTO;

/**
 * Mapper for the entity SpRendiconto and its DTO RendicontoDTO.
 */
@Mapper(componentModel = "spring", uses={
		TipoRendicontoMapper.class
})
public interface RendicontoMapper {

    public RendicontoDTO toDTO(SpRendiconto rendiconto);
    
    public List<RendicontoDTO> toListDTO(List<SpRendiconto> rendiconto);

    public SpRendiconto toEntity(RendicontoDTO rendiconto);

    public void mapToEntity(RendicontoDTO rendicontoDTO, @MappingTarget SpRendiconto rendiconto);

}
