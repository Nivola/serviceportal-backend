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
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import it.csi.nivola.nivolasp.security.AuthoritiesConstants;
import it.csi.nivola.nivolasp.security.SecurityUtils;
import it.csi.nivola.nivolasp.service.NewsService;
import it.csi.nivola.nivolasp.service.dto.NewsDto;
import it.csi.nivola.nivolasp.web.rest.util.HeaderUtil;

/**
 * REST controller for managing Message.
 */
@RestController
@RequestMapping("/api")
public class NewsResource {
	
	private NewsService newsService;

    private final Logger log = LoggerFactory.getLogger(NewsResource.class);

    public NewsResource(NewsService newsService) {
        this.newsService = newsService;
    }

    
    @GetMapping("/news/dashboard")
    
    public ResponseEntity<List<NewsDto>> getNewsForDashboard(Boolean dashboard) {
    	return new ResponseEntity<>(newsService.findAllValidNews(), HttpStatus.OK);
    }
    
    @GetMapping("/news")
    public ResponseEntity<List<NewsDto>> getAllNews(Boolean dashboard) {
    	if (SecurityUtils.isBackOfficeAdmin())
    		return new ResponseEntity<>(newsService.findAllNews(), HttpStatus.OK);
    	return new ResponseEntity<>(newsService.findAllValidNews(), HttpStatus.OK);
    }
/*
    @GetMapping("/my-news")
    
    public ResponseEntity<List<NewsDto>> getMyNews() {
    	List<NewsDto> page = newsService.findAllNews();
        return new ResponseEntity<>(page, HttpStatus.OK);
    }
    */
    /*@GetMapping("/messages")
    
    @Deprecated
    public ResponseEntity<List<NewsDto>> getMyNewsLegacy() {
    	List<NewsDto> page = newsService.findAllNews();
    	return new ResponseEntity<>(page, HttpStatus.OK);
    }
*/

    @GetMapping("/news/{id}")
    
    public ResponseEntity<NewsDto> getNotizia(@PathVariable Long id) {
        NewsDto notizia = newsService.findOne(id);
        return new ResponseEntity<NewsDto>(notizia, HttpStatus.OK);
    }
    

    @PostMapping("/news")
    
    @Secured(AuthoritiesConstants.BOADMIN)
    public ResponseEntity<NewsDto> createNotizia(@RequestBody NewsDto newsDto) throws URISyntaxException {
    	
        if (newsDto.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("News", "idexists", "Notizia gia' esistente")).body(null);
        }
     
        NewsDto result = newsService.save(newsDto, BigInteger.valueOf(SecurityUtils.getCurrentUser().getId()));
        
        return ResponseEntity.created(new URI("/api/news/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("News", result.getId().toString()))
            .body(result);
    }


    @PutMapping("/news")
    
    @Secured(AuthoritiesConstants.BOADMIN)
    public ResponseEntity<NewsDto> updateNotizia(@RequestBody NewsDto NewsDto) throws URISyntaxException {
        if (NewsDto.getId() == null) {
            return createNotizia(NewsDto);
        }
        NewsDto result = newsService.save(NewsDto, BigInteger.valueOf(SecurityUtils.getCurrentUser().getId()));
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("News", NewsDto.getId().toString()))
            .body(result);
    }

    
    @DeleteMapping("/news/{id}")
    
    @Secured(AuthoritiesConstants.BOADMIN)
    public ResponseEntity<Void> deleteNotizia(@PathVariable Long id) {
        log.debug("REST request to delete Message : {}", id);
        newsService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("News", id.toString())).build();
    }

}
