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

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import it.csi.nivola.nivolasp.domain.SpCostoGiorno;
import it.csi.nivola.nivolasp.domain.SpCostoGiornoDettaglio;
import it.csi.nivola.nivolasp.domain.SpDListinoDettaglio;
import it.csi.nivola.nivolasp.domain.SpDMetriche;
import it.csi.nivola.nivolasp.domain.SpDSottoservizio;
import it.csi.nivola.nivolasp.domain.SpDTipoRendiconto;
import it.csi.nivola.nivolasp.domain.SpDTipoServizio;
import it.csi.nivola.nivolasp.domain.SpRendiconto;
import it.csi.nivola.nivolasp.integration.rest.api.service.AuthorityApi;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListAccountsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListAccountsResponseSchemaAccounts;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListDivisionsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListDivisionsResponseSchemaDivisions;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListOrganizationsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListOrganizationsResponseSchemaOrganizations;
import it.csi.nivola.nivolasp.repository.MetricheRepository;
import it.csi.nivola.nivolasp.repository.RendicontoRepository;
import it.csi.nivola.nivolasp.repository.SpCostoGiornoRepository;
import it.csi.nivola.nivolasp.repository.SpDTipoServizioRepository;
import it.csi.nivola.nivolasp.service.dto.RaggruppamentoCostiServizioDTO;

@Service
public class GenerazioneReportCostiGiornaliero extends ReportPdf{

	@Autowired
	SpCostoGiornoRepository costoGiornoRepository;
	
	@Autowired
	AuthorityApi authorityApi;
	
	@Autowired
	MetricheRepository metricheRepository;
	
	@Autowired
	RendicontoRepository rendicontoRepository;
	
	SimpleDateFormat formatoGiorno = new SimpleDateFormat("dd/MM/yyyy");
	

	@Autowired
	SpCostoGiornoRepository spCostoGiornoRepository;
	
	@Autowired
	SpDTipoServizioRepository spDTipoServizio;
	
	
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private SpDTipoRendiconto tipo;
	
	@PostConstruct
	public void inizializzaServizio() {
		List<SpDTipoRendiconto> elencor = rendicontoService.elencoTipi();
		tipo = elencor.stream()
		  .filter(e -> "GA".equals(e.getCodice()))
		  .findAny()
		  .orElse(null);
	}
	
