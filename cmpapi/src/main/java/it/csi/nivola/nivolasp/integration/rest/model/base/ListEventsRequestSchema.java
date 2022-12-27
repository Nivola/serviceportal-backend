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
 * API description in Markdown.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: me@csi.it
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package it.csi.nivola.nivolasp.integration.rest.model.base;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * ListEventsRequestSchema
 */

public class ListEventsRequestSchema {
  @JsonProperty("data")
  private String data = null;

  @JsonProperty("date")
  private LocalDateTime date = null;

  @JsonProperty("datefrom")
  private LocalDateTime datefrom = null;

  @JsonProperty("dateto")
  private LocalDateTime dateto = null;

  @JsonProperty("dest")
  private String dest = null;

  /**
   * enitities list order field. Ex. id, uuid, name
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
    public static FieldEnum fromValue(String text) {
      for (FieldEnum b : FieldEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("field")
  private FieldEnum field = FieldEnum.ID;

  @JsonProperty("objdef")
  private String objdef = null;

  @JsonProperty("objid")
  private String objid = null;

  @JsonProperty("objtype")
  private String objtype = null;

  /**
   * enitities list order: ASC or DESC
   */
  public enum OrderEnum {
    ASC_UPPER("ASC"),
    
    ASC("asc"),
    
    DESC_UPPER("DESC"),
    
    DESC("desc");

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
    public static OrderEnum fromValue(String text) {
      for (OrderEnum b : OrderEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("order")
  private OrderEnum order = OrderEnum.DESC;

  @JsonProperty("page")
  private Integer page = 0;

  @JsonProperty("size")
  private Integer size = 10;

  @JsonProperty("source")
  private String source = null;

  @JsonProperty("type")
  private String type = null;

  public ListEventsRequestSchema data(String data) {
    this.data = data;
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(value = "")
  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public ListEventsRequestSchema date(LocalDateTime date) {
    this.date = date;
    return this;
  }

   /**
   * Get date
   * @return date
  **/
  @ApiModelProperty(value = "")
  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public ListEventsRequestSchema datefrom(LocalDateTime datefrom) {
    this.datefrom = datefrom;
    return this;
  }

   /**
   * Get datefrom
   * @return datefrom
  **/
  @ApiModelProperty(value = "")
  public LocalDateTime getDatefrom() {
    return datefrom;
  }

  public void setDatefrom(LocalDateTime datefrom) {
    this.datefrom = datefrom;
  }

  public ListEventsRequestSchema dateto(LocalDateTime dateto) {
    this.dateto = dateto;
    return this;
  }

   /**
   * Get dateto
   * @return dateto
  **/
  @ApiModelProperty(value = "")
  public LocalDateTime getDateto() {
    return dateto;
  }

  public void setDateto(LocalDateTime dateto) {
    this.dateto = dateto;
  }

  public ListEventsRequestSchema dest(String dest) {
    this.dest = dest;
    return this;
  }

   /**
   * Get dest
   * @return dest
  **/
  @ApiModelProperty(value = "")
  public String getDest() {
    return dest;
  }

  public void setDest(String dest) {
    this.dest = dest;
  }

  public ListEventsRequestSchema field(FieldEnum field) {
    this.field = field;
    return this;
  }

   /**
   * enitities list order field. Ex. id, uuid, name
   * @return field
  **/
  @ApiModelProperty(example = "id", value = "enitities list order field. Ex. id, uuid, name")
  public FieldEnum getField() {
    return field;
  }

  public void setField(FieldEnum field) {
    this.field = field;
  }

  public ListEventsRequestSchema objdef(String objdef) {
    this.objdef = objdef;
    return this;
  }

   /**
   * Get objdef
   * @return objdef
  **/
  @ApiModelProperty(value = "")
  public String getObjdef() {
    return objdef;
  }

  public void setObjdef(String objdef) {
    this.objdef = objdef;
  }

  public ListEventsRequestSchema objid(String objid) {
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

  public ListEventsRequestSchema objtype(String objtype) {
    this.objtype = objtype;
    return this;
  }

   /**
   * Get objtype
   * @return objtype
  **/
  @ApiModelProperty(value = "")
  public String getObjtype() {
    return objtype;
  }

  public void setObjtype(String objtype) {
    this.objtype = objtype;
  }

  public ListEventsRequestSchema order(OrderEnum order) {
    this.order = order;
    return this;
  }

   /**
   * enitities list order: ASC or DESC
   * @return order
  **/
  @ApiModelProperty(example = "DESC", value = "enitities list order: ASC or DESC")
  public OrderEnum getOrder() {
    return order;
  }

  public void setOrder(OrderEnum order) {
    this.order = order;
  }

  public ListEventsRequestSchema page(Integer page) {
    this.page = page;
    return this;
  }

   /**
   * enitities list page selected
   * minimum: 0
   * maximum: 1001
   * @return page
  **/
  @ApiModelProperty(example = "0", value = "enitities list page selected")
  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public ListEventsRequestSchema size(Integer size) {
    this.size = size;
    return this;
  }

   /**
   * enitities list page size
   * minimum: 0
   * maximum: 1001
   * @return size
  **/
  @ApiModelProperty(example = "10", value = "enitities list page size")
  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public ListEventsRequestSchema source(String source) {
    this.source = source;
    return this;
  }

   /**
   * Get source
   * @return source
  **/
  @ApiModelProperty(value = "")
  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public ListEventsRequestSchema type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListEventsRequestSchema listEventsRequestSchema = (ListEventsRequestSchema) o;
    return Objects.equals(this.data, listEventsRequestSchema.data) &&
        Objects.equals(this.date, listEventsRequestSchema.date) &&
        Objects.equals(this.datefrom, listEventsRequestSchema.datefrom) &&
        Objects.equals(this.dateto, listEventsRequestSchema.dateto) &&
        Objects.equals(this.dest, listEventsRequestSchema.dest) &&
        Objects.equals(this.field, listEventsRequestSchema.field) &&
        Objects.equals(this.objdef, listEventsRequestSchema.objdef) &&
        Objects.equals(this.objid, listEventsRequestSchema.objid) &&
        Objects.equals(this.objtype, listEventsRequestSchema.objtype) &&
        Objects.equals(this.order, listEventsRequestSchema.order) &&
        Objects.equals(this.page, listEventsRequestSchema.page) &&
        Objects.equals(this.size, listEventsRequestSchema.size) &&
        Objects.equals(this.source, listEventsRequestSchema.source) &&
        Objects.equals(this.type, listEventsRequestSchema.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, date, datefrom, dateto, dest, field, objdef, objid, objtype, order, page, size, source, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListEventsRequestSchema {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    datefrom: ").append(toIndentedString(datefrom)).append("\n");
    sb.append("    dateto: ").append(toIndentedString(dateto)).append("\n");
    sb.append("    dest: ").append(toIndentedString(dest)).append("\n");
    sb.append("    field: ").append(toIndentedString(field)).append("\n");
    sb.append("    objdef: ").append(toIndentedString(objdef)).append("\n");
    sb.append("    objid: ").append(toIndentedString(objid)).append("\n");
    sb.append("    objtype: ").append(toIndentedString(objtype)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

