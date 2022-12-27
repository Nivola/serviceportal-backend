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
/*
 * troubleticketing
 * Le API consentono interoperabilit� con il sistema di Trouble Ticketing (creazione ticket, anagrafiche clienti ed info lavoro) ed interrogazione informazioni (stato ticket, elenco ticket il cui stato � stato variato, elenco company cliente, elenco categorizzazioni operative, catalogo applicativo, configuration items, anagrafiche clienti).  
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package it.csi.nivola.nivolasp.integration.remedy.service;

import java.util.List;
import java.util.UUID;

import org.junit.Ignore;
import org.junit.Test;

import it.csi.nivola.nivolasp.integration.remedy.model.CategoriaApplicativa;
import it.csi.nivola.nivolasp.integration.remedy.model.CategoriaOperativaTicket;

/**
 * API tests for CategoriaApi
 */
@Ignore
public class CategoriaApiTest  extends AbstractTest{

    private final CategoriaApi api = new CategoriaApi();

    
    /**
     * ritorna una lista di categorie in base ai filtri specificati
     *
     * Ritorna una lista di categorie applicative filtrate secondo i criteri richiesti
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getAppCategoriesListTest() {
        String xRequestID = UUID.randomUUID().toString();
        String xForwardedFor = "127.0.0.1";
        String filter = null;
        String sort = null;
        Integer offset = null;
        Integer limit = null;
        List<CategoriaApplicativa> response = api.getAppCategoriesList(xRequestID, xForwardedFor, filter, sort, offset, limit);
        log.debug("\n"+response);
    }
    
    /**
     * ritorna una lista di categorie in base ai filtri specificati
     *
     * Ritorna una lista di categorie operative filtrate secondo i criteri richiesti
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getOpCategoriesListTest() {
        String xRequestID = UUID.randomUUID().toString();
        String xForwardedFor = "127.0.0.1";
        String filter = null;
        String sort = null;
        Integer offset = null;
        Integer limit = null;
        List<CategoriaOperativaTicket> response = api.getOpCategoriesList(xRequestID, xForwardedFor, filter, sort, offset, limit);

        log.debug("\n"+response);
    }
    
}