	/**
	 * Generazione del report mensile con dettaglio per giorno e servizio per ciascun account
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 */
	public void generaReportGiornalieroAccount () throws FileNotFoundException, DocumentException {
		ListAccountsResponseSchema elencoAccoutTotale = authorityApi.v10NwsAccountsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		ListDivisionsResponseSchema tutteDivisioni = authorityApi.v10NwsDivisionsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		ListOrganizationsResponseSchema tutteOrganizzazioni = authorityApi.v10NwsOrganizationsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		Set<SpDTipoServizio> decodificaTipiServizio = spDTipoServizioRepository.findByOrderByOrdine();
		LocalDate dataOggi = LocalDate.now();
		
		List<String> elencoAccount = costoGiornoRepository.distinctAccount();
		
		//seleziona il tipo di rendiconto (GIORNALIERO ACCOUNT) xche servirà successivamente per il salvataggio
		
		
		for (String accountId : elencoAccount) {
			try {
				LocalDate ultima = rendicontoRepository.findDataUltimaGenerazione(accountId, tipo);
				if (ultima == null)
					ultima = LocalDate.of(2019, 11, 1);
				
				//se ho già generato il report al giorno precedente rispetto ad oggi non devo fare nulla
				if (dataOggi.isBefore(ultima.plusDays(1)) || dataOggi.equals(ultima.plusDays(1))) {
					log.info("NON CI SONO NUOVI COSTI PER  REPORT DETTAGLIO PER ACCOUNT " + accountId + " E DATA " + ultima);
					continue;
				}
				
				//decodifica l'account, siccome potrebbe non vewnir trovato sulla CMP prevedo l'errore e continuo con l'account successivo
				ListAccountsResponseSchemaAccounts accountCMP = elencoAccoutTotale.getAccounts().stream().filter(e -> e.getUuid().equals(accountId)).findFirst().orElse(null);
				
				if (accountCMP == null)
					continue;
				//ciclo del mese
				while (ultima.withDayOfMonth(1).isBefore(dataOggi) || ultima.withDayOfMonth(1).equals(dataOggi)) {
					
					if (ultima.getMonthValue() == dataOggi.getMonthValue() && ultima.getYear() == dataOggi.getYear())
						ultima = ultima.withDayOfMonth(dataOggi.getDayOfMonth()).minusDays(1);
					else
						ultima = ultima.withDayOfMonth(ultima.lengthOfMonth());
					
					List<SpCostoGiorno> elencoCostiDiQuestoAccountPerQuestoPeriodo = costoGiornoRepository.ricercaPerGiornoIntervalloAccount(java.sql.Date.valueOf(ultima.withDayOfMonth(1)), java.sql.Date.valueOf(ultima), accountId);
					
					
					//cerco il record dell'esecuzione precedente, se è già stato eseguito di oggi non devo fare nulla
					SpRendiconto rendiconto = new SpRendiconto();
					rendiconto.setAnno(ultima.getYear());
					rendiconto.setMese(ultima.getMonthValue());
					rendiconto.setIdAccount(accountCMP.getUuid());
					rendiconto.setTipoRendiconto(tipo);
					
					rendiconto = rendicontoService.trovaReportGiornalieroEsistente(rendiconto);
					if (rendiconto == null || rendiconto.getDataRendicontoA().toLocalDate().isBefore(ultima)) {
						ListDivisionsResponseSchemaDivisions divisioneCMP = tutteDivisioni.getDivisions().stream().filter(e -> e.getUuid().equalsIgnoreCase(accountCMP.getDivisionId())).findFirst().orElse(null);
						ListOrganizationsResponseSchemaOrganizations organizzazioneCMP = tutteOrganizzazioni.getOrganizations().stream().filter(e -> e.getUuid().equalsIgnoreCase(divisioneCMP.getOrganizationId())).findFirst().orElse(null);
						try {
							log.info("INIZIO GENERAZIONE REPORT DETTAGLIO PER ACCOUNT " + accountCMP.getName() + " E DATA " + ultima);
							generazionePdf(accountCMP, divisioneCMP, organizzazioneCMP, elencoCostiDiQuestoAccountPerQuestoPeriodo, ultima, rendiconto, decodificaTipiServizio);
							log.info("FINE GENERAZIONE REPORT DETTAGLIO PER ACCOUNT " + accountCMP.getName());
						} catch (Exception e ) {
							log.info("ERRORE:", e);
						}
					}
					ultima = ultima.plusMonths(1);
	
				}
			
			} catch (Exception e) {
				log.error("ERRORE DURANTE LA GENERAZIONE REPORT DETTAGLIO: ", e);
			}
			log.info("FINE Elaborazione account");
		}
	}

