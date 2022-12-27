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
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.security.AuthoritiesConstants;
import it.csi.nivola.nivolasp.security.SecurityUtils;
import it.csi.nivola.nivolasp.service.GestioneListinoService;
import it.csi.nivola.nivolasp.service.MetricheService;
import it.csi.nivola.nivolasp.service.dto.CodiceEtichettaDescrizioneDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoEnum;
import it.csi.nivola.nivolasp.service.dto.InfocostoDTO;
import it.csi.nivola.nivolasp.service.dto.InsertInfocostoDTO;

/**
 * Controller per la gestione dei costi di lstino
 */
@RestController
@RequestMapping("/api")
public class GestioneListinoCostiResource extends AbstractResource {
	
	@Autowired
	MetricheService metricheService;
	
	@Autowired
	GestioneListinoService gestioneListinoService;
	
	/**
	 * Restituisce l'elenco delle decodifiche tel tipo di prezzo da applicare ad un account
	 */
	@GetMapping("listino/importo")
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<List<CodiceEtichettaDescrizioneDTO>> elencoMetricheCostoMetadati () {
		List<CodiceEtichettaDescrizioneDTO> decodifiche = new ArrayList<>();
		metricheService.decodificaTipoPrezzo().forEach(e -> {
			CodiceEtichettaDescrizioneDTO dec = new CodiceEtichettaDescrizioneDTO();
			dec.setCodice(e.getCodice());
			dec.setDescrizione(e.getDescrizione());
			dec.setEtichetta(e.getDescrizione());
			decodifiche.add(dec);
		});
		return new ResponseEntity<List<CodiceEtichettaDescrizioneDTO>>(decodifiche, HttpStatus.OK);
	}
	
	/**
	 * Restituisce tutti i record infocosto di un account
	 * @param accountId
	 * @return
	 */
	@GetMapping("listino/infocosto")
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<List<InfocostoDTO>> elencoInfocostiAccount (String accountId) {
		return new ResponseEntity<List<InfocostoDTO>>(gestioneListinoService.elencoInfocostoAccount(accountId), HttpStatus.OK);
	}
	
	/**
	 * Restituisce l'elenco dei tipi di listino (CSI, CLIENTE...)
	 * @return
	 */
	@GetMapping("listino/tipo")
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<List<CodiceEtichettaDescrizioneDTO>> elencoTipiDiListino () {
		return new ResponseEntity<List<CodiceEtichettaDescrizioneDTO>>(gestioneListinoService.elencoTipiDiListino(), HttpStatus.OK);
	}
	
	/**
	 * Restituisce l'elenco dei tipi prezzo (ESE, NC, ORD , PROD...)
	 * @return
	 */
	@GetMapping("listino/prezzo/tipo")
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<List<CodiceEtichettaDescrizioneDTO>> elencoTipiDiPrezzo () {
		return new ResponseEntity<List<CodiceEtichettaDescrizioneDTO>>(gestioneListinoService.elencoTipiPrezzo(), HttpStatus.OK);
	}
	
	/**
	 * Inserisce un infocosto
	 * @param richiesta
	 * @return
	 * @throws BusinessException
	 */
	@PostMapping("listino/infocosto")
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<EsitoDTO> inserisciInfocosto (@RequestBody InsertInfocostoDTO richiesta) throws BusinessException {
		if (StringUtils.isEmpty(richiesta.getIdListino()) && "S".equalsIgnoreCase(richiesta.getUsaListinoSpecifico()))
			throw new BusinessException("IdListino obbligatorio quando viene richiesto un listino specifico");
		gestioneListinoService.inserisciInfocosto(richiesta, BigInteger.valueOf(SecurityUtils.getUtenteLoggatoCompleto().getSpUser().getId()));
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "Infocosto inserito correttamente"), HttpStatus.OK);
	}
	
	@PutMapping("listino/infocosto")
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<EsitoDTO> modificaInfocosto (@RequestBody InsertInfocostoDTO richiesta) throws BusinessException {
		gestioneListinoService.modificaInfocosto(richiesta, BigInteger.valueOf(SecurityUtils.getUtenteLoggatoCompleto().getSpUser().getId()));
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "Infocosto inserito correttamente"), HttpStatus.OK);
	}
	
	@DeleteMapping("listino/infocosto/{id}")
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<EsitoDTO> eliminaInfocosto (@PathVariable Long id) throws BusinessException {
		gestioneListinoService.cancellaInfocosto(id, BigInteger.valueOf(SecurityUtils.getUtenteLoggatoCompleto().getSpUser().getId()));
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "Infocosto eliminato correttamente"), HttpStatus.OK);
	}
}
