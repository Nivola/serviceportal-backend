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
package it.csi.nivola.nivolasp.web.rest;

import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiParam;
import it.csi.nivola.nivolasp.security.AuthoritiesConstants;
import it.csi.nivola.nivolasp.service.AmazonS3ClientService;
import it.csi.nivola.nivolasp.service.GenerazioneCSVService;
import it.csi.nivola.nivolasp.service.RendicontoService;
import it.csi.nivola.nivolasp.service.dto.ExportCSV;
import it.csi.nivola.nivolasp.service.dto.RendicontoDTO;
import it.csi.nivola.nivolasp.service.dto.RendicontoServiceResponse;
import it.csi.nivola.nivolasp.service.dto.ReportRendicontoResponse;
import it.csi.nivola.nivolasp.service.dto.ValutaDTO;

/**
 *
 */
@RestController
@RequestMapping("/api")
public class RendicontoResource {

	private Logger log = LoggerFactory.getLogger(RendicontoResource.class);

	@Autowired
	RendicontoService rendicontoService;
	
	@Autowired
	AmazonS3ClientService amazonS3ClientService;
	
	@Autowired
	GenerazioneCSVService generazioneCSVService;

    @Autowired
    public RendicontoResource() {
    }

    /**
     * Elenco dei rendiconti mensili presenti per la visualizzazione nella schermata 'Costi e consumi'
     * @param idAccount
     * @param idDivisione
     * @param idOrganizzazione
     * @param pageable
     * @return
     */
    @GetMapping("/rendiconti")
    public ResponseEntity<RendicontoServiceResponse> getRendiconti( @RequestParam(value="account", required = false) Optional<String> idAccount,
											    		  @RequestParam(value="idDivisione", required = false) Optional<String> idDivisione,
											    		  @RequestParam(value="idOrganizzazione", required = false) Optional<String> idOrganizzazione,
											    		  @ApiParam Pageable pageable) {
    	log.debug("Richiesta elenco rendiconti");
    	RendicontoServiceResponse response = new RendicontoServiceResponse();
    	Page<RendicontoDTO> rendiconti =  null;
    	//di default sara per l'anno in corso o ulitmi 12 mesi
    	pageable = pageable == null ? new PageRequest(1,12) :pageable;
    	if(!idAccount.isPresent() && !idDivisione.isPresent() && !idOrganizzazione.isPresent()){
    		it.csi.nivola.nivolasp.integration.rest.model.service.Error err = new it.csi.nivola.nivolasp.integration.rest.model.service.Error();
    		err.setCode(1);
    		err.setDescription("Dati Obbligatori mancanti ");
    		err.setMessage("Dati Obbligatori mancanti ");
    		response.setError(err);
    		return new ResponseEntity<RendicontoServiceResponse>(response,HttpStatus.BAD_REQUEST);
    	}

    	if(idAccount.isPresent()){
    		rendiconti = rendicontoService.findRendicontiByidAccount(idAccount.get());
    	}else if(idDivisione.isPresent()){
    		rendiconti = rendicontoService.findRendicontiByidDivisione(idDivisione.get(), "MD",pageable);
    	}else if(idOrganizzazione.isPresent()){
    		rendiconti = rendicontoService.findRendicontiByidOrganizzazione(idOrganizzazione.get(),pageable);
    	}

    	response.setnElementi(rendiconti.getTotalElements());
    	response.setnPaginaCorrente(rendiconti.getNumber());
    	response.setnPagineTotali((rendiconti.getTotalPages()));
    	response.setRendiconti(rendiconti.getContent());
    	response.setValuta(new ValutaDTO());
    	return new ResponseEntity<RendicontoServiceResponse>(response,HttpStatus.OK);
    }


