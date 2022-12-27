/*-
 * ========================LICENSE_START=================================
 * Servizi di accesso dati
 * %%
 * Copyright (C) 2022 Regione Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | Regione Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.service.mapper.cmp;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeLoggingInstancesResponseSchemaDescribeLoggingInstancesResponseInstanceInfo;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeSpacesResponseSchemaDescribeSpacesResponseDashboards;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeSpacesResponseSchemaDescribeSpacesResponseEndpoints;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo;
import it.csi.nivola.nivolasp.service.dto.DescrizioneLoggingDto;
import it.csi.nivola.nivolasp.service.dto.LoggingSpaceDashboardDto;
import it.csi.nivola.nivolasp.service.dto.LoggingSpaceDto;
import it.csi.nivola.nivolasp.service.dto.LoggingSpaceEndpointDto;

@Mapper(componentModel = "spring")
public abstract class LoggingMapper {
	
	public abstract List<DescrizioneLoggingDto> toListDescrizioneLogging (List<DescribeLoggingInstancesResponseSchemaDescribeLoggingInstancesResponseInstanceInfo> elencoFrom);
	
	
	@Mapping(source="from.stateReason.nvlCode", target="stateCode")
	@Mapping(source="from.stateReason.nvlMessage", target="stateReason")
	public abstract DescrizioneLoggingDto toDescrzioneLogging (DescribeLoggingInstancesResponseSchemaDescribeLoggingInstancesResponseInstanceInfo from);
	
	@Mapping(source="from.stateReason.nvlCode", target="stateCode")
	@Mapping(source="from.stateReason.nvlMessage", target="stateReason")
	public abstract LoggingSpaceDto toLoggingSpaceDto (DescribeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo from);
	
	public abstract List<LoggingSpaceDto> toLoggingSpaceDto (List<DescribeSpacesResponseSchemaDescribeSpacesResponseSpaceInfo> from);
	
	public abstract LoggingSpaceDashboardDto toLoggingSpaceDashboardDto (DescribeSpacesResponseSchemaDescribeSpacesResponseDashboards from);
	
	public abstract List<LoggingSpaceDashboardDto> toLoggingSpaceDashboardDto (List<DescribeSpacesResponseSchemaDescribeSpacesResponseDashboards> from);
	
	public abstract LoggingSpaceEndpointDto toLoggingSpaceEndpointDto (DescribeSpacesResponseSchemaDescribeSpacesResponseEndpoints from);

}
