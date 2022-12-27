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
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.nivola.nivolasp.domain.SpAccountInfocosto;
import it.csi.nivola.nivolasp.domain.SpAccountStaas;
import it.csi.nivola.nivolasp.domain.SpDListino;
import it.csi.nivola.nivolasp.domain.SpDListinoDettaglio;
import it.csi.nivola.nivolasp.domain.SpDListinoImporto;
import it.csi.nivola.nivolasp.domain.SpDMetriche;
import it.csi.nivola.nivolasp.domain.SpDTipoListino;
import it.csi.nivola.nivolasp.domain.SpDTipoPrezzo;
import it.csi.nivola.nivolasp.domain.SpUser;
import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.integration.rest.api.service.AuthorityApi;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetAccountResponseSchema;
import it.csi.nivola.nivolasp.repository.MetricheRepository;
import it.csi.nivola.nivolasp.repository.SpAccountInfocostoRepository;
import it.csi.nivola.nivolasp.repository.SpAccountStaasRepository;
import it.csi.nivola.nivolasp.repository.SpDListinoDettaglioRepository;
import it.csi.nivola.nivolasp.repository.SpDListinoImportoRepository;
import it.csi.nivola.nivolasp.repository.SpDListinoRepository;
import it.csi.nivola.nivolasp.repository.SpDTipoListinoRepository;
import it.csi.nivola.nivolasp.repository.SpDTipoPrezzoRepository;
import it.csi.nivola.nivolasp.repository.SpTConsumiStaaRepository;
import it.csi.nivola.nivolasp.repository.query.DistinctShares;
import it.csi.nivola.nivolasp.service.dto.AssociaStaasAccount;
import it.csi.nivola.nivolasp.service.dto.CodiceEtichettaDescrizioneDTO;
import it.csi.nivola.nivolasp.service.dto.ExportCSV;
import it.csi.nivola.nivolasp.service.dto.ListinoDTO;
import it.csi.nivola.nivolasp.service.dto.ListinoDettaglioDTO;
import it.csi.nivola.nivolasp.service.dto.ListinoImportoDto;
import it.csi.nivola.nivolasp.service.dto.ListinoTipoPrezzoDTO;
import it.csi.nivola.nivolasp.service.dto.MetricaDTO;
import it.csi.nivola.nivolasp.service.mapper.ListinoMapper;
import it.csi.nivola.nivolasp.service.mapper.MetricheMapper;
import it.csi.nivola.nivolasp.util.NivolaUtilities;

@Service
@Transactional
public class ListinoService {
	
	@Autowired
	SpDListinoRepository spDListinoRepository;
	
	@Autowired
	SpDListinoDettaglioRepository spDListinoDettaglioRepository;
	
	@Autowired
	SpDListinoImportoRepository spDListinoImportoRepository;
	
	@Autowired
	SpDTipoPrezzoRepository spDTipoPrezzoRepository;
	
	@Autowired
	MetricheRepository metricheRepository;
	
	@Autowired
	ListinoMapper listinoMapper;
	
	@Autowired
	SpAccountStaasRepository spAccountStaasRepository;
	
	@Autowired
	SpTConsumiStaaRepository spTConsumiStaaRepository;
	
	@Autowired
	SpAccountInfocostoRepository spAccountInfocostoRepository;
	
	@Autowired
	AuthorityApi authorityApi;
	
	@Autowired
	SpDTipoListinoRepository spDTipoListinoRepository;
	
	@Autowired
	MetricheMapper metricheMapper;
	
	private static final String SEP = ";";
	
	private static final String N_LINE = "\r\n";
	
	private DecimalFormat df = null;
	
	SimpleDateFormat formatoGiorno = new SimpleDateFormat("dd/MM/yyyy");
	
