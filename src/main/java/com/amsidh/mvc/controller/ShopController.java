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
import org.springframework.web.bind.annotation.ResponseBody;

import com.amsidh.mvc.dto.ShopDto;
import com.amsidh.mvc.service.ShopService;

@Controller
public class ShopController {
	private static final Logger logger = Logger.getLogger(ShopController.class);

	@Autowired
	private ShopService shopService;

	public ShopController() {
		logger.info("Loading ShopController!!!!");

	}

	@RequestMapping(value = "/shops", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<Resource<ShopDto>> getAllShops() {
		Collection<ShopDto> shops = shopService.getAllShops();

		Collection<Resource<ShopDto>> resources = new ArrayList<Resource<ShopDto>>();
		for (ShopDto shopDto : shops) {
			if (null != shopDto)
				resources.add(getShopDtoResource(shopDto));
		}

		return resources;
	}

	private Resource<ShopDto> getShopDtoResource(ShopDto shopDto) {
		Resource<ShopDto> resource = new Resource<ShopDto>(shopDto);
		// Link to Shop
		resource.add(linkTo(methodOn(ShopController.class).getShop(shopDto.getShopId())).withSelfRel());
		resource.add(linkTo(methodOn(AddressController.class).getAddress(shopDto.getAddressId())).withRel("AddressDetail"));
		return resource;
	}

	@RequestMapping(value = "/shops/{shopId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Resource<ShopDto> getShop(@PathVariable(value = "shopId") Integer shopId) {

		ShopDto shopDto = shopService.getShopDetails(shopId);
		if (null != shopDto) {
			Resource<ShopDto> shopDtoResource = getShopDtoResource(shopDto);
			shopDtoResource.add(linkTo(methodOn(ShopController.class).getAllShops()).withRel("AllShops"));
			return shopDtoResource;
		} else {
			return null;
		}
	}

	
	@RequestMapping(value = "/shops", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<Resource<ShopDto>> saveShop(@RequestBody ShopDto shopDto) {
		shopService.saveShopDetails(shopDto);
		Collection<ShopDto> shops = shopService.getAllShops();

		Collection<Resource<ShopDto>> resources = new ArrayList<Resource<ShopDto>>();
		for (ShopDto shop : shops) {
			if (null != shop)
				resources.add(getShopDtoResource(shop));
		}

		return resources;
	}

}

