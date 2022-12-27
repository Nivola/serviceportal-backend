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

import it.csi.nivola.nivolasp.domain.SpUser;

public interface SpUserRepository extends JpaRepository<SpUser, Long> {
	
	Optional<SpUser> findOneByMatricolaCsi(String matricolaCsi);

    Optional<SpUser> findOneByCmpUsername(String cmpUsername);
    
	Optional<SpUser> findOneByUsername(String username);
    
    Optional<SpUser> findOneByCodiceFiscale(String codiceFiscale);

	SpUser findOneByUuidUtente(String id);
	
	Optional<List<SpUser>> findByCognomeStartsWithIgnoreCase (String cognome);
	
	@Query("select u from SpUser u JOIN u.spUserRuolos ruolo where u.cognome LIKE :cognome% AND ruolo.spRuolo.ruolo = 'TICKETOPERATOR'")
	Optional<List<SpUser>> trovaUtentiTicketOperator (@org.springframework.data.repository.query.Param("cognome") String cognome);
}
