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

import java.awt.Color;

import com.lowagie.text.Font;

public class ITextFont {
	public static final Font TITLE_FONT;
	public static final Font TITLE_BOLD;
	public static final Font TITLE_14_FONT;
	public static final Font TITLE_14_BOLD;
	public static final Font TITLE_12_BOLD;
	public static final Font REGULAR_FONT;
	public static final Font REGULAR_FONT_STRIKED;
	public static final Font REGULAR_BOLD;
	public static final Font REGULAR_ITALIC;
	public static final Font REGULAR_BOLD_ITALIC;
	public static final Font REGULAR_UNDERLINE;
	public static final Font SMALL_FONT;
	public static final Font SMALL_BOLD;
	public static final Font SMALL_ITALIC;
	public static final Font SMALL_FONT_BLUE;
	public static final Font SMALL_FONT_GRAY;
	public static final Font SMALL_FONT_GRAY_BOLD;
	public static final Font SMALL_FONT_STRIKED;
	
	static {
		TITLE_FONT = new Font(Font.TIMES_ROMAN, 18,Font.NORMAL);
		TITLE_BOLD = new Font(Font.TIMES_ROMAN, 18,Font.BOLD);
		
		TITLE_14_FONT = new Font(Font.TIMES_ROMAN, 14,Font.NORMAL);
		
		TITLE_14_BOLD = new Font(Font.TIMES_ROMAN, 14,Font.BOLD);
		
		TITLE_12_BOLD = new Font(Font.TIMES_ROMAN, 12,Font.BOLD);
		
		REGULAR_FONT = new Font(Font.TIMES_ROMAN, 10,Font.NORMAL);
		REGULAR_FONT_STRIKED = new Font(Font.TIMES_ROMAN, 10,Font.STRIKETHRU);
		REGULAR_BOLD = new Font(Font.TIMES_ROMAN, 10,Font.BOLD);
		
		REGULAR_ITALIC = new Font(Font.TIMES_ROMAN, 10,Font.ITALIC);
		REGULAR_BOLD_ITALIC = new Font(Font.TIMES_ROMAN, 10,Font.BOLDITALIC);
		
		REGULAR_UNDERLINE = new Font(Font.TIMES_ROMAN, 10,Font.UNDERLINE);
		SMALL_FONT = new Font(Font.TIMES_ROMAN, 7, Font.NORMAL);
		
		SMALL_FONT_STRIKED = new Font(Font.TIMES_ROMAN, 7, Font.STRIKETHRU);
		
		SMALL_BOLD = new Font(Font.TIMES_ROMAN, 7, Font.BOLD);
		SMALL_ITALIC = new Font(Font.TIMES_ROMAN, 7, Font.BOLD);
		
		SMALL_FONT_BLUE = new Font(Font.TIMES_ROMAN, 7, Font.NORMAL);
		SMALL_FONT_BLUE.setColor(Color.BLUE);

		SMALL_FONT_GRAY = new Font(Font.TIMES_ROMAN, 7, Font.NORMAL);
		SMALL_FONT_GRAY.setColor(Color.GRAY);

		SMALL_FONT_GRAY_BOLD = new Font(Font.TIMES_ROMAN, 7, Font.BOLD);
		SMALL_FONT_GRAY_BOLD.setColor(Color.GRAY);

	}
	
	public ITextFont (String mock) {
		
	}
}


