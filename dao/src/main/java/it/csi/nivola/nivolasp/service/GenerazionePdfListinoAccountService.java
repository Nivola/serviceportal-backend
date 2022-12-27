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


import com.lowagie.text.DocumentException;

import it.csi.nivola.nivolasp.service.dto.ListinoDTO;
import it.csi.nivola.nivolasp.service.dto.ReportRendicontoResponse;

public interface GenerazionePdfListinoAccountService {
	
	public ReportRendicontoResponse generaPdf(ListinoDTO listino) throws DocumentException;

}
