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
package it.csi.nivola.nivolasp.domain.cmp;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mv_aggregate_consumes")
public class VAggregateConsumes implements Serializable {

	private static final long serialVersionUID = -8923425327972258956L;

	@Id
	private Long id;
	
	@Column(name="organization_uuid")
	private String organizationUuid;
	
	
	@Column(name="division_uuid")
	private String divisionUuid;
	
	
	@Column(name="account_uuid")
	private String accountUuid;
	
	
	@Column(name="creation_date")
	private Date creationDate;
	
	@Column(name="evaluation_date")
	private Date evaluationDate;
	
	@Column(name="modification_date")
	private Date modificationDate;
	
	
	private Date period;
	
	private String metric;
	
	private Double consumed;
	
	@Column(name="measure_unit")
	private String measureUnit;
	
	@Column(name="container_uuid")
	private String containerUuid;
	
	@Column(name="container_instance_type")
	private String containerInstanceType;
	
	
	@Column(name="container_type")
	private String containerType;
	
	private String category;

	public String getOrganizationUuid() {
		return organizationUuid;
	}

	public void setOrganizationUuid(String organizationUuid) {
		this.organizationUuid = organizationUuid;
	}

	public String getDivisionUuid() {
		return divisionUuid;
	}

	public void setDivisionUuid(String divisionUuid) {
		this.divisionUuid = divisionUuid;
	}

	public String getAccountUuid() {
		return accountUuid;
	}

	public void setAccountUuid(String accountUuid) {
		this.accountUuid = accountUuid;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getEvaluationDate() {
		return evaluationDate;
	}

	public void setEvaluationDate(Date evaluationDate) {
		this.evaluationDate = evaluationDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public Date getPeriod() {
		return period;
	}

	public void setPeriod(Date period) {
		this.period = period;
	}

	public String getMetric() {
		return metric;
	}

	public void setMetric(String metric) {
		this.metric = metric;
	}
	



	public Double getConsumed() {
		return consumed;
	}

	public void setConsumed(Double consumed) {
		this.consumed = consumed;
	}

	public String getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}

	public String getContainerUuid() {
		return containerUuid;
	}

	public void setContainerUuid(String containerUuid) {
		this.containerUuid = containerUuid;
	}

	public String getContainerInstanceType() {
		return containerInstanceType;
	}

	public void setContainerInstanceType(String containerInstanceType) {
		this.containerInstanceType = containerInstanceType;
	}

	public String getContainerType() {
		return containerType;
	}

	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
}
