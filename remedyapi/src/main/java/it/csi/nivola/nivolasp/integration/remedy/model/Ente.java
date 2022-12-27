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
 * Ente
 */

public class Ente {
  @JsonProperty("companyId")
  private String companyId = null;

  /**
   * tipo di company
   */
  public enum TipologiaEnum {
    CLIENTE("Cliente"),
    
    FORNITORE("Fornitore"),
    
    RIVENDITORE("Rivenditore"),
    
    COMPANY_OPERATIVA("Company Operativa");

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

  @JsonProperty("companyName")
  private String companyName = null;

  @JsonProperty("stato")
  private String stato = null;

  @JsonProperty("anagraficaName")
  private String anagraficaName = null;

  @JsonProperty("anagraficaId")
  private Integer anagraficaId = null;

  public Ente companyId(String companyId) {
    this.companyId = companyId;
    return this;
  }

   /**
   * identificativo della company in formato &#x60;CPYxxxxxxxxxxxx&#x60;
   * @return companyId
  **/
  @ApiModelProperty(value = "identificativo della company in formato `CPYxxxxxxxxxxxx`")
  public String getCompanyId() {
    return companyId;
  }

  public void setCompanyId(String companyId) {
    this.companyId = companyId;
  }

  public Ente tipologia(TipologiaEnum tipologia) {
    this.tipologia = tipologia;
    return this;
  }

   /**
   * tipo di company
   * @return tipologia
  **/
  @ApiModelProperty(value = "tipo di company")
  public TipologiaEnum getTipologia() {
    return tipologia;
  }

  public void setTipologia(TipologiaEnum tipologia) {
    this.tipologia = tipologia;
  }

  public Ente companyName(String companyName) {
    this.companyName = companyName;
    return this;
  }

   /**
   * company name utilizzata su remedy
   * @return companyName
  **/
  @ApiModelProperty(value = "company name utilizzata su remedy")
  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public Ente stato(String stato) {
    this.stato = stato;
    return this;
  }

   /**
   * stato dell&#39;anagrafica
   * @return stato
  **/
  @ApiModelProperty(value = "stato dell'anagrafica")
  public String getStato() {
    return stato;
  }

  public void setStato(String stato) {
    this.stato = stato;
  }

  public Ente anagraficaName(String anagraficaName) {
    this.anagraficaName = anagraficaName;
    return this;
  }

   /**
   * company name da anagrafica enti
   * @return anagraficaName
  **/
  @ApiModelProperty(value = "company name da anagrafica enti")
  public String getAnagraficaName() {
    return anagraficaName;
  }

  public void setAnagraficaName(String anagraficaName) {
    this.anagraficaName = anagraficaName;
  }

  public Ente anagraficaId(Integer anagraficaId) {
    this.anagraficaId = anagraficaId;
    return this;
  }

   /**
   * company id da anagrafica enti
   * @return anagraficaId
  **/
  @ApiModelProperty(value = "company id da anagrafica enti")
  public Integer getAnagraficaId() {
    return anagraficaId;
  }

  public void setAnagraficaId(Integer anagraficaId) {
    this.anagraficaId = anagraficaId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ente ente = (Ente) o;
    return Objects.equals(this.companyId, ente.companyId) &&
        Objects.equals(this.tipologia, ente.tipologia) &&
        Objects.equals(this.companyName, ente.companyName) &&
        Objects.equals(this.stato, ente.stato) &&
        Objects.equals(this.anagraficaName, ente.anagraficaName) &&
        Objects.equals(this.anagraficaId, ente.anagraficaId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(companyId, tipologia, companyName, stato, anagraficaName, anagraficaId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ente {\n");
    
    sb.append("    companyId: ").append(toIndentedString(companyId)).append("\n");
    sb.append("    tipologia: ").append(toIndentedString(tipologia)).append("\n");
    sb.append("    companyName: ").append(toIndentedString(companyName)).append("\n");
    sb.append("    stato: ").append(toIndentedString(stato)).append("\n");
    sb.append("    anagraficaName: ").append(toIndentedString(anagraficaName)).append("\n");
    sb.append("    anagraficaId: ").append(toIndentedString(anagraficaId)).append("\n");
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

