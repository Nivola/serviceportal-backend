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
package it.csi.nivola.nivolasp.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.integration.rest.api.service.AuthorityApi;
import it.csi.nivola.nivolasp.integration.rest.api.service.ComputeserviceApi;
import it.csi.nivola.nivolasp.integration.rest.api.service.DatabaseserviceApi;
import it.csi.nivola.nivolasp.integration.rest.api.service.StorageserviceApi;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeDBInstanceTypesApiResponseSchemaDescribeDBInstanceTypesResponseInstanceTypesSet;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeDBInstanceTypesApiV2ResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeDBInstancesV2ResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeDBInstancesV2ResponseSchemaDescribeDBInstancesResponseDescribeDBInstancesResultDBInstances;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeFileSystemsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeFileSystemsResponseSchemaFileSystems;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeImagesResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeInstanceSnapshotsApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeInstanceSnapshotsApiResponseSchemaDescribeInstanceSnapshotsResponseInstancesSet;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeInstancesApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeInstancesApiResponseSchemaDescribeInstancesResponseInstancesSet;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeMountTargetsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeMountTargetsResponseSchemaMountTargets;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeSecurityGroupsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseIpPermissions;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeVolumesApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeVolumesApiResponseSchemaDescribeVolumesResponseVolumesSet;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetAccountResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetDivisionResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetOrganizationResponseSchema;
import it.csi.nivola.nivolasp.service.dto.ExportCSV;

@Service
public class ExportRisorseCSVService {

	private static final String SEP = ";";
	
	private static final String N_LINE = "\r\n";
	
	SimpleDateFormat formatoGiorno = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	AuthorityApi authorityApi;
	
	@Autowired
	public ComputeserviceApi computeserviceApi;

	@Autowired
	DatabaseserviceApi databaseserviceApi;
	
	@Autowired
	StorageserviceApi storageserviceApi;
	

	/**
	 * Estrazione dell'elenco dei security grou0ps di un account
	 * @param accountId
	 * @return
	 * @throws BusinessException
	 */
	public ExportCSV estrazioneSecurityGroupsAccount(String accountId) throws BusinessException {
		List<String> elencoAccountId = new ArrayList<String>(1);
		elencoAccountId.add(accountId);
		StringBuilder sb = new StringBuilder();
		GetAccountResponseSchema account = authorityApi.v10NwsAccountsOidGet(elencoAccountId.get(0));
		GetDivisionResponseSchema divisione = authorityApi.v10NwsDivisionsOidGet(account.getAccount().getDivisionId());
		GetOrganizationResponseSchema organizzazione = authorityApi.v10NwsOrganizationsOidGet(divisione.getDivision().getOrganizationId());
		
		sb.append("Organizzazione").append(SEP);
		sb.append("Divisione").append(SEP);
		sb.append("Account").append(SEP);
		sb.append("Ingress/Egress").append(SEP);
		sb.append("Verso CIDR").append(SEP);
		sb.append("Protocollo").append(SEP);
		sb.append("Da Porta").append(SEP);
		sb.append("A Porta").append(SEP);
		sb.append("Default").append(SEP);
		sb.append("Stato").append(SEP);
		sb.append("Descrizione").append(SEP).append(N_LINE);
		
		DescribeSecurityGroupsResponseSchema elencoSG = computeserviceApi.v10NwsComputeservicesSecuritygroupDescribesecuritygroupsGet(elencoAccountId, // vpcIdN,
				null, // groupNameN
				null, // tagKeyN
				null, // ownerIdN
				null, // ownerIdN2
				null, // groupNameN2
				null, // groupIdN
				null, // groupIdN2
				null // groupIdN3
		);
		
		elencoSG.getDescribeSecurityGroupsResponse().getSecurityGroupInfo().forEach(sg -> sb.append(rigaSG(account.getAccount().getName(), divisione.getDivision().getName(), organizzazione.getOrganization().getName(), sg)));
		
		ExportCSV risposta = new ExportCSV();
		risposta.setFile(sb);
		risposta.setFilename(account.getAccount().getName()+"_SecurityGroups_"+LocalDate.now()+".csv");
		return risposta;
	}

