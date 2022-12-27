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

import it.csi.nivola.nivolasp.domain.SpMailRichiesta;
import it.csi.nivola.nivolasp.domain.SpUser;

/**
 * Repository per la tabella sp_mail_richiesta
 */
public interface SPMailRichiestaRepository extends JpaRepository<SpMailRichiesta,Long> {
	
	List<SpMailRichiesta> findBySpUser(SpUser spUser);
	
	List<SpMailRichiesta> findByRefAccount(String refAccount);

}
