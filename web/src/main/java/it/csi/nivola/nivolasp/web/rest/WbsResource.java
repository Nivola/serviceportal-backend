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

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.csi.nivola.nivolasp.aop.logging.AzioneDispositiva;
import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.security.SecurityUtils;
import it.csi.nivola.nivolasp.service.dto.AssociazioneWbsAccountDto;
import it.csi.nivola.nivolasp.service.dto.EsitoDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoEnum;
import it.csi.nivola.nivolasp.service.dto.WbsDTO;
import it.csi.nivola.nivolasp.service.impl.WbsService;

/**
 * Rest controller per la gestione dei Volumi
 */
@RestController
@RequestMapping("/api")
public class WbsResource {
	@Autowired
	WbsService wbsService;

	private final Logger log = LoggerFactory.getLogger(WbsResource.class);

	/**
	 * Elenco di tutte le WBS censite (anagrafica)
	 * @param accountId
	 * @return
	 * @throws BusinessException
	 */
	@GetMapping("/wbs")
	public ResponseEntity<List<WbsDTO>> elencoWbsCensite(String accountId) throws BusinessException {
		return new ResponseEntity<>(wbsService.elencoWbsCensite(), HttpStatus.OK);
	}
	
	/**
	 * Elenco di tutte le WBS associate ad un dato account
	 * @param accountId
	 * @return
	 * @throws BusinessException
	 */
	@GetMapping("/wbs/account")
	public ResponseEntity<List<AssociazioneWbsAccountDto>> elencoWbsAccount(String accountId) throws BusinessException {
		log.debug(accountId);
		accountId = SecurityUtils.getAccountIdCorrente(accountId);
		return new ResponseEntity<List<AssociazioneWbsAccountDto>>(wbsService.elencoWbsAccount(accountId), HttpStatus.OK);
	}
	
	/**
	 * Elimina un'associazione WBS - account
	 * @param accountId
	 * @param associazioneId
	 * @return
	 * @throws BusinessException
	 */
	@DeleteMapping("/wbs/account/{accountId}/{associazioneId}")
	@AzioneDispositiva
	public ResponseEntity<EsitoDTO> eliminaAssociazioneAccount(@PathVariable String accountId, @PathVariable String associazioneId) throws BusinessException {
		accountId = SecurityUtils.getAccountIdCorrente(accountId);
		wbsService.cancellaAssociazioneAccount(accountId, associazioneId); 
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "Associazione eliminata correttamente"), HttpStatus.OK);
	}
	
	@PostMapping("/wbs/account")
	@AzioneDispositiva
	public ResponseEntity<EsitoDTO> inserisci(@RequestBody AssociazioneWbsAccountDto associazione) throws BusinessException {
		wbsService.inserisciAssociazioneWbsAccount(associazione, BigInteger.valueOf(SecurityUtils.getCurrentUser().getId()));
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "Associazione inserita correttamente"), HttpStatus.OK);
	}

}
