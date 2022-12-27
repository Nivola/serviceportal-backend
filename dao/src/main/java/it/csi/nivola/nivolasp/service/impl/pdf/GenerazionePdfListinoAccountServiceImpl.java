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
package it.csi.nivola.nivolasp.service.impl.pdf;

import java.io.ByteArrayOutputStream;
import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import it.csi.nivola.nivolasp.config.ApplicationProperties;
import it.csi.nivola.nivolasp.integration.rest.api.service.AuthorityApi;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetAccountResponseSchema;
import it.csi.nivola.nivolasp.service.GenerazionePdfListinoAccountService;
import it.csi.nivola.nivolasp.service.dto.ListinoDTO;
import it.csi.nivola.nivolasp.service.dto.ListinoDettaglioDTO;
import it.csi.nivola.nivolasp.service.dto.ListinoTipoPrezzoDTO;
import it.csi.nivola.nivolasp.service.dto.ReportRendicontoResponse;
import it.csi.nivola.nivolasp.service.impl.HeaderFooterReport;
import it.csi.nivola.nivolasp.service.impl.ITextFont;

@Service
public class GenerazionePdfListinoAccountServiceImpl implements GenerazionePdfListinoAccountService {
	
	@Autowired
	AuthorityApi authorityApi;
	
	protected DecimalFormat df = new DecimalFormat("#.##");
	
	ListinoTipoPrezzoDTO prezzoDefault = new ListinoTipoPrezzoDTO();
	
	@Autowired
	public ApplicationProperties proprieta = null;

