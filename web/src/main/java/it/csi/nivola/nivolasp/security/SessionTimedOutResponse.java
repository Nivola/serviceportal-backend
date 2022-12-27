/*-
 * ========================LICENSE_START=================================
 * Nivola Web
 * %%
 * Copyright (C) 2022 CSI Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | CSI Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.security;

import java.io.Serializable;

public class SessionTimedOutResponse implements Serializable {

	private static final long serialVersionUID = 4432842705387620281L;

	private String messaggioSessioneScaduta;
	
	private String urlLogin;

	public String getMessaggioSessioneScaduta() {
		return messaggioSessioneScaduta;
	}

	public void setMessaggioSessioneScaduta(String messaggioSessioneScaduta) {
		this.messaggioSessioneScaduta = messaggioSessioneScaduta;
	}

	public String getUrlLogin() {
		return urlLogin;
	}

	public void setUrlLogin(String urlLogin) {
		this.urlLogin = urlLogin;
	}
}
