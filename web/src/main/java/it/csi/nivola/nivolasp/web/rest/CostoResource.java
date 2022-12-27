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

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.csi.nivola.nivolasp.integration.rest.api.service.AuthorityApi;
import it.csi.nivola.nivolasp.security.AuthoritiesConstants;
import it.csi.nivola.nivolasp.service.MetricheService;
import it.csi.nivola.nivolasp.service.RendicontoService;
import it.csi.nivola.nivolasp.service.dto.CostiStrutturaRaggruppatiServizioDTO;
import it.csi.nivola.nivolasp.service.dto.CostoDelMeseDTO;
import it.csi.nivola.nivolasp.service.dto.CostoDelMeseRigaDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoEnum;
import it.csi.nivola.nivolasp.service.dto.InfoGraficoServizioDTO;
import it.csi.nivola.nivolasp.service.dto.RaggruppamentoCostiServizioDTO;
import it.csi.nivola.nivolasp.service.dto.ValutaDTO;

@RestController
@RequestMapping("/api")
public class CostoResource {

	@Autowired
	private AuthorityApi authorityApi;
	
	@Autowired
	private RendicontoService rendicontoService;
	
	@Autowired
	private MetricheService metricheService;


	/**
	 * Popolamento del grafico costi per ACCOUNT
	 * @param idAccount
	 * @return
	 */
	@GetMapping("/costo/grafico")
	@Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER, 
		AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR,  AuthoritiesConstants.DIVISION_VIEWER,
		AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR,  AuthoritiesConstants.ACCOUNT_VIEWER})
	public ResponseEntity<List<InfoGraficoServizioDTO>> datiGraficoCosti ( @RequestParam(value="idAccount") String idAccount) {
		List<InfoGraficoServizioDTO> risultato = rendicontoService.costiGraficoAccount(idAccount);
		return new ResponseEntity<List<InfoGraficoServizioDTO>>(risultato, HttpStatus.OK);
	}

	
	/**
	 * Popolamento del grafico costi per DIVISIONE
	 * @param idDivisione
	 * @return
	 */
	@GetMapping("divisione/costo/grafico")
	@Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER, 
		AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR,  AuthoritiesConstants.DIVISION_VIEWER})
	public ResponseEntity<List<InfoGraficoServizioDTO>> datiGraficoCostiDivisione (@RequestParam(name="uuidStruttura", required=true) String uuidStruttura) {
		List<InfoGraficoServizioDTO> risultato = rendicontoService.costiGraficoDivisione(uuidStruttura);
		return new ResponseEntity<List<InfoGraficoServizioDTO>>(risultato, HttpStatus.OK);
	}
	
	/**
	 * Elenco dei costi suddivisi per account di una data divisione
	 * @param uuidStruttura
	 * @return
	 */
	@GetMapping("divisione/costo/grafico/account")
	@Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER, 
		AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR,  AuthoritiesConstants.DIVISION_VIEWER})
	public ResponseEntity<List<CostiStrutturaRaggruppatiServizioDTO>> datiGraficoCostiAccountDellaDivisione (@RequestParam(name="uuidStruttura", required=true) String uuidStruttura) {
		List<CostiStrutturaRaggruppatiServizioDTO> risultato = rendicontoService.costiDivisionePerAccount(uuidStruttura);
		return new ResponseEntity<List<CostiStrutturaRaggruppatiServizioDTO>>(risultato, HttpStatus.OK);
	}
	
	/**
	 * Popolamento del grafico costi per ORGANIZZAZIONE
	 * @param idDivisione
	 * @return
	 */
	@GetMapping("organizzazione/costo/grafico")
	@Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER, 
		AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR,  AuthoritiesConstants.DIVISION_VIEWER})
	public ResponseEntity<List<InfoGraficoServizioDTO>> datiGraficoCostiOrganizzazione (@RequestParam(name="uuidStruttura", required=true) String uuidStruttura) {
		List<InfoGraficoServizioDTO> risultato = rendicontoService.costiGraficoOrganizzazione(uuidStruttura);
		return new ResponseEntity<List<InfoGraficoServizioDTO>>(risultato, HttpStatus.OK);
	}
	

	/**
	 * Elenco dei costi suddivisi per account di una data divisione
	 * @param uuidStruttura
	 * @return
	 */
	@GetMapping("organizzazione/costo/grafico/divisione")
	@Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER, 
		AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR,  AuthoritiesConstants.DIVISION_VIEWER})
	public ResponseEntity<List<CostiStrutturaRaggruppatiServizioDTO>> datiGraficoCostiDivisioniOrganizzazione (@RequestParam(name="uuidStruttura", required=true) String uuidStruttura) {
		List<CostiStrutturaRaggruppatiServizioDTO> risultato = rendicontoService.costiOrganizzazionePerDivisione(uuidStruttura);
		return new ResponseEntity<List<CostiStrutturaRaggruppatiServizioDTO>>(risultato, HttpStatus.OK);
	}
	
	@GetMapping("/costo/mese")
	@Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER, 
		AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR,  AuthoritiesConstants.DIVISION_VIEWER,
		AuthoritiesConstants.ACCOUNT_ADMIN, AuthoritiesConstants.ACCOUNT_OPERATOR,  AuthoritiesConstants.ACCOUNT_VIEWER})
	public ResponseEntity<CostoDelMeseDTO> datiCostiMese ( @RequestParam(value="idAccount") String idAccount) {
		return composizioneCostiMensile(idAccount, StrutturaOrganizzativaEnum.ACCOUNT);
	}
	
	@GetMapping("divisione/costo/mese")
	@Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER, 
		AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR,  AuthoritiesConstants.DIVISION_VIEWER})
	public ResponseEntity<CostoDelMeseDTO> datiCostiMeseDivisione (@RequestParam(name="uuidStruttura", required=true) String uuidStruttura) {
		return composizioneCostiMensile(uuidStruttura, StrutturaOrganizzativaEnum.DIVISION);
	}
	
	@GetMapping("organizzazione/costo/mese")
	@Secured({AuthoritiesConstants.BOADMIN, AuthoritiesConstants.ORGANIZATION_ADMIN, 
		AuthoritiesConstants.ORGANIZATION_OPERATOR,  AuthoritiesConstants.ORGANIZATION_VIEWER, 
		AuthoritiesConstants.DIVISION_ADMIN, AuthoritiesConstants.DIVISION_OPERATOR,  AuthoritiesConstants.DIVISION_VIEWER})
	public ResponseEntity<CostoDelMeseDTO> datiCostiMeseOrganizzazione (@RequestParam(name="uuidStruttura", required=true) String uuidStruttura) {
		return composizioneCostiMensile(uuidStruttura, StrutturaOrganizzativaEnum.ORGANIZATION);
	}
	
	@GetMapping("admin/pulizia")
	@Secured({AuthoritiesConstants.BOADMIN})
	public ResponseEntity<EsitoDTO> adminCancellazioneGiorniBatch (@RequestParam(name="uuid", required=true) String uuid, @RequestParam(name="giornoPartenza", required=true) LocalDate giornoPartenza ) {
		rendicontoService.cancellaGiorni(uuid, giornoPartenza);
		EsitoDTO esito = new EsitoDTO(EsitoEnum.OK, "0000", "Cancellate righe di costo a partire dal " + giornoPartenza);
		return new ResponseEntity<EsitoDTO>(esito, HttpStatus.OK);
	}
	
	/*
	 * Estrae i dati di costo di una data struttura organizzativa per mese
	 * L'interfaccia dei servizi dei costi e' la stessa per tutte le strutture organizzative, cambia solo il path.
	 */
	private ResponseEntity<CostoDelMeseDTO> composizioneCostiMensile(String identificativoUnitaOrganizzativa, StrutturaOrganizzativaEnum struttra) {
		CostoDelMeseDTO risposta = new CostoDelMeseDTO();

		LocalDate dataOggi = LocalDate.now();
		LocalDate dataInizioMese = dataOggi.withDayOfMonth(1);

    	risposta.setPeriodoA(dataOggi.minusDays(1).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    	risposta.setPeriodoDA(dataInizioMese.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

    	StringBuilder sb = new StringBuilder();
    	String mese  = DateTimeFormatter.ofPattern("MMMM").format(dataInizioMese);
    	mese = mese.substring(0,1).toUpperCase() + mese.substring(1).toLowerCase();
    	sb.append(mese);
    	sb.append(" ");
    	sb.append(DateTimeFormatter.ofPattern("yyyy").format(dataInizioMese));
    	risposta.setPeriodo(sb.toString());
    	
    	List<RaggruppamentoCostiServizioDTO> response = null;
    	
    	String nomeStruttura = "";

    	switch (struttra) {
    	case ACCOUNT:
    		response = rendicontoService.costiAccount(identificativoUnitaOrganizzativa, 
    				Date.from(dataInizioMese.atStartOfDay(ZoneId.systemDefault()).toInstant()), 
    				Date.from(dataOggi.atStartOfDay(ZoneId.systemDefault()).toInstant()));
    		
    		nomeStruttura = authorityApi.v10NwsAccountsOidGet(identificativoUnitaOrganizzativa).getAccount().getName();
    		break;
    	case DIVISION:
    		response = rendicontoService.costiDivisione(identificativoUnitaOrganizzativa, 
    				Date.from(dataInizioMese.atStartOfDay(ZoneId.systemDefault()).toInstant()), 
    				Date.from(dataOggi.atStartOfDay(ZoneId.systemDefault()).toInstant()));
    		nomeStruttura = authorityApi.v10NwsDivisionsOidGet(identificativoUnitaOrganizzativa).getDivision().getName();
    		break;
    	case ORGANIZATION:
    		response = rendicontoService.costiOrganizzazione(identificativoUnitaOrganizzativa, 
    				Date.from(dataInizioMese.atStartOfDay(ZoneId.systemDefault()).toInstant()), 
    				Date.from(dataOggi.atStartOfDay(ZoneId.systemDefault()).toInstant()));
    		nomeStruttura = authorityApi.v10NwsOrganizationsOidGet(identificativoUnitaOrganizzativa).getOrganization().getName();
    		break;//
    	case BACKOFFICE:
    		response = null;
    		break;
    	}
    	risposta.setTotale(response.size());
    	risposta.setTotaleConsumiNonRendicontati(response.stream().mapToDouble(RaggruppamentoCostiServizioDTO::getCosto).sum());
    	risposta.setValuta(new ValutaDTO());
    	risposta.setNomeStruttura(nomeStruttura);
    	List<CostoDelMeseRigaDTO> elencoServizi = new ArrayList<>(response.size());
    	response.stream().forEach(e ->
    		{
    		CostoDelMeseRigaDTO  costo = new CostoDelMeseRigaDTO();
        	costo.setCosto(e.getCosto());
        	costo.setNome(e.getServizio().getDescrizione());
        	elencoServizi.add(costo);
    		}
    	);

		
		risposta.setElencoServizi(elencoServizi);
		
		return new ResponseEntity<CostoDelMeseDTO>(risposta, HttpStatus.OK);
	}

	public AuthorityApi getAuthorityApi() {
		return authorityApi;
	}

	public void setAuthorityApi(AuthorityApi authorityApi) {
		this.authorityApi = authorityApi;
	}

	public RendicontoService getRendicontoService() {
		return rendicontoService;
	}

	public void setRendicontoService(RendicontoService rendicontoService) {
		this.rendicontoService = rendicontoService;
	}

	public MetricheService getMetricheService() {
		return metricheService;
	}

	public void setMetricheService(MetricheService metricheService) {
		this.metricheService = metricheService;
	}
	
}
