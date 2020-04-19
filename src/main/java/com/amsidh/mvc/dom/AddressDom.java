package com.amsidh.mvc.dom;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "addresses")
public class AddressDom implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer addressId;
	private Integer postCode;
	private Double longitude;
	private Double latitude;

	private Integer shopId;

	public AddressDom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressDom(Integer addressId, Integer postCode, Double longitude, Double latitude, Integer shopId) {
		super();
		this.addressId = addressId;
		this.postCode = postCode;
		this.longitude = longitude;
		this.latitude = latitude;
		this.shopId = shopId;
	}

	public AddressDom(Integer addressId, Integer postCode, Double longitude, Double latitude) {
		super();
		this.addressId = addressId;
		this.postCode = postCode;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public AddressDom(Integer addressId, Integer postCode) {
		super();
		this.addressId = addressId;
		this.postCode = postCode;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Integer getPostCode() {
		return postCode;
	}

	public void setPostCode(Integer postCode) {
		this.postCode = postCode;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

}
