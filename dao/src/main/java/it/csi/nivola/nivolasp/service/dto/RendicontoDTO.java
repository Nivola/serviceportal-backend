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
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * A DTO representing a user, with his authorities.
 */
@JsonInclude(Include.NON_NULL)
public class RendicontoDTO implements Serializable  {
	/**
	 *
	 */
	private static final long serialVersionUID = -2440518384178398112L;
	private Timestamp dataCancellazione;
	private Timestamp dataCreazione;
	private Timestamp dataModifica;
	private Date dataRendicontoA;
	private Date dataRendicontoDa;
	private String descrizione;
	private Long id;
	private String idAccount;
	private String idDivisione;
	private String idOrganizzazione;
	private double importo;
	private String nota;
	private byte[] report;
	private TipoRendicontoDto tipoRendiconto;
	private String periodo;
	private String urlFile;
	private String urlFileDettaglio;
	private Integer anno;
	private Integer mese;
	private Long idDettaglio;

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
	public Date getDataRendicontoA() {
		return dataRendicontoA;
	}
	public void setDataRendicontoA(Date dataRendicontoA) {
		this.dataRendicontoA = dataRendicontoA;
	}
	public Date getDataRendicontoDa() {
		return dataRendicontoDa;
	}
	public void setDataRendicontoDa(Date dataRendicontoDa) {
		this.dataRendicontoDa = dataRendicontoDa;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdAccount() {
		return idAccount;
	}
	public void setIdAccount(String idAccount) {
		this.idAccount = idAccount;
	}
	public String getIdDivisione() {
		return idDivisione;
	}
	public void setIdDivisione(String idDivisione) {
		this.idDivisione = idDivisione;
	}
	public String getIdOrganizzazione() {
		return idOrganizzazione;
	}
	public void setIdOrganizzazione(String idOrganizzazione) {
		this.idOrganizzazione = idOrganizzazione;
	}
	public double getImporto() {
		return importo;
	}
	public void setImporto(double importo) {
		this.importo = importo;
	}
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	public byte[] getReport() {
		return report;
	}
	public void setReport(byte[] report) {
		this.report = report;
	}
	public TipoRendicontoDto getTipoRendiconto() {
		return tipoRendiconto;
	}
	public void setTipoRendiconto(TipoRendicontoDto tipoRendiconto) {
		this.tipoRendiconto = tipoRendiconto;
	}

	public String getPeriodo() {
		if(getDataRendicontoDa() != null){
			java.util.Date safeDate = new Date(dataRendicontoDa.getTime());
			LocalDateTime dataRendiconto = LocalDateTime.ofInstant(safeDate.toInstant(),ZoneId.systemDefault());
	    	StringBuilder sb = new StringBuilder();
	    	String mese  = DateTimeFormatter.ofPattern("MMMM").format(dataRendiconto);
	    	mese = mese.substring(0,1).toUpperCase() + mese.substring(1).toLowerCase();
	    	sb.append(mese);
	    	sb.append(" ");
	    	sb.append(DateTimeFormatter.ofPattern("yyyy").format(dataRendiconto));
	    	return sb.toString();
		}
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getUrlFile() {
		return urlFile;
	}
	public void setUrlFile(String urlFile) {
		this.urlFile = urlFile;
	}
	public String getUrlFileDettaglio() {
		return urlFileDettaglio;
	}
	public void setUrlFileDettaglio(String urlFileDettaglio) {
		this.urlFileDettaglio = urlFileDettaglio;
	}
	public Integer getAnno() {
		return anno;
	}
	public void setAnno(Integer anno) {
		this.anno = anno;
	}
	public Integer getMese() {
		return mese;
	}
	public void setMese(Integer mese) {
		this.mese = mese;
	}
	public Long getIdDettaglio() {
		return idDettaglio;
	}
	public void setIdDettaglio(Long idDettaglio) {
		this.idDettaglio = idDettaglio;
	}
}
