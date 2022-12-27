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
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.csi.nivola.nivolasp.domain.SpAccountWb;
@Repository
public interface SpAccountWbsRepository extends JpaRepository<SpAccountWb, String> {

	public Optional<List<SpAccountWb>> findByRefAccount(String refAccount);
	
	@Modifying
	@Query(value="delete from sp_account_wbs where ref_account = ?1 and id = ?2", nativeQuery=true)
	public void eliminaAssociazione (String accountId , String associazioneId);
}
