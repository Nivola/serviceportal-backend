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
import org.springframework.stereotype.Repository;

import it.csi.nivola.nivolasp.domain.SpTConsumiStaas;
import it.csi.nivola.nivolasp.repository.query.DistinctShares;

@Repository
public interface SpTConsumiStaaRepository extends JpaRepository<SpTConsumiStaas, String>{
	
	public SpTConsumiStaas findByEvs (String evs);
	
	public SpTConsumiStaas findByFilesystem (String filesystem);
	
	@Query("select distinct new it.csi.nivola.nivolasp.repository.query.DistinctShares(evs, filesystem, share) from SpTConsumiStaas")
	public List<DistinctShares> elencoShares ();

}
