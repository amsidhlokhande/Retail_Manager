package com.amsidh.mvc.service;

import java.util.List;

import com.amsidh.mvc.dto.ShopDto;

public interface ShopService {
	
	public void saveShopDetails(ShopDto shop);
	public void updateShopDetails(ShopDto shop);
	public ShopDto getShopDetails(Integer shopId);
	public void deleteShopDetails(Integer shopId);
	public List<ShopDto> getAllShops();

}
