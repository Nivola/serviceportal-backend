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

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.csi.nivola.nivolasp.config.ApplicationProperties;
import it.csi.nivola.nivolasp.domain.SpAccountAttributo;
import it.csi.nivola.nivolasp.domain.SpAssegnatarioRichiesta;
import it.csi.nivola.nivolasp.domain.SpDRemedyCatOperativa;
import it.csi.nivola.nivolasp.domain.SpDRemedyUrgenza;
import it.csi.nivola.nivolasp.domain.SpDTipoForm;
import it.csi.nivola.nivolasp.domain.SpFormAllegato;
import it.csi.nivola.nivolasp.domain.SpFormRichieste;
import it.csi.nivola.nivolasp.domain.SpUser;
import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.exception.SystemException;
import it.csi.nivola.nivolasp.integration.remedy.portal.dto.CategoriaOperativaTicketDto;
import it.csi.nivola.nivolasp.integration.remedy.portal.dto.InfoNotaWLogDto;
import it.csi.nivola.nivolasp.integration.remedy.portal.dto.TicketDto;
import it.csi.nivola.nivolasp.integration.remedy.portal.service.RemedyService;
import it.csi.nivola.nivolasp.integration.remedy.portal.service.RemedyServiceException;
import it.csi.nivola.nivolasp.integration.rest.api.service.AuthorityApi;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetAccountResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetDivisionResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetOrganizationResponseSchema;
import it.csi.nivola.nivolasp.repository.SpAccountAttributoRepository;
import it.csi.nivola.nivolasp.repository.SpAssegnatarioRichiestaRepository;
import it.csi.nivola.nivolasp.repository.SpDRemedyCatOperativaRepository;
import it.csi.nivola.nivolasp.repository.SpDRemedyImpattoRepository;
import it.csi.nivola.nivolasp.repository.SpDRemedyTipologiaRepository;
import it.csi.nivola.nivolasp.repository.SpDRemedyUrgenzaRepository;
import it.csi.nivola.nivolasp.repository.SpDTipoFormRepository;
import it.csi.nivola.nivolasp.repository.SpFormAllegatoRepository;
import it.csi.nivola.nivolasp.repository.SpFormRichiesteRepository;
import it.csi.nivola.nivolasp.repository.SpUserRepository;
import it.csi.nivola.nivolasp.service.dto.AbstractBaseForm;
import it.csi.nivola.nivolasp.service.dto.DatiSinteticiUtenteDto;
import it.csi.nivola.nivolasp.service.dto.ExportCSV;
import it.csi.nivola.nivolasp.service.dto.RichiestaAssegnazioneSegnalazione;
import it.csi.nivola.nivolasp.service.dto.VerificaAssistenzaDto;

/**
 * Servizio per la gestione delle form di richiesta assistenza -> segnalazioni Remedy
 */
@Service
@Transactional
public class FormAssistenzaService {
	
	private static final String SEP = ";";
	
	private static final String N_LINE = "\r\n";
	
	SimpleDateFormat formatoGiorno = new SimpleDateFormat("dd/MM/yyyy");
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	private static final String FORM_PACKAGE = "it.csi.nivola.nivolasp.service.dto.form.";
	
	
	
	@Autowired
	SpDTipoFormRepository spDTipoFormRepository;
	
	@Autowired
	SpFormRichiesteRepository spFormRichiesteRepository;
	
	@Autowired
	SpFormAllegatoRepository spFormAllegatoRepository;
	@Autowired
	public AuthorityApi authorityApi;
	
	@Autowired
	RemedyService remedyService;
	
	@Autowired
	NewTransactionService newTransactionService;
	
	@Autowired
	SpAccountAttributoRepository spAccountAttributoRepository;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	SpDRemedyImpattoRepository spDRemedyImpattoRepository;
	
	@Autowired
	SpDRemedyCatOperativaRepository spDRemedyCatOperativaRepository;
	
	@Autowired
	SpDRemedyTipologiaRepository spDRemedyTipologiaRepository;
	
	@Autowired
	SpDRemedyUrgenzaRepository spDRemedyUrgenzaRepository;
	
	@Autowired
	SpAssegnatarioRichiestaRepository spAssegnatarioRichiestaRepository;
	
