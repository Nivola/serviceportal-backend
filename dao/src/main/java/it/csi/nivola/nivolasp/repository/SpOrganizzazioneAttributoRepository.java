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
import org.springframework.stereotype.Repository;

import it.csi.nivola.nivolasp.domain.SpOrganizzazioneAttributo;

@Repository
public interface SpOrganizzazioneAttributoRepository extends JpaRepository<SpOrganizzazioneAttributo, String> {

	public List<SpOrganizzazioneAttributo> findByOrgId (String orgId);
	
	@Query("from SpOrganizzazioneAttributo where orgId = :orgId AND spDTipoAttributo.nome  = :nome")
	public SpOrganizzazioneAttributo trovaPerOrganizzazioneTipo (@Param("nome") String nome, @Param("orgId") String orgId);
}
