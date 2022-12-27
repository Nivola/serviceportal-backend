/*-
 * ========================LICENSE_START=================================
 * Servizi di accesso dati
 * %%
 * Copyright (C) 2022 Regione Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | Regione Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.service.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class VpcDTO extends AbstractDTO {

	private static final long serialVersionUID = 7259175016657907100L;

	@JsonProperty("cidrBlock")
	private String cidrBlock = null;

	@JsonProperty("cidrBlockAssociationSet")
	private List<CidrBlockAssociationsDTO> cidrBlockAssociationSet = null;

	@JsonProperty("dhcpOptionsId")
	private String dhcpOptionsId = null;

	/**
	 * allowed tenancy of instances launched into the VPC
	 */
	public enum InstanceTenancyEnum {
		DEFAULT("default"),

		DEDICATED("dedicated"),

		HOST("host");

		private String value;

		InstanceTenancyEnum(String value) {
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
		public static InstanceTenancyEnum fromValue(String text) {
			for (InstanceTenancyEnum b : InstanceTenancyEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("instanceTenancy")
	private InstanceTenancyEnum instanceTenancy = null;

	@JsonProperty("ipv6CidrBlockAssociationSet")
	private List<Object> ipv6CidrBlockAssociationSet = null;

	@JsonProperty("isDefault")
	private Boolean isDefault = null;

	@JsonProperty("nvl-name")
	private String nvlName = null;

	@JsonProperty("nvl-resourceId")
	private String nvlResourceId = null;

	@JsonProperty("nvl-vpcName")
	private String nvlVpcName = null;

	@JsonProperty("nvl-vpcOwnerAlias")
	private String nvlVpcOwnerAlias = null;

	@JsonProperty("nvl-vpcOwnerId")
	private String nvlVpcOwnerId = null;

	@JsonProperty("ownerId")
	private String ownerId = null;
	
	@JsonProperty("vpcId")
	private String vpcId = null;

	/**
	 * state of the VPC (pending | available | transient | error)
	 */
	public enum StateEnum {
		PENDING("pending"),

		AVAILABLE("available"),

		TRANSIENT("transient"),

		ERROR("error");

		private String value;

		StateEnum(String value) {
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
		public static StateEnum fromValue(String text) {
			for (StateEnum b : StateEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	public String getCidrBlock() {
		return cidrBlock;
	}

	public void setCidrBlock(String cidrBlock) {
		this.cidrBlock = cidrBlock;
	}

	public List<CidrBlockAssociationsDTO> getCidrBlockAssociationSet() {
		return cidrBlockAssociationSet;
	}

	public void setCidrBlockAssociationSet(List<CidrBlockAssociationsDTO> cidrBlockAssociationSet) {
		this.cidrBlockAssociationSet = cidrBlockAssociationSet;
	}

	public String getDhcpOptionsId() {
		return dhcpOptionsId;
	}

	public void setDhcpOptionsId(String dhcpOptionsId) {
		this.dhcpOptionsId = dhcpOptionsId;
	}

	public InstanceTenancyEnum getInstanceTenancy() {
		return instanceTenancy;
	}

	public void setInstanceTenancy(InstanceTenancyEnum instanceTenancy) {
		this.instanceTenancy = instanceTenancy;
	}

	public List<Object> getIpv6CidrBlockAssociationSet() {
		return ipv6CidrBlockAssociationSet;
	}

	public void setIpv6CidrBlockAssociationSet(List<Object> ipv6CidrBlockAssociationSet) {
		this.ipv6CidrBlockAssociationSet = ipv6CidrBlockAssociationSet;
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public String getNvlName() {
		return nvlName;
	}

	public void setNvlName(String nvlName) {
		this.nvlName = nvlName;
	}

	public String getNvlResourceId() {
		return nvlResourceId;
	}

	public void setNvlResourceId(String nvlResourceId) {
		this.nvlResourceId = nvlResourceId;
	}

	public String getNvlVpcName() {
		return nvlVpcName;
	}

	public void setNvlVpcName(String nvlVpcName) {
		this.nvlVpcName = nvlVpcName;
	}

	public String getNvlVpcOwnerAlias() {
		return nvlVpcOwnerAlias;
	}

	public void setNvlVpcOwnerAlias(String nvlVpcOwnerAlias) {
		this.nvlVpcOwnerAlias = nvlVpcOwnerAlias;
	}

	public String getNvlVpcOwnerId() {
		return nvlVpcOwnerId;
	}

	public void setNvlVpcOwnerId(String nvlVpcOwnerId) {
		this.nvlVpcOwnerId = nvlVpcOwnerId;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getVpcId() {
		return vpcId;
	}

	public void setVpcId(String vpcId) {
		this.vpcId = vpcId;
	}

	
}
