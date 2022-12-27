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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class RendicontoServiceResponse  extends ServiceBasePageable{

	private List<RendicontoDTO> rendiconti;
	private ValutaDTO valuta;

	public List<RendicontoDTO> getRendiconti() {
		return rendiconti;
	}

	public void setRendiconti(List<RendicontoDTO> rendiconti) {
		this.rendiconti = rendiconti;
	}

	public ValutaDTO getValuta() {
		return valuta;
	}

	public void setValuta(ValutaDTO valuta) {
		this.valuta = valuta;
	}

}
