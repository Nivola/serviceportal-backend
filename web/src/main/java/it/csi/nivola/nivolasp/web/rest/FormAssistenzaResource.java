/*-
 * ========================LICENSE_START=================================
 * Nivola Web
 * %%
 * Copyright (C) 2022 CSI Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | CSI Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.web.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.csi.nivola.nivolasp.domain.SpAssegnatarioRichiesta;
import it.csi.nivola.nivolasp.domain.SpDTipoForm;
import it.csi.nivola.nivolasp.domain.SpFormAllegato;
import it.csi.nivola.nivolasp.domain.SpFormRichieste;
import it.csi.nivola.nivolasp.domain.SpUser;
import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.exception.SystemException;
import it.csi.nivola.nivolasp.integration.remedy.portal.dto.DecodificaDto;
import it.csi.nivola.nivolasp.integration.remedy.portal.dto.InfoNotaAttachmentsDto;
import it.csi.nivola.nivolasp.integration.remedy.portal.dto.LavorazioneTicketDto;
import it.csi.nivola.nivolasp.integration.remedy.portal.dto.UtenteDto;
import it.csi.nivola.nivolasp.integration.remedy.portal.service.RemedyService;
import it.csi.nivola.nivolasp.integration.remedy.portal.service.RemedyServiceException;
import it.csi.nivola.nivolasp.integration.rest.api.service.AuthorityApi;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetAccountResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetDivisionResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetOrganizationResponseSchema;
import it.csi.nivola.nivolasp.security.AuthoritiesConstants;
import it.csi.nivola.nivolasp.security.SecurityUtils;
import it.csi.nivola.nivolasp.service.FormAssistenzaService;
import it.csi.nivola.nivolasp.service.MailService;
import it.csi.nivola.nivolasp.service.dto.AbstractBaseForm;
import it.csi.nivola.nivolasp.service.dto.AllegatoRemedyDTO;
import it.csi.nivola.nivolasp.service.dto.DatiSinteticiUtenteDto;
import it.csi.nivola.nivolasp.service.dto.EsitoDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoEnum;
import it.csi.nivola.nivolasp.service.dto.RichiestaAssegnazioneSegnalazione;
import it.csi.nivola.nivolasp.service.dto.RichiestaAssistenzaSintesiDTO;
import it.csi.nivola.nivolasp.service.dto.ScaricaFileDTO;
import it.csi.nivola.nivolasp.service.dto.UserDTO;
import it.csi.nivola.nivolasp.service.dto.VerificaAssistenzaDto;
import it.csi.nivola.nivolasp.web.rest.form.NotaLavorazioneForm;
import it.csi.nivola.nivolasp.web.rest.form.StatoSegnalazione;

/**
 * Rest controller per le informazioni sulle richieste Remedy effettuate dal
 * Service portal
 */
@RestController
@RequestMapping("/api")
public class FormAssistenzaResource extends AbstractResource {

	@Autowired
	RemedyService remedyService;
	
	@Autowired
	FormAssistenzaService formAssistenzaService;
	
	@Autowired
	MailService mailService;

	@Autowired
	AuthorityApi authorityApi;
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	private final Logger log = LoggerFactory.getLogger(FormAssistenzaResource.class);
	
	private static final String FORM_PACKAGE = "it.csi.nivola.nivolasp.service.dto.form.";
	
