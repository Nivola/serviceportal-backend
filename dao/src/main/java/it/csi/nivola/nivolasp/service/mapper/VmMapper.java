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

import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeDBInstanceTypesApiResponseSchemaDescribeDBInstanceTypesResponseInstanceTypesSet;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeImagesResponseSchemaDescribeImagesResponseImagesSet;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeInstanceSnapshotsApiResponseSchemaDescribeInstanceSnapshotsResponseSnapshots;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeInstancesApiResponseSchemaDescribeInstancesResponseGroupSet;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeInstancesApiResponseSchemaDescribeInstancesResponseInstancesSet;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet;
import it.csi.nivola.nivolasp.service.dto.DescrizioneGruppo;
import it.csi.nivola.nivolasp.service.dto.FlavourDTO;
import it.csi.nivola.nivolasp.service.dto.SecurityGroupDTO;
import it.csi.nivola.nivolasp.service.dto.SubnetDTO;
import it.csi.nivola.nivolasp.service.dto.TemplateDTO;
import it.csi.nivola.nivolasp.service.dto.VmDTO;
import it.csi.nivola.nivolasp.service.dto.VmDetailDTO;
import it.csi.nivola.nivolasp.service.dto.VmSnapshotDTO;

/**
 * Mapper per tutte le entità riguardanti le VM
 */
@Mapper(componentModel = "spring")
public interface VmMapper extends CommonTypesMapper {
	
	/**
	 * Elenco VM
	 */
	@Mapping(source="from.nvlName", target="name")
	@Mapping(source="from.privateIpAddress", target="ip")
	@Mapping(source="from.nvlInstanceTypeExt.vcpus", target="cpu")
	@Mapping(source="from.nvlInstanceTypeExt.memory", target="ram")
	@Mapping(target="region", constant="RegionPiemonte01")
	@Mapping(source="from.placement.availabilityZone", target="az")
	@Mapping(source="from.instanceState.name", target="status")
	VmDTO toVmDto(DescribeInstancesApiResponseSchemaDescribeInstancesResponseInstancesSet from);
	
	/**
	 * Dettaglio VM
	 */
	@Mapping(source="from.nvlName", target="name")
	@Mapping(source="from.ipAddress", target="ip")
	@Mapping(source="from.nvlInstanceTypeExt.vcpus", target="cpu")
	@Mapping(source="from.nvlInstanceTypeExt.memory", target="ram")
	@Mapping(target="region", constant="RegionPiemonte01")
	@Mapping(source="from.placement.availabilityZone", target="az")
	VmDetailDTO toVmV2DetailDto(DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet from);
	

	/**
	 * Converte una descrizione di immagine in un template per la lista delle creazione VM
	 * @param from
	 * @return
	 */
	TemplateDTO toTemplateDTO(DescribeImagesResponseSchemaDescribeImagesResponseImagesSet from);
	
	/**
	 * Elenco immagini
	 * @param elencoFrom
	 * @return
	 */
    List<TemplateDTO> toListTemplateDTOs(List<DescribeImagesResponseSchemaDescribeImagesResponseImagesSet> elencoFrom);
    
    /**
     * Converte una definizione di serviziuo CMP in flavour
     * @param from
     * @return
     */
    @Mapping(source="from.features.disk", target="disk")
	@Mapping(source="from.features.ram", target="ram")
	@Mapping(source="from.features.vcpus", target="vcpus")
    FlavourDTO toFlavourDTO(DescribeDBInstanceTypesApiResponseSchemaDescribeDBInstanceTypesResponseInstanceTypesSet from);
    
    /**
     * Elenco flavours
     * @param list
     * @return
     */
    List<FlavourDTO> toListFlavourDTOs(List<DescribeDBInstanceTypesApiResponseSchemaDescribeDBInstanceTypesResponseInstanceTypesSet> list);
    
    /**
     * Subnet
     * @param from
     * @return
     */
    SubnetDTO toSubnetDTO (DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet from);
    
    List<SubnetDTO> toListSubnetDTOs(List<DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet> elencoFrom); 
    
    /**
     * Security group
     * @param from
     * @return
     */
    SecurityGroupDTO toSecurityGroupDTO (DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo from);
    
    /**
     * Elenco security groups
     * @param elencoFrom
     * @return
     */
    List<SecurityGroupDTO> toListSecurityGroupDTO (List<DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo> elencoFrom);
    
    /**
     * Elenco Dettaglio Security group
     * @param from
     * @return
     */
    List<DescrizioneGruppo> elencosg (List<DescribeInstancesApiResponseSchemaDescribeInstancesResponseGroupSet> from);
    
    /**
     * Singolo dettaglio security group
     * @param from
     * @return
     */
    DescrizioneGruppo decodificaSecGroup (DescribeInstancesApiResponseSchemaDescribeInstancesResponseGroupSet from);
    
    /**
     * Singolo snapshot di una VM
     * @param from
     * @return
     */
    VmSnapshotDTO decodificaSnapshotVm (DescribeInstanceSnapshotsApiResponseSchemaDescribeInstanceSnapshotsResponseSnapshots from);
    
    /**
     * Elenco di snapshots di una VM
     * @param from
     * @return
     */
    List<VmSnapshotDTO> decodificaElencoSnapshotVm (List<DescribeInstanceSnapshotsApiResponseSchemaDescribeInstanceSnapshotsResponseSnapshots> from);

    @Mapping(source="from.nvlName", target="name")
	@Mapping(source="from.privateIpAddress", target="ip")
	@Mapping(source="from.nvlInstanceTypeExt.vcpus", target="cpu")
	@Mapping(source="from.nvlInstanceTypeExt.memory", target="ram")
	@Mapping(target="region", constant="RegionPiemonte01")
	@Mapping(source="from.placement.availabilityZone", target="az")
	@Mapping(source="from.instanceState.name", target="status")
	VmDTO toVm2Dto(DescribeInstancesV20ApiResponseSchemaDescribeInstancesResponseInstancesSet from);

	
}
