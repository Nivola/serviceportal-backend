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
package it.csi.nivola.nivolasp.restinvoker;

import java.net.Socket;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import it.csi.nivola.nivolasp.config.ApplicationProperties;
import it.csi.nivola.nivolasp.domain.UtenteShibboleth;
//import it.csi.nivola.nivolasp.security.SecurityUtils;
import it.csi.nivola.nivolasp.service.LoggingAccessiService;

@Component
public class JwtTokenHelper implements JwtTokenHelperInterface {
	
	@Autowired
	ApplicationProperties applicationProperties = null;

	private static final String HEADER_CLIENT_ID = "client_id";
	private static final String HEADER_SCOPE = "scope";
	private static final String HEADER_ASSERTION = "assertion";
	private static final String HEADER_GRANT_TYPE = "grant_type";
	private static final String URN_IETF_PARAMS_OAUTH_GRANT_TYPE_JWT_BEARER = "urn:ietf:params:oauth:grant-type:jwt-bearer";
	private static final String HTTPS = "https://";
	private static RestTemplate springRestTemplate = null;
	
	private byte[] apiKeySecretBytes;
	
	private final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.RS512;
	
	// Sezione Refactory    
    @Autowired
    LoggingAccessiService loggingAccessiService = null; 
    
    private AccessTokenResponse accessTokenAdmin = null;
    
//    private final Logger log = LoggerFactory.getLogger(JwtTokenHelper.class);
    
	// elenco dei path per i quali e' necessario usare un token da admin
	private final Set<String> pathDaInvocareComeAdmin = new HashSet<String>();

	@PostConstruct
	public void setup () {
		apiKeySecretBytes = Base64.getDecoder().decode(applicationProperties.getBusinessApi().getPrivateKey());
		pathDaInvocareComeAdmin.add("/v1.0/nws/services/objects/filter/byusername");
		pathDaInvocareComeAdmin.add("/v1.0/nws/accounts");
		pathDaInvocareComeAdmin.add("/v1.0/nws/divisions");
		pathDaInvocareComeAdmin.add("/v1.0/nws/organizations");
		pathDaInvocareComeAdmin.add("/v1.0/nws/computeservices/instance/describeinstancesnapshots");
		pathDaInvocareComeAdmin.add("/v1.0/nws/computeservices/instance/createinstancesnapshots");
		pathDaInvocareComeAdmin.add("/v1.0/nws/computeservices/instance/deleteinstancesnapshots");
	}

	/**
	 * Restituisce il token admin o dell'utente se non richiesto refresh altrimenti 
	 * invoca il servizio di generazione del token usando JWT come Authorization Grant (2.1 RFC 7523)
	 * 
	 * @param path il path del servizio protetto da invocare per verificare se e' necessario un token admin
	 * @param refresh se in seguito ad un tentativo di invocazione e' necessario rigenerare un token
	 * @return
	 */
	public AccessTokenResponse retreiveAccessTokenJwt(String path, boolean refresh) {
		AccessTokenResponse tokenPresente= null;
		boolean risorsaAdmin = isRisorsaAdmin(path);
		if (!refresh) {
			if (risorsaAdmin)
				tokenPresente = accessTokenAdmin;
			else if (getTokenUtente() != null)
				tokenPresente =  getTokenUtente();
		}
		//al fine di funzionare anche con gli unit test, gestisco il caso in cui entrambi siano null
		if (tokenPresente != null)
			return tokenPresente;
		springRestTemplate = setupInvoker();
		
		String tokenServiceURL = HTTPS + applicationProperties.getBusinessApi().getHost() + "/v1.0/oauth2/token";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add(HEADER_GRANT_TYPE, URN_IETF_PARAMS_OAUTH_GRANT_TYPE_JWT_BEARER);
		body.add(HEADER_SCOPE, applicationProperties.getBusinessApi().getScopeValue());	
		createJwsAssertion(risorsaAdmin, body);
		
		
	   
		HttpEntity<Object> entity = new HttpEntity<Object>(body, headers);
		ResponseEntity<AccessTokenResponse> risposta = springRestTemplate.exchange(tokenServiceURL, HttpMethod.POST,
				entity, AccessTokenResponse.class);
		
		if (risorsaAdmin) {
			accessTokenAdmin = risposta.getBody();
		} else {
			impostaNuovoTokenUtente(risposta.getBody());
		}
		return risposta.getBody();
		
	}

	/**
	 * Imposta il template per l'invocazione del servizio di generazione del
	 * token ignorando i problemi sui certificati per HTTPS
	 * 
	 * @return
	 */
	private RestTemplate setupInvoker() {
		
		if (springRestTemplate != null)
			return springRestTemplate;
		
		try {
			SSLContext ctx = SSLContext.getInstance("TLS");
			X509TrustManager tm = new X509ExtendedTrustManager() {

				@Override
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				@Override
				public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType)
						throws java.security.cert.CertificateException {

				}

				@Override
				public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType)
						throws java.security.cert.CertificateException {

				}

				@Override
				public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType,
						SSLEngine engine) throws java.security.cert.CertificateException {

				}