	/*
	 * Generazione del PDF per un account
	 * @param accountCMP
	 * @param divisioneCMP
	 * @param organizzazioneCMP
	 * @param elencoCosti
	 * @param annoMese
	 * @throws DocumentException
	 */
	private void generazionePdf(ListAccountsResponseSchemaAccounts accountCMP, ListDivisionsResponseSchemaDivisions divisioneCMP, ListOrganizationsResponseSchemaOrganizations organizzazioneCMP, List<SpCostoGiorno> elencoCosti, LocalDate annoMese, SpRendiconto rendiconto, Set<SpDTipoServizio> decodificaTipiServizio) throws DocumentException {
		ByteArrayOutputStream file = new ByteArrayOutputStream();

		Document document = new Document(PageSize.LETTER);
		document.setMargins(document.leftMargin()-10, document.rightMargin()-10, document.topMargin() + 120,
				document.bottomMargin() + 30);

		PdfWriter writer = PdfWriter.getInstance(document, file);

		HeaderFooterReport hf = new HeaderFooterReport(proprieta.getDeploy().getPathToFrontEnd());

		writer.setPageEvent(hf);

		document.open();
		
		// metadati del PDF
		document.addTitle(
				"Report Giornaliero Costi del mese di " + annoMese.getMonth().getDisplayName(TextStyle.FULL, Locale.ITALY).toUpperCase() +  annoMese.getYear());
		document.addSubject("Generato automaticamente da Nivola");
		document.addKeywords("Rendiconto, " + annoMese.getMonth() + ", " + accountCMP.getDesc());
		document.addAuthor("CSI Piemonte");
		document.addCreator("CSI Piemonte");
		
		//  titolo
		String sTitle1 = "REPORT MENSILE COSTI e CONSUMI";
		Paragraph parTitle1 = new Paragraph(sTitle1, ITextFont.TITLE_FONT);
		parTitle1.setAlignment(Element.ALIGN_CENTER);
		document.add(parTitle1);
		document.add(new Paragraph("  "));

		//tabella di intestazione con finromazini org, div, account, referente, email
		intestazione(accountCMP, divisioneCMP, organizzazioneCMP, document);
		
		// tabella con la sintesi del report (periodo - importo totale)
		String periodoFormattato = annoMese.withDayOfMonth(1).format(formatterPeriodo) +" - " + annoMese.format(formatterPeriodo);
		Double totale = elencoCosti.stream().mapToDouble(e -> e.getSpCostoGiornoDettaglios().stream().mapToDouble(dett -> dett.getCosto()).sum()).sum();
		componiTabellaDatiGeneraliReport(totale, annoMese, document, periodoFormattato);
		
		
		// compone la tabella con i consumi raggruppati per servizio
		PdfPTable tabellaDettaglio = new PdfPTable(3);
		tabellaDettaglio.setWidthPercentage(100);
		float[] rows = {333f, 333f, 334f};
		tabellaDettaglio.setTotalWidth(rows);
		
		tabellaDettaglio = cella(tabellaDettaglio, "Sintesi consumi periodo " + annoMese.getMonth().getDisplayName(TextStyle.FULL, Locale.ITALY).toUpperCase() + " " + annoMese.getYear() + " dettaglio servizi attivi", 
				ITextFont.REGULAR_BOLD, 3, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);
		
		List<RaggruppamentoCostiServizioDTO> elencoCostiPerServizio = spCostoGiornoRepository.raggruppaCostiServizioAccount(accountCMP.getUuid(), java.sql.Date.valueOf(annoMese.withDayOfMonth(1)), java.sql.Date.valueOf(annoMese));
		Set<String> serviziConCosti = new HashSet<String>();
		for (RaggruppamentoCostiServizioDTO servizio : elencoCostiPerServizio) {
			
			//qua detro una tabella per servizio se importo maggiore di zero
			if (servizio.getCosto() == 0) continue;
			
			serviziConCosti.add(servizio.getServizio().getNome());
			tabellaDettaglio = cella(tabellaDettaglio, servizio.getServizio().getDescrizione(), 
					ITextFont.REGULAR_BOLD, 2, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);
			
			
			tabellaDettaglio = cella(tabellaDettaglio, " Euro "+BigDecimal.valueOf(servizio.getCosto()).setScale(2, RoundingMode.HALF_UP), 
					ITextFont.REGULAR_BOLD, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);
		}
		
		document.add(tabellaDettaglio);
		document.add(new Paragraph("  "));
		document.add(new Paragraph("* Tutti gli importi visualizzati sono arrotondati a 2 cifre decimali.\r\n" + 
				"E' possibile che si verifichino dei disallineamenti tra la somma degli importi giornalieri e il totale mensile.\r\n" + 
				"L'importo effettivamente consuntivato è da considerarsi il totale mensile.", ITextFont.REGULAR_BOLD));
		
		document.add(Chunk.NEXTPAGE);
		
		Paragraph dettaglioConsumi = new Paragraph("Dettaglio consumi periodo " + periodoFormattato, ITextFont.TITLE_14_BOLD);
		document.add(dettaglioConsumi);

		document.add(new Paragraph("  "));
		boolean newPage = false;
		// INIZIO DETTAGLIO GIORNO - METRICHE RAGGRUPPATE PER SERVIZIO
		for (SpDTipoServizio tipoServizio : decodificaTipiServizio) {
			if (serviziConCosti.contains(tipoServizio.getNome())) {
				if (newPage) {
					document.add(Chunk.NEXTPAGE);
				}
				Paragraph parT4 = new Paragraph(tipoServizio.getDescrizione(), ITextFont.TITLE_14_BOLD);
				document.add(parT4);
				document.add(new Paragraph("  "));

				List<SpDMetriche> elencoMetricheServizio = null;
				
				if (CollectionUtils.isEmpty(tipoServizio.getSpDSottoservizios())) {
					elencoMetricheServizio = metricheRepository.findListinoECmpPerServizio(tipoServizio.getNome());
					PdfPTable tbServizio = composizioneTabellaConGiorni(elencoCosti, tipoServizio, document, elencoMetricheServizio);
					if (tbServizio != null)
						document.add(tbServizio);
					newPage = true;
				} else {
					for (SpDSottoservizio sottServ : tipoServizio.getSpDSottoservizios()) {
						elencoMetricheServizio = metricheRepository.findListinoECmpPerServizioSottoServizio(tipoServizio.getNome(), sottServ);
						PdfPTable tbServizio = composizioneTabellaConGiorni(elencoCosti, tipoServizio, document, elencoMetricheServizio);
						if (tbServizio != null) {
							document.add(new Paragraph(sottServ.getDescrizione(), ITextFont.TITLE_12_BOLD));
							document.add(new Paragraph("  "));
							document.add(tbServizio);
							document.add(Chunk.NEXTPAGE);
						}
						
					}
					newPage = false;
				}
			}
		}
		// FINE DETTAGLIO GIORNO - METRICHE RAGGRUPPATE PER SERVIZIO
		
		document.close();
		/*
		 * Salvataggio in Amazon S3
		 */
		StringBuilder fileName = new StringBuilder(organizzazioneCMP.getName())
			.append("/")
			.append(divisioneCMP.getName())
			.append("/")
			.append(accountCMP.getName())
			.append("/")
			.append(accountCMP.getName())
			.append("_MENSILE_DETTAGLIO_GIORNALIERO_")
			.append(annoMese.getYear())
			.append("_")
			.append(annoMese.getMonthValue())
			.append("_")
			.append(annoMese.getMonth().getDisplayName(TextStyle.FULL, Locale.ITALY).toLowerCase())
			.append(".pdf");
		
		String url = salvaFile(fileName, file);
		registraReportEseguito(accountCMP, divisioneCMP, organizzazioneCMP, annoMese, url, rendiconto, tipo, totale);
	}

