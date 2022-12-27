/*-
 * ========================LICENSE_START=================================
 * Nivola Batch
 * %%
 * Copyright (C) 2022 CSI Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | CSI Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.scheduled;

import java.io.FileNotFoundException;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lowagie.text.DocumentException;

import it.csi.nivola.nivolasp.config.ApplicationProperties;
import it.csi.nivola.nivolasp.integration.rest.api.service.AuthorityApi;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListAccountsResponseSchema;
import it.csi.nivola.nivolasp.service.AllineamentoDatiRemedyService;
import it.csi.nivola.nivolasp.service.impl.AlimentaTabelleCostoGiornalieroDaVista;
import it.csi.nivola.nivolasp.service.impl.GenerazioneReportCostiGiornaliero;
import it.csi.nivola.nivolasp.service.impl.GenerazioneReportCostiMensile;

/**
 * Punto di ingresso per tutte le operaizoni schedulate.
 */
@Component
@Scope(value = "singleton")
public class NivolaScheduledTasks {

	@Autowired
	private GenerazioneReportCostiMensile report;

	@Autowired
	private AlimentaTabelleCostoGiornalieroDaVista alimentaTabelleCostoGiornaliero;
	
	@Autowired
	GenerazioneReportCostiGiornaliero generazioneReportCostiGiornaliero;
	
	@Autowired
	CaricaCostiStorageAsAService caricaCostiStorageAsAService;
	
	@Autowired
	AllineamentoDatiRemedyService allineamentoDatiRemedyService;

	// API CMP per elenco accounts e decodifica divisione ed organizzazione
	@Autowired
	AuthorityApi authorityApi;
	
	@Autowired
	ApplicationProperties applicationProperties;
	
	private boolean schedulingEnabled = true;

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * Calcola i costi giornalieri e li inserisce nel DB.
	 * Successivamente esegue i report pdf mensile sintetico e dettagliato per account
	 * @throws DocumentException 
	 * @throws FileNotFoundException 
	 */
	@Scheduled(cron="${scheduling.reportCostoGiornaliero}")
	public void calcoloCosti() throws FileNotFoundException, DocumentException {
		if (!schedulingEnabled) {
			log.info("ELABORAZIONE IN CORSO, NON E' POSSIBILE L'ESECUZIONE, RIPROVARE PIU' TARDI");
			return;
		}
		schedulingEnabled = false;
		log.warn("********************** PARTENZA SCHEDULATORE CALCOLO COSTI *****************************");
		
		try {
			alimentazioneTabelle();
			
			//generazione report costi mensile con dettaglio giornaliero con i dati appena ricavati.
			reportCostoGiornaliero();
			
			//generazione report costi mensile sintetico
			reportCostoMensile();
			
		} finally {
			schedulingEnabled = true;
		}
	}


	private void alimentazioneTabelle() {
		long inizio = System.currentTimeMillis();
		log.info("INIZIO ALIMENTAZIONE TABELLE COSTI");
		
		//estrazione di tutti gli account censiti
		ListAccountsResponseSchema elencoAccount = authorityApi.v10NwsAccountsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

		
		//per ogni account esegue il calcolo dei costi
		elencoAccount.getAccounts().forEach(e -> {
			try {
				alimentaTabelleCostoGiornaliero.estrazioneCostiAccountDettaglio(e);
			}
			catch (Exception e1) {
				log.error("ERRORE DURANTE L'ALIMENTAZIONE DELLE TABELLE PER ACCOUNT: " + e.getName()+ " - " + e.getDesc() + ":"+e.getUuid(), e1);
			}
		});
		
		log.info("FINE ALIMENTAZIONE TABELLE COSTI, DURATA TOTALE: " + (System.currentTimeMillis() - inizio));
	}
	
	
	/**
	 * Genera il report dei costi mensili per account dettagliati per giorno / metrica
	 */
	public void reportCostoGiornaliero () {
		log.debug("INIZIO GENERAZIONE PDF REPORT COSTO GIORNALIERO");
		try {
			generazioneReportCostiGiornaliero.generaReportGiornalieroAccount();
		}
		catch (FileNotFoundException | DocumentException e) {
			log.error("ERRORE", e);
		}
		log.info("FINE GENERAZIONE PDF REPORT COSTO GIORNALIERO");
	}
	
	/**
	 * Genera il report sintetico dei costi mensili per account
	 */
	public void reportCostoMensile () {
		try {
			report.generaReportMensileAccount();
		}
		catch (FileNotFoundException | DocumentException e) {
			log.error("ERRORE", e);
		}
	}
	
	
	/**
	 * Batch che controlla i file csv per i consumi di Storage
	 */
	@Scheduled(cron="${scheduling.elaborazioneCSVSTAAS}")
	public void csvStaas () {
		log.info("********* PARTENZA LETTURA CSV STORAGE AS A SERVICE *********");
		caricaCostiStorageAsAService.caricaFilesDati();
		log.info("********* FINE LETTURA CSV STORAGE AS A SERVICE *************");
	}
	
	@Scheduled(cron="0 */15 8-21 * * *")
	public void aggiornamentoStatoRemedy () {
		log.info("********* PARTENZA VERIFICA CAMBIO STATO REMEDY *********");
		allineamentoDatiRemedyService.aggiornaStatoTicketInLavorazione();
		log.info("********* FINE VERIFICA CAMBIO STATO REMEDY *************");
	}
	

	public void disattivaSchedulatore() {
		 schedulingEnabled = false;
	}


	public void attivaSchedulatore() {
		this.schedulingEnabled = true;
	}
	
	public boolean isSchedulingEnabled() {
		return schedulingEnabled;
	}


	@PreDestroy
	public void onDestroy() {
		log.debug("FINE DELLA SCHEDULAZIONE");
	}

}
