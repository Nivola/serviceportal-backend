/*-
 * ========================LICENSE_START=================================
 * Servizi di accesso dati
 * %%
 * Copyright (C) 2022 Regione Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | Regione Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.nivola.nivolasp.domain.SpDRemedyUrgenza;
import it.csi.nivola.nivolasp.domain.SpVRemedyUrgenzaForm;

@Repository
public interface SpDRemedyUrgenzaRepository  extends JpaRepository<SpDRemedyUrgenza, Long>{

	@Query("from SpVRemedyUrgenzaForm WHERE idImpatto = :idImpatto AND tipologia = :idTipologia AND :tenant BETWEEN livelloTenantDa AND livelloTentantA")
	public SpVRemedyUrgenzaForm trovaUrgenzaAccountGestioneLivelloTenantBetween (@Param("idImpatto") Long idImpatto, @Param("idTipologia") String idTipologia, @Param("tenant") Long tenant);
	
	public Optional<SpDRemedyUrgenza> findById (Long id);
}