	private PdfPTable composizioneTabellaConGiorni(List<SpCostoGiorno> elencoCosti, SpDTipoServizio tipoServizio, Document document, List<SpDMetriche> elencoMetricheServizio) throws DocumentException {
		// Tabella dati x giorno
		
		Double importoTotaleTabella = 0d;
		
		LinkedList<Float> dimensioneCelle = new LinkedList<Float>();
		dimensioneCelle.add(1.5f);
		for (int i=0; i<(elencoMetricheServizio.size()*2); i++) {
			dimensioneCelle.add(1f);
		}
		dimensioneCelle.add(1.5f);
		float[] array = ArrayUtils.toPrimitive(dimensioneCelle.toArray(new Float[0]));
		PdfPTable tbServizio = new PdfPTable(array);
		tbServizio.setWidthPercentage(100);
		tbServizio.setTotalWidth(document.getPageSize().getBorderWidth());

		tbServizio = cella(tbServizio, " GIORNO ", ITextFont.SMALL_BOLD, 1, 2, Rectangle.BOX, Element.ALIGN_CENTER, true, Color.LIGHT_GRAY);
		
		//intestazione metrica
		for (SpDMetriche metrica : elencoMetricheServizio) {
			tbServizio = cella(tbServizio, metrica.getDescrizione(), ITextFont.SMALL_BOLD, 2, 1, Rectangle.BOX, Element.ALIGN_CENTER, false, Color.LIGHT_GRAY);
		}
		
		//"Totale giorno" in fondo
		tbServizio = cella(tbServizio, "Totale\n giorno", ITextFont.SMALL_BOLD, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, true, Color.LIGHT_GRAY);
		
		//ciclo di comodo per le sottocelle quantità e costo
		for (@SuppressWarnings("unused") SpDMetriche metrica : elencoMetricheServizio) {
			tbServizio = cella(tbServizio, "Qta", ITextFont.SMALL_BOLD, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false, Color.LIGHT_GRAY);
			
			tbServizio = cella(tbServizio, "euro", ITextFont.SMALL_BOLD, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false, Color.LIGHT_GRAY);
		}
		
		//cella "importo sotto totale giorno
		tbServizio = cella(tbServizio, "Importo", ITextFont.SMALL_BOLD, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false, Color.LIGHT_GRAY);

		
		/*
		 * Inizio tabella per giorno.
		 * Si calcolano le somme per colonna (metrica) da inserire in fondo alla tabella
		 * Salvo in un map la somma incrementale indicizzandola per metrica per poterla recuperare dopo
		 */
		Map<String,Double> sommaColonneFooter = new HashMap<>(elencoMetricheServizio.size());
		Double sommaRigaGiorno = 0d;
		elencoCosti.sort(Comparator.comparing(SpCostoGiorno::getData));
		for (SpCostoGiorno giorno : elencoCosti) {
			//stampa il giorno
			tbServizio = cella(tbServizio, formatoGiorno.format(giorno.getData()), ITextFont.SMALL_FONT, 1, 1, Rectangle.BOX, Element.ALIGN_RIGHT, true);
			
			//cicla le metriche e ne stampa quantita e costo
			for (SpDMetriche metrica : elencoMetricheServizio) {
				Double qta = 0d;
				Double importo = 0d;
				
				/*
				 *  per le metriche listino si prende il dato puro, per le metriche CALC bisogna fare la somma di tutti 
				 *  i valori che corrispondono all'espressione regolare specificata come regola di calcolo
				 */
				Optional<SpCostoGiornoDettaglio> dettaglioTrovato = giorno.getSpCostoGiornoDettaglios().stream().filter(e -> e.getSpDMetriche().getId().equals(metrica.getId())).findFirst();
				qta = dettaglioTrovato.isPresent() ? dettaglioTrovato.get().getQta() : 0;
				importo = dettaglioTrovato.isPresent() ? dettaglioTrovato.get().getCosto() : 0;

				//cella col valore di quantita
				if ("D".equals(metrica.getIsTenantCost()) && qta > 0) {
					final Double decodificaTenant = qta;
					SpDListinoDettaglio dettaglioTenant = metrica.getSpDListinoDettaglios().stream().filter(ld -> ld.getQta().equals(decodificaTenant)).findFirst().get();
					tbServizio = cella(tbServizio, dettaglioTenant.getDescrizione(), ITextFont.SMALL_FONT, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);
				} else {
					tbServizio = cella(tbServizio, df.format(qta), ITextFont.SMALL_FONT, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);
				}
				

				//cella col valore importo
				tbServizio = cella(tbServizio, df.format(importo), ITextFont.SMALL_FONT, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);
				
				//gestione somma per totali in fondo, può essercvi già o no (prima volta)
				Double sommaIncorso = sommaColonneFooter.getOrDefault(metrica.getNome(), 0d);
				sommaIncorso += importo;
				sommaColonneFooter.put(metrica.getNome(), sommaIncorso);
				sommaRigaGiorno += importo;
			}
			
			//somma per il tutale giorno
			tbServizio = cella(tbServizio, df.format(sommaRigaGiorno), ITextFont.SMALL_FONT, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);
			sommaRigaGiorno = 0d;
		}
		
		//riga con i totali per colonna (metrica)
		tbServizio = cella(tbServizio, "TOTALE", ITextFont.SMALL_BOLD, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false, Color.LIGHT_GRAY);
		
		
		for (SpDMetriche metrica : elencoMetricheServizio) {
			tbServizio = cella(tbServizio, df.format(sommaColonneFooter.getOrDefault(metrica.getNome(), 0d)), ITextFont.SMALL_BOLD, 2, 1, Rectangle.BOX, Element.ALIGN_RIGHT, false, Color.LIGHT_GRAY);
			importoTotaleTabella += sommaColonneFooter.getOrDefault(metrica.getNome(), 0d);
		}
		
		if (importoTotaleTabella > 0) {
			tbServizio = cella(tbServizio, df.format(importoTotaleTabella), ITextFont.SMALL_BOLD, 2, 1, Rectangle.BOX, Element.ALIGN_CENTER, false, Color.LIGHT_GRAY);
		
			return tbServizio;
		}
		return null;
	}
}
