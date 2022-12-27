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
package it.csi.nivola.nivolasp.service;

import java.time.LocalDate;
import java.time.YearMonth;

import it.csi.nivola.nivolasp.service.dto.ExportCSV;

public interface GenerazioneCSVService {

	public StringBuilder creaCSVDettaglioGiornalieroAccount (String uuidAccount, LocalDate dataInizio, LocalDate dataFine);
	
	public ExportCSV creaCSVGiornalieroDivisioneSintetico (String uuidDivisione, LocalDate data);

	ExportCSV creaCSVGiornalieroOrganizzazioneSintetico(String uuidDivisione, LocalDate data);

	ExportCSV creaCSVGiornalieroDivisioneDettaglio(String uuidDivisione, LocalDate data);

	ExportCSV creaCSVGiornalieroOrganizzazioneDettaglio(String uuidDivisione, LocalDate data);

	ExportCSV creaCSVTotaliAccount(LocalDate dataInizio, LocalDate dataFine, String tipo);
	
	ExportCSV creaCSVTotaliAccountWbs(LocalDate dataInizio, LocalDate dataFine, String tipo);

	StringBuilder reportSinteticoAccountPeriodo(String uuidAccount, LocalDate dataPartenza, LocalDate dataFine);

	StringBuilder reportTipoListinoAccount();

	ExportCSV creaReportMensileSinteticoFormatoCSV(YearMonth annoMese, String uuidAccount);


}
