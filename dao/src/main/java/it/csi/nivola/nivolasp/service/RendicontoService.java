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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.csi.nivola.nivolasp.domain.SpDTipoRendiconto;
import it.csi.nivola.nivolasp.domain.SpRendiconto;
import it.csi.nivola.nivolasp.service.dto.CostiStrutturaRaggruppatiServizioDTO;
import it.csi.nivola.nivolasp.service.dto.CostoAccountDTO;
import it.csi.nivola.nivolasp.service.dto.CostoDelMeseRigaDTO;
import it.csi.nivola.nivolasp.service.dto.InfoGraficoServizioDTO;
import it.csi.nivola.nivolasp.service.dto.RaggruppamentoCostiServizioDTO;
import it.csi.nivola.nivolasp.service.dto.RendicontoDTO;

public interface RendicontoService {

	Page<RendicontoDTO> findRendicontiByidAccount(String idAccount);

	Page<RendicontoDTO> findRendicontiByidDivisione(String idDivisione, String tipoRendiconto, Pageable pageable);

	Page<RendicontoDTO> findRendicontiByidOrganizzazione(String idOrganizzazione, Pageable pageable);


	Optional<RendicontoDTO> findRendicontoByIdAndIdAccount(String idAccount, Long id);

	Optional<RendicontoDTO> findRendicontoByIdAndIdDivisione(String idDivisione,Long id);

	Optional<RendicontoDTO> findRendicontoByIdAndIdOrganizzazione(String idOrganizzazione,Long id);

	SpRendiconto salvaRendiconto(SpRendiconto daSalvare);
	
	List<SpDTipoRendiconto> elencoTipi();
	
	List<SpRendiconto> findByIdAccount (String idAccount);
	
	List<SpRendiconto> findByIdDivisione (String idDivisione);
	
	List<CostoAccountDTO> aggregaCostiAccountPerDivisionePeriodo (String idDivisione, Date dataDa,  Date dataA);

	List<CostoDelMeseRigaDTO> aggregaCostiDivisionePerServizio(String idDivisione, Date data);
	
	SpRendiconto trovaReportGiornalieroEsistente(SpRendiconto filtro);

	List<RaggruppamentoCostiServizioDTO> costiAccount(String refAccount, Date da, Date a);

	List<RaggruppamentoCostiServizioDTO> costiDivisione(String refDivisione, Date da, Date a);

	List<RaggruppamentoCostiServizioDTO> costiOrganizzazione(String refOrganizzazione, Date da, Date a);

	BigDecimal costiGiornoAccount(String refAccount, Date giorno);

	BigDecimal costiGiornoDivisione(String refDivisione, Date giorno);

	BigDecimal costiGiornoOrganizzazione(String refOrganizzazione, Date giorno);

	List<InfoGraficoServizioDTO> costiGraficoAccount(String refAccount);
	
	List<InfoGraficoServizioDTO> costiGraficoDivisione(String refDivisione);
	
	List<InfoGraficoServizioDTO> costiGraficoOrganizzazione(String id);

	List<CostiStrutturaRaggruppatiServizioDTO> costiDivisionePerAccount(String refDivisione);
	
	List<CostiStrutturaRaggruppatiServizioDTO> costiOrganizzazionePerDivisione(String refOrganizzazione);
	
	public void cancellaGiorni (String uuid, LocalDate giornoPartenza);
	
	public void cancellaReport (String uuid, LocalDate giornoPartenza);

}
