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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.csi.nivola.nivolasp.integration.rest.api.service.AuthorityApi;
import it.csi.nivola.nivolasp.integration.rest.api.service.ComputeserviceApi;
import it.csi.nivola.nivolasp.integration.rest.api.service.DatabaseserviceApi;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeInstancesApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeInstancesApiResponseSchemaDescribeInstancesResponseInstancesSet;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetActiveServicesByAccountResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetActiveServicesByDivisionResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetActiveServicesByOrganizationResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetNivolaActiveServicesResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListAccountsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListDivisionsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListOrganizationsResponseSchema;
import it.csi.nivola.nivolasp.security.AuthoritiesConstants;
import it.csi.nivola.nivolasp.service.MetricheService;
import it.csi.nivola.nivolasp.service.RendicontoService;
import it.csi.nivola.nivolasp.service.UserService;
import it.csi.nivola.nivolasp.service.dto.CostoBoxDTO;
import it.csi.nivola.nivolasp.service.dto.MetricaDTO;
import it.csi.nivola.nivolasp.service.dto.RaggruppamentoCostiServizioDTO;
import it.csi.nivola.nivolasp.service.dto.ServizioDTO;
import it.csi.nivola.nivolasp.service.dto.SommarioServiziCloudDTO;
import it.csi.nivola.nivolasp.service.dto.StatoUtilizzatoriDTO;
import it.csi.nivola.nivolasp.service.mapper.cmp.DashboardMapper;

/**
 * REST controller Per Dashboard (riquasdri
 */
@RestController
@RequestMapping("/api/dashboard")
public class DashboardResource {

	@Autowired
	AuthorityApi authorityApi;

	@Autowired
	DashboardMapper dashboardMapper;
	@Autowired
	ComputeserviceApi computeserviceApi;

    private final Logger log = LoggerFactory.getLogger(DashboardResource.class);
    @Autowired
	DatabaseserviceApi databaseserviceApi;
    @Autowired
	UserService userService;
    @Autowired
	MetricheService metricheService;

	Map<String, List<MetricaDTO>> elencoCalcoliMetriche = null;
	
	List<MetricaDTO> elencoDecodificaMetriche = null;
	@Autowired
	RendicontoService rendicontoService;
	
	


	@PostConstruct
    public void post() {
		List<MetricaDTO> elencoRegoleDB = metricheService.findCalcolate();
		elencoCalcoliMetriche = elencoRegoleDB.stream().collect(Collectors.groupingBy(MetricaDTO::getServizio));
		elencoDecodificaMetriche = metricheService.findAllMetriche();
	}


    /**
     * CDU 020 - Sezione elenco dei servizi attivi per un account
     * 4. Box "Servizi attivi dell’Account" con solo accountId nel path
     * 5. Box "Compute Service" Con tipoServizio = 'ComputeService'
     * 6. Box "Istanze DBAAS" Con tipoServizio = 'DatabaseService'
     * 7. Box "Istanze STAAS"  Con tipoServizio = 'StorageService'
     * @param id Obbligatorio
     * @param tipoServizio Opzionale, per i box specializzati su un tipo di servizio: ComputeService, DatabaseService, StorageService
     * @return
     */
    @GetMapping("/account/{id}/activeservices")
    
