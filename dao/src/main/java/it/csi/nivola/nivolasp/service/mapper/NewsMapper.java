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

import it.csi.nivola.nivolasp.domain.SpNews;
import it.csi.nivola.nivolasp.service.dto.NewsDto;

/**
 * Mapper for the entity Message and its DTO NewsDto.
 */
@Mapper(componentModel = "spring")
public interface NewsMapper {

	@Mapping(source="from.spStatoNew.stato", target="stato")
	NewsDto spNewsToNewsDto(SpNews from);

    List<NewsDto> spNewssToNewsDtos(List<SpNews> messages);

    SpNews newsDtoToSpNews(NewsDto from);

    List<SpNews> newsDtosToSpNews(List<NewsDto> NewsDtos);
   
}
