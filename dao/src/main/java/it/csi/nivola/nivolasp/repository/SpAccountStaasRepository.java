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
import org.springframework.stereotype.Repository;

import it.csi.nivola.nivolasp.domain.SpAccountStaas;
@Repository
public interface SpAccountStaasRepository extends JpaRepository<SpAccountStaas, String> {

	public List<SpAccountStaas> findByRefAccount(String refAccount);
}
