/*-
 * ========================LICENSE_START=================================
 * Servizi di accesso dati
 * %%
 * Copyright (C) 2022 CSI Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | CSI Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.csi.nivola.nivolasp.domain.SpNews;
import it.csi.nivola.nivolasp.repository.SpNewsRepository;
import it.csi.nivola.nivolasp.service.NewsService;
import it.csi.nivola.nivolasp.service.dto.NewsDto;
import it.csi.nivola.nivolasp.service.dto.UserDTO;
import it.csi.nivola.nivolasp.service.mapper.NewsMapper;

@Service
@Transactional
public class NewsServiceImpl implements NewsService{

    private final Logger log = LoggerFactory.getLogger(NewsServiceImpl.class);

    private final SpNewsRepository spNewsRepository;

    private final NewsMapper newsMapper;

    public NewsServiceImpl(SpNewsRepository spNewsRepository, NewsMapper newsMapper) {
        this.spNewsRepository = spNewsRepository;
        this.newsMapper = newsMapper;
    }
    
    @Override
    @Transactional(readOnly = true)
    public NewsDto findOne(Long id) {
        log.debug("Request to get SpNews : {}", id);
        SpNews document = spNewsRepository.findOne(id);
        NewsDto notizia = newsMapper.spNewsToNewsDto(document);
        return notizia;
    }

    
    @Override
    @Transactional(readOnly = true)
    public List<NewsDto> findAllNews() {
    	List<SpNews> result = spNewsRepository.findAll();
    	return newsMapper.spNewssToNewsDtos(result);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<NewsDto> findAllValidNews() {
    	List<SpNews> result = spNewsRepository.findNonScadute();
    	return newsMapper.spNewssToNewsDtos(result);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<NewsDto> findAllForCurrentUser(Pageable pageable, UserDTO currentUser) {
        List<SpNews> result = spNewsRepository.findNewsPerUtenteDestinatario(currentUser.getId());
        return newsMapper.spNewssToNewsDtos(result);
    }
   
    
    @Override
    public NewsDto save(NewsDto notizia, BigInteger userId) {
        
        SpNews notiziaDaSalvare = newsMapper.newsDtoToSpNews(notizia);
        notiziaDaSalvare.setAutoreId(userId);
        notiziaDaSalvare.setIdAgente(userId);
        notiziaDaSalvare.setSpStatoNew(spNewsRepository.findStatoNotizia(notizia.getStato()));
        notiziaDaSalvare = spNewsRepository.saveAndFlush(notiziaDaSalvare);
        NewsDto result = newsMapper.spNewsToNewsDto(notiziaDaSalvare);
        return result;
    }

    
    @Override
    public void delete(Long id) {
        log.debug("Request to delete SpNews : {}", id);
        spNewsRepository.delete(id);
    }

}
