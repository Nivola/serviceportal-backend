/*-
 * ========================LICENSE_START=================================
 * Nivola Web
 * %%
 * Copyright (C) 2022 Regione Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | Regione Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.web.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import it.csi.nivola.nivolasp.aop.logging.AzioneDispositiva;
import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.integration.rest.api.service.AuthorityApi;
import it.csi.nivola.nivolasp.integration.rest.api.service.ComputeserviceApi;
import it.csi.nivola.nivolasp.integration.rest.api.service.ServiceApi;
import it.csi.nivola.nivolasp.integration.rest.model.service.AuthorizeSGroupEgressApiRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.AuthorizeSGroupEgressApiRequestSchemaRule;
import it.csi.nivola.nivolasp.integration.rest.model.service.AuthorizeSGroupEgressApiRequestSchemaRuleIpPermissionsN;
import it.csi.nivola.nivolasp.integration.rest.model.service.AuthorizeSGroupEgressApiRequestSchemaRuleIpPermissionsN.IpProtocolEnum;
import it.csi.nivola.nivolasp.integration.rest.model.service.AuthorizeSGroupEgressApiRequestSchemaRuleIpRanges;
import it.csi.nivola.nivolasp.integration.rest.model.service.AuthorizeSGroupEgressApiRequestSchemaRuleIpv6Ranges;
import it.csi.nivola.nivolasp.integration.rest.model.service.AuthorizeSGroupEgressApiRequestSchemaRuleUserIdGroupPairs;
import it.csi.nivola.nivolasp.integration.rest.model.service.AuthorizeSGroupIngressApiRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateSecurityGroupApiRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateSecurityGroupApiRequestSchemaSecurityGroup;
import it.csi.nivola.nivolasp.integration.rest.model.service.DeleteSecurityGroupApiRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DeleteSecurityGroupApiRequestSchemaSecurityGroup;
import it.csi.nivola.nivolasp.integration.rest.model.service.DeleteSecurityGroupApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeSecurityGroupsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeVpcsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetAccountDefinitionsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.RevokeSGroupEgressApiRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.RevokeSGroupIngressApiRequestSchema;
import it.csi.nivola.nivolasp.security.AuthoritiesConstants;
import it.csi.nivola.nivolasp.security.SecurityUtils;
import it.csi.nivola.nivolasp.service.dto.CreazioneSecurityGroupDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoEnum;
import it.csi.nivola.nivolasp.service.dto.RegolaSecurityGroup;
import it.csi.nivola.nivolasp.service.dto.RegolaSecurityGroup.TipoRegoleEnum;
import it.csi.nivola.nivolasp.service.dto.VpcDTO;
import it.csi.nivola.nivolasp.service.mapper.cmp.ServiziMapper;
import it.csi.nivola.nivolasp.util.StreamingObjectUtil;

/**
 * Rest controller per la gestione dei Security Groups
 */
@RestController
@RequestMapping("/api")
public class SecurityGroupResource {
	/**
	 * Servizio presso CMP computeservice
	 */
	ComputeserviceApi computeserviceApi;

	ServiceApi serviceApi;

	ServiziMapper serviziMapper;
	
	AuthorityApi authorityApi;

	private final Logger log = LoggerFactory.getLogger(SecurityGroupResource.class);

	/**
	 * Costruttore
	 * 
	 * @param computeserviceApi
	 */
	public SecurityGroupResource(ComputeserviceApi computeserviceApi, ServiceApi serviceApi, ServiziMapper serviziMapper, AuthorityApi authorityApi) {
		this.computeserviceApi = computeserviceApi;
		this.serviceApi = serviceApi;
		this.serviziMapper = serviziMapper;
		this.authorityApi = authorityApi;
	}

	/**
	 * Recupera l'elenco delle VM di un account
	 * 
	 * @param accountUuid
	 * @return
	 */
	@GetMapping("/securitygroups/{uuid}")
	@Secured({ AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR, AuthoritiesConstants.ACCOUNT_VIEWER })
	public ResponseEntity<DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo> getDettaglioSecurityGroup(@PathVariable String uuid) {
		List<String> elencoId = new ArrayList<>(1);
		elencoId.add(uuid);
		DescribeSecurityGroupsResponseSchema risposta = computeserviceApi.v10NwsComputeservicesSecuritygroupDescribesecuritygroupsGet(null, elencoId, null, null, null, null, null, -1, null);

		return new ResponseEntity<DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo>(risposta.getDescribeSecurityGroupsResponse().getSecurityGroupInfo().get(0), HttpStatus.OK);
	}

