package com.amsidh.mvc.service;

import java.util.List;

import com.amsidh.mvc.dto.AddressDto;

public interface AddressService {
	
	public void saveAddress(AddressDto addressDto);
	public void updateAddress(AddressDto addressDto);
	public AddressDto getAddress(Integer addressId);
	public void deleteAddress(Integer addressId);
	public List<AddressDto> getAllAddresses();

}
