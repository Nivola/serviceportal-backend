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

package it.csi.nivola.nivolasp.integration.remedy.portal.dto;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;


public class InfoNotaAttachmentsDto {
  @JsonProperty("logId")
  private String logId = null;

  @JsonProperty("dataLog")
  private OffsetDateTime dataLog = null;

  /**
   * tipologia di informazioni inserite
   */
  public enum TipologiaEnum {
    CUSTOMER_INBOUND("Customer Inbound"),
    
    CUSTOMER_COMMUNICATION("Customer Communication"),
    
    CUSTOMER_FOLLOW_UP("Customer Follow Up"),
    
    CUSTOMER_STATUS_UPDATE("Customer Status Update"),
    
    CUSTOMER_OUTBOUND("Customer Outbound"),
    
    CLOSURE_FOLLOW_UP("Closure Follow Up"),
    
    DETAIL_CLARIFICATION("Detail Clarification"),
    
    GENERAL_INFORMATION("General Information"),
    
    RESOLUTION_COMMUNICATIONS("Resolution Communications"),
    
    SATISFACTION_SURVEY("Satisfaction Survey"),
    
    STATUS_UPDATE("Status Update"),
    
    GENERAL("General"),
    
    INCIDENT_TASK_OR_ACTION("Incident Task or Action"),
    
    PROBLEM_SCRIPT("Problem Script"),
    
    WORKING_LOG("Working Log"),
    
    EMAIL_SYSTEM("Email System"),
    
    PAGING_SYSTEM("Paging System"),
    
    BMC_IMPACT_MANAGER_UPDATE("BMC Impact Manager Update"),
    
    CHAT("Chat"),
    
    PENDING("Pending"),
    
    RESOLVED("Resolved");

    private String value;

    TipologiaEnum(String value) {
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
    public static TipologiaEnum fromValue(String text) {
      for (TipologiaEnum b : TipologiaEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("tipologia")
  private TipologiaEnum tipologia = null;

  @JsonProperty("note")
  private String note = null;

  @JsonProperty("allegati")
  private List<String> allegati = null;

  public InfoNotaAttachmentsDto logId(String logId) {
    this.logId = logId;
    return this;
  }

   /**
   * identificativo delle informazioni inserite in formato &#x60;WLGxxxxxxxxxxxx&#x60;
   * @return logId
  **/
  @ApiModelProperty(value = "identificativo delle informazioni inserite in formato `WLGxxxxxxxxxxxx`")
  public String getLogId() {
    return logId;
  }

  public void setLogId(String logId) {
    this.logId = logId;
  }

  public InfoNotaAttachmentsDto dataLog(OffsetDateTime dataLog) {
    this.dataLog = dataLog;
    return this;
  }

   /**
   * data di inserimento note
   * @return dataLog
  **/
  @ApiModelProperty(value = "data di inserimento note")
  public OffsetDateTime getDataLog() {
    return dataLog;
  }

  public void setDataLog(OffsetDateTime dataLog) {
    this.dataLog = dataLog;
  }

  public InfoNotaAttachmentsDto tipologia(TipologiaEnum tipologia) {
    this.tipologia = tipologia;
    return this;
  }

   /**
   * tipologia di informazioni inserite
   * @return tipologia
  **/
  @ApiModelProperty(required = true, value = "tipologia di informazioni inserite")
  public TipologiaEnum getTipologia() {
    return tipologia;
  }

  public void setTipologia(TipologiaEnum tipologia) {
    this.tipologia = tipologia;
  }

  public InfoNotaAttachmentsDto note(String note) {
    this.note = note;
    return this;
  }

   /**
   * dettaglio informazioni inserite
   * @return note
  **/
  @ApiModelProperty(required = true, value = "dettaglio informazioni inserite")
  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public InfoNotaAttachmentsDto allegati(List<String> allegati) {
    this.allegati = allegati;
    return this;
  }

  public InfoNotaAttachmentsDto addAllegatiItem(String allegatiItem) {
    if (this.allegati == null) {
      this.allegati = new ArrayList<>();
    }
    this.allegati.add(allegatiItem);
    return this;
  }

   /**
   * Get allegati
   * @return allegati
  **/
  @ApiModelProperty(value = "")
  public List<String> getAllegati() {
    return allegati;
  }

  public void setAllegati(List<String> allegati) {
    this.allegati = allegati;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InfoNotaAttachmentsDto infoNotaAttachments = (InfoNotaAttachmentsDto) o;
    return Objects.equals(this.logId, infoNotaAttachments.logId) &&
        Objects.equals(this.dataLog, infoNotaAttachments.dataLog) &&
        Objects.equals(this.tipologia, infoNotaAttachments.tipologia) &&
        Objects.equals(this.note, infoNotaAttachments.note) &&
        Objects.equals(this.allegati, infoNotaAttachments.allegati);
  }

  @Override
  public int hashCode() {
    return Objects.hash(logId, dataLog, tipologia, note, allegati);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InfoNotaAttachments {\n");
    
    sb.append("    logId: ").append(toIndentedString(logId)).append("\n");
    sb.append("    dataLog: ").append(toIndentedString(dataLog)).append("\n");
    sb.append("    tipologia: ").append(toIndentedString(tipologia)).append("\n");
    sb.append("    note: ").append(toIndentedString(note)).append("\n");
    sb.append("    allegati: ").append(toIndentedString(allegati)).append("\n");
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

