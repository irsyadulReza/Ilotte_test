package com.ilotte.reza.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.ilotte.reza.model.DeliveryAddress;

@Service("deliveryAddressService")
public class DeliveryAddressServiceImpl implements DeliveryAddressService{
	
private static final AtomicLong counter = new AtomicLong();
	
	private static List<DeliveryAddress> deliveryAddresses;
	
	static{
		deliveryAddresses= populateDummyDeliveryAddress();
	}

	@Override
	public List<DeliveryAddress> findAllDeliveryAddress() {
		return deliveryAddresses;
	}
	
	@Override
	public DeliveryAddress findById(long id) {
		for(DeliveryAddress address : deliveryAddresses){
			if(address.getId() == id){
				return address;
			}
		}
		return null;
	}
	
	@Override
	public DeliveryAddress findByName(String name) {
		for(DeliveryAddress address : deliveryAddresses){
			if(address.getAddress().equalsIgnoreCase(name)){
				return address;
			}
		}
		return null;
	}
	
	@Override
	public void saveDeliveryAddress(DeliveryAddress address) {
		address.setId(counter.incrementAndGet());
		deliveryAddresses.add(address);
	}

	@Override
	public void updateDeliveryAddress(DeliveryAddress address) {
		int index = deliveryAddresses.indexOf(address);
		deliveryAddresses.set(index, address);
	}
	

//	public void deleteShoppingCarts(long id) {
//		
//		for (Iterator<ShoppingCart> iterator = shoppingCartsDetails.iterator(); iterator.hasNext(); ) {
//			ShoppingCart cart = iterator.next();
//		    if (cart.getCartId() == id) {
//		        iterator.remove();
//		    }
//		}
//	}
//
	@Override
	public boolean isUserExist(DeliveryAddress address) {
		return findByName(address.getAddress())!=null;
	}
	
//	public void deleteShoppingCarts(){
//		shoppingCartsDetails.clear();
//	}
	
	
	private static List<DeliveryAddress> populateDummyDeliveryAddress(){
		List<DeliveryAddress> addresses = new ArrayList<DeliveryAddress>();
		addresses.add(new DeliveryAddress(1, "reza irsyadul", "bogor", "16820"));

		return addresses;
	}
	

}
