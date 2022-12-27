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

import it.csi.nivola.nivolasp.domain.SpDReadTheDocsMapping;

/**
 * Repository per la tabella sp_read_the_docs
 */
public interface SpReadTheDocsMappingRepository extends JpaRepository<SpDReadTheDocsMapping,Integer> {
	
	public SpDReadTheDocsMapping findByRouteLabel(String routeLabel);
	
	public SpDReadTheDocsMapping findByRouteLabelAndLingua(String routeLabel, String lingua);
	
	@Query("SELECT d FROM SpDReadTheDocsMapping d WHERE :lingua is null OR d.lingua = :lingua")
	public List<SpDReadTheDocsMapping> findByLingua(@Param("lingua") String lingua);

}
