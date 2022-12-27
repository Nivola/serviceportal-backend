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
package it.csi.nivola.nivolasp.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.SystemException;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.nivola.nivolasp.domain.SpAccountAttributo;
import it.csi.nivola.nivolasp.domain.SpMetricheDichiarate;
import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.repository.SpAccountAttributoRepository;
import it.csi.nivola.nivolasp.repository.SpDListinoImportoRepository;
import it.csi.nivola.nivolasp.repository.SpMetricheDichiarateRepository;
import it.csi.nivola.nivolasp.service.dto.CalcoloCostiVmDTO;
import it.csi.nivola.nivolasp.service.dto.ProspettoCostiStorageDTO;
import it.csi.nivola.nivolasp.service.dto.ProspettoCostiVmDTO;
import it.csi.nivola.nivolasp.service.dto.RichiestaCostiDbaasDTO;
import it.csi.nivola.nivolasp.service.dto.RichiestaCostiStorage;
import it.csi.nivola.nivolasp.service.dto.RichiestaCostiVmDTO;

@Service
public class CostiListinoService {
	
	@Autowired
	private SpAccountAttributoRepository spAccountAttributoRepository;
	
	@Autowired
	private SpDListinoImportoRepository spDListinoImportoRepository;
	
	@Autowired
	private SpMetricheDichiarateRepository spMetricheDichiarateRepository;
	
	private Map<String, String> decodificaEngineMetrica;
	
	private org.slf4j.Logger log = LoggerFactory.getLogger(CostiListinoService.class);
	
