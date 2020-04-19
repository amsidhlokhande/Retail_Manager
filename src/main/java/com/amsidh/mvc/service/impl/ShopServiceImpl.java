/**
 * 
 */
package com.amsidh.mvc.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amsidh.mvc.dao.ShopDao;
import com.amsidh.mvc.dto.ShopDto;
import com.amsidh.mvc.service.ShopService;
import com.amsidh.mvc.util.ShopUtility;

/**
 * @author amsidhlokhande
 *
 */
@Service
@Transactional
public class ShopServiceImpl implements ShopService {

	private static final Logger logger = Logger.getLogger(ShopServiceImpl.class);

	@Autowired
	private ShopDao shopDao;

	public ShopServiceImpl() {
		logger.info("Loading ShopServiceImpl!!!!");
	}

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public void saveShopDetails(ShopDto shopDto) {
        shopDao.createShop(ShopUtility.getShopDom(shopDto));
	}

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public void updateShopDetails(ShopDto shopDto) {
		shopDao.updateShop(ShopUtility.getShopDom(shopDto));
	}

	@Override
	public ShopDto getShopDetails(Integer shopId) {
		return ShopUtility.getShopDto(shopDao.getShopDomByShopId(shopId));
	}

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public void deleteShopDetails(Integer shopId) {
		shopDao.deleteShopByShopId(shopId);
	}

	@Override
	public List<ShopDto> getAllShops() {
		return ShopUtility.getAllShopDto(shopDao.getAllShops());
	}
}
