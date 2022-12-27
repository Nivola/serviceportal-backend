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
import org.springframework.data.jpa.repository.Query;

import it.csi.nivola.nivolasp.domain.SpDTipoPrezzo;

public interface SpDTipoPrezzoRepository extends JpaRepository<SpDTipoPrezzo, String> {
	
	@Query("select tipo from SpDTipoPrezzo tipo where tipo.dataCancellazione is null")
	public List<SpDTipoPrezzo> findDecodificaPrezziValidi();
	
	public Optional<SpDTipoPrezzo> findByCodice(String codice); 
	
}
