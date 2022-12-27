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

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.csi.nivola.nivolasp.domain.SpRuolo;
import it.csi.nivola.nivolasp.domain.SpUser;
import it.csi.nivola.nivolasp.domain.SpUserRuolo;
import it.csi.nivola.nivolasp.domain.UtenteShibboleth;
import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.integration.rest.api.auth.AuthorizationApi;
import it.csi.nivola.nivolasp.integration.rest.model.auth.CreateUserRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.auth.CreateUserRequestSchemaUser;
import it.csi.nivola.nivolasp.integration.rest.model.auth.CreateUserRequestSchemaUser.StoretypeEnum;
import it.csi.nivola.nivolasp.integration.rest.model.auth.CrudApiObjectResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.auth.ListUsersResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.auth.UserSecretResponseSchema;
import it.csi.nivola.nivolasp.repository.SpRuoloRepository;
import it.csi.nivola.nivolasp.repository.SpUserRepository;
import it.csi.nivola.nivolasp.repository.SpUserRuoloRepository;
import it.csi.nivola.nivolasp.service.dto.DatiSinteticiUtenteDto;
import it.csi.nivola.nivolasp.service.dto.DatiUtenteDTO;
import it.csi.nivola.nivolasp.service.dto.UserDTO;

/**
 * Servizio per la gestione utente
 */
@Service
@Transactional
public class UserService {
	
	private static final String TESTO_EMAIL_REGISTRAZIONE = "Buongiorno %s %s, sei appena stato registrato correttamente su Nivola!<br/>"
			+ "E' ora possibile accedere al Service Portal tramte il seguente url <a href=\"%s\">%s</a><br/>"
			+ "Utilizzando uno dei sistemi di autenticazione supportati (SPID, RUPAR, Sistema Piemonte, Credenziali intranet CSI)<br/><br/>"
			+ "Grazie, il team Nivola.";


	AuthorizationApi authorizationApi;
	

    private final SpUserRepository spUserRepository;
    private final SpUserRuoloRepository spUserRuoloRepository;
    private final SpRuoloRepository spRuoloRepository;
    private final MailService mailService;

    public UserService(SpUserRepository spUserRepository, SpUserRuoloRepository spUserRuoloRepository, AuthorizationApi authorizationApi, MailService mailService, SpRuoloRepository spRuoloRepository) {
        this.spUserRepository = spUserRepository;
        this.spUserRuoloRepository = spUserRuoloRepository;
        this.authorizationApi = authorizationApi;
        this.mailService = mailService;
        this.spRuoloRepository = spRuoloRepository;
    }

    /**
     * Registrazione utente da parte dell'amministratore di backoffice. Servizio legacy.
     * @param cognome
     * @param codiceFiscale
     * @param email
     * @param idAgente
     * @param matricolaCsi
     * @param nome
     * @param secretKey
     * @param username
     * @param role
     * @param attivo
     * @param emailUtenteCorrente
     * @return
     * @throws BusinessException
     */
    public SpUser createUser(String cognome, String codiceFiscale, String email, BigInteger idAgente, String matricolaCsi, String nome, String secretKey, String username, String role, Boolean attivo, String emailUtenteCorrente, boolean usaCredenziali, boolean usaRemedy) throws BusinessException{
    	String cmpUser = StringUtils.isNotEmpty(matricolaCsi) ? matricolaCsi+"@domnt.csi.it" : codiceFiscale+"@portal";
    	username = codiceFiscale;
    	if (spUserRepository.findOneByCodiceFiscale(codiceFiscale).isPresent())
    		throw new BusinessException("Utente con codice fiscale " + codiceFiscale + " gia' presente in anagrafica");
    	
    	if (spUserRepository.findOneByUsername(username).isPresent())
    		throw new BusinessException("Utente con nome utente " + username + " gia' presente in anagrafica");
    	
    	if (spUserRepository.findOneByCmpUsername(cmpUser).isPresent())
    		throw new BusinessException("Utente con matricola " + matricolaCsi + " gia' presente in anagrafica");
    	
        SpUser newUser = new SpUser();
        newUser.setCmpUsername(cmpUser);
        newUser.setCodiceFiscale(codiceFiscale);
        newUser.setCognome(cognome);
        Timestamp adesso = new Timestamp(System.currentTimeMillis());
		newUser.setDataCreazione(adesso);
        newUser.setDataModifica(adesso);
        newUser.setEmail(email);
        newUser.setIdAgente(idAgente);
        newUser.setMatricolaCsi(matricolaCsi);
        newUser.setNome(nome);
        newUser.setSecretKey(secretKey);
        newUser.setUsername(username);
        newUser.setAttivo(attivo);
        newUser.setStato(attivo ? "ATTIVO" : "DISATTIVATO");
        newUser.setUsaCredenziali(true);
        newUser.setUsaRemedy(usaRemedy);
        
        newUser = creazioneUtentePressoCMP(newUser);
        
        newUser = spUserRepository.save(newUser);
        
        if (role != null ) { 
	        SpUserRuolo ruolo = new SpUserRuolo();
	        ruolo.setDataCreazione(adesso);
	        ruolo.setDataInizioValidita(adesso);
	        ruolo.setDataModifica(adesso);
	        ruolo.setIdAgente(idAgente);
	        
	        ruolo.setSpRuolo(spRuoloRepository.findOne(role));
	        ruolo.setSpUser(newUser);
	        spUserRuoloRepository.save(ruolo);
        }
        
        mailService.sendEmail(newUser.getEmail(), new String[] {newUser.getEmail()}, "Registrazione Utente su Nivola", 
    			String.format(TESTO_EMAIL_REGISTRAZIONE, newUser.getNome(), newUser.getCognome(), "https://portal.nivolapiemonte.it/", "https://portal.nivolapiemonte.it/"), false, true);
        return newUser;
    }
    
