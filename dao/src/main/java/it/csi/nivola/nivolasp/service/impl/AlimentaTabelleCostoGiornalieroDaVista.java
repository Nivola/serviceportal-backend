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
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.stereotype.Service;

import it.csi.nivola.nivolasp.config.ApplicationProperties;
import it.csi.nivola.nivolasp.domain.SpAccountAttributo;
import it.csi.nivola.nivolasp.domain.SpAccountInfocosto;
import it.csi.nivola.nivolasp.domain.SpCostoGiorno;
import it.csi.nivola.nivolasp.domain.SpCostoGiornoDettaglio;
import it.csi.nivola.nivolasp.domain.SpDMetriche;
import it.csi.nivola.nivolasp.domain.SpDTipoServizio;
import it.csi.nivola.nivolasp.domain.cmp.VAggregateConsumes;
import it.csi.nivola.nivolasp.domain.cmp.VAggregateConsumesRepository;
import it.csi.nivola.nivolasp.integration.rest.api.service.AuthorityApi;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListAccountsResponseSchemaAccounts;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListDivisionsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListDivisionsResponseSchemaDivisions;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListOrganizationsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListOrganizationsResponseSchemaOrganizations;
import it.csi.nivola.nivolasp.repository.MetricheRepository;
import it.csi.nivola.nivolasp.repository.SpAccountAttributoRepository;
import it.csi.nivola.nivolasp.repository.SpAccountInfocostoRepository;
import it.csi.nivola.nivolasp.repository.SpCostoGiornoRepository;
import it.csi.nivola.nivolasp.repository.SpDListinoRepository;
import it.csi.nivola.nivolasp.repository.SpDTipoListinoRepository;
import it.csi.nivola.nivolasp.repository.SpDTipoPrezzoRepository;
import it.csi.nivola.nivolasp.repository.SpDTipoServizioRepository;
import it.csi.nivola.nivolasp.service.MailService;
import it.csi.nivola.nivolasp.util.StreamingObjectUtil;

@Service
public class AlimentaTabelleCostoGiornalieroDaVista {

	public static final String PROCEDURA_CALCOLA_COSTI_GIORNO = "calcola_costi_giorno";
	private static final String PROCEDURA_CALCOLA_COSTI_GIORNO_DA = "calcola_costi_giorno_da";

	// API CMP per elenco accounts e decodifica divisione ed organizzazione
	@Autowired
	AuthorityApi authorityApi;
	
	//Repository per la gestione del costo giorno
	@Autowired
	SpCostoGiornoRepository spCostoGiornoRepository;

	//decodifica delle metriche
	@Autowired
	MetricheRepository metricheRepository;
	
	@Autowired(required = false)
	VAggregateConsumesRepository vAggregateConsumesRepository;
	
	@Autowired
	SpDTipoServizioRepository spDTipoServizioRepository;
	
	@Autowired
	SpAccountAttributoRepository spAccountAttributoRepository;
	
	@Autowired
	SpAccountInfocostoRepository spInfocostoRepository;
	
	@Autowired
	SpDTipoPrezzoRepository spDTipoPrezzoRepository;
	
	@Autowired
	SpDListinoRepository spDListinoRepository;
	
	@Autowired
	SpDTipoListinoRepository spDTipoListinoRepository;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	ApplicationProperties proprieta;
	
	//Accesso diretto all'EntityManager per chiamata stored procedure
	@PersistenceContext
	private EntityManager entityManager;
	
	private static final String EMAIL_ACCOUNT_DA_CONFIGURARE_OGGETTO = "Trovato account %s privo di configurazione utile al calcolo dei costi";
	
	private static final String EMAIL_ACCOUNT_DA_CONFIGURARE = "La seguente per informare che durante la procedura di calcolo costi e' stato trovato l'account %s con uuid %s appartenente alla divisione %s" +
				" per il quale non e' stata trovata la corretta configurazione utile al calcolo dei costi (listino applicato, tipo prezzo, tenant)\r\n" +
				"Sono stati utilizzati valori di default per cui e' consigliabile verificare che questi siano corretti.\r\n\r\n" +
				"Questo potrebbe essere stato causato dalla creazione dell'account tramite CLI, per cui il portale non e' in possesso dei dati utili alla rendicontazione.\r\n\r\n" +
				"Questa email è stata inviata automaticamente dalla componente batch del Service Portal: per ulteriori informazioni fare riferimento al gruppo di sviluppo del service porotal.";
	
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	ListDivisionsResponseSchema tutteDivisioni;
	ListOrganizationsResponseSchema tutteOrganizzazioni;
	//Elenco delle metriche di tipo CMP per inserimento dettagli
	private List<SpDMetriche> elencoMetriche;
	
