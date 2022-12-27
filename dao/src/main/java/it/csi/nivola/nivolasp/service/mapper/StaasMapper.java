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

import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeFileSystemsResponseSchemaFileSystems;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeMountTargetsResponseSchemaMountTargets;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListFileSystemGrantResponseSchemaGrants;
import it.csi.nivola.nivolasp.service.dto.AutorizzazioneStorageDTO;
import it.csi.nivola.nivolasp.service.dto.MountTargetDTO;
import it.csi.nivola.nivolasp.service.dto.StaasDTO;

/**
 * Mapper per tutte le entità riguardanti Servizi di Storage
 */
@Mapper(componentModel = "spring")
public interface StaasMapper extends CommonTypesMapper {
	
	/**
	 * Elenco volumi, dettaglio volume
	 * @param from
	 * @return
	 */
    @Mapping(source="from.sizeInBytes.value", target="dimensioneInByte")
    StaasDTO toStaasDTO(DescribeFileSystemsResponseSchemaFileSystems from);
    
    List<StaasDTO> toListStaasDTOs(List<DescribeFileSystemsResponseSchemaFileSystems> list);
    
    /**
     * Enum stato de lvolume
     * @param value
     * @return
     */
    StaasDTO.StatoFileSystemEnum mapStato(DescribeFileSystemsResponseSchemaFileSystems.LifeCycleStateEnum value);
    
    /**
     * Enum livello di performance del volume
     * @param value
     * @return
     */
    StaasDTO.PerformanceModeEnum mapPerf(DescribeFileSystemsResponseSchemaFileSystems.PerformanceModeEnum value);
    
    /**
     * Enum ThroughputMode
     * @param value
     * @return
     */
    StaasDTO.ThroughputModeEnum mapThr(DescribeFileSystemsResponseSchemaFileSystems.ThroughputModeEnum value);
    
    
    /**
     * Singolo mount target
     * @param from
     * @return
     */
    MountTargetDTO mapMountTarget (DescribeMountTargetsResponseSchemaMountTargets from);
    
    /**
     * Elenco mount target
     * @param from
     * @return
     */
    List<MountTargetDTO> mapElencoMountTarget (List<DescribeMountTargetsResponseSchemaMountTargets> from);
    
	
	
	/**
	 * Mappaggio di un'autorizzazione sul volume
	 * @param from
	 * @return
	 */
	AutorizzazioneStorageDTO singoloGrant (ListFileSystemGrantResponseSchemaGrants from);
	
	/**
	 * Mappaggio dell'elenco delle autorizzazioni sul volume
	 * @param from
	 * @return
	 */
	List<AutorizzazioneStorageDTO> elencoGtrants (List<ListFileSystemGrantResponseSchemaGrants> from);
}
