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

public class StorageAsService extends AbstractBaseForm {

	private String mountPoint = "";
	
	private String dimensione = "";

	private String vm;
	
	@Override
	public void valida() throws BusinessException {
		super.valida();
		if (StringUtils.isEmpty(mountPoint)) {
			throw new BusinessException("campo Obbligatorio: mount point");
		}
		if (StringUtils.isEmpty(dimensione)) {
			throw new BusinessException("campo Obbligatorio: dimensione");
		}
	}

	@Override
	public String componiTestoDaParametri() {
		StringBuilder sb = new StringBuilder(super.componiTestoDaParametri());
			sb.append("\nMount point: ").append(mountPoint);
			sb.append("\nDimensione: ").append(dimensione);
			sb.append("\nVM: ").append(vm);
			
		return sb.toString();
	}

	public String getMountPoint() {
		return mountPoint;
	}

	public void setMountPoint(String mountPoint) {
		this.mountPoint = mountPoint;
	}

	public String getDimensione() {
		return dimensione;
	}

	public void setDimensione(String dimensione) {
		this.dimensione = dimensione;
	}

	public String getVm() {
		return vm;
	}

	public void setVm(String vm) {
		this.vm = vm;
	}

}
