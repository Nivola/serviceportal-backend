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
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the sp_rendiconto_servizio database table.
 * 
 */
@Entity
@Table(name="sp_rendiconto_servizio")
//@NamedQuery(name="SpRendicontoServizio.findAll", query="SELECT s FROM SpRendicontoServizio s")
public class SpRendicontoServizio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="data_inserimento")
	private Timestamp dataInserimento;

	private BigDecimal importo;

	@Column(name="tipo_servizio")
	private String tipoServizio;

	//bi-directional many-to-one association to SpRendiconto
	@ManyToOne
	@JoinColumn(name="id_rendiconto")
	private SpRendiconto spRendiconto;

	public SpRendicontoServizio() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDataInserimento() {
		return this.dataInserimento;
	}

	public void setDataInserimento(Timestamp dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public BigDecimal getImporto() {
		return this.importo;
	}

	public void setImporto(BigDecimal importo) {
		this.importo = importo;
	}

	public String getTipoServizio() {
		return this.tipoServizio;
	}

	public void setTipoServizio(String tipoServizio) {
		this.tipoServizio = tipoServizio;
	}

	public SpRendiconto getSpRendiconto() {
		return this.spRendiconto;
	}

	public void setSpRendiconto(SpRendiconto spRendiconto) {
		this.spRendiconto = spRendiconto;
	}

}
