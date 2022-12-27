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
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.integration.rest.api.service.ComputeserviceApi;
import it.csi.nivola.nivolasp.integration.rest.model.service.AddBackupJobInstanceRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.AddBackupJobInstanceResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateBackupJobRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateBackupJobRequestSchema.HypervisorEnum;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateBackupJobResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateBackupRestoreApiRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateBackupRestoreApiRequestSchemaInstance;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateBackupRestoreApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateBackupRestorePointsRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateBackupRestorePointsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DelBackupJobInstanceRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DelBackupJobInstanceResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DeleteBackupRestorePointsRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DeleteBackupRestorePointsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeBackupJobPoliciesApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeBackupJobsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeBackupRestorePointsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ModifyBackupJobRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ModifyBackupJobResponseSchema;
import it.csi.nivola.nivolasp.security.AuthoritiesConstants;
import it.csi.nivola.nivolasp.security.SecurityUtils;
import it.csi.nivola.nivolasp.service.dto.AggiungiJobIstanzaRequest;
import it.csi.nivola.nivolasp.service.dto.AssociaRestorePointVmRequest;
import it.csi.nivola.nivolasp.service.dto.BackupPoliciesDto;
import it.csi.nivola.nivolasp.service.dto.ElencoRispostaDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoEnum;
import it.csi.nivola.nivolasp.service.dto.GestioneJobRequest;
import it.csi.nivola.nivolasp.service.dto.GestioneRestorePointRequest;
import it.csi.nivola.nivolasp.service.dto.JobBackupDTO;
import it.csi.nivola.nivolasp.service.dto.RestorePointDTO;
import it.csi.nivola.nivolasp.service.mapper.BackupMapper;

@RestController
@RequestMapping("/api")
public class BackupResource extends AbstractResource {
	
	@Autowired
	ComputeserviceApi computeserviceApi;
	
	@Autowired
	BackupMapper backupMapper;
	
	/**
	 * Elenco dei job di backup di un account
	 * 
	 * @param accountId
	 * @return
	 * @throws BusinessException
	 */
	@GetMapping("/backup/job")
	public ResponseEntity<ElencoRispostaDTO<JobBackupDTO>> elencoJob(String accountId, String jobId) throws BusinessException {
		ElencoRispostaDTO<JobBackupDTO> rispostaRest = new ElencoRispostaDTO<>();
		
		List<String> ownerId = new ArrayList<>(1);
		ownerId.add(SecurityUtils.getAccountIdCorrente(accountId));
		DescribeBackupJobsResponseSchema rispostaCMP = computeserviceApi.v10NwsComputeservicesInstancebackupDescribebackupjobsGet(ownerId, jobId);
		
		rispostaRest.setRisultati(backupMapper.toListBackupDto(rispostaCMP.getDescribeBackupJobsResponse().getJobSet()));
		rispostaRest.setRequestId(rispostaCMP.getDescribeBackupJobsResponse().getRequestId());
		rispostaRest.setTotali(rispostaCMP.getDescribeBackupJobsResponse().getJobTotal());
		
		return new ResponseEntity<ElencoRispostaDTO<JobBackupDTO>>(rispostaRest, HttpStatus.OK);
	}
	
	/**
	 * Elenco dei restore points di un account
	 * 
	 * @param accountId
	 * @return
	 * @throws BusinessException
	 */
	@GetMapping("/backup/restorepoint")
	public ResponseEntity<ElencoRispostaDTO<RestorePointDTO>> elencoRestorePoint(String accountId, String restorePointId, String instanceId, String jobId) throws BusinessException {
		
		ElencoRispostaDTO<RestorePointDTO> rispostaRest = new ElencoRispostaDTO<>();
		
		String ownerId = SecurityUtils.getAccountIdCorrente(accountId);
		DescribeBackupRestorePointsResponseSchema rispostaCMP = computeserviceApi.v10NwsComputeservicesInstancebackupDescribebackuprestorepointsGet(ownerId, instanceId, jobId, restorePointId);
		
		rispostaRest.setRisultati(backupMapper.toListRestorePointDto(rispostaCMP.getDescribeBackupRestorePointsResponse().getRestorePointSet()));
		rispostaRest.setRequestId(rispostaCMP.getDescribeBackupRestorePointsResponse().getRequestId());
		rispostaRest.setTotali(rispostaCMP.getDescribeBackupRestorePointsResponse().getRestorePointTotal());
		
		return new ResponseEntity<ElencoRispostaDTO<RestorePointDTO>>(rispostaRest, HttpStatus.OK);
	}
	
