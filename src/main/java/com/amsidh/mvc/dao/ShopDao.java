/**
 * 
 */
package com.amsidh.mvc.dao;

import java.util.List;

import com.amsidh.mvc.dom.ShopDom;

/**
 * @author amsidhlokhande
 *
 */
public interface ShopDao {

	public void createShop(ShopDom shopDom);

	public void updateShop(ShopDom shopDom);

	public ShopDom getShopDomByShopId(Integer shopId);

	public void deleteShopByShopId(Integer shopId);

	public List<ShopDom> getAllShops();
}
