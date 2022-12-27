/*-
 * ========================LICENSE_START=================================
 * Nivola Web
 * %%
 * Copyright (C) 2022 CSI Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | CSI Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.web.rest.form;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import it.csi.nivola.nivolasp.service.dto.AbstractBaseForm;
import it.csi.nivola.nivolasp.service.dto.AllegatoRemedyDTO;
import it.csi.nivola.nivolasp.service.dto.RichiestaAssistenzaSintesiDTO;

/**
 * Trasferimento delle informazioni di un form con le informazioni sullo stato del ticket generato,
 * se inviato.
 * 
 */
public class StatoSegnalazione implements Serializable {
	
	private static final long serialVersionUID = -10311527613343274L;
	
	private RichiestaAssistenzaSintesiDTO datiSintesi;

	private AbstractBaseForm form;
	
	private String assegnatario;
	
	private String motivo;
	
	private String risoluzione;
	
	private String stato;
	
	private String tipologiaForm;
	
	private LocalDateTime updateDate = null;

	private LocalDateTime closeDate = null;

	private String operatorId = null;

	private String commento = null;
	
	private String riepilogoScelte;
	
	private List<AllegatoRemedyDTO> allegati;
	

	public AbstractBaseForm getForm() {
		return form;
	}

	public void setForm(AbstractBaseForm form) {
		this.form = form;
	}

	public String getAssegnatario() {
		return assegnatario;
	}

	public void setAssegnatario(String assegnatario) {
		this.assegnatario = assegnatario;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getRisoluzione() {
		return risoluzione;
	}

	public void setRisoluzione(String risoluzione) {
		this.risoluzione = risoluzione;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public RichiestaAssistenzaSintesiDTO getDatiSintesi() {
		return datiSintesi;
	}

	public void setDatiSintesi(RichiestaAssistenzaSintesiDTO datiSintesi) {
		this.datiSintesi = datiSintesi;
	}

	public String getTipologiaForm() {
		return tipologiaForm;
	}

	public void setTipologiaForm(String tipologiaForm) {
		this.tipologiaForm = tipologiaForm;
	}

	public List<AllegatoRemedyDTO> getAllegati() {
		return allegati;
	}

	public void setAllegati(List<AllegatoRemedyDTO> allegati) {
		this.allegati = allegati;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public LocalDateTime getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(LocalDateTime closeDate) {
		this.closeDate = closeDate;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getCommento() {
		return commento;
	}

	public void setCommento(String commento) {
		this.commento = commento;
	}

	public String getRiepilogoScelte() {
		return riepilogoScelte;
	}

	public void setRiepilogoScelte(String riepilogoScelte) {
		this.riepilogoScelte = riepilogoScelte;
	}
	
}