	private String rigaSG(String acc , String div, String org, DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseSecurityGroupInfo sg) {
		StringBuilder sb = new StringBuilder();
		sg.getIpPermissions().forEach(regola -> sb.append(org).append(SEP).append(div).append(SEP).append(acc).append(SEP).append("Ingress").append(SEP).append(rigaRegola(regola)).append(" ").append(SEP).append(sg.getNvlState()).append(SEP).append(sg.getGroupDescription()).append(SEP).append(N_LINE));
		sg.getIpPermissionsEgress().forEach(regola -> sb.append(org).append(SEP).append(div).append(SEP).append(acc).append(SEP).append("Egress").append(SEP).append(rigaRegola(regola)).append(" ").append(SEP).append(sg.getNvlState()).append(SEP).append(sg.getGroupDescription()).append(SEP).append(N_LINE));
		return sb.toString();
	}

	private String rigaRegola(DescribeSecurityGroupsResponseSchemaDescribeSecurityGroupsResponseIpPermissions regola) {
		StringBuilder sb = new StringBuilder ();
		regola.getIpRanges().forEach(cidr -> sb.append(cidr.getCidrIp()));
		sb.append(SEP);
		sb.append("-1".equals(regola.getIpProtocol())? "<non specificato>" : regola.getIpProtocol()).append(SEP);
		sb.append(regola.getFromPort()).append(SEP);
		sb.append(regola.getToPort()).append(SEP);
		return sb.toString();
	}
	
	/**
	 * Estrazione dell'elenco VM per un account
	 * @param accountId
	 * @return
	 * @throws BusinessException
	 */
	public ExportCSV estrazioneVmAccount(String accountId) throws BusinessException {
		List<String> elencoAccountId = new ArrayList<String>(1);
		elencoAccountId.add(accountId);
		StringBuilder sb = new StringBuilder();
		GetAccountResponseSchema account = authorityApi.v10NwsAccountsOidGet(elencoAccountId.get(0));
		GetDivisionResponseSchema divisione = authorityApi.v10NwsDivisionsOidGet(account.getAccount().getDivisionId());
		GetOrganizationResponseSchema organizzazione = authorityApi.v10NwsOrganizationsOidGet(divisione.getDivision().getOrganizationId());
		
		sb.append("Organizzazione").append(SEP);
		sb.append("Divisione").append(SEP);
		sb.append("Account").append(SEP);
		sb.append("Nome VM").append(SEP);
		sb.append("Region / A.Z.").append(SEP);
		sb.append("CPU").append(SEP);
		sb.append("RAM").append(SEP);
		sb.append("Disco").append(SEP);
		sb.append("Tags").append(SEP);
		sb.append("Sistema Operativo").append(SEP);
		sb.append("Ip Assegnato").append(SEP);
		sb.append("Stato").append(SEP);
		sb.append("Descrizione").append(SEP);
		sb.append("Security Group di appartenenza").append(SEP).append(N_LINE);
		
		DescribeInstancesApiResponseSchema rispostaVM = computeserviceApi.v10NwsComputeservicesInstanceDescribeinstancesGet
				(-1, null, elencoAccountId, null, null, null, null, null, null, null, null, null, null, null);
		
		
		rispostaVM.getDescribeInstancesResponse().getReservationSet().get(0).getInstancesSet().forEach(vm -> { 
			sb.append(organizzazione.getOrganization().getName()).append(SEP).append(divisione.getDivision().getName()).append(SEP).append(account.getAccount().getName()).append(SEP)
			.append(rigaVm(vm));
		});
		

		ExportCSV risposta = new ExportCSV();
		risposta.setFile(sb);
		risposta.setFilename(account.getAccount().getName()+"_VM_"+LocalDate.now()+".csv");
		return risposta;
	}