	/**
	 * Interroga la definjizione dei servizi per ottenere i templates del security
	 * group
	 * 
	 * @return
	 * @throws BusinessException 
	 * @throws RestClientException 
	 */
	@GetMapping("/securitygroups/templates")
	@Secured({ AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR, AuthoritiesConstants.ACCOUNT_VIEWER })
	public ResponseEntity<Object> getElencoTemplates(String accountId) throws RestClientException, BusinessException {
		
//		ListServiceDefinitionResponseSchema risposta = serviceApi.v10NwsServicedefsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "ComputeSecurityGroup", null);
		GetAccountDefinitionsResponseSchema risposta = authorityApi.v20NwsAccountsOidDefinitionsGet(SecurityUtils.getAccountIdCorrente(accountId), -1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, "ComputeSecurityGroup" /*plugin type*/, null, null);
		
//		return new ResponseEntity<>(serviziMapper.elencoServizi(risposta.getServicedefs()), HttpStatus.OK);
		return new ResponseEntity<>(serviziMapper.elencoServiziV2(risposta.getDefinitions()), HttpStatus.OK);
	}

	
	/**
	 * Elenco dei VP per account corrente
	 * @return
	 * @throws BusinessException 
	 */
	@GetMapping({"vpc", "/vpc/{uuidAccount}"})
	@Secured({ AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR, AuthoritiesConstants.ACCOUNT_VIEWER })
	public ResponseEntity<List<VpcDTO>> getElencoVpc(@PathVariable(required=false) String uuidAccount) throws BusinessException {
		List<String> ownerIdN = new ArrayList<>(1);
		if (SecurityUtils.isBackOfficeAdmin())
			ownerIdN.add(uuidAccount);
		else
			ownerIdN.add(SecurityUtils.getAccountIdCorrente());

		DescribeVpcsResponseSchema risposta = computeserviceApi.v10NwsComputeservicesVpcDescribevpcsGet(ownerIdN, null, null, null, null, null, null);
		return new ResponseEntity<>(serviziMapper.elencoVpc(risposta.getDescribeVpcsResponse().getVpcSet()), HttpStatus.OK);
	}
	
