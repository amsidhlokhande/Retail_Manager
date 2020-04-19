package com.amsidh.mvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.amsidh.mvc.dao.ShopDao;
import com.amsidh.mvc.dom.ShopDom;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * 
 * @author amsidhlokhande
 *
 */
@Repository
public class ShopDaoImpl implements ShopDao {

	private static final Logger logger = Logger.getLogger(ShopDaoImpl.class);

	private static final List<ShopDom> shops = new ArrayList();

	@Autowired
	private MongoTemplate mongoTemplate;

	public ShopDaoImpl() {
		logger.info("Loading ShopDaoImpl!!!!");
	}

	@Override
	public void createShop(ShopDom shopDom) {
		shops.add(shopDom);
		//mongoTemplate.save(shopDom);
	}

	@Override
	public void updateShop(ShopDom shopDom) {
		for (ShopDom shop : shops) {
			if (shop.getShopId() == shopDom.getShopId()) {
				shop.setShopName(shopDom.getShopName());
			}
		}
		/*Query query=new Query(Criteria.byExample(shopDom));
		DBObject dbDoc = new BasicDBObject();
		mongoTemplate.getConverter().write(shopDom, dbDoc); //it is the one spring use for convertions.
		dbDoc.removeField("_id");  // just to be sure to not create any duplicates
		Update update=Update.fromDBObject(dbDoc);
		mongoTemplate.upsert(query, update, ShopDom.class);
		*/
	}

	@Override
	public ShopDom getShopDomByShopId(Integer shopId) {
		ShopDom shopDom=null;
		
		for (ShopDom shop : shops) {
			if (shopId == shop.getShopId()) {
				shopDom=shop;
			}
		}
		//shopDom=mongoTemplate.findById(shopId, ShopDom.class);
		return shopDom;
		
	}

	@Override
	public void deleteShopByShopId(Integer shopId) {
		for (ShopDom shopDom : shops) {
			if (shopId == shopDom.getShopId()) {
				shops.remove(shopDom);
			}
		}
		//mongoTemplate.remove(getShopDomByShopId(shopId));

	}

	@Override
	public List<ShopDom> getAllShops() {
		return shops;
		//return mongoTemplate.findAll(ShopDom.class);
	}

}
