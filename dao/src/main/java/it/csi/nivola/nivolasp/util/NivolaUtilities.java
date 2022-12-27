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
package it.csi.nivola.nivolasp.util;

/**
 * Classe di utilita' generali
 */
public class NivolaUtilities {
	
	/**
	 * Converte un java.sql.Timestamp in java.time.LocalDateTime
	 * @param timestamp
	 * @return
	 */
	public static java.time.LocalDateTime timestampToLocalDateTime(java.sql.Timestamp timestamp) {
    	if (timestamp == null) return null;
    	return timestamp.toLocalDateTime();
    }
	
	/**
	 * Converte un java.sql.Date in un java.time.LocalDate
	 * @param date
	 * @return
	 */
	public static java.time.LocalDate sqlDateToLocalDate(java.sql.Date date) {
		if (date == null) return null;
		return date.toLocalDate();
	}
	
	public static java.sql.Date localDateToSqlDate(java.time.LocalDate date) {
		if (date == null) return null;
		return java.sql.Date.valueOf(date);
	}

}