	@PostConstruct
	public void inizializza () {
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.ITALIAN);
		otherSymbols.setDecimalSeparator(',');
		df = new DecimalFormat("0.00", otherSymbols);
	}
	
	/**
	 * Elenco dei listini
	 * @return
	 */
	public List<ListinoDTO> elencoListini () {
		return listinoMapper.spDListinoToListinoDtoElenco(spDListinoRepository.findAll());
	}
	
	/**
	 * Dettaglio listino
	 * @param id
	 * @return
	 */
	public ListinoDTO dettaglioListino (String id) throws BusinessException {
		SpDListino listinoRichiesto = spDListinoRepository.findOne(id);
		
		if (listinoRichiesto == null) {
			throw new BusinessException("Listino con id " + id + " non trovato");
		}
		
		ListinoDTO listinoConDettaglio = listinoMapper.spDListinoToListinoDto(listinoRichiesto);
		
		List<ListinoDettaglioDTO> elencoDettagli = listinoMapper.spDListinoDettaglioToListinoDettaglioDtoElenco(listinoRichiesto.getSpDListinoDettaglios());
		
		listinoConDettaglio.setElencoDettagli(elencoDettagli);
		return listinoConDettaglio;
	}
	
	public List<CodiceEtichettaDescrizioneDTO> elencoTipiListino () {
		return spDTipoListinoRepository.findAll().stream().map(t -> new CodiceEtichettaDescrizioneDTO(t.getCodice(), t.getCodice(), t.getDescrizione())).collect(Collectors.toList());
	}
	
	public List<MetricaDTO> elencoMetricheApplicabiliAlListino () {
		return metricheMapper.toDTOList(metricheRepository.findListinoECmpOrdinate());
	}
	
	/**
	 * Listino specifico di un account
	 * @return
	 */
	public ListinoDTO trovaListinoAccount (String refAccount) {
		SpDListino listinoRichiesto = null;
		String tipo = "ORD";
		SpAccountInfocosto listinoSpcifico = spAccountInfocostoRepository.findInfocostoCorrente(refAccount);
		if (listinoSpcifico != null && listinoSpcifico.getSpDListino() != null) {
			tipo = listinoSpcifico.getSpDTipoPrezzo().getCodice();
			listinoRichiesto = listinoSpcifico.getSpDListino();
		}else {
			listinoRichiesto = spDListinoRepository.listinoAttuale();
		}
		List<ListinoDettaglioDTO> elencoDettagli = listinoMapper.spDListinoDettaglioToListinoDettaglioDtoElenco(listinoRichiesto.getSpDListinoDettaglios());
		final String tipoFinal = tipo;
		ListinoDTO listinoConDettaglio = listinoMapper.spDListinoToListinoDto(listinoRichiesto);
		elencoDettagli.stream().forEach(d -> d.setElencoPrezzo(d.getElencoPrezzo().stream().filter(p -> p.getCodice().equals(tipoFinal)).collect(Collectors.toList())));
		listinoConDettaglio.setElencoDettagli(elencoDettagli);
		return listinoConDettaglio;
		
	}
	public ListinoDTO dettaglioListinoAttuale () {
		SpDListino listinoRichiesto = spDListinoRepository.listinoAttuale();
		ListinoDTO listinoConDettaglio = listinoMapper.spDListinoToListinoDto(listinoRichiesto);
		
		List<ListinoDettaglioDTO> elencoDettagli = listinoMapper.spDListinoDettaglioToListinoDettaglioDtoElenco(listinoRichiesto.getSpDListinoDettaglios());
		
		listinoConDettaglio.setElencoDettagli(elencoDettagli);
		return listinoConDettaglio;
	}
	
	
	/**
	 * Assocazione volume
	 * @param associazione
	 * @return
	 */
	@Transactional
	public String inserisciAssociazioneAccountStaas (AssociaStaasAccount associazione, BigInteger idAgente) {
		SpAccountStaas entity = new SpAccountStaas();
		entity.setDataCreazione(new Timestamp(System.currentTimeMillis()));
		entity.setDataFineAssociazione(associazione.getDataFineAssociazione());
		entity.setDataInizioAssociazione(associazione.getDataInizioAssociazione());
		entity.setDataModifica(new Timestamp(System.currentTimeMillis()));
		entity.setEvs(associazione.getEvs());
		entity.setFilesystem(associazione.getFilesystem());
		entity.setIdAgente(idAgente);
		entity.setRefAccount(associazione.getRefAccount());
		entity.setShare(associazione.getShare());
		entity.setTipologia(associazione.getTipologia());;
		entity = spAccountStaasRepository.saveAndFlush(entity);
		return entity.getId();
	}
	
	/**
	 * Elenco shares disponibili per l'associazione ad un account
	 * @param accountId
	 * @return
	 */
	public List<DistinctShares> elencoShares (String accountId) {
		
		List<DistinctShares> elencoTutte = spTConsumiStaaRepository.elencoShares();
		List<SpAccountStaas> elencoAssociate = spAccountStaasRepository.findByRefAccount(accountId);
		return elencoTutte.stream().filter(t -> eliminaAssociate(t, elencoAssociate)).collect(Collectors.toList());
	}
	
	/**
	 * Elenco shares associati ad un account
	 * @param accountId
	 * @return
	 */
	public List<DistinctShares> elencoSharesAssociati (String accountId) {
		
		List<SpAccountStaas> elencoAssociate = spAccountStaasRepository.findByRefAccount(accountId);
		
		return listinoMapper.toDistincts(elencoAssociate);
	}

	/*
	 * Eliminazione associazione
	 */
	private boolean eliminaAssociate(DistinctShares t, List<SpAccountStaas> elencoAssociate) {
		return !(elencoAssociate.stream().anyMatch(a -> 
			(a.getEvs().equals(t.getEvs()) && a.getFilesystem().equals(t.getFilesystem()) && a.getShare().equals(t.getShare()))
		));
	}
	
	
	public ExportCSV esportaLitinoInCSV(String refAccount) {
		StringBuilder fileCsv = new StringBuilder();
		GetAccountResponseSchema account = authorityApi.v10NwsAccountsOidGet(refAccount);
		ListinoDTO listino = trovaListinoAccount(refAccount);
		fileCsv.append("ACCOUNT:").append(SEP).append(account.getAccount().getName()).append(N_LINE);
		fileCsv.append("Nome Listino:").append(SEP).append(listino.getNome()).append(N_LINE);
		fileCsv.append("Descrizione Listino:").append(SEP).append(listino.getDescrizione()).append(N_LINE).append(N_LINE);
		
		fileCsv.append("Servizio").append(SEP)
				.append("Voce").append(SEP)
				.append("Unità di misura").append(SEP)
				.append("Quantità").append(SEP)
				.append("Importo Annuo").append(SEP).append(N_LINE);
		
		listino.getElencoDettagli().forEach(dett -> fileCsv.append(rigaDettaglio(dett)));
		
		ExportCSV risposta = new ExportCSV();
		risposta.setFile(fileCsv);
		risposta.setFilename("Listino_" + account.getAccount().getName() + "_.csv");
		return risposta;
	}

	private StringBuilder rigaDettaglio(ListinoDettaglioDTO dett) {
		ListinoTipoPrezzoDTO prezzoDefault = new ListinoTipoPrezzoDTO();
		prezzoDefault.setImportoAnnuo(0.0d);
		StringBuilder riga = new StringBuilder();
		riga.append(dett.getServizio()).append(SEP)
			.append(dett.getVoce()).append(SEP)
			.append(dett.getUdm()).append(SEP)
			.append(dett.getQta()).append(SEP)
			
			.append(df.format(dett.getElencoPrezzo().stream().findFirst().orElse(prezzoDefault).getImportoAnnuo())).append(SEP).append(N_LINE);
		
		return riga;
	}
	
	
	public SpAccountInfocosto recuperaInfocostoAccount (String refAccount) {
		return spAccountInfocostoRepository.findInfocostoCorrente(refAccount);
	}
	
	/**
	 * Inserimento di un nuovo listino
	 * @param nuovo
	 * @param idAgente
	 * @throws BusinessException
	 */
	@Transactional
	public String inserisciNuovoListino (ListinoDTO nuovo, BigInteger idAgente) throws BusinessException {
		SpDTipoListino tipo = spDTipoListinoRepository.findByCodice(nuovo.getTipoListino()).orElseThrow(() -> new BusinessException("Tipo listino con codice " + nuovo.getTipoListino() + " non trovato"));
		SpDListino daInserire = new SpDListino();
		daInserire.setDataCancellazione(Timestamp.valueOf(nuovo.getDataCancellazione()));
		daInserire.setDataCreazione(new Timestamp(System.currentTimeMillis()));
		daInserire.setDataFineValidita(NivolaUtilities.localDateToSqlDate(nuovo.getDataFineValidita()));
		daInserire.setDataInizioValidita(NivolaUtilities.localDateToSqlDate(nuovo.getDataInizioValidita()));
		daInserire.setDescrizione(nuovo.getDescrizione());
		daInserire.setNome(nuovo.getNome());
		daInserire.setIdAgente(idAgente);
		daInserire.setSpDTipoListino(tipo);
		
		return spDListinoRepository.saveAndFlush(daInserire).getId();
	}
	
	/**
	 * Modifica di un listino esistente
	 * @param nuovo
	 * @param idAgente
	 */
	@Transactional
	public void modificaListino (ListinoDTO nuovo, BigInteger idAgente) throws BusinessException{
		SpDListino daModificare = spDListinoRepository.findOne(nuovo.getId());
		if (daModificare == null) 
			throw new BusinessException("Listino con id " + nuovo.getId() + " non trovato");
		
		SpDTipoListino tipo = spDTipoListinoRepository.findByCodice(nuovo.getTipoListino()).orElseThrow(() -> new BusinessException("Tipo listino con codice " + nuovo.getTipoListino() + " non trovato"));
		
		if (nuovo.getDataCancellazione() != null)
			daModificare.setDataCancellazione(Timestamp.valueOf(nuovo.getDataCancellazione()));
		daModificare.setDataModifica(new Timestamp(System.currentTimeMillis()));
		if (nuovo.getDataFineValidita() != null)
			daModificare.setDataFineValidita(NivolaUtilities.localDateToSqlDate(nuovo.getDataFineValidita()));
		daModificare.setDataInizioValidita(NivolaUtilities.localDateToSqlDate(nuovo.getDataInizioValidita()));
		daModificare.setDescrizione(nuovo.getDescrizione());
		daModificare.setNome(nuovo.getNome());
		daModificare.setIdAgente(idAgente);
		daModificare.setSpDTipoListino(tipo);
		
		spDListinoRepository.saveAndFlush(daModificare);
	}
	
	/**
	 * Elimina un listino esistente
	 * @param nuovo
	 * @param idAgente
	 * @throws BusinessException 
	 */
	@Transactional
	public void eliminaListino (String id, BigInteger idAgente) throws BusinessException {
		SpDListino daEliminare = spDListinoRepository.findOne(id);
		if (daEliminare == null) 
			throw new BusinessException("Listino con id " + id + " non trovato");
		
		spDListinoRepository.delete(daEliminare);
	}
	
	/**
	 * Inserimento di un dettaglio
	 * @param dettaglio
	 * @param idAgente
	 * @throws BusinessException
	 */
	@Transactional
	public String inserisciDettaglio (ListinoDettaglioDTO dettaglio, BigInteger idAgente) throws BusinessException {
		SpDListino listinoRiferimento = spDListinoRepository.findOne(dettaglio.getIdListino());
		if (listinoRiferimento == null) 
			throw new BusinessException("Listino con id " + dettaglio.getIdListino() + " non trovato");
		
		SpDMetriche metricaRiferimento = metricheRepository.findOne(BigInteger.valueOf(dettaglio.getIdMetrica()));
		if (metricaRiferimento == null) 
			throw new BusinessException("Metrica con id " + dettaglio.getIdMetrica() + " non trovata");
		
		SpDListinoDettaglio dettaglioInserire = new SpDListinoDettaglio();
		if (dettaglio.getDataCancellazione() != null)
			dettaglio.setDataCancellazione(dettaglio.getDataCancellazione());
		
		dettaglioInserire.setDataCreazione(new Timestamp(System.currentTimeMillis()));
		dettaglioInserire.setDescrizione(dettaglio.getDescrizione());
		dettaglioInserire.setIdAgente(idAgente);
		dettaglioInserire.setQta(dettaglio.getQta());
		dettaglioInserire.setRangeMax(dettaglio.getRangeMax());
		dettaglioInserire.setRangeMin(dettaglio.getRangeMin());
		dettaglioInserire.setSpDListino(listinoRiferimento);
		dettaglioInserire.setSpDMetriche(metricaRiferimento);
		dettaglioInserire.setUdm(dettaglio.getUdm());
		dettaglioInserire.setVoce(dettaglio.getVoce());
		dettaglioInserire.setSpDListino(listinoRiferimento);
		
		return spDListinoDettaglioRepository.saveAndFlush(dettaglioInserire).getId();
	}
	
	/**
	 * Modifica di un dettaglio
	 * @param dettaglio
	 * @param idAgente
	 * @throws BusinessException
	 */
	@Transactional
	public void modificaDettaglio (ListinoDettaglioDTO dettaglio, BigInteger idAgente) throws BusinessException {
		SpDListino listinoRiferimento = spDListinoRepository.findOne(dettaglio.getIdListino());
		if (listinoRiferimento == null) 
			throw new BusinessException("Listino con id " + dettaglio.getIdListino() + " non trovato");
		
		SpDMetriche metricaRiferimento = metricheRepository.findOne(BigInteger.valueOf(dettaglio.getIdMetrica()));
		if (metricaRiferimento == null) 
			throw new BusinessException("Metrica con id " + dettaglio.getIdMetrica() + " non trovata");
		
		SpDListinoDettaglio dettaglioDaModificare = spDListinoDettaglioRepository.findOne(dettaglio.getId());
		if (dettaglioDaModificare == null) 
			throw new BusinessException("Dettaglio con id " + dettaglio.getId() + " non trovato");
		
		dettaglioDaModificare.setDataCancellazione(dettaglio.getDataCancellazione());
		dettaglioDaModificare.setDataModifica(new Timestamp(System.currentTimeMillis()));
		dettaglioDaModificare.setDescrizione(dettaglio.getDescrizione());
		dettaglioDaModificare.setIdAgente(idAgente);
		dettaglioDaModificare.setQta(dettaglio.getQta());
		dettaglioDaModificare.setRangeMax(dettaglio.getRangeMax());
		dettaglioDaModificare.setRangeMin(dettaglio.getRangeMin());
		dettaglioDaModificare.setSpDListino(listinoRiferimento);
		dettaglioDaModificare.setSpDMetriche(metricaRiferimento);
		dettaglioDaModificare.setUdm(dettaglio.getUdm());
		dettaglioDaModificare.setVoce(dettaglio.getVoce());
		dettaglioDaModificare.setSpDListino(listinoRiferimento);	
		
		spDListinoDettaglioRepository.saveAndFlush(dettaglioDaModificare);
	}
	
	/**
	 * Elimina un dettaglio
	 * @param id
	 * @param idAgente
	 * @throws BusinessException
	 */
	@Transactional
	public void eliminaDettaglio (String id, BigInteger idAgente) throws BusinessException {
		SpDListinoDettaglio daEliminare = spDListinoDettaglioRepository.findOne(id);
		if (daEliminare == null) 
			throw new BusinessException("Dettaglio con id " + id + " non trovato");
		
		spDListinoDettaglioRepository.delete(daEliminare);
	}
	
	/**
	 * Inserisce un importo
	 * @param importo
	 * @param utenteInserimento
	 * @throws BusinessException
	 */
	public String inserisciImporto (ListinoImportoDto importo, SpUser utenteInserimento) throws BusinessException {
		SpDListinoDettaglio dettaglio = spDListinoDettaglioRepository.findOne(importo.getIdListinoDettaglio());
		if (dettaglio == null) 
			throw new BusinessException("Dettaglio con id " + importo.getId() + " non trovato");
		
		Optional<SpDTipoPrezzo> tipoPrezzo = spDTipoPrezzoRepository.findByCodice(importo.getTipoPrezzo());
		
		SpDListinoImporto nuovo = new SpDListinoImporto();
		
		nuovo.setAddPerc(importo.getAddPerc());
		nuovo.setDataCancellazione(Timestamp.valueOf(importo.getDataCancellazione()));
		nuovo.setDataCreazione(new Timestamp(System.currentTimeMillis()));
		nuovo.setImportoAnnuo(importo.getImportoAnnuo());
		nuovo.setSpDListinoDettaglio(dettaglio);
		nuovo.setSpDTipoPrezzo(tipoPrezzo.orElseThrow(() -> new BusinessException("Tipo Prezzo con codice " + importo.getTipoPrezzo() + " non trovato")));
		nuovo.setSpUser(utenteInserimento);
		

		return spDListinoImportoRepository.saveAndFlush(nuovo).getId();
	}
	
	/**
	 * Modifica un importo 
	 * @param importo
	 * @param utenteInserimento
	 * @throws BusinessException
	 */
	public void modificaImporto (ListinoImportoDto importo, SpUser utenteInserimento) throws BusinessException {
		SpDListinoDettaglio dettaglio = spDListinoDettaglioRepository.findOne(importo.getIdListinoDettaglio());
		if (dettaglio == null) 
			throw new BusinessException("Dettaglio con id " + importo.getIdListinoDettaglio() + " non trovato");
		
		SpDTipoPrezzo tipoPrezzo = spDTipoPrezzoRepository.findByCodice(importo.getTipoPrezzo()).orElseThrow(() -> new BusinessException("Tipo Prezzo con codice " + importo.getTipoPrezzo() + " non trovato"));
		
		SpDListinoImporto daModificare = spDListinoImportoRepository.findOne(importo.getId());
		
		if (daModificare == null)
			throw new BusinessException("Listino importo con id " + importo.getId() + " Non trovato.");
		
		daModificare.setAddPerc(importo.getAddPerc());
		daModificare.setDataCancellazione(Timestamp.valueOf(importo.getDataCancellazione()));
		daModificare.setDataCreazione(new Timestamp(System.currentTimeMillis()));
		daModificare.setImportoAnnuo(importo.getImportoAnnuo());
		daModificare.setSpDListinoDettaglio(dettaglio);
		daModificare.setSpDTipoPrezzo(tipoPrezzo);
		daModificare.setSpUser(utenteInserimento);
		
		spDListinoImportoRepository.saveAndFlush(daModificare);
	}
	
	/**
	 * Elimina un importo
	 * @param id
	 * @param idAgente
	 * @throws BusinessException
	 */
	@Transactional
	public void eliminaImporto (String id, BigInteger idAgente) throws BusinessException {
		SpDListinoImporto daEliminare = spDListinoImportoRepository.findOne(id);
		if (daEliminare == null) 
			throw new BusinessException("Importo con id " + id + " non trovato");
		
		spDListinoImportoRepository.delete(daEliminare);
	}
	
}
