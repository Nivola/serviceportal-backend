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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import it.csi.nivola.nivolasp.integration.rest.model.service.Error;

public class ServiceBaseResponse {
	@JsonInclude(Include.NON_NULL)
	protected Error error;

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}


}
