package com.amsidh.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amsidh.mvc.dao.AddressDao;
import com.amsidh.mvc.dom.AddressDom;
import com.amsidh.mvc.dto.AddressDto;
import com.amsidh.mvc.service.AddressService;
import com.amsidh.mvc.util.ShopUtility;
@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao addressDao;
	
	
	@Override
	public void saveAddress(AddressDto addressDto) {
		addressDao.createAddress(ShopUtility.getAddressDom(addressDto));;

	}

	@Override
	public void updateAddress(AddressDto addressDto) {
		addressDao.updateAddress(ShopUtility.getAddressDom(addressDto));

	}

	@Override
	public AddressDto getAddress(Integer addressId) {
		
		return ShopUtility.getAddressDto(addressDao.getAddressDomByAddressId(addressId));
	}

	@Override
	public void deleteAddress(Integer addressId) {
       addressDao.deleteAddressByAddressId(addressId);

	}

	@Override
	public List<AddressDto> getAllAddresses() {
		
		List<AddressDto> addressDtos=new ArrayList();
		List<AddressDom> addressDoms = addressDao.getAllAddresss();
		if(null!=addressDoms & !addressDoms.isEmpty())
		{
			for(AddressDom addressDom:addressDoms){
				addressDtos.add(ShopUtility.getAddressDto(addressDom));
			}
		}
		
		return addressDtos;
	}

}
