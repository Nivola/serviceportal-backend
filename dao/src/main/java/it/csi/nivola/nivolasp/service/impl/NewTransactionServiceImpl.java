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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.csi.nivola.nivolasp.domain.SpFormAllegato;
import it.csi.nivola.nivolasp.domain.SpFormRichieste;
import it.csi.nivola.nivolasp.repository.SpFormAllegatoRepository;
import it.csi.nivola.nivolasp.repository.SpFormRichiesteRepository;

/**
 * Servizio per la gestione delle form di richiesta assistenza -> segnalazioni Remedy
 */
@Service
@Transactional
public class NewTransactionServiceImpl implements it.csi.nivola.nivolasp.service.NewTransactionService {

	@Autowired
	SpFormRichiesteRepository spFormRichiesteRepository;

	@Autowired
	SpFormAllegatoRepository spFormAllegatoRepository;
	
	/**
	 * Salva un form in una transazione nuova
	 * @param daSalvare
	 * @return
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public SpFormRichieste salvaFormRichieste (SpFormRichieste daSalvare) {
		return spFormRichiesteRepository.saveAndFlush(daSalvare);
	}
	
	/**
	 * Salva allegato in una transazione nuova
	 * @param file
	 * @param logId
	 * @param spFormRichieste
	 * @return
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public SpFormAllegato salvaAllegato (SpFormAllegato allegato) {
		allegato = spFormAllegatoRepository.saveAndFlush(allegato);
		return allegato;
	}
	
}