	private StringBuilder rigaVm(DescribeInstancesApiResponseSchemaDescribeInstancesResponseInstancesSet vm) {
		StringBuilder sb = new StringBuilder ();
		sb.append(vm.getNvlName()).append(SEP);
		sb.append(vm.getNvlSubnetName()).append(SEP);
		sb.append(vm.getNvlInstanceTypeExt().getVcpus()).append(SEP);
		sb.append(vm.getNvlInstanceTypeExt().getMemory()).append(SEP);
		Long diskSize = 0L;
		if (vm.getBlockDeviceMapping() != null)
			diskSize = vm.getBlockDeviceMapping().stream().mapToLong(disco -> disco.getEbs().getVolumeSize()).sum();
		sb.append(diskSize).append(SEP);
		vm.getTagSet().forEach(tag -> sb.append(tag.getValue()));
		sb.append(SEP);
		
		ArrayList<String> immagini = new ArrayList<String>(1);
		immagini.add(vm.getImageId());
		DescribeImagesResponseSchema rispostaImg = computeserviceApi.v10NwsComputeservicesImageDescribeimagesGet(immagini, null, null, null, null, null, -1, null);
		sb.append(rispostaImg.getDescribeImagesResponse().getImagesSet().get(0).getDescription()).append(SEP);
		sb.append(vm.getPrivateIpAddress()).append(SEP);
		sb.append((vm.getInstanceState()!= null && vm.getInstanceState().getName() != null) ? vm.getInstanceState().getName().getValue() : " ").append(SEP);
		sb.append(" ").append(SEP);
		vm.getGroupSet().forEach(group -> sb.append(group.getGroupName() + "  "));
		sb.append(SEP).append(N_LINE);
		
		/*List<String> idSubnetFiltro = new ArrayList<>(1);
		idSubnetFiltro.add(vm.getSubnetId());
		DescribeSubnetsResponseSchema rispostaSubnet = computeserviceApi.v10NwsComputeservicesSubnetDescribesubnetsGet(
				null, // vpcIdN,
				null, // vpcIdN2,
				null, // tagKeyN,
				null, // stateN,
				idSubnetFiltro, // subnetIdN,
				null, // ownerIdN,
				null, // subnetIdN2,
				null // subnetIdN3
		);
		sb.append(rispostaSubnet.getDescribeSubnetsResponse().getSubnetSet().get(0).getAvailabilityZone());*/
		
		return sb;
	}
	
	/**
	 * Estrazione di tutte le risorse DB per un account
	 * @param accountId
	 * @return
	 * @throws BusinessException
	 */
	public ExportCSV estrazioneDatabaseAccount(String accountId) throws BusinessException {
		List<String> elencoAccountId = new ArrayList<String>(1);
		elencoAccountId.add(accountId);
		StringBuilder sb = new StringBuilder();
		GetAccountResponseSchema account = authorityApi.v10NwsAccountsOidGet(elencoAccountId.get(0));
		GetDivisionResponseSchema divisione = authorityApi.v10NwsDivisionsOidGet(account.getAccount().getDivisionId());
		GetOrganizationResponseSchema organizzazione = authorityApi.v10NwsOrganizationsOidGet(divisione.getDivision().getOrganizationId());
		
		sb.append("Organizzazione").append(SEP);
		sb.append("Divisione").append(SEP);
		sb.append("Account").append(SEP);
		sb.append("Nome").append(SEP);
		sb.append("Region - A.Z.").append(SEP);
		sb.append("DB Engine").append(SEP);
 		sb.append("Classe Istanza").append(SEP);
 		sb.append("CPU").append(SEP);
 		sb.append("RAM").append(SEP);
 		sb.append("Storage").append(SEP);
 		sb.append("Stato").append(SEP).append(N_LINE);
 		
		DescribeDBInstancesV2ResponseSchema rispostaDb = databaseserviceApi.v20NwsDatabaseservicesInstanceDescribedbinstancesGet(elencoAccountId, null, null, null, -1, null, null);
		DescribeDBInstanceTypesApiV2ResponseSchema rispostaTipo = databaseserviceApi.v20NwsDatabaseservicesInstanceDescribedbinstancetypesGet(elencoAccountId.get(0), -1, null, null);
		
		rispostaDb.getDescribeDBInstancesResponse().getDescribeDBInstancesResult().getDbInstances().forEach(db -> { 
			sb.append(organizzazione.getOrganization().getName()).append(SEP).append(divisione.getDivision().getName()).append(SEP).append(account.getAccount().getName()).append(SEP)
			.append(rigaDb(db, rispostaTipo));
		});
 		
 		ExportCSV risposta = new ExportCSV();
		risposta.setFile(sb);
		risposta.setFilename(account.getAccount().getName()+"_Database_"+LocalDate.now()+".csv");
		return risposta;
	}

