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
package it.csi.nivola.nivolasp.integration.remedy.invoker;

import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import it.csi.nivola.nivolasp.integration.remedy.config.RemedyApiConfig;

@Component
public class ClientCredentialsHelper {
	
    
    private final Logger log = LoggerFactory.getLogger(ClientCredentialsHelper.class);
    
	private static RestTemplate springRestTemplate = null;
	
	@Autowired
	RemedyApiConfig remedyApiConfig;
	
	public RemedyApiConfig getRemedyApiConfig() {
		return remedyApiConfig;
	}
	
	public void setRemedyApiConfig(RemedyApiConfig remedyApiConfig) {
		this.remedyApiConfig = remedyApiConfig;
	}

	/**
	 * Restituisce il token admin o dell'utente se non richiesto refresh altrimenti 
	 * invoca il servizio di generazione del token usando JWT come Authorization Grant (2.1 RFC 7523)
	 * 
	 * @param path il path del servizio protetto da invocare per verificare se e' necessario un token admin
	 * @param refresh se in seguito ad un tentativo di invocazione e' necessario rigenerare un token
	 * @return
	 */
	public String richiediToken() {
		
		springRestTemplate = setupInvoker();
		
		String tokenServiceURL = remedyApiConfig.getTokenUrl();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		String headerAuth = remedyApiConfig.getConsumerKey()+":"+remedyApiConfig.getConsumerSecret();
		headers.add(HttpHeaders.AUTHORIZATION, "Basic " + Base64Utils.encodeToString(headerAuth.getBytes(StandardCharsets.UTF_8)));
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("grant_type","client_credentials");
		HttpEntity<Object> entity = new HttpEntity<Object>(body, headers);
		ResponseEntity<AccessToken> risposta = springRestTemplate.exchange(tokenServiceURL, HttpMethod.POST,
				entity, AccessToken.class);
		log.debug("");
		
		return risposta.getBody().getAccessToken();
		
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

}
