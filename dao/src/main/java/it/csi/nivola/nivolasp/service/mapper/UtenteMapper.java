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
package it.csi.nivola.nivolasp.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.csi.nivola.nivolasp.domain.SpUser;
import it.csi.nivola.nivolasp.service.dto.DatiUtenteDTO;
import it.csi.nivola.nivolasp.service.dto.UserDTO;

/**
 * Mapper per SPUser a UserDTO e viceversa 
 */
@Mapper(componentModel = "spring")
public interface UtenteMapper {


	@Mapping(source="cognome", target="lastName")
	@Mapping(source="nome", target="firstName")
	@Mapping(source="username", target="login")
	UserDTO spUserToUserDTO(SpUser utente);

    List<UserDTO> spUsersToUserDtos(List<SpUser> elencoUtentiDB);

    SpUser utenteToSpUser(UserDTO NewsDto);

    List<SpUser> newsDtosToSpNews(List<UserDTO> utenti);
    
    SpUser datiUtenteDTOtoSPUser(DatiUtenteDTO from);  
}