	/**
	 * Elimina un securoty Group per nome
	 * @param nome
	 * @return
	 */
	@DeleteMapping("/securitygroups/{nome}")
	@Secured({ AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR })
	@AzioneDispositiva
	public ResponseEntity<EsitoDTO> elimina(@PathVariable String nome) {
		DeleteSecurityGroupApiRequestSchema richiesta = new DeleteSecurityGroupApiRequestSchema();
		
		DeleteSecurityGroupApiRequestSchemaSecurityGroup securityGroup = new DeleteSecurityGroupApiRequestSchemaSecurityGroup();
		securityGroup.setGroupName(nome);
		
		richiesta.setSecurityGroup(securityGroup);
		
		DeleteSecurityGroupApiResponseSchema risposta = computeserviceApi.v10NwsComputeservicesSecuritygroupDeletesecuritygroupDelete(richiesta);
		
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "Richiesta di eliminazione del security group effettuata con id: "+ risposta.getDeleteSecurityGroupResponse().getRequestId()), HttpStatus.OK);
	}
	
	
	/**
	 * Crea un security Group
	 * @param gruppo
	 * @return
	 */
	@PostMapping("/securitygroups")
	@Secured({ AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR })
	@AzioneDispositiva
	public ResponseEntity<EsitoDTO> creaSecurityGroup(@RequestBody CreazioneSecurityGroupDTO gruppo) {
		CreateSecurityGroupApiRequestSchema richiesta = new CreateSecurityGroupApiRequestSchema();

		CreateSecurityGroupApiRequestSchemaSecurityGroup securityGroup = new CreateSecurityGroupApiRequestSchemaSecurityGroup();

//	securityGroup.setGroupDescription(gruppo.getDescrizione());
		securityGroup.setGroupName(gruppo.getNome());
		securityGroup.setGroupType(gruppo.getUuidTemplate());
		securityGroup.setVpcId(gruppo.getVpcId());

		richiesta.setSecurityGroup(securityGroup);
		
		computeserviceApi.v10NwsComputeservicesSecuritygroupCreatesecuritygroupPost(richiesta);

		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "SecurityGroup creato correttamente"), HttpStatus.OK);
	}

	
	/**
	 * Aggiunge una regola al security Group specificato facendo distinzione tra
	 * ingresso e uscita
	 * 
	 * @param regola
	 * @return
	 */
	@PostMapping("/securitygroups/regola")
	@Secured({ AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR })
	@AzioneDispositiva
	public ResponseEntity<EsitoDTO> creaRegolaSecurityGroup(@RequestBody RegolaSecurityGroup regola) {
		log.info("REGOLA: " + StreamingObjectUtil.streamObjectToJSON(regola));
		if (TipoRegoleEnum.INGRESSO.equals(regola.getTipoRegola())) {
			AuthorizeSGroupIngressApiRequestSchema body = new AuthorizeSGroupIngressApiRequestSchema();
			AuthorizeSGroupEgressApiRequestSchemaRule rule = impostaRegola(regola);
			body.setRule(rule);
			computeserviceApi.v10NwsComputeservicesSecuritygroupAuthorizesecuritygroupingressPost(body);
		}
		else {
			AuthorizeSGroupEgressApiRequestSchema body = new AuthorizeSGroupEgressApiRequestSchema();
			AuthorizeSGroupEgressApiRequestSchemaRule rule = impostaRegola(regola);
			body.setRule(rule);
			computeserviceApi.v10NwsComputeservicesSecuritygroupAuthorizesecuritygroupegressPost(body);
		}

		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "Regola creata correttamente"), HttpStatus.OK);
	}

	
	/**
	 * Revoca una regola al security Group specificato facendo distinzione tra
	 * ingresso e uscita
	 * 
	 * @param regola
	 * @return
	 */
	@PutMapping("/securitygroups/regola")
	@Secured({ AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR })
	@AzioneDispositiva
	public ResponseEntity<EsitoDTO> revocaRegolaSecurityGroup(@RequestBody RegolaSecurityGroup regola) {
		log.info("REGOLA: " + StreamingObjectUtil.streamObjectToJSON(regola));
		if (TipoRegoleEnum.INGRESSO.equals(regola.getTipoRegola())) {
			RevokeSGroupIngressApiRequestSchema body = new RevokeSGroupIngressApiRequestSchema();
			AuthorizeSGroupEgressApiRequestSchemaRule rule = impostaRegola(regola);
			body.setRule(rule);
			computeserviceApi.v10NwsComputeservicesSecuritygroupRevokesecuritygroupingressDelete(body);
		}
		else {
			RevokeSGroupEgressApiRequestSchema body = new RevokeSGroupEgressApiRequestSchema();
			AuthorizeSGroupEgressApiRequestSchemaRule rule = impostaRegola(regola);
			body.setRule(rule);
			computeserviceApi.v10NwsComputeservicesSecuritygroupRevokesecuritygroupegressDelete(body);
		}

		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "Regola creata correttamente"), HttpStatus.OK);
	}

	
	/**
	 * Genera l'oggetto che rappresenta la regola di un security group verso la cmp
	 * per tutti e 4 i casi: 1) aggiunta regola in ingresso 2) aggiunta regola in
	 * uscite 3) revoca regola in ingresso 4) revoca regola in uscita
	 * 
	 * @param regola
	 * @return
	 */
	private AuthorizeSGroupEgressApiRequestSchemaRule impostaRegola(RegolaSecurityGroup regola) {
		AuthorizeSGroupEgressApiRequestSchemaRule rule = new AuthorizeSGroupEgressApiRequestSchemaRule();
		rule.setGroupName(regola.getGruppoAppartenenza());
		List<AuthorizeSGroupEgressApiRequestSchemaRuleIpPermissionsN> ipPermissionsN = new ArrayList<>();
		AuthorizeSGroupEgressApiRequestSchemaRuleIpPermissionsN singolaRegola = new AuthorizeSGroupEgressApiRequestSchemaRuleIpPermissionsN();
		singolaRegola.setFromPort(regola.getDaPorta());
		singolaRegola.setToPort(regola.getaPorta());
		IpProtocolEnum protocolloTrovato = IpProtocolEnum.fromValue(StringUtils.trimToEmpty(regola.getProtocollo()));
		if ("SSH".equalsIgnoreCase(StringUtils.trimToEmpty(regola.getProtocollo())))
			protocolloTrovato = IpProtocolEnum.TCP;
		singolaRegola.setIpProtocol(protocolloTrovato);

		/*
		 * Sezione CIRD per IP V4
		 */
		if (StringUtils.isNotEmpty(regola.getCidrIp())) {
			List<AuthorizeSGroupEgressApiRequestSchemaRuleIpRanges> ipRanges = new ArrayList<>();
			AuthorizeSGroupEgressApiRequestSchemaRuleIpRanges rangeIp = new AuthorizeSGroupEgressApiRequestSchemaRuleIpRanges();
			rangeIp.setCidrIp(regola.getCidrIp());
			rangeIp.setDescription(regola.getDescrizione());
			ipRanges.add(rangeIp);
			singolaRegola.setIpRanges(ipRanges);
		}

		/*
		 * Sezione CIDR per IP V6
		 */
		if (StringUtils.isNotEmpty(regola.getCidrIpV6())) {
			List<AuthorizeSGroupEgressApiRequestSchemaRuleIpv6Ranges> ipv6Ranges = new ArrayList<>();
			AuthorizeSGroupEgressApiRequestSchemaRuleIpv6Ranges ipv6 = new AuthorizeSGroupEgressApiRequestSchemaRuleIpv6Ranges();
			ipv6.setCidrIpv6(regola.getCidrIpV6());
			ipv6.setDescription(regola.getDescrizione());
			ipv6Ranges.add(ipv6);
			singolaRegola.setIpv6Ranges(ipv6Ranges);
		}

		/*
		 * Sezione Verso Security Group
		 */
		if (StringUtils.isNotEmpty(regola.getGruppoDestinazione())) {
			List<AuthorizeSGroupEgressApiRequestSchemaRuleUserIdGroupPairs> userIdGroupPairs = new ArrayList<>();
			AuthorizeSGroupEgressApiRequestSchemaRuleUserIdGroupPairs gruppo = new AuthorizeSGroupEgressApiRequestSchemaRuleUserIdGroupPairs();
			gruppo.setGroupName(regola.getGruppoDestinazione());
			userIdGroupPairs.add(gruppo);
			singolaRegola.setUserIdGroupPairs(userIdGroupPairs);
		}

		ipPermissionsN.add(singolaRegola);
		rule.setIpPermissionsN(ipPermissionsN);
		return rule;
	}
}
