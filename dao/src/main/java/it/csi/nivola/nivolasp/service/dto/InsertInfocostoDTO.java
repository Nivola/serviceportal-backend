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
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO che rappresenta l'entità SPAccountInfocosto
 *
 */
public class InsertInfocostoDTO implements Serializable {
	
	private static final long serialVersionUID = 3326728099684325112L;

	private Long id;
	
	private String refAccount;

	private LocalDateTime dataCreazione;

	private LocalDate dataFineAssociazione;

	private LocalDate dataInizioAssociazione;

	private String usaListinoSpecifico;

	private String idListino;

	private String tipoListinoCodice;
	
	private String tipoListinoDescrizione;

	private String tipoPrezzoCodice;
	
	private String tipoPrezzoDescrizione;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRefAccount() {
		return refAccount;
	}

	public void setRefAccount(String refAccount) {
		this.refAccount = refAccount;
	}

	public LocalDateTime getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(LocalDateTime dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public LocalDate getDataFineAssociazione() {
		return dataFineAssociazione;
	}

	public void setDataFineAssociazione(LocalDate dataFineAssociazione) {
		this.dataFineAssociazione = dataFineAssociazione;
	}

	public LocalDate getDataInizioAssociazione() {
		return dataInizioAssociazione;
	}

	public void setDataInizioAssociazione(LocalDate dataInizioAssociazione) {
		this.dataInizioAssociazione = dataInizioAssociazione;
	}

	public String getUsaListinoSpecifico() {
		return usaListinoSpecifico;
	}

	public void setUsaListinoSpecifico(String usaListinoSpecifico) {
		this.usaListinoSpecifico = usaListinoSpecifico;
	}

	public String getIdListino() {
		return idListino;
	}

	public void setIdListino(String idListino) {
		this.idListino = idListino;
	}

	public String getTipoListinoCodice() {
		return tipoListinoCodice;
	}

	public void setTipoListinoCodice(String tipoListinoCodice) {
		this.tipoListinoCodice = tipoListinoCodice;
	}

	public String getTipoListinoDescrizione() {
		return tipoListinoDescrizione;
	}

	public void setTipoListinoDescrizione(String tipoListinoDescrizione) {
		this.tipoListinoDescrizione = tipoListinoDescrizione;
	}

	public String getTipoPrezzoCodice() {
		return tipoPrezzoCodice;
	}

	public void setTipoPrezzoCodice(String tipoPrezzoCodice) {
		this.tipoPrezzoCodice = tipoPrezzoCodice;
	}

	public String getTipoPrezzoDescrizione() {
		return tipoPrezzoDescrizione;
	}

	public void setTipoPrezzoDescrizione(String tipoPrezzoDescrizione) {
		this.tipoPrezzoDescrizione = tipoPrezzoDescrizione;
	}
	
	
	
	
	
}
