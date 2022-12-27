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
package it.csi.nivola.nivolasp.remote.service.impl;

import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.lowagie.text.DocumentException;

import it.csi.nivola.nivolasp.remote.service.ControlloBatchService;
import it.csi.nivola.nivolasp.remote.service.RemoteControlException;
import it.csi.nivola.nivolasp.scheduled.NivolaScheduledTasks;

@Service
public class ControlloBatchServiceImpl implements ControlloBatchService{
	
	
	private NivolaScheduledTasks nivolaScheduledTasks;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	

	@Override
	public String controllaBatchLibero() throws RemoteControlException {
		return nivolaScheduledTasks.isSchedulingEnabled() ? "SI" : "NO";
	}

	@Override
	@Async
	public void eseguiTutto() throws RemoteControlException {
		try {
			nivolaScheduledTasks.calcoloCosti();
		}
		catch (FileNotFoundException | DocumentException e) {
			log.error("Errore durante l'invocazione manuale del calcolo costi completo:", e);
		}
	}

	@Override
	@Async
	public void eseguiSoloCalcoloCosti() throws RemoteControlException {
		
	}

	@Override
	@Async
	public void eseguiSoloReportMensileSintetico() throws RemoteControlException {
		nivolaScheduledTasks.reportCostoMensile();
	}

	@Override
	@Async
	public void eseguiSoloReportMensileDettaglio() throws RemoteControlException {
		nivolaScheduledTasks.reportCostoGiornaliero();
	}

	public NivolaScheduledTasks getNivolaScheduledTasks() {
		return nivolaScheduledTasks;
	}

	@Autowired
	public void setNivolaScheduledTasks(NivolaScheduledTasks nivolaScheduledTasks) {
		this.nivolaScheduledTasks = nivolaScheduledTasks;
	}
}
