/*-
 * ========================LICENSE_START=================================
 * Nivola Batch
 * %%
 * Copyright (C) 2022 CSI Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | CSI Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import ch.qos.logback.classic.LoggerContext;

@Configuration
public class LoggingConfiguration {
	
    public LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();


    
}
