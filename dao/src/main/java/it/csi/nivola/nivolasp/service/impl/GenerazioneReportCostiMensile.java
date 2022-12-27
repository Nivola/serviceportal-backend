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

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

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
import it.csi.nivola.nivolasp.repository.RendicontoRepository;
import it.csi.nivola.nivolasp.repository.SpCostoGiornoRepository;
import it.csi.nivola.nivolasp.repository.SpDTipoServizioRepository;
import it.csi.nivola.nivolasp.service.RendicontoService;
import it.csi.nivola.nivolasp.service.dto.EstrazioneTotaliMetricaAccountDTO;
import it.csi.nivola.nivolasp.service.dto.RaggruppamentoCostiServizioDTO;
/**
 * Classe per la generazione del report PDF mensile sintetico destinato ai Clienti.
 */
@Service
public class GenerazioneReportCostiMensile extends ReportPdf {

	
	@Autowired
	RendicontoService rendicontoService;
	

	@Autowired
	RendicontoRepository rendicontoRepository;

	@Autowired
	AuthorityApi authorityApi;
	
	@Autowired
	SpCostoGiornoRepository spCostoGiornoRepository;
	
	ListDivisionsResponseSchema tutteDivisioni;
	ListOrganizationsResponseSchema tutteOrganizzazioni;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SpCostoGiornoRepository costoGiornoRepository;
	
	@Autowired
	SpDTipoServizioRepository spDTipoServizio;
	

	private SpDTipoRendiconto tipo;
	
	@PostConstruct
	public void inizializzaServizio() {
		List<SpDTipoRendiconto> elencor = rendicontoService.elencoTipi();
		tipo = elencor.stream()
		  .filter(e -> "MA".equals(e.getCodice()))
		  .findAny()
		  .orElse(null);
	}
	
	/**
	 * Genera il report mensile sintetico destinato ai Clienti.
	 * 
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 */
	public void generaReportMensileAccount () throws FileNotFoundException, DocumentException {
		log.info("INIZIO GENERAZIONE REPORT MENSILE SINTETICI");
		
		SpDTipoRendiconto tipoRendiconto = rendicontoService.elencoTipi().stream().filter(e -> "MA".equals(e.getCodice())).findAny().orElse(null);
		
		tutteDivisioni = authorityApi.v10NwsDivisionsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		tutteOrganizzazioni = authorityApi.v10NwsOrganizationsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		
		
		ListAccountsResponseSchema elencoAccount = authorityApi.v10NwsAccountsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		LocalDate dataOggi = LocalDate.now();
		
		for (ListAccountsResponseSchemaAccounts account : elencoAccount.getAccounts()) {
			
			LocalDate ultima = rendicontoRepository.findDataUltimaGenerazione(account.getUuid(), tipo);
			if (ultima == null)
				ultima = LocalDate.of(2019, 11, 1);
			
			//se ho già generato il report al giorno precedente rispetto ad oggi non devo fare nulla
			if (dataOggi.isBefore(ultima.plusDays(1)) || dataOggi.equals(ultima.plusDays(1))) {
				log.info("SKIPPO PERCHE' DATA ULTIMA = " + ultima);
				continue;
			}
				

			YearMonth annoMese = YearMonth.of(ultima.getYear(), ultima.getMonth());
			while (dataOggi.isAfter(LocalDate.of(annoMese.getYear(), annoMese.getMonth(), 1))) {
				//vede quali sono da rigenerare, controllando sulla sp_rendiconto i report precedentemente salvati
				SpRendiconto r = rendicontoRepository.findByAnnoAndMeseAndIdAccountAndTipoRendiconto(annoMese.getYear(), annoMese.getMonthValue(), account.getUuid(), tipoRendiconto);
				if (r ==null || r.getDataRendicontoA().toLocalDate().isBefore(dataOggi)) {
					log.debug("INIZIO GENERAZIONE REPORT PER ACCOUNT " + account.getName() + " MESE " + annoMese);
					try {
						generazionePdf(account, annoMese, tipoRendiconto, r);
						log.debug("FINE GENERAZIONE REPORT");
					} catch (Exception e) {
						log.debug("ERRORE ", e);
					}
				}
				annoMese = annoMese.plusMonths(1);
				
			}
			
		}
		log.info("FINE GENERAZIONE REPORT MENSILE SINTETICI");
	}
	

