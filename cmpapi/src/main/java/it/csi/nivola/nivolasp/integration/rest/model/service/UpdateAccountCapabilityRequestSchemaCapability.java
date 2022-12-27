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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * UpdateAccountCapabilityRequestSchemaCapability
 */

public class UpdateAccountCapabilityRequestSchemaCapability {
  @JsonProperty("definitions")
  private List<String> definitions = null;

  @JsonProperty("desc")
  private String desc = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("plugin_name")
  private String pluginName = null;

  @JsonProperty("services")
  private List<CreateAccountCapabilityRequestSchemaCapabilityServices> services = null;

  @JsonProperty("version")
  private String version = null;

  public UpdateAccountCapabilityRequestSchemaCapability definitions(List<String> definitions) {
    this.definitions = definitions;
    return this;
  }

  public UpdateAccountCapabilityRequestSchemaCapability addDefinitionsItem(String definitionsItem) {
    if (this.definitions == null) {
      this.definitions = new ArrayList<>();
    }
    this.definitions.add(definitionsItem);
    return this;
  }

   /**
   * List of Service definition added by the capability
   * @return definitions
  **/
  @ApiModelProperty(value = "List of Service definition added by the capability")
  public List<String> getDefinitions() {
    return definitions;
  }

  public void setDefinitions(List<String> definitions) {
    this.definitions = definitions;
  }

  public UpdateAccountCapabilityRequestSchemaCapability desc(String desc) {
    this.desc = desc;
    return this;
  }

   /**
   * Get desc
   * @return desc
  **/
  @ApiModelProperty(value = "")
  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public UpdateAccountCapabilityRequestSchemaCapability name(String name) {
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

  public UpdateAccountCapabilityRequestSchemaCapability pluginName(String pluginName) {
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

  public UpdateAccountCapabilityRequestSchemaCapability services(List<CreateAccountCapabilityRequestSchemaCapabilityServices> services) {
    this.services = services;
    return this;
  }

  public UpdateAccountCapabilityRequestSchemaCapability addServicesItem(CreateAccountCapabilityRequestSchemaCapabilityServices servicesItem) {
    if (this.services == null) {
      this.services = new ArrayList<>();
    }
    this.services.add(servicesItem);
    return this;
  }

   /**
   * List of ServiceInstanced added by the capability
   * @return services
  **/
  @ApiModelProperty(value = "List of ServiceInstanced added by the capability")
  public List<CreateAccountCapabilityRequestSchemaCapabilityServices> getServices() {
    return services;
  }

  public void setServices(List<CreateAccountCapabilityRequestSchemaCapabilityServices> services) {
    this.services = services;
  }

  public UpdateAccountCapabilityRequestSchemaCapability version(String version) {
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
    UpdateAccountCapabilityRequestSchemaCapability updateAccountCapabilityRequestSchemaCapability = (UpdateAccountCapabilityRequestSchemaCapability) o;
    return Objects.equals(this.definitions, updateAccountCapabilityRequestSchemaCapability.definitions) &&
        Objects.equals(this.desc, updateAccountCapabilityRequestSchemaCapability.desc) &&
        Objects.equals(this.name, updateAccountCapabilityRequestSchemaCapability.name) &&
        Objects.equals(this.pluginName, updateAccountCapabilityRequestSchemaCapability.pluginName) &&
        Objects.equals(this.services, updateAccountCapabilityRequestSchemaCapability.services) &&
        Objects.equals(this.version, updateAccountCapabilityRequestSchemaCapability.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(definitions, desc, name, pluginName, services, version);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateAccountCapabilityRequestSchemaCapability {\n");
    
    sb.append("    definitions: ").append(toIndentedString(definitions)).append("\n");
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    pluginName: ").append(toIndentedString(pluginName)).append("\n");
    sb.append("    services: ").append(toIndentedString(services)).append("\n");
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

