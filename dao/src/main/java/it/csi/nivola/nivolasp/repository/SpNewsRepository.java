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

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.csi.nivola.nivolasp.domain.SpNews;
import it.csi.nivola.nivolasp.domain.SpStatoNew;

public interface SpNewsRepository extends JpaRepository<SpNews, Long> {
	
	@Query("select n from SpNews n left join n.spNewsUsers nu where nu.spUser.id = :idUtente OR nu.spUser.id is null")
	public List<SpNews> findNewsPerUtenteDestinatario(@Param("idUtente") Long idUtente);
	
	@Query("select n from SpStatoNew n where n.stato = :stato")
	public SpStatoNew findStatoNotizia(@Param("stato") String stato);
	
	
	@Query("select n from SpNews n where n.dataPubblicazioneFine is null or n.dataPubblicazioneFine >= current_date")
	public List<SpNews> findNonScadute();
	

//	public List<SpNews> findAllOrderByDataPubblicazioneInizio();
}
