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

import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeBackupJobPoliciesApiResponseSchemaDescribeBackupJobPoliciesResponseJobPoliciesSet;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseInstanceSet;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseInstanceSet;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseRestorePointSet;
import it.csi.nivola.nivolasp.service.dto.BackupPoliciesDto;
import it.csi.nivola.nivolasp.service.dto.CodiceEtichettaDescrizioneDTO;
import it.csi.nivola.nivolasp.service.dto.JobBackupDTO;
import it.csi.nivola.nivolasp.service.dto.RestorePointDTO;

@Mapper(componentModel = "spring")
public abstract class BackupMapper {

	/**
	 * Mappaggio del job di backup
	 * 
	 * @param from
	 * @return
	 */
	public abstract JobBackupDTO toBackupDto(DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet from);

	/**
	 * Elenco Job di backup
	 * 
	 * @param from
	 * @return
	 */
	public abstract List<JobBackupDTO> toListBackupDto(List<DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseJobSet> from);

	/**
	 * mappaggio job.instanceSet
	 * 
	 * @param from
	 * @return
	 */
	@Mapping(source = "from.name", target = "etichetta")
	@Mapping(source = "from.uuid", target = "codice")
	public abstract CodiceEtichettaDescrizioneDTO toCodiceEtichettaDto(DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseInstanceSet from);

	/**
	 * mappaggio job.instanceSet
	 * 
	 * @param from
	 * @return
	 */
	public abstract List<CodiceEtichettaDescrizioneDTO> toListCodiceEtichettaDto(List<DescribeBackupJobsResponseSchemaDescribeBackupJobsResponseInstanceSet> from);

	/**
	 * Restore point
	 * 
	 * @param from
	 * @return
	 */
	@Mapping(source = "from.message.error", target = "messageError")
	@Mapping(source = "from.message.progress", target = "messageProgress")
	@Mapping(source = "from.message.warning", target = "messageWarning")
	@Mapping(source = "from.size.restore", target = "sizeRestore")
	@Mapping(source = "from.size.tot", target = "sizeTot")
	@Mapping(source = "from.size.uploaded", target = "sizeUploaded")
	public abstract RestorePointDTO toRestorePointDto(DescribeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseRestorePointSet from);

	/**
	 * Elenco Restore point
	 * 
	 * @param from
	 * @return
	 */
	public abstract List<RestorePointDTO> toListRestorePointDto(List<DescribeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseRestorePointSet> from);
	

	/**
	 * Singola policy
	 * @param from
	 * @return
	 */
	public abstract BackupPoliciesDto toBackupPolicyDto(DescribeBackupJobPoliciesApiResponseSchemaDescribeBackupJobPoliciesResponseJobPoliciesSet from);
	
	/**
	 * Elenco Restore point
	 * 
	 * @param from
	 * @return
	 */
	public abstract List<BackupPoliciesDto> toListBackupPolicyDto(List<DescribeBackupJobPoliciesApiResponseSchemaDescribeBackupJobPoliciesResponseJobPoliciesSet> from);

	/**
	 * restorepoint.instanceSet
	 * 
	 * @param from
	 * @return
	 */
	@Mapping(source = "from.name", target = "etichetta")
	@Mapping(source = "from.uuid", target = "codice")
	public abstract CodiceEtichettaDescrizioneDTO toRestorePointElencoIstanzeElemento(DescribeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseInstanceSet from);

	/**
	 * restorepoint.instanceSet
	 * 
	 * @param from
	 * @return
	 */
	public abstract List<CodiceEtichettaDescrizioneDTO> toRestorePointElencoIstanze(List<DescribeBackupRestorePointsResponseSchemaDescribeBackupRestorePointsResponseInstanceSet> from);

	public java.time.LocalDateTime map(java.sql.Timestamp timestamp) {
		if (timestamp == null)
			return null;
		return timestamp.toLocalDateTime();
	}

}
