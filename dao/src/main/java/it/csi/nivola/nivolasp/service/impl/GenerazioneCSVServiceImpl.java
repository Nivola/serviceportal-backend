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

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import it.csi.nivola.nivolasp.domain.SpAccountAttributo;
import it.csi.nivola.nivolasp.domain.SpAccountWb;
import it.csi.nivola.nivolasp.domain.SpCostoGiorno;
import it.csi.nivola.nivolasp.domain.SpCostoGiornoDettaglio;
import it.csi.nivola.nivolasp.domain.SpDMetriche;
import it.csi.nivola.nivolasp.domain.SpDTipoServizio;
import it.csi.nivola.nivolasp.integration.rest.api.service.AuthorityApi;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetAccountResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetDivisionResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetOrganizationResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListAccountsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListAccountsResponseSchemaAccounts;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListDivisionsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListDivisionsResponseSchemaDivisions;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListOrganizationsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListOrganizationsResponseSchemaOrganizations;
import it.csi.nivola.nivolasp.repository.MetricheRepository;
import it.csi.nivola.nivolasp.repository.SpAccountAttributoRepository;
import it.csi.nivola.nivolasp.repository.SpAccountWbsRepository;
import it.csi.nivola.nivolasp.repository.SpCostoGiornoRepository;
import it.csi.nivola.nivolasp.repository.SpDTipoServizioRepository;
import it.csi.nivola.nivolasp.service.GenerazioneCSVService;
import it.csi.nivola.nivolasp.service.dto.EstrazioneTotaliMetricaAccountDTO;
import it.csi.nivola.nivolasp.service.dto.ExportCSV;
import it.csi.nivola.nivolasp.service.dto.RaggruppamentoCostiServizioDTO;
import it.csi.nivola.nivolasp.service.dto.RaggruppamentoCostiWbsDTO;
import it.csi.nivola.nivolasp.service.dto.ReportServizioDTO;

@Service
@Transactional
public class GenerazioneCSVServiceImpl implements GenerazioneCSVService {
	
	private static final String SEP = ";";
	
	private static final String N_LINE = "\r\n";
	
	private DecimalFormat df = null;
	
	SimpleDateFormat formatoGiorno = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	SpCostoGiornoRepository spCostoGiornoRepository;

	@Autowired
	SpDTipoServizioRepository spDTipoServizioRepository;
	
	@Autowired
	AuthorityApi authorityApi;

	@Autowired
	MetricheRepository metricheRepository;
	
	@Autowired
	SpAccountAttributoRepository spAccountAttributoRepository;
	
	@Autowired
	SpCostoGiornoRepository costoGiornoRepository;
	
	@Autowired
	SpAccountWbsRepository spAccountWbsRepository;
	
	@Autowired ListinoService listinoService;
	
	private final Logger log = LoggerFactory.getLogger(GenerazioneCSVServiceImpl.class);
	
