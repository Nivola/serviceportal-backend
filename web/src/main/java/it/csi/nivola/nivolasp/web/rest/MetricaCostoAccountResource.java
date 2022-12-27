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
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.csi.nivola.nivolasp.aop.logging.AzioneDispositiva;
import it.csi.nivola.nivolasp.domain.SpMetricheDichiarate;
import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.security.SecurityUtils;
import it.csi.nivola.nivolasp.service.MetricheService;
import it.csi.nivola.nivolasp.service.dto.CodiceEtichettaDescrizioneDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoDTO;
import it.csi.nivola.nivolasp.service.dto.EsitoEnum;
import it.csi.nivola.nivolasp.service.dto.MetricaDTO;
import it.csi.nivola.nivolasp.service.dto.MetricaListinoDefinizioneDTO;
import it.csi.nivola.nivolasp.service.dto.ValoreCostoListinoDTO;
import it.csi.nivola.nivolasp.service.dto.ValoreStoricoCostoListinoDTO;
import it.csi.nivola.nivolasp.service.mapper.MetricheMapper;

/**
 * Rest controller per la gestione della sezione metriche - listino costi contrattuali in carico al service portal
 */
@RestController
@RequestMapping("/api")
public class MetricaCostoAccountResource {
	
	@Autowired
	MetricheService metricheService;
	
	@Autowired
	MetricheMapper metricheMapper;
	
	private final List<CodiceEtichettaDescrizioneDTO> elencoValoriAmmessiTenant;
	
	@Autowired
	public MetricaCostoAccountResource() {
		elencoValoriAmmessiTenant = new ArrayList<>(6);
		CodiceEtichettaDescrizioneDTO valore = new CodiceEtichettaDescrizioneDTO();
		valore.setCodice("1");
		valore.setDescrizione("Numero di tenant (0,1) con livello di gestione 'Developer'");
		valore.setEtichetta("Developer");
		elencoValoriAmmessiTenant.add(valore);	
		
		valore = new CodiceEtichettaDescrizioneDTO();
		valore.setCodice("2");
		valore.setDescrizione("Numero di tenant (0,1) con livello di gestione 'Standard'");
		valore.setEtichetta("Standard");
		elencoValoriAmmessiTenant.add(valore);	
		
		valore = new CodiceEtichettaDescrizioneDTO();
		valore.setCodice("3");
		valore.setDescrizione("Numero di tenant (0,1) con livello di gestione 'Standard orario esteso'");
		valore.setEtichetta("Standard orario esteso");
		elencoValoriAmmessiTenant.add(valore);	
		
		valore = new CodiceEtichettaDescrizioneDTO();
		valore.setCodice("4");
		valore.setDescrizione("Numero di tenant (0,1) con livello di gestione 'Premium'");
		valore.setEtichetta("Premium");
		elencoValoriAmmessiTenant.add(valore);	
		
		valore = new CodiceEtichettaDescrizioneDTO();
		valore.setCodice("5");
		valore.setDescrizione("Numero di tenant (0,1) con livello di gestione 'Premium orario esteso'");
		valore.setEtichetta("Premium orario esteso");
		elencoValoriAmmessiTenant.add(valore);	
		
		valore = new CodiceEtichettaDescrizioneDTO();
		valore.setCodice("6");
		valore.setDescrizione("Numero di tenant (0,1) con livello di gestione 'Premium H24'");
		valore.setEtichetta("Premium H24");
		elencoValoriAmmessiTenant.add(valore);	
	}

