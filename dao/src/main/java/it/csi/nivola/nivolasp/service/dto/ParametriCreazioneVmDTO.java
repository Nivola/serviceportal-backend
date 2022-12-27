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
package it.csi.nivola.nivolasp.service.dto;

import java.io.Serializable;
import java.util.List;

public class ParametriCreazioneVmDTO implements Serializable {

	private static final long serialVersionUID = 5345422387243566632L;

	private String nome;
	
	private String descrizione;
	
	private String templateUuid;
	
	private String flavurUuid;
	
	private List<DiscoAggiuntivoDTO> dischiAggiuntivi;
	
	private String region;
	
	private String az;
	
	private String subnet;
	
	private String securityGroup;
	
	private List<String> tags;
	
	private String adminPassword;
	
	private String hypervisor;
	
	private String accountId;
	
	private DiscoBase discobase;
	
	private String nomeChiave;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTemplateUuid() {
		return templateUuid;
	}

	public void setTemplateUuid(String templateUuid) {
		this.templateUuid = templateUuid;
	}

	public String getFlavurUuid() {
		return flavurUuid;
	}

	public void setFlavurUuid(String flavurUuid) {
		this.flavurUuid = flavurUuid;
	}

	public List<DiscoAggiuntivoDTO> getDischiAggiuntivi() {
		return dischiAggiuntivi;
	}

	public void setDischiAggiuntivi(List<DiscoAggiuntivoDTO> dischiAggiuntivi) {
		this.dischiAggiuntivi = dischiAggiuntivi;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAz() {
		return az;
	}

	public void setAz(String az) {
		this.az = az;
	}

	public String getSubnet() {
		return subnet;
	}

	public void setSubnet(String subnet) {
		this.subnet = subnet;
	}

	public String getSecurityGroup() {
		return securityGroup;
	}

	public void setSecurityGroup(String securityGroup) {
		this.securityGroup = securityGroup;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getHypervisor() {
		return hypervisor;
	}

	public void setHypervisor(String hypervisor) {
		this.hypervisor = hypervisor;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	public DiscoBase getDiscobase() {
		return discobase;
	}

	public void setDiscobase(DiscoBase discobase) {
		this.discobase = discobase;
	}



	public class DiscoBase implements Serializable {
		private static final long serialVersionUID = 528804684366125921L;
		
		private Integer dimensioneDisco;
		private String tipoDisco;
		
		public Integer getDimensioneDisco() {
			return dimensioneDisco;
		}
		
		public void setDimensioneDisco(Integer dimensioneDisco) {
			this.dimensioneDisco = dimensioneDisco;
		}
		
		public String getTipoDisco() {
			return tipoDisco;
		}
		
		public void setTipoDisco(String tipoDisco) {
			this.tipoDisco = tipoDisco;
		}
		
	}



	public String getNomeChiave() {
		return nomeChiave;
	}

	public void setNomeChiave(String nomeChiave) {
		this.nomeChiave = nomeChiave;
	}
	
	public void impostaDiscoBase(int dimensione, String tipo) {
		this.discobase = new DiscoBase();
		discobase.setDimensioneDisco(dimensione);
		discobase.setTipoDisco(tipo);

	}
}
