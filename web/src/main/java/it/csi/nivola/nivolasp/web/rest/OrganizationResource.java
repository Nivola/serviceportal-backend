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

import java.util.List;
import java.util.Objects;

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
import it.csi.nivola.nivolasp.domain.SpUser;
import it.csi.nivola.nivolasp.integration.rest.api.service.AuthorityApi;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateOrganizationRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateOrganizationRequestSchemaOrganization;
import it.csi.nivola.nivolasp.integration.rest.model.service.CrudApiObjectResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetAccountUsersResponseSchemaUsers;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetOrganizationResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetOrganizationUsersResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListOrganizationsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.UpdateOrganizationRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.UpdateOrganizationRequestSchemaOrganization;
import it.csi.nivola.nivolasp.security.AuthoritiesConstants;
import it.csi.nivola.nivolasp.service.AttributiService;
import it.csi.nivola.nivolasp.service.UserService;
import it.csi.nivola.nivolasp.service.dto.FiltroOrganizzazioneDto;
import it.csi.nivola.nivolasp.service.dto.OrganizzazioneDTO;
import it.csi.nivola.nivolasp.service.dto.UtenteAccountDTO;
import it.csi.nivola.nivolasp.service.mapper.OrganizzazioneMapper;

/**
 * REST controller Per Organizzazione
 */
@RestController
@RequestMapping("/api")
public class OrganizationResource {
	
	@Autowired
	public AuthorityApi authorityApi;

	@Autowired
	public OrganizzazioneMapper organizzazioneMapper;

    private final Logger log = LoggerFactory.getLogger(OrganizationResource.class);
    
    @Autowired
	public UserService userService;
    
    @Autowired
    public AttributiService attributiService;
   
    
    /**
     * Ricerca puntuale organizzazione
     * @param uuid
     * @return
     */
    @GetMapping("/organizzazione/{uuid}")
    