	/**
	 * Elenco delle policies di backup
	 * @param accountId
	 * @return
	 * @throws BusinessException
	 */
	@GetMapping("/backup/job/policies")
	public ResponseEntity<ElencoRispostaDTO<BackupPoliciesDto>> elencoPolicies(String accountId) throws BusinessException {
		ElencoRispostaDTO<BackupPoliciesDto> rispostaRest = new ElencoRispostaDTO<>();
		
		DescribeBackupJobPoliciesApiResponseSchema rispostaCMP = computeserviceApi.v10NwsComputeservicesInstancebackupDescribebackupjobpoliciesGet(SecurityUtils.getAccountIdCorrente(accountId));
		
		rispostaRest.setRisultati(backupMapper.toListBackupPolicyDto(rispostaCMP.getDescribeBackupJobPoliciesResponse().getJobPoliciesSet()));
		rispostaRest.setRequestId(rispostaCMP.getDescribeBackupJobPoliciesResponse().getRequestId());
		rispostaRest.setTotali(rispostaCMP.getDescribeBackupJobPoliciesResponse().getJobPoliciesTotal());
		
		
		return new ResponseEntity<ElencoRispostaDTO<BackupPoliciesDto>>(rispostaRest, HttpStatus.OK);
	}
	
	
	
	/**
	 * Crea un nuovo job di backup
	 * 
	 * @param richiesta
	 * @return
	 * @throws BusinessException 
	 */
	@PostMapping("/backup/job")
	@Secured(AuthoritiesConstants.BOADMIN) //fino all'implementazione del CDU evito di esporlo
	public ResponseEntity<EsitoDTO> creaNuovoJob (GestioneJobRequest richiesta) throws BusinessException {
		
		CreateBackupJobRequestSchema creaJob = new CreateBackupJobRequestSchema();
		creaJob.setAvailabilityZone(richiesta.getAvailabilityZone());
		creaJob.setHypervisor(HypervisorEnum.fromValue(richiesta.getHypervisor()));
		creaJob.setInstanceIdDotN(Arrays.asList(richiesta.getIdIstanza()));
		creaJob.setName(richiesta.getNome());
		creaJob.setOwnerId(SecurityUtils.getAccountIdCorrente(richiesta.getAccountId()));
		creaJob.setPolicy(richiesta.getPolicy());
		CreateBackupJobResponseSchema risposta = computeserviceApi.v10NwsComputeservicesInstancebackupCreatebackupjobPost(creaJob);
		
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0000", "Job creato correttamente " + risposta.getCreateBackupJob().getRequestId()), HttpStatus.OK);
	}
	
	/**
	 * Associa un Job di backup ad un'istanza
	 * 
	 * @param richiesta
	 * @return
	 * @throws BusinessException 
	 */
	@PostMapping("/backup/job/istance")
	@Secured(AuthoritiesConstants.BOADMIN) //fino all'implementazione del CDU evito di esporlo
	public ResponseEntity<EsitoDTO> aggiungiJobIstanza(AggiungiJobIstanzaRequest  richiesta) throws BusinessException {
		
		AddBackupJobInstanceRequestSchema aggiungiJob = new AddBackupJobInstanceRequestSchema();
		aggiungiJob.setInstanceId(richiesta.getInstanceId());
		aggiungiJob.setJobId(richiesta.getJobId()); //risultato del test05 (creazione job) o test02 (elenco job)
		aggiungiJob.setOwnerId(SecurityUtils.getAccountIdCorrente(richiesta.getOwnerId()));
		AddBackupJobInstanceResponseSchema risposta = computeserviceApi.v10NwsComputeservicesInstancebackupAddbackupjobinstancePost(aggiungiJob);
		
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0000", "Istanza aggiunta correttamente " + risposta.getAddBackupJobInstance().getRequestId()), HttpStatus.OK);
		
	}
	
