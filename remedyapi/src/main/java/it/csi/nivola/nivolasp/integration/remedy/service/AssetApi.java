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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import it.csi.nivola.nivolasp.integration.remedy.model.ConfigurationItem;


@Component("it.csi.nivola.nivolasp.integration.remedy.service.AssetApi")
public class AssetApi {
    private ApiClient apiClient;

    public AssetApi() {
        this(new ApiClient());
    }

    @Autowired
    public AssetApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * ritorna gli asset associati ad un utente del servizio di ticketing
     * Per richiedere gli asset associati all&#39;utente si possono specificare dei filtri sull\\&#39;ente o sul nome dell\\&#39;asset
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content. Nessun asset associato all&#39;utente
     * <p><b>400</b> - Richiesta utente errata
     * <p><b>401</b> - Autorizzazione mancante o non valida
     * <p><b>404</b> - Elemento richiesto errato o risorsa inesistente
     * <p><b>500</b> - Internal server error.
     * <p><b>503</b> - Servizio API non disponibile
     * <p><b>0</b> - Unexpected error
     * @param xRequestID identificativo della request (formato *uuid v4* preferibile). Utile per il tracciamento delle richieste
     * @param xForwardedFor lista degli IP richiedenti
     * @param personId The personId parameter
     * @param filter criteri disponibili eq (equals), neq (not equals), c(contains), ci(contains case insensitive), lt (less than), lte (less than or equals), gt (greater than), gte (greater than or equals), ad esempio:  * tutti gli utenti aventi nome uguale a: &#x60;{   \&quot;companyName\&quot;: {\&quot;eq\&quot;: \&quot;nome\&quot;} }&#x60;    
     * @param sort esempi di criteri di ordinamento: * id crescente: &#x60;+assetId&#x60; * id decrescente: &#x60;-assetId&#x60; 
     * @param offset Numero di elementi da cui partire
     * @param limit Massimo numero di elementi ritornati
     * @return List&lt;ConfigurationItem&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<ConfigurationItem> getConfigItemListByUserId(String xRequestID, String xForwardedFor, String personId, String filter, String sort, Integer offset, Integer limit) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'xRequestID' is set
        if (xRequestID == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xRequestID' when calling getConfigItemListByUserId");
        }
        
        // verify the required parameter 'xForwardedFor' is set
        if (xForwardedFor == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xForwardedFor' when calling getConfigItemListByUserId");
        }
        
        // verify the required parameter 'personId' is set
        if (personId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'personId' when calling getConfigItemListByUserId");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("personId", personId);
        String path = UriComponentsBuilder.fromPath("/users/{personId}/configuration-items").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<List<ConfigurationItem>> returnType = new ParameterizedTypeReference<List<ConfigurationItem>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