    /**
     * Autoregistrazione di un utente guest con credenziali SSO.
     * @param utente
     * @return
     * @throws BusinessException
     */
    public SpUser creazioneUtenteGuest(DatiUtenteDTO utente, UtenteShibboleth utenteLoggato) throws BusinessException{
    	
    	String cmpUser = StringUtils.isNotEmpty(utente.getMatricolaCsi()) ? utente.getMatricolaCsi()+"@domnt.csi.it" : utenteLoggato.getCodFiscale()+"@portal";
    	
    	if (spUserRepository.findOneByCodiceFiscale(utenteLoggato.getCodFiscale()).isPresent())
    		throw new BusinessException("Utente con codice fiscale " + utenteLoggato.getCodFiscale() + " gia' presente in anagrafica");
    	
    	if (spUserRepository.findOneByUsername(utenteLoggato.getCodFiscale()).isPresent())
    		throw new BusinessException("Utente con nome utente " + utenteLoggato.getCodFiscale() + " gia' presente in anagrafica");
    	
    	if (spUserRepository.findOneByCmpUsername(cmpUser).isPresent())
    		throw new BusinessException("Utente con username CMP " + cmpUser + " gia' presente in anagrafica");
    	
    	
    	if (spUserRepository.findOneByMatricolaCsi(utente.getMatricolaCsi()).isPresent())
    		throw new BusinessException("Utente con matricola " + utente.getMatricolaCsi() + " gia' presente in anagrafica");
    	
    	SpUser newUser = new SpUser();
    	newUser.setCmpUsername(utenteLoggato.getCodFiscale());
    	newUser.setCodiceFiscale(utenteLoggato.getCodFiscale());
    	newUser.setCognome(utenteLoggato.getCognome());
    	Timestamp adesso = new Timestamp(System.currentTimeMillis());
    	newUser.setDataCreazione(adesso);
    	newUser.setDataModifica(adesso);
    	newUser.setEmail(utente.getEmail());
    	newUser.setMatricolaCsi(utente.getMatricolaCsi());
    	newUser.setNome(utenteLoggato.getNome());
    	newUser.setUsername(utenteLoggato.getCodFiscale());
    	newUser.setAttivo(true);
    	
    	newUser = creazioneUtentePressoCMP(newUser);
    	
    	newUser = spUserRepository.save(newUser);
    	mailService.sendEmail(utente.getEmail(), new String[] {utente.getEmail()}, "Registrazione Utente su Nivola", 
    			String.format(TESTO_EMAIL_REGISTRAZIONE, newUser.getNome(), newUser.getCognome(), "https://portal.nivolapiemonte.it/", "https://portal.nivolapiemonte.it/")
    	+"\n\nNote per il supporto:\n" + utente.getNote(), false, true);
    	
    	return newUser;
    }
    
    
    public SpUser updateUser(DatiUtenteDTO datiUtente, Long idAgenteAggiornamento) throws ServiceException{
    	
    	if (!spUserRepository.exists(datiUtente.getId()))
    		throw new ServiceException("Utente con id " + datiUtente.getId() + " inesistente");
    	SpUser utenteDaAggiornare = spUserRepository.findOne(datiUtente.getId());
    	utenteDaAggiornare.setDataModifica(new Timestamp(System.currentTimeMillis()));
    	utenteDaAggiornare.setIdAgente(BigInteger.valueOf(idAgenteAggiornamento));
    	utenteDaAggiornare.setAttivo(datiUtente.getAttivo());
    	utenteDaAggiornare.setStato(datiUtente.getAttivo() ? "ATTIVO" : "DISATTIVATO");
//    	utenteDaAggiornare.setAttivoCMP(datiUtente.getAttivoCMP());
    	utenteDaAggiornare.setCodiceFiscale(datiUtente.getCodiceFiscale());
    	utenteDaAggiornare.setCmpUsername(datiUtente.getMatricolaCsi()+"@domnt.csi.it");
    	utenteDaAggiornare.setCognome(datiUtente.getCognome());
    	utenteDaAggiornare.setEmail(datiUtente.getEmail());
    	utenteDaAggiornare.setMatricolaCsi(datiUtente.getMatricolaCsi());
    	utenteDaAggiornare.setNome(datiUtente.getNome());
    	utenteDaAggiornare.setUsername(datiUtente.getCodiceFiscale());
    	utenteDaAggiornare.setUsaRemedy(datiUtente.getUsaRemedy());
    	utenteDaAggiornare = spUserRepository.save(utenteDaAggiornare);

    	return utenteDaAggiornare;
    }
    
