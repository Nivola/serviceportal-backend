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
package it.csi.nivola.nivolasp.service.dto.form;

import org.springframework.util.StringUtils;

import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.service.dto.AbstractBaseForm;

public class AnomaliaServicePortal extends AbstractBaseForm {

	private String ambitoDiIntervento = "";

	@Override
	public void valida() throws BusinessException {
		super.valida();
		if (StringUtils.isEmpty(ambitoDiIntervento)) {
			throw new BusinessException("campo Obbligatorio: ambitoDiIntervento");
		}
	}

	@Override
	public String componiTestoDaParametri() {
		return super.componiTestoDaParametri() + "\nAmbito di intervento: " + ambitoDiIntervento;
	}

	public String getAmbitoDiIntervento() {
		return ambitoDiIntervento;
	}

	public void setAmbitoDiIntervento(String ambitoDiIntervento) {
		this.ambitoDiIntervento = ambitoDiIntervento;
	}
}
