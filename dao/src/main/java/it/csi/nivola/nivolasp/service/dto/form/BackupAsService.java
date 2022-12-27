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

public class BackupAsService extends AbstractBaseForm {

	private String vm = "";
	
	private String periodoDiRitenzione = "";

	@Override
	public void valida() throws BusinessException {
		super.valida();
		if (StringUtils.isEmpty(vm)) {
			throw new BusinessException("campo Obbligatorio: ip/nome host della VM");
		}
		if (StringUtils.isEmpty(periodoDiRitenzione)) {
			throw new BusinessException("campo Obbligatorio: periodo di ritenzione");
		}
	}

	@Override
	public String componiTestoDaParametri() {
		return super.componiTestoDaParametri()+"\nip/nome host della VM: " + vm + "\nPeriodo di ritenzione: " + periodoDiRitenzione;
	}

	public String getVm() {
		return vm;
	}

	public void setVm(String vm) {
		this.vm = vm;
	}

	public String getPeriodoDiRitenzione() {
		return periodoDiRitenzione;
	}

	public void setPeriodoDiRitenzione(String periodoDiRitenzione) {
		this.periodoDiRitenzione = periodoDiRitenzione;
	}
	
	
}
