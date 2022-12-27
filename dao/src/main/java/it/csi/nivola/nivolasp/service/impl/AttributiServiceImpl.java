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
package it.csi.nivola.nivolasp.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.nivola.nivolasp.domain.SpDTipoAttributo;
import it.csi.nivola.nivolasp.domain.SpDivisioneAttributo;
import it.csi.nivola.nivolasp.domain.SpOrganizzazioneAttributo;
import it.csi.nivola.nivolasp.repository.SpDTipoAttributoRepository;
import it.csi.nivola.nivolasp.repository.SpDivisioneAttributoRepository;
import it.csi.nivola.nivolasp.repository.SpOrganizzazioneAttributoRepository;
import it.csi.nivola.nivolasp.service.AttributiService;
import it.csi.nivola.nivolasp.service.dto.AttributoStrutturaDTO;
import it.csi.nivola.nivolasp.service.mapper.AttributiMapper;

@Service
@Transactional
public class AttributiServiceImpl implements AttributiService {
	
	@Autowired
	SpDTipoAttributoRepository spDTipoAttributoRepository;
	
	@Autowired
	SpDivisioneAttributoRepository spDivisioneAttributoRepository;
	
	@Autowired
	SpOrganizzazioneAttributoRepository spOrganizzazioneAttributoRepository;
	
	@Autowired
	AttributiMapper attributiMapper;

	@Override
	public List<SpDTipoAttributo> findAllAttributi() {
		return spDTipoAttributoRepository.findAll();
	}

	@Override
	public List<AttributoStrutturaDTO> elencoAttributiDivisione(String divId) {
		return attributiMapper.elencoAttributiDivisione(spDivisioneAttributoRepository.findByDivId(divId));
	}

	@Override
	public List<AttributoStrutturaDTO> elencoAttributiOrganizzazione(String orgId) {
		return attributiMapper.elencoAttributiOrganizzazione(spOrganizzazioneAttributoRepository.findByOrgId(orgId));
	}

	@Override
	public void inserisciAttributoDivisione(SpDivisioneAttributo attributo) {
		spDivisioneAttributoRepository.saveAndFlush(attributo);

	}

	@Override
	public void inserisciAttributoOrganizzazione(SpOrganizzazioneAttributo attributo) {
		spOrganizzazioneAttributoRepository.saveAndFlush(attributo);

	}
	
	@Override
	public SpDTipoAttributo trovaAttributoPerNome(String nome) {
		return spDTipoAttributoRepository.findByNome(nome);
	}

	@Override
	public SpDivisioneAttributo trovaAttributoDivisionePerNomeEDivisione(String nome, String divId) {
		return spDivisioneAttributoRepository.trovaPerDivisioneTipo(nome, divId);
	}

	@Override
	public SpOrganizzazioneAttributo trovaAttributoOrganizzazionePerNomeEDivisione(String nome, String divId) {
		return spOrganizzazioneAttributoRepository.trovaPerOrganizzazioneTipo(nome, divId);
	}

	@Override
	public void eliminaAttributoDivisione(SpDivisioneAttributo toBeDeleted) {
		spDivisioneAttributoRepository.delete(toBeDeleted);
		
	}

	@Override
	public void eliminaAttributoOrganizzazione(SpOrganizzazioneAttributo toBeDeleted) {
		spOrganizzazioneAttributoRepository.delete(toBeDeleted);
	}
	

}
