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
package it.csi.nivola.nivolasp.integration.remedy.invoker.auth;

import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;

public interface Authentication {
    /** 
     * Apply authentication settings to header and / or query parameters.
     * @param queryParams The query parameters for the request 
     * @param headerParams The header parameters for the request
     */
    public void applyToParams(MultiValueMap<String, String> queryParams, HttpHeaders headerParams);
}
