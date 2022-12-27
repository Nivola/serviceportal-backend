/*-
 * ========================LICENSE_START=================================
 * Servizi di accesso dati
 * %%
 * Copyright (C) 2022 Regione Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | Regione Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.service.dto;

import java.io.Serializable;

public class RegolaSecurityGroup implements Serializable {

	private static final long serialVersionUID = -2387514998951255774L;

	private String gruppoAppartenenza;
	
	private Integer daPorta;
	
	private Integer aPorta;
	
	private String protocollo;
	
	private String cidrIp;
	
	private String descrizione;
	
	private String cidrIpV6;
	
	private String descrizioneV6;
	
	private String prefixListId;
	
	private String descrizionePrefix;
	
	private String gruppoDestinazione;
	
	private TipoRegoleEnum tipoRegola;

	public String getGruppoAppartenenza() {
		return gruppoAppartenenza;
	}

	public void setGruppoAppartenenza(String gruppoAppartenenza) {
		this.gruppoAppartenenza = gruppoAppartenenza;
	}

	public Integer getDaPorta() {
		return daPorta;
	}

	public void setDaPorta(Integer daPorta) {
		this.daPorta = daPorta;
	}

	public Integer getaPorta() {
		return aPorta;
	}

	public void setaPorta(Integer aPorta) {
		this.aPorta = aPorta;
	}

	public String getProtocollo() {
		return protocollo;
	}

	public void setProtocollo(String protocollo) {
		this.protocollo = protocollo;
	}

	public String getCidrIp() {
		return cidrIp;
	}

	public void setCidrIp(String cidrIp) {
		this.cidrIp = cidrIp;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCidrIpV6() {
		return cidrIpV6;
	}

	public void setCidrIpV6(String cidrIpV6) {
		this.cidrIpV6 = cidrIpV6;
	}

	public String getDescrizioneV6() {
		return descrizioneV6;
	}

	public void setDescrizioneV6(String descrizioneV6) {
		this.descrizioneV6 = descrizioneV6;
	}

	public String getPrefixListId() {
		return prefixListId;
	}

	public void setPrefixListId(String prefixListId) {
		this.prefixListId = prefixListId;
	}

	public String getDescrizionePrefix() {
		return descrizionePrefix;
	}

	public void setDescrizionePrefix(String descrizionePrefix) {
		this.descrizionePrefix = descrizionePrefix;
	}

	public String getGruppoDestinazione() {
		return gruppoDestinazione;
	}

	public void setGruppoDestinazione(String gruppoDestinazione) {
		this.gruppoDestinazione = gruppoDestinazione;
	}
	
	
	
	public TipoRegoleEnum getTipoRegola() {
		return tipoRegola;
	}

	public void setTipoRegola(TipoRegoleEnum tipoRegola) {
		this.tipoRegola = tipoRegola;
	}



	public enum TipoRegoleEnum {
		INGRESSO, USCITA
	}
}
