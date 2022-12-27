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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiParam;
import it.csi.nivola.nivolasp.domain.SpAccountAttributo;
import it.csi.nivola.nivolasp.domain.SpAccountInfocosto;
import it.csi.nivola.nivolasp.domain.SpUser;
import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.integration.rest.api.service.AuthorityApi;
import it.csi.nivola.nivolasp.integration.rest.api.service.ComputeserviceApi;
import it.csi.nivola.nivolasp.integration.rest.api.service.DatabaseserviceApi;
import it.csi.nivola.nivolasp.integration.rest.api.service.StorageserviceApi;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateAccountRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateAccountRequestSchemaAccount;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateDivisionRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateDivisionRequestSchemaDivision;
import it.csi.nivola.nivolasp.integration.rest.model.service.CrudApiObjectResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeAccountAttributesCSResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeAccountAttributesDBSResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeAccountAttributesSSResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetAccountResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetAccountUsersResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetAccountUsersResponseSchemaUsers;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetDivisionResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetDivisionUsersResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetDivisionUsersResponseSchemaUsers;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetOrganizationResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListAccountsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListAccountsResponseSchemaAccounts;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListDivisionsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListDivisionsResponseSchemaDivisions;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListOrganizationsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListOrganizationsResponseSchemaOrganizations;
import it.csi.nivola.nivolasp.integration.rest.model.service.UpdateAccountRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.UpdateAccountRequestSchemaAccount;
import it.csi.nivola.nivolasp.integration.rest.model.service.UpdateDivisionRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.UpdateDivisionRequestSchemaDivision;
import it.csi.nivola.nivolasp.security.AuthoritiesConstants;
import it.csi.nivola.nivolasp.security.SecurityUtils;
import it.csi.nivola.nivolasp.service.AttributiService;
import it.csi.nivola.nivolasp.service.MetricheService;
import it.csi.nivola.nivolasp.service.UserService;
import it.csi.nivola.nivolasp.service.dto.AccountDTO;
import it.csi.nivola.nivolasp.service.dto.DivisioneDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoEnum;
import it.csi.nivola.nivolasp.service.dto.FiltroAccountDto;
import it.csi.nivola.nivolasp.service.dto.FiltroDivisioneDto;
import it.csi.nivola.nivolasp.service.dto.OrganizzazioneDTO;
import it.csi.nivola.nivolasp.service.dto.RispostaQuotaDTO;
import it.csi.nivola.nivolasp.service.dto.UtenteAccountDTO;
import it.csi.nivola.nivolasp.service.impl.ListinoService;
import it.csi.nivola.nivolasp.service.mapper.AccountMapper;
import it.csi.nivola.nivolasp.service.mapper.DivisioneMapper;
import it.csi.nivola.nivolasp.service.mapper.ListinoMapper;
import it.csi.nivola.nivolasp.service.mapper.OrganizzazioneMapper;
import it.csi.nivola.nivolasp.util.StreamingObjectUtil;

/**
 * REST controller Per crud divisioni e account.
 * Agglomerate Divisioni e account per similitudine ed evitare conflitti con il controller AccountResource che riguarda l'utente 
 * del portale.
 */
@RestController
@RequestMapping("/api")
public class DivisioneResource {
	
	@Autowired
	public AuthorityApi authorityApi;
	
	@Autowired
	public DivisioneMapper divisioneMapper;

	@Autowired
	public AccountMapper accountMapper;

	@Autowired
	public OrganizzazioneMapper organizzazioneMapper;

	@Autowired
	public UserService userService;

	@Autowired
	public MetricheService metricheService;
	
	@Autowired
	public ListinoService listinoService;
	
	@Autowired
	ListinoMapper listinoMapper;
	
	@Autowired
	public AttributiService attributiService;

    private final Logger log = LoggerFactory.getLogger(DivisioneResource.class);

	@Autowired
	ComputeserviceApi computeserviceApi;
	
