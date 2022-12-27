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
package it.csi.nivola.nivolasp.service.dto;

public class AbilitazioneDTO extends AbstractDTO {
	
	private static final long serialVersionUID = 3077807853568343399L;
	
	private int id;
	private String accountDesc; 
	private String accountId; 
	private String accountName; 
	private String accountUuid; 
	private String catalogDesc; 
	private String catalogId; 
	private String catalogName; 
	private String catalogUuid; 
	private String divDesc; 
	private String divId;
	private String divName; 
	private String divUuid; 
	private String orgDesc;
	private String orgId;
	private String orgName;
	private String orgUuid;
	private String userRole;
	private String userRoleDescription;
	private boolean provenienteDaCmp = true;
	
	
	public String getAccountDesc() {
		return accountDesc;
	}
	public void setAccountDesc(String accountDesc) {
		this.accountDesc = accountDesc;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountUuid() {
		return accountUuid;
	}
	public void setAccountUuid(String accountUuid) {
		this.accountUuid = accountUuid;
	}
	public String getCatalogDesc() {
		return catalogDesc;
	}
	public void setCatalogDesc(String catalogDesc) {
		this.catalogDesc = catalogDesc;
	}
	public String getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}
	public String getCatalogName() {
		return catalogName;
	}
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}
	public String getCatalogUuid() {
		return catalogUuid;
	}
	public void setCatalogUuid(String catalogUuid) {
		this.catalogUuid = catalogUuid;
	}
	public String getDivDesc() {
		return divDesc;
	}
	public void setDivDesc(String divDesc) {
		this.divDesc = divDesc;
	}
	public String getDivId() {
		return divId;
	}
	public void setDivId(String divId) {
		this.divId = divId;
	}
	public String getDivName() {
		return divName;
	}
	public void setDivName(String divName) {
		this.divName = divName;
	}
	public String getDivUuid() {
		return divUuid;
	}
	public void setDivUuid(String divUuid) {
		this.divUuid = divUuid;
	}
	public String getOrgDesc() {
		return orgDesc;
	}
	public void setOrgDesc(String orgDesc) {
		this.orgDesc = orgDesc;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgUuid() {
		return orgUuid;
	}
	public void setOrgUuid(String orgUuid) {
		this.orgUuid = orgUuid;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getUserRoleDescription() {
		return userRoleDescription;
	}
	public void setUserRoleDescription(String userRoleDescription) {
		this.userRoleDescription = userRoleDescription;
	}
	public boolean isProvenienteDaCmp() {
		return provenienteDaCmp;
	}
	public void setProvenienteDaCmp(boolean provenienteDaCmp) {
		this.provenienteDaCmp = provenienteDaCmp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