	public CostiListinoService() {
		decodificaEngineMetrica = new HashMap<>();
		decodificaEngineMetrica.put("postgresql", "pgsql");
		decodificaEngineMetrica.put("postgres", "pgsql");
		decodificaEngineMetrica.put("mysql", "mysql");
		decodificaEngineMetrica.put("oracle", "ora");
		decodificaEngineMetrica.put("sqlServer", "mssql");
		decodificaEngineMetrica.put("sqlserver", "mssql");
	}
	
	
	/**
	 * Calcolo della previsione costi di una VM che si sta creando
	 * @param richiestaCosti
	 * @return
	 * @throws BusinessException 
	 */
	public ProspettoCostiVmDTO calcolaProspettoVm (RichiestaCostiVmDTO richiestaCosti) throws BusinessException {
		
		ProspettoCostiVmDTO costiCalcolati = new ProspettoCostiVmDTO();
		
		String codiceTipoPrezzo = null;
		SpAccountAttributo attr = spAccountAttributoRepository.findByRefAccount(richiestaCosti.getAccountId());
		
		if (attr == null) {
			codiceTipoPrezzo = "ESE";
		} else {
			codiceTipoPrezzo = attr.getSpDTipoPrezzo().getCodice();
		}
			
		
		//inizializzazione costi di interesse a 0
		Double costoAnnualeCpu = 0d;
		Double costoAnnualeDiscoBase = 0d;
		Double costoAnnualeDiscoHi = 0d;
		Double costoAnnualeRam = 0d;
		
		// differenza tra locenza commerciale e OS per le metriche "semplici"
		if (richiestaCosti.isLicenzaCommerciale()) {
			costoAnnualeCpu = spDListinoImportoRepository.costoAnnualeMetricaTipo(codiceTipoPrezzo, "vm_vcpu_com", new Date());
			costoAnnualeDiscoBase = spDListinoImportoRepository.costoAnnualeMetricaTipo(codiceTipoPrezzo, "vm_gbdisk_low_com", new Date());
			costoAnnualeDiscoHi = spDListinoImportoRepository.costoAnnualeMetricaTipo(codiceTipoPrezzo, "vm_gbdisk_hi_com", new Date());
			costoAnnualeRam = spDListinoImportoRepository.costoAnnualeMetricaTipo(codiceTipoPrezzo, "vm_gbram_os", new Date());
		} else {
			costoAnnualeCpu = spDListinoImportoRepository.costoAnnualeMetricaTipo(codiceTipoPrezzo, "vm_vcpu_os", new Date());
			costoAnnualeDiscoBase = spDListinoImportoRepository.costoAnnualeMetricaTipo(codiceTipoPrezzo, "vm_gbdisk_low_os", new Date());
			costoAnnualeDiscoHi = spDListinoImportoRepository.costoAnnualeMetricaTipo(codiceTipoPrezzo, "vm_gbdisk_hi_os", new Date());
			costoAnnualeRam = spDListinoImportoRepository.costoAnnualeMetricaTipo(codiceTipoPrezzo, "vm_gbram_os", new Date());
		}
		
		//restituisco i dati di partenza per comodita' FE ed includere tutti i dati
		BeanUtils.copyProperties(richiestaCosti, costiCalcolati);
		
		/*
		 * si calcolano il costo mensile (unitario) e il costo totale (per la quantita' richiesta).
		 * Essendo una stima (i costi reali dipenderanno da altri fattori tra qui uptime...)
		 * non si pone troppa precisione nei calcoli.
		 */
		Double costoMensileCpu = costoAnnualeCpu / 12.0;
		costiCalcolati.setCostoUnitarioCpu(costoMensileCpu);
		costiCalcolati.setCostoTotaleCpu(richiestaCosti.getNumCpu() * costoMensileCpu);
		
		Double costoMensileDiscoBase = costoAnnualeDiscoBase / 12.0;
		costiCalcolati.setCostoUnitarioDiscoBase(costoMensileDiscoBase);
		costiCalcolati.setCostoTotaleDiscoBase(costoMensileDiscoBase * richiestaCosti.getGbDiscoBase());
		
		Double costoMensileDiscoHi = costoAnnualeDiscoHi / 12.0;
		costiCalcolati.setCostoUnitarioDiscoPrestazionale(costoMensileDiscoHi);
		costiCalcolati.setCostoTotaleDiscoPrestazionale(costoMensileDiscoHi * richiestaCosti.getGbDiscoPrestazionale());
		
		Double costoMensileRam = costoAnnualeRam / 12.0;
		costiCalcolati.setCostoUnitarioRam(costoMensileRam);
		costiCalcolati.setCostoTotaleRam(costoMensileRam * richiestaCosti.getGbRam());
		
		/**
		 * Calcolo delle metriche dichiarate
		 */
		List<SpMetricheDichiarate> metricheDichiateAccount = spMetricheDichiarateRepository.findMetricheDichiarateAccount(richiestaCosti.getAccountId());
		Map<String, CalcoloCostiVmDTO> mappaCostiDichiarati = new HashMap<String, CalcoloCostiVmDTO>();
		final String codicePrezzoLambda = codiceTipoPrezzo;
		metricheDichiateAccount.forEach(m -> {
			if (!m.getSpDMetriche().getNome().startsWith("tenant")) {
				Double costoAnnualeDich = spDListinoImportoRepository.costoAnnualeMetricaPerRange(codicePrezzoLambda, m.getSpDMetriche().getNome(), new Date(), m.getQta());
				CalcoloCostiVmDTO costo = new CalcoloCostiVmDTO(costoAnnualeDich / 12, costoAnnualeDich / 12);
				mappaCostiDichiarati.put(m.getSpDMetriche().getDescrizione(), costo);
			} else {
				Double costoAnnualeDich = spDListinoImportoRepository.costoAnnualeMetricaTipoTenant(codicePrezzoLambda, m.getSpDMetriche().getNome(), m.getQta(), new Date());
				CalcoloCostiVmDTO costo = new CalcoloCostiVmDTO(costoAnnualeDich / 12, costoAnnualeDich / 12);
				mappaCostiDichiarati.put(m.getSpDMetriche().getDescrizione(), costo);
			}
			
		});
		
		costiCalcolati.setCostiDichiarati(mappaCostiDichiarati);
		
		return costiCalcolati;
	}
	
	
	/**
	 * Calcolo della previsione costi di un DB che si sta creando
	 * @param richiestaCosti
	 * @return
	 * @throws SystemException 
	 */
	public ProspettoCostiVmDTO calcolaProspettoDb (RichiestaCostiDbaasDTO richiestaCosti) throws SystemException {
		
		ProspettoCostiVmDTO costiCalcolati = new ProspettoCostiVmDTO();
		
		String codiceTipoPrezzo = null;
		SpAccountAttributo attr = spAccountAttributoRepository.findByRefAccount(richiestaCosti.getAccountId());
		
		if (attr == null) {
			codiceTipoPrezzo = "ESE";
		} else {
			codiceTipoPrezzo = attr.getSpDTipoPrezzo().getCodice();
		}
		
		//inizializzazione costi di interesse a 0
		Double costoAnnualeCpu = 0d;
		Double costoAnnualeDiscoBase = 0d;
		Double costoAnnualeDiscoHi = 0d;
		Double costoAnnualeRam = 0d;
		
		log.warn("CODICE LISTINO = "  + codiceTipoPrezzo + " METRICA = " + decodificaEngineMetrica.get(richiestaCosti.getEngineType()));
		
		costoAnnualeCpu = spDListinoImportoRepository.costoAnnualeMetricaTipo(codiceTipoPrezzo, "db_"+ decodificaEngineMetrica.get(richiestaCosti.getEngineType()) + "_vcpu", new Date());
		costoAnnualeDiscoBase = spDListinoImportoRepository.costoAnnualeMetricaTipo(codiceTipoPrezzo, "db_"+ decodificaEngineMetrica.get(richiestaCosti.getEngineType()) + "_gbdisk_low", new Date());
		costoAnnualeDiscoHi = spDListinoImportoRepository.costoAnnualeMetricaTipo(codiceTipoPrezzo, "db_"+ decodificaEngineMetrica.get(richiestaCosti.getEngineType()) + "_gbdisk_hi", new Date());
		costoAnnualeRam = spDListinoImportoRepository.costoAnnualeMetricaTipo(codiceTipoPrezzo, "db_"+ decodificaEngineMetrica.get(richiestaCosti.getEngineType()) + "_gbram", new Date());
		
		
		//restituisco i dati di partenza per comodita' FE ed includere tutti i dati
		BeanUtils.copyProperties(richiestaCosti, costiCalcolati);
		
		/*
		 * si calcolano il costo mensile (unitario) e il costo totale (per la quantita' richiesta).
		 * Essendo una stima (i costi reali dipenderanno da altri fattori tra qui uptime...)
		 * non si pone troppa precisione nei calcoli.
		 */
		Double costoMensileCpu = costoAnnualeCpu / 12.0;
		costiCalcolati.setCostoUnitarioCpu(costoMensileCpu);
		costiCalcolati.setCostoTotaleCpu(richiestaCosti.getNumCpu() * costoMensileCpu);
		
		Double costoMensileDiscoBase = costoAnnualeDiscoBase / 12.0;
		costiCalcolati.setCostoUnitarioDiscoBase(costoMensileDiscoBase);
		costiCalcolati.setCostoTotaleDiscoBase(costoMensileDiscoBase * richiestaCosti.getGbDiscoBase());
		
		Double costoMensileDiscoHi = costoAnnualeDiscoHi / 12.0;
		costiCalcolati.setCostoUnitarioDiscoPrestazionale(costoMensileDiscoHi);
		costiCalcolati.setCostoTotaleDiscoPrestazionale(costoMensileDiscoHi * richiestaCosti.getGbDiscoPrestazionale());
		
		Double costoMensileRam = costoAnnualeRam / 12.0;
		costiCalcolati.setCostoUnitarioRam(costoMensileRam);
		costiCalcolati.setCostoTotaleRam(costoMensileRam * richiestaCosti.getGbRam());
		
		/**
		 * Calcolo delle metriche dichiarate
		 */
		/*List<SpMetricheDichiarate> metricheDichiateAccount = spMetricheDichiarateRepository.findMetricheDichiarateAccount(richiestaCosti.getAccountId());
		Map<String, CalcoloCostiVmDTO> mappaCostiDichiarati = new HashMap<String, CalcoloCostiVmDTO>();
		/*
		metricheDichiateAccount.forEach(m -> {
			if (!m.getSpDMetriche().getNome().startsWith("tenant")) {
				Double costoAnnualeDich = spDListinoImportoRepository.costoAnnualeMetricaTipo(codiceTipoPrezzo, m.getSpDMetriche().getNome(), new Date());
				CalcoloCostiVmDTO costo = new CalcoloCostiVmDTO(costoAnnualeDich / 12, costoAnnualeDich / 12);
				mappaCostiDichiarati.put(m.getSpDMetriche().getDescrizione(), costo);
			} else {
				Double costoAnnualeDich = spDListinoImportoRepository.costoAnnualeMetricaTipoTenant(codiceTipoPrezzo, m.getSpDMetriche().getNome(), m.getQta(), new Date());
				CalcoloCostiVmDTO costo = new CalcoloCostiVmDTO(costoAnnualeDich / 12, costoAnnualeDich / 12);
				mappaCostiDichiarati.put(m.getSpDMetriche().getDescrizione(), costo);
			}
			
		});
		*
		costiCalcolati.setCostiDichiarati(mappaCostiDichiarati);
		*/
		return costiCalcolati;
	}
	
	public ProspettoCostiStorageDTO calcolaProspettoStorage (RichiestaCostiStorage richiestaCosti) throws SystemException {
		
		ProspettoCostiStorageDTO costiCalcolati = new ProspettoCostiStorageDTO();
		
		String codiceTipoPrezzo = null;
		SpAccountAttributo attr = spAccountAttributoRepository.findByRefAccount(richiestaCosti.getAccountId());
		
		if (attr == null) {
			codiceTipoPrezzo = "ESE";
		} else {
			codiceTipoPrezzo = attr.getSpDTipoPrezzo().getCodice();
		}
		
		Double costoAnnualeUnitario = spDListinoImportoRepository.costoAnnualeStorage(codiceTipoPrezzo, "sd_gdisk_low", new Date(), richiestaCosti.getDimensione());
		costoAnnualeUnitario = costoAnnualeUnitario / 12;
		costiCalcolati.setCostoUnitarioStorage(costoAnnualeUnitario);
		costiCalcolati.setCostoTotaleStorage(costoAnnualeUnitario * richiestaCosti.getDimensione());
				
		return costiCalcolati;
	}
}
