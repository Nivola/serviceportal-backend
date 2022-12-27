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

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.csi.nivola.nivolasp.domain.SpDRemedyCatOperativa;

@Repository
public interface SpDRemedyCatOperativaRepository  extends JpaRepository<SpDRemedyCatOperativa, Long>{
	
	public SpDRemedyCatOperativa findByCodTecnologia (String codTecnologia);

}
