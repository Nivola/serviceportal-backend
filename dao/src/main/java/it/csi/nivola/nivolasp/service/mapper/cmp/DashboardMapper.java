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

import java.util.List;

import org.mapstruct.Mapper;

import it.csi.nivola.nivolasp.integration.rest.model.service.GetActiveServicesByAccountResponseSchemaServicesServiceContainer;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetActiveServicesByAccountResponseSchemaServicesTotMetrics;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetActiveServicesByDivisionResponseSchemaServices;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetActiveServicesByOrganizationResponseSchemaServices;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetNivolaActiveServicesResponseSchemaServices;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListCostOrganizationResponseSchemaCosts;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListCostsAccountResponseSchemaCosts;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListCostsDivisionResponseSchemaCosts;
import it.csi.nivola.nivolasp.service.dto.CostoConCreditoDTO;
import it.csi.nivola.nivolasp.service.dto.CostoDTO;
import it.csi.nivola.nivolasp.service.dto.MetricaDTO;
import it.csi.nivola.nivolasp.service.dto.ServizioDTO;
import it.csi.nivola.nivolasp.service.dto.SommarioServiziCloudDTO;

/**
 * Mapper per Organizzazione
 */
@Mapper(componentModel = "spring")
public interface DashboardMapper {
	
	ServizioDTO mappaServizio (GetActiveServicesByAccountResponseSchemaServicesServiceContainer from);
	
	List<ServizioDTO> elencoServizi (List<GetActiveServicesByAccountResponseSchemaServicesServiceContainer> from);
	
	MetricaDTO mappaMetrica (GetActiveServicesByAccountResponseSchemaServicesTotMetrics from);
	
	List<MetricaDTO> elencoMetriche (List<GetActiveServicesByAccountResponseSchemaServicesTotMetrics> from);
	
	CostoDTO convertiCostoAccount(ListCostsAccountResponseSchemaCosts from);
	
	CostoConCreditoDTO convertiCostoDivisione(ListCostsDivisionResponseSchemaCosts from);
	
	CostoConCreditoDTO convertiCostoOrganizzazione(ListCostOrganizationResponseSchemaCosts from);
	
	SommarioServiziCloudDTO convertiServiziAttiviPerDivisione (GetActiveServicesByDivisionResponseSchemaServices from);
	
	SommarioServiziCloudDTO convertiServiziAttiviPerDivisione (GetActiveServicesByOrganizationResponseSchemaServices from);
	
	SommarioServiziCloudDTO convertiServiziAttiviPerDivisione (GetNivolaActiveServicesResponseSchemaServices from);
}
