package com.ilotte.reza.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.ilotte.reza.model.DeliveryAddress;
import com.ilotte.reza.model.OrderDetails;
import com.ilotte.reza.model.PaymentMethode;
import com.ilotte.reza.model.ShoppingCart;

@Service("orderDetailsService")
public class OrderDetailsServiceImpl implements OrderDetailsService {
	
private static final AtomicLong counter = new AtomicLong();
	
	private static List<OrderDetails> orderDetails;
	private static List<ShoppingCart> shoppingCarts;
	
	static{
		orderDetails = populateDummyOrderDetails();
	}

	@Override
	public List<OrderDetails> findAllpopulateDummyOrderDetails() {
		return orderDetails;
	}
	
	@Override
	public OrderDetails findById(long id) {
		for(OrderDetails details : orderDetails){
			if(details.getOrderId() == id){
				return details;
			}
		}
		return null;
	}
	
	
	@Override
	public void saveOrderDetails(OrderDetails details) {
		details.setOrderId(counter.incrementAndGet());
		orderDetails.add(details);
	}

	@Override
	public void updateOrderDetails(OrderDetails details) {
		int index = orderDetails.indexOf(details);
		orderDetails.set(index, details);
	}
	

//	@Override
//	public void deleteShoppingCarts(long id) {
//		
//		for (Iterator<ShoppingCart> iterator = shoppingCartsDetails.iterator(); iterator.hasNext(); ) {
//			ShoppingCart cart = iterator.next();
//		    if (cart.getCartId() == id) {
//		        iterator.remove();
//		    }
//		}
//	}

	@Override
	public boolean isOrderDetailsExist(OrderDetails details) {
		if(details.getAddresses() != null && details.getPaymentMethodes() != null) {
			for(ShoppingCart cart  : shoppingCarts) {
				if(cart.getQuantity() == 0) {
					return false;
				}else {
					return findById(details.getOrderId())!=null;
				}
			}
			return false;
		}
		return false;
	}
	
//	@Override
//	public void deleteShoppingCarts(){
//		shoppingCartsDetails.clear();
//	}
	
	
	private static List populateDummyOrderDetails(){
		
		List<OrderDetails> details = new ArrayList<OrderDetails>();
		List<ShoppingCart> shoppingCarts = new ArrayList<ShoppingCart>();
		List<DeliveryAddress> deliveryAddresses = new ArrayList<DeliveryAddress>();
		List<PaymentMethode> paymentMethodes = new ArrayList<PaymentMethode>();
		List<List<String>> strings = new ArrayList<List<String>>();
		
		List merged = new ArrayList<>(details);
		merged.addAll(shoppingCarts);
		merged.addAll(deliveryAddresses);
		merged.addAll(paymentMethodes);
		
		return merged ;
	}
	

}
