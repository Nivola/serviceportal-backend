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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class RestLoggingInterceptor implements ClientHttpRequestInterceptor {
	
	private final Logger log = LoggerFactory.getLogger(RestLoggingInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        traceRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        traceResponse(response);
        return response;
    }

    private void traceRequest(HttpRequest request, byte[] body) throws IOException {
        log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>TOKEN API MANAGER request begin<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        log.debug("URI         : " + request.getURI());
        log.debug("Method      : " + request.getMethod());
        log.debug("Headers     : " + request.getHeaders() );
        log.debug("Request body: " + new String(body, "UTF-8"));
        log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>TOKEN API MANAGER request end<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }

    private void traceResponse(ClientHttpResponse response) throws IOException {
    	try {
    	StringBuilder inputStringBuilder = new StringBuilder();
    	log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>TOKEN API MANAGER response begin<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        log.debug("Status code  : " + response.getStatusCode());
        log.debug("Status text  : " + response.getStatusText());
        
    	if (response.getBody() != null) {
	       
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getBody(), "UTF-8"));
	        String line = bufferedReader.readLine();
	        while (line != null) {
	            inputStringBuilder.append(line);
	            inputStringBuilder.append('\n');
	            line = bufferedReader.readLine();
	        }
    	}
    	log.debug("Headers      : " + response.getHeaders());
        log.debug("Response body: " + inputStringBuilder.toString());
        log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>TOKEN API MANAGER response end<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    	} catch (Exception e) {
    		log.error("impossibile stampare la risposta ", e);
    	}
    	
    }

}
