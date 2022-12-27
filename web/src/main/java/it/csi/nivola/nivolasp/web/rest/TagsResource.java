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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.integration.rest.api.service.ComputeserviceApi;
import it.csi.nivola.nivolasp.integration.rest.api.service.ServiceApi;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateTagsApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DeleteTagsApiRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DeleteTagsApiRequestSchemaTags;
import it.csi.nivola.nivolasp.integration.rest.model.service.DeleteTagsApiRequestSchemaTagsTagN;
import it.csi.nivola.nivolasp.integration.rest.model.service.DeleteTagsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.TagsApiRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.TagsApiRequestSchemaTags;
import it.csi.nivola.nivolasp.security.SecurityUtils;
import it.csi.nivola.nivolasp.service.dto.EsitoDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoEnum;
import it.csi.nivola.nivolasp.service.dto.RichiestaTagDTO;
import it.csi.nivola.nivolasp.service.mapper.VmMapper;

/**
 * Rest controller per la gestione dell Vm
 */
@RestController
@RequestMapping("/api")
public class TagsResource {
	/**
	 * Servizio presso CMP computeservice
	 */
	@Autowired
	ComputeserviceApi computeserviceApi;

	@Autowired
	VmMapper vmMapper;

	@Autowired
	ServiceApi serviceApi;

	private Logger log = LoggerFactory.getLogger(TagsResource.class);

	
	/**
	 * Aggiunge un tag ad una risorsa
	 * @param resourceId
	 * @param accountId
	 * @param elencoTags
	 * @return
	 * @throws BusinessException 
	 */
	@PostMapping("/vm/tags")
	public ResponseEntity<EsitoDTO> aggiungiTagRisorsa (@RequestBody RichiestaTagDTO richiesta) throws BusinessException {
		TagsApiRequestSchema body = new TagsApiRequestSchema();
		TagsApiRequestSchemaTags tags = new TagsApiRequestSchemaTags();
		tags.setOwnerId(SecurityUtils.getAccountIdCorrente(richiesta.getAccountId()));
		List<String> elencoRisorse = new ArrayList<String>();
		elencoRisorse.add(richiesta.getRisorsaId());
		tags.setResourceIdN(elencoRisorse);
		List<DeleteTagsApiRequestSchemaTagsTagN> elencoTagsCMP = new ArrayList<>(richiesta.getTags().size());
		richiesta.getTags().forEach(t -> {
			DeleteTagsApiRequestSchemaTagsTagN tagDaCreare = new DeleteTagsApiRequestSchemaTagsTagN();
			tagDaCreare.setKey(t.getCodice());
			elencoTagsCMP.add(tagDaCreare);
			
		});
		tags.setTagN(elencoTagsCMP);
		body.setTags(tags);
		CreateTagsApiResponseSchema risposta = computeserviceApi.v10NwsComputeservicesTagCreatetagsPost(body);
		log.debug("AGGIUNTA TAG ALLA RISORSA " + richiesta.getRisorsaId(), risposta);
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "Tag aggiunto correttamente"), HttpStatus.OK);
	}
	
	
	/**
	 * Elimina un tag dalla risorsa
	 * @param resourceId
	 * @param tagKey
	 * @return
	 */
	@DeleteMapping("/risorsa/{resourceId}/tags/{tagKey}")
	public ResponseEntity<EsitoDTO> eliminaTagRisorsa (@PathVariable String resourceId, @PathVariable String tagKey) {
		DeleteTagsApiRequestSchema body = new DeleteTagsApiRequestSchema();
		DeleteTagsApiRequestSchemaTags tags = new DeleteTagsApiRequestSchemaTags();
		tags.addResourceIdNItem(resourceId);
		DeleteTagsApiRequestSchemaTagsTagN tagNItem = new DeleteTagsApiRequestSchemaTagsTagN();
		tagNItem.setKey(tagKey);
		tags.addTagNItem(tagNItem);
		body.setTags(tags);
		DeleteTagsResponseSchema risposta = computeserviceApi.v10NwsComputeservicesTagDeletetagsDelete(body);
		log.debug("ELIMINAZIONE TAG DALLA RISORSA " + resourceId + " TAG: " + tagKey, risposta);
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "Tag eliminato correttamente"), HttpStatus.OK);
	}
}
