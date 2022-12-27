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

import java.util.Date;

import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.service.dto.AbstractBaseForm;

public class ProvisioningNuovoAccount extends AbstractBaseForm {
	Date dataPrevistaConsegna;
	
	
	@Override
	public void valida() throws BusinessException {
		super.valida();
	}

	@Override
	public String componiTestoDaParametri() {
		StringBuilder sb = new StringBuilder(super.componiTestoDaParametri());
		if (dataPrevistaConsegna != null)
			sb.append("\nData Prevista di consegna: ").append(dataPrevistaConsegna.toString());
		return sb.toString();
	}

	public Date getDataPrevistaConsegna() {
		return dataPrevistaConsegna;
	}

	public void setDataPrevistaConsegna(Date dataPrevistaConsegna) {
		this.dataPrevistaConsegna = dataPrevistaConsegna;
	}
	
}
