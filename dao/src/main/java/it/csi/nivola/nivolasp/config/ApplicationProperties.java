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
package it.csi.nivola.nivolasp.config;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.boot.context.properties.ConfigurationProperties;

import it.csi.nivola.nivolasp.domain.SpConfig;
import it.csi.nivola.nivolasp.repository.SpConfigRepository;

/**
 * Properties specific to JHipster.
 *
 * <p>
 * Properties are configured in the application.yml file.
 * </p>
 */
@ConfigurationProperties(ignoreUnknownFields = true)
public class ApplicationProperties {
	
	public static final String PARAMETRO_DB_CLIENT_ID = "cmp_client_id";
	public static final String PARAMETRO_DB_CMP_SECRET = "cmp_secret";
	public static final String PARAMETRO_DB_CMP_USER = "cmp_user"; 
	public static final String PARAMETRO_DB_CMP_SUBJECT = "cmp_subject";
	public static final String PARAMETRO_DB_DBAAS_MIN_SIZE = "dbaas_min_size";
	public static final String PARAMETRO_DB_DBAAS_MAX_SIZE = "dbaas_max_size";

	private final Deploy deploy = new Deploy();
	private BusinessApi businessApi = new BusinessApi();
	
	public SpConfigRepository spConfigRepository = null;
	
	private final Map<String, String> parametriDb;
	
	private Map<String, String> logoutInfo;
	
	public ApplicationProperties(SpConfigRepository spConfigRepository) {
		parametriDb = spConfigRepository.findAll().stream().collect(Collectors.toMap(SpConfig::getNome,SpConfig::getValore));
	}
	
	public String getParametroDb ( String nomeParametro) {
		return parametriDb.get(nomeParametro);
	}
	

	public Deploy getDeploy() {
		return deploy;
	}
	
	public BusinessApi getBusinessApi() {
		return businessApi;
	}

	public void setBusinessApi(BusinessApi businessApi) {
		this.businessApi = businessApi;
	}
	


	public Map<String, String> getLogoutInfo() {
		return logoutInfo;
	}

	public void setLogoutInfo(Map<String, String> logoutInfo) {
		this.logoutInfo = logoutInfo;
	}





	public static class Deploy {
		private String timestamp;
		private String utente;
		private String profile;
		private boolean devMode = false;
		private String redirectTo;
		private String pathToFrontEnd;
		private String host;
		private String port;
		private String indirizzoServizio;
		private String aliasServizio;
		private String docsBaseUrl;
		private String docsLang;
		private String endpointControlloBatch;
		
		public String getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(String timestamp) {
			this.timestamp = timestamp;
		}
		public String getUtente() {
			return utente;
		}
		public void setUtente(String utente) {
			this.utente = utente;
		}
		public String getProfile() {
			return profile;
		}
		public void setProfile(String profile) {
			this.profile = profile;
		}
		public boolean isDevMode() {
			return devMode;
		}
		public void setDevMode(boolean devMode) {
			this.devMode = devMode;
		}
		public String getRedirectTo() {
			return redirectTo;
		}
		public void setRedirectTo(String redirectTo) {
			this.redirectTo = redirectTo;
		}
		public String getPathToFrontEnd() {
			return pathToFrontEnd;
		}
		public void setPathToFrontEnd(String pathToFrontEnd) {
			this.pathToFrontEnd = pathToFrontEnd;
		}
		public String getHost() {
			return host;
		}
		public void setHost(String host) {
			this.host = host;
		}
		public String getPort() {
			return port;
		}
		public void setPort(String port) {
			this.port = port;
		}
		public String getIndirizzoServizio() {
			return indirizzoServizio;
		}
		public void setIndirizzoServizio(String indirizzoServizio) {
			this.indirizzoServizio = indirizzoServizio;
		}
		public String getAliasServizio() {
			return aliasServizio;
		}
		public void setAliasServizio(String aliasServizio) {
			this.aliasServizio = aliasServizio;
		}
		public String getDocsBaseUrl() {
			return docsBaseUrl;
		}
		public void setDocsBaseUrl(String docsBaseUrl) {
			this.docsBaseUrl = docsBaseUrl;
		}
		public String getDocsLang() {
			return docsLang;
		}
		public void setDocsLang(String docsLang) {
			this.docsLang = docsLang;
		}
		public String getEndpointControlloBatch() {
			return endpointControlloBatch;
		}
		public void setEndpointControlloBatch(String endpointControlloBatch) {
			this.endpointControlloBatch = endpointControlloBatch;
		}
		
		
	}
	
	public static class BusinessApi {
		private String scopeValue;
		private String audience;
		private String privateKey;
		private String host;
		private String basePath;
		private String amazonClientId;
		private String amazonSecretKey;
		private String amazonReportBucket;
		
		public String getScopeValue() {
			return scopeValue;
		}
		public void setScopeValue(String scopeValue) {
			this.scopeValue = scopeValue;
		}
		public String getAudience() {
			return audience;
		}
		public void setAudience(String audience) {
			this.audience = audience;
		}
		public String getPrivateKey() {
			return privateKey;
		}
		public void setPrivateKey(String privateKey) {
			this.privateKey = privateKey;
		}
		public String getHost() {
			return host;
		}
		public void setHost(String host) {
			this.host = host;
		}
		public String getBasePath() {
			return basePath;
		}
		public void setBasePath(String basePath) {
			this.basePath = basePath;
		}
		public String getAmazonClientId() {
			return amazonClientId;
		}
		public void setAmazonClientId(String amazonClientId) {
			this.amazonClientId = amazonClientId;
		}
		public String getAmazonSecretKey() {
			return amazonSecretKey;
		}
		public void setAmazonSecretKey(String amazonSecretKey) {
			this.amazonSecretKey = amazonSecretKey;
		}
		public String getAmazonReportBucket() {
			return amazonReportBucket;
		}
		public void setAmazonReportBucket(String amazonReportBucket) {
			this.amazonReportBucket = amazonReportBucket;
		}
	}
}
