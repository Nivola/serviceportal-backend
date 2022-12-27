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

import it.csi.nivola.nivolasp.domain.SpAccountAttributo;
import it.csi.nivola.nivolasp.domain.SpDTipoPrezzo;
import it.csi.nivola.nivolasp.domain.SpDTipoServizio;
import it.csi.nivola.nivolasp.domain.SpMetricheDichiarate;
import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.service.dto.AccountDTO;
import it.csi.nivola.nivolasp.service.dto.MetricaDTO;
import it.csi.nivola.nivolasp.service.dto.ValoreCostoListinoDTO;


public interface MetricheService {


	List<MetricaDTO> findAllMetriche();
	List<MetricaDTO> findCalcolate();
	List<MetricaDTO> findListino();
	List<SpMetricheDichiarate> findMetricheDichiarateAccount(String idAccount);
	
	List<SpMetricheDichiarate> findMetricaConStorico(String idAccount, String nome);
	void delete (String accountId, String name, BigInteger userId) throws BusinessException;
	
	void update(String accountId, ValoreCostoListinoDTO daAggiornare, BigInteger  userId) throws BusinessException;
	void inserisci(String idAccount, ValoreCostoListinoDTO costo, BigInteger userId) throws BusinessException;
	
	List<SpDTipoPrezzo> decodificaTipoPrezzo ();
	
	void inserisciAssociazioneAccountTipoPrezzo(AccountDTO account, BigInteger userId);
	SpAccountAttributo reperisciCodicePrezzo(String account);
	List<SpDTipoServizio> tuttiITipiServizio();

}