    /**
     * Download dei report PDF per struttura organizzativa
     * @param reportId
     * @param idAccount
     * @param idDivisione
     * @param idOrganizzazione
     * @return
     * @throws IOException
     */
    @GetMapping("/report")
    public ResponseEntity<ReportRendicontoResponse> getPDF( @RequestParam(value="report", required = true) Optional<Long> reportId,
    													  @RequestParam(value="account", required = false) Optional<String> idAccount,
											    		  @RequestParam(value="divisione", required = false) Optional<String> idDivisione,
											    		  @RequestParam(value="organizzazione", required = false) Optional<String> idOrganizzazione) throws IOException {
    	ReportRendicontoResponse response = new ReportRendicontoResponse();
    	//di default sara per l'anno in corso o ulitmi 12 mesi
    	if(!idAccount.isPresent() && !idDivisione.isPresent() && !idOrganizzazione.isPresent()
    			|| !reportId.isPresent()
    			){
    		it.csi.nivola.nivolasp.integration.rest.model.service.Error err = new it.csi.nivola.nivolasp.integration.rest.model.service.Error();
    		err.setCode(1);
    		err.setDescription("Dati Obbligatori mancanti ");
    		err.setMessage("Dati Obbligatori mancanti ");
    		response.setError(err);
    		return new ResponseEntity<ReportRendicontoResponse>(response,HttpStatus.BAD_REQUEST);
    	}

    	Optional<RendicontoDTO> rendiconto = null;
    	if(idAccount.isPresent()){
    		rendiconto = rendicontoService.findRendicontoByIdAndIdAccount(idAccount.get(),reportId.get());
    	}else if(idDivisione.isPresent()){
    		rendiconto = rendicontoService.findRendicontoByIdAndIdDivisione(idDivisione.get(),reportId.get());
    	}else if(idOrganizzazione.isPresent()){
    		rendiconto = rendicontoService.findRendicontoByIdAndIdOrganizzazione(idOrganizzazione.get(),reportId.get());
    	}

    	if(rendiconto.isPresent()) {
    		response.setReport(amazonS3ClientService.getFile(rendiconto.get().getUrlFile()));
    		String [] splitted = rendiconto.get().getUrlFile().split("/");
    		response.setNomeFile(splitted[splitted.length-1]);
    	}
    	return new ResponseEntity<ReportRendicontoResponse>(response,HttpStatus.OK);
    }
    
    /**
     * Report di dettaglio giornaliero per account scaricabile dalla pagina dei costi
     * @param uuidStruttura
     * @param anno
     * @param mese
     * @param tipoStruttura
     * @param nome
     * @return
     * @throws IOException
     */
    @GetMapping("/reportCSV")
    public ResponseEntity<ReportRendicontoResponse> getCSV(
    		@RequestParam(value="uuidStruttura", required = true) String uuidStruttura,
    		@RequestParam(value="anno", required = true) Integer anno,
    		@RequestParam(value="mese", required = true) Integer mese,
    		@RequestParam(value="tipoStruttura", required = true) StrutturaOrganizzativaEnum tipoStruttura,
    		@RequestParam(value="nome", required = false) String nome) throws IOException {
    	
    	YearMonth annoMese = YearMonth.of(anno, mese);
    	LocalDate dataInizio = LocalDate.of(annoMese.getYear(), annoMese.getMonth(), 1);
		LocalDate dataFine = dataInizio.withDayOfMonth(dataInizio.lengthOfMonth());
		StringBuilder csv = generazioneCSVService.creaCSVDettaglioGiornalieroAccount(uuidStruttura, dataInizio, dataFine);
		ReportRendicontoResponse risposta = new ReportRendicontoResponse();
		risposta.setNomeFile(nome + "_" + anno + "_" + mese + ".csv");
		risposta.setReport(csv.toString().getBytes());
    	return new ResponseEntity<ReportRendicontoResponse>(risposta, HttpStatus.OK);
    }
    
