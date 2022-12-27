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

import it.csi.nivola.nivolasp.integration.rest.model.service.CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSubnetGroup;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSubnetGroupSubnets;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceVpcSecurityGroups;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateDBInstanceV2ResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstance;
import it.csi.nivola.nivolasp.integration.rest.model.service.DeleteDBInstancesApiResponseSchemaDeleteDBInstanceResponseDeleteDBInstanceResultDBInstance;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeDBInstanceTypesApiResponseSchemaDescribeDBInstanceTypesResponseInstanceTypesSet;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet;
import it.csi.nivola.nivolasp.service.dto.DbGrouSubnetDTO;
import it.csi.nivola.nivolasp.service.dto.DbaasDetailDTO;
import it.csi.nivola.nivolasp.service.dto.FlavourDTO;
import it.csi.nivola.nivolasp.service.dto.SecurityGroupDTO;
import it.csi.nivola.nivolasp.service.dto.SubnetDTO;
import it.csi.nivola.nivolasp.service.dto.SubnetDbDTO;

/**
 * Mapper per tutte le entità riguardanti le VM
 */
@Mapper(componentModel = "spring")
public interface DBaasMapper extends CommonTypesMapper {
	
	
    /**
     * Converte una definizione di serviziuo CMP in flavour
     * @param from
     * @return
     */
    @Mapping(source="from.features.disk", target="disk")
	@Mapping(source="from.features.ram", target="ram")
	@Mapping(source="from.features.vcpus", target="vcpus")
    FlavourDTO toFlavourDTO(DescribeDBInstanceTypesApiResponseSchemaDescribeDBInstanceTypesResponseInstanceTypesSet from);
    
    List<FlavourDTO> toListFlavourDTOs(List<DescribeDBInstanceTypesApiResponseSchemaDescribeDBInstanceTypesResponseInstanceTypesSet> list);
    
    
    /**
     * Subnet e relativo elenco
     * @param from
     * @return
     */
    SubnetDTO toSubnetDTO (DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet from);
    
    List<SubnetDTO> toListSubnetDTOs(List<DescribeSubnetsResponseSchemaDescribeSubnetsResponseSubnetSet> elencoFrom); 
    
    
    SecurityGroupDTO toSecurityGroupDTO (DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo from);
    
    List<SecurityGroupDTO> toListSecurityGroupDTO (List<DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo> elencoFrom);
    
    
    SecurityGroupDTO toSecurityGroupDTO2 (CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceVpcSecurityGroups from);
    
    List<SecurityGroupDTO> toListSecurityGroupDTO2 (List<CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceVpcSecurityGroups> elencoFrom);
    
    
//    @Mapping(source="from.endpoint.address", target="address")
//	@Mapping(source="from.endpoint.port", target="port")
    DbaasDetailDTO toDettaglio (DeleteDBInstancesApiResponseSchemaDeleteDBInstanceResponseDeleteDBInstanceResultDBInstance deleteDBInstancesApiResponseSchemaDeleteDBInstanceResponseDeleteDBInstanceResultDBInstance);
    
    SubnetDbDTO toSubnetDB (CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSubnetGroup from);
    
    List<SubnetDbDTO> toListSubnetDB (List<CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSubnetGroup> from);
    
    @Mapping(source="from.subnetAvailabilityZone.name", target="name")
    DbGrouSubnetDTO toDbGroup (CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSubnetGroupSubnets from);
    
    List<DbGrouSubnetDTO> toDbGroupList (List<CreateDBInstanceResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstanceDBSubnetGroupSubnets> from);

    @Mapping(source="from.dbInstancePort", target="port")
    @Mapping(source="from.endpoint.address", target="address")
    @Mapping(source="from.dbSubnetGroup.dbSubnetGroupName", target="subnet")
    @Mapping(expression = "java(from.getVpcSecurityGroups().get(0).getVpcSecurityGroupMembership().getNvlVpcSecurityGroupName())", target="securityGroup")
	DbaasDetailDTO toDettaglioV2(CreateDBInstanceV2ResponseSchemaCreateDBInstanceResponseCreateDBInstanceResultDBInstance from);
    
    
}
