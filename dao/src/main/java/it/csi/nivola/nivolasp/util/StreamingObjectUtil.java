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
package it.csi.nivola.nivolasp.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StreamingObjectUtil {

	
	private static ObjectMapper mapper = new ObjectMapper();

	
	public static String streamObjectToJSON (Object o) {
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
			return e.getMessage();
		}
		
	}
	
	public static String streamObjectToJSONUnformatted (Object o) {
		try {
			return mapper.writer().writeValueAsString(o);
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
			return e.getMessage();
		}
		
	}
}
