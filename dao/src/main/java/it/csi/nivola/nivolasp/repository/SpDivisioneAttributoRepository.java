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

import it.csi.nivola.nivolasp.domain.SpDivisioneAttributo;

public interface SpDivisioneAttributoRepository extends JpaRepository<SpDivisioneAttributo, String> {
	
	public List<SpDivisioneAttributo> findByDivId (String divId);
	
	@Query("from SpDivisioneAttributo where divId = :divId AND spDTipoAttributo.nome  = :nome")
	public SpDivisioneAttributo trovaPerDivisioneTipo (@Param("nome") String nome, @Param("divId") String divId);

}