	@PostConstruct
	public void inizializza () {
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.ITALIAN);
		otherSymbols.setDecimalSeparator(',');
		df = new DecimalFormat("0.00", otherSymbols);
	}

	/**
	 * Report CSV costi giornalieri di un account per un periodo specificato: crea una riga per ogni giorno.
	 * @param uuidAccount identificativo account
	 * @param dataInizio data di inizio report
	 * @param dataFine data fine report
	 */
	@Override
	public StringBuilder creaCSVDettaglioGiornalieroAccount(String uuidAccount, LocalDate dataInizio, LocalDate dataFine) {
		StringBuilder fileCSV = new StringBuilder();
		GetAccountResponseSchema account = authorityApi.v10NwsAccountsOidGet(uuidAccount);
		GetDivisionResponseSchema divisione = authorityApi.v10NwsDivisionsOidGet(account.getAccount().getDivisionId());
		GetOrganizationResponseSchema organizzazione = authorityApi.v10NwsOrganizationsOidGet(divisione.getDivision().getOrganizationId());
		
		
		List<SpDMetriche> elencoMetriche = metricheRepository.findListinoECmpOrdinate();
		
		fileCSV.append(intestazione(elencoMetriche, true, true, true));
		
		List<SpCostoGiorno> elencoGiorniCosto = spCostoGiornoRepository.ricercaPerGiornoIntervalloAccount(Date.valueOf(dataInizio), Date.valueOf(dataFine), uuidAccount);
		
		elencoGiorniCosto.forEach(giorno -> fileCSV.append(elaboraRigaGiorno(giorno, organizzazione.getOrganization().getName(), divisione.getDivision().getName(), account.getAccount().getName(), elencoMetriche)));
		
		return fileCSV;
	}
	

	/**
	 * Report CSV costo giornaliero di una divisione per un giorno specificato.
	 * @param uuidDivisione identificativo divisione
	 * @param data giorno per cui generare il report
	 */
	@Override
	public ExportCSV creaCSVGiornalieroDivisioneDettaglio(String uuidDivisione, LocalDate data) {
		StringBuilder fileCSV = new StringBuilder();
		GetDivisionResponseSchema divisione = authorityApi.v10NwsDivisionsOidGet(uuidDivisione);
		GetOrganizationResponseSchema organizzazione = authorityApi.v10NwsOrganizationsOidGet(divisione.getDivision().getOrganizationId());
		
		List<SpDMetriche> elencoMetriche = metricheRepository.findListinoECmpOrdinate();
		
		fileCSV.append(intestazione(elencoMetriche, true, true , true));
		
		List<SpCostoGiorno> elencoGiorniCosto = spCostoGiornoRepository.ricercaPerGiornoIntervalloDivisione(Date.valueOf(data), Date.valueOf(data), uuidDivisione);
		
		elencoGiorniCosto.forEach(giorno -> fileCSV.append(elaboraRigaGiorno(giorno, organizzazione.getOrganization().getName(), divisione.getDivision().getName(), authorityApi.v10NwsAccountsOidGet(giorno.getRefAccount()).getAccount().getName(), elencoMetriche)));
		
		ExportCSV risposta = new ExportCSV();
		risposta.setFile(fileCSV);
		risposta.setFilename(divisione.getDivision().getName() + "_" +  data+".csv");
		return risposta;
	}
	
	/**
	 * Report CSV costo giornaliero di una organizzazione per un giorno specificato.
	 * @param uuidOrganizzazione identificativo organizzazione
	 * @param data giorno per cui generare il report
	 */
	@Override
	public ExportCSV creaCSVGiornalieroOrganizzazioneDettaglio(String uuidOrganizzazione, LocalDate data) {
		StringBuilder fileCSV = new StringBuilder();
		GetOrganizationResponseSchema organizzazione = authorityApi.v10NwsOrganizationsOidGet(uuidOrganizzazione);
		
		List<SpDMetriche> elencoMetriche = metricheRepository.findListinoECmpOrdinate();
		
		fileCSV.append(intestazione(elencoMetriche, true, true, true));
		
		List<SpCostoGiorno> elencoGiorniCosto = spCostoGiornoRepository.ricercaPerGiornoIntervalloOrganizzazione(Date.valueOf(data), Date.valueOf(data), uuidOrganizzazione);
		
		elencoGiorniCosto.forEach(giorno -> fileCSV.append(elaboraRigaGiorno(giorno, organizzazione.getOrganization().getName(), authorityApi.v10NwsDivisionsOidGet(giorno.getRefDivisione()).getDivision().getName(), authorityApi.v10NwsAccountsOidGet(giorno.getRefAccount()).getAccount().getName(), elencoMetriche)));
		
		ExportCSV risposta = new ExportCSV();
		risposta.setFile(fileCSV);
		risposta.setFilename(organizzazione.getOrganization().getName() + "_" +  data+".csv");
		return risposta;
	}
	
	/**
	 * Report per divisione con costi garruppati 1 giorno.
	 * @param uuidDivisione identificativo divisione
	 * @param data giorno per cui generare il report
	 */
	@Override
	public ExportCSV creaCSVGiornalieroDivisioneSintetico(String uuidDivisione, LocalDate data) {
		StringBuilder fileCSV = new StringBuilder();
		GetDivisionResponseSchema response = authorityApi.v10NwsDivisionsOidGet(uuidDivisione);
		
		List<SpDMetriche> elencoMetriche = metricheRepository.findListinoECmpOrdinate();
		
		fileCSV.append(intestazione(elencoMetriche, true, true, true));
		
		List<ReportServizioDTO> elencoGiorniCosto = spCostoGiornoRepository.costiRaggruppatiPerMetricaDivisione(uuidDivisione, Date.valueOf(data), Date.valueOf(data));
		
		fileCSV.append(elaboraRigaGiornoMetrica(elencoGiorniCosto, response.getDivision().getName(), elencoMetriche, data));
		ExportCSV risposta = new ExportCSV();
		risposta.setFile(fileCSV);
		risposta.setFilename(response.getDivision().getName() + "_" +  data+".csv");
//		return fileCSV;
		return risposta;
	}
	
	/**
	 * Report CSV costo giornaliero sintetico di una organizzazione per un giorno specificato.
	 * @param uuidOrganizzazione identificativo organizzazione
	 * @param data giorno per cui generare il report
	 */
	@Override
	public ExportCSV creaCSVGiornalieroOrganizzazioneSintetico(String uuid, LocalDate data) {
		StringBuilder fileCSV = new StringBuilder();
		GetOrganizationResponseSchema response = authorityApi.v10NwsOrganizationsOidGet(uuid);
		
		List<SpDMetriche> elencoMetriche = metricheRepository.findListinoECmpOrdinate();
		
		fileCSV.append(intestazione(elencoMetriche, true, true, true));
		
		List<ReportServizioDTO> elencoGiorniCosto = spCostoGiornoRepository.costiRaggruppatiPerMetricaOrganizzazione(uuid, Date.valueOf(data), Date.valueOf(data));
		
		fileCSV.append(elaboraRigaGiornoMetrica(elencoGiorniCosto, response.getOrganization().getName(), elencoMetriche, data));
		ExportCSV risposta = new ExportCSV();
		risposta.setFile(fileCSV);
		risposta.setFilename(response.getOrganization().getName() + "_" +  data+".csv");
//		return fileCSV;
		return risposta;
	}


	
	/**
	 * Riga di ciascun giorno
	 * @param giorno
	 * @param accountName
	 * @return
	 */
	private String elaboraRigaGiorno(SpCostoGiorno giorno,String orgName, String divName,  String accountName, List<SpDMetriche> elencoMetriche) {
		StringBuilder rigaGiorno = new StringBuilder();
		
		rigaGiorno.append(formatoGiorno.format(giorno.getData()));
		rigaGiorno.append(SEP);
		rigaGiorno.append(orgName);
		rigaGiorno.append(SEP);
		rigaGiorno.append(divName);
		rigaGiorno.append(SEP);
		rigaGiorno.append(accountName);
		rigaGiorno.append(SEP);
		
		elencoMetriche.forEach(m -> rigaGiorno.append(cellaMetriche(m, giorno)));
		
		rigaGiorno.append(N_LINE);
		
		return rigaGiorno.toString();
	}
	
	/**
	 * Riga di ciascun giorno
	 * @param giorno
	 * @param accountName
	 * @return
	 */
	private String elaboraRigaGiornoMetrica(List<ReportServizioDTO> costi, String nomeStruttura, List<SpDMetriche> elencoMetriche, LocalDate giorno) {
		StringBuilder rigaGiorno = new StringBuilder();
		
		rigaGiorno.append(giorno);
		rigaGiorno.append(SEP);
		rigaGiorno.append(nomeStruttura);
		rigaGiorno.append(SEP);
		
		elencoMetriche.forEach(m -> rigaGiorno.append(cellaMetricheTotali(m, costi)));
		
		return rigaGiorno.toString();
	}
	

	private String cellaMetriche(SpDMetriche m, SpCostoGiorno giorno) {
		StringBuilder costoOut = new StringBuilder("0");
		StringBuilder consumoOut = new StringBuilder("0");
		Optional<SpCostoGiornoDettaglio> dettaglio = giorno.getSpCostoGiornoDettaglios().stream().filter(e -> e.getSpDMetriche().getId().equals(m.getId())).findFirst();
		dettaglio.ifPresent(d -> {
				costoOut.delete(0, 1);
				costoOut.append(df.format(d.getCosto()));
				consumoOut.delete(0, 1);
				consumoOut.append(df.format(d.getQta()));
			}
		);
		costoOut.append(SEP).append(consumoOut);
		costoOut.append(SEP);
		return costoOut.toString();
	}
	
	private String cellaMetricheTotali(SpDMetriche m, List<ReportServizioDTO> costi) {
		StringBuilder costoOut = new StringBuilder("0");
		Optional<ReportServizioDTO> dettaglio = costi.stream().filter(e -> e.getMetrica().equals(m.getNome())).findFirst();
		dettaglio.ifPresent(d -> {
			costoOut.delete(0, 1);
			costoOut.append(df.format(d.getCosto()));
		}
				);
		
		costoOut.append(SEP);
		return costoOut.toString();
	}


	/**
	 * Prima riga del CSV
	 * @param elencoMetriche
	 * @return
	 */
	private String intestazione(List<SpDMetriche> elencoMetriche, boolean giornoIncluso, Boolean includiCosto, Boolean includiConsumo) {
		StringBuilder intestazione = new StringBuilder();
		if (giornoIncluso)
			intestazione.append("'GIORNO'").append(SEP);
		intestazione.append("'ORGANIZZAZIONE'").append(SEP);
		intestazione.append("'DIVISIONE'").append(SEP);
		intestazione.append("'ACCOUNT'").append(SEP);
		intestazione.append("'UUID'").append(SEP);;
		intestazione.append("'TOTALE'").append(SEP);
		intestazione.append("'TOTALE ORACLE'").append(SEP);
		
		elencoMetriche.forEach(m -> {
			if (includiCosto)
				intestazione.append("'Costo " + m.getDescrizione()+"'").append(SEP);
			if (includiConsumo)
				intestazione.append("'Consumo " + m.getDescrizione()+ "'").append(SEP);
		});
		
		intestazione.append(N_LINE);
		
		return intestazione.toString();
	}
	
	/**
	 * Creazione per la fase di rendicontazione da parte dell'amministrazione del CSV dei costi di tutti gli account sepratai per metrica con costi ORACLE all'inizio.
	 * @param dataInizio data di inizio report
	 * @param dataFine data fine report
	 */
	@Override
	public ExportCSV creaCSVTotaliAccount(LocalDate dataInizio, LocalDate dataFine, String tipo) {
		StringBuilder fileCSV = new StringBuilder();
		ListAccountsResponseSchema elencoAccount = authorityApi.v10NwsAccountsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		ListDivisionsResponseSchema tutteDivisioni = authorityApi.v10NwsDivisionsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		ListOrganizationsResponseSchema tutteOrganizzazioni = authorityApi.v10NwsOrganizationsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		
		
		// elenco metriche per intestazione
		List<SpDMetriche> elencoMetriche = metricheRepository.findListinoECmpReport();
		final boolean includiCosto = "consumo".equalsIgnoreCase(tipo) ? false : true;
		final boolean includiConsumo = "costo".equalsIgnoreCase(tipo) ? false : true;
		
		
		fileCSV.append(intestazione(elencoMetriche, false, includiCosto, includiConsumo));
		
		elencoAccount.getAccounts().forEach(account -> {
			try {
				ListDivisionsResponseSchemaDivisions cercaDivisione = tutteDivisioni.getDivisions().stream().filter(e -> e.getUuid().equalsIgnoreCase(account.getDivisionId())).findFirst().orElse(null);
				ListOrganizationsResponseSchemaOrganizations cercaOrganizzazione = tutteOrganizzazioni.getOrganizations().stream().filter(e -> e.getUuid().equalsIgnoreCase(cercaDivisione.getOrganizationId())).findFirst().orElse(null);
				
				
				fileCSV.append("'"+cercaOrganizzazione.getName()+"'");
				fileCSV.append(SEP);
				fileCSV.append("'"+cercaDivisione.getName()+"'");
				fileCSV.append(SEP);
				fileCSV.append("'"+account.getName()+"'");
				fileCSV.append(SEP);
				fileCSV.append("'"+account.getUuid()+"'");
				fileCSV.append(SEP);
				
				BigDecimal totAccount = spCostoGiornoRepository.totaleAccountData(account.getUuid(), Date.valueOf(dataInizio), Date.valueOf(dataFine));
				if (totAccount == null)
					fileCSV.append("0,00");
				else
					fileCSV.append(df.format(totAccount));
				
				fileCSV.append(SEP);
				
				BigDecimal totaleOracle = spCostoGiornoRepository.totaleOracleAccountData(account.getUuid(), Date.valueOf(dataInizio), Date.valueOf(dataFine));
				if (totaleOracle == null)
					fileCSV.append("0,00");
				else
					fileCSV.append(df.format(totaleOracle));
				
				fileCSV.append(SEP);
				

				List<EstrazioneTotaliMetricaAccountDTO> elencoTotaliMetrica = spCostoGiornoRepository.estrazioneCSVCompleto(account.getUuid(), Date.valueOf(dataInizio), Date.valueOf(dataFine));
				
				elencoMetriche.forEach(metrica -> {
					Optional<EstrazioneTotaliMetricaAccountDTO> opt = elencoTotaliMetrica.stream().filter(tot -> tot.getMetrica().equals(metrica.getNome())).findFirst();
					if (opt.isPresent()) {
						EstrazioneTotaliMetricaAccountDTO totale = opt.get();
						if (includiCosto)
							fileCSV.append(df.format(totale.getTotaleCosto())).append(SEP);
						if (includiConsumo)
							fileCSV.append(df.format(totale.getTotaleConsumo())).append(SEP);
						
					} else {
						if (includiCosto)
							fileCSV.append("0,00").append(SEP);
						if (includiConsumo)
							fileCSV.append("0,00").append(SEP);
					}
				});
				fileCSV.append(N_LINE);
			}
			catch (Exception e1) {
				e1.printStackTrace();
				log.error("ERRORE NELLA GENERAZIONE CSV DURANTE ACCOUNT: "+ account.getUuid(), e1);
				fileCSV.append(N_LINE);
			}
		});
		
		ExportCSV risposta = new ExportCSV();
		risposta.setFile(fileCSV);
		risposta.setFilename("Totali_acc_" + dataInizio + "_" + dataFine + ".csv");
		return risposta;
		
	}
	/**
	 * Creazione per la fase di rendicontazione da parte dell'amministrazione del CSV dei costi di tutti gli account e la somma dei costi raggruppati per WBS
	 * @param dataInizio data di inizio report
	 * @param dataFine data fine report
	 */
	@Override
	public ExportCSV creaCSVTotaliAccountWbs(LocalDate dataInizio, LocalDate dataFine, String colonne) {
		StringBuilder fileCSV = new StringBuilder();
		ListAccountsResponseSchema elencoAccount = authorityApi.v10NwsAccountsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		ListDivisionsResponseSchema tutteDivisioni = authorityApi.v10NwsDivisionsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		ListOrganizationsResponseSchema tutteOrganizzazioni = authorityApi.v10NwsOrganizationsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		
		fileCSV.append("UUID").append(SEP);
		fileCSV.append("ORGANIZZAZIONE").append(SEP);
		fileCSV.append("DIVISIONE").append(SEP);
		fileCSV.append("ACCOUNT").append(SEP);
		fileCSV.append("LISTINO APPLICATO").append(SEP);
		fileCSV.append("CODICE WBS").append(SEP);
		fileCSV.append("PERCENTUALE WBS").append(SEP);
		fileCSV.append("IMPORTO TOTALE WBS").append(SEP);
		fileCSV.append("COMMITTENTE").append(SEP);
		fileCSV.append(N_LINE);
		
		elencoAccount.getAccounts().forEach(account -> {
			try {
				ListDivisionsResponseSchemaDivisions cercaDivisione = tutteDivisioni.getDivisions().stream().filter(e -> e.getUuid().equalsIgnoreCase(account.getDivisionId())).findFirst().orElse(null);
				ListOrganizationsResponseSchemaOrganizations cercaOrganizzazione = tutteOrganizzazioni.getOrganizations().stream().filter(e -> e.getUuid().equalsIgnoreCase(cercaDivisione.getOrganizationId())).findFirst().orElse(null);
				
				List<RaggruppamentoCostiWbsDTO> elencoCostiWbs = spCostoGiornoRepository.totaleAccountDataPerWbs(account.getUuid(), Date.valueOf(dataInizio), Date.valueOf(dataFine));
				if (CollectionUtils.isEmpty(elencoCostiWbs)) {
					fileCSV.append("'"+account.getUuid()+"'");
					fileCSV.append(SEP);
					fileCSV.append("'"+cercaOrganizzazione.getName()+"'");
					fileCSV.append(SEP);
					fileCSV.append("'"+cercaDivisione.getName()+"'");
					fileCSV.append(SEP);
					fileCSV.append("'"+account.getName()+"'");
					fileCSV.append(SEP);
					fileCSV.append("").append(SEP).append("").append(SEP).append("").append(SEP).append("0,00").append(SEP).append("").append(SEP);
					fileCSV.append(N_LINE);
				}else {
					elencoCostiWbs.forEach(w -> fileCSV.append(creaRigheWbsAccount(w, account, cercaOrganizzazione, cercaDivisione)));
					
				}
			}
			catch (Exception e1) {
				e1.printStackTrace();
				log.error("ERRORE NELLA GENERAZIONE CSV DURANTE ACCOUNT: "+ account.getUuid(), e1);
				fileCSV.append(N_LINE);
			}
		});
		
		ExportCSV risposta = new ExportCSV();
		risposta.setFile(fileCSV);
		risposta.setFilename("Totali_acc_" + dataInizio + "_" + dataFine + ".csv");
		return risposta;
		
	}
	
	private StringBuilder creaRigheWbsAccount(RaggruppamentoCostiWbsDTO w, ListAccountsResponseSchemaAccounts account, ListOrganizationsResponseSchemaOrganizations cercaOrganizzazione, ListDivisionsResponseSchemaDivisions cercaDivisione) {
		StringBuilder fileCSV = new StringBuilder();
		
		fileCSV.append("'"+account.getUuid()+"'");
		fileCSV.append(SEP);
		fileCSV.append("'"+cercaOrganizzazione.getName()+"'");
		fileCSV.append(SEP);
		fileCSV.append("'"+cercaDivisione.getName()+"'");
		fileCSV.append(SEP);
		fileCSV.append("'"+account.getName()+"'");
		fileCSV.append(SEP);
		fileCSV.append("'"+listinoService.trovaListinoAccount(account.getUuid()).getNome()+"'");
		fileCSV.append(SEP);
		fileCSV.append("'"+w.getWbs()+"'").append(SEP);
		double percentuale = spAccountWbsRepository.findByRefAccount(account.getUuid()).orElse(new ArrayList<>()).stream().filter(wbs -> w.getWbs().equals(wbs.getSpDWb().getEwbs())).findFirst().orElse(new SpAccountWb()).getEwbsPerc();
		fileCSV.append(df.format(percentuale*100.0)).append(SEP)
		.append("'"+StringUtils.replace(w.getCommittente(), ",", " ")+"'").append(SEP).append(w.getCosto()).append(SEP);
		fileCSV.append(N_LINE);
		return fileCSV;
	}

	/**
	 * Report con il raggruppamento per servizio e i totali metriche per account
	 * @param uuidAccount
	 * @param dataPartenza
	 * @param dataFine
	 */
	@Override
	public StringBuilder reportSinteticoAccountPeriodo (String uuidAccount, LocalDate dataPartenza, LocalDate dataFine) {
		StringBuilder streamCSV = new StringBuilder();
//		GetAccountResponseSchema account = authorityApi.v10NwsAccountsOidGet(uuidAccount);
		
		streamCSV.append("'ACCOUNT'").append(SEP).append(StringUtils.quote("'Preprod'")).append(N_LINE);
		streamCSV.append("'PERIODO'").append(SEP).append(StringUtils.quote(dataPartenza.toString())).append(SEP).append(StringUtils.quote(dataFine.toString())).append(N_LINE);
		
		List<RaggruppamentoCostiServizioDTO> elencoCostiPerServizio = spCostoGiornoRepository.raggruppaCostiServizioAccount(uuidAccount, java.sql.Date.valueOf(dataPartenza), java.sql.Date.valueOf(dataFine));
		double totale = elencoCostiPerServizio.stream().mapToDouble(e -> e.getCosto()).sum();
		
		streamCSV.append("'Importo totale'").append(SEP).append(df.format(totale)).append(N_LINE);
		
		
		List<EstrazioneTotaliMetricaAccountDTO> tuttiCostiAccountPeriodo = spCostoGiornoRepository.estrazioneCSVCompleto(uuidAccount, java.sql.Date.valueOf(dataPartenza.withDayOfMonth(1)), java.sql.Date.valueOf(dataFine));
		
	
		for (RaggruppamentoCostiServizioDTO servizio : elencoCostiPerServizio) {
			
			if (servizio.getCosto() == 0) continue;
			
			streamCSV.append(N_LINE);
			
			streamCSV.append(servizio.getServizio()).append(SEP).append(SEP).append(df.format(servizio.getCosto())).append(" 'Euro'").append(N_LINE);
			
			SpDTipoServizio decodificaServizio = servizio.getServizio();
			List<EstrazioneTotaliMetricaAccountDTO> costiFiltratiServizio = tuttiCostiAccountPeriodo.stream().filter(e -> e.getServizio().equals(decodificaServizio.getNome())).collect(Collectors.toList());

			for (EstrazioneTotaliMetricaAccountDTO elem : costiFiltratiServizio) {
				if (elem.getTotaleCosto() > 0) {
					streamCSV.append(SEP).append(StringUtils.quote(elem.getMetricaDescrizione())).append(SEP).append(df.format(elem.getTotaleCosto())).append(N_LINE);
				}
			}
		}
		
		return streamCSV;
	}

	/**
	 * Estrazione della definizione del listino associato per ciascu account censito
	 */
	@Override
	public StringBuilder reportTipoListinoAccount () {
		StringBuilder sb = new StringBuilder("'Account'; 'Divisione'; 'Organizzazione'; 'Tipo Listino'; 'Data inizio costi';\r\n");
		ListAccountsResponseSchema elencoAccoutTotale = authorityApi.v10NwsAccountsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		ListDivisionsResponseSchema tutteDivisioni = authorityApi.v10NwsDivisionsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		ListOrganizationsResponseSchema tutteOrganizzazioni = authorityApi.v10NwsOrganizationsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		
		for (ListAccountsResponseSchemaAccounts account : elencoAccoutTotale.getAccounts()) {
			sb.append(account.getName()).append(SEP);
			ListDivisionsResponseSchemaDivisions div = tutteDivisioni.getDivisions().stream().filter(d -> d.getUuid().equals(account.getDivisionId())).findFirst().orElse(null);
			sb.append(div.getName()).append(SEP);
			sb.append(tutteOrganizzazioni.getOrganizations().stream().filter(o -> o.getUuid().equals(div.getOrganizationId())).findFirst().orElse(null).getName());
			sb.append(SEP);
			SpAccountAttributo attr = spAccountAttributoRepository.findByRefAccount(account.getUuid());
			if (attr != null) {
				sb.append(attr.getSpDTipoPrezzo().getCodice()).append(SEP);
				sb.append("'").append(attr.getDataInizioConsumi()).append("'").append(SEP);
			}
			else 
				sb.append("'*** Nessuno configurato ***'").append(SEP).append("'Nessuna data'").append(SEP);
			
			sb.append(N_LINE);
		}
		return sb;
	}

	/**
	 * Versione CSV del report PDF 'Costi mensensile sintetico'
	 * @param annoMese
	 * @param uuidAccount
	 */
	@Override
	public ExportCSV creaReportMensileSinteticoFormatoCSV(YearMonth annoMese, String uuidAccount) {
		StringBuilder sb = new StringBuilder();
		//reperimento dati
		GetAccountResponseSchema account = authorityApi.v10NwsAccountsOidGet(uuidAccount);
		GetDivisionResponseSchema divisione = authorityApi.v10NwsDivisionsOidGet(account.getAccount().getDivisionId());
		GetOrganizationResponseSchema organizzazione = authorityApi.v10NwsOrganizationsOidGet(divisione.getDivision().getOrganizationId());
		
		//intestazione
		sb.append("Organizzazione").append(SEP).append(organizzazione.getOrganization().getName()).append(N_LINE);
		sb.append("Divisione").append(SEP).append(divisione.getDivision().getName()).append(N_LINE);
		sb.append("Account").append(SEP).append(account.getAccount().getName()).append(N_LINE);
		sb.append("Indirizzo").append(SEP).append("").append(N_LINE);
		sb.append("Referente").append(SEP).append(account.getAccount().getContact()).append(N_LINE);
		sb.append("Email").append(SEP).append(account.getAccount().getEmail()).append(N_LINE).append(N_LINE);
		
		sb.append("                    REPORT MESE DI " + annoMese.getMonth().getDisplayName(TextStyle.FULL, Locale.ITALY).toUpperCase() + " " + annoMese.getYear()).append(N_LINE);
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss");
		String formatDateTime = now.format(formatter);
		sb.append("Data di generazione Report").append(SEP).append(formatDateTime).append(N_LINE);
		sb.append("Periodo").append(SEP).append(annoMese.getMonth().getDisplayName(TextStyle.FULL, Locale.ITALY).toUpperCase() + " " + annoMese.getYear()).append(N_LINE);
		LocalDate dataInizio = annoMese.atDay(1); 
		LocalDate dataFine = annoMese.atEndOfMonth();
		List<RaggruppamentoCostiServizioDTO> elencoCostiPerServizio = spCostoGiornoRepository.raggruppaCostiServizioAccount(account.getAccount().getUuid(), java.sql.Date.valueOf(dataInizio), java.sql.Date.valueOf(dataFine));
		double amount = elencoCostiPerServizio.stream().mapToDouble(e -> e.getCosto()).sum();
		sb.append("Importo totale").append(SEP).append(df.format(amount)).append(SEP).append("Euro").append(N_LINE).append(N_LINE);
		
		sb.append("         Sintesi consumi periodo " + annoMese.getMonth().getDisplayName(TextStyle.FULL, Locale.ITALY).toUpperCase() + " " + annoMese.getYear() + "  dettaglio servizi attivi").append(N_LINE).append(N_LINE);
		
		List<SpDTipoServizio> elencoTipiServizio = spDTipoServizioRepository.findAll();
		
		List<EstrazioneTotaliMetricaAccountDTO> tuttiCostiAccountPeriodo = costoGiornoRepository.estrazioneCSVCompleto(account.getAccount().getUuid(), java.sql.Date.valueOf(dataInizio.withDayOfMonth(1)), java.sql.Date.valueOf(dataFine));
		
	
		for (RaggruppamentoCostiServizioDTO servizio : elencoCostiPerServizio) {
			
			//qua detro una tabella per servizio se importo maggiore di zero
			if (servizio.getCosto() == 0) continue;
			
			//riga vuota
			sb.append(N_LINE);
			
			sb.append(servizio.getServizio().getDescrizione()).append(SEP).append("TOTALE").append(SEP).append(df.format(servizio.getCosto())).append(SEP).append("Euro").append(N_LINE);
			
			//rindondanza per non riscrivere le query condivise su piu' componenti e recuperare anche il nome,oltre la descrizione
			SpDTipoServizio decodificaServizio = elencoTipiServizio.stream().filter(s -> s.getNome().equals(servizio.getServizio().getNome())).findFirst().get();
			List<EstrazioneTotaliMetricaAccountDTO> costiFiltratiServizio = tuttiCostiAccountPeriodo.stream().filter(e -> e.getServizio().equals(decodificaServizio.getNome())).collect(Collectors.toList());
			
			// dettagli per metrica
			for (EstrazioneTotaliMetricaAccountDTO elem : costiFiltratiServizio) {
				if (elem.getTotaleCosto() > 0 ) {
					sb.append("                                    ").append(SEP).append(elem.getMetricaDescrizione()).append(SEP);
					sb.append(df.format(elem.getTotaleCosto())).append(SEP).append(" Euro").append(N_LINE);
				}
			}
		}
		
		ExportCSV risposta = new ExportCSV();
		risposta.setFile(sb);
		risposta.setFilename(account.getAccount().getName()+"_MENSILE_"+annoMese.getMonthValue()+"_"+annoMese.getYear()+".csv");
		return risposta;
	}
}