    /**
     * Report csv per divisione con download immediato da browser
     * @param uuid
     * @param giorno
     * @return
     * @throws IOException
     */
    @GetMapping("/divisione/reportCSV")
    public ResponseEntity<Resource> getCSVDivisione(
    		@RequestParam(value="uuid", required = true) String uuid,
    		@RequestParam(value="giorno", required = true) LocalDate giorno) throws IOException {
    	
    	ExportCSV csv = generazioneCSVService.creaCSVGiornalieroDivisioneDettaglio(uuid, giorno);
    	ReportRendicontoResponse risposta = new ReportRendicontoResponse();
    	risposta.setNomeFile(csv.getFilename());
    	risposta.setReport(csv.getFile().toString().getBytes());
    	ByteArrayResource resource = new ByteArrayResource(csv.getFile().toString().getBytes());

        return ResponseEntity.ok()
        		.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + risposta.getNomeFile() + "\"")
                .contentLength(csv.getFile().toString().getBytes().length)
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(resource);
//    	return new ResponseEntity<ReportRendicontoResponse>(risposta, HttpStatus.OK);
    }
    
    /**
     * Report csv per organizzazione con download immediato da browser
     * @param uuid
     * @param giorno
     * @return
     * @throws IOException
     */
    @GetMapping("/organizzazione/reportCSV")
    public ResponseEntity<Resource> getCSVOrganizzazione(
    		@RequestParam(value="uuid", required = true) String uuid,
    		@RequestParam(value="giorno", required = true) LocalDate giorno) throws IOException {
    	
    	ExportCSV csv = generazioneCSVService.creaCSVGiornalieroOrganizzazioneDettaglio(uuid, giorno);
    	ReportRendicontoResponse risposta = new ReportRendicontoResponse();
    	risposta.setNomeFile(csv.getFilename());
    	risposta.setReport(csv.getFile().toString().getBytes());
    	ByteArrayResource resource = new ByteArrayResource(csv.getFile().toString().getBytes());
    	
    	return ResponseEntity.ok()
    			.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + risposta.getNomeFile() + "\"")
    			.contentLength(csv.getFile().toString().getBytes().length)
    			.contentType(MediaType.parseMediaType("text/csv"))
    			.body(resource);
