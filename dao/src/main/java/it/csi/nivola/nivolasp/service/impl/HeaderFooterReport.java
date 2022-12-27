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

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;

public class HeaderFooterReport extends PdfPageEventHelper {
	protected Image headerImg;
	protected Image footerImg;
	protected PdfPTable footerText;

	public HeaderFooterReport() {
	}

	public HeaderFooterReport(String imgPath) {
		try {
			headerImg = Image.getInstance(imgPath+"nivola.png");

			headerImg.scaleAbsoluteWidth(240);
//			footerImg = Image.getInstance(imgPath+"breakLineReport.png");
//			footerImg.scaleAbsoluteWidth(651);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void onEndPage(PdfWriter writer, Document document) {
		try {
			Rectangle page = document.getPageSize();
			PdfPTable head = new PdfPTable(1);

			// Aggiunge una linea vuota
			PdfPCell cellH= new PdfPCell();
			cellH.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellH.setVerticalAlignment(Element.ALIGN_BOTTOM);
			cellH.setBorder(Rectangle.NO_BORDER);
			cellH.setImage(headerImg);
			
			head.addCell(cellH);

			head.setTotalWidth(240);
			head.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			head.writeSelectedRows(
					0,
					-1,
					document.leftMargin()+ 200,
					page.getHeight() - document.topMargin()
							+ head.getTotalHeight(), writer.getDirectContent());
			
			PdfPTable foot = new PdfPTable(1);

//			PdfPCell cellF= new PdfPCell(footerImg);
//			cellF.setHorizontalAlignment(Element.ALIGN_CENTER);
//			cellF.setBorder(Rectangle.NO_BORDER);
//			cellF.setImage(footerImg);
//			foot.addCell(cellF);
			
			PdfPCell cellF2 = new PdfPCell();
			cellF2.setHorizontalAlignment(Element.ALIGN_LEFT);
			cellF2.setBorder(Rectangle.NO_BORDER);
			Paragraph par2 = new Paragraph("Consorzio per il Sistema Informativo", ITextFont.SMALL_FONT_GRAY_BOLD);
			cellF2.addElement(par2);

			Paragraph par3 = new Paragraph("Corso Unione Sovietica, 216   10134 Torino  tel. +390113168111  fax +39011 316 82 12  P.Iva 01995120019", ITextFont.SMALL_FONT_GRAY);
			cellF2.addElement(par3);

			Phrase ph1 = new Phrase("Posta Elettronica Certificata  ", ITextFont.SMALL_FONT_GRAY);
			Paragraph par4 = new Paragraph(ph1);

			Phrase ph2 = new Phrase("protocollo@cert.csi.it  ", ITextFont.SMALL_FONT_GRAY_BOLD);
			par4.add(ph2);
			
			Phrase ph3 = new Phrase("www.csipiemonte.it", ITextFont.SMALL_FONT_BLUE);
			par4.add(ph3);
			
			cellF2.addElement(par4);

			foot.addCell(cellF2);
			
			
			foot.setTotalWidth(page.getWidth() - document.leftMargin()
					- document.rightMargin());
			foot.writeSelectedRows(0, -1, document.leftMargin(),
					document.bottomMargin(), writer.getDirectContent());
			
		} catch (Exception e) {
			throw new ExceptionConverter(e);
		}
	}

}