	@Autowired
	DatabaseserviceApi databaseserviceApi;
	
	@Autowired
	StorageserviceApi storageserviceApi;
	


    //
    // SEZIONE DIVISIONE
    //
    
    /**
     * Reperisce una divisione a partire dall'id o uuid
     * @param uuid
     * @param pageable
     * @return
     */
    @GetMapping("/divisione/{uuid}")
    @Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER, 
		AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR,  AuthoritiesConstants.DIVISION_VIEWER})
    public ResponseEntity<DivisioneDTO> getDivisioneUuid(@PathVariable String uuid, @ApiParam Pageable pageable) {
    	GetDivisionResponseSchema response = authorityApi.v10NwsDivisionsOidGet(uuid);
    	if (response == null || response.getDivision() == null)
    		new ResponseEntity<>("Nessun dato trovato", HttpStatus.NOT_FOUND);
    	DivisioneDTO divisione = divisioneMapper.toDivisioneDTO(response.getDivision());
		divisione.setOrganizzazione(organizzazioneMapper.toOrganizzazioneDTO(authorityApi.v10NwsOrganizationsOidGet(response.getDivision().getOrganizationId()).getOrganization()));
		divisione.setElencoAttributi(attributiService.elencoAttributiDivisione(divisione.getUuid()));
    	return new ResponseEntity<DivisioneDTO>(divisione, HttpStatus.OK);
    	
    }
    
    /**
     * Reperisce l'elenco delle divisioni in base ai filtri (nessun filtro = elenco complessivo)
     * @param filtro
     * @param pageable
     * @return
     */
	@GetMapping("/divisione")
    @Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER, 
		AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR,  AuthoritiesConstants.DIVISION_VIEWER})
    public ResponseEntity<List<DivisioneDTO>> getDivisioniFiltrate(FiltroDivisioneDto filtro, @ApiParam Pageable pageable) {
		ListDivisionsResponseSchema response = null;
		if (filtro == null)
			filtro = new FiltroDivisioneDto();
		log.info("FILTRO DIVISIONI: " + filtro.getOrganizationId());
    	response = authorityApi.v10NwsDivisionsGet(-1, 0, null, null, null, filtro.getDataCreazioneDa(), filtro.getDataCreazioneA(), filtro.getDataModificaDa(), filtro.getDataScadenzaA(), filtro.getDataCreazioneA(), filtro.getDataScadenzaA(), filtro.getName(), null, null, null, null, filtro.getOrganizationId(), null, null, null);
    	ListOrganizationsResponseSchema elencoOrganizzazioni = authorityApi.v10NwsOrganizationsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

    	if (response == null || response.getCount() == 0)
    		new ResponseEntity<>("Nessun dato trovato", HttpStatus.NOT_FOUND);
    	List<DivisioneDTO> elencoDivisioni = new ArrayList<DivisioneDTO>(response.getDivisions().size());
    	for (ListDivisionsResponseSchemaDivisions elem : response.getDivisions()) {
    		DivisioneDTO divisione = divisioneMapper.toDivisioneDTO(elem);
    		divisione.setOrganizzazione(trovaOrganizzazione(elencoOrganizzazioni, elem.getOrganizationId()));
    		elencoDivisioni.add(divisione);
    	}
    	return new ResponseEntity<List<DivisioneDTO>>(elencoDivisioni, HttpStatus.OK);
    }
	
	/**
	 * Aggiorna una divisione esistente
	 * @param divisioneParam
	 * @return
	 */
	@PutMapping("/divisione")
    @Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR})
    public ResponseEntity<EsitoDTO> aggiornaDivisione(@RequestBody DivisioneDTO divisioneParam) {
		UpdateDivisionRequestSchema richiestaAggiornamento = new UpdateDivisionRequestSchema();
		UpdateDivisionRequestSchemaDivision divisione = new UpdateDivisionRequestSchemaDivision();
		divisione.setActive(true);
		divisione.setContact(divisioneParam.getContact());
		divisione.setDesc(divisioneParam.getDesc());
		divisione.setEmail(divisioneParam.getEmail());
		divisione.setName(divisioneParam.getName());
		divisione.setPostaladdress(divisioneParam.getPostaladdress());
		richiestaAggiornamento.setDivision(divisione);
		/*SpDivisioneAttributo attr = attributiService.trovaAttributoDivisionePerNomeEDivisione("REMEDY_ENTE", divisioneParam.getUuid());
		if (divisioneParam.getEnteSelezionato() != null) {
			if (attr == null) {
				attr = new SpDivisioneAttributo();
				attr.setSpDTipoAttributo(attributiService.trovaAttributoPerNome("REMEDY_ENTE"));
				attr.setDivId(divisioneParam.getUuid());
			}
			attr.setDataModifica(new Timestamp(System.currentTimeMillis()));
			attr.setSpUser(SecurityUtils.getUtenteLoggatoCompleto().getSpUser());
			attr.setValore(divisioneParam.getEnteSelezionato().getDescrizioneEnte());
			attributiService.inserisciAttributoDivisione(attr);
		} else if (attr != null) {
			attributiService.eliminaAttributoDivisione(attr);
		}*/
		CrudApiObjectResponseSchema response = authorityApi.v10NwsDivisionsOidPut(divisioneParam.getUuid(), richiestaAggiornamento);
		EsitoDTO esito = new EsitoDTO(EsitoEnum.OK, "0001", "Account aggiornato correttamente");
		HttpStatus status = HttpStatus.OK;
		if (response.getUuid() == null || response.getUuid().toString() == null) {
			esito = new EsitoDTO(EsitoEnum.KO, "0001", "Impossibile aggiornare l'account");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<EsitoDTO>(esito, status);
	}
	
	/**
	 * Crea una nuova divisione
	 * @param divisioneParam
	 * @return
	 */
	@PostMapping("/divisione")
	@Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR})
	public ResponseEntity<EsitoDTO> inserisciDivisione(@RequestBody DivisioneDTO divisioneParam) {
		CreateDivisionRequestSchema richiestaCreazione = new CreateDivisionRequestSchema();
		CreateDivisionRequestSchemaDivision divisione = new CreateDivisionRequestSchemaDivision();
		divisione.setContact(divisioneParam.getContact());
		divisione.setDesc(divisioneParam.getDesc());
		divisione.setEmail(divisioneParam.getEmail());
		divisione.setName(divisioneParam.getName());
		divisione.setPostaladdress(divisioneParam.getPostaladdress());
		divisione.setOrganizationId(divisioneParam.getOrganizationId()); //Obbligatorio
		// divisione.setPriceListId(""); aspetto, non è obbligatorio
		richiestaCreazione.setDivision(divisione);

		CrudApiObjectResponseSchema response = authorityApi.v10NwsDivisionsPost(richiestaCreazione);
		
		EsitoDTO esito = new EsitoDTO(EsitoEnum.OK, "0001", "Divisione aggiornato correttamente");
		HttpStatus status = HttpStatus.OK;
		
		if (response.getUuid() == null || response.getUuid().toString() == null) {
			esito = new EsitoDTO(EsitoEnum.KO, "0001", "Impossibile aggiornare l'account");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		

		/*if (divisioneParam.getEnteSelezionato() != null) {
			SpDivisioneAttributo attr = new SpDivisioneAttributo();
			attr.setDivId(response.getUuid().toString());
			attr.setSpDTipoAttributo(attributiService.trovaAttributoPerNome("REMEDY_ENTE"));
			attr.setSpUser(SecurityUtils.getUtenteLoggatoCompleto().getSpUser());
			attr.setValore(divisioneParam.getEnteSelezionato().getDescrizioneEnte());
			attributiService.inserisciAttributoDivisione(attr);
		}*/
		
		return new ResponseEntity<EsitoDTO>(esito, status);
	}
	
	
	/**
	 * Annulla una divisione (active = false)
	 * @param uuid
	 * @return
	 */
	@DeleteMapping("/divisione/{uuid}")
    @Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR})
    public ResponseEntity<HttpStatus> cancellaDivisione(@PathVariable String uuid) {
		authorityApi.v10NwsDivisionsOidDelete(uuid);
		return new ResponseEntity<>(HttpStatus.OK);
    }
	
	/**
	 * Restituisce l'elenco degli utenti di un'account
	 * @param uuid
	 * @return
	 */
	@GetMapping("/divisione/{uuid}/utentiaccount")
	@Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER, 
		AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR,  AuthoritiesConstants.DIVISION_VIEWER,
		AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR,  AuthoritiesConstants.ACCOUNT_VIEWER})
	public ResponseEntity<List<UtenteAccountDTO>> elencoUtentiAccountPerDivisione(@PathVariable String uuid) {
		
		ListAccountsResponseSchema elencoAccount = authorityApi.v10NwsAccountsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

		List<UtenteAccountDTO> utentiTotaliDivisione = new ArrayList<>();
		
		GetDivisionUsersResponseSchema utentiDivisione = authorityApi.v10NwsDivisionsOidUsersGet(uuid, -1, 0,null, null);
		
		List<SpUser> elencoUtentiPortale = userService.getAll();
		utentiTotaliDivisione.addAll(RestUtils.composizioneUtentiElencoDIVISIONE(utentiDivisione.getUsers(), utentiDivisione.getCount(), elencoUtentiPortale, "Divisione", null));

		for (ListAccountsResponseSchemaAccounts account : elencoAccount.getAccounts()) {
			GetAccountUsersResponseSchema risposta = authorityApi.v10NwsAccountsOidUsersGet(account.getUuid(), -1, 0, null, null);
			utentiTotaliDivisione.addAll(RestUtils.composizioneUtentiElencoACCOUNT(risposta.getUsers(), risposta.getCount(), elencoUtentiPortale, "Account", account.getName()));
		}
		
		return new ResponseEntity<List<UtenteAccountDTO>>(utentiTotaliDivisione, HttpStatus.OK);
	}
	
	//
	// SEZIONE ACCOUNT
	//
	
	/**
	 * Reperisce un account a partire dall'id o uuid
	 * @param uuid
	 * @param pageable
	 * @return
	 */
    @GetMapping("/accountcmp/{uuid}")
    @Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER, 
		AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR,  AuthoritiesConstants.DIVISION_VIEWER,
		AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR,  AuthoritiesConstants.ACCOUNT_VIEWER})
    public ResponseEntity<AccountDTO> getAccountUuid(@PathVariable String uuid, @ApiParam Pageable pageable) {
    	GetAccountResponseSchema response = authorityApi.v10NwsAccountsOidGet(uuid);
    	if (response == null || response.getAccount() == null)
    		new ResponseEntity<>("Nessun dato trovato", HttpStatus.NOT_FOUND);
    	AccountDTO singoloAccount = accountMapper.toAccountDTO(response.getAccount());
		GetDivisionResponseSchema responseDivisioni = authorityApi.v10NwsDivisionsOidGet(singoloAccount.getDivisionId());
		singoloAccount.setDivisione(divisioneMapper.toDivisioneDTO(responseDivisioni.getDivision()));
		GetOrganizationResponseSchema responseOrg = authorityApi.v10NwsOrganizationsOidGet(responseDivisioni.getDivision().getOrganizationId());
		singoloAccount.setOrganizzazione(organizzazioneMapper.toOrganizzazioneDTO(responseOrg.getOrganization()));
		
		SpAccountAttributo attributoAccount = metricheService.reperisciCodicePrezzo(response.getAccount().getUuid());
		SpAccountInfocosto infocostoAccount = listinoService.recuperaInfocostoAccount(response.getAccount().getUuid());
		if (attributoAccount != null) {
			singoloAccount.setAggiornaCostiGiorno(attributoAccount.getAggiornaCostiGiorno());
			singoloAccount.setDataInizioConsumi(attributoAccount.getDataInizioConsumi() != null ? attributoAccount.getDataInizioConsumi().toLocalDate() : null);
			singoloAccount.setPersonId(attributoAccount.getPersonId());
			singoloAccount.setBudgetMin(attributoAccount.getBudgetMin());
			singoloAccount.setBudgetMax(attributoAccount.getBudgetMax());
		}
		if (infocostoAccount != null) {
			if (infocostoAccount.getSpDTipoPrezzo() != null) {
				singoloAccount.setCodicePrezzo(infocostoAccount.getSpDTipoPrezzo().getCodice());
				singoloAccount.setDescrizionePrezzo(infocostoAccount.getSpDTipoPrezzo().getDescrizione());
			}
			if (infocostoAccount.getSpDListino() != null)
				singoloAccount.setListino(listinoMapper.spDListinoToListinoDto(infocostoAccount.getSpDListino()));
			
		}
    	return new ResponseEntity<AccountDTO>(singoloAccount, HttpStatus.OK);
    	
    }
    
    /**
     * Reperisce l'elenco degli account in base ai filtri (nessun filtro = elenco complessivo)
     * @param filtro
     * @param pageable
     * @return
     */
	@GetMapping("/accountcmp")
    @Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER, 
		AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR,  AuthoritiesConstants.DIVISION_VIEWER,
		AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR,  AuthoritiesConstants.ACCOUNT_VIEWER})
    public ResponseEntity<List<AccountDTO>> getAccountsFiltrati(FiltroAccountDto filtro, @ApiParam Pageable pageable) {
		if (filtro == null)
			filtro = new FiltroAccountDto();
		ListAccountsResponseSchema response = authorityApi.v10NwsAccountsGet(-1, 0, null, null, null, null, null, null, null, null, null, filtro.getName(), null, null, filtro.getActive(), null, filtro.getDivisionId(), null, null, null, null);
		ListDivisionsResponseSchema elencoDivisioni = authorityApi.v10NwsDivisionsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		ListOrganizationsResponseSchema elencoOrganizzazioni = authorityApi.v10NwsOrganizationsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    	
		if (response == null || response.getCount() == 0)
    		new ResponseEntity<>("Nessun dato trovato", HttpStatus.NOT_FOUND);
    	List<ListAccountsResponseSchemaAccounts> ricevutoDallaCMP = response.getAccounts();
    	List<AccountDTO> elencoAccount = new ArrayList<AccountDTO>(ricevutoDallaCMP.size());
    	for (ListAccountsResponseSchemaAccounts elem : ricevutoDallaCMP) {
    		AccountDTO singoloAccount = accountMapper.toAccountDTO(elem);
    		singoloAccount.setDivisione(trovaDivisione(elencoDivisioni, elem.getDivisionId()));
    		singoloAccount.setOrganizzazione(trovaOrganizzazione(elencoOrganizzazioni, singoloAccount.getDivisione().getOrganizationId()));
    		elencoAccount.add(singoloAccount);
    	}
    	return new ResponseEntity<List<AccountDTO>>(elencoAccount, HttpStatus.OK);
    }
	
	private DivisioneDTO trovaDivisione (ListDivisionsResponseSchema elenco, String uuidDivisione) {
		for (ListDivisionsResponseSchemaDivisions div : elenco.getDivisions()) {
			if (div.getUuid().equals(uuidDivisione)) {
				return divisioneMapper.toDivisioneDTO(div);
			}
		}
		return null;
	}
	
	private OrganizzazioneDTO trovaOrganizzazione (ListOrganizationsResponseSchema elenco, String uuidOrganizzazione) {
		
		for (ListOrganizationsResponseSchemaOrganizations org : elenco.getOrganizations()) {
			if (org.getUuid().equals(uuidOrganizzazione)) {
				return organizzazioneMapper.toOrganizzazioneDTOs(org);
			}
		}
		return null;
	}
	
	/**
	 * Inserisce un nuovo account
	 * @param accountParam
	 * @return
	 */
	@PostMapping("/accountcmp")
	@Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER, 
		AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR})
	public ResponseEntity<EsitoDTO> inserisciAccount(@RequestBody AccountDTO accountParam) {
		log.info("ACCOUNT IN CREAZIONE: " + StreamingObjectUtil.streamObjectToJSON(accountParam));
		CreateAccountRequestSchema richiesta = new CreateAccountRequestSchema();
		CreateAccountRequestSchemaAccount account = new CreateAccountRequestSchemaAccount();
		account.setContact(accountParam.getContact());
		account.setDesc(accountParam.getDesc());
		account.setDivisionId(accountParam.getDivisionId());
		account.setEmail(accountParam.getEmail());
		account.setEmailSupport(accountParam.getEmailSupport());
		account.setEmailSupportLink(accountParam.getEmailSupportLink());
		
		account.setManaged(accountParam.getManaged());
		account.setName(accountParam.getName());
		account.setNote(accountParam.getNote());
		account.setAcronym(accountParam.getAcronym());
		
		richiesta.setAccount(account);
		CrudApiObjectResponseSchema response = authorityApi.v10NwsAccountsPost(richiesta);
		
		EsitoDTO esito = new EsitoDTO(EsitoEnum.OK, "0001", "Divisione aggiornato correttamente");
		HttpStatus status = HttpStatus.OK;
		
		if (response.getUuid() == null || response.getUuid().toString() == null) {
			esito = new EsitoDTO(EsitoEnum.KO, "0001", "Impossibile aggiornare l'account");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		} else {
			accountParam.setUuid(response.getUuid().toString());
			metricheService.inserisciAssociazioneAccountTipoPrezzo(accountParam, BigInteger.valueOf(SecurityUtils.getCurrentUser().getId()));
		}
		
		return new ResponseEntity<EsitoDTO>(esito, status);
	}
	
	/**
	 * Aggiorna un account esistente
	 * @param accountParam
	 * @return
	 */
	@PutMapping("/accountcmp")
    @Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER, 
		AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR})
    public ResponseEntity<EsitoDTO> aggiornaAccount(@RequestBody AccountDTO accountParam) {
		log.info("ACCOUNT IN MODIFICA: " + StreamingObjectUtil.streamObjectToJSON(accountParam));
		UpdateAccountRequestSchema richiesta = new UpdateAccountRequestSchema();
		UpdateAccountRequestSchemaAccount account = new UpdateAccountRequestSchemaAccount();
		account.setActive(true);
		account.setContact(accountParam.getContact());
		account.setDesc(accountParam.getDesc());
		account.setEmail(accountParam.getEmail());
		account.setEmailSupport(accountParam.getEmailSupport());
		account.setEmailSupportLink(accountParam.getEmailSupportLink());
		account.setName(accountParam.getName());
		account.setNote(accountParam.getNote());
		account.setAcronym(accountParam.getAcronym());
		richiesta.setAccount(account);
		
		CrudApiObjectResponseSchema response = authorityApi.v10NwsAccountsOidPut(accountParam.getUuid(), richiesta);
		EsitoDTO esito = new EsitoDTO(EsitoEnum.OK, "0001", "Account aggiornato correttamente");
		HttpStatus status = HttpStatus.OK;
		if (response.getUuid() == null || response.getUuid().toString() == null) {
			esito = new EsitoDTO(EsitoEnum.KO, "0001", "Impossibile aggiornare l'account");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		} else {
			metricheService.inserisciAssociazioneAccountTipoPrezzo(accountParam, BigInteger.valueOf(SecurityUtils.getCurrentUser().getId()));
		}
		
		return new ResponseEntity<EsitoDTO>(esito, status);
	}
	
	
	/**
	 * Annulla un account esistente (active = false)
	 * @param uuid
	 * @return
	 */
	@DeleteMapping("/accountcmp/{uuid}")
    
    @Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER, 
		AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR})
    public ResponseEntity<HttpStatus> cancellaAccount(@PathVariable String uuid) {
		authorityApi.v10NwsAccountsOidDelete(uuid);
		return new ResponseEntity<>(HttpStatus.OK);
    }
	
	/**
	 * Restituisce l'elenco degli utenti di una divisione
	 * @param uuid
	 * @return
	 */
	@GetMapping("/divisione/{uuid}/utenti")
	
	@Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER, 
		AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR,  AuthoritiesConstants.DIVISION_VIEWER})
	public ResponseEntity<List<UtenteAccountDTO>> elencoUtentiDivisione(@PathVariable String uuid) {
		GetDivisionUsersResponseSchema risposta = authorityApi.v10NwsDivisionsOidUsersGet(uuid, -1, 0, null, null);
		List<GetDivisionUsersResponseSchemaUsers> utenti = risposta.getUsers();
		List<SpUser> elencoUtentiPortale = userService.getAll();
		return ResponseEntity.ok( RestUtils.composizioneUtentiElencoDIVISIONE(utenti, risposta.getCount(), elencoUtentiPortale, null, null));
	}
	
	/**
	 * Restituisce l'elenco degli utenti di un'account
	 * @param uuid
	 * @return
	 */
	@GetMapping("/accountcmp/{uuid}/utenti")
	
	@Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER, 
		AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR,  AuthoritiesConstants.DIVISION_VIEWER,
		AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR,  AuthoritiesConstants.ACCOUNT_VIEWER})
	public ResponseEntity<List<UtenteAccountDTO>> elencoUtentiAccount(@PathVariable String uuid) {
		GetAccountUsersResponseSchema risposta = authorityApi.v10NwsAccountsOidUsersGet(uuid, -1, 0, null, null);
		List<GetAccountUsersResponseSchemaUsers> utenti = risposta.getUsers();
		List<SpUser> elencoUtentiPortale = userService.getAll();
		return ResponseEntity.ok( RestUtils.composizioneUtentiElencoACCOUNT(utenti, risposta.getCount(), elencoUtentiPortale, null, null));
	}
	
	
	/**
	 * Restituisce l'elenco delle quote di utilizzo dei servizi dell'account con limite massimo e valore in uso
	 * @param uuid
	 * @return
	 * @throws BusinessException 
	 */
	@GetMapping("/accountcmp/{uuid}/quote")
	
	@Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER, 
		AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR,  AuthoritiesConstants.DIVISION_VIEWER,
		AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR,  AuthoritiesConstants.ACCOUNT_VIEWER})
	
	public ResponseEntity<RispostaQuotaDTO> elencoQuoteAccount(@PathVariable String uuid) throws BusinessException {
		RispostaQuotaDTO completo = new RispostaQuotaDTO();
		SecurityUtils.getAccountIdCorrente(uuid);
		DescribeAccountAttributesCSResponseSchema risposta = computeserviceApi.v10NwsComputeservicesDescribeaccountattributesGet(uuid);
		completo.setQuoteCompute(accountMapper.toDescrizioneQuotaElenco(risposta.getDescribeAccountAttributesResponse().getAccountAttributeSet()));
		DescribeAccountAttributesDBSResponseSchema rispostaDb = databaseserviceApi.v10NwsDatabaseservicesDescribeaccountattributesGet(uuid);
		completo.setQuoteDb(accountMapper.toDescrizioneQuotaElenco(rispostaDb.getDescribeAccountAttributesResponse().getAccountAttributeSet()));
		DescribeAccountAttributesSSResponseSchema rispostaStorage = storageserviceApi.v10NwsStorageservicesDescribeaccountattributesGet(uuid);
		completo.setQuoteStorage(accountMapper.toDescrizioneQuotaElenco(rispostaStorage.getDescribeAccountAttributesResponse().getAccountAttributeSet()));
		return new ResponseEntity<RispostaQuotaDTO>(completo, HttpStatus.OK);
	}
}
