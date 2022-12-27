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

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.nivola.nivolasp.domain.SpDUrgenzaForm;

@Repository
public interface SpDUrgenzaFormRepository  extends JpaRepository<SpDUrgenzaForm, Long>{
	
	@Query("from SpDUrgenzaForm where valorePortale = :urgenza and :tenant between tenantDa and tenantA")
	public SpDUrgenzaForm trovaTenant (@Param("tenant") Integer tenant, @Param("urgenza") String urgenza);
}
