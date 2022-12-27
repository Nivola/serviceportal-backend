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

public class VariazioneRisorseVm extends AbstractBaseForm {

	private String nomeVm = "";
	
	private String risorse = "";
	
	private String dimensione = "";
	
	@Override
	public void valida() throws BusinessException {
		super.valida();
		if (StringUtils.isEmpty(nomeVm)) {
			throw new BusinessException("campo Obbligatorio: nome VM");
		}
		if (StringUtils.isEmpty(dimensione)) {
			throw new BusinessException("campo Obbligatorio: dimensione");
		}
		if (StringUtils.isEmpty(risorse)) {
			throw new BusinessException("campo Obbligatorio: risorse");
		}
	}

	@Override
	public String componiTestoDaParametri() {
		StringBuilder sb = new StringBuilder(super.componiTestoDaParametri());
			sb.append("\nNome VM: ").append(nomeVm);
			sb.append("\nRisorse: ").append(risorse);
			sb.append("\nDimensione: ").append(dimensione);
			
		return sb.toString();
	}

	public String getNomeVm() {
		return nomeVm;
	}

	public void setNomeVm(String nomeVm) {
		this.nomeVm = nomeVm;
	}

	public String getRisorse() {
		return risorse;
	}

	public void setRisorse(String risorse) {
		this.risorse = risorse;
	}

	public String getDimensione() {
		return dimensione;
	}

	public void setDimensione(String dimensione) {
		this.dimensione = dimensione;
	}

	
}
