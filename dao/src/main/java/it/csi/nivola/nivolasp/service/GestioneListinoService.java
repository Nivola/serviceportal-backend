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
package it.csi.nivola.nivolasp.service;

import java.math.BigInteger;
import java.util.List;

import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.service.dto.CodiceEtichettaDescrizioneDTO;
import it.csi.nivola.nivolasp.service.dto.InfocostoDTO;
import it.csi.nivola.nivolasp.service.dto.InsertInfocostoDTO;

public interface GestioneListinoService {
	
	public List<InfocostoDTO> elencoInfocostoAccount (String account);
	
	public void inserisciInfocosto(InsertInfocostoDTO infocosto, BigInteger idAgente) throws BusinessException;

	public List<CodiceEtichettaDescrizioneDTO> elencoTipiDiListino();

	List<CodiceEtichettaDescrizioneDTO> elencoTipiPrezzo();

	public void modificaInfocosto(InsertInfocostoDTO richiesta, BigInteger bigInteger) throws BusinessException;

	public void cancellaInfocosto(Long id, BigInteger valueOf);

}
