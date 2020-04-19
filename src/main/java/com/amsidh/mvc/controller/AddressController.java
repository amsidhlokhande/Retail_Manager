package com.amsidh.mvc.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amsidh.mvc.dto.AddressDto;
import com.amsidh.mvc.service.AddressService;

@Controller
public class AddressController {

	private static final Logger logger = Logger.getLogger(AddressController.class);

	@Autowired
	private AddressService addressService;

	public AddressController() {
		logger.info("Loading AddressController!!!!");

	}
	
	@RequestMapping(value = "/addresses", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<Resource<AddressDto>> getAllAddresses() {
		Collection<AddressDto> addresses = addressService.getAllAddresses();

		Collection<Resource<AddressDto>> resources = new ArrayList<Resource<AddressDto>>();
		for (AddressDto addressDto : addresses) {
			if (null != addressDto)
				resources.add(getAddressDtoResource(addressDto));
		}

		return resources;
	}

	private Resource<AddressDto> getAddressDtoResource(AddressDto addressDto) {
		Resource<AddressDto> resource = new Resource<AddressDto>(addressDto);
		// Link to Shop
		resource.add(linkTo(methodOn(AddressController.class).getAddress(addressDto.getAddressId())).withSelfRel());
		resource.add(linkTo(methodOn(ShopController.class).getShop(addressDto.getShopId())).withRel("Shop"));
		return resource;
	}

	@RequestMapping(value = "/addresses/{addressId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Resource<AddressDto> getAddress(@PathVariable(value = "addressId") Integer addressId) {

		AddressDto addressDto = addressService.getAddress(addressId);
		if (null != addressDto) {
			Resource<AddressDto> AddressDtoResource = getAddressDtoResource(addressDto);
			AddressDtoResource.add(linkTo(methodOn(AddressController.class).getAllAddresses()).withRel("Addresses"));
			return AddressDtoResource;
		} else {
			return null;
		}
	}
	
	
	@RequestMapping(value = "/addresses", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<Resource<AddressDto>> saveAddress(@RequestBody AddressDto addressDto) {

		addressService.saveAddress(addressDto);
		
		Collection<AddressDto> addresses = addressService.getAllAddresses();
		Collection<Resource<AddressDto>> resources = new ArrayList<Resource<AddressDto>>();
		for (AddressDto address : addresses) {
			if (null != address)
				resources.add(getAddressDtoResource(address));
		}

		return resources;
	}
}
