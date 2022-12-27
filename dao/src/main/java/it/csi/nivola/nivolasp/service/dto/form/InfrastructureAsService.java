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
package it.csi.nivola.nivolasp.service.dto.form;

import org.springframework.util.StringUtils;

import it.csi.nivola.nivolasp.exception.BusinessException;
import it.csi.nivola.nivolasp.service.dto.AbstractBaseForm;

public class InfrastructureAsService extends AbstractBaseForm {

	private String nomeVm = "";
	
	private String destinazione = "";
	
	private String filiera = "";
	
	private String sistemaOperativo;
	
	private String risorse;
	
	private String dimensione;
	
	private String az = "";
	
	private String subnet = "";
	
	private String securityGroup = "";
	
	@Override
	public void valida() throws BusinessException {
		super.valida();
		if (StringUtils.isEmpty(nomeVm)) {
			throw new BusinessException("campo Obbligatorio: nome VM");
		}
		if (StringUtils.isEmpty(dimensione)) {
			throw new BusinessException("campo Obbligatorio: dimensione");
		}
		if (StringUtils.isEmpty(risorse)) {
			throw new BusinessException("campo Obbligatorio: risorse");
		}
		if (StringUtils.isEmpty(destinazione)) {
			throw new BusinessException("campo Obbligatorio: destinazione");
		}
		if (StringUtils.isEmpty(filiera)) {
			throw new BusinessException("campo Obbligatorio: filiera");
		}
		if (StringUtils.isEmpty(sistemaOperativo)) {
			throw new BusinessException("campo Obbligatorio: sistemaOperativo");
		}
	}

	@Override
	public String componiTestoDaParametri() {
		StringBuilder sb = new StringBuilder(super.componiTestoDaParametri());
			sb.append("\nNome VM: ").append(nomeVm);
			sb.append("\nDestinazione: ").append(destinazione);
			sb.append("\nFiliera: ").append(filiera);
			sb.append("\nSistema Operativo: ").append(sistemaOperativo);
			sb.append("\nRisorse: ").append(risorse);
			sb.append("\nDimensione: ").append(dimensione);
			sb.append("\nAvailabulity zone: ").append(az);
			sb.append("\nSubnet: ").append(subnet);
			sb.append("\nSecurity Group: ").append(securityGroup);
			
		return sb.toString();
	}

	public String getNomeVm() {
		return nomeVm;
	}

	public void setNomeVm(String nomeVm) {
		this.nomeVm = nomeVm;
	}

	public String getDestinazione() {
		return destinazione;
	}

	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}

	public String getFiliera() {
		return filiera;
	}

	public void setFiliera(String filiera) {
		this.filiera = filiera;
	}

	public String getSistemaOperativo() {
		return sistemaOperativo;
	}

	public void setSistemaOperativo(String sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}

	public String getRisorse() {
		return risorse;
	}

	public void setRisorse(String risorse) {
		this.risorse = risorse;
	}

	public String getDimensione() {
		return dimensione;
	}

	public void setDimensione(String dimensione) {
		this.dimensione = dimensione;
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
}
