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
package it.csi.nivola.nivolasp.security;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.CollectionUtils;

import it.csi.nivola.nivolasp.config.ApplicationProperties;
import it.csi.nivola.nivolasp.config.DecodificaRuoliCMP;
import it.csi.nivola.nivolasp.domain.SpLogAccessoShib;
import it.csi.nivola.nivolasp.domain.SpUser;
import it.csi.nivola.nivolasp.domain.SpUserRuolo;
import it.csi.nivola.nivolasp.domain.UtenteShibboleth;
import it.csi.nivola.nivolasp.integration.rest.api.service.AuthorityApi;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetUserRolesAndServicesResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetUserRolesAndServicesResponseSchemaServices;
import it.csi.nivola.nivolasp.service.LoggingAccessiService;
import it.csi.nivola.nivolasp.service.UserService;
import it.csi.nivola.nivolasp.service.dto.AbilitazioneDTO;
import it.csi.nivola.nivolasp.service.dto.UserDTO;
import it.csi.nivola.nivolasp.service.mapper.cmp.AbilitazioneMapper;
import it.csi.nivola.nivolasp.util.StreamingObjectUtil;

/**
 * Filtro per l'autenticazione tramite IDP Shibboleth. Effettua l'integrazione con Spring security gestendo
 * la profizolazione dei ruoli all'interno del portal usando GrandedAuthority
 */
public class ShibbolethFilter implements Filter {
	
	private final Logger log = LoggerFactory.getLogger(ShibbolethFilter.class);
	
	// definisce i path da non proteggere (risorse statiche e service status
	private HashSet<String> pathDaNonProteggere = new HashSet<String>();
	
	// servizio di logging su database degli accessi shibboleth
	private LoggingAccessiService servizioLog = null;
	
	// servizio per il reperimento delle informazioni utente
	private UserService servizioUtente = null;
	
	// proprietà dell'applicazione su file application-(env).yml 
	private ApplicationProperties proprieta = null;
	
	private AuthorityApi authorityApi;
	
	// mapper per l'oggetto AbilitazioneDTO che contiene i ruoli ed i dettagli della profilazione dell'utente appena autenticato
	private AbilitazioneMapper abilitazioneMapper;
	
	// decodifica dei ruoli che l'utente possiede presso la CMP, usato in AbilitazioneDTO
	private DecodificaRuoliCMP decodificaRuoliCMP;

	
	/**
	 * Crea un filtro per l'autenticazione tramite IDP Shibboleth: ottiene la profilazione completa sul portale, sulla CMP
	 * ed effettua l'integrazione dell'autenticazione avvenuta con la gestione dei ruoli in Spring Security
	 */
	public ShibbolethFilter(LoggingAccessiService servizio, ApplicationProperties proprieta, UserService userService, AbilitazioneMapper abilitazioneMapper, DecodificaRuoliCMP decodificaRuoliCMP, AuthorityApi authorityApi) {
		this.proprieta = proprieta;
		servizioLog = servizio;
		servizioUtente = userService;
		this.abilitazioneMapper = abilitazioneMapper;
		this.decodificaRuoliCMP = decodificaRuoliCMP;
		this.authorityApi = authorityApi;
		pathDaNonProteggere = new HashSet<String>();
		pathDaNonProteggere.add(".*/angular/.*");
		pathDaNonProteggere.add(".*/bower_components/.*");
		pathDaNonProteggere.add(".*/css/.*");
		pathDaNonProteggere.add(".*/global/.*");
		pathDaNonProteggere.add(".*/img/.*");
		pathDaNonProteggere.add(".*/lib/.*");
		pathDaNonProteggere.add(".*/templates/.*");
		pathDaNonProteggere.add(".*/nivolaspsrv/error$");
		pathDaNonProteggere.add(".*/login.*");
		pathDaNonProteggere.add(".*/public/.*");
	}

