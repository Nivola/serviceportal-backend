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
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the sp_d_tipo_evento database table.
 * 
 */
@Entity
@Table(name="sp_d_tipo_evento")
@NamedQuery(name="SpDTipoEvento.findAll", query="SELECT s FROM SpDTipoEvento s")
public class SpDTipoEvento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="codice_evento")
	private String codiceEvento;

	@Column(name="descrizione_evento")
	private String descrizioneEvento;

	//bi-directional many-to-one association to SpMailRichiesta
	@OneToMany(mappedBy="spDTipoEvento")
	private List<SpMailRichiesta> spMailRichiestas;

	public SpDTipoEvento() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodiceEvento() {
		return this.codiceEvento;
	}

	public void setCodiceEvento(String codiceEvento) {
		this.codiceEvento = codiceEvento;
	}

	public String getDescrizioneEvento() {
		return this.descrizioneEvento;
	}

	public void setDescrizioneEvento(String descrizioneEvento) {
		this.descrizioneEvento = descrizioneEvento;
	}

	public List<SpMailRichiesta> getSpMailRichiestas() {
		return this.spMailRichiestas;
	}

	public void setSpMailRichiestas(List<SpMailRichiesta> spMailRichiestas) {
		this.spMailRichiestas = spMailRichiestas;
	}

	public SpMailRichiesta addSpMailRichiesta(SpMailRichiesta spMailRichiesta) {
		getSpMailRichiestas().add(spMailRichiesta);
		spMailRichiesta.setSpDTipoEvento(this);

		return spMailRichiesta;
	}

	public SpMailRichiesta removeSpMailRichiesta(SpMailRichiesta spMailRichiesta) {
		getSpMailRichiestas().remove(spMailRichiesta);
		spMailRichiesta.setSpDTipoEvento(null);

		return spMailRichiesta;
	}

}