	private StringBuilder rigaDb(DescribeDBInstancesV2ResponseSchemaDescribeDBInstancesResponseDescribeDBInstancesResultDBInstances db, DescribeDBInstanceTypesApiV2ResponseSchema rispostaTipo) {
		
		StringBuilder riga = new StringBuilder();
		riga.append(db.getDbInstance().getDbName()).append(SEP);
		riga.append(db.getDbInstance().getAvailabilityZone()).append(SEP);
		riga.append(db.getDbInstance().getEngine() + " " + db.getDbInstance().getEngineVersion()).append(SEP);
		riga.append(db.getDbInstance().getDbInstanceClass()).append(SEP);
		
		for (DescribeDBInstanceTypesApiResponseSchemaDescribeDBInstanceTypesResponseInstanceTypesSet singoloTipo : rispostaTipo.getDescribeDBInstanceTypesResponse().getInstanceTypesSet()) {
			if (singoloTipo.getName().equals(db.getDbInstance().getDbInstanceClass())) {
				if (singoloTipo.getFeatures() != null) {
					riga.append(singoloTipo.getFeatures().getVcpus()).append(SEP);
					riga.append(singoloTipo.getFeatures().getRam().replace("GB", "")).append(SEP);
				}	
			}
		}
		riga.append(db.getDbInstance().getAllocatedStorage()).append(SEP);
		riga.append(db.getDbInstance().getDbInstanceStatus()).append(SEP).append(N_LINE);
		return riga;
	}
	
	
	/**
	 * Estrazione di tutte le risorse Share per un account FIXME: da completare
	 * @param accountId
	 * @return
	 * @throws BusinessException
	 */
	public ExportCSV estrazioneStorageAccount(String accountId) throws BusinessException {
		List<String> elencoAccountId = new ArrayList<String>(1);
		elencoAccountId.add(accountId);
		StringBuilder sb = new StringBuilder();
		GetAccountResponseSchema account = authorityApi.v10NwsAccountsOidGet(elencoAccountId.get(0));
		GetDivisionResponseSchema divisione = authorityApi.v10NwsDivisionsOidGet(account.getAccount().getDivisionId());
		GetOrganizationResponseSchema organizzazione = authorityApi.v10NwsOrganizationsOidGet(divisione.getDivision().getOrganizationId());
		
		sb.append("Organizzazione").append(SEP);
		sb.append("Divisione").append(SEP);
		sb.append("Account").append(SEP);
		sb.append("Nome").append(SEP);
		sb.append("Dimensione").append(SEP);
		sb.append("Data creazione").append(SEP);
		/*sb.append("Protocollo").append(SEP);
		sb.append("Indirizzo ip").append(SEP);
		sb.append("Mount target").append(SEP);*/
		sb.append("Stato").append(SEP).append(N_LINE);


		DescribeFileSystemsResponseSchema rispostaShare = storageserviceApi.v10NwsStorageservicesEfsFileSystemsGet(elencoAccountId, null, null, -1, null);
		
		DescribeMountTargetsResponseSchema rispostamount = storageserviceApi.v10NwsStorageservicesEfsMountTargetsGet(elencoAccountId, null, -1, null);
		List<DescribeMountTargetsResponseSchemaMountTargets> elencoMountAccount = rispostamount.getMountTargets();
		
		rispostaShare.getFileSystems().forEach(share -> sb.append(rigaShare(organizzazione, divisione, account, share, elencoMountAccount)));
		
		ExportCSV risposta = new ExportCSV();
		risposta.setFile(sb);
		risposta.setFilename(account.getAccount().getName()+"_Storage_"+LocalDate.now()+".csv");
		return risposta;
	}
	
