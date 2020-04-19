package com.amsidh.mvc.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ShopDto {
	private Integer shopId;
	private String shopName;

	private Integer addressId;
	
	
	
	public ShopDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShopDto(Integer shopId, String shopName) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
	}

	public ShopDto(Integer shopId, String shopName, Integer addressId) {
		this.shopId = shopId;
		this.shopName = shopName;
		this.addressId = addressId;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	
	
	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	@Override
	public String toString() {
		return "{ShopID:" + this.shopId + ", ShopName:" + this.shopName +", AddressId:"+this.addressId +"}";
	}

}
