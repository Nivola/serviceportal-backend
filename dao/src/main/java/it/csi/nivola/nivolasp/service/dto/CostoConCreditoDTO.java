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

import com.fasterxml.jackson.annotation.JsonProperty;

public class CostoConCreditoDTO extends CostoDTO {

	private static final long serialVersionUID = 2922282572285622317L;

	@JsonProperty("creditoResiduo")
	private Float creditRes = null;

	@JsonProperty("creditoTotale")
	private Float creditTot = null;

	public Float getCreditRes() {
		return creditRes;
	}

	public void setCreditRes(Float creditRes) {
		this.creditRes = creditRes;
	}

	public Float getCreditTot() {
		return creditTot;
	}

	public void setCreditTot(Float creditTot) {
		this.creditTot = creditTot;
	}

}