	/*
	 * Genera il PDF 
	 */
	private void generazionePdf(ListAccountsResponseSchemaAccounts account, YearMonth annoMese, SpDTipoRendiconto tipoRendiconto, SpRendiconto rendicontoDb) throws FileNotFoundException, DocumentException {
		ListDivisionsResponseSchemaDivisions cercaDivisione = tutteDivisioni.getDivisions().stream().filter(e -> e.getUuid().equalsIgnoreCase(account.getDivisionId())).findFirst().orElse(null);
		ListOrganizationsResponseSchemaOrganizations cercaOrganizzazione = tutteOrganizzazioni.getOrganizations().stream().filter(e -> e.getUuid().equalsIgnoreCase(cercaDivisione.getOrganizationId())).findFirst().orElse(null);
		
		
		ByteArrayOutputStream file = new ByteArrayOutputStream();

		Document document = new Document(PageSize.LETTER);
		document.setMargins(document.leftMargin(), document.rightMargin(), document.topMargin() + 120,
				document.bottomMargin() + 30);

		PdfWriter writer = PdfWriter.getInstance(document, file);

		HeaderFooterReport hf = new HeaderFooterReport(proprieta.getDeploy().getPathToFrontEnd());

		writer.setPageEvent(hf);

		document.open();

		// metadati del PDF
		LocalDate dataInizio = LocalDate.from(annoMese.atDay(1));
		
		document.addTitle(
				"Report Mensile Costi del mese di " + dataInizio.getMonth().getDisplayName(TextStyle.FULL, Locale.ITALY).toUpperCase() + " anno " + annoMese.getYear());
		document.addSubject("Generato automaticamente da Nivola");
		document.addKeywords("Rendiconto, " + annoMese.getMonth() + ", " + account.getDesc());
		document.addAuthor("CSI Piemonte");
		document.addCreator("CSI Piemonte");
		
		// titolo del report
		String sTitle1 = "REPORT MENSILE COSTI e CONSUMI";
		Paragraph parTitle1 = new Paragraph(sTitle1, ITextFont.TITLE_FONT);
		parTitle1.setAlignment(Element.ALIGN_CENTER);
		document.add(parTitle1);
		document.add(new Paragraph("  "));

		//tabella di intestazione con finromazini org, div, account, referente, email
		intestazione(account, cercaDivisione, cercaOrganizzazione, document);
		
		document.add(new Paragraph("  "));
		document.add(new Paragraph("  "));

		// tabella con la sintesi del report (periodo - importo totale)
		LocalDate dataFine = dataInizio.withDayOfMonth(dataInizio.lengthOfMonth());
		List<RaggruppamentoCostiServizioDTO> elencoCostiPerServizio = spCostoGiornoRepository.raggruppaCostiServizioAccount(account.getUuid(), java.sql.Date.valueOf(dataInizio), java.sql.Date.valueOf(dataFine));
		double amount = elencoCostiPerServizio.stream().mapToDouble(e -> e.getCosto()).sum();
		componiTabellaDatiGeneraliReport(amount, dataInizio, document, dataInizio.getMonth().getDisplayName(TextStyle.FULL, Locale.ITALY) + " " + annoMese.getYear());
		
		// compone la tabella con i consumi raggruppati per servizio
		PdfPTable tabellaDettaglio = new PdfPTable(3);
		tabellaDettaglio.setWidthPercentage(100);
		float[] rows = {333f, 333f, 334f};
		tabellaDettaglio.setTotalWidth(rows);
		
		tabellaDettaglio = cella(tabellaDettaglio, "Sintesi consumi periodo " + dataInizio.getMonth().getDisplayName(TextStyle.FULL, Locale.ITALY).toUpperCase() + " " + annoMese.getYear() + " dettaglio servizi attivi", 
				ITextFont.REGULAR_BOLD, 3, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);
		
		List<SpDTipoServizio> elencoTipiServizio = spDTipoServizioRepository.findAll();
		
		List<EstrazioneTotaliMetricaAccountDTO> tuttiCostiAccountPeriodo = costoGiornoRepository.estrazioneCSVCompleto(account.getUuid(), java.sql.Date.valueOf(dataInizio.withDayOfMonth(1)), java.sql.Date.valueOf(dataFine));
		
	
		for (RaggruppamentoCostiServizioDTO servizio : elencoCostiPerServizio) {
			
			//qua detro una tabella per servizio se importo maggiore di zero
			if (servizio.getCosto() == 0) continue;
			
			//riga vuota
			tabellaDettaglio = cellaVuota(tabellaDettaglio, 3, 1, 14.0f);
			
			tabellaDettaglio = cella(tabellaDettaglio, servizio.getServizio().getDescrizione(), 
					ITextFont.REGULAR_BOLD, 2, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);
			
			
			tabellaDettaglio = cella(tabellaDettaglio,"TOTALE    " + "Euro " + BigDecimal.valueOf(servizio.getCosto()).setScale(2, RoundingMode.HALF_UP), 
					ITextFont.REGULAR_BOLD, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);
			
			//rindondanza per non riscrivere le query condivise su piu' componenti e recuperare anche il nome,oltre la descrizione
			SpDTipoServizio decodificaServizio = elencoTipiServizio.stream().filter(s -> s.getNome().equals(servizio.getServizio().getNome())).findFirst().get();
			List<EstrazioneTotaliMetricaAccountDTO> costiFiltratiServizio = tuttiCostiAccountPeriodo.stream().filter(e -> e.getServizio().equals(decodificaServizio.getNome())).collect(Collectors.toList());
			
			// dettagli per metrica
			for (EstrazioneTotaliMetricaAccountDTO elem : costiFiltratiServizio) {
				if (elem.getTotaleCosto() > 0 ) {
					tabellaDettaglio = cella(tabellaDettaglio,"", ITextFont.REGULAR_FONT, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);
					
					tabellaDettaglio = cella(tabellaDettaglio, elem.getMetricaDescrizione(), ITextFont.REGULAR_BOLD, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);
					
					tabellaDettaglio = cella(tabellaDettaglio, "Euro " + df.format(elem.getTotaleCosto()), ITextFont.REGULAR_FONT, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);
				}
			}
		}
		
		document.add(tabellaDettaglio);
		document.add(new Paragraph("  "));
		document.add(new Paragraph("* Tutti gli importi visualizzati sono arrotondati a 2 cifre decimali.\r\n" + 
				"E' possibile che si verifichino dei disallineamenti tra la somma degli importi giornalieri e il totale mensile.\r\n" + 
				"L'importo effettivamente consuntivato è da considerarsi il totale mensile.", ITextFont.REGULAR_BOLD));
			
		
		document.close();
		// FINE DOCUMENTO
		
		//nome file = cartella_organizzazione / cartella_divisione / cartella_acount / MENSILE_nomeAccount_anno_mese_meseesteso
		StringBuilder fileName = new StringBuilder(cercaOrganizzazione.getName())
				.append("/")
				.append(cercaDivisione.getName())
				.append("/")
				.append(account.getName())
				.append("/")
				.append(account.getName())
				.append("_MENSILE_")
				.append("_")
				.append(dataInizio.getYear())
				.append("_")
				.append(dataInizio.getMonthValue())
				.append("_")
				.append(dataInizio.getMonth().getDisplayName(TextStyle.FULL, Locale.ITALY).toLowerCase())
				.append(".pdf");
		
		String url = salvaFile(fileName, file);
		
		if (dataFine.isAfter(LocalDate.now()))
			dataFine = LocalDate.now().minusDays(1);
		
		registraReportEseguito(account, cercaDivisione, cercaOrganizzazione, dataFine, url, rendicontoDb, 
				tipoRendiconto, amount);
	}
}