	/**
	 * Restituisce tutte le metriche di tipo "COSTO" per la costruzione dell'interfaccia di inserimento costi a listino
	 * per account. Le definizioni "semplici" vengono gestite in automaitco mentre il livello "tenant" segue una logica 
	 * più complessa di valori ammessi ed è gestito manualmente. 
	 * @return
	 */
	@GetMapping("metrichecosto/descrivi")
	public ResponseEntity<List<MetricaListinoDefinizioneDTO>> elencoMetricheCostoMetadati () {
		List<MetricaDTO> elencoMetricheListino = metricheService.findListino();
		ArrayList<MetricaListinoDefinizioneDTO> elencoDefinizioni = new ArrayList<>();
		
		for (MetricaDTO e : elencoMetricheListino) {
			if (!e.getMetric().startsWith("tenant")) {
				elencoDefinizioni.add(metricheMapper.toMetricaDefinizioneNumerico(e));
			} else {
				MetricaListinoDefinizioneDTO livelloTenant = metricheMapper.toMetricaDefinizioneNumerico(e);
				livelloTenant.setElencoValoriAmmessi(elencoValoriAmmessiTenant);
				elencoDefinizioni.add(livelloTenant);
			}
		}
		return new ResponseEntity<List<MetricaListinoDefinizioneDTO>>(elencoDefinizioni, HttpStatus.OK);
	}
	
	
	/**
	 * Restituisce l'elenco delle metriche dell'account specificato
	 * @param idAccount
	 * @return
	 */
	@GetMapping("accountcmp/{idAccount}/metrichecosto")
	public ResponseEntity<List<ValoreCostoListinoDTO>> elencoMetricheCostoAccount (@PathVariable String idAccount) {

		List<SpMetricheDichiarate> findMetricheDichiarateAccount = metricheService.findMetricheDichiarateAccount(idAccount);
		//devo togliere i doppioni con data fine null e ultima data fine valorizzata
		/*List<SpMetricheDichiarate> filtrati = findMetricheDichiarateAccount.stream().filter(e -> e.getDataFineValidita() == null).collect(Collectors.toList());
		findMetricheDichiarateAccount.stream().filter(e -> e.getDataFineValidita() != null).forEach(e -> {
			if (!filtrati.stream().anyMatch(f -> f.getSpDMetriche().getNome().equals(e.getSpDMetriche().getNome()))) {
				filtrati.add(e);
			}
		});
		return new ResponseEntity<List<ValoreCostoListinoDTO>>(metricheMapper.convertiElencoMetricaDichiarataInValoreCosto(filtrati),  HttpStatus.OK);*/
		return new ResponseEntity<List<ValoreCostoListinoDTO>>(metricheMapper.convertiElencoMetricaDichiarataInValoreCosto(findMetricheDichiarateAccount),  HttpStatus.OK);
	}
	
