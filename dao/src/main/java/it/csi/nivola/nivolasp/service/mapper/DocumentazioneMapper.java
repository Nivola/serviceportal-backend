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

import it.csi.nivola.nivolasp.domain.SpDReadTheDocsMapping;
import it.csi.nivola.nivolasp.service.dto.DocumentazioneDTO;

@Mapper(componentModel = "spring")
public interface DocumentazioneMapper {

	public DocumentazioneDTO toDocumentazioneDto (SpDReadTheDocsMapping from);
	public List<DocumentazioneDTO> toDocumentazioneDtos (List<SpDReadTheDocsMapping> from);
	
	public SpDReadTheDocsMapping fromDocumentazioneDto (DocumentazioneDTO from);
}
