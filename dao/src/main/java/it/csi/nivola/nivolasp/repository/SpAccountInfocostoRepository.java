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

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.nivola.nivolasp.domain.SpAccountInfocosto;
@Repository
public interface SpAccountInfocostoRepository extends JpaRepository<SpAccountInfocosto, Long> {
	@Query ("from it.csi.nivola.nivolasp.domain.SpAccountInfocosto where refAccount = :account and (current_date between dataInizioAssociazione and  COALESCE(dataFineAssociazione, '2999-12-31'))")
	public SpAccountInfocosto findInfocostoCorrente (@Param("account") String refAccount);
	
	public List<SpAccountInfocosto> findByRefAccount (String refAccount);
	
	public Optional<SpAccountInfocosto> findByRefAccountAndDataFineAssociazione(String refAccount, Date dataFineAssociazione);
}