	/**
	 * Crea un nuovo restore point
	 * 
	 * @param richiesta
	 * @return
	 * @throws BusinessException
	 */
	@PostMapping("/backup/restorepoint")
	@Secured(AuthoritiesConstants.BOADMIN) //fino all'implementazione del CDU evito di esporlo
	public ResponseEntity<EsitoDTO> creaRestorePoint (GestioneRestorePointRequest richiesta) throws BusinessException {
		
		CreateBackupRestorePointsRequestSchema creaRestorePoint = new CreateBackupRestorePointsRequestSchema();
		
		creaRestorePoint.setBackupFull(richiesta.getBackupFull());
		creaRestorePoint.setDesc(richiesta.getDesc());
		creaRestorePoint.setJobId(richiesta.getJobId());
		creaRestorePoint.setName(richiesta.getName());
		creaRestorePoint.setOwnerId(SecurityUtils.getAccountIdCorrente(richiesta.getAccountId()));
		CreateBackupRestorePointsResponseSchema risposta = computeserviceApi.v10NwsComputeservicesInstancebackupCreatebackuprestorepointsPost(creaRestorePoint);

		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0000", "restore point creato correttamente " + risposta.getCreateBackupRestorePoints().getRequestId()), HttpStatus.OK);
		
	}
	
	
	@PostMapping("/backup/restore/vm")
	@Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR})
	public ResponseEntity<EsitoDTO> creaRestorePoint (AssociaRestorePointVmRequest richiesta) throws BusinessException {
		CreateBackupRestoreApiRequestSchema creaRestore = new CreateBackupRestoreApiRequestSchema();
		CreateBackupRestoreApiRequestSchemaInstance instance = new CreateBackupRestoreApiRequestSchemaInstance();
		instance.setInstanceId(richiesta.getInstanceId());
		instance.setInstanceName(richiesta.getInstanceName());
		instance.setOwnerId(SecurityUtils.getAccountIdCorrente(richiesta.getAccountId()));
		instance.setRestorePointId(richiesta.getRestorePointId()); // test07 (creazione) oppure test03 (elenco)
		creaRestore.setInstance(instance);
		CreateBackupRestoreApiResponseSchema risposta = computeserviceApi.v10NwsComputeservicesInstancebackupCreatebackuprestoresPost(creaRestore);
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0000", "restore point creato correttamente " + risposta.getCreateBackupRestoreResponse().getRequestId()), HttpStatus.OK);
		
	}
	
	/**
	 * Elimina un job di backup
	 * 
	 * @param richiesta
	 * @return
	 * @throws BusinessException
	 */
	@PostMapping("/backup/job/delete")
	@Secured(AuthoritiesConstants.BOADMIN) //fino all'implementazione del CDU evito di esporlo
	public ResponseEntity<EsitoDTO> cancellaJobIstanza (GestioneJobRequest richiesta) throws BusinessException {
		
		DelBackupJobInstanceRequestSchema cancellaJobIstanza = new DelBackupJobInstanceRequestSchema();
		cancellaJobIstanza.setInstanceId(richiesta.getIdIstanza());
		cancellaJobIstanza.setJobId(richiesta.getJobId());
		cancellaJobIstanza.setOwnerId(SecurityUtils.getAccountIdCorrente(richiesta.getAccountId()));
		DelBackupJobInstanceResponseSchema risposta = computeserviceApi.v10NwsComputeservicesInstancebackupDelbackupjobinstanceDelete(cancellaJobIstanza);

		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0000", "job eliminato correttamente " + risposta.getDelBackupJobInstance().getRequestId()), HttpStatus.OK);
		
	}
	
	/**
	 * Elimina un restore point
	 * 
	 * @param richiesta
	 * @return
	 * @throws BusinessException
	 */
	@PostMapping("/backup/restorepoint/delete")
	@Secured(AuthoritiesConstants.BOADMIN) //fino all'implementazione del CDU evito di esporlo
	public ResponseEntity<EsitoDTO> cancellaRestorePoint (GestioneRestorePointRequest richiesta) throws BusinessException {
		
		DeleteBackupRestorePointsRequestSchema cancellaRestorePoint = new DeleteBackupRestorePointsRequestSchema();
		cancellaRestorePoint.setJobId(richiesta.getJobId());
		cancellaRestorePoint.setOwnerId(SecurityUtils.getAccountIdCorrente(richiesta.getAccountId()));
		cancellaRestorePoint.setRestorePointId(richiesta.getRestorePointId());
		DeleteBackupRestorePointsResponseSchema risposta = computeserviceApi.v10NwsComputeservicesInstancebackupDeletebackuprestorepointsDelete(cancellaRestorePoint);

		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0000", "restore point eliminato correttamente " + risposta.getDeleteBackupRestorePoints().getRequestId()), HttpStatus.OK);
		
	}
	
	/**
	 * Modifica un job di backup
	 * 
	 * @param richiesta
	 * @return
	 * @throws BusinessException
	 */
	@PutMapping("/backup/job")
	@Secured(AuthoritiesConstants.BOADMIN) //fino all'implementazione del CDU evito di esporlo
	public ResponseEntity<EsitoDTO> modificaJobIstanza (GestioneJobRequest richiesta) throws BusinessException {
		
		ModifyBackupJobRequestSchema modificaJobBackup = new ModifyBackupJobRequestSchema();
		modificaJobBackup.setEnabled(richiesta.getEnabled());
		modificaJobBackup.setJobId(richiesta.getJobId());
		modificaJobBackup.setName(richiesta.getNome());
		modificaJobBackup.setOwnerId(SecurityUtils.getAccountIdCorrente(richiesta.getAccountId()));
		modificaJobBackup.setPolicy(richiesta.getPolicy()); // valori per policy?
		ModifyBackupJobResponseSchema risposta = computeserviceApi.v10NwsComputeservicesInstancebackupModifybackupjobPut(modificaJobBackup);

		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0000", "job modificato correttamente " + risposta.getModifyBackupJob().getRequestId()), HttpStatus.OK);
		
	}
	

}
