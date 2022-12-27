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

import it.csi.nivola.nivolasp.domain.SpDTipoAttributo;
import it.csi.nivola.nivolasp.domain.SpDivisioneAttributo;
import it.csi.nivola.nivolasp.domain.SpOrganizzazioneAttributo;
import it.csi.nivola.nivolasp.service.dto.AttributoStrutturaDTO;


public interface AttributiService {

	List<SpDTipoAttributo> findAllAttributi();
	
	List<AttributoStrutturaDTO> elencoAttributiDivisione(String divId);
	
	List<AttributoStrutturaDTO> elencoAttributiOrganizzazione(String orgId);
	
	public void inserisciAttributoDivisione(SpDivisioneAttributo attributo);
	
	public void inserisciAttributoOrganizzazione(SpOrganizzazioneAttributo attributo);

	SpDTipoAttributo trovaAttributoPerNome(String nome);
	
	SpDivisioneAttributo trovaAttributoDivisionePerNomeEDivisione(String nome, String divId);
	
	SpOrganizzazioneAttributo trovaAttributoOrganizzazionePerNomeEDivisione(String nome, String divId);
	
	void eliminaAttributoDivisione (SpDivisioneAttributo toBeDeleted);
	
	void eliminaAttributoOrganizzazione (SpOrganizzazioneAttributo toBeDeleted);
}