				@Override
				public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType,
						Socket socket) throws java.security.cert.CertificateException {

				}

				@Override
				public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType,
						SSLEngine engine) throws java.security.cert.CertificateException {

				}

				@Override
				public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType,
						Socket socket) throws java.security.cert.CertificateException {

				}
			};
			ctx.init(null, new TrustManager[] { tm }, null);
			SSLContext.setDefault(ctx);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		springRestTemplate = new RestTemplate(
				new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
		interceptors.add(new RestLoggingInterceptor());
		springRestTemplate.setInterceptors(interceptors);
		return springRestTemplate;
	}

	/**
	 * Creazione dell'asserzione JWT per la generazione del token
	 * @param body 
	 * 
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	private void createJwsAssertion(boolean risorsaAdmin, MultiValueMap<String, String> body){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	UtenteShibboleth utenteAutenticato = null;
    	/*
    	 * se nessuno loggato trovo AnonymousAuthenticationToken
    	 */
    	if (auth instanceof UtenteShibboleth) {
    		utenteAutenticato = (UtenteShibboleth) auth;
    	}
    	
    	/*
    	 * Gestione alternativa generazione token per admin o utewnte loggato
    	 */
		String subject = applicationProperties.getParametroDb(ApplicationProperties.PARAMETRO_DB_CMP_SUBJECT);
		String clientId = applicationProperties.getParametroDb(ApplicationProperties.PARAMETRO_DB_CLIENT_ID);
		String issuer = applicationProperties.getParametroDb(ApplicationProperties.PARAMETRO_DB_CMP_USER);
		
		if (utenteAutenticato != null && !risorsaAdmin) {
			subject = utenteAutenticato.getSpUser().getCmpUsername()+":"+utenteAutenticato.getSpUser().getSecretKey();
		}
		
		try {
			
			long nowMillis = System.currentTimeMillis();
			Date now = new Date(nowMillis);
	
			// Recupero della chiave privata RSA
			String pkcs8Pem = new String(apiKeySecretBytes);
			
			/* La chiave decodificata contiene le diciture --- BEGIN [...] PRIVATE KEY --- e --- END [...] PRIVATE KEY --- 
			 * a volte è scritto RSA, a volte no, in base a come viene generata la chiave. per cui la prima e l'ultima riga
			 * devono essere eliminate.
			 */
			String[] lineeChiave = pkcs8Pem.split("\n");
			StringBuilder chiaveSenzaIntestazioneCoda = new StringBuilder();
			for (int numeroLinea = 1 ; numeroLinea < lineeChiave.length; numeroLinea ++) {
				if (numeroLinea != lineeChiave.length -1)
					chiaveSenzaIntestazioneCoda.append(lineeChiave[numeroLinea]);
			}
			pkcs8Pem = chiaveSenzaIntestazioneCoda.toString();
			pkcs8Pem = pkcs8Pem.replaceAll("\\s+", "");
			
			PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(pkcs8Pem));
			KeyFactory kf;
			
			kf = KeyFactory.getInstance(SignatureAlgorithm.RS512.getFamilyName());
			
			PrivateKey signingKey = kf.generatePrivate(spec);
			
			JwtBuilder builder = Jwts.builder().setId(clientId).setIssuedAt(now).setIssuer(issuer).setAudience(applicationProperties.getBusinessApi().getAudience()).setSubject(subject).signWith(signatureAlgorithm, signingKey);
	
			long expMillis = nowMillis + 100000;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
			
			String jwtAssertion = builder.compact();
			body.add(HEADER_ASSERTION, jwtAssertion);	
			body.add(HEADER_CLIENT_ID, clientId);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException  e) {
			e.printStackTrace();
			throw new RestClientException("ERRORE DURANTE LA CREAZIONE DEL TOKEN JWT", e);
		}
	}
	
	// Sezione refactory
	
	private void impostaNuovoTokenUtente (AccessTokenResponse nuovoAccessToken) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	UtenteShibboleth utenteAutenticato = null;
    	//se nessuno loggato trovo AnonymousAuthenticationToken
    	if (auth instanceof UtenteShibboleth) {
    		utenteAutenticato = (UtenteShibboleth) auth;
    		utenteAutenticato.setAccessToken(nuovoAccessToken);
    	}
		
	}
	/*
	@Override
	public void logInvocazioneCmp(HttpRequest request, byte[] body, ClientHttpResponse response) {
		try {
			loggingAccessiService.logInvocazioneCmp(request, body, response, SecurityUtils.getUtenteLoggatoCompleto() == null ? null : SecurityUtils.getUtenteLoggatoCompleto().getSpUser());
		} catch (Exception e) {
			log.error("********************** IMPOSSIBILE REGISTRARE L'INVOCAZIONE SU SP_LOG_INVOCAZIONI_CMP:", e);
		}
	}
*/

	public String getBasePath() {
		return applicationProperties.getBusinessApi().getBasePath();
	}


	private boolean isRisorsaAdmin(String path) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	UtenteShibboleth utenteAutenticato = null;
    	//se nessuno loggato trovo AnonymousAuthenticationToken
    	if (auth instanceof UtenteShibboleth) {
    		utenteAutenticato = (UtenteShibboleth) auth;
    		if (utenteAutenticato.getSpUser() != null && utenteAutenticato.getSpUser().getUsaCredenziali())
    			return pathDaInvocareComeAdmin.stream().anyMatch(pathAdmin -> path.contains(pathAdmin));
    	}
		return true;
	}

	private AccessTokenResponse getTokenUtente() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	UtenteShibboleth utenteAutenticato = null;
    	//se nessuno loggato trovo AnonymousAuthenticationToken
    	if (auth instanceof UtenteShibboleth) {
    		utenteAutenticato = (UtenteShibboleth) auth;
    		return utenteAutenticato.getAccessToken();
    	}
    	return null;
	}
}