	@Override
	public ReportRendicontoResponse generaPdf(ListinoDTO listino) throws DocumentException {
		prezzoDefault.setImportoAnnuo(0.0d);
		GetAccountResponseSchema account = authorityApi.v10NwsAccountsOidGet("757998dc-8185-4caa-8b43-a170290a6809");
		ByteArrayOutputStream file = new ByteArrayOutputStream();

		Document document = new Document(PageSize.LETTER);
		document.setMargins(document.leftMargin(), document.rightMargin(), document.topMargin() + 120,
				document.bottomMargin() + 30);

		PdfWriter writer = PdfWriter.getInstance(document, file);

		HeaderFooterReport hf = new HeaderFooterReport(proprieta.getDeploy().getPathToFrontEnd());

		writer.setPageEvent(hf);

		document.open();

		document.addTitle("Dati del listino applicato all'account " + account.getAccount().getName());
		document.addSubject("Generato su richiesta da Nivola");
		document.addKeywords("Listino, " + account.getAccount().getName());
		document.addAuthor("CSI Piemonte");
		document.addCreator("CSI Piemonte");
		
		// titolo del report
		String sTitle1 = "PROSPETTO DI LISTINO PREZZI";
		Paragraph parTitle1 = new Paragraph(sTitle1, ITextFont.TITLE_FONT);
		parTitle1.setAlignment(Element.ALIGN_CENTER);
		document.add(parTitle1);
		document.add(new Paragraph("  "));

		//tabella di intestazione con finromazini org, div, account, referente, email
		PdfPTable tbHeader = new PdfPTable(2);
		tbHeader.setWidthPercentage(100);
		float[] rowsHeader = { 300f, 900f };
		tbHeader.setTotalWidth(rowsHeader);

		// NOME ACCOUNT
		tbHeader = cella(tbHeader, "Account : ", ITextFont.REGULAR_BOLD, 1, 1, Rectangle.BOX, Element.ALIGN_LEFT, false);
		tbHeader = cella(tbHeader, account.getAccount().getDesc(), ITextFont.REGULAR_FONT, 1, 1, Rectangle.BOX, Element.ALIGN_LEFT, false);

		// REFERENTE DELL'ACCOUNT
		tbHeader = cella(tbHeader, "Referente : ", ITextFont.REGULAR_BOLD, 1, 1, Rectangle.BOX, Element.ALIGN_LEFT, false);
		tbHeader = cella(tbHeader, account.getAccount().getContact(), ITextFont.REGULAR_FONT, 1, 1, Rectangle.BOX, Element.ALIGN_LEFT, false);

		// EMAIL DALL'ACCOUNT
		tbHeader = cella(tbHeader, "Email : ", ITextFont.REGULAR_BOLD, 1, 1, Rectangle.BOX, Element.ALIGN_LEFT, false);
		tbHeader = cella(tbHeader, account.getAccount().getEmail(), ITextFont.REGULAR_FONT, 1, 1, Rectangle.BOX, Element.ALIGN_LEFT, false);
		
		// Listino nome
		tbHeader = cella(tbHeader, "Nome del listino : ", ITextFont.REGULAR_BOLD, 1, 1, Rectangle.BOX, Element.ALIGN_LEFT, false);
		tbHeader = cella(tbHeader, listino.getNome(), ITextFont.REGULAR_FONT, 1, 1, Rectangle.BOX, Element.ALIGN_LEFT, false);
		
		// Listino descrizione
		tbHeader = cella(tbHeader, "Descrizione del listino : ", ITextFont.REGULAR_BOLD, 1, 1, Rectangle.BOX, Element.ALIGN_LEFT, false);
		tbHeader = cella(tbHeader, listino.getDescrizione(), ITextFont.REGULAR_FONT, 1, 1, Rectangle.BOX, Element.ALIGN_LEFT, false);

		document.add(tbHeader);
		
		document.add(new Paragraph("  "));
		document.add(new Paragraph("Dettaglio voci di costo", ITextFont.TITLE_12_BOLD));
		
		document.add(new Paragraph("  "));

		// compone la tabella con i consumi raggruppati per servizio
		PdfPTable tabellaDettaglio = new PdfPTable(5);
		tabellaDettaglio.setWidthPercentage(100);
		float[] rows = {200f, 446f, 100f, 100f, 154f};
		tabellaDettaglio.setTotalWidth(rows);
		tabellaDettaglio.setHeaderRows(1);
		
		tabellaDettaglio = cella(tabellaDettaglio, "Servizio", ITextFont.REGULAR_BOLD, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);
		tabellaDettaglio = cella(tabellaDettaglio, "Voce", ITextFont.REGULAR_BOLD, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);
		tabellaDettaglio = cella(tabellaDettaglio, "Unità di misura", ITextFont.REGULAR_BOLD, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);
		tabellaDettaglio = cella(tabellaDettaglio, "Quantità", ITextFont.REGULAR_BOLD, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);
		tabellaDettaglio = cella(tabellaDettaglio, "Importo Annuo", ITextFont.REGULAR_BOLD, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);
		
		for (ListinoDettaglioDTO dett : listino.getElencoDettagli()) {
			tabellaDettaglio = cella(tabellaDettaglio, dett.getServizio(), ITextFont.REGULAR_FONT, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);
			tabellaDettaglio = cella(tabellaDettaglio, dett.getVoce(), ITextFont.REGULAR_FONT, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);
			tabellaDettaglio = cella(tabellaDettaglio, dett.getUdm(), ITextFont.REGULAR_FONT, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);
			tabellaDettaglio = cella(tabellaDettaglio, dett.getQta()+"", ITextFont.REGULAR_FONT, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);
			tabellaDettaglio = cella(tabellaDettaglio, df.format(dett.getElencoPrezzo().stream().findFirst().orElse(prezzoDefault).getImportoAnnuo()), ITextFont.REGULAR_FONT, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);
		}
		
		
		document.add(tabellaDettaglio);
		document.close();
		// FINE DOCUMENTO
		
		//nome file = cartella_organizzazione / cartella_divisione / cartella_acount / MENSILE_nomeAccount_anno_mese_meseesteso
		
		ReportRendicontoResponse response = new ReportRendicontoResponse();
		response.setNomeFile("Listino " + account.getAccount().getName() + ".pdf");
		response.setReport(file.toByteArray());
		return response;
	}


	protected PdfPTable cella(PdfPTable tabella, String contenuto, Font font, int colspan, int rowspan, int border, int alignent, boolean nowrap) {
		Paragraph pp;
		PdfPCell cc;
		pp = new Paragraph(contenuto, font);
		cc = new PdfPCell(pp);
		cc.setColspan(colspan);
		cc.setRowspan(rowspan);
		cc.setBorder(border);
		cc.setHorizontalAlignment(alignent);
		cc.setNoWrap(nowrap);
		tabella.addCell(cc);
		return tabella;
	}

}