	private StringBuilder rigaShare(GetOrganizationResponseSchema organizzazione, GetDivisionResponseSchema divisione, GetAccountResponseSchema account, DescribeFileSystemsResponseSchemaFileSystems share, List<DescribeMountTargetsResponseSchemaMountTargets> elencoMountAccount) {
		StringBuilder riga = new StringBuilder();
		
		riga.append(organizzazione.getOrganization().getName()).append(SEP);
		riga.append(divisione.getDivision().getName()).append(SEP);
		riga.append(account.getAccount().getName()).append(SEP);
		riga.append(share.getName()).append(SEP);
		riga.append(share.getSizeInBytes().getValue().divide(BigDecimal.valueOf(1024)).divide(BigDecimal.valueOf(1024)).divide(BigDecimal.valueOf(1024)) + " GB").append(SEP);
		riga.append(share.getCreationTime()).append(SEP);
		riga.append(share.getLifeCycleState()).append(SEP).append(N_LINE);
		/*List<DescribeMountTargetsResponseSchemaMountTargets> elencoMountShare = elencoMountAccount.parallelStream().filter(
						mount -> mount.getFileSystemId().equals(share.getFileSystemId())).collect(Collectors.toList());*/
		
		return riga;
	}
	
	/**
	 * Elenco dei volumi di un account
	 * @param accountId
	 * @return
	 * @throws BusinessException
	 */
	public ExportCSV estrazioneVolumiAccount(String accountId) throws BusinessException {
		List<String> elencoAccountId = new ArrayList<String>(1);
		elencoAccountId.add(accountId);
		StringBuilder sb = new StringBuilder();
		GetAccountResponseSchema account = authorityApi.v10NwsAccountsOidGet(elencoAccountId.get(0));
		GetDivisionResponseSchema divisione = authorityApi.v10NwsDivisionsOidGet(account.getAccount().getDivisionId());
		GetOrganizationResponseSchema organizzazione = authorityApi.v10NwsOrganizationsOidGet(divisione.getDivision().getOrganizationId());
		
		sb.append("Organizzazione").append(SEP);
		sb.append("Divisione").append(SEP);
		sb.append("Account").append(SEP);
		sb.append("Nome Volume").append(SEP);
		sb.append("Dimensione").append(SEP);
		sb.append("Availability Zone").append(SEP);
		sb.append("Data creazione").append(SEP);
		sb.append("Hypervisor").append(SEP);
		sb.append("Stato").append(SEP).append(N_LINE);
		
		DescribeVolumesApiResponseSchema rispostaElencoVolumi = computeserviceApi.v20NwsComputeservicesVolumeDescribevolumesGet(-1, // maxResults,
				null, // nextToken,
				elencoAccountId, // ownerIdN,
				null, // nvlNameN,
				null, // volumeIdN,
				null, // volumeIdN2,
				null, // volumeTypeN,
				null, // statusN,
				null, // tagKeyN,
				null, // createTimeN,
				null // attachmentN
		);
		
		rispostaElencoVolumi.getDescribeVolumesResponse().getVolumesSet().forEach(volume -> sb.append(rigaVolume(organizzazione, divisione, account, volume)));

		ExportCSV risposta = new ExportCSV();
		risposta.setFile(sb);
		risposta.setFilename(account.getAccount().getName()+"_Volumi_"+LocalDate.now()+".csv");
		return risposta;
	}

	private StringBuilder rigaVolume(GetOrganizationResponseSchema organizzazione, GetDivisionResponseSchema divisione, GetAccountResponseSchema account, DescribeVolumesApiResponseSchemaDescribeVolumesResponseVolumesSet volume) {
		StringBuilder riga = new StringBuilder();
		
		riga.append(organizzazione.getOrganization().getName()).append(SEP);;
		riga.append(divisione.getDivision().getName()).append(SEP);;
		riga.append(account.getAccount().getName()).append(SEP);;
		riga.append(volume.getNvlName()).append(SEP);;
		riga.append(volume.getSize()+ " GB").append(SEP);
		riga.append(volume.getAvailabilityZone()).append(SEP);;
		riga.append(volume.getCreateTime()).append(SEP);
		riga.append(volume.getNvlHypervisor()).append(SEP);
		riga.append(volume.getStatus()).append(SEP).append(N_LINE);
		
		return riga;
	}

