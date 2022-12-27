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
package it.csi.nivola.nivolasp.web.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.security.AuthoritiesConstants;
import it.csi.nivola.nivolasp.security.SecurityUtils;
import it.csi.nivola.nivolasp.service.ExportRisorseCSVService;
import it.csi.nivola.nivolasp.service.FormAssistenzaService;
import it.csi.nivola.nivolasp.service.LoggingAccessiService;
import it.csi.nivola.nivolasp.service.dto.ExportCSV;
import it.csi.nivola.nivolasp.service.dto.LogAzioneDTO;
import it.csi.nivola.nivolasp.service.dto.ReportRendicontoResponse;

/**
 * Rest controller per la generazione dei file CSV
 */
@RestController
@RequestMapping("/api")
public class CsvResource {
	

	@Autowired
	ExportRisorseCSVService generazioneCSVService;
	
	@Autowired
	LoggingAccessiService loggingAccessiService;
	
	@Autowired
	FormAssistenzaService formAssistenzaService;
	
	/**
	 * Esporta in CSV l'elenco dei security groups di un account
	 * @param accountId
	 * @return
	 * @throws IOException
	 * @throws BusinessException
	 */
    @GetMapping("/csv/account/risorse/sg")
    public ResponseEntity<ReportRendicontoResponse> getEstrazioneSecurityGroups(@RequestParam(value="accountId", required=false) String accountId) throws IOException, BusinessException {
    	
    	ExportCSV csv = generazioneCSVService.estrazioneSecurityGroupsAccount(SecurityUtils.getAccountIdCorrente(accountId));
    	ReportRendicontoResponse risposta = new ReportRendicontoResponse();
    	risposta.setNomeFile(csv.getFilename());
    	risposta.setReport(csv.getFile().toString().getBytes());
    	return new ResponseEntity<ReportRendicontoResponse>(risposta, HttpStatus.OK);
    }
    
    /**
     * Esporta in CSV l'elenco delle VM di un account
     * @param accountId
     * @return
     * @throws IOException
     * @throws BusinessException
     */
    @GetMapping("/csv/account/risorse/vm")
    public ResponseEntity<ReportRendicontoResponse> getEstrazioneVm(@RequestParam(value="accountId", required=false) String accountId) throws IOException, BusinessException {
    	
    	ExportCSV csv = generazioneCSVService.estrazioneVmAccount(SecurityUtils.getAccountIdCorrente(accountId));
    	ReportRendicontoResponse risposta = new ReportRendicontoResponse();
    	risposta.setNomeFile(csv.getFilename());
    	risposta.setReport(csv.getFile().toString().getBytes());
    	return new ResponseEntity<ReportRendicontoResponse>(risposta, HttpStatus.OK);
    }
    
    /**
     * Esporta in csv l'elenco dei DB di un account
     * @param accountId
     * @return
     * @throws IOException
     * @throws BusinessException
     */
    @GetMapping("/csv/account/risorse/db")
    public ResponseEntity<ReportRendicontoResponse> getEstrazioneDatabase(@RequestParam(value="accountId", required=false) String accountId) throws IOException, BusinessException {
    	
    	ExportCSV csv = generazioneCSVService.estrazioneDatabaseAccount(SecurityUtils.getAccountIdCorrente(accountId));
    	ReportRendicontoResponse risposta = new ReportRendicontoResponse();
    	risposta.setNomeFile(csv.getFilename());
    	risposta.setReport(csv.getFile().toString().getBytes());
    	return new ResponseEntity<ReportRendicontoResponse>(risposta, HttpStatus.OK);
    }
    
    /**
     * Esporta in csv l'elenco delle snapshots delle vm di un account
     * @param accountId
     * @return
     * @throws IOException
     * @throws BusinessException
     */
    @GetMapping("/csv/account/risorse/snapshot")
    public ResponseEntity<ReportRendicontoResponse> getEstrazioneSnapshots(@RequestParam(value="accountId", required=false) String accountId) throws IOException, BusinessException {
    	
    	ExportCSV csv = generazioneCSVService.estrazioneSnapshot(SecurityUtils.getAccountIdCorrente(accountId));
    	ReportRendicontoResponse risposta = new ReportRendicontoResponse();
    	risposta.setNomeFile(csv.getFilename());
    	risposta.setReport(csv.getFile().toString().getBytes());
    	return new ResponseEntity<ReportRendicontoResponse>(risposta, HttpStatus.OK);
    }
    
    /**
     * Esporta in csv l'elenco dei volumi di un account
     * @param accountId
     * @return
     * @throws IOException
     * @throws BusinessException
     */
    @GetMapping("/csv/account/risorse/volumi")
    public ResponseEntity<ReportRendicontoResponse> getEstrazioneVolumi(@RequestParam(value="accountId", required=false) String accountId) throws IOException, BusinessException {
    	
    	ExportCSV csv = generazioneCSVService.estrazioneVolumiAccount(SecurityUtils.getAccountIdCorrente(accountId));
    	ReportRendicontoResponse risposta = new ReportRendicontoResponse();
    	risposta.setNomeFile(csv.getFilename());
    	risposta.setReport(csv.getFile().toString().getBytes());
    	return new ResponseEntity<ReportRendicontoResponse>(risposta, HttpStatus.OK);
    }
    
    /**
     * Esporta elenco shares di un account
     * @param accountId
     * @return
     * @throws IOException
     * @throws BusinessException
     */
    @GetMapping("/csv/account/risorse/share")
    public ResponseEntity<ReportRendicontoResponse> getEstrazioneShare(@RequestParam(value="accountId", required=false) String accountId) throws IOException, BusinessException {
    	
    	ExportCSV csv = generazioneCSVService.estrazioneStorageAccount(SecurityUtils.getAccountIdCorrente(accountId));
    	ReportRendicontoResponse risposta = new ReportRendicontoResponse();
    	risposta.setNomeFile(csv.getFilename());
    	risposta.setReport(csv.getFile().toString().getBytes());
    	return new ResponseEntity<ReportRendicontoResponse>(risposta, HttpStatus.OK);
    }
    
    @GetMapping("/csv/logazione")
    @Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.DIVISION_ADMIN,  AuthoritiesConstants.ORGANIZATION_ADMIN})
    public ResponseEntity<ReportRendicontoResponse> elencoLogAzioneAccountCsv(LogAzioneDTO filtro) {
    	
    	ExportCSV csv = loggingAccessiService.csvPerAccount(filtro);
    	ReportRendicontoResponse risposta = new ReportRendicontoResponse();
    	risposta.setNomeFile(csv.getFilename());
    	risposta.setReport(csv.getFile().toString().getBytes());
    	return new ResponseEntity<ReportRendicontoResponse>(risposta, HttpStatus.OK);
    }
    
    /**
     * Elenco dei ticket aperti o in corso ad uso esclusivo del servizio
     * @return
     * @throws BusinessException
     */
    @GetMapping("/csv/ticket/nonterminati")
    @Secured({AuthoritiesConstants.BOADMIN})
    public ResponseEntity<ReportRendicontoResponse> elencoTicketNonTerminati() throws BusinessException {
    	
    	ExportCSV csv = formAssistenzaService.elencoTicketApertiCSV();
    	ReportRendicontoResponse risposta = new ReportRendicontoResponse();
    	risposta.setNomeFile(csv.getFilename());
    	risposta.setReport(csv.getFile().toString().getBytes());
    	return new ResponseEntity<ReportRendicontoResponse>(risposta, HttpStatus.OK);
    }

}
