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

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

public class CategoriaOperativaTicketDto {
  @JsonProperty("ente")
  private String ente = null;

  @JsonProperty("livello1")
  private String livello1 = null;

  @JsonProperty("livello2")
  private String livello2 = null;

  @JsonProperty("livello3")
  private String livello3 = null;

  /**
   * tipologia di ticket
   */
  public enum TipologiaEnum {
    RIPRISTINO_DI_SERVIZIO_UTENTE("Ripristino di servizio utente"),
    
    RIPRISTINO_DI_SERVIZIO_INFRASTRUTTURALE("Ripristino di servizio infrastrutturale"),
    
    RICHIESTA_UTENTE("Richiesta utente"),
    
    EVENTO_INFRASTRUTTURALE("Evento infrastrutturale");

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

  public CategoriaOperativaTicketDto ente(String ente) {
    this.ente = ente;
    return this;
  }

   /**
   * company di riferimento
   * @return ente
  **/
  @ApiModelProperty(value = "company di riferimento")
  public String getEnte() {
    return ente;
  }

  public void setEnte(String ente) {
    this.ente = ente;
  }

  public CategoriaOperativaTicketDto livello1(String livello1) {
    this.livello1 = livello1;
    return this;
  }

   /**
   * primo livello dell&#39;organizzazione operativa del sistema di ticketing
   * @return livello1
  **/
  @ApiModelProperty(value = "primo livello dell'organizzazione operativa del sistema di ticketing")
  public String getLivello1() {
    return livello1;
  }

  public void setLivello1(String livello1) {
    this.livello1 = livello1;
  }

  public CategoriaOperativaTicketDto livello2(String livello2) {
    this.livello2 = livello2;
    return this;
  }

   /**
   * secondo livello dell&#39;organizzazione operativa del sistema di ticketing
   * @return livello2
  **/
  @ApiModelProperty(value = "secondo livello dell'organizzazione operativa del sistema di ticketing")
  public String getLivello2() {
    return livello2;
  }

  public void setLivello2(String livello2) {
    this.livello2 = livello2;
  }

  public CategoriaOperativaTicketDto livello3(String livello3) {
    this.livello3 = livello3;
    return this;
  }

   /**
   * terzo livello dell&#39;organizzazione operativa del sistema di ticketing
   * @return livello3
  **/
  @ApiModelProperty(value = "terzo livello dell'organizzazione operativa del sistema di ticketing")
  public String getLivello3() {
    return livello3;
  }

  public void setLivello3(String livello3) {
    this.livello3 = livello3;
  }

  public CategoriaOperativaTicketDto tipologia(TipologiaEnum tipologia) {
    this.tipologia = tipologia;
    return this;
  }

   /**
   * tipologia di ticket
   * @return tipologia
  **/
  @ApiModelProperty(value = "tipologia di ticket")
  public TipologiaEnum getTipologia() {
    return tipologia;
  }

  public void setTipologia(TipologiaEnum tipologia) {
    this.tipologia = tipologia;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategoriaOperativaTicketDto categoriaOperativaTicket = (CategoriaOperativaTicketDto) o;
    return Objects.equals(this.ente, categoriaOperativaTicket.ente) &&
        Objects.equals(this.livello1, categoriaOperativaTicket.livello1) &&
        Objects.equals(this.livello2, categoriaOperativaTicket.livello2) &&
        Objects.equals(this.livello3, categoriaOperativaTicket.livello3) &&
        Objects.equals(this.tipologia, categoriaOperativaTicket.tipologia);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ente, livello1, livello2, livello3, tipologia);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoriaOperativaTicket {\n");
    
    sb.append("    ente: ").append(toIndentedString(ente)).append("\n");
    sb.append("    livello1: ").append(toIndentedString(livello1)).append("\n");
    sb.append("    livello2: ").append(toIndentedString(livello2)).append("\n");
    sb.append("    livello3: ").append(toIndentedString(livello3)).append("\n");
    sb.append("    tipologia: ").append(toIndentedString(tipologia)).append("\n");
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

