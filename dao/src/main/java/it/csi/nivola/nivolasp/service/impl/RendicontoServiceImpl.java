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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import it.csi.nivola.nivolasp.domain.SpDTipoRendiconto;
import it.csi.nivola.nivolasp.domain.SpRendiconto;
import it.csi.nivola.nivolasp.integration.rest.api.service.AuthorityApi;
import it.csi.nivola.nivolasp.repository.RendicontoRepository;
import it.csi.nivola.nivolasp.repository.SpCostoGiornoRepository;
import it.csi.nivola.nivolasp.repository.TipoRendicontoRepository;
import it.csi.nivola.nivolasp.service.RendicontoService;
import it.csi.nivola.nivolasp.service.dto.CostiSottostrutturaDTO;
import it.csi.nivola.nivolasp.service.dto.CostiStrutturaRaggruppatiServizioDTO;
import it.csi.nivola.nivolasp.service.dto.CostoAccountDTO;
import it.csi.nivola.nivolasp.service.dto.CostoDelMeseRigaDTO;
import it.csi.nivola.nivolasp.service.dto.DettaglioServizioDTO;
import it.csi.nivola.nivolasp.service.dto.InfoGraficoServizioDTO;
import it.csi.nivola.nivolasp.service.dto.RaggruppamentoCostiServizioDTO;
import it.csi.nivola.nivolasp.service.dto.RendicontoDTO;
import it.csi.nivola.nivolasp.service.dto.RigaCostoDTO;
import it.csi.nivola.nivolasp.service.mapper.RendicontoMapper;

@Service("rendicontoService")
@Transactional
public class RendicontoServiceImpl implements RendicontoService {

	@Autowired
    RendicontoRepository rendicontoRepository;
	
	@Autowired
	TipoRendicontoRepository tipoRendicontoRepository;

	@Autowired
	RendicontoMapper rendicontoMapper;
	
	@Autowired
	SpCostoGiornoRepository spCostoGiornoRepository;
	
	@Autowired
	AuthorityApi authorityApi;
	
	ZoneId defaultZoneId = ZoneId.systemDefault();

    /**
     * findRendicontiByidAccount
     * ritorna l'elenco dei rendiconti di un dato account
     */
	@Override
	public Page<RendicontoDTO> findRendicontiByidAccount(String idAccount) {
	    List<SpRendiconto> elencoDettaglio = rendicontoRepository.trovaRendicontiAccountDettaglio(idAccount);
	    List<SpRendiconto> elencoSintetici = rendicontoRepository.trovaRendicontiSintesiAccount(idAccount);
	    List<RendicontoDTO> elenco = rendicontoMapper.toListDTO(elencoSintetici);
	    elenco.forEach(r -> {
	    	Optional<SpRendiconto> dett = elencoDettaglio.stream().filter(d -> d.getAnno().equals(r.getAnno()) && d.getMese().equals(r.getMese())).findFirst();
	    	r.setUrlFileDettaglio(dett.isPresent() ? dett.get().getUrlFile() : "");
	    	r.setIdDettaglio(dett.isPresent() ? dett.get().getId() : -1);
	    });
	    
	    
	    return new PageImpl<RendicontoDTO>(elenco);

	}

