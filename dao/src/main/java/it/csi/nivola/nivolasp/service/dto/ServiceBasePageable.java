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

public class ServiceBasePageable extends  ServiceBaseResponse{

	protected long nPagineTotali;
	protected long nPaginaCorrente;
	protected long nElementi;
	public long getnPagineTotali() {
		return nPagineTotali;
	}
	public void setnPagineTotali(long nPagineTotali) {
		this.nPagineTotali = nPagineTotali;
	}
	public long getnPaginaCorrente() {
		return nPaginaCorrente;
	}
	public void setnPaginaCorrente(long nPaginaCorrente) {
		this.nPaginaCorrente = nPaginaCorrente;
	}
	public long getnElementi() {
		return nElementi;
	}
	public void setnElementi(long nElementi) {
		this.nElementi = nElementi;
	}

}
