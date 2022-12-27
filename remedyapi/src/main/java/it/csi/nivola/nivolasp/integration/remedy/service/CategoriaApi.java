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
package it.csi.nivola.nivolasp.integration.remedy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

import it.csi.nivola.nivolasp.integration.remedy.invoker.ApiClient;
import it.csi.nivola.nivolasp.integration.remedy.model.CategoriaApplicativa;
import it.csi.nivola.nivolasp.integration.remedy.model.CategoriaOperativaTicket;


@Component("it.csi.nivola.nivolasp.integration.remedy.service.CategoriaApi")
public class CategoriaApi {
    private ApiClient apiClient;

    public CategoriaApi() {
        this(new ApiClient());
    }

    @Autowired
    public CategoriaApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * ritorna una lista di categorie in base ai filtri specificati
     * Ritorna una lista di categorie applicative filtrate secondo i criteri richiesti
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content. Nessuna categorizzazione risponde ai criteri applicati.
     * <p><b>400</b> - Richiesta utente errata
     * <p><b>401</b> - Autorizzazione mancante o non valida
     * <p><b>500</b> - Internal server error.
     * <p><b>503</b> - Servizio API non disponibile
     * <p><b>0</b> - Unexpected error
     * @param xRequestID identificativo della request (formato *uuid v4* preferibile). Utile per il tracciamento delle richieste
     * @param xForwardedFor lista degli IP richiedenti
     * @param filter criteri disponibili eq (equals), neq (not equals), c(contains), ci(contains case insensitive), lt (less than), lte (less than or equals), gt (greater than), gte (greater than or equals), ad esempio:  * tutte le categorie aventi ente uguale a: &#x60;{   \&quot;ente\&quot;: {\&quot;eq\&quot;: \&quot;ente\&quot;} }&#x60;  * tutte le categorie aventi applicativo uguale a: &#x60;{   \&quot;applicativo\&quot;: {\&quot;eq\&quot;: \&quot;applicativo\&quot;} }&#x60;  * tutte le categorie aventi componente uguale a: &#x60;{   \&quot;componente\&quot;: {\&quot;eq\&quot;: \&quot;componente\&quot;} }&#x60;  * tutte le categorie aventi aggregazione logico omogenea uguale a: &#x60;{   \&quot;alo\&quot;: {\&quot;eq\&quot;: \&quot;alo\&quot;} }&#x60;  * tutte le categorie aventi soluzione applicativa uguale a: &#x60;{   \&quot;sa\&quot;: {\&quot;eq\&quot;: \&quot;sa\&quot;} }&#x60;    
     * @param sort esempi di criteri di ordinamento: * id crescente: &#x60;+componente&#x60; * id decrescente: &#x60;-componente&#x60; 
     * @param offset Numero di elementi da cui partire
     * @param limit Massimo numero di elementi ritornati
     * @return List&lt;CategoriaApplicativa&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<CategoriaApplicativa> getAppCategoriesList(String xRequestID, String xForwardedFor, String filter, String sort, Integer offset, Integer limit) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'xRequestID' is set
        if (xRequestID == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xRequestID' when calling getAppCategoriesList");
        }
        
        // verify the required parameter 'xForwardedFor' is set
        if (xForwardedFor == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xForwardedFor' when calling getAppCategoriesList");
        }
        
        String path = UriComponentsBuilder.fromPath("/categorie-applicative").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter", filter));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort", sort));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        
        if (xRequestID != null)
        headerParams.add("X-Request-ID", apiClient.parameterToString(xRequestID));
        if (xForwardedFor != null)
        headerParams.add("X-Forwarded-For", apiClient.parameterToString(xForwardedFor));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<List<CategoriaApplicativa>> returnType = new ParameterizedTypeReference<List<CategoriaApplicativa>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * ritorna una lista di categorie in base ai filtri specificati
     * Ritorna una lista di categorie operative filtrate secondo i criteri richiesti
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content. Nessuna categorizzazione risponde ai criteri applicati.
     * <p><b>400</b> - Richiesta utente errata
     * <p><b>401</b> - Autorizzazione mancante o non valida
     * <p><b>500</b> - Internal server error.
     * <p><b>503</b> - Servizio API non disponibile
     * <p><b>0</b> - Unexpected error
     * @param xRequestID identificativo della request (formato *uuid v4* preferibile). Utile per il tracciamento delle richieste
     * @param xForwardedFor lista degli IP richiedenti
     * @param filter criteri disponibili eq (equals), neq (not equals), c(contains), ci(contains case insensitive), lt (less than), lte (less than or equals), gt (greater than), gte (greater than or equals), ad esempio:  * tutte le categorie aventi ente uguale a: &#x60;{   \&quot;ente\&quot;: {\&quot;eq\&quot;: \&quot;ente\&quot;} }&#x60;  * tutte le categorie aventi prima gerarchia uguale a: &#x60;{   \&quot;livello1\&quot;: {\&quot;eq\&quot;: \&quot;livello1\&quot;} }&#x60;  * tutte le categorie aventi prima gerarchia uguale a: &#x60;{   \&quot;livello2\&quot;: {\&quot;eq\&quot;: \&quot;livello2\&quot;} }&#x60;  * tutte le categorie aventi prima gerarchia uguale a: &#x60;{   \&quot;livello3\&quot;: {\&quot;eq\&quot;: \&quot;livello3\&quot;} }&#x60;    
     * @param sort esempi di criteri di ordinamento: * id crescente: &#x60;+livello1&#x60; * id decrescente: &#x60;-livello1&#x60; 
     * @param offset Numero di elementi da cui partire
     * @param limit Massimo numero di elementi ritornati
     * @return List&lt;CategoriaOperativaTicket&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<CategoriaOperativaTicket> getOpCategoriesList(String xRequestID, String xForwardedFor, String filter, String sort, Integer offset, Integer limit) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'xRequestID' is set
        if (xRequestID == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xRequestID' when calling getOpCategoriesList");
        }
        
        // verify the required parameter 'xForwardedFor' is set
        if (xForwardedFor == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xForwardedFor' when calling getOpCategoriesList");
        }
        
        String path = UriComponentsBuilder.fromPath("/categorie-operative").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter", filter));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort", sort));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        
        if (xRequestID != null)
        headerParams.add("X-Request-ID", apiClient.parameterToString(xRequestID));
        if (xForwardedFor != null)
        headerParams.add("X-Forwarded-For", apiClient.parameterToString(xForwardedFor));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<List<CategoriaOperativaTicket>> returnType = new ParameterizedTypeReference<List<CategoriaOperativaTicket>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
