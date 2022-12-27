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
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import it.csi.nivola.nivolasp.config.ApplicationProperties;
import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.integration.rest.api.service.AuthorityApi;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetAccountResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetDivisionResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetOrganizationResponseSchema;
import it.csi.nivola.nivolasp.security.SecurityUtils;
import it.csi.nivola.nivolasp.service.AmazonS3ClientService;
import it.csi.nivola.nivolasp.service.DocumentiService;
import it.csi.nivola.nivolasp.service.dto.AmazonS3FileInfo;
import it.csi.nivola.nivolasp.service.dto.CodiceEtichettaDescrizioneDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoEnum;
import it.csi.nivola.nivolasp.service.dto.ReportRendicontoResponse;

@RestController
@RequestMapping("/api")
public class DocumentiResource {

	@Autowired
	DocumentiService documentiService;

	@Autowired
	AuthorityApi authorityApi;

	@Autowired
	AmazonS3ClientService amazonS3ClientService;
	
	@Autowired
	ApplicationProperties proprieta;

	/**
	 * Elenco dei tipi di documento disponibili
	 * @return
	 */
	@GetMapping("/documento/tipi")
	public ResponseEntity<List<CodiceEtichettaDescrizioneDTO>> elencoTipiDocumentoValidi() {
		return new ResponseEntity<List<CodiceEtichettaDescrizioneDTO>>(documentiService.elencoTipiDocumento(), HttpStatus.OK);
	}

	/**
	 * upload di un documento
	 * @param accountId
	 * @param tipo
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@PostMapping("/documento/{accountId}/upload/{tipo}")
	public ResponseEntity<EsitoDTO> uploadDocumentoAccount (@PathVariable String accountId, @PathVariable String tipo, @RequestParam("file") MultipartFile file) throws IOException {
		
		GetAccountResponseSchema rispostaAccount = authorityApi.v10NwsAccountsOidGet(accountId);
		GetDivisionResponseSchema rispostaDivisione = authorityApi.v10NwsDivisionsOidGet(rispostaAccount.getAccount().getDivisionId());
		GetOrganizationResponseSchema rispostaOrganizzazione = authorityApi.v10NwsOrganizationsOidGet(rispostaDivisione.getDivision().getOrganizationId());
		
		StringBuilder fileName = new StringBuilder(rispostaOrganizzazione.getOrganization().getName())
				.append("/")
				.append(rispostaDivisione.getDivision().getName())
				.append("/")
				.append(rispostaAccount.getAccount().getName())
				.append("/DOCUMENTI/")
				.append(tipo)
				.append("/")
				.append(file.getOriginalFilename());

		amazonS3ClientService.uploadObject(proprieta.getBusinessApi().getAmazonReportBucket(), fileName.toString(), file.getInputStream(), file.getSize());
		
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "File inviato correttamente"),HttpStatus.OK);
    	
	}
	
	/**
	 * Elenco dei documenti presenti per un account
	 * @param accountId
	 * @return
	 * @throws BusinessException
	 */
	@GetMapping("/documento")
	public ResponseEntity<List<AmazonS3FileInfo>> elencoDocumentiAccount (String accountId) throws BusinessException {

		accountId = SecurityUtils.getAccountIdCorrente(accountId);
		
		GetAccountResponseSchema rispostaAccount = authorityApi.v10NwsAccountsOidGet(accountId);
		GetDivisionResponseSchema rispostaDivisione = authorityApi.v10NwsDivisionsOidGet(rispostaAccount.getAccount().getDivisionId());
		GetOrganizationResponseSchema rispostaOrganizzazione = authorityApi.v10NwsOrganizationsOidGet(rispostaDivisione.getDivision().getOrganizationId());
		
		StringBuilder fileName = new StringBuilder(rispostaOrganizzazione.getOrganization().getName())
				.append("/")
				.append(rispostaDivisione.getDivision().getName())
				.append("/")
				.append(rispostaAccount.getAccount().getName())
				.append("/DOCUMENTI/");
		
		return new ResponseEntity<List<AmazonS3FileInfo>>(amazonS3ClientService.listFiles(proprieta.getBusinessApi().getAmazonReportBucket(), fileName.toString()), HttpStatus.OK);
	}
	
	/**
	 * Download di un documento
	 * @param accountId
	 * @param nomeFile
	 * @return
	 * @throws BusinessException
	 * @throws IOException
	 */
	@GetMapping("/documento/download")
	public ResponseEntity<ReportRendicontoResponse> scaricaDocumento(String accountId, String nomeFile, String tipo) throws BusinessException, IOException {
		accountId = SecurityUtils.getAccountIdCorrente(accountId);
		
		GetAccountResponseSchema rispostaAccount = authorityApi.v10NwsAccountsOidGet(accountId);
		GetDivisionResponseSchema rispostaDivisione = authorityApi.v10NwsDivisionsOidGet(rispostaAccount.getAccount().getDivisionId());
		GetOrganizationResponseSchema rispostaOrganizzazione = authorityApi.v10NwsOrganizationsOidGet(rispostaDivisione.getDivision().getOrganizationId());
		
		StringBuilder fileName = new StringBuilder(rispostaOrganizzazione.getOrganization().getName())
				.append("/")
				.append(rispostaDivisione.getDivision().getName())
				.append("/")
				.append(rispostaAccount.getAccount().getName())
				.append("/DOCUMENTI/")
				.append(tipo)
				.append("/")
				.append(nomeFile);
		
		byte[] fileS3 = amazonS3ClientService.getFile(proprieta.getBusinessApi().getAmazonReportBucket(), fileName.toString());
		
		ReportRendicontoResponse response = new ReportRendicontoResponse();
		response.setNomeFile(nomeFile);
		response.setReport(fileS3);
		return new ResponseEntity<ReportRendicontoResponse>(response,HttpStatus.OK);
	}
	
	/**
	 * Cancellazione di un documento
	 * @param nomeFile
	 * @return
	 * @throws IOException
	 * @throws BusinessException
	 */
	@PutMapping("/documento")
	public ResponseEntity<String> eliminaDocumento (@RequestBody AmazonS3FileInfo file) throws IOException, BusinessException {
		
		String accountId = SecurityUtils.getAccountIdCorrente(file.getIdAccount());
		
		GetAccountResponseSchema rispostaAccount = authorityApi.v10NwsAccountsOidGet(accountId);
		GetDivisionResponseSchema rispostaDivisione = authorityApi.v10NwsDivisionsOidGet(rispostaAccount.getAccount().getDivisionId());
		GetOrganizationResponseSchema rispostaOrganizzazione = authorityApi.v10NwsOrganizationsOidGet(rispostaDivisione.getDivision().getOrganizationId());
		

		StringBuilder fileName = new StringBuilder(rispostaOrganizzazione.getOrganization().getName())
				.append("/")
				.append(rispostaDivisione.getDivision().getName())
				.append("/")
				.append(rispostaAccount.getAccount().getName())
				.append("/DOCUMENTI/")
				.append(file.getTipoDocumento())
				.append("/")
				.append(file.getNomeFile());
		
		amazonS3ClientService.deleteFile(proprieta.getBusinessApi().getAmazonReportBucket(), fileName.toString());
		return new ResponseEntity<String>("",HttpStatus.OK);
	}
}
