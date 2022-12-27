/*-
 * ========================LICENSE_START=================================
 * Api Remedy
 * %%
 * Copyright (C) 2022 Regione Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | Regione Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.integration.remedy.portal.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import it.csi.nivola.nivolasp.integration.remedy.model.CategoriaOperativaTicket;
import it.csi.nivola.nivolasp.integration.remedy.model.Ente;
import it.csi.nivola.nivolasp.integration.remedy.model.EnteUser;
import it.csi.nivola.nivolasp.integration.remedy.model.InfoNotaAttachments;
import it.csi.nivola.nivolasp.integration.remedy.model.InfoNotaWLog;
import it.csi.nivola.nivolasp.integration.remedy.model.LavorazioneTicket;
import it.csi.nivola.nivolasp.integration.remedy.model.RichiedenteDaAnagrafica;
import it.csi.nivola.nivolasp.integration.remedy.portal.dto.CategoriaOperativaTicketDto;
import it.csi.nivola.nivolasp.integration.remedy.portal.dto.EnteDto;
import it.csi.nivola.nivolasp.integration.remedy.portal.dto.InfoNotaAttachmentsDto;
import it.csi.nivola.nivolasp.integration.remedy.portal.dto.InfoNotaWLogDto;
import it.csi.nivola.nivolasp.integration.remedy.portal.dto.LavorazioneTicketDto;
import it.csi.nivola.nivolasp.integration.remedy.portal.dto.UtenteDto;

@Mapper(componentModel="spring")
public interface RemedyTypesMapper {    

	public EnteDto enteVersoPortale (Ente origine);
	
	public UtenteDto utenteVersoPortale (RichiedenteDaAnagrafica origine);
	
	public List<UtenteDto> listaUtenteVersoPortale (List<RichiedenteDaAnagrafica> origine);
	
	public CategoriaOperativaTicketDto categoriaOperativaVersoPortale (CategoriaOperativaTicket origine);
	
	public List<CategoriaOperativaTicketDto> elencoCategorieOperativaVersoPortale (List<CategoriaOperativaTicket> origine);
	
	public LavorazioneTicketDto dettaglioTicketVersoPortale (LavorazioneTicket origine);
	
	public InfoNotaAttachmentsDto lavorazioneVersoPortale (InfoNotaAttachments origine);
	
	public List<InfoNotaAttachmentsDto> elencoLavorazioneVersoPortale (List<InfoNotaAttachments> origine);
	
	public InfoNotaWLogDto risultatoInserimentoNotaVersoPortale (InfoNotaWLog origine);
	
	public EnteDto.TipologiaEnum tipologiaEnteVersoPortale (Ente.TipologiaEnum origine);
	
	public CategoriaOperativaTicketDto.TipologiaEnum tipologiaCategoriaOperativaVersoPortale (CategoriaOperativaTicket.TipologiaEnum origine);
	
	public LavorazioneTicketDto.StatoEnum statoLavorazioneVersoPortale (LavorazioneTicket.StatoEnum origine);
	
	public InfoNotaAttachmentsDto.TipologiaEnum map(it.csi.nivola.nivolasp.integration.remedy.model.InfoNotaAttachments.TipologiaEnum value);
	
	public InfoNotaWLogDto.TipologiaEnum map(InfoNotaWLog.TipologiaEnum value);

	public LavorazioneTicketDto.MotivoStatoEnum map(it.csi.nivola.nivolasp.integration.remedy.model.LavorazioneTicket.MotivoStatoEnum value);
	
	EnteDto map(EnteUser value);
	
	EnteDto.TipologiaEnum map(it.csi.nivola.nivolasp.integration.remedy.model.EnteUser.TipologiaEnum value);
}
