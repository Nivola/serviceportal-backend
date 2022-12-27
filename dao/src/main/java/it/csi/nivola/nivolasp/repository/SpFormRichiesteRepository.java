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
package it.csi.nivola.nivolasp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.csi.nivola.nivolasp.domain.SpFormRichieste;

@Repository
public interface SpFormRichiesteRepository  extends JpaRepository<SpFormRichieste, String>{
	
	public SpFormRichieste findByTicketId (String ticketId);
	
	public Optional<SpFormRichieste> findById(String id);
	
	public List<SpFormRichieste> findByRefAccount (String refAccount);
	
	@Query("from SpFormRichieste where ticketId is not null AND stato not in ('Chiuso', 'Annullato')")
	public Optional<List<SpFormRichieste>> elencoTicketInCorsoDiLavorazione();

}
