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

import java.sql.Timestamp;
import java.util.List;

public class ListinoDettaglioDTO extends AbstractDTO{

	private static final long serialVersionUID = 2362788881672545196L;

	private String id;

	private Timestamp dataCancellazione;

	private Timestamp dataCreazione;

	private Timestamp dataModifica;

	private String descrizione;

	private double qta;

	private String udm;

	private String voce;
	
	private String servizio;
	
	private Long idMetrica;
	
	private String idListino;
	
	private Double rangeMin;
	
	private Double rangeMax;
	
	private List<ListinoTipoPrezzoDTO> elencoPrezzo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getDataCancellazione() {
		return dataCancellazione;
	}

	public void setDataCancellazione(Timestamp dataCancellazione) {
		this.dataCancellazione = dataCancellazione;
	}

	public Timestamp getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Timestamp dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Timestamp getDataModifica() {
		return dataModifica;
	}

	public void setDataModifica(Timestamp dataModifica) {
		this.dataModifica = dataModifica;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getQta() {
		return qta;
	}

	public void setQta(double qta) {
		this.qta = qta;
	}

	public String getUdm() {
		return udm;
	}

	public void setUdm(String udm) {
		this.udm = udm;
	}

	public String getVoce() {
		return voce;
	}

	public void setVoce(String voce) {
		this.voce = voce;
	}

	public List<ListinoTipoPrezzoDTO> getElencoPrezzo() {
		return elencoPrezzo;
	}

	public void setElencoPrezzo(List<ListinoTipoPrezzoDTO> elencoPrezzo) {
		this.elencoPrezzo = elencoPrezzo;
	}

	public String getServizio() {
		return servizio;
	}

	public void setServizio(String servizio) {
		this.servizio = servizio;
	}

	public Long getIdMetrica() {
		return idMetrica;
	}

	public void setIdMetrica(Long idMetrica) {
		this.idMetrica = idMetrica;
	}

	public String getIdListino() {
		return idListino;
	}

	public void setIdListino(String idListino) {
		this.idListino = idListino;
	}

	public Double getRangeMin() {
		return rangeMin;
	}

	public void setRangeMin(Double rangeMin) {
		this.rangeMin = rangeMin;
	}

	public Double getRangeMax() {
		return rangeMax;
	}

	public void setRangeMax(Double rangeMax) {
		this.rangeMax = rangeMax;
	}
	
}
