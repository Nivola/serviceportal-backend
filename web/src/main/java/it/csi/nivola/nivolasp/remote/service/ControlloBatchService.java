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
package it.csi.nivola.nivolasp.remote.service;

import org.springframework.scheduling.annotation.Async;

public interface ControlloBatchService {
	public String controllaBatchLibero() throws RemoteControlException;
	@Async
	public void eseguiTutto () throws RemoteControlException;
	@Async
	public void eseguiSoloCalcoloCosti() throws RemoteControlException;
	@Async
	public void eseguiSoloReportMensileSintetico() throws RemoteControlException;
	@Async
	public void eseguiSoloReportMensileDettaglio() throws RemoteControlException;

}