    public SpUser deleteUser(Long id, Long idAgenteAggiornamento) throws ServiceException{
    	
    	if (!spUserRepository.exists(id))
    		throw new ServiceException("Utente con id " + id + " inesistente");
    	SpUser utenteDaAggiornare = spUserRepository.findOne(id);
    	utenteDaAggiornare.setDataCancellazione(new Timestamp(System.currentTimeMillis()));
    	utenteDaAggiornare.setAttivo(false);
    	utenteDaAggiornare = spUserRepository.save(utenteDaAggiornare);
    	
    	return utenteDaAggiornare;
    }
    
    /**
     * Crea l'utente presso la CMP, gestendo la duplicazione
     * @param newUser
     * @return
     */
	public SpUser creazioneUtentePressoCMP(SpUser newUser) {
    	String uuid;
    	
		ListUsersResponseSchema cercaUtenteCmp = authorizationApi.v10NasUsersGet(null, null, newUser.getCmpUsername(), 
				null, null, null, null, null, null, null, null, null, null);
		if (cercaUtenteCmp.getCount() == 0) {
			CreateUserRequestSchema creaUtente = new CreateUserRequestSchema();
    		CreateUserRequestSchemaUser utente = new CreateUserRequestSchemaUser();
    		utente.setActive(true);
    		utente.setBase(true);
    		utente.setDesc(newUser.getNome() + " " + newUser.getCognome());
    		utente.setExpirydate("2099-12-31");
    		utente.setName(newUser.getCmpUsername());
    		utente.setPassword("passw0rd");
    		utente.setStoretype(StoretypeEnum.DBUSER);
    		utente.setSystem(false);
    		utente.setEmail(newUser.getEmail());
    		creaUtente.setUser(utente);
    		CrudApiObjectResponseSchema risposta = authorizationApi.v10NasUsersPost(creaUtente);
    		uuid = risposta.getUuid().toString();
		} else {
			uuid = cercaUtenteCmp.getUsers().get(0).getUuid();
		}
		newUser.setUuidUtente(uuid);
    	UserSecretResponseSchema richiestaSecretKey = authorizationApi.v10NasUsersOidSecretGet(uuid);
		newUser.setSecretKey(richiestaSecretKey.getUser().getSecret());
    	return newUser;
	}

    public SpUser createUser(UserDTO userDTO) {
    	SpUser user = new SpUser();
        
        return user;
    }

    @Transactional(readOnly = true)
    public SpUser getUserByUsername(String username) {
        return spUserRepository.findOneByUsername(username).orElse(null);
    }
    
    @Transactional(readOnly = true)
    public Long countUtenti() {
    	return spUserRepository.count();
    }
    
    @Transactional(readOnly = true)
    public SpUser getUserBycf(String cf) {
    	return spUserRepository.findOneByCodiceFiscale(cf).orElse(null);
    }
    
    @Transactional(readOnly = true)
    public List<SpUser> getAll() {
    	return spUserRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public SpUser getUserById(Long id) {
    	return spUserRepository.findOne(id);
    }
    
    @Transactional(readOnly = true)
    public SpUser getUserByUuid(String id) {
    	return spUserRepository.findOneByUuidUtente(id);
    }
    
    @Transactional(readOnly = true)
    public SpRuolo getRuoloById(String id) {
    	return spRuoloRepository.findOne(id);
    }

    public SpUserRuolo associaRuolo (SpUserRuolo daAssociare) {
    	return spUserRuoloRepository.saveAndFlush(daAssociare);
    }

	public void eliminaRuolo(Long id, String ruolo) {
		spUserRuoloRepository.eliminaAssociazione(id, ruolo);
		
	}
	
	public List<DatiSinteticiUtenteDto> ricercaUtenteCognome (String cognome) {
		List<DatiSinteticiUtenteDto> elencoRisultati = new LinkedList<>();
		spUserRepository.findByCognomeStartsWithIgnoreCase(cognome).ifPresent(el -> el.forEach(
				user -> elencoRisultati.add(mappaElemento(user))));
		return elencoRisultati;
	}

	private DatiSinteticiUtenteDto mappaElemento(SpUser user) {
		DatiSinteticiUtenteDto dati = new DatiSinteticiUtenteDto();
		dati.setCognome(user.getCognome());
		dati.setNome(user.getNome());
		dati.setId(user.getId());
		return dati;
	}


}
