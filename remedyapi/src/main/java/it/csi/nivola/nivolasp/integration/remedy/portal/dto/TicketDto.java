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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import it.csi.nivola.nivolasp.integration.remedy.portal.dto.CategoriaOperativaTicketDto.TipologiaEnum;

/**
 * Passaggio dati del Ticket
 */
public class TicketDto {

	private String categoriaOperativaLivello1;

	private String categoriaOperativaLivello2;

	private String categoriaOperativaLivello3;

	private TipologiaEnum tipologiaCategoriaOperativa;

	private String dettaglio;

	private ImpattoEnum impatto;

	private String emailRichiedente;
	
	private UrgenzaEnum urgenza;
	
	private String oggetto;
	
	private String personId;

	/**
	 * Valori possibili del campo impatto
	 */
	public enum ImpattoEnum {
		VASTO_DIFFUSO("Vasto/Diffuso"),

		SIGNIFICATIVO_GRANDE("Significativo/Grande"),

		MODERATO_LIMITATO("Moderato/Limitato"),

		MINIMO_LOCALIZZATO("Minimo/Localizzato");

		private String value;

		ImpattoEnum(String value) {
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
		public static ImpattoEnum fromValue(String text) {
			for (ImpattoEnum b : ImpattoEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	/**
	 * Valori possibili nel campo urgenza
	 */
	public enum UrgenzaEnum {
		CRITICA("Critica"),

		ALTA("Alta"),

		MEDIA("Media"),

		BASSA("Bassa");

		private String value;

		UrgenzaEnum(String value) {
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
		public static UrgenzaEnum fromValue(String text) {
			for (UrgenzaEnum b : UrgenzaEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	public String getCategoriaOperativaLivello1() {
		return categoriaOperativaLivello1;
	}

	public void setCategoriaOperativaLivello1(String categoriaOperativaLivello1) {
		this.categoriaOperativaLivello1 = categoriaOperativaLivello1;
	}

	public String getCategoriaOperativaLivello2() {
		return categoriaOperativaLivello2;
	}

	public void setCategoriaOperativaLivello2(String categoriaOperativaLivello2) {
		this.categoriaOperativaLivello2 = categoriaOperativaLivello2;
	}

	public String getCategoriaOperativaLivello3() {
		return categoriaOperativaLivello3;
	}

	public void setCategoriaOperativaLivello3(String categoriaOperativaLivello3) {
		this.categoriaOperativaLivello3 = categoriaOperativaLivello3;
	}

	public TipologiaEnum getTipologiaCategoriaOperativa() {
		return tipologiaCategoriaOperativa;
	}

	public void setTipologiaCategoriaOperativa(TipologiaEnum tipologiaCategoriaOperativa) {
		this.tipologiaCategoriaOperativa = tipologiaCategoriaOperativa;
	}

	public String getDettaglio() {
		return dettaglio;
	}

	public void setDettaglio(String dettaglio) {
		this.dettaglio = dettaglio;
	}

	public ImpattoEnum getImpatto() {
		return impatto;
	}

	public void setImpatto(ImpattoEnum impatto) {
		this.impatto = impatto;
	}

	public String getEmailRichiedente() {
		return emailRichiedente;
	}

	public void setEmailRichiedente(String emailRichiedente) {
		this.emailRichiedente = emailRichiedente;
	}

	public UrgenzaEnum getUrgenza() {
		return urgenza;
	}

	public void setUrgenza(UrgenzaEnum urgenza) {
		this.urgenza = urgenza;
	}

	public String getOggetto() {
		return oggetto;
	}

	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}
	
	
}
