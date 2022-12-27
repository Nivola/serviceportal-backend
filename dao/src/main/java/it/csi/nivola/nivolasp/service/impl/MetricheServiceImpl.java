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
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.csi.nivola.nivolasp.domain.SpAccountAttributo;
import it.csi.nivola.nivolasp.domain.SpAccountInfocosto;
import it.csi.nivola.nivolasp.domain.SpDListino;
import it.csi.nivola.nivolasp.domain.SpDTipoPrezzo;
import it.csi.nivola.nivolasp.domain.SpDTipoServizio;
import it.csi.nivola.nivolasp.domain.SpMetricheDichiarate;
import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.repository.MetricheRepository;
import it.csi.nivola.nivolasp.repository.SpAccountAttributoRepository;
import it.csi.nivola.nivolasp.repository.SpAccountInfocostoRepository;
import it.csi.nivola.nivolasp.repository.SpCostoGiornoRepository;
import it.csi.nivola.nivolasp.repository.SpDListinoRepository;
import it.csi.nivola.nivolasp.repository.SpDTipoListinoRepository;
import it.csi.nivola.nivolasp.repository.SpDTipoPrezzoRepository;
import it.csi.nivola.nivolasp.repository.SpDTipoServizioRepository;
import it.csi.nivola.nivolasp.repository.SpMetricheDichiarateRepository;
import it.csi.nivola.nivolasp.service.MetricheService;
import it.csi.nivola.nivolasp.service.dto.AccountDTO;
import it.csi.nivola.nivolasp.service.dto.MetricaDTO;
import it.csi.nivola.nivolasp.service.dto.ValoreCostoListinoDTO;
import it.csi.nivola.nivolasp.service.mapper.MetricheMapper;

@Service("metricheService")
public class MetricheServiceImpl implements MetricheService {

	@Autowired
	MetricheRepository metricheRepository;

	@Autowired
	SpMetricheDichiarateRepository spMetricheDichiarateRepository;

	@Autowired
	MetricheMapper metricheMapper;
	
	@Autowired
	SpDTipoPrezzoRepository spDTipoPrezzoRepository;
	
	@Autowired
	SpAccountAttributoRepository spAccountAttributoRepository;
	
	@Autowired
	SpAccountInfocostoRepository spAccountInfocostoRepository;
	
	@Autowired
	SpDListinoRepository spDListinoRepository;
	
	@Autowired
	SpDTipoServizioRepository spDTipoServizioRepository;

	@Autowired
	SpCostoGiornoRepository spCostoGiornoRepository;
	
	@Autowired
	SpDTipoListinoRepository spDTipoListinoRepository;
	

	@Override
	@Cacheable("metrichePortal")
	public List<MetricaDTO> findAllMetriche() {
		return metricheRepository.findAll().stream().map((e) -> metricheMapper.toDTO(e)).collect(Collectors.toList());
	}

	@Override
	@Cacheable("metricheRegolePortal")
	public List<MetricaDTO> findCalcolate() {
		return metricheRepository.findCalcolate().stream().map((e) -> metricheMapper.toDTO(e)).collect(Collectors.toList());
	}

	@Override
	@Cacheable("metricheListino")
	public List<MetricaDTO> findListino() {
		return metricheRepository.findListino().stream().map((e) -> metricheMapper.toDTO(e)).collect(Collectors.toList());
	}

	@Override
	public List<SpMetricheDichiarate> findMetricheDichiarateAccount(String idAccount) {
		return spMetricheDichiarateRepository.findMetricheDichiarateAccount(idAccount);
	}

	@Override
	public void delete(String accountId, String idMetrica, BigInteger userId) throws BusinessException {
		SpMetricheDichiarate cercaMetrica = spMetricheDichiarateRepository.findOne(idMetrica);
		cercaMetrica.setDataCancellazione(new Timestamp(System.currentTimeMillis()));
		cercaMetrica.setIdAgente(userId);
		spMetricheDichiarateRepository.save(cercaMetrica);

	}

	
	@Override
	public void update(String accountId, ValoreCostoListinoDTO daAggiornare, BigInteger userId) throws BusinessException {
		SpMetricheDichiarate cercaMetrica = spMetricheDichiarateRepository.findOne(daAggiornare.getIdValore());
		if (daAggiornare.getDataA() != null && cercaMetrica.getDataInizioValidita().after(daAggiornare.getDataA()))
			throw new BusinessException("La data fine valitia' specificata e' precedente a quella di inizio");
		cercaMetrica.setDataFineValidita(Timestamp.from(daAggiornare.getDataA().toLocalDateTime().toInstant(ZoneOffset.UTC)));
		cercaMetrica.setIdAgente(userId);
		spMetricheDichiarateRepository.save(cercaMetrica);
	}

	@Override
	@Transactional
	public void inserisci(String idAccount, ValoreCostoListinoDTO costo, BigInteger idAgente) throws BusinessException {
		SpMetricheDichiarate vocePrecedente = cercaUltima(idAccount, costo.getNomeMetricaDefinizione(), true);
		Timestamp dataCreazione = new Timestamp(System.currentTimeMillis());
		if (vocePrecedente != null) {
			vocePrecedente.setDataFineValidita(Timestamp.valueOf(costo.getDataDa().toLocalDateTime().minusDays(1)));
			vocePrecedente.setDataModifica(dataCreazione);
			vocePrecedente.setIdAgente(idAgente);
			spMetricheDichiarateRepository.save(vocePrecedente);
		}
		SpMetricheDichiarate daInserire = new SpMetricheDichiarate();
		daInserire.setDataCreazione(dataCreazione);
		daInserire.setDataFineValidita(costo.getDataA());
		daInserire.setDataInizioValidita(costo.getDataDa());
		daInserire.setDataModifica(dataCreazione);
		daInserire.setIdAgente(idAgente);
		daInserire.setQta(costo.getQuantita());
		daInserire.setRefAccount(idAccount);
		daInserire.setSpDMetriche(metricheRepository.findByNome(costo.getNomeMetricaDefinizione()));
		spMetricheDichiarateRepository.save(daInserire);
		spMetricheDichiarateRepository.flush();
	}

