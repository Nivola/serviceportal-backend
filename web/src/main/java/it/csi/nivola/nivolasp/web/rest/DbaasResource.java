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

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.transaction.SystemException;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import it.csi.nivola.nivolasp.aop.logging.AzioneDispositiva;
import it.csi.nivola.nivolasp.config.ApplicationProperties;
import it.csi.nivola.nivolasp.domain.SpDivisioneAttributo;
import it.csi.nivola.nivolasp.domain.SpMailRichiesta;
import it.csi.nivola.nivolasp.domain.SpOrganizzazioneAttributo;
import it.csi.nivola.nivolasp.domain.UtenteShibboleth;
import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.integration.rest.api.service.AuthorityApi;
import it.csi.nivola.nivolasp.integration.rest.api.service.ComputeserviceApi;
import it.csi.nivola.nivolasp.integration.rest.api.service.DatabaseserviceApi;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateDBInstancesApiRequestSchemaDbinstanceTag;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateDBInstancesApiRequestSchemaDbinstanceTagN;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateDBInstancesApiV2RequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateDBInstancesApiV2RequestSchemaDbinstance;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateDBInstancesApiV2RequestSchemaDbinstance.EngineEnum;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateDBInstancesApiV2RequestSchemaDbinstanceVpcSecurityGroupIds;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeDBInstanceEngineTypesApiResponseSchemaDescribeDBInstanceEngineTypesResponseEngineTypesSet;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeDBInstanceEngineTypesApiV2ResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeDBInstanceTypesApiResponseSchemaDescribeDBInstanceTypesResponseInstanceTypesSet;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeDBInstanceTypesApiV2ResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeDBInstancesV2ResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeDBInstancesV2ResponseSchemaDescribeDBInstancesResponseDescribeDBInstancesResultDBInstances;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeTagsApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetAccountResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetDivisionResponseSchema;
import it.csi.nivola.nivolasp.repository.SPDTipoEventoRepository;
import it.csi.nivola.nivolasp.security.AuthoritiesConstants;
import it.csi.nivola.nivolasp.security.SecurityUtils;
import it.csi.nivola.nivolasp.service.AttributiService;
import it.csi.nivola.nivolasp.service.MailService;
import it.csi.nivola.nivolasp.service.dto.DatiUtenteDbaas;
import it.csi.nivola.nivolasp.service.dto.DbEngine;
import it.csi.nivola.nivolasp.service.dto.DbaasDTO;
import it.csi.nivola.nivolasp.service.dto.DbaasDetailDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoEnum;
import it.csi.nivola.nivolasp.service.dto.FlavourDTO;
import it.csi.nivola.nivolasp.service.dto.LimiteDTO;
import it.csi.nivola.nivolasp.service.dto.ParametriCreazioneDbaas;
import it.csi.nivola.nivolasp.service.dto.ProspettoCostiVmDTO;
import it.csi.nivola.nivolasp.service.dto.RichiestaCostiDbaasDTO;
import it.csi.nivola.nivolasp.service.dto.Tag;
import it.csi.nivola.nivolasp.service.impl.CostiListinoService;
import it.csi.nivola.nivolasp.service.mapper.DBaasMapper;
import it.csi.nivola.nivolasp.util.JwtInternalGenerator;

/**
 * Rest controller per la gestione delle istanze DB
 */
@RestController
@RequestMapping("/api")
public class DbaasResource {

	DatabaseserviceApi databaseserviceApi;
	
	DBaasMapper dBaasMapper;
	
	ApplicationProperties applicationProperties;
	
	@Autowired
	JwtInternalGenerator jwtInternalGenerator;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	AuthorityApi authorityApi;
	
	@Autowired
	SPDTipoEventoRepository spdTipoEventoRepository;
	
	@Autowired
	AttributiService attributiService;
	
	@Autowired
	ComputeserviceApi computeserviceApi;
	
