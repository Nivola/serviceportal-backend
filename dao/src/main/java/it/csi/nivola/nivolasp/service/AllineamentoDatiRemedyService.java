/*-
 * ========================LICENSE_START=================================
 * Servizi di accesso dati
 * %%
 * Copyright (C) 2022 Regione Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | Regione Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.nivola.nivolasp.domain.SpFormRichieste;
import it.csi.nivola.nivolasp.integration.remedy.portal.dto.LavorazioneTicketDto;
import it.csi.nivola.nivolasp.integration.remedy.portal.service.RemedyService;
import it.csi.nivola.nivolasp.integration.remedy.portal.service.RemedyServiceException;
import it.csi.nivola.nivolasp.repository.SpFormRichiesteRepository;

@Service
public class AllineamentoDatiRemedyService {
	
	@Autowired
	SpFormRichiesteRepository spFormRichiesteRepository;
	
	@Autowired
	RemedyService remedyService;
	
	@Autowired
	MailService mailService;
	
	private final Logger log = LoggerFactory.getLogger(AllineamentoDatiRemedyService.class);
	
	/**
	 * Prende tutti i ticket che sono in stato diverso da 'Chiuso' o 'Annullato' e ne controlla il cambiamento di stato
	 */
	public void aggiornaStatoTicketInLavorazione () {
		Optional<List<SpFormRichieste>> risultato = spFormRichiesteRepository.elencoTicketInCorsoDiLavorazione();
		risultato.ifPresent(elenco -> elenco.stream().forEach(segnalazione -> verificaAggiornaStatoSegnalazione(segnalazione)));
	}

	private void verificaAggiornaStatoSegnalazione(SpFormRichieste segnalazione) {
		try {
			LavorazioneTicketDto nuovoStato = remedyService.recuperaStatoTicket(segnalazione.getTicketId());
			if (!segnalazione.getStato().equals(nuovoStato.getStato().getValue())) {
				log.info("LA SEGNALAZIONE " + segnalazione.getTicketId() + " HA SUBITO UN CAMBIO DI STATO DA " + segnalazione.getStato() + " A " + nuovoStato.getStato());
				String oldSato = segnalazione.getStato();
				segnalazione.setStato(nuovoStato.getStato().getValue());
				if (nuovoStato.getUpdateDate() != null)
					segnalazione.setUpdateDate(Timestamp.valueOf(nuovoStato.getUpdateDate()));
				if (nuovoStato.getCloseDate() != null)
				segnalazione.setCloseDate(Timestamp.valueOf(nuovoStato.getCloseDate()));
				spFormRichiesteRepository.saveAndFlush(segnalazione);
				mailService.sendEmail("no-reply-nivola.support@csi.it", segnalazione.getUtenteInvio().getEmail(), "La segnalazione " + segnalazione.getTicketId() + " e' ora in stato " + nuovoStato.getStato().name(), 
						"La segnalazione : " + segnalazione.getTicketId() + " e' stata modificata da un operatore dell'assistenza; lo stato e' passato da " +oldSato + " a " + nuovoStato.getStato().name()
						+"\n\nMotivo stato : " + nuovoStato.getMotivoStato(), false, false);
			}
		} catch (RemedyServiceException e) {
			log.error("IMPOSSIBILE VERIFICARE LO STATO DEL TICKET " + segnalazione.getTicketId(), e);
		}
	}

}
