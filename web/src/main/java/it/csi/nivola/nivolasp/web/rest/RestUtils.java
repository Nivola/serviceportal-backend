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

import java.util.ArrayList;
import java.util.List;

import it.csi.nivola.nivolasp.domain.SpUser;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetAccountUsersResponseSchemaUsers;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetDivisionUsersResponseSchemaUsers;
import it.csi.nivola.nivolasp.service.dto.UtenteAccountDTO;

/**
 * Classe di utilita' poer i resource
 */
public class RestUtils {



	public static List<UtenteAccountDTO> composizioneUtentiElencoDIVISIONE(List<GetDivisionUsersResponseSchemaUsers> list, Integer count, List<SpUser> elencoUtentiPortale, String strutturaOrganizzativaRuolo, String nomeStrutturaOrganizzativa) {
		List<UtenteAccountDTO> elencoRisposta = new ArrayList<>(count);
		for (GetDivisionUsersResponseSchemaUsers utenteCMP : list) {
			UtenteAccountDTO utente = new UtenteAccountDTO();
			
			// dati di default, nel caso in cui l'utente non sia censito anche sul portale
			utente.setNome(utenteCMP.getDesc());
			utente.setRuolo(utenteCMP.getRole());
			utente.setUsername(utenteCMP.getName());
			utente.setStrutturaOrganizzativaRuolo(strutturaOrganizzativaRuolo);
			utente.setNomeStrutturaOrganizzativa(nomeStrutturaOrganizzativa);
			
			SpUser utentePortale = trovaUtentePortale(elencoUtentiPortale, utenteCMP.getName());
			if (utentePortale != null ) {
				utente.setId(utentePortale.getId());
				utente.setUtentePortale(true);
				utente.setEmail(utentePortale.getEmail());
				utente.setNome(utentePortale.getNome() + " " + utentePortale.getCognome());
			}
			
			elencoRisposta.add(utente);
		}
		return elencoRisposta;
	}
	
	public static List<UtenteAccountDTO> composizioneUtentiElencoACCOUNT(List<GetAccountUsersResponseSchemaUsers> list, Integer count, List<SpUser> elencoUtentiPortale, String strutturaOrganizzativaRuolo, String nomeStrutturaOrganizzativa) {
		List<UtenteAccountDTO> elencoRisposta = new ArrayList<>(count);
		for (GetAccountUsersResponseSchemaUsers utenteCMP : list) {
			UtenteAccountDTO utente = new UtenteAccountDTO();
			
			// dati di default, nel caso in cui l'utente non sia censito anche sul portale
			utente.setNome(utenteCMP.getDesc());
			utente.setRuolo(utenteCMP.getRole());
			utente.setUsername(utenteCMP.getName());
			utente.setStrutturaOrganizzativaRuolo(strutturaOrganizzativaRuolo);
			utente.setNomeStrutturaOrganizzativa(nomeStrutturaOrganizzativa);
			
			SpUser utentePortale = trovaUtentePortale(elencoUtentiPortale, utenteCMP.getName());
			if (utentePortale != null ) {
				utente.setId(utentePortale.getId());
				utente.setUtentePortale(true);
				utente.setEmail(utentePortale.getEmail());
				utente.setNome(utentePortale.getNome() + " " + utentePortale.getCognome());
			}
			
			elencoRisposta.add(utente);
		}
		return elencoRisposta;
	}
	

	
	private static SpUser trovaUtentePortale (List<SpUser> elencoUtentiPortale, String name) {
		for (SpUser ut : elencoUtentiPortale) {
			if (ut.getCmpUsername().equals(name))
				return ut;
		}
		return null;
	}
}
