/*-
 * ========================LICENSE_START=================================
 * Api CMP
 * %%
 * Copyright (C) 2022 CSI Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | CSI Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
/*
 * Beehive API
 * Beehive API
 *
 * OpenAPI spec version: 1.0.0
 * Contact: nivola.engineering@csi.it
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package it.csi.nivola.nivolasp.integration.rest.model.service;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * ListReportCostRequestSchema
 */

public class ListReportCostRequestSchema {
  @JsonProperty("active")
  private Boolean active = null;

  /**
   * enitities list order field. Ex. id, period
   */
  public enum FieldEnum {
    ID("id"),
    
    PERIOD("period");

    private String value;

    FieldEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static FieldEnum fromValue(String value) {
      for (FieldEnum b : FieldEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("field")
  private FieldEnum field = FieldEnum.ID;

  @JsonProperty("filter_creation_date_start")
  private LocalDateTime filterCreationDateStart = null;

  @JsonProperty("filter_creation_date_stop")
  private LocalDateTime filterCreationDateStop = null;

  @JsonProperty("filter_expired")
  private Boolean filterExpired = false;

  @JsonProperty("filter_expiry_date_start")
  private LocalDateTime filterExpiryDateStart = null;

  @JsonProperty("filter_expiry_date_stop")
  private LocalDateTime filterExpiryDateStop = null;

  @JsonProperty("filter_modification_date_start")
  private LocalDateTime filterModificationDateStart = null;

  @JsonProperty("filter_modification_date_stop")
  private LocalDateTime filterModificationDateStop = null;

  @JsonProperty("is_reported")
  private Boolean isReported = null;

  @JsonProperty("job_id")
  private Integer jobId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("objid")
  private String objid = null;

  @JsonProperty("oid")
  private String oid = null;

  /**
   * entities list order: ASC or DESC
   */
  public enum OrderEnum {
    ASC("ASC"),
    
    ASC_2("asc"),
    
    DESC("DESC"),
    
    DESC_2("desc");

    private String value;

    OrderEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static OrderEnum fromValue(String value) {
      for (OrderEnum b : OrderEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("order")
  private OrderEnum order = OrderEnum.DESC;

  @JsonProperty("page")
  private Integer page = null;

  @JsonProperty("period")
  private String period = null;

  @JsonProperty("period_end")
  private String periodEnd = null;

  @JsonProperty("period_start")
  private String periodStart = null;

  @JsonProperty("plugin_name")
  private String pluginName = null;

  @JsonProperty("size")
  private Integer size = null;

  @JsonProperty("version")
  private String version = null;

  public ListReportCostRequestSchema active(Boolean active) {
    this.active = active;
    return this;
  }

   /**
   * Get active
   * @return active
  **/
  @ApiModelProperty(value = "")
  public Boolean isActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public ListReportCostRequestSchema field(FieldEnum field) {
    this.field = field;
    return this;
  }

   /**
   * enitities list order field. Ex. id, period
   * @return field
  **/
  @ApiModelProperty(example = "id", value = "enitities list order field. Ex. id, period")
  public FieldEnum getField() {
    return field;
  }

  public void setField(FieldEnum field) {
    this.field = field;
  }

  public ListReportCostRequestSchema filterCreationDateStart(LocalDateTime filterCreationDateStart) {
    this.filterCreationDateStart = filterCreationDateStart;
    return this;
  }

   /**
   * Get filterCreationDateStart
   * @return filterCreationDateStart
  **/
  @ApiModelProperty(value = "")
  public LocalDateTime getFilterCreationDateStart() {
    return filterCreationDateStart;
  }

  public void setFilterCreationDateStart(LocalDateTime filterCreationDateStart) {
    this.filterCreationDateStart = filterCreationDateStart;
  }

  public ListReportCostRequestSchema filterCreationDateStop(LocalDateTime filterCreationDateStop) {
    this.filterCreationDateStop = filterCreationDateStop;
    return this;
  }

   /**
   * Get filterCreationDateStop
   * @return filterCreationDateStop
  **/
  @ApiModelProperty(value = "")
  public LocalDateTime getFilterCreationDateStop() {
    return filterCreationDateStop;
  }

  public void setFilterCreationDateStop(LocalDateTime filterCreationDateStop) {
    this.filterCreationDateStop = filterCreationDateStop;
  }

  public ListReportCostRequestSchema filterExpired(Boolean filterExpired) {
    this.filterExpired = filterExpired;
    return this;
  }

   /**
   * Get filterExpired
   * @return filterExpired
  **/
  @ApiModelProperty(value = "")
  public Boolean isFilterExpired() {
    return filterExpired;
  }

  public void setFilterExpired(Boolean filterExpired) {
    this.filterExpired = filterExpired;
  }

  public ListReportCostRequestSchema filterExpiryDateStart(LocalDateTime filterExpiryDateStart) {
    this.filterExpiryDateStart = filterExpiryDateStart;
    return this;
  }

   /**
   * Get filterExpiryDateStart
   * @return filterExpiryDateStart
  **/
  @ApiModelProperty(value = "")
  public LocalDateTime getFilterExpiryDateStart() {
    return filterExpiryDateStart;
  }

  public void setFilterExpiryDateStart(LocalDateTime filterExpiryDateStart) {
    this.filterExpiryDateStart = filterExpiryDateStart;
  }

  public ListReportCostRequestSchema filterExpiryDateStop(LocalDateTime filterExpiryDateStop) {
    this.filterExpiryDateStop = filterExpiryDateStop;
    return this;
  }

   /**
   * Get filterExpiryDateStop
   * @return filterExpiryDateStop
  **/
  @ApiModelProperty(value = "")
  public LocalDateTime getFilterExpiryDateStop() {
    return filterExpiryDateStop;
  }

  public void setFilterExpiryDateStop(LocalDateTime filterExpiryDateStop) {
    this.filterExpiryDateStop = filterExpiryDateStop;
  }

  public ListReportCostRequestSchema filterModificationDateStart(LocalDateTime filterModificationDateStart) {
    this.filterModificationDateStart = filterModificationDateStart;
    return this;
  }

   /**
   * Get filterModificationDateStart
   * @return filterModificationDateStart
  **/
  @ApiModelProperty(value = "")
  public LocalDateTime getFilterModificationDateStart() {
    return filterModificationDateStart;
  }

  public void setFilterModificationDateStart(LocalDateTime filterModificationDateStart) {
    this.filterModificationDateStart = filterModificationDateStart;
  }

  public ListReportCostRequestSchema filterModificationDateStop(LocalDateTime filterModificationDateStop) {
    this.filterModificationDateStop = filterModificationDateStop;
    return this;
  }

   /**
   * Get filterModificationDateStop
   * @return filterModificationDateStop
  **/
  @ApiModelProperty(value = "")
  public LocalDateTime getFilterModificationDateStop() {
    return filterModificationDateStop;
  }

  public void setFilterModificationDateStop(LocalDateTime filterModificationDateStop) {
    this.filterModificationDateStop = filterModificationDateStop;
  }

  public ListReportCostRequestSchema isReported(Boolean isReported) {
    this.isReported = isReported;
    return this;
  }

   /**
   * Get isReported
   * @return isReported
  **/
  @ApiModelProperty(value = "")
  public Boolean isIsReported() {
    return isReported;
  }

  public void setIsReported(Boolean isReported) {
    this.isReported = isReported;
  }

  public ListReportCostRequestSchema jobId(Integer jobId) {
    this.jobId = jobId;
    return this;
  }

   /**
   * Get jobId
   * @return jobId
  **/
  @ApiModelProperty(value = "")
  public Integer getJobId() {
    return jobId;
  }

  public void setJobId(Integer jobId) {
    this.jobId = jobId;
  }

  public ListReportCostRequestSchema name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ListReportCostRequestSchema objid(String objid) {
    this.objid = objid;
    return this;
  }

   /**
   * Get objid
   * @return objid
  **/
  @ApiModelProperty(value = "")
  public String getObjid() {
    return objid;
  }

  public void setObjid(String objid) {
    this.objid = objid;
  }

  public ListReportCostRequestSchema oid(String oid) {
    this.oid = oid;
    return this;
  }

   /**
   * id, uuid or name
   * @return oid
  **/
  @ApiModelProperty(required = true, value = "id, uuid or name")
  public String getOid() {
    return oid;
  }

  public void setOid(String oid) {
    this.oid = oid;
  }

  public ListReportCostRequestSchema order(OrderEnum order) {
    this.order = order;
    return this;
  }

   /**
   * entities list order: ASC or DESC
   * @return order
  **/
  @ApiModelProperty(example = "DESC", value = "entities list order: ASC or DESC")
  public OrderEnum getOrder() {
    return order;
  }

  public void setOrder(OrderEnum order) {
    this.order = order;
  }

  public ListReportCostRequestSchema page(Integer page) {
    this.page = page;
    return this;
  }

   /**
   * entities list page selected
   * minimum: 0
   * maximum: 10000
   * @return page
  **/
  @ApiModelProperty(example = "0", value = "entities list page selected")
  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public ListReportCostRequestSchema period(String period) {
    this.period = period;
    return this;
  }

   /**
   * Get period
   * @return period
  **/
  @ApiModelProperty(value = "")
  public String getPeriod() {
    return period;
  }

  public void setPeriod(String period) {
    this.period = period;
  }

  public ListReportCostRequestSchema periodEnd(String periodEnd) {
    this.periodEnd = periodEnd;
    return this;
  }

   /**
   * Get periodEnd
   * @return periodEnd
  **/
  @ApiModelProperty(value = "")
  public String getPeriodEnd() {
    return periodEnd;
  }

  public void setPeriodEnd(String periodEnd) {
    this.periodEnd = periodEnd;
  }

  public ListReportCostRequestSchema periodStart(String periodStart) {
    this.periodStart = periodStart;
    return this;
  }

   /**
   * Get periodStart
   * @return periodStart
  **/
  @ApiModelProperty(value = "")
  public String getPeriodStart() {
    return periodStart;
  }

  public void setPeriodStart(String periodStart) {
    this.periodStart = periodStart;
  }

  public ListReportCostRequestSchema pluginName(String pluginName) {
    this.pluginName = pluginName;
    return this;
  }

   /**
   * Get pluginName
   * @return pluginName
  **/
  @ApiModelProperty(value = "")
  public String getPluginName() {
    return pluginName;
  }

  public void setPluginName(String pluginName) {
    this.pluginName = pluginName;
  }

  public ListReportCostRequestSchema size(Integer size) {
    this.size = size;
    return this;
  }

   /**
   * entities list page size. -1 to get all the records
   * minimum: -1
   * maximum: 100
   * @return size
  **/
  @ApiModelProperty(example = "20", value = "entities list page size. -1 to get all the records")
  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public ListReportCostRequestSchema version(String version) {
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @ApiModelProperty(value = "")
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListReportCostRequestSchema listReportCostRequestSchema = (ListReportCostRequestSchema) o;
    return Objects.equals(this.active, listReportCostRequestSchema.active) &&
        Objects.equals(this.field, listReportCostRequestSchema.field) &&
        Objects.equals(this.filterCreationDateStart, listReportCostRequestSchema.filterCreationDateStart) &&
        Objects.equals(this.filterCreationDateStop, listReportCostRequestSchema.filterCreationDateStop) &&
        Objects.equals(this.filterExpired, listReportCostRequestSchema.filterExpired) &&
        Objects.equals(this.filterExpiryDateStart, listReportCostRequestSchema.filterExpiryDateStart) &&
        Objects.equals(this.filterExpiryDateStop, listReportCostRequestSchema.filterExpiryDateStop) &&
        Objects.equals(this.filterModificationDateStart, listReportCostRequestSchema.filterModificationDateStart) &&
        Objects.equals(this.filterModificationDateStop, listReportCostRequestSchema.filterModificationDateStop) &&
        Objects.equals(this.isReported, listReportCostRequestSchema.isReported) &&
        Objects.equals(this.jobId, listReportCostRequestSchema.jobId) &&
        Objects.equals(this.name, listReportCostRequestSchema.name) &&
        Objects.equals(this.objid, listReportCostRequestSchema.objid) &&
        Objects.equals(this.oid, listReportCostRequestSchema.oid) &&
        Objects.equals(this.order, listReportCostRequestSchema.order) &&
        Objects.equals(this.page, listReportCostRequestSchema.page) &&
        Objects.equals(this.period, listReportCostRequestSchema.period) &&
        Objects.equals(this.periodEnd, listReportCostRequestSchema.periodEnd) &&
        Objects.equals(this.periodStart, listReportCostRequestSchema.periodStart) &&
        Objects.equals(this.pluginName, listReportCostRequestSchema.pluginName) &&
        Objects.equals(this.size, listReportCostRequestSchema.size) &&
        Objects.equals(this.version, listReportCostRequestSchema.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, field, filterCreationDateStart, filterCreationDateStop, filterExpired, filterExpiryDateStart, filterExpiryDateStop, filterModificationDateStart, filterModificationDateStop, isReported, jobId, name, objid, oid, order, page, period, periodEnd, periodStart, pluginName, size, version);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListReportCostRequestSchema {\n");
    
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    field: ").append(toIndentedString(field)).append("\n");
    sb.append("    filterCreationDateStart: ").append(toIndentedString(filterCreationDateStart)).append("\n");
    sb.append("    filterCreationDateStop: ").append(toIndentedString(filterCreationDateStop)).append("\n");
    sb.append("    filterExpired: ").append(toIndentedString(filterExpired)).append("\n");
    sb.append("    filterExpiryDateStart: ").append(toIndentedString(filterExpiryDateStart)).append("\n");
    sb.append("    filterExpiryDateStop: ").append(toIndentedString(filterExpiryDateStop)).append("\n");
    sb.append("    filterModificationDateStart: ").append(toIndentedString(filterModificationDateStart)).append("\n");
    sb.append("    filterModificationDateStop: ").append(toIndentedString(filterModificationDateStop)).append("\n");
    sb.append("    isReported: ").append(toIndentedString(isReported)).append("\n");
    sb.append("    jobId: ").append(toIndentedString(jobId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    objid: ").append(toIndentedString(objid)).append("\n");
    sb.append("    oid: ").append(toIndentedString(oid)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    period: ").append(toIndentedString(period)).append("\n");
    sb.append("    periodEnd: ").append(toIndentedString(periodEnd)).append("\n");
    sb.append("    periodStart: ").append(toIndentedString(periodStart)).append("\n");
    sb.append("    pluginName: ").append(toIndentedString(pluginName)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
