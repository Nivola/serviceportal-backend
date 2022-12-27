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

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.nivola.nivolasp.domain.SpAccountWb;
import it.csi.nivola.nivolasp.domain.SpDWb;
import it.csi.nivola.nivolasp.repository.SpAccountWbsRepository;
import it.csi.nivola.nivolasp.repository.SpDWbRepository;
import it.csi.nivola.nivolasp.service.dto.AssociazioneWbsAccountDto;
import it.csi.nivola.nivolasp.service.dto.WbsDTO;
import it.csi.nivola.nivolasp.service.mapper.WbsMapper;

@Service
public class WbsService {
	
	@Autowired
	SpDWbRepository spDWbRepository;
	
	@Autowired
	SpAccountWbsRepository spAccountWbsRepository;
	
	@Autowired
	WbsMapper wbsMapper;
	
	/**
	 * Elenco di tutte le WBS
	 * @return
	 */
	public List<WbsDTO> elencoWbsCensite () {
		return wbsMapper.toWbsDto(spDWbRepository.findAll());
	}
	
	/**
	 * Elenco delle WBS di un account
	 * @param accountId
	 * @return
	 */
	public List<AssociazioneWbsAccountDto> elencoWbsAccount (String accountId) {
		return wbsMapper.toAssociazioneDto(spAccountWbsRepository.findByRefAccount(accountId).get());
	}
	
	/**
	 * Elimina un'associazione WBS - account
	 * @param accountId
	 * @param associazioneId
	 */
	@Transactional
	public void cancellaAssociazioneAccount (String accountId, String associazioneId) {
		spAccountWbsRepository.eliminaAssociazione(accountId, associazioneId);
	}
	
	public void inserisciAssociazioneWbsAccount (AssociazioneWbsAccountDto associazione, BigInteger idAgente) {
		SpAccountWb associazioneDaRegistrare = new SpAccountWb();
		associazioneDaRegistrare.setDataCreazione(Timestamp.from(Instant.now()));
		associazioneDaRegistrare.setDataFineAssociazione(associazione.getDataFineAssociazione());
		associazioneDaRegistrare.setDataInizioAssociazione(associazione.getDataInizioAssociazione());
		associazioneDaRegistrare.setEwbsPerc(associazione.getEwbsPerc());
		associazioneDaRegistrare.setRefAccount(associazione.getRefAccount());
		associazioneDaRegistrare.setIdAgente(idAgente);
		
		SpDWb wbs = spDWbRepository.findByEwbs(associazione.getEwbs());
		
		associazioneDaRegistrare.setSpDWb(wbs);
		
		spAccountWbsRepository.saveAndFlush(associazioneDaRegistrare);
	}
}
