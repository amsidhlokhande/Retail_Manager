package com.amsidh.mvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.amsidh.mvc.dao.AddressDao;
import com.amsidh.mvc.dom.AddressDom;

@Repository
public class AddressDaoImpl implements AddressDao {
	private static final Logger logger = Logger.getLogger(AddressDaoImpl.class);

	private static final List<AddressDom> addresses = new ArrayList();
	

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void createAddress(AddressDom addressDom) {
		//mongoTemplate.save(addressDom);
		addresses.add(addressDom);
	}

	@Override
	public void updateAddress(AddressDom addressDom) {

		/*Query query = new Query(Criteria.byExample(addressDom));
		DBObject dbDoc = new BasicDBObject();
		mongoTemplate.getConverter().write(addressDom, dbDoc); // it is the one
																// spring use
																// for
																// convertions.
		dbDoc.removeField("_id"); // just to be sure to not create any
									// duplicates

		Update update = Update.fromDBObject(dbDoc);
		mongoTemplate.upsert(query, update, AddressDom.class);
       */
		
		for(AddressDom address:addresses){
			if(addressDom.getAddressId()==address.getAddressId()){
				address.setPostCode(addressDom.getPostCode());
				address.setLongitude(addressDom.getLongitude());
				address.setLatitude(addressDom.getLatitude());
				address.setShopId(addressDom.getShopId());
			}
		}
	}

	@Override
	public AddressDom getAddressDomByAddressId(Integer addressId) {
		AddressDom addressDom = null;
		//addressDom = mongoTemplate.findById(addressId, AddressDom.class);
		for(AddressDom address:addresses){
			if(addressId==address.getAddressId()){
				addressDom=address;
			}
		}
		return addressDom;
	}

	@Override
	public void deleteAddressByAddressId(Integer addressId) {
		//mongoTemplate.remove(getAddressDomByAddressId(addressId));
		for(AddressDom address:addresses){
			if(addressId==address.getAddressId()){
				addresses.remove(address);
			}
		}
	}

	@Override
	public List<AddressDom> getAllAddresss() {
		//return mongoTemplate.findAll(AddressDom.class);
		return addresses;
	}

}
