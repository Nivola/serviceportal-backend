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

public class VerificaAssistenzaDto {
	
	private Integer idTenant;
	
	private String descrizioneTenant;
	
	private boolean accountConfiguratoRemedy = false;

	public Integer getIdTenant() {
		return idTenant;
	}

	public void setIdTenant(Integer idTenant) {
		this.idTenant = idTenant;
	}

	public String getDescrizioneTenant() {
		return descrizioneTenant;
	}

	public void setDescrizioneTenant(String descrizioneTenant) {
		this.descrizioneTenant = descrizioneTenant;
	}

	public boolean isAccountConfiguratoRemedy() {
		return accountConfiguratoRemedy;
	}

	public void setAccountConfiguratoRemedy(boolean accountConfiguratoRemedy) {
		this.accountConfiguratoRemedy = accountConfiguratoRemedy;
	}
	
	
	

}
