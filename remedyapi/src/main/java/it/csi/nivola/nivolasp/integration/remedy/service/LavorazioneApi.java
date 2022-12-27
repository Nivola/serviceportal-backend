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

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
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
import it.csi.nivola.nivolasp.integration.remedy.model.InfoNotaAttachments;
import it.csi.nivola.nivolasp.integration.remedy.model.InfoNotaWLog;
import it.csi.nivola.nivolasp.integration.remedy.model.LavorazioneTicket;
import it.csi.nivola.nivolasp.integration.remedy.model.TicketExpo;
import it.csi.nivola.nivolasp.integration.remedy.model.TicketSnapshot;


@Component("it.csi.nivola.nivolasp.integration.remedy.service.LavorazioneApi")
public class LavorazioneApi {
    private ApiClient apiClient;

    public LavorazioneApi() {
        this(new ApiClient());
    }

    @Autowired
    public LavorazioneApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * aggiorna le informazioni allegate alla service request
     * Aggioramento delle informazioni richieste al richiedente per la lavorazione della service request
     * <p><b>200</b> - OK
     * <p><b>400</b> - Richiesta utente errata
     * <p><b>401</b> - Autorizzazione mancante o non valida
     * <p><b>415</b> - Non � stato specificato l&#39;header Content-Type corretto
     * <p><b>500</b> - Internal server error.
     * <p><b>502</b> - Comunicazione con altro servizio fallita
     * <p><b>503</b> - Servizio API non disponibile
     * <p><b>0</b> - Unexpected error
     * @param xRequestID identificativo della request (formato *uuid v4* preferibile). Utile per il tracciamento delle richieste
     * @param xForwardedFor lista degli IP richiedenti
     * @param ticketId The ticketId parameter
     * @param riepilogo informazioni sul worklog utente
     * @param tipologia tipologia di informazioni tra quelle disponibili
     * @param note dettagli sul worklog dell&#39;utente
     * @param nomeAllegato1 chiave custom del primo allegato (es. il nome del file)
     * @param customKey file allegato, la chiave dev&#39;essere il valore indicato al parametro *nomeAllegato1*
     * @return InfoNotaWLog
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InfoNotaWLog addWorkinfoTicket(String xRequestID, String xForwardedFor, String ticketId, String riepilogo, String tipologia, String note, String nomeAllegato1, File customKey) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'xRequestID' is set
        if (xRequestID == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xRequestID' when calling addWorkinfoTicket");
        }
        
        // verify the required parameter 'xForwardedFor' is set
        if (xForwardedFor == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xForwardedFor' when calling addWorkinfoTicket");
        }
        
        // verify the required parameter 'ticketId' is set
        if (ticketId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'ticketId' when calling addWorkinfoTicket");
        }
        
        // verify the required parameter 'riepilogo' is set
        if (riepilogo == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'riepilogo' when calling addWorkinfoTicket");
        }
        
