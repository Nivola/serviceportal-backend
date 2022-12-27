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

public class AnomaliaConnessioneDiRete extends AbstractBaseForm {

	private String ipHostFrom;
	
	private String ipHostTo;
	
	private String porta;

	public String getIpHostFrom() {
		return ipHostFrom;
	}

	public void setIpHostFrom(String ipHostFrom) {
		this.ipHostFrom = ipHostFrom;
	}

	public String getIpHostTo() {
		return ipHostTo;
	}

	public void setIpHostTo(String ipHostTo) {
		this.ipHostTo = ipHostTo;
	}

	public String getPorta() {
		return porta;
	}

	public void setPorta(String porta) {
		this.porta = porta;
	}
	
	@Override
	public void valida() throws BusinessException {
		super.valida();
		if (StringUtils.isEmpty(ipHostFrom)) {
			throw new BusinessException("Campo mancante: ip host from");
		}
		if (StringUtils.isEmpty(ipHostTo)) {
			throw new BusinessException("Campo mancante: ip host to");
		}
		if (StringUtils.isEmpty(porta)) {
			throw new BusinessException("Campo mancante: porta");
		}
	}
	
	@Override
	public String componiTestoDaParametri() {
		StringBuilder testo = new StringBuilder(super.componiTestoDaParametri());
		testo.append("\nIP Host From: ").append(ipHostFrom)
			.append("\nIP Host TO: ").append(ipHostTo)
			.append("\nPorta: ").append(porta)
			.append("\n");
		return testo.toString();
	}
}
