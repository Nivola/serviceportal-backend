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
 * ListServiceMetricTypeRequestSchema
 */

public class ListServiceMetricTypeRequestSchema {
  @JsonProperty("active")
  private Boolean active = null;

  /**
   * entities list order field. Ex. id, uuid, name
   */
  public enum FieldEnum {
    ID("id"),
    
    UUID("uuid"),
    
    OBJID("objid"),
    
    NAME("name");

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

  @JsonProperty("group_name")
  private String groupName = null;

  @JsonProperty("metric_type")
  private String metricType = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("objid")
  private String objid = null;

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

  @JsonProperty("size")
  private Integer size = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("version")
  private String version = null;

  public ListServiceMetricTypeRequestSchema active(Boolean active) {
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

  public ListServiceMetricTypeRequestSchema field(FieldEnum field) {
    this.field = field;
    return this;
  }

   /**
   * entities list order field. Ex. id, uuid, name
   * @return field
  **/
  @ApiModelProperty(example = "id", value = "entities list order field. Ex. id, uuid, name")
  public FieldEnum getField() {
    return field;
  }

  public void setField(FieldEnum field) {
    this.field = field;
  }

  public ListServiceMetricTypeRequestSchema filterCreationDateStart(LocalDateTime filterCreationDateStart) {
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

  public ListServiceMetricTypeRequestSchema filterCreationDateStop(LocalDateTime filterCreationDateStop) {
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

  public ListServiceMetricTypeRequestSchema filterExpired(Boolean filterExpired) {
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

  public ListServiceMetricTypeRequestSchema filterExpiryDateStart(LocalDateTime filterExpiryDateStart) {
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

  public ListServiceMetricTypeRequestSchema filterExpiryDateStop(LocalDateTime filterExpiryDateStop) {
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

  public ListServiceMetricTypeRequestSchema filterModificationDateStart(LocalDateTime filterModificationDateStart) {
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

  public ListServiceMetricTypeRequestSchema filterModificationDateStop(LocalDateTime filterModificationDateStop) {
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

  public ListServiceMetricTypeRequestSchema groupName(String groupName) {
    this.groupName = groupName;
    return this;
  }

   /**
   * Get groupName
   * @return groupName
  **/
  @ApiModelProperty(value = "")
  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public ListServiceMetricTypeRequestSchema metricType(String metricType) {
    this.metricType = metricType;
    return this;
  }

   /**
   * Get metricType
   * @return metricType
  **/
  @ApiModelProperty(value = "")
  public String getMetricType() {
    return metricType;
  }

  public void setMetricType(String metricType) {
    this.metricType = metricType;
  }

  public ListServiceMetricTypeRequestSchema name(String name) {
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

  public ListServiceMetricTypeRequestSchema objid(String objid) {
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

  public ListServiceMetricTypeRequestSchema order(OrderEnum order) {
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

  public ListServiceMetricTypeRequestSchema page(Integer page) {
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

  public ListServiceMetricTypeRequestSchema size(Integer size) {
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

  public ListServiceMetricTypeRequestSchema status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public ListServiceMetricTypeRequestSchema version(String version) {
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
    ListServiceMetricTypeRequestSchema listServiceMetricTypeRequestSchema = (ListServiceMetricTypeRequestSchema) o;
    return Objects.equals(this.active, listServiceMetricTypeRequestSchema.active) &&
        Objects.equals(this.field, listServiceMetricTypeRequestSchema.field) &&
        Objects.equals(this.filterCreationDateStart, listServiceMetricTypeRequestSchema.filterCreationDateStart) &&
        Objects.equals(this.filterCreationDateStop, listServiceMetricTypeRequestSchema.filterCreationDateStop) &&
        Objects.equals(this.filterExpired, listServiceMetricTypeRequestSchema.filterExpired) &&
        Objects.equals(this.filterExpiryDateStart, listServiceMetricTypeRequestSchema.filterExpiryDateStart) &&
        Objects.equals(this.filterExpiryDateStop, listServiceMetricTypeRequestSchema.filterExpiryDateStop) &&
        Objects.equals(this.filterModificationDateStart, listServiceMetricTypeRequestSchema.filterModificationDateStart) &&
        Objects.equals(this.filterModificationDateStop, listServiceMetricTypeRequestSchema.filterModificationDateStop) &&
        Objects.equals(this.groupName, listServiceMetricTypeRequestSchema.groupName) &&
        Objects.equals(this.metricType, listServiceMetricTypeRequestSchema.metricType) &&
        Objects.equals(this.name, listServiceMetricTypeRequestSchema.name) &&
        Objects.equals(this.objid, listServiceMetricTypeRequestSchema.objid) &&
        Objects.equals(this.order, listServiceMetricTypeRequestSchema.order) &&
        Objects.equals(this.page, listServiceMetricTypeRequestSchema.page) &&
        Objects.equals(this.size, listServiceMetricTypeRequestSchema.size) &&
        Objects.equals(this.status, listServiceMetricTypeRequestSchema.status) &&
        Objects.equals(this.version, listServiceMetricTypeRequestSchema.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, field, filterCreationDateStart, filterCreationDateStop, filterExpired, filterExpiryDateStart, filterExpiryDateStop, filterModificationDateStart, filterModificationDateStop, groupName, metricType, name, objid, order, page, size, status, version);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListServiceMetricTypeRequestSchema {\n");
    
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    field: ").append(toIndentedString(field)).append("\n");
    sb.append("    filterCreationDateStart: ").append(toIndentedString(filterCreationDateStart)).append("\n");
    sb.append("    filterCreationDateStop: ").append(toIndentedString(filterCreationDateStop)).append("\n");
    sb.append("    filterExpired: ").append(toIndentedString(filterExpired)).append("\n");
    sb.append("    filterExpiryDateStart: ").append(toIndentedString(filterExpiryDateStart)).append("\n");
    sb.append("    filterExpiryDateStop: ").append(toIndentedString(filterExpiryDateStop)).append("\n");
    sb.append("    filterModificationDateStart: ").append(toIndentedString(filterModificationDateStart)).append("\n");
    sb.append("    filterModificationDateStop: ").append(toIndentedString(filterModificationDateStop)).append("\n");
    sb.append("    groupName: ").append(toIndentedString(groupName)).append("\n");
    sb.append("    metricType: ").append(toIndentedString(metricType)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    objid: ").append(toIndentedString(objid)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

