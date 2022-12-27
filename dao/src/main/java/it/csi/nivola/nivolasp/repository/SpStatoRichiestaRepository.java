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

import it.csi.nivola.nivolasp.domain.SpStatoRichiesta;

/**
 * Spring Data JPA repository for the SpStatoRichiesta entity.
 */
public interface SpStatoRichiestaRepository extends JpaRepository<SpStatoRichiesta,Long> {

}
