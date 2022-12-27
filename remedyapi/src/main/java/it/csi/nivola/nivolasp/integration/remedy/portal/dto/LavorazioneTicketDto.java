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
package it.csi.nivola.nivolasp.integration.remedy.portal.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * LavorazioneTicketDto
 */
public class LavorazioneTicketDto {
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


	public LavorazioneTicketDto stato(StatoEnum stato) {
		this.stato = stato;
		return this;
	}

	public StatoEnum getStato() {
		return stato;
	}

	public void setStato(StatoEnum stato) {
		this.stato = stato;
	}

	public LavorazioneTicketDto motivoStato(MotivoStatoEnum motivoStato) {
		this.motivoStato = motivoStato;
		return this;
	}

	public MotivoStatoEnum getMotivoStato() {
		return motivoStato;
	}

	public void setMotivoStato(MotivoStatoEnum motivoStato) {
		this.motivoStato = motivoStato;
	}

	public LavorazioneTicketDto risoluzione(String risoluzione) {
		this.risoluzione = risoluzione;
		return this;
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

	public String getRisoluzione() {
		return risoluzione;
	}

	public void setRisoluzione(String risoluzione) {
		this.risoluzione = risoluzione;
	}

	public LavorazioneTicketDto assegnatario(String assegnatario) {
		this.assegnatario = assegnatario;
		return this;
	}

	public String getAssegnatario() {
		return assegnatario;
	}

	public void setAssegnatario(String assegnatario) {
		this.assegnatario = assegnatario;
	}
}
