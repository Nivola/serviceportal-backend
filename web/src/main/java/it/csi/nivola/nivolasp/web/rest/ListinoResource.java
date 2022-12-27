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
import it.csi.nivola.nivolasp.repository.query.DistinctShares;
import it.csi.nivola.nivolasp.security.AuthoritiesConstants;
import it.csi.nivola.nivolasp.security.SecurityUtils;
import it.csi.nivola.nivolasp.service.dto.AssociaStaasAccount;
import it.csi.nivola.nivolasp.service.dto.CodiceEtichettaDescrizioneDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoEnum;
import it.csi.nivola.nivolasp.service.dto.ListinoDTO;
import it.csi.nivola.nivolasp.service.dto.ListinoDettaglioDTO;
import it.csi.nivola.nivolasp.service.dto.ListinoImportoDto;
import it.csi.nivola.nivolasp.service.dto.MetricaDTO;
import it.csi.nivola.nivolasp.service.impl.ListinoService;

/**
 * Endpoint REST per la gestione dei listini
 *
 */
@RestController
@RequestMapping("/api")
public class ListinoResource extends AbstractResource {

	@Autowired
	ListinoService listinoService;

	/**
	 * Elenco di tutti i listini, ad uso dell'amministratore di BO
	 */
	@GetMapping("/listino")
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<List<ListinoDTO>> elencoListini() {
		List<ListinoDTO> listini = listinoService.elencoListini();
		return new ResponseEntity<List<ListinoDTO>>(listini, HttpStatus.OK);
	}

	/**
	 * Dettaglio completo del singolo listino, ad uso dell'amministratore di BO
	 * @param id
	 * @return
	 * @throws BusinessException 
	 */
	@GetMapping("/listino/{id}")
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<ListinoDTO> dettaglioListino(@PathVariable(name = "id") Integer id) throws BusinessException {
		return new ResponseEntity<ListinoDTO>(listinoService.dettaglioListino("" + id), HttpStatus.OK);
	}
	