//    	return new ResponseEntity<ReportRendicontoResponse>(risposta, HttpStatus.OK);
    }
    
    /**
     * Versione richiamabile da browser del report per l'amministrazione con i dettagli costi - metrica per account
     * @param dataInizio
     * @param dataFine
     * @return
     * @throws IOException
     */
    @GetMapping("/bo/reportTot")
    @Secured(AuthoritiesConstants.BOADMIN)
    public ResponseEntity<Resource> reportTotlaeAccountBO(
    		@RequestParam(value="dataInizio", required = true) LocalDate dataInizio,
    		@RequestParam(value="dataFine", required = true) LocalDate dataFine) throws IOException {
    	
    	ExportCSV csv = generazioneCSVService.creaCSVTotaliAccount(dataInizio, dataFine, "all");
    	ReportRendicontoResponse risposta = new ReportRendicontoResponse();
    	risposta.setNomeFile(csv.getFilename());
    	risposta.setReport(csv.getFile().toString().getBytes());
    	ByteArrayResource resource = new ByteArrayResource(csv.getFile().toString().getBytes());
    	
    	return ResponseEntity.ok()
    			.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + risposta.getNomeFile() + "\"")
    			.contentLength(csv.getFile().toString().getBytes().length)
    			.contentType(MediaType.parseMediaType("text/csv"))
    			.body(resource);
    }
    
    /**
     * Versione richiamabile da browser del report per l'amministrazione con i dettagli costi - WBS per account
     * @param dataInizio
     * @param dataFine
     * @return
     * @throws IOException
     */
    @GetMapping("/bo/reportTotWbs")
    @Secured(AuthoritiesConstants.BOADMIN)
    public ResponseEntity<Resource> reportTotaleAccountWbsBO(
    		@RequestParam(value="dataInizio", required = true) LocalDate dataInizio,
    		@RequestParam(value="dataFine", required = true) LocalDate dataFine, String tipo) throws IOException {
    	
    	ExportCSV csv = generazioneCSVService.creaCSVTotaliAccountWbs(dataInizio, dataFine, tipo);
    	ReportRendicontoResponse risposta = new ReportRendicontoResponse();
    	risposta.setNomeFile(csv.getFilename());
    	risposta.setReport(csv.getFile().toString().getBytes());
    	ByteArrayResource resource = new ByteArrayResource(csv.getFile().toString().getBytes());
    	
    	return ResponseEntity.ok()
    			.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + risposta.getNomeFile() + "\"")
    			.contentLength(csv.getFile().toString().getBytes().length)
    			.contentType(MediaType.parseMediaType("text/csv"))
    			.body(resource);
    }
    
    /**
     * Versione richiamabile da Angular del report per l'amministrazione con i dettagli costi - metrica per account
     * @param dataInizio
     * @param dataFine
     * @return
     * @throws IOException
     */
    @GetMapping("/bo/reportCSVTot")
    public ResponseEntity<ReportRendicontoResponse> getCSVTotaliBO(
    		@RequestParam(value="dataInizio", required = true) LocalDate dataInizio,
    		@RequestParam(value="dataFine", required = true) LocalDate dataFine, String tipo) throws IOException {
    	
    	ExportCSV csv = generazioneCSVService.creaCSVTotaliAccount(dataInizio, dataFine, tipo);
    	ReportRendicontoResponse risposta = new ReportRendicontoResponse();
    	risposta.setNomeFile(csv.getFilename());
    	risposta.setReport(csv.getFile().toString().getBytes());
    	return new ResponseEntity<ReportRendicontoResponse>(risposta, HttpStatus.OK);
    }
    
    /**
     * Versione richiamabile da Angular del report per l'amministrazione con i dettagli costi - WBS per account
     * @param dataInizio
     * @param dataFine
     * @return
     * @throws IOException
     */
    @GetMapping("/bo/reportTotWbsAngular")
    @Secured(AuthoritiesConstants.BOADMIN)
    public ResponseEntity<ReportRendicontoResponse> reportTotaleAccountWbsBOAngular(
    		@RequestParam(value="dataInizio", required = true) LocalDate dataInizio,
    		@RequestParam(value="dataFine", required = true) LocalDate dataFine, String tipo) throws IOException {
    	
    	ExportCSV csv = generazioneCSVService.creaCSVTotaliAccountWbs(dataInizio, dataFine, tipo);
    	ReportRendicontoResponse risposta = new ReportRendicontoResponse();
    	risposta.setNomeFile(csv.getFilename());
    	risposta.setReport(csv.getFile().toString().getBytes());
    	return new ResponseEntity<ReportRendicontoResponse>(risposta, HttpStatus.OK);
    }
    
    /**
     * Recupera la versione CSV del report sistetico mensile per account, scaricabile a fianco ai PDF
     * @param uuidAccount
     * @param anno
     * @param mese
     * @return
     * @throws IOException
     */
    @GetMapping("/account/report/csv/mensilesintetico")
    public ResponseEntity<ReportRendicontoResponse> getCSVMensileSintetico(
    		@RequestParam(value="uuidAccount", required = true) String uuidAccount,
    		@RequestParam(value="anno", required = true) Integer anno,
    		@RequestParam(value="mese", required = true) Integer mese) throws IOException {
    	
    	ExportCSV csv = generazioneCSVService.creaReportMensileSinteticoFormatoCSV(YearMonth.of(anno, mese), uuidAccount);
    	ReportRendicontoResponse risposta = new ReportRendicontoResponse();
    	risposta.setNomeFile(csv.getFilename());
    	risposta.setReport(csv.getFile().toString().getBytes());
    	return new ResponseEntity<ReportRendicontoResponse>(risposta, HttpStatus.OK);
    }

    @Autowired
    private CacheManager cacheManager;

    @GetMapping("/svuotaCacheMetriche")
    @Secured(AuthoritiesConstants.BOADMIN)
    public void clearAllCaches() {
        cacheManager.getCacheNames().forEach(s -> cacheManager.getCache(s).clear());
    }
    
    
    /**
     * Versione richiamabile da browser del report per l'amministrazione con i dettagli costi - metrica per account
     * @param dataInizio
     * @param dataFine
     * @return
     * @throws IOException
     */
    @GetMapping("/bo/reportWbs")
    @Secured(AuthoritiesConstants.BOADMIN)
    public ResponseEntity<Resource> reportTotaliAccountWbs(
    		@RequestParam(value="dataInizio", required = true) LocalDate dataInizio,
    		@RequestParam(value="dataFine", required = true) LocalDate dataFine) throws IOException {
    	
    	ExportCSV csv = generazioneCSVService.creaCSVTotaliAccountWbs(dataInizio, dataFine, "all");
    	ReportRendicontoResponse risposta = new ReportRendicontoResponse();
    	risposta.setNomeFile(csv.getFilename());
    	risposta.setReport(csv.getFile().toString().getBytes());
    	ByteArrayResource resource = new ByteArrayResource(csv.getFile().toString().getBytes());
    	
    	return ResponseEntity.ok()
    			.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + risposta.getNomeFile() + "\"")
    			.contentLength(csv.getFile().toString().getBytes().length)
    			.contentType(MediaType.parseMediaType("text/csv"))
    			.body(resource);
    }

}
