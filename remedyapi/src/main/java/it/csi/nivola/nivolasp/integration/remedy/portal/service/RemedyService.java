/*-
 * ========================LICENSE_START=================================
 * Api Remedy
 * %%
 * Copyright (C) 2022 Regione Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | Regione Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.integration.remedy.portal.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientResponseException;

import it.csi.nivola.nivolasp.integration.remedy.model.CategoriaOperativaBaseModel;
import it.csi.nivola.nivolasp.integration.remedy.model.CategoriaOperativaBaseModel.TipologiaEnum;
import it.csi.nivola.nivolasp.integration.remedy.model.CategoriaOperativaTicket;
import it.csi.nivola.nivolasp.integration.remedy.model.CategorizzazioneTicket;
import it.csi.nivola.nivolasp.integration.remedy.model.Ente;
import it.csi.nivola.nivolasp.integration.remedy.model.InfoNotaAttachments;
import it.csi.nivola.nivolasp.integration.remedy.model.InfoNotaWLog;
import it.csi.nivola.nivolasp.integration.remedy.model.LavorazioneTicket;
import it.csi.nivola.nivolasp.integration.remedy.model.RichiedenteDaAnagrafica;
import it.csi.nivola.nivolasp.integration.remedy.model.RichiedenteTicket;
import it.csi.nivola.nivolasp.integration.remedy.model.Ticket;
import it.csi.nivola.nivolasp.integration.remedy.model.Ticket.ImpattoEnum;
import it.csi.nivola.nivolasp.integration.remedy.model.Ticket.UrgenzaEnum;
import it.csi.nivola.nivolasp.integration.remedy.portal.dto.CategoriaOperativaTicketDto;
import it.csi.nivola.nivolasp.integration.remedy.portal.dto.DecodificaDto;
import it.csi.nivola.nivolasp.integration.remedy.portal.dto.EnteDto;
import it.csi.nivola.nivolasp.integration.remedy.portal.dto.InfoNotaAttachmentsDto;
import it.csi.nivola.nivolasp.integration.remedy.portal.dto.InfoNotaWLogDto;
import it.csi.nivola.nivolasp.integration.remedy.portal.dto.LavorazioneTicketDto;
import it.csi.nivola.nivolasp.integration.remedy.portal.dto.TicketDto;
import it.csi.nivola.nivolasp.integration.remedy.portal.dto.UtenteDto;
import it.csi.nivola.nivolasp.integration.remedy.portal.mapper.RemedyTypesMapper;
import it.csi.nivola.nivolasp.integration.remedy.service.CategoriaApi;
import it.csi.nivola.nivolasp.integration.remedy.service.EnteApi;
import it.csi.nivola.nivolasp.integration.remedy.service.LavorazioneApi;
import it.csi.nivola.nivolasp.integration.remedy.service.RichiedenteApi;
import it.csi.nivola.nivolasp.integration.remedy.service.TicketApi;

@Service
public class RemedyService extends AbstractService {
	@Autowired
	public EnteApi enteApi;
	@Autowired
	public RichiedenteApi richiedenteApi;
	@Autowired
	public TicketApi ticketApi;
	@Autowired
	public CategoriaApi categoriaApi;
	@Autowired
	public LavorazioneApi lavorazioneApi;
	
	@Autowired
	RemedyTypesMapper remedyTypesMapper;
	
	/**
	 * Recupera l'ente per identificativo
	 * @param companyId
	 * @return
	 * @throws RemedyServiceException
	 */
	public EnteDto recuperaEnte ( String companyId) throws RemedyServiceException{
		if (StringUtils.isEmpty(companyId))
        	throw new RemedyServiceException("Campo obbligatorio: " + companyId);
		
		String xRequestID = UUID.randomUUID().toString();
        String xForwardedFor = "127.0.0.1";
        String filter = "{ \"companyId\": {\"eq\":\""+companyId+"\"} }";
        log.debug(filter);
        String sort = null;
        Integer offset = null;
        Integer limit = null;
        
        List<Ente> response = enteApi.getCompanyList(xRequestID, xForwardedFor, filter, sort, offset, limit);
        
        if (CollectionUtils.isEmpty(response))
        	throw new RemedyServiceException("Nessun ente trovato per " + companyId);
        if (response.size() > 1)
        	throw new RemedyServiceException("Piu' di un ente trovato per " + companyId);
		return remedyTypesMapper.enteVersoPortale(response.get(0));
	}
	
	/**
	 * Recupera un utente per email
	 * @param email
	 * @return
	 * @throws RemedyServiceException
	 */
	public UtenteDto recuperaUtentePerEmail (String email) throws RemedyServiceException {
		if (StringUtils.isEmpty(email))
        	throw new RemedyServiceException("Campo obbligatorio: " + email);
		
		String xRequestID = UUID.randomUUID().toString();
        String xForwardedFor = "127.0.0.1";
        String filter = "{ \"email\": {\"eq\": \""+email+"\"} }";
        String sort = null;
        Integer offset = null;
        Integer limit = 20;
        
        List<RichiedenteDaAnagrafica> response = richiedenteApi.getUserList(xRequestID, xForwardedFor, filter, sort, offset, limit);
        
        if (CollectionUtils.isEmpty(response))
        	throw new RemedyServiceException("Nessun utente trovato per " + email);
        if (response.size() > 1)
        	throw new RemedyServiceException("Piu' di un utente trovato per " + email);
        
		return remedyTypesMapper.utenteVersoPortale(response.get(0));
	}
	
	/**
	 * Recupera un utente per person id
	 * @param email
	 * @return
	 * @throws RemedyServiceException
	 */
	public UtenteDto recuperaUtentePerPersonId (String personId) throws RemedyServiceException {
		if (StringUtils.isEmpty(personId))
			throw new RemedyServiceException("Campo obbligatorio: " + personId);
		
		List<RichiedenteDaAnagrafica> response = internoUtentePerPersonId(personId);
		
		return remedyTypesMapper.utenteVersoPortale(response.get(0));
	}

	private List<RichiedenteDaAnagrafica> internoUtentePerPersonId(String personId) throws RemedyServiceException {
		String xRequestID = UUID.randomUUID().toString();
		String xForwardedFor = "127.0.0.1";
		String filter = "{ \"personId\": {\"eq\": \""+personId+"\"} }";
		String sort = null;
		Integer offset = null;
		Integer limit = 20;
		
		List<RichiedenteDaAnagrafica> response = richiedenteApi.getUserList(xRequestID, xForwardedFor, filter, sort, offset, limit);
		
		if (CollectionUtils.isEmpty(response))
			throw new RemedyServiceException("Nessun utente trovato per " + personId);
		if (response.size() > 1)
			throw new RemedyServiceException("Piu' di un utente trovato per " + personId, TipoErroreEnum.PERSON_ID_MOLTE_COMPANY);
		return response;
	}
	
	/**
	 * Recupera un utente per person id
	 * @param email
	 * @return
	 * @throws RemedyServiceException
	 */
	public List<UtenteDto> recuperaTuttiUtenti () throws RemedyServiceException {
		String xRequestID = UUID.randomUUID().toString();
		String xForwardedFor = "127.0.0.1";
		String filter = null;
		String sort = null;
		Integer offset = null;
		Integer limit = 20;
		
		List<RichiedenteDaAnagrafica> response = richiedenteApi.getUserList(xRequestID, xForwardedFor, filter, sort, offset, limit);
		
		return remedyTypesMapper.listaUtenteVersoPortale(response);
	}
	
	/**
	 * Elenco delle categorie operative
	 * @param ente
	 * @return
	 * @throws RemedyServiceException 
	 */
	public List<CategoriaOperativaTicketDto> elencoCategorieOperative (String ente) throws RemedyServiceException {
		if (StringUtils.isEmpty(ente))
        	throw new RemedyServiceException("Campo obbligatorio: " + ente);
		
		String xRequestID = UUID.randomUUID().toString();
        String xForwardedFor = "127.0.0.1";
        String filter = null;
        String sort = null;
        Integer offset = null;
        Integer limit = null;
        
        List<CategoriaOperativaTicket> response = categoriaApi.getOpCategoriesList(xRequestID, xForwardedFor, filter, sort, offset, limit);
        
        return remedyTypesMapper.elencoCategorieOperativaVersoPortale(response);
	}
	
	/**
	 * Recupera lo stato del ticket a partire dal suo identificativo
	 * @param ticketId
	 * @return
	 * @throws RemedyServiceException 
	 */
	public LavorazioneTicketDto recuperaStatoTicket (String ticketId) throws RemedyServiceException {
		if (StringUtils.isEmpty(ticketId))
        	throw new RemedyServiceException("Campo obbligatorio: " + ticketId);
		
		String xRequestID = UUID.randomUUID().toString();
        String xForwardedFor = "127.0.0.1";
        try {
        	LavorazioneTicket response = ticketApi.getWorkinfoTicket(xRequestID, xForwardedFor, ticketId);
        	return remedyTypesMapper.dettaglioTicketVersoPortale(response);
        } catch (RestClientResponseException e) {
        	log.error("Errore durante l'invocazione dei servizi Remedy");
        	throw new RemedyServiceException("Errore inatteso durante la comunicazione con Remedy : " + e.getResponseBodyAsString());
        }
	}
	
	/**
	 * Elenco delle lavorazioni - Info Note con allegati di una segnalazione
	 * @param ticketId
	 * @return
	 * @throws RemedyServiceException 
	 */
	public List<InfoNotaAttachmentsDto> elencoLavorazioniTicket (String ticketId) throws RemedyServiceException {
		if (StringUtils.isEmpty(ticketId))
        	return new ArrayList<>();
		
		String xRequestID = UUID.randomUUID().toString();
        String xForwardedFor = "127.0.0.1";
        String filter = null;
        String sort = null;
        Integer offset = null;
        Integer limit = null;
        List<InfoNotaAttachments> response = ticketApi.getWorklogsTicket(xRequestID, xForwardedFor, ticketId, filter, sort, offset, limit);
        
        return remedyTypesMapper.elencoLavorazioneVersoPortale(response);

	}
	
	/**
	 * Restituisce il dettagio di una nota di lavorazione
	 * @param ticketId identificativo ticket
	 * @param logId identificativo della nota
	 * @return
	 * @throws RemedyServiceException 
	 */
	public InfoNotaAttachmentsDto dettaglioLavorazioneTicket (String ticketId, String logId) throws RemedyServiceException {
		
		if (StringUtils.isEmpty(ticketId))
        	throw new RemedyServiceException("Campo obbligatorio: " + ticketId);
		
		if (StringUtils.isEmpty(logId))
			throw new RemedyServiceException("Campo obbligatorio: " + logId);
		
		String xRequestID = UUID.randomUUID().toString();
        String xForwardedFor = "127.0.0.1";
        InfoNotaAttachments response = ticketApi.getWorklogTicket(xRequestID, xForwardedFor, ticketId, logId);
        
        return remedyTypesMapper.lavorazioneVersoPortale(response);
	}
	
	
	/**
	 * Aggiunge una nota di lavorazione al ticket
	 * @param ticketId identificativo del ticket
	 * @param riepilogo riepilogo lavorazione
	 * @param tipologia tipologia lavorazione
	 * @param note nota lavorazione
	 * @param nomeAllegato1 nome del file da allegare
	 * @param customKey allegato
	 * @return
	 * @throws RemedyServiceException 
	 */
	public InfoNotaWLogDto inserisciNotaLavorazioneTicket (String ticketId, String riepilogo, String tipologia, String note, String nomeAllegato1, File customKey) throws RemedyServiceException {

		if (StringUtils.isEmpty(ticketId))
        	throw new RemedyServiceException("Campo obbligatorio: " + ticketId);
		
		
		String xRequestID = UUID.randomUUID().toString();
        String xForwardedFor = "127.0.0.1";
		InfoNotaWLog response = ticketApi.addWorkinfoTicket(xRequestID, xForwardedFor, ticketId, riepilogo, tipologia, note, nomeAllegato1, customKey);
        return remedyTypesMapper.risultatoInserimentoNotaVersoPortale(response);
	}
	
	/**
	 * Crea una nuova segnalazione
	 * @param ticketRichiesto
	 * @return
	 * @throws RemedyServiceException
	 */
	public String creazioneTicket (TicketDto ticketRichiesto) throws RemedyServiceException {
		
        String xRequestID = UUID.randomUUID().toString();
        String xForwardedFor = "127.0.0.1";
        
        RichiedenteDaAnagrafica utenteFromPersonId = internoUtentePerPersonId(ticketRichiesto.getPersonId()).get(0);
		
//		richiedenteTicket.setCompany(utenteFromPersonId.getCompany());s
        
        Ticket ticket = new Ticket();
        
        CategorizzazioneTicket categorizzazione = new CategorizzazioneTicket();
        
        CategoriaOperativaBaseModel categoriaOperativa = new CategoriaOperativaBaseModel();        
        categoriaOperativa.setLivello1(ticketRichiesto.getCategoriaOperativaLivello1());
        categoriaOperativa.setLivello2(ticketRichiesto.getCategoriaOperativaLivello2());
        categoriaOperativa.setLivello3(ticketRichiesto.getCategoriaOperativaLivello3());
        categoriaOperativa.setTipologia(TipologiaEnum.valueOf(ticketRichiesto.getTipologiaCategoriaOperativa().name()) );
        categoriaOperativa.setEnte(utenteFromPersonId.getCompany().getCompanyId());
        
		categorizzazione.setCategoriaOperativa(categoriaOperativa);
        
		ticket.setCategorizzazione(categorizzazione);
		ticket.setDettaglio(ticketRichiesto.getDettaglio());
		ticket.setImpatto(ImpattoEnum.valueOf(ticketRichiesto.getImpatto().name()));
		
		RichiedenteTicket richiedenteTicket = new RichiedenteTicket();
		

		
		richiedenteTicket.setPersonId(ticketRichiesto.getPersonId());
		ticket.setRichiedente(richiedenteTicket);
		
		ticket.setUrgenza(UrgenzaEnum.valueOf(ticketRichiesto.getUrgenza().name()));
		ticket.setRiepilogo(ticketRichiesto.getOggetto());
		ticket.setTipologia(it.csi.nivola.nivolasp.integration.remedy.model.Ticket.TipologiaEnum.valueOf(ticketRichiesto.getTipologiaCategoriaOperativa().name()));
		
        Ticket response = ticketApi.createTicket(xRequestID, xForwardedFor, ticket);
        
        return response.getTicketId();
	}
	
	/**
	 * Fornisce una decodifica delle tipologie di categoria operative utile per l'apertura del ticket
	 * @return
	 */
	public List<DecodificaDto> elencoTipologieCategoriaOperativa () {
		List<DecodificaDto> decodifica = new ArrayList<DecodificaDto>(TipologiaEnum.values().length);
		for (TipologiaEnum valore : TipologiaEnum.values()) {
			decodifica.add(new DecodificaDto(valore.name(), valore.getValue()));
		}
		return decodifica;
	}
	
	/**
	 * Elenco dei possibili tipi di impatto utile per l'apertura del ticket
	 * @return
	 */
	public List<DecodificaDto> elencoTipiImpatto () {
		List<DecodificaDto> decodifica = new ArrayList<DecodificaDto>(ImpattoEnum.values().length);
		for (ImpattoEnum valore : ImpattoEnum.values()) {
			decodifica.add(new DecodificaDto(valore.name(), valore.getValue()));
		}
		return decodifica;
	}
	
	/**
	 * Elenco dei possibili tipi di ticket utile per l'apertura del ticket
	 * @return
	 */
	public List<DecodificaDto> elencoTipiTicket () {
		List<DecodificaDto> decodifica = new ArrayList<DecodificaDto>(it.csi.nivola.nivolasp.integration.remedy.model.Ticket.TipologiaEnum.values().length);
		for (Ticket.TipologiaEnum valore : Ticket.TipologiaEnum.values()) {
			decodifica.add(new DecodificaDto(valore.name(), valore.getValue()));
		}
		return decodifica;
	}
	
	public List<DecodificaDto> elencoStatiTicket () {
		List<DecodificaDto> decodifica = new ArrayList<DecodificaDto>(LavorazioneTicket.StatoEnum.values().length);
		for (LavorazioneTicket.StatoEnum valore : LavorazioneTicket.StatoEnum.values()) {
			decodifica.add(new DecodificaDto(valore.name(), valore.getValue()));
		}
		return decodifica;
	}
	
	/**
	 * Restituisce l'elenco delle tipologie possibili per info Nota
	 * @return
	 */
	public List<DecodificaDto> elencoTipiInfoNota () {
		List<DecodificaDto> decodifica = new ArrayList<DecodificaDto>(it.csi.nivola.nivolasp.integration.remedy.model.Ticket.TipologiaEnum.values().length);
		for (InfoNotaAttachments.TipologiaEnum valore : InfoNotaAttachments.TipologiaEnum.values()) {
			decodifica.add(new DecodificaDto(valore.name(), valore.getValue()));
		}
		return decodifica;
	}
	
	public List<DecodificaDto> elencoTipiUrgenza () {
		List<DecodificaDto> decodifica = new ArrayList<DecodificaDto>(UrgenzaEnum.values().length);
		for (UrgenzaEnum valore : UrgenzaEnum.values()) {
			decodifica.add(new DecodificaDto(valore.name(), valore.getValue()));
		}
		return decodifica;
	}
}
