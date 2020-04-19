package com.amsidh.mvc.dto;

public class AddressDto {

	private Integer addressId;
	private Integer postCode;
	private Double longitude;
	private Double latitude;

	private Integer shopId;

	public AddressDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressDto(Integer addressId, Integer postCode, Double longitude, Double latitude, Integer shopId) {
		super();
		this.addressId = addressId;
		this.postCode = postCode;
		this.longitude = longitude;
		this.latitude = latitude;
		this.shopId = shopId;
	}

	public AddressDto(Integer addressId, Integer postCode, Integer shopId) {
		super();
		this.addressId = addressId;
		this.postCode = postCode;
		this.shopId = shopId;
	}

	public AddressDto(Integer addressId, Integer postCode) {
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

	@Override
	public String toString() {
		return "{ShopAddress:{" + "AddressId:" + this.addressId + ", PostCode:" + this.postCode + ", Longitude:"
				+ this.longitude + ", Latitude:" + this.latitude + "}";
	}

}