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
 * GetAccountDefinitionsRequestSchema
 */

public class GetAccountDefinitionsRequestSchema {
  @JsonProperty("active")
  private Boolean active = null;

  /**
   * definiton category
   */
  public enum CategoryEnum {
    DUMMY("dummy"),
    
    CPAAS("cpaas"),
    
    DBAAS("dbaas"),
    
    STAAS("staas"),
    
    PLAAS("plaas"),
    
    NETAAS("netaas"),
    
    LAAS("laas"),
    
    MAAS("maas");

    private String value;

    CategoryEnum(String value) {
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
    public static CategoryEnum fromValue(String value) {
      for (CategoryEnum b : CategoryEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("category")
  private CategoryEnum category = null;

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

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("objid")
  private String objid = null;

  @JsonProperty("oid")
  private String oid = null;

  @JsonProperty("only_container")
  private Boolean onlyContainer = null;

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

  /**
   * plugin type name
   */
  public enum PlugintypeEnum {
    DUMMY("Dummy"),
    
    COMPUTESERVICE("ComputeService"),
    
    COMPUTEINSTANCE("ComputeInstance"),
    
    COMPUTEIMAGE("ComputeImage"),
    
    COMPUTEVPC("ComputeVPC"),
    
    COMPUTESUBNET("ComputeSubnet"),
    
    COMPUTESECURITYGROUP("ComputeSecurityGroup"),
    
    COMPUTEVOLUME("ComputeVolume"),
    
    COMPUTEKEYPAIRS("ComputeKeyPairs"),
    
    COMPUTELIMITS("ComputeLimits"),
    
    COMPUTEADDRESS("ComputeAddress"),
    
    DATABASESERVICE("DatabaseService"),
    
    DATABASEINSTANCE("DatabaseInstance"),
    
    DATABASESCHEMA("DatabaseSchema"),
    
    DATABASEUSER("DatabaseUser"),
    
    DATABASEBACKUP("DatabaseBackup"),
    
    DATABASELOG("DatabaseLog"),
    
    DATABASESNAPSHOT("DatabaseSnapshot"),
    
    DATABASETAG("DatabaseTag"),
    
    STORAGESERVICE("StorageService"),
    
    STORAGEEFS("StorageEFS"),
    
    COMPUTETAG("ComputeTag"),
    
    APPENGINESERVICE("AppEngineService"),
    
    APPENGINEINSTANCE("AppEngineInstance"),
    
    COMPUTETEMPLATE("ComputeTemplate"),
    
    NETWORKSERVICE("NetworkService"),
    
    NETWORKGATEWAY("NetworkGateway"),
    
    NETWORKHEALTHMONITOR("NetworkHealthMonitor"),
    
    NETWORKTARGETGROUP("NetworkTargetGroup"),
    
    VIRTUALSERVICE("VirtualService"),
    
    COMPUTECUSTOMIZATION("ComputeCustomization"),
    
    LOGGINGSERVICE("LoggingService"),
    
    LOGGINGSPACE("LoggingSpace"),
    
    LOGGINGINSTANCE("LoggingInstance"),
    
    MONITORINGSERVICE("MonitoringService"),
    
    MONITORINGFOLDER("MonitoringFolder"),
    
    MONITORINGINSTANCE("MonitoringInstance");

    private String value;

    PlugintypeEnum(String value) {
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
    public static PlugintypeEnum fromValue(String value) {
      for (PlugintypeEnum b : PlugintypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("plugintype")
  private PlugintypeEnum plugintype = null;

  @JsonProperty("size")
  private Integer size = null;

  @JsonProperty("version")
  private String version = null;

  public GetAccountDefinitionsRequestSchema active(Boolean active) {
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

  public GetAccountDefinitionsRequestSchema category(CategoryEnum category) {
    this.category = category;
    return this;
  }

   /**
   * definiton category
   * @return category
  **/
  @ApiModelProperty(value = "definiton category")
  public CategoryEnum getCategory() {
    return category;
  }

  public void setCategory(CategoryEnum category) {
    this.category = category;
  }

  public GetAccountDefinitionsRequestSchema field(FieldEnum field) {
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

  public GetAccountDefinitionsRequestSchema filterCreationDateStart(LocalDateTime filterCreationDateStart) {
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

  public GetAccountDefinitionsRequestSchema filterCreationDateStop(LocalDateTime filterCreationDateStop) {
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

  public GetAccountDefinitionsRequestSchema filterExpired(Boolean filterExpired) {
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

  public GetAccountDefinitionsRequestSchema filterExpiryDateStart(LocalDateTime filterExpiryDateStart) {
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

  public GetAccountDefinitionsRequestSchema filterExpiryDateStop(LocalDateTime filterExpiryDateStop) {
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

  public GetAccountDefinitionsRequestSchema filterModificationDateStart(LocalDateTime filterModificationDateStart) {
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

  public GetAccountDefinitionsRequestSchema filterModificationDateStop(LocalDateTime filterModificationDateStop) {
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

  public GetAccountDefinitionsRequestSchema name(String name) {
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

  public GetAccountDefinitionsRequestSchema objid(String objid) {
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

  public GetAccountDefinitionsRequestSchema oid(String oid) {
    this.oid = oid;
    return this;
  }

   /**
   * account id
   * @return oid
  **/
  @ApiModelProperty(value = "account id")
  public String getOid() {
    return oid;
  }

  public void setOid(String oid) {
    this.oid = oid;
  }

  public GetAccountDefinitionsRequestSchema onlyContainer(Boolean onlyContainer) {
    this.onlyContainer = onlyContainer;
    return this;
  }

   /**
   * if True select only definition with type that is a container
   * @return onlyContainer
  **/
  @ApiModelProperty(value = "if True select only definition with type that is a container")
  public Boolean isOnlyContainer() {
    return onlyContainer;
  }

  public void setOnlyContainer(Boolean onlyContainer) {
    this.onlyContainer = onlyContainer;
  }

  public GetAccountDefinitionsRequestSchema order(OrderEnum order) {
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

  public GetAccountDefinitionsRequestSchema page(Integer page) {
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

  public GetAccountDefinitionsRequestSchema plugintype(PlugintypeEnum plugintype) {
    this.plugintype = plugintype;
    return this;
  }

   /**
   * plugin type name
   * @return plugintype
  **/
  @ApiModelProperty(value = "plugin type name")
  public PlugintypeEnum getPlugintype() {
    return plugintype;
  }

  public void setPlugintype(PlugintypeEnum plugintype) {
    this.plugintype = plugintype;
  }

  public GetAccountDefinitionsRequestSchema size(Integer size) {
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

  public GetAccountDefinitionsRequestSchema version(String version) {
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
    GetAccountDefinitionsRequestSchema getAccountDefinitionsRequestSchema = (GetAccountDefinitionsRequestSchema) o;
    return Objects.equals(this.active, getAccountDefinitionsRequestSchema.active) &&
        Objects.equals(this.category, getAccountDefinitionsRequestSchema.category) &&
        Objects.equals(this.field, getAccountDefinitionsRequestSchema.field) &&
        Objects.equals(this.filterCreationDateStart, getAccountDefinitionsRequestSchema.filterCreationDateStart) &&
        Objects.equals(this.filterCreationDateStop, getAccountDefinitionsRequestSchema.filterCreationDateStop) &&
        Objects.equals(this.filterExpired, getAccountDefinitionsRequestSchema.filterExpired) &&
        Objects.equals(this.filterExpiryDateStart, getAccountDefinitionsRequestSchema.filterExpiryDateStart) &&
        Objects.equals(this.filterExpiryDateStop, getAccountDefinitionsRequestSchema.filterExpiryDateStop) &&
        Objects.equals(this.filterModificationDateStart, getAccountDefinitionsRequestSchema.filterModificationDateStart) &&
        Objects.equals(this.filterModificationDateStop, getAccountDefinitionsRequestSchema.filterModificationDateStop) &&
        Objects.equals(this.name, getAccountDefinitionsRequestSchema.name) &&
        Objects.equals(this.objid, getAccountDefinitionsRequestSchema.objid) &&
        Objects.equals(this.oid, getAccountDefinitionsRequestSchema.oid) &&
        Objects.equals(this.onlyContainer, getAccountDefinitionsRequestSchema.onlyContainer) &&
        Objects.equals(this.order, getAccountDefinitionsRequestSchema.order) &&
        Objects.equals(this.page, getAccountDefinitionsRequestSchema.page) &&
        Objects.equals(this.plugintype, getAccountDefinitionsRequestSchema.plugintype) &&
        Objects.equals(this.size, getAccountDefinitionsRequestSchema.size) &&
        Objects.equals(this.version, getAccountDefinitionsRequestSchema.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, category, field, filterCreationDateStart, filterCreationDateStop, filterExpired, filterExpiryDateStart, filterExpiryDateStop, filterModificationDateStart, filterModificationDateStop, name, objid, oid, onlyContainer, order, page, plugintype, size, version);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetAccountDefinitionsRequestSchema {\n");
    
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    field: ").append(toIndentedString(field)).append("\n");
    sb.append("    filterCreationDateStart: ").append(toIndentedString(filterCreationDateStart)).append("\n");
    sb.append("    filterCreationDateStop: ").append(toIndentedString(filterCreationDateStop)).append("\n");
    sb.append("    filterExpired: ").append(toIndentedString(filterExpired)).append("\n");
    sb.append("    filterExpiryDateStart: ").append(toIndentedString(filterExpiryDateStart)).append("\n");
    sb.append("    filterExpiryDateStop: ").append(toIndentedString(filterExpiryDateStop)).append("\n");
    sb.append("    filterModificationDateStart: ").append(toIndentedString(filterModificationDateStart)).append("\n");
    sb.append("    filterModificationDateStop: ").append(toIndentedString(filterModificationDateStop)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    objid: ").append(toIndentedString(objid)).append("\n");
    sb.append("    oid: ").append(toIndentedString(oid)).append("\n");
    sb.append("    onlyContainer: ").append(toIndentedString(onlyContainer)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    plugintype: ").append(toIndentedString(plugintype)).append("\n");
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

