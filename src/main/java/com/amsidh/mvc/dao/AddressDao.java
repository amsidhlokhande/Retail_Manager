package com.amsidh.mvc.dao;

import java.util.List;

import com.amsidh.mvc.dom.AddressDom;

public interface AddressDao {

	public void createAddress(AddressDom addressDom);

	public void updateAddress(AddressDom addressDom);

	public AddressDom getAddressDomByAddressId(Integer addressId);

	public void deleteAddressByAddressId(Integer addressId);

	public List<AddressDom> getAllAddresss();
}
