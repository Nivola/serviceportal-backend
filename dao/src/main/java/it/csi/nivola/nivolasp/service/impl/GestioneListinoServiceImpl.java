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
package it.csi.nivola.nivolasp.service.impl;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.nivola.nivolasp.domain.SpAccountInfocosto;
import it.csi.nivola.nivolasp.domain.SpDListino;
import it.csi.nivola.nivolasp.domain.SpDTipoListino;
import it.csi.nivola.nivolasp.domain.SpDTipoPrezzo;
import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.repository.SpAccountInfocostoRepository;
import it.csi.nivola.nivolasp.repository.SpDListinoRepository;
import it.csi.nivola.nivolasp.repository.SpDTipoListinoRepository;
import it.csi.nivola.nivolasp.repository.SpDTipoPrezzoRepository;
import it.csi.nivola.nivolasp.service.GestioneListinoService;
import it.csi.nivola.nivolasp.service.dto.CodiceEtichettaDescrizioneDTO;
import it.csi.nivola.nivolasp.service.dto.InfocostoDTO;
import it.csi.nivola.nivolasp.service.dto.InsertInfocostoDTO;
import it.csi.nivola.nivolasp.service.mapper.ListinoMapper;
import it.csi.nivola.nivolasp.util.NivolaUtilities;
@Service("gestioneListinoService")
public class GestioneListinoServiceImpl implements GestioneListinoService {
	
	@Autowired
	SpAccountInfocostoRepository spAccountInfocostoRepository;
	
	@Autowired
	SpDListinoRepository spDListinoRepository;
	
	@Autowired
	SpDTipoPrezzoRepository spDTipoPrezzoRepository;
	
	@Autowired
	SpDTipoListinoRepository spDTipoListinoRepository;
	
	@Autowired
	ListinoMapper listinoMapper;

	@Override
	public List<InfocostoDTO> elencoInfocostoAccount(String account) {
		return listinoMapper.toInfocostoList(spAccountInfocostoRepository.findByRefAccount(account));
	}

	@Override
	public void inserisciInfocosto(InsertInfocostoDTO infocosto, BigInteger idAgente) throws BusinessException {
		
		if (StringUtils.isNotEmpty(infocosto.getUsaListinoSpecifico()) && !StringUtils.equalsAnyIgnoreCase(infocosto.getUsaListinoSpecifico(), "S", "N")) {
			throw new BusinessException("Valore del campo usa listino specifico " + infocosto.getUsaListinoSpecifico() + " non valido");
		}
		
		if (infocosto.getDataInizioAssociazione() == null)
			throw new BusinessException("Data inizio associazione obbligatoria");
		
		if (StringUtils.isEmpty(infocosto.getRefAccount()))
			throw new BusinessException("Ref Account obbligatorio");
		
		SpDListino listinoTrovato = null;
		if (infocosto.getIdListino() != null)
			listinoTrovato = spDListinoRepository.findOne(infocosto.getIdListino());
		else
			listinoTrovato = spDListinoRepository.listinoAttuale();

		Optional<SpDTipoPrezzo> spDTipoPrezzoTrovato = spDTipoPrezzoRepository.findByCodice(infocosto.getTipoPrezzoCodice());
		
		Optional<SpDTipoListino> spDTipoListinoTrovato = spDTipoListinoRepository.findByCodice(infocosto.getTipoListinoCodice());
		
		SpAccountInfocosto daInserire = new SpAccountInfocosto();
		daInserire.setDataCreazione(new Timestamp(System.currentTimeMillis()));
		if (infocosto.getDataFineAssociazione() != null)
			daInserire.setDataFineAssociazione(Date.valueOf(infocosto.getDataFineAssociazione()));
		daInserire.setDataInizioAssociazione(Date.valueOf(infocosto.getDataInizioAssociazione()));
		daInserire.setIdAgente(idAgente);
		daInserire.setRefAccount(infocosto.getRefAccount());
		daInserire.setUsaListinoSpecifico(infocosto.getUsaListinoSpecifico());
		
		daInserire.setSpDListino(listinoTrovato);
		daInserire.setSpDTipoPrezzo(spDTipoPrezzoTrovato.orElseThrow(() -> new BusinessException("Tipo prezzo con codice " + infocosto.getTipoPrezzoCodice() + " non trovato")));
		daInserire.setSpDTipoListino(spDTipoListinoTrovato.orElseThrow(() -> new BusinessException("Tipo listino con codice " + infocosto.getTipoListinoCodice() + " non trovato")));
		
		SpAccountInfocosto infocostoPrecedente = spAccountInfocostoRepository.findInfocostoCorrente(infocosto.getRefAccount());
		
		if (infocostoPrecedente != null) {
			infocostoPrecedente.setDataFineAssociazione(Date.valueOf(infocosto.getDataInizioAssociazione().minusDays(1)));
			spAccountInfocostoRepository.saveAndFlush(infocostoPrecedente);
		}
		spAccountInfocostoRepository.saveAndFlush(daInserire);
	}

