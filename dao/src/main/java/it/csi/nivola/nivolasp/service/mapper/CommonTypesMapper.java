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

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommonTypesMapper {
/*
	@InheritConfiguration
	public void intoDates (GetAccountCapabilityResponseSchemaCapabilitiesDate from, @MappingTarget BaseCMPDto to);
	*/
}
