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

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatoUtilizzatoriDTO implements Serializable {

	private static final long serialVersionUID = 6367594499304143595L;
	
	private Integer totaleOrganizzazioni;
	private Integer totaleDivisioni;
	private Integer totaleAccount;
	private Long totaleUtenti;
	
	
	
	public Integer getTotaleOrganizzazioni() {
		return totaleOrganizzazioni;
	}
	public void setTotaleOrganizzazioni(Integer totaleOrganizzazioni) {
		this.totaleOrganizzazioni = totaleOrganizzazioni;
	}
	public Integer getTotaleDivisioni() {
		return totaleDivisioni;
	}
	public void setTotaleDivisioni(Integer totaleDivisioni) {
		this.totaleDivisioni = totaleDivisioni;
	}
	public Integer getTotaleAccount() {
		return totaleAccount;
	}
	public void setTotaleAccount(Integer totaleAccount) {
		this.totaleAccount = totaleAccount;
	}
	public Long getTotaleUtenti() {
		return totaleUtenti;
	}
	public void setTotaleUtenti(Long totaleUtenti) {
		this.totaleUtenti = totaleUtenti;
	}
	
	
	
	
}