	@Autowired
	SpUserRepository spUserRepository;
	
	@Autowired
	ApplicationProperties applicationProperties;
	
//	private Logger log = LoggerFactory.getLogger(FormAssistenzaService.class);
	
	/**
	 * Elenco di tutte le richieste di assistenza per l'account dell'operatore. Se BOADMIN l'elenco è di tutte le richieste
	 * @param stato 
	 * @param accountId 
	 * @param userId 
	 * @return
	 * @throws BusinessException
	 */
	public List<SpFormRichieste> elencoRichieste (Long userId, String accountId, String stato) throws BusinessException {
		SpFormRichieste filtro = new SpFormRichieste();
		if (userId != null && userId != 0L) {
			SpUser utenteInserimento = new SpUser();
			utenteInserimento.setUsaCredenziali(null);
			utenteInserimento.setId(userId);
			filtro.setUtenteInserimento(utenteInserimento);
		}
		filtro.setRefAccount(accountId);
		if (StringUtils.isNotEmpty(stato))
			filtro.setStato(stato);
		
		return spFormRichiesteRepository.findAll(Example.of(filtro));
	}
	
	/**
	 * Recupera una richiesta di assistenza per id
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public SpFormRichieste recuperaRichiestaPerId (String id ) throws BusinessException {
		SpFormRichieste richiesta = spFormRichiesteRepository.findOne(id);
		return richiesta;
	}
	
	/**
	 * Recupera il tipo di form partendo dal nome
	 * @param nome
	 * @return
	 */
	public SpDTipoForm recuperaTipoFormPerNome (String nome) {
		return spDTipoFormRepository.findByNome(nome);
	}
	
	/**
	 * Prima di proporre il percorso di apertura della segnalazione recupera il livello di asssitenza e la corretta configurazione
	 * per poter effettuare la richiesta 
	 * @param accountId
	 * @return
	 */
	public VerificaAssistenzaDto verificaRequisitiAccount(String accountId) {
		VerificaAssistenzaDto verifica = new VerificaAssistenzaDto();
		SpAccountAttributo attributoAccount = spAccountAttributoRepository.findByRefAccount(accountId);
		
		if (attributoAccount != null && StringUtils.isNotEmpty(attributoAccount.getPersonId())) {
			verifica.setAccountConfiguratoRemedy(true);
		}
			
		Object [] rs = spAccountAttributoRepository.recuperaTenantDiAccount(accountId);
		if (rs != null && rs.length > 0) {
			Object [] campi = (Object[])rs[0];
			verifica.setIdTenant(Double.valueOf((double)campi[0]).intValue());
			verifica.setDescrizioneTenant((String)campi[1]);
		}
		return verifica;
	}
	
