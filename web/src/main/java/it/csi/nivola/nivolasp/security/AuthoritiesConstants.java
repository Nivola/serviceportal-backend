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
package it.csi.nivola.nivolasp.security;

/**
 * Costanti per le authorities di Spring Security
 */
public final class AuthoritiesConstants {
	public static final String SUPERADMIN = "ROLE_SUPERADMIN";
	public static final String BOADMIN = "ROLE_BOADMIN";
	public static final String BOMONITORING = "ROLE_BOMONITORING"; 
	public static final String ROLE_USER = "ROLE_Utente";
	public static final String ROLE_GUEST = "ROLE_Ospite";
	public static final String ANONYMOUS = "ROLE_Anonimo";
	
	public static final String ACCOUNT_VIEWER =  "ROLE_AccountViewerRole";
	public static final String ACCOUNT_OPERATOR = "ROLE_AccountOperatorRole";
	public static final String ACCOUNT_ADMIN =  "ROLE_AccountAdminRole";
	public static final String DIVISION_VIEWER = "ROLE_DivViewerRole";
	public static final String DIVISION_OPERATOR = "ROLE_DivOperatorRole";
	public static final String DIVISION_ADMIN = "ROLE_DivAdminRole";
	public static final String ORGANIZATION_VIEWER = "ROLE_OrgViewerRole";
	public static final String ORGANIZATION_OPERATOR = "ROLE_OrgOperatorRole";
	public static final String ORGANIZATION_ADMIN = "ROLE_OrgAdminRole";
}
