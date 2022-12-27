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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class MetricheServiceResponse  extends ServiceBasePageable{

	private List<MetricaDTO> metriche;

	public List<MetricaDTO> getMetriche() {
		return metriche;
	}

	public void setMetriche(List<MetricaDTO> metriche) {
		this.metriche = metriche;
	}

}