	/**
	 * Esecuzione del filtraggio
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fchn) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		UtenteShibboleth utenteLoggato = (UtenteShibboleth) SecurityContextHolder.getContext().getAuthentication();
		
		String marker = getToken(request);
		
		//Se la risorsa e' libera oppure l'utente e' gia' autenticato procede
		if (risorsaLibera(req) || utenteLoggato != null)  {
			fchn.doFilter(req,resp);
			return;
		}
		
		/*
		 * Arriva qui se la risorsa non è libera e l'utente non ancora censito: se manca il marker shibboleth nell'header 
		 * l'utente non è autenticato, altrimenti recupera i dati
		 */
		if (utenteLoggato == null && marker == null) {
			log.warn("TENTATIVO DI ACCESSO A PAGINA NON AUTORIZZATA: " + request.getRequestURL() + " REDIRECT A: " + proprieta.getDeploy().getRedirectTo());
//			((HttpServletResponse) resp).sendRedirect(proprieta.getDeploy().getRedirectTo());
			SessionTimedOutResponse jsonDatiNuovoLogin = new SessionTimedOutResponse();
			jsonDatiNuovoLogin.setMessaggioSessioneScaduta("Sessione scaduta, e' necessario effettuare di nuovo l'autenticazione");
			jsonDatiNuovoLogin.setUrlLogin(proprieta.getDeploy().getRedirectTo());
			HttpServletResponse responseHttp = (HttpServletResponse) resp;
			responseHttp.setContentType("application/json");
			responseHttp.resetBuffer();
			responseHttp.setStatus(401);
			responseHttp.setHeader("Content-Type", "application/json");
			responseHttp.getOutputStream().print(StreamingObjectUtil.streamObjectToJSON(jsonDatiNuovoLogin));
			responseHttp.flushBuffer();
			
//			((HttpServletResponse) resp).sendError(403, );
		} else if (marker!= null) {
			componiUtente(resp, request, marker);
		}
		if(!resp.isCommitted()) {
			fchn.doFilter(req,resp);
		}
	}

	/**
	 * Crea il contesto di autenticazione in Spring security prelevando tutti i dati dell'utente e le sue abilitazioni
	 * dal DB del portale e dalla CMP.
	 * @param resp
	 * @param request
	 * @param marker
	 * @throws IOException
	 */
	private void componiUtente(ServletResponse resp, HttpServletRequest request, String marker) throws IOException {
		// evitare di ricreare l'utente se si fa refresh
		UtenteShibboleth identita = SecurityUtils.getUtenteLoggatoCompleto();
		if (identita != null && marker.equals(identita.getToken()))
			return;
		identita = new UtenteShibboleth(normalizeToken(marker));
		int progressivoAbilitazione = 1;
		try {
			
			//inizializza l'utenza base con le informazioni sull'identità in modo da visualizzare l'utente nel portale
			UserDTO userDto = inizializzaUserDTO(identita);
			userDto.setUrlLogout(proprieta.getLogoutInfo().get(identita.getIdProvider()));
			identita.setUserDto(userDto);

			// recupero informazioni censite a livello di portale
			SpUser infoUtentePerApi = servizioUtente.getUserByUsername(identita.getCodFiscale());
			
			
			
			identita.setSpUser(infoUtentePerApi);
			SecurityContextHolder.getContext().setAuthentication(identita);
			//registra l'avvenuto accesso
			logAccessoEffettuato(identita, infoUtentePerApi);

			//preset utente anonimo per non lasciare le credenziali vuote
			Set<String> elencoRuoli = new HashSet<String>();
			elencoRuoli.add(AuthoritiesEnum.ROLE_GUEST.getNomeVisualizzato());
			userDto.setDescrizioneRuolo(AuthoritiesEnum.ROLE_GUEST.getDescrizione());
			AbilitazioneDTO abilitazioneGuest = new AbilitazioneDTO();
			abilitazioneGuest.setProvenienteDaCmp(false);
			abilitazioneGuest.setId(1);
			abilitazioneGuest.setUserRole(AuthoritiesEnum.ROLE_GUEST.getNomeVisualizzato());
			abilitazioneGuest.setUserRoleDescription(AuthoritiesEnum.ROLE_GUEST.getDescrizione());
			userDto.setAbilitazioneSelezionata(abilitazioneGuest);
			Set<AbilitazioneDTO> elencoAbilitazioni = new HashSet<>();
			elencoAbilitazioni.add(abilitazioneGuest);
			userDto.setElencoAbilitazioni(elencoAbilitazioni);
			
			
			//arricchimento utente con le informazioni a disposizione del portale e successiva richiesta alla CMP
			if (infoUtentePerApi != null) {
				userDto.setId(infoUtentePerApi.getId());
				gestioneUtenteCensito(identita, progressivoAbilitazione, userDto, infoUtentePerApi, elencoRuoli);
			}
			
			if ("true".equals(proprieta.getParametroDb("manutenzione"))) {
				if (!userDto.getElencoAbilitazioni().stream().anyMatch(ab -> "MANUTENZIONE".equalsIgnoreCase(ab.getUserRole()))) {
					SecurityUtils.logout();
					request.getSession().invalidate();
			    	((HttpServletResponse) resp).sendRedirect(proprieta.getDeploy().getRedirectTo()+"/index_sp_not_available.html");
				}
					
			}
			
		} catch (Exception e) {
			log.error("ERRORE NELLA DECODIFICA DELL'UTENTE SHIBBOLETH - SAML", e);
			((HttpServletResponse) resp).sendRedirect(proprieta.getDeploy().getRedirectTo());
		} finally {
			SecurityContextHolder.getContext().setAuthentication(identita);
		}
	}

	
	private void gestioneUtenteCensito(UtenteShibboleth identita, int progressivoAbilitazione, UserDTO userDto, SpUser infoUtentePerApi, Set<String> elencoRuoli) {
		elencoRuoli.clear();
		userDto.setDescrizioneRuolo(AuthoritiesEnum.ROLE_GUEST.getDescrizione());
		userDto.setFirstName(infoUtentePerApi.getNome());
		userDto.setLastName(infoUtentePerApi.getCognome());
		userDto.setEmail(infoUtentePerApi.getEmail());
		userDto.setId(Long.valueOf(infoUtentePerApi.getId()));
		userDto.setAttivoCMP(infoUtentePerApi.getAttivoCMP());
		userDto.setUsaCredenziali(infoUtentePerApi.getUsaCredenziali());
		userDto.setUsaRemedy(infoUtentePerApi.getUsaRemedy());
		userDto.setAttivo(infoUtentePerApi.getAttivo());
		
		// se l'utente non è attivo non imposto le abilitazioni
		if (infoUtentePerApi.getAttivo() == false)
			return;
		Set<AbilitazioneDTO> elencoAbilitazioni = new HashSet<AbilitazioneDTO>();
		
		//ruoli portale
		if (!infoUtentePerApi.getSpUserRuolos().isEmpty() && infoUtentePerApi.getSpUserRuolos().get(0) != null) {
			for (SpUserRuolo r : infoUtentePerApi.getSpUserRuolos()) {
				//scarto i ruoli scaduti
				if (r.getDataFineValidita() != null  && new Timestamp(System.currentTimeMillis()).after(r.getDataFineValidita())) {
					continue;
				}
				//scarto i ruoli che non sono ancora validi
				if (r.getDataInizioValidita() != null  && new Timestamp(System.currentTimeMillis()).before(r.getDataInizioValidita())) {
					continue;
				}
				elencoRuoli.add(r.getSpRuolo().getRuolo());
				userDto.setDescrizioneRuolo(AuthoritiesEnum.valueOf(infoUtentePerApi.getSpUserRuolos().get(0).getSpRuolo().getRuolo()).getDescrizione());
				AbilitazioneDTO account = new AbilitazioneDTO();
				account.setOrgName("Nivola Service Portal");
				account.setOrgDesc("Nivola Service Portal");
				account.setProvenienteDaCmp(false);
				account.setUserRole(r.getSpRuolo().getRuolo());
				account.setUserRoleDescription(AuthoritiesEnum.valueOf(r.getSpRuolo().getRuolo()).getDescrizione());
				account.setId(progressivoAbilitazione++);
				
				elencoAbilitazioni.add(account);
			}
		}
		
		//informazinoi provenienti dalla CMP
		GetUserRolesAndServicesResponseSchema response = null;
		try {
			response = authorityApi.v10NwsServicesObjectsFilterByusernameGet(infoUtentePerApi.getCmpUsername());
		} catch (Exception e) {
			log.error("IMPOSSSIBILE OTTENERE LE ABILITAZIONI PER L'UTENTE " + infoUtentePerApi.getCmpUsername() + "- MOTIVO:", e);
		}
		//elenco ruoli presso la CMP
		if (response != null && response.getServices() != null) {
			for (GetUserRolesAndServicesResponseSchemaServices singolo : response.getServices()) {
				if (singolo.getUserRole() != null && decodificaRuoliCMP.getDecodifica(singolo.getUserRole()) != null &&
						(singolo.getAccountName() == null || !singolo.getAccountName().toUpperCase().contains("DELETED"))) {
					AbilitazioneDTO account = abilitazioneMapper.serviceToAbilitazione(singolo);
					account.setUserRoleDescription(decodificaRuoliCMP.getDecodifica(singolo.getUserRole()));
					account.setId(progressivoAbilitazione++);
					elencoAbilitazioni.add(account);
					elencoRuoli.add(singolo.getUserRole());
				}
				
			}
		}
		
		if (elencoAbilitazioni.size() == 0) {
			AbilitazioneDTO abilitazioneBase = new AbilitazioneDTO();
			abilitazioneBase.setId(1);
			abilitazioneBase.setUserRole("Ospite");
			abilitazioneBase.setUserRoleDescription("Ospite");
			elencoAbilitazioni.add(abilitazioneBase);
		}
		userDto.setElencoAbilitazioni(elencoAbilitazioni);
		identita.setGrantedAuthorities(elencoRuoli);
		userDto.setAbilitazioneSelezionata(CollectionUtils.isEmpty(userDto.getElencoAbilitazioni()) ? null : userDto.getElencoAbilitazioni().stream().findFirst().get());
	}

	private UserDTO inizializzaUserDTO(UtenteShibboleth identita) {
		UserDTO userDto = new UserDTO();
		userDto.setFirstName(identita.getNome());
		userDto.setLastName(identita.getCognome());
		userDto.setLogin(identita.getCodFiscale());
		userDto.setIdProvider(identita.getIdProvider());
		userDto.setIdAgente(BigInteger.ONE);
		userDto.setAttivo(true);
		userDto.setLangKey("IT");
		return userDto;
	}

	private void logAccessoEffettuato(UtenteShibboleth identita, SpUser infoUtentePerApi) {
		SpLogAccessoShib accesso = new SpLogAccessoShib();
		accesso.setCodiceFiscale(identita.getCodFiscale());
		accesso.setCognome(identita.getCognome());
		accesso.setComunitaShib(identita.getIdProvider());
		accesso.setDataAccesso(new Timestamp(System.currentTimeMillis()));
		accesso.setId("" + System.currentTimeMillis());
		accesso.setNome(identita.getNome());
		try {
			servizioLog.save(accesso);
			if (infoUtentePerApi != null)
				servizioLog.logAccesso(infoUtentePerApi);
		} catch (Exception e) {
			log.error("ERRORE DURANTE IL SALVATAGGIO DELL'ACCESSO SHIBBOLETH", e);
		}
	}

	private boolean risorsaLibera(ServletRequest req) {
		boolean libera = false;
		String requestURL = ((HttpServletRequest) req).getRequestURL().toString();
		for (String pathSingolo : pathDaNonProteggere) {
			libera = libera || requestURL.matches(pathSingolo);
		}
		return libera;
	}


	public void destroy() {
		// nulla da eseguire
	}

	public String getToken(HttpServletRequest httpreq) {
		if (proprieta.getDeploy().isDevMode()) 
//			return "DPNDME73A03L219D/Demo/Dipendente Due/CSI/20181015190239/2/jRryBU1Yk/d6gJwcD8fEOw=="; //
			return proprieta.getDeploy().getUtente(); // af: BOADMIN ADMIN account 4
		String marker = httpreq.getHeader("Shib-Iride-IdentitaDigitale");
//		Enumeration headerNames = httpreq.getHeaderNames();
//		while(headerNames.hasMoreElements()) {
//		  String headerName = (String)headerNames.nextElement();
//		  System.out.println(headerName + httpreq.getHeader(headerName));
//		}
		String provider = httpreq.getHeader("Shib-Identita-Provider");
		if (StringUtils.isNotEmpty(provider) && provider.contains("EXT")) {
			return httpreq.getHeader("Shib-Identita-CodiceFiscale")+"/"+
					httpreq.getHeader("Shib-Identita-Nome")+"/"+
					httpreq.getHeader("Shib-Identita-Cognome")+"/"+
					httpreq.getHeader("Shib-Identita-Provider")+"/"+
					httpreq.getHeader("Shib-Identita-TimeStamp")+"/"+
					httpreq.getHeader("Shib-Identita-LivAuth")+"/jRryBU1Yk/d6gJwcD8fEOw==";
		}
		return marker;
	}

	private String normalizeToken(String token) {
		return token;
	}

	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//non da implementare
	}
}
