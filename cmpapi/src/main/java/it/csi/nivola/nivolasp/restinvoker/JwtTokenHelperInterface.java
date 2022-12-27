/*-
 * ========================LICENSE_START=================================
 * Api CMP
 * %%
 * Copyright (C) 2022 CSI Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | CSI Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.restinvoker;

public interface JwtTokenHelperInterface {
	
	
	/*
	 * Invoca il servizio di generazione del token usando JWT come Authorization
	 * Grant (2.1 RFC 7523)
	 */
	public AccessTokenResponse retreiveAccessTokenJwt(String path, boolean refresh);
	
	//public void logInvocazioneCmp(HttpRequest request, byte[] body, ClientHttpResponse response);

	public String getBasePath();
	
}
