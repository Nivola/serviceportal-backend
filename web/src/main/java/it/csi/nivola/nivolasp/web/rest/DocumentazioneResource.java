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

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.csi.nivola.nivolasp.domain.SpDReadTheDocsMapping;
import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.repository.SpReadTheDocsMappingRepository;
import it.csi.nivola.nivolasp.security.AuthoritiesConstants;
import it.csi.nivola.nivolasp.security.SecurityUtils;
import it.csi.nivola.nivolasp.service.dto.DocumentazioneDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoEnum;
import it.csi.nivola.nivolasp.service.mapper.DocumentazioneMapper;
/**
 * Rest controller per la gestione dell'associazione routing - documentazione
 */
@RequestMapping("/api/docs/")
@RestController
public class DocumentazioneResource extends AbstractResource {
	
	@Autowired
	SpReadTheDocsMappingRepository spReadTheDocsMappingRepository;
	
	@Autowired
	DocumentazioneMapper documentazioneMapper;

	/**
	 * Restituisce l'elenco delle associazioni
	 * @return
	 */
	@GetMapping("readthedocs")
	public ResponseEntity<List<DocumentazioneDTO>> elencoUrlDocumentazione(String lingua) {
		List<SpDReadTheDocsMapping> definizioni = spReadTheDocsMappingRepository.findByLingua(lingua);
		List<DocumentazioneDTO> elencoVoci = new ArrayList<DocumentazioneDTO>(definizioni.size());
		definizioni.forEach(d -> {
			DocumentazioneDTO voce = documentazioneMapper.toDocumentazioneDto(d);
			if (!d.getDocUrl().toLowerCase().startsWith("http"))
				voce.setDocUrl(applicationProperties.getDeploy().getDocsBaseUrl()+applicationProperties.getDeploy().getDocsLang()+d.getDocUrl());
			elencoVoci.add(voce);
		});
		return new ResponseEntity<List<DocumentazioneDTO>>(elencoVoci, HttpStatus.OK);
		
	}
	
	/**
	 * Restituisce una specifica associazione
	 * @return
	 */
	@GetMapping("readthedocs/{routeLabel}")
	public ResponseEntity<DocumentazioneDTO> getUrlDocumento(@PathVariable("routeLabel") String routeLabel, String lingua) {
		SpDReadTheDocsMapping findByRouteLabel = spReadTheDocsMappingRepository.findByRouteLabelAndLingua(routeLabel, lingua);
		DocumentazioneDTO voce = documentazioneMapper.toDocumentazioneDto(findByRouteLabel);
		if (!findByRouteLabel.getDocUrl().toLowerCase().startsWith("http"))
			voce.setDocUrl(applicationProperties.getDeploy().getDocsBaseUrl()+applicationProperties.getDeploy().getDocsLang()+findByRouteLabel.getDocUrl());
		return new ResponseEntity<DocumentazioneDTO>(voce, HttpStatus.OK);
	}
	
	
	/**
	 * Inserisce una nuova associazione
	 * @param parametro
	 * @return
	 * @throws BusinessException
	 */
	@PostMapping("readthedocs")
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<EsitoDTO> inserisciUrlDocumentazione(@RequestBody SpDReadTheDocsMapping parametro) throws BusinessException {
		if (parametro.getId() != null)
			throw new BusinessException("Identificativo dell'associazione deve essere null");
		parametro.setSpUser(SecurityUtils.getUtenteLoggatoCompleto().getSpUser());
		spReadTheDocsMappingRepository.saveAndFlush(parametro);
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "Associazione routing - url di documentazione eseguito correttamente"), HttpStatus.OK);
	}
	
	
	/**
	 * modifica un'associazione esistente
	 * @param parametro
	 * @return
	 * @throws BusinessException
	 */
	@PutMapping("readthedocs")
	@Secured(AuthoritiesConstants.BOADMIN)
	public ResponseEntity<EsitoDTO> modificaUrlDocumentazioneEsistente(@RequestBody SpDReadTheDocsMapping parametro) throws BusinessException {
		
		if (parametro.getId() == null)
			throw new BusinessException("Identificativo dell'associazione deve essere valorizzato");
		
		SpDReadTheDocsMapping mapping = spReadTheDocsMappingRepository.findOne(parametro.getId());
		
		if (mapping == null )
			throw new BusinessException("Associazione alla documentazione con id " + parametro.getId() + " Non trovata");
		
		parametro.setSpUser(SecurityUtils.getUtenteLoggatoCompleto().getSpUser());
		spReadTheDocsMappingRepository.saveAndFlush(parametro);
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "Associazione routing - url di documentazione eseguito correttamente"), HttpStatus.OK);
	}

}