    @Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER, 
		AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR,  AuthoritiesConstants.DIVISION_VIEWER,
		AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR,  AuthoritiesConstants.ACCOUNT_VIEWER})
    public ResponseEntity<List<ServizioDTO>> getServiziAttiviAccount(@PathVariable String id, String tipoServizio) {
    	GetActiveServicesByAccountResponseSchema response = authorityApi.v10NwsAccountsOidActiveservicesGet(id, tipoServizio);
    	if (response == null) {
    		return new ResponseEntity<List<ServizioDTO>>(HttpStatus.NOT_FOUND);
    	}



    	List<ServizioDTO> elenco = dashboardMapper.elencoServizi(response.getServices().getServiceContainer());
    	Integer countRunning = Integer.valueOf(0);
		Integer countStopped = Integer.valueOf(0);
		Integer countError = Integer.valueOf(0);
    	if ("ComputeService".equalsIgnoreCase(tipoServizio)) {
    		
    		List<String> elencoAccountId = new ArrayList<String>(1);
    		elencoAccountId.add(id);
    		DescribeInstancesApiResponseSchema risposta = computeserviceApi.v10NwsComputeservicesInstanceDescribeinstancesGet(-1, null, elencoAccountId, null, null, null, null, null, null, null, null, null, null, null);
    		
    		for (DescribeInstancesApiResponseSchemaDescribeInstancesResponseInstancesSet vm : risposta.getDescribeInstancesResponse().getReservationSet().get(0).getInstancesSet()) {
    			try {
	    			switch (vm.getInstanceState().getName().getValue()) {
	    			case "running" :
	    				countRunning ++;
	    			case "stopped":
	    				countStopped ++;
	    			default:
	    				countError ++;
	    			}
    			} catch (Exception e) {
    				countError ++;
    			}
    		}
    	}
    	
    	for (ServizioDTO serv : elenco) {
			if ("ComputeService".equalsIgnoreCase(serv.getPluginType())) {
				serv.setInstancesError(countError);
				serv.setInstancesRunning(countRunning);
				serv.setInstancesStopped(countStopped);
				MetricaDTO metricaTotVm = serv.getTotMetrics().stream().filter(metrica -> "vm_numero_vm_tot".equals(metrica.getMetric())).findFirst().orElse(null);
				serv.setInstances(metricaTotVm != null ? metricaTotVm.getValue().intValue() : 0);
			}
			if ("DatabaseService".equalsIgnoreCase(serv.getPluginType())) {
				MetricaDTO metricaTotVm = serv.getTotMetrics().stream().filter(metrica -> "db_numero_istanze_tot".equals(metrica.getMetric())).findFirst().orElse(null);
				serv.setInstances(metricaTotVm != null ? metricaTotVm.getValue().intValue() : 0);
			}
			gestioneMetricheCalcolate(serv);
		}
		HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", ""+System.currentTimeMillis());
		return new ResponseEntity<List<ServizioDTO>>(elenco, headers, HttpStatus.OK);
    }

    /**
     * CDU 020 - Sezione elenco costi account
     * 8. Box "Costi Account"
     * @param id
     * @param anno
     * @return
     */
    @GetMapping("/account/{id}/costi")
    
    @Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER, 
		AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR,  AuthoritiesConstants.DIVISION_VIEWER,
		AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR,  AuthoritiesConstants.ACCOUNT_VIEWER})
    public ResponseEntity<CostoBoxDTO> getCostiAccount(@PathVariable String id) {

    	return estraiCostiPerStrutturaOrganizzativa(id, StrutturaOrganizzativaEnum.ACCOUNT);
    }


    /**
     * CDU 020 - Sezione elenco costi divisione
     * 9. Box "Portafoglio Divisione"
     * @param id
     * @param anno
     * @return
     */
    @GetMapping("/divisione/{id}/costi")
    
    @Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER, 
		AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR,  AuthoritiesConstants.DIVISION_VIEWER})
    public ResponseEntity<CostoBoxDTO> getCostiDivisione(@PathVariable String id, String anno) {
    	log.info("COSTI DIVISIONE BEGIN");
    	return estraiCostiPerStrutturaOrganizzativa(id, StrutturaOrganizzativaEnum.DIVISION);
    }

    /**
     * CDU 020 - Sezione elenco costi organizzazione
     * 10. Box "Portafoglio Organizzazione"
     * @param divisionId
     * @param anno
     * @return
     */
    @GetMapping("/organizzazione/{id}/costi")
    
    @Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER})
    public ResponseEntity<CostoBoxDTO> getCostiOrganizzazione(@PathVariable String id, String anno) {
    	log.info("COSTI ORGANIZZAZIONE BEGIN");
    	return estraiCostiPerStrutturaOrganizzativa(id, StrutturaOrganizzativaEnum.ORGANIZATION);
    }

    /**
     * CDU 020 - Sezione servizi attivi per divisione
     * 11. Box "Risorse cloud della Divisione"
     * @param id
     * @return
     */
    @GetMapping("/divisione/{id}/risorse")
    
    @Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER, 
		AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR,  AuthoritiesConstants.DIVISION_VIEWER})
    public ResponseEntity<SommarioServiziCloudDTO> getRisorseDivisione(@PathVariable String id) {
    	GetActiveServicesByDivisionResponseSchema response = authorityApi.v10NwsDivisionsOidActiveservicesGet(id);
    	if (response == null) {
    		return new ResponseEntity<>((SommarioServiziCloudDTO)null, HttpStatus.NOT_FOUND);
    	}
    	SommarioServiziCloudDTO convertiServiziAttiviPerDivisione = dashboardMapper.convertiServiziAttiviPerDivisione(response.getServices());
    	for (ServizioDTO serv : convertiServiziAttiviPerDivisione.getServiceContainer()) {
			gestioneMetricheCalcolate(serv);
		}
    	
		return new ResponseEntity<SommarioServiziCloudDTO>(convertiServiziAttiviPerDivisione, HttpStatus.OK);
    }


	private void gestioneMetricheCalcolate(ServizioDTO serv) {
		//metriche calcolate
		if (elencoCalcoliMetriche.get(serv.getPluginType()) != null)
			for (MetricaDTO regola : elencoCalcoliMetriche.get(serv.getPluginType())) {
				Map<String,  List<MetricaDTO>> metricheRaggruppate = serv.getTotMetrics().stream().collect(Collectors.groupingBy(MetricaDTO::getMetric));
				List<MetricaDTO> metricheNormalizzate = new ArrayList<>();
				metricheRaggruppate.forEach((metrica, elencoVal) -> {
					MetricaDTO metricaNorm = elencoVal.get(0);
					metricaNorm.setValue(elencoVal.stream().mapToDouble(MetricaDTO::getValue).sum());
					metricheNormalizzate.add(metricaNorm);
				});
				
				serv.setTotMetrics(metricheNormalizzate);
				double valore = serv.getTotMetrics().stream().filter(metrica -> (metrica.getMetric().matches(regola.getRegola()))).mapToDouble(MetricaDTO::getValue).sum();
				MetricaDTO metricaCalcolata = new MetricaDTO();
				metricaCalcolata.setMetric(regola.getMetric());
				metricaCalcolata.setUnit(regola.getUnit());
				metricaCalcolata.setValue(valore);
				serv.getTotMetrics().add(metricaCalcolata);
			}
		
		serv.getTotMetrics().stream().forEach(e -> e.setDescrizione(
				elencoDecodificaMetriche.stream().filter(metrica -> metrica.getMetric().equals(e.getMetric())).findFirst().orElse(new MetricaDTO()).getDescrizione()));
	}


    @GetMapping("/organizzazione/{id}/risorse")
    
    @Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER})
    public ResponseEntity<SommarioServiziCloudDTO> getRisorseOrganizzazione(@PathVariable String id) {
    	log.debug("RISORSE per ORGANIZZAZIONE ID = " + id);
    	GetActiveServicesByOrganizationResponseSchema response = authorityApi.v10NwsOrganizationsOidActiveservicesGet(id);
    	if (response == null) {
    		return new ResponseEntity<>((SommarioServiziCloudDTO)null, HttpStatus.NOT_FOUND);
    	}
    	SommarioServiziCloudDTO convertiServiziAttiviPerOrganizzazione = dashboardMapper.convertiServiziAttiviPerDivisione(response.getServices());
    	for (ServizioDTO serv : convertiServiziAttiviPerOrganizzazione.getServiceContainer()) {
			gestioneMetricheCalcolate(serv);
		}
		return new ResponseEntity<SommarioServiziCloudDTO>(convertiServiziAttiviPerOrganizzazione, HttpStatus.OK);
    }


    @GetMapping("/all-services")
    
    @Secured(AuthoritiesConstants.BOADMIN)
    public ResponseEntity<SommarioServiziCloudDTO> getRisorseComplessive() {
    	GetNivolaActiveServicesResponseSchema response = authorityApi.v10NwsServicesActiveservicesGet();
    	if (response == null) {
    		return new ResponseEntity<>((SommarioServiziCloudDTO)null, HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<SommarioServiziCloudDTO>(dashboardMapper.convertiServiziAttiviPerDivisione(response.getServices()), HttpStatus.OK);
    }

    @GetMapping("/stato-utilizzatori")
    @Secured(AuthoritiesConstants.BOADMIN)
    public ResponseEntity<StatoUtilizzatoriDTO> statoUtilizzatori () {
    	StatoUtilizzatoriDTO statoUtilizzatoriDTO = new StatoUtilizzatoriDTO();
    	statoUtilizzatoriDTO.setTotaleUtenti(userService.countUtenti());
    	ListDivisionsResponseSchema responseDiv = authorityApi.v10NwsDivisionsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

    	ListAccountsResponseSchema responseAcc = authorityApi.v10NwsAccountsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);


    	ListOrganizationsResponseSchema responseOrg = authorityApi.v10NwsOrganizationsGet(-1, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

    	statoUtilizzatoriDTO.setTotaleOrganizzazioni(responseOrg.getTotal());
    	statoUtilizzatoriDTO.setTotaleDivisioni(responseDiv.getTotal());
    	statoUtilizzatoriDTO.setTotaleAccount(responseAcc.getTotal());

    	return new ResponseEntity<StatoUtilizzatoriDTO>(statoUtilizzatoriDTO, HttpStatus.OK);

    }


    /**
     * Siccome la struttura della risposta dell'estrazione dei costi è la stessa per account, divisione ed organizzazione si accorpa
     * la logica in un unico metodo e cambia solo il path di invocazione.
     * @param id
     * @param opzione
     * @return
     */
	private ResponseEntity<CostoBoxDTO> estraiCostiPerStrutturaOrganizzativa(String id, StrutturaOrganizzativaEnum opzione) {
		LocalDate todaydate = LocalDate.now();
    	List<RaggruppamentoCostiServizioDTO> response = null;
    	BigDecimal giornata = null;
    	switch (opzione) {
    	case ACCOUNT:
    		giornata = rendicontoService.costiGiornoAccount(id, new Date());
    		response = rendicontoService.costiAccount(id, 
    				Date.from(todaydate.withDayOfMonth(1).atStartOfDay(ZoneId.systemDefault()).toInstant()), 
    				Date.from(todaydate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
    		break;
    	case DIVISION:
    		giornata = rendicontoService.costiGiornoAccount(id, new Date());
    		response = rendicontoService.costiDivisione(id, 
    				Date.from(todaydate.withDayOfMonth(1).atStartOfDay(ZoneId.systemDefault()).toInstant()), 
    				Date.from(todaydate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
    		break;
    	case ORGANIZATION:
    		giornata = rendicontoService.costiGiornoAccount(id, new Date());
    		response = rendicontoService.costiOrganizzazione(id, 
    				Date.from(todaydate.withDayOfMonth(1).atStartOfDay(ZoneId.systemDefault()).toInstant()), 
    				Date.from(todaydate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
    		break;
    	case BACKOFFICE:
    		response = null;
    		break;
    	}

    	if (giornata == null) 
    		giornata = BigDecimal.ZERO;
    	BigDecimal meseInCorso = BigDecimal.valueOf(response.stream().mapToDouble(RaggruppamentoCostiServizioDTO::getCosto).sum());
    
    	CostoBoxDTO costo = new CostoBoxDTO();
    	costo.setCostoDellaGiornata(giornata);
    	costo.setCostoMeseInCorso(meseInCorso);
    	costo.setGiornoRiferimento(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(todaydate));
    	costo.setMeseRiferimento(""+todaydate.getMonthValue());
    	costo.setAnnoRiferimento(DateTimeFormatter.ofPattern("yyyy").format(todaydate));
    	return new ResponseEntity<CostoBoxDTO>(costo, HttpStatus.OK);
	}
}
