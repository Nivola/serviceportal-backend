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

import org.springframework.beans.factory.annotation.Autowired;

import it.csi.nivola.nivolasp.config.ApplicationProperties;

public abstract class AbstractResource {
	
	@Autowired
	ApplicationProperties applicationProperties;

	public ApplicationProperties getApplicationProperties() {
		return applicationProperties;
	}
}