	@Autowired
	CostiListinoService costiListinoService;
	

	
	/**
	 * Costruttore
	 * @param computeserviceApi
	 */
	public DbaasResource(DatabaseserviceApi databaseserviceApi, DBaasMapper dBaasMapper, ApplicationProperties applicationProperties) {
		this.databaseserviceApi = databaseserviceApi;
		this.dBaasMapper = dBaasMapper;
		this.applicationProperties = applicationProperties;
	}
	
	
	/**
	 * Elenco delle istanze DBAAS
	 * @return
	 * @throws BusinessException 
	 */
	@GetMapping("/dbaas")
	@Secured({AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR, AuthoritiesConstants.ACCOUNT_VIEWER})
	public ResponseEntity<List<DbaasDTO>> elencoDbaas (String accountId) throws BusinessException {
		List<DbaasDTO> elenco = null;
		List<String> elencoAccountId = new ArrayList<>(1);
		elencoAccountId.add(SecurityUtils.getAccountIdCorrente(accountId));
		DescribeDBInstancesV2ResponseSchema risposta = databaseserviceApi.v20NwsDatabaseservicesInstanceDescribedbinstancesGet(elencoAccountId, null, null, null, -1, null, null);
		
		elenco = new ArrayList<>(risposta.getDescribeDBInstancesResponse().getDescribeDBInstancesResult().getDbInstances().size());
		DescribeDBInstanceTypesApiV2ResponseSchema rispostaTipo = databaseserviceApi.v20NwsDatabaseservicesInstanceDescribedbinstancetypesGet(SecurityUtils.getAccountIdCorrente(accountId), -1, null, null);
		for (DescribeDBInstancesV2ResponseSchemaDescribeDBInstancesResponseDescribeDBInstancesResultDBInstances istanza : risposta.getDescribeDBInstancesResponse().getDescribeDBInstancesResult().getDbInstances()) {
			DbaasDTO elem = new DbaasDTO();
			elem.setAz(istanza.getDbInstance().getAvailabilityZone());
			elem.setEngine(istanza.getDbInstance().getEngine() + " " + istanza.getDbInstance().getEngineVersion());
			elem.setInstanceId(istanza.getDbInstance().getDbiResourceId());
			elem.setNome(istanza.getDbInstance().getDbInstanceIdentifier());
			elem.setRegion("RegionePiemonte01");
			elem.setStato(istanza.getDbInstance().getDbInstanceStatus());
			elem.setStatus(istanza.getDbInstance().getDbInstanceStatus());
			elem.setStorage(""+istanza.getDbInstance().getAllocatedStorage());
			
			List<String> resourceIdN = new ArrayList<>(1);
			resourceIdN.add(istanza.getDbInstance().getDbiResourceId());
			DescribeTagsApiResponseSchema rispostaTags = computeserviceApi.v10NwsComputeservicesTagDescribetagsGet(null, null, resourceIdN, null, 50, null);
			
			if (rispostaTags.getDescribeTagsResponse().getTagSet() != null) {
				rispostaTags.getDescribeTagsResponse().getTagSet().forEach(t -> {
					Tag tag = new Tag();
					tag.setKey(t.getKey());
					elem.getElencoTag().add(tag);
				});
			}
			
			elenco.add(elem);
			List<String> elencoTipi = new ArrayList<>(1);
			for (DescribeDBInstanceTypesApiResponseSchemaDescribeDBInstanceTypesResponseInstanceTypesSet singoloTipo : rispostaTipo.getDescribeDBInstanceTypesResponse().getInstanceTypesSet()) {
				if (singoloTipo.getName().equals(istanza.getDbInstance().getDbInstanceClass())) {
					if (singoloTipo.getFeatures() != null) {
						elem.setCpu(singoloTipo.getFeatures().getVcpus());
						elem.setRam(singoloTipo.getFeatures().getRam());
					}	
				}
			}
			elencoTipi.add(istanza.getDbInstance().getDbInstanceClass());
			
		}
		
		return new ResponseEntity<>(elenco, HttpStatus.OK);
	}
	
	
	/**
	 * Dettaglio di un'istanza per uuid, dati completi
	 * @param uuid
	 * @return
	 * @throws BusinessException 
	 */
	@GetMapping("/dbaas/{uuid}")
	@Secured({AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR, AuthoritiesConstants.ACCOUNT_VIEWER})
	public ResponseEntity<DbaasDetailDTO> dettaglioDbaas (@PathVariable String uuid) throws BusinessException {
		List<String> elencoAccountId = new ArrayList<>(1);
//		elencoAccountId.add("0b484891-37e8-4f37-9e3c-ced04df5f449");
		elencoAccountId.add(SecurityUtils.getAccountIdCorrente());
		List<String> istanzauuid = new ArrayList<>(1);
		istanzauuid.add(uuid);
		DescribeDBInstancesV2ResponseSchema risposta = databaseserviceApi.v20NwsDatabaseservicesInstanceDescribedbinstancesGet(elencoAccountId, null, null, istanzauuid, -1, null, null);
	
		if (risposta == null || 
				risposta.getDescribeDBInstancesResponse().getDescribeDBInstancesResult().getNvlDBInstancesTotal() == null ||
				risposta.getDescribeDBInstancesResponse().getDescribeDBInstancesResult().getNvlDBInstancesTotal() <= 0) {
			throw new BusinessException("Istanza con uuid " + uuid +" non trovata");
		}
		
		DbaasDetailDTO elem = dBaasMapper.toDettaglioV2(risposta.getDescribeDBInstancesResponse().getDescribeDBInstancesResult().getDbInstances().get(0).getDbInstance());
		
		DescribeDBInstanceTypesApiV2ResponseSchema rispostaTipo = databaseserviceApi.v20NwsDatabaseservicesInstanceDescribedbinstancetypesGet(elencoAccountId.get(0), -1, null, null);
		
		for (DescribeDBInstancesV2ResponseSchemaDescribeDBInstancesResponseDescribeDBInstancesResultDBInstances istanza : risposta.getDescribeDBInstancesResponse().getDescribeDBInstancesResult().getDbInstances()) {
			elem.setAz(istanza.getDbInstance().getAvailabilityZone());
			elem.setEngine(istanza.getDbInstance().getEngine() + " " + istanza.getDbInstance().getEngineVersion());
			elem.setInstanceId(istanza.getDbInstance().getDbInstanceIdentifier());
			elem.setNome(istanza.getDbInstance().getDbInstanceIdentifier());
			elem.setRegion("RegionePiemonte01");
			elem.setStato(istanza.getDbInstance().getDbInstanceStatus());
			elem.setStatus(istanza.getDbInstance().getDbInstanceStatus());
			elem.setStorage(""+istanza.getDbInstance().getAllocatedStorage());
			List<String> elencoTipi = new ArrayList<>(1);
			for (DescribeDBInstanceTypesApiResponseSchemaDescribeDBInstanceTypesResponseInstanceTypesSet singoloTipo : rispostaTipo.getDescribeDBInstanceTypesResponse().getInstanceTypesSet()) {
				if (singoloTipo.getName().equals(istanza.getDbInstance().getDbInstanceClass())) {
					if (singoloTipo.getFeatures() != null) {
						elem.setCpu(singoloTipo.getFeatures().getVcpus());
						elem.setRam(singoloTipo.getFeatures().getRam());
					}	
				}
			}
			elencoTipi.add(istanza.getDbInstance().getDbInstanceClass());
		}
		
		List<String> resourceIdN = new ArrayList<>();
		resourceIdN.add(uuid);
		DescribeTagsApiResponseSchema rispostaTags = computeserviceApi.v10NwsComputeservicesTagDescribetagsGet(null, null, resourceIdN, null, -1, null);
		
		if (rispostaTags.getDescribeTagsResponse().getTagSet() != null) {
			rispostaTags.getDescribeTagsResponse().getTagSet().forEach(t -> {
				Tag tag = new Tag();
				tag.setKey(t.getKey());
				elem.getElencoTag().add(tag);
			});
		}
		
		return new ResponseEntity<>(elem, HttpStatus.OK);
	}
	
	
	/**
	 * Restituisce i limiti minimo e massimo di storage per la creazione del DB
	 * @return
	 */
	@GetMapping("/dbaas/limiti")
	@Secured({AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR})
	public LimiteDTO limitiDimensioneDb () {
		LimiteDTO limite = new LimiteDTO();
		limite.setLimiteMin(applicationProperties.getParametroDb(ApplicationProperties.PARAMETRO_DB_DBAAS_MIN_SIZE));
		limite.setLimiteMax(applicationProperties.getParametroDb(ApplicationProperties.PARAMETRO_DB_DBAAS_MAX_SIZE));
		return limite;
	}
	
	
	/**
	 * Restituisce l'elenco degli engines DB a partire dal catalogo CMP
	 * @return
	 * @throws BusinessException 
	 * @throws RestClientException 
	 */
	@GetMapping("/dbaas/engine")
	@Secured({AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR})
	public List<DbEngine> elencoEngines () throws RestClientException, BusinessException {
		
		DescribeDBInstanceEngineTypesApiV2ResponseSchema risposta = databaseserviceApi.v20NwsDatabaseservicesInstanceEnginetypesGet(SecurityUtils.getAccountIdCorrente());
		List<DbEngine> elenco = new ArrayList<>(risposta.getDescribeDBInstanceEngineTypesResponse().getEngineTypesTotal());
		for (DescribeDBInstanceEngineTypesApiResponseSchemaDescribeDBInstanceEngineTypesResponseEngineTypesSet loopElem : risposta.getDescribeDBInstanceEngineTypesResponse().getEngineTypesSet()) {
			DbEngine myEngine = new DbEngine(loopElem.getEngine(), loopElem.getEngineVersion());
			elenco.add(myEngine);
		}
		return elenco;
		
	}
	
	
	/**
	 * Elenco dei flavours (taglia -> instanceType presso CMP)
	 * @return
	 * @throws BusinessException 
	 * @throws RestClientException 
	 */
	@GetMapping("/dbaas/flavour")
	@Secured({AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR})
	public List<FlavourDTO> elencoFavourDbaas() throws RestClientException, BusinessException {
		DescribeDBInstanceTypesApiV2ResponseSchema risposta = databaseserviceApi.v20NwsDatabaseservicesInstanceDescribedbinstancetypesGet(SecurityUtils.getAccountIdCorrente(), -1, null, null);
		return dBaasMapper.toListFlavourDTOs(risposta.getDescribeDBInstanceTypesResponse().getInstanceTypesSet());
	}
	
	
	/**
	 * Elimina un'istanza DBAAS
	 * @param uuid
	 * @return
	 */
	@DeleteMapping("/dbaas/{uuid}")
	@Secured({AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR})
	@AzioneDispositiva
	public ResponseEntity<EsitoDTO> cancellazioneIstanzaDb (@PathVariable String uuid) {
		databaseserviceApi.v20NwsDatabaseservicesInstanceDeletedbinstanceDelete(uuid, null, null);
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "Cancellazione avvenuta correttamente"), HttpStatus.OK);
	}
	
	
	/**
	 * Crea una nuova istanza DBAAS
	 * @param dbaas
	 * @return
	 * @throws BusinessException
	 */
	@PostMapping("/dbaas")
	@Secured({AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR})
	@AzioneDispositiva
	public ResponseEntity<EsitoDTO> creazioneIstanzaDbaas (@RequestBody ParametriCreazioneDbaas dbaas) throws BusinessException{
		if (!dbaas.getNome().matches("^[a-zA-Z][a-zA-Z0-9-]+")) {
			throw new BusinessException("Campo nome database deve essere alfanumerico: deve iniziare con una lettera e deve contenere lettere, numeri o il carattere speciale -");
		}
		if (!dbaas.getSchemaName().matches("^[a-zA-Z][a-zA-Z0-9]+")) {
			throw new BusinessException("Campo nome schema deve essere alfanumerico: non sono ammessi simboli");
		}
		CreateDBInstancesApiV2RequestSchema richesta = new CreateDBInstancesApiV2RequestSchema();
		CreateDBInstancesApiV2RequestSchemaDbinstance dbinstance = new CreateDBInstancesApiV2RequestSchemaDbinstance();
		dbinstance.setAccountId(SecurityUtils.getAccountIdCorrente());
		dbinstance.setAllocatedStorage(dbaas.getSpazioAllocazione());
		dbinstance.setDbInstanceClass(dbaas.getFlavourName());//flavour
		dbinstance.setDbInstanceIdentifier(dbaas.getNome());
//		dbinstance.setDbName(dbaas.getSchemaName());
		dbinstance.setDbSubnetGroupName(dbaas.getSubnet());
		dbinstance.setEngine(EngineEnum.fromValue(dbaas.getEngine()));
		dbinstance.setEngineVersion(dbaas.getVersione());

		dbinstance.setMasterUserPassword(StringUtils.trimToNull(dbaas.getAdminPassword()));
		dbinstance.setMultiAZ(false);
//		dbinstance.setNvlKeyName(dbaas.getChiaveSSH());
		if (dbaas.getTags() != null) {
			List<CreateDBInstancesApiRequestSchemaDbinstanceTagN> elencoTegs = new LinkedList<>();
			
			for (String singoloTag : dbaas.getTags()) {
				CreateDBInstancesApiRequestSchemaDbinstanceTagN elementoElencoTag = new CreateDBInstancesApiRequestSchemaDbinstanceTagN	();
				CreateDBInstancesApiRequestSchemaDbinstanceTag tag = new CreateDBInstancesApiRequestSchemaDbinstanceTag();
				tag.setKey(singoloTag);
				tag.setValue(singoloTag);
				elementoElencoTag.setTag(tag);
				elencoTegs.add(elementoElencoTag);
			}
			dbinstance.setTags(elencoTegs);
		}
		CreateDBInstancesApiV2RequestSchemaDbinstanceVpcSecurityGroupIds vpcSecurityGroupIds = new CreateDBInstancesApiV2RequestSchemaDbinstanceVpcSecurityGroupIds();
		vpcSecurityGroupIds.addVpcSecurityGroupIdItem(dbaas.getSecurityGroup());
		dbinstance.setVpcSecurityGroupIds(vpcSecurityGroupIds);
		// Ok sec groups, ma il resto?
		
		richesta.setDbinstance(dbinstance);
		databaseserviceApi.v20NwsDatabaseservicesInstanceCreatedbinstancePost(richesta);
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "Creazione  avvenuta correttamente"), HttpStatus.OK);
	}
	
	
	/**
	 * Genera un token JWT per la console di amministrazione del DBAAS
	 * @param uuid
	 * @return
	 * @throws JSONException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws BusinessException 
	 */
    @GetMapping("/dbaas/{uuid}/token")
	@Secured({AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR, AuthoritiesConstants.ACCOUNT_VIEWER})
	public ResponseEntity<String> generaTorkenAdminer(@PathVariable String uuid) throws JSONException, NoSuchAlgorithmException, InvalidKeySpecException, BusinessException {
    	List<String> elencoAccountId = new ArrayList<>(1);
		elencoAccountId.add(SecurityUtils.getAccountIdCorrente());
		List<String> elencoUuid = new ArrayList<>(1);
    	DescribeDBInstancesV2ResponseSchema risposta = databaseserviceApi.v20NwsDatabaseservicesInstanceDescribedbinstancesGet(elencoAccountId, null, null, elencoUuid, -1, null, null);
    	return new ResponseEntity<String>(jwtInternalGenerator.generaJWT(null, "be@local", "adminer:"+SecurityUtils.getCurrentUser().getUuidUtente()+":"+risposta.getDescribeDBInstancesResponse().getDescribeDBInstancesResult().getDbInstances().get(0).getDbInstance().getDbInstanceIdentifier()), HttpStatus.OK);
	}
    
    /**
     * Richiesta di creazione utente su un DBAAS
     * @param uuid
     * @param datiUtente
     * @return
     * @throws BusinessException
     */
    @PostMapping("/dbaas/{uuid}/utente")
	@Secured({AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR, AuthoritiesConstants.ACCOUNT_VIEWER})
    @AzioneDispositiva
	public ResponseEntity<EsitoDTO> richiediUtente (@PathVariable String uuid, @RequestBody DatiUtenteDbaas datiUtente) throws BusinessException {
    	ResponseEntity<DbaasDetailDTO> dettaglio = dettaglioDbaas(uuid);
    	UtenteShibboleth utente = SecurityUtils.getUtenteLoggatoCompleto();
    	SpMailRichiesta richiestaEmail = new SpMailRichiesta();
    	GetAccountResponseSchema accountCMP = authorityApi.v10NwsAccountsOidGet(dettaglio.getBody().getNvlOwnerId());
    	
    	String ente;
    	SpDivisioneAttributo attr = attributiService.trovaAttributoDivisionePerNomeEDivisione("REMEDY_ENTE", accountCMP.getAccount().getDivisionId());
    	if (attr != null) {
    		ente = attr.getValore();
    	} else {
    		GetDivisionResponseSchema divisioneCMP = authorityApi.v10NwsDivisionsOidGet(accountCMP.getAccount().getDivisionId());
    		SpOrganizzazioneAttributo attrOrg = attributiService.trovaAttributoOrganizzazionePerNomeEDivisione("REMEDY_ENTE", divisioneCMP.getDivision().getOrganizationId());
    		if (attrOrg == null) {
    			throw new BusinessException("ENTE REMEDY NON CONFIGURATO");
    		}
    		ente = attrOrg.getValore();
    	}
		
    	String subject =  "NSP - richiesta creazione utenza DB per account " + dettaglio.getBody().getNvlOwnerAlias();
    	String content =
    			"\nCodice fiscale: " + utente.getCodFiscale()+
    			"\r\nCognome: " + utente.getCognome() +
    			"\r\nNome: " + utente.getNome() +
    			"\r\nTipologia di utenza: " + SecurityUtils.getCurrentUser().getAbilitazioneSelezionata().getUserRoleDescription()+
    			"\r\nEnte appartenenza: " + ente + 
    			"\r\nEmail: " + utente.getSpUser().getEmail() + " mailto: " + utente.getSpUser().getEmail() +
    			"\r\nSegnalazione: Assistenza" + 
    			"\r\nDescrizione del problema: Richiesta creazione utente " + datiUtente.getNome() + " per il database " + dettaglio.getBody().getNome() + 
    			" Schema= "+dettaglio.getBody().getDbName() + " Note = " + datiUtente.getNote();
    	
    	richiestaEmail.setOggetto(subject);
    	richiestaEmail.setRefAccount(dettaglio.getBody().getNvlOwnerId());
    	richiestaEmail.setSpUser(utente.getSpUser());
		richiestaEmail.setTesto(content);
		richiestaEmail.setSpDTipoEvento(spdTipoEventoRepository.findByCodiceEvento("CREAZIONE_UTENTE_DB"));
		richiestaEmail.setDataRichiesta(new Date(System.currentTimeMillis()));
		richiestaEmail = mailService.inserisciRichiestaDB(richiestaEmail);
    
		mailService.sendEmail("nivola-request@csi.it", applicationProperties.getDeploy().getIndirizzoServizio(), subject,  "Id richiesta: " + String.format("%07d", richiestaEmail.getId()) + content, false, false);
    	return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "Richiesta di creazione utente inviata correttamente"), HttpStatus.OK);
    	
    }
    
    
    /**
     * Richiesta tramite email di dismissione di un'utenza
     * @param uuid
     * @param datiUtente
     * @return
     * @throws BusinessException
     */
    @PutMapping("/dbaas/{uuid}/utente")
    @Secured({AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR, AuthoritiesConstants.ACCOUNT_VIEWER})
    @AzioneDispositiva
    public ResponseEntity<EsitoDTO> dismettiUtente (@PathVariable String uuid, @RequestBody DatiUtenteDbaas datiUtente) throws BusinessException {
    	ResponseEntity<DbaasDetailDTO> dettaglio = dettaglioDbaas(uuid);
    	UtenteShibboleth utente = SecurityUtils.getUtenteLoggatoCompleto();
    	SpMailRichiesta richiestaEmail = new SpMailRichiesta();
    	GetAccountResponseSchema accountCMP = authorityApi.v10NwsAccountsOidGet(dettaglio.getBody().getNvlOwnerId());
    	String ente;
    	SpDivisioneAttributo attr = attributiService.trovaAttributoDivisionePerNomeEDivisione("REMEDY_ENTE", accountCMP.getAccount().getDivisionId());
    	if (attr != null) {
    		ente = attr.getValore();
    	} else {
    		GetDivisionResponseSchema divisioneCMP = authorityApi.v10NwsDivisionsOidGet(accountCMP.getAccount().getDivisionId());
    		SpOrganizzazioneAttributo attrOrg = attributiService.trovaAttributoOrganizzazionePerNomeEDivisione("REMEDY_ENTE", divisioneCMP.getDivision().getOrganizationId());
    		if (attrOrg == null) {
    			throw new BusinessException("ENTE REMEDY NON CONFIGURATO");
    		}
    		ente = attrOrg.getValore();
    	}
		
    	String subject =  "NSP - richiesta dismissione utenza DB per account " + dettaglio.getBody().getNvlOwnerAlias();
    	String content =
    			"\nCodice fiscale: " + utente.getCodFiscale()+
    			"\nCognome: " + utente.getCognome() +
    			"\nNome: " + utente.getNome() +
    			"\nTipologia di utenza: " + SecurityUtils.getCurrentUser().getAbilitazioneSelezionata().getUserRoleDescription()+
    			"\nEnte di appartenenza: " + ente + 
    			"\nEmail: " + utente.getSpUser().getEmail() + 
    			"\nRichiesta di dismissione utente " + datiUtente.getNome() +" tipologia: "+datiUtente.getTipo() + " per il database " + dettaglio.getBody().getNome();
    	
    	richiestaEmail.setOggetto(subject);
    	richiestaEmail.setRefAccount(dettaglio.getBody().getNvlOwnerId());
    	richiestaEmail.setSpUser(utente.getSpUser());
		richiestaEmail.setTesto(content);
		richiestaEmail.setSpDTipoEvento(spdTipoEventoRepository.findByCodiceEvento("DISMISSIONE_UTENTE_DB"));
		richiestaEmail.setDataRichiesta(new Date(System.currentTimeMillis()));
		richiestaEmail = mailService.inserisciRichiestaDB(richiestaEmail);
    	
		mailService.sendEmail("nivola-request@csi.it", applicationProperties.getDeploy().getIndirizzoServizio(), subject,  "Id richiesta: " + String.format("%07d", richiestaEmail.getId()) + content, false, false);
    	
    	return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "Richiesta di dismissione utente inviata correttamente"), HttpStatus.OK);
    	
    }
    
    /**
	 * Calcolo dei costi MENSILI stimati per la configurazione scelta di una VM .
	 * @param richiestaCosti
	 * @returns
     * @throws SystemException 
	 */
	@GetMapping("/dbaas/stimacosto")
	@Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN,
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER,
		AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR,  AuthoritiesConstants.DIVISION_VIEWER,
		AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR,  AuthoritiesConstants.ACCOUNT_VIEWER})
	public ResponseEntity<ProspettoCostiVmDTO> getCostiStimatiVm(RichiestaCostiDbaasDTO richiestaCosti) throws SystemException {
		
		return new ResponseEntity<ProspettoCostiVmDTO>(costiListinoService.calcolaProspettoDb(richiestaCosti), HttpStatus.OK);
	}
}