	@GetMapping("accountcmp/{idAccount}/metrichecosto/{nome}")
	public ResponseEntity<ValoreStoricoCostoListinoDTO> storicoVoceCosto (@PathVariable String idAccount, @PathVariable String nome) throws BusinessException {
		ValoreStoricoCostoListinoDTO voce = null;
		List<SpMetricheDichiarate> lista = metricheService.findMetricaConStorico(idAccount, nome);
		if (lista != null && lista.size() > 0) {
			voce = new ValoreStoricoCostoListinoDTO();
			voce.setAccountUuid(lista.get(0).getRefAccount());
			voce.setDataA(lista.get(0).getDataFineValidita());
			voce.setDataCancellazione(lista.get(0).getDataCancellazione());
			voce.setDataDa(lista.get(0).getDataInizioValidita());
			voce.setDataModifica(lista.get(0).getDataModifica());
			voce.setDescrizioneMetrica(lista.get(0).getSpDMetriche().getDescrizione());
			voce.setEtichettaValore(decodificaTenant(lista.get(0)));
			voce.setIdValore(lista.get(0).getId());
			voce.setNomeMetricaDefinizione(lista.get(0).getSpDMetriche().getNome());
			voce.setQuantita(lista.get(0).getQta());
			lista.remove(0);
			voce.setElencoStorici(metricheMapper.convertiElencoMetricaDichiarataInValoreCosto(lista));
		}
		
		return new ResponseEntity<ValoreStoricoCostoListinoDTO>(voce, HttpStatus.OK);
	}
	
	
	/**
	 * Elimina - logicamente impostando la data fine validità - una voce di costo del listino per l'account specificato
	 * @param idAccount
	 * @param nome
	 * @return
	 * @throws BusinessException
	 */
	@DeleteMapping("accountcmp/{idAccount}/metrichecosto/{idMetrica}")
	@AzioneDispositiva
	public ResponseEntity<EsitoDTO> eliminaVoceCosto (@PathVariable String idAccount, @PathVariable String idMetrica) throws BusinessException {
		
//		controllaAccountNome(idAccount, idMetrica);
		
		metricheService.delete(idAccount, idMetrica, BigInteger.valueOf(SecurityUtils.getCurrentUser().getId()));
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "Voce di costo eliminata correttamente"), HttpStatus.OK);
	}

	
	/**
	 * Aggiorna una voce di costo del listino per l'account specificato.
	 * Al momento attuale è possibile solo modificare la data fine validità, mentre per cambi di quantità si storicizza,
	 * in modo da conservare correttamente la cronologia dei costi.
	 * @param idAccount
	 * @param costo
	 * @return
	 * @throws BusinessException
	 */
	@PutMapping("accountcmp/{idAccount}/metrichecosto")
	@AzioneDispositiva
	public ResponseEntity<EsitoDTO> impostaDataFineVoceCosto (@PathVariable String idAccount, @RequestBody ValoreCostoListinoDTO costo) throws BusinessException {
		
		controllaAccountNome(idAccount, costo.getIdValore());
		
		metricheService.update(idAccount, costo, BigInteger.valueOf(SecurityUtils.getCurrentUser().getId()));
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "ok.voceCosto", "Voce di costo aggiornata correttamente"), HttpStatus.OK);
	
	}
	
	
	/**
	 * Crea una nuova voce di costo per l'account specificato.
	 * @param idAccount
	 * @param costo
	 * @return
	 * @throws BusinessException
	 */
	@PostMapping("accountcmp/{idAccount}/metrichecosto")
	@AzioneDispositiva
	public ResponseEntity<EsitoDTO> inserisciVoceCosto (@PathVariable String idAccount, @RequestBody ValoreCostoListinoDTO costo) throws BusinessException {
		
		controllaAccountNome(idAccount, costo.getNomeMetricaDefinizione());
		if (costo.getDataDa() == null)
			throw new BusinessException("La data di inizio validita' deve essere valorizzata");
		
		if (costo.getQuantita() == null  || costo.getQuantita() <= 0)
			throw new BusinessException("Quantita' non valida");
		
		if (costo.getDataA() != null && costo.getDataDa().after(costo.getDataA()))
			throw new BusinessException("La data fine valitia' specificata e' precedente a quella di inizio");
		
		metricheService.inserisci(idAccount, costo, BigInteger.valueOf(SecurityUtils.getCurrentUser().getId()));
		return new ResponseEntity<EsitoDTO>(new EsitoDTO(EsitoEnum.OK, "0001", "Voce di costo aggiornata correttamente"), HttpStatus.OK);
	}

	/*
	 * Controlla che accountId e il nome della metrica di riferimento siano valorizzati
	 * @param idAccount
	 * @param nome
	 * @throws BusinessException
	 */
	private void controllaAccountNome(String idAccount, String nome) throws BusinessException {
		// controlli formali INIZIO
		if (StringUtils.isEmpty(idAccount))
			throw new BusinessException("idAccount", "err.obbligatorio");
		
		if (StringUtils.isEmpty(nome))
			throw new BusinessException("Id Metrica", "err.obbligatorio");
		// controlli formali FINE
	}
	
	/*
	 * Decodifica del tenant
	 */
	public String decodificaTenant (SpMetricheDichiarate from) {
    	if (from.getSpDMetriche().getNome().contains("tenant")&& from.getQta()!= null) {
	    	switch (from.getQta().intValue()) {
			case 1:
				return "Developer";
			case 2:
				return "Standard";
			case 3:
				return "Standard orario esteso";
			case 4:
				return "Premium";
			case 5:
				return "Premium orario esteso";
			case 6:
				return "Premium H24";
			default:
				return null;
			}
    	}
    	return null;
    }
}
