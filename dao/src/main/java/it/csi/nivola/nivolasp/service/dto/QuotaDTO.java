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

public class QuotaDTO  implements Serializable {

	private static final long serialVersionUID = -6733148092483345848L;
	
	private Integer limite;
	
	private Integer usato;
	
	public Integer getLimite() {
		return limite;
	}
	public void setLimite(Integer limite) {
		this.limite = limite;
	}
	public Integer getUsato() {
		return usato;
	}
	public void setUsato(Integer usato) {
		this.usato = usato;
	}
	
	
}
