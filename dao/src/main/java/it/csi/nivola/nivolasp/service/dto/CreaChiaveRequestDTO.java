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

public class CreaChiaveRequestDTO extends AbstractDTO {

	private static final long serialVersionUID = 8151535166733002559L;
	
	private String nome;
	private String tipo;
	private String chiaveDaImportare;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getChiaveDaImportare() {
		return chiaveDaImportare;
	}
	public void setChiaveDaImportare(String chiaveDaImportare) {
		this.chiaveDaImportare = chiaveDaImportare;
	}
}
