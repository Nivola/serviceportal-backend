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

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.csi.nivola.nivolasp.domain.SpLogAzione;
import it.csi.nivola.nivolasp.domain.SpUser;

/**
 * Spring Data JPA repository for the SpLogAccessoUserRepository entity.
 */
public interface SpLogAzioneRepository extends JpaRepository<SpLogAzione,Long> {
	
	public List<SpLogAzione> findByAccount(String account);

	public List<SpLogAzione> findByDataAzioneBetweenAndAccountAndSpUser(Timestamp from, Timestamp to, String account, SpUser spUser);
	

}
