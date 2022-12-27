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

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.csi.nivola.nivolasp.aop.logging.AzioneDispositiva;
import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.remote.service.ControlloBatchService;
import it.csi.nivola.nivolasp.remote.service.RemoteControlException;
import it.csi.nivola.nivolasp.security.AuthoritiesConstants;
import it.csi.nivola.nivolasp.service.RendicontoService;
import it.csi.nivola.nivolasp.service.dto.EsitoDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoEnum;

@RestController
@RequestMapping("/api/admin")
@Secured(AuthoritiesConstants.BOADMIN)
public class StrumentiAmministratoreBackoffice extends AbstractResource{
	

	@Autowired
	ControlloBatchService controlloBatchService;
	
	@Autowired
	RendicontoService rendicontoService;
	
	@SuppressWarnings("unused")
	private final Logger log = LoggerFactory.getLogger(StrumentiAmministratoreBackoffice.class);
	
	/**
	 * Cancellazione e ricalcolo costi e report
	 * @param accountId
	 * @param data
	 * @return
	 * @throws BusinessException
	 * @throws RemoteControlException
	 */
	@DeleteMapping("accountcmp/{accountId}/costi/{data}")
	@AzioneDispositiva
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<EsitoDTO> eliminaCostiPerRicalcolo (@PathVariable String accountId, @PathVariable String data) throws BusinessException, RemoteControlException {
		if (controlloBatchService.controllaBatchLibero().equals("NO")) {
			throw new BusinessException("BATCH ATTUALMENTE IN ESECUZIONE: RIPROVARE PIU' TARDI.");
		}
		rendicontoService.cancellaGiorni(accountId, LocalDate.parse(data));
		rendicontoService.cancellaReport(accountId, LocalDate.parse(data));
		controlloBatchService.eseguiTutto();
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "Costi cancellati correttamente"), HttpStatus.OK);
    }

}
