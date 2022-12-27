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

import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeAccountAttributesCSResponseSchemaDescribeAccountAttributesResponseAccountAttributeSet;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeAccountAttributesCSResponseSchemaDescribeAccountAttributesResponseAttributeValueSet;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetAccountResponseSchemaAccount;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListAccountsResponseSchemaAccounts;
import it.csi.nivola.nivolasp.service.dto.AccountDTO;
import it.csi.nivola.nivolasp.service.dto.DescrizioneQuotaDTO;
import it.csi.nivola.nivolasp.service.dto.QuotaDTO;

/**
 * Mapper per Account
 */
@Mapper(componentModel = "spring")
public interface AccountMapper extends CommonTypesMapper {

	@Mapping(source = "from.date.creation", target = "creation")
	@Mapping(source = "from.date.expiry", target = "expiry")
	@Mapping(source = "from.date.modified", target = "modified")
	AccountDTO toAccountDTO(GetAccountResponseSchemaAccount from);
	
	@Mapping(source = "from.date.creation", target = "creation")
	@Mapping(source = "from.date.expiry", target = "expiry")
	@Mapping(source = "from.date.modified", target = "modified")
	AccountDTO toAccountDTO(ListAccountsResponseSchemaAccounts from);

	List<AccountDTO> toListAccountDTOs(List<ListAccountsResponseSchemaAccounts> elencoFrom);
	
	@Mapping(source = "from.attributeName", target = "nomeQuota")
	@Mapping(source = "from.nvlAttributeUnit", target = "unitaMisura")
	@Mapping(source = "from.attributeValueSet", target = "valori")
	DescrizioneQuotaDTO toDescrizioneQuota (DescribeAccountAttributesCSResponseSchemaDescribeAccountAttributesResponseAccountAttributeSet from);
	
	List<DescrizioneQuotaDTO> toDescrizioneQuotaElenco (List<DescribeAccountAttributesCSResponseSchemaDescribeAccountAttributesResponseAccountAttributeSet> from);
	
	@Mapping(source = "from.item.attributeValue", target = "limite")
	@Mapping(source = "from.item.nvlAttributeUsed", target = "usato")
	QuotaDTO toQuotaDTO (DescribeAccountAttributesCSResponseSchemaDescribeAccountAttributesResponseAttributeValueSet from);
	
	List<QuotaDTO> toQuotaDTOElenco (List<DescribeAccountAttributesCSResponseSchemaDescribeAccountAttributesResponseAttributeValueSet> from);
	
}
