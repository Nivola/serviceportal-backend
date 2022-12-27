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

import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeVpcsResponseSchemaDescribeVpcsResponseCidrBlockAssociationSet;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeVpcsResponseSchemaDescribeVpcsResponseCidrBlockState;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeVpcsResponseSchemaDescribeVpcsResponseVpcSet;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetAccountDefinitionsResponseSchemaDefinitions;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetCatalogDefsResponseSchemaServicedefs;
import it.csi.nivola.nivolasp.service.dto.CidrBlockAssociationsDTO;
import it.csi.nivola.nivolasp.service.dto.CidrBlockStateDTO;
import it.csi.nivola.nivolasp.service.dto.DefinizioneServizioDTO;
import it.csi.nivola.nivolasp.service.dto.VpcDTO;
import it.csi.nivola.nivolasp.service.dto.VpcDTO.InstanceTenancyEnum;

@Mapper(componentModel="spring")
public interface ServiziMapper {
	
	/**
	 * Mappatura della singola definizione del servizio
	 * @param from
	 * @return
	 */
	DefinizioneServizioDTO mappaServizioV2 (GetAccountDefinitionsResponseSchemaDefinitions from);
	
	/**
	 * Mappatura dell'elenco della definizione di servizi
	 * @param from
	 * @return
	 */
	List<DefinizioneServizioDTO> elencoServiziV2 (List<GetAccountDefinitionsResponseSchemaDefinitions> from);
	
	/**
	 * Mappatura della singola definizione del servizio
	 * @param from
	 * @return
	 */
	DefinizioneServizioDTO mappaServizio (GetCatalogDefsResponseSchemaServicedefs from);
	
	/**
	 * Mappatura dell'elenco della definizione di servizi
	 * @param from
	 * @return
	 */
	List<DefinizioneServizioDTO> elencoServizi (List<GetCatalogDefsResponseSchemaServicedefs> from);
	
	
	/**
	 * Mappaggio singolo VPC
	 * @param from
	 * @return
	 */
	VpcDTO singoloVpc (DescribeVpcsResponseSchemaDescribeVpcsResponseVpcSet from);
	
	/**
	 * Mappatura dell'elenco VPC
	 * @param from
	 * @return
	 */
	List<VpcDTO> elencoVpc (List<DescribeVpcsResponseSchemaDescribeVpcsResponseVpcSet> from);
	
	
	CidrBlockAssociationsDTO singoloBlocco (DescribeVpcsResponseSchemaDescribeVpcsResponseCidrBlockAssociationSet from);
	
	List<CidrBlockAssociationsDTO> elencoBlocchi(List<DescribeVpcsResponseSchemaDescribeVpcsResponseCidrBlockAssociationSet> value);
	
	InstanceTenancyEnum map(DescribeVpcsResponseSchemaDescribeVpcsResponseVpcSet.InstanceTenancyEnum from);
	
	CidrBlockStateDTO blocco(DescribeVpcsResponseSchemaDescribeVpcsResponseCidrBlockState from);
	
	CidrBlockStateDTO.StateEnum stato(DescribeVpcsResponseSchemaDescribeVpcsResponseCidrBlockState.StateEnum value);

}
