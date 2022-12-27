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
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.csi.nivola.nivolasp.domain.SpUserRuolo;

public interface SpUserRuoloRepository extends JpaRepository<SpUserRuolo, Long> {

	@Modifying
	@Query(value="update sp_user_ruolo ruolo set ruolo.data_cancellazione = CURRENT_TIMESTAMP where ruolo.user_id = ?1 and ruolo.ruolo = ?2", nativeQuery=true)
	void eliminaAssociazione(Long id, String ruolo);

}
