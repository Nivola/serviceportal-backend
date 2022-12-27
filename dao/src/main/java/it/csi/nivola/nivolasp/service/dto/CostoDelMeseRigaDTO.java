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
import java.math.BigDecimal;

public class CostoDelMeseRigaDTO implements Serializable {

	private static final long serialVersionUID = -950144153612092961L;

	private String nome;
	
	private String parametro;
	
	private Double costo = 0d;
	
	public CostoDelMeseRigaDTO() {
		
	}

	public CostoDelMeseRigaDTO(String nome, BigDecimal costo) {
		super();
		this.nome = nome;
		this.costo = costo.doubleValue();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}
	
	
}
