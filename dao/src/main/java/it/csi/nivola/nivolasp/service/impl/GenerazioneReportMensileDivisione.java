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
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import it.csi.nivola.nivolasp.config.ApplicationProperties;
import it.csi.nivola.nivolasp.domain.SpDTipoRendiconto;
import it.csi.nivola.nivolasp.domain.SpRendiconto;
import it.csi.nivola.nivolasp.integration.rest.api.service.AuthorityApi;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetAccountResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetOrganizationResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListDivisionsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListDivisionsResponseSchemaDivisions;
import it.csi.nivola.nivolasp.service.RendicontoService;
import it.csi.nivola.nivolasp.service.dto.CostoAccountDTO;
import it.csi.nivola.nivolasp.service.dto.CostoDelMeseRigaDTO;

public class GenerazioneReportMensileDivisione extends ReportPdf {
	

	@Autowired
	RendicontoService rendicontoService;
	

	@Autowired
	AuthorityApi authorityApi;
	

	@Autowired
	public ApplicationProperties proprieta = null;
	
	public void generaRendicontoMensileDivisione () throws FileNotFoundException, DocumentException {
		
		ListDivisionsResponseSchema response = authorityApi.v10NwsDivisionsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		
		for (ListDivisionsResponseSchemaDivisions divisione : response.getDivisions()) {
			YearMonth annoMese = YearMonth.now();
			
			for (int i=1;i<=12;i++) {
				annoMese = annoMese.minusMonths(1);
				LocalDate data = LocalDate.from(annoMese.atDay(1));
				Date dataA = new Timestamp(java.sql.Date.valueOf(data.withDayOfMonth(data.getMonth().length(data.isLeapYear()))).getTime());
				Date dataDa = new Timestamp(java.sql.Date.valueOf(data.withDayOfMonth(1)).getTime());
				List<CostoAccountDTO> elencoDivisoPerAccount = rendicontoService.aggregaCostiAccountPerDivisionePeriodo(divisione.getUuid(), dataDa, dataA);
				List<CostoDelMeseRigaDTO> elencoPerServizio = rendicontoService.aggregaCostiDivisionePerServizio(divisione.getUuid(), dataDa);
				
				GetOrganizationResponseSchema cercaOrganizzazione = authorityApi.v10NwsOrganizationsOidGet(divisione.getOrganizationId());
				
				//generazione report
				ByteArrayOutputStream file = new ByteArrayOutputStream();

				Document document = new Document(PageSize.LETTER);
				document.setMargins(document.leftMargin(), document.rightMargin(), document.topMargin() + 120,
						document.bottomMargin() + 30);

				PdfWriter writer = PdfWriter.getInstance(document, file);

				HeaderFooterReport hf = new HeaderFooterReport(proprieta.getDeploy().getPathToFrontEnd());

				writer.setPageEvent(hf);

				// OPEN
				document.open();

				// Add metadata
				data = LocalDate.from(annoMese.atDay(1));
				
				document.addTitle(
						"Report Mensile Costi del mese di " + data.getMonth().getDisplayName(TextStyle.FULL, Locale.ITALY).toUpperCase() + " anno " + annoMese.getYear());
				document.addSubject("Generato automaticamente da Nivola");
				document.addKeywords("Rendiconto, " + annoMese.getMonth() + ", " + divisione.getDesc());
				document.addAuthor("CSI Piemonte");
				document.addCreator("CSI Piemonte");
				
				String sTitle1 = "REPORT MENSILE COSTI e CONSUMI";
				Paragraph parTitle1 = new Paragraph(sTitle1, ITextFont.TITLE_FONT);
				parTitle1.setAlignment(Element.ALIGN_CENTER);
				document.add(parTitle1);
				document.add(new Paragraph("  "));

				// HEADER - SEZIONE INFORMAZIONI SULL'ENTE E DATA del RENDICONTO
				PdfPTable tbHeader = new PdfPTable(2);
				tbHeader.setWidthPercentage(100);
				float[] rowsHeader = { 300f, 900f };
				tbHeader.setTotalWidth(rowsHeader);

				// HEADER - Data rendiconto

				// HEADER - Org
				Paragraph parLblOrg = new Paragraph("Organizzazione : ", ITextFont.REGULAR_BOLD);

				PdfPCell lblOrg = new PdfPCell(parLblOrg);
				lblOrg.setBorder(Rectangle.NO_BORDER);
				lblOrg.setHorizontalAlignment(Element.ALIGN_LEFT);

				Paragraph parTxtOrg = new Paragraph(cercaOrganizzazione.getOrganization().getDesc(), ITextFont.REGULAR_FONT);

				PdfPCell txtEnte = new PdfPCell(parTxtOrg);
				txtEnte.setBorder(Rectangle.NO_BORDER);
				txtEnte.setHorizontalAlignment(Element.ALIGN_LEFT);

				tbHeader.addCell(lblOrg);
				tbHeader.addCell(txtEnte);
				
				// HEADER - Div
				Paragraph parLblDiv = new Paragraph("Divisione : ", ITextFont.REGULAR_BOLD);
				
				PdfPCell lblDiv = new PdfPCell(parLblDiv);
				lblDiv.setBorder(Rectangle.NO_BORDER);
				lblDiv.setHorizontalAlignment(Element.ALIGN_LEFT);
				
				Paragraph parTxtDiv = new Paragraph(divisione.getDesc(), ITextFont.REGULAR_FONT);
				
				PdfPCell txtDiv = new PdfPCell(parTxtDiv);
				txtDiv.setBorder(Rectangle.NO_BORDER);
				txtDiv.setHorizontalAlignment(Element.ALIGN_LEFT);
				
				tbHeader.addCell(lblDiv);
				tbHeader.addCell(txtDiv);
				

				// HEADER - Indirizzo
				Paragraph parLblIndirizzo = new Paragraph("Indirizzo : ", ITextFont.REGULAR_BOLD);

				PdfPCell lblIndirizzo = new PdfPCell(parLblIndirizzo);
				lblIndirizzo.setBorder(Rectangle.NO_BORDER);
				lblIndirizzo.setHorizontalAlignment(Element.ALIGN_LEFT);

				Paragraph parTxtIndirizzo = new Paragraph(divisione.getPostaladdress(), ITextFont.REGULAR_FONT);

				PdfPCell txtIndirizzo = new PdfPCell(parTxtIndirizzo);
				txtIndirizzo.setBorder(Rectangle.NO_BORDER);
				txtIndirizzo.setHorizontalAlignment(Element.ALIGN_LEFT);

				tbHeader.addCell(lblIndirizzo);
				tbHeader.addCell(txtIndirizzo);

				// HEADER - Referente
				Paragraph parLblReferente = new Paragraph("Referente : ", ITextFont.REGULAR_BOLD);

				PdfPCell lblReferente = new PdfPCell(parLblReferente);
				lblReferente.setBorder(Rectangle.NO_BORDER);
				lblReferente.setHorizontalAlignment(Element.ALIGN_LEFT);

				Paragraph parTxtReferente = new Paragraph(divisione.getContact(), ITextFont.REGULAR_FONT);

				PdfPCell txtReferente = new PdfPCell(parTxtReferente);
				txtReferente.setBorder(Rectangle.NO_BORDER);
				txtReferente.setHorizontalAlignment(Element.ALIGN_LEFT);

				tbHeader.addCell(lblReferente);
				tbHeader.addCell(txtReferente);

				// HEADER - Email
				Paragraph parLblEmail = new Paragraph("Email : ", ITextFont.REGULAR_BOLD);

				PdfPCell lblEmail = new PdfPCell(parLblEmail);
				lblEmail.setBorder(Rectangle.NO_BORDER);
				lblEmail.setHorizontalAlignment(Element.ALIGN_LEFT);

				Paragraph parTxtEmail = new Paragraph(divisione.getEmail(), ITextFont.REGULAR_FONT);

				PdfPCell txtEmail = new PdfPCell(parTxtEmail);
				txtEmail.setBorder(Rectangle.NO_BORDER);
				txtEmail.setHorizontalAlignment(Element.ALIGN_LEFT);

				tbHeader.addCell(lblEmail);
				tbHeader.addCell(txtEmail);
				
				document.add(tbHeader);
				
				document.add(new Paragraph("  "));
				
				
				//TABELLA DI SINTESI 
				document.add(new Paragraph("  "));
				PdfPTable tabellaSintesi = new PdfPTable(2);
				tabellaSintesi.setWidthPercentage(100);
				float[] rows = {500f, 500f};
				tabellaSintesi.setTotalWidth(rows);

				Paragraph parDelibereHeader = new Paragraph("REPORT MESE DI " + data.getMonth().getDisplayName(TextStyle.FULL, Locale.ITALY).toUpperCase() + " " + annoMese.getYear(), ITextFont.REGULAR_BOLD);
				PdfPCell lblDelibereHeader = new PdfPCell(parDelibereHeader);
				lblDelibereHeader.setColspan(2);
				lblDelibereHeader.setBorder(Rectangle.BOX);
				lblDelibereHeader.setHorizontalAlignment(Element.ALIGN_CENTER);

				tabellaSintesi.addCell(lblDelibereHeader);

				Paragraph parDelibereLblCol1 = new Paragraph("Data di generazione Report", ITextFont.REGULAR_BOLD);
				PdfPCell cellDelibereLblCol1 = new PdfPCell(parDelibereLblCol1);
				cellDelibereLblCol1.setColspan(1);
				cellDelibereLblCol1.setBorder(Rectangle.BOX);
				cellDelibereLblCol1.setHorizontalAlignment(Element.ALIGN_CENTER);
				tabellaSintesi.addCell(cellDelibereLblCol1);
				
				LocalDateTime now = LocalDateTime.now();

		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss");

		        String formatDateTime = now.format(formatter);
		 
				Paragraph par1Head = new Paragraph(formatDateTime, ITextFont.REGULAR_FONT);
				PdfPCell cell1 = new PdfPCell(par1Head);
				cell1.setColspan(1);
				cell1.setBorder(Rectangle.BOX);
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				tabellaSintesi.addCell(cell1);

				Paragraph parPeriodoEtichetta = new Paragraph("Periodo", ITextFont.REGULAR_BOLD);
				PdfPCell cellaEtichettaPeriodo = new PdfPCell(parPeriodoEtichetta);
				cellaEtichettaPeriodo.setColspan(1);
				cellaEtichettaPeriodo.setBorder(Rectangle.BOX);
				cellaEtichettaPeriodo.setHorizontalAlignment(Element.ALIGN_CENTER);
				tabellaSintesi.addCell(cellaEtichettaPeriodo);

				Paragraph parPeriodoValore = new Paragraph(data.getMonth().getDisplayName(TextStyle.FULL, Locale.ITALY) + " " + annoMese.getYear(), ITextFont.REGULAR_FONT);
				PdfPCell cellaPeriodoValore = new PdfPCell(parPeriodoValore);
				cellaPeriodoValore.setColspan(1);
				cellaPeriodoValore.setBorder(Rectangle.BOX);
				cellaPeriodoValore.setHorizontalAlignment(Element.ALIGN_CENTER);
				tabellaSintesi.addCell(cellaPeriodoValore);

				Paragraph paragradoEtichettaImporto = new Paragraph("Importo totale", ITextFont.REGULAR_BOLD);
				PdfPCell cellaEtichettaImporto = new PdfPCell(paragradoEtichettaImporto);
				cellaEtichettaImporto.setColspan(1);
				cellaEtichettaImporto.setBorder(Rectangle.BOX);
				cellaEtichettaImporto.setHorizontalAlignment(Element.ALIGN_CENTER);
				tabellaSintesi.addCell(cellaEtichettaImporto);
				
				double importoTotaleDivisione = elencoDivisoPerAccount.stream().mapToDouble(CostoAccountDTO::getImporto).sum();
				Paragraph parValoreImporto = new Paragraph(importoTotaleDivisione+" Euro", ITextFont.REGULAR_FONT);
				PdfPCell cellaValoreImporto = new PdfPCell(parValoreImporto);
				cellaValoreImporto.setColspan(1);
				cellaValoreImporto.setBorder(Rectangle.BOX);
				cellaValoreImporto.setHorizontalAlignment(Element.ALIGN_CENTER);
				tabellaSintesi.addCell(cellaValoreImporto);
				
				document.add(tabellaSintesi);
				// FINE TABELLA SINTESI
				
				
				// INIZIO TABELLA COSTI PER SERVIZIO
				document.add(new Paragraph("  "));
				
				PdfPTable tabellaDettaglio = new PdfPTable(2);
				tabellaDettaglio.setWidthPercentage(100);
				tabellaDettaglio.setTotalWidth(rows);
				
				Paragraph paragrafoDettaglioHeader = new Paragraph("RIEPILOGO COSTI PER SERVIZIO", ITextFont.REGULAR_BOLD);
				PdfPCell labelDettaglioHeader = new PdfPCell(paragrafoDettaglioHeader);
				labelDettaglioHeader.setColspan(2);
				labelDettaglioHeader.setBorder(Rectangle.BOX);
				labelDettaglioHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				tabellaDettaglio.addCell(labelDettaglioHeader);
				for (CostoDelMeseRigaDTO servizio : elencoPerServizio) {
					
					// tabella dettaglio per servizio
					Paragraph paragrafoNomeMetrica = new Paragraph(servizio.getNome(), ITextFont.REGULAR_BOLD);
					PdfPCell cellaNomeMetrica = new PdfPCell(paragrafoNomeMetrica);
					cellaNomeMetrica.setColspan(1);
					cellaNomeMetrica.setBorder(Rectangle.BOX);
					cellaNomeMetrica.setHorizontalAlignment(Element.ALIGN_CENTER);
					tabellaDettaglio.addCell(cellaNomeMetrica);
					
					Paragraph paragrafoImportoMetrica = new Paragraph(BigDecimal.valueOf(servizio.getCosto()).setScale(2, RoundingMode.HALF_UP)+" Euro", ITextFont.REGULAR_FONT);
					PdfPCell cellaValoreMetrica = new PdfPCell(paragrafoImportoMetrica);
					cellaValoreMetrica.setColspan(1);
					cellaValoreMetrica.setBorder(Rectangle.BOX);
					cellaValoreMetrica.setHorizontalAlignment(Element.ALIGN_CENTER);
					tabellaDettaglio.addCell(cellaValoreMetrica);
				}
				
				
				document.add(tabellaDettaglio);
				//FINE TABELLA COSTI PER SERVIZIO
				
				//INIZIO TABELLA COSTI PER ACCOUNT
				document.add(new Paragraph("  "));
				
				PdfPTable tabellaAccount = new PdfPTable(2);
				tabellaAccount.setWidthPercentage(100);
				tabellaAccount.setTotalWidth(rows);
				
				Paragraph paragrafoAccountHeader = new Paragraph("COSTI DIVISI PER ACCOUNT DELLA DIVISIONE", ITextFont.REGULAR_BOLD);
				PdfPCell labelAccountHeader = new PdfPCell(paragrafoAccountHeader);
				labelAccountHeader.setColspan(2);
				labelAccountHeader.setBorder(Rectangle.BOX);
				labelAccountHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				tabellaAccount.addCell(labelAccountHeader);
				for (CostoAccountDTO costoAccount : elencoDivisoPerAccount) {
					GetAccountResponseSchema cercaAccount = authorityApi.v10NwsAccountsOidGet(costoAccount.getUuid());
					// tabella dettaglio per servizio
					Paragraph paragrafoNomeAccount = new Paragraph(cercaAccount.getAccount().getName(), ITextFont.REGULAR_BOLD);
					PdfPCell cellaNomeAccount = new PdfPCell(paragrafoNomeAccount);
					cellaNomeAccount.setColspan(1);
					cellaNomeAccount.setBorder(Rectangle.BOX);
					cellaNomeAccount.setHorizontalAlignment(Element.ALIGN_CENTER);
					tabellaAccount.addCell(cellaNomeAccount);
					
					Paragraph paragrafoImportoAccount = new Paragraph(BigDecimal.valueOf(costoAccount.getImporto()).setScale(2, RoundingMode.HALF_UP)+" Euro", ITextFont.REGULAR_FONT);
					PdfPCell cellaValoreAccount = new PdfPCell(paragrafoImportoAccount);
					cellaValoreAccount.setColspan(1);
					cellaValoreAccount.setBorder(Rectangle.BOX);
					cellaValoreAccount.setHorizontalAlignment(Element.ALIGN_CENTER);
					tabellaAccount.addCell(cellaValoreAccount);
				}
				
				
				document.add(tabellaAccount);
				//FINE TABELLA COSTI PER ACCOUNT

				document.close();
				
				List<SpDTipoRendiconto> elencor = rendicontoService.elencoTipi();
				SpDTipoRendiconto tipo = elencor.stream()
				  .filter(e -> "MD".equals(e.getCodice()))
				  .findAny()
				  .orElse(null);
				SpRendiconto rendiconto = new SpRendiconto();
				rendiconto.setDataCreazione(new Timestamp(System.currentTimeMillis()));
				rendiconto.setDataModifica(rendiconto.getDataCreazione());
				rendiconto.setDescrizione("Rendiconto del mese di " + data.getMonth().getDisplayName(TextStyle.FULL, Locale.ITALY).toUpperCase() + " per Divisione " + divisione.getName());
				rendiconto.setIdDivisione(divisione.getUuid());
				rendiconto.setIdOrganizzazione(cercaOrganizzazione.getOrganization().getUuid());
				rendiconto.setImporto(importoTotaleDivisione);
				rendiconto.setNota("Rendiconto del mese di " + data.getMonth().getDisplayName(TextStyle.FULL, Locale.ITALY).toUpperCase() + " per Divisione " + divisione.getName());
				rendiconto.setTipoRendiconto(tipo);
				rendiconto.setReport(file.toByteArray());
				rendiconto.setDataRendicontoA(java.sql.Date.valueOf(data.withDayOfMonth(data.getMonth().length(data.isLeapYear()))));
				rendiconto.setDataRendicontoDa(java.sql.Date.valueOf(data.withDayOfMonth(1)));
				rendicontoService.salvaRendiconto(rendiconto);
				
//				StringBuilder fileName = new StringBuilder(cercaOrganizzazione.getOrganization().getName())
//						.append("/")
//						.append(divisione.getName())
//						.append("/")
//						.append("MENSILE_")
//						.append(data.getYear())
//						.append("_")
//						.append(data.getMonthValue())
//						.append("_")
//						.append(data.getMonth().getDisplayName(TextStyle.FULL, Locale.ITALY).toLowerCase())
//						.append(".pdf");
//					
//					amazonS3ClientServiceBatch.uploadObject(proprieta.getBusinessApi().getAmazonReportBucket(), fileName.toString(), new ByteArrayInputStream(file.toByteArray()));
				
			}
		}
		
	}
	
	


}