    /**
     * findRendicontiByidDivisione
     * ritorna l'elenco dei rendiconti di una divisione
     */
	@Override
	public Page<RendicontoDTO> findRendicontiByidDivisione(String idDivisione, String tipoRendiconto, Pageable pageable) {
	    Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "id"));
		return rendicontoRepository.findRendicontiByidDivisione(idDivisione,tipoRendiconto, new PageRequest(pageable.getPageNumber(),pageable.getPageSize(),sort)).map(rendicontoMapper::toDTO);
	}

    /**
     * findRendicontiByidOrganizzazione
     * ritorna l'elenco dei rendiconti di una data organizzazione
     */
	@Override
	public Page<RendicontoDTO> findRendicontiByidOrganizzazione(String idOrganizzazione, Pageable pageable) {
	    Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "id"));
		return rendicontoRepository.findRendicontiByidOrganizzazione(idOrganizzazione,new PageRequest(pageable.getPageNumber(),pageable.getPageSize(),sort)).map(rendicontoMapper::toDTO);
	}

	@Override
	public Optional<RendicontoDTO> findRendicontoByIdAndIdAccount(String idAccount,Long id) {
		return rendicontoRepository.findRendicontoByIdAndIdAccount(idAccount, id).map(rendicontoMapper::toDTO);
	}

	@Override
	public Optional<RendicontoDTO> findRendicontoByIdAndIdDivisione(String idDivisione,Long id) {
		return rendicontoRepository.findRendicontoByIdAndIdDivisione(idDivisione, id).map(rendicontoMapper::toDTO);
	}

	@Override
	public Optional<RendicontoDTO> findRendicontoByIdAndIdOrganizzazione(String idOrganizzazione, Long id) {
		return rendicontoRepository.findRendicontoByIdAndIdOrganizzazione(idOrganizzazione, id).map(rendicontoMapper::toDTO);
	}


	@Override
	public SpRendiconto salvaRendiconto(SpRendiconto daSalvare) {
		return rendicontoRepository.save(daSalvare);
	}

	@Override
	public List<SpDTipoRendiconto> elencoTipi() {
		return tipoRendicontoRepository.findAll();
	}

	@Override
	public List<SpRendiconto> findByIdAccount(String idAccount) {
		return rendicontoRepository.findByIdAccount(idAccount);
	}

	@Override
	public List<SpRendiconto> findByIdDivisione(String idDivisione) {
		return rendicontoRepository.findByIdDivisione(idDivisione);
	}

	@Override
	public List<CostoAccountDTO> aggregaCostiAccountPerDivisionePeriodo(String idDivisione, Date dataDa, Date dataA) {
		return rendicontoRepository.aggregaCostiAccountPerDivisionePeriodo(idDivisione, dataDa, dataA);
	}
	
	@Override
	public List<CostoDelMeseRigaDTO> aggregaCostiDivisionePerServizio(String idDivisione, Date data) {
		return rendicontoRepository.aggregaCostiDivisionePerServizio(idDivisione, data);
	}

	@Override
	public SpRendiconto trovaReportGiornalieroEsistente(SpRendiconto filtro) {
		return rendicontoRepository.findByAnnoAndMeseAndIdAccountAndTipoRendiconto(filtro.getAnno(), filtro.getMese(), filtro.getIdAccount(), filtro.getTipoRendiconto());
	}
	
	@Override
	public List<RaggruppamentoCostiServizioDTO> costiAccount(String refAccount, Date da, Date a) {
		return spCostoGiornoRepository.raggruppaCostiServizioAccount(refAccount, da, a);
	}
	
	@Override
	public List<RaggruppamentoCostiServizioDTO> costiDivisione(String refDivisione, Date da, Date a) {
		return spCostoGiornoRepository.raggruppaCostiServizioDivisione(refDivisione, da, a);
	}
	
	@Override
	public List<RaggruppamentoCostiServizioDTO> costiOrganizzazione(String refOrganizzazione, Date da, Date a) {
		return spCostoGiornoRepository.raggruppaCostiServizioOrganizzazione(refOrganizzazione, da, a);
	}
	
	/**
	 * Restituisce il costo totale a carico dell'organizzazione specificata ad un giorno preciso, usato nel box dashboard
	 * @param refOrganizzazione
	 * @param giorno
	 * @return
	 */
	@Override
	public BigDecimal costiGiornoOrganizzazione(@Param("refOrganizzazione") String refOrganizzazione, @Param("giorno") java.util.Date giorno) {
		return spCostoGiornoRepository.costiGiornoOrganizzazione(refOrganizzazione, giorno);
	}
	
	/**
	 * Restituisce il costo totale a carico della divisione specificata ad un giorno preciso, usato nel box dashboard
	 * @param refDivisione
	 * @param giorno
	 * @return
	 */
	@Override
	public BigDecimal costiGiornoDivisione(@Param("refDivisione") String refDivisione, @Param("giorno") java.util.Date giorno) {
		return spCostoGiornoRepository.costiGiornoDivisione(refDivisione, giorno);
	}
	
	
	/**
	 * Restituisce il costo totale a carico dell'account specificato ad un giorno preciso, usato nel box dashboard
	 * @param refOrganizzazione
	 * @param giorno
	 * @return
	 */
	@Override
	public BigDecimal costiGiornoAccount(@Param("refAccount") String refAccount, @Param("giorno") java.util.Date giorno) {
		return spCostoGiornoRepository.costiGiornoAccount(refAccount, giorno);
	}
	
	@Override
	public List<InfoGraficoServizioDTO> costiGraficoAccount(String refAccount) {
		YearMonth annoMese = YearMonth.now();
		
		ArrayList<InfoGraficoServizioDTO> elencoCostiPerServizio = new ArrayList<>();
		
		
		for (int i=0;i<12; i++) {
			//inizializzo data in millisecondi per il frontend
			LocalDate dataInizio = LocalDate.of(annoMese.getYear(), annoMese.getMonth(), 1);
			LocalDate dataFine = dataInizio.withDayOfMonth(dataInizio.lengthOfMonth());
			List<RaggruppamentoCostiServizioDTO> elencoCosti = spCostoGiornoRepository.raggruppaCostiServizioAccount(refAccount, 
					Date.from(dataInizio.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), 
					Date.from(dataFine.atStartOfDay(ZoneId.systemDefault()).toInstant()));
			
			
			for (RaggruppamentoCostiServizioDTO servizio : elencoCosti) {
				InfoGraficoServizioDTO infoServizio = null;
				Optional<InfoGraficoServizioDTO> infoServizioOpt = elencoCostiPerServizio.stream().filter(e -> e.getNome().equals(servizio.getServizio().getDescrizione())).findFirst();
				if (!infoServizioOpt.isPresent()) {
					infoServizio = new InfoGraficoServizioDTO();
					infoServizio.setNome(servizio.getServizio().getDescrizione());
					infoServizio.setColore(servizio.getServizio().getColore());
					List<RigaCostoDTO> costiDelServizio = new ArrayList<RigaCostoDTO>();
					infoServizio.setCosti(costiDelServizio);
					elencoCostiPerServizio.add(infoServizio);
				} else {
					infoServizio = infoServizioOpt.get();
				}
					
				RigaCostoDTO riga = new RigaCostoDTO();
				riga.setValore(servizio.getCosto());
				riga.setData(dataInizio.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
				riga.setDataAsString(annoMese.toString());
				infoServizio.getCosti().add(riga);
	    	}
			//anno-mese per invocazione servizio
			annoMese = annoMese.minusMonths(1);
		}
		return elencoCostiPerServizio;
	}

	@Override
	public List<InfoGraficoServizioDTO> costiGraficoDivisione(String refDivisione) {
		YearMonth annoMese = YearMonth.now();
		
		ArrayList<InfoGraficoServizioDTO> elencoCostiPerServizio = new ArrayList<>();
		
		
		for (int i=0;i<12; i++) {
			//inizializzo data in millisecondi per il frontend
			LocalDate dataInizio = LocalDate.of(annoMese.getYear(), annoMese.getMonth(), 1);
			LocalDate dataFine = dataInizio.withDayOfMonth(dataInizio.lengthOfMonth());
			List<RaggruppamentoCostiServizioDTO> elencoCosti = spCostoGiornoRepository.raggruppaCostiServizioDivisione(refDivisione, 
					Date.from(dataInizio.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), 
					Date.from(dataFine.atStartOfDay(ZoneId.systemDefault()).toInstant()));
			
			
			for (RaggruppamentoCostiServizioDTO servizio : elencoCosti) {
				InfoGraficoServizioDTO infoServizio = null;
				Optional<InfoGraficoServizioDTO> infoServizioOpt = elencoCostiPerServizio.stream().filter(e -> e.getNome().equals(servizio.getServizio().getDescrizione())).findFirst();
				if (!infoServizioOpt.isPresent()) {
					infoServizio = new InfoGraficoServizioDTO();
					infoServizio.setNome(servizio.getServizio().getDescrizione());
					infoServizio.setColore(servizio.getServizio().getColore());
					List<RigaCostoDTO> costiDelServizio = new ArrayList<RigaCostoDTO>();
					infoServizio.setCosti(costiDelServizio);
					elencoCostiPerServizio.add(infoServizio);
				} else {
					infoServizio = infoServizioOpt.get();
				}
					
				RigaCostoDTO riga = new RigaCostoDTO();
				riga.setValore(servizio.getCosto());
				riga.setData(dataInizio.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
				riga.setDataAsString(annoMese.toString());
				infoServizio.getCosti().add(riga);
	    	}
			//anno-mese per invocazione servizio
			annoMese = annoMese.minusMonths(1);
		}
		return elencoCostiPerServizio;
	}

	@Override
	public List<InfoGraficoServizioDTO> costiGraficoOrganizzazione(String id) {
		YearMonth annoMese = YearMonth.now();
		
		ArrayList<InfoGraficoServizioDTO> elencoCostiPerServizio = new ArrayList<>();
		
		
		for (int i=0;i<12; i++) {
			//inizializzo data in millisecondi per il frontend
			LocalDate dataInizio = LocalDate.of(annoMese.getYear(), annoMese.getMonth(), 1);
			LocalDate dataFine = dataInizio.withDayOfMonth(dataInizio.lengthOfMonth());
			List<RaggruppamentoCostiServizioDTO> elencoCosti = spCostoGiornoRepository.raggruppaCostiServizioOrganizzazione(id, 
					Date.from(dataInizio.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), 
					Date.from(dataFine.atStartOfDay(ZoneId.systemDefault()).toInstant()));
			
			
			for (RaggruppamentoCostiServizioDTO servizio : elencoCosti) {
				InfoGraficoServizioDTO infoServizio = null;
				Optional<InfoGraficoServizioDTO> infoServizioOpt = elencoCostiPerServizio.stream().filter(e -> e.getNome().equals(servizio.getServizio().getDescrizione())).findFirst();
				if (!infoServizioOpt.isPresent()) {
					infoServizio = new InfoGraficoServizioDTO();
					infoServizio.setNome(servizio.getServizio().getDescrizione());
					infoServizio.setColore(servizio.getServizio().getColore());
					List<RigaCostoDTO> costiDelServizio = new ArrayList<RigaCostoDTO>();
					infoServizio.setCosti(costiDelServizio);
					elencoCostiPerServizio.add(infoServizio);
				} else {
					infoServizio = infoServizioOpt.get();
				}
					
				RigaCostoDTO riga = new RigaCostoDTO();
				riga.setValore(servizio.getCosto());
				riga.setData(dataInizio.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
				riga.setDataAsString(annoMese.toString());
				infoServizio.getCosti().add(riga);
	    	}
			//anno-mese per invocazione servizio
			annoMese = annoMese.minusMonths(1);
		}
		return elencoCostiPerServizio;
	}
	
	@Override
	public List<CostiStrutturaRaggruppatiServizioDTO> costiDivisionePerAccount(String refDivisione) {
		LocalDateTime oggi = LocalDate.now().atStartOfDay();
		LocalDateTime inizio = oggi.minus(1, ChronoUnit.YEARS).plus(1, ChronoUnit.MONTHS).withDayOfMonth(1);
		
		List<CostiSottostrutturaDTO> elencoCosti = spCostoGiornoRepository.costiDivisioneRaggruppatiAccountServizio(
				refDivisione,
				Date.from(inizio.atZone(ZoneId.systemDefault()).toInstant()), 
				Date.from(oggi.atZone(ZoneId.systemDefault()).toInstant())
		);
		
		List<CostiStrutturaRaggruppatiServizioDTO> risposta = new ArrayList<>();
		
		elencoCosti.forEach(e -> {
			Optional<CostiStrutturaRaggruppatiServizioDTO> trovato = risposta.stream().filter(acc -> acc.getUuid().equals(e.getUuid()))
					.findAny();
					
			trovato.ifPresent(presente -> {
				DettaglioServizioDTO dett = new DettaglioServizioDTO();
				dett.setNomeServizio(e.getNomeServizio());
				dett.setColore(e.getColoreServizio());
				dett.setImporto(e.getCosto());
				dett.setQuantita(e.getQuantita());
				presente.getServizi().add(dett);
			});
			
			if (!trovato.isPresent()) {
				CostiStrutturaRaggruppatiServizioDTO elem = new CostiStrutturaRaggruppatiServizioDTO();
				elem.setUuid(e.getUuid());
				elem.setNomeStruttura(authorityApi.v10NwsAccountsOidGet(e.getUuid()).getAccount().getName());
				DettaglioServizioDTO dett = new DettaglioServizioDTO();
				dett.setNomeServizio(e.getNomeServizio());
				dett.setColore(e.getColoreServizio());
				dett.setImporto(e.getCosto());
				dett.setQuantita(e.getQuantita());
				elem.getServizi().add(dett);
				risposta.add(elem);
			}
			
		});
		
		return risposta;
	}

	@Override
	public List<CostiStrutturaRaggruppatiServizioDTO> costiOrganizzazionePerDivisione(String refOrganizzazione) {
		LocalDateTime oggi = LocalDate.now().atStartOfDay();
		LocalDateTime inizio = oggi.minus(1, ChronoUnit.YEARS).plus(1, ChronoUnit.MONTHS).withDayOfMonth(1);
		
		List<CostiSottostrutturaDTO> elencoCosti = spCostoGiornoRepository.costiOrganizzazioneRaggruppatiDivisioneServizio(
				refOrganizzazione,
				Date.from(inizio.atZone(ZoneId.systemDefault()).toInstant()), 
				Date.from(oggi.atZone(ZoneId.systemDefault()).toInstant())
		);
		
		List<CostiStrutturaRaggruppatiServizioDTO> risposta = new ArrayList<>();
		
		elencoCosti.forEach(e -> {
			Optional<CostiStrutturaRaggruppatiServizioDTO> trovato = risposta.stream().filter(div -> div.getUuid().equals(e.getUuid()))
					.findAny();
					
			trovato.ifPresent(presente -> {
				DettaglioServizioDTO dett = new DettaglioServizioDTO();
				dett.setNomeServizio(e.getNomeServizio());
				dett.setColore(e.getColoreServizio());
				dett.setImporto(e.getCosto());
				dett.setQuantita(e.getQuantita());
				presente.getServizi().add(dett);
			});
			
			if (!trovato.isPresent()) {
				CostiStrutturaRaggruppatiServizioDTO elem = new CostiStrutturaRaggruppatiServizioDTO();
				elem.setUuid(e.getUuid());
				elem.setNomeStruttura(authorityApi.v10NwsDivisionsOidGet(e.getUuid()).getDivision().getName());
				DettaglioServizioDTO dett = new DettaglioServizioDTO();
				dett.setNomeServizio(e.getNomeServizio());
				dett.setColore(e.getColoreServizio());
				dett.setImporto(e.getCosto());
				dett.setQuantita(e.getQuantita());
				elem.getServizi().add(dett);
				risposta.add(elem);
			}
			
		});
		
		return risposta;
	}

	/**
	 * Elimina i costi caricati per un account ed una certa data
	 * @param uuid identificativo dell'account, se vale 'none' significa che è stata richiesta la cancellazione di tutti gli account
	 * @param giornoPartenza giorno di partenza per la cancellazione
	 */
	@Override
	@Transactional
	public void cancellaGiorni(String uuid, LocalDate giornoPartenza) {
		if (StringUtils.isNotEmpty(uuid) && !"none".equalsIgnoreCase(uuid))
			spCostoGiornoRepository.deleteByRefAccountAndDataAfter(uuid, Date.from(giornoPartenza.atStartOfDay(defaultZoneId).toInstant()));
		else
			spCostoGiornoRepository.deleteByDataAfter(Date.from(giornoPartenza.atStartOfDay(defaultZoneId).toInstant()));
	}

	/**
	 * Elimina i report generati per un account ed una certa data
	 * @param uuid identificativo dell'account, se vale 'none' significa che è stata richiesta la cancellazione di tutti gli account
	 * @param giornoPartenza giorno di partenza per la cancellazione
	 */
	@Override
	@Transactional
	public void cancellaReport(String uuid, LocalDate giornoPartenza) {
		if (StringUtils.isNotEmpty(uuid) && !"none".equalsIgnoreCase(uuid))
			rendicontoRepository.deleteByRefAccountAndDataAfter(uuid, Date.from(giornoPartenza.withDayOfMonth(1).atStartOfDay(defaultZoneId).toInstant()));
		else
			rendicontoRepository.deleteByDataAfter(Date.from(giornoPartenza.withDayOfMonth(1).atStartOfDay(defaultZoneId).toInstant()));
		
	}
	


}
