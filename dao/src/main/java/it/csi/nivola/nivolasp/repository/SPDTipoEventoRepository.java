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

import it.csi.nivola.nivolasp.domain.SpDTipoEvento;

/**
 * Repository per la tabella sp_d_tipo_evento
 */
public interface SPDTipoEventoRepository extends JpaRepository<SpDTipoEvento,Long> {
	
	public SpDTipoEvento findByCodiceEvento(String codiceEvento);

}