	/**
	 * Caricamento "cache" elenco metriche all'inizio.
	 */
	@PostConstruct
	public void carichaDecodificaMetriche () {

		tutteDivisioni = authorityApi.v10NwsDivisionsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		tutteOrganizzazioni = authorityApi.v10NwsOrganizationsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
	}

	@Transactional
	public void estrazioneCostiAccountDettaglio(ListAccountsResponseSchemaAccounts e2) throws ParseException {
		long inizio = System.currentTimeMillis();
		log.info("INIZIO ELABORAZIONE ACCOUNT " + e2.getUuid());
		
		//JIRA NSP-1767	Censire account sconosciuti al service portal
		boolean inviaEmail = false;
		
		SpAccountAttributo attributo = spAccountAttributoRepository.findByRefAccount(e2.getUuid());
		if (attributo == null)  {
			inviaEmail = true;
			log.warn("ATTENZIONE: PER ACCOUNT " + e2.getUuid() + " " + e2.getName() + " CONFIGURAZIONE MANCANTE");
			attributo = new SpAccountAttributo();
			attributo.setAcronimo(e2.getAcronym());
			attributo.setAggiornaCostiGiorno(true);
			attributo.setBudgetMax(0);
			attributo.setBudgetMin(0);
			attributo.setDataCreazione(new Timestamp(System.currentTimeMillis()));
			attributo.setDataInizioConsumi(new Date(System.currentTimeMillis()));
			attributo.setDataModifica(new Timestamp(System.currentTimeMillis()));
			attributo.setDivision(e2.getDivisionName());
			attributo.setIdAgente(BigInteger.valueOf(0));
			attributo.setManaged("true");
			attributo.setNome(e2.getName());
			attributo.setRefAccount(e2.getUuid());
			attributo.setSpDTipoPrezzo(spDTipoPrezzoRepository.findOne("PROD"));
			
			spAccountAttributoRepository.saveAndFlush(attributo);
		}
		
		SpAccountInfocosto infocosto = spInfocostoRepository.findInfocostoCorrente(e2.getUuid());
		
		if (infocosto == null) {
			inviaEmail = true;
			log.warn("ATTENZIONE: PER ACCOUNT " + e2.getUuid() + " " + e2.getName() + " INFOCOSTO MANCANTE");
			infocosto = new SpAccountInfocosto();
			infocosto.setDataCreazione(new Timestamp(System.currentTimeMillis()));
			infocosto.setDataInizioAssociazione(new Date(System.currentTimeMillis()));
			infocosto.setIdAgente(BigInteger.valueOf(0));
			infocosto.setRefAccount(e2.getUuid());
			infocosto.setSpDListino(spDListinoRepository.listinoAttuale());
			infocosto.setSpDTipoListino(spDTipoListinoRepository.findOne("CSI"));
			infocosto.setSpDTipoPrezzo(spDTipoPrezzoRepository.findOne("PROD"));
			infocosto.setUsaListinoSpecifico("N");
			
		}
		
		if (inviaEmail)
			mailService.sendEmail(
				"no-reply-nivola.support@csi.it",
				proprieta.getDeploy().getIndirizzoServizio(), 
				String.format(EMAIL_ACCOUNT_DA_CONFIGURARE_OGGETTO, e2.getName()), 
				String.format(EMAIL_ACCOUNT_DA_CONFIGURARE, e2.getName(), e2.getUuid(), e2.getDivisionName()), false, false);
				
		
		/*
		 * si estraggono solo i costi non ancora inseriti, si ricerca l'ultimo costo giornaliero per questo account.
		 * Se non trovato (prima esecuzione o nuovo account) si prende il riferimento del primo Novembre 2019
		 */
		LocalDate ultimaEstrazioneLocalDate = spCostoGiornoRepository.findMaxDataPerAccount(e2.getUuid());
		boolean ultimaEstrazioneNull = false;
		if (ultimaEstrazioneLocalDate == null) {
			ultimaEstrazioneLocalDate = LocalDate.of(2019, 11, 01);
			ultimaEstrazioneNull = true;
		} else if (ultimaEstrazioneLocalDate.isEqual(LocalDate.now().minusDays(1))) {
			log.info("ACCOUNT "  + e2.getUuid() + " NON HA NUOVI CONSUMI, RILEVATI IL: " + ultimaEstrazioneLocalDate);
			return;
		}
		LocalDate partenzaProcedure = ultimaEstrazioneNull ? LocalDate.of(2019, 11, 01)  : ultimaEstrazioneLocalDate.plusDays(1);
		
		//vista CMP
		List<VAggregateConsumes> elencoConsumi = vAggregateConsumesRepository.findByAccountUuidAndPeriodAfterOrderByPeriodDesc(e2.getUuid(), Date.valueOf(ultimaEstrazioneLocalDate));
		
		if (elencoConsumi == null || elencoConsumi.size() == 0) {
			log.info("NON SONO STATI TROVATI CONSUMI PER L'ACCOUNT "  + e2.getUuid());
			return;
		}
			
		
		boolean prima = true;
		SpCostoGiorno testata = null;
		
		elencoMetriche = metricheRepository.findCmp();

		for (VAggregateConsumes consumo : elencoConsumi) {
			List<SpCostoGiornoDettaglio> elencoDettagli = null;
			if (prima || !consumo.getPeriod().equals(testata.getData())) {
				prima = false;
				if (testata != null)
					spCostoGiornoRepository.saveAndFlush(testata);
				// si sceglie di avere un solo record di testata per giorno - account, siccome la CMP li duplica per servizio controllo di non avere già la testata
				testata = spCostoGiornoRepository.findByRefAccountAndData(e2.getUuid(), consumo.getPeriod());
			}
			
			// se non c'è lo creo nuovo
			if (testata == null) {
				testata = new SpCostoGiorno();
				testata.setData(consumo.getPeriod());
				Timestamp dataCreazione = new Timestamp(System.currentTimeMillis());
				testata.setDataCreazione(dataCreazione);
				testata.setDataModifica(dataCreazione);
				testata.setRefAccount(e2.getUuid());
				elencoDettagli = new ArrayList<>();
			}
			else
			{
				elencoDettagli = testata.getSpCostoGiornoDettaglios();
			}
			
			testata.setRefDivisione(consumo.getDivisionUuid());
			testata.setRefOrganizzazione(consumo.getOrganizationUuid());
			// ciclo dettagli
			boolean metricaNuova = mappaMetricaInCostoDettaglio(elencoDettagli, testata, consumo);
			
			testata.setSpCostoGiornoDettaglios(elencoDettagli);
			
			//refresh elenco metriche
			if (metricaNuova) {
				elencoMetriche = metricheRepository.findCmp();
			}
		}
		try {
			if (testata != null)
			spCostoGiornoRepository.saveAndFlush(testata);
		} catch (Exception e) {
			log.error("ERRORE IN SALVATAGGIO: ", e);
			log.error(StreamingObjectUtil.streamObjectToJSON(testata));
		}
		
		
		//gestione dei costi di listino
		if (elencoConsumi.size() > 0)
			invocaProcedureCalcoloCostoListino(e2, partenzaProcedure.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		else
			log.info("NESSUN NUOVO CONSUMO IN ARRIVO");

		log.info("FINE ELABORAZIONE ACCOUNT " + e2.getUuid() + " DURATA: " + (System.currentTimeMillis() - inizio));
	}



	/**
	 * Mappa la singola metrica ricevuta dalla cmp in una riga di dettaglio del giorno
	 * @param metrica
	 * @param elencoDettagli
	 * @param testata
	 * @param consumo
	 */
	private boolean mappaMetricaInCostoDettaglio(List<SpCostoGiornoDettaglio> elencoDettagli, SpCostoGiorno testata, VAggregateConsumes consumo) {
		boolean inseritaMetrica = false;
		SpCostoGiornoDettaglio dettaglio = null;
		//predispongo il singolo dettaglio
		Optional<SpCostoGiornoDettaglio> cercaDett = elencoDettagli.stream().filter(d -> d.getSpDMetriche().getNome().equals(consumo.getMetric())).findFirst();
		if (cercaDett.isPresent()) {
			dettaglio = cercaDett.get();
			double newq = dettaglio.getQta() + consumo.getConsumed();
			dettaglio.setQta(newq);
		} else {
			dettaglio = new SpCostoGiornoDettaglio();
			dettaglio.setCosto(consumo.getConsumed());
			Timestamp dataCreazione = new Timestamp(System.currentTimeMillis());
			dettaglio.setDataCreazione(dataCreazione);
			dettaglio.setDataModifica(dataCreazione);
			dettaglio.setOrigine("CMP");
			dettaglio.setQta(consumo.getConsumed());
			dettaglio.setSpCostoGiorno(testata);
		}
		
		// le metriche dovrebbero essere tutte censite, nel caso mi arrivi una metrica sconosciuta la inserisco
		SpDMetriche metricaTrovata = elencoMetriche.stream().filter(m -> m.getNome().equals(consumo.getMetric())).findFirst().orElse(null);
		
		
		if (metricaTrovata == null) {
			log.debug("*******METRICA NON TROVATA = "+ consumo.getMetric() + "*******");
			metricaTrovata = new SpDMetriche();
			metricaTrovata.setDescrizione(consumo.getContainerType() + " - " + consumo.getMetric());
			metricaTrovata.setNome(consumo.getMetric());
			metricaTrovata.setNote(consumo.getContainerType() + " - " + consumo.getMetric() + " Inserita automaticamente in quanto non trovata");
			metricaTrovata.setTipo("CMP");
			metricaTrovata.setUdm(consumo.getMeasureUnit());
			SpDTipoServizio tipoServizio = spDTipoServizioRepository.findByNome(consumo.getContainerType());
			if (tipoServizio == null) {
				tipoServizio = new SpDTipoServizio();
				tipoServizio.setColore("#000000");
				tipoServizio.setDescrizione(consumo.getContainerInstanceType()+" - Inserito da batch");
				tipoServizio.setEtichetta(StringUtils.abbreviate(consumo.getContainerType(), 16));
				tipoServizio.setNome(consumo.getContainerType());
				tipoServizio = spDTipoServizioRepository.saveAndFlush(tipoServizio);
			}
			metricaTrovata.setSpDTipoServizio(tipoServizio);
			inseritaMetrica = true;
			metricaTrovata = metricheRepository.save(metricaTrovata);
			
		}
		dettaglio.setSpDMetriche(metricaTrovata);
		
		elencoDettagli.add(dettaglio);
		return inseritaMetrica;
	}

	/**
	 * Effettua la chiamata alla stored procedure che popola i costi giornalieri di listino.
	 * @param e2
	 * @param giorno
	 * @return
	 */
	
	private void invocaProcedureCalcoloCostoListino(ListAccountsResponseSchemaAccounts e2, String giorno) {
		log.warn("INVOCAZIONE STORED PROCEDURE PER ACCOUNT " + e2.getUuid() + " E GIORNO " + giorno);
		ListDivisionsResponseSchemaDivisions cercaDivisione = tutteDivisioni.getDivisions().stream().filter(e -> e.getUuid().equalsIgnoreCase(e2.getDivisionId())).findFirst().orElse(null);
		ListOrganizationsResponseSchemaOrganizations cercaOrganizzazione = tutteOrganizzazioni.getOrganizations().stream().filter(e -> e.getUuid().equalsIgnoreCase(cercaDivisione.getOrganizationId())).findFirst().orElse(null);
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery(PROCEDURA_CALCOLA_COSTI_GIORNO_DA);
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.setParameter(1, e2.getUuid());
		query.setParameter(2, giorno);
		query.setParameter(3, cercaDivisione.getUuid());
		query.setParameter(4, cercaOrganizzazione.getUuid());
		query.executeUpdate();
		if (query.getUpdateCount() <= 0)
			log.error("ATTENZIONE!!! ERRORE in calcolo costi per account: " + e2.getName() + " - UUID: " + e2.getUuid() + " - DATA PARTENZA: " + giorno);
		entityManager.close();
	}
}
