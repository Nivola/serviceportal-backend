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
/*
 * troubleticketing
 * Le API consentono interoperabilit� con il sistema di Trouble Ticketing (creazione ticket, anagrafiche clienti ed info lavoro) ed interrogazione informazioni (stato ticket, elenco ticket il cui stato � stato variato, elenco company cliente, elenco categorizzazioni operative, catalogo applicativo, configuration items, anagrafiche clienti).  
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package it.csi.nivola.nivolasp.integration.remedy.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * LavorazioneBaseModel
 */

public class LavorazioneBaseModel {
  /**
   * stato della service request
   */
  public enum StatoEnum {
    ASSEGNATO("Assegnato"),
    
    IN_CORSO("In corso"),
    
    PENDENTE("Pendente"),
    
    RISOLTO("Risolto"),
    
    CHIUSO("Chiuso"),
    
    ANNULLATO("Annullato");

    private String value;

    StatoEnum(String value) {
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
    public static StatoEnum fromValue(String text) {
      for (StatoEnum b : StatoEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("stato")
  private StatoEnum stato = null;

  /**
   * comunicazioni sulla lavorazione
   */
  public enum MotivoStatoEnum {
    CREAZIONE_MODIFICA_INFRASTRUTTURALE("Creazione modifica infrastrutturale"),
    
    APPROVAZIONE_RICHIESTA("Approvazione Richiesta"),
    
    RICHIESTA_INFORMAZIONI("Richiesta Informazioni"),
    
    ATTESA_PARTI_HW("Attesa parti HW"),
    
    ALTRE_AZIONI_NON_NECESSARIE("Altre azioni non necessarie"),
    
    RISOLUZ_AUTOMATICA_RIPORTATA("Risoluz. automatica riportata"),
    
    NON_PI_CI_CAUSALE("Non pi� CI causale"),
    
    APPUNTAMENTO_CONTATTO("Appuntamento Contatto"),
    
    ASSENZA_INDIS_UTENTE("Assenza/indis. utente"),
    
    INTERVENTO_NON_RIUSCITO("Intervento non riuscito"),
    
    NON_APPROVATO("Non Approvato"),
    
    INOLTRATO("Inoltrato");

    private String value;

    MotivoStatoEnum(String value) {
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
    public static MotivoStatoEnum fromValue(String text) {
      for (MotivoStatoEnum b : MotivoStatoEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("motivoStato")
  private MotivoStatoEnum motivoStato = null;

  @JsonProperty("risoluzione")
  private String risoluzione = null;

  @JsonProperty("assegnatario")
  private String assegnatario = null;

  public LavorazioneBaseModel stato(StatoEnum stato) {
    this.stato = stato;
    return this;
  }

   /**
   * stato della service request
   * @return stato
  **/
  @ApiModelProperty(required = true, value = "stato della service request")
  public StatoEnum getStato() {
    return stato;
  }

  public void setStato(StatoEnum stato) {
    this.stato = stato;
  }

  public LavorazioneBaseModel motivoStato(MotivoStatoEnum motivoStato) {
    this.motivoStato = motivoStato;
    return this;
  }

   /**
   * comunicazioni sulla lavorazione
   * @return motivoStato
  **/
  @ApiModelProperty(value = "comunicazioni sulla lavorazione")
  public MotivoStatoEnum getMotivoStato() {
    return motivoStato;
  }

  public void setMotivoStato(MotivoStatoEnum motivoStato) {
    this.motivoStato = motivoStato;
  }

  public LavorazioneBaseModel risoluzione(String risoluzione) {
    this.risoluzione = risoluzione;
    return this;
  }

   /**
   * commento di chiusura della request
   * @return risoluzione
  **/
  @ApiModelProperty(value = "commento di chiusura della request")
  public String getRisoluzione() {
    return risoluzione;
  }

  public void setRisoluzione(String risoluzione) {
    this.risoluzione = risoluzione;
  }

  public LavorazioneBaseModel assegnatario(String assegnatario) {
    this.assegnatario = assegnatario;
    return this;
  }

   /**
   * alias del gruppo o nominativo operatore
   * @return assegnatario
  **/
  @ApiModelProperty(value = "alias del gruppo o nominativo operatore")
  public String getAssegnatario() {
    return assegnatario;
  }

  public void setAssegnatario(String assegnatario) {
    this.assegnatario = assegnatario;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LavorazioneBaseModel lavorazioneBaseModel = (LavorazioneBaseModel) o;
    return Objects.equals(this.stato, lavorazioneBaseModel.stato) &&
        Objects.equals(this.motivoStato, lavorazioneBaseModel.motivoStato) &&
        Objects.equals(this.risoluzione, lavorazioneBaseModel.risoluzione) &&
        Objects.equals(this.assegnatario, lavorazioneBaseModel.assegnatario);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stato, motivoStato, risoluzione, assegnatario);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LavorazioneBaseModel {\n");
    
    sb.append("    stato: ").append(toIndentedString(stato)).append("\n");
    sb.append("    motivoStato: ").append(toIndentedString(motivoStato)).append("\n");
    sb.append("    risoluzione: ").append(toIndentedString(risoluzione)).append("\n");
    sb.append("    assegnatario: ").append(toIndentedString(assegnatario)).append("\n");
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
