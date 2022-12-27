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

import org.springframework.stereotype.Service;

import it.csi.nivola.nivolasp.domain.SpStatoRichiesta;
import it.csi.nivola.nivolasp.repository.SpStatoRichiestaRepository;
import it.csi.nivola.nivolasp.service.RichiesteService;

@Service
public class RichiesteServiceImpl implements RichiesteService {
	
	private final SpStatoRichiestaRepository spStatoRichiestaRepository;
	
	public RichiesteServiceImpl(SpStatoRichiestaRepository spStatoRichiestaRepository) {
		this.spStatoRichiestaRepository = spStatoRichiestaRepository;
	}

	@Override
	public SpStatoRichiesta salvaRichiesta(SpStatoRichiesta richiesta) {
		return spStatoRichiestaRepository.save(richiesta);
	}

}
