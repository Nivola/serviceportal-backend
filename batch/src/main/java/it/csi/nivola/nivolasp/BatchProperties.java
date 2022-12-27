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

import org.springframework.boot.context.properties.ConfigurationProperties;

import it.csi.nivola.nivolasp.config.ApplicationProperties;
import it.csi.nivola.nivolasp.repository.SpConfigRepository;
@ConfigurationProperties(ignoreUnknownFields = true)
public class BatchProperties extends ApplicationProperties{
	
	private StaasCSV staasCSV = new StaasCSV();
	
	/**
	 * Costruttore
	 * @param spConfigRepository
	 */
	public BatchProperties(SpConfigRepository spConfigRepository) {
		super(spConfigRepository);
	}

	
	public StaasCSV getStaasCSV() {
		return staasCSV;
	}


	public void setStaasCSV(StaasCSV staasCSV) {
		this.staasCSV = staasCSV;
	}


	/**
	 * Classe per i parametri di lettura flusso CSV con i consumi dello storage
	 * @author plaf
	 *
	 */
	public class StaasCSV {

		private String elaborazionefile;

		private String headerLineV01;

		private String headerLineV02;

		private String pathFilesCostiStaasDaCaricare;

		private String pathFilesCostiStaasCaricati;

		private String pathFilesCostiStaasConErrore;

		public String getElaborazionefile() {
			return elaborazionefile;
		}

		public void setElaborazionefile(String elaborazionefile) {
			this.elaborazionefile = elaborazionefile;
		}

		public String getHeaderLineV01() {
			return headerLineV01;
		}

		public void setHeaderLineV01(String headerLineV01) {
			this.headerLineV01 = headerLineV01;
		}

		public String getHeaderLineV02() {
			return headerLineV02;
		}

		public void setHeaderLineV02(String headerLineV02) {
			this.headerLineV02 = headerLineV02;
		}

		public String getPathFilesCostiStaasDaCaricare() {
			return pathFilesCostiStaasDaCaricare;
		}

		public void setPathFilesCostiStaasDaCaricare(String pathFilesCostiStaasDaCaricare) {
			this.pathFilesCostiStaasDaCaricare = pathFilesCostiStaasDaCaricare;
		}

		public String getPathFilesCostiStaasCaricati() {
			return pathFilesCostiStaasCaricati;
		}

		public void setPathFilesCostiStaasCaricati(String pathFilesCostiStaasCaricati) {
			this.pathFilesCostiStaasCaricati = pathFilesCostiStaasCaricati;
		}

		public String getPathFilesCostiStaasConErrore() {
			return pathFilesCostiStaasConErrore;
		}

		public void setPathFilesCostiStaasConErrore(String pathFilesCostiStaasConErrore) {
			this.pathFilesCostiStaasConErrore = pathFilesCostiStaasConErrore;
		}
	}
}
