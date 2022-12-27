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
package it.csi.nivola.nivolasp.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Pageable;

import it.csi.nivola.nivolasp.service.dto.NewsDto;
import it.csi.nivola.nivolasp.service.dto.UserDTO;

public interface NewsService {

    public NewsDto findOne(Long id);

    public NewsDto save(NewsDto messageDTO, BigInteger userId);
 
    public void delete(Long id);

	public List<NewsDto> findAllForCurrentUser(Pageable pageable, UserDTO currentUser);

	public List<NewsDto> findAllNews();
	
	public List<NewsDto> findAllValidNews();
    
}
