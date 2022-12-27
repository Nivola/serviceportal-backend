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
package it.csi.nivola.nivolasp.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the sp_rendiconto database table.
 * 
 */
@Entity
@Table(name="sp_rendiconto")
//@NamedQuery(name="SpRendiconto.findAll", query="SELECT s FROM SpRendiconto s")
public class SpRendiconto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="data_cancellazione")
	private Timestamp dataCancellazione;

	@Column(name="data_creazione")
	private Timestamp dataCreazione;

	@Column(name="data_modifica")
	private Timestamp dataModifica;

	@Column(name="data_rendiconto_a")
	private Date dataRendicontoA;

	@Column(name="data_rendiconto_da")
	private Date dataRendicontoDa;

	private String descrizione;

	@Column(name="id_account")
	private String idAccount;

	@Column(name="id_divisione")
	private String idDivisione;

	@Column(name="id_organizzazione")
	private String idOrganizzazione;

	private Double importo;

	private String nota;
	
	private Integer anno;
	
	private Integer mese;
	
	@Column(name="url_file")
	private String urlFile;


	@Lob
	private byte[] report;
	
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_rendiconto")
    private SpDTipoRendiconto tipoRendiconto;

	//bi-directional many-to-one association to SpRendicontoServizio
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy="spRendiconto")
	private List<SpRendicontoServizio> spRendicontoServizios;


	public SpRendiconto() {
		
	}
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getDataCancellazione() {
		return this.dataCancellazione;
	}

	public void setDataCancellazione(Timestamp dataCancellazione) {
		this.dataCancellazione = dataCancellazione;
	}

	public Timestamp getDataCreazione() {
		return this.dataCreazione;
	}

	public void setDataCreazione(Timestamp dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Timestamp getDataModifica() {
		return this.dataModifica;
	}

	public void setDataModifica(Timestamp dataModifica) {
		this.dataModifica = dataModifica;
	}

	public Date getDataRendicontoA() {
		return this.dataRendicontoA;
	}

	public void setDataRendicontoA(Date dataRendicontoA) {
		this.dataRendicontoA = dataRendicontoA;
	}

	public Date getDataRendicontoDa() {
		return this.dataRendicontoDa;
	}

	public void setDataRendicontoDa(Date dataRendicontoDa) {
		this.dataRendicontoDa = dataRendicontoDa;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getIdAccount() {
		return this.idAccount;
	}

	public void setIdAccount(String idAccount) {
		this.idAccount = idAccount;
	}

	public String getIdDivisione() {
		return this.idDivisione;
	}

	public void setIdDivisione(String idDivisione) {
		this.idDivisione = idDivisione;
	}

	public String getIdOrganizzazione() {
		return this.idOrganizzazione;
	}

	public void setIdOrganizzazione(String idOrganizzazione) {
		this.idOrganizzazione = idOrganizzazione;
	}

	public Double getImporto() {
		return this.importo;
	}

	public void setImporto(Double importo) {
		this.importo = importo;
	}

	public String getNota() {
		return this.nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public byte[] getReport() {
		return this.report;
	}

	public void setReport(byte[] report) {
		this.report = report;
	}


	public List<SpRendicontoServizio> getSpRendicontoServizios() {
		return this.spRendicontoServizios;
	}

	public void setSpRendicontoServizios(List<SpRendicontoServizio> spRendicontoServizios) {
		this.spRendicontoServizios = spRendicontoServizios;
	}
	

	public SpDTipoRendiconto getTipoRendiconto() {
		return tipoRendiconto;
	}

	public void setTipoRendiconto(SpDTipoRendiconto tipoRendiconto) {
		this.tipoRendiconto = tipoRendiconto;
	}

	public SpRendicontoServizio addSpRendicontoServizio(SpRendicontoServizio spRendicontoServizio) {
		getSpRendicontoServizios().add(spRendicontoServizio);
		spRendicontoServizio.setSpRendiconto(this);

		return spRendicontoServizio;
	}

	public SpRendicontoServizio removeSpRendicontoServizio(SpRendicontoServizio spRendicontoServizio) {
		getSpRendicontoServizios().remove(spRendicontoServizio);
		spRendicontoServizio.setSpRendiconto(null);

		return spRendicontoServizio;
	}
	
	public String getUrlFile() {
		return urlFile;
	}


	public void setUrlFile(String urlFile) {
		this.urlFile = urlFile;
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
}
