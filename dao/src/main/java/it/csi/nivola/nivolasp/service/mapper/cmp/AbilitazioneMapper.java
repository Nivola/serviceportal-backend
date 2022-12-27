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
package it.csi.nivola.nivolasp.service.mapper.cmp;

import org.mapstruct.Mapper;

import it.csi.nivola.nivolasp.integration.rest.model.service.GetUserRolesAndServicesResponseSchemaServices;
import it.csi.nivola.nivolasp.service.dto.AbilitazioneDTO;

@Mapper(componentModel="spring")
public interface AbilitazioneMapper {
	
	AbilitazioneDTO serviceToAbilitazione(GetUserRolesAndServicesResponseSchemaServices getUserRolesAndServicesResponseSchemaServices);

}
