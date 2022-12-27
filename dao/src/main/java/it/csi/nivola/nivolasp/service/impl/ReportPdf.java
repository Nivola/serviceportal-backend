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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;

import it.csi.nivola.nivolasp.config.ApplicationProperties;
import it.csi.nivola.nivolasp.domain.SpCostoGiorno;
import it.csi.nivola.nivolasp.domain.SpCostoGiornoDettaglio;
import it.csi.nivola.nivolasp.domain.SpDMetriche;
import it.csi.nivola.nivolasp.domain.SpDTipoRendiconto;
import it.csi.nivola.nivolasp.domain.SpRendiconto;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListAccountsResponseSchemaAccounts;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListDivisionsResponseSchemaDivisions;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListOrganizationsResponseSchemaOrganizations;
import it.csi.nivola.nivolasp.repository.SpDTipoServizioRepository;
import it.csi.nivola.nivolasp.service.AmazonS3ClientService;
import it.csi.nivola.nivolasp.service.RendicontoService;

public class ReportPdf {

	protected DecimalFormat df = new DecimalFormat("#.##");

	@Autowired
	AmazonS3ClientService amazonS3ClientService;

	@Autowired
	public ApplicationProperties proprieta = null;

	@Autowired
	RendicontoService rendicontoService;

	@Autowired
	SpDTipoServizioRepository spDTipoServizioRepository;

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	

