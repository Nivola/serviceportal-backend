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
package it.csi.nivola.nivolasp.remote.service;

public interface ControlloBatchService {
	
	public String controllaBatchLibero() throws RemoteControlException;
	
	public void eseguiTutto () throws RemoteControlException;
	
	public void eseguiSoloCalcoloCosti() throws RemoteControlException;
	
	public void eseguiSoloReportMensileSintetico() throws RemoteControlException;
	
	public void eseguiSoloReportMensileDettaglio() throws RemoteControlException;

}
