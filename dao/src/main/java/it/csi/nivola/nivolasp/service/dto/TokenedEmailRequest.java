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

public class TokenedEmailRequest implements Serializable {
	
	private static final long serialVersionUID = -687492185167863232L;

	private String token;
	
	private EmailInfo mailSupporto;
	
	private EmailInfo mailUtente;
	
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
	public EmailInfo getMailSupporto() {
		return mailSupporto;
	}

	public void setMailSupporto(EmailInfo mailSupporto) {
		this.mailSupporto = mailSupporto;
	}

	public EmailInfo getMailUtente() {
		return mailUtente;
	}

	public void setMailUtente(EmailInfo mailUtente) {
		this.mailUtente = mailUtente;
	}

	public EmailInfo createInfo () {
		
		return new EmailInfo();
	}


	public class EmailInfo {
		private String richiedente;
		
		private String destinatario;
		
		private String titolo;
		
		private String corpo;

		public String getRichiedente() {
			return richiedente;
		}

		public void setRichiedente(String richiedente) {
			this.richiedente = richiedente;
		}

		public String getDestinatario() {
			return destinatario;
		}

		public void setDestinatario(String destinatario) {
			this.destinatario = destinatario;
		}

		public String getTitolo() {
			return titolo;
		}

		public void setTitolo(String titolo) {
			this.titolo = titolo;
		}

		public String getCorpo() {
			return corpo;
		}

		public void setCorpo(String corpo) {
			this.corpo = corpo;
		}
	
	
	}

}