	@Override
	public List<SpMetricheDichiarate> findMetricaConStorico(String idAccount, String nome) {
		return spMetricheDichiarateRepository.trovaStoricoOrdinato(idAccount, nome);
	}
	

	private SpMetricheDichiarate cercaUltima(String accountId, String name, boolean... inserimento) throws BusinessException {
		List<SpMetricheDichiarate> cercaMetricaElenco = spMetricheDichiarateRepository.trovaStoricoOrdinato(accountId, name);
		if (cercaMetricaElenco != null && cercaMetricaElenco.size() > 0) {
			return cercaMetricaElenco.get(0);
		}
		if (inserimento == null)
			throw new BusinessException("Voce di costo non trovata");
		return null;
	}

	@Override
	public List<SpDTipoPrezzo> decodificaTipoPrezzo() {
		return spDTipoPrezzoRepository.findDecodificaPrezziValidi();
	}

	@Override
	@Transactional
	public void inserisciAssociazioneAccountTipoPrezzo(AccountDTO account, BigInteger userId) {
		SpAccountAttributo attr = spAccountAttributoRepository.findByRefAccount(account.getUuid());
		if (attr == null) {
			attr = new SpAccountAttributo();
			attr.setDataCreazione(new Timestamp(System.currentTimeMillis()));
			attr.setRefAccount(account.getUuid());
			attr.setDivision(account.getDivisioneNome());
			attr.setManaged(""+account.getManaged());
			attr.setAcronimo(account.getAcronym());
			attr.setDataInizioConsumi(new Date (System.currentTimeMillis()));
		}
		attr.setDataModifica(new Timestamp(System.currentTimeMillis()));
		attr.setIdAgente(userId);
		attr.setNome(account.getName());
		attr.setAggiornaCostiGiorno(account.getAggiornaCostiGiorno());
		
		if (account.getDataInizioConsumi() != null)
			attr.setDataInizioConsumi(Date.valueOf(account.getDataInizioConsumi()));
		
		if (account.getDataFineConsumi() != null)
			attr.setDataFineConsumi(Date.valueOf(account.getDataFineConsumi()));
			
		SpDTipoPrezzo tipoPrezzo = spDTipoPrezzoRepository.findOne("PROD");
		if (StringUtils.isNotEmpty(account.getCodicePrezzo())) {
			tipoPrezzo = spDTipoPrezzoRepository.findOne(account.getCodicePrezzo());
		}
		attr.setSpDTipoPrezzo(tipoPrezzo);
		if (account.getBudgetMin() != null)
			attr.setBudgetMin(account.getBudgetMin());
		if (account.getBudgetMax() != null)
			attr.setBudgetMax(account.getBudgetMax());
		if (account.getDataFineConsumi() != null)
			attr.setDataFineConsumi(Date.valueOf(account.getDataFineConsumi()));
		attr.setPersonId(account.getPersonId());
		spAccountAttributoRepository.saveAndFlush(attr);
		
		SpAccountInfocosto infocostoPerBatch = spAccountInfocostoRepository.findInfocostoCorrente(account.getUuid());
		if (infocostoPerBatch == null) {
			infocostoPerBatch = new SpAccountInfocosto();
			infocostoPerBatch.setDataCreazione(new Timestamp(System.currentTimeMillis()));
			infocostoPerBatch.setDataInizioAssociazione(new Date(System.currentTimeMillis()));
			infocostoPerBatch.setIdAgente(userId);
			infocostoPerBatch.setUsaListinoSpecifico("N");
			infocostoPerBatch.setSpDListino(spDListinoRepository.listinoAttuale());
			infocostoPerBatch.setRefAccount(account.getUuid());
			infocostoPerBatch.setSpDTipoListino(spDTipoListinoRepository.findOne("CSI"));//FIXME chiave primaria di business su tabella originaria
			infocostoPerBatch.setSpDTipoPrezzo(tipoPrezzo);
			if (account.getIdListinoSpecifico() != null) {
				SpDListino listinoSpecifico = spDListinoRepository.findOne(account.getIdListinoSpecifico());
				infocostoPerBatch.setSpDListino(listinoSpecifico);
			}
			infocostoPerBatch.setSpDTipoPrezzo(tipoPrezzo);		
			infocostoPerBatch.setDataInizioAssociazione(new Date(System.currentTimeMillis()));
			infocostoPerBatch.setIdAgente(userId);
			spAccountInfocostoRepository.saveAndFlush(infocostoPerBatch);
		}
	}
	
	@Override
	public SpAccountAttributo reperisciCodicePrezzo(String account) {
		return spAccountAttributoRepository.findByRefAccount(account);
	}
	
	@Override
	public List<SpDTipoServizio> tuttiITipiServizio() {
		return spDTipoServizioRepository.findAll();
	}
}
