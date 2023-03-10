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
 * RunCustomizationsApiRequestSchemaCustomization
 */

public class RunCustomizationsApiRequestSchemaCustomization {
  @JsonProperty("Args")
  private List<RunCustomizationsApiRequestSchemaCustomizationArgs> args = new ArrayList<>();

  @JsonProperty("CustomizationType")
  private String customizationType = null;

  @JsonProperty("Instances")
  private List<String> instances = new ArrayList<>();

  @JsonProperty("Name")
  private String name = null;

  @JsonProperty("owner-id")
  private String ownerId = null;

  public RunCustomizationsApiRequestSchemaCustomization args(List<RunCustomizationsApiRequestSchemaCustomizationArgs> args) {
    this.args = args;
    return this;
  }

  public RunCustomizationsApiRequestSchemaCustomization addArgsItem(RunCustomizationsApiRequestSchemaCustomizationArgs argsItem) {
    this.args.add(argsItem);
    return this;
  }

   /**
   * customization type args
   * @return args
  **/
  @ApiModelProperty(required = true, value = "customization type args")
  public List<RunCustomizationsApiRequestSchemaCustomizationArgs> getArgs() {
    return args;
  }

  public void setArgs(List<RunCustomizationsApiRequestSchemaCustomizationArgs> args) {
    this.args = args;
  }

  public RunCustomizationsApiRequestSchemaCustomization customizationType(String customizationType) {
    this.customizationType = customizationType;
    return this;
  }

   /**
   * customization type
   * @return customizationType
  **/
  @ApiModelProperty(example = "nginx", required = true, value = "customization type")
  public String getCustomizationType() {
    return customizationType;
  }

  public void setCustomizationType(String customizationType) {
    this.customizationType = customizationType;
  }

  public RunCustomizationsApiRequestSchemaCustomization instances(List<String> instances) {
    this.instances = instances;
    return this;
  }

  public RunCustomizationsApiRequestSchemaCustomization addInstancesItem(String instancesItem) {
    this.instances.add(instancesItem);
    return this;
  }

   /**
   * list of compute instance id
   * @return instances
  **/
  @ApiModelProperty(required = true, value = "list of compute instance id")
  public List<String> getInstances() {
    return instances;
  }

  public void setInstances(List<String> instances) {
    this.instances = instances;
  }

  public RunCustomizationsApiRequestSchemaCustomization name(String name) {
    this.name = name;
    return this;
  }

   /**
   * customization name
   * @return name
  **/
  @ApiModelProperty(example = "test", required = true, value = "customization name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RunCustomizationsApiRequestSchemaCustomization ownerId(String ownerId) {
    this.ownerId = ownerId;
    return this;
  }

   /**
   * parent account id
   * @return ownerId
  **/
  @ApiModelProperty(example = "test", required = true, value = "parent account id")
  public String getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(String ownerId) {
    this.ownerId = ownerId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RunCustomizationsApiRequestSchemaCustomization runCustomizationsApiRequestSchemaCustomization = (RunCustomizationsApiRequestSchemaCustomization) o;
    return Objects.equals(this.args, runCustomizationsApiRequestSchemaCustomization.args) &&
        Objects.equals(this.customizationType, runCustomizationsApiRequestSchemaCustomization.customizationType) &&
        Objects.equals(this.instances, runCustomizationsApiRequestSchemaCustomization.instances) &&
        Objects.equals(this.name, runCustomizationsApiRequestSchemaCustomization.name) &&
        Objects.equals(this.ownerId, runCustomizationsApiRequestSchemaCustomization.ownerId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(args, customizationType, instances, name, ownerId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RunCustomizationsApiRequestSchemaCustomization {\n");
    
    sb.append("    args: ").append(toIndentedString(args)).append("\n");
    sb.append("    customizationType: ").append(toIndentedString(customizationType)).append("\n");
    sb.append("    instances: ").append(toIndentedString(instances)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
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

