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
package it.csi.nivola.nivolasp.web.rest.errors;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.ConcurrencyFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.integration.remedy.portal.dto.ErroreRemedy;
import it.csi.nivola.nivolasp.integration.rest.model.auth.Error;
import it.csi.nivola.nivolasp.service.dto.EsitoDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoEnum;

/**
 * Gestione centralizzata degli errori
 */
@ControllerAdvice
public class ExceptionTranslator {
	
	private static final Logger log = LoggerFactory.getLogger("it.csi.nivola.error");
	
	ObjectMapper mapper = new ObjectMapper();
	
    @Autowired
    public MessageSource messageSource;

	
    @ExceptionHandler(ConcurrencyFailureException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorVM processConcurrencyError(ConcurrencyFailureException ex) {
    	log.error("CONCURRENCY FAILURE EXCEPTION");
        return new ErrorVM(ErrorConstants.ERR_CONCURRENCY_FAILURE);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorVM processValidationError(MethodArgumentNotValidException ex) {
    	log.error("PROCESS VALIDATION ERROR", ex);
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        ErrorVM dto = new ErrorVM(ErrorConstants.ERR_VALIDATION);
        for (FieldError fieldError : fieldErrors) {
            dto.add(fieldError.getObjectName(), fieldError.getField(), fieldError.getCode());
        }
        return dto;
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ErrorVM processAccessDeniedException(AccessDeniedException e) {
    	log.error("PROCESS ACCESS DENIED EXCEPTION", e);
        return new ErrorVM(ErrorConstants.ERR_ACCESS_DENIED, e.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ErrorVM processMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
    	log.error("PROCESS METHOD NOT SUPPORTED EXCEPTION", exception);
        return new ErrorVM(ErrorConstants.ERR_METHOD_NOT_SUPPORTED, exception.getMessage());
    }
    
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<EsitoDTO> erroreLatoCMP(WebRequest webRequest, HttpClientErrorException e) {
//    	log.error("Si è verificato un errore", e);
    	MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
    	headers.add("Content-Type", MediaType.TEXT_PLAIN.toString());
    	
    	EsitoDTO esito = new EsitoDTO(EsitoEnum.KO, "", e.getResponseBodyAsString());
    	try {
    			Error obj = mapper.readValue(e.getResponseBodyAsString(), it.csi.nivola.nivolasp.integration.rest.model.auth.Error.class);
				esito = new EsitoDTO(EsitoEnum.KO, obj.getCode()+"", obj.getMessage());
    			
		} catch (IOException ine) {
			esito = provaLetturaErroreRemedyEFallback(e, esito);
		}
		return new ResponseEntity<EsitoDTO>(esito, headers, e.getStatusCode());
    }
    
    /**
     * Remedy per alcuni errori di validazione dati input decide di rispondere con errore 500 anziché Bad Request.
     * @param webRequest
     * @param e
     * @return
     */
    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<EsitoDTO> erroreInvocazioneServiziEsterni(WebRequest webRequest, HttpServerErrorException e) {
//    	log.error("Si è verificato un errore", e);
    	MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
    	headers.add("Content-Type", MediaType.TEXT_PLAIN.toString());
    	
    	EsitoDTO esito = new EsitoDTO(EsitoEnum.KO, "", e.getResponseBodyAsString());
    	try {
    		Error obj = mapper.readValue(e.getResponseBodyAsString(), it.csi.nivola.nivolasp.integration.rest.model.auth.Error.class);
    		esito = new EsitoDTO(EsitoEnum.KO, obj.getCode()+"", obj.getMessage());
    		
    	} catch (IOException ine) {
    		esito = provaLetturaErroreRemedyEFallback(e, esito);
    	}
    	return new ResponseEntity<EsitoDTO>(esito, headers, e.getStatusCode());
    }
    
    private EsitoDTO provaLetturaErroreRemedyEFallback(HttpStatusCodeException e, EsitoDTO esito) {
		try {
			ErroreRemedy obj = mapper.readValue(e.getResponseBodyAsString(), ErroreRemedy.class);
			esito = new EsitoDTO(EsitoEnum.KO, obj.getStatus(), obj.getTitle());
		}
		catch (IOException e1) {
			esito = new EsitoDTO(EsitoEnum.KO, "", e.getResponseBodyAsString());
		}
		return esito;
	}

	
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<EsitoDTO> erroreDiValidazione(WebRequest webRequest, BusinessException e) {
    	HttpStatus stato = HttpStatus.BAD_REQUEST;
    	if (e.getStatusCode() != null)
    		stato = HttpStatus.valueOf(e.getStatusCode());
    	ResponseEntity<EsitoDTO> response = new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.KO, e.getCodiceErrore(), messageSource.getMessage(e.getCodiceErrore(), new String[] {e.getMessage()}, e.getMessage(), null)), stato);
    	return response;
    }
    
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<EsitoDTO> erroreDiSistemaNonGestito(WebRequest webRequest, Exception e) {
    	StringBuilder msg = new StringBuilder("PER UTENTE ");
    	msg.append(webRequest.getUserPrincipal() != null ? webRequest.getUserPrincipal().getName() : "SCONOSCIUTO");
    	log.error("ERRORE NON GESTITO " + msg, e);
    	ResponseEntity<EsitoDTO> response = new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.KO, "XXXX", e.getMessage()), HttpStatus.BAD_REQUEST);
    	return response;
    }
}