        // verify the required parameter 'tipologia' is set
        if (tipologia == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'tipologia' when calling addWorkinfoTicket");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("ticketId", ticketId);
        String path = UriComponentsBuilder.fromPath("/tickets/{ticketId}/stato/info-dettagli").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        if (xRequestID != null)
        headerParams.add("X-Request-ID", apiClient.parameterToString(xRequestID));
        if (xForwardedFor != null)
        headerParams.add("X-Forwarded-For", apiClient.parameterToString(xForwardedFor));
        
        if (riepilogo != null)
            formParams.add("riepilogo", riepilogo);
        if (tipologia != null)
            formParams.add("tipologia", tipologia);
        if (note != null)
            formParams.add("note", note);
        if (nomeAllegato1 != null)
            formParams.add("nomeAllegato1", nomeAllegato1);
        if (customKey != null)
            formParams.add("custom-key", new FileSystemResource(customKey));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "multipart/form-data"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<InfoNotaWLog> returnType = new ParameterizedTypeReference<InfoNotaWLog>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * restituisce un allegato associato alla info nota di una service request
     * Consultazione delle informazioni allegate dal richiedente per la lavorazione della service request
     * <p><b>200</b> - OK
     * <p><b>400</b> - Richiesta utente errata
     * <p><b>401</b> - Autorizzazione mancante o non valida
     * <p><b>404</b> - Elemento richiesto errato o risorsa inesistente
     * <p><b>500</b> - Internal server error.
     * <p><b>503</b> - Servizio API non disponibile
     * <p><b>0</b> - Unexpected error
     * @param xRequestID identificativo della request (formato *uuid v4* preferibile). Utile per il tracciamento delle richieste
     * @param xForwardedFor lista degli IP richiedenti
     * @param ticketId The ticketId parameter
     * @param logId id dell\\&#39;info nota in formato &#x60;WLGxxxxxxxxxxxx&#x60;
     * @param attachId indice dell\\&#39;allegato da 1 a 3
     * @return File
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public File getAttachment(String xRequestID, String xForwardedFor, String ticketId, String logId, Integer attachId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'xRequestID' is set
        if (xRequestID == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xRequestID' when calling getAttachment");
        }
        
        // verify the required parameter 'xForwardedFor' is set
        if (xForwardedFor == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xForwardedFor' when calling getAttachment");
        }
        
        // verify the required parameter 'ticketId' is set
        if (ticketId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'ticketId' when calling getAttachment");
        }
        
        // verify the required parameter 'logId' is set
        if (logId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'logId' when calling getAttachment");
        }
        
        // verify the required parameter 'attachId' is set
        if (attachId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'attachId' when calling getAttachment");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("ticketId", ticketId);
        uriVariables.put("logId", logId);
        uriVariables.put("attachId", attachId);
        String path = UriComponentsBuilder.fromPath("/tickets/{ticketId}/stato/info-dettagli/{logId}/allegati/{attachId}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        if (xRequestID != null)
        headerParams.add("X-Request-ID", apiClient.parameterToString(xRequestID));
        if (xForwardedFor != null)
        headerParams.add("X-Forwarded-For", apiClient.parameterToString(xForwardedFor));

        final String[] accepts = { 
            "application/octet-stream", "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<File> returnType = new ParameterizedTypeReference<File>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * ritorna gli ultimi ticket registrati a sistema con categorizzazione &#39;1L -&#39; da qualsiasi fonte
     * ritorna i ticket registrati negli ultimi 10 gg a sistema con categorizzazione &#39;1L -&#39; da qualsiasi fonte
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content.
     * <p><b>400</b> - Richiesta utente errata
     * <p><b>401</b> - Autorizzazione mancante o non valida
     * <p><b>500</b> - Internal server error.
     * <p><b>503</b> - Servizio API non disponibile
     * <p><b>0</b> - Unexpected error
     * @param xRequestID identificativo della request (formato *uuid v4* preferibile). Utile per il tracciamento delle richieste
     * @param xForwardedFor lista degli IP richiedenti
     * @param filter criteri disponibili eq (equals), neq (not equals), c(contains), ci(contains case insensitive), lt (less than), lte (less than or equals), gt (greater than), gte (greater than or equals), ad esempio:     * tutti gli ultimi ticket registrati aventi data di inserimento maggiore di:&#x60;{   \&quot;submitDate\&quot;: {\&quot;gt\&quot;: \&quot;2020-12-03T11:56:18Z\&quot;} }&#x60;      * tutti gli ultimi ticket registrati aventi data di inserimento minore di:&#x60;{   \&quot;submitDate\&quot;: {\&quot;lt\&quot;:\&quot;2020-12-03T14:25:18Z\&quot;} }&#x60;      * tutti gli ultimi ticket registrati aventi data di inserimento compresa fra:&#x60;{   \&quot;submitDate\&quot;: {\&quot;gte\&quot;:\&quot;2020-12-03T11:56:18Z\&quot;, \&quot;lte\&quot;:\&quot;2020-12-03T14:25:18Z\&quot;} }&#x60;    
     * @param sort esempi di criteri di ordinamento: * id crescente: &#x60;+ticketId&#x60; * id decrescente: &#x60;-ticketId&#x60; 
     * @param offset Numero di elementi da cui partire
     * @param limit Massimo numero di elementi ritornati
     * @return List&lt;TicketExpo&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<TicketExpo> getLastRegistered(String xRequestID, String xForwardedFor, String filter, String sort, Integer offset, Integer limit) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'xRequestID' is set
        if (xRequestID == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xRequestID' when calling getLastRegistered");
        }
        
        // verify the required parameter 'xForwardedFor' is set
        if (xForwardedFor == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xForwardedFor' when calling getLastRegistered");
        }
        
        String path = UriComponentsBuilder.fromPath("/tickets/esposizione").build().toUriString();
        
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

        ParameterizedTypeReference<List<TicketExpo>> returnType = new ParameterizedTypeReference<List<TicketExpo>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * ritorna gli ultimi ticket modificati
     * Ritorna le service request che siano state modificate entro x ore dall&#39;ultimo controllo
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content.
     * <p><b>400</b> - Richiesta utente errata
     * <p><b>401</b> - Autorizzazione mancante o non valida
     * <p><b>500</b> - Internal server error.
     * <p><b>503</b> - Servizio API non disponibile
     * <p><b>0</b> - Unexpected error
     * @param xRequestID identificativo della request (formato *uuid v4* preferibile). Utile per il tracciamento delle richieste
     * @param xForwardedFor lista degli IP richiedenti
     * @param filter criteri disponibili eq (equals), neq (not equals), c(contains), ci(contains case insensitive), lt (less than), lte (less than or equals), gt (greater than), gte (greater than or equals), ad esempio:     * tutti gli ultimi ticket aggiornati aventi data di inserimento maggiore o uguale a:&#x60;{   \&quot;submitDate\&quot;: {\&quot;gte\&quot;:\&quot;2020-12-03T11:56:18Z\&quot;} }&#x60;      * tutti gli ultimi ticket aggiornati aventi data di inserimento minore o uguale a:&#x60;{   \&quot;submitDate\&quot;: {\&quot;lte\&quot;:\&quot;2020-12-03T14:25:18Z\&quot;} }&#x60;      * tutti gli ultimi ticket aggiornati aventi data di inserimento compresa fra:&#x60;{   \&quot;submitDate\&quot;: {\&quot;gte\&quot;:\&quot;2020-12-03T11:56:18Z\&quot;, \&quot;lte\&quot;:\&quot;2020-12-03T14:25:18Z\&quot;} }&#x60; 
     * @param sort esempi di criteri di ordinamento: * id crescente: &#x60;+ticketId&#x60; * id decrescente: &#x60;-ticketId&#x60; 
     * @param offset Numero di elementi da cui partire
     * @param limit Massimo numero di elementi ritornati
     * @return List&lt;TicketSnapshot&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<TicketSnapshot> getLastUpdated(String xRequestID, String xForwardedFor, String filter, String sort, Integer offset, Integer limit) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'xRequestID' is set
        if (xRequestID == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xRequestID' when calling getLastUpdated");
        }
        
        // verify the required parameter 'xForwardedFor' is set
        if (xForwardedFor == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xForwardedFor' when calling getLastUpdated");
        }
        
        String path = UriComponentsBuilder.fromPath("/tickets/monitoraggio").build().toUriString();
        
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

        ParameterizedTypeReference<List<TicketSnapshot>> returnType = new ParameterizedTypeReference<List<TicketSnapshot>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * ritorna le informazioni sulla lavorazione della service request
     * Ritorna le info lavorazione della service request
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content. Nessuna lavorazione associata al ticket trovata
     * <p><b>400</b> - Richiesta utente errata
     * <p><b>401</b> - Autorizzazione mancante o non valida
     * <p><b>500</b> - Internal server error.
     * <p><b>503</b> - Servizio API non disponibile
     * <p><b>0</b> - Unexpected error
     * @param xRequestID identificativo della request (formato *uuid v4* preferibile). Utile per il tracciamento delle richieste
     * @param xForwardedFor lista degli IP richiedenti
     * @param ticketId The ticketId parameter
     * @return LavorazioneTicket
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public LavorazioneTicket getWorkinfoTicket(String xRequestID, String xForwardedFor, String ticketId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'xRequestID' is set
        if (xRequestID == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xRequestID' when calling getWorkinfoTicket");
        }
        
        // verify the required parameter 'xForwardedFor' is set
        if (xForwardedFor == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xForwardedFor' when calling getWorkinfoTicket");
        }
        
        // verify the required parameter 'ticketId' is set
        if (ticketId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'ticketId' when calling getWorkinfoTicket");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("ticketId", ticketId);
        String path = UriComponentsBuilder.fromPath("/tickets/{ticketId}/stato").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
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

        ParameterizedTypeReference<LavorazioneTicket> returnType = new ParameterizedTypeReference<LavorazioneTicket>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * consulta una specifica info nota allegata alla service request
     * Consultazione delle informazioni allegate dal richiedente per la lavorazione della service request
     * <p><b>200</b> - OK
     * <p><b>400</b> - Richiesta utente errata
     * <p><b>401</b> - Autorizzazione mancante o non valida
     * <p><b>404</b> - Elemento richiesto errato o risorsa inesistente
     * <p><b>500</b> - Internal server error.
     * <p><b>503</b> - Servizio API non disponibile
     * <p><b>0</b> - Unexpected error
     * @param xRequestID identificativo della request (formato *uuid v4* preferibile). Utile per il tracciamento delle richieste
     * @param xForwardedFor lista degli IP richiedenti
     * @param ticketId The ticketId parameter
     * @param logId id dell\\&#39;info nota in formato &#x60;WLGxxxxxxxxxxxx&#x60;
     * @return InfoNotaAttachments
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InfoNotaAttachments getWorklogTicket(String xRequestID, String xForwardedFor, String ticketId, String logId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'xRequestID' is set
        if (xRequestID == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xRequestID' when calling getWorklogTicket");
        }
        
        // verify the required parameter 'xForwardedFor' is set
        if (xForwardedFor == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xForwardedFor' when calling getWorklogTicket");
        }
        
        // verify the required parameter 'ticketId' is set
        if (ticketId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'ticketId' when calling getWorklogTicket");
        }
        
        // verify the required parameter 'logId' is set
        if (logId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'logId' when calling getWorklogTicket");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("ticketId", ticketId);
        uriVariables.put("logId", logId);
        String path = UriComponentsBuilder.fromPath("/tickets/{ticketId}/stato/info-dettagli/{logId}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
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

        ParameterizedTypeReference<InfoNotaAttachments> returnType = new ParameterizedTypeReference<InfoNotaAttachments>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * consulta le informazioni allegate alla service request
     * Consultazione delle informazioni allegate dal richiedente per la lavorazione della service request
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content. Nessun informazione associata al ticket
     * <p><b>400</b> - Richiesta utente errata
     * <p><b>401</b> - Autorizzazione mancante o non valida
     * <p><b>500</b> - Internal server error.
     * <p><b>503</b> - Servizio API non disponibile
     * <p><b>0</b> - Unexpected error
     * @param xRequestID identificativo della request (formato *uuid v4* preferibile). Utile per il tracciamento delle richieste
     * @param xForwardedFor lista degli IP richiedenti
     * @param ticketId The ticketId parameter
     * @param filter criteri disponibili eq (equals), neq (not equals), c(contains), ci(contains case insensitive), lt (less than), lte (less than or equals), gt (greater than), gte (greater than or equals), ad esempio:     * tutti i worklog relativi al ticket aventi data di inserimento maggiore o uguale a:&#x60;{   \&quot;dataLog\&quot;: {\&quot;gte\&quot;:\&quot;2020-12-03T11:56:18Z\&quot;} }&#x60;      * tutti i worklog relativi al ticket aventi data di inserimento minore o uguale a:&#x60;{   \&quot;dataLog\&quot;: {\&quot;lte\&quot;:\&quot;2020-12-03T14:25:18Z\&quot;} }&#x60;      * tutti i worklog relativi al ticket aventi data di inserimento compresa fra:&#x60;{   \&quot;dataLog\&quot;: {\&quot;gte\&quot;:\&quot;2020-12-03T11:56:18Z\&quot;, \&quot;lte\&quot;:\&quot;2020-12-03T14:25:18Z\&quot;} }&#x60; 
     * @param sort esempi di criteri di ordinamento: * id crescente: &#x60;+logId&#x60; * id decrescente: &#x60;-logId&#x60; 
     * @param offset Numero di elementi da cui partire
     * @param limit Massimo numero di elementi ritornati
     * @return List&lt;InfoNotaAttachments&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<InfoNotaAttachments> getWorklogsTicket(String xRequestID, String xForwardedFor, String ticketId, String filter, String sort, Integer offset, Integer limit) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'xRequestID' is set
        if (xRequestID == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xRequestID' when calling getWorklogsTicket");
        }
        
        // verify the required parameter 'xForwardedFor' is set
        if (xForwardedFor == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xForwardedFor' when calling getWorklogsTicket");
        }
        
        // verify the required parameter 'ticketId' is set
        if (ticketId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'ticketId' when calling getWorklogsTicket");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("ticketId", ticketId);
        String path = UriComponentsBuilder.fromPath("/tickets/{ticketId}/stato/info-dettagli").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<List<InfoNotaAttachments>> returnType = new ParameterizedTypeReference<List<InfoNotaAttachments>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
