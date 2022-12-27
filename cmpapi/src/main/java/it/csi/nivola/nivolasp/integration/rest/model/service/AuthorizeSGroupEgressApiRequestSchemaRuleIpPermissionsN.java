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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * AuthorizeSGroupEgressApiRequestSchemaRuleIpPermissionsN
 */

public class AuthorizeSGroupEgressApiRequestSchemaRuleIpPermissionsN {
  @JsonProperty("FromPort")
  private Integer fromPort = null;

  /**
   * IP protocol for security group rule
   */
  public enum IpProtocolEnum {
    TCP("tcp"),
    
    UDP("udp"),
    
    ICMP("icmp"),
    
    _1("-1");

    private String value;

    IpProtocolEnum(String value) {
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
    public static IpProtocolEnum fromValue(String value) {
      for (IpProtocolEnum b : IpProtocolEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("IpProtocol")
  private IpProtocolEnum ipProtocol = null;

  @JsonProperty("IpRanges")
  private List<AuthorizeSGroupEgressApiRequestSchemaRuleIpRanges> ipRanges = null;

  @JsonProperty("Ipv6Ranges")
  private List<AuthorizeSGroupEgressApiRequestSchemaRuleIpv6Ranges> ipv6Ranges = null;

  @JsonProperty("ToPort")
  private Integer toPort = null;

  @JsonProperty("UserIdGroupPairs")
  private List<AuthorizeSGroupEgressApiRequestSchemaRuleUserIdGroupPairs> userIdGroupPairs = null;

  @JsonProperty("prefixListIds")
  private List<AuthorizeSGroupEgressApiRequestSchemaRulePrefixListIds> prefixListIds = null;

  public AuthorizeSGroupEgressApiRequestSchemaRuleIpPermissionsN fromPort(Integer fromPort) {
    this.fromPort = fromPort;
    return this;
  }

   /**
   * start of port range for the protocols tcp, udp. Subprotocol for icmp
   * @return fromPort
  **/
  @ApiModelProperty(example = "", value = "start of port range for the protocols tcp, udp. Subprotocol for icmp")
  public Integer getFromPort() {
    return fromPort;
  }

  public void setFromPort(Integer fromPort) {
    this.fromPort = fromPort;
  }

  public AuthorizeSGroupEgressApiRequestSchemaRuleIpPermissionsN ipProtocol(IpProtocolEnum ipProtocol) {
    this.ipProtocol = ipProtocol;
    return this;
  }

   /**
   * IP protocol for security group rule
   * @return ipProtocol
  **/
  @ApiModelProperty(value = "IP protocol for security group rule")
  public IpProtocolEnum getIpProtocol() {
    return ipProtocol;
  }

  public void setIpProtocol(IpProtocolEnum ipProtocol) {
    this.ipProtocol = ipProtocol;
  }

  public AuthorizeSGroupEgressApiRequestSchemaRuleIpPermissionsN ipRanges(List<AuthorizeSGroupEgressApiRequestSchemaRuleIpRanges> ipRanges) {
    this.ipRanges = ipRanges;
    return this;
  }

  public AuthorizeSGroupEgressApiRequestSchemaRuleIpPermissionsN addIpRangesItem(AuthorizeSGroupEgressApiRequestSchemaRuleIpRanges ipRangesItem) {
    if (this.ipRanges == null) {
      this.ipRanges = new ArrayList<>();
    }
    this.ipRanges.add(ipRangesItem);
    return this;
  }

   /**
   * one or more ipv4 range
   * @return ipRanges
  **/
  @ApiModelProperty(value = "one or more ipv4 range")
  public List<AuthorizeSGroupEgressApiRequestSchemaRuleIpRanges> getIpRanges() {
    return ipRanges;
  }

  public void setIpRanges(List<AuthorizeSGroupEgressApiRequestSchemaRuleIpRanges> ipRanges) {
    this.ipRanges = ipRanges;
  }

  public AuthorizeSGroupEgressApiRequestSchemaRuleIpPermissionsN ipv6Ranges(List<AuthorizeSGroupEgressApiRequestSchemaRuleIpv6Ranges> ipv6Ranges) {
    this.ipv6Ranges = ipv6Ranges;
    return this;
  }

  public AuthorizeSGroupEgressApiRequestSchemaRuleIpPermissionsN addIpv6RangesItem(AuthorizeSGroupEgressApiRequestSchemaRuleIpv6Ranges ipv6RangesItem) {
    if (this.ipv6Ranges == null) {
      this.ipv6Ranges = new ArrayList<>();
    }
    this.ipv6Ranges.add(ipv6RangesItem);
    return this;
  }

   /**
   * one or more ipv6 range
   * @return ipv6Ranges
  **/
  @ApiModelProperty(value = "one or more ipv6 range")
  public List<AuthorizeSGroupEgressApiRequestSchemaRuleIpv6Ranges> getIpv6Ranges() {
    return ipv6Ranges;
  }

  public void setIpv6Ranges(List<AuthorizeSGroupEgressApiRequestSchemaRuleIpv6Ranges> ipv6Ranges) {
    this.ipv6Ranges = ipv6Ranges;
  }

  public AuthorizeSGroupEgressApiRequestSchemaRuleIpPermissionsN toPort(Integer toPort) {
    this.toPort = toPort;
    return this;
  }

   /**
   * end of port range for the protocols
   * @return toPort
  **/
  @ApiModelProperty(example = "", value = "end of port range for the protocols")
  public Integer getToPort() {
    return toPort;
  }

  public void setToPort(Integer toPort) {
    this.toPort = toPort;
  }

  public AuthorizeSGroupEgressApiRequestSchemaRuleIpPermissionsN userIdGroupPairs(List<AuthorizeSGroupEgressApiRequestSchemaRuleUserIdGroupPairs> userIdGroupPairs) {
    this.userIdGroupPairs = userIdGroupPairs;
    return this;
  }

  public AuthorizeSGroupEgressApiRequestSchemaRuleIpPermissionsN addUserIdGroupPairsItem(AuthorizeSGroupEgressApiRequestSchemaRuleUserIdGroupPairs userIdGroupPairsItem) {
    if (this.userIdGroupPairs == null) {
      this.userIdGroupPairs = new ArrayList<>();
    }
    this.userIdGroupPairs.add(userIdGroupPairsItem);
    return this;
  }

   /**
   * One or more security group and account ID pairs
   * @return userIdGroupPairs
  **/
  @ApiModelProperty(value = "One or more security group and account ID pairs")
  public List<AuthorizeSGroupEgressApiRequestSchemaRuleUserIdGroupPairs> getUserIdGroupPairs() {
    return userIdGroupPairs;
  }

  public void setUserIdGroupPairs(List<AuthorizeSGroupEgressApiRequestSchemaRuleUserIdGroupPairs> userIdGroupPairs) {
    this.userIdGroupPairs = userIdGroupPairs;
  }

  public AuthorizeSGroupEgressApiRequestSchemaRuleIpPermissionsN prefixListIds(List<AuthorizeSGroupEgressApiRequestSchemaRulePrefixListIds> prefixListIds) {
    this.prefixListIds = prefixListIds;
    return this;
  }

  public AuthorizeSGroupEgressApiRequestSchemaRuleIpPermissionsN addPrefixListIdsItem(AuthorizeSGroupEgressApiRequestSchemaRulePrefixListIds prefixListIdsItem) {
    if (this.prefixListIds == null) {
      this.prefixListIds = new ArrayList<>();
    }
    this.prefixListIds.add(prefixListIdsItem);
    return this;
  }

   /**
   * One or more prefix list IDs for a service
   * @return prefixListIds
  **/
  @ApiModelProperty(value = "One or more prefix list IDs for a service")
  public List<AuthorizeSGroupEgressApiRequestSchemaRulePrefixListIds> getPrefixListIds() {
    return prefixListIds;
  }

  public void setPrefixListIds(List<AuthorizeSGroupEgressApiRequestSchemaRulePrefixListIds> prefixListIds) {
    this.prefixListIds = prefixListIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthorizeSGroupEgressApiRequestSchemaRuleIpPermissionsN authorizeSGroupEgressApiRequestSchemaRuleIpPermissionsN = (AuthorizeSGroupEgressApiRequestSchemaRuleIpPermissionsN) o;
    return Objects.equals(this.fromPort, authorizeSGroupEgressApiRequestSchemaRuleIpPermissionsN.fromPort) &&
        Objects.equals(this.ipProtocol, authorizeSGroupEgressApiRequestSchemaRuleIpPermissionsN.ipProtocol) &&
        Objects.equals(this.ipRanges, authorizeSGroupEgressApiRequestSchemaRuleIpPermissionsN.ipRanges) &&
        Objects.equals(this.ipv6Ranges, authorizeSGroupEgressApiRequestSchemaRuleIpPermissionsN.ipv6Ranges) &&
        Objects.equals(this.toPort, authorizeSGroupEgressApiRequestSchemaRuleIpPermissionsN.toPort) &&
        Objects.equals(this.userIdGroupPairs, authorizeSGroupEgressApiRequestSchemaRuleIpPermissionsN.userIdGroupPairs) &&
        Objects.equals(this.prefixListIds, authorizeSGroupEgressApiRequestSchemaRuleIpPermissionsN.prefixListIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fromPort, ipProtocol, ipRanges, ipv6Ranges, toPort, userIdGroupPairs, prefixListIds);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthorizeSGroupEgressApiRequestSchemaRuleIpPermissionsN {\n");
    
    sb.append("    fromPort: ").append(toIndentedString(fromPort)).append("\n");
    sb.append("    ipProtocol: ").append(toIndentedString(ipProtocol)).append("\n");
    sb.append("    ipRanges: ").append(toIndentedString(ipRanges)).append("\n");
    sb.append("    ipv6Ranges: ").append(toIndentedString(ipv6Ranges)).append("\n");
    sb.append("    toPort: ").append(toIndentedString(toPort)).append("\n");
    sb.append("    userIdGroupPairs: ").append(toIndentedString(userIdGroupPairs)).append("\n");
    sb.append("    prefixListIds: ").append(toIndentedString(prefixListIds)).append("\n");
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

