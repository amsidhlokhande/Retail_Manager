/**
 * 
 */
package com.amsidh.mvc.util;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.amsidh.mvc.dom.AddressDom;
import com.amsidh.mvc.dom.ShopDom;
import com.amsidh.mvc.dto.AddressDto;
import com.amsidh.mvc.dto.ShopDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author amsidhlokhande
 *
 */
public class ShopUtility {

	private ShopUtility() {
	}

	public static ShopDto getShopDto(ShopDom shopDom) {

		return null == shopDom ? null : new ShopDto(shopDom.getShopId(), shopDom.getShopName(), shopDom.getAddressId());

	}

	public static AddressDto getAddressDto(AddressDom addressDom) {
		if (null != addressDom) {
			AddressDto addressDto = new AddressDto(addressDom.getAddressId(), addressDom.getPostCode());
			if (null != addressDom.getLongitude()) {
				addressDto.setLongitude(addressDom.getLongitude());
			}

			if (null != addressDom.getLatitude()) {
				addressDto.setLatitude(addressDom.getLatitude());
			}
			if (null != addressDom.getShopId()) {
				addressDto.setShopId(addressDom.getShopId());
			}

			return addressDto;
		} else {
			return null;
		}
	}

	public static ShopDom getShopDom(ShopDto shopDto) {

		return shopDto == null ? null : new ShopDom(shopDto.getShopId(), shopDto.getShopName(), shopDto.getAddressId());
	}

	public static AddressDom getAddressDom(AddressDto addressDto) {
		geoCoding(addressDto);

		AddressDom addressDom = new AddressDom(addressDto.getAddressId(), addressDto.getPostCode());

		if (null != addressDto.getLongitude()) {
			addressDom.setLongitude(addressDto.getLongitude());
		}
		if (null != addressDto.getLatitude()) {
			addressDom.setLatitude(addressDto.getLatitude());
		}

		if (null != addressDto.getShopId()) {
			addressDom.setShopId(addressDto.getShopId());
		}

		return addressDom;
	}

	public static List<ShopDto> getAllShopDto(List<ShopDom> shopDoms) {
		List<ShopDto> shopDtos = new ArrayList();

		for (ShopDom shopDom : shopDoms) {
			shopDtos.add(new ShopDto(shopDom.getShopId(), shopDom.getShopName(), shopDom.getAddressId()));
		}
		return shopDtos;

	}

	public static List<ShopDom> getAllShopDoms(List<ShopDto> shopDtos) {

		List<ShopDom> shopDoms = new ArrayList();
		for (ShopDto shopDto : shopDtos) {
			shopDoms.add(new ShopDom(shopDto.getShopId(), shopDto.getShopName(), shopDto.getAddressId()));
		}
		return shopDoms;
	}

	private static final void geoCoding(AddressDto addressDto) {

		if (addressDto != null) {
			if (null == addressDto.getLongitude() || null == addressDto.getLatitude()) {

				try {
					URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?address='"
							+ addressDto.getPostCode() + "'&sensor=false");
					ObjectMapper objectMapper = new ObjectMapper();
					JsonNode node = objectMapper.readValue(url, JsonNode.class);
					JsonNode location = node.get("results").get(0).get("geometry").get("location");
					addressDto.setLongitude(location.get("lng").asDouble());
					addressDto.setLatitude(location.get("lat").asDouble());
				} catch (Exception ex) {

					System.out.println(
							"Internet Connection unavailable or Geographical Information is not found for given pin code"
									+ ex.getLocalizedMessage());
				}
			}
		}

	}
}
