/*-
 * ========================LICENSE_START=================================
 * Api Remedy
 * %%
 * Copyright (C) 2022 Regione Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | Regione Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.integration.remedy.token;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import it.csi.nivola.nivolasp.integration.remedy.invoker.ClientCredentialsHelper;
import it.csi.nivola.nivolasp.integration.remedy.service.AbstractTest;

public class GenerazioneTokenTest extends AbstractTest {
	@Autowired
	public ClientCredentialsHelper generazioneToken;
	
	@Test
	public void getToken() {
		log.debug(generazioneToken.richiediToken());
	}

}
