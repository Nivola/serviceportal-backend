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

import it.csi.nivola.nivolasp.domain.SpStatoRichiesta;

/**
 * Interfaccia per il servizio che gestisce le richieste "dispositive" verso la CMP
 */
public interface RichiesteService {

	SpStatoRichiesta salvaRichiesta (SpStatoRichiesta richiesta);
}
