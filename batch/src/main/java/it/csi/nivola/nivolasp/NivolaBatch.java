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

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import it.csi.nivola.nivolasp.integration.remedy.config.RemedyApiConfig;
import it.csi.nivola.nivolasp.remote.service.ControlloBatchService;

@SpringBootApplication
@EnableConfigurationProperties({BatchProperties.class, RemedyApiConfig.class})
@EnableAutoConfiguration
@EnableScheduling
@EnableAsync
public class NivolaBatch extends SpringBootServletInitializer {
	
	private final static Logger log = LoggerFactory.getLogger(NivolaBatch.class);

    public static void main(String[] args) {
    	/*
    	 * l'opzione --debug indica a spring boot di stampare informazioni di debug. 
    	 * Sfrutto il meccanismo per stampare i parametri di input e classpath dell'applicazione.
    	 */
    	if (Arrays.asList(args).contains("--debug")) {
    		log.debug("ARGOMENTI:");
        	for(String s: args){
        		log.debug(s);
            }
        	log.debug("\nCLASSPATH:");
            ClassLoader cl = ClassLoader.getSystemClassLoader();

            URL[] urls = ((URLClassLoader)cl).getURLs();

            for(URL url: urls){
            	log.debug(url.getFile());
            }
    	}
        SpringApplication.run(NivolaBatch.class, args);
    }
    
    @Bean(name = "/gestione") HttpInvokerServiceExporter accountService(ControlloBatchService servizio) {
        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
        exporter.setService(servizio);
        exporter.setServiceInterface( ControlloBatchService.class );
        return exporter;
    }
}
