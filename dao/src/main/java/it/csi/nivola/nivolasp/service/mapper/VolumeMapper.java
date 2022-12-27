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

import it.csi.nivola.nivolasp.integration.rest.model.service.AttachVolumeApiResponseSchemaAttachVolumeResponse;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateVolumeApiResponseSchemaCreateVolumeResponse;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeDBInstanceTypesApiResponseSchemaDescribeDBInstanceTypesResponseFeatures;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeDBInstanceTypesApiResponseSchemaDescribeDBInstanceTypesResponseInstanceTypesSet;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeVolumeTypesApiResponseSchemaDescribeVolumeTypesResponse;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeVolumesApiResponseSchemaDescribeVolumesResponse;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeVolumesApiResponseSchemaDescribeVolumesResponseAttachmentSet;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeVolumesApiResponseSchemaDescribeVolumesResponseVolumesSet;
import it.csi.nivola.nivolasp.integration.rest.model.service.DetachVolumeApiResponseSchemaDetachVolumeResponse;
import it.csi.nivola.nivolasp.service.dto.AttachDetachVolumeRisposta;
import it.csi.nivola.nivolasp.service.dto.ElencoTipiVolumeRisposta;
import it.csi.nivola.nivolasp.service.dto.FeaturesTipoVolumeDTO;
import it.csi.nivola.nivolasp.service.dto.RispostaElencoVolumiDTO;
import it.csi.nivola.nivolasp.service.dto.TipoVolumeDTO;
import it.csi.nivola.nivolasp.service.dto.VolumeAttachmentDTO;
import it.csi.nivola.nivolasp.service.dto.VolumeDTO;

/**
 * Mapper per tutte le entità riguardanti i volumi
 */
@Mapper(componentModel = "spring")
public interface VolumeMapper extends CommonTypesMapper {
	
	/**
	 * Risposta Principale
	 */
	@Mapping(source="from.nvlVolumeTotal", target="numeroVolumiTotali")
	@Mapping(source="from.volumesSet", target="elencoVolumi")
	RispostaElencoVolumiDTO toRispostaElencoVolumi(DescribeVolumesApiResponseSchemaDescribeVolumesResponse from);
	
	/**
	 * Elenco dei volumi
	 */
	List<VolumeDTO> toVolumeDto (List<DescribeVolumesApiResponseSchemaDescribeVolumesResponseVolumesSet> from);
	
	/**
	 * Elenco dei volumi
	 */
	VolumeDTO toVolumeDto (DescribeVolumesApiResponseSchemaDescribeVolumesResponseVolumesSet from);
	
	/**
	 * Attachment
	 */
	List<VolumeAttachmentDTO> toVolumeAttachment (List<DescribeVolumesApiResponseSchemaDescribeVolumesResponseAttachmentSet> from);
	
	/**
	 * Attachment
	 */
	VolumeAttachmentDTO toVolumeAttachment (DescribeVolumesApiResponseSchemaDescribeVolumesResponseAttachmentSet from);

	/**
	 * Dopo la creazione di un volume
	 * @param createVolumeResponse
	 * @return
	 */
	VolumeDTO toVolumeDto(CreateVolumeApiResponseSchemaCreateVolumeResponse createVolumeResponse);
	
	@Mapping(source="from.volumeTypesTotal", target="totali")
	@Mapping(source="from.volumeTypesSet", target="elencoTipiVolume")
	ElencoTipiVolumeRisposta toRispostaTipiVolume (DescribeVolumeTypesApiResponseSchemaDescribeVolumeTypesResponse from);
	
	/**
	 * Elenco dei tipi volume
	 */
	List<TipoVolumeDTO> toElencoTipoVolume(List<DescribeDBInstanceTypesApiResponseSchemaDescribeDBInstanceTypesResponseInstanceTypesSet> from);
	
	/**
	 * Singolo tipo volume
	 * @param from
	 * @return
	 */
	TipoVolumeDTO toElencoTipoVolume(DescribeDBInstanceTypesApiResponseSchemaDescribeDBInstanceTypesResponseInstanceTypesSet from);
	
	/**
	 * 
	 * @param from
	 * @return
	 */
	FeaturesTipoVolumeDTO toFeaturesDTO (DescribeDBInstanceTypesApiResponseSchemaDescribeDBInstanceTypesResponseFeatures from);
	
	/**
	 * Risposta dell'attach
	 * @param from
	 * @return
	 */
	AttachDetachVolumeRisposta toAttachDetach( AttachVolumeApiResponseSchemaAttachVolumeResponse from);
	
	/**
	 * Detach volume
	 * @param from
	 * @return
	 */
	AttachDetachVolumeRisposta toAttachDetach( DetachVolumeApiResponseSchemaDetachVolumeResponse from);
}