    @Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER})
    public ResponseEntity<OrganizzazioneDTO> getOrganizzazione(@PathVariable String uuid) {
    	log.debug("RICHIESTA ORGANIZZAZIONE PUNTUALE PER ID = " + uuid);
    	GetOrganizationResponseSchema response = authorityApi.v10NwsOrganizationsOidGet(uuid);
    	if (response == null) {
    		new ResponseEntity<>("Nessun dato trovato", HttpStatus.NOT_FOUND);
    	}
    	
    	OrganizzazioneDTO organizzazioneDTO = organizzazioneMapper.toOrganizzazioneDTO(response.getOrganization());
    	organizzazioneDTO.setElencoAttributi(attributiService.elencoAttributiOrganizzazione(uuid));
		return new ResponseEntity<OrganizzazioneDTO>(organizzazioneDTO, HttpStatus.OK);
    }

    /**
     * Elenco Organizzazioni filtrate
     */
	@GetMapping("/organizzazione")
    
    @Secured(AuthoritiesConstants.BOADMIN)
    public ResponseEntity<List<OrganizzazioneDTO>> getOrganizzazioniFiltrate(FiltroOrganizzazioneDto filtro, @ApiParam Pageable pageable) {
		ListOrganizationsResponseSchema response = null;
		if (filtro == null) {
			response = authorityApi.v10NwsOrganizationsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    	} else {
    		response = authorityApi.v10NwsOrganizationsGet(-1, 0, null, null, null, null, null, null, null, null, null, filtro.getName(), null, null, filtro.getActive(), filtro.getOrgType(), filtro.getServiceStatusId(), null, null, filtro.getHasvat(), null, filtro.getReferent(), filtro.getEmail(), filtro.getLegalemail(), filtro.getPostaladdress());
    	}
		if (response == null || response.getCount() == 0)
    		new ResponseEntity<>("Nessun dato trovato", HttpStatus.NOT_FOUND);
    	return new ResponseEntity<List<OrganizzazioneDTO>>(organizzazioneMapper.toListOrganizzazioneDTOs(response.getOrganizations()), HttpStatus.OK);
    }
	
	
	/**
	 * Creazione di una nuova organizzazione
	 * @param org
	 * @return
	 */
	@PostMapping("/organizzazione")
	
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<String> creaOrganizzazione(@RequestBody OrganizzazioneDTO org) {
		CreateOrganizationRequestSchema richiesta= new CreateOrganizationRequestSchema();
		CreateOrganizationRequestSchemaOrganization organization = new CreateOrganizationRequestSchemaOrganization();
		organization.setAttributes(org.getAttributes());
		organization.setDesc(org.getDesc());
		organization.setEmail(org.getEmail());
		organization.setExtAnagId(org.getExtAnagId());//codiceClienteSAP
		organization.setHasvat(org.getHasvat());//soggettoAIVA
		organization.setLegalemail(org.getLegalemail());// immagino PEC
		organization.setName(org.getName());
		organization.setOrgType(org.getOrgType());
		organization.setPartner(org.getPartner());
		organization.setPostaladdress(org.getPostaladdress());
		organization.setReferent(org.getReferent());
		richiesta.setOrganization(organization);
		CrudApiObjectResponseSchema rispostaCreazione = authorityApi.v10NwsOrganizationsPost(richiesta);
		
		/*if (org.getEnteSelezionato() != null) {
			SpOrganizzazioneAttributo attr = new SpOrganizzazioneAttributo();
			attr.setOrgId(rispostaCreazione.getUuid().toString());
			attr.setSpDTipoAttributo(attributiService.trovaAttributoPerNome("REMEDY_ENTE"));
			attr.setSpUser(SecurityUtils.getUtenteLoggatoCompleto().getSpUser());
			attr.setValore(org.getEnteSelezionato().getDescrizioneEnte());
			attributiService.inserisciAttributoOrganizzazione(attr);
		}*/
		
		if (rispostaCreazione.getUuid() != null && Objects.toString(rispostaCreazione.getUuid()) != null)
			return new ResponseEntity<String>(rispostaCreazione.getUuid().toString(), HttpStatus.CREATED);
		else
			return new ResponseEntity<String>("Errore durante la creazione dell'organizzazione'", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	/**
	 * Aggiornamento organizzazione esistente
	 * @param org
	 * @return
	 */
	@PutMapping("/organizzazione")
	
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<String> aggiornaOrganizzazione(@RequestBody OrganizzazioneDTO org) {
		UpdateOrganizationRequestSchemaOrganization organization = new UpdateOrganizationRequestSchemaOrganization();
		organization.setActive(org.getActive());
		organization.setAttributes(org.getAttributes());
		organization.setDesc(org.getDesc());
		organization.setEmail(org.getEmail());
		organization.setExtAnagId(org.getExtAnagId());
		organization.setHasvat(org.getHasvat());
		organization.setLegalemail(org.getLegalemail());
		organization.setName(org.getName());
		organization.setOrgType(org.getOrgType());
		organization.setPartner(org.getPartner());
		organization.setPostaladdress(org.getPostaladdress());
		organization.setReferent(org.getReferent());
		
		UpdateOrganizationRequestSchema richiesta = new UpdateOrganizationRequestSchema();
		richiesta.setOrganization(organization);
		CrudApiObjectResponseSchema rispostaCreazione = null;
		rispostaCreazione = authorityApi.v10NwsOrganizationsOidPut(String.valueOf(org.getUuid()),richiesta);
		/*SpOrganizzazioneAttributo attr = attributiService.trovaAttributoOrganizzazionePerNomeEDivisione("REMEDY_ENTE", org.getUuid());
		if (org.getEnteSelezionato() != null) {
			if (attr == null) {
				attr = new SpOrganizzazioneAttributo();
				attr.setSpDTipoAttributo(attributiService.trovaAttributoPerNome("REMEDY_ENTE"));
				attr.setOrgId(org.getUuid());
			}
			attr.setDataModifica(new Timestamp(System.currentTimeMillis()));
			attr.setSpUser(SecurityUtils.getUtenteLoggatoCompleto().getSpUser());
			attr.setValore(org.getEnteSelezionato().getDescrizioneEnte());
			attributiService.inserisciAttributoOrganizzazione(attr);
		} else if (attr != null) {
			attributiService.eliminaAttributoOrganizzazione(attr);
		}*/
		
		if (rispostaCreazione != null && rispostaCreazione.getUuid() != null && Objects.toString(rispostaCreazione.getUuid()) != null)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	/**
	 * Eliminazione di un'organizzazione
	 * @param id
	 * @return
	 */
	@DeleteMapping("/organizzazione/{id}")
    
    @Secured(AuthoritiesConstants.BOADMIN)
    public ResponseEntity<HttpStatus> cancellaOrganizzazione(@PathVariable String id) {
		authorityApi.v10NwsOrganizationsOidDelete(String.valueOf(id));
		return new ResponseEntity<>(HttpStatus.OK);
    }
	
	
	/**
	 * Restituisce l'elenco degli utenti di una divisione
	 * @param uuid
	 * @return
	 */
	@GetMapping("/organizzazione/{uuid}/utenti")
	
	@Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR})
	public ResponseEntity<List<UtenteAccountDTO>> elencoUtentiAccount(@PathVariable String uuid) {
		GetOrganizationUsersResponseSchema risposta = authorityApi.v10NwsOrganizationsOidUsersGet(uuid, -1, 0, null, null);
		List<GetAccountUsersResponseSchemaUsers> utenti = risposta.getUsers();
		List<SpUser> elencoUtentiPortale = userService.getAll();
		return ResponseEntity.ok(RestUtils.composizioneUtentiElencoACCOUNT(utenti, risposta.getCount(), elencoUtentiPortale, null, null));
	}
	
	
	public AuthorityApi getAuthorityApi() {
		return authorityApi;
	}
	public void setAuthorityApi(AuthorityApi authorityApi) {
		this.authorityApi = authorityApi;
	}
	public OrganizzazioneMapper getOrganizzazioneMapper() {
		return organizzazioneMapper;
	}
	public void setOrganizzazioneMapper(OrganizzazioneMapper organizzazioneMapper) {
		this.organizzazioneMapper = organizzazioneMapper;
	}
	
	
}
