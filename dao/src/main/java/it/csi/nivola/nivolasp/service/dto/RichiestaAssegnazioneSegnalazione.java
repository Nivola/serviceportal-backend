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

import java.sql.Date;

public class RichiestaAssegnazioneSegnalazione {
	
	private Long idRichiesta;
	
	private Long idUtenteAssegnatario;
	
	private Date dataInizioValidita;
	
	private Date dataFineValidita;

	
	
	
	public Long getIdRichiesta() {
		return idRichiesta;
	}

	public void setIdRichiesta(Long idRichiesta) {
		this.idRichiesta = idRichiesta;
	}

	public Long getIdUtenteAssegnatario() {
		return idUtenteAssegnatario;
	}

	public void setIdUtenteAssegnatario(Long idUtenteAssegnatario) {
		this.idUtenteAssegnatario = idUtenteAssegnatario;
	}

	public Date getDataInizioValidita() {
		return dataInizioValidita;
	}

	public void setDataInizioValidita(Date dataInizioValidita) {
		this.dataInizioValidita = dataInizioValidita;
	}

	public Date getDataFineValidita() {
		return dataFineValidita;
	}

	public void setDataFineValidita(Date dataFineValidita) {
		this.dataFineValidita = dataFineValidita;
	}
	
	
	
    
    
}
