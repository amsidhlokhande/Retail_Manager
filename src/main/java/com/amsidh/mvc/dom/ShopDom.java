package com.amsidh.mvc.dom;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shops")
public class ShopDom implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer shopId;
	private String shopName;

	private Integer addressId;

	public ShopDom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShopDom(Integer shopId, String shopName, Integer addressId) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
		this.addressId = addressId;
	}

	public ShopDom(Integer shopId, String shopName) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
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

}
