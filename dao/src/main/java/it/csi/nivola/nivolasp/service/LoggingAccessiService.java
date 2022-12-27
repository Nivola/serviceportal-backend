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

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpResponse;

import it.csi.nivola.nivolasp.domain.SpLogAccessoShib;
import it.csi.nivola.nivolasp.domain.SpLogAccessoUser;
import it.csi.nivola.nivolasp.domain.SpLogAzione;
import it.csi.nivola.nivolasp.domain.SpLogInvocazioniCmp;
import it.csi.nivola.nivolasp.domain.SpUser;
import it.csi.nivola.nivolasp.service.dto.ExportCSV;
import it.csi.nivola.nivolasp.service.dto.LogAzioneDTO;

/**
 * Interfaccia per il servizio di logging degli accessi
 */
public interface LoggingAccessiService {


    SpLogAccessoShib save(SpLogAccessoShib accesso);
    
    SpLogAccessoUser logAccesso(SpUser utente);


    Page<SpLogAccessoShib> findAll(Pageable pageable);


    SpLogAccessoShib findOne(Long id);

    void delete(Long id);


	SpLogInvocazioniCmp logInvocazioneCmp(HttpRequest request, byte[] body, ClientHttpResponse response, SpUser userId);

	SpLogAzione logAzione(SpLogAzione azione);

	List<LogAzioneDTO> elencoPerAccount(String accountName);

	List<LogAzioneDTO> elencoLogAzioneCompleto();
	
	public ExportCSV csvPerAccount(LogAzioneDTO filtro);
}
