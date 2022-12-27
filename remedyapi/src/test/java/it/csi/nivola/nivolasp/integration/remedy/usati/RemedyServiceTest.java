/*-
 * ========================LICENSE_START=================================
 * Api Remedy
 * %%
 * Copyright (C) 2022 Regione Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | Regione Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.integration.remedy.usati;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import it.csi.nivola.nivolasp.integration.remedy.portal.service.RemedyService;
import it.csi.nivola.nivolasp.integration.remedy.portal.service.RemedyServiceException;
import it.csi.nivola.nivolasp.integration.remedy.service.AbstractTest;

public class RemedyServiceTest  extends AbstractTest{

	@Autowired
	public RemedyService remedyService;
	
	@Test
	public void recuperaEnteTrovato () throws RemedyServiceException {
		log.debug(""+remedyService.recuperaEnte("CPY000000014451"));
	}
	
	@Test
	public void recuperaUtenteEmailUnica () throws RemedyServiceException {
		log.debug(""+remedyService.recuperaUtentePerEmail("eliana.test@gmail.com"));
	}
	
	@Test
	public void recuperaUtenteEmailDoppiaErrore () {
		try {
			remedyService.recuperaUtentePerEmail("pippo@libero.it");
			assert false;
		}
		catch (RemedyServiceException e) {
			assert true;
		}

	}
	
	@Test
	public void testElencoCategorieOperativeEnteEsistente () throws RemedyServiceException {
		log.debug(""+remedyService.elencoCategorieOperative("CPY000000014451"));
	}
	
	
	@Test
	public void testStatoTicketEsistente () throws RemedyServiceException {
		log.debug(""+remedyService.recuperaStatoTicket("INC000003284167"));
	}
	
	@Test
	public void testElencoLavorazioniTicket () throws RemedyServiceException {
		log.debug(""+remedyService.elencoLavorazioniTicket("INC000003289559"));
	}
	
	@Test
	public void testDettaglioLavorazioneTicket () throws RemedyServiceException {
		log.debug(""+remedyService.dettaglioLavorazioneTicket("INC000003289559", "WLG000001392664"));
	}
	
	@Test
	public void testInserimentoLavorazioneTicket () throws RemedyServiceException {
		log.debug(""+remedyService.inserisciNotaLavorazioneTicket("INC000003289559", "ins api2", "General", "Inserimento API Servizio", null, null));
	}

	
	
	@Test
	public void testElencoTipologieCategoriaOperativa () {
		log.debug(""+remedyService.elencoTipologieCategoriaOperativa());
	}
}
