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
package it.csi.nivola.nivolasp.scheduled;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.nivola.nivolasp.BatchProperties;
import it.csi.nivola.nivolasp.domain.SpTConsumiStaas;
import it.csi.nivola.nivolasp.repository.SpTConsumiStaaRepository;


/**
 * 
 * @author LG
 * Classe per le funzionalita di caricamento costi Staas
 */

@Service
public class CaricaCostiStorageAsAService {

	@Autowired
	public BatchProperties proprieta = null;
	
	@Autowired
	public SpTConsumiStaaRepository spTConsumiStaaRepository;

	private final static String CVS_SPLIT_BY = ";";

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	public boolean isPresenteFileDatiStaas() {
		boolean retVal = false;
		File file = new File(proprieta.getStaasCSV().getPathFilesCostiStaasDaCaricare());
		
		if (file.isDirectory()) {
			if (file.list().length > 0) {
				retVal =  true;
			} else {
				retVal =  false;
			}
			
		}
		return retVal;
	}

	public boolean caricaFilesDati() {
		
		boolean bRet = false;
		if (proprieta.getStaasCSV().getElaborazionefile() != null && proprieta.getStaasCSV().getElaborazionefile().equals("true")) {

			BufferedReader br = null;
			String line = "";

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-mm-dd");
			sdf.setTimeZone(TimeZone.getTimeZone("Europe/Rome"));

			if (isPresenteFileDatiStaas()) {
				// Ci sono dei files!
				File directory = new File(proprieta.getStaasCSV().getPathFilesCostiStaasDaCaricare());
				List<String> wildcards = new ArrayList<String>();
				// Cerca solo i file CSV
				wildcards.add("*.csv");
				wildcards.add("*.CSV");
				WildcardFileFilter wildCardFilter = new WildcardFileFilter(wildcards);

				Collection<File> fList = FileUtils.listFiles(directory, wildCardFilter, null);
				int lineNumber = 0;
				int skippedLines = 0;
				int linesWithError = 0;
				int linesWithData = 0;


				// Formato della data nel file
				SimpleDateFormat sdfData = new SimpleDateFormat("yyyymmdd");

				// Loop sui files trovati
				for (File file : fList) {
					if (file.isFile()) {
						
						boolean bElaborazioneFileCompletataConErrori = false;

						try {
							// Crea file di report
							Timestamp now = new Timestamp((new java.util.Date()).getTime());
							BufferedWriter reportFile = new BufferedWriter(
									new OutputStreamWriter(
											new FileOutputStream(
													proprieta.getStaasCSV().getPathFilesCostiStaasDaCaricare() + file.getName() + "_report.txt"),
											"utf-8"));
							reportFile.write(
									"===================== REPORT CARICAMENTO FILE COSTI STAAS ==============================");
							reportFile.newLine();
							reportFile.write("NOME FILE : " + file.getName());
							reportFile.newLine();
							reportFile.write("DATA e ORA ELABORAZIONE : " + sdf.format(now));
							reportFile.newLine();

							lineNumber = 0;
							skippedLines = 0;
							linesWithError = 0;
							linesWithData = 0;

							br = new BufferedReader(new FileReader(file));

							while ((line = br.readLine()) != null) {
								lineNumber = lineNumber + 1;

								if (!line.toUpperCase().equals(proprieta.getStaasCSV().getHeaderLineV01().toUpperCase())
										&& !line.equals(proprieta.getStaasCSV().getHeaderLineV02().toUpperCase())) {
									if (line.trim().equals("")) {
										reportFile.newLine();
										reportFile.write("Linea " + lineNumber + " vuota ... skipped! ");
										skippedLines++;
									} else {
										String[] riga = line.split(CVS_SPLIT_BY);
										// Verifica la correttezza formale della
										// riga letta
										// Ci devono essere esattamente sei dati
										boolean bInserisciRiga = true;
										SpTConsumiStaas rs = new SpTConsumiStaas();

										if (riga.length != 6) {
											reportFile.newLine();
											reportFile.write("[ERRORE] Linea " + lineNumber
													+ " : Formato linea non corretto. Numero di dati diverso da 6.");
											linesWithError++;
											bInserisciRiga = false;
										}

										if (bInserisciRiga) {
											// Controlla che la data sia
											// corretta
											if (riga[0].equals("")) {
												bInserisciRiga = false;
												reportFile.newLine();
												reportFile.write("[ERRORE] Linea " + lineNumber
														+ " : manca la data di rilevazione.");
												linesWithError++;
											} else {
												try {
													Date dataOraRilevazione = (Date) sdfData.parse(riga[0]);
													Timestamp tsData = new Timestamp(dataOraRilevazione.getTime());
													String sData1 = sdf3.format(tsData) + " " + "08:00:00";
													Timestamp tsData1 = Timestamp.valueOf(sData1);

													rs.setData(new Date(tsData1.getTime()));

												} catch (ParseException pe) {
													bInserisciRiga = false;
													reportFile.newLine();
													reportFile.write("[ERRORE] Linea " + lineNumber
															+ " : il formato della data di rilevazione non e' corretto.");
													linesWithError++;
												}
											}
										}

										if (bInserisciRiga) {
											// Controlla che evs sia definito
											if (riga[1].equals("")) {
												bInserisciRiga = false;
												reportFile.newLine();
												reportFile
														.write("[ERRORE] Linea " + lineNumber + " : evs non definito.");
												linesWithError++;
											} else {
												rs.setEvs(riga[1].trim());
											}
										}

										if (bInserisciRiga) {
											// Controlla che filesystem sia
											// definito
											if (riga[2].equals("")) {
												bInserisciRiga = false;
												reportFile.newLine();
												reportFile.write(
														"[ERRORE] Linea " + lineNumber + " : filesystem non definito.");
												linesWithError++;
											} else {
												rs.setFilesystem(riga[2].trim());
											}
										}

										if (bInserisciRiga) {
											// Controlla che share sia definito
											if (riga[3].equals("")) {
												bInserisciRiga = false;
												reportFile.newLine();
												reportFile.write(
														"[ERRORE] Linea " + lineNumber + " : share non definito.");
												linesWithError++;
											} else {
												rs.setShare(riga[3].trim());
											}
										}

										if (bInserisciRiga) {
											// Controlla che used sia definito e
											// sia
											// un numero
											if (riga[4].equals("")) {
												bInserisciRiga = false;
												reportFile.newLine();
												reportFile.write(
														"[ERRORE] Linea " + lineNumber + " : consumo non definita.");
												linesWithError++;
											} else {
												try {
													rs.setUsedGb(Double.parseDouble(riga[4]));

												} catch (NumberFormatException pe) {
													bInserisciRiga = false;
													reportFile.newLine();
													reportFile.write("[ERRORE] Linea " + lineNumber
															+ " : il formato della data di rilevazione non e' corretto.");
													linesWithError++;
												}
											}
										}

										if (bInserisciRiga) {
											// Controlla che used sia definito e
											// sia
											// un numero
											if (riga[5].equals("")) {
												bInserisciRiga = false;
												reportFile.newLine();
												reportFile.write(
														"[ERRORE] Linea " + lineNumber + " : quota non definita.");
												linesWithError++;
											} else {
												try {
													rs.setQuotaGb(Double.parseDouble(riga[5]));

												} catch (NumberFormatException pe) {
													bInserisciRiga = false;
													reportFile.newLine();
													reportFile.write("[ERRORE] Linea " + lineNumber
															+ " : il formato della data di rilevazione non e' corretto.");
													linesWithError++;
												}
											}
										}

										if (bInserisciRiga) {
											// Verifica se esiste gi� nel
											// database
											// un record
											// per lo stesso giorno, evs,
											// filesystem, share
											linesWithData++;
											try {
												// AF ricerca del record
												SpTConsumiStaas ril = spTConsumiStaaRepository.findByFilesystem(rs.getFilesystem());
												reportFile.newLine();
												if (ril != null) {
													// Sostituisce il dato
													rs.setId(ril.getId());
													
													reportFile.write("[UPDATE] Linea " + lineNumber
															+ " : Rilevazione gi� presente. Dati aggiornati.");
												} else {
													// Nuovo inserimento
													reportFile.write("[INSERT] Linea " + lineNumber + " : Dati inseriti.");
												}
												spTConsumiStaaRepository.saveAndFlush(rs);
											} catch (Exception e) {
												reportFile.newLine();
												reportFile.write("[ERRORE] Linea " + lineNumber
														+ " : Si e' verificato un errore nella aggiornamento del DB.");
												linesWithError++;
												bElaborazioneFileCompletataConErrori = true;
												bInserisciRiga = false;
												e.printStackTrace();
											}

										}

									}
								}
							}
							// close the input stream
							br.close();

							// Close the output stream
							reportFile.newLine();
							reportFile.write("  linee totali :" + lineNumber);
							reportFile.newLine();
							reportFile.write("       skipped : " + skippedLines);
							reportFile.newLine();
							reportFile.write("     in errore : " + linesWithError);
							reportFile.newLine();
							reportFile.write("linee con dati : " + linesWithData);

							if (linesWithError > 0) {
								bElaborazioneFileCompletataConErrori = true;
							}

							reportFile.close();

						} catch (IOException ex) {
							ex.printStackTrace();
							bElaborazioneFileCompletataConErrori = true;
						}

						SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
						sdf2.setTimeZone(TimeZone.getTimeZone("Europe/Rome"));

						// Deve spostare i files (dati e report) nella cartella
						// corretta
						File srcDataFile = new File(proprieta.getStaasCSV().getPathFilesCostiStaasDaCaricare() + file.getName());
						File srcReportFile = new File(proprieta.getStaasCSV().getPathFilesCostiStaasDaCaricare() + file.getName() + "_report.txt");
						File destDataFile = null;
						File destReportFile = null;

						if (bElaborazioneFileCompletataConErrori) {
							destDataFile = new File(proprieta.getStaasCSV().getPathFilesCostiStaasConErrore() + file.getName());
							destReportFile = new File(proprieta.getStaasCSV().getPathFilesCostiStaasConErrore() + file.getName() + ".txt");
						} else {
							destDataFile = new File(proprieta.getStaasCSV().getPathFilesCostiStaasCaricati() + file.getName());
							destReportFile = new File(proprieta.getStaasCSV().getPathFilesCostiStaasCaricati() + file.getName() + ".txt");
						}

						try {
							if (destDataFile.exists()) {
								destDataFile.delete();
							}
							FileUtils.moveFile(srcDataFile, destDataFile);

							if (destReportFile.exists()) {
								destReportFile.delete();
							}
							FileUtils.moveFile(srcReportFile, destReportFile);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		log.debug("FINE caricaFilesDati");
		return bRet;
	}

}
