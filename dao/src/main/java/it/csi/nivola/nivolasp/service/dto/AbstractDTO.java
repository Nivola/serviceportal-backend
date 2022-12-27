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
import java.util.ArrayList;
import java.util.List;

import it.csi.nivola.nivolasp.util.StreamingObjectUtil;


@SuppressWarnings("serial")
public abstract class AbstractDTO implements Serializable {
	
	private static final String COMMON_NAMESPACE = "it.csi.nivola.nivolasp.";
	
	public List<String> getEntity() {
		List<String> output = new ArrayList<>();
		
		Class<?> c = this.getClass();
		while (c != null && !c.equals(java.lang.Object.class)) {
			String name = c.getName();
			if (name.startsWith(COMMON_NAMESPACE)) {
				name = name.substring(COMMON_NAMESPACE.length());
			}
			output.add(name);
			c = c.getSuperclass();
		}
		
		return output;
	}
	
	@Override
	public String toString() {
		return StreamingObjectUtil.streamObjectToJSON(this);
	}
}