	/**
	 * Elenco delle richieste effettuate
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 */
	@GetMapping("/richiesta")
	public ResponseEntity<List<RichiestaAssistenzaSintesiDTO>> elencoSegnalazioni (Long userId, String accountId, String stato) throws BusinessException, SystemException {
		List<SpFormRichieste> elencoRichiesteDb = formAssistenzaService.elencoRichieste(userId, StringUtils.trimToNull(SecurityUtils.isBackOfficeAdmin() ? accountId : SecurityUtils.getAccountIdCorrente()), StringUtils.upperCase(stato));
		List<RichiestaAssistenzaSintesiDTO> elencoRichieste = new ArrayList<RichiestaAssistenzaSintesiDTO>(elencoRichiesteDb.size());
		
		elencoRichieste =  elencoRichiesteDb.parallelStream().map(e -> mappaRichiesta(e, false)).collect(Collectors.toList());
		return new ResponseEntity<List<RichiestaAssistenzaSintesiDTO>>(elencoRichieste, HttpStatus.OK);
	}
	
	
	/**
	 * Prima di attivare il wizard di apertura segnalazione si verifica che l'account sia correttamente configurato e si mostra il livello di assistenza
	 * @param accountId
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 */
	@GetMapping("/richiesta/requisiti")
	public ResponseEntity<VerificaAssistenzaDto> verificaRequisitiAccount (String accountId) throws BusinessException, SystemException {
		VerificaAssistenzaDto verifica = formAssistenzaService.verificaRequisitiAccount(SecurityUtils.getAccountIdCorrente(accountId));
		return new ResponseEntity<VerificaAssistenzaDto>(verifica, HttpStatus.OK);
	}
	
