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
package it.csi.nivola.nivolasp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.csi.nivola.nivolasp.domain.SpDTipoDocumento;
import it.csi.nivola.nivolasp.repository.SpDTipoDocumentoRepository;
import it.csi.nivola.nivolasp.service.dto.CodiceEtichettaDescrizioneDTO;

/**
 * Servizio per la gestione dei documenti
 */
@Service
@Transactional
public class DocumentiService {
	
	@Autowired
	SpDTipoDocumentoRepository spDTipoDocumentoRepository;
	
	public List<CodiceEtichettaDescrizioneDTO> elencoTipiDocumento () {
		List<SpDTipoDocumento> elencoTipiDB = spDTipoDocumentoRepository.findByAttivoTrue();
		return elencoTipiDB.stream().map(tipo -> new CodiceEtichettaDescrizioneDTO(String.valueOf(tipo.getId()), tipo.getTipoDocumento(), tipo.getTipoDocumento())).collect(Collectors.toList());
	}
}