	/**
	 * Salva
	 * @param tipoForm
	 * @param form
	 * @param json
	 * @param file 
	 * @return
	 * @throws RemedyServiceException 
	 * @throws IOException 
	 * @throws BusinessException 
	 */
	public SpFormRichieste salvaInviaRichiesta (SpDTipoForm tipoForm, AbstractBaseForm form, String json, MultipartFile file, SpUser utenteCorrente, String accountId) throws RemedyServiceException, BusinessException, IOException  {
		//si cerca il person id sulla account attributo, se non c'è il record o person id vuoto si manda per email la richiesta al supporto indicando l'errore.
		File tmpFile = null;
		SpFormRichieste daSalvare = new SpFormRichieste();
		String tipologiaInfo = "Customer Communication";
		if (form.getFormId() != null) {
			daSalvare = spFormRichiesteRepository.findOne(form.getFormId().toString());
		}
		
		daSalvare.setJson(json);
		daSalvare.setRefAccount(form.getAccountId());
		daSalvare.setSpDTipoForm(tipoForm);
		daSalvare.setUtenteInserimento(utenteCorrente);
		daSalvare.setDataInserimento(new Date(System.currentTimeMillis()));
		daSalvare.setInviato(false);
		daSalvare.setStato("Assegnato");
//		daSalvare.setScope(form.getqScope().getValore());
		daSalvare.setScope("");
		daSalvare.setService(form.getqServ());;
		daSalvare.setTecnologia(form.getqTecnologia());
		daSalvare.setTipo(form.getqTipo());
		daSalvare.setRiepilogoScelte(form.getRiepilogoScelte());
		if (form.getqSev() == null || form.getqSev() == 0)
			form.setqSev(1L);
		daSalvare.setSpDRemedyUrgenza(spDRemedyUrgenzaRepository.findOne(form.getqSev()));
		GetAccountResponseSchema account = authorityApi.v10NwsAccountsOidGet(form.getAccountId());
		GetDivisionResponseSchema divisone = authorityApi.v10NwsDivisionsOidGet(account.getAccount().getDivisionId());
		GetOrganizationResponseSchema orgenizzazione = authorityApi.v10NwsOrganizationsOidGet(divisone.getDivision().getOrganizationId());
		try {
			
			SpFormAllegato spFormAllegato = new SpFormAllegato();
			if (file != null && !daSalvare.getSpFormAllegatos().stream().anyMatch(all -> file.getOriginalFilename().equals(all.getNome()))) {
				spFormAllegato.setFile(file.getBytes());
				spFormAllegato.setNome(file.getOriginalFilename());
				spFormAllegato.setNote("Allegato utente in creazione richiesta");
				spFormAllegato.setRiepilogo("Allegato utente");
				spFormAllegato.setDataInserimento(new Timestamp(System.currentTimeMillis()));
				spFormAllegato.setUtenteInserimento(utenteCorrente);
				spFormAllegato.setTipologia(tipologiaInfo);
				daSalvare.addSpFormAllegato(spFormAllegato);
			}
			
			if (form.getInvia()) {
				
				TicketDto ticketRichiesto = new TicketDto();
				SpDRemedyCatOperativa cat = spDRemedyCatOperativaRepository.findByCodTecnologia(form.getqTecnologia());
				SpAccountAttributo attributoAccount = spAccountAttributoRepository.findByRefAccount(accountId);
				if (attributoAccount == null || StringUtils.isEmpty(attributoAccount.getPersonId()))
					throw new BusinessException ("Errore: account non configurato correttamente per l'apertura di segnalazioni, contattare l'assistenza fornendo il nome dell'account in uso.");
				if (cat == null) {
					cat = new SpDRemedyCatOperativa();
					cat.setLivello1("1L - Gestione Nivola");
					cat.setLivello2("gestione e monitoraggio");
					cat.setLivello3("gestione e monitoraggio");
					cat.setTipologiaTripletta("Ripristino di servizio utente");
				}
				
				Double tenant = 1.0;
				String descrizioneTenant = "non trovato, usato livello di assistenza minimo.";
				// BUG SPRING
				Object [] rs = spAccountAttributoRepository.recuperaTenantDiAccount(account.getAccount().getUuid());
				if (rs != null && rs.length > 0) {
					Object [] campi = (Object[])rs[0];
					tenant = (double)campi[0];
					descrizioneTenant = (String)campi[1];
				}
				
				ticketRichiesto.setCategoriaOperativaLivello1(cat.getLivello1());
				ticketRichiesto.setCategoriaOperativaLivello2(cat.getLivello2());
				ticketRichiesto.setCategoriaOperativaLivello3(cat.getLivello3());
				ticketRichiesto.setTipologiaCategoriaOperativa(CategoriaOperativaTicketDto.TipologiaEnum.fromValue(cat.getTipologiaTripletta()));
				String accountDivisione = "Account: " + account.getAccount().getName() + "\nDivisione: " + divisone.getDivision().getName() + "\nOrganizzazione"+ orgenizzazione.getOrganization().getName() +"\n Livello tenant " + descrizioneTenant;
				accountDivisione += "\nRichiedente: " + utenteCorrente.getNome() + " " + utenteCorrente.getCognome();
				ticketRichiesto.setDettaglio(accountDivisione + "\n" + form.componiTestoDaParametri());
				ticketRichiesto.setEmailRichiedente(utenteCorrente.getEmail());
				ticketRichiesto.setPersonId(attributoAccount.getPersonId());
				if (form.getqSev() == null)
					form.setqSev(1L);
				ticketRichiesto.setImpatto(it.csi.nivola.nivolasp.integration.remedy.portal.dto.TicketDto.ImpattoEnum.fromValue(spDRemedyImpattoRepository.findOne(form.getqSev()).getValoreRemedy()));
				ticketRichiesto.setOggetto(form.getOggetto());
				
				ticketRichiesto.setUrgenza(it.csi.nivola.nivolasp.integration.remedy.portal.dto.TicketDto.UrgenzaEnum.fromValue(spDRemedyUrgenzaRepository.trovaUrgenzaAccountGestioneLivelloTenantBetween(form.getqSev(), form.getqTipo(), tenant.longValue()).getUrgenza()));
				
				String ticketId = remedyService.creazioneTicket(ticketRichiesto);
				
				daSalvare.setTicketId(ticketId);
				daSalvare.setDataInvio(new Date(System.currentTimeMillis()));
				daSalvare.setInviato(true);
				daSalvare.setUtenteInvio(utenteCorrente);
				if (file != null) {
					tmpFile = new File ("/home/wildfly/"+file.getOriginalFilename());
					FileUtils.copyInputStreamToFile(file.getInputStream(), tmpFile);
					InfoNotaWLogDto risposta = remedyService.inserisciNotaLavorazioneTicket(ticketId, "Allegato utente", tipologiaInfo, "Allegato utente in creazione richiesta", file.getOriginalFilename(), tmpFile);
					spFormAllegato.setLogId(risposta.getLogId());
				}
				spFormAllegato.setInviato(true);
				
				mailService.sendEmail("no-reply-nivola.support@csi.it", utenteCorrente.getEmail(), "Apertura segnalazione " + ticketId, "E' stata creata la segnalazione tramite Remedy con ticket id: " + ticketId +"\n\nE' possibile seguire lo stato della segnalazione ed effettuare integrazioni tramite la sezione \"Assistenza\" disponibile sul portale." + 
				"\n\nOggetto della richiesta: " + form.getOggetto() + "\n\nTesto della richiesta: "  + form.getDescrizione(), false, false);
			}
		} catch (RestClientResponseException e){
			String testoConPlaceholder = "Si e' verificato un errore durante l'apertura del ticket da parte dell'utente "+utenteCorrente.getNome()+
					" " + utenteCorrente.getCognome() +"\n"
					+"Account: "+account.getAccount().getName()+
					"\nDivisione: "+divisone.getDivision().getName()+
					"\n\nContenuto della richiesta (ai fini del debug):\n"+json+
					"\n\nRisposta ricevuta: " + e.getResponseBodyAsString()+
					"\n\nErrore:\n" + ExceptionUtils.getStackTrace(e) ;
			String subject = "Errore durante l'apertura della segnalazione";
			mailService.sendEmail(applicationProperties.getDeploy().getIndirizzoServizio(), "andrea.fontana@csi.it,luciano.gallo@consulenti.csi.it,ezio.raymondi@csi.it".split(","), subject, testoConPlaceholder, false, false);
			throw e;
		} finally {
			newTransactionService.salvaFormRichieste(daSalvare);
			if (tmpFile != null && tmpFile.canWrite()) {
				tmpFile.delete();
			}
		}

		return daSalvare;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public SpFormRichieste effettuaSalvataggio (SpFormRichieste daSalvare) {
		return spFormRichiesteRepository.saveAndFlush(daSalvare);
	}
	
	/**
	 * Allega un file su remedy e lo salva
	 * @param formDb
	 * @param riepilogo
	 * @param tipologia
	 * @param note
	 * @param file
	 * @throws BusinessException
	 * @throws IOException
	 * @throws RemedyServiceException
	 */
	public void allegaFile(SpFormRichieste formDb, String riepilogo, String tipologia, String note, MultipartFile file, boolean isBackofficeAdmin, SpUser utenteCorrente) throws BusinessException, IOException, RemedyServiceException {
		String tipologiaInfo = "Customer Communication";
		String emailDaAvvisare = applicationProperties.getDeploy().getIndirizzoServizio();
		Comparator<SpFormAllegato> comp = Comparator.comparingInt(SpFormAllegato::getId).reversed();
		Optional<SpFormAllegato> integrazionePrecedente = formDb.getSpFormAllegatos().stream().sorted(comp).findFirst();
		if (integrazionePrecedente.isPresent())
			if ("Detail Clarification".equalsIgnoreCase(integrazionePrecedente.get().getTipologia())) {
				emailDaAvvisare = integrazionePrecedente.get().getUtenteInserimento().getEmail();
			}
		if (isBackofficeAdmin) {
			tipologiaInfo = "Detail Clarification";
			emailDaAvvisare = formDb.getUtenteInvio().getEmail();
		}
		File tmpFile = null;
		String filename = null;
		if (formDb.getInviato() == false) {
			throw new BusinessException("Form con id: " + formDb.getId() + " non inviato. Impossibile proseguire");
		}
		SpFormAllegato allegato = new SpFormAllegato();
		if (file != null) {
			tmpFile = new File ("/home/wildfly/"+file.getName());
			FileUtils.copyInputStreamToFile(file.getInputStream(), tmpFile);
			filename = file.getName();
			allegato.setFile(file.getBytes());
			allegato.setNome(file.getOriginalFilename());
			
		}
		allegato.setDataInserimento(new Timestamp(System.currentTimeMillis()));
		allegato.setUtenteInserimento(utenteCorrente);
		allegato.setInviato(false);
		allegato.setNote(note);
		allegato.setRiepilogo(riepilogo);
		allegato.setTipologia(tipologiaInfo);
		allegato.setSpFormRichieste(formDb);
		try {
			InfoNotaWLogDto risposta = remedyService.inserisciNotaLavorazioneTicket(formDb.getTicketId(), riepilogo, tipologiaInfo, note, filename, tmpFile);
			allegato.setLogId(risposta.getLogId());
			allegato.setInviato(true);
			mailService.sendEmail("no-reply-nivola.support@csi.it", emailDaAvvisare, "E' stata effettuata un'integrazione alla segnalazione " + formDb.getTicketId(), "Con identificativo integrazione" + risposta.getLogId() + "\n\nL'oggetto della modifica è il seguente: "+ riepilogo + "\n\nNote di lavorazione"+ note + "\n\nE' possibile seguire lo stato della segnalazione ed effettuare integrazioni tramite la sezione \"Assistenza\" disponibile sul portale." , false, false);
		} finally {
			newTransactionService.salvaAllegato(allegato);
			if (tmpFile != null && tmpFile.canWrite()) {
				tmpFile.delete();
			}
		}
	}
	
	/**
	 * Invia a Remedy un file allegato in precedenza
	 * @param idAllegato
	 * @param riepilogo
	 * @param tipologia
	 * @param note
	 * @throws BusinessException
	 * @throws IOException
	 * @throws RemedyServiceException
	 */
	public void inviaFileEsistente(Integer idAllegato, String riepilogo, String tipologia, String note, SpUser utenteCorrente) throws BusinessException, IOException, RemedyServiceException {
		
		SpFormAllegato allegatoDb = recuperaAllegatoPerId(idAllegato);
		
		if (allegatoDb.getInviato() == null || allegatoDb.getInviato()) {
			throw new BusinessException("Allegato gia' inviato. Impossibile proseguire");
		}

		if (allegatoDb.getSpFormRichieste().getInviato() == null || allegatoDb.getSpFormRichieste().getInviato()) {
			throw new BusinessException("Allegato appartenente ad un form non inviato. Impossibile proseguire");
		}
		
		File tmpFile = new File ("/home/wildfly/"+allegatoDb.getNome());
		FileUtils.writeByteArrayToFile(tmpFile, allegatoDb.getFile());
		
		try {
			InfoNotaWLogDto risposta = remedyService.inserisciNotaLavorazioneTicket(allegatoDb.getSpFormRichieste().getTicketId(), riepilogo, "General", note, allegatoDb.getNome(), tmpFile);
			allegatoDb.setInviato(true);
			allegatoDb.setLogId(risposta.getLogId());
			mailService.sendEmail("no-reply-nivola.support@csi.it", utenteCorrente.getEmail(), "E' stata effettuata un'integrazione alla segnalazione " + allegatoDb.getSpFormRichieste().getTicketId(), "Con identificativo integrazione" + risposta.getLogId() + "\n\nL'oggetto della modifica è il seguente: "+ riepilogo + "\n\nE' possibile seguire lo stato della segnalazione ed effettuare integrazioni tramite la sezione \"Assistenza\" disponibile sul portale." , false, false);
		} finally {
			newTransactionService.salvaAllegato(allegatoDb);
			if (tmpFile != null && tmpFile.canWrite()) {
				tmpFile.delete();
			}
		}
		
		
		tmpFile.delete();
	}
	
	/**
	 * Scarica un allegato con identificativo DB
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public SpFormAllegato recuperaAllegatoPerId (Integer id) throws BusinessException {
		
		SpFormAllegato allegato = spFormAllegatoRepository.findOne(id);
		
		return allegato;
	}
	
	/**
	 * Scarica un allegato con identificativo Remedy
	 * @param wlog
	 * @return
	 * @throws BusinessException
	 */
	public SpFormAllegato recuperaAllegatoPerWlog (String wlog) throws BusinessException {
		
		SpFormAllegato allegato = spFormAllegatoRepository.findByLogId(wlog);
		
		return allegato;
	}
	
	/**
	 * Aggiorna l'urgenza di una segnalazione
	 * @param id
	 * @param urgenza
	 * @throws BusinessException
	 */
	public void aggiornaUrgenza (String id , Long urgenza) throws BusinessException {
		SpFormRichieste richiesta = spFormRichiesteRepository.findById(id).orElseThrow(() -> new BusinessException("Richiesta con id " + id + " non trovata"));
		SpDRemedyUrgenza urgenzaTrovata = spDRemedyUrgenzaRepository.findById(urgenza).orElseThrow(() -> new BusinessException("Urgenza con id " + urgenza + " non trovata"));

		richiesta.setSpDRemedyUrgenza(urgenzaTrovata);
		
		spFormRichiesteRepository.saveAndFlush(richiesta);
		
	}
	
	/**
	 * Assegna una segnalazione
	 * @param assegnazione
	 */
	@Transactional
	public void assegnaSegnalazioneUtente (RichiestaAssegnazioneSegnalazione assegnazione, SpUser user) throws BusinessException {
		
		SpFormRichieste formAfferente = spFormRichiesteRepository.findById(assegnazione.getIdRichiesta()+"").orElseThrow(() -> new BusinessException("Form con id " + assegnazione.getIdRichiesta() + " non trovato"));
		
		//cerco e disattivo il precedente assegnatario
		Optional<SpAssegnatarioRichiesta> assegnatarioPrecedente = spAssegnatarioRichiestaRepository.findByRichiestaAndAttivoTrue(formAfferente);
		
		assegnatarioPrecedente.ifPresent(assegnatario -> { 
			assegnatario.setAttivo(false);
			assegnatario.setDataFineValidita(new Date(System.currentTimeMillis()));
			assegnatario.setAgente(user);
			spAssegnatarioRichiestaRepository.saveAndFlush(assegnatario);
		});
		
		SpAssegnatarioRichiesta nuovoAssegnatario = new SpAssegnatarioRichiesta();
		nuovoAssegnatario.setAttivo(true);
		nuovoAssegnatario.setDataFineValidita(assegnazione.getDataFineValidita());
		nuovoAssegnatario.setDataInizioValidita(new Date(System.currentTimeMillis()));
		nuovoAssegnatario.setAgente(user);
		
		nuovoAssegnatario.setRichiesta(formAfferente);
		nuovoAssegnatario.setAssegnatario(spUserRepository.findOne(assegnazione.getIdUtenteAssegnatario()));
		spAssegnatarioRichiestaRepository.saveAndFlush(nuovoAssegnatario);
	}

	/**
	 * Elenca tutti gli utenti di tipo TICKETOPERATOR
	 * @param startBy
	 * @return
	 */
	public List<DatiSinteticiUtenteDto> ricercaUtenteTicketOperatorCognome(String startBy) {
		return spUserRepository.trovaUtentiTicketOperator(StringUtils.trimToEmpty(startBy)).orElse(new ArrayList<SpUser>()).parallelStream().map(u -> mappaInDatiSintetici(u)).collect(Collectors.toList());
	}
	
	public void eliminaSegnalazioneBozza(String id, boolean admin, String accountId) throws BusinessException {
		SpFormRichieste trovata = spFormRichiesteRepository.findOne(id);
		
		if (!admin && !trovata.getRefAccount().equals(accountId)) {
			throw new BusinessException("Nessuna segnalazione trovata per l'account corrente");
		}
		
		spFormRichiesteRepository.delete(trovata);
		
	}
	
	
	public ExportCSV elencoTicketApertiCSV() throws BusinessException {
		Optional<List<SpFormRichieste>> elencoTicketAperti = spFormRichiesteRepository.elencoTicketInCorsoDiLavorazione();
		StringBuilder sb = new StringBuilder();
//		ListAccountsResponseSchema elencoAccoutTotale = authorityApi.v10NwsAccountsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
//		ListDivisionsResponseSchema tutteDivisioni = authorityApi.v10NwsDivisionsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
//		ListOrganizationsResponseSchema tutteOrganizzazioni = authorityApi.v10NwsOrganizationsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		
		
//		sb.append("Organizzazione").append(SEP);
//		sb.append("Divisione").append(SEP);
//		sb.append("Account").append(SEP);
		sb.append("Tipo Segnalazione").append(SEP);
		sb.append("Numero Ticket").append(SEP);
		sb.append("Oggetto").append(SEP);
		sb.append("Stato Ticket").append(SEP);
		sb.append("Inviata").append(SEP);
		sb.append("Inviata Da").append(SEP);
		sb.append("In Data").append(SEP);
		sb.append("Assegnatario").append(SEP).append(N_LINE);

		elencoTicketAperti.orElseGet(() -> new ArrayList<SpFormRichieste>()).forEach(ticket -> sb.append(rigaTicket(/*tutteOrganizzazioni, tutteDivisioni, elencoAccoutTotale, */ticket)));
		
		ExportCSV risposta = new ExportCSV();
		risposta.setFile(sb);
		risposta.setFilename("Elenco segnalazioni non terminate.csv");
		return risposta;
	}

	/*
	 * Riga del singolo ticket 
	 * @param ticket
	 * @return
	 */
	private StringBuilder rigaTicket(/*ListOrganizationsResponseSchema tutteOrganizzazioni, ListDivisionsResponseSchema tutteDivisioni, ListAccountsResponseSchema elencoAccoutTotale,*/ SpFormRichieste ticket) {
		StringBuilder sb = new StringBuilder();
		AbstractBaseForm form;
		try {
			form = (AbstractBaseForm) mapper.readValue(ticket.getJson(), Class.forName(FORM_PACKAGE+ticket.getSpDTipoForm().getClasseJson()));
			sb.append(form.getqTipo()).append(SEP);
			sb.append(ticket.getTicketId()).append(SEP);;
			sb.append(form.getOggetto()).append(SEP);
			sb.append(ticket.getStato()).append(SEP);
			sb.append(ticket.getInviato() ? "SI" : "NO").append(SEP);
			sb.append(ticket.getUtenteInvio().getNome() + " " + ticket.getUtenteInvio().getCognome()).append(SEP);
			sb.append(formatoGiorno.format(ticket.getDataInvio())).append(SEP);
			SpAssegnatarioRichiesta assegnatario = new SpAssegnatarioRichiesta();
			assegnatario.setAssegnatario(new SpUser());
			assegnatario = ticket.getSpAssegnatarioRichiestas().stream().filter(a -> a.getAttivo()).findFirst().orElse(assegnatario);
			sb.append(StringUtils.trimToEmpty(assegnatario.getAssegnatario().getNome()) + StringUtils.trimToEmpty(assegnatario.getAssegnatario().getCognome())).append(SEP).append(N_LINE);
		}
		catch (ClassNotFoundException | IOException e1) {
			throw new SystemException(e1);
		}
		return sb;
	}


	/*
	 * Mappaggio interno dei dati sintetici di un utente
	 */
	private DatiSinteticiUtenteDto mappaInDatiSintetici(SpUser u) {
		DatiSinteticiUtenteDto sint = new DatiSinteticiUtenteDto();
		sint.setNome(u.getNome());
		sint.setCognome(u.getCognome());
		sint.setId(u.getId());
		
		return sint;
	}

}