	DateTimeFormatter formatterPeriodo = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ITALY);

	/**
	 * Costruisce una cella e la aggiunge ad una tabella
	 * 
	 * @param tabella la tabella in cui inserire la cella
	 * @param contenuto il testo - gia' formattato - da visualizzare
	 * @param font il font iText da utilizzare - @see ITextFont
	 * @param colspan
	 * @param rowspan
	 * @param border tipo di bordo @see com.lowagie.text.Rectangle
	 * @param alignent allineamento @see com.lowagie.text.Element
	 * @param nowrap true se il testo contenuto non deve andare a capo, false altrimenti
	 * @return la tabella passata come parametro
	 */
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

	/**
	 * Costruisce una cella e la aggiunge ad una tabella - rispetto al precedente
	 * include la dichiarazione del colore
	 * 
	 * @param tabella la tabella in cui inserire la cella
	 * @param contenuto il testo - gia' formattato - da visualizzare
	 * @param font il font iText da utilizzare - @see ITextFont
	 * @param colspan
	 * @param rowspan
	 * @param border tipo di bordo @see com.lowagie.text.Rectangle
	 * @param alignent allineamento @see com.lowagie.text.Element
	 * @param nowrap true se il testo contenuto non deve andare a capo, false altrimenti
	 * @param color il colore della cella definito da @see java.awt.Color
	 * @return la tabella passata come parametro
	 */
	protected PdfPTable cella(PdfPTable tabella, String contenuto, Font font, int colspan, int rowspan, int border, int alignent, boolean nowrap, Color color) {
		Paragraph pp;
		PdfPCell cc;
		pp = new Paragraph(contenuto, font);
		cc = new PdfPCell(pp);
		cc.setColspan(colspan);
		cc.setRowspan(rowspan);
		cc.setBorder(border);
		cc.setHorizontalAlignment(alignent);
		cc.setNoWrap(nowrap);
		cc.setBackgroundColor(color);
		tabella.addCell(cc);
		return tabella;
	}
	
	protected PdfPTable cellaVuota(PdfPTable tabella, int colspan, int rowspan, float fixedHeight) {
		Paragraph pp;
		PdfPCell cc;
		pp = new Paragraph("", ITextFont.REGULAR_FONT);
		cc = new PdfPCell(pp);
		cc.setColspan(colspan);
		cc.setRowspan(rowspan);
		cc.setBorder(Rectangle.BOX);
		cc.setNoWrap(true);
		cc.setFixedHeight(fixedHeight);
		tabella.addCell(cc);
		return tabella;
	}

	/**
	 * Genera l'header con le informazioni anagrafiche dell'account: - nome
	 * organizzazione; - nome divisione - nome account - indirizzo preso
	 * dall'organizzazione - referente dell'account - email dall'account
	 * 
	 * @param accountCMP
	 * @param divisioneCMP
	 * @param organizzazioneCMP
	 * @param document
	 * @param iTextFont
	 * @throws DocumentException
	 */
	protected void intestazione(ListAccountsResponseSchemaAccounts accountCMP, ListDivisionsResponseSchemaDivisions divisioneCMP, ListOrganizationsResponseSchemaOrganizations organizzazioneCMP, Document document) throws DocumentException {

		PdfPTable tbHeader = new PdfPTable(2);
		tbHeader.setWidthPercentage(100);
		float[] rowsHeader = { 300f, 900f };
		tbHeader.setTotalWidth(rowsHeader);

		// NOME ORGANIZZAZIONE
		tbHeader = cella(tbHeader, "Organizzazione : ", ITextFont.REGULAR_BOLD, 1, 1, Rectangle.BOX, Element.ALIGN_LEFT, false);
		tbHeader = cella(tbHeader, organizzazioneCMP.getName(), ITextFont.REGULAR_FONT, 1, 1, Rectangle.BOX, Element.ALIGN_LEFT, false);

		// NOME DIVISIONE
		tbHeader = cella(tbHeader, "Divisione : ", ITextFont.REGULAR_BOLD, 1, 1, Rectangle.BOX, Element.ALIGN_LEFT, false);
		tbHeader = cella(tbHeader, divisioneCMP.getName(), ITextFont.REGULAR_FONT, 1, 1, Rectangle.BOX, Element.ALIGN_LEFT, false);

		// NOME ACCOUNT
		tbHeader = cella(tbHeader, "Account : ", ITextFont.REGULAR_BOLD, 1, 1, Rectangle.BOX, Element.ALIGN_LEFT, false);
		tbHeader = cella(tbHeader, accountCMP.getDesc(), ITextFont.REGULAR_FONT, 1, 1, Rectangle.BOX, Element.ALIGN_LEFT, false);

		// INDIRIZZO PRESO DALL'ORGANIZZAZIONE
		tbHeader = cella(tbHeader, "Indirizzo : ", ITextFont.REGULAR_BOLD, 1, 1, Rectangle.BOX, Element.ALIGN_LEFT, false);
		tbHeader = cella(tbHeader, organizzazioneCMP.getPostaladdress(), ITextFont.REGULAR_FONT, 1, 1, Rectangle.BOX, Element.ALIGN_LEFT, false);

		// REFERENTE DELL'ACCOUNT
		tbHeader = cella(tbHeader, "Referente : ", ITextFont.REGULAR_BOLD, 1, 1, Rectangle.BOX, Element.ALIGN_LEFT, false);
		tbHeader = cella(tbHeader, accountCMP.getContact(), ITextFont.REGULAR_FONT, 1, 1, Rectangle.BOX, Element.ALIGN_LEFT, false);

		// EMAIL DALL'ACCOUNT
		tbHeader = cella(tbHeader, "Email : ", ITextFont.REGULAR_BOLD, 1, 1, Rectangle.BOX, Element.ALIGN_LEFT, false);
		tbHeader = cella(tbHeader, accountCMP.getEmail(), ITextFont.REGULAR_FONT, 1, 1, Rectangle.BOX, Element.ALIGN_LEFT, false);

		document.add(tbHeader);
	}

	/**
	 * Tabella con i dati generali del report (Data generazione, periodo e importo totale)
	 * 
	 * @param elencoCosti
	 * @param annoMese
	 * @param document
	 * @param iTextFont
	 * @param periodoFormattato
	 * @return
	 * @throws DocumentException
	 */
	protected void componiTabellaDatiGeneraliReport(Double totale, LocalDate annoMese, Document document, String periodoFormattato) throws DocumentException {

		// spaziatura comune a tutti i report
		document.add(new Paragraph("  "));
		document.add(new Paragraph("  "));

		// tabella riepilogo
		PdfPTable tabellaRiepilogo = new PdfPTable(2);
		tabellaRiepilogo.setWidthPercentage(100);
		float[] rows = { 500f, 500f };
		tabellaRiepilogo.setTotalWidth(rows);

		// intestazione di due colonne
		tabellaRiepilogo = cella(tabellaRiepilogo, "REPORT MESE DI " + annoMese.getMonth().getDisplayName(TextStyle.FULL, Locale.ITALY).toUpperCase() + " " + annoMese.getYear(), ITextFont.REGULAR_BOLD, 2, 1, Rectangle.BOX,
				Element.ALIGN_CENTER, false);

		// riga data di generazione: 2 celle etichetta - valore
		tabellaRiepilogo = cella(tabellaRiepilogo, "Data di generazione Report", ITextFont.REGULAR_BOLD, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss");
		String formatDateTime = now.format(formatter);
		tabellaRiepilogo = cella(tabellaRiepilogo, formatDateTime, ITextFont.REGULAR_FONT, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);

		// riga periodo: 2 celle etichetta - valore
		tabellaRiepilogo = cella(tabellaRiepilogo, "Periodo", ITextFont.REGULAR_BOLD, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);
		tabellaRiepilogo = cella(tabellaRiepilogo, periodoFormattato, ITextFont.REGULAR_FONT, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);

		// riga importo totale: 2 celle etichetta - valore
		tabellaRiepilogo = cella(tabellaRiepilogo, "Importo totale", ITextFont.REGULAR_BOLD, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);
		tabellaRiepilogo = cella(tabellaRiepilogo, "Euro " + df.format(totale), ITextFont.REGULAR_FONT, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);

		document.add(tabellaRiepilogo);
		document.add(new Paragraph("  "));
	}
	
	/*
	 * Tabella SINTESI CONSUMI
	 */
	protected void componiTabellaSintesiMetrica(List<SpCostoGiorno> elencoCosti, Document document, String periodoFormattato) throws DocumentException {
		
		PdfPTable tabellaSintesiConsumi = new PdfPTable(2);
		tabellaSintesiConsumi.setWidthPercentage(100);
		float[] rows = {500f, 500f};
		tabellaSintesiConsumi.setTotalWidth(rows);
		
		Map<SpDMetriche,List<SpCostoGiornoDettaglio>> separataPerMetrica = elencoCosti.stream().flatMap(e -> e.getSpCostoGiornoDettaglios().stream()).collect(Collectors.groupingBy(SpCostoGiornoDettaglio::getSpDMetriche));
		
		// intestazione della tabella - Sintesi consumi periodo
		tabellaSintesiConsumi = cella(tabellaSintesiConsumi, "Sintesi consumi periodo " + periodoFormattato, ITextFont.REGULAR_BOLD, 2, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);
		
		// dettagli per metrica
		Set<SpDMetriche> setMetriche = separataPerMetrica.keySet();
		setMetriche = setMetriche.stream().sorted(Comparator.<SpDMetriche, String>comparing(m -> m.getSpDTipoServizio().getNome())).collect(Collectors.toSet());
		for (SpDMetriche elem : setMetriche) {
			
			tabellaSintesiConsumi = cella(tabellaSintesiConsumi, elem.getDescrizione(), ITextFont.REGULAR_BOLD, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);
			
			Double totaleMetrica = separataPerMetrica.get(elem).stream().mapToDouble(e -> e.getCosto()).sum();
			tabellaSintesiConsumi = cella(tabellaSintesiConsumi, df.format(totaleMetrica) + " Euro", ITextFont.REGULAR_FONT, 1, 1, Rectangle.BOX, Element.ALIGN_CENTER, false);
		}
		document.add(tabellaSintesiConsumi);
	}

	/**
	 * Salva il file su AWS S3
	 * 
	 * @param fileName
	 * @param file
	 */
	protected String salvaFile(StringBuilder fileName, ByteArrayOutputStream file) {
		log.info("INVIO DEL FILE SU S3:" + fileName);
		byte[] byteArray = file.toByteArray();
		amazonS3ClientService.uploadObject(proprieta.getBusinessApi().getAmazonReportBucket(), fileName.toString(), new ByteArrayInputStream(byteArray), byteArray.length);

		//conservato per debug in locale ed evitare traffico su S3
		/*
		String nomeFile = fileName.toString().replaceAll("/", "_");
		try(java.io.OutputStream outputStream = new java.io.FileOutputStream("D:\\report\\"+nomeFile)) {
			file.writeTo(outputStream);
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}*/
		log.info("INVIO DEL FILE SU S3 RIUSCITO");
		return amazonS3ClientService.getUrl(proprieta.getBusinessApi().getAmazonReportBucket(), fileName.toString());
	}

	/**
	 * Tiene traccia del report generato, nel caso di mensile sintetico destinato al cliente si salvano anche i costi per servizio per retrocompatibilita';
	 * al 20/02/2020 probabilmente sarà da deprecare e verrà eliminarto.
	 * 
	 * @param accountCMP
	 * @param divisioneCMP
	 * @param organizzazioneCMP
	 * @param data
	 * @param url
	 * @param rendiconto
	 * @param tipo
	 * @param elencoServizi Al 20/02/2020 viene ancora utilizzato per retrocompatibilita'; probabilmente sara' deprecato
	 * @param importo
	 */
	protected void registraReportEseguito(ListAccountsResponseSchemaAccounts accountCMP, ListDivisionsResponseSchemaDivisions divisioneCMP, ListOrganizationsResponseSchemaOrganizations organizzazioneCMP, LocalDate data, String url,
			SpRendiconto rendiconto, SpDTipoRendiconto tipo, double importo) {

		/*
		 * Se c'è gia' il record trovato ad inizio elaborazione e sono qui significa che
		 * il report e' stato aggiornato, evito di riscrivere un campo
		 */
		Timestamp dataModifica = new Timestamp(System.currentTimeMillis());
		if (rendiconto == null) {
			rendiconto = new SpRendiconto();
			rendiconto.setAnno(data.getYear());
			rendiconto.setMese(data.getMonthValue());
			rendiconto.setIdAccount(accountCMP.getUuid());
			rendiconto.setTipoRendiconto(tipo);
			rendiconto.setDataCreazione(dataModifica);
			rendiconto.setDescrizione("Rendiconto giornaliero del mese di " + data.getMonth().getDisplayName(TextStyle.FULL, Locale.ITALY).toUpperCase() + " per Account " + accountCMP.getName());
			rendiconto.setIdDivisione(divisioneCMP.getUuid());
			rendiconto.setIdOrganizzazione(organizzazioneCMP.getUuid());
			rendiconto.setNota("Rendiconto del mese di " + data.getMonth().getDisplayName(TextStyle.FULL, Locale.ITALY).toUpperCase() + " per Account " + accountCMP.getName());
			rendiconto.setDataRendicontoDa(Date.valueOf(data.withDayOfMonth(1)));
		}
		rendiconto.setDataModifica(dataModifica);
		rendiconto.setDataRendicontoA(Date.valueOf(data));
		try {
			rendiconto.setUrlFile(URLDecoder.decode(url, "UTF-8"));
		}
		catch (UnsupportedEncodingException e) {
			rendiconto.setUrlFile(url);
		}
		rendiconto.setImporto(importo);
		

		rendicontoService.salvaRendiconto(rendiconto);
	}
}