	/**
	 * Elenco delle snapshots
	 * @param accountId
	 * @return
	 * @throws BusinessException
	 */
	public ExportCSV estrazioneSnapshot(String accountId) throws BusinessException {
		List<String> elencoAccountId = new ArrayList<String>(1);
		elencoAccountId.add(accountId);
		StringBuilder sb = new StringBuilder();
		GetAccountResponseSchema account = authorityApi.v10NwsAccountsOidGet(elencoAccountId.get(0));
		GetDivisionResponseSchema divisione = authorityApi.v10NwsDivisionsOidGet(account.getAccount().getDivisionId());
		GetOrganizationResponseSchema organizzazione = authorityApi.v10NwsOrganizationsOidGet(divisione.getDivision().getOrganizationId());
		
		sb.append("Organizzazione").append(SEP);
		sb.append("Divisione").append(SEP);
		sb.append("Account").append(SEP);
		sb.append("Vm Riferimento").append(SEP);
		sb.append("Identificativo Snapshot").append(SEP);
		sb.append("Nome snaposhot").append(SEP);
		sb.append("Data creazione snapshot").append(SEP);
		sb.append("Stato snapshot").append(SEP);
		
		DescribeInstancesApiResponseSchema rispostaElencoVM = computeserviceApi.v10NwsComputeservicesInstanceDescribeinstancesGet
				(-1, null, elencoAccountId, null, null, null, null, null, null, null, null, null, null, null);
		
		
		rispostaElencoVM.getDescribeInstancesResponse().getReservationSet().get(0).getInstancesSet().forEach(vm -> estrazioneSnapshotVm(vm, sb, organizzazione.getOrganization().getName(), 
				divisione.getDivision().getName(), account));
		
		ExportCSV risposta = new ExportCSV();
		risposta.setFile(sb);
		risposta.setFilename(account.getAccount().getName()+"_VM_"+LocalDate.now()+".csv");
		return risposta;
	}

	private void estrazioneSnapshotVm(DescribeInstancesApiResponseSchemaDescribeInstancesResponseInstancesSet vm, StringBuilder sb, String nomeOrg, String nomeDiv, GetAccountResponseSchema account) {
	
		ArrayList<String> elencoIdVm = new ArrayList<String>(1);
		elencoIdVm.add(vm.getInstanceId());
		List<String> elencoAccountId = new ArrayList<String>(1);
		elencoAccountId.add(account.getAccount().getUuid());
		DescribeInstanceSnapshotsApiResponseSchema rispostaSnapshot = computeserviceApi.v10NwsComputeservicesInstanceDescribeinstancesnapshotsGet(elencoIdVm, elencoAccountId);
		
		rispostaSnapshot.getDescribeInstanceSnapshotsResponse().getInstancesSet().forEach(elencoSnapVm ->  {
			sb.append(rigaSnapshot(elencoSnapVm, nomeOrg, nomeDiv, account, vm));
		});
	}

	private StringBuilder rigaSnapshot(DescribeInstanceSnapshotsApiResponseSchemaDescribeInstanceSnapshotsResponseInstancesSet elencoSnapVm, String nomeOrg, String nomeDiv, GetAccountResponseSchema account, DescribeInstancesApiResponseSchemaDescribeInstancesResponseInstancesSet vm) {
		StringBuilder riga= new StringBuilder();
		elencoSnapVm.getSnapshots().forEach(snap -> {
			riga.append(nomeOrg).append(SEP).append(nomeDiv).append(SEP).append(account.getAccount().getName()).append(SEP).append(vm.getDnsName());
			riga.append(snap.getSnapshotId()).append(SEP).append(snap.getSnapshotName()).append(SEP).append(snap.getCreateTime()).append(SEP).append(snap.getSnapshotStatus()).append(N_LINE);
		});
		return riga;
	}
}
