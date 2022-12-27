/*-
 * ========================LICENSE_START=================================
 * Api Remedy
 * %%
 * Copyright (C) 2022 Regione Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | Regione Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
/*
 * troubleticketing
 * Le API consentono interoperabilit� con il sistema di Trouble Ticketing (creazione ticket, anagrafiche clienti ed info lavoro) ed interrogazione informazioni (stato ticket, elenco ticket il cui stato � stato variato, elenco company cliente, elenco categorizzazioni operative, catalogo applicativo, configuration items, anagrafiche clienti).  
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package it.csi.nivola.nivolasp.integration.remedy.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * LavorazioneTicket
 */

public class LavorazioneTicket {
	/**
	 * stato della service request
	 */
	public enum StatoEnum {
		ASSEGNATO("Assegnato"),

		IN_CORSO("In corso"),

		PENDENTE("Pendente"),

		RISOLTO("Risolto"),

		CHIUSO("Chiuso"),

		ANNULLATO("Annullato");

		private String value;

		StatoEnum(String value) {
			this.value = value;
		}

		@JsonValue
		public String getValue() {
			return value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static StatoEnum fromValue(String text) {
			for (StatoEnum b : StatoEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("stato")
	private StatoEnum stato = null;

	/**
	 * comunicazioni sulla lavorazione
	 */
	public enum MotivoStatoEnum {
		CREAZIONE_MODIFICA_INFRASTRUTTURALE("Creazione modifica infrastrutturale"),

		APPROVAZIONE_RICHIESTA("Approvazione Richiesta"),

		RICHIESTA_INFORMAZIONI("Richiesta Informazioni"),

		ATTESA_PARTI_HW("Attesa parti HW"),

		ALTRE_AZIONI_NON_NECESSARIE("Altre azioni non necessarie"),

		RISOLUZ_AUTOMATICA_RIPORTATA("Risoluz. automatica riportata"),

		NON_PI_CI_CAUSALE("Non pi� CI causale"),

		APPUNTAMENTO_CONTATTO("Appuntamento Contatto"),

		ASSENZA_INDIS_UTENTE("Assenza/indis. utente"),

		INTERVENTO_NON_RIUSCITO("Intervento non riuscito"),

		NON_APPROVATO("Non Approvato"),

		INOLTRATO("Inoltrato");

		private String value;

		MotivoStatoEnum(String value) {
			this.value = value;
		}

		@JsonValue
		public String getValue() {
			return value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static MotivoStatoEnum fromValue(String text) {
			for (MotivoStatoEnum b : MotivoStatoEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("motivoStato")
	private MotivoStatoEnum motivoStato = null;

	@JsonProperty("risoluzione")
	private String risoluzione = null;

	@JsonProperty("assegnatario")
	private String assegnatario = null;

	@JsonProperty("email")
	private String email = null;

	@JsonProperty("updateDate")
	private LocalDateTime updateDate = null;

	@JsonProperty("closeDate")
	private LocalDateTime closeDate = null;

	@JsonProperty("operatorId")
	private String operatorId = null;

	@JsonProperty("commento")
	private String commento = null;

	@JsonProperty("noteUtente")
	private List<InfoNotaBaseModel> noteUtente = null;

	public LavorazioneTicket stato(StatoEnum stato) {
		this.stato = stato;
		return this;
	}

	/**
	 * stato della service request
	 * 
	 * @return stato
	 **/
	@ApiModelProperty(required = true, value = "stato della service request")
	public StatoEnum getStato() {
		return stato;
	}

	public void setStato(StatoEnum stato) {
		this.stato = stato;
	}

	public LavorazioneTicket motivoStato(MotivoStatoEnum motivoStato) {
		this.motivoStato = motivoStato;
		return this;
	}

	/**
	 * comunicazioni sulla lavorazione
	 * 
	 * @return motivoStato
	 **/
	@ApiModelProperty(value = "comunicazioni sulla lavorazione")
	public MotivoStatoEnum getMotivoStato() {
		return motivoStato;
	}

	public void setMotivoStato(MotivoStatoEnum motivoStato) {
		this.motivoStato = motivoStato;
	}

	public LavorazioneTicket risoluzione(String risoluzione) {
		this.risoluzione = risoluzione;
		return this;
	}

	/**
	 * commento di chiusura della request
	 * 
	 * @return risoluzione
	 **/
	@ApiModelProperty(value = "commento di chiusura della request")
	public String getRisoluzione() {
		return risoluzione;
	}

	public void setRisoluzione(String risoluzione) {
		this.risoluzione = risoluzione;
	}

	public LavorazioneTicket assegnatario(String assegnatario) {
		this.assegnatario = assegnatario;
		return this;
	}

	/**
	 * alias del gruppo o nominativo operatore
	 * 
	 * @return assegnatario
	 **/
	@ApiModelProperty(value = "alias del gruppo o nominativo operatore")
	public String getAssegnatario() {
		return assegnatario;
	}

	public void setAssegnatario(String assegnatario) {
		this.assegnatario = assegnatario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<InfoNotaBaseModel> getNoteUtente() {
		return noteUtente;
	}

	public void setNoteUtente(List<InfoNotaBaseModel> noteUtente) {
		this.noteUtente = noteUtente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assegnatario == null) ? 0 : assegnatario.hashCode());
		result = prime * result + ((closeDate == null) ? 0 : closeDate.hashCode());
		result = prime * result + ((commento == null) ? 0 : commento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((motivoStato == null) ? 0 : motivoStato.hashCode());
		result = prime * result + ((noteUtente == null) ? 0 : noteUtente.hashCode());
		result = prime * result + ((operatorId == null) ? 0 : operatorId.hashCode());
		result = prime * result + ((risoluzione == null) ? 0 : risoluzione.hashCode());
		result = prime * result + ((stato == null) ? 0 : stato.hashCode());
		result = prime * result + ((updateDate == null) ? 0 : updateDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LavorazioneTicket other = (LavorazioneTicket) obj;
		if (assegnatario == null) {
			if (other.assegnatario != null)
				return false;
		}
		else if (!assegnatario.equals(other.assegnatario))
			return false;
		if (closeDate == null) {
			if (other.closeDate != null)
				return false;
		}
		else if (!closeDate.equals(other.closeDate))
			return false;
		if (commento == null) {
			if (other.commento != null)
				return false;
		}
		else if (!commento.equals(other.commento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		}
		else if (!email.equals(other.email))
			return false;
		if (motivoStato != other.motivoStato)
			return false;
		if (noteUtente == null) {
			if (other.noteUtente != null)
				return false;
		}
		else if (!noteUtente.equals(other.noteUtente))
			return false;
		if (operatorId == null) {
			if (other.operatorId != null)
				return false;
		}
		else if (!operatorId.equals(other.operatorId))
			return false;
		if (risoluzione == null) {
			if (other.risoluzione != null)
				return false;
		}
		else if (!risoluzione.equals(other.risoluzione))
			return false;
		if (stato != other.stato)
			return false;
		if (updateDate == null) {
			if (other.updateDate != null)
				return false;
		}
		else if (!updateDate.equals(other.updateDate))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "LavorazioneTicket [stato=" + stato + ", motivoStato=" + motivoStato + ", risoluzione=" + risoluzione + ", assegnatario=" + assegnatario + ", email=" + email + ", updateDate=" + updateDate + ", closeDate=" + closeDate
				+ ", operatorId=" + operatorId + ", commento=" + commento + ", noteUtente=" + noteUtente + "]";
	}

}