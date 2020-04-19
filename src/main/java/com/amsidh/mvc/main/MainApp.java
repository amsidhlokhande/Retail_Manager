/**
 * 
 */
package com.amsidh.mvc.main;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.amsidh.mvc.dto.AddressDto;
import com.amsidh.mvc.dto.ShopDto;
import com.amsidh.mvc.service.AddressService;
import com.amsidh.mvc.service.ShopService;
import com.amsidh.mvc.service.impl.AddressServiceImpl;
import com.amsidh.mvc.service.impl.ShopServiceImpl;

/**
 * @author amsidhlokhande
 *
 */
public class MainApp {
	private static final Logger logger = Logger.getLogger(MainApp.class);

	private MainApp() {

	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:/META-INF/spring-configuration/spring-beans.xml");
		context.registerShutdownHook();

		ShopService shopService = context.getBean(ShopServiceImpl.class);
		AddressService addressService = context.getBean(AddressServiceImpl.class);

		ShopDto shopDto = new ShopDto(1, "BigBazzar", 1);
		AddressDto addressDto = new AddressDto(1, 411047, 1);

		shopService.saveShopDetails(shopDto);
		addressService.saveAddress(addressDto);

		shopDto = new ShopDto(2, "D-Mart", 2);
		addressDto = new AddressDto(1, 411014, 1);
		shopService.saveShopDetails(shopDto);
		addressService.saveAddress(addressDto);

		for (ShopDto shop : shopService.getAllShops()) {
			logger.info(shop.toString());
		}

		for (AddressDto addresss : addressService.getAllAddresses()) {
			logger.info(addresss.toString());
		}
		logger.info("END OF Main");

	}

}