	//@GetMapping("/listino/tipo")
	//@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<List<CodiceEtichettaDescrizioneDTO>> elencoTipiListino(@PathVariable(name = "id") Integer id) throws BusinessException {
		return ResponseEntity.ok(listinoService.elencoTipiListino());
	}
	
	@GetMapping("/listino/metriche")
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<List<MetricaDTO>> elencoMetricheListino() throws BusinessException {
		return ResponseEntity.ok(listinoService.elencoMetricheApplicabiliAlListino());
	}
	
	/**
	 * Richiesta di creazione listino
	 * @param nuovoListino
	 * @return
	 * @throws BusinessException
	 */
	@PostMapping("/listino")
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<EsitoDTO> creaNuovoListino(@RequestBody ListinoDTO nuovoListino) throws BusinessException {
		String id = listinoService.inserisciNuovoListino(nuovoListino, BigInteger.valueOf(SecurityUtils.getCurrentUser().getId()));
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, id, "Listino creato correttamente con id " + id), HttpStatus.CREATED);
	}
	
	/**
	 * Richiesta di modifica listino
	 * @param listino
	 * @return
	 * @throws BusinessException
	 */
	@PutMapping("/listino")
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<EsitoDTO> modificaListino(@RequestBody ListinoDTO listino) throws BusinessException {
		listinoService.modificaListino(listino, BigInteger.valueOf(SecurityUtils.getCurrentUser().getId()));
		return ResponseEntity.ok(new EsitoDTO(EsitoEnum.OK, listino.getId(), "Listino modificato"));
	}
	
	@DeleteMapping("/listino/{id}")
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<EsitoDTO> eliminaListino(@PathVariable String id) throws BusinessException {
		listinoService.eliminaListino(id, BigInteger.valueOf(SecurityUtils.getCurrentUser().getId()));
		return ResponseEntity.ok(new EsitoDTO(EsitoEnum.OK, id, "Listino cancellato"));
	}
	
	/**
	 * Crea un dettaglio
	 * @param nuovoListino
	 * @return
	 * @throws BusinessException
	 */
	@PostMapping("/listino/dettaglio")
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<EsitoDTO> creaNuovoDettaglio(@RequestBody ListinoDettaglioDTO nuovo) throws BusinessException {
		String id = listinoService.inserisciDettaglio(nuovo, BigInteger.valueOf(SecurityUtils.getCurrentUser().getId()));
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, id, "Dettaglio creato correttamente con id " + id), HttpStatus.CREATED);
	}
	
	/**
	 * Richiesta di modifica dettaglio
	 * @param dettaglio
	 * @return
	 * @throws BusinessException
	 */
	@PutMapping("/listino/dettaglio")
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<EsitoDTO> modificaListino(@RequestBody ListinoDettaglioDTO dettaglio) throws BusinessException {
		listinoService.modificaDettaglio(dettaglio, BigInteger.valueOf(SecurityUtils.getCurrentUser().getId()));
		return ResponseEntity.ok(new EsitoDTO(EsitoEnum.OK, dettaglio.getId(), "Dettaglio modificato"));
	}
	
	/**
	 * Elimina un dettaglio
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	@DeleteMapping("/listino/dettaglio/{id}")
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<EsitoDTO> eliminaDettaglio(@PathVariable String id) throws BusinessException {
		listinoService.eliminaDettaglio(id, BigInteger.valueOf(SecurityUtils.getCurrentUser().getId()));
		return ResponseEntity.ok(new EsitoDTO(EsitoEnum.OK, id, "Dettaglio cancellato"));
	}
	
	
	/**
	 * Aggiunge un importo
	 * @param nuovoListino
	 * @return
	 * @throws BusinessException
	 */
	@PostMapping("/listino/dettaglio/importo")
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<EsitoDTO> creaNuovoImporto(@RequestBody ListinoImportoDto nuovo) throws BusinessException {
		String id = listinoService.inserisciImporto(nuovo, SecurityUtils.getUtenteLoggatoCompleto().getSpUser());
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, id, "Dettaglio creato correttamente con id " + id), HttpStatus.CREATED);
	}
	
	/**
	 * Richiesta di modifica importo
	 * @param dettaglio
	 * @return
	 * @throws BusinessException
	 */
	@PutMapping("/listino/dettaglio/importo")
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<EsitoDTO> modificaImporto(@RequestBody ListinoImportoDto importo) throws BusinessException {
		listinoService.modificaImporto(importo, SecurityUtils.getUtenteLoggatoCompleto().getSpUser());
		return ResponseEntity.ok(new EsitoDTO(EsitoEnum.OK, importo.getId(), "Dettaglio modificato"));
	}
	
	/**
	 * Elimina un importo
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	@DeleteMapping("/listino/dettaglio/importo/{id}")
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<EsitoDTO> eliminaImporto(@PathVariable String id) throws BusinessException {
		listinoService.eliminaImporto(id, BigInteger.valueOf(SecurityUtils.getCurrentUser().getId()));
		return ResponseEntity.ok(new EsitoDTO(EsitoEnum.OK, id, "importo cancellato"));
	}
	
	/**
	 * Listino associato ad un account
	 * @param id
	 * @return
	 */
	@GetMapping("/account/{id}/listino")
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<ListinoDTO> listinoAccount(@PathVariable(name = "id") String id) {
		return new ResponseEntity<ListinoDTO>(listinoService.trovaListinoAccount(id), HttpStatus.OK);
	}
	
	/**
	 * Restituisce il listino di un account
	 * @param idAccount
	 * @return
	 */
	@GetMapping("/listino/attuale")
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<ListinoDTO> listinoAccountAttuale(String idAccount) {
		return new ResponseEntity<ListinoDTO>(listinoService.trovaListinoAccount(idAccount), HttpStatus.OK);
	}
	
	/**
	 * Restituisce il listino attuamente in vigore
	 * @return
	 */
	@GetMapping("/listino/corrente")
	public ResponseEntity<ListinoDTO> listinoAttuale () {
		return new ResponseEntity<ListinoDTO>(listinoService.dettaglioListinoAttuale(), HttpStatus.OK);
	}
	
	/**
	 * Associa uno storage ad un account per la successiva rendicontazione dei costi
	 * @param associazione
	 * @return
	 */
	@PostMapping("/account/staas")
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<EsitoDTO> associaVolumeAccount(@RequestBody AssociaStaasAccount associazione) {
		String id = listinoService.inserisciAssociazioneAccountStaas(associazione, BigInteger.valueOf(SecurityUtils.getCurrentUser().getId()));
		return new ResponseEntity<>(new EsitoDTO(EsitoEnum.OK, "0001", "Associazione con id " + id + " creato correttamente"), HttpStatus.OK);
	}

	/**
	 * Elenco dei volumi associabili
	 * @param accountUuid
	 * @return
	 */
	@GetMapping("/account/staas")
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<List<DistinctShares>> elencoVolumiAssociabili(String accountUuid) {

		return new ResponseEntity<List<DistinctShares>>(listinoService.elencoShares(accountUuid), HttpStatus.OK);
	}

	/**
	 * Elenco dei volumi associati per un account
	 * @param accountUuid
	 * @return
	 */
	@GetMapping("/account/staas/associati")
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<List<DistinctShares>> elencoVolumiAssociati(String accountUuid) {
		return new ResponseEntity<List<DistinctShares>>(listinoService.elencoSharesAssociati(accountUuid), HttpStatus.OK);
	}

}