	@GetMapping("/richiesta/configura")
	public ResponseEntity<EsitoDTO> inviaEmailRichiestaConfigurazione (String accountId) throws BusinessException, SystemException {
		UserDTO utente = SecurityUtils.getCurrentUser();
		GetAccountResponseSchema account = authorityApi.v10NwsAccountsOidGet(SecurityUtils.getAccountIdCorrente(accountId));
		mailService.sendEmail(utente.getEmail(), applicationProperties.getDeploy().getIndirizzoServizio(), "Richiesta configurazione account per apertura Ticket", "La presente per richiedere la configurazione necessaria all'apertura dei ticket per l'account " + account.getAccount().getName() +" con id " + account.getAccount().getUuid(), false, false);
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "", "Email inviata correttamente"), HttpStatus.OK);

	}
	
	
	/**
	 * Entry point unico per l'invio di una form di richiesta assistenza. Registra i dati della form in formato JSon, recupera le informazioni rilevanti 
	 * per la creazione del ticket
	 * @param nome
	 * @param jsonBody
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws BusinessException
	 * @throws RemedyServiceException
	 */
	@PostMapping("/richiesta/{nome}/form")
	public ResponseEntity<AbstractBaseForm> salvaForm (@PathVariable String nome, @RequestParam(name="form") String jsonBody, @RequestParam(name="file", required=false) MultipartFile file ) 
			throws JsonParseException, JsonMappingException, IOException, ClassNotFoundException, BusinessException, RemedyServiceException {
		log.info("BODY: " + jsonBody);
		SpDTipoForm tipoForm = formAssistenzaService.recuperaTipoFormPerNome(nome);
		AbstractBaseForm form = (AbstractBaseForm) mapper.readValue(jsonBody, Class.forName(FORM_PACKAGE+tipoForm.getClasseJson()));
		form.valida();
		log.info("COMPOSIZIONE TESTO DA PARAMETRI: " + form.componiTestoDaParametri());
		formAssistenzaService.salvaInviaRichiesta(tipoForm, form, jsonBody, file, SecurityUtils.getUtenteLoggatoCompleto().getSpUser(), SecurityUtils.getAccountIdCorrente());
		return new ResponseEntity<AbstractBaseForm>(form, HttpStatus.OK);
	}
	
	/**
	 * Entry point unico per l'invio di una form di richiesta assistenza. Registra i dati della form in formato JSon, recupera le informazioni rilevanti 
	 * per la creazione del ticket
	 * @param nome
	 * @param jsonBody
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws BusinessException
	 * @throws RemedyServiceException
	 */
	@PutMapping("/richiesta/{id}/urgenza/{urgenza}")
	@Secured({AuthoritiesConstants.BOADMIN})
	public ResponseEntity<EsitoDTO> aggiornaUrgenza (@PathVariable String id, @PathVariable Long urgenza) throws BusinessException {
		formAssistenzaService.aggiornaUrgenza(id, urgenza);
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "", "Urgenza aggiornataCorrettamente"), HttpStatus.OK);
		
	}
	
	/**
	 * Restituisce la form di richiesta assistenza con l'aggiunta, se inviata, delle informazioni sul ticket che ha generato.
	 * @param id identificativo della richiesta (form)
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @throws RemedyServiceException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@GetMapping("/richiesta/{id}/stato")
	public ResponseEntity<StatoSegnalazione> dettaglioFormSegnalazione (@PathVariable String id) throws BusinessException, SystemException, RemedyServiceException, JsonParseException, JsonMappingException, ClassNotFoundException, IOException {
		SpFormRichieste formDb = formAssistenzaService.recuperaRichiestaPerId(id);
		if (!SecurityUtils.isBackOfficeAdmin() && !formDb.getRefAccount().equals(SecurityUtils.getAccountIdCorrente()))
			throw new BusinessException("L'utente corrente non e' abilitato a visualizzare la richiesta con id " + id);
		AbstractBaseForm form = (AbstractBaseForm) mapper.readValue(formDb.getJson(), Class.forName(FORM_PACKAGE+formDb.getSpDTipoForm().getClasseJson()));
																																   
		StatoSegnalazione segnalazione = new StatoSegnalazione();
		segnalazione.setDatiSintesi(mappaRichiesta(formDb, true));
		segnalazione.setForm(form);
		segnalazione.setTipologiaForm(formDb.getSpDTipoForm().getNome());
		segnalazione.setRiepilogoScelte(formDb.getRiepilogoScelte());
		if (formDb.getInviato()) {
			LavorazioneTicketDto statoTicket = remedyService.recuperaStatoTicket(formDb.getTicketId());
			segnalazione.setAssegnatario(statoTicket.getAssegnatario());
			segnalazione.setMotivo(statoTicket.getMotivoStato() != null ? statoTicket.getMotivoStato().name() : "");
			segnalazione.setRisoluzione(statoTicket.getRisoluzione());
			segnalazione.setStato(statoTicket.getStato() != null ? statoTicket.getStato().name() : "");
		}
		segnalazione.setAllegati(formDb.getSpFormAllegatos().stream().map(a -> {
			return mappaNotaLavoro(a);
		}).collect(Collectors.toList()));
			
		return new ResponseEntity<StatoSegnalazione>(segnalazione, HttpStatus.OK);
	}
	
	@DeleteMapping("/richiesta/{id}")
	public ResponseEntity<EsitoDTO> eliminaSegnalazioneInBozza (@PathVariable String id) throws BusinessException, SystemException, RemedyServiceException, JsonParseException, JsonMappingException, ClassNotFoundException, IOException {
		formAssistenzaService.eliminaSegnalazioneBozza(id, SecurityUtils.isBackOfficeAdmin(), SecurityUtils.getAccountIdCorrente(""));
		return null;
	}
		
	
	private AllegatoRemedyDTO mappaNotaLavoro(SpFormAllegato a) {
		AllegatoRemedyDTO allegato = new AllegatoRemedyDTO();
		allegato.setId(a.getId());
		allegato.setInviato(a.getInviato());
		allegato.setLogId(a.getLogId());
		allegato.setNomeFile(a.getNome());
		allegato.setNote(a.getNote());
		allegato.setRiepilogo(a.getRiepilogo());
		allegato.setTipologia(a.getTipologia());
		allegato.setDataInserimento(a.getDataInserimento().toLocalDateTime());
		allegato.setRichiedente(a.getUtenteInserimento().getNome() + " " + a.getUtenteInserimento().getCognome());
		return allegato;
	}
				  
	
	/**
	 * Scarica un allegato
	 * @param id identificativo dell'allegato
	 * @return
	 * @throws BusinessException
	 */
	@GetMapping("/richiesta/allegato/{id}/scarica")
	public ResponseEntity<ScaricaFileDTO> scaricaAllegato (@PathVariable String id) throws BusinessException {
		
		if (id == null)
			throw new BusinessException("Campo id obbligatorio");
		
		SpFormAllegato allegato = null;
		if (NumberUtils.isCreatable(id))
			allegato =  formAssistenzaService.recuperaAllegatoPerId(Integer.parseInt(id));
		else
			allegato = formAssistenzaService.recuperaAllegatoPerWlog(id);
		

		if (SecurityUtils.isAccount() && !SecurityUtils.getAccountIdCorrente().equals(allegato.getSpFormRichieste().getRefAccount()))
			throw new BusinessException("Utente non abilitato a scaricare l'allegato " + id);
		
		
		ScaricaFileDTO download = new ScaricaFileDTO();
		download.setFile(allegato.getFile());
		download.setNomeFile(allegato.getNome());
		
		return new ResponseEntity<ScaricaFileDTO>(download, HttpStatus.OK);
	}
	
	/**
	 * Invia un allegato già presente a sistema verso remedy aggiungendo una info nota
	 * @param id
	 * @return
	 * @throws BusinessException
	 * @throws RemedyServiceException 
	 * @throws IOException 
	 */
	@PostMapping("/richiesta/allegato/{id}/invia")
	public ResponseEntity<EsitoDTO> inviaAllegato (@PathVariable Integer id, @RequestParam NotaLavorazioneForm form) throws BusinessException, IOException, RemedyServiceException {
		formAssistenzaService.inviaFileEsistente(id, form.getRiepilogo(), form.getTipologia(), form.getNote(), SecurityUtils.getUtenteLoggatoCompleto().getSpUser());
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK,"0000", "Bozza eliminata correttamente"), HttpStatus.OK);
	}
	
	
	/**
	 * Restituisce l'elenco delle lavorazini
	 * @param id identificativo della richiesta (form)
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @throws RemedyServiceException
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@GetMapping("/richiesta/{id}/stato/dettagli")
	public ResponseEntity< List<InfoNotaAttachmentsDto>> elencoLavorazioniTicket (@PathVariable String id) throws BusinessException, SystemException, RemedyServiceException, JsonParseException, JsonMappingException, ClassNotFoundException, IOException {
		SpFormRichieste formDb = formAssistenzaService.recuperaRichiestaPerId(id);
		if (!SecurityUtils.isBackOfficeAdmin() && !formDb.getRefAccount().equals(SecurityUtils.getAccountIdCorrente()))
			throw new BusinessException("L'utente corrente non e' abilitato a visualizzare la richiesta con id " + id);
		return new ResponseEntity<List<InfoNotaAttachmentsDto>>(remedyService.elencoLavorazioniTicket(formDb.getTicketId()), HttpStatus.OK);
	}
	
	/**
	 * Dettaglio di una lavorazione su un ticket
	 * @param id identificativo della richiesta (form)
	 * @param logId identificativo della lavorazione fornito da Remedy
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @throws RemedyServiceException
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@GetMapping("/richiesta/{id}/stato/dettagli/{logId}")
	public ResponseEntity<InfoNotaAttachmentsDto> dettaglioLavorazioneTicket (@PathVariable String id, @PathVariable String logId) throws BusinessException, SystemException, RemedyServiceException, JsonParseException, JsonMappingException, ClassNotFoundException, IOException {
		SpFormRichieste formDb = formAssistenzaService.recuperaRichiestaPerId(id);
		if (!SecurityUtils.isBackOfficeAdmin() && !formDb.getRefAccount().equals(SecurityUtils.getAccountIdCorrente()))
			throw new BusinessException("L'utente corrente non e' abilitato a visualizzare la richiesta con id " + id);
		return new ResponseEntity<InfoNotaAttachmentsDto>(remedyService.dettaglioLavorazioneTicket(formDb.getTicketId(), logId), HttpStatus.OK);
	}
	
	/**
	 * Inserisce una nota ad una segnalazione esistente ed inviata
	 * @param id
	 * @param form
	 * @param file
	 * @return
	 * @throws BusinessException
	 * @throws IOException
	 * @throws RemedyServiceException
	 */
	@PostMapping("/richiesta/{id}/form/integrazione")
	public ResponseEntity<EsitoDTO> inserisciLavorazioneTicket (@PathVariable String id, @RequestPart(name="form") NotaLavorazioneForm form, @RequestPart(name="file", required=false) MultipartFile file) throws BusinessException, IOException, RemedyServiceException {
		SpFormRichieste formDb = formAssistenzaService.recuperaRichiestaPerId(id);
		if (!SecurityUtils.isBackOfficeAdmin() && !formDb.getRefAccount().equals(SecurityUtils.getAccountIdCorrente()))
			throw new BusinessException("L'utente corrente non e' abilitato a visualizzare la richiesta con id " + id);
		formAssistenzaService.allegaFile(formDb, form.getRiepilogo(), form.getTipologia(), form.getNote(), file, SecurityUtils.isBackOfficeAdmin(), SecurityUtils.getUtenteLoggatoCompleto().getSpUser());
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(null, null, null), HttpStatus.OK);
	}
	
	
	/**
	 * Elenco dei tipi di impatto di segnalazione remedy
	 * @return
	 */
	@GetMapping("/richiesta/impatto")
	public ResponseEntity<List<DecodificaDto>> elencoTipiImpatto () {
		return new ResponseEntity<List<DecodificaDto>>(remedyService.elencoTipiImpatto(), HttpStatus.OK);
	}
	
	/**
	 * Elenco dei tipi di urgenza
	 * @return
	 */
	@GetMapping("/richiesta/urgenza")
	public ResponseEntity<List<DecodificaDto>> elencoTipiUrgenza () {
		return new ResponseEntity<List<DecodificaDto>>(remedyService.elencoTipiUrgenza(), HttpStatus.OK);
	}

	/**
	 * Dettaglio di un ticket
	 * @param ticketId
	 * @return
	 * @throws RemedyServiceException
	 */
	@GetMapping("/remedy/ticket")
	public ResponseEntity<LavorazioneTicketDto> dettaglioTicket (String ticketId) throws RemedyServiceException {
		return new ResponseEntity<LavorazioneTicketDto>(remedyService.recuperaStatoTicket(ticketId), HttpStatus.OK);
	}
	
	@GetMapping("/remedy/persons")
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<List<UtenteDto>> allPersons () throws RemedyServiceException {
		return new ResponseEntity<List<UtenteDto>>(remedyService.recuperaTuttiUtenti(), HttpStatus.OK);
	}
	
	
	@GetMapping("/remedy/ticket/stato")
	public ResponseEntity<List<DecodificaDto>> elencoTipologieTicket () throws RemedyServiceException {
		return new ResponseEntity<List<DecodificaDto>>(remedyService.elencoStatiTicket(), HttpStatus.OK);
	}
	
	/*
	 * Mappa una richiesta di assistenza in dati sintesi per il frontend
	 */
	private RichiestaAssistenzaSintesiDTO mappaRichiesta(SpFormRichieste e, boolean dettaglio) {
		RichiestaAssistenzaSintesiDTO richiesta = new RichiestaAssistenzaSintesiDTO();
		richiesta.setDataInserimento(e.getDataInserimento());
		richiesta.setDataInvio(e.getDataInvio());
		richiesta.setDataUltimaModifica(e.getDataModifica());
		richiesta.setTicketId(e.getTicketId());
		AbstractBaseForm form;
		try {
			form = (AbstractBaseForm) mapper.readValue(e.getJson(), Class.forName(FORM_PACKAGE+e.getSpDTipoForm().getClasseJson()));
		}
		catch (ClassNotFoundException | IOException e1) {
			throw new SystemException(e1);
		}
		richiesta.setDescrizione(form.getDescrizione());
		richiesta.setId(e.getId());
		richiesta.setInviato(e.getInviato());
		richiesta.setOggetto(form.getOggetto());
		richiesta.setTipoSegnalazione(e.getSpDTipoForm().getClasseJson());
		richiesta.setUtenteInserimento(e.getUtenteInserimento().getNome() + " " + e.getUtenteInserimento().getCognome());
		if (e.getUtenteInvio() != null )
			richiesta.setUtenteInvio(e.getUtenteInvio().getNome() + " " + e.getUtenteInvio().getCognome());
		if (e.getUtenteModifica() != null )
		richiesta.setUtenteUltimaModifica(e.getUtenteModifica().getNome() + " " + e.getUtenteModifica().getCognome());
		
		richiesta.setAccountId(e.getRefAccount());
		GetAccountResponseSchema account = authorityApi.v10NwsAccountsOidGet(e.getRefAccount());
		richiesta.setAccountName(account.getAccount().getName());
		
		if (dettaglio) {
			GetDivisionResponseSchema divisione = authorityApi.v10NwsDivisionsOidGet(account.getAccount().getDivisionId());
			richiesta.setDivisioneId(divisione.getDivision().getUuid());
			richiesta.setDivisioneName(divisione.getDivision().getName());
			
			GetOrganizationResponseSchema organizzazione = authorityApi.v10NwsOrganizationsOidGet(divisione.getDivision().getOrganizationId());
			richiesta.setOrganizzazioneId(organizzazione.getOrganization().getUuid());
			richiesta.setOrganizzazioneName(organizzazione.getOrganization().getName());
		}
		
		richiesta.setUrgenza(e.getSpDRemedyUrgenza().getDescrizione());
		if (form.getqScope() != null) {
			richiesta.setImpatto(form.getqScope().getValore());
		}
		

		richiesta.setStato(e.getStato());
		if (form.getqScope() != null)
		richiesta.setScope(form.getqScope().getValore());
		richiesta.setService(form.getqServ());;
		richiesta.setTecnologia(form.getqTecnologia());
		richiesta.setTipologiaProblema(form.getqTipo());
		
		SpAssegnatarioRichiesta assegnatarioCorrente = e.getSpAssegnatarioRichiestas().stream().filter(a -> a.getAttivo()).findAny().orElse(defaultassegnatario());
		
		richiesta.setAssegnatario(StringUtils.trimToEmpty(assegnatarioCorrente.getAssegnatario().getNome()) + " " + StringUtils.trimToEmpty(assegnatarioCorrente.getAssegnatario().getCognome()));
		
		return richiesta;
	}
	
	

	private SpAssegnatarioRichiesta defaultassegnatario() {
		SpAssegnatarioRichiesta defaultAssegnatatrio = new SpAssegnatarioRichiesta();
		defaultAssegnatatrio.setAssegnatario(new SpUser()); 
		return defaultAssegnatatrio;
	}

	@GetMapping("/user/suggest/ticket")
	public ResponseEntity<List<DatiSinteticiUtenteDto>> suggestUtentiTicketOperator (String startBy) {
		return new ResponseEntity<List<DatiSinteticiUtenteDto>>(formAssistenzaService.ricercaUtenteTicketOperatorCognome(startBy), HttpStatus.OK);
	}
	
	
	
	/**
	 * Assegna la segnalazione ad un utente
	 * @param assegnazione
	 * @return
	 * @throws BusinessException
	 */
	@PostMapping("/richiesta/assegna")
	public ResponseEntity<EsitoDTO> assegnasegnalazione (@RequestBody RichiestaAssegnazioneSegnalazione assegnazione) throws BusinessException {
		if (assegnazione.getIdRichiesta() == null)
			throw new BusinessException("Ticket id mancante");
		
		/*if (assegnazione.getDataInizioValidita() == null)
			throw new BusinessException("Data Fine Assegnazione mancante");
		*/
		if (assegnazione.getIdUtenteAssegnatario() == null)
			throw new BusinessException("Utente assegnatario mancante");
		
		formAssistenzaService.assegnaSegnalazioneUtente(assegnazione, SecurityUtils.getUtenteLoggatoCompleto().getSpUser());
		
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "", "Utente assegnato correttamente"), HttpStatus.OK);
	}
}
