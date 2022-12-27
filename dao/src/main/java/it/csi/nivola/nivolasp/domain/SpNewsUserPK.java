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

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the sp_news_user database table.
 * 
 */
@Embeddable
public class SpNewsUserPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="news_id", insertable=false, updatable=false)
	private String newsId;

	@Column(name="user_id", insertable=false, updatable=false)
	private String userId;

	public SpNewsUserPK() {
	}
	public String getNewsId() {
		return this.newsId;
	}
	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SpNewsUserPK)) {
			return false;
		}
		SpNewsUserPK castOther = (SpNewsUserPK)other;
		return 
			this.newsId.equals(castOther.newsId)
			&& this.userId.equals(castOther.userId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.newsId.hashCode();
		hash = hash * prime + this.userId.hashCode();
		
		return hash;
	}
}
