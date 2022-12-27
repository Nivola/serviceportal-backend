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
package it.csi.nivola.nivolasp.integration.remedy.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import it.csi.nivola.nivolasp.integration.remedy.AppConfig;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppConfig.class)
@ActiveProfiles(profiles = "sandbox")
public class AbstractTest {

	protected Logger log;
	
	@Before
	public void preparaTest () {
		log = LoggerFactory.getLogger(this.getClass());
	}

	@Test
	public void test () {
		assert true;
	}
}
