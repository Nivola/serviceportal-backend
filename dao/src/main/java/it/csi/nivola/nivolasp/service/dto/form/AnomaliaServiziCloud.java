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


import org.apache.commons.lang3.StringUtils;

import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.service.dto.AbstractBaseForm;

public class AnomaliaServiziCloud extends AbstractBaseForm {

	private String ambitoCloud = "";

	public String getAmbitoCloud() {
		return ambitoCloud;
	}

	public void setAmbitoCloud(String ambitoCloud) {
		this.ambitoCloud = ambitoCloud;
	}

	@Override
	public void valida() throws BusinessException {
		super.valida();
//		if (StringUtils.isEmpty(ambitoCloud)) {
//			throw new BusinessException("campo Obbligatorio: ambitoCloud");
//		}
	}

	@Override
	public String componiTestoDaParametri() {
		return super.componiTestoDaParametri() +  (StringUtils.isNotEmpty(ambitoCloud) ? "\nAmbito Cloud: " + ambitoCloud : "");
	}
	
	
}
