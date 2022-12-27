/*-
 * ========================LICENSE_START=================================
 * Nivola Web
 * %%
 * Copyright (C) 2022 CSI Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | CSI Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.web.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.csi.nivola.nivolasp.aop.logging.AzioneDispositiva;
import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.integration.rest.api.service.ComputeserviceApi;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateInstanceSnapshotsApiRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DeleteInstanceSnapshotsApiRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeInstanceSnapshotsApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.RevertInstanceSnapshotsApiRequestSchema;
import it.csi.nivola.nivolasp.security.AuthoritiesConstants;
import it.csi.nivola.nivolasp.security.SecurityUtils;
import it.csi.nivola.nivolasp.service.dto.EsitoDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoEnum;
import it.csi.nivola.nivolasp.service.dto.RichiestaSnapshotVmDTO;
import it.csi.nivola.nivolasp.service.dto.VmSnapshotDTO;
import it.csi.nivola.nivolasp.service.mapper.VmMapper;

/**
 * Rest controller per la gestione delle snapshots Vm
 */
@RestController
@RequestMapping("/api/vm/")
public class VmSnapshotResource {
	/**
	 * Servizio presso CMP computeservice
	 */
	@Autowired
	ComputeserviceApi computeserviceApi;
	
	@Autowired
	VmMapper vmMapper;

	
	/**
	 * Elenco degli snapshots di una vm
	 * @param accountId
	 * @param instanceId
	 * @return
	 * @throws BusinessException 
	 */
	@GetMapping("/snapshot")
	@Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN,
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER,
		AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR,  AuthoritiesConstants.DIVISION_VIEWER,
		AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR,  AuthoritiesConstants.ACCOUNT_VIEWER})
	public ResponseEntity<List<VmSnapshotDTO>> getElencoSnapshotsVm(String accountId, String instanceId) throws BusinessException {
		
		List<String> elencoAccountId = new ArrayList<String>(1);
		elencoAccountId.add(SecurityUtils.getAccountIdCorrente(accountId));
		
		List<String> elencoVmId = new ArrayList<String>(1);
		elencoVmId.add(instanceId);
		
		DescribeInstanceSnapshotsApiResponseSchema rispostaSnapshots = computeserviceApi.v10NwsComputeservicesInstanceDescribeinstancesnapshotsGet(elencoVmId, elencoAccountId);
		
		if (CollectionUtils.isEmpty(rispostaSnapshots.getDescribeInstanceSnapshotsResponse().getInstancesSet()) ||
				CollectionUtils.isEmpty(rispostaSnapshots.getDescribeInstanceSnapshotsResponse().getInstancesSet().get(0).getSnapshots())) {
			return new ResponseEntity<List<VmSnapshotDTO>>(new ArrayList<>(0), HttpStatus.OK);
		}
		
		return new ResponseEntity<List<VmSnapshotDTO>> (
				vmMapper.decodificaElencoSnapshotVm(rispostaSnapshots.getDescribeInstanceSnapshotsResponse().getInstancesSet().get(0).getSnapshots()),
				HttpStatus.OK);
	}

	/**
	 * Inserisce una snapshot su una VM
	 * @param richiestaCosti
	 * @return
	 * @throws BusinessException 
	 */
	@Secured({AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR,  AuthoritiesConstants.ACCOUNT_VIEWER, AuthoritiesConstants.BOADMIN})
	@PostMapping("/snapshot")
	@AzioneDispositiva
	public ResponseEntity<EsitoDTO> creaSnapshotVm(@RequestBody RichiestaSnapshotVmDTO richiesta) throws BusinessException {
		
		if (richiesta == null) {
			throw new BusinessException("Parametri mancanti - richiesta vuota");
		}
		
		if (StringUtils.isEmpty(richiesta.getInstanceId())) {
			throw new BusinessException("Parametri mancanti - id istanza VM");
		}
		
		if (StringUtils.isEmpty(richiesta.getNomeSnapshot())) {
			throw new BusinessException("Parametri mancanti - nome snapshot");
		}
		
		List<String> elencoAccountId = new ArrayList<String>(1);
		elencoAccountId.add(SecurityUtils.getAccountIdCorrente());
		
		List<String> elencoVmId = new ArrayList<String>(1);
		elencoVmId.add(richiesta.getInstanceId());
		
		CreateInstanceSnapshotsApiRequestSchema creaSnashotCmp = new CreateInstanceSnapshotsApiRequestSchema();
		creaSnashotCmp.setInstanceIdDotN(elencoVmId);
		creaSnashotCmp.setOwnerIdN(elencoAccountId);
		creaSnashotCmp.setSnapshotName(richiesta.getNomeSnapshot());
		computeserviceApi.v10NwsComputeservicesInstanceCreateinstancesnapshotsPut(creaSnashotCmp);
		
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK,"0001", "Snapshot creata correttamente"), HttpStatus.OK);
	}
	/**
	 * Elimina una snapshot su una VM
	 * @param richiestaCosti
	 * @return
	 * @throws BusinessException 
	 */
	@Secured({AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR,  AuthoritiesConstants.ACCOUNT_VIEWER, AuthoritiesConstants.BOADMIN})
	@PutMapping("/snapshot")
	@AzioneDispositiva
	public ResponseEntity<EsitoDTO> eliminaSnapshotVm(@RequestBody RichiestaSnapshotVmDTO richiesta) throws BusinessException {
		
		if (richiesta == null) {
			throw new BusinessException("Parametri mancanti - richiesta vuota");
		}
		
		if (StringUtils.isEmpty(richiesta.getInstanceId())) {
			throw new BusinessException("Parametri mancanti - id istanza VM");
		}
		
		if (StringUtils.isEmpty(richiesta.getIdSnapshot())) {
			throw new BusinessException("Parametri mancanti - id snapshot");
		}
		
		List<String> elencoAccountId = new ArrayList<String>(1);
		elencoAccountId.add(SecurityUtils.getAccountIdCorrente());
		
		List<String> elencoVmId = new ArrayList<String>(1);
		elencoVmId.add(richiesta.getInstanceId());
		
		DeleteInstanceSnapshotsApiRequestSchema eliminaSnashotCmp = new DeleteInstanceSnapshotsApiRequestSchema();
		eliminaSnashotCmp.setInstanceIdDotN(elencoVmId);
		eliminaSnashotCmp.setOwnerIdN(elencoAccountId);
		eliminaSnashotCmp.setSnapshotId(richiesta.getIdSnapshot());
		computeserviceApi.v10NwsComputeservicesInstanceDeleteinstancesnapshotsPut(eliminaSnashotCmp);
		
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK,"0001", "Snapshot eliminata correttamente"), HttpStatus.OK);
	}
	
	
	@Secured({AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR,  AuthoritiesConstants.ACCOUNT_VIEWER, AuthoritiesConstants.BOADMIN})
	@PutMapping("/snapshot/revert")
	@AzioneDispositiva
	public ResponseEntity<EsitoDTO> revertSnapshotVm(@RequestBody RichiestaSnapshotVmDTO richiesta) throws BusinessException {
		
		if (richiesta == null) {
			throw new BusinessException("Parametri mancanti - richiesta vuota");
		}
		
		if (StringUtils.isEmpty(richiesta.getInstanceId())) {
			throw new BusinessException("Parametri mancanti - id istanza VM");
		}
		
		if (StringUtils.isEmpty(richiesta.getIdSnapshot())) {
			throw new BusinessException("Parametri mancanti - id snapshot");
		}
		
		List<String> elencoAccountId = new ArrayList<String>(1);
		elencoAccountId.add(SecurityUtils.getAccountIdCorrente());
		
		List<String> elencoVmId = new ArrayList<String>(1);
		elencoVmId.add(richiesta.getInstanceId());
		
		RevertInstanceSnapshotsApiRequestSchema richiestaRevert = new RevertInstanceSnapshotsApiRequestSchema();
		richiestaRevert.setInstanceIdDotN(elencoVmId);
		richiestaRevert.setOwnerIdN(elencoAccountId);
		richiestaRevert.setSnapshotId(richiesta.getIdSnapshot());
		System.out.println(computeserviceApi.v10NwsComputeservicesInstanceRevertinstancesnapshotsPut(richiestaRevert));
		
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK,"0001", "revert della snaphot effettuata correttamente"), HttpStatus.OK);
	}
}
