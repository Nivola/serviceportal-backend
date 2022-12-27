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
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the sp_form_richieste database table.
 * 
 */
@Entity
@Table(name="sp_form_richieste")
@NamedQuery(name="SpFormRichieste.findAll", query="SELECT s FROM SpFormRichieste s")
public class SpFormRichieste implements Serializable {

	private static final long serialVersionUID = -9152807673431355275L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_inserimento")
	private Date dataInserimento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_invio")
	private Date dataInvio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_modifica")
	private Date dataModifica;

	private Boolean inviato;

	@Lob
	private String json;

	@Column(name="ref_account")
	private String refAccount;

	private String scope;

	private String service;

	private String stato;

	private String tecnologia;

	@Column(name="ticket_id")
	private String ticketId;

	private String tipo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ultimo_aggiornamento_stato")
	private Date ultimoAggiornamentoStato;

	//bi-directional many-to-one association to SpFormAllegato
	@OneToMany(cascade=CascadeType.ALL, mappedBy="spFormRichieste", fetch=FetchType.LAZY)
	private List<SpFormAllegato> spFormAllegatos = new LinkedList<SpFormAllegato>();

	//bi-directional many-to-one association to SpDRemedyUrgenza
	@ManyToOne
	@JoinColumn(name="severity")
	private SpDRemedyUrgenza spDRemedyUrgenza;

	//bi-directional many-to-one association to SpDTipoForm
	@ManyToOne
	@JoinColumn(name="id_tipo_form")
	private SpDTipoForm spDTipoForm;

	//bi-directional many-to-one association to SpUser
	@ManyToOne
	@JoinColumn(name="id_utente_inserimento")
	private SpUser utenteInserimento;

	//bi-directional many-to-one association to SpUser
	@ManyToOne
	@JoinColumn(name="id_utente_invio")
	private SpUser utenteInvio;

	//bi-directional many-to-one association to SpUser
	@ManyToOne
	@JoinColumn(name="id_utente_modifica")
	private SpUser utenteModifica;
	
	@Column(name="update_date")
	private Timestamp updateDate;
	
	@Column(name="close_date")
	private Timestamp closeDate;
	
	@Column(name="riepilogo_scelte")
	private String riepilogoScelte;
	
	//bi-directional one-to-one association to SpAssegnatarioRichiesta
	@OneToMany(cascade=CascadeType.ALL, mappedBy="richiesta", fetch=FetchType.LAZY)
	private List<SpAssegnatarioRichiesta> spAssegnatarioRichiestas;
	
	

	public SpFormRichieste() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public Date getDataInvio() {
		return dataInvio;
	}

	public void setDataInvio(Date dataInvio) {
		this.dataInvio = dataInvio;
	}

	public Date getDataModifica() {
		return dataModifica;
	}

	public void setDataModifica(Date dataModifica) {
		this.dataModifica = dataModifica;
	}

	public Boolean getInviato() {
		return inviato;
	}

	public void setInviato(Boolean inviato) {
		this.inviato = inviato;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String getRefAccount() {
		return refAccount;
	}

	public void setRefAccount(String refAccount) {
		this.refAccount = refAccount;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getUltimoAggiornamentoStato() {
		return ultimoAggiornamentoStato;
	}

	public void setUltimoAggiornamentoStato(Date ultimoAggiornamentoStato) {
		this.ultimoAggiornamentoStato = ultimoAggiornamentoStato;
	}

	public List<SpFormAllegato> getSpFormAllegatos() {
		return spFormAllegatos;
	}

	public void setSpFormAllegatos(List<SpFormAllegato> spFormAllegatos) {
		this.spFormAllegatos = spFormAllegatos;
	}

	public SpFormAllegato addSpFormAllegato(SpFormAllegato spFormAllegato) {
		getSpFormAllegatos().add(spFormAllegato);
		spFormAllegato.setSpFormRichieste(this);

		return spFormAllegato;
	}

	public SpFormAllegato removeSpFormAllegato(SpFormAllegato spFormAllegato) {
		getSpFormAllegatos().remove(spFormAllegato);
		spFormAllegato.setSpFormRichieste(null);

		return spFormAllegato;
	}

	public SpDRemedyUrgenza getSpDRemedyUrgenza() {
		return spDRemedyUrgenza;
	}

	public void setSpDRemedyUrgenza(SpDRemedyUrgenza spDRemedyUrgenza) {
		this.spDRemedyUrgenza = spDRemedyUrgenza;
	}

	public SpDTipoForm getSpDTipoForm() {
		return spDTipoForm;
	}

	public void setSpDTipoForm(SpDTipoForm spDTipoForm) {
		this.spDTipoForm = spDTipoForm;
	}

	public SpUser getUtenteInserimento() {
		return utenteInserimento;
	}

	public void setUtenteInserimento(SpUser utenteInserimento) {
		this.utenteInserimento = utenteInserimento;
	}

	public SpUser getUtenteInvio() {
		return utenteInvio;
	}

	public void setUtenteInvio(SpUser utenteInvio) {
		this.utenteInvio = utenteInvio;
	}

	public SpUser getUtenteModifica() {
		return utenteModifica;
	}

	public void setUtenteModifica(SpUser utenteModifica) {
		this.utenteModifica = utenteModifica;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public Timestamp getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Timestamp closeDate) {
		this.closeDate = closeDate;
	}

	public String getRiepilogoScelte() {
		return riepilogoScelte;
	}

	public void setRiepilogoScelte(String riepilogoScelte) {
		this.riepilogoScelte = riepilogoScelte;
	}

	public List<SpAssegnatarioRichiesta> getSpAssegnatarioRichiestas() {
		return spAssegnatarioRichiestas;
	}

	public void setSpAssegnatarioRichiestas(List<SpAssegnatarioRichiesta> spAssegnatarioRichiestas) {
		this.spAssegnatarioRichiestas = spAssegnatarioRichiestas;
	}
	

	
}