	/**
	 * Restituisce i tipi di listino (CSI, CLIENTE...)
	 */
	@Override
	public List<CodiceEtichettaDescrizioneDTO> elencoTipiDiListino() {
		ArrayList<CodiceEtichettaDescrizioneDTO> elencoTipi = new ArrayList<CodiceEtichettaDescrizioneDTO>();
		spDTipoListinoRepository.findAll().forEach(t -> {
			elencoTipi.add(new CodiceEtichettaDescrizioneDTO(t.getCodice(), t.getDescrizione(), ""));
		});
		return elencoTipi;
	}
	
	/**
	 * Restituisce i tipi di prezzo (ESE, NC, ORD , PROD...)
	 */
	@Override
	public List<CodiceEtichettaDescrizioneDTO> elencoTipiPrezzo() {
		ArrayList<CodiceEtichettaDescrizioneDTO> elencoTipi = new ArrayList<CodiceEtichettaDescrizioneDTO>();
		spDTipoPrezzoRepository.findAll().forEach(t -> {
			elencoTipi.add(new CodiceEtichettaDescrizioneDTO(t.getCodice(), t.getDescrizione(), ""));
		});
		return elencoTipi;
	}

	/**
	 * Aggiorna un record account infocosto
	 */
	@Override
	public void modificaInfocosto(InsertInfocostoDTO richiesta, BigInteger idAgente) throws BusinessException {
		SpAccountInfocosto infocostoEsistente = spAccountInfocostoRepository.findOne(richiesta.getId());
		if (infocostoEsistente == null)
			throw new BusinessException("Infocosto con id " + richiesta.getId() + " non trovato");
		
		infocostoEsistente.setDataFineAssociazione(NivolaUtilities.localDateToSqlDate(richiesta.getDataFineAssociazione()));
		infocostoEsistente.setIdAgente(idAgente);
		
		Optional<SpDTipoPrezzo> spDTipoPrezzoTrovato = spDTipoPrezzoRepository.findByCodice(richiesta.getTipoPrezzoCodice());
		
		Optional<SpDTipoListino> spDTipoListinoTrovato = spDTipoListinoRepository.findByCodice(richiesta.getTipoListinoCodice());
		
		SpDListino listinoTrovato = null;
		if (richiesta.getIdListino() != null)
			listinoTrovato = spDListinoRepository.findOne(richiesta.getIdListino());
		else
			listinoTrovato = spDListinoRepository.listinoAttuale();

		
		infocostoEsistente.setDataCreazione(new Timestamp(System.currentTimeMillis()));
		if (richiesta.getDataFineAssociazione() != null)
			infocostoEsistente.setDataFineAssociazione(Date.valueOf(richiesta.getDataFineAssociazione()));
		infocostoEsistente.setDataInizioAssociazione(Date.valueOf(richiesta.getDataInizioAssociazione()));
		infocostoEsistente.setIdAgente(idAgente);
		infocostoEsistente.setUsaListinoSpecifico(richiesta.getUsaListinoSpecifico());
		
		infocostoEsistente.setSpDListino(listinoTrovato);
		infocostoEsistente.setSpDTipoPrezzo(spDTipoPrezzoTrovato.orElseThrow(() -> new BusinessException("Tipo prezzo con codice " + richiesta.getTipoPrezzoCodice() + " non trovato")));
		infocostoEsistente.setSpDTipoListino(spDTipoListinoTrovato.orElseThrow(() -> new BusinessException("Tipo listino con codice " + richiesta.getTipoListinoCodice() + " non trovato")));
		
		
		spAccountInfocostoRepository.saveAndFlush(infocostoEsistente);
	}

	@Override
	@Transactional
	public void cancellaInfocosto(Long id, BigInteger idAgente) {
		SpAccountInfocosto infocostoDaCancellare = spAccountInfocostoRepository.findOne(id);
		Optional<SpAccountInfocosto> infocostoPrecedente = spAccountInfocostoRepository.findByRefAccountAndDataFineAssociazione(infocostoDaCancellare.getRefAccount(), Date.valueOf(infocostoDaCancellare.getDataInizioAssociazione().toLocalDate().minusDays(1))); //select con data fine associazione = da cancellare con data inizio -1 giorno
		
		infocostoPrecedente.ifPresent(costo -> {
			costo.setDataFineAssociazione(null); 
			costo.setIdAgente(idAgente);
			spAccountInfocostoRepository.save(costo);
		});
		
		spAccountInfocostoRepository.delete(infocostoDaCancellare);
	}

}
